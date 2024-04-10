var b = Object.defineProperty;
var R = (o, s, t) => s in o ? b(o, s, { enumerable: !0, configurable: !0, writable: !0, value: t }) : o[s] = t;
var m = (o, s, t) => (R(o, typeof s != "symbol" ? s + "" : s, t), t);
import { ControlController as w, Srfuf as B, calcNavParams as N, hasSubRoute as D, registerControlProvider as S } from "@ibiz-template/runtime";
import { route2routePath as c, useControlController as x, useNamespace as y, getNestedRoutePath as E, onRouteChange as V, withInstall as G } from "@ibiz-template/vue3-util";
import { defineComponent as j, watch as O, createVNode as v, resolveComponent as I, isVNode as A } from "vue";
import { useRouter as T, useRoute as C } from "vue-router";
class _ extends w {
  constructor() {
    super(...arguments);
    /**
     * Router 对象
     *
     * @type {Router}
     * @memberof DRTabController
     */
    m(this, "router");
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
    return this.getData()[0].srfuf !== B.UPDATE;
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
    const { dedrctrlItems: t, dedrbarGroups: e } = this.model, a = [];
    e && t && e.forEach((i) => {
      if (t.filter(
        (n) => n.dedrbarGroupId === i.id
      ).length > 0) {
        let n = i.caption;
        i.capLanguageRes && (n = ibiz.i18n.t(
          i.capLanguageRes.lanResTag,
          i.caption
        )), a.push({
          tag: i.id,
          caption: n,
          sysImage: i.sysImage
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
    var r;
    if (!this.state.drBarItems.find((n) => n.tag === t))
      return;
    const i = (r = this.model.dedrctrlItems) == null ? void 0 : r.find(
      (n) => n.dedrbarGroupId === t
    );
    i ? (this.setVisible("navPos"), this.openNavPosView(i, e)) : (this.setVisible("form"), this.routeDepth && this.router.push(this.state.drBarItems[0].fullPath)), this.state.selectedItem = t, this.state.defaultItem = t;
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
    const { navigateContexts: e, navigateParams: a } = t, i = {
      navContexts: e,
      navParams: a
    }, r = {
      context: this.context,
      params: this.params,
      data: this.getData()[0]
    }, { resultContext: n, resultParams: u } = N(i, r), h = Object.assign(this.context.clone(), n), d = { ...this.params, ...u };
    return { context: h, params: d };
  }
  /**
   * 打开导航占位视图
   *
   * @param {IDEDRBarItem} drBarItem 关系项
   * @memberof DRBarExController
   */
  async openNavPosView(t, e = !1) {
    var r;
    const { context: a, params: i } = this.prepareParams(t);
    Object.assign(a, {
      srfdefaulttoroutedepth: this.routeDepth + 1
    }), a.currentSrfNav = t.dedrbarGroupId, this.state.srfnav = t.dedrbarGroupId, (r = this.navPos) == null || r.openView({
      key: t.id,
      context: a,
      params: i,
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
    const a = c(this.router.currentRoute.value);
    if (this.routeDepth && a.pathNodes[this.routeDepth - 1]) {
      const r = a.pathNodes[this.routeDepth - 1];
      r && r.srfnav && (e = r.srfnav);
    }
    if (e) {
      const r = !!this.routeDepth && D(this.routeDepth);
      this.handleSelectChange(e, r), this.state.defaultItem = e;
    }
  }
  /**
   * 路由变更处理回调
   * @param {{ srfnav?: string; path: string }} info 当前系统的路由的从一级到最后一级的所有路径。
   */
  async onRouterChange(t) {
    if (this.state.srfnav !== t.srfnav && t.srfnav) {
      this.state.srfnav = t.srfnav;
      const e = !!this.routeDepth && D(this.routeDepth);
      this.handleSelectChange(t.srfnav, e), this.force(() => {
        this.state.defaultItem = t.srfnav;
      });
    }
  }
}
function z(o) {
  return typeof o == "function" || Object.prototype.toString.call(o) === "[object Object]" && !A(o);
}
function L(o) {
  const s = o.view.modal.routeDepth;
  if (s) {
    const t = C();
    let e;
    V(({
      currentKey: a,
      fullPath: i
    }) => {
      if (!e)
        e = a;
      else if (e === a) {
        const r = c(t), {
          srfnav: n
        } = r.pathNodes[s - 1];
        o.onRouterChange({
          srfnav: n || "",
          path: i
        });
      }
    }, s);
  }
}
const g = /* @__PURE__ */ j({
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
    const s = x((...r) => new _(...r)), t = y("control-".concat(s.model.controlType.toLowerCase(), "-ex")), e = T();
    s.setRouter(e);
    const a = C();
    return L(s), O(() => e.currentRoute.value, (r, n) => {
      var u, h;
      if (s.routeDepth && s.navPos) {
        const {
          pathNodes: d
        } = c(r), {
          pathNodes: p
        } = c(n), l = E(a, s.routeDepth + 1), f = ((u = d[s.routeDepth + 1]) == null ? void 0 : u.viewName) === "route-modal" || ((h = p[s.routeDepth + 1]) == null ? void 0 : h.viewName) === "route-modal";
        l && !f && s.navPos.openView({
          key: l,
          isRoutePushed: !1
        });
      }
    }), {
      c: s,
      ns: t,
      handleSelect: (r) => {
        var h, d, p;
        if (!s.state.drBarItems.find((l) => l.tag === r))
          return;
        const u = (h = s.model.dedrctrlItems) == null ? void 0 : h.find((l) => l.dedrbarGroupId === r);
        if (u) {
          const f = (d = c(a).pathNodes[s.routeDepth]) == null ? void 0 : d.viewName, P = (p = u.appViewId) == null ? void 0 : p.split(".")[1];
          if (P && f && P === f)
            return;
        }
        s.handleSelectChange(r);
      }
    };
  },
  render() {
    let o;
    const {
      isCreated: s,
      drBarItems: t,
      defaultItem: e
    } = this.c.state;
    return v(I("iBizControlBase"), {
      controller: this.c,
      class: this.ns.b()
    }, {
      default: () => [s && !!e && v(I("el-tabs"), {
        modelValue: e,
        onTabClick: (a, i) => {
          this.handleSelect(a.paneName);
        }
      }, z(o = t.map((a) => v(I("el-tab-pane"), {
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
    m(this, "component", "IBizDRBarExControl");
  }
}
const q = G(
  g,
  function(o) {
    o.component(g.name, g), S("CUSTOM_DRBAR_EX", () => new M());
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
