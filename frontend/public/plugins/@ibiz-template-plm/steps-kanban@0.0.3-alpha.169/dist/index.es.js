import './style.css';
var ae = Object.defineProperty;
var le = (l, n, t) => n in l ? ae(l, n, { enumerable: !0, configurable: !0, writable: !0, value: t }) : l[n] = t;
var M = (l, n, t) => (le(l, typeof n != "symbol" ? n + "" : n, t), t);
import { useControlController as re, useNamespace as se, withInstall as ce } from "@ibiz-template/vue3-util";
import { KanbanController as de, calcDeCodeNameById as ue, registerControlProvider as he } from "@ibiz-template/runtime";
import { defineComponent as Z, ref as F, computed as K, onMounted as ee, watch as me, createVNode as o, resolveComponent as s, mergeProps as pe, onBeforeUnmount as fe, createTextVNode as A } from "vue";
import H from "vuedraggable";
import { toNumberOrNil as Q, RuntimeModelError as X, clone as ge, listenJSEvent as be, NOOP as Y } from "@ibiz-template/core";
class ye extends de {
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
    /**
     * @description 可视化数据长度
     * @type {number}
     * @memberof StepsKanbanController
     */
    M(this, "visiableLength", 10);
    /**
     * @description 分组项高度（计算虚拟列表时使用）
     * @type {number}
     * @memberof StepsKanbanController
     */
    M(this, "groupItemSize", 160);
  }
  async onCreated() {
    await super.onCreated(), this.visiableLength = Q(this.controlParams.visiablecount) || this.visiableLength, this.groupItemSize = Q(this.controlParams.groupitemsize) || this.groupItemSize;
  }
  /**
   * 处理数据分组
   *
   * @memberof StepsKanbanController
   */
  async handleDataGroup() {
    if (await super.handleDataGroup(), this.state.groups.length > 0) {
      const t = this.state.groups.find((c) => {
        if (this.groupCodeListItems.find(
          (u) => u.value === c.key
        ).data === 1)
          return this.splitGroupKey = c.key, !0;
      });
      if (t) {
        const c = t.children.filter(
          (u) => !Object.is(u.entry_status, "2")
        ), p = t.children.filter(
          (u) => Object.is(u.entry_status, "2")
        );
        this.splitMap.set("".concat(t.key, "_runing"), { children: c }), this.splitMap.set("".concat(t.key, "_finish"), { children: p });
      }
    }
  }
  /**
   * 拖拽变更事件处理回调
   * @author lxm
   * @date 2023-09-11 04:12:58
   * @param {IDragChangeInfo} info
   * @return {*}  {Promise<void>}
   */
  async onDragChange(t, c) {
    var _;
    if (!this.enableEditGroup && t.from !== t.to) {
      ibiz.message.warning(
        ibiz.i18n.t("runtime.controller.control.kanban.adjustmentsGroup")
      );
      return;
    }
    const { from: p, to: u, fromIndex: b, toIndex: $ } = t, d = this.model.groupAppDEFieldId, f = this.model.minorSortAppDEFieldId;
    let D = this.state.groups.find((h) => h.key === p), w = this.state.groups.find((h) => h.key === u);
    if (D || (D = this.splitMap.get(p)), w || (w = this.splitMap.get(u)), !this.enableEditOrder) {
      if (t.from === t.to) {
        ibiz.message.warning(
          ibiz.i18n.t("runtime.controller.control.kanban.noAllowReorder")
        );
        return;
      }
      const h = D.children[b];
      return h[d] = t.to, this.filterGroupField([h], d), this.updateChangedItems([h]);
    }
    const O = [...w.children];
    if (!((_ = this.model.moveControlAction) == null ? void 0 : _.appDEMethodId))
      throw new X(
        this.model,
        ibiz.i18n.t("runtime.controller.common.md.noMoveDataCconfig")
      );
    this.state.updating = !0;
    const S = (h, C, k, g, I) => {
      let L = {};
      const T = g[C];
      if (T)
        L = {
          srftargetkey: T.srfkey,
          srfmovetype: C < g.length - 1 || I ? "MOVEBEFORE" : "MOVEAFTER"
        };
      else {
        let N = [];
        if (g.length > 0 && (N = g), N.length > 0) {
          const R = N.reduce((E, B) => {
            const x = E[f] > B[f];
            return x && E[this.dataEntity.keyAppDEFieldId] !== k.srfkey ? E : !x && B[this.dataEntity.keyAppDEFieldId] !== k.srfkey ? B : E;
          });
          R && R[this.dataEntity.keyAppDEFieldId] !== k.srfkey && (L = {
            srftargetkey: R.srfkey,
            srfmovetype: "MOVEAFTER"
          });
        }
      }
      return L;
    }, y = ge(D.children[b]);
    if (t.from !== t.to) {
      let h = t.to;
      c && (h = t.to.split("_")[0]), y[d] = h;
    }
    const P = D.children.splice(b, 1);
    if (w.children.splice($, 0, ...P), t.from !== t.to) {
      y[d] = t.to;
      const h = ibiz.hub.getApp(this.model.appId), C = ue(this.model.appDataEntityId), k = this.context.clone();
      k[C] = y.srfkey, this.filterGroupField([y], d);
      try {
        await h.deService.exec(
          this.model.appDataEntityId,
          "update",
          k,
          y
        );
        const g = this.state.items.findIndex(
          (I) => I.srfkey === y[this.dataEntity.keyAppDEFieldId]
        );
        g !== -1 && this.state.items.splice(g, 1, y);
      } catch (g) {
        throw this.state.updating = !1, new X(
          this.model,
          ibiz.i18n.t("runtime.controller.common.md.changeGroupError")
        );
      }
    }
    const V = S(
      b,
      $,
      y,
      O,
      t.from !== t.to
    );
    try {
      const { ok: h, result: C } = await this.moveOrderItem(
        y,
        V
      );
      h && (Array.isArray(C) && C.length > 0 ? C.forEach((k) => {
        const g = this.state.items.findIndex(
          (I) => I.srfkey === k[this.dataEntity.keyAppDEFieldId]
        );
        g !== -1 && (this.state.items[g][f] = k[f]);
      }) : await this.refresh());
    } catch (h) {
      this.state.updating = !1, this.actionNotification("MOVEERROR", {
        error: h
      });
    } finally {
      await this.afterLoad({}, this.state.items), this.state.updating = !1;
    }
  }
  /**
   * 过滤分组属性
   *
   * @param {IData[]} items
   * @param {string} groupField
   * @memberof StepsKanbanController
   */
  filterGroupField(t, c) {
    t.forEach((p) => {
      const u = p[c];
      u.endsWith("_runing") ? p.entry_status = "1" : u.endsWith("_finish") && (p.entry_status = "2"), p[c] = u.replace("_runing", "").replace("_finish", "");
    });
  }
}
const ke = /* @__PURE__ */ Z({
  name: "VirtualDraggable",
  components: {
    draggable: H
  },
  props: {
    items: {
      type: Array,
      required: !0
    },
    count: {
      type: Number,
      default: 6
    },
    itemSize: {
      type: Number,
      default: 160
    }
  },
  emits: ["change"],
  setup(l, {
    emit: n
  }) {
    const t = F(l.count), c = F(), p = F(), u = K(() => l.items.slice(0, t.value)), b = (d) => {
      n("change", d);
    };
    return ee(() => {
      if (c.value) {
        const d = c.value.$el, f = l.items.length * l.itemSize + 16;
        d.style.height = "".concat(Math.max(f, d.offsetHeight), "px");
      }
    }), me(l.items, () => {
      if (c.value) {
        const d = c.value.$el;
        if (l.items.length) {
          const f = l.items.length * l.itemSize + 16;
          d.style.height = "".concat(Math.max(f, d.offsetHeight), "px");
        } else
          d.style.height = "inherit";
      }
    }, {
      immediate: !0
    }), {
      draggableRef: c,
      scrollbarRef: p,
      virtualData: u,
      handleScroll: ({
        scrollTop: d
      }) => {
        const f = Math.floor(d / l.itemSize);
        t.value = f + l.count;
      },
      onChange: b
    };
  },
  render() {
    return o(s("el-scrollbar"), {
      ref: "scrollbarRef",
      noresize: !0,
      onScroll: this.handleScroll
    }, {
      default: () => [o(H, pe({
        ref: "draggableRef",
        modelValue: this.virtualData,
        onChange: this.onChange
      }, this.$attrs), {
        ...this.$slots
      })]
    });
  }
});
const q = /* @__PURE__ */ Z({
  name: "IBizStepsKanbanControl",
  components: {
    draggable: H,
    "virtual-draggable": ke
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
  setup(l) {
    var U, W, J;
    const n = re((...e) => new ye(...e)), t = se("control-".concat(n.model.controlType.toLowerCase())), c = F(), p = F(!1), u = K(() => !n.state.draggable || n.state.updating), b = K(() => n.context.srfreadonly === !0 || n.context.srfreadonly === "true"), $ = K(() => n.state.batching ? n.state.selectGroupKey : ""), d = (U = n.model.controls) == null ? void 0 : U.find((e) => e.name === "".concat(n.model.name, "_quicktoolbar") || e.name === "".concat(n.model.name, "_groupquicktoolbar")), f = (W = n.model.controls) == null ? void 0 : W.find((e) => e.name === "".concat(n.model.name, "_batchtoolbar")), D = ((J = n.model.groupSysCss) == null ? void 0 : J.cssName) || "", w = F({});
    let O = Y;
    const z = {};
    switch (n.model.groupLayout) {
      case "ROW":
        z.width = "".concat(n.model.groupWidth || 300, "px"), z.height = "100%";
        break;
      case "COLUMN":
        z.width = "100%", z.height = "".concat(n.model.groupHeight || 500, "px");
        break;
    }
    const S = (e) => {
      e.stopPropagation();
    }, y = (e, i) => {
      S(i);
      const a = String(e.key);
      w.value[a] = !w.value[a];
    }, P = (e, i) => (S(i), n.onRowClick(e)), V = (e, i) => (S(i), n.onDbRowClick(e)), _ = (e, i) => (S(e), n.onClickNew(e, i)), h = (e, i) => {
      const a = e.selectedData || [];
      i ? a.forEach((r) => {
        n.onRowClick(r);
      }) : e.children.filter((m) => !a.includes(m)).forEach((m) => {
        n.onRowClick(m);
      });
    }, C = (e) => n.groupCodeListItems.find((i) => i.value === e);
    ee(() => {
      O = be(window, "resize", () => {
        p.value = n.getFullscreen();
      });
    }), fe(() => {
      O !== Y && O();
    });
    const k = (e, i) => {
      const {
        context: a,
        params: r
      } = n;
      return o(s("iBizControlShell"), {
        data: e,
        modelData: i,
        context: a,
        params: r
      }, null);
    }, g = (e, i) => {
      var a;
      return o(s("iBizActionToolbar"), {
        class: t.bem("item", "bottom", "actions"),
        "action-details": (a = n.getOptItemModel().deuiactionGroup) == null ? void 0 : a.uiactionGroupDetails,
        "actions-state": n.getOptItemAction(e),
        onActionClick: (r, m) => n.onGroupActionClick(r, e, m, i)
      }, null);
    }, I = (e) => {
      if (d)
        return o(s("iBizControlShell"), {
          class: t.e("quicktoolbar"),
          modelData: {
            ...d,
            name: "".concat(d.name, "_").concat(e.key)
          },
          context: n.context,
          params: n.params
        }, null);
    }, L = (e) => {
      if (f)
        return o("div", {
          class: t.be("batch", "toolbar")
        }, [o(s("iBizControlShell"), {
          modelData: {
            ...f,
            name: "".concat(f.name, "_").concat(e.key)
          },
          context: n.context,
          params: n.params
        }, null)]);
    }, T = (e) => {
      const i = e.selectedData || [], a = i.length === e.children.length, r = i.length > 0 && i.length < e.children.length;
      return o("div", {
        class: t.be("batch", "check")
      }, [o(s("el-checkbox"), {
        "model-value": a,
        indeterminate: r,
        onChange: () => h(e, a)
      }, {
        default: () => [A("全选")]
      }), o("span", {
        class: t.be("batch", "info")
      }, [A("已选择"), o("span", null, [i.length]), A("条数据")])]);
    }, N = (e) => {
      if ($.value === e.key)
        return o("div", {
          class: t.b("batch")
        }, [L(e), T(e)]);
    }, R = (e, i) => [o("div", {
      class: t.be("item", "top")
    }, [o("div", {
      class: t.bem("item", "top", "title")
    }, [e.srfmajortext]), o("div", {
      class: t.bem("item", "top", "description")
    }, [e.content])]), n.getOptItemModel() ? o("div", {
      class: t.be("item", "bottom")
    }, [g(e, i)]) : null], E = (e, i) => {
      const a = n.state.selectedData.findIndex((G) => G.srfkey === e.srfkey), r = [t.b("item"), t.is("selected", a !== -1), t.is("disabled", u.value)], m = {};
      n.model.cardWidth && (m.width = "".concat(n.model.cardWidth, "px")), n.model.cardHeight && (m.height = "".concat(n.model.cardHeight, "px"));
      const v = l.modelData.itemLayoutPanel;
      return o(s("el-card"), {
        shadow: "hover",
        class: r,
        "body-style": m,
        onClick: (G) => P(e, G),
        onDblclick: (G) => V(e, G)
      }, {
        default: () => [v ? k(e, v) : R(e, i)]
      });
    }, B = () => {
      if (n.state.isLoaded)
        return o(s("iBizNoData"), {
          text: n.model.emptyText,
          emptyTextLanguageRes: n.model.emptyTextLanguageRes
        }, null);
    };
    let x = null;
    const j = (e, i, a, r) => {
      const m = r || i.key;
      if (e.moved && n.onDragChange({
        from: m,
        to: m,
        fromIndex: e.moved.oldIndex,
        toIndex: e.moved.newIndex
      }), e.added && (x = {
        to: m,
        toIndex: e.added.newIndex
      }, a)) {
        const {
          id: v
        } = e.added.element, G = i.children.find((ie) => ie.id === v);
        G.entry_status = a;
      }
      e.removed && (x && (x.from = m, x.fromIndex = e.removed.oldIndex, n.onDragChange(x, a)), x = null);
    }, te = () => {
      const e = c.value.$el;
      p.value = n.onFullScreen(e);
    }, ne = (e) => {
      const i = n.model.groupUIActionGroup && e.groupActionGroupState || f;
      return $.value === e.key ? o("span", {
        class: t.be("group", "header-right"),
        onClick: (a) => S(a)
      }, [o(s("el-button"), {
        text: !0,
        onClick: () => n.closeBatch()
      }, {
        default: () => [A("完成")]
      })]) : o("span", {
        class: t.be("group", "header-right"),
        onClick: (a) => S(a)
      }, [n.enableNew && !b.value && o(s("el-button"), {
        class: t.be("group", "header-new"),
        text: !0,
        circle: !0,
        onClick: (a) => {
          _(a, e.key);
        }
      }, {
        default: () => [o(s("ion-icon"), {
          name: "add-outline",
          title: "新建"
        }, null)]
      }), i && !b.value && o(s("el-dropdown"), {
        class: t.be("group", "header-actions"),
        trigger: "click",
        teleported: !1
      }, {
        default: () => o("span", null, [A("···")]),
        dropdown: () => o("div", {
          class: t.be("group", "actions-dropdown")
        }, [n.model.groupUIActionGroup && e.groupActionGroupState && o(s("iBizActionToolbar"), {
          actionDetails: n.model.groupUIActionGroup.uiactionGroupDetails,
          actionsState: e.groupActionGroupState,
          onActionClick: (a, r) => {
            n.onGroupToolbarClick(a, r, e);
          }
        }, null), f && o(s("el-button"), {
          size: "small",
          onClick: () => {
            n.openBatch(e.key);
          }
        }, {
          default: () => [o(s("ion-icon"), {
            name: "checkmark-sharp"
          }, null), A("批量操作")]
        })])
      })]);
    }, oe = (e) => {
      if (n.splitGroupKey === e.key) {
        const i = n.splitMap.get("".concat(e.key, "_runing")), a = n.splitMap.get("".concat(e.key, "_finish"));
        return o("div", {
          class: t.b("split")
        }, [o("div", {
          class: t.be("split", "left")
        }, [o("div", {
          class: t.be("split", "header")
        }, [A("进行中")]), o(s("virtual-draggable"), {
          class: t.be("group", "draggable"),
          items: i.children,
          count: n.visiableLength,
          itemSize: n.groupItemSize,
          group: n.model.id,
          itemKey: "srfkey",
          disabled: u.value || b.value,
          onChange: (r) => j(r, e, "1", "".concat(e.key, "_runing"))
        }, {
          item: ({
            element: r
          }) => E(r, e),
          header: () => i.children.length ? null : o("div", {
            class: [t.be("group", "list"), t.is("empty", !0)]
          }, [B()])
        }), I(e)]), o("div", {
          class: t.be("split", "right")
        }, [o("div", {
          class: t.be("split", "header")
        }, [A("已完成")]), o(s("virtual-draggable"), {
          class: t.be("group", "draggable"),
          items: a.children,
          count: n.visiableLength,
          itemSize: n.groupItemSize,
          group: n.model.id,
          itemKey: "srfkey",
          disabled: u.value || b.value,
          onChange: (r) => j(r, e, "2", "".concat(e.key, "_finish"))
        }, {
          item: ({
            element: r
          }) => E(r, e),
          header: () => a.children.length ? null : o("div", {
            class: [t.be("group", "list"), t.is("empty", !0)]
          }, [B()])
        }), I(e)])]);
      }
      return [o(s("virtual-draggable"), {
        class: t.be("group", "draggable"),
        items: e.children,
        count: n.visiableLength,
        itemSize: n.groupItemSize,
        group: n.model.id,
        itemKey: "srfkey",
        disabled: u.value || b.value,
        onChange: (i) => j(i, e)
      }, {
        item: ({
          element: i
        }) => E(i, e),
        header: () => e.children.length ? null : o("div", {
          class: t.be("group", "list")
        }, [B()])
      }), I(e)];
    };
    return {
      c: n,
      ns: t,
      isFull: p,
      kanban: c,
      onFullScreen: te,
      renderGroup: (e) => {
        const i = C(e.key), a = w.value[String(e.key)], r = n.model.groupLayout === "COLUMN", m = {
          ...z
        };
        if (a && (m.height = "50px"), i.data === 1) {
          const v = z.width.slice(0, -2);
          m.width = "".concat(Number(v) * 2, "px");
        }
        return !a || r ? o("div", {
          class: [t.b("group"), t.is("collapse", a), D],
          style: m
        }, [o("div", {
          class: t.be("group", "header"),
          style: {
            borderTopColor: e.color || "transparent"
          },
          onClick: (v) => y(e, v)
        }, [o("div", {
          class: t.be("group", "header-left")
        }, [o(s("ion-icon"), {
          name: "caret-down-sharp"
        }, null), o("span", {
          class: [t.be("group", "header-caption"), t.is("badge", !!e.color)],
          style: {
            backgroundColor: e.color
          }
        }, ["".concat(e.caption).concat(e.children.length ? " · ".concat(e.children.length) : "")])]), ne(e)]), N(e), o("div", {
          class: [t.be("group", "list"), t.is("empty", !e.children.length)]
        }, [oe(e)])]) : o("div", {
          class: [t.b("group"), t.is("collapse", a), D]
        }, [o("div", {
          class: t.be("group", "header"),
          style: {
            borderTopColor: e.color || "transparent"
          },
          onClick: (v) => y(e, v)
        }, [o("span", {
          class: [t.be("group", "header-caption"), t.is("badge", !!e.color)],
          style: {
            backgroundColor: e.color
          }
        }, ["".concat(e.caption).concat(e.children.length ? " · ".concat(e.children.length) : "")]), o(s("ion-icon"), {
          name: "caret-forward-sharp"
        }, null)])]);
      }
    };
  },
  render() {
    var t;
    const {
      groups: l,
      isCreated: n
    } = this.c.state;
    return n ? o(s("iBizControlBase"), {
      ref: "kanban",
      controller: this.c,
      class: [this.ns.m((t = this.modelData.groupLayout) == null ? void 0 : t.toLowerCase()), this.ns.is("full", this.isFull), this.ns.is("plugin", !0)]
    }, {
      default: () => [o("div", {
        class: this.ns.b("group-container")
      }, [l.length > 0 && l.map((c) => this.renderGroup(c))]), l.length > 0 && o("div", {
        class: this.ns.e("full-btn"),
        onClick: this.onFullScreen
      }, [this.isFull ? o(s("ion-icon"), {
        name: "contract-outline"
      }, null) : o(s("ion-icon"), {
        name: "expand-outline"
      }, null)])]
    }) : null;
  }
});
class Ce {
  constructor() {
    M(this, "component", "IBizStepsKanbanControl");
  }
}
const ve = ce(
  q,
  function(l) {
    l.component(q.name, q), he(
      "CUSTOM_STEPS_KANBAN",
      () => new Ce()
    );
  }
), ze = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(l) {
    l.use(ve);
  }
};
export {
  ve as IBizStepsKanbanControl,
  ze as default
};
