import { ref, watch, createVNode, resolveComponent, createTextVNode, defineComponent } from 'vue';
import { getInputProps, getEditorEmits, useNamespace } from '@ibiz-template/vue3-util';
import { debounce } from 'lodash-es';
import './cron-editor.css';

"use strict";
var CronEditor = /* @__PURE__ */ defineComponent({
  name: "IBizCronEditor",
  props: getInputProps(),
  emits: getEditorEmits(),
  setup(props, {
    emit
  }) {
    const c = props.controller;
    const ns = useNamespace("cron-editor");
    const cronPopover = ref(false);
    const currentVal = ref("");
    watch(() => props.value, (newVal, oldVal) => {
      if (newVal !== oldVal) {
        if (newVal == null) {
          currentVal.value = "";
        } else {
          currentVal.value = newVal.toString();
        }
      }
    }, {
      immediate: true
    });
    const changeCron = (val) => {
      if (typeof val !== "string")
        return false;
      currentVal.value = val;
      emit("change", val);
    };
    const closeCron = () => {
      cronPopover.value = false;
    };
    const changeButton = () => {
      cronPopover.value = !cronPopover.value;
    };
    const debounceChange = debounce((val) => {
      emit("change", val);
    }, 300, {
      leading: true
    });
    const handleChange = (val) => {
      debounceChange(val);
    };
    return {
      c,
      ns,
      changeCron,
      closeCron,
      changeButton,
      cronPopover,
      currentVal,
      handleChange
    };
  },
  render() {
    let content = null;
    if (this.readonly) {
      content = createVNode("span", null, [this.currentVal]);
    } else {
      content = createVNode(resolveComponent("el-input"), {
        "modelValue": this.currentVal,
        "onUpdate:modelValue": ($event) => this.currentVal = $event,
        "disabled": this.c.model.disabled,
        "onInput": this.handleChange,
        "placeholder": this.c.placeHolder
      }, {
        append: () => createVNode(resolveComponent("el-popover"), {
          "visible": this.cronPopover,
          "width": "700px",
          "trigger": "click"
        }, {
          reference: () => createVNode(resolveComponent("el-button"), {
            "onClick": this.changeButton,
            "disabled": this.c.model.disabled
          }, {
            default: () => [createTextVNode("\u8BBE\u7F6E")]
          }),
          default: () => createVNode(resolveComponent("noVue3Cron"), {
            "cronValue": this.currentVal,
            "onChange": this.changeCron,
            "onClose": this.closeCron,
            "maxHeight": "400px",
            "i18n": "cn"
          }, null)
        })
      });
    }
    return createVNode("div", {
      "class": [this.ns.b(), this.readonly ? this.ns.m("readonly") : ""]
    }, [content]);
  }
});

export { CronEditor as default };
