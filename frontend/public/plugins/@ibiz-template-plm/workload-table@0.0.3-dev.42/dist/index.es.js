import './style.css';
var te = Object.defineProperty;
var ae = (e, t, a) => t in e ? te(e, t, { enumerable: !0, configurable: !0, writable: !0, value: a }) : e[t] = a;
var O = (e, t, a) => (ae(e, typeof t != "symbol" ? t + "" : t, a), a);
import { useNamespace as A, useControlController as oe, useUIStore as se, withInstall as ne } from "@ibiz-template/vue3-util";
import { GridRowState as U, ControlVO as re, GridController as ie, handleAllSettled as le, GridNotifyState as de, exportData as ce, registerControlProvider as ue } from "@ibiz-template/runtime";
import { ref as I, watch as _, computed as P, watchEffect as he, onUnmounted as Q, nextTick as me, reactive as fe, createVNode as p, resolveComponent as b, defineComponent as K, onMounted as pe, createTextVNode as z, mergeProps as ge, h as we } from "vue";
import { plus as H, RuntimeError as N, RuntimeModelError as Ce } from "@ibiz-template/core";
import { computePosition as be } from "@floating-ui/dom";
import R from "dayjs";
import { isNil as ye, clone as ve } from "ramda";
function De(e) {
  const t = I();
  let a = !1, d = !1;
  async function r(n, l, o) {
    if (ibiz.config.grid.editShowMode === "row" && e.model.enableRowEdit) {
      const h = e.findRowState(n);
      h && h.showRowEdit !== !0 && await e.switchRowEdit(h, !0);
    } else
      e.onRowClick(n);
  }
  function i(n) {
    e.onDbRowClick(n);
  }
  function c(n) {
    a || e.setSelection(n);
  }
  _(
    [
      () => t.value,
      () => e.state.isLoaded,
      () => e.state.selectedData
    ],
    ([n, l, o]) => {
      !l || !n || (e.state.singleSelect ? o[0] ? t.value.setCurrentRow(o[0], !0) : t.value.setCurrentRow() : (a = !0, t.value.clearSelection(), o.forEach((h) => t.value.toggleRowSelection(h, !0)), a = !1));
    }
  );
  function f(n) {
    if (d) {
      d = !1;
      return;
    }
    const { prop: l, order: o } = n, h = e.fieldColumns[l].model.appDEFieldId;
    let m;
    o === "ascending" ? m = "asc" : o === "descending" && (m = "desc"), "".concat(h, ",").concat(m) !== e.state.sortQuery && (e.setSort(h, m), e.load());
  }
  function u({ row: n }) {
    let l = "";
    e.state.selectedData.length > 0 && e.state.selectedData.forEach((h) => {
      h === n && (l = "current-row");
    });
    const o = e.findRowState(n);
    return o != null && o.showRowEdit && (l += " editing-row"), n.srfkey && (l += " id-".concat(n.srfkey)), l;
  }
  function s({
    _row: n,
    column: l,
    _rowIndex: o,
    _columnIndex: h
  }) {
    var g;
    const m = (g = e.model.degridColumns) == null ? void 0 : g.find((w) => w.codeName === l.property);
    return m && m.headerSysCss && m.headerSysCss.cssName ? m.headerSysCss.cssName : "";
  }
  return _(
    () => e.state.sortQuery,
    (n) => {
      if (n) {
        const l = e.state.sortQuery.split(",")[0], o = e.state.sortQuery.split(",")[1];
        if (l && o) {
          const h = o === "desc" ? "descending" : "ascending", m = () => {
            t.value ? me(() => {
              d = !0, t.value.sort(l, h);
            }) : setTimeout(m, 500);
          };
          m();
        }
      }
    }
  ), {
    tableRef: t,
    onRowClick: r,
    onDbRowClick: i,
    onSelectionChange: c,
    onSortChange: f,
    handleRowClassName: u,
    handleHeaderCellClassName: s
  };
}
function Ee(e, t) {
  const a = () => {
    t.data && (e.state.items = t.data, e.state.rows = t.data.map((u) => new U(new re(u), e)));
  }, d = P(() => {
    var s;
    const u = Object.values(e.fieldColumns).find(
      (n) => n.model.appDEFieldId === e.model.minorSortAppDEFieldId
    );
    return {
      prop: u == null ? void 0 : u.model.codeName,
      order: ((s = e.model.minorSortDir) == null ? void 0 : s.toLowerCase()) === "desc" ? "descending" : "ascending"
    };
  });
  e.evt.on("onCreated", async () => {
    t.isSimple && (a(), e.state.isLoaded = !0);
  }), _(
    () => t.data,
    () => {
      t.isSimple && a();
    },
    {
      deep: !0
    }
  );
  const r = P(() => {
    const { state: u } = e;
    return u.rows.map((s) => s.data);
  }), i = P(() => {
    if (e.isMultistageHeader)
      return e.model.degridColumns || [];
    const u = [];
    return e.state.columnStates.forEach((s) => {
      var l, o;
      if (s.hidden)
        return;
      const n = ((l = e.fieldColumns[s.key]) == null ? void 0 : l.model) || ((o = e.uaColumns[s.key]) == null ? void 0 : o.model);
      n && u.push(n);
    }), u;
  });
  return {
    tableData: r,
    renderColumns: i,
    defaultSort: d,
    summaryMethod: ({
      columns: u
    }) => u.map((s, n) => n === 0 ? e.aggTitle : e.state.aggResult[s.property]),
    ganttSummaryMethod: ({
      columns: u
    }) => u.map((s, n) => e.state.rows.map((l) => l.data[s.property] || 0).reduce((l, o) => H(l, o), 0))
  };
}
function Se(e, t) {
  let a = null, d = 0;
  const r = I({}), i = () => {
    if (window.ResizeObserver) {
      const f = e.value.$el.querySelector(
        ".el-table__header-wrapper"
      );
      f && (a = new ResizeObserver((u) => {
        const { height: s } = u[0].contentRect;
        if (s !== d) {
          const n = {
            "now-header-height": "".concat(s, "px")
          };
          r.value = t.cssVarBlock(n), d = s;
        }
      }), a.observe(f));
    }
  }, c = he(() => {
    e.value && i();
  });
  return Q(() => {
    a && a.disconnect(), c();
  }), {
    headerCssVars: r
  };
}
function Re(e) {
  function t(r) {
    !r || r === e.state.curPage || (e.state.curPage = r, e.load());
  }
  function a(r) {
    !r || r === e.state.size || (e.state.size = r, e.state.curPage === 1 && e.load());
  }
  function d() {
    e.load();
  }
  return { onPageChange: t, onPageSizeChange: a, onPageRefresh: d };
}
function xe(e, t) {
  let a;
  const d = I(!1), r = I(), i = fe({}), c = (l) => {
    if (!e.value)
      throw new N("找不到表格组件引用");
    const o = e.value.$el;
    let h = ".el-table__row";
    l.data.srfkey && (h += ".id-".concat(l.data.srfkey));
    const m = o.querySelector(h);
    if (!m)
      throw new N("找不到对应的表格行dom元素");
    return m;
  }, f = async (l) => {
    const o = c(l);
    if (!a)
      throw new N("拿不到pop组件的实例");
    const h = a.$el, {
      x: m,
      y: g
    } = await be(o, h, {
      placement: "bottom"
    });
    Object.assign(i, {
      top: "".concat(g, "px"),
      left: "".concat(m, "px")
    }), r.value = l, d.value = !0;
  }, u = async () => {
    r.value && t.switchRowEdit(r.value, !1, !0);
  }, s = async () => {
    r.value && t.switchRowEdit(r.value, !1, !1);
  }, n = () => {
    const l = d.value && t.state.rows[t.state.rows.length - 1].showRowEdit;
    return [p("div", {
      class: "row-edit-popover__placeholder",
      style: {
        display: l ? "block" : "none"
      }
    }, null), p(b("iBizRowEditPopover"), {
      ref: (o) => {
        a = o;
      },
      style: i,
      show: d.value,
      onConfirm: u,
      onCancel: s
    }, null)];
  };
  return t.evt.on("onRowEditChange", (l) => {
    l.row.showRowEdit ? setTimeout(() => {
      f(l.row);
    }, 0) : (r.value = void 0, d.value = !1, Object.assign(i, {
      top: void 0,
      left: void 0
    }));
  }), {
    renderPopover: n
  };
}
const Pe = /* @__PURE__ */ K({
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
    const t = A("gantt-column"), a = e.controller, d = P(() => {
      var n;
      let s;
      return (n = a.model.controlRenders) == null || n.forEach((l) => {
        l.renderType === "LAYOUTPANEL" && l.id === "gantt_column" && (s = l.layoutPanel);
      }), s;
    }), r = (s, n) => {
      n && (s.stopPropagation(), s.preventDefault());
    }, i = (s) => p(b("iBizControlShell"), {
      data: s,
      modelData: d.value,
      context: a.context,
      params: a.params
    }, null), c = (s) => p("div", {
      class: [t.e("header"), t.e("column")]
    }, [p("div", {
      class: ["time", t.is("today", s.isToday), t.is("weekend", s.isWeekend)]
    }, [p("div", {
      class: "week"
    }, [s.week]), p("div", {
      class: "date"
    }, [R(s.date).format("MM/DD")])])]), f = (s, n) => p("div", {
      class: [t.e("default"), t.e("column")]
    }, [p("div", {
      class: ["time", t.is("today", n.isToday), t.is("weekend", n.isWeekend)],
      onClick: (l) => r(l, s[n.date] && d.value)
    }, [s[n.date] ? p(b("el-popover"), {
      trigger: "click",
      disabled: !d.value,
      placement: "bottom",
      width: "auto",
      "popper-style": {
        "min-width": "300px"
      }
    }, {
      reference: () => p("div", {
        class: "duration"
      }, [s[n.date]]),
      default: () => i(s)
    }) : null])]);
    return {
      ns: t,
      renderColumn: (s) => p(b("el-table-column"), {
        className: t.b(),
        "min-width": 60,
        align: "center",
        type: "gantt",
        prop: s.date
      }, {
        header: () => c(s),
        default: ({
          row: n
        }) => f(n, s)
      })
    };
  },
  render() {
    return this.columns.map((e) => this.renderColumn(e));
  }
}), ke = {
  0: "周日",
  1: "周一",
  2: "周二",
  3: "周三",
  4: "周四",
  5: "周五",
  6: "周六"
};
class V {
  /**
   * 时间是否相等
   *
   * @static
   * @param {(string | Date | Dayjs)} date1
   * @param {(string | Date | Dayjs)} date2
   * @return {*}
   * @memberof Util
   */
  static isDateSame(t, a) {
    return R(t).format("YYYY-MM-DD") === R(a).format("YYYY-MM-DD");
  }
  /**
   * 计算日期
   *
   * @static
   * @param {string} start 开始时间
   * @param {string} end 结束时间
   * @memberof Util
   */
  static calcDate(t, a) {
    const d = R(t, "YYYY-MM-DD"), r = R(a, "YYYY-MM-DD"), i = [];
    for (let c = d; !c.isAfter(r); c = c.add(1, "day"))
      i.push({
        date: c.format("YYYY-MM-DD"),
        week: ke[c.day()],
        isWeekend: c.day() === 6 || c.day() === 0,
        isToday: this.isDateSame(c, /* @__PURE__ */ new Date())
      });
    return i;
  }
}
class Me extends ie {
  constructor() {
    super(...arguments);
    /**
     * 分组代码表数据项
     *
     * @type {readonly}
     * @memberof WorkloadTableController
     */
    O(this, "codeListItems");
    /**
     * 精度
     *
     * @memberof WorkloadTableController
     */
    O(this, "precision", 1);
  }
  async onCreated() {
    await super.onCreated();
    const { ctrlParams: a = {} } = this.model.controlParam;
    try {
      a.PRECISION && (this.precision = Number(a.PRECISION));
    } catch (d) {
      ibiz.log.error(d);
    }
  }
  initState() {
    super.initState(), this.initGanttColumns();
  }
  /**
   * 初始化甘特列
   * - 默认最近一周
   */
  initGanttColumns() {
    const a = /* @__PURE__ */ new Date(), d = R(a.getTime() - 6048e5).format("YYYY-MM-DD"), r = R(a).format("YYYY-MM-DD");
    this.state.ganttColumns = V.calcDate(d, r);
  }
  /**
   * 初始化分组
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof WorkloadTableController
   */
  async initGroup() {
    const { groupCodeListId: a, groupMode: d, enableGroup: r } = this.model;
    if (r && d === "CODELIST") {
      if (!a)
        throw new Ce(
          this.model,
          "代码表分组模式需要配置代码表"
        );
      const i = ibiz.hub.getApp(this.context.srfappid);
      this.codeListItems = await i.codeList.get(
        a,
        this.context,
        this.params
      );
    }
  }
  /**
   * 计算甘特列
   */
  calcGanttColumns() {
    var r, i, c;
    const a = this.view.getController("searchform"), d = (i = (r = this.model.controlParam) == null ? void 0 : r.ctrlParams) == null ? void 0 : i.DATERANGE;
    if (this.state.ganttColumns = [], a && d) {
      const f = (c = a.state.data) == null ? void 0 : c[d];
      if (f) {
        const u = f.split(",");
        u.length === 2 && (this.state.ganttColumns = V.calcDate(u[0], u[1]));
      }
    }
    this.state.ganttColumns.length === 0 && this.initGanttColumns();
  }
  /**
   * 部件加载数据行为
   * @param args
   * @returns
   */
  async load(a = {}) {
    if (this.calcGanttColumns(), this.state.isSimple)
      return [];
    const d = a.silent === !0;
    d || await this.startLoading();
    try {
      const r = a.isInitialLoad === !0, i = a.isLoadMore === !0;
      r ? this.state.curPage = 1 : i && (this.state.curPage += 1);
      const { context: c } = this.handlerAbilityParams(a), f = await this.getFetchParams(a == null ? void 0 : a.viewParam), u = await this.service.fetch(c, f);
      typeof u.total == "number" && (this.state.total = u.total), i ? this.state.items.push(...u.data) : this.state.items = u.data, await this.afterLoad(a, u.data), this.state.isLoaded = !0, await this._evt.emit("onLoadSuccess", {
        isInitialLoad: r
      });
    } catch (r) {
      throw await this._evt.emit("onLoadError", void 0), this.actionNotification("FETCHERROR", {
        error: r
      }), r;
    } finally {
      d || await this.endLoading();
    }
    return this.state.items.forEach((r, i) => {
      r.srfserialnum = i + 1;
    }), this.actionNotification("FETCHSUCCESS"), this.state.items;
  }
  /**
   * 加载之后
   *
   * @param {MDCtrlLoadParams} args
   * @param {ControlVO[]} items
   * @return {*}  {Promise<ControlVO[]>}
   * @memberof WorkloadTableController
   */
  async afterLoad(a, d) {
    await le(
      Object.values(this.fieldColumns).map(async (i) => {
        await i.loadCodeList();
      }),
      !1
    );
    const r = this.calcMergeByGroup(d);
    return this.state.rows = r.map((i) => {
      const c = new U(i, this);
      return this.gridStateNotify(c, de.LOAD), c;
    }), this.state.rows.forEach((i) => {
      Object.values(i.uaColStates).forEach((c) => {
        c.update(
          this.context,
          i.data.getOrigin(),
          this.model.appDataEntityId
        );
      });
    }), this.state.rows.forEach((i) => {
      Object.values(i.uiActionGroupStates).forEach((c) => {
        c.update(
          this.context,
          i.data.getOrigin(),
          this.model.appDataEntityId
        );
      });
    }), this.calcAggResult(d), d;
  }
  /**
   * 通过分组计算数据聚合
   *
   * @protected
   * @param {IData[]} data
   * @return {*}  {IData[]}
   * @memberof WorkloadTableController
   */
  calcMergeByGroup(a) {
    let d = [];
    a.forEach((f) => {
      Object.assign(f, {
        [R(f.register_date).format("YYYY-MM-DD")]: f.duration.toFixed(
          this.precision
        )
      });
    });
    const { enableGroup: r, groupMode: i, groupAppDEFieldId: c } = this.model;
    if (r && c) {
      const f = /* @__PURE__ */ new Map(), u = i === "CODELIST", s = c.toLowerCase();
      u && this.codeListItems.forEach((n) => {
        f.set(n.value, []);
      }), a.forEach((n) => {
        const l = n[s];
        !u && !f.has(l) && f.set(l, []), f.has(l) && f.get(l).push(n);
      }), f.forEach((n, l) => {
        if (n.length > 0) {
          const o = n[0].clone(), h = n.filter((m) => !ye(m.duration));
          n.forEach((m) => {
            const g = R(m.register_date).format("YYYY-MM-DD");
            o.srfkey !== m.srfkey && g && Object.assign(o, {
              [g]: Object.prototype.hasOwnProperty.call(o, g) ? (Number(o[g] || 0) + m.duration).toFixed(
                this.precision
              ) : m.duration.toFixed(this.precision)
            });
          }), o.duration = h.map((m) => m.duration).reduce((m, g) => H(m, g), 0).toFixed(this.precision), d.push(o);
        }
      });
    } else
      d = a;
    return d;
  }
  /**
   * 数据导出
   * @param _args
   */
  async exportData(a) {
    var l;
    this.model.dedataExportId && !this.dataExport && (this.dataExport = (l = this.dataEntity.appDEDataExports) == null ? void 0 : l.find((o) => o.id === this.model.dedataExportId), this.dataExport && (this.allExportColumns = await this.findAllExportColumns(
      this.dataExport
    )));
    const d = (o) => {
      var g;
      const h = /* @__PURE__ */ new Map();
      this.allExportColumns && this.allExportColumns.length > 0 ? (g = this.allExportColumns) == null || g.forEach((w) => {
        w.codeListItems && h.set(
          w.appDEFieldId,
          w.codeListItems
        );
      }) : Object.keys(this.fieldColumns).forEach((w) => {
        this.fieldColumns[w].codeList && h.set(w, this.fieldColumns[w].codeListItems);
      });
      const m = ve(
        o.map((w) => w)
      );
      return m.forEach((w) => {
        Object.keys(w).forEach((y) => {
          var Y;
          let E = w[y];
          const k = this.fieldColumns[y];
          h.get(y) ? E = ((Y = h.get(y).find((G) => G.value === w[y])) == null ? void 0 : Y.text) || E : k && (E = k.formatValue(E) + (k.model.unitName || "")), w[y] = E;
        });
      }), m;
    }, r = this.state.ganttColumns.map(
      (o) => "".concat(o.week, "(").concat(R(o.date).format("MM/DD"), ")")
    ), i = this.state.ganttColumns.map((o) => o.date), c = async () => {
      var m;
      const o = (m = a.params) == null ? void 0 : m.type;
      let h = [];
      if (!o || o === "activatedPage")
        h = this.state.rows.map((g) => g.data);
      else if (o === "maxRowCount" || o === "customPage") {
        const { size: g } = this.state, { startPage: w, endPage: x } = a.params, y = o === "customPage" ? {
          page: 0,
          offset: (w - 1) * g,
          size: (x - w + 1) * g
        } : { size: 1e3, page: 0 }, E = await this.loadData({ viewParam: y });
        h = this.calcMergeByGroup(E);
      } else
        o === "selectedRows" && (h = this.getData());
      if (h.length === 0)
        throw new N("无导出数据");
      if (this.enableAgg) {
        const g = { ...this.state.aggResult, summary: !0 };
        i.length > 0 && i.forEach((w) => {
          Object.assign(g, {
            [w]: h.map((x) => x[w] || 0).reduce((x, y) => H(x, y), 0).toFixed(this.precision)
          });
        }), h.push(g);
      }
      return d(h);
    }, f = (o, h) => h.map((m) => o.map((g, w) => m.summary && w === 0 ? this.aggTitle : m[g]));
    let u = [], s = [];
    if (this.allExportColumns && this.allExportColumns.length > 0)
      u = this.allExportColumns.map(
        (o) => o.appDEFieldId
      ), s = this.allExportColumns.map(
        (o) => o.caption
      );
    else {
      const { degridColumns: o } = this.model;
      if (!o)
        throw new N("无表格列");
      u = o.map((h) => h.id), s = o.map((h) => h.caption);
    }
    s = s.concat(r), u = u.concat(i);
    const n = f(u, await c());
    await ce(s, n, this.model.logicName);
  }
}
function Te(e, t, a, d) {
  var u;
  const {
    codeName: r,
    width: i
  } = t, c = e.columns[r], f = c.isAdaptiveColumn ? "min-width" : "width";
  return p(b("el-table-column"), ge({
    label: t.caption,
    prop: r
  }, {
    [f]: i
  }, {
    fixed: "left",
    sortable: t.enableSort ? "custom" : !1,
    align: ((u = t.align) == null ? void 0 : u.toLowerCase()) || "center"
  }), {
    default: ({
      row: s
    }) => {
      let n = s;
      s.isGroupData && (n = s.first);
      const l = e.findRowState(n);
      if (l) {
        const o = b(e.providers[r].component);
        return we(o, {
          controller: c,
          row: l,
          key: n.tempsrfkey + r
        });
      }
      return null;
    }
  });
}
function J(e, t, a, d) {
  var r, i;
  if (t.columnType === "GROUPGRIDCOLUMN") {
    const c = ((r = t.degridColumns) == null ? void 0 : r.filter((s) => !s.hideDefault && !s.hiddenDataItem)) || [], {
      width: f
    } = t, u = ((i = t.align) == null ? void 0 : i.toLowerCase()) || "center";
    return p(b("el-table-column"), {
      prop: t.codeName,
      label: t.caption,
      "min-width": f,
      align: u
    }, {
      default: () => c.map((s, n) => J(e, s))
    });
  }
  return Te(e, t);
}
const B = /* @__PURE__ */ K({
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
    const t = oe((...C) => new Me(...C)), a = A("control-".concat(t.model.controlType.toLowerCase())), d = A("workload-table"), {
      zIndex: r
    } = se();
    t.state.zIndex = r.increment();
    const i = I(void 0), {
      tableRef: c,
      onRowClick: f,
      onDbRowClick: u,
      onSelectionChange: s,
      onSortChange: n,
      handleRowClassName: l,
      handleHeaderCellClassName: o
    } = De(t), {
      onPageChange: h,
      onPageRefresh: m,
      onPageSizeChange: g
    } = Re(t), {
      headerCssVars: w
    } = Se(c, a), x = () => {
      var v;
      const {
        isLoaded: C
      } = t.state;
      if (C) {
        const S = (v = t.model.controls) == null ? void 0 : v.find((D) => D.name === "".concat(t.model.name, "_quicktoolbar"));
        return S ? p(b("iBizToolbarControl"), {
          modelData: S,
          context: t.context,
          params: t.params,
          class: a.b("quick-toolbar")
        }, null) : p(b("iBizNoData"), {
          text: t.model.emptyText,
          emptyTextLanguageRes: t.model.emptyTextLanguageRes
        }, null);
      }
      return p("div", null, null);
    }, {
      tableData: y,
      renderColumns: E,
      defaultSort: k,
      summaryMethod: Y,
      ganttSummaryMethod: G
    } = Ee(t, e), {
      renderPopover: X
    } = xe(c, t), M = P(() => {
      var C;
      return (C = i.value) == null ? void 0 : C.scrollBarRef.wrapRef;
    }), T = P(() => {
      var C;
      return (C = c.value) == null ? void 0 : C.scrollBarRef.wrapRef;
    }), $ = (C = !1) => {
      var S;
      let v = 0;
      if (C)
        E.value.forEach((D) => v += D.width || 0);
      else {
        const D = (S = c.value) == null ? void 0 : S.store.states.columns.value;
        (D == null ? void 0 : D.length) > 0 && D.forEach((L) => v += L.realWidth || L.width);
      }
      return v;
    }, j = (C = !1) => {
      setTimeout(() => {
        var D, L;
        const v = (D = c.value) == null ? void 0 : D.$el;
        v && (v.style.width = "".concat($(C), "px"));
        const S = (L = i.value) == null ? void 0 : L.$el;
        S && (S.style.width = "calc(100% - ".concat($(C), "px)"));
      }, 300);
    }, F = (C) => {
      C === "gantt" ? c.value.setScrollTop(M.value.scrollTop) : i.value.setScrollTop(T.value.scrollTop);
    }, W = () => {
      F("gantt");
    }, q = () => {
      F("table");
    }, Z = () => {
      j();
    }, ee = () => {
      var v;
      const C = (v = t.model.controls) == null ? void 0 : v.find((S) => S.name === "".concat(t.model.name, "_batchtoolbar"));
      if (!(!C || t.state.singleSelect))
        return p("div", {
          class: [a.b("batch-toolbar"), a.is("show", t.state.selectedData.length > 0)]
        }, [p("div", {
          class: a.b("batch-toolbar-content")
        }, [p("div", {
          class: a.b("batch-toolbar-text")
        }, [z("已选中"), t.state.selectedData.length, z("项")]), p("div", {
          class: a.b("batch-toolbar-separator")
        }, [z("|")]), p(b("iBizToolbarControl"), {
          modelData: C,
          context: t.context,
          params: t.params,
          class: a.b("batch-toolbar-items")
        }, null)])]);
    };
    return pe(() => {
      j(!0), setTimeout(() => {
        M.value && M.value.addEventListener("scroll", W), T.value && T.value.addEventListener("scroll", q);
      }, 300);
    }), Q(() => {
      r.decrement(), M.value && M.value.removeEventListener("scroll", W), T.value && T.value.removeEventListener("scroll", q);
    }), {
      c: t,
      ns: a,
      ns2: d,
      tableRef: c,
      ganttRef: i,
      tableData: y,
      renderColumns: E,
      onDbRowClick: u,
      onRowClick: f,
      onSelectionChange: s,
      onSortChange: n,
      onPageChange: h,
      onPageSizeChange: g,
      onPageRefresh: m,
      handleRowClassName: l,
      handleHeaderCellClassName: o,
      renderNoData: x,
      summaryMethod: Y,
      ganttSummaryMethod: G,
      renderPopover: X,
      defaultSort: k,
      renderBatchToolBar: ee,
      headerCssVars: w,
      onHeaderDragend: Z
    };
  },
  render() {
    if (!this.c.state.isCreated)
      return;
    const {
      state: e
    } = this.c, {
      hideHeader: t,
      enablePagingBar: a,
      enableCustomized: d,
      enableGroup: r
    } = this.c.model;
    return p(b("iBizControlBase"), {
      class: [this.ns2.b(), this.ns.is("show-header", !t), this.ns.is("enable-page", a), this.ns.is("enable-group", r), this.ns.is("single-select", e.singleSelect), this.ns.is("empty", e.items.length === 0), this.ns.is("enable-customized", d)],
      controller: this.c,
      style: this.headerCssVars
    }, {
      default: () => [p("div", {
        class: this.ns2.e("container")
      }, [p(b("el-table"), {
        ref: "tableRef",
        class: [this.ns.e("table"), this.ns2.e("left")],
        "default-sort": this.defaultSort,
        border: !0,
        onHeaderDragend: this.onHeaderDragend,
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
        default: () => [!e.singleSelect && p(b("el-table-column"), {
          "class-name": this.ns.e("selection"),
          type: "selection",
          width: "55"
        }, null), this.renderColumns.map((i, c) => J(this.c, i, this.renderColumns))],
        append: () => this.renderPopover()
      }), p(b("el-table"), {
        ref: "ganttRef",
        class: [this.ns.e("table"), this.ns2.e("right")],
        "default-sort": this.defaultSort,
        border: !0,
        "show-header": !t,
        "show-summary": this.c.enableAgg,
        "summary-method": this.ganttSummaryMethod,
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
        empty: () => p("div", null, null),
        default: () => [p(Pe, {
          controller: this.c,
          columns: this.c.state.ganttColumns
        }, null)]
      })]), a && p(b("iBizPagination"), {
        total: e.total,
        curPage: e.curPage,
        size: e.size,
        onChange: this.onPageChange,
        onPageSizeChange: this.onPageSizeChange,
        onPageRefresh: this.onPageRefresh
      }, null), d && !t && p("div", {
        class: this.ns.b("setting-box")
      }, [p(b("iBizGridSetting"), {
        columnStates: e.columnStates,
        controller: this.c
      }, null)]), this.renderBatchToolBar()]
    });
  }
});
class Le {
  constructor() {
    O(this, "component", "IBizWorkloadTableControl");
  }
}
const Ne = ne(
  B,
  (e) => {
    e.component(B.name, B), ue(
      "GRID_RENDER_WORKLOAD_TABLE",
      () => new Le()
    );
  }
), He = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(e) {
    e.use(Ne);
  }
};
export {
  Ne as IBizWorkloadTableControl,
  He as default
};
