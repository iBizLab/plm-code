import { isVNode, ref, resolveComponent, h, createVNode, provide, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { DndDesignPanelItemController } from './dnd-design.controller.mjs';
import '../../utils/index.mjs';
import './dnd-design.css';
import { layoutUtil } from '../../utils/layout-util/layout-util.mjs';
import { modelStateUtil } from '../../utils/model-state-util/model-state-util.mjs';

"use strict";
function _isSlot(s) {
  return typeof s === "function" || Object.prototype.toString.call(s) === "[object Object]" && !isVNode(s);
}
var DndDesign = /* @__PURE__ */ defineComponent({
  name: "IBizDndDesignPanelItem",
  props: {
    modelData: {
      type: Object,
      required: true
    },
    controller: {
      type: DndDesignPanelItemController,
      required: true
    }
  },
  setup(props) {
    const c = props.controller;
    const select = ref();
    const ns = useNamespace("dnd-design");
    c.view.select.on((data) => {
      select.value = data;
    });
    const onSelect = (e, item) => {
      e.stopPropagation();
      c.view.select.set(item);
    };
    const onActiveRoot = (e) => {
      e.stopPropagation();
      c.view.call("onActiveRoot");
    };
    const renderItems = (items, parent, renderChildren) => {
      const key = "dnd-design-".concat(parent ? parent.srfkey : "root");
      const modelState = parent ? c.getModelState(parent) : 0;
      return createVNode(resolveComponent("iBizDraggable"), {
        "class": {
          [ns.b("drag-container")]: true,
          ...parent ? layoutUtil.getDraggableContainerClass(parent, ns) : {}
        },
        "style": parent ? layoutUtil.getFlexLayoutStyle(parent) : {},
        "itemKey": "srfkey",
        "handle": ".handle",
        "key": key,
        "group": {
          name: "dnd-design",
          put: modelStateUtil.isEnableDrop(modelState)
        },
        "ghost-class": ns.b("ghost"),
        "list": items,
        "onChange": (e) => c.change(e, items, parent)
      }, {
        item: (data) => {
          var _a;
          let _slot;
          const item = data.element;
          const provider = c.providers[item.srfkey];
          if (!provider) {
            return null;
          }
          const controller = c.controllers[item.srfkey];
          const com = resolveComponent(provider.component);
          const state = c.getModelState(item);
          if (item.editortype === "HIDDEN" && !c.state.hiddenFormItemVisible) {
            return null;
          }
          return createVNode(resolveComponent("iBizDraggableItem"), {
            "class": parent ? layoutUtil.calcColClass(item, parent) : {},
            "style": parent ? layoutUtil.calcStyle(item, parent) : {},
            "controller": controller,
            "isSelect": ((_a = select.value) == null ? void 0 : _a.srfkey) === item.srfkey,
            "key": item.srfkey,
            "item": item,
            "actions": controller.actions,
            "modelState": state,
            "isShowMask": c.isShowMask(item),
            "onClick": (e) => onSelect(e, item),
            "onAction": (action) => {
              controller.onAction(action).then((result) => {
                if (result === false) {
                  if (action.command === "delete") {
                    c.remove(items, item);
                  }
                }
              });
            }
          }, _isSlot(_slot = h(com, {
            controller,
            dndDesignController: c
          }, renderChildren ? renderChildren(items, item) : item.children ? () => renderItems(item.children, item) : void 0)) ? _slot : {
            default: () => [_slot]
          });
        }
      });
    };
    const renderFormPage = () => {
      return createVNode(resolveComponent("iBizDndDesignFormPage"), {
        "key": c.state.uuid,
        "items": c.state.items,
        "dndDesignController": c,
        "select": select.value,
        "onChange": (e) => c.change(e, c.state.items),
        "onRemove": (item) => c.remove(c.state.items, item),
        "onSelect": (item) => {
          c.view.select.set(item);
        }
      }, {
        default: (item) => {
          if (!item.children) {
            item.children = [];
          }
          return renderItems(item.children, item);
        }
      });
    };
    provide("dndDesignRenderItems", renderItems);
    return {
      ns,
      renderItems,
      renderFormPage,
      onActiveRoot
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b(),
      "onClick": (e) => {
        this.onActiveRoot(e);
      }
    }, [createVNode("div", {
      "class": this.ns.b("container")
    }, [this.renderFormPage()])]);
  }
});

export { DndDesign as default };
