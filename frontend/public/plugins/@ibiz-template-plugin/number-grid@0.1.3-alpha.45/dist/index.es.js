import './style.css';
var me = Object.defineProperty;
var pe = (e, s, t) => s in e ? me(e, s, { enumerable: !0, configurable: !0, writable: !0, value: t }) : e[s] = t;
var k = (e, s, t) => (pe(e, typeof s != "symbol" ? s + "" : s, t), t);
import { useUIStore as we, useNamespace as j, useControlController as W, withInstall as ge } from "@ibiz-template/vue3-util";
import { GridRowState as Y, ControlVO as Ce, TreeGridController as be, Srfuf as ye, calcDeCodeNameById as ve, GridNotifyState as J, GridController as Ee, registerControlProvider as Re } from "@ibiz-template/runtime";
import { ref as B, computed as L, watch as U, nextTick as Se, reactive as De, createVNode as w, resolveComponent as S, defineComponent as xe, onMounted as Ge, onUnmounted as Pe, createTextVNode as $, mergeProps as Z, h as Ne } from "vue";
import { toNumber as Ie, isArray as K } from "lodash-es";
import { isElementSame as Te, RuntimeError as _, awaitTimeout as Le, mergeDefaultInLeft as ke, RuntimeModelError as _e } from "@ibiz-template/core";
import { createUUID as Ae } from "qx-util";
import { computePosition as Fe } from "@floating-ui/dom";
class Oe {
  constructor() {
    k(this, "component", "IBizNumberGridControl");
  }
}
function ze(e) {
  const s = B(), t = B([]), i = L(() => e.state.rows.map((l) => u(l.data))), o = L(() => i.value.filter(
    (p) => !p[e.treeGridParentField]
  ));
  async function r(l, p, v) {
    if (!(e.model.enableGroup && l.isGroupData))
      if (ibiz.config.grid.editShowMode === "row" && e.model.enableRowEdit) {
        const D = e.findRowState(l);
        D && D.showRowEdit !== !0 && await e.switchRowEdit(D, !0);
      } else
        e.onRowClick(l);
  }
  function n(l) {
    e.model.enableGroup && l.isGroupData || e.onDbRowClick(l);
  }
  function u(l) {
    return l._hasChildren = e.state.items.some(
      (p) => l[e.treeGridValueField] && l[e.treeGridValueField] === p[e.treeGridParentField]
    ), l._children = [], l;
  }
  function d(l) {
    return !!t.value.find(
      (p) => l.tempsrfkey === p.tempsrfkey
    );
  }
  function c() {
    return e.model.enableGroup ? t.value.filter((l) => !l.isGroupData) : t.value;
  }
  U(
    [
      () => s.value,
      () => e.state.isLoaded,
      () => e.state.selectedData
    ],
    ([l, p, v]) => {
      !p || !l || (Te(v, c()) || (t.value = v), e.state.singleSelect && (v[0] ? s.value.setCurrentRow(v[0], !0) : s.value.setCurrentRow()));
    }
  );
  function h(l) {
    const { prop: p, order: v } = l, D = e.fieldColumns[p].model.appDEFieldId;
    let b;
    v === "ascending" ? b = "asc" : v === "descending" && (b = "desc"), "".concat(D, ",").concat(b) !== e.state.sortQuery && (e.setSort(D, b), e.load());
  }
  function m({ row: l }) {
    let p = "";
    t.value.length > 0 && t.value.forEach((D) => {
      D.tempsrfkey === l.tempsrfkey && (p = "current-row");
    });
    const v = e.findRowState(l);
    return v != null && v.showRowEdit && (p += " editing-row"), l.srfkey && (p += " id-".concat(l.srfkey)), p;
  }
  function g({
    _row: l,
    column: p,
    _rowIndex: v,
    _columnIndex: D
  }) {
    var P;
    const b = (P = e.model.degridColumns) == null ? void 0 : P.find((N) => N.codeName === p.property);
    return b && b.headerSysCss && b.headerSysCss.cssName ? b.headerSysCss.cssName : "";
  }
  U(
    () => e.state.sortQuery,
    (l) => {
      if (l) {
        const p = e.state.sortQuery.split(",")[0], v = e.state.sortQuery.split(",")[1];
        if (p && v) {
          const D = v === "desc" ? "descending" : "ascending", b = () => {
            s.value ? Se(() => {
              s.value.sort(p, D);
            }) : setTimeout(b, 500);
          };
          b();
        }
      }
    }
  );
  const C = (l) => e.state.rows.find(
    (p) => l.data[e.treeGridParentField] && p.data[e.treeGridValueField] === l.data[e.treeGridParentField]
  ), G = (l) => {
    const { row: p, isReloadParent: v, eventName: D } = l;
    let b = v ? C(p) : p;
    if (b) {
      const P = s.value.store.states.treeData.value, N = s.value.store.states.lazyTreeNodeMap.value;
      if (P && P[b.data.tempsrfkey]) {
        P[b.data.tempsrfkey].loaded = !1;
        const O = i.value.find(
          (z) => b.data[e.treeGridValueField] === z[e.treeGridValueField]
        );
        O && !O._hasChildren && P[b.data.tempsrfkey].children.length > 0 && delete N[b.data.tempsrfkey];
      }
      s.value.store.loadOrToggle(b.data);
    }
  };
  return e.evt.on("onReloadNode", (l) => {
    setTimeout(() => {
      e.state.showTreeGrid && G(l);
    });
  }), {
    tableRef: s,
    getSelection: c,
    curSelectedData: t,
    onRowClick: r,
    onDbRowClick: n,
    isSelected: d,
    onSortChange: h,
    treeGirdItems: i,
    treeGirdData: o,
    handleRowClassName: m,
    handleHeaderCellClassName: g
  };
}
function Me(e, s) {
  const { controlParam: t } = s.modelData, i = () => {
    s.data && (e.state.items = s.data, e.state.rows = s.data.map((d) => new Y(new Ce(d), e)));
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
    let c = "cube-outline";
    if (t && t.ctrlParams && t.ctrlParams.GROUPICON && (c = t.ctrlParams.GROUPICON), e.model.enableGroup) {
      const h = [];
      return d.groups.forEach((m) => {
        if (!m.children.length)
          return;
        const g = [...m.children], C = Ae();
        h.push({
          tempsrfkey: C,
          srfkey: C,
          isGroupData: !0,
          caption: m.caption,
          _children: g,
          groupIcon: c
        });
      }), h;
    }
    return d.rows.map((h) => h.data);
  }), n = L(() => {
    if (e.isMultistageHeader)
      return e.model.degridColumns || [];
    const d = [];
    return e.state.columnStates.forEach((c) => {
      var m, g;
      if (c.hidden)
        return;
      const h = ((m = e.fieldColumns[c.key]) == null ? void 0 : m.model) || ((g = e.uaColumns[c.key]) == null ? void 0 : g.model);
      h && d.push(h);
    }), d;
  });
  return { tableData: r, renderColumns: n, defaultSort: o, summaryMethod: ({
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
function Be(e, s) {
  let t;
  const i = B(!1), o = B(), r = De({}), n = (m) => {
    if (!e.value)
      throw new _("找不到表格组件引用");
    const g = e.value.$el;
    let C = ".editing-row";
    m.data.srfkey && (C += ".id-".concat(m.data.srfkey));
    const G = g.querySelector(C);
    if (!G)
      throw new _("找不到对应的表格行dom元素");
    return G;
  }, u = async (m) => {
    const g = n(m);
    if (!t)
      throw new _("拿不到pop组件的实例");
    const C = t.$el, {
      x: G,
      y: l
    } = await Fe(g, C, {
      placement: "bottom"
    });
    Object.assign(r, {
      top: "".concat(l, "px"),
      left: "".concat(G, "px")
    }), o.value = m, i.value = !0;
  }, d = async () => {
    o.value && s.switchRowEdit(o.value, !1, !0);
  }, c = async () => {
    o.value && s.switchRowEdit(o.value, !1, !1);
  }, h = () => {
    const m = i.value && s.state.rows[s.state.rows.length - 1].showRowEdit;
    return [w("div", {
      class: "row-edit-popover__placeholder",
      style: {
        display: m ? "block" : "none"
      }
    }, null), w(S("iBizRowEditPopover"), {
      ref: (g) => {
        t = g;
      },
      style: r,
      show: i.value,
      onConfirm: d,
      onCancel: c
    }, null)];
  };
  return s.evt.on("onRowEditChange", (m) => {
    m.row.showRowEdit ? setTimeout(() => {
      u(m.row);
    }, 0) : (o.value = void 0, i.value = !1, Object.assign(r, {
      top: void 0,
      left: void 0
    }));
  }), {
    renderPopover: h
  };
}
class Ue extends be {
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
      const { context: n } = this.handlerAbilityParams(t), u = await this.getFetchParams(t == null ? void 0 : t.viewParam);
      u.hasOwnProperty("srfshowmode") || this.state.showTreeGrid && Object.assign(u, {
        srfshowmode: "tree"
      });
      const d = await this.service.fetch(n, u);
      typeof d.total == "number" && (this.state.total = d.total), r ? this.state.items.push(...d.data) : this.state.items = d.data, await this.afterLoad(t, d.data), this.state.isLoaded = !0, await this._evt.emit("onLoadSuccess", {
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
        (n) => this.state.items.find((u) => n.tempsrfkey === u.tempsrfkey)
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
    const i = t.srfuf === ye.CREATE, o = this.findRowState(t);
    if (!o)
      throw new _("行数据不存在");
    if (!o.modified) {
      ibiz.log.debug("值没有发生改变");
      return;
    }
    if (o.processing) {
      await Le(500, this.save.bind(this), [t]);
      return;
    }
    if (!await this.validate(o))
      throw new _("行数据校验不通过，保存取消");
    let n;
    const u = ve(this.model.appDataEntityId), d = this.context.clone();
    d[u] = t.srfkey;
    try {
      n = i ? await this.service.create(d, t) : await this.service.update(d, t);
    } catch (h) {
      throw await this._evt.emit("onSaveError", void 0), this.actionNotification("".concat(i ? "CREATE" : "UPDATE", "ERROR"), {
        error: h,
        data: o.data
      }), h;
    }
    const c = this.findRowStateIndex(t);
    this.state.items.splice(c, 1, n.data), o.data = n.data, o.modified = !1, i && this._evt.emit("onReloadNode", { row: o, isReloadParent: !0 }), this.gridStateNotify(o, J.SAVE), await this._evt.emit("onSaveSuccess", void 0);
  }
  afterRemove(t) {
    const i = this.state.items.findIndex(
      (n) => n.srfkey === t.srfkey
    );
    i !== -1 && this.state.items.splice(i, 1);
    const o = this.findRowStateIndex(t), r = this.state.rows[o];
    this.state.rows.splice(o, 1), this.state.groups.forEach((n) => {
      if (n.children.length) {
        const u = n.children.findIndex(
          (d) => d.srfkey === t.srfkey
        );
        u !== -1 && n.children.splice(u, 1);
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
      throw new _("请先完成当前行编辑中的行的操作");
    const n = { ...this.params }, u = this.calcDefaultValue(r || {}, !0);
    r.srfDefaultData && Object.assign(u, r.srfDefaultData), Object.assign(n, u);
    let d;
    try {
      d = await this.service.getDraft(this.context, n);
    } catch (m) {
      throw this.actionNotification("GETDRAFTERROR", {
        error: m
      }), m;
    }
    const c = d.data;
    ke(c, u), r && (c[this.treeGridParentField] = r[this.treeGridValueField]), this.state.items.push(c);
    const h = new Y(c, this);
    this.state.rows.push(h), this.gridStateNotify(h, J.DRAFT), o === "row" && this.switchRowEdit(h, !0), this._evt.emit("onReloadNode", { row: h, isReloadParent: !0 }), this.actionNotification("GETDRAFTSUCCESS", { data: c });
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
        (n) => n.data.tempsrfkey === (o == null ? void 0 : o.data.tempsrfkey)
      );
      i && r === -1 ? this.state.expandRows.push(o) : !i && r > -1 && this.state.expandRows.splice(r, 1);
    }
  }
}
class Ve extends Ee {
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
    const { curPage: i, size: o, sortQuery: r, noSort: n } = this.state, u = {
      ...this.params
    };
    if (o && (u.page = i - 1, u.size = o), !n)
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
      const n = /* @__PURE__ */ new Map(), u = o === "CODELIST", d = r.toLowerCase();
      u && this.codeListItems.forEach((c) => {
        n.set(c.value, []);
      }), t.forEach((c) => {
        const h = c[d];
        !u && !n.has(h) && n.set(h, []), n.has(h) && n.get(h).push(c);
      }), this.state.groups = [], n.forEach((c, h) => {
        var g;
        const m = (g = this.codeListItems) == null ? void 0 : g.find(
          (C) => C.value === h
        );
        this.state.groups.push({
          caption: (m == null ? void 0 : m.text) || "".concat(h || "其他"),
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
        (n) => this.state.items.find((u) => n.tempsrfkey === u.tempsrfkey)
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
function je(e, s, t, i) {
  var g;
  const {
    codeName: o,
    width: r
  } = s, n = e.columns[o], u = e.state.columnStates.find((C) => C.key === o), d = t.find((C) => e.columns[C.codeName].isAdaptiveColumn), h = n.isAdaptiveColumn || !d && i === t.length - 1 ? "min-width" : "width";
  let m = "default";
  return e != null && e.expandColumnIndex && i < Ie(e == null ? void 0 : e.expandColumnIndex) && (m = "index"), w(S("el-table-column"), Z({
    label: s.caption,
    prop: o
  }, {
    [h]: r
  }, {
    fixed: u.fixed,
    sortable: s.enableSort ? "custom" : !1,
    align: ((g = s.align) == null ? void 0 : g.toLowerCase()) || "center",
    type: m
  }), {
    default: ({
      row: C
    }) => {
      const G = C;
      if (C.isGroupData)
        return i !== 0 ? null : w("div", {
          class: "group-column"
        }, [w(S("ion-icon"), {
          class: "group-icon",
          name: C.groupIcon
        }, null), C.caption]);
      const l = e.findRowState(G);
      if (l) {
        const p = S(e.providers[o].component);
        return Ne(p, {
          controller: n,
          row: l,
          key: G.tempsrfkey + o
        });
      }
      return null;
    }
  });
}
function ee(e, s, t, i) {
  var o, r;
  if (s.columnType === "GROUPGRIDCOLUMN") {
    const n = ((o = s.degridColumns) == null ? void 0 : o.filter((c) => !c.hideDefault)) || [], {
      width: u
    } = s, d = ((r = s.align) == null ? void 0 : r.toLowerCase()) || "center";
    return w(S("el-table-column"), {
      prop: s.codeName,
      label: s.caption,
      "min-width": u,
      align: d
    }, {
      default: () => n.map((c, h) => ee(e, c, t, h))
    });
  }
  return je(e, s, t, i);
}
const Q = /* @__PURE__ */ xe({
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
      e.modelData.controlType === "TREEGRID" ? s = W((...a) => new Ue(...a)) : s = W((...a) => new Ve(...a));
    })();
    const {
      zIndex: i
    } = we();
    s.state.zIndex = i.increment();
    const o = j("control-grid"), r = L(() => {
      if (e.modelData.controlType === "TREEGRID")
        return j("control-".concat(s.model.controlType.toLowerCase()));
    }), n = j("number-grid"), {
      tableRef: u,
      onRowClick: d,
      onDbRowClick: c,
      onSortChange: h,
      isSelected: m,
      curSelectedData: g,
      getSelection: C,
      handleRowClassName: G,
      treeGirdItems: l,
      treeGirdData: p,
      handleHeaderCellClassName: v
    } = ze(s), {
      onPageChange: D,
      onPageRefresh: b,
      onPageSizeChange: P
    } = $e(s), N = L(() => e.modelData.controlType === "TREEGRID" ? s.state.showTreeGrid : !1), O = async (a, f, E) => {
      const y = l.value.filter((R) => a[s.treeGridValueField] === R[s.treeGridParentField]);
      E(y);
    };
    let z = [];
    const te = () => {
      const a = [];
      return u.value && u.value.$el.getElementsByClassName("el-table__row").forEach((y) => {
        y.style.display !== "none" && a.push(y);
      }), a;
    }, X = (a = 0) => {
      setTimeout(() => {
        const f = te();
        f.length !== z.length && (z = f, f.forEach((E, y) => {
          const R = E.firstChild;
          if (R.className.includes("ibiz-number-grid__first-column")) {
            const F = R.getElementsByClassName("ibiz-number-grid__number--caption")[0];
            F && (F.innerText = "".concat((s.state.curPage - 1) * s.state.size + (y + 1)));
          }
        }));
      }, a);
    }, se = (a, f) => {
      X(), s.setRowExpand(a, f);
    };
    Ge(() => {
      const {
        controlType: a,
        enableGroup: f
      } = s.model;
      a === "GRID" && f && X(1e3);
    }), U(() => N.value, (a, f) => {
      a !== f && (g.value = [], s.setSelection([]));
    });
    const oe = () => {
      const a = [...p.value], f = (E) => {
        const y = l.value.filter((R) => R[s.treeGridParentField] && E[s.treeGridValueField] === R[s.treeGridParentField]);
        y.length > 0 && (a.push(...y), y.forEach((R) => {
          f(R);
        }));
      };
      return p.value.forEach((E) => {
        f(E);
      }), a;
    }, q = () => {
      let a = [];
      return N.value ? a = oe() : (a = [...A.value], s.model.enableGroup && A.value.forEach((f) => {
        a.push(...f._children);
      })), a;
    }, V = () => {
      const a = q();
      let f = !1;
      return a.length > 0 && (f = a.filter((y) => !m(y)).length === 0), f;
    }, ie = () => {
      const a = q(), f = g.value.filter((E) => !a.find((y) => y.tempsrfkey === E.tempsrfkey));
      V() || f.push(...a), g.value = f, s.setSelection(C());
    }, ae = (a) => {
      re(g.value, a), s.setSelection(C());
    }, ne = (a) => {
      a.stopPropagation();
    }, re = (a, f) => {
      const {
        controlType: E,
        enableGroup: y
      } = s.model, R = a.findIndex((x) => x.tempsrfkey === f.tempsrfkey);
      R !== -1 ? (a.splice(R, 1), E === "GRID" && y && (K(f._children) ? f._children.forEach((x) => {
        const I = a.indexOf(x);
        I !== -1 && a.splice(I, 1);
      }) : A.value.forEach((x) => {
        const I = x._children.find((T) => !a.includes(T)), M = a.findIndex((T) => T.tempsrfkey === x.tempsrfkey);
        I && M !== -1 && a.splice(M, 1);
      }))) : (a.push(f), E === "GRID" && y && (K(f._children) ? f._children.forEach((x) => {
        a.indexOf(x) === -1 && a.push(x);
      }) : A.value.forEach((x) => {
        const I = x._children.find((T) => !a.includes(T)), M = a.findIndex((T) => T.tempsrfkey === x.tempsrfkey);
        !I && M === -1 && a.unshift(x);
      })));
    }, le = () => {
      var f;
      const {
        isLoaded: a
      } = s.state;
      if (a) {
        const E = (f = s.model.controls) == null ? void 0 : f.find((y) => y.name === "".concat(s.model.name, "_quicktoolbar"));
        return E ? w(S("iBizToolbarControl"), {
          modelData: E,
          context: s.context,
          params: s.params,
          class: o.b("quick-toolbar")
        }, null) : w(S("iBizNoData"), {
          text: s.model.emptyText,
          emptyTextLanguageRes: s.model.emptyTextLanguageRes
        }, null);
      }
      return null;
    }, {
      tableData: A,
      renderColumns: H,
      defaultSort: de,
      summaryMethod: ce
    } = Me(s, e), {
      renderPopover: ue
    } = Be(u, s), he = () => {
      var f;
      const a = (f = s.model.controls) == null ? void 0 : f.find((E) => E.name === "".concat(s.model.name, "_batchtoolbar"));
      if (!(!a || s.state.singleSelect))
        return w("div", {
          class: [o.b("batch-toolbar"), n.b("batch-toolbar"), o.is("show", s.state.selectedData.length > 0)]
        }, [w("div", {
          class: o.b("batch-toolbar-content")
        }, [w("div", {
          class: o.b("batch-toolbar-text")
        }, [$("已选中"), s.state.selectedData.length, $("项")]), w("div", {
          class: o.b("batch-toolbar-separator")
        }, [$("|")]), w(S("iBizToolbarControl"), {
          modelData: a,
          context: s.context,
          params: s.params,
          class: o.b("batch-toolbar-items")
        }, null)])]);
    }, fe = () => {
      const a = H.value.length ? "width" : "min-width";
      return w(S("el-table-column"), Z({
        "class-name": n.e("first-column")
      }, {
        [a]: 80
      }, {
        align: "center",
        fixed: "left",
        type: "index"
      }), {
        header: () => w("div", {
          class: n.e("number")
        }, [s.state.singleSelect ? w("span", null, [$("序号")]) : w(S("el-checkbox"), {
          size: "large",
          indeterminate: s.state.selectedData.length > 0 && !V(),
          modelValue: V(),
          onChange: () => ie()
        }, null)]),
        default: ({
          row: f,
          column: E,
          $index: y
        }) => {
          const R = (s.state.curPage - 1) * s.state.size + (y + 1);
          return s.state.singleSelect ? w("div", {
            class: n.e("number")
          }, [w("span", null, [R])]) : w("div", {
            class: n.e("number"),
            onClick: (F) => ne(F)
          }, [w("span", {
            class: n.em("number", "caption")
          }, [R]), w(S("el-checkbox"), {
            size: "large",
            class: n.em("number", "checkbox"),
            modelValue: m(f),
            onChange: () => ae(f)
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
      ns3: n,
      tableRef: u,
      tableData: A,
      treeGirdData: p,
      loadData: O,
      showTreeGrid: N,
      renderColumns: H,
      onDbRowClick: c,
      onRowClick: d,
      onExpandChange: se,
      onSortChange: h,
      onPageChange: D,
      onPageSizeChange: P,
      onPageRefresh: b,
      handleRowClassName: G,
      handleHeaderCellClassName: v,
      renderNoData: le,
      summaryMethod: ce,
      renderPopover: ue,
      defaultSort: de,
      renderBatchToolBar: he,
      renderFirstColumn: fe
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
    return w(S("iBizControlBase"), {
      class: [this.ns.b(), (i = this.ns2) == null ? void 0 : i.b(), this.ns3.b(), this.ns.is("show-header", !s), this.ns.is("enable-page", t), this.ns.is("enable-group", this.c.model.enableGroup), this.ns.is("single-select", e.singleSelect), this.ns.is("enable-customized", this.c.model.enableCustomized)],
      controller: this.c
    }, {
      default: () => [w(S("el-table"), {
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
        default: () => [this.renderFirstColumn(), this.renderColumns.map((o, r) => ee(this.c, o, this.renderColumns, r))],
        append: () => this.renderPopover()
      }), t && w(S("iBizPagination"), {
        total: e.total,
        curPage: e.curPage,
        size: e.size,
        onChange: this.onPageChange,
        onPageSizeChange: this.onPageSizeChange,
        onPageRefresh: this.onPageRefresh
      }, null), this.c.model.enableCustomized && !s && w("div", {
        class: [this.ns.b("setting-box"), this.ns3.b("setting-box")]
      }, [w(S("iBizGridSetting"), {
        columnStates: e.columnStates,
        controller: this.c
      }, null)]), this.renderBatchToolBar()]
    });
  }
}), Qe = ge(
  Q,
  (e) => {
    e.component(Q.name, Q), Re(
      "GRID_RENDER_NUMBER_GRID",
      () => new Oe()
    );
  }
), et = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(e) {
    e.use(Qe);
  }
};
export {
  Qe as IBizNumberGridControl,
  et as default
};
