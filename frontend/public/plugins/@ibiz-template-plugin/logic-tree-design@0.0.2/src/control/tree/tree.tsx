import { useControlController, useNamespace } from '@ibiz-template/vue3-util';
import {
  computed,
  defineComponent,
  nextTick,
  onMounted,
  onUnmounted,
  PropType,
  ref,
  resolveComponent,
  VNode,
  watch,
} from 'vue';
import { createUUID } from 'qx-util';
import { debounce } from 'lodash-es';
import { IDETBUIActionItem, IDETree, IDETreeNode } from '@ibiz/model-core';
import {
  IControlProvider,
  ITreeNodeData,
  getControlPanel,
} from '@ibiz-template/runtime';
import './tree.scss';
import { RuntimeError } from '@ibiz-template/core';
import { ElTree } from 'element-plus';
import {
  AllowDropType,
  NodeDropType,
} from 'element-plus/es/components/tree/src/tree.type';
import {
  findNodeData,
  formatNodeDropType,
  useElTreeUtil,
} from './el-tree-util';
import { LogicTreeDesignTreeController } from './tree.controller';

export const LogicTreeDesignTree = defineComponent({
  name: 'IBizLogicTreeDesignTree',
  props: {
    modelData: { type: Object as PropType<IDETree>, required: true },
    context: { type: Object as PropType<IContext>, required: true },
    params: { type: Object as PropType<IParams>, default: () => ({}) },
    provider: { type: Object as PropType<IControlProvider> },
    /**
     * 部件行数据默认激活模式
     * - 0 不激活
     * - 1 单击激活
     * - 2 双击激活(默认值)
     *
     * @type {(number | 0 | 1 | 2)}
     */
    mdctrlActiveMode: { type: Number, default: undefined },

    /**
     * 是否为单选
     * - true 单选
     * - false 多选
     *
     * @type {(Boolean)}
     */
    singleSelect: { type: Boolean, default: undefined },
    navigational: { type: Boolean, default: undefined },
    defaultExpandedKeys: { type: Array as PropType<string[]> },
    loadDefault: { type: Boolean, default: true },
  },
  setup() {
    const c = useControlController<LogicTreeDesignTreeController>(
      (...args) => new LogicTreeDesignTreeController(...args),
    );
    const ns = useNamespace('logic-tree-design-tree');
    const treeRef = ref<InstanceType<typeof ElTree> | null>(null);
    const treeviewRef = ref<IData | null>(null);

    const treeRefreshKey = ref('');

    // 节点名称编辑相关
    const treeNodeTextInputRef = ref<IData | null>(null);
    const editingNodeKey = ref<string | null>(null);
    const editingNodeText = ref<string | null>(null);

    watch(
      () => treeNodeTextInputRef.value,
      newVal => {
        if (newVal) {
          newVal.$el.getElementsByTagName('input')[0].focus();
        }
      },
    );

    /**
     * 编辑当前节点的文本
     * @author lxm
     * @date 2023-12-15 05:46:02
     * @return {*}  {void}
     */
    const editCurrentNodeText = (): void => {
      const currentkey = treeRef.value?.getCurrentKey();
      if (!currentkey || currentkey === editingNodeKey.value) {
        return;
      }
      const nodeData = findNodeData(currentkey, c)!;
      const model = c.getNodeModel(nodeData._nodeId);
      if (model?.allowEditText) {
        editingNodeKey.value = currentkey;
      }
    };

    /**
     * 处理节点文本编辑失效事件
     * @author lxm
     * @date 2023-12-15 05:37:03
     */
    const onNodeTextEditBlur = async () => {
      if (editingNodeKey.value) {
        if (editingNodeText.value) {
          const nodeData = findNodeData(editingNodeKey.value, c)!;
          await c.modifyNodeText(nodeData, editingNodeText.value);
          editingNodeKey.value = null;
          editingNodeText.value = null;
        } else {
          // 取消编辑
          editingNodeKey.value = null;
        }
      }
    };

    const { updateUI } = useElTreeUtil(treeRef, c);

    /**
     * 创建新的节点对象，隔离组件数据和controller数据
     * @author lxm
     * @date 2023-08-30 09:35:25
     * @param {ITreeNodeData[]} nodes
     * @return {*}  {IData[]}
     */
    const toElNodes = (nodes: ITreeNodeData[]): IData[] => {
      return nodes.map(node => ({
        _id: node._id,
        _uuid: node._uuid,
        // 子节点或者，非子节点但是已经加载过子且子是空的
        _leaf: node._leaf || (node._children && node._children.length === 0),
        _text: node._text,
      }));
    };

    // el-treeUI更新子节点
    c.evt.on('onAfterRefreshParent', event => {
      if (treeRef.value) {
        const { parentNode, children } = event;
        const elNodes = toElNodes(children);
        treeRef.value!.updateKeyChildren(parentNode._id, elNodes);
        updateUI();
      }
    });

    c.evt.on('onAfterNodeDrop', event => {
      if (event.isChangedParent) {
        // 变更父节点的时候强刷
        treeRefreshKey.value = createUUID();
      }
    });

    /** 树展示数据 */
    const treeData = computed(() => {
      if (!c.state.isLoaded) {
        return [];
      }
      return c.model.rootVisible
        ? c.state.rootNodes
        : c.state.rootNodes.reduce<ITreeNodeData[]>((result, nodeData) => {
            if (nodeData._children) {
              return result.concat(nodeData._children);
            }
            return result;
          }, []);
    });

    // 根节点数据变更时重绘tree
    watch(treeData, (newVal, oldVal) => {
      if (newVal !== oldVal) {
        treeRefreshKey.value = createUUID();
      }
    });

    /**
     * 触发节点加载数据
     * @author lxm
     * @date 2023-05-29 09:16:07
     * @param {IData} item
     * @param {(nodes: IData[]) => void} callback
     */
    const loadData = async (
      item: IData,
      callback: (nodes: IData[]) => void,
    ) => {
      let nodes: ITreeNodeData[];
      if (item.level === 0) {
        nodes = treeData.value;
        ibiz.log.debug('初始加载');
      } else {
        const nodeData = findNodeData(item.data._uuid, c)!;
        if (!nodeData) {
          // todo临时修复报错，可能会有别的影响
          return;
        }

        if (nodeData._children) {
          ibiz.log.debug('节点展开加载-本地', nodeData);
          nodes = nodeData._children;
        } else {
          ibiz.log.debug('节点展开加载-远程', nodeData);
          nodes = await c.loadNodes(nodeData);
        }
      }
      ibiz.log.debug('给树返回值', nodes);

      callback(toElNodes(nodes));
      updateUI();
    };

    // 值变更优化，加载成功后的值变更需要等渲染完成之后执行，其他情况不用
    let selectionWait = false;
    c.evt.on('onLoadSuccess', () => {
      selectionWait = true;
      setTimeout(() => {
        selectionWait = false;
      }, 200);
    });

    // 选中数据回显
    c.evt.on('onSelectionChange', async () => {
      if (selectionWait) {
        await nextTick();
      }
      if (c.state.singleSelect) {
        treeRef.value!.setCurrentKey(c.state.selectedData[0]?._id || undefined);
      } else {
        // el-tree，会把没选中的反选，且不触发check事件
        treeRef.value!.setCheckedKeys(
          c.state.selectedData.map(item => item._id),
        );
      }
    });

    /**
     * 多选时选中节点变更
     */
    const onCheck = (
      nodeData: ITreeNodeData,
      opts: { checkedNodes: ITreeNodeData[] },
    ) => {
      const { checkedNodes } = opts;
      c.setSelection(checkedNodes);
    };

    let forbidClick: boolean = false;
    /**
     * 节点单击事件
     */
    const onNodeClick = (nodeData: ITreeNodeData, evt: MouseEvent) => {
      evt.stopPropagation();
      if (forbidClick) {
        return;
      }

      // 已经是当前节点，则进入编辑模式
      if (treeRef.value?.getCurrentKey() === nodeData._id) {
        editCurrentNodeText();
      }

      // 多选的时候设置节点的当前节点
      if (!c.state.singleSelect) {
        treeRef.value?.setCurrentKey(nodeData._id);
      }

      c.onTreeNodeClick(nodeData, evt);
      forbidClick = true;
      setTimeout(() => {
        forbidClick = false;
      }, 200);
    };

    /**
     * 节点双击事件
     */
    const onNodeDbClick = (nodeData: ITreeNodeData, evt: MouseEvent) => {
      evt.stopPropagation();
      c.onDbTreeNodeClick(nodeData);
    };

    const iBizIcon = resolveComponent('IBizIcon');

    /**
     * 绘制上下文菜单触发图标
     * @param nodeModel
     * @param nodeData
     * @returns
     */
    const renderContextMenu = (
      nodeModel: IDETreeNode,
      nodeData: ITreeNodeData,
    ) => {
      if (!nodeModel?.decontextMenu?.detoolbarItems?.length) {
        return;
      }

      const logicType = nodeData._deData?.srftype;

      return (
        <div class={ns.b('context-menu')}>
          {nodeModel.decontextMenu.detoolbarItems.map(
            (item: IDETBUIActionItem) => {
              // 配置了userTag的只有相同logictype的数据才显示该菜单项
              if (item.userTag && logicType && logicType !== item.userTag) {
                return null;
              }

              if (
                c.context.srfreadonly === true ||
                c.context.srfreadonly === 'true'
              ) {
                return null;
              }

              return (
                <el-button
                  text
                  size='small'
                  onClick={(e: MouseEvent): void => {
                    e.stopPropagation();
                    c.doUIAction(item.uiactionId!, nodeData, e, item.appId);
                  }}
                  title={item.tooltip}
                >
                  <iBizIcon icon={item.sysImage}></iBizIcon>
                </el-button>
              );
            },
          )}
        </div>
      );
    };

    const updateNodeExpand = (data: IData, expanded: boolean) => {
      const nodeData = findNodeData(data._uuid, c);
      if (!nodeData) {
        throw new RuntimeError(`没有找到_uuid为${data._uuid}的节点`);
      }
      c.onExpandChange(nodeData, expanded);
    };

    const debounceSearch = debounce(() => {
      c.load();
    }, 500);

    const onInput = (value: string): void => {
      c.state.query = value;
      debounceSearch();
    };

    // 拖拽相关
    const allowDrop = (
      draggingNode: IData,
      dropNode: IData,
      type: AllowDropType,
    ) => {
      const draggingNodeData = findNodeData(draggingNode.data._uuid, c)!;
      const dropNodeData = findNodeData(dropNode.data._uuid, c)!;
      const result = c.calcAllowDrop(draggingNodeData, dropNodeData, type);
      return result;
    };

    const allowDrag = (draggingNode: IData) => {
      const nodeData = findNodeData(draggingNode.data._uuid, c)!;
      return c.calcAllowDrag(nodeData);
    };

    /**
     * 处理拖入完成事件
     * @author lxm
     * @date 2023-12-15 05:37:10
     * @param {IData} draggingNode
     * @param {IData} dropNode
     * @param {NodeDropType} dropType
     */
    const handleDrop = (
      draggingNode: IData,
      dropNode: IData,
      dropType: NodeDropType,
    ) => {
      const type = formatNodeDropType(dropType);
      const draggingNodeData = findNodeData(draggingNode.data._uuid, c)!;
      const dropNodeData = findNodeData(dropNode.data._uuid, c)!;
      c.onNodeDrop(draggingNodeData, dropNodeData, type);
    };

    /**
     * 处理按键事件
     * @author lxm
     * @date 2023-12-15 05:39:00
     * @param {KeyboardEvent} e
     */
    const keydownHandle = (e: KeyboardEvent) => {
      if (e.code === 'F2' || e.code === 'Enter') {
        editCurrentNodeText();
      }
    };

    onMounted(() => {
      treeviewRef.value?.$el.addEventListener('keydown', keydownHandle);
    });

    onUnmounted(() => {
      treeviewRef.value?.$el.removeEventListener('keydown', keydownHandle);
    });

    /** 绘制实体节点 */
    const renderDeNode = (nodeData: ITreeNodeData) => {
      const deData = nodeData._deData!;

      return [
        deData.srficon && (
          <iBizIcon
            class={ns.be('node', 'icon')}
            icon={deData.srficon}
          ></iBizIcon>
        ),
        <span title={deData.srfmajortext} class={ns.be('node', 'label')}>
          {deData.srfmajortext}
        </span>,
      ];
    };

    return {
      c,
      ns,
      treeRef,
      treeviewRef,
      treeNodeTextInputRef,
      treeData,
      treeRefreshKey,
      editingNodeKey,
      editingNodeText,
      findNodeData,
      onCheck,
      onNodeClick,
      onNodeDbClick,
      loadData,
      renderContextMenu,
      updateNodeExpand,
      onInput,
      allowDrop,
      allowDrag,
      handleDrop,
      onNodeTextEditBlur,
      renderDeNode,
    };
  },
  render() {
    const slots: IData = {
      searchbar: () => {
        if (!this.c.enableQuickSearch) {
          return null;
        }
        return (
          <el-input
            model-value={this.c.state.query}
            class={[this.ns.b('quick-search'), this.ns.b('quick-search')]}
            placeholder={this.c.state.placeHolder}
            onInput={this.onInput}
          >
            {{
              prefix: (): VNode => {
                return (
                  <ion-icon class={this.ns.e('search-icon')} name='search' />
                );
              },
            }}
          </el-input>
        );
      },
    };
    const key = this.c.controlPanel ? 'tree' : 'default';
    const readonly =
      this.c.context.srfreadonly === true ||
      this.c.context.srfreadonly === 'true';
    slots[key] = () => {
      if (this.c.state.isLoaded && this.treeRefreshKey) {
        return (
          <el-tree
            ref={'treeRef'}
            key={this.treeRefreshKey}
            node-key='_id'
            highlight-current
            // 点击节点的时候不展开
            expand-on-click-node={false}
            auto-expand-parent={false}
            show-checkbox={!this.c.state.singleSelect}
            check-strictly
            default-expanded-keys={this.c.state.expandedKeys}
            props={{
              label: '_text',
              children: '_children',
              isLeaf: '_leaf',
            }}
            lazy
            load={this.loadData}
            onCheck={this.onCheck}
            onNodeExpand={(data: IData) => {
              this.updateNodeExpand(data, true);
            }}
            onNodeCollapse={(data: IData) => {
              this.updateNodeExpand(data, false);
            }}
            draggable={!readonly}
            allow-drop={this.allowDrop}
            allow-drag={this.allowDrag}
            onNodeDrop={this.handleDrop}
          >
            {{
              default: ({ data }: { node: IData; data: IData }) => {
                const nodeData = this.findNodeData(data._uuid, this.c)!;
                if (!nodeData) {
                  return null;
                }
                const nodeModel = this.c.getNodeModel(nodeData._nodeId)!;

                // 绘制编辑项
                if (this.editingNodeKey === nodeData._id) {
                  return (
                    <div class={[this.ns.b('node'), nodeModel.sysCss?.cssName]}>
                      <el-input
                        v-model={this.editingNodeText}
                        ref='treeNodeTextInputRef'
                        class={this.ns.b('editing-node')}
                        onBlur={() => {
                          this.onNodeTextEditBlur();
                        }}
                        onKeydown={(e: KeyboardEvent) => {
                          e.stopPropagation();
                          if (e.code === 'Enter') {
                            this.onNodeTextEditBlur();
                          }
                        }}
                      ></el-input>
                    </div>
                  );
                }

                const layoutPanel = getControlPanel(nodeModel);

                let content;
                if (layoutPanel) {
                  content = (
                    <iBizControlShell
                      data={nodeData}
                      modelData={layoutPanel}
                      context={this.c.context}
                      params={this.c.params}
                    ></iBizControlShell>
                  );
                } else if (nodeModel.treeNodeType === 'DE') {
                  content = this.renderDeNode(nodeData);
                } else {
                  content = [
                    nodeData._icon ? (
                      <iBizIcon
                        class={this.ns.be('node', 'icon')}
                        icon={nodeData._icon}
                      ></iBizIcon>
                    ) : null,
                    nodeData._textHtml ? (
                      <span
                        class={this.ns.be('node', 'label')}
                        v-html={nodeData._textHtml}
                      ></span>
                    ) : (
                      <span class={this.ns.be('node', 'label')}>
                        {nodeData._text}
                      </span>
                    ),
                  ];
                }

                return (
                  <div
                    onDblclick={evt => this.onNodeDbClick(nodeData, evt)}
                    onClick={evt => this.onNodeClick(nodeData, evt)}
                    class={[
                      this.ns.b('node'),
                      nodeModel.sysCss?.cssName,
                      nodeModel.rootNode ? this.ns.bm('node', 'root') : '',
                    ]}
                  >
                    {content}
                    {this.renderContextMenu(nodeModel, nodeData)}
                  </div>
                );
              },
            }}
          </el-tree>
        );
      }
    };

    return (
      <iBizControlBase
        ref={'treeviewRef'}
        controller={this.c}
        v-loading={this.c.state.isLoading}
      >
        {slots}
      </iBizControlBase>
    );
  },
});
