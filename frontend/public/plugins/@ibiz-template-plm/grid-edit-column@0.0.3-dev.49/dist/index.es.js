import './style.css';
var Ge = Object.defineProperty;
var ze = (e, l, o) => l in e ? Ge(e, l, { enumerable: !0, configurable: !0, writable: !0, value: o }) : e[l] = o;
var V = (e, l, o) => (ze(e, typeof l != "symbol" ? l + "" : l, o), o);
import { useClickOutside as Y, useNamespace as B, withInstall as ne } from "@ibiz-template/vue3-util";
import { Srfuf as _, GridFieldEditColumnController as Fe, GridRowState as Oe, UIActionUtil as Be, SysUIActionTag as j, TreeGridExNodeColumnController as _e, TreeGridExRowState as le, TreeGridExFieldColumnController as re, registerGridColumnProvider as Ue, registerTreeGridExColumnProvider as $e } from "@ibiz-template/runtime";
import { computed as i, ref as b, reactive as R, defineComponent as J, onMounted as se, onUnmounted as He, createVNode as s, resolveComponent as v, h as W, isVNode as qe } from "vue";
import { isNotNil as ae, isNil as je } from "ramda";
import { RuntimeError as de } from "@ibiz-template/core";
function Ke(e, l) {
  const o = e.controller, r = i(() => e.row.editColStates[o.fieldName].disabled), n = i(() => e.row.editColStates[o.fieldName].readonly), u = i(() => !!e.row.errors[o.fieldName]), f = i(
    () => e.row.editColStates[o.fieldName].editable
  ), a = (T) => {
    e.row.editColStates[o.fieldName].editable = T;
  }, w = i(() => !r.value && !n.value && !u.value), h = i(() => u.value || w.value && f.value), C = i(() => !h.value), E = !1, I = !0, L = i(() => w.value && !f.value), x = i(() => f.value);
  let m;
  const y = () => {
    a(!0), m = Y(l, async (T) => {
      a(!1), m.stop();
    });
  }, k = () => {
    m && m.stop(), ibiz.log.debug("".concat(o.fieldName, "属性编辑器focus事件"));
  };
  let P = e.row.data[o.fieldName];
  const D = b(!1), G = () => {
    var T;
    ibiz.log.debug("".concat(o.fieldName, "属性编辑器blur事件")), !(D.value || o.hasDropdown) && (a(!1), ((T = o.model.userParam) == null ? void 0 : T.SAVEMODE) === "BLUR" ? o.grid.save(e.row.data) : e.row.data.srfuf === _.CREATE ? o.grid.remove({ data: [e.row.data], silent: !0 }) : o.setRowValue(e.row, P));
  }, N = async () => {
    o.setPickerValue(e.row), D.value = !0, ibiz.log.debug("".concat(o.fieldName, "属性编辑器enter事件")), await o.grid.save(e.row.data), P = e.row.data[o.fieldName], a(!1), D.value = !1;
  }, z = (T) => {
    T.keyCode === 27 && a(!1);
  }, p = R({
    showEditMask: L,
    stopPropagation: x
  }), M = R({
    autoFocus: I,
    disabled: E,
    readonly: C,
    onFocus: k,
    onBlur: G,
    onEnter: N,
    onKeydown: z
  });
  return {
    gridEditItemProps: p,
    editorProps: M,
    onMaskClick: y
  };
}
function Xe(e, l) {
  const o = e.controller, r = i(() => e.row.editColStates[o.fieldName].disabled), n = i(() => e.row.editColStates[o.fieldName].readonly), u = i(
    () => e.row.editColStates[o.fieldName].editable
  ), f = i(() => n.value || !u.value), a = i(() => u.value && r.value), w = i(() => u.value), h = R({
    stopPropagation: w
  }), C = R({
    disabled: a,
    readonly: f
  });
  return {
    gridEditItemProps: h,
    editorProps: C
  };
}
function Ye(e, l) {
  const o = e.controller, r = i(() => e.row.editColStates[o.fieldName].disabled), n = i(() => e.row.editColStates[o.fieldName].readonly), u = i(() => e.controller.grid.state.rowEditOpen), f = i(() => n.value || !u.value), a = i(() => u.value && r.value), w = i(() => u.value), h = () => {
    o.grid.save(e.row.data);
  }, C = R({
    stopPropagation: w
  }), E = R({
    disabled: a,
    readonly: f,
    onBlur: h
  });
  return {
    gridEditItemProps: C,
    editorProps: E
  };
}
class ce extends Fe {
  constructor() {
    super(...arguments);
    /**
     * 用户代码表
     *
     * @type {(IAppCodeList | undefined)}
     * @memberof GridEditColumnController
     */
    V(this, "userCodeList");
    /**
     * 是否拥有下拉
     *
     * @type {boolean}
     * @memberof GridEditColumnController
     */
    V(this, "hasDropdown", !1);
    /**
     * 当前选项id
     *
     * @type {string}
     * @memberof GridEditColumnController
     */
    V(this, "curPickerId", "");
  }
  /**
   * 加载用户代码表
   *
   * @param {IData} data
   * @return {*}  {Promise<readonly}
   * @memberof GridEditColumnController
   */
  async loadUserCodeList(o) {
    if (o.codelistTag) {
      const r = ibiz.hub.getApp(this.context.srfappid), n = await r.codeList.get(
        o.codelistTag,
        this.context,
        this.params
      );
      this.userCodeList = r.codeList.getCodeList(o.codelistTag);
      const u = (o.pickerData || "").split(",");
      return this.hasDropdown = !0, n.filter((f) => u.includes(f.id));
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
  setPickerValue(o) {
    const r = o.data.srfUserData;
    r && r.pickerField && (o.data[r.pickerField] = this.curPickerId);
  }
}
function We(e) {
  return typeof e == "function" || Object.prototype.toString.call(e) === "[object Object]" && !qe(e);
}
const K = /* @__PURE__ */ J({
  name: "GridEditColumn",
  props: {
    controller: {
      type: ce,
      required: !0
    },
    row: {
      type: Oe,
      required: !0
    }
  },
  setup(e) {
    var te;
    const l = B("grid-edit-column"), o = b(), r = b(), n = e.controller, u = (te = n.editItem) == null ? void 0 : te.codeName, f = b(!1), a = b(!1), w = b(), h = b(), C = b(), E = [50, 100], I = b(!1), {
      zIndex: L
    } = e.controller.grid.state, x = b([]), m = b("");
    let y = !1, k;
    const P = e.row.data.srfUserData;
    (async () => {
      P && (x.value = await n.loadUserCodeList(P), m.value = P.defaultValue, n.curPickerId = P.defaultValue);
    })();
    const G = i(() => {
      const {
        deuiactionGroup: t
      } = n.model;
      return t != null && t.uiactionGroupDetails ? t.uiactionGroupDetails.filter((d) => E.findIndex((c) => c === d.actionLevel) === -1) : [];
    }), N = i(() => {
      const {
        deuiactionGroup: t
      } = n.model;
      return t != null && t.uiactionGroupDetails ? t.uiactionGroupDetails.filter((d) => E.findIndex((c) => c === d.actionLevel) !== -1) : [];
    }), z = i(() => !(n.grid.model.controlType === "TREEGRID" && !n.grid.state.showTreeGrid)), p = async (t, d) => {
      await n.setRowValue(e.row, t, d);
    }, M = () => {
      switch (ibiz.config.grid.editShowMode) {
        case "cell":
          return Ke(e, o);
        case "row":
          return Xe(e);
        case "all":
          return Ye(e);
        default:
          throw new de("".concat(ibiz.config.grid.editShowMode, "暂未支持"));
      }
    }, {
      gridEditItemProps: T,
      editorProps: U
    } = M(), Q = (t) => {
      e.row.editColStates[n.fieldName].editable = t;
    };
    se(() => {
      e.row.data.srfuf === _.CREATE && Q(!0), r.value && (k = Y(r, async () => {
        !y && !U.readonly && (n.hasDropdown = !1, U.onBlur());
      }));
    }), He(() => {
      k && k.stop && k.stop();
    });
    const ue = (t) => {
      e.controller.hasAction && (t.stopPropagation(), e.controller.triggerAction(e.row, t));
    }, me = (t) => {
      e.controller.isLinkColumn && (t.stopPropagation(), e.controller.openLinkView(e.row, t));
    }, fe = i(() => n.getCustomHtml(e.row)), F = i(() => e.row.uiActionGroupStates[n.model.codeName]), O = i(() => e.row.data[e.controller.model.codeName.toLowerCase()]), Z = i(() => n.formatValue(O.value)), $ = b(void 0), ve = (t) => {
      $.value = t;
    }, he = i(() => {
      if (e.controller.grid.overflowMode === "ellipsis" && ae(O.value) && O.value !== "")
        return $.value ? $.value : Z.value + (e.controller.model.unitName || "");
    }), we = (t, d) => {
      const c = {
        ...d
      };
      if (h.value) {
        const g = h.value.querySelector(".".concat(t.id));
        g && (c.target = g);
      }
      return c;
    }, H = async (t, d) => {
      var S, A;
      d.stopPropagation(), I.value = !0;
      const c = {
        context: n.context,
        params: n.params,
        data: [e.row.data],
        view: n.grid.view,
        event: we(t, d)
      }, g = await Be.exec(t.uiactionId, c, t.appId);
      if (g.cancel || (a.value = !1), I.value = !1, g.closeView)
        c.view.modal.ignoreDismissCheck = !0, c.view.closeView({
          ok: !0
        });
      else if (g.refresh)
        switch (g.refreshMode) {
          case 1:
            c.view.callUIAction(j.REFRESH);
            break;
          case 2:
            (S = c.view.parentView) == null || S.callUIAction(j.REFRESH);
            break;
          case 3:
            (A = c.view.getTopView()) == null || A.callUIAction(j.REFRESH);
            break;
        }
    }, Ce = async (t, d, c) => {
      const g = c || t.editItem.codeName;
      await n.setRowValue(e.row, d, g);
      const S = t.editor.model.editorType;
      ["TEXTBOX", "PASSWORD", "TEXTAREA", "TEXTAREA_10", "NUMBER", "SOLIDER", "STEPPER"].includes(S) || (q(), a.value = !1);
    }, ge = () => {
      q(), a.value = !1, n.grid.saveAll();
    }, be = (t) => {
      var A, oe;
      const d = t.editItem.codeName, c = e.row.data[d], g = (A = e.row.editColStates[d]) == null ? void 0 : A.readonly, S = (oe = e.row.editColStates[d]) == null ? void 0 : oe.disabled;
      return t.editorProvider && W(v(t.editorProvider.gridEditor), {
        class: l.e("editor"),
        value: g ? t.formatValue(c) : c,
        data: e.row.data,
        controller: t.editor,
        overflowMode: n.grid.overflowMode,
        // eslint-disable-next-line no-shadow
        onChange: (ie, Ve) => Ce(t, ie, Ve),
        // eslint-disable-next-line @typescript-eslint/no-unused-vars
        onEnter: (ie) => ge(),
        readonly: g,
        disabled: S
      });
    }, Ee = () => {
      f.value = !0;
    }, q = () => {
      f.value = !1;
    }, Ie = (t) => {
      t.stopPropagation(), t.preventDefault();
    }, ye = (t) => {
      t.stopPropagation(), Q(!0);
    }, Re = () => {
      const d = Object.values(n.grid.columns).filter((c) => c.enableRowEdit && c.model.id !== n.model.id).map((c) => {
        const {
          caption: g
        } = c.model, S = c.model.sysImage || {
          cssClass: "fa fa-bars"
        };
        return s(v("el-popover"), {
          placement: "right-start",
          width: "280",
          teleported: !1,
          offset: 16,
          trigger: "click"
        }, {
          reference: () => s("div", {
            class: l.bem("actions-popper", "action-group", "edit-column")
          }, [s(v("iBizIcon"), {
            icon: S
          }, null), g]),
          default: () => s("div", {
            onMouseenter: Ee,
            onMouseleave: q,
            ref: w,
            onClick: (A) => Ie(A)
          }, [be(c)])
        });
      });
      return d.length > 0 ? s("div", {
        class: l.be("actions-popper", "edit-group")
      }, [d]) : null;
    }, ke = (t) => s(v("el-button"), {
      text: !0,
      size: "small",
      onClick: (d) => H(t, d),
      title: t.tooltipLanguageRes ? ibiz.i18n.t(t.tooltipLanguageRes.lanResTag, t.tooltip) : t.tooltip,
      disabled: F.value[t.id].disabled,
      class: ee(t)
    }, {
      default: () => [t.showIcon && t.sysImage && s("div", {
        class: l.be("action", "icon")
      }, [s(v("iBizIcon"), {
        icon: t.sysImage
      }, null)]), t.showCaption ? t.capLanguageRes ? ibiz.i18n.t(t.capLanguageRes.lanResTag, t.caption) : t.caption : ""]
    }), xe = () => {
      let t = null;
      const d = [];
      return N.value.forEach((c) => {
        c.uiactionId && c.uiactionId.includes("get_editor_column") ? t = Re() : F.value[c.id].visible && d.push(ke(c));
      }), s("div", {
        class: l.be("actions-popper", "action-group"),
        ref: h
      }, [t, ...d]);
    }, pe = () => {
      const t = w.value, d = Y(h, async (c) => {
        I.value || (De(), a.value || d.stop());
      }, {
        ignore: [t]
      });
    }, Pe = (t) => {
      t.stopPropagation(), a.value = !a.value;
    }, Te = () => {
      n.grid.saveAll();
    }, ee = (t) => {
      const {
        actionLevel: d
      } = t;
      return [t.id, l.e("item"), l.is("disabled", !1), l.em("item", "level-".concat(d))];
    }, Le = () => s(v("el-popover"), {
      visible: a.value,
      popperClass: l.b("actions-popper"),
      placement: "right-start",
      width: "280",
      trigger: "click",
      onShow: () => {
        pe();
      },
      onHide: () => {
        Te();
      },
      "popper-style": {
        zIndex: L
      },
      ref: C
    }, {
      reference: () => s(v("el-button"), {
        text: !0,
        size: "small",
        class: "hover-action",
        onClick: (t) => Pe(t),
        title: "更多"
      }, {
        icon: () => s(v("ion-icon"), {
          name: "ellipsis-vertical-outline"
        }, null)
      }),
      default: () => xe()
    }), Se = () => G.value.map((t) => {
      if (F.value[t.id].visible && (t.actionLevel === 250 || z.value && t.actionLevel === 200))
        return s(v("el-button"), {
          text: !0,
          size: "small",
          onClick: (d) => H(t, d),
          title: t.tooltipLanguageRes ? ibiz.i18n.t(t.tooltipLanguageRes.lanResTag, t.tooltip) : t.tooltip,
          disabled: F.value[t.id].disabled,
          class: ee(t)
        }, {
          default: () => [t.showIcon && t.sysImage && s(v("iBizIcon"), {
            icon: t.sysImage
          }, null), t.showCaption ? t.capLanguageRes ? ibiz.i18n.t(t.capLanguageRes.lanResTag, t.caption) : t.caption : ""]
        });
    }), Ae = () => {
      const {
        enableRowEdit: t,
        deuiactionGroup: d
      } = n.model, c = [];
      return t && c.push(s(v("el-button"), {
        text: !0,
        size: "small",
        class: "hover-action",
        onClick: (g) => ye(g),
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
      })), d && (c.push(Se()), N.value.length > 0 && c.push(Le())), c;
    }, De = () => {
      f.value || (a.value = !1);
    }, Ne = (t) => {
      m.value = t.id, n.curPickerId = t.id;
    }, Me = async (t) => {
      y = t;
    };
    return {
      ns: l,
      componentRef: o,
      containerRef: r,
      fieldName: u,
      gridEditItemProps: T,
      rowDataChange: p,
      editorProps: U,
      onCellClick: ue,
      onTextClick: me,
      onInfoTextChange: ve,
      onActionClick: H,
      renderActions: Ae,
      CustomHtml: fe,
      fieldValue: O,
      formatValue: Z,
      tooltip: he,
      renderPicker: () => {
        if (x.value.length > 0)
          return s(v("el-dropdown"), {
            onVisibleChange: Me,
            onCommand: (t) => Ne(t)
          }, {
            default: () => s(v("iBizCodeList"), {
              class: l.e("text"),
              codeListItems: x.value,
              codeList: n.userCodeList,
              value: m.value
            }, null),
            dropdown: () => {
              let t;
              return s(v("el-dropdown-menu"), null, We(t = x.value.map((d) => s(v("el-dropdown-item"), {
                title: d.tooltip,
                command: d
              }, {
                default: () => [s(v("iBizCodeList"), {
                  class: l.e("text"),
                  codeListItems: x.value,
                  codeList: n.userCodeList,
                  value: d.id
                }, null)]
              }))) ? t : {
                default: () => [t]
              });
            }
          });
      }
    };
  },
  render() {
    var r;
    const e = this.controller;
    let l = null;
    e.isCustomCode ? l = s("span", {
      class: this.ns.e("script"),
      innerHTML: this.CustomHtml
    }, null) : e.codeList ? l = s(v("iBizCodeList"), {
      class: this.ns.e("text"),
      codeListItems: e.codeListItems,
      codeList: e.codeList,
      value: this.fieldValue,
      onClick: this.onTextClick,
      onInfoTextChange: this.onInfoTextChange,
      title: this.tooltip
    }, null) : l = s("span", {
      class: this.ns.e("text"),
      title: this.tooltip,
      onClick: this.onTextClick
    }, [this.formatValue, this.fieldValue != null && e.model.unitName]);
    const o = s(v("iBizGridEditItem"), {
      ref: "componentRef",
      required: !e.editItem.allowEmpty,
      error: this.row.errors[this.fieldName],
      overflowMode: this.controller.grid.overflowMode,
      class: this.ns.m("edit-item"),
      ...this.gridEditItemProps
    }, {
      default: () => [e.editorProvider && W(v(e.editorProvider.gridEditor), {
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
      ref: "containerRef",
      class: [this.ns.b(), e.clickable(this.row) && this.ns.m("clickable"), this.ns.m(this.controller.grid.overflowMode), (r = this.controller.model.cellSysCss) == null ? void 0 : r.cssName, this.ns.is("has-action", !!e.model.deuiactionGroup)],
      onClick: this.onCellClick
    }, [e.model.enableRowEdit ? s("div", {
      class: this.ns.b("edit-container")
    }, [o, this.renderPicker()]) : s("div", {
      class: this.ns.b("text-container")
    }, [l]), e.model.enableRowEdit && !this.editorProps.readonly ? null : s("div", {
      class: this.ns.b("toolbar-container")
    }, [this.renderActions()])]);
  }
});
class Je {
  constructor() {
    V(this, "component", "GridEditColumn");
  }
  async createController(l, o) {
    const r = new ce(l, o);
    return await r.init(), r;
  }
}
function Qe(e, l) {
  const o = e.controller, r = i(() => e.row.editColStates[o.name].disabled), n = i(() => e.row.editColStates[o.name].readonly), u = i(() => !!e.row.errors[o.name]), f = i(() => e.row.editColStates[o.name].editable), a = (p) => {
    e.row.editColStates[o.name].editable = p;
  }, w = i(() => !r.value && !n.value && !u.value), h = i(() => u.value || w.value && f.value), C = i(() => !h.value), E = !1, I = !0, L = i(() => !1), x = i(() => f.value);
  let m = e.row.data[e.controller.name];
  const y = b(!1), k = () => {
    ibiz.log.debug("".concat(o.name, "属性编辑器focus事件"));
  }, P = () => {
    var p, M;
    ibiz.log.debug("".concat(o.name, "属性编辑器blur事件")), !y.value && (a(!1), ((p = o.nodeColumn.userParam) == null ? void 0 : p.SAVEMODE) === "BLUR" ? o.treeGrid.save(e.row.data) : ((M = e.row.data._deData) == null ? void 0 : M.srfuf) === _.CREATE ? o.treeGrid.remove({ data: [e.row.data], silent: !0 }) : o.setRowValue(e.row, m));
  }, D = async () => {
    y.value = !0, await o.treeGrid.save(e.row.data), m = e.row.data[e.controller.name], a(!1), y.value = !1;
  }, G = (p) => {
    p.keyCode === 27 && a(!1);
  }, N = R({
    showEditMask: L,
    stopPropagation: x
  }), z = R({
    autoFocus: I,
    disabled: E,
    readonly: C,
    onBlur: P,
    onFocus: k,
    onEnter: D,
    onKeydown: G
  });
  return {
    gridEditItemProps: N,
    editorProps: z
  };
}
function Ze(e, l) {
  const o = e.controller, r = i(() => e.row.editColStates[o.name].disabled), n = i(() => e.row.editColStates[o.name].readonly), u = i(() => e.row.editColStates[o.name].editable), f = i(() => n.value || !u.value), a = i(() => u.value && r.value), w = i(() => u.value), h = R({
    stopPropagation: w
  }), C = R({
    disabled: a,
    readonly: f
  });
  return {
    gridEditItemProps: h,
    editorProps: C
  };
}
function et(e, l) {
  const o = e.controller, r = i(() => e.row.editColStates[o.name].disabled), n = i(() => e.row.editColStates[o.name].readonly), u = i(() => e.controller.treeGrid.state.rowEditOpen), f = i(() => n.value || !u.value), a = i(() => u.value && r.value), w = i(() => u.value), h = () => {
    o.treeGrid.save(e.row.data);
  }, C = R({
    stopPropagation: w
  }), E = R({
    disabled: a,
    readonly: f,
    onBlur: h
  });
  return {
    gridEditItemProps: C,
    editorProps: E
  };
}
const tt = /* @__PURE__ */ J({
  name: "TreeGridExEditColumn",
  props: {
    controller: {
      type: _e,
      required: !0
    },
    row: {
      type: le,
      required: !0
    }
  },
  setup(e) {
    const l = i(() => e.row.data[e.controller.name]), o = B("tree-grid-ex-edit-column"), r = b(), n = e.controller, u = async (I, L) => {
      ibiz.log.debug("".concat(n.name, "值变更"), I), await n.setRowValue(e.row, I, L);
    }, f = () => {
      switch (ibiz.config.grid.editShowMode) {
        case "cell":
          return Qe(e);
        case "row":
          return Ze(e);
        case "all":
          return et(e);
        default:
          throw new de("".concat(ibiz.config.grid.editShowMode, "暂未支持"));
      }
    }, {
      gridEditItemProps: a,
      editorProps: w
    } = f(), h = b(void 0), C = (I) => {
      h.value = I;
    }, E = i(() => {
      if (w.readonly)
        return je(h.value) ? n.formatValue(l.value) : h.value;
    });
    return {
      ns: o,
      fieldValue: l,
      componentRef: r,
      tooltip: E,
      rowDataChange: u,
      onInfoTextChange: C,
      gridEditItemProps: a,
      editorProps: w
    };
  },
  render() {
    return s(v("iBizGridEditItem"), {
      ref: "componentRef",
      required: !this.controller.nodeEditItem.allowEmpty,
      overflowMode: this.controller.overflowMode,
      class: [this.ns, this.ns.m(this.controller.overflowMode)],
      ...this.gridEditItemProps
    }, {
      default: () => [this.controller.editorProvider && W(v(this.controller.editorProvider.gridEditor), {
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
const X = /* @__PURE__ */ J({
  name: "TreeGridExFieldColumn",
  props: {
    controller: {
      type: re,
      required: !0
    },
    row: {
      type: le,
      required: !0
    }
  },
  setup(e) {
    const l = B("tree-grid-ex-field-column"), o = B("tree-grid-ex-field-edit-column"), r = i(() => e.controller.nodeColumnControllerMap.get(e.row.data._nodeId)), n = i(() => e.row.editColStates[r.value.name].editable), u = (m) => {
      e.row.editColStates[r.value.name].editable = m;
    }, f = (m) => {
      m.stopPropagation(), u(!0);
    };
    se(() => {
      e.row.data.srfuf === _.CREATE && u(!0);
    });
    const a = i(() => e.row.data._nodeType !== "DE" && e.controller.isFirstShowColumn ? e.row.data._text : e.row.data[e.controller.name]), w = b(""), h = (m) => {
      w.value = m;
    }, C = i(() => {
      const m = r.value;
      return m ? m.nodeEditItem ? void 0 : m.codeList ? w.value : m.formatValue(a.value) + (m.unitName || "") : a.value;
    }), E = i(() => {
      if (e.controller.treeGrid.overflowMode === "ellipsis" && ae(a.value) && a.value !== "")
        return C.value;
    }), I = i(() => a.value && r.value && (r.value.isLinkColumn || r.value.hasClickAction));
    return {
      ns: l,
      ns2: o,
      nodeColumn: r,
      fieldValue: a,
      showText: C,
      clickable: I,
      tooltip: E,
      editable: n,
      onInfoTextChange: h,
      onTextClick: (m) => {
        var y;
        (y = r.value) == null || y.onTextClick(e.row, m);
      },
      onActionClick: async (m, y) => {
        var k;
        await ((k = r.value) == null ? void 0 : k.onActionClick(m, e.row, y));
      },
      onOpenEdit: f
    };
  },
  render() {
    var r, n, u, f;
    let e = null;
    (r = this.nodeColumn) != null && r.nodeEditItem ? e = s(tt, {
      controller: this.nodeColumn,
      row: this.row
    }, null) : (n = this.nodeColumn) != null && n.codeList ? e = s(v("iBizCodeList"), {
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
    let l;
    this.$slots.actions ? l = this.$slots.actions() : this.row.columnActionsStates[this.controller.name] && (l = s(v("iBizActionToolbar"), {
      class: this.ns.e("toolbar"),
      "action-details": (u = this.nodeColumn) == null ? void 0 : u.nodeColumn.deuiactionGroup.uiactionGroupDetails,
      "actions-state": this.row.columnActionsStates[this.controller.name],
      groupLevelKeys: [50, 100],
      onActionClick: this.onActionClick
    }, null));
    const o = s(v("el-button"), {
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
      class: [this.ns.b(), this.ns2.b(), this.clickable && this.ns.m("clickable"), this.ns.m(this.controller.treeGrid.overflowMode), (f = this.controller.model.cellSysCss) == null ? void 0 : f.cssName, this.ns2.is("editable", this.editable), this.ns.is("has-action", !!l)]
    }, [s("div", {
      class: this.ns.b("text-container")
    }, [e]), s("div", {
      class: this.ns.b("toolbar-container")
    }, [this.editable ? null : [o, l]])]);
  }
});
class ot {
  constructor() {
    V(this, "component", "TreeGridExFieldColumn");
  }
  async createController(l, o) {
    const r = new re(l, o);
    return await r.init(), r;
  }
}
const it = ne(
  K,
  function(e) {
    e.component(K.name, K), Ue(
      "GRID_COLRENDER_COLUMN_ACTION_EDIT",
      () => new Je()
    );
  }
), nt = ne(
  X,
  function(e) {
    e.component(X.name, X), $e(
      "GRID_COLRENDER_COLUMN_ACTION_EDIT",
      () => new ot()
    );
  }
), mt = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(e) {
    e.use(it), e.use(nt);
  }
};
export {
  it as IBizGridEditColumn,
  nt as IBizTreeGridExFieldColumn,
  mt as default
};
