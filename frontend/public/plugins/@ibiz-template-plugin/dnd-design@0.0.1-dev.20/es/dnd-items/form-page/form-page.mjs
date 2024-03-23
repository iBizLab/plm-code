import { ref, watch, resolveComponent, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import './form-page.css';

"use strict";
var Component = /* @__PURE__ */ defineComponent({
  name: "IBizDndDesignFormPage",
  props: {
    items: {
      type: Array,
      required: true,
      default: () => {
        return [];
      }
    },
    select: {
      type: Object
    }
  },
  emits: ["change", "remove", "select"],
  setup(props, {
    emit
  }) {
    const ns = useNamespace("dnd-design-form-page");
    const activePage = ref();
    watch(() => props.select, () => {
      const items = props.items;
      if (Array.isArray(items) && items.length) {
        if (props.select) {
          const data = items.find((item) => item.srfkey === props.select.srfkey);
          if (data) {
            activePage.value = data.srfkey;
          }
        }
      }
    }, {
      immediate: true
    });
    const onActivePageChange = (item) => {
      activePage.value = item.srfkey;
      emit("select", item);
    };
    const onPagePositionChange = async (evt) => {
      emit("change", evt);
    };
    const onPageAdd = async () => {
      const items = props.items;
      items.push({
        detailtype: "FORMPAGE"
      });
      emit("change", {
        added: {
          element: items[items.length - 1],
          newIndex: items.length - 1
        }
      });
    };
    const onPageRemove = async (page) => {
      emit("remove", page);
    };
    return {
      ns,
      activePage,
      onActivePageChange,
      onPagePositionChange,
      onPageAdd,
      onPageRemove
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b()
    }, [createVNode(resolveComponent("iBizDraggableTabs"), {
      "value": this.activePage,
      "items": this.items,
      "select": this.select,
      "onChange": this.onActivePageChange,
      "onDragChange": this.onPagePositionChange,
      "onAdd": this.onPageAdd,
      "onRemove": this.onPageRemove
    }, {
      default: (item) => {
        var _a, _b;
        return (_b = (_a = this.$slots).default) == null ? void 0 : _b.call(_a, item);
      }
    })]);
  }
});

export { Component as default };
