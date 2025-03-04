import { resolveComponent, createVNode, createTextVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import dayjs from 'dayjs';
import '../../controller/index.mjs';
import './form-item.css';
import { DndItemController } from '../../controller/dnd-item-controller/dnd-item-controller.mjs';

"use strict";
var Component = /* @__PURE__ */ defineComponent({
  name: "IBizDndDesignFormItem",
  props: {
    controller: {
      type: DndItemController,
      required: true
    },
    formItemLabelWidth: {
      type: Number
    }
  },
  setup(props) {
    const ns = useNamespace("dnd-design-form-item");
    const getContentStyle = () => {
      const data = props.controller.data;
      if (data && data.rawcssstyle) {
        const res = data.rawcssstyle.split("\n");
        const target = [];
        for (let i = 0; i < res.length; i++) {
          target.push(...res[i].split(";").filter((value) => value));
        }
        return target.filter((value) => {
          return value.split(":").length === 2;
        }).join(";");
      }
    };
    const renderDefaultField = () => {
      const data = props.controller.data;
      return createVNode(resolveComponent("el-input"), {
        "placeholder": data.srftext,
        "disabled": true
      }, null);
    };
    const renderDesignItem = () => {
      const data = props.controller.data;
      const contentStyle = getContentStyle();
      const text = "".concat(data.srftext);
      const curDate = /* @__PURE__ */ new Date();
      if (data) {
        switch (data.editortype) {
          case "HIDDEN":
            return createVNode("div", {
              "style": "padding-left: 10px;",
              "class": "design-item-hidden"
            }, [createTextVNode("\u9690\u85CF\u8868\u5355\u9879")]);
          case "SPAN":
            return createVNode("span", {
              "style": "padding-left: 10px;".concat(contentStyle),
              "class": "design-design-editor"
            }, [text]);
          case "RADIOBUTTONLIST":
            return createVNode(resolveComponent("el-radio-group"), {
              "model-value": "",
              "disabled": true
            }, {
              default: () => [createVNode(resolveComponent("el-radio"), {
                "label": "1"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E00")]
              }), createVNode(resolveComponent("el-radio"), {
                "label": "2"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E8C")]
              }), createVNode(resolveComponent("el-radio"), {
                "label": "3"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E09")]
              })]
            });
          case "ADDRESSPICKUP":
          case "ADDRESSPICKUP_AC":
            return createVNode(resolveComponent("el-select"), {
              "mode": "tags",
              "style": "width: 100%",
              "placeholder": text,
              "disabled": true
            }, {
              default: () => [createVNode(resolveComponent("el-option"), {
                "value": "1"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E00")]
              }), createVNode(resolveComponent("el-option"), {
                "value": "2"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E8C")]
              }), createVNode(resolveComponent("el-option"), {
                "value": "3"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E09")]
              })]
            });
          case "TEXTAREA":
            return createVNode(resolveComponent("el-input"), {
              "placeholder": text,
              "style": data.ctrlheight ? "height: ".concat(data.ctrlheight, "px;") : "",
              "class": ns.e("textarea"),
              "type": "textarea",
              "rows": 1,
              "disabled": true
            }, null);
          case "TEXTAREA_10":
            return createVNode(resolveComponent("el-input"), {
              "placeholder": text,
              "rows": 10,
              "type": "textarea",
              "disabled": true
            }, null);
          case "PASSWORD":
            return createVNode(resolveComponent("el-input"), {
              "placeholder": text,
              "disabled": true
            }, null);
          case "DATEPICKEREX":
            return createVNode(resolveComponent("el-date-picker"), {
              "class": ns.e("datepicker"),
              "model-value": dayjs(curDate).format("YYYY-MM-DD HH:mm:ss"),
              "format": "YYYY-MM-DD HH:mm:ss",
              "disabled": true
            }, null);
          case "DATEPICKEREX_MINUTE":
            return createVNode(resolveComponent("el-date-picker"), {
              "class": ns.e("datepicker"),
              "model-value": dayjs(curDate).format("YYYY-MM-DD HH:mm"),
              "format": "YYYY-MM-DD HH:mm",
              "disabled": true
            }, null);
          case "DATEPICKEREX_SECOND":
            return createVNode(resolveComponent("el-date-picker"), {
              "class": ns.e("datepicker"),
              "model-value": dayjs(curDate).format("YYYY-MM-DD HH:mm:ss"),
              "format": "YYYY-MM-DD HH:mm:ss",
              "disabled": true
            }, null);
          case "DATEPICKEREX_NODAY":
            return createVNode(resolveComponent("el-date-picker"), {
              "class": ns.e("datepicker"),
              "model-value": curDate,
              "format": "HH:mm:ss",
              "disabled": true
            }, null);
          case "DATEPICKEREX_NODAY_NOSECOND":
            return createVNode(resolveComponent("el-date-picker"), {
              "class": ns.e("datepicker"),
              "model-value": curDate,
              "format": "HH:mm",
              "disabled": true
            }, null);
          case "DATEPICKEREX_NOTIME":
            return createVNode(resolveComponent("el-date-picker"), {
              "class": ns.e("datepicker"),
              "model-value": dayjs(curDate).format("YYYY-MM-DD"),
              "format": "YYYY-MM-DD",
              "disabled": true
            }, null);
          case "DATEPICKEREX_HOUR":
            return createVNode(resolveComponent("el-date-picker"), {
              "class": ns.e("datepicker"),
              "model-value": dayjs(curDate).format("YYYY-MM-DD HH"),
              "format": "YYYY-MM-DD HH",
              "disabled": true
            }, null);
          case "DATEPICKER":
            return createVNode(resolveComponent("el-date-picker"), {
              "class": ns.e("datepicker"),
              "model-value": dayjs(curDate).format("YYYY-MM-DD HH:mm:ss"),
              "format": "YYYY-MM-DD HH:mm:ss",
              "disabled": true
            }, null);
          case "TEXTBOX":
            return createVNode(resolveComponent("el-input"), {
              "style": contentStyle,
              "placeholder": text,
              "disabled": true
            }, null);
          case "FILEUPLOADER":
            return createVNode(resolveComponent("el-button"), {
              "disabled": true,
              "class": ns.e("fileuploader")
            }, {
              default: () => [createVNode("ion-icon", {
                "name": "cloud-upload-outline"
              }, null), text]
            });
          case "AC":
          case "AC_NOBUTTON":
          case "AC_FS_NOBUTTON":
          case "AC_FS":
          case "PICKEREX_LINKONLY":
          case "PICKER":
          case "PICKUPVIEW":
          case "PICKEREX_LINK":
          case "PICKEREX_NOAC_LINK":
          case "PICKEREX_NOAC":
          case "PICKEREX_NOBUTTON":
          case "PICKEREX_TRIGGER_LINK":
          case "PICKEREX_TRIGGER":
          case "DROPDOWNLIST":
            return createVNode(resolveComponent("el-select"), {
              "model-value": "\u9009\u9879\u4E00",
              "style": "width: 100%",
              "disabled": true
            }, {
              default: () => [createVNode(resolveComponent("el-option"), {
                "value": "\u9009\u9879\u4E00"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E00")]
              }), createVNode(resolveComponent("el-option"), {
                "value": "\u9009\u9879\u4E8C"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E8C")]
              }), createVNode(resolveComponent("el-option"), {
                "value": "\u9009\u9879\u4E09"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E09")]
              })]
            });
          case "MDROPDOWNLIST":
            return createVNode(resolveComponent("el-select"), {
              "model-value": "\u9009\u9879\u4E00",
              "style": "width: 100%",
              "disabled": true
            }, {
              default: () => [createVNode(resolveComponent("el-option"), {
                "value": "\u9009\u9879\u4E00"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E00")]
              }), createVNode(resolveComponent("el-option"), {
                "value": "\u9009\u9879\u4E8C"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E8C")]
              }), createVNode(resolveComponent("el-option"), {
                "value": "\u9009\u9879\u4E09"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E09")]
              })]
            });
          case "DROPDOWNLIST_100":
            return createVNode(resolveComponent("el-select"), {
              "model-value": "\u9009\u9879\u4E00",
              "style": "width: 100px",
              "disabled": true
            }, {
              default: () => [createVNode(resolveComponent("el-option"), {
                "value": "\u9009\u9879\u4E00"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E00")]
              }), createVNode(resolveComponent("el-option"), {
                "value": "\u9009\u9879\u4E8C"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E8C")]
              }), createVNode(resolveComponent("el-option"), {
                "value": "\u9009\u9879\u4E09"
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E09")]
              })]
            });
          case "CHECKBOX":
            return createVNode(resolveComponent("el-checkbox"), {
              "disabled": true
            }, {
              default: () => [createTextVNode("\u9009\u9879")]
            });
          case "CHECKBOXLIST":
            return createVNode(resolveComponent("el-checkbox-group"), {
              "disabled": true
            }, {
              default: () => [createVNode(resolveComponent("el-checkbox"), {
                "disabled": true
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E00")]
              }), createTextVNode(";"), createVNode(resolveComponent("el-checkbox"), {
                "disabled": true
              }, {
                default: () => [createTextVNode("\u9009\u9879\u4E8C")]
              }), createTextVNode(";")]
            });
          case "NUMBER":
            return createVNode(resolveComponent("el-input-number"), {
              "class": ns.e("number"),
              "style": "width: 100%",
              "disabled": true
            }, null);
          case "USERCONTROL":
            return createVNode("span", null, [createTextVNode("\u7528\u6237\u81EA\u5B9A\u4E49")]);
          case "RATING":
            return createVNode(resolveComponent("el-rate"), {
              "text-color": "#ff9900",
              "model-value": 4,
              "disabled": true
            }, null);
          case "SLIDER":
            return createVNode(resolveComponent("el-slider"), {
              "model-value": 30,
              "show-input": true,
              "class": ns.e("slider")
            }, null);
          case "DATERANGE":
            return createVNode(resolveComponent("el-date-picker"), {
              "model-value": [curDate, curDate],
              "type": "datetimerange",
              "range-separator": "\u81F3",
              "start-placeholder": "\u5F00\u59CB\u65E5\u671F",
              "end-placeholder": "\u7ED3\u675F\u65E5\u671F",
              "format": "YYYY-MM-DD HH:mm:ss",
              "disabled": true,
              "class": ns.e("daterange")
            }, null);
          case "ARRAY":
            return createVNode("div", {
              "class": ns.e("panel-array-input")
            }, [createVNode(resolveComponent("el-input"), {
              "placeholder": text,
              "disabled": true
            }, null), createVNode(resolveComponent("el-button"), {
              "type": "primary",
              "circle": true,
              "class": ns.e("panel-array-input-add-button")
            }, {
              default: () => [createVNode("ion-icon", {
                "name": "add-outline"
              }, null)]
            }), createVNode(resolveComponent("el-button"), {
              "type": "danger",
              "circle": true,
              "class": ns.e("panel-array-input-remove-button")
            }, {
              default: () => [createVNode("ion-icon", {
                "name": "remove-outline"
              }, null)]
            })]);
          case "MAPPICKER":
            return createVNode(resolveComponent("el-cascader"), {
              "class": ns.e("mappicker"),
              "options": [{
                value: "\u7701",
                label: "\u7701",
                children: [{
                  value: "\u5E02",
                  label: "\u5E02",
                  children: [{
                    value: "\u533A",
                    label: "\u533A"
                  }]
                }]
              }],
              "model-value": ["\u7701", "\u5E02", "\u533A"],
              "disabled": true
            }, null);
          case "SWITCH":
            return createVNode(resolveComponent("el-switch"), {
              "disabled": true
            }, null);
          default:
            return renderDefaultField();
        }
      }
      return renderDefaultField();
    };
    const getFormCtrlStyle = (tag, labelPos) => {
      let style = "";
      if (Object.is(labelPos, "none") || Object.is(labelPos, "top") || Object.is(labelPos, "bottom") || tag.showcaption === "0") {
        if (tag.ctrlwidth) {
          style += "width: ".concat(tag.ctrlwidth, "px;");
        } else {
          style += "width: 100%;";
        }
      } else if (tag.ctrlwidth) {
        style += "width: ".concat(tag.ctrlwidth, "px;");
      } else {
        style += "width: calc(100% - ".concat(tag.labelwidth || props.formItemLabelWidth || 130, "px);");
      }
      if (tag.ctrlheight) {
        style += "height: ".concat(tag.ctrlheight, "px;");
      } else {
        style += "height: 100%;";
      }
      return style;
    };
    const renderContent = () => {
      const data = props.controller.data;
      const caption = props.controller.getItemCaption();
      const tag = data;
      const labelPos = tag.labelpos ? tag.labelpos.toLowerCase() : "left";
      const labelStyle = Object.is(labelPos, "top") || Object.is(labelPos, "bottom") ? "" : "width: ".concat(tag.labelwidth || props.formItemLabelWidth || 130, "px;");
      const ctrlStyle = getFormCtrlStyle(tag, labelPos);
      if (tag.itemtype === "FIELD") {
        return createVNode("div", {
          "class": "design-form-item ".concat(labelPos || "left")
        }, [createVNode("div", {
          "class": ns.e("container-content"),
          "style": {
            width: "100%",
            height: "100%"
          }
        }, [renderDesignItem()])]);
      }
      return createVNode("div", {
        "class": "".concat(ns.e("item-content"), " ").concat(ns.em("item-content", labelPos || "left"))
      }, [tag.showcaption == "0" ? null : createVNode("div", {
        "class": ns.e("label-content"),
        "style": labelStyle
      }, [tag.emptycaption == "1" ? null : createVNode("label", {
        "class": ns.e("label")
      }, [Object.is(labelPos, "right") ? "\uFF1A" : "", caption || "", !Object.is(labelPos, "right") ? "\uFF1A" : ""])]), createVNode("div", {
        "class": ns.e("container-content"),
        "style": ctrlStyle
      }, [renderDesignItem()])]);
    };
    return {
      ns,
      renderDesignItem,
      renderContent
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b()
    }, [createVNode("div", {
      "class": this.ns.e("wrapper")
    }, null), this.renderContent()]);
  }
});

export { Component as default };
