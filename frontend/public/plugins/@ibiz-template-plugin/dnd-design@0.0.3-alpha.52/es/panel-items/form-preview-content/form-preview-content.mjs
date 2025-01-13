import { resolveComponent, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import './form-preview-content.css';

"use strict";
var IBizFormPreviewContent = /* @__PURE__ */ defineComponent({
  name: "IBizFormPreviewContent",
  props: {
    modelData: {
      type: Object,
      required: true
    },
    controller: {
      type: Object,
      required: true
    }
  },
  setup() {
    const ns = useNamespace("form-preview-content");
    return {
      ns
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b()
    }, [createVNode(resolveComponent("iBizFormShell"), {
      "data": this.controller.majorData,
      "items": this.controller.state.items,
      "context": this.controller.panel.context
    }, null)]);
  }
});

export { IBizFormPreviewContent as default };
