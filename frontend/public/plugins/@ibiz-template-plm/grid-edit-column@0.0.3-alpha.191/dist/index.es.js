import './style.css';
var Ce = Object.defineProperty;
var ge = (e, u, t) => u in e ? Ce(e, u, { enumerable: !0, configurable: !0, writable: !0, value: t }) : e[u] = t;
var U = (e, u, t) => (ge(e, typeof u != "symbol" ? u + "" : u, t), t);
import { useClickOutside as ee, useNamespace as H, useUIStore as be, withInstall as te } from "@ibiz-template/vue3-util";
import { Srfuf as O, GridFieldEditColumnController as Ee, GridRowState as Ie, UIActionUtil as oe, SysUIActionTag as W, TreeGridExNodeColumnController as pe, TreeGridExRowState as ie, TreeGridExFieldColumnController as ne, registerGridColumnProvider as ye, registerTreeGridExColumnProvider as Te } from "@ibiz-template/runtime";
import { computed as i, ref as p, reactive as k, defineComponent as X, watch as Pe, createVNode as s, resolveComponent as b, onMounted as le, h as K, isVNode as Re } from "vue";
import { isNotNil as se, isNil as xe } from "ramda";
import { RuntimeError as re } from "@ibiz-template/core";
function Le(e, u) {
  const t = e.controller, h = i(() => e.row.editColStates[t.fieldName].disabled), n = i(() => e.row.editColStates[t.fieldName].readonly), d = i(() => !!e.row.errors[t.fieldName]), m = i(
    () => e.row.editColStates[t.fieldName].editable
  ), o = (C) => {
    e.row.editColStates[t.fieldName].editable = C;
  }, a = i(() => !h.value && !n.value && !d.value), r = i(() => d.value || a.value && m.value), f = i(() => !r.value), v = !1, E = !0, T = i(() => a.value && !m.value), x = i(() => m.value);
  let y;
  const P = () => {
    o(!0), y = ee(u, async (C) => {
      o(!1), y.stop();
    });
  }, A = () => {
    y && y.stop(), ibiz.log.debug("".concat(t.fieldName, "属性编辑器focus事件"));
  };
  let L = e.row.data[t.fieldName];
  const D = p(!1), N = async () => {
    var C;
    ibiz.log.debug("".concat(t.fieldName, "属性编辑器blur事件")), !(D.value || t.hasDropdown) && (o(!1), ((C = t.model.userParam) == null ? void 0 : C.SAVEMODE) === "BLUR" ? t.grid.save(e.row.data) : e.row.data.srfuf === O.CREATE ? (e.row.modified || t.grid.remove({ data: [e.row.data], silent: !0 }), await t.grid.save(e.row.data)) : t.setRowValue(e.row, L));
  }, M = async () => {
    t.setPickerValue(e.row), D.value = !0, ibiz.log.debug("".concat(t.fieldName, "属性编辑器enter事件")), e.row.data.srfuf === O.CREATE && (e.row.modified || t.grid.remove({ data: [e.row.data], silent: !0 })), await t.grid.save(e.row.data), L = e.row.data[t.fieldName], o(!1), D.value = !1;
  }, z = (C) => {
    C.keyCode === 27 && o(!1);
  }, c = k({
    showEditMask: T,
    stopPropagation: x
  }), g = k({
    autoFocus: E,
    disabled: v,
    readonly: f,
    cellEditable: a,
    onFocus: A,
    onBlur: N,
    onEnter: M,
    onKeydown: z
  });
  return {
    gridEditItemProps: c,
    editorProps: g,
    onMaskClick: P
  };
}
function Se(e, u) {
  const t = e.controller, h = i(() => e.row.editColStates[t.fieldName].disabled), n = i(() => e.row.editColStates[t.fieldName].readonly), d = i(
    () => e.row.editColStates[t.fieldName].editable
  ), m = i(() => n.value || !d.value), o = i(() => d.value && h.value), a = i(() => d.value), r = k({
    stopPropagation: a
  }), f = k({
    disabled: o,
    readonly: m
  });
  return {
    gridEditItemProps: r,
    editorProps: f
  };
}
function ke(e, u) {
  const t = e.controller, h = i(() => e.row.editColStates[t.fieldName].disabled), n = i(() => e.row.editColStates[t.fieldName].readonly), d = i(() => e.controller.grid.state.rowEditOpen), m = i(() => n.value || !d.value), o = i(() => d.value && h.value), a = i(() => d.value), r = () => {
    t.grid.save(e.row.data);
  }, f = k({
    stopPropagation: a
  }), v = k({
    disabled: o,
    readonly: m,
    onBlur: r
  });
  return {
    gridEditItemProps: f,
    editorProps: v
  };
}
class ae extends Ee {
  constructor() {
    super(...arguments);
    /**
     * 用户代码表
     *
     * @type {(IAppCodeList | undefined)}
     * @memberof GridEditColumnController
     */
    U(this, "userCodeList");
    /**
     * 是否拥有下拉
     *
     * @type {boolean}
     * @memberof GridEditColumnController
     */
    U(this, "hasDropdown", !1);
    /**
     * 当前选项id
     *
     * @type {string}
     * @memberof GridEditColumnController
     */
    U(this, "curPickerId", "");
  }
  /**
   * 加载用户代码表
   *
   * @param {IData} data
   * @return {*}  {Promise<readonly}
   * @memberof GridEditColumnController
   */
  async loadUserCodeList(t) {
    if (t.codelistTag) {
      const h = ibiz.hub.getApp(this.context.srfappid), n = await h.codeList.get(
        t.codelistTag,
        this.context,
        this.params
      );
      this.userCodeList = h.codeList.getCodeList(t.codelistTag);
      const d = (t.pickerData || "").split(",");
      return this.hasDropdown = !0, n.filter((m) => d.includes(m.id));
    }
    return [];
  }
  /**
   * 设置选中数据
   *
   * @param {IData} data
   * @return {*}  {Promise<readonly}
   * @memberof GridEditColumnController
   */
  setPickerValue(t) {
    const { srfuf: h } = t.data;
    if (h === O.CREATE) {
      const n = t.data.srfUserData;
      n && n.pickerField && (t.data[n.pickerField] = this.curPickerId);
    }
  }
}
const de = /* @__PURE__ */ X({
  name: "IBizEditColumnActionToolbar",
  props: {
    actionDetails: {
      type: Array,
      required: !0
    },
    actionsState: {
      type: Object,
      required: !0
    },
    caption: String,
    mode: {
      type: String,
      default: "buttons"
    },
    // 分组的行为级别
    groupLevelKeys: {
      type: Array,
      default: () => [50]
    },
    editColums: {
      type: Object,
      required: !0
    },
    showCommonAction: {
      type: Boolean,
      default: !0
    },
    zIndex: Number,
    popperClass: String
  },
  emits: ["saveAll", "actionClick"],
  setup(e, {
    emit: u
  }) {
    var F;
    const t = H("edit-column-action-toolbar"), h = H("edit-column-action-toolbar"), n = p(!1), d = p(!1), m = p(!1), o = p(), a = p(), r = p(!1);
    (F = e.actionDetails) == null || F.forEach((w) => {
      w.capLanguageRes && w.capLanguageRes.lanResTag && (w.caption = ibiz.i18n.t(w.capLanguageRes.lanResTag, w.caption)), w.tooltipLanguageRes && w.tooltipLanguageRes.lanResTag && (w.tooltip = ibiz.i18n.t(w.tooltipLanguageRes.lanResTag, w.tooltip));
    });
    const f = p([]), v = p([]), E = () => {
      v.value = [], f.value = [], e.actionDetails && e.actionDetails.forEach((w) => {
        !e.showCommonAction && w.actionLevel === 200 || (e.groupLevelKeys.findIndex((V) => V === w.actionLevel) !== -1 ? v.value.push(w) : f.value.push(w));
      });
    };
    Pe(() => e.showCommonAction, () => {
      E();
    }, {
      immediate: !0
    });
    const T = (w) => {
      w.stopPropagation(), d.value = !0;
    }, x = () => {
      d.value = !1;
    }, y = () => {
      m.value = !0;
    }, P = () => {
      m.value = !1;
    }, A = () => {
      r.value = !0;
    }, L = () => {
      r.value = !1;
    }, D = () => {
      P(), d.value = !1;
    }, N = async (w, V) => {
      V.stopPropagation(), u("actionClick", w, V);
    }, M = (w) => {
      const {
        actionLevel: V
      } = w;
      return [t.e("item"), t.is("disabled", !1), t.em("item", "level-".concat(V)), t.is("level-".concat(V), !0)];
    }, z = () => {
      m.value || (d.value = !1);
    }, c = (w) => {
      w.stopPropagation(), w.preventDefault();
    };
    let g;
    return {
      ns: t,
      ns2: h,
      actionRef: a,
      childLevelRef: o,
      expandDetails: f,
      groupDetails: v,
      popoverVisible: n,
      topLevelVisible: d,
      handleClick: N,
      openTopLevel: T,
      closeTopLevel: x,
      openChildLevel: y,
      closeChildLevel: P,
      closeAllPopover: D,
      openProcessing: A,
      closeProcessing: L,
      onChildLevelClick: c,
      onTopLevelPopHide: () => {
        g == null || g.stop(), u("saveAll");
      },
      onTopLevelPopShow: () => {
        const w = o.value;
        g = ee(a, () => {
          r.value || z();
        }, {
          ignore: [w]
        });
      },
      calcActionItemClass: M
    };
  },
  render() {
    var m;
    const {
      $slots: e
    } = this, u = () => {
      const o = this.editColums.map((a) => {
        const {
          caption: r
        } = a.model, f = a.model.sysImage || {
          cssClass: "fa fa-bars"
        };
        return s(b("el-popover"), {
          placement: "right-start",
          width: "280",
          teleported: !1,
          offset: 16,
          trigger: "click"
        }, {
          reference: () => s("div", {
            class: this.ns.bem("popper", "action-group", "edit-column")
          }, [s("div", {
            class: this.ns.bem("popper", "action-group", "icon")
          }, [s(b("iBizIcon"), {
            icon: f
          }, null)]), s("span", null, [r])]),
          default: () => s("div", {
            onMouseenter: this.openChildLevel,
            onMouseleave: this.closeChildLevel,
            ref: "childLevelRef",
            onClick: (v) => this.onChildLevelClick(v)
          }, [e.editor && (e == null ? void 0 : e.editor(a))])
        });
      });
      return o.length > 0 ? s("div", {
        class: this.ns.be("popper", "edit-group")
      }, [o]) : null;
    }, t = (o) => s(b("el-divider"), {
      class: this.ns.e("separator"),
      "border-style": "double",
      direction: o ? "vertical" : "horizontal"
    }, null), h = (o, a = !0) => [o.addSeparator && t(a), s(b("el-button"), {
      text: !0,
      size: "small",
      onClick: (r) => this.handleClick(o, r),
      title: o.tooltip,
      disabled: this.actionsState[o.id].disabled,
      class: this.calcActionItemClass(o)
    }, {
      default: () => [s("div", {
        class: [this.ns.em("item", "icon"), this.ns.is("has-caption", o.showCaption && !!o.caption), this.ns.is("has-icon", o.showIcon && !!o.sysImage)]
      }, [o.showIcon && o.sysImage && s(b("iBizIcon"), {
        icon: o.sysImage
      }, null)]), s("div", {
        class: [this.ns.em("item", "label"), this.ns.is("has-caption", o.showCaption && !!o.caption), this.ns.is("has-icon", o.showIcon && !!o.sysImage)]
      }, [o.showCaption ? o.caption : ""])]
    })], n = (o, a = !0) => {
      if (a)
        return o.map((v) => {
          var E;
          return (E = this.actionsState[v.id]) != null && E.visible ? h(v, a) : null;
        });
      let r = null;
      const f = [];
      return o.forEach((v) => {
        v.uiactionId && v.uiactionId.includes("get_editor_column") ? r = u() : this.actionsState[v.id].visible && f.push(h(v, a));
      }), s("div", {
        class: this.ns.be("popper", "action-group"),
        ref: "actionRef"
      }, [r, ...f]);
    }, d = () => {
      if (this.groupDetails.length === 0 || !(this.groupDetails.findIndex((r) => this.actionsState[r.id].visible === !0) !== -1))
        return null;
      const a = this.groupDetails.findIndex((r) => this.actionsState[r.id].disabled === !1) === -1;
      return s(b("el-popover"), {
        width: "280",
        disabled: a,
        placement: "right-start",
        visible: this.topLevelVisible,
        "popper-class": this.ns.b("popper"),
        "popper-style": {
          zIndex: this.zIndex
        },
        onShow: () => {
          this.onTopLevelPopShow();
        },
        onHide: () => {
          this.onTopLevelPopHide();
        }
      }, {
        reference: () => s(b("el-button"), {
          size: "small",
          text: !0,
          disabled: a,
          onClick: this.openTopLevel,
          class: [this.ns.e("item"), this.ns.is("group-button", !0), this.ns.is("expand", this.topLevelVisible)]
        }, {
          icon: () => s(b("ion-icon"), {
            class: this.ns.e("icon"),
            name: "ellipsis-vertical",
            title: ibiz.i18n.t("component.actionToolbar.more")
          }, null)
        }),
        default: () => n(this.groupDetails, !1)
      });
    };
    if ((m = this.actionsState) != null && m.visible)
      return s("div", {
        class: [this.ns.b(), this.ns.m("buttons")],
        onClick: (o) => o.stopPropagation()
      }, [n(this.expandDetails), d()]);
  }
}), ce = [
  "TEXTBOX",
  "PASSWORD",
  "TEXTAREA",
  "TEXTAREA_10",
  "NUMBER",
  "SOLIDER",
  "STEPPER"
];
function Ae(e) {
  return typeof e == "function" || Object.prototype.toString.call(e) === "[object Object]" && !Re(e);
}
const J = /* @__PURE__ */ X({
  name: "GridEditColumn",
  props: {
    controller: {
      type: ae,
      required: !0
    },
    row: {
      type: Ie,
      required: !0
    }
  },
  setup(e) {
    var Z;
    const u = H("grid-edit-column"), t = p(), h = p(), n = e.controller, d = (Z = n.editItem) == null ? void 0 : Z.codeName, {
      zIndex: m
    } = e.controller.grid.state, o = p([]), a = p("");
    let r = !1;
    const f = e.row.data.srfUserData;
    (async () => {
      const {
        srfuf: l
      } = e.row.data;
      l === O.CREATE && f && (o.value = await n.loadUserCodeList(f), a.value = f.defaultValue, n.curPickerId = f.defaultValue);
    })();
    const E = i(() => !(n.grid.model.controlType === "TREEGRID" && !n.grid.state.showTreeGrid)), T = () => {
      var l;
      (l = t.value) == null || l.closeAllPopover();
    }, x = async (l, I) => {
      await n.setRowValue(e.row, l, I);
    }, y = () => {
      switch (ibiz.config.grid.editShowMode) {
        case "cell":
          return Le(e, h);
        case "row":
          return Se(e);
        case "all":
          return ke(e);
        default:
          throw new re("".concat(ibiz.config.grid.editShowMode, "暂未支持"));
      }
    }, {
      gridEditItemProps: P,
      editorProps: A
    } = y(), L = (l) => {
      e.row.editColStates[n.fieldName].editable = l;
    };
    le(() => {
      e.row.data.srfuf === O.CREATE && L(!0);
    });
    const D = (l) => {
      e.controller.hasAction && (l.stopPropagation(), e.controller.triggerAction(e.row, l));
    }, N = (l) => {
      e.controller.isLinkColumn && (l.stopPropagation(), e.controller.openLinkView(e.row, l));
    }, M = i(() => n.getCustomHtml(e.row)), z = Object.values(n.grid.columns).filter((l) => l.enableRowEdit && l.model.id !== n.model.id), c = i(() => e.row.data[e.controller.model.codeName.toLowerCase()]), g = i(() => n.formatValue(c.value)), C = p(void 0), G = (l) => {
      C.value = l;
    }, F = i(() => {
      if (e.controller.grid.overflowMode === "ellipsis" && se(c.value) && c.value !== "")
        return C.value ? C.value : g.value + (e.controller.model.unitName || "");
    }), w = async (l, I) => {
      var _, $, q, j;
      I.stopPropagation(), (_ = t.value) == null || _.openProcessing();
      const R = {
        context: n.context,
        params: n.params,
        data: [e.row.data],
        view: n.grid.view,
        event: I
      }, S = await oe.exec(l.uiactionId, R, l.appId);
      if (($ = t.value) == null || $.closeProcessing(), S.cancel || T(), S.closeView)
        R.view.modal.ignoreDismissCheck = !0, R.view.closeView({
          ok: !0
        });
      else if (S.refresh)
        switch (S.refreshMode) {
          case 1:
            R.view.callUIAction(W.REFRESH);
            break;
          case 2:
            (q = R.view.parentView) == null || q.callUIAction(W.REFRESH);
            break;
          case 3:
            (j = R.view.getTopView()) == null || j.callUIAction(W.REFRESH);
            break;
        }
    }, V = async (l, I, R) => {
      const S = R || l.editItem.codeName;
      await n.setRowValue(e.row, I, S);
      const _ = l.editor.model.editorType;
      ce.includes(_) || T();
    }, Y = () => {
      T(), n.grid.saveAll();
    }, B = (l) => {
      var $, q;
      const I = l.editItem.codeName, R = e.row.data[I], S = ($ = e.row.editColStates[I]) == null ? void 0 : $.readonly, _ = (q = e.row.editColStates[I]) == null ? void 0 : q.disabled;
      return l.editorProvider && K(b(l.editorProvider.gridEditor), {
        class: u.e("editor"),
        value: S ? l.formatValue(R) : R,
        data: e.row.data,
        controller: l.editor,
        overflowMode: n.grid.overflowMode,
        // eslint-disable-next-line no-shadow
        onChange: (j, we) => V(l, j, we),
        // eslint-disable-next-line @typescript-eslint/no-unused-vars
        onEnter: (j) => Y(),
        readonly: S,
        disabled: _
      });
    }, ue = (l) => {
      l.stopPropagation(), L(!0);
    }, me = () => {
      n.grid.saveAll();
    }, he = () => {
      const {
        enableRowEdit: l,
        deuiactionGroup: I
      } = n.model, R = [];
      return l && R.push(s(b("el-button"), {
        text: !0,
        size: "small",
        class: "hover-action",
        onClick: (S) => ue(S),
        title: "编辑"
      }, {
        default: () => [s("svg", {
          viewBox: "0 0 16 16",
          xmlns: "http://www.w3.org/2000/svg",
          height: "1em",
          width: "1em",
          preserveAspectRatio: "xMidYMid meet",
          focusable: "false"
        }, [s("g", {
          id: "aiuaction/edit",
          "stroke-width": "1",
          "fill-rule": "evenodd"
        }, [s("path", {
          d: "M2 8.34L10.71 0 15 4.17 6.538 13H2V8.34zm1.2.512V11.8h2.826l7.283-7.6-2.606-2.533L3.2 8.852zM0 16v-1.2h16V16H0z",
          id: "aiu编辑"
        }, null)])])]
      })), I != null && I.uiactionGroupDetails && R.push(s(de, {
        ref: "actionToolbarRef",
        class: u.e("toolbar"),
        actionDetails: I == null ? void 0 : I.uiactionGroupDetails,
        actionsState: e.row.uiActionGroupStates[n.model.codeName],
        groupLevelKeys: [50, 100],
        zIndex: m,
        editColums: z,
        showCommonAction: E.value,
        onActionClick: w,
        onSaveAll: me
      }, {
        editor: (S) => B(S)
      })), R;
    }, fe = (l) => {
      a.value = l.id, n.curPickerId = l.id;
    }, ve = async (l) => {
      r = l;
    };
    return {
      ns: u,
      picking: r,
      componentRef: h,
      actionToolbarRef: t,
      fieldName: d,
      gridEditItemProps: P,
      rowDataChange: x,
      editorProps: A,
      onCellClick: D,
      onTextClick: N,
      onInfoTextChange: G,
      onActionClick: w,
      renderActions: he,
      CustomHtml: M,
      fieldValue: c,
      formatValue: g,
      tooltip: F,
      renderPicker: () => {
        if (o.value.length > 0)
          return s(b("el-dropdown"), {
            onVisibleChange: ve,
            onCommand: (l) => fe(l)
          }, {
            default: () => s(b("iBizCodeList"), {
              class: u.e("text"),
              codeListItems: o.value,
              codeList: n.userCodeList,
              value: a.value
            }, null),
            dropdown: () => {
              let l;
              return s(b("el-dropdown-menu"), null, Ae(l = o.value.map((I) => s(b("el-dropdown-item"), {
                title: I.tooltip,
                command: I
              }, {
                default: () => [s(b("iBizCodeList"), {
                  class: u.e("text"),
                  codeListItems: o.value,
                  codeList: n.userCodeList,
                  value: I.id
                }, null)]
              }))) ? l : {
                default: () => [l]
              });
            }
          });
      }
    };
  },
  render() {
    var h;
    const e = this.controller;
    let u = null;
    e.isCustomCode ? u = s("span", {
      class: this.ns.e("script"),
      innerHTML: this.CustomHtml
    }, null) : e.codeList ? u = s(b("iBizCodeList"), {
      class: this.ns.e("text"),
      codeListItems: e.codeListItems,
      codeList: e.codeList,
      value: this.fieldValue,
      onClick: this.onTextClick,
      onInfoTextChange: this.onInfoTextChange,
      title: this.tooltip
    }, null) : u = s("span", {
      class: this.ns.e("text"),
      title: this.tooltip,
      onClick: this.onTextClick
    }, [this.formatValue, this.fieldValue != null && e.model.unitName]);
    const t = s(b("iBizGridEditItem"), {
      ref: "componentRef",
      required: !e.editItem.allowEmpty,
      error: this.row.errors[this.fieldName],
      overflowMode: this.controller.grid.overflowMode,
      class: this.ns.m("edit-item"),
      ...this.gridEditItemProps
    }, {
      default: () => [e.editorProvider && K(b(e.editorProvider.gridEditor), {
        class: this.ns.e("editor"),
        value: this.row.data[this.fieldName],
        data: this.row.data,
        controller: e.editor,
        overflowMode: e.grid.overflowMode,
        onChange: this.rowDataChange,
        onInfoTextChange: this.onInfoTextChange,
        title: this.tooltip,
        ...this.editorProps
      })]
    });
    return s("div", {
      class: [this.ns.b(), e.clickable(this.row) && this.ns.m("clickable"), this.ns.m(this.controller.grid.overflowMode), (h = this.controller.model.cellSysCss) == null ? void 0 : h.cssName, this.ns.is("has-action", !!e.model.deuiactionGroup)],
      onClick: this.onCellClick
    }, [e.model.enableRowEdit ? s("div", {
      class: this.ns.b("edit-container")
    }, [t, this.renderPicker()]) : s("div", {
      class: this.ns.b("text-container")
    }, [u]), !(e.model.enableRowEdit && !this.editorProps.readonly) && this.editorProps.cellEditable ? s("div", {
      class: this.ns.b("toolbar-container")
    }, [this.renderActions()]) : null]);
  }
});
class De {
  constructor() {
    U(this, "component", "GridEditColumn");
  }
  async createController(u, t) {
    const h = new ae(u, t);
    return await h.init(), h;
  }
}
function Ve(e, u) {
  const t = e.controller, h = i(() => e.row.editColStates[t.name].disabled), n = i(() => e.row.editColStates[t.name].readonly), d = i(() => !!e.row.errors[t.name]), m = i(() => e.row.editColStates[t.name].editable), o = (c) => {
    e.row.editColStates[t.name].editable = c;
  }, a = i(() => !h.value && !n.value && !d.value), r = i(() => d.value || a.value && m.value), f = i(() => !r.value), v = !1, E = !0, T = i(() => !1), x = i(() => m.value);
  let y = e.row.data[e.controller.name];
  const P = p(!1), A = () => {
    ibiz.log.debug("".concat(t.name, "属性编辑器focus事件"));
  }, L = () => {
    var c, g;
    ibiz.log.debug("".concat(t.name, "属性编辑器blur事件")), !P.value && (o(!1), ((c = t.nodeColumn.userParam) == null ? void 0 : c.SAVEMODE) === "BLUR" ? t.treeGrid.save(e.row.data) : ((g = e.row.data._deData) == null ? void 0 : g.srfuf) === O.CREATE ? t.treeGrid.remove({ data: [e.row.data], silent: !0 }) : t.setRowValue(e.row, y));
  }, D = async () => {
    P.value = !0, await t.treeGrid.save(e.row.data), y = e.row.data[e.controller.name], o(!1), P.value = !1;
  }, N = (c) => {
    c.keyCode === 27 && o(!1);
  }, M = k({
    showEditMask: T,
    stopPropagation: x
  }), z = k({
    autoFocus: E,
    disabled: v,
    readonly: f,
    onBlur: L,
    onFocus: A,
    onEnter: D,
    onKeydown: N
  });
  return {
    gridEditItemProps: M,
    editorProps: z
  };
}
function Ne(e, u) {
  const t = e.controller, h = i(() => e.row.editColStates[t.name].disabled), n = i(() => e.row.editColStates[t.name].readonly), d = i(() => e.row.editColStates[t.name].editable), m = i(() => n.value || !d.value), o = i(() => d.value && h.value), a = i(() => d.value), r = k({
    stopPropagation: a
  }), f = k({
    disabled: o,
    readonly: m
  });
  return {
    gridEditItemProps: r,
    editorProps: f
  };
}
function Me(e, u) {
  const t = e.controller, h = i(() => e.row.editColStates[t.name].disabled), n = i(() => e.row.editColStates[t.name].readonly), d = i(() => e.controller.treeGrid.state.rowEditOpen), m = i(() => n.value || !d.value), o = i(() => d.value && h.value), a = i(() => d.value), r = () => {
    t.treeGrid.save(e.row.data);
  }, f = k({
    stopPropagation: a
  }), v = k({
    disabled: o,
    readonly: m,
    onBlur: r
  });
  return {
    gridEditItemProps: f,
    editorProps: v
  };
}
const ze = /* @__PURE__ */ X({
  name: "TreeGridExEditColumn",
  props: {
    controller: {
      type: pe,
      required: !0
    },
    row: {
      type: ie,
      required: !0
    }
  },
  setup(e) {
    const u = i(() => e.row.data[e.controller.name]), t = H("tree-grid-ex-edit-column"), h = p(), n = e.controller, d = async (E, T) => {
      ibiz.log.debug("".concat(n.name, "值变更"), E), await n.setRowValue(e.row, E, T);
    }, m = () => {
      switch (ibiz.config.grid.editShowMode) {
        case "cell":
          return Ve(e);
        case "row":
          return Ne(e);
        case "all":
          return Me(e);
        default:
          throw new re("".concat(ibiz.config.grid.editShowMode, "暂未支持"));
      }
    }, {
      gridEditItemProps: o,
      editorProps: a
    } = m(), r = p(void 0), f = (E) => {
      r.value = E;
    }, v = i(() => {
      if (a.readonly)
        return xe(r.value) ? n.formatValue(u.value) : r.value;
    });
    return {
      ns: t,
      fieldValue: u,
      componentRef: h,
      tooltip: v,
      rowDataChange: d,
      onInfoTextChange: f,
      gridEditItemProps: o,
      editorProps: a
    };
  },
  render() {
    return s(b("iBizGridEditItem"), {
      ref: "componentRef",
      required: !this.controller.nodeEditItem.allowEmpty,
      overflowMode: this.controller.overflowMode,
      class: [this.ns, this.ns.m(this.controller.overflowMode)],
      ...this.gridEditItemProps
    }, {
      default: () => [this.controller.editorProvider && K(b(this.controller.editorProvider.gridEditor), {
        class: this.ns.e("editor"),
        value: this.fieldValue,
        data: this.row.data,
        controller: this.controller.editor,
        overflowMode: this.controller.overflowMode,
        onChange: this.rowDataChange,
        onInfoTextChange: this.onInfoTextChange,
        title: this.tooltip,
        ...this.editorProps
      })]
    });
  }
});
const Q = /* @__PURE__ */ X({
  name: "TreeGridExFieldColumn",
  props: {
    controller: {
      type: ne,
      required: !0
    },
    row: {
      type: ie,
      required: !0
    }
  },
  setup(e) {
    const u = H("tree-grid-ex-field-column"), t = H("tree-grid-ex-field-edit-column"), n = be().zIndex.increment(), d = p(), m = i(() => e.controller.nodeColumnControllerMap.get(e.row.data._nodeId)), o = i(() => e.row.editColStates[m.value.name].editable), a = i(() => e.row.editColStates[m.value.name].readonly), r = (c) => {
      e.row.editColStates[m.value.name].editable = c;
    }, f = (c) => {
      c.stopPropagation(), r(!0);
    };
    le(() => {
      e.row.data.srfuf === O.CREATE && r(!0);
    });
    const v = i(() => e.row.data._nodeType !== "DE" && e.controller.isFirstShowColumn ? e.row.data._text : e.row.data[e.controller.name]), E = p(""), T = (c) => {
      E.value = c;
    }, x = i(() => {
      const c = m.value;
      return c ? c.nodeEditItem ? void 0 : c.codeList ? E.value : c.formatValue(v.value) + (c.unitName || "") : v.value;
    }), y = i(() => {
      if (e.controller.treeGrid.overflowMode === "ellipsis" && se(v.value) && v.value !== "")
        return x.value;
    }), P = i(() => v.value && m.value && (m.value.isLinkColumn || m.value.hasClickAction)), A = (c) => {
      var g;
      (g = m.value) == null || g.onTextClick(e.row, c);
    }, L = () => {
      var c;
      (c = d.value) == null || c.closeAllPopover();
    }, D = async (c, g) => {
      var G, F, w;
      g.stopPropagation();
      const C = (G = m.value) == null ? void 0 : G.treeGrid;
      if (C) {
        (F = d.value) == null || F.openProcessing();
        const V = C.getEventArgs(), Y = C.parseTreeNodeData(e.row.data), B = await oe.exec(c.uiactionId, {
          ...V,
          ...Y,
          event: g
        }, c.appId);
        if ((w = d.value) == null || w.closeProcessing(), B.cancel || L(), B.closeView)
          C.view.closeView();
        else if (B.refresh)
          switch (B.refreshMode) {
            case 1:
              C.refreshNodeChildren(e.row.data);
              break;
            case 2:
              C.refreshNodeChildren(e.row.data, !0);
              break;
            case 3:
              C.refresh();
              break;
          }
      }
    }, N = i(() => Object.values(e.controller.treeGrid.columns).filter((c) => {
      var C;
      const g = c.nodeColumnControllerMap.get(e.row.data._nodeId);
      return g.nodeColumn.enableRowEdit && g.nodeColumn.id !== ((C = m.value) == null ? void 0 : C.nodeColumn.id);
    }));
    return {
      ns: u,
      ns2: t,
      zIndex: n,
      nodeColumn: m,
      fieldValue: v,
      showText: x,
      clickable: P,
      tooltip: y,
      editable: o,
      readonly: a,
      editColums: N,
      actionToolbarRef: d,
      onInfoTextChange: T,
      onDataChange: async (c, g, C) => {
        await c.setRowValue(e.row, g, C);
        const G = c.editor.model.editorType;
        ce.includes(G) || L();
      },
      editorEnter: async (c, g, C) => {
        await c.setRowValue(e.row, g, C), L();
      },
      onTextClick: A,
      onActionClick: D,
      onOpenEdit: f
    };
  },
  render() {
    var n, d, m, o;
    let e = null;
    const u = (a) => {
      var x, y;
      const r = a.nodeColumnControllerMap.get(this.row.data._nodeId), f = r.name, v = this.row.data[f], E = (x = this.row.editColStates[f]) == null ? void 0 : x.readonly, T = (y = this.row.editColStates[f]) == null ? void 0 : y.disabled;
      return r.editorProvider && K(b(r.editorProvider.gridEditor), {
        class: this.ns.e("editor"),
        value: E ? r.formatValue(v) : v,
        data: this.row.data,
        controller: r.editor,
        overflowMode: r.overflowMode,
        // eslint-disable-next-line no-shadow
        onChange: (P, A) => this.onDataChange(r, P, A || f),
        // eslint-disable-next-line @typescript-eslint/no-unused-vars
        onEnter: (P) => this.editorEnter(r, v, f),
        // 待测试
        readonly: E,
        disabled: T
      });
    };
    (n = this.nodeColumn) != null && n.nodeEditItem ? e = s(ze, {
      controller: this.nodeColumn,
      row: this.row
    }, null) : (d = this.nodeColumn) != null && d.codeList ? e = s(b("iBizCodeList"), {
      class: this.ns.e("text"),
      codeListItems: this.nodeColumn.codeListItems,
      codeList: this.nodeColumn.codeList,
      value: this.fieldValue,
      onClick: this.onTextClick,
      onInfoTextChange: this.onInfoTextChange,
      title: this.tooltip
    }, null) : e = s("span", {
      class: this.ns.e("text"),
      title: this.tooltip,
      onClick: this.onTextClick
    }, [this.showText]);
    let t;
    this.$slots.actions ? t = this.$slots.actions() : this.row.columnActionsStates[this.controller.name] && (t = s(de, {
      ref: "actionToolbarRef",
      class: this.ns.e("toolbar"),
      actionDetails: (m = this.nodeColumn) == null ? void 0 : m.nodeColumn.deuiactionGroup.uiactionGroupDetails,
      actionsState: this.row.columnActionsStates[this.controller.name],
      groupLevelKeys: [50, 100],
      zIndex: this.zIndex,
      editColums: this.editColums,
      onActionClick: this.onActionClick
    }, {
      editor: (a) => u(a)
    }));
    const h = s(b("el-button"), {
      text: !0,
      size: "small",
      class: "hover-action",
      onClick: (a) => this.onOpenEdit(a),
      title: "编辑"
    }, {
      default: () => [s("svg", {
        viewBox: "0 0 16 16",
        xmlns: "http://www.w3.org/2000/svg",
        height: "1em",
        width: "1em",
        preserveAspectRatio: "xMidYMid meet",
        focusable: "false"
      }, [s("g", {
        id: "aiuaction/edit",
        "stroke-width": "1",
        "fill-rule": "evenodd"
      }, [s("path", {
        d: "M2 8.34L10.71 0 15 4.17 6.538 13H2V8.34zm1.2.512V11.8h2.826l7.283-7.6-2.606-2.533L3.2 8.852zM0 16v-1.2h16V16H0z",
        id: "aiu编辑"
      }, null)])])]
    });
    return s("div", {
      class: [this.ns.b(), this.ns2.b(), this.clickable && this.ns.m("clickable"), this.ns.m(this.controller.treeGrid.overflowMode), (o = this.controller.model.cellSysCss) == null ? void 0 : o.cssName, this.ns2.is("editable", this.editable), this.ns.is("has-action", !!t)]
    }, [s("div", {
      class: this.ns.b("text-container")
    }, [e]), s("div", {
      class: this.ns.b("toolbar-container")
    }, [!this.editable && !this.readonly ? [h, t] : null])]);
  }
});
class Ge {
  constructor() {
    U(this, "component", "TreeGridExFieldColumn");
  }
  async createController(u, t) {
    const h = new ne(u, t);
    return await h.init(), h;
  }
}
const Fe = te(
  J,
  function(e) {
    e.component(J.name, J), ye(
      "GRID_COLRENDER_COLUMN_ACTION_EDIT",
      () => new De()
    );
  }
), Oe = te(
  Q,
  function(e) {
    e.component(Q.name, Q), Te(
      "GRID_COLRENDER_COLUMN_ACTION_EDIT",
      () => new Ge()
    );
  }
), Ke = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(e) {
    e.use(Fe), e.use(Oe);
  }
};
export {
  Fe as IBizGridEditColumn,
  Oe as IBizTreeGridExFieldColumn,
  Ke as default
};
