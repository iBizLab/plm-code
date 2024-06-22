import './style.css';
var ue = Object.defineProperty;
var he = (s, t, e) => t in s ? ue(s, t, { enumerable: !0, configurable: !0, writable: !0, value: e }) : s[t] = e;
var x = (s, t, e) => (he(s, typeof t != "symbol" ? t + "" : t, e), e);
import { useUIStore as fe, useNamespace as M, useControlController as V, withInstall as me } from "@ibiz-template/vue3-util";
import { Srfuf as z, GridRowState as H, ControlVO as pe, TreeGridController as we, calcDeCodeNameById as ge, GridNotifyState as X, GridController as Ce, ScriptFactory as ye, registerControlProvider as be } from "@ibiz-template/runtime";
import { ref as k, computed as I, watch as A, nextTick as Se, reactive as ve, createVNode as w, resolveComponent as S, defineComponent as Ee, onMounted as De, onUnmounted as Re, createTextVNode as L, mergeProps as W, h as Pe } from "vue";
import { toNumber as xe, isArray as q } from "lodash-es";
import { isElementSame as Ie, RuntimeError as G, awaitTimeout as Ge, mergeDefaultInLeft as Ne, RuntimeModelError as Te } from "@ibiz-template/core";
import { createUUID as Le } from "qx-util";
import { computePosition as ke } from "@floating-ui/dom";
class Ae {
  constructor() {
    x(this, "component", "IBizNumberGridControl");
  }
}
function Fe(s) {
  const t = k(), e = k([]), o = I(() => s.state.treeData);
  async function i(a, h, m) {
    if (!(s.model.enableGroup && a.isGroupData) && a.srfuf !== z.CREATE)
      if (ibiz.config.grid.editShowMode === "row" && s.model.enableRowEdit) {
        const C = s.findRowState(a);
        C && C.showRowEdit !== !0 && await s.switchRowEdit(C, !0);
      } else
        s.onRowClick(a);
  }
  function n(a) {
    s.model.enableGroup && a.isGroupData || a.srfuf !== z.CREATE && s.onDbRowClick(a);
  }
  function r(a) {
    return !!e.value.find(
      (h) => a.tempsrfkey === h.tempsrfkey
    );
  }
  function l() {
    return s.model.enableGroup ? e.value.filter((a) => !a.isGroupData) : e.value;
  }
  A(
    [
      () => t.value,
      () => s.state.isLoaded,
      () => s.state.selectedData
    ],
    ([a, h, m]) => {
      !h || !a || (Ie(m, l()) || (e.value = m), s.state.singleSelect && (m[0] ? t.value.setCurrentRow(m[0], !0) : t.value.setCurrentRow()));
    }
  );
  function d(a) {
    const { prop: h, order: m } = a, C = s.fieldColumns[h].model.appDEFieldId;
    let g;
    m === "ascending" ? g = "asc" : m === "descending" && (g = "desc"), "".concat(C, ",").concat(g) !== s.state.sortQuery && (s.setSort(C, g), s.load());
  }
  function u({ row: a }) {
    let h = "";
    e.value.length > 0 && e.value.forEach((C) => {
      C.tempsrfkey === a.tempsrfkey && (h = "current-row");
    });
    const m = s.findRowState(a);
    return m != null && m.showRowEdit && (h += " editing-row"), a.srfkey && (h += " id-".concat(a.srfkey)), h;
  }
  function f({
    _row: a,
    column: h,
    _rowIndex: m,
    _columnIndex: C
  }) {
    var D;
    const g = (D = s.model.degridColumns) == null ? void 0 : D.find((F) => F.codeName === h.property);
    return g && g.headerSysCss && g.headerSysCss.cssName ? g.headerSysCss.cssName : "";
  }
  return A(
    () => s.state.sortQuery,
    (a) => {
      if (a) {
        const h = s.state.sortQuery.split(",")[0], m = s.state.sortQuery.split(",")[1];
        if (h && m) {
          const C = m === "desc" ? "descending" : "ascending", g = () => {
            t.value ? Se(() => {
              t.value.sort(h, C);
            }) : setTimeout(g, 500);
          };
          g();
        }
      }
    }
  ), s.evt.on("onRowCollapse", (a) => {
    setTimeout(() => {
      t.value && t.value.toggleRowExpansion(a.row.data, a.state);
    }, 0);
  }), {
    tableRef: t,
    getSelection: l,
    curSelectedData: e,
    onRowClick: i,
    onDbRowClick: n,
    isSelected: r,
    onSortChange: d,
    treeGirdData: o,
    handleRowClassName: u,
    handleHeaderCellClassName: f
  };
}
function Oe(s, t) {
  const { controlParam: e } = t.modelData, o = () => {
    t.data && (s.state.items = t.data, s.state.rows = t.data.map((d) => new H(new pe(d), s)));
  }, i = I(() => {
    var u;
    const d = Object.values(s.fieldColumns).find(
      (f) => f.model.appDEFieldId === s.model.minorSortAppDEFieldId
    );
    return {
      prop: d == null ? void 0 : d.model.codeName,
      order: ((u = s.model.minorSortDir) == null ? void 0 : u.toLowerCase()) === "desc" ? "descending" : "ascending"
    };
  });
  s.evt.on("onCreated", async () => {
    t.isSimple && (o(), s.state.isLoaded = !0);
  }), A(
    () => t.data,
    () => {
      t.isSimple && o();
    },
    {
      deep: !0
    }
  );
  const n = I(() => {
    const { state: d } = s;
    let u = {
      appId: s.context.srfappid,
      cssClass: "cube-outline"
    };
    if (e && e.ctrlParams && e.ctrlParams.GROUPICON && (u.cssClass = e.ctrlParams.GROUPICON), s.model.enableGroup) {
      const f = [];
      return d.groups.forEach((a) => {
        if (!a.children.length)
          return;
        a.groupIcon && (u = a.groupIcon);
        const h = [...a.children], m = Le();
        f.push({
          tempsrfkey: m,
          srfkey: m,
          isGroupData: !0,
          caption: a.caption,
          _children: h,
          groupIcon: u
        });
      }), f;
    }
    return d.rows.map((f) => f.data);
  }), r = I(() => {
    if (s.isMultistageHeader)
      return s.model.degridColumns || [];
    const d = [];
    return s.state.columnStates.forEach((u) => {
      var a, h;
      if (u.hidden)
        return;
      const f = ((a = s.fieldColumns[u.key]) == null ? void 0 : a.model) || ((h = s.uaColumns[u.key]) == null ? void 0 : h.model);
      f && d.push(f);
    }), d;
  });
  return { tableData: n, renderColumns: r, defaultSort: i, summaryMethod: ({
    columns: d
  }) => d.map((u, f) => f === 0 ? s.aggTitle : s.state.aggResult[u.property]) };
}
function $e(s) {
  function t(i) {
    !i || i === s.state.curPage || (s.state.curPage = i, s.load());
  }
  function e(i) {
    !i || i === s.state.size || (s.state.size = i, s.state.curPage === 1 && s.load());
  }
  function o() {
    s.load();
  }
  return { onPageChange: t, onPageSizeChange: e, onPageRefresh: o };
}
function Me(s, t) {
  let e;
  const o = k(!1), i = k(), n = ve({}), r = (a) => {
    if (!s.value)
      throw new G("找不到表格组件引用");
    const h = s.value.$el;
    let m = ".editing-row";
    a.data.srfkey && (m += ".id-".concat(a.data.srfkey));
    const C = h.querySelector(m);
    if (!C)
      throw new G("找不到对应的表格行dom元素");
    return C;
  }, l = async (a) => {
    const h = r(a);
    if (!e)
      throw new G("拿不到pop组件的实例");
    const m = e.$el, {
      x: C,
      y: g
    } = await ke(h, m, {
      placement: "bottom"
    });
    Object.assign(n, {
      top: "".concat(g, "px"),
      left: "".concat(C, "px")
    }), i.value = a, o.value = !0;
  }, d = async () => {
    i.value && t.switchRowEdit(i.value, !1, !0);
  }, u = async () => {
    i.value && t.switchRowEdit(i.value, !1, !1);
  }, f = () => {
    const a = o.value && t.state.rows[t.state.rows.length - 1].showRowEdit;
    return [w("div", {
      class: "row-edit-popover__placeholder",
      style: {
        display: a ? "block" : "none"
      }
    }, null), w(S("iBizRowEditPopover"), {
      ref: (h) => {
        e = h;
      },
      style: n,
      show: o.value,
      onConfirm: d,
      onCancel: u
    }, null)];
  };
  return t.evt.on("onRowEditChange", (a) => {
    a.row.showRowEdit ? setTimeout(() => {
      l(a.row);
    }, 0) : (i.value = void 0, o.value = !1, Object.assign(n, {
      top: void 0,
      left: void 0
    }));
  }), {
    renderPopover: f
  };
}
class _e extends we {
  constructor() {
    super(...arguments);
    /**
     * 是否默认展开所有
     *
     * @type {boolean}
     * @memberof NumberTreeGridController
     */
    x(this, "defaultExpandAll", !1);
    /**
     * 指定展开列下标
     *
     * @type {boolean}
     * @memberof NumberGridController
     */
    x(this, "expandColumnIndex");
  }
  get overflowMode() {
    return "ellipsis";
  }
  initState() {
    super.initState(), this.state.treeData = [];
    const e = "SHOW_MODE_".concat(this.context.project, "_").concat(this.view.model.codeName), o = localStorage.getItem(e);
    o === "tree" ? this.state.showTreeGrid = !0 : o === "grid" && (this.state.showTreeGrid = !1);
  }
  /**
   * 设置排序
   */
  setSort(e, o) {
    if (!e && !o)
      return;
    let i;
    e && (i = this.fieldIdNameMap.get(e).toLowerCase()), i && o ? this.state.sortQuery = "".concat(i, ",").concat(o) : this.state.sortQuery = "", this.setSortCache();
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
    const { curPage: o, size: i, sortQuery: n, noSort: r } = this.state, l = {
      ...this.params
    };
    if (i && (l.page = o - 1, l.size = i), !r)
      if (n)
        l.sort = n;
      else {
        const { minorSortAppDEFieldId: d, minorSortDir: u } = this.getSortModel();
        if (this.view && localStorage.getItem("".concat(this.view.model.id, ".").concat(this.model.name, ".sort")))
          this.state.sortQuery = localStorage.getItem(
            "".concat(this.view.model.id, ".").concat(this.model.name, ".sort")
          );
        else if (d && u) {
          const f = this.fieldIdNameMap.get(d);
          this.state.sortQuery = "".concat(f.toLowerCase(), ",").concat(u.toLowerCase());
        }
        l.sort = this.state.sortQuery, this.setSortCache();
      }
    return await this.evt.emit("onBeforeLoad", void 0), Object.assign(l, {
      ...this.state.searchParams
    }), e && Object.assign(l, e), l;
  }
  /**
   * 切换显示模式
   *
   * @param {IData} param
   * @memberof NumberTreeGridController
   */
  async switchShowMode(e) {
    const { showMode: o } = e;
    o && (o === "tree" ? this.state.showTreeGrid = !0 : o === "grid" && (this.state.showTreeGrid = !1), this.state.treeData = [...this.state.items], await this.refresh());
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
    await this.load({ isInitialLoad: e });
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
      const i = e.isInitialLoad === !0, n = e.isLoadMore === !0;
      i ? this.state.curPage = 1 : n && (this.state.curPage += 1);
      const { context: r } = this.handlerAbilityParams(e), l = await this.getFetchParams(e == null ? void 0 : e.viewParam);
      l != null && l.hasOwnProperty("srfshowmode") || this.state.showTreeGrid && Object.assign(l, {
        srfshowmode: "tree"
      });
      const d = await this.service.fetch(r, l);
      typeof d.total == "number" && (this.state.total = d.total), typeof d.totalPages == "number" && (this.state.totalPages = d.totalPages), n ? this.state.items.push(...d.data) : this.state.items = d.data, await this.afterLoad(e, d.data), this.state.isLoaded = !0, await this.evt.emit("onLoadSuccess", {
        isInitialLoad: i
      });
    } catch (i) {
      throw await this.evt.emit("onLoadError", void 0), this.actionNotification("FETCHERROR", {
        error: i
      }), i;
    } finally {
      o || await this.endLoading();
    }
    return this.state.items.forEach((i, n) => {
      i.srfserialnum = n + 1;
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
      this.state.selectedData = [];
    else {
      const n = this.state.selectedData.filter(
        (r) => this.state.items.find((l) => r.tempsrfkey === l.tempsrfkey)
      );
      this.state.selectedData = n;
    }
    return this.setTreeData(), o;
  }
  /**
   * 设置树数据
   *
   * @memberof NumberTreeGridController
   */
  setTreeData() {
    if (this.state.showTreeGrid) {
      const e = this.state.items.map((n) => n[this.treeGridValueField]).filter((n) => n !== void 0), o = this.state.items.filter(
        (n) => !e.includes(n[this.treeGridParentField])
      ), i = (n) => {
        n.forEach((r) => {
          const l = this.state.items.filter(
            (d) => r[this.treeGridValueField] && d[this.treeGridParentField] === r[this.treeGridValueField]
          );
          l.length > 0 && i(l), r._children = l;
        });
      };
      i(o), this.state.treeData = o;
    }
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
    const o = e.srfuf === z.CREATE, i = this.findRowState(e);
    if (!i)
      throw new G("行数据不存在");
    if (!i.modified) {
      ibiz.log.debug("值没有发生改变");
      return;
    }
    if (i.processing) {
      await Ge(500, this.save.bind(this), [e]);
      return;
    }
    if (!await this.validate(i))
      throw new G("行数据校验不通过，保存取消");
    let r;
    const l = ge(this.model.appDataEntityId), d = this.context.clone();
    d[l] = e.srfkey;
    try {
      r = o ? await this.service.create(d, e) : await this.service.update(d, e);
    } catch (f) {
      throw o && await this.remove({ data: [e], silent: !0 }), await this.evt.emit("onSaveError", void 0), this.actionNotification("".concat(o ? "CREATE" : "UPDATE", "ERROR"), {
        error: f,
        data: i.data
      }), f;
    }
    const u = this.findRowStateIndex(e);
    this.state.items.splice(u, 1, r.data), i.data = r.data, i.modified = !1, this.setTreeData(), this.gridStateNotify(i, X.SAVE), await this.evt.emit("onSaveSuccess", void 0);
  }
  afterRemove(e) {
    const o = this.state.items.findIndex(
      (r) => r.srfkey === e.srfkey
    );
    o !== -1 && this.state.items.splice(o, 1);
    const i = this.findRowStateIndex(e);
    this.state.rows[i], this.state.rows.splice(i, 1), this.state.groups.forEach((r) => {
      if (r.children.length) {
        const l = r.children.findIndex(
          (d) => d.srfkey === e.srfkey
        );
        l !== -1 && r.children.splice(l, 1);
      }
    }), this.setTreeData();
    const n = this.state.rows.find((r) => e[this.treeGridParentField] && r.data[this.treeGridValueField] === e[this.treeGridParentField]);
    n && n.data._children.length === 0 && this.evt.emit("onRowCollapse", { row: n, state: !1 });
  }
  /**
   * 新建行
   *
   * @param {MDCtrlLoadParams} [args={}]
   * @return {*}  {Promise<void>}
   * @memberof NumberTreeGridController
   */
  async newRow(e = {}) {
    const { data: o } = e, { editShowMode: i } = ibiz.config.grid;
    let n = {};
    if (o && (n = Array.isArray(o) ? o[0] : o), i === "row" && this.state.rows.find((m) => m.showRowEdit))
      throw new G("请先完成当前行编辑中的行的操作");
    const r = { ...this.params }, l = this.calcDefaultValue(n || {}, !0);
    n.srfDefaultData && Object.assign(l, n.srfDefaultData), Object.assign(r, l);
    let d;
    try {
      d = await this.service.getDraft(this.context, r);
    } catch (h) {
      throw this.actionNotification("GETDRAFTERROR", {
        error: h
      }), h;
    }
    const u = d.data;
    Ne(u, l), u[this.treeGridParentField] = n[this.treeGridValueField], n.srfUserData && (u.srfUserData = n.srfUserData), this.state.items.push(u);
    const f = new H(u, this);
    this.state.rows.push(f), this.gridStateNotify(f, X.DRAFT), i === "row" && this.switchRowEdit(f, !0), this.setTreeData();
    const a = this.state.rows.find((h) => f.data[this.treeGridParentField] && h.data[this.treeGridValueField] === f.data[this.treeGridParentField]);
    a && this.evt.emit("onRowCollapse", { row: a, state: !0 }), this.actionNotification("GETDRAFTSUCCESS", { data: u });
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
}
class ze extends Ce {
  constructor() {
    super(...arguments);
    /**
     * 分组代码表数据项
     *
     * @type {readonly}
     * @memberof NumberGridController
     */
    x(this, "codeListItems");
    /**
     * 是否默认展开所有
     *
     * @type {boolean}
     * @memberof NumberGridController
     */
    x(this, "defaultExpandAll", !1);
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
    let i;
    e && (i = this.fieldIdNameMap.get(e).toLowerCase()), i && o ? this.state.sortQuery = "".concat(i, ",").concat(o) : this.state.sortQuery = "", this.setSortCache();
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
    const { curPage: o, size: i, sortQuery: n, noSort: r } = this.state, l = {
      ...this.params
    };
    if (i && (l.page = o - 1, l.size = i), !r)
      if (n)
        l.sort = n;
      else {
        const { minorSortAppDEFieldId: d, minorSortDir: u } = this.getSortModel();
        if (this.view && localStorage.getItem("".concat(this.view.model.id, ".").concat(this.model.name, ".sort")))
          this.state.sortQuery = localStorage.getItem(
            "".concat(this.view.model.id, ".").concat(this.model.name, ".sort")
          );
        else if (d && u) {
          const f = this.fieldIdNameMap.get(d);
          this.state.sortQuery = "".concat(f.toLowerCase(), ",").concat(u.toLowerCase());
        }
        l.sort = this.state.sortQuery, this.setSortCache();
      }
    return await this._evt.emit("onBeforeLoad", void 0), Object.assign(l, {
      ...this.state.searchParams
    }), e && Object.assign(l, e), l;
  }
  /**
   * 初始化表格分组
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof NumberGridController
   */
  async initGroup() {
    const { groupCodeListId: e, groupMode: o, enableGroup: i } = this.model;
    if (i && o === "CODELIST") {
      if (!e)
        throw new Te(
          this.model,
          "代码表分组模式需要配置代码表"
        );
      const n = ibiz.hub.getApp(this.context.srfappid);
      this.codeListItems = await n.codeList.get(
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
    const { enableGroup: o, groupMode: i, groupAppDEFieldId: n } = this.model;
    if (o && n) {
      const r = /* @__PURE__ */ new Map(), l = i === "CODELIST", d = n.toLowerCase();
      l && this.codeListItems.forEach((u) => {
        r.set(u.value, []);
      }), e.forEach((u) => {
        const f = u[d];
        !l && !r.has(f) && r.set(f, []), r.has(f) && r.get(f).push(u);
      }), this.state.groups = [], r.forEach((u, f) => {
        var h;
        const a = (h = this.codeListItems) == null ? void 0 : h.find(
          (m) => m.value === f
        );
        this.state.groups.push({
          caption: (a == null ? void 0 : a.text) || "".concat(f || "其他"),
          groupIcon: a == null ? void 0 : a.sysImage,
          key: f,
          children: u
        });
      });
    }
  }
  async afterLoad(e, o) {
    if (await super.afterLoad(e, o), e.isInitialLoad === !0)
      this.state.selectedData = [];
    else {
      const n = this.state.selectedData.filter(
        (r) => this.state.items.find((l) => r.tempsrfkey === l.tempsrfkey)
      );
      this.state.selectedData = n;
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
function Be(s, t) {
  var o;
  const e = {};
  return (o = s.controlAttributes) == null || o.forEach((i) => {
    i.attrName && i.attrValue && (e[i.attrName] = ye.execSingleLine(i.attrValue, {
      ...t
    }));
  }), e;
}
function Ue(s, t, e, o) {
  var h;
  const {
    codeName: i,
    width: n
  } = t, r = s.columns[i], l = s.state.columnStates.find((m) => m.key === i), d = e.find((m) => s.columns[m.codeName].isAdaptiveColumn), f = r.isAdaptiveColumn || !d && o === e.length - 1 ? "min-width" : "width";
  let a = "default";
  return s != null && s.expandColumnIndex && o < xe(s == null ? void 0 : s.expandColumnIndex) && (a = ""), w(S("el-table-column"), W({
    label: t.caption,
    prop: i
  }, {
    [f]: n
  }, {
    fixed: l.fixed,
    sortable: t.enableSort ? "custom" : !1,
    align: ((h = t.align) == null ? void 0 : h.toLowerCase()) || "center",
    type: a
  }), {
    default: ({
      row: m
    }) => {
      const C = m;
      if (m.isGroupData)
        return o !== 0 ? null : w("div", {
          class: "group-column"
        }, [w(S("iBizIcon"), {
          class: "group-icon",
          icon: m.groupIcon
        }, null), m.caption]);
      const g = s.findRowState(C);
      if (g) {
        const D = S(s.providers[i].component);
        return Pe(D, {
          controller: r,
          row: g,
          key: C.tempsrfkey + i,
          attrs: Be(t, {
            ...s.getEventArgs(),
            data: g.data
          })
        });
      }
      return null;
    }
  });
}
function J(s, t, e, o) {
  var i, n;
  if (t.columnType === "GROUPGRIDCOLUMN") {
    const r = ((i = t.degridColumns) == null ? void 0 : i.filter((u) => !u.hideDefault)) || [], {
      width: l
    } = t, d = ((n = t.align) == null ? void 0 : n.toLowerCase()) || "center";
    return w(S("el-table-column"), {
      prop: t.codeName,
      label: t.caption,
      "min-width": l,
      align: d
    }, {
      default: () => r.map((u, f) => J(s, u, e, f))
    });
  }
  return Ue(s, t, e, o);
}
const _ = /* @__PURE__ */ Ee({
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
  setup(s) {
    let t;
    (() => {
      s.modelData.controlType === "TREEGRID" ? t = V((...c) => new _e(...c)) : t = V((...c) => new ze(...c));
    })();
    const {
      zIndex: o
    } = fe();
    t.state.zIndex = o.increment();
    const i = M("control-grid"), n = I(() => {
      if (s.modelData.controlType === "TREEGRID")
        return M("control-".concat(t.model.controlType.toLowerCase()));
    }), r = M("number-grid"), {
      tableRef: l,
      onRowClick: d,
      onDbRowClick: u,
      onSortChange: f,
      isSelected: a,
      curSelectedData: h,
      getSelection: m,
      handleRowClassName: C,
      treeGirdData: g,
      handleHeaderCellClassName: D
    } = Fe(t), {
      onPageChange: F,
      onPageRefresh: K,
      onPageSizeChange: Y
    } = $e(t), O = I(() => s.modelData.controlType === "TREEGRID" ? t.state.showTreeGrid : !1), B = (c = 0) => {
      setTimeout(() => {
        if (l.value) {
          const p = l.value.$el.getElementsByClassName("el-table__row");
          let y = 0;
          p.forEach((b) => {
            const E = b.firstChild.getElementsByClassName("ibiz-number-grid__number--caption")[0];
            b.style.display !== "none" && E && (E.innerText = "".concat((t.state.curPage - 1) * t.state.size + (y + 1)), y++);
          });
        }
      }, c);
    }, Z = (c, p) => {
      B();
    };
    De(() => {
      const {
        controlType: c,
        enableGroup: p
      } = t.model;
      t.evt.on("onLoadSuccess", () => {
        (c === "TREEGRID" || c === "GRID" && p) && B();
      });
    }), A(() => O.value, (c, p) => {
      c !== p && (h.value = [], t.setSelection([]));
    });
    const ee = () => {
      const c = [...g.value], p = (y) => {
        const b = t.state.items.filter((E) => E[t.treeGridParentField] && y[t.treeGridValueField] === E[t.treeGridParentField]);
        b.length > 0 && (c.push(...b), b.forEach((E) => {
          p(E);
        }));
      };
      return g.value.forEach((y) => {
        p(y);
      }), c;
    }, U = () => {
      let c = [];
      return O.value ? c = ee() : (c = [...N.value], t.model.enableGroup && N.value.forEach((p) => {
        c.push(...p._children);
      })), c;
    }, $ = () => {
      const c = U();
      let p = !1;
      return c.length > 0 && (p = c.filter((b) => !a(b)).length === 0), p;
    }, te = () => {
      const c = U(), p = h.value.filter((y) => !c.find((b) => b.tempsrfkey === y.tempsrfkey));
      $() || p.push(...c), h.value = p, t.setSelection(m());
    }, se = (c) => {
      oe(h.value, c), t.setSelection(m());
    }, ie = (c) => {
      c.stopPropagation();
    }, oe = (c, p) => {
      const {
        controlType: y,
        enableGroup: b
      } = t.model, E = c.findIndex((v) => v.tempsrfkey === p.tempsrfkey);
      E !== -1 ? (c.splice(E, 1), y === "GRID" && b && (q(p._children) ? p._children.forEach((v) => {
        const R = c.indexOf(v);
        R !== -1 && c.splice(R, 1);
      }) : N.value.forEach((v) => {
        const R = v._children.find((P) => !c.includes(P)), T = c.findIndex((P) => P.tempsrfkey === v.tempsrfkey);
        R && T !== -1 && c.splice(T, 1);
      }))) : (c.push(p), y === "GRID" && b && (q(p._children) ? p._children.forEach((v) => {
        c.indexOf(v) === -1 && c.push(v);
      }) : N.value.forEach((v) => {
        const R = v._children.find((P) => !c.includes(P)), T = c.findIndex((P) => P.tempsrfkey === v.tempsrfkey);
        !R && T === -1 && c.unshift(v);
      })));
    }, ae = () => {
      var p;
      const {
        isLoaded: c
      } = t.state;
      if (c) {
        const y = (p = t.model.controls) == null ? void 0 : p.find((b) => b.name === "".concat(t.model.name, "_quicktoolbar"));
        return y ? w(S("iBizToolbarControl"), {
          modelData: y,
          context: t.context,
          params: t.params,
          class: i.b("quick-toolbar")
        }, null) : w(S("iBizNoData"), {
          text: t.model.emptyText,
          emptyTextLanguageRes: t.model.emptyTextLanguageRes
        }, null);
      }
      return null;
    }, {
      tableData: N,
      renderColumns: Q,
      defaultSort: ne,
      summaryMethod: re
    } = Oe(t, s), {
      renderPopover: le
    } = Me(l, t), de = () => {
      var p;
      const c = (p = t.model.controls) == null ? void 0 : p.find((y) => y.name === "".concat(t.model.name, "_batchtoolbar"));
      if (!(!c || t.state.singleSelect))
        return w("div", {
          class: [i.b("batch-toolbar"), r.b("batch-toolbar"), i.is("show", t.state.selectedData.length > 0)]
        }, [w("div", {
          class: i.b("batch-toolbar-content")
        }, [w("div", {
          class: i.b("batch-toolbar-text")
        }, [L("已选中"), t.state.selectedData.length, L("项")]), w("div", {
          class: i.b("batch-toolbar-separator")
        }, [L("|")]), w(S("iBizToolbarControl"), {
          modelData: c,
          context: t.context,
          params: t.params,
          class: i.b("batch-toolbar-items")
        }, null)])]);
    }, ce = () => {
      const c = Q.value.length ? "width" : "min-width";
      return w(S("el-table-column"), W({
        "class-name": r.e("first-column")
      }, {
        [c]: 80
      }, {
        align: "center",
        fixed: "left",
        type: "index"
      }), {
        header: () => w("div", {
          class: r.e("number")
        }, [t.state.singleSelect ? w("span", null, [L("序号")]) : w(S("el-checkbox"), {
          size: "large",
          indeterminate: t.state.selectedData.length > 0 && !$(),
          modelValue: $(),
          onChange: () => te()
        }, null)]),
        // eslint-disable-next-line @typescript-eslint/no-unused-vars
        default: ({
          row: p,
          column: y,
          $index: b
        }) => {
          const E = (t.state.curPage - 1) * t.state.size + (b + 1);
          return w("div", {
            class: [r.e("number"), r.is("multiple", !t.state.singleSelect), r.is("single", t.state.singleSelect)],
            onClick: (j) => ie(j)
          }, [w("span", {
            class: r.em("number", "caption")
          }, [E]), !t.state.singleSelect && w(S("el-checkbox"), {
            size: "large",
            class: r.em("number", "checkbox"),
            modelValue: a(p),
            onChange: () => se(p)
          }, null)]);
        }
      });
    };
    return Re(() => {
      o.decrement();
    }), {
      c: t,
      ns: i,
      ns2: n,
      ns3: r,
      tableRef: l,
      tableData: N,
      treeGirdData: g,
      showTreeGrid: O,
      renderColumns: Q,
      onDbRowClick: u,
      onRowClick: d,
      onExpandChange: Z,
      onSortChange: f,
      onPageChange: F,
      onPageSizeChange: Y,
      onPageRefresh: K,
      handleRowClassName: C,
      handleHeaderCellClassName: D,
      renderNoData: ae,
      summaryMethod: re,
      renderPopover: le,
      defaultSort: ne,
      renderBatchToolBar: de,
      renderFirstColumn: ce
    };
  },
  render() {
    var o;
    if (!this.c.state.isCreated)
      return;
    const {
      state: s
    } = this.c, {
      hideHeader: t,
      enablePagingBar: e
    } = this.c.model;
    return w(S("iBizControlBase"), {
      class: [this.ns.b(), (o = this.ns2) == null ? void 0 : o.b(), this.ns3.b(), this.ns.is("show-header", !t), this.ns.is("enable-page", e), this.ns.is("enable-group", this.c.model.enableGroup), this.ns.is("single-select", s.singleSelect), this.ns.is("enable-customized", this.c.model.enableCustomized)],
      controller: this.c
    }, {
      default: () => [w(S("el-table"), {
        border: !0,
        ref: "tableRef",
        "row-key": "tempsrfkey",
        class: this.ns.e("table"),
        "default-sort": this.defaultSort,
        "show-header": !t,
        "show-summary": this.c.enableAgg,
        "summary-method": this.summaryMethod,
        "highlight-current-row": s.singleSelect,
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
        }
      }, {
        empty: this.renderNoData,
        default: () => [this.renderFirstColumn(), this.renderColumns.map((i, n) => J(this.c, i, this.renderColumns, n))],
        append: () => this.renderPopover()
      }), e && w(S("iBizPagination"), {
        total: s.total,
        curPage: s.curPage,
        size: s.size,
        totalPages: s.totalPages,
        onChange: this.onPageChange,
        onPageSizeChange: this.onPageSizeChange,
        onPageRefresh: this.onPageRefresh
      }, null), this.c.model.enableCustomized && !t && w("div", {
        class: [this.ns.b("setting-box"), this.ns3.b("setting-box")]
      }, [w(S("iBizGridSetting"), {
        columnStates: s.columnStates,
        controller: this.c
      }, null)]), this.renderBatchToolBar()]
    });
  }
}), Qe = me(
  _,
  (s) => {
    s.component(_.name, _), be(
      "GRID_RENDER_NUMBER_GRID",
      () => new Ae()
    );
  }
), Ye = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(s) {
    s.use(Qe);
  }
};
export {
  Qe as IBizNumberGridControl,
  Ye as default
};
