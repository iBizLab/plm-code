import { computed, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import '../../utils/index.mjs';
import './dnd-draggable-item.css';
import { modelStateUtil } from '../../utils/model-state-util/model-state-util.mjs';

"use strict";
var DndDraggableItem = /* @__PURE__ */ defineComponent({
  name: "IBizDraggableItem",
  props: {
    isSelect: {
      type: Boolean,
      default: false
    },
    item: {
      type: Object,
      required: true
    },
    actions: {
      type: Array,
      required: false
    },
    modelState: {
      type: Number,
      required: true
    },
    isShowMask: {
      type: Boolean
    },
    isShowLogicButton: {
      type: Boolean
    }
  },
  setup(props, {
    emit
  }) {
    const ns = useNamespace("dnd-design-draggable-item");
    const onClick = (e, action) => {
      e.stopPropagation();
      emit("action", action);
    };
    const layoutStyle = computed(() => {
      return {
        width: props.item.width ? "".concat(props.item.width, "px") : "",
        height: props.item.height ? "".concat(props.item.height, "px") : ""
      };
    });
    return {
      ns,
      layoutStyle,
      onClick
    };
  },
  render() {
    var _a, _b;
    return createVNode("div", {
      "class": [this.ns.b(), this.ns.is("select", this.isSelect)],
      "style": this.layoutStyle
    }, [createVNode("div", {
      "class": [this.ns.b("content"), this.isShowMask ? this.ns.bm("content", "mask") : ""]
    }, [this.isShowMask && createVNode("div", {
      "class": this.ns.be("content", "mask")
    }, null), (_b = (_a = this.$slots).default) == null ? void 0 : _b.call(_a)]), modelStateUtil.isEnableDrag(this.modelState) && createVNode("div", {
      "class": [this.ns.e("handle"), "handle"]
    }, [createVNode("svg", {
      "viewBox": "64 64 896 896",
      "data-icon": "drag",
      "width": "1em",
      "height": "1em",
      "fill": "currentColor",
      "aria-hidden": "true",
      "focusable": "false",
      "class": ""
    }, [createVNode("path", {
      "d": "M909.3 506.3L781.7 405.6a7.23 7.23 0 0 0-11.7 5.7V476H548V254h64.8c6 0 9.4-7 5.7-11.7L517.7 114.7a7.14 7.14 0 0 0-11.3 0L405.6 242.3a7.23 7.23 0 0 0 5.7 11.7H476v222H254v-64.8c0-6-7-9.4-11.7-5.7L114.7 506.3a7.14 7.14 0 0 0 0 11.3l127.5 100.8c4.7 3.7 11.7.4 11.7-5.7V548h222v222h-64.8c-6 0-9.4 7-5.7 11.7l100.8 127.5c2.9 3.7 8.5 3.7 11.3 0l100.8-127.5c3.7-4.7.4-11.7-5.7-11.7H548V548h222v64.8c0 6 7 9.4 11.7 5.7l127.5-100.8a7.3 7.3 0 0 0 .1-11.4z"
    }, null)])]), this.actions ? createVNode("ul", {
      "class": this.ns.b("actions")
    }, [this.actions.map((action) => {
      if (action.command === "delete" && !modelStateUtil.isEnableRemove(this.modelState)) {
        return;
      }
      if (action.command === "delete" && !this.isSelect) {
        return;
      }
      if (action.command === "logic" && !this.isShowLogicButton) {
        return;
      }
      return createVNode("li", {
        "class": this.ns.be("actions", "item"),
        "title": action.tooltip,
        "onClick": (e) => this.onClick(e, action)
      }, [action.icon]);
    })]) : null]);
  }
});

export { DndDraggableItem as default };
