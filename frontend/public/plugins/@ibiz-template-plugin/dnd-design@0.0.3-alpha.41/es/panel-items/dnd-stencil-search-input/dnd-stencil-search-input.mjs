import { ref, watch, resolveComponent, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { DndStencilSearchInputController } from './dnd-stencil-search-input.controller.mjs';
import './dnd-stencil-search-input.css';

"use strict";
var DndStencilSearchInput = /* @__PURE__ */ defineComponent({
  name: "IBizDndStencilSearchInput",
  props: {
    modelData: {
      type: Object,
      required: true
    },
    controller: {
      type: DndStencilSearchInputController,
      required: true
    }
  },
  setup(props) {
    const ns = useNamespace("dnd-stencil-search-input");
    const searchValue = ref("");
    watch(searchValue, () => {
      props.controller.sendMessage(searchValue.value);
    });
    return {
      ns,
      searchValue
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b()
    }, [createVNode(resolveComponent("el-input"), {
      "modelValue": this.searchValue,
      "onUpdate:modelValue": ($event) => this.searchValue = $event,
      "placeholder": "\u8F93\u5165\u5173\u952E\u8BCD\u8FDB\u884C\u8FC7\u6EE4",
      "prefix-icon": createVNode("ion-icon", {
        "name": "search-outline"
      }, null),
      "clearable": true
    }, null)]);
  }
});

export { DndStencilSearchInput as default };
