import './style.css';
var F = Object.defineProperty;
var E = (s, e, t) => e in s ? F(s, e, { enumerable: !0, configurable: !0, writable: !0, value: t }) : s[e] = t;
var a = (s, e, t) => (E(s, typeof e != "symbol" ? e + "" : e, t), t);
import { useNamespace as f, withInstall as P } from "@ibiz-template/vue3-util";
import { PanelItemController as S, registerPanelItemProvider as T, registerErrorViewProvider as z } from "@ibiz-template/runtime";
import { defineComponent as p, createVNode as r, h as w, resolveComponent as h, createTextVNode as I, inject as O, ref as U, onBeforeUnmount as B, onMounted as L, computed as j } from "vue";
import { useRouter as C, useRoute as x } from "vue-router";
import { NOOP as v, listenJSEvent as R, HttpError as D } from "@ibiz-template/core";
import { AppRouter as $ } from "@ibiz-template/vue3-components";
const l = class l {
  /**
   * 获取主题色
   *
   * @static
   * @return {*}
   * @memberof Util
   */
  static getThemeVar() {
    const e = document.documentElement;
    return e ? getComputedStyle(e).getPropertyValue("--ibiz-color-primary") : null;
  }
  /**
   * 是否为中文字符串
   *
   * @static
   * @param {string} char
   * @return {*}
   * @memberof Util
   */
  static isChineseChart(e) {
    return /[\u4E00-\u9FA5]/.test(e);
  }
  /**
   * 是否同时存在英文和中文
   *
   * @static
   * @param {string} str
   * @return {*}
   * @memberof Util
   */
  static hasChineseAndEnglish(e) {
    return /[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(e);
  }
  /**
   * 计算图片文字
   *
   * @static
   * @param {string} textVal
   * @return {*}
   * @memberof Util
   */
  static calcTextPhoto(e) {
    if (e && e.toString().length < 2)
      return e;
    if (e && e.toString().length >= 2) {
      if (this.hasChineseAndEnglish(e)) {
        const i = e.split("").find((c) => /[a-zA-Z]/.test(c)) || "", u = e.split("").find((c) => /[\u4E00-\u9FA5]/.test(c)) || "";
        return "".concat(i).concat(u).toLowerCase();
      }
      return /[a-zA-Z]/.test(e) ? e.split("").filter((i) => /[a-zA-Z]/.test(i)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(e) ? e.split("").filter((i) => /[\u4E00-\u9FA5]/.test(i)).slice(-2).join("") : e.replaceAll(" ", "").substring(0, 2);
    }
  }
};
/**
 * 计算图片颜色
 *
 * @static
 * @param {string} textVal
 * @memberof Util
 */
a(l, "calcColorPhoto", (e) => {
  if (!e)
    return "";
  let t = 0;
  for (let d = 0; d < e.length; d++)
    if (l.isChineseChart(e))
      t = e.charCodeAt(d) + ((t << 5) - t), t = t & t;
    else {
      const A = e.charCodeAt(d);
      t += A.toString(16);
    }
  const n = String(t).substring(0, 6);
  let o = parseInt(n.substring(0, 2), 16), i = parseInt(n.substring(2, 4), 16), u = parseInt(n.substring(4, 6), 16);
  o < 0 && (o = 10), i < 0 && (i = 10), u < 0 && (u = 10);
  const c = "#".concat(o.toString(16).padStart(2, "0")).concat(i.toString(16).padStart(2, "0")).concat(u.toString(16).padStart(2, "0"));
  return c === "#FFFFFF" && l.getThemeVar() || c;
});
let m = l;
const b = /* @__PURE__ */ p({
  name: "Avatar",
  props: {
    label: {
      type: String,
      required: !0
    },
    img: {
      type: String
    },
    readOnly: {
      type: Boolean,
      default: !1
    }
  },
  setup(s) {
    const e = f("custom-avatar");
    return {
      ns: e,
      renderAvatar: () => s.img ? r("img", {
        class: e.e("user-avatar"),
        src: s.img
      }, null) : r("div", {
        class: e.e("default-avatar"),
        style: "background-color: ".concat(m.calcColorPhoto(s.label))
      }, [m.calcTextPhoto(s.label)])
    };
  },
  render() {
    return r("div", {
      class: this.ns.b()
    }, [this.renderAvatar()]);
  }
});
const k = /* @__PURE__ */ p({
  name: "UserInfoPopover",
  props: {
    controller: {
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
    viewId: {
      type: String
    },
    modal: {
      type: Object
    }
  },
  setup(s) {
    const e = f("user-info-popover"), t = s.controller, n = () => [r("div", {
      class: e.e("header")
    }, [r("img", {
      src: "./assets/images/login-header.png"
    }, null)]), r("div", {
      class: e.e("content")
    }, [r("div", {
      class: e.em("content", "avatar-container")
    }, [r(b, {
      class: e.em("content", "avatar"),
      label: t.userInfo.srfusername
    }, null)]), r("div", {
      class: e.em("content", "info")
    }, [r("div", {
      class: "user-name"
    }, [t.userInfo.srfusername]), r("div", {
      class: "description"
    }, [t.userInfo.srfpersonname])])]), r(h("el-divider"), {
      class: e.e("divider"),
      "content-position": "center"
    }, null), r("div", {
      class: e.e("footer")
    }, [r(h("el-button"), {
      class: e.e("log-out"),
      onClick: () => t.onLogOut(),
      text: !0
    }, {
      default: () => [r(h("iBizIcon"), {
        class: e.em("log-out", "icon"),
        icon: {
          cssClass: "fa fa-sign-out"
        }
      }, null), r("span", {
        class: e.em("log-out", "text")
      }, [I("退出登录")])]
    })])];
    return {
      ns: e,
      renderContent: () => s.viewId ? w(h("IBizViewShell"), {
        context: s.context,
        params: s.params,
        viewId: s.viewId,
        modal: s.modal
      }) : n()
    };
  },
  render() {
    return r("div", {
      class: [this.ns.b()]
    }, [this.renderContent()]);
  }
});
class y extends S {
  constructor() {
    super(...arguments);
    /**
     * 路由
     *
     * @private
     * @memberof CustomUserInfoController
     */
    a(this, "router");
    /**
     * 气泡弹窗容器
     *
     * @private
     * @type {(IOverlayPopoverContainer | null)}
     * @memberof CustomUserInfoController
     */
    a(this, "overlay", null);
    /**
     * ctx
     *
     * @memberof CustomUserInfoController
     */
    a(this, "ctx", O("ctx", void 0));
    /**
     * 用户信息视图
     *
     * @private
     * @type {IViewConfig}
     * @memberof CustomUserInfoController
     */
    a(this, "userInfoView");
    /**
     * 用户信息
     *
     * @public
     * @type {IData}
     * @memberof CustomUserInfoController
     */
    a(this, "userInfo");
    /**
     * 监听函数
     *
     * @memberof CustomUserInfoController
     */
    a(this, "cleanup", v);
  }
  /**
   * 是否折叠
   *
   * @readonly
   * @memberof CustomUserInfoController
   */
  get isCollapse() {
    return this.panel.view.state.isCollapse;
  }
  /**
   * 菜单方向
   *
   * @readonly
   * @memberof CustomUserInfoController
   */
  get menuAlign() {
    var t;
    return (t = this.ctx) != null && t.view && this.ctx.view.model.mainMenuAlign || "LEFT";
  }
  /**
   * 初始化
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof CustomUserInfoController
   */
  async onInit() {
    var t;
    await super.onInit();
    try {
      const { srfusername: n = "游客", srfpersonname: o } = ((t = ibiz.appData) == null ? void 0 : t.context) || {};
      this.userInfo = { srfusername: n, srfpersonname: o }, this.userInfoView = await ibiz.hub.config.view.get("userinfocustomview");
    } catch (n) {
      ibiz.log.error(n);
    }
    this.cleanup = R(window, "keydown", (n) => {
      var o;
      n.keyCode === 27 && ((o = this.overlay) == null || o.dismiss());
    });
  }
  /**
   * 设置路由对象
   *
   * @param {Router} router
   * @memberof CustomUserInfoController
   */
  setRouter(t) {
    this.router = t;
  }
  /**
   * 登出
   *
   * @memberof CustomUserInfoController
   */
  async onLogOut() {
    var n;
    (n = this.overlay) == null || n.dismiss(), await ibiz.confirm.info({
      title: "退出登录",
      desc: "您确定要退出登录吗？"
    }) && await ibiz.hub.controller.logout() && (await this.router.push(
      "/login?ru=".concat(encodeURIComponent(
        window.location.hash.replace("#/", "/")
      ))
    ), ibiz.util.showAppLoading(), window.location.reload());
  }
  /**
   * 打开用户信息Popover
   *
   * @param {EventTarget} target
   * @memberof CustomUserInfoController
   */
  async openUserInfoPopover(t) {
    var n, o;
    return this.overlay = ibiz.overlay.createPopover(
      (i) => {
        var u;
        return w(k, {
          context: this.panel.context.clone(),
          params: this.panel.params,
          modal: i,
          controller: this,
          viewId: (u = this.userInfoView) == null ? void 0 : u.id
        });
      },
      void 0,
      {
        placement: this.menuAlign === "LEFT" ? "right-start" : "bottom",
        autoClose: !0,
        noArrow: !0,
        width: ((n = this.userInfoView) == null ? void 0 : n.width) || 320,
        height: (o = this.userInfoView) == null ? void 0 : o.height
      }
    ), await this.overlay.present(t), await this.overlay.onWillDismiss();
  }
  onDestroyed() {
    var t;
    this.cleanup !== v && this.cleanup(), (t = this.overlay) == null || t.dismiss();
  }
}
const g = /* @__PURE__ */ p({
  name: "CustomUserInfo",
  props: {
    modelData: {
      type: Object,
      required: !0
    },
    controller: {
      type: y,
      required: !0
    }
  },
  setup(s) {
    const e = f("custom-user-info"), t = s.controller, n = U({}), o = C();
    t.setRouter(o);
    const i = () => {
      t.openUserInfoPopover(n.value);
    };
    return B(() => {
      t.onDestroyed();
    }), {
      c: t,
      ns: e,
      userInfo: n,
      onOpenUserInfoPopover: i
    };
  },
  render() {
    return r("div", {
      ref: "userInfo",
      class: [this.ns.b(), this.ns.m(this.modelData.id), ...this.c.containerClass, this.ns.is("left", this.c.menuAlign === "LEFT"), this.ns.is("top", this.c.menuAlign === "TOP"), this.ns.is("collapse", this.c.isCollapse)],
      onClick: this.onOpenUserInfoPopover
    }, [r(b, {
      class: this.ns.e("avatar"),
      label: this.c.userInfo.srfusername,
      readOnly: !0
    }, null), !this.c.isCollapse && r("div", {
      class: this.ns.e("info")
    }, [r("div", {
      class: this.ns.em("info", "user-name")
    }, [this.c.userInfo.srfusername]), this.c.menuAlign === "LEFT" && r("div", {
      class: this.ns.em("info", "description")
    }, [this.c.userInfo.srfpersonname])])]);
  }
});
class q {
  constructor() {
    a(this, "component", "CustomUserInfo");
  }
  async createController(e, t, n) {
    const o = new y(e, t, n);
    return await o.init(), o;
  }
}
class N {
  handle(e) {
    if (e instanceof D && e.status === 403)
      return $.getRouter().push({
        name: "errorView2",
        params: { code: "403" }
      }), !0;
  }
}
const Z = /* @__PURE__ */ p({
  name: "IBizView403",
  setup() {
    const s = f("403-view"), e = C(), t = x(), n = async () => {
      await e.push("/"), window.location.reload();
    };
    L(() => ibiz.util.hiddenAppLoading());
    const o = j(() => t && !t.params.view1);
    return {
      ns: s,
      isTop: o,
      gotoIndexView: n
    };
  },
  render() {
    return r("div", {
      class: [this.ns.b(), this.ns.is("top", this.isTop)]
    }, [r("img", {
      class: this.ns.b("img"),
      src: "./assets/images/404.png"
    }, null), r("div", {
      class: this.ns.b("text")
    }, [r("div", {
      class: this.ns.be("text", "text1")
    }, [I("抱歉，您没有访问该页面的权限")])])]);
  }
}), H = P(
  g,
  function(s) {
    s.component(g.name, g), T(
      "CUSTOM_CUSTOM_AUTH_USERINFO",
      () => new q()
    );
  }
), Q = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(s) {
    s.use(H), ibiz.util.error.register(new N()), z("403", () => ({ component: Z }));
  }
};
export {
  H as IBizCustomUserInfo,
  Q as default
};
