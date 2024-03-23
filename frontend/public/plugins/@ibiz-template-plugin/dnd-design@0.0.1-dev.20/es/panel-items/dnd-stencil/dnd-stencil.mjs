import { isVNode, resolveComponent, createVNode, createTextVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { DndStencilPanelItemController } from './dnd-stencil.controller.mjs';
import { resource } from '../../global.mjs';
import './dnd-stencil.css';

"use strict";
function _isSlot(s) {
  return typeof s === "function" || Object.prototype.toString.call(s) === "[object Object]" && !isVNode(s);
}
var DndStencil = /* @__PURE__ */ defineComponent({
  name: "IBizDndStencilPanelItem",
  props: {
    modelData: {
      type: Object,
      required: true
    },
    controller: {
      type: DndStencilPanelItemController,
      required: true
    }
  },
  setup(props) {
    const ns = useNamespace("dnd-stencil");
    const actives = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"];
    const clone = (item) => {
      const data = JSON.parse(item.data || "{}");
      data.srftype = data.detailtype;
      return data;
    };
    const onStart = (e) => {
      const el = e.item;
      if (el) {
        el.style.setProperty("--svg-visibility", "hidden");
      }
    };
    const onEnd = (e) => {
      const el = e.item;
      if (el) {
        el.style.setProperty("--svg-visibility", "");
      }
    };
    const onActionClick = async (detail, event) => {
      await props.controller.onActionClick(detail, event);
    };
    const renderGroup = (groupName, items, i, codeName) => {
      const buttonGroup = props.controller.buttonGroupMap.get(codeName);
      const model = buttonGroup && buttonGroup.model;
      const state = buttonGroup && buttonGroup.state;
      const group = model && model.uiactionGroup;
      return createVNode(resolveComponent("el-collapse-item"), {
        "title": groupName,
        "name": i.toString()
      }, {
        title: () => {
          return createVNode("div", {
            "class": ns.b("group-header")
          }, [createVNode("div", {
            "class": ns.b("group-header-text")
          }, [groupName]), group && state ? createVNode(resolveComponent("iBizActionToolbar"), {
            "class": ns.b("group-header-toolbar"),
            "actionDetails": group.uiactionGroupDetails,
            "actionsState": state,
            "onActionClick": onActionClick,
            "caption": group.name,
            "mode": model.actionGroupExtractMode === "ITEMS" ? "dropdown" : "buttons"
          }, null) : null]);
        },
        default: () => {
          return items.length === 0 ? createVNode("div", {
            "class": ns.bm("drag-container", "empty")
          }, [createTextVNode("\u6682\u65E0\u6570\u636E")]) : createVNode(resolveComponent("iBizDraggable"), {
            "itemKey": "dnd-stencil",
            "sort": false,
            "group": {
              name: "dnd-design",
              pull: "clone",
              put: false
            },
            "class": ns.b("drag-container"),
            "list": items,
            "clone": clone,
            "onStart": onStart,
            "onEnd": onEnd
          }, {
            item: (data) => {
              const item = data.element;
              return createVNode("div", {
                "key": data.index,
                "class": [ns.b("handle")],
                "title": item.text
              }, [createVNode("svg", {
                "class": ns.be("handle", "svg"),
                "height": "100%",
                "width": "100%",
                "xmlns": "http://www.w3.org/2000/svg"
              }, [createVNode("rect", {
                "height": "100%",
                "width": "100%"
              }, null)]), createVNode("div", {
                "class": [ns.b("handle-content")]
              }, [createVNode("div", {
                "class": [ns.be("handle", "icon")]
              }, [item.iconPath ? createVNode("ion-icon", {
                "src": resource.dir(item.iconPath)
              }, null) : null]), createVNode("div", {
                "class": [ns.be("handle", "text")]
              }, [item.text])])]);
            }
          });
        }
      });
    };
    return {
      ns,
      renderGroup,
      clone,
      actives
    };
  },
  render() {
    const content = [];
    if (this.controller.enableGroup) {
      this.controller.state.items.forEach((codeItem, i) => {
        content.push(this.renderGroup(codeItem.text, codeItem.codeItems, i, codeItem.codeName));
      });
    } else {
      content.push(this.renderGroup(this.controller.codeList.name, this.controller.state.items, 0, this.controller.codeList.codeName));
    }
    return createVNode("div", {
      "class": this.ns.b()
    }, [createVNode(resolveComponent("el-collapse"), {
      "modelValue": this.actives,
      "onUpdate:modelValue": ($event) => this.actives = $event
    }, _isSlot(content) ? content : {
      default: () => [content]
    })]);
  }
});

export { DndStencil as default };
