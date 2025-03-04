import { createTextVNode, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import '../../controller/index.mjs';
import './druipart.css';
import { DndItemController } from '../../controller/dnd-item-controller/dnd-item-controller.mjs';

"use strict";
var Component = /* @__PURE__ */ defineComponent({
  name: "IBizDndDesignDRUIPart",
  props: {
    controller: {
      type: DndItemController,
      required: true
    }
  },
  setup() {
    const ns = useNamespace("dnd-design-druipart");
    return {
      ns
    };
  },
  render() {
    const data = this.controller.data;
    return createVNode("div", {
      "class": this.ns.b()
    }, [createVNode("div", {
      "class": this.ns.b("content")
    }, [data.srftext || "", createTextVNode("[\u5173\u7CFB]")])]);
  }
});

export { Component as default };
