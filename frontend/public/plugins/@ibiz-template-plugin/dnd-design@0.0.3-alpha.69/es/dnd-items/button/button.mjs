import { resolveComponent, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import '../../controller/index.mjs';
import './button.css';
import { DndItemController } from '../../controller/dnd-item-controller/dnd-item-controller.mjs';

"use strict";
var Component = /* @__PURE__ */ defineComponent({
  name: "IBizDndDesignButton",
  props: {
    controller: {
      type: DndItemController,
      required: true
    }
  },
  setup() {
    const ns = useNamespace("dnd-design-button");
    return {
      ns
    };
  },
  render() {
    const data = this.controller.data;
    return createVNode("div", {
      "class": this.ns.b()
    }, [createVNode(resolveComponent("el-button"), {
      "class": this.ns.b("content")
    }, {
      default: () => [data.showcaption !== 0 ? data.srftext || "" : "*"]
    })]);
  }
});

export { Component as default };
