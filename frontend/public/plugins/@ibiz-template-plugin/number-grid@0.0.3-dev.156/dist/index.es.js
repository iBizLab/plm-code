import './style.css';
var pe = Object.defineProperty;
var we = (t, i, e) => i in t ? pe(t, i, { enumerable: !0, configurable: !0, writable: !0, value: e }) : t[i] = e;
var L = (t, i, e) => (we(t, typeof i != "symbol" ? i + "" : i, e), e);
import { useUIStore as ge, useNamespace as Q, useControlController as K, withInstall as ye } from "@ibiz-template/vue3-util";
import { Srfuf as X, GridRowState as Z, ControlVO as Ce, TreeGridController as be, calcDeCodeNameById as ve, GridNotifyState as W, GridController as Ee, ScriptFactory as Se, registerControlProvider as Re } from "@ibiz-template/runtime";
import { ref as B, computed as k, watch as U, nextTick as De, reactive as Pe, createVNode as w, resolveComponent as D, defineComponent as Ne, onMounted as Ge, onUnmounted as xe, createTextVNode as z, mergeProps as ee, h as Ie } from "vue";
import { toNumber as Te, isArray as Y } from "lodash-es";
import { isElementSame as ke, RuntimeError as F, awaitTimeout as Le, mergeDefaultInLeft as Fe, RuntimeModelError as Ae } from "@ibiz-template/core";
import { createUUID as Oe } from "qx-util";
import { computePosition as _e } from "@floating-ui/dom";
import { isNil as Me } from "ramda";
class $e {
  constructor() {
    L(this, "component", "IBizNumberGridControl");
  }
}
function ze(t) {
  const i = B(), e = B([]), o = k(() => t.state.rows.map((d) => r(d.data))), s = k(() => {
    const d = [], p = [];
    return o.value.forEach((y) => {
      const S = y[t.treeGridValueField];
      S && p.push(S);
    }), o.value.forEach((y) => {
      p.includes(y[t.treeGridParentField]) || d.push(y);
    }), d;
  });
  async function a(d, p, y) {
    if (!(t.model.enableGroup && d.isGroupData) && d.srfuf !== X.CREATE)
      if (ibiz.config.grid.editShowMode === "row" && t.model.enableRowEdit) {
        const S = t.findRowState(d);
        S && S.showRowEdit !== !0 && await t.switchRowEdit(S, !0);
      } else
        t.onRowClick(d);
  }
  function n(d) {
    t.model.enableGroup && d.isGroupData || d.srfuf !== X.CREATE && t.onDbRowClick(d);
  }
  function r(d) {
    return d._hasChildren = t.state.items.some(
      (p) => d[t.treeGridValueField] && d[t.treeGridValueField] === p[t.treeGridParentField]
    ), d._children = [], d;
  }
  function c(d) {
    return !!e.value.find(
      (p) => d.tempsrfkey === p.tempsrfkey
    );
  }
  function u() {
    return t.model.enableGroup ? e.value.filter((d) => !d.isGroupData) : e.value;
  }
  U(
    [
      () => i.value,
      () => t.state.isLoaded,
      () => t.state.selectedData
    ],
    ([d, p, y]) => {
      !p || !d || (ke(y, u()) || (e.value = y), t.state.singleSelect && (y[0] ? i.value.setCurrentRow(y[0], !0) : i.value.setCurrentRow()));
    }
  );
  function h(d) {
    const { prop: p, order: y } = d, S = t.fieldColumns[p].model.appDEFieldId;
    let b;
    y === "ascending" ? b = "asc" : y === "descending" && (b = "desc"), "".concat(S, ",").concat(b) !== t.state.sortQuery && (t.setSort(S, b), t.load());
  }
  function f({ row: d }) {
    let p = "";
    e.value.length > 0 && e.value.forEach((S) => {
      S.tempsrfkey === d.tempsrfkey && (p = "current-row");
    });
    const y = t.findRowState(d);
    return y != null && y.showRowEdit && (p += " editing-row"), d.srfkey && (p += " id-".concat(d.srfkey)), p;
  }
  function g({
    _row: d,
    column: p,
    _rowIndex: y,
    _columnIndex: S
  }) {
    var G;
    const b = (G = t.model.degridColumns) == null ? void 0 : G.find((x) => x.codeName === p.property);
    return b && b.headerSysCss && b.headerSysCss.cssName ? b.headerSysCss.cssName : "";
  }
  U(
    () => t.state.sortQuery,
    (d) => {
      if (d) {
        const p = t.state.sortQuery.split(",")[0], y = t.state.sortQuery.split(",")[1];
        if (p && y) {
          const S = y === "desc" ? "descending" : "ascending", b = () => {
            i.value ? De(() => {
              i.value.sort(p, S);
            }) : setTimeout(b, 500);
          };
          b();
        }
      }
    }
  );
  const C = (d) => t.state.rows.find(
    (p) => d.data[t.treeGridParentField] && p.data[t.treeGridValueField] === d.data[t.treeGridParentField]
  ), N = (d) => {
    const { row: p, isReloadParent: y, eventName: S } = d;
    let b = y ? C(p) : p;
    if (b) {
      const G = i.value.store.states.treeData.value, x = i.value.store.states.lazyTreeNodeMap.value;
      if (G && G[b.data.tempsrfkey]) {
        G[b.data.tempsrfkey].loaded = !1;
        const _ = o.value.find(
          (M) => b.data[t.treeGridValueField] === M[t.treeGridValueField]
        );
        _ && !_._hasChildren && G[b.data.tempsrfkey].children.length > 0 && delete x[b.data.tempsrfkey];
      }
      i.value.store.loadOrToggle(b.data);
    }
  };
  return t.evt.on("onReloadNode", (d) => {
    setTimeout(() => {
      t.state.showTreeGrid && N(d);
    });
  }), {
    tableRef: i,
    getSelection: u,
    curSelectedData: e,
    onRowClick: a,
    onDbRowClick: n,
    isSelected: c,
    onSortChange: h,
    treeGirdItems: o,
    treeGirdData: s,
    handleRowClassName: f,
    handleHeaderCellClassName: g
  };
}
function Be(t, i) {
  const { controlParam: e } = i.modelData, o = () => {
    i.data && (t.state.items = i.data, t.state.rows = i.data.map((c) => new Z(new Ce(c), t)));
  }, s = k(() => {
    var u;
    const c = Object.values(t.fieldColumns).find(
      (h) => h.model.appDEFieldId === t.model.minorSortAppDEFieldId
    );
    return {
      prop: c == null ? void 0 : c.model.codeName,
      order: ((u = t.model.minorSortDir) == null ? void 0 : u.toLowerCase()) === "desc" ? "descending" : "ascending"
    };
  });
  t.evt.on("onCreated", async () => {
    i.isSimple && (o(), t.state.isLoaded = !0);
  }), U(
    () => i.data,
    () => {
      i.isSimple && o();
    },
    {
      deep: !0
    }
  );
  const a = k(() => {
    const { state: c } = t;
    let u = {
      appId: t.context.srfappid,
      cssClass: "cube-outline"
    };
    if (e && e.ctrlParams && e.ctrlParams.GROUPICON && (u.cssClass = e.ctrlParams.GROUPICON), t.model.enableGroup) {
      const h = [];
      return c.groups.forEach((f) => {
        if (!f.children.length)
          return;
        f.groupIcon && (u = f.groupIcon);
        const g = [...f.children], C = Oe();
        h.push({
          tempsrfkey: C,
          srfkey: C,
          isGroupData: !0,
          caption: f.caption,
          _children: g,
          groupIcon: u
        });
      }), h;
    }
    return c.rows.map((h) => h.data);
  }), n = k(() => {
    if (t.isMultistageHeader)
      return t.model.degridColumns || [];
    const c = [];
    return t.state.columnStates.forEach((u) => {
      var f, g;
      if (u.hidden)
        return;
      const h = ((f = t.fieldColumns[u.key]) == null ? void 0 : f.model) || ((g = t.uaColumns[u.key]) == null ? void 0 : g.model);
      h && c.push(h);
    }), c;
  });
  return { tableData: a, renderColumns: n, defaultSort: s, summaryMethod: ({
    columns: c
  }) => c.map((u, h) => h === 0 ? t.aggTitle : t.state.aggResult[u.property]) };
}
function Ue(t) {
  function i(s) {
    !s || s === t.state.curPage || (t.state.curPage = s, t.load());
  }
  function e(s) {
    !s || s === t.state.size || (t.state.size = s, t.state.curPage === 1 && t.load());
  }
  function o() {
    t.load();
  }
  return { onPageChange: i, onPageSizeChange: e, onPageRefresh: o };
}
function Ve(t, i) {
  let e;
  const o = B(!1), s = B(), a = Pe({}), n = (f) => {
    if (!t.value)
      throw new F("找不到表格组件引用");
    const g = t.value.$el;
    let C = ".editing-row";
    f.data.srfkey && (C += ".id-".concat(f.data.srfkey));
    const N = g.querySelector(C);
    if (!N)
      throw new F("找不到对应的表格行dom元素");
    return N;
  }, r = async (f) => {
    const g = n(f);
    if (!e)
      throw new F("拿不到pop组件的实例");
    const C = e.$el, {
      x: N,
      y: d
    } = await _e(g, C, {
      placement: "bottom"
    });
    Object.assign(a, {
      top: "".concat(d, "px"),
      left: "".concat(N, "px")
    }), s.value = f, o.value = !0;
  }, c = async () => {
    s.value && i.switchRowEdit(s.value, !1, !0);
  }, u = async () => {
    s.value && i.switchRowEdit(s.value, !1, !1);
  }, h = () => {
    const f = o.value && i.state.rows[i.state.rows.length - 1].showRowEdit;
    return [w("div", {
      class: "row-edit-popover__placeholder",
      style: {
        display: f ? "block" : "none"
      }
    }, null), w(D("iBizRowEditPopover"), {
      ref: (g) => {
        e = g;
      },
      style: a,
      show: o.value,
      onConfirm: c,
      onCancel: u
    }, null)];
  };
  return i.evt.on("onRowEditChange", (f) => {
    f.row.showRowEdit ? setTimeout(() => {
      r(f.row);
    }, 0) : (s.value = void 0, o.value = !1, Object.assign(a, {
      top: void 0,
      left: void 0
    }));
  }), {
    renderPopover: h
  };
}
class Qe extends be {
  constructor() {
    super(...arguments);
    /**
     * 是否默认展开所有
     *
     * @type {boolean}
     * @memberof NumberTreeGridController
     */
    L(this, "defaultExpandAll", !1);
    /**
     * 指定展开列下标
     *
     * @type {boolean}
     * @memberof NumberGridController
     */
    L(this, "expandColumnIndex");
  }
  get overflowMode() {
    return "ellipsis";
  }
  initState() {
    super.initState();
    const e = "SHOW_MODE_".concat(this.context.project, "_").concat(this.view.model.codeName), o = localStorage.getItem(e);
    o === "tree" ? this.state.showTreeGrid = !0 : o === "grid" && (this.state.showTreeGrid = !1);
  }
  /**
   * 设置排序
   */
  setSort(e, o) {
    if (!e && !o)
      return;
    let s;
    e && (s = this.fieldIdNameMap.get(e).toLowerCase()), s && o ? this.state.sortQuery = "".concat(s, ",").concat(o) : this.state.sortQuery = "", this.setSortCache();
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
  async getFetchParams(e) {
    const { curPage: o, size: s, sortQuery: a, noSort: n } = this.state, r = {
      ...this.params
    };
    if (s && (r.page = o - 1, r.size = s), !n)
      if (a)
        r.sort = a;
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
        r.sort = this.state.sortQuery, this.setSortCache();
      }
    return await this._evt.emit("onBeforeLoad", void 0), Object.assign(r, {
      ...this.state.searchParams
    }), e && Object.assign(r, e), r;
  }
  /**
   * 切换显示模式
   *
   * @param {IData} param
   * @memberof NumberTreeGridController
   */
  switchShowMode(e) {
    const { showMode: o } = e;
    o && (o === "tree" ? this.state.showTreeGrid = !0 : o === "grid" && (this.state.showTreeGrid = !1), this.refresh());
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
    const { ctrlParams: e = {} } = this.model.controlParam;
    e.DEFAULTEXPANDALL && (this.defaultExpandAll = Object.is(e.DEFAULTEXPANDALL, "TRUE") || Object.is(e.DEFAULTEXPANDALL, "true")), e.GRIDROWACTIVEMODE && (this.state.mdctrlActiveMode = JSON.parse(e.GRIDROWACTIVEMODE)), e.EXPANDCOLUMNINDEX && (this.expandColumnIndex = e.EXPANDCOLUMNINDEX);
  }
  /**
   * 刷新
   *
   * @return {*}  {Promise<void>}
   * @memberof NumberTreeGridController
   */
  async refresh(e = !1) {
    await this.load({ isInitialLoad: e }), this.state.expandRows.forEach((o) => {
      setTimeout(() => {
        this.evt.emit("onReloadNode", { row: o, isReloadParent: !1 });
      });
    });
  }
  /**
   * 刷新父节点
   *
   * @return {*}  {Promise<void>}
   * @memberof NumberTreeGridController
   */
  async refreshParentNode(e, o = !1) {
    const s = this.state.items.find((r) => r.srfkey === e.srfkey);
    let a;
    s && (a = this.state.items.find(
      (r) => s[this.treeGridParentField] && r[this.treeGridValueField] === s[this.treeGridParentField]
    )), await this.load({ isInitialLoad: o });
    const n = this.findRowState(e);
    if (n) {
      if (a && n.data[this.treeGridParentField] !== a[this.treeGridValueField]) {
        const r = this.findRowState(a);
        r && this.evt.emit("onReloadNode", {
          row: r,
          isReloadParent: !1
        });
      }
      this.evt.emit("onReloadNode", {
        row: n,
        isReloadParent: !0
      });
    }
  }
  /**
   * 部件加载数据行为
   *
   * @param {MDCtrlLoadParams} [args={}]
   * @return {*}  {Promise<IData[]>}
   * @memberof NumberTreeGridController
   */
  async load(e = {}) {
    if (this.state.isSimple)
      return [];
    const o = e.silent === !0;
    o || await this.startLoading();
    try {
      const s = e.isInitialLoad === !0, a = e.isLoadMore === !0;
      s ? this.state.curPage = 1 : a && (this.state.curPage += 1);
      const { context: n } = this.handlerAbilityParams(e), r = await this.getFetchParams(e == null ? void 0 : e.viewParam);
      r != null && r.hasOwnProperty("srfshowmode") || this.state.showTreeGrid && Object.assign(r, {
        srfshowmode: "tree"
      });
      const c = await this.service.fetch(n, r);
      typeof c.total == "number" && (this.state.total = c.total), typeof c.totalPages == "number" && (this.state.totalPages = c.totalPages), a ? this.state.items.push(...c.data) : this.state.items = c.data, await this.afterLoad(e, c.data), this.state.isLoaded = !0, await this._evt.emit("onLoadSuccess", {
        isInitialLoad: s
      });
    } catch (s) {
      throw await this._evt.emit("onLoadError", void 0), this.actionNotification("FETCHERROR", {
        error: s
      }), s;
    } finally {
      o || await this.endLoading();
    }
    return this.state.items.forEach((s, a) => {
      s.srfserialnum = a + 1;
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
  async afterLoad(e, o) {
    if (await super.afterLoad(e, o), e.isInitialLoad === !0)
      this.state.selectedData = [], this.state.expandRows = [];
    else {
      const a = this.state.selectedData.filter(
        (n) => this.state.items.find((r) => n.tempsrfkey === r.tempsrfkey)
      );
      this.state.selectedData = a;
    }
    return o;
  }
  /**
   * 保存
   *
   * @param {ControlVO} data
   * @return {*}  {Promise<void>}
   * @memberof NumberTreeGridController
   */
  async save(e) {
    if (this.state.isSimple)
      return;
    const o = e.srfuf === X.CREATE, s = this.findRowState(e);
    if (!s)
      throw new F("行数据不存在");
    if (!s.modified) {
      ibiz.log.debug("值没有发生改变");
      return;
    }
    if (s.processing) {
      await Le(500, this.save.bind(this), [e]);
      return;
    }
    if (!await this.validate(s))
      throw new F("行数据校验不通过，保存取消");
    let n;
    const r = ve(this.model.appDataEntityId), c = this.context.clone();
    c[r] = e.srfkey;
    try {
      n = o ? await this.service.create(c, e) : await this.service.update(c, e);
    } catch (h) {
      throw o && await this.remove({ data: [e], silent: !0 }), await this._evt.emit("onSaveError", void 0), this.actionNotification("".concat(o ? "CREATE" : "UPDATE", "ERROR"), {
        error: h,
        data: s.data
      }), h;
    }
    const u = this.findRowStateIndex(e);
    this.state.items.splice(u, 1, n.data), s.data = n.data, s.modified = !1, o && this.evt.emit("onReloadNode", { row: s, isReloadParent: !0 }), this.gridStateNotify(s, W.SAVE), await this.evt.emit("onSaveSuccess", void 0);
  }
  afterRemove(e) {
    const o = this.state.items.findIndex(
      (n) => n.srfkey === e.srfkey
    );
    o !== -1 && this.state.items.splice(o, 1);
    const s = this.findRowStateIndex(e), a = this.state.rows[s];
    this.state.rows.splice(s, 1), this.state.groups.forEach((n) => {
      if (n.children.length) {
        const r = n.children.findIndex(
          (c) => c.srfkey === e.srfkey
        );
        r !== -1 && n.children.splice(r, 1);
      }
    }), this.evt.emit("onReloadNode", {
      row: a,
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
  async newRow(e = {}) {
    const { data: o } = e, { editShowMode: s } = ibiz.config.grid;
    let a = {};
    if (o && (a = Array.isArray(o) ? o[0] : o), s === "row" && this.state.rows.find((g) => g.showRowEdit))
      throw new F("请先完成当前行编辑中的行的操作");
    const n = { ...this.params }, r = this.calcDefaultValue(a || {}, !0);
    a.srfDefaultData && Object.assign(r, a.srfDefaultData), Object.assign(n, r);
    let c;
    try {
      c = await this.service.getDraft(this.context, n);
    } catch (f) {
      throw this.actionNotification("GETDRAFTERROR", {
        error: f
      }), f;
    }
    const u = c.data;
    Fe(u, r), u[this.treeGridParentField] = a[this.treeGridValueField], a.srfUserData && (u.srfUserData = a.srfUserData), this.state.items.push(u);
    const h = new Z(u, this);
    this.state.rows.push(h), this.gridStateNotify(h, W.DRAFT), s === "row" && this.switchRowEdit(h, !0), this.evt.emit("onReloadNode", { row: h, isReloadParent: !0 }), this.actionNotification("GETDRAFTSUCCESS", { data: u });
  }
  /**
   * 行单击事件
   *
   * @param {IData} data
   * @return {*}  {Promise<void>}
   * @memberof NumberTreeGridController
   */
  async onRowClick(e) {
    this.state.singleSelect && this.setSelection([e]), this.state.mdctrlActiveMode === 1 && await this.setActive(e);
  }
  /**
   * 设置行展开
   *
   * @param {IData} data
   * @param {boolean} state
   * @memberof NumberTreeGridController
   */
  setRowExpand(e, o) {
    const s = this.findRowState(e);
    if (s) {
      const a = this.state.expandRows.findIndex(
        (n) => n.data.tempsrfkey === (s == null ? void 0 : s.data.tempsrfkey)
      );
      o && a === -1 ? this.state.expandRows.push(s) : !o && a > -1 && this.state.expandRows.splice(a, 1);
    }
  }
  /**
   * 检测实体数据变更
   *
   * @author ljx
   * @date 2024-05-10 17:03:30
   * @protected
   * @param {IPortalMessage} msg
   * @return {*}  {void}
   */
  onDEDataChange(e) {
    if (!Me(e.triggerKey) && e.triggerKey === this.triggerKey)
      return;
    const o = e.data;
    if (!o || o.srfdecodename !== this.dataEntity.codeName)
      return;
    let s = !1;
    switch (e.subtype) {
      case "OBJECTCREATED":
        (!o[this.treeGridParentField] || this.state.items.findIndex(
          (a) => a[this.treeGridValueField] === o[this.treeGridParentField]
        ) !== -1) && (s = !0);
        break;
      case "OBJECTUPDATED":
      case "OBJECTREMOVED":
        this.state.items.findIndex((a) => a.srfkey === o.srfkey) !== -1 && (s = !0);
        break;
    }
    s && this.doNextActive(() => this.refreshParentNode(o, !!ibiz.env.isMob), {
      key: "refresh"
    });
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
    L(this, "codeListItems");
    /**
     * 是否默认展开所有
     *
     * @type {boolean}
     * @memberof NumberGridController
     */
    L(this, "defaultExpandAll", !1);
  }
  /**
   * 初始化方法
   *
   * @memberof NumberGridController
   */
  async onCreated() {
    await super.onCreated();
    const { ctrlParams: e = {} } = this.model.controlParam;
    e.DEFAULTEXPANDALL && (this.defaultExpandAll = Object.is(e.DEFAULTEXPANDALL, "TRUE") || Object.is(e.DEFAULTEXPANDALL, "true"));
  }
  /**
   * 设置排序
   */
  setSort(e, o) {
    if (!e && !o)
      return;
    let s;
    e && (s = this.fieldIdNameMap.get(e).toLowerCase()), s && o ? this.state.sortQuery = "".concat(s, ",").concat(o) : this.state.sortQuery = "", this.setSortCache();
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
  async getFetchParams(e) {
    const { curPage: o, size: s, sortQuery: a, noSort: n } = this.state, r = {
      ...this.params
    };
    if (s && (r.page = o - 1, r.size = s), !n)
      if (a)
        r.sort = a;
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
        r.sort = this.state.sortQuery, this.setSortCache();
      }
    return await this._evt.emit("onBeforeLoad", void 0), Object.assign(r, {
      ...this.state.searchParams
    }), e && Object.assign(r, e), r;
  }
  /**
   * 初始化表格分组
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof NumberGridController
   */
  async initGroup() {
    const { groupCodeListId: e, groupMode: o, enableGroup: s } = this.model;
    if (s && o === "CODELIST") {
      if (!e)
        throw new Ae(
          this.model,
          "代码表分组模式需要配置代码表"
        );
      const a = ibiz.hub.getApp(this.context.srfappid);
      this.codeListItems = await a.codeList.get(
        e,
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
  calcGroupData(e) {
    const { enableGroup: o, groupMode: s, groupAppDEFieldId: a } = this.model;
    if (o && a) {
      const n = /* @__PURE__ */ new Map(), r = s === "CODELIST", c = a.toLowerCase();
      r && this.codeListItems.forEach((u) => {
        n.set(u.value, []);
      }), e.forEach((u) => {
        const h = u[c];
        !r && !n.has(h) && n.set(h, []), n.has(h) && n.get(h).push(u);
      }), this.state.groups = [], n.forEach((u, h) => {
        var g;
        const f = (g = this.codeListItems) == null ? void 0 : g.find(
          (C) => C.value === h
        );
        this.state.groups.push({
          caption: (f == null ? void 0 : f.text) || "".concat(h || "其他"),
          groupIcon: f == null ? void 0 : f.sysImage,
          key: h,
          children: u
        });
      });
    }
  }
  async afterLoad(e, o) {
    if (await super.afterLoad(e, o), e.isInitialLoad === !0)
      this.state.selectedData = [];
    else {
      const a = this.state.selectedData.filter(
        (n) => this.state.items.find((r) => n.tempsrfkey === r.tempsrfkey)
      );
      this.state.selectedData = a;
    }
    return o;
  }
  /**
   * 表格行单击
   *
   * @param {IData} data
   * @return {*}  {Promise<void>}
   * @memberof NumberGridController
   */
  async onRowClick(e) {
    this.state.singleSelect && this.setSelection([e]), this.state.mdctrlActiveMode === 1 && await this.setActive(e);
  }
}
function Xe(t, i) {
  var o;
  const e = {};
  return (o = t.controlAttributes) == null || o.forEach((s) => {
    s.attrName && s.attrValue && (e[s.attrName] = Se.execSingleLine(s.attrValue, {
      ...i
    }));
  }), e;
}
function qe(t, i, e, o) {
  var g;
  const {
    codeName: s,
    width: a
  } = i, n = t.columns[s], r = t.state.columnStates.find((C) => C.key === s), c = e.find((C) => t.columns[C.codeName].isAdaptiveColumn), h = n.isAdaptiveColumn || !c && o === e.length - 1 ? "min-width" : "width";
  let f = "default";
  return t != null && t.expandColumnIndex && o < Te(t == null ? void 0 : t.expandColumnIndex) && (f = ""), w(D("el-table-column"), ee({
    label: i.caption,
    prop: s
  }, {
    [h]: a
  }, {
    fixed: r.fixed,
    sortable: i.enableSort ? "custom" : !1,
    align: ((g = i.align) == null ? void 0 : g.toLowerCase()) || "center",
    type: f
  }), {
    default: ({
      row: C
    }) => {
      const N = C;
      if (C.isGroupData)
        return o !== 0 ? null : w("div", {
          class: "group-column"
        }, [w(D("iBizIcon"), {
          class: "group-icon",
          icon: C.groupIcon
        }, null), C.caption]);
      const d = t.findRowState(N);
      if (d) {
        const p = D(t.providers[s].component);
        return Ie(p, {
          controller: n,
          row: d,
          key: N.tempsrfkey + s,
          attrs: Xe(i, {
            ...t.getEventArgs(),
            data: d.data
          })
        });
      }
      return null;
    }
  });
}
function te(t, i, e, o) {
  var s, a;
  if (i.columnType === "GROUPGRIDCOLUMN") {
    const n = ((s = i.degridColumns) == null ? void 0 : s.filter((u) => !u.hideDefault)) || [], {
      width: r
    } = i, c = ((a = i.align) == null ? void 0 : a.toLowerCase()) || "center";
    return w(D("el-table-column"), {
      prop: i.codeName,
      label: i.caption,
      "min-width": r,
      align: c
    }, {
      default: () => n.map((u, h) => te(t, u, e, h))
    });
  }
  return qe(t, i, e, o);
}
const j = /* @__PURE__ */ Ne({
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
  setup(t) {
    let i;
    (() => {
      t.modelData.controlType === "TREEGRID" ? i = K((...l) => new Qe(...l)) : i = K((...l) => new je(...l));
    })();
    const {
      zIndex: o
    } = ge();
    i.state.zIndex = o.increment();
    const s = Q("control-grid"), a = k(() => {
      if (t.modelData.controlType === "TREEGRID")
        return Q("control-".concat(i.model.controlType.toLowerCase()));
    }), n = Q("number-grid"), {
      tableRef: r,
      onRowClick: c,
      onDbRowClick: u,
      onSortChange: h,
      isSelected: f,
      curSelectedData: g,
      getSelection: C,
      handleRowClassName: N,
      treeGirdItems: d,
      treeGirdData: p,
      handleHeaderCellClassName: y
    } = ze(i), {
      onPageChange: S,
      onPageRefresh: b,
      onPageSizeChange: G
    } = Ue(i), x = k(() => t.modelData.controlType === "TREEGRID" ? i.state.showTreeGrid : !1), _ = async (l, m, E) => {
      const v = d.value.filter((R) => l[i.treeGridValueField] === R[i.treeGridParentField]);
      E(v);
    };
    let M = [];
    const se = () => {
      const l = [];
      return r.value && r.value.$el.getElementsByClassName("el-table__row").forEach((v) => {
        v.style.display !== "none" && l.push(v);
      }), l;
    }, q = (l = 0) => {
      setTimeout(() => {
        const m = se();
        m.length !== M.length && (M = m, m.forEach((E, v) => {
          const R = E.firstChild;
          if (R.className.includes("ibiz-number-grid__first-column")) {
            const O = R.getElementsByClassName("ibiz-number-grid__number--caption")[0];
            O && (O.innerText = "".concat((i.state.curPage - 1) * i.state.size + (v + 1)));
          }
        }));
      }, l);
    }, ie = (l, m) => {
      q(), i.setRowExpand(l, m);
    };
    Ge(() => {
      const {
        controlType: l,
        enableGroup: m
      } = i.model;
      l === "GRID" && m && q(1e3);
    }), U(() => x.value, (l, m) => {
      l !== m && (g.value = [], i.setSelection([]));
    });
    const oe = () => {
      const l = [...p.value], m = (E) => {
        const v = d.value.filter((R) => R[i.treeGridParentField] && E[i.treeGridValueField] === R[i.treeGridParentField]);
        v.length > 0 && (l.push(...v), v.forEach((R) => {
          m(R);
        }));
      };
      return p.value.forEach((E) => {
        m(E);
      }), l;
    }, H = () => {
      let l = [];
      return x.value ? l = oe() : (l = [...A.value], i.model.enableGroup && A.value.forEach((m) => {
        l.push(...m._children);
      })), l;
    }, V = () => {
      const l = H();
      let m = !1;
      return l.length > 0 && (m = l.filter((v) => !f(v)).length === 0), m;
    }, ae = () => {
      const l = H(), m = g.value.filter((E) => !l.find((v) => v.tempsrfkey === E.tempsrfkey));
      V() || m.push(...l), g.value = m, i.setSelection(C());
    }, re = (l) => {
      le(g.value, l), i.setSelection(C());
    }, ne = (l) => {
      l.stopPropagation();
    }, le = (l, m) => {
      const {
        controlType: E,
        enableGroup: v
      } = i.model, R = l.findIndex((P) => P.tempsrfkey === m.tempsrfkey);
      R !== -1 ? (l.splice(R, 1), E === "GRID" && v && (Y(m._children) ? m._children.forEach((P) => {
        const I = l.indexOf(P);
        I !== -1 && l.splice(I, 1);
      }) : A.value.forEach((P) => {
        const I = P._children.find((T) => !l.includes(T)), $ = l.findIndex((T) => T.tempsrfkey === P.tempsrfkey);
        I && $ !== -1 && l.splice($, 1);
      }))) : (l.push(m), E === "GRID" && v && (Y(m._children) ? m._children.forEach((P) => {
        l.indexOf(P) === -1 && l.push(P);
      }) : A.value.forEach((P) => {
        const I = P._children.find((T) => !l.includes(T)), $ = l.findIndex((T) => T.tempsrfkey === P.tempsrfkey);
        !I && $ === -1 && l.unshift(P);
      })));
    }, de = () => {
      var m;
      const {
        isLoaded: l
      } = i.state;
      if (l) {
        const E = (m = i.model.controls) == null ? void 0 : m.find((v) => v.name === "".concat(i.model.name, "_quicktoolbar"));
        return E ? w(D("iBizToolbarControl"), {
          modelData: E,
          context: i.context,
          params: i.params,
          class: s.b("quick-toolbar")
        }, null) : w(D("iBizNoData"), {
          text: i.model.emptyText,
          emptyTextLanguageRes: i.model.emptyTextLanguageRes
        }, null);
      }
      return null;
    }, {
      tableData: A,
      renderColumns: J,
      defaultSort: ce,
      summaryMethod: ue
    } = Be(i, t), {
      renderPopover: he
    } = Ve(r, i), fe = () => {
      var m;
      const l = (m = i.model.controls) == null ? void 0 : m.find((E) => E.name === "".concat(i.model.name, "_batchtoolbar"));
      if (!(!l || i.state.singleSelect))
        return w("div", {
          class: [s.b("batch-toolbar"), n.b("batch-toolbar"), s.is("show", i.state.selectedData.length > 0)]
        }, [w("div", {
          class: s.b("batch-toolbar-content")
        }, [w("div", {
          class: s.b("batch-toolbar-text")
        }, [z("已选中"), i.state.selectedData.length, z("项")]), w("div", {
          class: s.b("batch-toolbar-separator")
        }, [z("|")]), w(D("iBizToolbarControl"), {
          modelData: l,
          context: i.context,
          params: i.params,
          class: s.b("batch-toolbar-items")
        }, null)])]);
    }, me = () => {
      const l = J.value.length ? "width" : "min-width";
      return w(D("el-table-column"), ee({
        "class-name": n.e("first-column")
      }, {
        [l]: 80
      }, {
        align: "center",
        fixed: "left",
        type: "index"
      }), {
        header: () => w("div", {
          class: n.e("number")
        }, [i.state.singleSelect ? w("span", null, [z("序号")]) : w(D("el-checkbox"), {
          size: "large",
          indeterminate: i.state.selectedData.length > 0 && !V(),
          modelValue: V(),
          onChange: () => ae()
        }, null)]),
        // eslint-disable-next-line @typescript-eslint/no-unused-vars
        default: ({
          row: m,
          column: E,
          $index: v
        }) => {
          const R = (i.state.curPage - 1) * i.state.size + (v + 1);
          return i.state.singleSelect ? w("div", {
            class: n.e("number")
          }, [w("span", null, [R])]) : w("div", {
            class: n.e("number"),
            onClick: (O) => ne(O)
          }, [w("span", {
            class: n.em("number", "caption")
          }, [R]), w(D("el-checkbox"), {
            size: "large",
            class: n.em("number", "checkbox"),
            modelValue: f(m),
            onChange: () => re(m)
          }, null)]);
        }
      });
    };
    return xe(() => {
      o.decrement();
    }), {
      c: i,
      ns: s,
      ns2: a,
      ns3: n,
      tableRef: r,
      tableData: A,
      treeGirdData: p,
      loadData: _,
      showTreeGrid: x,
      renderColumns: J,
      onDbRowClick: u,
      onRowClick: c,
      onExpandChange: ie,
      onSortChange: h,
      onPageChange: S,
      onPageSizeChange: G,
      onPageRefresh: b,
      handleRowClassName: N,
      handleHeaderCellClassName: y,
      renderNoData: de,
      summaryMethod: ue,
      renderPopover: he,
      defaultSort: ce,
      renderBatchToolBar: fe,
      renderFirstColumn: me
    };
  },
  render() {
    var o;
    if (!this.c.state.isCreated)
      return;
    const {
      state: t
    } = this.c, {
      hideHeader: i,
      enablePagingBar: e
    } = this.c.model;
    return w(D("iBizControlBase"), {
      class: [this.ns.b(), (o = this.ns2) == null ? void 0 : o.b(), this.ns3.b(), this.ns.is("show-header", !i), this.ns.is("enable-page", e), this.ns.is("enable-group", this.c.model.enableGroup), this.ns.is("single-select", t.singleSelect), this.ns.is("enable-customized", this.c.model.enableCustomized)],
      controller: this.c
    }, {
      default: () => [w(D("el-table"), {
        border: !0,
        ref: "tableRef",
        "row-key": "tempsrfkey",
        class: this.ns.e("table"),
        "default-sort": this.defaultSort,
        "show-header": !i,
        "show-summary": this.c.enableAgg,
        "summary-method": this.summaryMethod,
        "highlight-current-row": t.singleSelect,
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
        default: () => [this.renderFirstColumn(), this.renderColumns.map((s, a) => te(this.c, s, this.renderColumns, a))],
        append: () => this.renderPopover()
      }), e && w(D("iBizPagination"), {
        total: t.total,
        curPage: t.curPage,
        size: t.size,
        totalPages: t.totalPages,
        onChange: this.onPageChange,
        onPageSizeChange: this.onPageSizeChange,
        onPageRefresh: this.onPageRefresh
      }, null), this.c.model.enableCustomized && !i && w("div", {
        class: [this.ns.b("setting-box"), this.ns3.b("setting-box")]
      }, [w(D("iBizGridSetting"), {
        columnStates: t.columnStates,
        controller: this.c
      }, null)]), this.renderBatchToolBar()]
    });
  }
}), He = ye(
  j,
  (t) => {
    t.component(j.name, j), Re(
      "GRID_RENDER_NUMBER_GRID",
      () => new $e()
    );
  }
), ot = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(t) {
    t.use(He);
  }
};
export {
  He as IBizNumberGridControl,
  ot as default
};
