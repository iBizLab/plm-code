import { ref, watch, resolveComponent, createVNode, createTextVNode, defineComponent } from 'vue';
import { getInputProps, useNamespace } from '@ibiz-template/vue3-util';
import { debounce, clone } from '@ibiz-template/core';
import './view-nav-params.css';

"use strict";
const ViewNavParams = /* @__PURE__ */ defineComponent({
  name: "ViewNavParams",
  props: getInputProps(),
  emits: ["change"],
  setup(props, {
    emit
  }) {
    const ns = useNamespace("view-nav-params");
    const c = props.controller;
    const isCustom = ref(false);
    const curValue = ref("");
    const items = ref([]);
    const paramType = [{
      label: "\u9ED8\u8BA4",
      value: "DEFAULT"
    }, {
      label: "\u4E0A\u4E0B\u6587",
      value: "SRFNAVCTX"
    }, {
      label: "\u89C6\u56FE\u53C2\u6570",
      value: "SRFNAVPARAM"
    }];
    const paramValueType = [{
      label: "\u76F4\u63A5\u503C",
      value: 1
    }, {
      label: "\u586B\u5145\u503C",
      value: 2
    }];
    const formatParams = (value) => {
      const list = value.split("\n");
      const params = [];
      list.forEach((item) => {
        if (!item) {
          return;
        }
        const param = item.split("=");
        let tempParamType = "DEFAULT";
        let tempParamKey = "";
        let tempValue = param[1];
        let tempValueType = 1;
        if (param[0].indexOf(".") >= 0) {
          const typeKey = param[0].split(".");
          tempParamType = typeKey[0];
          tempParamKey = typeKey[1];
        } else {
          tempParamKey = param[0];
        }
        if (param[1].startsWith("%") && param[1].endsWith("%")) {
          tempValue = param[1].slice(1, -1);
          tempValueType = 2;
        }
        params.push({
          paramType: tempParamType,
          paramKey: tempParamKey,
          paramValue: tempValue,
          paramValueType: tempValueType
        });
      });
      items.value = params;
    };
    watch(() => props.value, () => {
      curValue.value = props.value;
      formatParams(props.value || "");
    }, {
      immediate: true
    });
    const calcParamStr = () => {
      const params = items.value.map((item) => {
        const type = item.paramType === "DEFAULT" ? "" : "".concat(item.paramType, ".");
        const key = item.paramKey ? "".concat(item.paramKey) : "";
        const value = item.paramValueType === 1 ? item.paramValue : "%".concat(item.paramValue, "%");
        return "".concat(type).concat(key, "=").concat(value);
      });
      return params.join("\n");
    };
    const emitFunc = debounce(() => {
      emit("change", curValue.value);
    }, 500);
    const onValueChange = () => {
      curValue.value = calcParamStr();
      emitFunc();
    };
    const onDelete = (index) => {
      if (props.disabled || props.readonly) {
        return;
      }
      items.value.splice(index, 1);
      curValue.value = calcParamStr();
      emitFunc();
    };
    const onCopy = (index) => {
      if (props.disabled || props.readonly) {
        return;
      }
      const tempCopy = clone(items.value[index]);
      items.value.splice(index, 0, tempCopy);
      curValue.value = calcParamStr();
      emitFunc();
    };
    const onAddItem = () => {
      if (props.disabled || props.readonly) {
        return;
      }
      items.value.push({
        paramType: "DEFAULT",
        paramKey: "",
        paramValue: "",
        paramValueType: 1
      });
      curValue.value = calcParamStr();
      emitFunc();
    };
    const onSwitchCustom = (value) => {
      isCustom.value = value;
    };
    const renderSelectList = () => {
      return items.value.map((item, index) => {
        return createVNode("div", {
          "class": ns.e("item")
        }, [createVNode("div", {
          "class": ns.em("item", "param-type")
        }, [createVNode(resolveComponent("el-select"), {
          "modelValue": item.paramType,
          "onUpdate:modelValue": ($event) => item.paramType = $event,
          "onChange": onValueChange,
          "readonly": props.readonly,
          "disabled": props.disabled
        }, {
          default: () => {
            return paramType.map((type) => {
              return createVNode(resolveComponent("el-option"), {
                "key": type.value,
                "label": type.label,
                "value": type.value
              }, null);
            });
          }
        })]), createVNode("div", {
          "class": ns.em("item", "param-key")
        }, [createVNode(resolveComponent("el-input"), {
          "modelValue": item.paramKey,
          "onUpdate:modelValue": ($event) => item.paramKey = $event,
          "readonly": props.readonly,
          "disabled": props.disabled,
          "onInput": onValueChange
        }, null)]), createVNode("div", {
          "class": ns.em("item", "param-value")
        }, [createVNode(resolveComponent("el-input"), {
          "modelValue": item.paramValue,
          "onUpdate:modelValue": ($event) => item.paramValue = $event,
          "readonly": props.readonly,
          "disabled": props.disabled,
          "onInput": onValueChange
        }, null)]), createVNode("div", {
          "class": ns.em("item", "param-value-type")
        }, [createVNode(resolveComponent("el-select"), {
          "modelValue": item.paramValueType,
          "onUpdate:modelValue": ($event) => item.paramValueType = $event,
          "onChange": onValueChange,
          "disabled": props.disabled
        }, {
          default: () => {
            return paramValueType.map((type) => {
              return createVNode(resolveComponent("el-option"), {
                "key": type.value,
                "label": type.label,
                "value": type.value
              }, null);
            });
          }
        })]), createVNode("div", {
          "class": [ns.em("item", "remove"), ns.is("disabled", props.disabled || props.readonly)],
          "title": "\u5220\u9664",
          "onClick": () => onDelete(index)
        }, [createVNode("ion-icon", {
          "name": "close-outline"
        }, null)]), createVNode("div", {
          "class": [ns.em("item", "copy"), ns.is("disabled", props.disabled || props.readonly)],
          "title": "\u590D\u5236",
          "onClick": () => onCopy(index)
        }, [createVNode("ion-icon", {
          "name": "copy-outline"
        }, null)])]);
      });
    };
    const onCustomChange = () => {
      emitFunc();
    };
    return {
      ns,
      c,
      isCustom,
      items,
      curValue,
      onValueChange,
      renderSelectList,
      onAddItem,
      onSwitchCustom,
      onCustomChange
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b()
    }, [!this.isCustom ? createVNode("div", {
      "class": this.ns.e("select")
    }, [createVNode("div", {
      "class": this.ns.em("select", "list")
    }, [this.renderSelectList()]), createVNode("div", {
      "class": this.ns.em("select", "use-custom")
    }, [createVNode("div", {
      "class": [this.ns.em("select", "btn")],
      "onClick": () => this.onSwitchCustom(true)
    }, [createTextVNode("\u5F00\u542F\u81EA\u5B9A\u4E49")]), createVNode("ion-icon", {
      "class": [this.ns.em("select", "add-icon"), this.ns.is("disabled", this.disabled || this.readonly)],
      "name": "add-outline",
      "onClick": this.onAddItem,
      "title": "\u65B0\u589E"
    }, null)])]) : createVNode("div", {
      "class": this.ns.e("custom")
    }, [createVNode("div", {
      "class": this.ns.em("custom", "textarea")
    }, [createVNode(resolveComponent("el-input"), {
      "type": "textarea",
      "modelValue": this.curValue,
      "onUpdate:modelValue": ($event) => this.curValue = $event,
      "disabled": this.disabled,
      "readonly": this.readonly,
      "this": true,
      "rows": "6",
      "onInput": this.onCustomChange
    }, null)]), createVNode("div", {
      "class": this.ns.em("custom", "close-custom")
    }, [createVNode("div", {
      "class": this.ns.em("select", "btn"),
      "onClick": () => this.onSwitchCustom(false)
    }, [createTextVNode("\u5173\u95ED\u81EA\u5B9A\u4E49")])])])]);
  }
});

export { ViewNavParams };
