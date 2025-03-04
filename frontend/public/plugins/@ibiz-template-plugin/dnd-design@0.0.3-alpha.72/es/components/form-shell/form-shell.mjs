import { ref, watch, resolveComponent, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import './form-shell.css';

"use strict";
var IBizFormShell = /* @__PURE__ */ defineComponent({
  name: "IBizFormShell",
  props: {
    context: {
      type: Object,
      required: true
    },
    data: {
      type: Object,
      required: true
    },
    items: {
      type: Object,
      required: true
    }
  },
  setup(props) {
    const ns = useNamespace("form-shell");
    const shellNS = useNamespace("light-theme-shell");
    const modelData = ref();
    const transformTree = (original, transformFunc, parentNode) => {
      return original.map((item) => {
        const children = item.psdeformdetails ? transformTree(item.psdeformdetails, transformFunc, item) : [];
        const detail = transformFunc(item, parentNode);
        if (children.length > 0) {
          detail[detail.detailType === "TABPANEL" ? "deformTabPages" : "deformDetails"] = children;
        }
        return detail;
      });
    };
    const transformEditorParams = (val) => {
      if (!val) {
        return {};
      }
      const params = val.split("\n");
      const editorParams = {};
      params.forEach((param) => {
        const [key, value] = param.split("=");
        editorParams[key] = value;
      });
      return editorParams;
    };
    const getCustomEditorParams = (item) => {
      const type = item.editortype;
      const editorParams = {};
      if (!type) {
        return editorParams;
      }
      if (["CODE", "MARKDOWN"].includes(type)) {
        editorParams.customTheme = "light";
      }
      return editorParams;
    };
    const parseFormDetail = (data) => {
      const transform = (item, parent) => {
        var _a;
        let detail = {
          width: item.width,
          height: item.height,
          caption: item.caption,
          detailType: item.detailtype,
          id: item.psdeformdetailname,
          name: item.psdeformdetailname,
          appId: props.context.srfappid,
          codeName: item.psdeformdetailname,
          showCaption: item.showcaption !== 0,
          sysImage: {
            appId: props.context.srfappid,
            cssClass: item.pssysimagename
          },
          detailStyle: item.detailstyle,
          layout: {
            appId: props.context.srfappid,
            layout: item.layoutmode || (parent == null ? void 0 : parent.layoutmode) || item.playoutmode || "TABLE_24COL",
            // flex布局
            dir: item.flexdir,
            align: item.flexalign,
            valign: item.flexvalign
          },
          layoutPos: {
            appId: props.context.srfappid,
            layout: item.layoutmode || (parent == null ? void 0 : parent.layoutmode) || item.playoutmode || "TABLE_24COL",
            // 栅格布局
            colXS: item.col_xs || (parent == null ? void 0 : parent.child_col_xs),
            colXSOffset: item.col_xs_os,
            colSM: item.col_sm || (parent == null ? void 0 : parent.child_col_sm),
            colSMOffset: item.col_sm_os,
            colMD: item.col_md || (parent == null ? void 0 : parent.child_col_md),
            colMDOffset: item.col_md_os,
            colLG: item.col_lg || (parent == null ? void 0 : parent.child_col_lg),
            colLGOffset: item.col_lg_os,
            // flex布局
            basis: item.flexbasis,
            grow: item.flexgrow,
            shrink: item.flexshrink
          }
        };
        switch (detail.detailType) {
          case "FORMITEM":
            detail = {
              ...detail,
              emptyCaption: item.emptycaption,
              labelPos: item.labelpos || "LEFT",
              labelWidth: item.labelwidth,
              allowEmpty: item.allowempty !== 0,
              hidden: item.editortype === "HIDDEN",
              valueFormat: item.valueformat,
              // enableCond: item.enablecond,
              enableItemPriv: item.enableitempriv,
              resetItemNames: item.resetitemname ? item.resetitemname.split(";") : void 0,
              editor: {
                appId: props.context.srfappid,
                editorType: item.editortype || "TEXTBOX",
                placeHolder: item.placeholder,
                editorItems: item.valueitemname ? item.valueitemname.split(";") : void 0,
                editorHeight: item.ctrlheight,
                editorWidth: item.ctrlwidth,
                editorParams: {
                  enumOptions: [{
                    appId: props.context.srfappid,
                    text: "\u9009\u98791",
                    value: "option1"
                  }, {
                    appId: props.context.srfappid,
                    text: "\u9009\u98792",
                    value: "option2"
                  }],
                  ...transformEditorParams(item.editorparams),
                  ...getCustomEditorParams(item)
                }
              }
            };
            break;
          case "TABPAGE":
          case "TABPANEL":
          case "FORMPAGE":
          case "GROUPPANEL":
            detail = {
              ...detail,
              enableAnchor: item.enableanchor,
              captionItemName: item.valueitemname,
              titleBarCloseMode: item.titlebarclosemode
            };
            break;
          case "IFRAME":
            detail = {
              ...detail,
              iframeUrl: item.editorparams
            };
            break;
          case "RAWITEM":
            detail = {
              ...detail,
              rawItem: {
                appId: props.context.srfappid,
                contentType: item.contenttype,
                caption: item.rawcontent || "",
                content: item.htmlcontent || "",
                sysImage: {
                  appId: props.context.srfappid,
                  cssClass: item.pssysimagename
                }
              }
            };
            break;
          case "BUTTONLIST":
            detail = {
              ...detail,
              buttonListType: "UIACTIONGROUP",
              actionGroupExtractMode: "ITEM",
              uiactionGroup: {
                id: "buttonList",
                appId: props.context.srfappid,
                uiactionGroupDetails: [{
                  id: "button1",
                  uiactionId: "button1",
                  appId: props.context.srfappid,
                  caption: "\u6309\u94AE1",
                  showCaption: true
                }, {
                  id: "button2",
                  uiactionId: "button2",
                  appId: props.context.srfappid,
                  caption: "\u6309\u94AE2",
                  showCaption: true
                }]
              }
            };
            break;
          case "MDCTRL":
            detail = {
              ...detail,
              contentType: item.mdctrltype
            };
            break;
          case "FORMITEMEX":
            detail = {
              ...detail,
              detailType: "FORMITEM",
              emptyCaption: item.emptycaption,
              labelPos: item.labelpos || "LEFT",
              labelWidth: item.labelwidth,
              allowEmpty: item.allowempty !== 0,
              hidden: item.editortype === "HIDDEN",
              // enableCond: item.enablecond,
              enableItemPriv: item.enableitempriv,
              compositeItem: true,
              editor: {
                id: detail.id,
                appId: props.context.srfappid,
                editorType: item.editortype || "TEXTBOX",
                editorHeight: item.ctrlheight,
                editorWidth: item.ctrlwidth,
                editorParams: {
                  enumOptions: [{
                    appId: props.context.srfappid,
                    text: "\u9009\u98791",
                    value: "option1"
                  }, {
                    appId: props.context.srfappid,
                    text: "\u9009\u98792",
                    value: "option2"
                  }],
                  ...transformEditorParams(item.editorparams),
                  ...getCustomEditorParams(item)
                },
                editorItems: ((_a = item.psdeformdetails) == null ? void 0 : _a.map((editorItem) => {
                  return {
                    appId: props.context.srfappid,
                    id: editorItem.psdeformdetailname
                  };
                })) || []
              }
            };
            break;
          default:
            break;
        }
        return detail;
      };
      return transformTree(data, transform);
    };
    const init = async () => {
      const data = props.data;
      if (!data) {
        return;
      }
      const model = {
        controlType: data.formtype,
        appId: props.context.srfappid,
        codeName: data.codename,
        autoSaveMode: 0,
        navBarPos: data.navbarpos,
        navBarStyle: data.navbarstyle,
        navBarWidth: data.navbarwidth || 0,
        navbarHeight: data.navbarheight,
        navBarSysCss: {
          appId: props.context.srfappid,
          cssName: data.navbarpssyscssname
        },
        enableAutoSave: false,
        enableCustomized: false,
        infoFormMode: data.infoformflag,
        showFormNavBar: data.formnavbar,
        formFuncMode: data.funcmode,
        formStyle: data.formstyle,
        formWidth: data.formwidth,
        noTabHeader: data.showtabheader === 0,
        tabHeaderPos: data.tabheaderpos,
        logicName: data.psdeformname,
        deformPages: parseFormDetail(props.items),
        sysCss: {
          appId: props.context.srfappid,
          cssName: shellNS.b()
        },
        searchButtonStyle: data.formtype === "EDITFORM" ? void 0 : "SEARCHONLY"
      };
      modelData.value = model;
    };
    watch(() => props.items, () => {
      init();
    }, {
      immediate: true,
      deep: true
    });
    return {
      ns,
      shellNS,
      modelData
    };
  },
  render() {
    if (this.modelData) {
      return createVNode("div", {
        "class": this.ns.b()
      }, [this.modelData.controlType === "EDITFORM" ? createVNode(resolveComponent("iBizEditFormControl"), {
        "data": {},
        "isSimple": true,
        "class": [this.ns.m("light")],
        "modelData": this.modelData,
        "context": this.context
      }, null) : createVNode(resolveComponent("iBizSearchFormControl"), {
        "data": {},
        "isSimple": true,
        "class": [this.ns.m("light")],
        "modelData": this.modelData,
        "context": this.context
      }, null)]);
    }
    return null;
  }
});

export { IBizFormShell as default };
