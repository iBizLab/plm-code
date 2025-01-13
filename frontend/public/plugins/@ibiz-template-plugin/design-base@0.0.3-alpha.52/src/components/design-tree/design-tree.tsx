/* eslint-disable @typescript-eslint/no-explicit-any */
import { PropType, Ref, defineComponent, nextTick, ref, watch } from 'vue';
import { uniq } from 'ramda';
import { useNamespace } from '@ibiz-template/vue3-util';
import { IActionItem, ITreeNode } from '../../interface';
import './design-tree.scss';

export default defineComponent({
  name: 'IBizDesignTree',
  props: {
    // 是否只读
    readOnly: {
      type: Boolean,
      default: false,
    },
    // 是否可拖拽
    draggable: {
      type: Boolean,
      default: true,
    },
    // 拖拽规则
    dropRules: {
      type: Object as PropType<Map<string, RegExp>>,
      default: () => {
        return new Map();
      },
    },
    // 行为组
    actions: {
      type: Array as PropType<IActionItem[]>,
      default: () => {
        return [];
      },
    },
    // 绘制节点内容
    renderItem: {
      type: Object as PropType<(h: any, context: any) => any>,
      required: false,
    },
    // 树节点数据
    nodes: {
      type: Object as PropType<ITreeNode[]>,
      required: true,
    },
    // 激活节点
    activeNode: {
      type: String,
    },
  },
  emits: ['nodeSelect', 'actionClick', 'nodeDrop'],
  setup(props, { emit }) {
    const ns = useNamespace('design_tree');
    // 默认展开节点
    const expendNodeKeys: Ref<string[]> = ref([]);

    // 当前使用行为计算展示逻辑
    const useCalcActions = (context: IData, item: IActionItem): boolean => {
      const { data, node } = context;
      const reg = props.dropRules.get(data.type);
      if (node.level === 1 && item.type !== 'add') {
        return false;
      }
      if (reg == null && item.type === 'add') {
        return false;
      }
      return true;
    };

    // 行为项点击
    const actionClick = (
      e: MouseEvent,
      action: IActionItem,
      data?: IData,
    ): void => {
      e.stopPropagation();
      emit('actionClick', e, action, data);
    };

    /**
     * 计算展开节点
     *
     * @param {ITreeNode[]} nodes 所有节点
     * @param {string[]} items 已展开节点标识
     */
    const calcExpandAll = (nodes: ITreeNode[], items: string[]): void => {
      nodes.forEach(item => {
        if (item?.children != null) {
          const i = items.findIndex(str => item.id === str);
          if (i === -1) {
            expendNodeKeys.value.push(item.id);
          }
          calcExpandAll(item.children, items);
        }
      });
    };

    // 展开所有节点
    const expandAll = (): void => {
      if (props.nodes) {
        const items = uniq(expendNodeKeys.value);
        calcExpandAll(props.nodes, items);
      }
    };

    // 绘制当前节点
    const renderTreeItem = (h: any, context: IData): any => {
      if (props.renderItem) {
        return props.renderItem(h, context);
      }
      const { data } = context;
      return (
        <div class={ns.e('component')}>
          <div class={ns.e('item')}>
            <div class={ns.e('item-label')} title={data.label}>
              {data.icon ? (
                <ion-icon
                  class={`${ns.e('item-icon')}`}
                  name={data.icon}
                ></ion-icon>
              ) : null}
              <span class={ns.e('item-caption')}>{data.label}</span>
            </div>
            {!props.readOnly && props.actions.length > 0 ? (
              <div
                class={{
                  [ns.e('actions')]: true,
                  first: context.node.level === 1,
                }}
              >
                <div class={ns.e('item-actions')}>
                  {props.actions.map(item => {
                    return useCalcActions(context, item) && !item.visible ? (
                      <div
                        class={ns.e('item-action-item')}
                        title={item.tooltip}
                        onClick={(e: any) => actionClick(e, item, data.data)}
                      >
                        <ion-icon name={item.icon}></ion-icon>
                      </div>
                    ) : null;
                  })}
                </div>
                <div class={ns.e('default-actions')}>
                  {props.actions.map(item => {
                    return useCalcActions(context, item) && item.visible ? (
                      <div
                        class={ns.e('item-action-item')}
                        title={item.tooltip}
                        onClick={(e: any) => actionClick(e, item, data.data)}
                      >
                        <ion-icon name={item.icon}></ion-icon>
                      </div>
                    ) : null;
                  })}
                </div>
              </div>
            ) : null}
          </div>
        </div>
      );
    };

    // 判断节点是否可拖拽
    const allowDrag = (node: IData): boolean => {
      if (node.level === 0) {
        return false;
      }
      return true;
    };

    // 是否可放置
    const allowDrop = (
      draggingNode: IData,
      dropNode: IData,
      type: string,
    ): boolean => {
      if (Object.is(type, 'inner')) {
        // 插入子
        if (dropNode?.data && draggingNode?.data) {
          const reg = props.dropRules.get(dropNode.data.type);
          return !!reg?.test(draggingNode.data.type);
        }
      } else {
        if (dropNode?.level === 0) {
          return false;
        }
        // 插入前或后
        if (dropNode?.data && draggingNode?.data && dropNode.parent) {
          const reg = props.dropRules.get(dropNode.parent.data.type);
          return !!reg?.test(draggingNode.data.type);
        }
      }
      return false;
    };

    // 节点拖拽完毕
    const handleDrop = (
      draggingNode: IData,
      dropNode: IData,
      dropType: string,
    ): void => {
      emit('nodeDrop', draggingNode, dropNode, dropType);
    };

    // 节点选中
    const handNodeSelect = (data: ITreeNode, node: IData): void => {
      emit('nodeSelect', data, node);
    };

    // 节点展开
    const handleNodeExpand = (data: ITreeNode): void => {
      const i = expendNodeKeys.value.findIndex(str => data.id === str);
      if (i === -1) {
        expendNodeKeys.value.push(data.id);
      }
    };

    // 节点收缩
    const handleNodeCollapse = (data: ITreeNode): void => {
      const i = expendNodeKeys.value.findIndex(str => data.id === str);
      if (i !== -1) {
        expendNodeKeys.value.splice(i, 1);
      }
    };

    expandAll();

    // el-tree实例
    const tree = ref();

    watch(props.nodes, () => {
      nextTick(() => {
        if (tree.value) {
          tree.value.setCurrentKey?.(props.activeNode);
        }
      });
    });

    return {
      ns,
      expendNodeKeys,
      tree,
      renderTreeItem,
      allowDrag,
      allowDrop,
      handleDrop,
      handNodeSelect,
      handleNodeExpand,
      handleNodeCollapse,
      expandAll,
    };
  },
  render() {
    const designTreeCss = {
      [this.ns.b()]: true,
      [this.ns.is('readonly')]: this.readOnly,
    };
    return (
      <div class={designTreeCss}>
        <el-tree
          ref='tree'
          current-node-key={this.activeNode}
          class={this.ns.b('tree')}
          data={this.nodes}
          draggable={this.draggable && !this.readOnly}
          allow-drop={this.allowDrop}
          allow-drag={this.allowDrag}
          default-expanded-keys={this.expendNodeKeys}
          node-key='id'
          highlight-current={!this.readOnly}
          expand-on-click-node={false}
          auto-expand-parent={false}
          indent={8}
          render-content={this.renderTreeItem}
          onNodeExpand={(data: ITreeNode) => {
            this.handleNodeExpand(data);
          }}
          onNodeCollapse={(data: ITreeNode) => {
            this.handleNodeCollapse(data);
          }}
          onNodeDrop={this.handleDrop}
          onCurrentChange={this.handNodeSelect}
        ></el-tree>
      </div>
    );
  },
});
