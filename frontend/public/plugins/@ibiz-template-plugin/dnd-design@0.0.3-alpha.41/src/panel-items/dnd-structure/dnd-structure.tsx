import {
  PropType,
  defineComponent,
  nextTick,
  onMounted,
  onUnmounted,
  ref,
  watch,
} from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { IPanelRawItem } from '@ibiz/model-core';
import { ElTree } from 'element-plus';
import Node from 'element-plus/es/components/tree/src/model/node';
import { AllowDropType } from 'element-plus/es/components/tree/src/tree.type';
import { DndStructurePanelItemController } from './dnd-structure.controller';
import { IDndStructureNodeData } from '../../interface';
import { resource } from '../../global';
import './dnd-structure.scss';

export default defineComponent({
  name: 'IBizDndStructurePanelItem',
  props: {
    modelData: {
      type: Object as PropType<IPanelRawItem>,
      required: true,
    },
    controller: {
      type: DndStructurePanelItemController,
      required: true,
    },
  },
  setup(props) {
    const ns = useNamespace('dnd-structure');

    const tree = ref<InstanceType<typeof ElTree> | null>(null);
    const searchValue = ref('');

    watch(searchValue, () => {
      if (!tree.value) {
        return;
      }
      tree.value.filter(searchValue.value);
    });

    const filterNode = (value: string, data: IDndStructureNodeData) => {
      if (!value) return true;
      const filterValue = value.trim().toLowerCase();
      return data.text.includes(filterValue);
    };

    const onCurrentNodeChange = (data: IDndStructureNodeData | null) => {
      if (data) {
        props.controller.view.select.set(data.entity);
      }
    };

    const onSelectDataChange = (data?: IData | null) => {
      if (!tree.value) {
        return;
      }
      if (data) {
        const node = tree.value.getNode(data.srfkey);
        if (node) {
          tree.value.setCurrentKey(data.srfkey);
          return;
        }
      }
      tree.value.setCurrentKey();
    };

    props.controller.view.select.on(data => {
      onSelectDataChange(data);
    });

    onMounted(() => {
      onSelectDataChange(props.controller.view.select.data);
    });

    const updateSelect = () => {
      nextTick(() => {
        onSelectDataChange(props.controller.view.select.data);
      });
    };

    props.controller.evt.on('updateSelect', updateSelect);

    const allowDrag = (node: Node) => {
      const nodeData = node.data as IDndStructureNodeData;
      if (node.level === 0 || nodeData.type === 'FORMPAGE') {
        return false;
      }
      if (!searchValue.value) {
        return true;
      }
      const filterValue = searchValue.value.trim().toLowerCase();
      if (filterValue) {
        return false;
      }
      return true;
    };

    const allowDrop = (
      draggingNode: Node,
      dropNode: Node,
      type: AllowDropType,
    ) => {
      const draggingNodeData = draggingNode.data as IDndStructureNodeData;
      const dropNodeData = dropNode.data as IDndStructureNodeData;
      if (type === 'inner') {
        const containerType = ['GROUPPANEL', 'FORMPAGE'];
        if (containerType.includes(dropNodeData.type)) {
          return true;
        }
        return false;
      }
      if (dropNode.level === 0) {
        return false;
      }
      if (
        dropNodeData.type === 'FORMPAGE' &&
        draggingNodeData.type !== 'FORMPAGE'
      ) {
        return false;
      }
      return true;
    };

    const onNodeDrop = (
      draggingNode: Node,
      dropNode: Node,
      type: AllowDropType,
    ) => {
      const draggingNodeData = draggingNode.data as IDndStructureNodeData;
      const dropNodeData = dropNode.data as IDndStructureNodeData;
      if (type === 'inner') {
        props.controller.change(
          draggingNodeData,
          dropNodeData.children,
          dropNodeData,
        );
        return;
      }
      const parentNodeData = dropNodeData.parent;
      if (parentNodeData) {
        props.controller.change(
          draggingNodeData,
          parentNodeData.children,
          parentNodeData,
        );
      } else {
        props.controller.change(draggingNodeData, props.controller.state.items);
      }
    };

    onUnmounted(() => {
      props.controller.evt.off('updateSelect', updateSelect);
    });

    return {
      ns,
      tree,
      searchValue,
      filterNode,
      onCurrentNodeChange,
      allowDrag,
      allowDrop,
      onNodeDrop,
    };
  },
  render() {
    return (
      <div class={this.ns.b()}>
        <div class={this.ns.b('header')}>
          <el-input
            v-model={this.searchValue}
            prefix-icon={<ion-icon name='search-outline'></ion-icon>}
            clearable={true}
          ></el-input>
        </div>
        <div class={this.ns.b('content')}>
          <el-tree
            ref='tree'
            data={this.controller.state.items}
            node-key='id'
            props={{
              label: 'text',
              children: 'children',
            }}
            indent={8}
            draggable={true}
            default-expand-all={true}
            expand-on-click-node={false}
            highlight-current={true}
            filter-node-method={this.filterNode}
            onCurrentChange={this.onCurrentNodeChange}
            allow-drag={this.allowDrag}
            allow-drop={this.allowDrop}
            onNodeDrop={this.onNodeDrop}
          >
            {{
              default: ({ data }: { data: IDndStructureNodeData }) => {
                const iconPath = this.controller.getNodeIcon(data);
                return (
                  <div class={this.ns.b('node')}>
                    <div class={this.ns.be('node', 'icon')}>
                      {iconPath ? (
                        <ion-icon src={resource.dir(iconPath)}></ion-icon>
                      ) : null}
                    </div>
                    <div class={this.ns.be('node', 'text')} title={data.text}>
                      {data.text}
                    </div>
                  </div>
                );
              },
            }}
          </el-tree>
        </div>
      </div>
    );
  },
});
