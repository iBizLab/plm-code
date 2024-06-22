var R = Object.defineProperty;
var x = (l, r, t) => r in l ? R(l, r, { enumerable: !0, configurable: !0, writable: !0, value: t }) : l[r] = t;
var g = (l, r, t) => (x(l, typeof r != "symbol" ? r + "" : r, t), t);
import { ControlController as N, Srfuf as E, calcItemVisibleByCounter as B, calcItemVisible as V, calcNavParams as _, hasSubRoute as w, CounterService as A, registerControlProvider as j } from "@ibiz-template/runtime";
import { route2routePath as u, routePath2string as C, useControlController as G, useNamespace as M, getNestedRoutePath as S, onRouteChange as O, withInstall as T } from "@ibiz-template/vue3-util";
import { defineComponent as L, reactive as $, onUnmounted as z, watch as q, createVNode as I, resolveComponent as D, isVNode as K } from "vue";
import { useRouter as U, useRoute as y } from "vue-router";
class k extends N {
  constructor() {
    super(...arguments);
    /**
     * Router 对象
     *
     * @type {Router}
     * @memberof DRTabController
     */
    g(this, "router");
    /**
     * 存储key前缀
     *
     * @author zhanghengfeng
     * @date 2024-05-22 18:05:13
     * @type {string}
     */
    g(this, "storagePrefix", "DR_BAR_SELECTED_ITEM");
    /**
     * 计数器对象
     *
     * @author zhanghengfeng
     * @date 2024-05-20 11:05:16
     * @type {AppCounter}
     */
    g(this, "counter");
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
    return this.getData()[0].srfuf !== E.UPDATE;
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
    if (this.state.drBarItems.forEach((a) => {
      var s;
      if ((s = a.children) != null && s.length)
        a.children.forEach((i) => {
          const o = B(i, this.counter);
          o !== void 0 && (i.visible = o);
        }), a.visible = a.children.some((i) => i.visible);
      else {
        const i = B(a, this.counter);
        i !== void 0 && (a.visible = i);
      }
    }), this.state.selectedItem && e) {
      const { visible: a, defaultVisibleItem: s } = this.getItemVisibleState(
        this.state.selectedItem
      );
      !a && s && this.handleSelectChange(s.tag);
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
    let e = !0, a;
    return this.state.drBarItems.forEach((s) => {
      if (s.children) {
        a || (a = s.children.find((o) => o.visible));
        const i = s.children.find((o) => o.tag === t);
        i && (e = !!i.visible);
      } else
        !a && s.visible && (a = s), s.tag === t && (e = !!s.visible);
    }), {
      visible: e,
      defaultVisibleItem: a
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
    const a = (i = this.getData()) != null && i.length ? this.getData()[0] : void 0, s = await V(
      t,
      this.context,
      this.params,
      this.model.appDataEntityId,
      this.model.appId,
      a
    );
    s !== void 0 && (e = s), t.visible = e;
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
          t.children.map(async (a) => {
            await this.calcPermitted(a);
          })
        ), t.visible = t.children.some((a) => a.visible)) : await this.calcPermitted(t);
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
      var a;
      const e = (a = t.data) == null ? void 0 : a[0];
      this.view.state.srfactiveviewdata = e, e && e.srfreadonly && (this.view.context.srfreadonly = !0), await this.calcDrBarItemsState(), this.doDefaultSelect();
    }) : await this.calcDrBarItemsState(), this.form.state.isLoaded && this.doDefaultSelect();
  }
  /**
   * 初始化关系项数据
   *
   * @memberof DRBarExController
   */
  initDRBarItems() {
    const { dedrctrlItems: t, dedrbarGroups: e } = this.model, a = [];
    e && t && e.forEach((s) => {
      const i = t.filter(
        (o) => o.dedrbarGroupId === s.id
      );
      if (i.length > 0) {
        let o = s.caption;
        s.capLanguageRes && (o = ibiz.i18n.t(
          s.capLanguageRes.lanResTag,
          s.caption
        ));
        const {
          enableMode: n,
          dataAccessAction: c,
          testAppDELogicId: h,
          testScriptCode: d,
          counterId: f,
          counterMode: p
        } = i[0] || {};
        a.push({
          tag: s.id,
          caption: o,
          sysImage: s.sysImage,
          visible: !1,
          enableMode: n,
          dataAccessAction: c,
          testAppDELogicId: h,
          testScriptCode: d,
          counterId: f,
          counterMode: p
        });
      }
    }), this.state.drBarItems = a;
  }
  /**
   * 处理选中改变
   *
   * @param {string} key
   * @memberof DRBarExController
   */
  handleSelectChange(t, e = !1) {
    var o;
    if (!this.state.drBarItems.find((n) => n.tag === t))
      return;
    const s = (o = this.model.dedrctrlItems) == null ? void 0 : o.find(
      (n) => n.dedrbarGroupId === t
    );
    s ? (this.setVisible("navPos"), this.openNavPosView(s, e)) : (this.setVisible("form"), this.routeDepth && this.router.push(this.state.drBarItems[0].fullPath)), this.state.selectedItem = t, this.state.defaultItem = t;
    const i = this.context.srfuserid;
    if (i) {
      const n = u(this.router.currentRoute.value);
      if (this.routeDepth && n.pathNodes[this.routeDepth - 2]) {
        n.pathNodes = n.pathNodes.slice(0, this.routeDepth - 1);
        const h = C(n).split("/");
        h && h.length && localStorage.setItem(
          "".concat(this.storagePrefix, "_").concat(i, "_").concat(h[h.length - 1]),
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
    var a;
    if (this.state.hideEditItem)
      return;
    const e = (a = this.view.layoutPanel) == null ? void 0 : a.panelItems.view_form;
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
    const { navigateContexts: e, navigateParams: a } = t, s = {
      navContexts: e,
      navParams: a
    }, i = {
      context: this.context,
      params: this.params,
      data: this.getData()[0]
    }, { resultContext: o, resultParams: n } = _(s, i), c = Object.assign(this.context.clone(), o), h = { ...this.params, ...n };
    return { context: c, params: h };
  }
  /**
   * 打开导航占位视图
   *
   * @param {IDEDRBarItem} drBarItem 关系项
   * @memberof DRBarExController
   */
  async openNavPosView(t, e = !1) {
    var i;
    const { context: a, params: s } = this.prepareParams(t);
    Object.assign(a, {
      srfdefaulttoroutedepth: this.routeDepth + 1
    }), a.currentSrfNav = t.dedrbarGroupId, this.state.srfnav = t.dedrbarGroupId, (i = this.navPos) == null || i.openView({
      key: t.id,
      context: a,
      params: s,
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
    const a = this.context.srfuserid;
    if (a) {
      const o = u(this.router.currentRoute.value);
      if (this.routeDepth && o.pathNodes[this.routeDepth - 2]) {
        o.pathNodes = o.pathNodes.slice(0, this.routeDepth - 1);
        const c = C(o).split("/");
        if (c && c.length) {
          const h = localStorage.getItem(
            "".concat(this.storagePrefix, "_").concat(a, "_").concat(c[c.length - 1])
          );
          h && (e = h);
        }
      }
    }
    const s = u(this.router.currentRoute.value);
    if (this.routeDepth && s.pathNodes[this.routeDepth - 1]) {
      const o = s.pathNodes[this.routeDepth - 1];
      o && o.srfnav && (e = o.srfnav);
    }
    if (e) {
      const o = !!this.routeDepth && w(this.routeDepth), { visible: n, defaultVisibleItem: c } = this.getItemVisibleState(e);
      !n && c ? (e = c.tag, this.handleSelectChange(e)) : this.handleSelectChange(e, o), this.state.defaultItem = e;
    }
  }
  /**
   * 路由变更处理回调
   * @param {{ srfnav?: string; path: string }} info 当前系统的路由的从一级到最后一级的所有路径。
   */
  async onRouterChange(t) {
    if (this.state.srfnav !== t.srfnav && t.srfnav) {
      this.state.srfnav = t.srfnav;
      const e = !!this.routeDepth && w(this.routeDepth);
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
      const a = u(this.router.currentRoute.value);
      this.routeDepth && (a.pathNodes = a.pathNodes.slice(0, this.routeDepth - 1));
      const s = C(a);
      this.counter = await A.getCounterByRef(
        e,
        this.context,
        s ? { srfcustomtag: s, ...this.params } : { ...this.params }
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
function F(l) {
  return typeof l == "function" || Object.prototype.toString.call(l) === "[object Object]" && !K(l);
}
function W(l) {
  const r = l.view.modal.routeDepth;
  if (r) {
    const t = y();
    let e;
    O(({
      currentKey: a,
      fullPath: s
    }) => {
      if (!e)
        e = a;
      else if (e === a) {
        const i = u(t), {
          srfnav: o
        } = i.pathNodes[r - 1];
        l.onRouterChange({
          srfnav: o || "",
          path: s
        });
      }
    }, r);
  }
}
const P = /* @__PURE__ */ L({
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
  setup(l) {
    const r = G((...n) => new k(...n)), t = M("control-".concat(r.model.controlType.toLowerCase(), "-ex")), e = U(), a = $({}), s = (n) => {
      Object.assign(a, n);
    };
    r.evt.on("onCreated", () => {
      r.counter && r.counter.onChange(s, !0);
    }), z(() => {
      var n;
      (n = r.counter) == null || n.offChange(s);
    }), r.setRouter(e);
    const i = y();
    return W(r), q(() => e.currentRoute.value, (n, c) => {
      var h, d;
      if (r.routeDepth && r.navPos) {
        const {
          pathNodes: f
        } = u(n), {
          pathNodes: p
        } = u(c), m = S(c, r.routeDepth + 1), v = S(i, r.routeDepth + 1);
        if (m === v)
          return;
        const b = ((h = f[r.routeDepth + 1]) == null ? void 0 : h.viewName) === "route-modal" || ((d = p[r.routeDepth + 1]) == null ? void 0 : d.viewName) === "route-modal";
        v && !b && r.navPos.openView({
          key: v,
          isRoutePushed: !1,
          context: r.context.clone(),
          params: {
            ...r.params
          }
        });
      }
    }), {
      c: r,
      ns: t,
      counterData: a,
      handleSelect: (n) => {
        var d, f, p;
        if (!r.state.drBarItems.find((m) => m.tag === n))
          return;
        const h = (d = r.model.dedrctrlItems) == null ? void 0 : d.find((m) => m.dedrbarGroupId === n);
        if (h) {
          const v = (f = u(i).pathNodes[r.routeDepth]) == null ? void 0 : f.viewName, b = (p = h.appViewId) == null ? void 0 : p.split(".")[1];
          if (b && v && b === v)
            return;
        }
        r.handleSelectChange(n);
      }
    };
  },
  render() {
    let l;
    const {
      isCreated: r,
      drBarItems: t,
      defaultItem: e,
      isCalculatedPermission: a
    } = this.c.state;
    return I(D("iBizControlBase"), {
      controller: this.c,
      class: this.ns.b()
    }, {
      default: () => [r && a && !!e && I(D("el-tabs"), {
        modelValue: e,
        onTabClick: (s, i) => {
          this.handleSelect(s.paneName);
        }
      }, F(l = t.map((s) => {
        if (s.visible)
          return I(D("el-tab-pane"), {
            label: s.caption,
            name: s.tag
          }, {
            label: () => I("span", {
              class: this.ns.b("pane-label")
            }, [I("span", {
              class: this.ns.be("pane-label", "text")
            }, [s.caption || ""]), s.counterId && this.counterData[s.counterId] != null && I(D("iBizBadge"), {
              class: this.ns.be("pane-label", "counter"),
              value: this.counterData[s.counterId],
              counterMode: s.counterMode
            }, null)])
          });
      })) ? l : {
        default: () => [l]
      })]
    });
  }
});
class X {
  constructor() {
    g(this, "component", "IBizDRBarExControl");
  }
}
const H = T(
  P,
  function(l) {
    l.component(P.name, P), j("CUSTOM_DRBAR_EX", () => new X());
  }
), et = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(l) {
    l.use(H);
  }
};
export {
  k as DRBarExController,
  H as IBizDRBarExControl,
  et as default
};
