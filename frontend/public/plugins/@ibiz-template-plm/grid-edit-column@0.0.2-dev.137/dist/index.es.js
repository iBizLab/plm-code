import './style.css';
var Pe = Object.defineProperty;
var Se = (e, l, o) => l in e ? Pe(e, l, { enumerable: !0, configurable: !0, writable: !0, value: o }) : e[l] = o;
var $ = (e, l, o) => (Se(e, typeof l != "symbol" ? l + "" : l, o), o);
import { useClickOutside as Z, useNamespace as D, withInstall as ee } from "@ibiz-template/vue3-util";
import { Srfuf as F, GridFieldEditColumnController as te, GridRowState as Ae, UIActionUtil as Le, SysUIActionTag as H, TreeGridExNodeColumnController as Me, TreeGridExRowState as oe, TreeGridExFieldColumnController as ne, registerGridColumnProvider as Ne, registerTreeGridExColumnProvider as pe } from "@ibiz-template/runtime";
import { computed as n, ref as E, reactive as x, defineComponent as X, onMounted as ie, createVNode as r, resolveComponent as C, h as K } from "vue";
import { isNotNil as le, isNil as Ge } from "ramda";
import { RuntimeError as re } from "@ibiz-template/core";
function ze(e, l) {
  const o = e.controller, i = n(() => e.row.editColStates[o.fieldName].disabled), v = n(() => e.row.editColStates[o.fieldName].readonly), a = n(() => !!e.row.errors[o.fieldName]), u = n(
    () => e.row.editColStates[o.fieldName].editable
  ), c = (y) => {
    e.row.editColStates[o.fieldName].editable = y;
  }, f = n(() => !i.value && !v.value && !a.value), h = n(() => a.value || f.value && u.value), w = n(() => !h.value), b = !1, I = !0, P = n(() => f.value && !u.value), L = n(() => u.value);
  let m;
  const R = () => {
    c(!0), m = Z(l, async (y) => {
      c(!1), m.stop();
    });
  }, S = () => {
    m && m.stop(), ibiz.log.debug("".concat(o.fieldName, "属性编辑器focus事件"));
  };
  let p = e.row.data[o.fieldName];
  const M = E(!1), G = () => {
    var y;
    ibiz.log.debug("".concat(o.fieldName, "属性编辑器blur事件")), !M.value && (c(!1), ((y = o.model.userParam) == null ? void 0 : y.SAVEMODE) === "BLUR" ? o.grid.save(e.row.data) : e.row.data.srfuf === F.CREATE ? o.grid.remove({ data: [e.row.data], silent: !0 }) : o.setRowValue(e.row, p));
  }, z = async () => {
    M.value = !0, ibiz.log.debug("".concat(o.fieldName, "属性编辑器enter事件")), await o.grid.save(e.row.data), p = e.row.data[o.fieldName], c(!1), M.value = !1;
  }, V = (y) => {
    y.keyCode === 27 && c(!1);
  }, T = x({
    showEditMask: P,
    stopPropagation: L
  }), k = x({
    autoFocus: I,
    disabled: b,
    readonly: w,
    onFocus: S,
    onBlur: G,
    onEnter: z,
    onKeydown: V
  });
  return {
    gridEditItemProps: T,
    editorProps: k,
    onMaskClick: R
  };
}
function Ve(e, l) {
  const o = e.controller, i = n(() => e.row.editColStates[o.fieldName].disabled), v = n(() => e.row.editColStates[o.fieldName].readonly), a = n(
    () => e.row.editColStates[o.fieldName].editable
  ), u = n(() => v.value || !a.value), c = n(() => a.value && i.value), f = n(() => a.value), h = x({
    stopPropagation: f
  }), w = x({
    disabled: c,
    readonly: u
  });
  return {
    gridEditItemProps: h,
    editorProps: w
  };
}
function De(e, l) {
  const o = e.controller, i = n(() => e.row.editColStates[o.fieldName].disabled), v = n(() => e.row.editColStates[o.fieldName].readonly), a = n(() => e.controller.grid.state.rowEditOpen), u = n(() => v.value || !a.value), c = n(() => a.value && i.value), f = n(() => a.value), h = () => {
    o.grid.save(e.row.data);
  }, w = x({
    stopPropagation: f
  }), b = x({
    disabled: c,
    readonly: u,
    onBlur: h
  });
  return {
    gridEditItemProps: w,
    editorProps: b
  };
}
const U = /* @__PURE__ */ X({
  name: "GridEditColumn",
  props: {
    controller: {
      type: te,
      required: !0
    },
    row: {
      type: Ae,
      required: !0
    }
  },
  setup(e) {
    var W;
    const l = D("grid-edit-column"), o = E(), i = e.controller, v = (W = i.editItem) == null ? void 0 : W.codeName, a = E(!1), u = E(!1), c = E(), f = E(), h = E(), w = [50, 100], b = E(!1), {
      zIndex: I
    } = e.controller.grid.state, P = n(() => {
      const {
        deuiactionGroup: t
      } = i.model;
      return t != null && t.uiactionGroupDetails ? t.uiactionGroupDetails.filter((d) => w.findIndex((s) => s === d.actionLevel) === -1) : [];
    }), L = n(() => {
      const {
        deuiactionGroup: t
      } = i.model;
      return t != null && t.uiactionGroupDetails ? t.uiactionGroupDetails.filter((d) => w.findIndex((s) => s === d.actionLevel) !== -1) : [];
    }), m = n(() => !(i.grid.model.controlType === "TREEGRID" && !i.grid.state.showTreeGrid)), R = async (t, d) => {
      await i.setRowValue(e.row, t, d);
    }, S = () => {
      switch (ibiz.config.grid.editShowMode) {
        case "cell":
          return ze(e, o);
        case "row":
          return Ve(e);
        case "all":
          return De(e);
        default:
          throw new re("".concat(ibiz.config.grid.editShowMode, "暂未支持"));
      }
    }, {
      gridEditItemProps: p,
      editorProps: M
    } = S(), G = (t) => {
      e.row.editColStates[i.fieldName].editable = t;
    };
    ie(() => {
      e.row.data.srfuf === F.CREATE && G(!0);
    });
    const z = (t) => {
      e.controller.hasAction && (t.stopPropagation(), e.controller.triggerAction(e.row, t));
    }, V = (t) => {
      e.controller.isLinkColumn && (t.stopPropagation(), e.controller.openLinkView(e.row, t));
    }, T = n(() => i.getCustomHtml(e.row)), k = n(() => e.row.uiActionGroupStates[i.model.codeName]), y = n(() => e.row.data[e.controller.model.codeName.toLowerCase()]), Y = n(() => i.formatValue(y.value)), O = E(void 0), se = (t) => {
      O.value = t;
    }, ae = n(() => {
      if (e.controller.grid.overflowMode === "ellipsis" && le(y.value) && y.value !== "")
        return O.value ? O.value : Y.value + (e.controller.model.unitName || "");
    }), de = (t, d) => {
      const s = {
        ...d
      };
      if (f.value) {
        const g = f.value.querySelector(".".concat(t.id));
        g && (s.target = g);
      }
      return s;
    }, B = async (t, d) => {
      var A, N;
      d.stopPropagation(), b.value = !0;
      const s = {
        context: i.context,
        params: i.params,
        data: [e.row.data],
        view: i.grid.view,
        event: de(t, d)
      }, g = await Le.exec(t.uiactionId, s, t.appId);
      if (g.cancel || (u.value = !1), b.value = !1, g.closeView)
        s.view.modal.ignoreDismissCheck = !0, s.view.closeView({
          ok: !0
        });
      else if (g.refresh)
        switch (g.refreshMode) {
          case 1:
            s.view.callUIAction(H.REFRESH);
            break;
          case 2:
            (A = s.view.parentView) == null || A.callUIAction(H.REFRESH);
            break;
          case 3:
            (N = s.view.getTopView()) == null || N.callUIAction(H.REFRESH);
            break;
        }
    }, ce = async (t, d, s) => {
      const g = s || t.editItem.codeName;
      await i.setRowValue(e.row, d, g);
      const A = t.editor.model.editorType;
      ["TEXTBOX", "PASSWORD", "TEXTAREA", "TEXTAREA_10", "NUMBER", "SOLIDER", "STEPPER"].includes(A) || (_(), u.value = !1);
    }, ue = () => {
      _(), u.value = !1, i.grid.saveAll();
    }, me = (t) => {
      var N, J;
      const d = t.editItem.codeName, s = e.row.data[d], g = (N = e.row.editColStates[d]) == null ? void 0 : N.readonly, A = (J = e.row.editColStates[d]) == null ? void 0 : J.disabled;
      return t.editorProvider && K(C(t.editorProvider.gridEditor), {
        class: l.e("editor"),
        value: g ? t.formatValue(s) : s,
        data: e.row.data,
        controller: t.editor,
        overflowMode: i.grid.overflowMode,
        onChange: (Q, ke) => ce(t, Q, ke),
        onEnter: (Q) => ue(),
        readonly: g,
        disabled: A
      });
    }, fe = () => {
      a.value = !0;
    }, _ = () => {
      a.value = !1;
    }, ve = (t) => {
      t.stopPropagation(), t.preventDefault();
    }, he = (t) => {
      t.stopPropagation(), G(!0);
    }, we = () => {
      const d = Object.values(i.grid.columns).filter((s) => s.enableRowEdit && s.model.id !== i.model.id).map((s) => {
        const {
          caption: g
        } = s.model, A = s.model.sysImage || {
          cssClass: "fa fa-bars"
        };
        return r(C("el-popover"), {
          placement: "right-start",
          width: "280",
          teleported: !1,
          offset: 16,
          trigger: "click"
        }, {
          reference: () => r("div", {
            class: l.bem("actions-popper", "action-group", "edit-column")
          }, [r(C("iBizIcon"), {
            icon: A
          }, null), g]),
          default: () => r("div", {
            onMouseenter: fe,
            onMouseleave: _,
            ref: c,
            onClick: (N) => ve(N)
          }, [me(s)])
        });
      });
      return d.length > 0 ? r("div", {
        class: l.be("actions-popper", "edit-group")
      }, [d]) : null;
    }, Ce = (t) => r(C("el-button"), {
      text: !0,
      size: "small",
      onClick: (d) => B(t, d),
      title: t.tooltipLanguageRes ? ibiz.i18n.t(t.tooltipLanguageRes.lanResTag, t.tooltip) : t.tooltip,
      disabled: k.value[t.id].disabled,
      class: j(t)
    }, {
      default: () => [t.showIcon && t.sysImage && r("div", {
        class: l.be("action", "icon")
      }, [r(C("iBizIcon"), {
        icon: t.sysImage
      }, null)]), t.showCaption ? t.capLanguageRes ? ibiz.i18n.t(t.capLanguageRes.lanResTag, t.caption) : t.caption : ""]
    }), ge = () => {
      let t = null;
      const d = [];
      return L.value.forEach((s) => {
        s.uiactionId && s.uiactionId.includes("get_editor_column") ? t = we() : k.value[s.id].visible && d.push(Ce(s));
      }), r("div", {
        class: l.be("actions-popper", "action-group"),
        ref: f
      }, [t, ...d]);
    }, be = () => {
      const t = c.value, d = Z(f, async (s) => {
        b.value || (Te(), u.value || d.stop());
      }, {
        ignore: [t]
      });
    }, Ee = (t) => {
      t.stopPropagation(), u.value = !u.value;
    }, Ie = () => {
      i.grid.saveAll();
    }, j = (t) => {
      const {
        actionLevel: d
      } = t;
      return [t.id, l.e("item"), l.is("disabled", !1), l.em("item", "level-".concat(d))];
    }, Re = () => r(C("el-popover"), {
      visible: u.value,
      popperClass: l.b("actions-popper"),
      placement: "right-start",
      width: "280",
      trigger: "click",
      onShow: () => {
        be();
      },
      onHide: () => {
        Ie();
      },
      "popper-style": {
        zIndex: I
      },
      ref: h
    }, {
      reference: () => r(C("el-button"), {
        text: !0,
        size: "small",
        class: "hover-action",
        onClick: (t) => Ee(t),
        title: "更多"
      }, {
        icon: () => r(C("ion-icon"), {
          name: "ellipsis-vertical-outline"
        }, null)
      }),
      default: () => ge()
    }), ye = () => P.value.map((t) => {
      if (k.value[t.id].visible && (t.actionLevel === 250 || m.value && t.actionLevel === 200))
        return r(C("el-button"), {
          text: !0,
          size: "small",
          onClick: (d) => B(t, d),
          title: t.tooltipLanguageRes ? ibiz.i18n.t(t.tooltipLanguageRes.lanResTag, t.tooltip) : t.tooltip,
          disabled: k.value[t.id].disabled,
          class: j(t)
        }, {
          default: () => [t.showIcon && t.sysImage && r(C("iBizIcon"), {
            icon: t.sysImage
          }, null), t.showCaption ? t.capLanguageRes ? ibiz.i18n.t(t.capLanguageRes.lanResTag, t.caption) : t.caption : ""]
        });
    }), xe = () => {
      const {
        enableRowEdit: t,
        deuiactionGroup: d
      } = i.model, s = [];
      return t && s.push(r(C("el-button"), {
        text: !0,
        size: "small",
        class: "hover-action",
        onClick: (g) => he(g),
        title: "编辑"
      }, {
        default: () => [r("svg", {
          viewBox: "0 0 16 16",
          xmlns: "http://www.w3.org/2000/svg",
          height: "1em",
          width: "1em",
          preserveAspectRatio: "xMidYMid meet",
          focusable: "false"
        }, [r("g", {
          id: "aiuaction/edit",
          "stroke-width": "1",
          "fill-rule": "evenodd"
        }, [r("path", {
          d: "M2 8.34L10.71 0 15 4.17 6.538 13H2V8.34zm1.2.512V11.8h2.826l7.283-7.6-2.606-2.533L3.2 8.852zM0 16v-1.2h16V16H0z",
          id: "aiu编辑"
        }, null)])])]
      })), d && (s.push(ye()), L.value.length > 0 && s.push(Re())), s;
    }, Te = () => {
      a.value || (u.value = !1);
    };
    return {
      ns: l,
      componentRef: o,
      fieldName: v,
      gridEditItemProps: p,
      rowDataChange: R,
      editorProps: M,
      onCellClick: z,
      onTextClick: V,
      onInfoTextChange: se,
      onActionClick: B,
      renderActions: xe,
      CustomHtml: T,
      fieldValue: y,
      formatValue: Y,
      tooltip: ae
    };
  },
  render() {
    var o;
    const e = this.controller;
    let l = null;
    return e.isCustomCode ? l = r("span", {
      class: this.ns.e("script"),
      innerHTML: this.CustomHtml
    }, null) : e.codeList ? l = r(C("iBizCodeList"), {
      class: this.ns.e("text"),
      codeListItems: e.codeListItems,
      codeList: e.codeList,
      value: this.fieldValue,
      onClick: this.onTextClick,
      onInfoTextChange: this.onInfoTextChange,
      title: this.tooltip
    }, null) : l = r("span", {
      class: this.ns.e("text"),
      title: this.tooltip,
      onClick: this.onTextClick
    }, [this.formatValue, this.fieldValue != null && e.model.unitName]), r("div", {
      class: [this.ns.b(), e.clickable(this.row) && this.ns.m("clickable"), this.ns.m(this.controller.grid.overflowMode), (o = this.controller.model.cellSysCss) == null ? void 0 : o.cssName, this.ns.is("has-action", !!e.model.deuiactionGroup)],
      onClick: this.onCellClick
    }, [e.model.enableRowEdit ? r(C("iBizGridEditItem"), {
      ref: "componentRef",
      required: !e.editItem.allowEmpty,
      error: this.row.errors[this.fieldName],
      overflowMode: this.controller.grid.overflowMode,
      class: this.ns.m("edit-item"),
      ...this.gridEditItemProps
    }, {
      default: () => [e.editorProvider && K(C(e.editorProvider.gridEditor), {
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
    }) : r("div", {
      class: this.ns.b("text-container")
    }, [l]), e.model.enableRowEdit && !this.editorProps.readonly ? null : r("div", {
      class: this.ns.b("toolbar-container")
    }, [this.renderActions()])]);
  }
});
class Fe {
  constructor() {
    $(this, "component", "GridEditColumn");
  }
  async createController(l, o) {
    const i = new te(l, o);
    return await i.init(), i;
  }
}
function Oe(e, l) {
  const o = e.controller, i = n(() => e.row.editColStates[o.name].disabled), v = n(() => e.row.editColStates[o.name].readonly), a = n(() => !!e.row.errors[o.name]), u = n(() => e.row.editColStates[o.name].editable), c = (T) => {
    e.row.editColStates[o.name].editable = T;
  }, f = n(() => !i.value && !v.value && !a.value), h = n(() => a.value || f.value && u.value), w = n(() => !h.value), b = !1, I = !0, P = n(() => !1), L = n(() => u.value);
  let m = e.row.data[e.controller.name];
  const R = E(!1), S = () => {
    ibiz.log.debug("".concat(o.name, "属性编辑器focus事件"));
  }, p = () => {
    var T, k;
    ibiz.log.debug("".concat(o.name, "属性编辑器blur事件")), !R.value && (c(!1), ((T = o.nodeColumn.userParam) == null ? void 0 : T.SAVEMODE) === "BLUR" ? o.treeGrid.save(e.row.data) : ((k = e.row.data._deData) == null ? void 0 : k.srfuf) === F.CREATE ? o.treeGrid.remove({ data: [e.row.data], silent: !0 }) : o.setRowValue(e.row, m));
  }, M = async () => {
    R.value = !0, await o.treeGrid.save(e.row.data), m = e.row.data[e.controller.name], c(!1), R.value = !1;
  }, G = (T) => {
    T.keyCode === 27 && c(!1);
  }, z = x({
    showEditMask: P,
    stopPropagation: L
  }), V = x({
    autoFocus: I,
    disabled: b,
    readonly: w,
    onBlur: p,
    onFocus: S,
    onEnter: M,
    onKeydown: G
  });
  return {
    gridEditItemProps: z,
    editorProps: V
  };
}
function Be(e, l) {
  const o = e.controller, i = n(() => e.row.editColStates[o.name].disabled), v = n(() => e.row.editColStates[o.name].readonly), a = n(() => e.row.editColStates[o.name].editable), u = n(() => v.value || !a.value), c = n(() => a.value && i.value), f = n(() => a.value), h = x({
    stopPropagation: f
  }), w = x({
    disabled: c,
    readonly: u
  });
  return {
    gridEditItemProps: h,
    editorProps: w
  };
}
function _e(e, l) {
  const o = e.controller, i = n(() => e.row.editColStates[o.name].disabled), v = n(() => e.row.editColStates[o.name].readonly), a = n(() => e.controller.treeGrid.state.rowEditOpen), u = n(() => v.value || !a.value), c = n(() => a.value && i.value), f = n(() => a.value), h = () => {
    o.treeGrid.save(e.row.data);
  }, w = x({
    stopPropagation: f
  }), b = x({
    disabled: c,
    readonly: u,
    onBlur: h
  });
  return {
    gridEditItemProps: w,
    editorProps: b
  };
}
const $e = /* @__PURE__ */ X({
  name: "TreeGridExEditColumn",
  props: {
    controller: {
      type: Me,
      required: !0
    },
    row: {
      type: oe,
      required: !0
    }
  },
  setup(e) {
    const l = n(() => e.row.data[e.controller.name]), o = D("tree-grid-ex-edit-column"), i = E(), v = e.controller, a = async (I, P) => {
      ibiz.log.debug("".concat(v.name, "值变更"), I), await v.setRowValue(e.row, I, P);
    }, u = () => {
      switch (ibiz.config.grid.editShowMode) {
        case "cell":
          return Oe(e);
        case "row":
          return Be(e);
        case "all":
          return _e(e);
        default:
          throw new re("".concat(ibiz.config.grid.editShowMode, "暂未支持"));
      }
    }, {
      gridEditItemProps: c,
      editorProps: f
    } = u(), h = E(void 0), w = (I) => {
      h.value = I;
    }, b = n(() => {
      if (f.readonly)
        return Ge(h.value) ? v.formatValue(l.value) : h.value;
    });
    return {
      ns: o,
      fieldValue: l,
      componentRef: i,
      tooltip: b,
      rowDataChange: a,
      onInfoTextChange: w,
      gridEditItemProps: c,
      editorProps: f
    };
  },
  render() {
    return r(C("iBizGridEditItem"), {
      ref: "componentRef",
      required: !this.controller.nodeEditItem.allowEmpty,
      overflowMode: this.controller.overflowMode,
      class: [this.ns, this.ns.m(this.controller.overflowMode)],
      ...this.gridEditItemProps
    }, {
      default: () => [this.controller.editorProvider && K(C(this.controller.editorProvider.gridEditor), {
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
const q = /* @__PURE__ */ X({
  name: "TreeGridExFieldColumn",
  props: {
    controller: {
      type: ne,
      required: !0
    },
    row: {
      type: oe,
      required: !0
    }
  },
  setup(e) {
    const l = D("tree-grid-ex-field-column"), o = D("tree-grid-ex-field-edit-column"), i = n(() => e.controller.nodeColumnControllerMap.get(e.row.data._nodeId)), v = n(() => e.row.editColStates[i.value.name].editable), a = (m) => {
      e.row.editColStates[i.value.name].editable = m;
    }, u = (m) => {
      m.stopPropagation(), a(!0);
    };
    ie(() => {
      e.row.data.srfuf === F.CREATE && a(!0);
    });
    const c = n(() => e.row.data._nodeType !== "DE" && e.controller.isFirstShowColumn ? e.row.data._text : e.row.data[e.controller.name]), f = E(""), h = (m) => {
      f.value = m;
    }, w = n(() => {
      const m = i.value;
      return m ? m.nodeEditItem ? void 0 : m.codeList ? f.value : m.formatValue(c.value) + (m.unitName || "") : c.value;
    }), b = n(() => {
      if (e.controller.treeGrid.overflowMode === "ellipsis" && le(c.value) && c.value !== "")
        return w.value;
    }), I = n(() => c.value && i.value && (i.value.isLinkColumn || i.value.hasClickAction));
    return {
      ns: l,
      ns2: o,
      nodeColumn: i,
      fieldValue: c,
      showText: w,
      clickable: I,
      tooltip: b,
      editable: v,
      onInfoTextChange: h,
      onTextClick: (m) => {
        var R;
        (R = i.value) == null || R.onTextClick(e.row, m);
      },
      onActionClick: async (m, R) => {
        var S;
        await ((S = i.value) == null ? void 0 : S.onActionClick(m, e.row, R));
      },
      onOpenEdit: u
    };
  },
  render() {
    var i, v, a, u;
    let e = null;
    (i = this.nodeColumn) != null && i.nodeEditItem ? e = r($e, {
      controller: this.nodeColumn,
      row: this.row
    }, null) : (v = this.nodeColumn) != null && v.codeList ? e = r(C("iBizCodeList"), {
      class: this.ns.e("text"),
      codeListItems: this.nodeColumn.codeListItems,
      codeList: this.nodeColumn.codeList,
      value: this.fieldValue,
      onClick: this.onTextClick,
      onInfoTextChange: this.onInfoTextChange,
      title: this.tooltip
    }, null) : e = r("span", {
      class: this.ns.e("text"),
      title: this.tooltip,
      onClick: this.onTextClick
    }, [this.showText]);
    let l;
    this.$slots.actions ? l = this.$slots.actions() : this.row.columnActionsStates[this.controller.name] && (l = r(C("iBizActionToolbar"), {
      class: this.ns.e("toolbar"),
      "action-details": (a = this.nodeColumn) == null ? void 0 : a.nodeColumn.deuiactionGroup.uiactionGroupDetails,
      "actions-state": this.row.columnActionsStates[this.controller.name],
      groupLevelKeys: [50, 100],
      onActionClick: this.onActionClick
    }, null));
    const o = r(C("el-button"), {
      text: !0,
      size: "small",
      class: "hover-action",
      onClick: (c) => this.onOpenEdit(c),
      title: "编辑"
    }, {
      default: () => [r("svg", {
        viewBox: "0 0 16 16",
        xmlns: "http://www.w3.org/2000/svg",
        height: "1em",
        width: "1em",
        preserveAspectRatio: "xMidYMid meet",
        focusable: "false"
      }, [r("g", {
        id: "aiuaction/edit",
        "stroke-width": "1",
        "fill-rule": "evenodd"
      }, [r("path", {
        d: "M2 8.34L10.71 0 15 4.17 6.538 13H2V8.34zm1.2.512V11.8h2.826l7.283-7.6-2.606-2.533L3.2 8.852zM0 16v-1.2h16V16H0z",
        id: "aiu编辑"
      }, null)])])]
    });
    return r("div", {
      class: [this.ns.b(), this.ns2.b(), this.clickable && this.ns.m("clickable"), this.ns.m(this.controller.treeGrid.overflowMode), (u = this.controller.model.cellSysCss) == null ? void 0 : u.cssName, this.ns2.is("editable", this.editable), this.ns.is("has-action", !!l)]
    }, [r("div", {
      class: this.ns.b("text-container")
    }, [e]), r("div", {
      class: this.ns.b("toolbar-container")
    }, [this.editable ? null : [o, l]])]);
  }
});
class He {
  constructor() {
    $(this, "component", "TreeGridExFieldColumn");
  }
  async createController(l, o) {
    const i = new ne(l, o);
    return await i.init(), i;
  }
}
const Ue = ee(
  U,
  function(e) {
    e.component(U.name, U), Ne(
      "GRID_COLRENDER_COLUMN_ACTION_EDIT",
      () => new Fe()
    );
  }
), qe = ee(
  q,
  function(e) {
    e.component(q.name, q), pe(
      "GRID_COLRENDER_COLUMN_ACTION_EDIT",
      () => new He()
    );
  }
), Qe = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(e) {
    e.use(Ue), e.use(qe);
  }
};
export {
  Ue as IBizGridEditColumn,
  qe as IBizTreeGridExFieldColumn,
  Qe as default
};
