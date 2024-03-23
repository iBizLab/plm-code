import './style.css';
var q = Object.defineProperty;
var W = (e, t, r) => t in e ? q(e, t, { enumerable: !0, configurable: !0, writable: !0, value: r }) : e[t] = r;
var _ = (e, t, r) => (W(e, typeof t != "symbol" ? t + "" : t, r), r);
import { useNamespace as B, useControlController as j, useUIStore as F, withInstall as U } from "@ibiz-template/vue3-util";
import { GridRowState as Q, ControlVO as V, GridController as K, registerControlProvider as J } from "@ibiz-template/runtime";
import { ref as R, watch as M, computed as E, watchEffect as X, onUnmounted as G, nextTick as Z, reactive as ee, createVNode as d, resolveComponent as p, defineComponent as I, createTextVNode as T, mergeProps as te, h as oe } from "vue";
import S from "dayjs";
import { computePosition as ne } from "@floating-ui/dom";
import { RuntimeError as x } from "@ibiz-template/core";
const ae = {
  0: "周日",
  1: "周一",
  2: "周二",
  3: "周三",
  4: "周四",
  5: "周五",
  6: "周六"
};
class Y {
  /**
   * 时间是否相等
   *
   * @static
   * @param {(string | Date | Dayjs)} date1
   * @param {(string | Date | Dayjs)} date2
   * @return {*} 
   * @memberof Util
   */
  static isDateSame(t, r) {
    return S(t).format("YYYY-MM-DD") === S(r).format("YYYY-MM-DD");
  }
  /**
   * 计算日期
   *
   * @static
   * @param {string} start 开始时间
   * @param {string} end 结束时间
   * @memberof Util
   */
  static calcDate(t, r) {
    const c = S(t, "YYYY-MM-DD"), l = S(r, "YYYY-MM-DD"), u = [];
    for (let m = c; !m.isAfter(l); m = m.add(1, "day"))
      u.push({
        date: m.format("YYYY-MM-DD"),
        week: ae[m.day()],
        isWeekend: m.day() === 6 || m.day() === 0,
        isToday: this.isDateSame(m, /* @__PURE__ */ new Date())
      });
    return u;
  }
}
function re(e) {
  const t = R();
  let r = !1, c = !1;
  async function l(o, n, s) {
    if (ibiz.config.grid.editShowMode === "row" && e.model.enableRowEdit) {
      const i = e.findRowState(o);
      i && i.showRowEdit !== !0 && await e.switchRowEdit(i, !0);
    } else
      e.onRowClick(o);
  }
  function u(o) {
    e.onDbRowClick(o);
  }
  function m(o) {
    r || e.setSelection(o);
  }
  M(
    [
      () => t.value,
      () => e.state.isLoaded,
      () => e.state.selectedData
    ],
    ([o, n, s]) => {
      !n || !o || (e.state.singleSelect ? s[0] ? t.value.setCurrentRow(s[0], !0) : t.value.setCurrentRow() : (r = !0, t.value.clearSelection(), s.forEach((i) => t.value.toggleRowSelection(i, !0)), r = !1));
    }
  );
  function f(o) {
    if (c) {
      c = !1;
      return;
    }
    const { prop: n, order: s } = o, i = e.fieldColumns[n].model.appDEFieldId;
    let h;
    s === "ascending" ? h = "asc" : s === "descending" && (h = "desc"), "".concat(i, ",").concat(h) !== e.state.sortQuery && (e.setSort(i, h), e.load());
  }
  function g({ row: o }) {
    let n = "";
    e.state.selectedData.length > 0 && e.state.selectedData.forEach((i) => {
      i === o && (n = "current-row");
    });
    const s = e.findRowState(o);
    return s != null && s.showRowEdit && (n += " editing-row"), o.srfkey && (n += " id-".concat(o.srfkey)), n;
  }
  function a({
    _row: o,
    column: n,
    _rowIndex: s,
    _columnIndex: i
  }) {
    var w;
    const h = (w = e.model.degridColumns) == null ? void 0 : w.find((b) => b.codeName === n.property);
    return h && h.headerSysCss && h.headerSysCss.cssName ? h.headerSysCss.cssName : "";
  }
  return M(
    () => e.state.sortQuery,
    (o) => {
      if (o) {
        const n = e.state.sortQuery.split(",")[0], s = e.state.sortQuery.split(",")[1];
        if (n && s) {
          const i = s === "desc" ? "descending" : "ascending", h = () => {
            t.value ? Z(() => {
              c = !0, t.value.sort(n, i);
            }) : setTimeout(h, 500);
          };
          h();
        }
      }
    }
  ), {
    tableRef: t,
    onRowClick: l,
    onDbRowClick: u,
    onSelectionChange: m,
    onSortChange: f,
    handleRowClassName: g,
    handleHeaderCellClassName: a
  };
}
function se(e, t) {
  const r = () => {
    t.data && (e.state.items = t.data, e.state.rows = t.data.map((a) => new Q(new V(a), e)));
  }, c = E(() => {
    var o;
    const a = Object.values(e.fieldColumns).find(
      (n) => n.model.appDEFieldId === e.model.minorSortAppDEFieldId
    );
    return {
      prop: a == null ? void 0 : a.model.codeName,
      order: ((o = e.model.minorSortDir) == null ? void 0 : o.toLowerCase()) === "desc" ? "descending" : "ascending"
    };
  });
  e.evt.on("onCreated", async () => {
    t.isSimple && (r(), e.state.isLoaded = !0);
  }), M(
    () => t.data,
    () => {
      t.isSimple && r();
    },
    {
      deep: !0
    }
  );
  const l = E(() => {
    const a = e.state;
    if (e.model.enableGroup) {
      const o = [];
      return a.groups.forEach((n) => {
        if (!n.children.length)
          return;
        const s = [...n.children], i = s.shift();
        o.push({
          tempsrfkey: (i == null ? void 0 : i.tempsrfkey) || n.caption,
          srfkey: (i == null ? void 0 : i.srfkey) || n.caption,
          isGroupData: !0,
          caption: n.caption,
          first: i,
          children: s
        });
      }), o;
    }
    return a.rows.map((o) => o.data);
  }), u = R([]), m = e.view.getController("searchform");
  e.evt.on("onLoadSuccess", (a) => {
    var n, s, i;
    const o = (s = (n = e.model.controlParam) == null ? void 0 : n.ctrlParams) == null ? void 0 : s.DATERANGE;
    if (m && o) {
      const h = (i = m.state.data) == null ? void 0 : i[o];
      if (h) {
        const w = h.split(",");
        if (w.length === 2) {
          const b = Y.calcDate(w[0], w[1]), N = e.state.rows.map((C) => C.data);
          b.forEach((C) => {
            C.summary = 0;
            const k = N.filter(
              (y) => Y.isDateSame(y.register_date, C.date)
            );
            k.length > 0 && k.forEach((y) => {
              Number.isNaN(y.duration) || (C.summary += y.duration);
            });
          }), u.value = b;
        } else
          u.value = [];
      } else
        u.value = [];
    }
  });
  const f = E(() => {
    if (e.isMultistageHeader)
      return e.model.degridColumns || [];
    const a = [];
    return e.state.columnStates.forEach((o) => {
      var s, i;
      if (o.hidden)
        return;
      const n = ((s = e.fieldColumns[o.key]) == null ? void 0 : s.model) || ((i = e.uaColumns[o.key]) == null ? void 0 : i.model);
      n && a.push(n);
    }), a;
  });
  return { tableData: l, renderColumns: f, defaultSort: c, summaryMethod: ({
    columns: a
  }) => a.map((o, n) => {
    if (n === 0)
      return e.aggTitle;
    const s = u.value.find((i) => i.date === o.property);
    return e.state.aggResult[o.property] || (s == null ? void 0 : s.summary);
  }), ganttColumns: u };
}
function le(e, t) {
  let r = null, c = 0;
  const l = R({}), u = () => {
    if (window.ResizeObserver) {
      const f = e.value.$el.querySelector(
        ".el-table__header-wrapper"
      );
      f && (r = new ResizeObserver((g) => {
        const a = g[0].contentRect.height;
        if (a !== c) {
          const o = {
            "now-header-height": "".concat(a, "px")
          };
          l.value = t.cssVarBlock(o), c = a;
        }
      }), r.observe(f));
    }
  }, m = X(() => {
    e.value && u();
  });
  return G(() => {
    r && r.disconnect(), m();
  }), {
    headerCssVars: l
  };
}
function ie(e) {
  function t(l) {
    !l || l === e.state.curPage || (e.state.curPage = l, e.load());
  }
  function r(l) {
    !l || l === e.state.size || (e.state.size = l, e.state.curPage === 1 && e.load());
  }
  function c() {
    e.load();
  }
  return { onPageChange: t, onPageSizeChange: r, onPageRefresh: c };
}
function de(e, t) {
  let r;
  const c = R(!1), l = R(), u = ee({}), m = (n) => {
    if (!e.value)
      throw new x("找不到表格组件引用");
    const s = e.value.$el;
    let i = ".el-table__row";
    n.data.srfkey && (i += ".id-".concat(n.data.srfkey));
    const h = s.querySelector(i);
    if (!h)
      throw new x("找不到对应的表格行dom元素");
    return h;
  }, f = async (n) => {
    const s = m(n);
    if (!r)
      throw new x("拿不到pop组件的实例");
    const i = r.$el, {
      x: h,
      y: w
    } = await ne(s, i, {
      placement: "bottom"
    });
    Object.assign(u, {
      top: "".concat(w, "px"),
      left: "".concat(h, "px")
    }), l.value = n, c.value = !0;
  }, g = async () => {
    l.value && t.switchRowEdit(l.value, !1, !0);
  }, a = async () => {
    l.value && t.switchRowEdit(l.value, !1, !1);
  }, o = () => {
    const n = c.value && t.state.rows[t.state.rows.length - 1].showRowEdit;
    return [d("div", {
      class: "row-edit-popover__placeholder",
      style: {
        display: n ? "block" : "none"
      }
    }, null), d(p("iBizRowEditPopover"), {
      ref: (s) => {
        r = s;
      },
      style: u,
      show: c.value,
      onConfirm: g,
      onCancel: a
    }, null)];
  };
  return t.evt.on("onRowEditChange", (n) => {
    n.row.showRowEdit ? setTimeout(() => {
      f(n.row);
    }, 0) : (l.value = void 0, c.value = !1, Object.assign(u, {
      top: void 0,
      left: void 0
    }));
  }), {
    renderPopover: o
  };
}
const ce = /* @__PURE__ */ I({
  name: "GanttColumns",
  props: {
    controller: {
      type: Object,
      required: !0
    },
    columns: {
      type: Array,
      required: !0
    }
  },
  setup(e) {
    const t = B("gantt-column"), r = e.controller, c = E(() => {
      var o;
      let a;
      return (o = r.model.controlRenders) == null || o.forEach((n) => {
        n.renderType === "LAYOUTPANEL" && n.id === "gantt_column" && (a = n.layoutPanel);
      }), a;
    }), l = (a) => {
      a.stopPropagation(), a.preventDefault();
    }, u = (a) => d(p("iBizControlShell"), {
      data: a,
      modelData: c.value,
      context: r.context,
      params: r.params
    }, null), m = (a) => d("div", {
      class: [t.e("header"), t.e("column")]
    }, [d("div", {
      class: ["time", t.is("today", a.isToday), t.is("weekend", a.isWeekend)]
    }, [d("div", {
      class: "week"
    }, [a.week]), d("div", {
      class: "date"
    }, [S(a.date).format("MM/DD")])])]), f = (a, o) => d("div", {
      class: [t.e("default"), t.e("column")]
    }, [d("div", {
      class: ["time", t.is("today", o.isToday), t.is("weekend", o.isWeekend)],
      onClick: (n) => l(n)
    }, [a.register_date && Y.isDateSame(a.register_date, o.date) ? d(p("el-popover"), {
      trigger: "click",
      disabled: !a.duration || !c.value,
      placement: "bottom",
      width: "auto",
      "popper-style": {
        "min-width": "300px"
      }
    }, {
      reference: () => d("div", {
        class: "duration"
      }, [a.duration]),
      default: () => u(a)
    }) : null])]);
    return {
      ns: t,
      renderColumn: (a) => d(p("el-table-column"), {
        fixed: "right",
        className: t.b(),
        "min-width": 60,
        align: "center",
        prop: a.date
      }, {
        header: () => m(a),
        default: ({
          row: o
        }) => f(o, a)
      })
    };
  },
  render() {
    return this.columns.map((e) => this.renderColumn(e));
  }
});
function ue(e, t, r, c) {
  var o;
  const {
    codeName: l,
    width: u
  } = t, m = e.columns[l], f = e.state.columnStates.find((n) => n.key === l), a = m.isAdaptiveColumn || !e.hasAdaptiveColumn && c === r.length - 1 ? "min-width" : "width";
  return d(p("el-table-column"), te({
    label: t.caption,
    prop: l
  }, {
    [a]: u
  }, {
    fixed: f.fixed,
    sortable: t.enableSort ? "custom" : !1,
    align: ((o = t.align) == null ? void 0 : o.toLowerCase()) || "center"
  }), {
    default: ({
      row: n
    }) => {
      let s = n;
      n.isGroupData && (s = n.first);
      const i = e.findRowState(s);
      if (i) {
        const h = p(e.providers[l].component);
        return oe(h, {
          controller: m,
          row: i,
          key: s.tempsrfkey + l
        });
      }
      return null;
    }
  });
}
function O(e, t, r, c) {
  var l, u;
  if (t.columnType === "GROUPGRIDCOLUMN") {
    const m = ((l = t.degridColumns) == null ? void 0 : l.filter((a) => !a.hideDefault && !a.hiddenDataItem)) || [], {
      width: f
    } = t, g = ((u = t.align) == null ? void 0 : u.toLowerCase()) || "center";
    return d(p("el-table-column"), {
      prop: t.codeName,
      label: t.caption,
      "min-width": f,
      align: g
    }, {
      default: () => m.map((a, o) => O(e, a, r, o))
    });
  }
  return ue(e, t, r, c);
}
const z = /* @__PURE__ */ I({
  name: "IBizWorkloadTableControl",
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
    /**
     * 部件行数据默认激活模式
     * - 0 不激活
     * - 1 单击激活
     * - 2 双击激活(默认值)
     *
     * @type {(number | 0 | 1 | 2)}
     */
    mdctrlActiveMode: {
      type: Number,
      default: void 0
    },
    singleSelect: {
      type: Boolean,
      default: void 0
    },
    rowEditOpen: {
      type: Boolean,
      default: void 0
    },
    isSimple: {
      type: Boolean,
      required: !1
    },
    data: {
      type: Array,
      required: !1
    },
    loadDefault: {
      type: Boolean,
      default: !0
    }
  },
  setup(e) {
    const t = j((...v) => new K(...v)), r = B("control-".concat(t.model.controlType.toLowerCase())), c = B("workload-table"), {
      zIndex: l
    } = F();
    t.state.zIndex = l.increment();
    const {
      tableRef: u,
      onRowClick: m,
      onDbRowClick: f,
      onSelectionChange: g,
      onSortChange: a,
      handleRowClassName: o,
      handleHeaderCellClassName: n
    } = re(t), {
      onPageChange: s,
      onPageRefresh: i,
      onPageSizeChange: h
    } = ie(t), {
      headerCssVars: w
    } = le(u, r), b = () => {
      var D;
      const {
        isLoaded: v
      } = t.state;
      if (v) {
        const P = (D = t.model.controls) == null ? void 0 : D.find((H) => H.name === "".concat(t.model.name, "_quicktoolbar"));
        return P ? d(p("iBizToolbarControl"), {
          modelData: P,
          context: t.context,
          params: t.params,
          class: r.b("quick-toolbar")
        }, null) : d(p("iBizNoData"), {
          text: t.model.emptyText,
          emptyTextLanguageRes: t.model.emptyTextLanguageRes
        }, null);
      }
      return d("div", null, null);
    }, {
      tableData: N,
      renderColumns: C,
      defaultSort: k,
      summaryMethod: y,
      ganttColumns: A
    } = se(t, e), {
      renderPopover: L
    } = de(u, t), $ = () => {
      var D;
      const v = (D = t.model.controls) == null ? void 0 : D.find((P) => P.name === "".concat(t.model.name, "_batchtoolbar"));
      if (!(!v || t.state.singleSelect))
        return d("div", {
          class: [r.b("batch-toolbar"), r.is("show", t.state.selectedData.length > 0)]
        }, [d("div", {
          class: r.b("batch-toolbar-content")
        }, [d("div", {
          class: r.b("batch-toolbar-text")
        }, [T("已选中"), t.state.selectedData.length, T("项")]), d("div", {
          class: r.b("batch-toolbar-separator")
        }, [T("|")]), d(p("iBizToolbarControl"), {
          modelData: v,
          context: t.context,
          params: t.params,
          class: r.b("batch-toolbar-items")
        }, null)])]);
    };
    return G(() => {
      l.decrement();
    }), {
      c: t,
      ns: r,
      ns2: c,
      tableRef: u,
      tableData: N,
      ganttColumns: A,
      renderColumns: C,
      onDbRowClick: f,
      onRowClick: m,
      onSelectionChange: g,
      onSortChange: a,
      onPageChange: s,
      onPageSizeChange: h,
      onPageRefresh: i,
      handleRowClassName: o,
      handleHeaderCellClassName: n,
      renderNoData: b,
      summaryMethod: y,
      renderPopover: L,
      defaultSort: k,
      renderBatchToolBar: $,
      headerCssVars: w
    };
  },
  render() {
    if (!this.c.state.isCreated)
      return;
    const e = this.c.state, {
      hideHeader: t,
      enablePagingBar: r
    } = this.c.model;
    return d(p("iBizControlBase"), {
      class: [this.ns2.b(), this.ns.is("show-header", !t), this.ns.is("enable-page", r), this.ns.is("enable-group", this.c.model.enableGroup), this.ns.is("single-select", e.singleSelect), this.ns.is("empty", e.items.length === 0), this.ns.is("enable-customized", this.c.model.enableCustomized)],
      controller: this.c,
      style: this.headerCssVars
    }, {
      default: () => [d(p("el-table"), {
        ref: "tableRef",
        class: this.ns.e("table"),
        "default-sort": this.defaultSort,
        border: !0,
        "show-header": !t,
        "show-summary": this.c.enableAgg,
        "summary-method": this.summaryMethod,
        "highlight-current-row": e.singleSelect,
        "row-class-name": this.handleRowClassName,
        "header-cell-class-name": this.handleHeaderCellClassName,
        "row-key": "tempsrfkey",
        data: this.tableData,
        onRowClick: this.onRowClick,
        onRowDblclick: this.onDbRowClick,
        onSelectionChange: this.onSelectionChange,
        onSortChange: this.onSortChange,
        "tooltip-effect": "light"
      }, {
        empty: this.renderNoData,
        default: () => [!e.singleSelect && d(p("el-table-column"), {
          "class-name": this.ns.e("selection"),
          type: "selection",
          width: "55"
        }, null), this.renderColumns.map((c, l) => O(this.c, c, this.renderColumns, l)), d(ce, {
          controller: this.c,
          columns: this.ganttColumns
        }, null)],
        append: () => this.renderPopover()
      }), r && d(p("iBizPagination"), {
        total: e.total,
        curPage: e.curPage,
        size: e.size,
        onChange: this.onPageChange,
        onPageSizeChange: this.onPageSizeChange,
        onPageRefresh: this.onPageRefresh
      }, null), this.c.model.enableCustomized && !t && d("div", {
        class: this.ns.b("setting-box")
      }, [d(p("iBizGridSetting"), {
        columnStates: e.columnStates,
        controller: this.c
      }, null)]), this.renderBatchToolBar()]
    });
  }
});
class me {
  constructor() {
    _(this, "component", "IBizWorkloadTableControl");
  }
}
const he = U(
  z,
  (e) => {
    e.component(z.name, z), J(
      "GRID_RENDER_WORKLOAD_TABLE",
      () => new me()
    );
  }
), ve = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(e) {
    e.use(he);
  }
};
export {
  he as IBizWorkloadTableControl,
  ve as default
};
