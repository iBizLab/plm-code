import { ref, createVNode, nextTick, watch, resolveComponent, defineComponent } from 'vue';
import { uniq } from 'ramda';
import { useNamespace } from '@ibiz-template/vue3-util';
import './design-tree.css';

"use strict";
var IBizDesignTree = /* @__PURE__ */ defineComponent({
  name: "IBizDesignTree",
  props: {
    // 是否只读
    readOnly: {
      type: Boolean,
      default: false
    },
    // 是否可拖拽
    draggable: {
      type: Boolean,
      default: true
    },
    // 拖拽规则
    dropRules: {
      type: Object,
      default: () => {
        return /* @__PURE__ */ new Map();
      }
    },
    // 行为组
    actions: {
      type: Array,
      default: () => {
        return [];
      }
    },
    // 绘制节点内容
    renderItem: {
      type: Object,
      required: false
    },
    // 树节点数据
    nodes: {
      type: Object,
      required: true
    },
    // 激活节点
    activeNode: {
      type: String
    }
  },
  emits: ["nodeSelect", "actionClick", "nodeDrop"],
  setup(props, {
    emit
  }) {
    const ns = useNamespace("design_tree");
    const expendNodeKeys = ref([]);
    const useCalcActions = (context, item) => {
      const {
        data,
        node
      } = context;
      const reg = props.dropRules.get(data.type);
      if (node.level === 1 && item.type !== "add") {
        return false;
      }
      if (reg == null && item.type === "add") {
        return false;
      }
      return true;
    };
    const actionClick = (e, action, data) => {
      e.stopPropagation();
      emit("actionClick", e, action, data);
    };
    const calcExpandAll = (nodes, items) => {
      nodes.forEach((item) => {
        if ((item == null ? void 0 : item.children) != null) {
          const i = items.findIndex((str) => item.id === str);
          if (i === -1) {
            expendNodeKeys.value.push(item.id);
          }
          calcExpandAll(item.children, items);
        }
      });
    };
    const expandAll = () => {
      if (props.nodes) {
        const items = uniq(expendNodeKeys.value);
        calcExpandAll(props.nodes, items);
      }
    };
    const renderTreeItem = (h, context) => {
      if (props.renderItem) {
        return props.renderItem(h, context);
      }
      const {
        data
      } = context;
      return createVNode("div", {
        "class": ns.e("component")
      }, [createVNode("div", {
        "class": ns.e("item")
      }, [createVNode("div", {
        "class": ns.e("item-label"),
        "title": data.label
      }, [data.icon ? createVNode("ion-icon", {
        "class": "".concat(ns.e("item-icon")),
        "name": data.icon
      }, null) : null, createVNode("span", {
        "class": ns.e("item-caption")
      }, [data.label])]), !props.readOnly && props.actions.length > 0 ? createVNode("div", {
        "class": {
          [ns.e("actions")]: true,
          first: context.node.level === 1
        }
      }, [createVNode("div", {
        "class": ns.e("item-actions")
      }, [props.actions.map((item) => {
        return useCalcActions(context, item) && !item.visible ? createVNode("div", {
          "class": ns.e("item-action-item"),
          "title": item.tooltip,
          "onClick": (e) => actionClick(e, item, data.data)
        }, [createVNode("ion-icon", {
          "name": item.icon
        }, null)]) : null;
      })]), createVNode("div", {
        "class": ns.e("default-actions")
      }, [props.actions.map((item) => {
        return useCalcActions(context, item) && item.visible ? createVNode("div", {
          "class": ns.e("item-action-item"),
          "title": item.tooltip,
          "onClick": (e) => actionClick(e, item, data.data)
        }, [createVNode("ion-icon", {
          "name": item.icon
        }, null)]) : null;
      })])]) : null])]);
    };
    const allowDrag = (node) => {
      if (node.level === 0) {
        return false;
      }
      return true;
    };
    const allowDrop = (draggingNode, dropNode, type) => {
      if (Object.is(type, "inner")) {
        if ((dropNode == null ? void 0 : dropNode.data) && (draggingNode == null ? void 0 : draggingNode.data)) {
          const reg = props.dropRules.get(dropNode.data.type);
          return !!(reg == null ? void 0 : reg.test(draggingNode.data.type));
        }
      } else {
        if ((dropNode == null ? void 0 : dropNode.level) === 0) {
          return false;
        }
        if ((dropNode == null ? void 0 : dropNode.data) && (draggingNode == null ? void 0 : draggingNode.data) && dropNode.parent) {
          const reg = props.dropRules.get(dropNode.parent.data.type);
          return !!(reg == null ? void 0 : reg.test(draggingNode.data.type));
        }
      }
      return false;
    };
    const handleDrop = (draggingNode, dropNode, dropType) => {
      emit("nodeDrop", draggingNode, dropNode, dropType);
    };
    const handNodeSelect = (data, node) => {
      emit("nodeSelect", data, node);
    };
    const handleNodeExpand = (data) => {
      const i = expendNodeKeys.value.findIndex((str) => data.id === str);
      if (i === -1) {
        expendNodeKeys.value.push(data.id);
      }
    };
    const handleNodeCollapse = (data) => {
      const i = expendNodeKeys.value.findIndex((str) => data.id === str);
      if (i !== -1) {
        expendNodeKeys.value.splice(i, 1);
      }
    };
    expandAll();
    const tree = ref();
    watch(props.nodes, () => {
      nextTick(() => {
        var _a, _b;
        if (tree.value) {
          (_b = (_a = tree.value).setCurrentKey) == null ? void 0 : _b.call(_a, props.activeNode);
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
      expandAll
    };
  },
  render() {
    const designTreeCss = {
      [this.ns.b()]: true,
      [this.ns.is("readonly")]: this.readOnly
    };
    return createVNode("div", {
      "class": designTreeCss
    }, [createVNode(resolveComponent("el-tree"), {
      "ref": "tree",
      "current-node-key": this.activeNode,
      "class": this.ns.b("tree"),
      "data": this.nodes,
      "draggable": this.draggable && !this.readOnly,
      "allow-drop": this.allowDrop,
      "allow-drag": this.allowDrag,
      "default-expanded-keys": this.expendNodeKeys,
      "node-key": "id",
      "highlight-current": !this.readOnly,
      "expand-on-click-node": false,
      "auto-expand-parent": false,
      "indent": 8,
      "render-content": this.renderTreeItem,
      "onNodeExpand": (data) => {
        this.handleNodeExpand(data);
      },
      "onNodeCollapse": (data) => {
        this.handleNodeCollapse(data);
      },
      "onNodeDrop": this.handleDrop,
      "onCurrentChange": this.handNodeSelect
    }, null)]);
  }
});

export { IBizDesignTree as default };
