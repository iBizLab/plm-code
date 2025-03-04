import { ref, watch, resolveComponent, createVNode, createTextVNode, defineComponent } from 'vue';
import { getInputProps, getEditorEmits, useNamespace } from '@ibiz-template/vue3-util';
import { debounce } from 'lodash-es';
import { createUUID } from 'qx-util';
import { resource } from '../../global.mjs';
import './editor-params-custom.css';

"use strict";
var EditorParams = /* @__PURE__ */ defineComponent({
  name: "IBizEditorParmas",
  props: getInputProps(),
  emits: getEditorEmits(),
  setup(props, {
    emit
  }) {
    var _a;
    const c = props.controller;
    const ns = useNamespace("editor-params-custom");
    const isCustom = ref(false);
    const changeIscustom = () => {
      isCustom.value = !isCustom.value;
    };
    let editorType = (_a = props.data) == null ? void 0 : _a.editortype;
    const editorParams = ref(props.value);
    const formData = ref({});
    const typeMap = {
      param: "",
      srfnavparam: "SRFNAVPARAM.",
      srfnavctx: "SRFNAVCTX."
    };
    const formItems = ref([]);
    const dynamicItems = ref([]);
    const valueEditorRefs = ref([]);
    const transformEditorParams = (editorParamsStr) => {
      if (!editorParamsStr) {
        return;
      }
      const items = editorParamsStr.split("\n");
      const dynamicParamList = [];
      items.forEach((item) => {
        if (!item) {
          return;
        }
        const index = item.indexOf("=");
        if (index === -1) {
          return;
        }
        const key = item.slice(0, index);
        const value = item.slice(index + 1);
        if (!key) {
          return;
        }
        if (Object.prototype.hasOwnProperty.call(formData.value, key)) {
          if (!value) {
            formData.value[key] = void 0;
          } else {
            try {
              formData.value[key] = JSON.parse(value);
            } catch (error) {
              formData.value[key] = value;
            }
          }
        } else {
          let tempKey = key;
          let type = "param";
          if (key.startsWith("SRFNAVPARAM.")) {
            tempKey = key.slice(key.indexOf(".") + 1);
            type = "srfnavparam";
          } else if (key.startsWith("SRFNAVCTX.")) {
            tempKey = key.slice(key.indexOf(".") + 1);
            type = "srfnavctx";
          }
          const obj = {
            id: createUUID(),
            key: tempKey,
            value,
            type
          };
          dynamicParamList.push(obj);
        }
      });
      dynamicItems.value = dynamicParamList;
    };
    const initFormItems = (_editorType) => {
      return false;
    };
    const onEditorTypeChange = (editorTypeStr) => {
      if (!editorTypeStr) {
        formItems.value = [];
        formData.value = {};
      } else if (editorTypeStr !== editorType) {
        const result = initFormItems(editorTypeStr);
        if (!result) {
          formItems.value = [];
          formData.value = {};
        }
      }
    };
    const onParamDataChange = () => {
      const formParamList = [];
      const dynamicParamList = [];
      dynamicItems.value.forEach((item) => {
        if (!item.key) {
          return;
        }
        dynamicParamList.push("".concat(typeMap[item.type]).concat(item.key, "=").concat(item.value));
      });
      const formParams = formParamList.join("\n");
      const dynamicParams = dynamicParamList.join("\n");
      if (formParams) {
        editorParams.value = "".concat(formParams).concat(dynamicParams ? "\n".concat(dynamicParams) : "");
        emit("change", editorParams.value || null);
      } else {
        editorParams.value = dynamicParams;
        emit("change", editorParams.value || null);
      }
    };
    if (editorParams.value) {
      transformEditorParams(editorParams.value);
    }
    watch(() => props.value, (_newVal, _oldVal) => {
      if (editorParams.value) {
        transformEditorParams(editorParams.value);
      }
    });
    watch(() => props.data, (newVal, _oldVal) => {
      const editorTypeStr = newVal == null ? void 0 : newVal.editortype;
      const editorParamsStr = props.value ? props.value.toString() : "";
      if (!editorParamsStr) {
        dynamicItems.value = [];
      } else if (editorParamsStr !== editorParams.value || editorTypeStr !== editorType) {
        transformEditorParams(editorParamsStr);
      }
      editorType = editorTypeStr;
      editorParams.value = editorParamsStr;
      onParamDataChange();
    }, {
      immediate: true
    });
    const addDynamicParam = (type) => {
      dynamicItems.value.push({
        id: createUUID(),
        key: "",
        value: "",
        type
      });
      onParamDataChange();
    };
    const deleteDynamicParam = (index) => {
      dynamicItems.value.splice(index, 1);
      onParamDataChange();
    };
    const onDynamicParamChange = (value, item, key) => {
      item[key] = value;
      const fn = debounce(() => {
        onParamDataChange();
      }, 0);
      fn();
    };
    const onCustomParamChange = (valueStr) => {
      const fn = debounce(() => {
        emit("change", valueStr);
      }, 0);
      fn();
    };
    const onFocus = async (index) => {
      setTimeout(() => {
        const target = valueEditorRefs.value[index];
        target == null ? void 0 : target.focus();
      }, 0);
    };
    return {
      ns,
      c,
      isCustom,
      changeIscustom,
      dynamicItems,
      formItems,
      addDynamicParam,
      editorParams,
      typeMap,
      formData,
      onEditorTypeChange,
      transformEditorParams,
      editorType,
      onCustomParamChange,
      onDynamicParamChange,
      deleteDynamicParam,
      onFocus,
      valueEditorRefs
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b()
    }, [this.isCustom ? createVNode(resolveComponent("el-input"), {
      "class": [this.ns.e("param-textarea"), this.ns.is("readonly", this.readonly)],
      "type": "textarea",
      "rows": 6,
      "modelValue": this.editorParams,
      "onUpdate:modelValue": ($event) => this.editorParams = $event,
      "readonly": this.readonly,
      "disabled": this.readonly,
      "onInput": (value) => this.onCustomParamChange(value)
    }, null) : createVNode("div", {
      "class": this.ns.e("param-container")
    }, [createVNode("div", {
      "class": this.ns.e("param-list-from")
    }, null), createVNode("div", {
      "class": this.ns.e("param-list-dynamic")
    }, [this.dynamicItems.map((item, index) => createVNode("div", {
      "class": this.ns.e("param-item-dynamic"),
      "key": item.id
    }, [createVNode("ion-icon", {
      "src": resource.dir("./assets/svg/".concat(item.type, ".svg")),
      "class": this.ns.em("param-item-dynamic", "icon")
    }, null), this.readonly ? [createVNode("div", {
      "class": [this.ns.em("param-item-dynamic", "key"), this.ns.is("readonly", this.readonly)]
    }, [item.key]), createVNode("div", {
      "class": [this.ns.em("param-item-dynamic", "value"), this.ns.is("readonly", this.readonly)]
    }, [item.value])] : [createVNode(resolveComponent("el-input"), {
      "class": this.ns.em("param-item-dynamic", "key"),
      "modelValue": item.key,
      "onUpdate:modelValue": ($event) => item.key = $event,
      "onChange": (value) => this.onDynamicParamChange(value, item, "key")
    }, null), createVNode(resolveComponent("el-input"), {
      "ref": (el) => {
        this.valueEditorRefs[index] = el;
      },
      "class": this.ns.em("param-item-dynamic", "value"),
      "modelValue": item.value,
      "onUpdate:modelValue": ($event) => item.value = $event,
      "onFocus": () => this.onFocus(index),
      "onChange": (value) => {
        this.onDynamicParamChange(value, item, "value");
      }
    }, null), createVNode("ion-icon", {
      "name": "close-outline",
      "class": this.ns.em("param-item-dynamic", "delete"),
      "onClick": () => this.deleteDynamicParam(index)
    }, null)]]))])]), createVNode("div", {
      "class": this.ns.e("param-custom-button")
    }, [createVNode(resolveComponent("el-button"), {
      "size": "small",
      "onClick": () => this.changeIscustom()
    }, {
      default: () => ["".concat(this.isCustom ? "\u5173\u95ED" : "\u5F00\u542F", "\u81EA\u5B9A\u4E49")]
    }), this.readonly ? null : createVNode(resolveComponent("el-dropdown"), {
      "trigger": "click",
      "size": "small",
      "onCommand": this.addDynamicParam
    }, {
      default: () => createVNode(resolveComponent("el-button"), {
        "size": "small"
      }, {
        default: () => [createVNode("ion-icon", {
          "name": "add-outline"
        }, null)]
      }),
      dropdown: () => createVNode(resolveComponent("el-dropdown-menu"), null, {
        default: () => [createVNode(resolveComponent("el-dropdown-item"), {
          "command": "param"
        }, {
          default: () => [createTextVNode("\u53C2\u6570")]
        }), createVNode(resolveComponent("el-dropdown-item"), {
          "command": "srfnavparam"
        }, {
          default: () => [createTextVNode("\u89C6\u56FE\u53C2\u6570")]
        }), createVNode(resolveComponent("el-dropdown-item"), {
          "command": "srfnavctx"
        }, {
          default: () => [createTextVNode("\u89C6\u56FE\u4E0A\u4E0B\u6587")]
        })]
      })
    })])]);
  }
});

export { EditorParams as default };
