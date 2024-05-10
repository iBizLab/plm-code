import './style.css';
var pe = Object.defineProperty;
var we = (e, s, t) => s in e ? pe(e, s, { enumerable: !0, configurable: !0, writable: !0, value: t }) : e[s] = t;
var k = (e, s, t) => (we(e, typeof s != "symbol" ? s + "" : s, t), t);
import { useUIStore as ge, useNamespace as j, useControlController as J, withInstall as Ce } from "@ibiz-template/vue3-util";
import { Srfuf as X, GridRowState as Z, ControlVO as be, TreeGridController as ye, calcDeCodeNameById as ve, GridNotifyState as K, GridController as Ee, ScriptFactory as Re, registerControlProvider as Se } from "@ibiz-template/runtime";
import { ref as $, computed as L, watch as U, nextTick as De, reactive as xe, createVNode as w, resolveComponent as D, defineComponent as Pe, onMounted as Ne, onUnmounted as Ge, createTextVNode as B, mergeProps as ee, h as Ie } from "vue";
import { toNumber as Te, isArray as Y } from "lodash-es";
import { isElementSame as Le, RuntimeError as A, awaitTimeout as ke, mergeDefaultInLeft as Ae, RuntimeModelError as _e } from "@ibiz-template/core";
import { createUUID as Fe } from "qx-util";
import { computePosition as Oe } from "@floating-ui/dom";
class ze {
  constructor() {
    k(this, "component", "IBizNumberGridControl");
  }
}
function Me(e) {
  const s = $(), t = $([]), i = L(() => e.state.rows.map((n) => u(n.data))), o = L(() => {
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
  function u(n) {
    return n._hasChildren = e.state.items.some(
      (p) => n[e.treeGridValueField] && n[e.treeGridValueField] === p[e.treeGridParentField]
    ), n._children = [], n;
  }
  function d(n) {
    return !!t.value.find(
      (p) => n.tempsrfkey === p.tempsrfkey
    );
  }
  function c() {
    return e.model.enableGroup ? t.value.filter((n) => !n.isGroupData) : t.value;
  }
  U(
    [
      () => s.value,
      () => e.state.isLoaded,
      () => e.state.selectedData
    ],
    ([n, p, C]) => {
      !p || !n || (Le(C, c()) || (t.value = C), e.state.singleSelect && (C[0] ? s.value.setCurrentRow(C[0], !0) : s.value.setCurrentRow()));
    }
  );
  function h(n) {
    const { prop: p, order: C } = n, R = e.fieldColumns[p].model.appDEFieldId;
    let y;
    C === "ascending" ? y = "asc" : C === "descending" && (y = "desc"), "".concat(R, ",").concat(y) !== e.state.sortQuery && (e.setSort(R, y), e.load());
  }
  function f({ row: n }) {
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
    var N;
    const y = (N = e.model.degridColumns) == null ? void 0 : N.find((G) => G.codeName === p.property);
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
  ), P = (n) => {
    const { row: p, isReloadParent: C, eventName: R } = n;
    let y = C ? b(p) : p;
    if (y) {
      const N = s.value.store.states.treeData.value, G = s.value.store.states.lazyTreeNodeMap.value;
      if (N && N[y.data.tempsrfkey]) {
        N[y.data.tempsrfkey].loaded = !1;
        const O = i.value.find(
          (z) => y.data[e.treeGridValueField] === z[e.treeGridValueField]
        );
        O && !O._hasChildren && N[y.data.tempsrfkey].children.length > 0 && delete G[y.data.tempsrfkey];
      }
      s.value.store.loadOrToggle(y.data);
    }
  };
  return e.evt.on("onReloadNode", (n) => {
    setTimeout(() => {
      e.state.showTreeGrid && P(n);
    });
  }), {
    tableRef: s,
    getSelection: c,
    curSelectedData: t,
    onRowClick: r,
    onDbRowClick: l,
    isSelected: d,
    onSortChange: h,
    treeGirdItems: i,
    treeGirdData: o,
    handleRowClassName: f,
    handleHeaderCellClassName: g
  };
}
function Be(e, s) {
  const { controlParam: t } = s.modelData, i = () => {
    s.data && (e.state.items = s.data, e.state.rows = s.data.map((d) => new Z(new be(d), e)));
  }, o = L(() => {
    var c;
    const d = Object.values(e.fieldColumns).find(
      (h) => h.model.appDEFieldId === e.model.minorSortAppDEFieldId
    );
    return {
      prop: d == null ? void 0 : d.model.codeName,
      order: ((c = e.model.minorSortDir) == null ? void 0 : c.toLowerCase()) === "desc" ? "descending" : "ascending"
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
    const { state: d } = e;
    let c = {
      appId: e.context.srfappid,
      cssClass: "cube-outline"
    };
    if (t && t.ctrlParams && t.ctrlParams.GROUPICON && (c.cssClass = t.ctrlParams.GROUPICON), e.model.enableGroup) {
      const h = [];
      return d.groups.forEach((f) => {
        if (!f.children.length)
          return;
        f.groupIcon && (c = f.groupIcon);
        const g = [...f.children], b = Fe();
        h.push({
          tempsrfkey: b,
          srfkey: b,
          isGroupData: !0,
          caption: f.caption,
          _children: g,
          groupIcon: c
        });
      }), h;
    }
    return d.rows.map((h) => h.data);
  }), l = L(() => {
    if (e.isMultistageHeader)
      return e.model.degridColumns || [];
    const d = [];
    return e.state.columnStates.forEach((c) => {
      var f, g;
      if (c.hidden)
        return;
      const h = ((f = e.fieldColumns[c.key]) == null ? void 0 : f.model) || ((g = e.uaColumns[c.key]) == null ? void 0 : g.model);
      h && d.push(h);
    }), d;
  });
  return { tableData: r, renderColumns: l, defaultSort: o, summaryMethod: ({
    columns: d
  }) => d.map((c, h) => h === 0 ? e.aggTitle : e.state.aggResult[c.property]) };
}
function $e(e) {
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
  const i = $(!1), o = $(), r = xe({}), l = (f) => {
    if (!e.value)
      throw new A("找不到表格组件引用");
    const g = e.value.$el;
    let b = ".editing-row";
    f.data.srfkey && (b += ".id-".concat(f.data.srfkey));
    const P = g.querySelector(b);
    if (!P)
      throw new A("找不到对应的表格行dom元素");
    return P;
  }, u = async (f) => {
    const g = l(f);
    if (!t)
      throw new A("拿不到pop组件的实例");
    const b = t.$el, {
      x: P,
      y: n
    } = await Oe(g, b, {
      placement: "bottom"
    });
    Object.assign(r, {
      top: "".concat(n, "px"),
      left: "".concat(P, "px")
    }), o.value = f, i.value = !0;
  }, d = async () => {
    o.value && s.switchRowEdit(o.value, !1, !0);
  }, c = async () => {
    o.value && s.switchRowEdit(o.value, !1, !1);
  }, h = () => {
    const f = i.value && s.state.rows[s.state.rows.length - 1].showRowEdit;
    return [w("div", {
      class: "row-edit-popover__placeholder",
      style: {
        display: f ? "block" : "none"
      }
    }, null), w(D("iBizRowEditPopover"), {
      ref: (g) => {
        t = g;
      },
      style: r,
      show: i.value,
      onConfirm: d,
      onCancel: c
    }, null)];
  };
  return s.evt.on("onRowEditChange", (f) => {
    f.row.showRowEdit ? setTimeout(() => {
      u(f.row);
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
      const { context: l } = this.handlerAbilityParams(t), u = await this.getFetchParams(t == null ? void 0 : t.viewParam);
      u != null && u.hasOwnProperty("srfshowmode") || this.state.showTreeGrid && Object.assign(u, {
        srfshowmode: "tree"
      });
      const d = await this.service.fetch(l, u);
      typeof d.total == "number" && (this.state.total = d.total), typeof d.totalPages == "number" && (this.state.totalPages = d.totalPages), r ? this.state.items.push(...d.data) : this.state.items = d.data, await this.afterLoad(t, d.data), this.state.isLoaded = !0, await this._evt.emit("onLoadSuccess", {
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
        (l) => this.state.items.find((u) => l.tempsrfkey === u.tempsrfkey)
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
    const u = ve(this.model.appDataEntityId), d = this.context.clone();
    d[u] = t.srfkey;
    try {
      l = i ? await this.service.create(d, t) : await this.service.update(d, t);
    } catch (h) {
      throw await this._evt.emit("onSaveError", void 0), this.actionNotification("".concat(i ? "CREATE" : "UPDATE", "ERROR"), {
        error: h,
        data: o.data
      }), h;
    }
    const c = this.findRowStateIndex(t);
    this.state.items.splice(c, 1, l.data), o.data = l.data, o.modified = !1, i && this._evt.emit("onReloadNode", { row: o, isReloadParent: !0 }), this.gridStateNotify(o, K.SAVE), await this._evt.emit("onSaveSuccess", void 0);
  }
  afterRemove(t) {
    const i = this.state.items.findIndex(
      (l) => l.srfkey === t.srfkey
    );
    i !== -1 && this.state.items.splice(i, 1);
    const o = this.findRowStateIndex(t), r = this.state.rows[o];
    this.state.rows.splice(o, 1), this.state.groups.forEach((l) => {
      if (l.children.length) {
        const u = l.children.findIndex(
          (d) => d.srfkey === t.srfkey
        );
        u !== -1 && l.children.splice(u, 1);
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
    const l = { ...this.params }, u = this.calcDefaultValue(r || {}, !0);
    r.srfDefaultData && Object.assign(u, r.srfDefaultData), Object.assign(l, u);
    let d;
    try {
      d = await this.service.getDraft(this.context, l);
    } catch (f) {
      throw this.actionNotification("GETDRAFTERROR", {
        error: f
      }), f;
    }
    const c = d.data;
    Ae(c, u), r && (c[this.treeGridParentField] = r[this.treeGridValueField]), r.srfUserData && (c.srfUserData = r.srfUserData), this.state.items.push(c);
    const h = new Z(c, this);
    this.state.rows.push(h), this.gridStateNotify(h, K.DRAFT), o === "row" && this.switchRowEdit(h, !0), this._evt.emit("onReloadNode", { row: h, isReloadParent: !0 }), this.actionNotification("GETDRAFTSUCCESS", { data: c });
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
    const { curPage: i, size: o, sortQuery: r, noSort: l } = this.state, u = {
      ...this.params
    };
    if (o && (u.page = i - 1, u.size = o), !l)
      if (r)
        u.sort = r;
      else {
        const { minorSortAppDEFieldId: d, minorSortDir: c } = this.getSortModel();
        if (this.view && localStorage.getItem("".concat(this.view.model.id, ".").concat(this.model.name, ".sort")))
          this.state.sortQuery = localStorage.getItem(
            "".concat(this.view.model.id, ".").concat(this.model.name, ".sort")
          );
        else if (d && c) {
          const h = this.fieldIdNameMap.get(d);
          this.state.sortQuery = "".concat(h.toLowerCase(), ",").concat(c.toLowerCase());
        }
        u.sort = this.state.sortQuery, this.setSortCache();
      }
    return await this._evt.emit("onBeforeLoad", void 0), Object.assign(u, {
      ...this.state.searchParams
    }), t && Object.assign(u, t), u;
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
      const l = /* @__PURE__ */ new Map(), u = o === "CODELIST", d = r.toLowerCase();
      u && this.codeListItems.forEach((c) => {
        l.set(c.value, []);
      }), t.forEach((c) => {
        const h = c[d];
        !u && !l.has(h) && l.set(h, []), l.has(h) && l.get(h).push(c);
      }), this.state.groups = [], l.forEach((c, h) => {
        var g;
        const f = (g = this.codeListItems) == null ? void 0 : g.find(
          (b) => b.value === h
        );
        this.state.groups.push({
          caption: (f == null ? void 0 : f.text) || "".concat(h || "其他"),
          groupIcon: f == null ? void 0 : f.sysImage,
          key: h,
          children: c
        });
      });
    }
  }
  async afterLoad(t, i) {
    if (await super.afterLoad(t, i), t.isInitialLoad === !0)
      this.state.selectedData = [];
    else {
      const r = this.state.selectedData.filter(
        (l) => this.state.items.find((u) => l.tempsrfkey === u.tempsrfkey)
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
  } = s, l = e.columns[o], u = e.state.columnStates.find((b) => b.key === o), d = t.find((b) => e.columns[b.codeName].isAdaptiveColumn), h = l.isAdaptiveColumn || !d && i === t.length - 1 ? "min-width" : "width";
  let f = "default";
  return e != null && e.expandColumnIndex && i < Te(e == null ? void 0 : e.expandColumnIndex) && (f = ""), w(D("el-table-column"), ee({
    label: s.caption,
    prop: o
  }, {
    [h]: r
  }, {
    fixed: u.fixed,
    sortable: s.enableSort ? "custom" : !1,
    align: ((g = s.align) == null ? void 0 : g.toLowerCase()) || "center",
    type: f
  }), {
    default: ({
      row: b
    }) => {
      const P = b;
      if (b.isGroupData)
        return i !== 0 ? null : w("div", {
          class: "group-column"
        }, [w(D("iBizIcon"), {
          class: "group-icon",
          icon: b.groupIcon
        }, null), b.caption]);
      const n = e.findRowState(P);
      if (n) {
        const p = D(e.providers[o].component);
        return Ie(p, {
          controller: l,
          row: n,
          key: P.tempsrfkey + o,
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
    const l = ((o = s.degridColumns) == null ? void 0 : o.filter((c) => !c.hideDefault)) || [], {
      width: u
    } = s, d = ((r = s.align) == null ? void 0 : r.toLowerCase()) || "center";
    return w(D("el-table-column"), {
      prop: s.codeName,
      label: s.caption,
      "min-width": u,
      align: d
    }, {
      default: () => l.map((c, h) => te(e, c, t, h))
    });
  }
  return Xe(e, s, t, i);
}
const Q = /* @__PURE__ */ Pe({
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
      tableRef: u,
      onRowClick: d,
      onDbRowClick: c,
      onSortChange: h,
      isSelected: f,
      curSelectedData: g,
      getSelection: b,
      handleRowClassName: P,
      treeGirdItems: n,
      treeGirdData: p,
      handleHeaderCellClassName: C
    } = Me(s), {
      onPageChange: R,
      onPageRefresh: y,
      onPageSizeChange: N
    } = $e(s), G = L(() => e.modelData.controlType === "TREEGRID" ? s.state.showTreeGrid : !1), O = async (a, m, E) => {
      const v = n.value.filter((S) => a[s.treeGridValueField] === S[s.treeGridParentField]);
      E(v);
    };
    let z = [];
    const se = () => {
      const a = [];
      return u.value && u.value.$el.getElementsByClassName("el-table__row").forEach((v) => {
        v.style.display !== "none" && a.push(v);
      }), a;
    }, q = (a = 0) => {
      setTimeout(() => {
        const m = se();
        m.length !== z.length && (z = m, m.forEach((E, v) => {
          const S = E.firstChild;
          if (S.className.includes("ibiz-number-grid__first-column")) {
            const F = S.getElementsByClassName("ibiz-number-grid__number--caption")[0];
            F && (F.innerText = "".concat((s.state.curPage - 1) * s.state.size + (v + 1)));
          }
        }));
      }, a);
    }, oe = (a, m) => {
      q(), s.setRowExpand(a, m);
    };
    Ne(() => {
      const {
        controlType: a,
        enableGroup: m
      } = s.model;
      a === "GRID" && m && q(1e3);
    }), U(() => G.value, (a, m) => {
      a !== m && (g.value = [], s.setSelection([]));
    });
    const ie = () => {
      const a = [...p.value], m = (E) => {
        const v = n.value.filter((S) => S[s.treeGridParentField] && E[s.treeGridValueField] === S[s.treeGridParentField]);
        v.length > 0 && (a.push(...v), v.forEach((S) => {
          m(S);
        }));
      };
      return p.value.forEach((E) => {
        m(E);
      }), a;
    }, H = () => {
      let a = [];
      return G.value ? a = ie() : (a = [..._.value], s.model.enableGroup && _.value.forEach((m) => {
        a.push(...m._children);
      })), a;
    }, V = () => {
      const a = H();
      let m = !1;
      return a.length > 0 && (m = a.filter((v) => !f(v)).length === 0), m;
    }, ae = () => {
      const a = H(), m = g.value.filter((E) => !a.find((v) => v.tempsrfkey === E.tempsrfkey));
      V() || m.push(...a), g.value = m, s.setSelection(b());
    }, ne = (a) => {
      le(g.value, a), s.setSelection(b());
    }, re = (a) => {
      a.stopPropagation();
    }, le = (a, m) => {
      const {
        controlType: E,
        enableGroup: v
      } = s.model, S = a.findIndex((x) => x.tempsrfkey === m.tempsrfkey);
      S !== -1 ? (a.splice(S, 1), E === "GRID" && v && (Y(m._children) ? m._children.forEach((x) => {
        const I = a.indexOf(x);
        I !== -1 && a.splice(I, 1);
      }) : _.value.forEach((x) => {
        const I = x._children.find((T) => !a.includes(T)), M = a.findIndex((T) => T.tempsrfkey === x.tempsrfkey);
        I && M !== -1 && a.splice(M, 1);
      }))) : (a.push(m), E === "GRID" && v && (Y(m._children) ? m._children.forEach((x) => {
        a.indexOf(x) === -1 && a.push(x);
      }) : _.value.forEach((x) => {
        const I = x._children.find((T) => !a.includes(T)), M = a.findIndex((T) => T.tempsrfkey === x.tempsrfkey);
        !I && M === -1 && a.unshift(x);
      })));
    }, de = () => {
      var m;
      const {
        isLoaded: a
      } = s.state;
      if (a) {
        const E = (m = s.model.controls) == null ? void 0 : m.find((v) => v.name === "".concat(s.model.name, "_quicktoolbar"));
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
    } = Be(s, e), {
      renderPopover: he
    } = Ue(u, s), fe = () => {
      var m;
      const a = (m = s.model.controls) == null ? void 0 : m.find((E) => E.name === "".concat(s.model.name, "_batchtoolbar"));
      if (!(!a || s.state.singleSelect))
        return w("div", {
          class: [o.b("batch-toolbar"), l.b("batch-toolbar"), o.is("show", s.state.selectedData.length > 0)]
        }, [w("div", {
          class: o.b("batch-toolbar-content")
        }, [w("div", {
          class: o.b("batch-toolbar-text")
        }, [B("已选中"), s.state.selectedData.length, B("项")]), w("div", {
          class: o.b("batch-toolbar-separator")
        }, [B("|")]), w(D("iBizToolbarControl"), {
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
        }, [s.state.singleSelect ? w("span", null, [B("序号")]) : w(D("el-checkbox"), {
          size: "large",
          indeterminate: s.state.selectedData.length > 0 && !V(),
          modelValue: V(),
          onChange: () => ae()
        }, null)]),
        // eslint-disable-next-line @typescript-eslint/no-unused-vars
        default: ({
          row: m,
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
            modelValue: f(m),
            onChange: () => ne(m)
          }, null)]);
        }
      });
    };
    return Ge(() => {
      i.decrement();
    }), {
      c: s,
      ns: o,
      ns2: r,
      ns3: l,
      tableRef: u,
      tableData: _,
      treeGirdData: p,
      loadData: O,
      showTreeGrid: G,
      renderColumns: W,
      onDbRowClick: c,
      onRowClick: d,
      onExpandChange: oe,
      onSortChange: h,
      onPageChange: R,
      onPageSizeChange: N,
      onPageRefresh: y,
      handleRowClassName: P,
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
        totalPages: e.totalPages,
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
