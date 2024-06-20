var S = Object.defineProperty;
var y = (n, o, t) => o in n ? S(n, o, { enumerable: !0, configurable: !0, writable: !0, value: t }) : n[o] = t;
var m = (n, o, t) => (y(n, typeof o != "symbol" ? o + "" : o, t), t);
import { ControlController as R, Srfuf as x, calcItemVisibleByCounter as C, calcItemVisible as N, calcNavParams as E, hasSubRoute as P, CounterService as V, registerControlProvider as _ } from "@ibiz-template/runtime";
import { route2routePath as d, routePath2string as I, useControlController as A, useNamespace as G, getNestedRoutePath as w, onRouteChange as j, withInstall as O } from "@ibiz-template/vue3-util";
import { defineComponent as T, watch as L, createVNode as g, resolveComponent as b, isVNode as M } from "vue";
import { useRouter as $, useRoute as B } from "vue-router";
class z extends R {
  constructor() {
    super(...arguments);
    /**
     * Router 对象
     *
     * @type {Router}
     * @memberof DRTabController
     */
    m(this, "router");
    /**
     * 存储key前缀
     *
     * @author zhanghengfeng
     * @date 2024-05-22 18:05:13
     * @type {string}
     */
    m(this, "storagePrefix", "DR_BAR_SELECTED_ITEM");
    /**
     * 计数器对象
     *
     * @author zhanghengfeng
     * @date 2024-05-20 11:05:16
     * @type {AppCounter}
     */
    m(this, "counter");
  }
  /**
   * 导航占位控制器
   *
   * @readonly
   * @memberof DRBarExController
   */
  get navPos() {
    var t;
    return (t = this.view.layoutPanel) == null ? void 0 : t.panelItems.nav_pos;
  }
  /**
   * 表单部件
   *
   * @readonly
   * @memberof DRBarExController
   */
  get form() {
    var t;
    return (t = this.view) == null ? void 0 : t.getController("form");
  }
  /**
   * 是否是新建
   * @author lxm
   * @date 2023-12-11 06:32:04
   * @readonly
   * @type {boolean}
   */
  get isCreate() {
    return this.getData()[0].srfuf !== x.UPDATE;
  }
  /**
   * 获取数据
   *
   * @return {*}  {IData[]}
   * @memberof DRBarExController
   */
  getData() {
    var t;
    return ((t = this.form) == null ? void 0 : t.getData()) || [{}];
  }
  /**
   * 设置 Router 对象
   *
   * @param {Router} router
   * @memberof DRTabController
   */
  setRouter(t) {
    this.router = t;
  }
  /**
   * 路由层级
   *
   * @readonly
   * @type {(number | undefined)}
   * @memberof DRBarExController
   */
  get routeDepth() {
    return this.view.modal.routeDepth;
  }
  /**
   * 初始化state的属性
   *
   * @protected
   * @memberof DRBarExController
   */
  initState() {
    super.initState(), this.state.drBarItems = [], this.state.srfnav = "", this.state.hideEditItem = !!this.model.hideEditItem;
  }
  /**
   * 创建完成
   *
   * @return {*}  {Promise<void>}
   * @memberof DRBarExController
   */
  async onCreated() {
    await super.onCreated(), this.initDRBarItems(), await this.initCounter();
  }
  /**
   * 通过计数器数据，计算项状态
   *
   * @author zhanghengfeng
   * @date 2024-05-20 11:05:21
   * @param {IData} [_data]
   * @param {boolean} [reset=true]
   */
  calcItemStateByCounter(t, e = !0) {
    if (this.state.drBarItems.forEach((s) => {
      var a;
      if ((a = s.children) != null && a.length)
        s.children.forEach((i) => {
          const r = C(i, this.counter);
          r !== void 0 && (i.visible = r);
        }), s.visible = s.children.some((i) => i.visible);
      else {
        const i = C(s, this.counter);
        i !== void 0 && (s.visible = i);
      }
    }), this.state.selectedItem && e) {
      const { visible: s, defaultVisibleItem: a } = this.getItemVisibleState(
        this.state.selectedItem
      );
      !s && a && this.handleSelectChange(a.tag);
    }
  }
  /**
   * 获取对应项的显示状态
   *
   * @author zhanghengfeng
   * @date 2024-05-20 11:05:41
   * @param {string} key
   * @return {*}  {{
   *     visible: boolean;
   *     defaultVisibleItem?: IDRBarItemsState;
   *   }}
   */
  getItemVisibleState(t) {
    let e = !0, s;
    return this.state.drBarItems.forEach((a) => {
      if (a.children) {
        s || (s = a.children.find((r) => r.visible));
        const i = a.children.find((r) => r.tag === t);
        i && (e = !!i.visible);
      } else
        !s && a.visible && (s = a), a.tag === t && (e = !!a.visible);
    }), {
      visible: e,
      defaultVisibleItem: s
    };
  }
  /**
   * 计算关系界面组权限
   *
   * @author zhanghengfeng
   * @date 2024-05-20 11:05:54
   * @param {IDRBarItemsState} item
   * @return {*}  {Promise<void>}
   */
  async calcPermitted(t) {
    var i;
    let e = !0;
    const s = (i = this.getData()) != null && i.length ? this.getData()[0] : void 0, a = await N(
      t,
      this.context,
      this.params,
      this.model.appDataEntityId,
      this.model.appId,
      s
    );
    a !== void 0 && (e = a), t.visible = e;
  }
  /**
   * 计算是否展示
   *
   * @author zhanghengfeng
   * @date 2024-05-20 11:05:59
   * @return {*}  {Promise<void>}
   */
  async calcDrBarItemsState() {
    await Promise.all(
      this.state.drBarItems.map(async (t) => {
        var e;
        (e = t.children) != null && e.length ? (await Promise.all(
          t.children.map(async (s) => {
            await this.calcPermitted(s);
          })
        ), t.visible = t.children.some((s) => s.visible)) : await this.calcPermitted(t);
      })
    ), this.calcItemStateByCounter({}, !1), this.state.isCalculatedPermission = !0;
  }
  /**
   * 加载完成
   *
   * @return {*}  {Promise<void>}
   * @memberof DRBarExController
   */
  async onMounted() {
    await super.onMounted(), this.form ? this.form.evt.on("onLoadSuccess", async (t) => {
      var s;
      const e = (s = t.data) == null ? void 0 : s[0];
      this.view.state.srfactiveviewdata = e, e && e.srfreadonly && (this.view.context.srfreadonly = !0), await this.calcDrBarItemsState(), this.doDefaultSelect();
    }) : await this.calcDrBarItemsState(), this.form.state.isLoaded && this.doDefaultSelect();
  }
  /**
   * 初始化关系项数据
   *
   * @memberof DRBarExController
   */
  initDRBarItems() {
    const { dedrctrlItems: t, dedrbarGroups: e } = this.model, s = [];
    e && t && e.forEach((a) => {
      const i = t.filter(
        (r) => r.dedrbarGroupId === a.id
      );
      if (i.length > 0) {
        let r = a.caption;
        a.capLanguageRes && (r = ibiz.i18n.t(
          a.capLanguageRes.lanResTag,
          a.caption
        ));
        const {
          enableMode: l,
          dataAccessAction: h,
          testAppDELogicId: c,
          testScriptCode: f,
          counterId: u
        } = i[0] || {};
        s.push({
          tag: a.id,
          caption: r,
          sysImage: a.sysImage,
          visible: !1,
          enableMode: l,
          dataAccessAction: h,
          testAppDELogicId: c,
          testScriptCode: f,
          counterId: u
        });
      }
    }), this.state.drBarItems = s;
  }
  /**
   * 处理选中改变
   *
   * @param {string} key
   * @memberof DRBarExController
   */
  handleSelectChange(t, e = !1) {
    var r;
    if (!this.state.drBarItems.find((l) => l.tag === t))
      return;
    const a = (r = this.model.dedrctrlItems) == null ? void 0 : r.find(
      (l) => l.dedrbarGroupId === t
    );
    a ? (this.setVisible("navPos"), this.openNavPosView(a, e)) : (this.setVisible("form"), this.routeDepth && this.router.push(this.state.drBarItems[0].fullPath)), this.state.selectedItem = t, this.state.defaultItem = t;
    const i = this.context.srfuserid;
    if (i) {
      const l = d(this.router.currentRoute.value);
      if (this.routeDepth && l.pathNodes[this.routeDepth - 2]) {
        l.pathNodes = l.pathNodes.slice(0, this.routeDepth - 1);
        const c = I(l).split("/");
        c && c.length && localStorage.setItem(
          "".concat(this.storagePrefix, "_").concat(i, "_").concat(c[c.length - 1]),
          t
        );
      }
    }
  }
  /**
   * 设置显示状态
   *
   * @param {('form' | 'navPos')} ctrlName 显示的部件名称
   * @memberof DRBarExController
   */
  setVisible(t) {
    var s;
    if (this.state.hideEditItem)
      return;
    const e = (s = this.view.layoutPanel) == null ? void 0 : s.panelItems.view_form;
    t === "form" ? (e && (e.state.visible = !0, e.state.keepAlive = !0), this.navPos && (this.navPos.state.visible = !1, this.navPos.state.keepAlive = !0)) : (e && (e.state.visible = !1, e.state.keepAlive = !0), this.navPos && (this.navPos.state.visible = !0, this.navPos.state.keepAlive = !0));
  }
  /**
   * 准备参数
   *
   * @param {IDEDRBarItem} drBarItem 关系项
   * @return {*}
   * @memberof DRBarExController
   */
  prepareParams(t) {
    const { navigateContexts: e, navigateParams: s } = t, a = {
      navContexts: e,
      navParams: s
    }, i = {
      context: this.context,
      params: this.params,
      data: this.getData()[0]
    }, { resultContext: r, resultParams: l } = E(a, i), h = Object.assign(this.context.clone(), r), c = { ...this.params, ...l };
    return { context: h, params: c };
  }
  /**
   * 打开导航占位视图
   *
   * @param {IDEDRBarItem} drBarItem 关系项
   * @memberof DRBarExController
   */
  async openNavPosView(t, e = !1) {
    var i;
    const { context: s, params: a } = this.prepareParams(t);
    Object.assign(s, {
      srfdefaulttoroutedepth: this.routeDepth + 1
    }), s.currentSrfNav = t.dedrbarGroupId, this.state.srfnav = t.dedrbarGroupId, (i = this.navPos) == null || i.openView({
      key: t.id,
      context: s,
      params: a,
      viewId: t.appViewId,
      isRoutePushed: e
    });
  }
  /**
   * 处理第一次的默认选中
   * @author lxm
   * @date 2023-12-11 05:38:30
   * @return {*}  {void}
   */
  doDefaultSelect() {
    var i;
    if (!this.state.hideEditItem && !this.state.srfnav)
      return;
    if (this.isCreate) {
      this.state.defaultItem = this.model.uniqueTag;
      return;
    }
    const { drBarItems: t } = this.state;
    let e = ((i = t[0].children) == null ? void 0 : i[0].tag) || t[0].tag;
    const s = this.context.srfuserid;
    if (s) {
      const r = d(this.router.currentRoute.value);
      if (this.routeDepth && r.pathNodes[this.routeDepth - 2]) {
        r.pathNodes = r.pathNodes.slice(0, this.routeDepth - 1);
        const h = I(r).split("/");
        if (h && h.length) {
          const c = localStorage.getItem(
            "".concat(this.storagePrefix, "_").concat(s, "_").concat(h[h.length - 1])
          );
          c && (e = c);
        }
      }
    }
    const a = d(this.router.currentRoute.value);
    if (this.routeDepth && a.pathNodes[this.routeDepth - 1]) {
      const r = a.pathNodes[this.routeDepth - 1];
      r && r.srfnav && (e = r.srfnav);
    }
    if (e) {
      const r = !!this.routeDepth && P(this.routeDepth), { visible: l, defaultVisibleItem: h } = this.getItemVisibleState(e);
      !l && h ? (e = h.tag, this.handleSelectChange(e)) : this.handleSelectChange(e, r), this.state.defaultItem = e;
    }
  }
  /**
   * 路由变更处理回调
   * @param {{ srfnav?: string; path: string }} info 当前系统的路由的从一级到最后一级的所有路径。
   */
  async onRouterChange(t) {
    if (this.state.srfnav !== t.srfnav && t.srfnav) {
      this.state.srfnav = t.srfnav;
      const e = !!this.routeDepth && P(this.routeDepth);
      this.handleSelectChange(t.srfnav, e), this.force(() => {
        this.state.defaultItem = t.srfnav;
      });
    }
  }
  /**
   * 初始化计数器
   *
   * @author zhanghengfeng
   * @date 2024-05-20 11:05:28
   * @protected
   * @return {*}  {Promise<void>}
   */
  async initCounter() {
    const { appCounterRefs: t } = this.model, e = t == null ? void 0 : t[0];
    if (e) {
      const s = d(this.router.currentRoute.value);
      this.routeDepth && (s.pathNodes = s.pathNodes.slice(0, this.routeDepth - 1));
      const a = I(s);
      this.counter = await V.getCounterByRef(
        e,
        this.context,
        a ? { srfcustomtag: a, ...this.params } : { ...this.params }
      ), this.calcItemStateByCounter = this.calcItemStateByCounter.bind(this), this.counter.onChange(this.calcItemStateByCounter);
    }
  }
  /**
   * 监听组件销毁
   *
   * @author zhanghengfeng
   * @date 2024-05-20 11:05:37
   * @protected
   * @return {*}  {Promise<void>}
   */
  async onDestroyed() {
    await super.onDestroyed(), this.counter && (this.counter.offChange(this.calcItemStateByCounter), this.counter.destroy());
  }
}
function q(n) {
  return typeof n == "function" || Object.prototype.toString.call(n) === "[object Object]" && !M(n);
}
function K(n) {
  const o = n.view.modal.routeDepth;
  if (o) {
    const t = B();
    let e;
    j(({
      currentKey: s,
      fullPath: a
    }) => {
      if (!e)
        e = s;
      else if (e === s) {
        const i = d(t), {
          srfnav: r
        } = i.pathNodes[o - 1];
        n.onRouterChange({
          srfnav: r || "",
          path: a
        });
      }
    }, o);
  }
}
const D = /* @__PURE__ */ T({
  name: "IBizDRBarExControl",
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
    srfnav: {
      type: String,
      required: !1
    },
    showMode: {
      type: String,
      default: "vertical"
    },
    hideEditItem: {
      type: Boolean,
      default: void 0
    }
  },
  setup(n) {
    const o = A((...i) => new z(...i)), t = G("control-".concat(o.model.controlType.toLowerCase(), "-ex")), e = $();
    o.setRouter(e);
    const s = B();
    return K(o), L(() => e.currentRoute.value, (i, r) => {
      var l, h;
      if (o.routeDepth && o.navPos) {
        const {
          pathNodes: c
        } = d(i), {
          pathNodes: f
        } = d(r), u = w(r, o.routeDepth + 1), p = w(s, o.routeDepth + 1);
        if (u === p)
          return;
        const v = ((l = c[o.routeDepth + 1]) == null ? void 0 : l.viewName) === "route-modal" || ((h = f[o.routeDepth + 1]) == null ? void 0 : h.viewName) === "route-modal";
        p && !v && o.navPos.openView({
          key: p,
          isRoutePushed: !1,
          context: o.context.clone(),
          params: {
            ...o.params
          }
        });
      }
    }), {
      c: o,
      ns: t,
      handleSelect: (i) => {
        var h, c, f;
        if (!o.state.drBarItems.find((u) => u.tag === i))
          return;
        const l = (h = o.model.dedrctrlItems) == null ? void 0 : h.find((u) => u.dedrbarGroupId === i);
        if (l) {
          const p = (c = d(s).pathNodes[o.routeDepth]) == null ? void 0 : c.viewName, v = (f = l.appViewId) == null ? void 0 : f.split(".")[1];
          if (v && p && v === p)
            return;
        }
        o.handleSelectChange(i);
      }
    };
  },
  render() {
    let n;
    const {
      isCreated: o,
      drBarItems: t,
      defaultItem: e,
      isCalculatedPermission: s
    } = this.c.state;
    return g(b("iBizControlBase"), {
      controller: this.c,
      class: this.ns.b()
    }, {
      default: () => [o && s && !!e && g(b("el-tabs"), {
        modelValue: e,
        onTabClick: (a, i) => {
          this.handleSelect(a.paneName);
        }
      }, q(n = t.map((a) => {
        if (a.visible)
          return g(b("el-tab-pane"), {
            label: a.caption,
            name: a.tag
          }, null);
      })) ? n : {
        default: () => [n]
      })]
    });
  }
});
class U {
  constructor() {
    m(this, "component", "IBizDRBarExControl");
  }
}
const k = O(
  D,
  function(n) {
    n.component(D.name, D), _("CUSTOM_DRBAR_EX", () => new U());
  }
), Q = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(n) {
    n.use(k);
  }
};
export {
  z as DRBarExController,
  k as IBizDRBarExControl,
  Q as default
};
