import { isVNode, ref, watch, computed, nextTick, resolveComponent, createVNode, onMounted, onUnmounted, resolveDirective, withDirectives, defineComponent } from 'vue';
import { useControlController, useNamespace } from '@ibiz-template/vue3-util';
import { createUUID } from 'qx-util';
import { debounce } from 'lodash-es';
import { getControlPanel } from '@ibiz-template/runtime';
import './tree.css';
import { RuntimeError } from '@ibiz-template/core';
import { findNodeData, useElTreeUtil, formatNodeDropType } from './el-tree-util.mjs';
import { LogicTreeDesignTreeController } from './tree.controller.mjs';

"use strict";
function _isSlot(s) {
  return typeof s === "function" || Object.prototype.toString.call(s) === "[object Object]" && !isVNode(s);
}
const LogicTreeDesignTree = /* @__PURE__ */ defineComponent({
  name: "IBizLogicTreeDesignTree",
  props: {
    modelData: {
      type: Object,
      required: true
    },
    context: {
      type: Object,
      required: true
    },
    params: {
      type: Object,
      default: () => ({})
    },
    provider: {
      type: Object
    },
    /**
     * 部件行数据默认激活模式
     * - 0 不激活
     * - 1 单击激活
     * - 2 双击激活(默认值)
     *
     * @type {(number | 0 | 1 | 2)}
     */
    mdctrlActiveMode: {
      type: Number,
      default: void 0
    },
    /**
     * 是否为单选
     * - true 单选
     * - false 多选
     *
     * @type {(Boolean)}
     */
    singleSelect: {
      type: Boolean,
      default: void 0
    },
    navigational: {
      type: Boolean,
      default: void 0
    },
    defaultExpandedKeys: {
      type: Array
    },
    loadDefault: {
      type: Boolean,
      default: true
    }
  },
  setup() {
    const c = useControlController((...args) => new LogicTreeDesignTreeController(...args));
    const ns = useNamespace("logic-tree-design-tree");
    const treeRef = ref(null);
    const treeviewRef = ref(null);
    const treeRefreshKey = ref("");
    const treeNodeTextInputRef = ref(null);
    const editingNodeKey = ref(null);
    const editingNodeText = ref(null);
    watch(() => treeNodeTextInputRef.value, (newVal) => {
      if (newVal) {
        newVal.$el.getElementsByTagName("input")[0].focus();
      }
    });
    const editCurrentNodeText = () => {
      var _a;
      const currentkey = (_a = treeRef.value) == null ? void 0 : _a.getCurrentKey();
      if (!currentkey || currentkey === editingNodeKey.value) {
        return;
      }
      const nodeData = findNodeData(currentkey, c);
      const model = c.getNodeModel(nodeData._nodeId);
      if (model == null ? void 0 : model.allowEditText) {
        editingNodeKey.value = currentkey;
      }
    };
    const onNodeTextEditBlur = async () => {
      if (editingNodeKey.value) {
        if (editingNodeText.value) {
          const nodeData = findNodeData(editingNodeKey.value, c);
          await c.modifyNodeText(nodeData, editingNodeText.value);
          editingNodeKey.value = null;
          editingNodeText.value = null;
        } else {
          editingNodeKey.value = null;
        }
      }
    };
    const {
      updateUI
    } = useElTreeUtil(treeRef, c);
    const toElNodes = (nodes) => {
      return nodes.map((node) => ({
        _id: node._id,
        _uuid: node._uuid,
        // 子节点或者，非子节点但是已经加载过子且子是空的
        _leaf: node._leaf || node._children && node._children.length === 0,
        _text: node._text
      }));
    };
    c.evt.on("onAfterRefreshParent", (event) => {
      if (treeRef.value) {
        const {
          parentNode,
          children
        } = event;
        const elNodes = toElNodes(children);
        treeRef.value.updateKeyChildren(parentNode._id, elNodes);
        updateUI();
      }
    });
    c.evt.on("onAfterNodeDrop", (event) => {
      if (event.isChangedParent) {
        treeRefreshKey.value = createUUID();
      }
    });
    const treeData = computed(() => {
      if (!c.state.isLoaded) {
        return [];
      }
      return c.model.rootVisible ? c.state.rootNodes : c.state.rootNodes.reduce((result, nodeData) => {
        if (nodeData._children) {
          return result.concat(nodeData._children);
        }
        return result;
      }, []);
    });
    watch(treeData, (newVal, oldVal) => {
      if (newVal !== oldVal) {
        treeRefreshKey.value = createUUID();
      }
    });
    const loadData = async (item, callback) => {
      let nodes;
      if (item.level === 0) {
        nodes = treeData.value;
        ibiz.log.debug("\u521D\u59CB\u52A0\u8F7D");
      } else {
        const nodeData = findNodeData(item.data._uuid, c);
        if (!nodeData) {
          return;
        }
        if (nodeData._children) {
          ibiz.log.debug("\u8282\u70B9\u5C55\u5F00\u52A0\u8F7D-\u672C\u5730", nodeData);
          nodes = nodeData._children;
        } else {
          ibiz.log.debug("\u8282\u70B9\u5C55\u5F00\u52A0\u8F7D-\u8FDC\u7A0B", nodeData);
          nodes = await c.loadNodes(nodeData);
        }
      }
      ibiz.log.debug("\u7ED9\u6811\u8FD4\u56DE\u503C", nodes);
      callback(toElNodes(nodes));
      updateUI();
    };
    let selectionWait = false;
    c.evt.on("onLoadSuccess", () => {
      selectionWait = true;
      setTimeout(() => {
        selectionWait = false;
      }, 200);
    });
    c.evt.on("onSelectionChange", async () => {
      var _a;
      if (selectionWait) {
        await nextTick();
      }
      if (c.state.singleSelect) {
        treeRef.value.setCurrentKey(((_a = c.state.selectedData[0]) == null ? void 0 : _a._id) || void 0);
      } else {
        treeRef.value.setCheckedKeys(c.state.selectedData.map((item) => item._id));
      }
    });
    const onCheck = (nodeData, opts) => {
      const {
        checkedNodes
      } = opts;
      c.setSelection(checkedNodes);
    };
    let forbidClick = false;
    const onNodeClick = (nodeData, evt) => {
      var _a, _b;
      evt.stopPropagation();
      if (forbidClick) {
        return;
      }
      if (((_a = treeRef.value) == null ? void 0 : _a.getCurrentKey()) === nodeData._id) {
        editCurrentNodeText();
      }
      if (!c.state.singleSelect) {
        (_b = treeRef.value) == null ? void 0 : _b.setCurrentKey(nodeData._id);
      }
      c.onTreeNodeClick(nodeData, evt);
      forbidClick = true;
      setTimeout(() => {
        forbidClick = false;
      }, 200);
    };
    const onNodeDbClick = (nodeData, evt) => {
      evt.stopPropagation();
      c.onDbTreeNodeClick(nodeData);
    };
    const iBizIcon = resolveComponent("IBizIcon");
    const renderContextMenu = (nodeModel, nodeData) => {
      var _a, _b, _c;
      if (!((_b = (_a = nodeModel == null ? void 0 : nodeModel.decontextMenu) == null ? void 0 : _a.detoolbarItems) == null ? void 0 : _b.length)) {
        return;
      }
      const logicType = (_c = nodeData._deData) == null ? void 0 : _c.srftype;
      return createVNode("div", {
        "class": ns.b("context-menu")
      }, [nodeModel.decontextMenu.detoolbarItems.map((item) => {
        if (item.userTag && logicType && logicType !== item.userTag) {
          return null;
        }
        if (c.context.srfreadonly === true || c.context.srfreadonly === "true") {
          return null;
        }
        return createVNode(resolveComponent("el-button"), {
          "text": true,
          "size": "small",
          "onClick": (e) => {
            e.stopPropagation();
            c.doUIAction(item.uiactionId, nodeData, e, item.appId);
          },
          "title": item.tooltip
        }, {
          default: () => [createVNode(iBizIcon, {
            "icon": item.sysImage
          }, null)]
        });
      })]);
    };
    const updateNodeExpand = (data, expanded) => {
      const nodeData = findNodeData(data._uuid, c);
      if (!nodeData) {
        throw new RuntimeError("\u6CA1\u6709\u627E\u5230_uuid\u4E3A".concat(data._uuid, "\u7684\u8282\u70B9"));
      }
      c.onExpandChange(nodeData, expanded);
    };
    const debounceSearch = debounce(() => {
      c.load();
    }, 500);
    const onInput = (value) => {
      c.state.query = value;
      debounceSearch();
    };
    const allowDrop = (draggingNode, dropNode, type) => {
      const draggingNodeData = findNodeData(draggingNode.data._uuid, c);
      const dropNodeData = findNodeData(dropNode.data._uuid, c);
      const result = c.calcAllowDrop(draggingNodeData, dropNodeData, type);
      return result;
    };
    const allowDrag = (draggingNode) => {
      const nodeData = findNodeData(draggingNode.data._uuid, c);
      return c.calcAllowDrag(nodeData);
    };
    const handleDrop = (draggingNode, dropNode, dropType) => {
      const type = formatNodeDropType(dropType);
      const draggingNodeData = findNodeData(draggingNode.data._uuid, c);
      const dropNodeData = findNodeData(dropNode.data._uuid, c);
      c.onNodeDrop(draggingNodeData, dropNodeData, type);
    };
    const keydownHandle = (e) => {
      if (e.code === "F2" || e.code === "Enter") {
        editCurrentNodeText();
      }
    };
    onMounted(() => {
      var _a;
      (_a = treeviewRef.value) == null ? void 0 : _a.$el.addEventListener("keydown", keydownHandle);
    });
    onUnmounted(() => {
      var _a;
      (_a = treeviewRef.value) == null ? void 0 : _a.$el.removeEventListener("keydown", keydownHandle);
    });
    const renderDeNode = (nodeData) => {
      const deData = nodeData._deData;
      return [deData.srficon && createVNode(iBizIcon, {
        "class": ns.be("node", "icon"),
        "icon": deData.srficon
      }, null), createVNode("span", {
        "title": deData.srfmajortext,
        "class": ns.be("node", "label")
      }, [deData.srfmajortext])];
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
      renderDeNode
    };
  },
  render() {
    const slots = {
      searchbar: () => {
        if (!this.c.enableQuickSearch) {
          return null;
        }
        return createVNode(resolveComponent("el-input"), {
          "model-value": this.c.state.query,
          "class": [this.ns.b("quick-search"), this.ns.b("quick-search")],
          "placeholder": this.c.state.placeHolder,
          "onInput": this.onInput
        }, {
          prefix: () => {
            return createVNode("ion-icon", {
              "class": this.ns.e("search-icon"),
              "name": "search"
            }, null);
          }
        });
      }
    };
    const key = this.c.controlPanel ? "tree" : "default";
    const readonly = this.c.context.srfreadonly === true || this.c.context.srfreadonly === "true";
    slots[key] = () => {
      if (this.c.state.isLoaded && this.treeRefreshKey) {
        return createVNode(resolveComponent("el-tree"), {
          "ref": "treeRef",
          "key": this.treeRefreshKey,
          "node-key": "_id",
          "highlight-current": true,
          "expand-on-click-node": false,
          "auto-expand-parent": false,
          "show-checkbox": !this.c.state.singleSelect,
          "check-strictly": true,
          "default-expanded-keys": this.c.state.expandedKeys,
          "props": {
            label: "_text",
            children: "_children",
            isLeaf: "_leaf"
          },
          "lazy": true,
          "load": this.loadData,
          "onCheck": this.onCheck,
          "onNodeExpand": (data) => {
            this.updateNodeExpand(data, true);
          },
          "onNodeCollapse": (data) => {
            this.updateNodeExpand(data, false);
          },
          "draggable": !readonly,
          "allow-drop": this.allowDrop,
          "allow-drag": this.allowDrag,
          "onNodeDrop": this.handleDrop
        }, {
          default: ({
            data
          }) => {
            var _a, _b;
            const nodeData = this.findNodeData(data._uuid, this.c);
            if (!nodeData) {
              return null;
            }
            const nodeModel = this.c.getNodeModel(nodeData._nodeId);
            if (this.editingNodeKey === nodeData._id) {
              return createVNode("div", {
                "class": [this.ns.b("node"), (_a = nodeModel.sysCss) == null ? void 0 : _a.cssName]
              }, [createVNode(resolveComponent("el-input"), {
                "modelValue": this.editingNodeText,
                "onUpdate:modelValue": ($event) => this.editingNodeText = $event,
                "ref": "treeNodeTextInputRef",
                "class": this.ns.b("editing-node"),
                "onBlur": () => {
                  this.onNodeTextEditBlur();
                },
                "onKeydown": (e) => {
                  e.stopPropagation();
                  if (e.code === "Enter") {
                    this.onNodeTextEditBlur();
                  }
                }
              }, null)]);
            }
            const layoutPanel = getControlPanel(nodeModel);
            let content;
            if (layoutPanel) {
              content = createVNode(resolveComponent("iBizControlShell"), {
                "data": nodeData,
                "modelData": layoutPanel,
                "context": this.c.context,
                "params": this.c.params
              }, null);
            } else if (nodeModel.treeNodeType === "DE") {
              content = this.renderDeNode(nodeData);
            } else {
              content = [nodeData._icon ? createVNode(resolveComponent("iBizIcon"), {
                "class": this.ns.be("node", "icon"),
                "icon": nodeData._icon
              }, null) : null, nodeData._textHtml ? createVNode("span", {
                "class": this.ns.be("node", "label"),
                "innerHTML": nodeData._textHtml
              }, null) : createVNode("span", {
                "class": this.ns.be("node", "label")
              }, [nodeData._text])];
            }
            return createVNode("div", {
              "onDblclick": (evt) => this.onNodeDbClick(nodeData, evt),
              "onClick": (evt) => this.onNodeClick(nodeData, evt),
              "class": [this.ns.b("node"), (_b = nodeModel.sysCss) == null ? void 0 : _b.cssName, nodeModel.rootNode ? this.ns.bm("node", "root") : ""]
            }, [content, this.renderContextMenu(nodeModel, nodeData)]);
          }
        });
      }
    };
    return withDirectives(createVNode(resolveComponent("iBizControlBase"), {
      "ref": "treeviewRef",
      "controller": this.c
    }, _isSlot(slots) ? slots : {
      default: () => [slots]
    }), [[resolveDirective("loading"), this.c.state.isLoading]]);
  }
});

export { LogicTreeDesignTree };
