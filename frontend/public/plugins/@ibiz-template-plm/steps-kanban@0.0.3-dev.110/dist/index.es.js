import './style.css';
var ee = Object.defineProperty;
var te = (d, n, t) => n in d ? ee(d, n, { enumerable: !0, configurable: !0, writable: !0, value: t }) : d[n] = t;
var M = (d, n, t) => (te(d, typeof n != "symbol" ? n + "" : n, t), t);
import { useControlController as ne, useNamespace as oe, withInstall as le } from "@ibiz-template/vue3-util";
import { KanbanController as re, registerControlProvider as se } from "@ibiz-template/runtime";
import { defineComponent as ae, ref as R, computed as W, onMounted as ie, onBeforeUnmount as ce, createVNode as o, resolveComponent as i, createTextVNode as w } from "vue";
import N from "vuedraggable";
import { listenJSEvent as de, NOOP as V } from "@ibiz-template/core";
class ue extends re {
  constructor() {
    super(...arguments);
    /**
     *
     *
     * @memberof StepsKanbanController
     */
    M(this, "splitMap", /* @__PURE__ */ new Map());
    /**
     * 步骤分组标识
     *
     * @type {(string | number)}
     * @memberof StepsKanbanController
     */
    M(this, "splitGroupKey", "");
  }
  /**
   * 处理数据分组
   *
   * @memberof StepsKanbanController
   */
  async handleDataGroup() {
    if (await super.handleDataGroup(), this.state.groups.length > 0) {
      const t = this.state.groups.find((h) => {
        if (this.groupCodeListItems.find(
          (u) => u.value === h.key
        ).data === 1)
          return this.splitGroupKey = h.key, !0;
      });
      if (t) {
        const h = t.children.filter(
          (u) => !Object.is(u.entry_status, "2")
        ), p = t.children.filter(
          (u) => Object.is(u.entry_status, "2")
        );
        this.splitMap.set("".concat(t.key, "_runing"), { children: h }), this.splitMap.set("".concat(t.key, "_finish"), { children: p });
      }
    }
  }
  async onDragChange(t, h) {
    if (!this.enableEditGroup && t.from !== t.to) {
      ibiz.message.warning("当前看板不允许调整分组！");
      return;
    }
    const p = this.model.minorSortDir === "ASC", { from: u, to: L, fromIndex: y, toIndex: k } = t, A = this.model.groupAppDEFieldId, m = this.model.minorSortAppDEFieldId, v = [];
    let f = this.state.groups.find((s) => s.key === u), b = this.state.groups.find((s) => s.key === L);
    if (f || (f = this.splitMap.get(u)), b || (b = this.splitMap.get(L)), !this.enableEditOrder) {
      if (t.from === t.to) {
        ibiz.message.warning("当前看板不允许调整次序");
        return;
      }
      const s = f.children[y];
      return s[A] = t.to, this.updateChangedItems([s]);
    }
    const $ = (s) => s + (100 - s % 100), x = [...b.children], D = [...b.children], F = f.children[y];
    if (t.from !== t.to) {
      let s = t.to;
      h && (s = t.to.split("_")[0]), F[A] = s, D.splice(k, 0, F);
    } else
      D.splice(y, 1), D.splice(k, 0, F);
    const T = f.children.splice(y, 1);
    b.children.splice(k, 0, ...T), p || (x.reverse(), D.reverse());
    let g, S = [], B;
    D.forEach((s, I) => {
      g === void 0 ? (s !== x[I] || h && I === y) && (x[I] ? g = x[I][m] || 100 : g = I === 0 ? 100 : $(x[I - 1][m]), s[m] = g, v.push(s)) : (g >= s[m] ? (S.length > 0 && (S.forEach((K) => {
        K[m] = $(B), v.push(K), B = K[m];
      }), g = B, B = 0, S = []), s[m] = $(g), v.push(s)) : (S.length === 0 && (B = g), S.push(s)), g = s[m]);
    }), this.filterGroupField(v, A), this.updateChangedItems(v);
  }
  /**
   * 过滤分组属性
   *
   * @param {IData[]} items
   * @param {string} groupField
   * @memberof StepsKanbanController
   */
  filterGroupField(t, h) {
    t.forEach((p) => {
      const u = p[h];
      u.endsWith("_runing") ? p.entry_status = "1" : u.endsWith("_finish") && (p.entry_status = "2"), p[h] = u.replace("_runing", "").replace("_finish", "");
    });
  }
}
const P = /* @__PURE__ */ ae({
  name: "IBizStepsKanbanControl",
  components: {
    draggable: N
  },
  props: {
    modelData: {
      type: Object,
      required: !0
    },
    context: {
      type: Object,
      required: !0
    },
    params: {
      type: Object,
      default: () => ({})
    },
    provider: {
      type: Object
    },
    mdctrlActiveMode: {
      type: Number,
      default: void 0
    },
    singleSelect: {
      type: Boolean,
      default: void 0
    },
    loadDefault: {
      type: Boolean,
      default: !0
    }
  },
  setup(d) {
    var j, U, q;
    const n = ne((...e) => new ue(...e)), t = oe("control-".concat(n.model.controlType.toLowerCase())), h = R(), p = R(!1), u = W(() => !n.state.draggable || n.state.updating), L = W(() => n.state.batching ? n.state.selectGroupKey : ""), y = (j = n.model.controls) == null ? void 0 : j.find((e) => e.name === "".concat(n.model.name, "_quicktoolbar") || e.name === "".concat(n.model.name, "_groupquicktoolbar")), k = (U = n.model.controls) == null ? void 0 : U.find((e) => e.name === "".concat(n.model.name, "_batchtoolbar")), A = ((q = n.model.groupSysCss) == null ? void 0 : q.cssName) || "", m = R({});
    let v = V;
    const f = {};
    switch (n.model.groupLayout) {
      case "ROW":
        f.width = "".concat(n.model.groupWidth || 300, "px"), f.height = "100%";
        break;
      case "COLUMN":
        f.width = "100%", f.height = "".concat(n.model.groupHeight || 500, "px");
        break;
    }
    const b = (e) => {
      e.stopPropagation();
    }, $ = (e, l) => {
      b(l);
      const r = String(e.key);
      m.value[r] = !m.value[r];
    }, x = (e, l) => (b(l), n.onRowClick(e)), D = (e, l) => (b(l), n.onDbRowClick(e)), F = (e, l) => (b(e), n.onClickNew(e, l)), T = (e, l) => {
      const r = e.selectedData || [];
      l ? r.forEach((a) => {
        n.onRowClick(a);
      }) : e.children.filter((c) => !r.includes(c)).forEach((c) => {
        n.onRowClick(c);
      });
    }, g = (e) => n.groupCodeListItems.find((l) => l.value === e);
    ie(() => {
      v = de(window, "resize", () => {
        p.value = n.getFullscreen();
      });
    }), ce(() => {
      v !== V && v();
    });
    const S = (e, l) => {
      const {
        context: r,
        params: a
      } = n;
      return o(i("iBizControlShell"), {
        data: e,
        modelData: l,
        context: r,
        params: a
      }, null);
    }, B = (e, l) => {
      var r;
      return o(i("iBizActionToolbar"), {
        class: t.bem("item", "bottom", "actions"),
        "action-details": (r = n.getOptItemModel().deuiactionGroup) == null ? void 0 : r.uiactionGroupDetails,
        "actions-state": n.getOptItemAction(e),
        onActionClick: (a, c) => n.onGroupActionClick(a, e, c, l)
      }, null);
    }, s = (e) => {
      if (y)
        return o(i("iBizControlShell"), {
          class: t.e("quicktoolbar"),
          modelData: {
            ...y,
            name: "".concat(y.name, "_").concat(e.key)
          },
          context: n.context,
          params: n.params
        }, null);
    }, I = (e) => {
      if (k)
        return o("div", {
          class: t.be("batch", "toolbar")
        }, [o(i("iBizControlShell"), {
          modelData: {
            ...k,
            name: "".concat(k.name, "_").concat(e.key)
          },
          context: n.context,
          params: n.params
        }, null)]);
    }, K = (e) => {
      const l = e.selectedData || [], r = l.length === e.children.length, a = l.length > 0 && l.length < e.children.length;
      return o("div", {
        class: t.be("batch", "check")
      }, [o(i("el-checkbox"), {
        "model-value": r,
        indeterminate: a,
        onChange: () => T(e, r)
      }, {
        default: () => [w("全选")]
      }), o("span", {
        class: t.be("batch", "info")
      }, [w("已选择"), o("span", null, [l.length]), w("条数据")])]);
    }, H = (e) => {
      if (L.value === e.key)
        return o("div", {
          class: t.b("batch")
        }, [I(e), K(e)]);
    }, J = (e, l) => [o("div", {
      class: t.be("item", "top")
    }, [o("div", {
      class: t.bem("item", "top", "title")
    }, [e.srfmajortext]), o("div", {
      class: t.bem("item", "top", "description")
    }, [e.content])]), n.getOptItemModel() ? o("div", {
      class: t.be("item", "bottom")
    }, [B(e, l)]) : null], O = (e, l) => {
      const r = n.state.selectedData.findIndex((G) => G.srfkey === e.srfkey), a = [t.b("item"), t.is("selected", r !== -1), t.is("disabled", u.value)], c = {};
      n.model.cardWidth && (c.width = "".concat(n.model.cardWidth, "px")), n.model.cardHeight && (c.height = "".concat(n.model.cardHeight, "px"));
      const C = d.modelData.itemLayoutPanel;
      return o(i("el-card"), {
        shadow: "hover",
        class: a,
        "body-style": c,
        onClick: (G) => x(e, G),
        onDblclick: (G) => D(e, G)
      }, {
        default: () => [C ? S(e, C) : J(e, l)]
      });
    }, E = () => {
      if (n.state.isLoaded)
        return o(i("iBizNoData"), {
          text: n.model.emptyText,
          emptyTextLanguageRes: n.model.emptyTextLanguageRes
        }, null);
    };
    let _ = null;
    const z = (e, l, r, a) => {
      const c = a || l.key;
      if (e.moved && n.onDragChange({
        from: c,
        to: c,
        fromIndex: e.moved.oldIndex,
        toIndex: e.moved.newIndex
      }), e.added && (_ = {
        to: c,
        toIndex: e.added.newIndex
      }, r)) {
        const {
          id: C
        } = e.added.element, G = l.children.find((Z) => Z.id === C);
        G.entry_status = r;
      }
      e.removed && (_ && (_.from = c, _.fromIndex = e.removed.oldIndex, n.onDragChange(_, r)), _ = null);
    }, Q = () => {
      const e = h.value.$el;
      p.value = n.onFullScreen(e);
    }, X = (e) => {
      const l = n.model.groupUIActionGroup && e.groupActionGroupState || k;
      return L.value === e.key ? o("span", {
        class: t.be("group", "header-right"),
        onClick: (r) => b(r)
      }, [o(i("el-button"), {
        text: !0,
        onClick: () => n.closeBatch()
      }, {
        default: () => [w("完成")]
      })]) : o("span", {
        class: t.be("group", "header-right"),
        onClick: (r) => b(r)
      }, [n.enableNew && o(i("el-button"), {
        class: t.be("group", "header-new"),
        text: !0,
        circle: !0,
        onClick: (r) => {
          F(r, e.key);
        }
      }, {
        default: () => [o(i("ion-icon"), {
          name: "add-outline",
          title: "新建"
        }, null)]
      }), l && o(i("el-dropdown"), {
        class: t.be("group", "header-actions"),
        trigger: "click",
        teleported: !1
      }, {
        default: () => o("span", null, [w("···")]),
        dropdown: () => o("div", {
          class: t.be("group", "actions-dropdown")
        }, [n.model.groupUIActionGroup && e.groupActionGroupState && o(i("iBizActionToolbar"), {
          actionDetails: n.model.groupUIActionGroup.uiactionGroupDetails,
          actionsState: e.groupActionGroupState,
          onActionClick: (r, a) => {
            n.onGroupToolbarClick(r, a, e);
          }
        }, null), k && o(i("el-button"), {
          size: "small",
          onClick: () => {
            n.openBatch(e.key);
          }
        }, {
          default: () => [o(i("ion-icon"), {
            name: "checkmark-sharp"
          }, null), w("批量操作")]
        })])
      })]);
    }, Y = (e) => {
      if (n.splitGroupKey === e.key) {
        const l = n.splitMap.get("".concat(e.key, "_runing")), r = n.splitMap.get("".concat(e.key, "_finish"));
        return o("div", {
          class: t.b("split")
        }, [o("div", {
          class: t.be("split", "left")
        }, [o("div", {
          class: t.be("split", "header")
        }, [w("进行中")]), o(N, {
          class: t.be("group", "draggable"),
          modelValue: l.children,
          group: n.model.id,
          itemKey: "srfkey",
          disabled: u.value,
          onChange: (a) => z(a, e, "1", "".concat(e.key, "_runing"))
        }, {
          item: ({
            element: a
          }) => O(a, e),
          header: () => l.children.length ? null : o("div", {
            class: [t.be("group", "list"), t.is("empty", !0)]
          }, [E()])
        }), s(e)]), o("div", {
          class: t.be("split", "right")
        }, [o("div", {
          class: t.be("split", "header")
        }, [w("已完成")]), o(N, {
          class: t.be("group", "draggable"),
          modelValue: r.children,
          group: n.model.id,
          itemKey: "srfkey",
          disabled: u.value,
          onChange: (a) => z(a, e, "2", "".concat(e.key, "_finish"))
        }, {
          item: ({
            element: a
          }) => O(a, e),
          header: () => r.children.length ? null : o("div", {
            class: [t.be("group", "list"), t.is("empty", !0)]
          }, [E()])
        }), s(e)])]);
      }
      return [o(N, {
        class: t.be("group", "draggable"),
        modelValue: e.children,
        group: n.model.id,
        itemKey: "srfkey",
        disabled: u.value,
        onChange: (l) => z(l, e)
      }, {
        item: ({
          element: l
        }) => O(l, e),
        header: () => e.children.length ? null : o("div", {
          class: t.be("group", "list")
        }, [E()])
      }), s(e)];
    };
    return {
      c: n,
      ns: t,
      isFull: p,
      kanban: h,
      onFullScreen: Q,
      renderGroup: (e) => {
        const l = g(e.key), r = m.value[String(e.key)], a = n.model.groupLayout === "COLUMN", c = {
          ...f
        };
        if (r && (c.height = "50px"), l.data === 1) {
          const C = f.width.slice(0, -2);
          c.width = "".concat(Number(C) * 2, "px");
        }
        return !r || a ? o("div", {
          class: [t.b("group"), t.is("collapse", r), A],
          style: c
        }, [o("div", {
          class: t.be("group", "header"),
          style: {
            borderTopColor: e.color || "transparent"
          },
          onClick: (C) => $(e, C)
        }, [o("div", {
          class: t.be("group", "header-left")
        }, [o(i("ion-icon"), {
          name: "caret-down-sharp"
        }, null), o("span", {
          class: [t.be("group", "header-caption"), t.is("badge", !!e.color)],
          style: {
            backgroundColor: e.color
          }
        }, ["".concat(e.caption).concat(e.children.length ? " · ".concat(e.children.length) : "")])]), X(e)]), H(e), o("div", {
          class: [t.be("group", "list"), t.is("empty", !e.children.length)]
        }, [Y(e)])]) : o("div", {
          class: [t.b("group"), t.is("collapse", r), A]
        }, [o("div", {
          class: t.be("group", "header"),
          style: {
            borderTopColor: e.color || "transparent"
          },
          onClick: (C) => $(e, C)
        }, [o("span", {
          class: [t.be("group", "header-caption"), t.is("badge", !!e.color)],
          style: {
            backgroundColor: e.color
          }
        }, ["".concat(e.caption).concat(e.children.length ? " · ".concat(e.children.length) : "")]), o(i("ion-icon"), {
          name: "caret-forward-sharp"
        }, null)])]);
      }
    };
  },
  render() {
    var t;
    const {
      groups: d,
      isCreated: n
    } = this.c.state;
    return n ? o(i("iBizControlBase"), {
      ref: "kanban",
      controller: this.c,
      class: [this.ns.m((t = this.modelData.groupLayout) == null ? void 0 : t.toLowerCase()), this.ns.is("full", this.isFull), this.ns.is("plugin", !0)]
    }, {
      default: () => [o("div", {
        class: this.ns.b("group-container")
      }, [d.length > 0 && d.map((h) => this.renderGroup(h))]), d.length > 0 && o("div", {
        class: this.ns.e("full-btn"),
        onClick: this.onFullScreen
      }, [this.isFull ? o(i("ion-icon"), {
        name: "contract-outline"
      }, null) : o(i("ion-icon"), {
        name: "expand-outline"
      }, null)])]
    }) : null;
  }
});
class he {
  constructor() {
    M(this, "component", "IBizStepsKanbanControl");
  }
}
const pe = le(
  P,
  function(d) {
    d.component(P.name, P), se(
      "CUSTOM_STEPS_KANBAN",
      () => new he()
    );
  }
), ve = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(d) {
    d.use(pe);
  }
};
export {
  pe as IBizStepsKanbanControl,
  ve as default
};
