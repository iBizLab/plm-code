import { ref, watch, resolveComponent, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { useRenderItems } from '../../use/index.mjs';
import './tab-panel.css';

"use strict";
var Component = /* @__PURE__ */ defineComponent({
  name: "IBizDndDesignTabPanel",
  props: {
    controller: {
      type: Object,
      required: true
    }
  },
  setup(props) {
    const ns = useNamespace("dnd-design-tab-panel");
    const c = props.controller;
    const renderItems = useRenderItems();
    const activePage = ref();
    const select = ref(c.select.data);
    c.select.on((data) => {
      select.value = data;
    });
    const onActivePageChange = (item) => {
      activePage.value = item.srfkey;
      c.select.set(item);
    };
    watch(select, () => {
      const items = c.data.children;
      if (Array.isArray(items) && items.length) {
        if (select.value) {
          const data = items.find((item) => item.srfkey === select.value.srfkey);
          if (data) {
            activePage.value = data.srfkey;
          }
        }
      }
    }, {
      immediate: true
    });
    const onPagePositionChange = async (evt) => {
      const items = c.data.children;
      if (Array.isArray(items)) {
        c.change(evt, items, c.data);
      }
    };
    const onPageAdd = async () => {
      const items = c.data.children;
      if (Array.isArray(items)) {
        items.push({
          detailtype: "TABPAGE"
        });
        c.change({
          added: {
            element: items[items.length - 1],
            newIndex: items.length - 1
          }
        }, items, c.data);
      }
    };
    const onPageRemove = async (page) => {
      const items = c.data.children;
      if (Array.isArray(items)) {
        c.remove(items, page);
      }
    };
    return {
      ns,
      activePage,
      select,
      onActivePageChange,
      onPagePositionChange,
      onPageAdd,
      onPageRemove,
      renderItems
    };
  },
  render() {
    const data = this.controller.data;
    const items = data.children || [];
    return createVNode("div", {
      "class": this.ns.b()
    }, [createVNode(resolveComponent("iBizDraggableTabs"), {
      "value": this.activePage,
      "items": items,
      "dragSwitchPage": false,
      "select": this.select,
      "class": this.ns.b("content"),
      "onChange": this.onActivePageChange,
      "onDragChange": this.onPagePositionChange,
      "onAdd": this.onPageAdd,
      "onRemove": this.onPageRemove
    }, {
      default: (item) => {
        return this.renderItems(item.children, item);
      }
    })]);
  }
});

export { Component as default };
