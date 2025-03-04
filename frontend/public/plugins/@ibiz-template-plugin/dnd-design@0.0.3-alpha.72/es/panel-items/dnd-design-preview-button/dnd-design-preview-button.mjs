import { resolveComponent, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { DndDesignPreviewButtonController } from './dnd-design-preview-button.controller.mjs';
import './dnd-design-preview-button.css';

"use strict";
var DndDesignPreviewButton = /* @__PURE__ */ defineComponent({
  name: "IBizDndDesignPreviewButton",
  props: {
    modelData: {
      type: Object,
      required: true
    },
    controller: {
      type: DndDesignPreviewButtonController,
      required: true
    }
  },
  setup() {
    const ns = useNamespace("dnd-design-preview-button");
    return {
      ns
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b()
    }, [createVNode(resolveComponent("el-button"), {
      "size": "small",
      "onClick": () => {
        this.controller.handleButtonClick();
      }
    }, {
      default: () => [this.controller.state.isPreview ? "\u53D6\u6D88\u9884\u89C8" : "\u9884\u89C8"]
    })]);
  }
});

export { DndDesignPreviewButton as default };
