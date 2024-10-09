import { createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import '../../controller/index.mjs';
import { useRenderItems } from '../../use/index.mjs';
import './group-panel.css';
import { DndItemController } from '../../controller/dnd-item-controller/dnd-item-controller.mjs';

"use strict";
var Component = /* @__PURE__ */ defineComponent({
  name: "IBizDndDesignFormPanel",
  props: {
    controller: {
      type: DndItemController,
      required: true
    }
  },
  setup() {
    const ns = useNamespace("dnd-design-group-panel");
    const renderItems = useRenderItems();
    return {
      ns,
      renderItems
    };
  },
  render() {
    const data = this.controller.data;
    const isHiddenHeader = data.showcaption === 0;
    return createVNode("div", {
      "class": this.ns.b()
    }, [isHiddenHeader ? createVNode("div", {
      "class": this.ns.b("info")
    }, [data.srftext || ""]) : createVNode("div", {
      "class": this.ns.b("header")
    }, [createVNode("div", null, [createVNode("div", {
      "class": this.ns.be("header", "text")
    }, [data.srftext || ""]), createVNode("ion-icon", {
      "class": this.ns.be("header", "icon"),
      "name": "caret-down"
    }, null)])]), createVNode("div", {
      "class": this.ns.b("content")
    }, [this.renderItems(data.children, data)])]);
  }
});

export { Component as default };
