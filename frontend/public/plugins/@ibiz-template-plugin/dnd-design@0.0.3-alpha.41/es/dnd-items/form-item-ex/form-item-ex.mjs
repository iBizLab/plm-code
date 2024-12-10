import { createTextVNode, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import './form-item-ex.css';

"use strict";
var Component = /* @__PURE__ */ defineComponent({
  name: "IBizDndDesignFormItemEx",
  props: {
    controller: {
      type: Object,
      required: true
    }
  },
  setup() {
    const ns = useNamespace("dnd-design-form-item-ex");
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
    }, [data.srftext || "", createTextVNode("[\u590D\u5408\u8868\u5355\u9879]")])]);
  }
});

export { Component as default };
