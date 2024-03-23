import './style.css';
var R = Object.defineProperty;
var S = (e, l, t) => l in e ? R(e, l, { enumerable: !0, configurable: !0, writable: !0, value: t }) : e[l] = t;
var P = (e, l, t) => (S(e, typeof l != "symbol" ? l + "" : l, t), t);
import { ControlController as N, Srfuf as V, hasSubRoute as I, calcNavParams as E, CounterService as M, registerControlProvider as j } from "@ibiz-template/runtime";
import { defineComponent as F, reactive as L, onMounted as O, onBeforeMount as k, watch as B, createVNode as f, resolveComponent as b, isVNode as _ } from "vue";
import { getNestedRoutePath as C, useControlController as A, useNamespace as q, route2routePath as z } from "@ibiz-template/vue3-util";
import { useRouter as U, useRoute as X } from "vue-router";
class G {
  constructor() {
    P(this, "component", "TabExpSelect");
  }
}
class H extends N {
  constructor() {
    super(...arguments);
    /**
     * 计数器对象
     * @author lxm
     * @date 2024-01-18 05:12:35
     * @type {AppCounter}
     */
    P(this, "counter");
    /**
     * Router 对象
     *
     * @type {Router}
     * @memberof DRTabController
     */
    P(this, "router");
  }
  /**
   * 导航占位控制器
   *
   * @readonly
   * @memberof DRTabController
   */
  get navPos() {
    var t;
    return (t = this.view.layoutPanel) == null ? void 0 : t.panelItems.nav_pos;
  }
  /**
   * 表单部件
   *
   * @readonly
   * @memberof DRTabController
   */
  get form() {
    return this.view.getController("form");
  }
  /**
   * 路由层级
   *
   * @readonly
   * @type {(number | undefined)}
   * @memberof DRTabController
   */
  get routeDepth() {
    return this.view.modal.routeDepth;
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
   * 获取数据
   *
   * @return {*}  {IData[]}
   * @memberof DRTabController
   */
  getData() {
    var t;
    return ((t = this.form) == null ? void 0 : t.getData()) || [{}];
  }
  /**
   * 初始化state的属性
   *
   * @protected
   * @memberof DRTabController
   */
  initState() {
    super.initState(), this.state.drTabPages = [];
  }
  /**
   * 创建完成
   *
   * @return {*}  {Promise<void>}
   * @memberof DRTabController
   */
  async onCreated() {
    await super.onCreated(), await this.initCounter();
  }
  /**
   * 加载完成
   *
   * @return {*}  {Promise<void>}
   * @memberof DRTabController
   */
  async onMounted() {
    await super.onMounted(), this.form && (this.form.evt.on("onLoadSuccess", () => {
      this.handleFormChange();
    }), this.form.evt.on("onLoadDraftSuccess", () => {
      this.handleFormChange();
    }), this.form.evt.on("onSaveSuccess", () => {
      this.handleFormChange();
    })), this.initDRTabPages();
  }
  /**
   * 处理表单数据变更
   *
   * @memberof DRTabController
   */
  handleFormChange() {
    const t = this.getData()[0].srfuf !== V.UPDATE;
    this.setDRTabPagesState(this.state.drTabPages, t);
  }
  /**
   * 设置关系分页状态
   *
   * @param {IDRTabPagesState[]} drTabPages 关系分页
   * @param {boolean} disabled 禁用状态
   * @memberof DRTabController
   */
  setDRTabPagesState(t, a) {
    t.forEach((n) => {
      n.tag !== this.model.uniqueTag && (n.disabled = a);
    });
  }
  /**
   * 初始化关系分页数据
   *
   * @memberof DRTabController
   */
  initDRTabPages() {
    const {
      editItemCaption: t,
      editItemCapLanguageRes: a,
      hideEditItem: n,
      editItemSysImage: i,
      uniqueTag: c,
      dedrtabPages: p
    } = this.model, h = [];
    let o = t;
    a && (o = ibiz.i18n.t(a.lanResTag, t)), n || h.push({
      tag: c,
      caption: o,
      hidden: !!n,
      disabled: !1,
      sysImage: i,
      fullPath: this.routeDepth ? C(this.router.currentRoute.value, this.routeDepth) : ""
    }), p == null || p.forEach((s) => {
      let u = s.caption;
      s.capLanguageRes && (u = ibiz.i18n.t(s.capLanguageRes.lanResTag, s.caption)), h.push({
        tag: s.id,
        caption: u,
        sysImage: s.sysImage,
        hidden: !1,
        disabled: !1,
        counterId: s.counterId
      });
    }), this.state.drTabPages = h, this.view.state.srfnav ? this.state.activeName = this.view.state.srfnav : this.state.activeName = h[0].tag;
    const r = !!this.routeDepth && I(this.routeDepth);
    this.handleTabChange(r);
  }
  /**
   * 处理分页改变
   *
   * @author lxm
   * @date 2023-12-21 05:31:59
   * @param {boolean} [isRoutePushed=false] 是否是路由已经跳转过了
   */
  handleTabChange(t = !1) {
    var i;
    const { activeName: a } = this.state, n = (i = this.model.dedrtabPages) == null ? void 0 : i.find(
      (c) => c.id === a
    );
    n ? (this.setVisible("navPos"), this.openNavPosView(n, t)) : (this.setVisible("form"), this.routeDepth && this.router.push(this.state.drTabPages[0].fullPath));
  }
  /**
   * 设置显示状态
   *
   * @param {('form' | 'navPos')} ctrlName 显示的部件名称
   * @memberof DRTabController
   */
  setVisible(t) {
    var n;
    const a = (n = this.view.layoutPanel) == null ? void 0 : n.panelItems.view_form;
    t === "form" ? (a && (a.state.visible = !0, a.state.keepAlive = !0), this.navPos && (this.navPos.state.visible = !1, this.navPos.state.keepAlive = !0)) : (a && (a.state.visible = !1, a.state.keepAlive = !0), this.navPos && (this.navPos.state.visible = !0, this.navPos.state.keepAlive = !0));
  }
  /**
   * 准备参数
   *
   * @param {IDEDRCtrlItem} drTabPages 关系分页
   * @return {*}
   * @memberof DRTabController
   */
  prepareParams(t) {
    const { navigateContexts: a, navigateParams: n } = t, i = {
      navContexts: a,
      navParams: n
    }, c = {
      context: this.context,
      params: this.params,
      data: this.getData()[0]
    }, { resultContext: p, resultParams: h } = E(i, c), o = Object.assign(this.context.clone(), p, {
      currentSrfNav: t.id
    }), r = { ...this.params, ...h };
    return { context: o, params: r };
  }
  /**
   * 打开导航占位视图
   *
   * @author lxm
   * @date 2023-12-21 05:40:07
   * @param {IDEDRCtrlItem} drTabPages
   * @param {boolean} [isRoutePushed=false]
   * @return {*}  {Promise<void>}
   */
  async openNavPosView(t, a = !1) {
    var c;
    const { context: n, params: i } = this.prepareParams(t);
    (c = this.navPos) == null || c.openView({
      key: t.id,
      context: n,
      params: i,
      viewId: t.appViewId,
      isRoutePushed: a
    });
  }
  /**
   * 初始化计数器
   * @author lxm
   * @date 2024-01-18 05:12:02
   * @protected
   * @return {*}  {Promise<void>}
   */
  async initCounter() {
    const { appCounterRefs: t } = this.model, a = t == null ? void 0 : t[0];
    a && (this.counter = await M.getCounterByRef(
      a,
      this.context
    ));
  }
}
function J(e) {
  return typeof e == "function" || Object.prototype.toString.call(e) === "[object Object]" && !_(e);
}
const D = /* @__PURE__ */ F({
  name: "TabExpSelect",
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
    }
  },
  setup() {
    const e = A((...o) => new H(...o)), l = q("tab-exp-select"), t = U(), a = L({});
    e.evt.on("onCreated", () => {
      e.counter && e.counter.onChange((o) => {
        Object.assign(a, o);
      }, !0);
    }), e.setRouter(t);
    const n = () => {
      e.handleTabChange();
    }, i = X();
    let c = "";
    e.routeDepth && (c = C(i, e.routeDepth));
    const p = () => {
      var r, s;
      const o = (s = (r = e.view.layoutPanel) == null ? void 0 : r.panelItems.searchform) == null ? void 0 : s.control.getFilterParams();
      e.params = o, e.handleTabChange();
    }, h = () => {
      var r, s, u, v, m, g;
      const o = (r = e.model.dedrtabPages) == null ? void 0 : r.find((w) => w.id === e.state.activeName);
      if (o) {
        const T = (o.appViewId || "").split(".").pop(), y = (u = (s = e.view.layoutPanel) == null ? void 0 : s.panelItems.searchform) == null ? void 0 : u.control.getFilterParams();
        for (let x of e.view.ctx.controllersMap.keys())
          if (x.toLowerCase() === T) {
            const d = e.view.ctx.controllersMap.get(x);
            d && (d.params = y, d.engines[0].grid && d.engines[0].grid.load({
              isInitialLoad: !0
            }), (v = d.ctx) != null && v.controllersMap && ((m = d.ctx) != null && m.controllersMap.get("chart")) && ((g = d.ctx) == null || g.controllersMap.get("chart").load({
              isInitialLoad: !0
            })));
          }
      }
    };
    return O(() => {
      var o, r, s, u;
      (u = (s = (r = (o = e.view.layoutPanel) == null ? void 0 : o.panelItems.searchform) == null ? void 0 : r.control) == null ? void 0 : s.evt) == null || u.on("onFormDataChange", h);
    }), k(() => {
      var o, r, s;
      (s = (r = (o = e.view.layoutPanel) == null ? void 0 : o.panelItems.searchform) == null ? void 0 : r.evt) == null || s.off("onFormDataChange", h);
    }), B(() => i.fullPath, (o, r) => {
      if (o !== r) {
        const s = e.routeDepth;
        if (s && C(i, e.routeDepth) === c) {
          const v = z(i), {
            srfnav: m
          } = v.pathNodes[s - 1];
          if (m && e.state.activeName && e.state.activeName !== m) {
            e.state.activeName = m;
            const g = !!e.routeDepth && I(e.routeDepth);
            e.handleTabChange(g);
          }
        }
      }
    }, {
      immediate: !0
    }), {
      c: e,
      ns: l,
      valueChange: p,
      counterData: a,
      handleTabChange: n
    };
  },
  render() {
    let e;
    const {
      isCreated: l,
      drTabPages: t
    } = this.c.state;
    return f(b("iBizControlBase"), {
      controller: this.c,
      class: this.ns.b()
    }, {
      default: () => {
        var a, n;
        return [l && f("div", {
          class: this.ns.e("tabexp")
        }, [f("div", {
          class: this.ns.em("tabexp", "caption")
        }, [(n = (a = this.c.view.layoutPanel) == null ? void 0 : a.panelItems.tabexppanel) == null ? void 0 : n.model.caption]), f(b("el-select"), {
          modelValue: this.c.state.activeName,
          "onUpdate:modelValue": (i) => this.c.state.activeName = i,
          onChange: this.valueChange
        }, J(e = t.map((i) => f(b("el-option"), {
          key: i.tag,
          label: i.caption,
          value: i.tag
        }, null))) ? e : {
          default: () => [e]
        })])];
      }
    });
  }
}), $ = {
  install(e) {
    e.component(D.name, D), j(
      "CUSTOM_TAB_EXP_SELECT",
      () => new G()
    );
  }
};
export {
  $ as default
};
