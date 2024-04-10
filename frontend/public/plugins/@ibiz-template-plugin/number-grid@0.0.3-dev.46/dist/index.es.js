import './style.css';
var pe = Object.defineProperty;
var we = (e, s, t) => s in e ? pe(e, s, { enumerable: !0, configurable: !0, writable: !0, value: t }) : e[s] = t;
var k = (e, s, t) => (we(e, typeof s != "symbol" ? s + "" : s, t), t);
import { useUIStore as ge, useNamespace as j, useControlController as J, withInstall as Ce } from "@ibiz-template/vue3-util";
import { Srfuf as X, GridRowState as Z, ControlVO as be, TreeGridController as ye, calcDeCodeNameById as ve, GridNotifyState as K, GridController as Ee, ScriptFactory as Re, registerControlProvider as Se } from "@ibiz-template/runtime";
import { ref as B, computed as L, watch as U, nextTick as De, reactive as xe, createVNode as w, resolveComponent as D, defineComponent as Ne, onMounted as Ge, onUnmounted as Pe, createTextVNode as $, mergeProps as ee, h as Te } from "vue";
import { toNumber as Ie, isArray as Y } from "lodash-es";
import { isElementSame as Le, RuntimeError as A, awaitTimeout as ke, mergeDefaultInLeft as Ae, RuntimeModelError as _e } from "@ibiz-template/core";
import { createUUID as Fe } from "qx-util";
import { computePosition as Oe } from "@floating-ui/dom";
class ze {
  constructor() {
    k(this, "component", "IBizNumberGridControl");
  }
}
function Me(e) {
  const s = B(), t = B([]), i = L(() => e.state.rows.map((n) => d(n.data))), o = L(() => {
    const n = [], p = [];
    return i.value.forEach((C) => {
      const R = C[e.treeGridValueField];
      R && p.push(R);
    }), i.value.forEach((C) => {
      p.includes(C[e.treeGridParentField]) || n.push(C);
    }), n;
  });
  async function r(n, p, C) {
    if (!(e.model.enableGroup && n.isGroupData) && n.srfuf !== X.CREATE)
      if (ibiz.config.grid.editShowMode === "row" && e.model.enableRowEdit) {
        const R = e.findRowState(n);
        R && R.showRowEdit !== !0 && await e.switchRowEdit(R, !0);
      } else
        e.onRowClick(n);
  }
  function l(n) {
    e.model.enableGroup && n.isGroupData || n.srfuf !== X.CREATE && e.onDbRowClick(n);
  }
  function d(n) {
    return n._hasChildren = e.state.items.some(
      (p) => n[e.treeGridValueField] && n[e.treeGridValueField] === p[e.treeGridParentField]
    ), n._children = [], n;
  }
  function c(n) {
    return !!t.value.find(
      (p) => n.tempsrfkey === p.tempsrfkey
    );
  }
  function u() {
    return e.model.enableGroup ? t.value.filter((n) => !n.isGroupData) : t.value;
  }
  U(
    [
      () => s.value,
      () => e.state.isLoaded,
      () => e.state.selectedData
    ],
    ([n, p, C]) => {
      !p || !n || (Le(C, u()) || (t.value = C), e.state.singleSelect && (C[0] ? s.value.setCurrentRow(C[0], !0) : s.value.setCurrentRow()));
    }
  );
  function h(n) {
    const { prop: p, order: C } = n, R = e.fieldColumns[p].model.appDEFieldId;
    let y;
    C === "ascending" ? y = "asc" : C === "descending" && (y = "desc"), "".concat(R, ",").concat(y) !== e.state.sortQuery && (e.setSort(R, y), e.load());
  }
  function m({ row: n }) {
    let p = "";
    t.value.length > 0 && t.value.forEach((R) => {
      R.tempsrfkey === n.tempsrfkey && (p = "current-row");
    });
    const C = e.findRowState(n);
    return C != null && C.showRowEdit && (p += " editing-row"), n.srfkey && (p += " id-".concat(n.srfkey)), p;
  }
  function g({
    _row: n,
    column: p,
    _rowIndex: C,
    _columnIndex: R
  }) {
    var G;
    const y = (G = e.model.degridColumns) == null ? void 0 : G.find((P) => P.codeName === p.property);
    return y && y.headerSysCss && y.headerSysCss.cssName ? y.headerSysCss.cssName : "";
  }
  U(
    () => e.state.sortQuery,
    (n) => {
      if (n) {
        const p = e.state.sortQuery.split(",")[0], C = e.state.sortQuery.split(",")[1];
        if (p && C) {
          const R = C === "desc" ? "descending" : "ascending", y = () => {
            s.value ? De(() => {
              s.value.sort(p, R);
            }) : setTimeout(y, 500);
          };
          y();
        }
      }
    }
  );
  const b = (n) => e.state.rows.find(
    (p) => n.data[e.treeGridParentField] && p.data[e.treeGridValueField] === n.data[e.treeGridParentField]
  ), N = (n) => {
    const { row: p, isReloadParent: C, eventName: R } = n;
    let y = C ? b(p) : p;
    if (y) {
      const G = s.value.store.states.treeData.value, P = s.value.store.states.lazyTreeNodeMap.value;
      if (G && G[y.data.tempsrfkey]) {
        G[y.data.tempsrfkey].loaded = !1;
        const O = i.value.find(
          (z) => y.data[e.treeGridValueField] === z[e.treeGridValueField]
        );
        O && !O._hasChildren && G[y.data.tempsrfkey].children.length > 0 && delete P[y.data.tempsrfkey];
      }
      s.value.store.loadOrToggle(y.data);
    }
  };
  return e.evt.on("onReloadNode", (n) => {
    setTimeout(() => {
      e.state.showTreeGrid && N(n);
    });
  }), {
    tableRef: s,
    getSelection: u,
    curSelectedData: t,
    onRowClick: r,
    onDbRowClick: l,
    isSelected: c,
    onSortChange: h,
    treeGirdItems: i,
    treeGirdData: o,
    handleRowClassName: m,
    handleHeaderCellClassName: g
  };
}
function $e(e, s) {
  const { controlParam: t } = s.modelData, i = () => {
    s.data && (e.state.items = s.data, e.state.rows = s.data.map((c) => new Z(new be(c), e)));
  }, o = L(() => {
    var u;
    const c = Object.values(e.fieldColumns).find(
      (h) => h.model.appDEFieldId === e.model.minorSortAppDEFieldId
    );
    return {
      prop: c == null ? void 0 : c.model.codeName,
      order: ((u = e.model.minorSortDir) == null ? void 0 : u.toLowerCase()) === "desc" ? "descending" : "ascending"
    };
  });
  e.evt.on("onCreated", async () => {
    s.isSimple && (i(), e.state.isLoaded = !0);
  }), U(
    () => s.data,
    () => {
      s.isSimple && i();
    },
    {
      deep: !0
    }
  );
  const r = L(() => {
    const { state: c } = e;
    let u = "cube-outline";
    if (t && t.ctrlParams && t.ctrlParams.GROUPICON && (u = t.ctrlParams.GROUPICON), e.model.enableGroup) {
      const h = [];
      return c.groups.forEach((m) => {
        if (!m.children.length)
          return;
        const g = [...m.children], b = Fe();
        h.push({
          tempsrfkey: b,
          srfkey: b,
          isGroupData: !0,
          caption: m.caption,
          _children: g,
          groupIcon: u
        });
      }), h;
    }
    return c.rows.map((h) => h.data);
  }), l = L(() => {
    if (e.isMultistageHeader)
      return e.model.degridColumns || [];
    const c = [];
    return e.state.columnStates.forEach((u) => {
      var m, g;
      if (u.hidden)
        return;
      const h = ((m = e.fieldColumns[u.key]) == null ? void 0 : m.model) || ((g = e.uaColumns[u.key]) == null ? void 0 : g.model);
      h && c.push(h);
    }), c;
  });
  return { tableData: r, renderColumns: l, defaultSort: o, summaryMethod: ({
    columns: c
  }) => c.map((u, h) => h === 0 ? e.aggTitle : e.state.aggResult[u.property]) };
}
function Be(e) {
  function s(o) {
    !o || o === e.state.curPage || (e.state.curPage = o, e.load());
  }
  function t(o) {
    !o || o === e.state.size || (e.state.size = o, e.state.curPage === 1 && e.load());
  }
  function i() {
    e.load();
  }
  return { onPageChange: s, onPageSizeChange: t, onPageRefresh: i };
}
function Ue(e, s) {
  let t;
  const i = B(!1), o = B(), r = xe({}), l = (m) => {
    if (!e.value)
      throw new A("找不到表格组件引用");
    const g = e.value.$el;
    let b = ".editing-row";
    m.data.srfkey && (b += ".id-".concat(m.data.srfkey));
    const N = g.querySelector(b);
    if (!N)
      throw new A("找不到对应的表格行dom元素");
    return N;
  }, d = async (m) => {
    const g = l(m);
    if (!t)
      throw new A("拿不到pop组件的实例");
    const b = t.$el, {
      x: N,
      y: n
    } = await Oe(g, b, {
      placement: "bottom"
    });
    Object.assign(r, {
      top: "".concat(n, "px"),
      left: "".concat(N, "px")
    }), o.value = m, i.value = !0;
  }, c = async () => {
    o.value && s.switchRowEdit(o.value, !1, !0);
  }, u = async () => {
    o.value && s.switchRowEdit(o.value, !1, !1);
  }, h = () => {
    const m = i.value && s.state.rows[s.state.rows.length - 1].showRowEdit;
    return [w("div", {
      class: "row-edit-popover__placeholder",
      style: {
        display: m ? "block" : "none"
      }
    }, null), w(D("iBizRowEditPopover"), {
      ref: (g) => {
        t = g;
      },
      style: r,
      show: i.value,
      onConfirm: c,
      onCancel: u
    }, null)];
  };
  return s.evt.on("onRowEditChange", (m) => {
    m.row.showRowEdit ? setTimeout(() => {
      d(m.row);
    }, 0) : (o.value = void 0, i.value = !1, Object.assign(r, {
      top: void 0,
      left: void 0
    }));
  }), {
    renderPopover: h
  };
}
class Ve extends ye {
  constructor() {
    super(...arguments);
    /**
     * 是否默认展开所有
     *
     * @type {boolean}
     * @memberof NumberTreeGridController
     */
    k(this, "defaultExpandAll", !1);
    /**
     * 指定展开列下标
     *
     * @type {boolean}
     * @memberof NumberGridController
     */
    k(this, "expandColumnIndex");
  }
  get _evt() {
    return this.evt;
  }
  get overflowMode() {
    return "ellipsis";
  }
  /**
   * 切换显示模式
   *
   * @param {IData} param
   * @memberof NumberTreeGridController
   */
  switchShowMode(t) {
    const { showMode: i } = t;
    i && (i === "tree" ? this.state.showTreeGrid = !0 : i === "grid" && (this.state.showTreeGrid = !1), this.refresh());
  }
  /**
   * 初始化方法
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof NumberTreeGridController
   */
  async onCreated() {
    await super.onCreated();
    const { ctrlParams: t = {} } = this.model.controlParam;
    t.DEFAULTEXPANDALL && (this.defaultExpandAll = Object.is(t.DEFAULTEXPANDALL, "TRUE") || Object.is(t.DEFAULTEXPANDALL, "true")), t.GRIDROWACTIVEMODE && (this.state.mdctrlActiveMode = JSON.parse(t.GRIDROWACTIVEMODE)), t.EXPANDCOLUMNINDEX && (this.expandColumnIndex = t.EXPANDCOLUMNINDEX);
  }
  /**
   * 刷新
   *
   * @return {*}  {Promise<void>}
   * @memberof NumberTreeGridController
   */
  async refresh() {
    await this.load({ isInitialLoad: !1 }), this.state.expandRows.forEach((t) => {
      setTimeout(() => {
        this._evt.emit("onReloadNode", { row: t, isReloadParent: !1 });
      });
    });
  }
  /**
   * 部件加载数据行为
   *
   * @param {MDCtrlLoadParams} [args={}]
   * @return {*}  {Promise<IData[]>}
   * @memberof NumberTreeGridController
   */
  async load(t = {}) {
    if (this.state.isSimple)
      return [];
    const i = t.silent === !0;
    i || await this.startLoading();
    try {
      const o = t.isInitialLoad === !0, r = t.isLoadMore === !0;
      o ? this.state.curPage = 1 : r && (this.state.curPage += 1);
      const { context: l } = this.handlerAbilityParams(t), d = await this.getFetchParams(t == null ? void 0 : t.viewParam);
      d != null && d.hasOwnProperty("srfshowmode") || this.state.showTreeGrid && Object.assign(d, {
        srfshowmode: "tree"
      });
      const c = await this.service.fetch(l, d);
      typeof c.total == "number" && (this.state.total = c.total), r ? this.state.items.push(...c.data) : this.state.items = c.data, await this.afterLoad(t, c.data), this.state.isLoaded = !0, await this._evt.emit("onLoadSuccess", {
        isInitialLoad: o
      });
    } catch (o) {
      throw await this._evt.emit("onLoadError", void 0), this.actionNotification("FETCHERROR", {
        error: o
      }), o;
    } finally {
      i || await this.endLoading();
    }
    return this.state.items.forEach((o, r) => {
      o.srfserialnum = r + 1;
    }), this.actionNotification("FETCHSUCCESS"), this.state.items;
  }
  /**
   * 部件加载后处理
   *
   * @param {MDCtrlLoadParams} args
   * @param {ControlVO[]} items
   * @return {*}  {Promise<ControlVO[]>}
   * @memberof NumberTreeGridController
   */
  async afterLoad(t, i) {
    if (await super.afterLoad(t, i), t.isInitialLoad === !0)
      this.state.selectedData = [], this.state.expandRows = [];
    else {
      const r = this.state.selectedData.filter(
        (l) => this.state.items.find((d) => l.tempsrfkey === d.tempsrfkey)
      );
      this.state.selectedData = r;
    }
    return i;
  }
  /**
   * 保存
   *
   * @param {ControlVO} data
   * @return {*}  {Promise<void>}
   * @memberof NumberTreeGridController
   */
  async save(t) {
    if (this.state.isSimple)
      return;
    const i = t.srfuf === X.CREATE, o = this.findRowState(t);
    if (!o)
      throw new A("行数据不存在");
    if (!o.modified) {
      ibiz.log.debug("值没有发生改变");
      return;
    }
    if (o.processing) {
      await ke(500, this.save.bind(this), [t]);
      return;
    }
    if (!await this.validate(o))
      throw new A("行数据校验不通过，保存取消");
    let l;
    const d = ve(this.model.appDataEntityId), c = this.context.clone();
    c[d] = t.srfkey;
    try {
      l = i ? await this.service.create(c, t) : await this.service.update(c, t);
    } catch (h) {
      throw await this._evt.emit("onSaveError", void 0), this.actionNotification("".concat(i ? "CREATE" : "UPDATE", "ERROR"), {
        error: h,
        data: o.data
      }), h;
    }
    const u = this.findRowStateIndex(t);
    this.state.items.splice(u, 1, l.data), o.data = l.data, o.modified = !1, i && this._evt.emit("onReloadNode", { row: o, isReloadParent: !0 }), this.gridStateNotify(o, K.SAVE), await this._evt.emit("onSaveSuccess", void 0);
  }
  afterRemove(t) {
    const i = this.state.items.findIndex(
      (l) => l.srfkey === t.srfkey
    );
    i !== -1 && this.state.items.splice(i, 1);
    const o = this.findRowStateIndex(t), r = this.state.rows[o];
    this.state.rows.splice(o, 1), this.state.groups.forEach((l) => {
      if (l.children.length) {
        const d = l.children.findIndex(
          (c) => c.srfkey === t.srfkey
        );
        d !== -1 && l.children.splice(d, 1);
      }
    }), this._evt.emit("onReloadNode", {
      row: r,
      isReloadParent: !0,
      eventName: "remove"
    });
  }
  /**
   * 新建行
   *
   * @param {MDCtrlLoadParams} [args={}]
   * @return {*}  {Promise<void>}
   * @memberof NumberTreeGridController
   */
  async newRow(t = {}) {
    const { data: i } = t, { editShowMode: o } = ibiz.config.grid;
    let r = null;
    if (i && (r = Array.isArray(i) ? i[0] : i), o === "row" && this.state.rows.find((g) => g.showRowEdit))
      throw new A("请先完成当前行编辑中的行的操作");
    const l = { ...this.params }, d = this.calcDefaultValue(r || {}, !0);
    r.srfDefaultData && Object.assign(d, r.srfDefaultData), Object.assign(l, d);
    let c;
    try {
      c = await this.service.getDraft(this.context, l);
    } catch (m) {
      throw this.actionNotification("GETDRAFTERROR", {
        error: m
      }), m;
    }
    const u = c.data;
    Ae(u, d), r && (u[this.treeGridParentField] = r[this.treeGridValueField]), r.srfUserData && (u.srfUserData = r.srfUserData), this.state.items.push(u);
    const h = new Z(u, this);
    this.state.rows.push(h), this.gridStateNotify(h, K.DRAFT), o === "row" && this.switchRowEdit(h, !0), this._evt.emit("onReloadNode", { row: h, isReloadParent: !0 }), this.actionNotification("GETDRAFTSUCCESS", { data: u });
  }
  /**
   * 行单击事件
   *
   * @param {IData} data
   * @return {*}  {Promise<void>}
   * @memberof NumberTreeGridController
   */
  async onRowClick(t) {
    this.state.singleSelect && this.setSelection([t]), this.state.mdctrlActiveMode === 1 && await this.setActive(t);
  }
  /**
   * 设置行展开
   *
   * @param {IData} data
   * @param {boolean} state
   * @memberof NumberTreeGridController
   */
  setRowExpand(t, i) {
    const o = this.findRowState(t);
    if (o) {
      const r = this.state.expandRows.findIndex(
        (l) => l.data.tempsrfkey === (o == null ? void 0 : o.data.tempsrfkey)
      );
      i && r === -1 ? this.state.expandRows.push(o) : !i && r > -1 && this.state.expandRows.splice(r, 1);
    }
  }
}
class je extends Ee {
  constructor() {
    super(...arguments);
    /**
     * 分组代码表数据项
     *
     * @type {readonly}
     * @memberof NumberGridController
     */
    k(this, "codeListItems");
    /**
     * 是否默认展开所有
     *
     * @type {boolean}
     * @memberof NumberGridController
     */
    k(this, "defaultExpandAll", !1);
  }
  /**
   * 初始化方法
   *
   * @memberof NumberGridController
   */
  async onCreated() {
    await super.onCreated();
    const { ctrlParams: t = {} } = this.model.controlParam;
    t.DEFAULTEXPANDALL && (this.defaultExpandAll = Object.is(t.DEFAULTEXPANDALL, "TRUE") || Object.is(t.DEFAULTEXPANDALL, "true"));
  }
  /**
   * 设置排序
   */
  setSort(t, i) {
    if (!t && !i)
      return;
    let o;
    t && (o = this.fieldIdNameMap.get(t).toLowerCase()), o && i ? this.state.sortQuery = "".concat(o, ",").concat(i) : this.state.sortQuery = "", this.setSortCache();
  }
  /**
   * 设置排序缓存
   */
  setSortCache() {
    this.view && (this.state.sortQuery ? localStorage.setItem(
      "".concat(this.view.model.id, ".").concat(this.model.name, ".sort"),
      this.state.sortQuery
    ) : localStorage.removeItem(
      "".concat(this.view.model.id, ".").concat(this.model.name, ".sort")
    ));
  }
  /**
   * 获取请求过滤参数（整合了视图参数，各种过滤条件，排序，分页）
   */
  async getFetchParams(t) {
    const { curPage: i, size: o, sortQuery: r, noSort: l } = this.state, d = {
      ...this.params
    };
    if (o && (d.page = i - 1, d.size = o), !l)
      if (r)
        d.sort = r;
      else {
        const { minorSortAppDEFieldId: c, minorSortDir: u } = this.getSortModel();
        if (this.view && localStorage.getItem("".concat(this.view.model.id, ".").concat(this.model.name, ".sort")))
          this.state.sortQuery = localStorage.getItem(
            "".concat(this.view.model.id, ".").concat(this.model.name, ".sort")
          );
        else if (c && u) {
          const h = this.fieldIdNameMap.get(c);
          this.state.sortQuery = "".concat(h.toLowerCase(), ",").concat(u.toLowerCase());
        }
        d.sort = this.state.sortQuery, this.setSortCache();
      }
    return await this._evt.emit("onBeforeLoad", void 0), Object.assign(d, {
      ...this.state.searchParams
    }), t && Object.assign(d, t), d;
  }
  /**
   * 初始化表格分组
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof NumberGridController
   */
  async initGroup() {
    const { groupCodeListId: t, groupMode: i, enableGroup: o } = this.model;
    if (o && i === "CODELIST") {
      if (!t)
        throw new _e(
          this.model,
          "代码表分组模式需要配置代码表"
        );
      const r = ibiz.hub.getApp(this.context.srfappid);
      this.codeListItems = await r.codeList.get(
        t,
        this.context,
        this.params
      );
    }
  }
  /**
   * 计算分组数据
   *
   * @protected
   * @param {IData[]} items
   * @memberof NumberGridController
   */
  calcGroupData(t) {
    const { enableGroup: i, groupMode: o, groupAppDEFieldId: r } = this.model;
    if (i && r) {
      const l = /* @__PURE__ */ new Map(), d = o === "CODELIST", c = r.toLowerCase();
      d && this.codeListItems.forEach((u) => {
        l.set(u.value, []);
      }), t.forEach((u) => {
        const h = u[c];
        !d && !l.has(h) && l.set(h, []), l.has(h) && l.get(h).push(u);
      }), this.state.groups = [], l.forEach((u, h) => {
        var g;
        const m = (g = this.codeListItems) == null ? void 0 : g.find(
          (b) => b.value === h
        );
        this.state.groups.push({
          caption: (m == null ? void 0 : m.text) || "".concat(h || "其他"),
          key: h,
          children: u
        });
      });
    }
  }
  async afterLoad(t, i) {
    if (await super.afterLoad(t, i), t.isInitialLoad === !0)
      this.state.selectedData = [];
    else {
      const r = this.state.selectedData.filter(
        (l) => this.state.items.find((d) => l.tempsrfkey === d.tempsrfkey)
      );
      this.state.selectedData = r;
    }
    return i;
  }
  /**
   * 表格行单击
   *
   * @param {IData} data
   * @return {*}  {Promise<void>}
   * @memberof NumberGridController
   */
  async onRowClick(t) {
    this.state.singleSelect && this.setSelection([t]), this.state.mdctrlActiveMode === 1 && await this.setActive(t);
  }
}
function Qe(e, s) {
  var i;
  const t = {};
  return (i = e.controlAttributes) == null || i.forEach((o) => {
    o.attrName && o.attrValue && (t[o.attrName] = Re.execSingleLine(o.attrValue, {
      ...s
    }));
  }), t;
}
function Xe(e, s, t, i) {
  var g;
  const {
    codeName: o,
    width: r
  } = s, l = e.columns[o], d = e.state.columnStates.find((b) => b.key === o), c = t.find((b) => e.columns[b.codeName].isAdaptiveColumn), h = l.isAdaptiveColumn || !c && i === t.length - 1 ? "min-width" : "width";
  let m = "default";
  return e != null && e.expandColumnIndex && i < Ie(e == null ? void 0 : e.expandColumnIndex) && (m = ""), w(D("el-table-column"), ee({
    label: s.caption,
    prop: o
  }, {
    [h]: r
  }, {
    fixed: d.fixed,
    sortable: s.enableSort ? "custom" : !1,
    align: ((g = s.align) == null ? void 0 : g.toLowerCase()) || "center",
    type: m
  }), {
    default: ({
      row: b
    }) => {
      const N = b;
      if (b.isGroupData)
        return i !== 0 ? null : w("div", {
          class: "group-column"
        }, [w(D("ion-icon"), {
          class: "group-icon",
          name: b.groupIcon
        }, null), b.caption]);
      const n = e.findRowState(N);
      if (n) {
        const p = D(e.providers[o].component);
        return Te(p, {
          controller: l,
          row: n,
          key: N.tempsrfkey + o,
          attrs: Qe(s, {
            ...e.getEventArgs(),
            data: n.data
          })
        });
      }
      return null;
    }
  });
}
function te(e, s, t, i) {
  var o, r;
  if (s.columnType === "GROUPGRIDCOLUMN") {
    const l = ((o = s.degridColumns) == null ? void 0 : o.filter((u) => !u.hideDefault)) || [], {
      width: d
    } = s, c = ((r = s.align) == null ? void 0 : r.toLowerCase()) || "center";
    return w(D("el-table-column"), {
      prop: s.codeName,
      label: s.caption,
      "min-width": d,
      align: c
    }, {
      default: () => l.map((u, h) => te(e, u, t, h))
    });
  }
  return Xe(e, s, t, i);
}
const Q = /* @__PURE__ */ Ne({
  name: "IBizNumberGridControl",
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
    let s;
    (() => {
      e.modelData.controlType === "TREEGRID" ? s = J((...a) => new Ve(...a)) : s = J((...a) => new je(...a));
    })();
    const {
      zIndex: i
    } = ge();
    s.state.zIndex = i.increment();
    const o = j("control-grid"), r = L(() => {
      if (e.modelData.controlType === "TREEGRID")
        return j("control-".concat(s.model.controlType.toLowerCase()));
    }), l = j("number-grid"), {
      tableRef: d,
      onRowClick: c,
      onDbRowClick: u,
      onSortChange: h,
      isSelected: m,
      curSelectedData: g,
      getSelection: b,
      handleRowClassName: N,
      treeGirdItems: n,
      treeGirdData: p,
      handleHeaderCellClassName: C
    } = Me(s), {
      onPageChange: R,
      onPageRefresh: y,
      onPageSizeChange: G
    } = Be(s), P = L(() => e.modelData.controlType === "TREEGRID" ? s.state.showTreeGrid : !1), O = async (a, f, E) => {
      const v = n.value.filter((S) => a[s.treeGridValueField] === S[s.treeGridParentField]);
      E(v);
    };
    let z = [];
    const se = () => {
      const a = [];
      return d.value && d.value.$el.getElementsByClassName("el-table__row").forEach((v) => {
        v.style.display !== "none" && a.push(v);
      }), a;
    }, q = (a = 0) => {
      setTimeout(() => {
        const f = se();
        f.length !== z.length && (z = f, f.forEach((E, v) => {
          const S = E.firstChild;
          if (S.className.includes("ibiz-number-grid__first-column")) {
            const F = S.getElementsByClassName("ibiz-number-grid__number--caption")[0];
            F && (F.innerText = "".concat((s.state.curPage - 1) * s.state.size + (v + 1)));
          }
        }));
      }, a);
    }, oe = (a, f) => {
      q(), s.setRowExpand(a, f);
    };
    Ge(() => {
      const {
        controlType: a,
        enableGroup: f
      } = s.model;
      a === "GRID" && f && q(1e3);
    }), U(() => P.value, (a, f) => {
      a !== f && (g.value = [], s.setSelection([]));
    });
    const ie = () => {
      const a = [...p.value], f = (E) => {
        const v = n.value.filter((S) => S[s.treeGridParentField] && E[s.treeGridValueField] === S[s.treeGridParentField]);
        v.length > 0 && (a.push(...v), v.forEach((S) => {
          f(S);
        }));
      };
      return p.value.forEach((E) => {
        f(E);
      }), a;
    }, H = () => {
      let a = [];
      return P.value ? a = ie() : (a = [..._.value], s.model.enableGroup && _.value.forEach((f) => {
        a.push(...f._children);
      })), a;
    }, V = () => {
      const a = H();
      let f = !1;
      return a.length > 0 && (f = a.filter((v) => !m(v)).length === 0), f;
    }, ae = () => {
      const a = H(), f = g.value.filter((E) => !a.find((v) => v.tempsrfkey === E.tempsrfkey));
      V() || f.push(...a), g.value = f, s.setSelection(b());
    }, ne = (a) => {
      le(g.value, a), s.setSelection(b());
    }, re = (a) => {
      a.stopPropagation();
    }, le = (a, f) => {
      const {
        controlType: E,
        enableGroup: v
      } = s.model, S = a.findIndex((x) => x.tempsrfkey === f.tempsrfkey);
      S !== -1 ? (a.splice(S, 1), E === "GRID" && v && (Y(f._children) ? f._children.forEach((x) => {
        const T = a.indexOf(x);
        T !== -1 && a.splice(T, 1);
      }) : _.value.forEach((x) => {
        const T = x._children.find((I) => !a.includes(I)), M = a.findIndex((I) => I.tempsrfkey === x.tempsrfkey);
        T && M !== -1 && a.splice(M, 1);
      }))) : (a.push(f), E === "GRID" && v && (Y(f._children) ? f._children.forEach((x) => {
        a.indexOf(x) === -1 && a.push(x);
      }) : _.value.forEach((x) => {
        const T = x._children.find((I) => !a.includes(I)), M = a.findIndex((I) => I.tempsrfkey === x.tempsrfkey);
        !T && M === -1 && a.unshift(x);
      })));
    }, de = () => {
      var f;
      const {
        isLoaded: a
      } = s.state;
      if (a) {
        const E = (f = s.model.controls) == null ? void 0 : f.find((v) => v.name === "".concat(s.model.name, "_quicktoolbar"));
        return E ? w(D("iBizToolbarControl"), {
          modelData: E,
          context: s.context,
          params: s.params,
          class: o.b("quick-toolbar")
        }, null) : w(D("iBizNoData"), {
          text: s.model.emptyText,
          emptyTextLanguageRes: s.model.emptyTextLanguageRes
        }, null);
      }
      return null;
    }, {
      tableData: _,
      renderColumns: W,
      defaultSort: ce,
      summaryMethod: ue
    } = $e(s, e), {
      renderPopover: he
    } = Ue(d, s), fe = () => {
      var f;
      const a = (f = s.model.controls) == null ? void 0 : f.find((E) => E.name === "".concat(s.model.name, "_batchtoolbar"));
      if (!(!a || s.state.singleSelect))
        return w("div", {
          class: [o.b("batch-toolbar"), l.b("batch-toolbar"), o.is("show", s.state.selectedData.length > 0)]
        }, [w("div", {
          class: o.b("batch-toolbar-content")
        }, [w("div", {
          class: o.b("batch-toolbar-text")
        }, [$("已选中"), s.state.selectedData.length, $("项")]), w("div", {
          class: o.b("batch-toolbar-separator")
        }, [$("|")]), w(D("iBizToolbarControl"), {
          modelData: a,
          context: s.context,
          params: s.params,
          class: o.b("batch-toolbar-items")
        }, null)])]);
    }, me = () => {
      const a = W.value.length ? "width" : "min-width";
      return w(D("el-table-column"), ee({
        "class-name": l.e("first-column")
      }, {
        [a]: 80
      }, {
        align: "center",
        fixed: "left",
        type: "index"
      }), {
        header: () => w("div", {
          class: l.e("number")
        }, [s.state.singleSelect ? w("span", null, [$("序号")]) : w(D("el-checkbox"), {
          size: "large",
          indeterminate: s.state.selectedData.length > 0 && !V(),
          modelValue: V(),
          onChange: () => ae()
        }, null)]),
        // eslint-disable-next-line @typescript-eslint/no-unused-vars
        default: ({
          row: f,
          column: E,
          $index: v
        }) => {
          const S = (s.state.curPage - 1) * s.state.size + (v + 1);
          return s.state.singleSelect ? w("div", {
            class: l.e("number")
          }, [w("span", null, [S])]) : w("div", {
            class: l.e("number"),
            onClick: (F) => re(F)
          }, [w("span", {
            class: l.em("number", "caption")
          }, [S]), w(D("el-checkbox"), {
            size: "large",
            class: l.em("number", "checkbox"),
            modelValue: m(f),
            onChange: () => ne(f)
          }, null)]);
        }
      });
    };
    return Pe(() => {
      i.decrement();
    }), {
      c: s,
      ns: o,
      ns2: r,
      ns3: l,
      tableRef: d,
      tableData: _,
      treeGirdData: p,
      loadData: O,
      showTreeGrid: P,
      renderColumns: W,
      onDbRowClick: u,
      onRowClick: c,
      onExpandChange: oe,
      onSortChange: h,
      onPageChange: R,
      onPageSizeChange: G,
      onPageRefresh: y,
      handleRowClassName: N,
      handleHeaderCellClassName: C,
      renderNoData: de,
      summaryMethod: ue,
      renderPopover: he,
      defaultSort: ce,
      renderBatchToolBar: fe,
      renderFirstColumn: me
    };
  },
  render() {
    var i;
    if (!this.c.state.isCreated)
      return;
    const {
      state: e
    } = this.c, {
      hideHeader: s,
      enablePagingBar: t
    } = this.c.model;
    return w(D("iBizControlBase"), {
      class: [this.ns.b(), (i = this.ns2) == null ? void 0 : i.b(), this.ns3.b(), this.ns.is("show-header", !s), this.ns.is("enable-page", t), this.ns.is("enable-group", this.c.model.enableGroup), this.ns.is("single-select", e.singleSelect), this.ns.is("enable-customized", this.c.model.enableCustomized)],
      controller: this.c
    }, {
      default: () => [w(D("el-table"), {
        border: !0,
        ref: "tableRef",
        "row-key": "tempsrfkey",
        class: this.ns.e("table"),
        "default-sort": this.defaultSort,
        "show-header": !s,
        "show-summary": this.c.enableAgg,
        "summary-method": this.summaryMethod,
        "highlight-current-row": e.singleSelect,
        "row-class-name": this.handleRowClassName,
        "header-cell-class-name": this.handleHeaderCellClassName,
        data: this.showTreeGrid ? this.treeGirdData : this.tableData,
        onRowClick: this.onRowClick,
        onRowDblclick: this.onDbRowClick,
        onSortChange: this.onSortChange,
        onExpandChange: this.onExpandChange,
        "tooltip-effect": "light",
        "default-expand-all": this.c.defaultExpandAll,
        "tree-props": {
          children: "_children",
          hasChildren: "_hasChildren"
        },
        load: this.loadData,
        lazy: this.showTreeGrid
      }, {
        empty: this.renderNoData,
        default: () => [this.renderFirstColumn(), this.renderColumns.map((o, r) => te(this.c, o, this.renderColumns, r))],
        append: () => this.renderPopover()
      }), t && w(D("iBizPagination"), {
        total: e.total,
        curPage: e.curPage,
        size: e.size,
        onChange: this.onPageChange,
        onPageSizeChange: this.onPageSizeChange,
        onPageRefresh: this.onPageRefresh
      }, null), this.c.model.enableCustomized && !s && w("div", {
        class: [this.ns.b("setting-box"), this.ns3.b("setting-box")]
      }, [w(D("iBizGridSetting"), {
        columnStates: e.columnStates,
        controller: this.c
      }, null)]), this.renderBatchToolBar()]
    });
  }
}), qe = Ce(
  Q,
  (e) => {
    e.component(Q.name, Q), Se(
      "GRID_RENDER_NUMBER_GRID",
      () => new ze()
    );
  }
), st = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(e) {
    e.use(qe);
  }
};
export {
  qe as IBizNumberGridControl,
  st as default
};
