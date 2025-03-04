import { isVNode, renderSlot, createVNode, resolveComponent, h, defineComponent } from 'vue';
import { ScriptFactory, findChildFormDetails, ControlType } from '@ibiz-template/runtime';
import { useNamespace } from '@ibiz-template/vue3-util';
import './memo-form.css';

"use strict";
function _isSlot(s) {
  return typeof s === "function" || Object.prototype.toString.call(s) === "[object Object]" && !isVNode(s);
}
const MemoFormControl = /* @__PURE__ */ defineComponent({
  name: "IBizMemoFormControl",
  props: {
    controller: {
      type: Object,
      required: true
    }
  },
  setup(props, {
    slots
  }) {
    const ns = useNamespace("memo-form");
    const c = props.controller;
    const slotProps = {
      form: c
    };
    const renderAttrs = (model) => {
      var _a;
      const attrs = {};
      (_a = model.controlAttributes) == null ? void 0 : _a.forEach((item) => {
        if (item.attrName && item.attrValue) {
          attrs[item.attrName] = ScriptFactory.execSingleLine(item.attrValue, {
            ...props.controller.getEventArgs(),
            data: props.controller.data
          });
        }
      });
      return attrs;
    };
    const renderByDetailType = (detail, hidden = true) => {
      if (detail.hidden) {
        return;
      }
      const detailId = detail.id;
      if (slots[detailId]) {
        return renderSlot(slots, detailId, {
          model: detail,
          data: c.state.data,
          value: c.state.data[detailId]
        });
      }
      const childSlots = {};
      if (detail.detailType === "FORMITEM" && slots["".concat(detailId, "_editor")]) {
        childSlots.default = (...args) => {
          return slots["".concat(detailId, "_editor")](...args);
        };
      }
      const childDetails = findChildFormDetails(detail);
      if (childDetails.length) {
        childSlots.default = () => childDetails.map((child) => {
          return renderByDetailType(child);
        });
      }
      const provider = c.providers[detailId];
      if (!provider) {
        return createVNode("div", null, [ibiz.i18n.t("control.form.noSupportDetailType", {
          detailType: detail.detailType
        })]);
      }
      const component = resolveComponent(provider.component);
      if (detail.detailType === "FORMITEM" && hidden) {
        const formItem = detail;
        if (formItem.editor && formItem.editor.editorType === "TEXTAREA" && formItem.codeName === "memo") {
          return;
        }
      }
      return h(component, {
        modelData: detail,
        controller: c.details[detailId],
        key: detail.id,
        attrs: renderAttrs(detail)
      }, childSlots);
    };
    const FormDetail = (_props) => {
      const {
        modelData
      } = _props;
      const detailModels = modelData instanceof Array ? modelData : [modelData];
      return detailModels.map((detail) => {
        return renderByDetailType(detail);
      });
    };
    FormDetail.props = ["modelData"];
    slotProps.FormDetail = FormDetail;
    return {
      ns,
      c,
      FormDetail,
      slotProps,
      renderByDetailType,
      renderAttrs
    };
  },
  render() {
    const {
      state,
      model,
      controlPanel
    } = this.c;
    const {
      isCreated
    } = state;
    const slots = {};
    if (isCreated) {
      if (this.$slots.default) {
        slots.default = () => {
          return this.$slots.default({
            ...this.slotProps
          });
        };
      } else {
        const formSlotKey = model.controlType === ControlType.SEARCHFORM ? "searchform" : "form";
        const key = controlPanel ? formSlotKey : "default";
        let memo;
        this.c.formItems.some((item) => {
          const model2 = item.model;
          if (model2.detailType === "FORMITEM") {
            if (model2.editor && model2.editor.editorType === "TEXTAREA" && model2.codeName === "memo") {
              memo = model2;
              return true;
            }
          }
        });
        slots[key] = () => {
          return [createVNode("div", {
            "class": this.ns.b("container")
          }, [createVNode("div", {
            "class": this.ns.b("content")
          }, [createVNode(resolveComponent("iBizFormPage"), {
            "modelData": this.c.model,
            "controller": this.c
          }, {
            default: () => {
              var _a;
              return [(_a = this.c.model.deformPages) == null ? void 0 : _a.map((page) => {
                return this.renderByDetailType(page);
              })];
            }
          })]), createVNode("div", {
            "class": this.ns.b("footer")
          }, [memo && createVNode(resolveComponent("iBizFormItem"), {
            "modelData": memo,
            "controller": this.c.details[memo.id],
            "key": memo.id,
            "attrs": this.renderAttrs(memo)
          }, {
            default: (editorProps) => {
              const component = resolveComponent("IBizMarkdownMemoEditor");
              return h(component, {
                ...editorProps
              });
            }
          })])])];
        };
      }
    }
    return createVNode(resolveComponent("iBizControlBase"), {
      "class": [this.ns.b()],
      "controller": this.c
    }, _isSlot(slots) ? slots : {
      default: () => [slots]
    });
  }
});

export { MemoFormControl };
