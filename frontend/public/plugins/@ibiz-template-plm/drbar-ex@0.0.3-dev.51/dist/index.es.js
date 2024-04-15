var R = Object.defineProperty;
var w = (o, e, t) => e in o ? R(o, e, { enumerable: !0, configurable: !0, writable: !0, value: t }) : o[e] = t;
var v = (o, e, t) => (w(o, typeof e != "symbol" ? e + "" : e, t), t);
import { ControlController as B, Srfuf as x, calcNavParams as N, hasSubRoute as D, registerControlProvider as S } from "@ibiz-template/runtime";
import { route2routePath as p, useControlController as y, useNamespace as E, getNestedRoutePath as C, onRouteChange as V, withInstall as G } from "@ibiz-template/vue3-util";
import { defineComponent as j, watch as O, createVNode as I, resolveComponent as g, isVNode as A } from "vue";
import { useRouter as T, useRoute as b } from "vue-router";
class _ extends B {
  constructor() {
    super(...arguments);
    /**
     * Router 对象
     *
     * @type {Router}
     * @memberof DRTabController
     */
    v(this, "router");
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
    return this.view.getController("form");
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
    await super.onCreated(), this.initDRBarItems();
  }
  /**
   * 加载完成
   *
   * @return {*}  {Promise<void>}
   * @memberof DRBarExController
   */
  async onMounted() {
    await super.onMounted(), this.form && this.form.evt.on("onLoadSuccess", () => {
      this.doDefaultSelect();
    }), this.form.state.isLoaded && this.doDefaultSelect();
  }
  /**
   * 初始化关系项数据
   *
   * @memberof DRBarExController
   */
  initDRBarItems() {
    const { dedrctrlItems: t, dedrbarGroups: s } = this.model, a = [];
    s && t && s.forEach((n) => {
      if (t.filter(
        (i) => i.dedrbarGroupId === n.id
      ).length > 0) {
        let i = n.caption;
        n.capLanguageRes && (i = ibiz.i18n.t(
          n.capLanguageRes.lanResTag,
          n.caption
        )), a.push({
          tag: n.id,
          caption: i,
          sysImage: n.sysImage
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
  handleSelectChange(t, s = !1) {
    var r;
    if (!this.state.drBarItems.find((i) => i.tag === t))
      return;
    const n = (r = this.model.dedrctrlItems) == null ? void 0 : r.find(
      (i) => i.dedrbarGroupId === t
    );
    n ? (this.setVisible("navPos"), this.openNavPosView(n, s)) : (this.setVisible("form"), this.routeDepth && this.router.push(this.state.drBarItems[0].fullPath)), this.state.selectedItem = t, this.state.defaultItem = t;
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
    const s = (a = this.view.layoutPanel) == null ? void 0 : a.panelItems.view_form;
    t === "form" ? (s && (s.state.visible = !0, s.state.keepAlive = !0), this.navPos && (this.navPos.state.visible = !1, this.navPos.state.keepAlive = !0)) : (s && (s.state.visible = !1, s.state.keepAlive = !0), this.navPos && (this.navPos.state.visible = !0, this.navPos.state.keepAlive = !0));
  }
  /**
   * 准备参数
   *
   * @param {IDEDRBarItem} drBarItem 关系项
   * @return {*}
   * @memberof DRBarExController
   */
  prepareParams(t) {
    const { navigateContexts: s, navigateParams: a } = t, n = {
      navContexts: s,
      navParams: a
    }, r = {
      context: this.context,
      params: this.params,
      data: this.getData()[0]
    }, { resultContext: i, resultParams: u } = N(n, r), h = Object.assign(this.context.clone(), i), l = { ...this.params, ...u };
    return { context: h, params: l };
  }
  /**
   * 打开导航占位视图
   *
   * @param {IDEDRBarItem} drBarItem 关系项
   * @memberof DRBarExController
   */
  async openNavPosView(t, s = !1) {
    var r;
    const { context: a, params: n } = this.prepareParams(t);
    Object.assign(a, {
      srfdefaulttoroutedepth: this.routeDepth + 1
    }), a.currentSrfNav = t.dedrbarGroupId, this.state.srfnav = t.dedrbarGroupId, (r = this.navPos) == null || r.openView({
      key: t.id,
      context: a,
      params: n,
      viewId: t.appViewId,
      isRoutePushed: s
    });
  }
  /**
   * 处理第一次的默认选中
   * @author lxm
   * @date 2023-12-11 05:38:30
   * @return {*}  {void}
   */
  doDefaultSelect() {
    var n;
    if (!this.state.hideEditItem && !this.state.srfnav)
      return;
    if (this.isCreate) {
      this.state.defaultItem = this.model.uniqueTag;
      return;
    }
    const { drBarItems: t } = this.state;
    let s = ((n = t[0].children) == null ? void 0 : n[0].tag) || t[0].tag;
    const a = p(this.router.currentRoute.value);
    if (this.routeDepth && a.pathNodes[this.routeDepth - 1]) {
      const r = a.pathNodes[this.routeDepth - 1];
      r && r.srfnav && (s = r.srfnav);
    }
    if (s) {
      const r = !!this.routeDepth && D(this.routeDepth);
      this.handleSelectChange(s, r), this.state.defaultItem = s;
    }
  }
  /**
   * 路由变更处理回调
   * @param {{ srfnav?: string; path: string }} info 当前系统的路由的从一级到最后一级的所有路径。
   */
  async onRouterChange(t) {
    if (this.state.srfnav !== t.srfnav && t.srfnav) {
      this.state.srfnav = t.srfnav;
      const s = !!this.routeDepth && D(this.routeDepth);
      this.handleSelectChange(t.srfnav, s), this.force(() => {
        this.state.defaultItem = t.srfnav;
      });
    }
  }
}
function z(o) {
  return typeof o == "function" || Object.prototype.toString.call(o) === "[object Object]" && !A(o);
}
function L(o) {
  const e = o.view.modal.routeDepth;
  if (e) {
    const t = b();
    let s;
    V(({
      currentKey: a,
      fullPath: n
    }) => {
      if (!s)
        s = a;
      else if (s === a) {
        const r = p(t), {
          srfnav: i
        } = r.pathNodes[e - 1];
        o.onRouterChange({
          srfnav: i || "",
          path: n
        });
      }
    }, e);
  }
}
const P = /* @__PURE__ */ j({
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
  setup(o) {
    const e = y((...r) => new _(...r)), t = E("control-".concat(e.model.controlType.toLowerCase(), "-ex")), s = T();
    e.setRouter(s);
    const a = b();
    return L(e), O(() => s.currentRoute.value, (r, i) => {
      var u, h;
      if (e.routeDepth && e.navPos) {
        const {
          pathNodes: l
        } = p(r), {
          pathNodes: f
        } = p(i), d = C(i, e.routeDepth + 1), c = C(a, e.routeDepth + 1);
        if (d === c)
          return;
        const m = ((u = l[e.routeDepth + 1]) == null ? void 0 : u.viewName) === "route-modal" || ((h = f[e.routeDepth + 1]) == null ? void 0 : h.viewName) === "route-modal";
        c && !m && e.navPos.openView({
          key: c,
          isRoutePushed: !1,
          context: e.context.clone(),
          params: {
            ...e.params
          }
        });
      }
    }), {
      c: e,
      ns: t,
      handleSelect: (r) => {
        var h, l, f;
        if (!e.state.drBarItems.find((d) => d.tag === r))
          return;
        const u = (h = e.model.dedrctrlItems) == null ? void 0 : h.find((d) => d.dedrbarGroupId === r);
        if (u) {
          const c = (l = p(a).pathNodes[e.routeDepth]) == null ? void 0 : l.viewName, m = (f = u.appViewId) == null ? void 0 : f.split(".")[1];
          if (m && c && m === c)
            return;
        }
        e.handleSelectChange(r);
      }
    };
  },
  render() {
    let o;
    const {
      isCreated: e,
      drBarItems: t,
      defaultItem: s
    } = this.c.state;
    return I(g("iBizControlBase"), {
      controller: this.c,
      class: this.ns.b()
    }, {
      default: () => [e && !!s && I(g("el-tabs"), {
        modelValue: s,
        onTabClick: (a, n) => {
          this.handleSelect(a.paneName);
        }
      }, z(o = t.map((a) => I(g("el-tab-pane"), {
        label: a.caption,
        name: a.tag
      }, null))) ? o : {
        default: () => [o]
      })]
    });
  }
});
class M {
  constructor() {
    v(this, "component", "IBizDRBarExControl");
  }
}
const q = G(
  P,
  function(o) {
    o.component(P.name, P), S("CUSTOM_DRBAR_EX", () => new M());
  }
), X = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(o) {
    o.use(q);
  }
};
export {
  _ as DRBarExController,
  q as IBizDRBarExControl,
  X as default
};
