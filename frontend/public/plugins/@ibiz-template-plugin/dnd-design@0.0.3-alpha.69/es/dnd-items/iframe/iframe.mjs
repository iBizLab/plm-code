import { createTextVNode, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import '../../controller/index.mjs';
import './iframe.css';
import { DndItemController } from '../../controller/dnd-item-controller/dnd-item-controller.mjs';

"use strict";
var Component = /* @__PURE__ */ defineComponent({
  name: "IBizDndDesignIframe",
  props: {
    controller: {
      type: DndItemController,
      required: true
    }
  },
  setup() {
    const ns = useNamespace("dnd-design-iframe");
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
    }, [data.srftext || "", createTextVNode("[\u76F4\u63A5\u5D4C\u5165\u9875\u9762\uFF08iframe\uFF09]")])]);
  }
});

export { Component as default };
