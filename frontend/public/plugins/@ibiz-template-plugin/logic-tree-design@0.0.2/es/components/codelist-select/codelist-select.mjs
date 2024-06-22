import { ref, createTextVNode, createVNode, resolveComponent, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import './codelist-select.css';

"use strict";
const CodeListSelect = /* @__PURE__ */ defineComponent({
  name: "IBizCodeListSelect",
  props: {
    codeListId: {
      type: String,
      required: true
    },
    context: {
      type: Object,
      required: true
    },
    params: {
      type: Object
    }
  },
  emits: ["select"],
  setup(props, {
    emit
  }) {
    const ns = useNamespace("codelist-select");
    const codeListItems = ref();
    ibiz.hub.getApp(props.context.srfappid).codeList.get(props.codeListId, props.context, props.params).then((items) => {
      codeListItems.value = items;
    });
    const onSelect = (item) => {
      emit("select", item);
    };
    return {
      ns,
      codeListItems,
      onSelect
    };
  },
  render() {
    var _a;
    return createVNode("div", {
      "class": [this.ns.b()]
    }, [createVNode("div", {
      "class": [this.ns.e("header")]
    }, [createTextVNode("\u65B0\u5EFA")]), createVNode("div", {
      "class": [this.ns.e("items")]
    }, [(_a = this.codeListItems) == null ? void 0 : _a.map((item) => createVNode("div", {
      "class": [this.ns.b("item")],
      "onClick": () => this.onSelect(item)
    }, [item.sysImage && createVNode(resolveComponent("iBizIcon"), {
      "class": [this.ns.be("item", "icon")],
      "icon": item.sysImage
    }, null), createVNode("div", {
      "class": [this.ns.be("item", "text")]
    }, [item.text])]))])]);
  }
});

export { CodeListSelect };
