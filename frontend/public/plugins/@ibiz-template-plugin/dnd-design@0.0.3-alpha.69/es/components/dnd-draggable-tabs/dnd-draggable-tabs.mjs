import { resolveComponent, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { createUUID } from 'qx-util';
import '../../utils/index.mjs';
import './dnd-draggable-tabs.css';
import { modelStateUtil } from '../../utils/model-state-util/model-state-util.mjs';

"use strict";
var DndDraggableTabs = /* @__PURE__ */ defineComponent({
  name: "IBizDraggableTabs",
  props: {
    value: {
      type: String
    },
    items: {
      type: Array,
      required: true,
      default: () => {
        return [];
      }
    },
    dragSwitchPage: {
      type: Boolean,
      default: true
    },
    select: {
      type: Object
    },
    dndDesignController: {
      type: Object,
      required: true
    }
  },
  emits: ["change", "drag-change", "remove", "add"],
  setup(props, {
    emit
  }) {
    const ns = useNamespace("dnd-design-draggable-tabs");
    const shellNS = useNamespace("light-theme-shell");
    const uuid = createUUID();
    const onDragChange = (evt) => {
      emit("drag-change", evt);
    };
    const onItemClick = (item) => {
      if (item.srfkey !== props.value || !props.select || props.select.srfkey !== props.value) {
        emit("change", item);
      }
    };
    const onAddButtonClick = (e) => {
      e.stopPropagation();
      emit("add");
    };
    const onConfirm = (item) => {
      emit("remove", item);
    };
    const timerMap = /* @__PURE__ */ new Map();
    const onDragenter = (_e, item) => {
      if (!props.dragSwitchPage) {
        return;
      }
      if (item.srfkey) {
        const timerList = timerMap.get(item.srfkey) || [];
        const timer = window.setTimeout(() => {
          onItemClick(item);
          timerList.pop();
        }, 500);
        timerList.push(timer);
        timerMap.set(item.srfkey, timerList);
      }
    };
    const onDragLeave = (_e, item) => {
      if (!props.dragSwitchPage) {
        return;
      }
      if (item.srfkey) {
        const timerList = timerMap.get(item.srfkey);
        if (timerList) {
          const timer = timerList.pop();
          if (timer) {
            clearTimeout(timer);
          }
        }
      }
    };
    return {
      ns,
      shellNS,
      uuid,
      onDragChange,
      onItemClick,
      onConfirm,
      onAddButtonClick,
      onDragenter,
      onDragLeave
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b()
    }, [createVNode("div", {
      "class": this.ns.b("header")
    }, [createVNode(resolveComponent("iBizDraggable"), {
      "class": this.ns.b("nav"),
      "list": this.items,
      "group": {
        name: this.uuid,
        pull: false
      },
      "filter": ".".concat(this.ns.bm("item", "forbid")),
      "itemKey": "srfkey",
      "onChange": this.onDragChange
    }, {
      item: (args) => {
        const {
          element,
          index
        } = args;
        const isActive = this.value ? this.value === element.srfkey : index === 0;
        const state = this.dndDesignController.getModelState(element);
        return createVNode("div", {
          "class": [this.ns.b("item"), this.ns.is("active", isActive), !modelStateUtil.isEnableDrag(state) && this.ns.bm("item", "forbid")],
          "onClick": (e) => {
            e.stopPropagation();
            this.onItemClick(element);
          },
          "onDragenter": (e) => this.onDragenter(e, element),
          "onDragleave": (e) => this.onDragLeave(e, element)
        }, [createVNode("div", {
          "class": this.ns.be("item", "text")
        }, [element.srftext || ""]), modelStateUtil.isEnableRemove(state) && createVNode("div", {
          "class": this.ns.be("item", "remove-button")
        }, [createVNode(resolveComponent("el-popconfirm"), {
          "title": "\u786E\u8BA4\u5220\u9664\u8868\u5355\u5206\u9875?\u5B50\u6570\u636E\u5C06\u4E00\u5E76\u5220\u9664!",
          "confirm-button-text": "\u786E\u8BA4",
          "cancel-button-text": "\u53D6\u6D88",
          "width": "auto",
          "placement": "left",
          "popper-class": [this.ns.be("item", "pop-confirm"), this.shellNS.m("popper")],
          "icon": createVNode("ion-icon", {
            "name": "alert-circle"
          }, null),
          "icon-color": "#faad14",
          "onConfirm": () => this.onConfirm(element)
        }, {
          reference: () => {
            return createVNode("ion-icon", {
              "name": "close-outline",
              "onClick": (e) => {
                e.stopPropagation();
              }
            }, null);
          }
        })])]);
      },
      footer: () => {
        return createVNode("div", {
          "class": this.ns.b("item-add-button"),
          "onClick": (e) => this.onAddButtonClick(e),
          "title": "\u65B0\u5EFA\u5206\u9875"
        }, [createVNode("ion-icon", {
          "name": "add-outline",
          "class": this.ns.be("item-add-button", "icon")
        }, null)]);
      }
    })]), createVNode("div", {
      "class": this.ns.b("content")
    }, [this.items.map((item, i) => {
      var _a, _b;
      const isHidden = this.value ? item.srfkey !== this.value : i !== 0;
      const isShowMask = this.dndDesignController.isShowMask(item);
      return createVNode("div", {
        "class": [this.ns.b("item-content"), this.ns.is("hidden", isHidden), this.ns.is("select", this.select && item.srfkey === this.select.srfkey), isShowMask ? this.ns.bm("item-content", "mask") : ""],
        "onClick": (e) => {
          e.stopPropagation();
          this.onItemClick(item);
        }
      }, [isShowMask && createVNode("div", {
        "class": this.ns.be("item-content", "mask")
      }, null), (_b = (_a = this.$slots).default) == null ? void 0 : _b.call(_a, item)]);
    })])]);
  }
});

export { DndDraggableTabs as default };
