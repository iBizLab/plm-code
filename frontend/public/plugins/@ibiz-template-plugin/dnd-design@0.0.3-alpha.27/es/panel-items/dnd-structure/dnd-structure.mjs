import { ref, watch, onMounted, nextTick, onUnmounted, resolveComponent, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { DndStructurePanelItemController } from './dnd-structure.controller.mjs';
import { resource } from '../../global.mjs';
import './dnd-structure.css';

"use strict";
var DndStructure = /* @__PURE__ */ defineComponent({
  name: "IBizDndStructurePanelItem",
  props: {
    modelData: {
      type: Object,
      required: true
    },
    controller: {
      type: DndStructurePanelItemController,
      required: true
    }
  },
  setup(props) {
    const ns = useNamespace("dnd-structure");
    const tree = ref(null);
    const searchValue = ref("");
    watch(searchValue, () => {
      if (!tree.value) {
        return;
      }
      tree.value.filter(searchValue.value);
    });
    const filterNode = (value, data) => {
      if (!value)
        return true;
      const filterValue = value.trim().toLowerCase();
      return data.text.includes(filterValue);
    };
    const onCurrentNodeChange = (data) => {
      if (data) {
        props.controller.view.select.set(data.entity);
      }
    };
    const onSelectDataChange = (data) => {
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
    props.controller.view.select.on((data) => {
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
    props.controller.evt.on("updateSelect", updateSelect);
    const allowDrag = (node) => {
      const nodeData = node.data;
      if (node.level === 0 || nodeData.type === "FORMPAGE") {
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
    const allowDrop = (draggingNode, dropNode, type) => {
      const draggingNodeData = draggingNode.data;
      const dropNodeData = dropNode.data;
      if (type === "inner") {
        const containerType = ["GROUPPANEL", "FORMPAGE"];
        if (containerType.includes(dropNodeData.type)) {
          return true;
        }
        return false;
      }
      if (dropNode.level === 0) {
        return false;
      }
      if (dropNodeData.type === "FORMPAGE" && draggingNodeData.type !== "FORMPAGE") {
        return false;
      }
      return true;
    };
    const onNodeDrop = (draggingNode, dropNode, type) => {
      const draggingNodeData = draggingNode.data;
      const dropNodeData = dropNode.data;
      if (type === "inner") {
        props.controller.change(draggingNodeData, dropNodeData.children, dropNodeData);
        return;
      }
      const parentNodeData = dropNodeData.parent;
      if (parentNodeData) {
        props.controller.change(draggingNodeData, parentNodeData.children, parentNodeData);
      } else {
        props.controller.change(draggingNodeData, props.controller.state.items);
      }
    };
    onUnmounted(() => {
      props.controller.evt.off("updateSelect", updateSelect);
    });
    return {
      ns,
      tree,
      searchValue,
      filterNode,
      onCurrentNodeChange,
      allowDrag,
      allowDrop,
      onNodeDrop
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b()
    }, [createVNode("div", {
      "class": this.ns.b("header")
    }, [createVNode(resolveComponent("el-input"), {
      "modelValue": this.searchValue,
      "onUpdate:modelValue": ($event) => this.searchValue = $event,
      "prefix-icon": createVNode("ion-icon", {
        "name": "search-outline"
      }, null),
      "clearable": true
    }, null)]), createVNode("div", {
      "class": this.ns.b("content")
    }, [createVNode(resolveComponent("el-tree"), {
      "ref": "tree",
      "data": this.controller.state.items,
      "node-key": "id",
      "props": {
        label: "text",
        children: "children"
      },
      "indent": 8,
      "draggable": true,
      "default-expand-all": true,
      "expand-on-click-node": false,
      "highlight-current": true,
      "filter-node-method": this.filterNode,
      "onCurrentChange": this.onCurrentNodeChange,
      "allow-drag": this.allowDrag,
      "allow-drop": this.allowDrop,
      "onNodeDrop": this.onNodeDrop
    }, {
      default: ({
        data
      }) => {
        const iconPath = this.controller.getNodeIcon(data);
        return createVNode("div", {
          "class": this.ns.b("node")
        }, [createVNode("div", {
          "class": this.ns.be("node", "icon")
        }, [iconPath ? createVNode("ion-icon", {
          "src": resource.dir(iconPath)
        }, null) : null]), createVNode("div", {
          "class": this.ns.be("node", "text"),
          "title": data.text
        }, [data.text])]);
      }
    })])]);
  }
});

export { DndStructure as default };
