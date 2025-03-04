import { watch, reactive, resolveComponent, createVNode, defineComponent } from 'vue';
import { useControlController, useNamespace } from '@ibiz-template/vue3-util';
import { MemoEditFormController } from './memo-edit-form.controller.mjs';

"use strict";
const MemoEditFormControl = /* @__PURE__ */ defineComponent({
  name: "IBizMemoEditFormControl",
  props: {
    modelData: {
      type: Object,
      required: true
    },
    context: {
      type: Object,
      required: true
    },
    params: {
      type: Object,
      default: () => ({})
    },
    provider: {
      type: Object
    },
    isSimple: {
      type: Boolean,
      required: false
    },
    data: {
      type: Object,
      required: false
    },
    loadDefault: {
      type: Boolean,
      default: true
    }
  },
  setup(props) {
    const c = useControlController((...args) => new MemoEditFormController(...args), {
      excludePropsKeys: ["data"]
    });
    if (props.isSimple) {
      c.evt.on("onMounted", () => {
        c.setSimpleData(props.data || {});
      });
      watch(() => props.data, (newVal) => {
        const changeVal = newVal || {};
        const find = Object.keys(c.data).find((key) => {
          return changeVal[key] !== c.data[key];
        });
        if (find) {
          c.setSimpleData(changeVal);
        }
      }, {
        deep: true
      });
    }
    const ns = useNamespace("control-".concat(c.model.controlType.toLowerCase()));
    c.evt.on("onCreated", () => {
      const keys = Object.keys(c.details);
      keys.forEach((key) => {
        const detail = c.details[key];
        detail.state = reactive(detail.state);
      });
    });
    return {
      c,
      ns
    };
  },
  render() {
    return createVNode(resolveComponent("iBizMemoFormControl"), {
      "class": this.ns.b(),
      "controller": this.c
    }, {
      ...this.$slots
    });
  }
});

export { MemoEditFormControl };
