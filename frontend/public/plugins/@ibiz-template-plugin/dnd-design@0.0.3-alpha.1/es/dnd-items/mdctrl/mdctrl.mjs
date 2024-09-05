import { createTextVNode, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import '../../controller/index.mjs';
import './mdctrl.css';
import { DndItemController } from '../../controller/dnd-item-controller/dnd-item-controller.mjs';

"use strict";
var Component = /* @__PURE__ */ defineComponent({
  name: "IBizDndDesignMDCtrl",
  props: {
    controller: {
      type: DndItemController,
      required: true
    }
  },
  setup() {
    const ns = useNamespace("dnd-design-mdctrl");
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
    }, [data.srftext || "", createTextVNode("[\u591A\u6570\u636E\u90E8\u4EF6]")])]);
  }
});

export { Component as default };
