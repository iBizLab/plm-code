import './style.css';
var T = Object.defineProperty;
var E = (r, e, t) => e in r ? T(r, e, { enumerable: !0, configurable: !0, writable: !0, value: t }) : r[e] = t;
var l = (r, e, t) => (E(r, typeof e != "symbol" ? e + "" : e, t), t);
import { useNamespace as f, withInstall as P } from "@ibiz-template/vue3-util";
import { PanelItemController as S, registerPanelItemProvider as O, registerErrorViewProvider as z } from "@ibiz-template/runtime";
import { defineComponent as p, createVNode as n, h as I, resolveComponent as h, createTextVNode as b, inject as U, ref as L, onBeforeUnmount as B, onMounted as R, computed as j } from "vue";
import { useRouter as C, useRoute as N } from "vue-router";
import { NOOP as v, listenJSEvent as x, RuntimeError as D, HttpError as V } from "@ibiz-template/core";
import { isArray as w } from "lodash-es";
import { AppRouter as $ } from "@ibiz-template/vue3-components";
const c = class c {
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
        const o = e.split("").find((u) => /[a-zA-Z]/.test(u)) || "", a = e.split("").find((u) => /[\u4E00-\u9FA5]/.test(u)) || "";
        return "".concat(o).concat(a).toLowerCase();
      }
      return /[a-zA-Z]/.test(e) ? e.split("").filter((o) => /[a-zA-Z]/.test(o)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(e) ? e.split("").filter((o) => /[\u4E00-\u9FA5]/.test(o)).slice(-2).join("") : e.replaceAll(" ", "").substring(0, 2);
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
l(c, "calcColorPhoto", (e) => {
  if (!e)
    return "";
  let t = 0;
  for (let d = 0; d < e.length; d++)
    if (c.isChineseChart(e))
      t = e.charCodeAt(d) + ((t << 5) - t), t = t & t;
    else {
      const F = e.charCodeAt(d);
      t += F.toString(16);
    }
  const s = String(t).substring(0, 6);
  let i = parseInt(s.substring(0, 2), 16), o = parseInt(s.substring(2, 4), 16), a = parseInt(s.substring(4, 6), 16);
  i < 0 && (i = 10), o < 0 && (o = 10), a < 0 && (a = 10);
  const u = "#".concat(i.toString(16).padStart(2, "0")).concat(o.toString(16).padStart(2, "0")).concat(a.toString(16).padStart(2, "0"));
  return u === "#FFFFFF" && c.getThemeVar() || u;
});
let m = c;
const y = /* @__PURE__ */ p({
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
  setup(r) {
    const e = f("custom-avatar");
    return {
      ns: e,
      renderAvatar: () => r.img ? n("img", {
        class: e.e("user-avatar"),
        src: r.img
      }, null) : n("div", {
        class: e.e("default-avatar"),
        style: "background-color: ".concat(m.calcColorPhoto(r.label))
      }, [m.calcTextPhoto(r.label)])
    };
  },
  render() {
    return n("div", {
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
  setup(r) {
    const e = f("user-info-popover"), t = r.controller, s = () => [n("div", {
      class: e.e("header")
    }, [n("img", {
      src: "./assets/images/login-header.png"
    }, null)]), n("div", {
      class: e.e("content")
    }, [n("div", {
      class: e.em("content", "avatar-container")
    }, [n(y, {
      class: e.em("content", "avatar"),
      label: t.userInfo.srfusername,
      img: t.userInfo.avatar
    }, null)]), n("div", {
      class: e.em("content", "info")
    }, [n("div", {
      class: "user-name"
    }, [t.userInfo.srfusername]), n("div", {
      class: "description"
    }, [t.userInfo.srfpersonname])])]), n(h("el-divider"), {
      class: e.e("divider"),
      "content-position": "center"
    }, null), n("div", {
      class: e.e("footer")
    }, [n(h("el-button"), {
      class: e.e("log-out"),
      onClick: () => t.onLogOut(),
      text: !0
    }, {
      default: () => [n(h("iBizIcon"), {
        class: e.em("log-out", "icon"),
        icon: {
          cssClass: "fa fa-sign-out"
        }
      }, null), n("span", {
        class: e.em("log-out", "text")
      }, [b("退出登录")])]
    })])];
    return {
      ns: e,
      renderContent: () => r.viewId ? I(h("IBizViewShell"), {
        context: r.context,
        params: r.params,
        viewId: r.viewId,
        modal: r.modal
      }) : s()
    };
  },
  render() {
    return n("div", {
      class: [this.ns.b()]
    }, [this.renderContent()]);
  }
});
class A extends S {
  constructor() {
    super(...arguments);
    /**
     * 弹框内导航视图名称
     *
     * @private
     * @memberof CustomUserInfoController
     */
    l(this, "navViewName", "");
    /**
     * 头像属性
     *
     * @type {string}
     * @memberof CustomUserInfoController
     */
    l(this, "avatarField", "");
    /**
     * 标题属性
     *
     * @type {string}
     * @memberof CustomUserInfoController
     */
    l(this, "titlField", "");
    /**
     * 子标题属性
     *
     * @type {string}
     * @memberof CustomUserInfoController
     */
    l(this, "subTitleField", "");
    /**
     * 路由
     *
     * @private
     * @memberof CustomUserInfoController
     */
    l(this, "router");
    /**
     * 气泡弹窗容器
     *
     * @private
     * @type {(IOverlayPopoverContainer | null)}
     * @memberof CustomUserInfoController
     */
    l(this, "overlay", null);
    /**
     * ctx
     *
     * @memberof CustomUserInfoController
     */
    l(this, "ctx", U("ctx", void 0));
    /**
     * 用户信息视图
     *
     * @private
     * @type {IViewConfig}
     * @memberof CustomUserInfoController
     */
    l(this, "userInfoView");
    /**
     * 用户信息
     *
     * @public
     * @type {IData}
     * @memberof CustomUserInfoController
     */
    l(this, "userInfo");
    /**
     * 监听函数
     *
     * @memberof CustomUserInfoController
     */
    l(this, "cleanup", v);
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
    await super.onInit(), this.initRawItemParams();
    try {
      const s = ((t = ibiz.appData) == null ? void 0 : t.context) || {}, { srfusername: i = "游客", srfpersonname: o } = s;
      this.userInfo = { srfusername: i, srfpersonname: o }, this.avatarField && s[this.avatarField] && Object.assign(this.userInfo, {
        avatar: this.parseAvatar(s[this.avatarField])
      }), this.titlField && s[this.titlField] && Object.assign(this.userInfo, {
        srfusername: s[this.titlField]
      }), this.subTitleField && s[this.subTitleField] && Object.assign(this.userInfo, {
        srfpersonname: s[this.subTitleField]
      }), this.userInfoView = await ibiz.hub.config.view.get(this.navViewName);
    } catch (s) {
      ibiz.log.error(s);
    }
    this.cleanup = x(window, "keydown", (s) => {
      var i;
      s.keyCode === 27 && ((i = this.overlay) == null || i.dismiss());
    });
  }
  /**
   * 解析头像数据
   *
   * @param {string} avatar
   * @return {*}
   * @memberof CustomUserInfoController
   */
  parseAvatar(t) {
    try {
      const s = JSON.parse(t);
      if (s) {
        const i = w(s) ? s[0] : s;
        return ibiz.util.file.calcFileUpDownUrl(
          this.panel.context,
          this.panel.params
        ).downloadUrl.replace("%fileId%", i.id);
      }
    } catch (s) {
      throw new D("头像数据解析异常");
    }
  }
  /**
   * 初始化面板项高级参数
   *
   * @memberof CustomUserInfoController
   */
  initRawItemParams() {
    var s;
    const t = (s = this.model) == null ? void 0 : s.rawItem;
    w(t == null ? void 0 : t.rawItemParams) && (t == null || t.rawItemParams.forEach((i) => {
      const { key: o, value: a } = i;
      o === "NAVVIEWNAME" && (this.navViewName = a), o === "AVATAR" && (this.avatarField = a.toLowerCase()), o === "TITLE" && (this.titlField = a.toLowerCase()), o === "SUBTITLE" && (this.subTitleField = a.toLowerCase());
    }));
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
    var s;
    (s = this.overlay) == null || s.dismiss(), await ibiz.confirm.info({
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
    var s, i;
    return this.overlay = ibiz.overlay.createPopover(
      (o) => {
        var a;
        return I(k, {
          context: this.panel.context.clone(),
          params: this.panel.params,
          modal: o,
          controller: this,
          viewId: (a = this.userInfoView) == null ? void 0 : a.id
        });
      },
      void 0,
      {
        placement: this.menuAlign === "LEFT" ? "right-start" : "bottom",
        autoClose: !0,
        noArrow: !0,
        width: ((s = this.userInfoView) == null ? void 0 : s.width) || 320,
        height: (i = this.userInfoView) == null ? void 0 : i.height
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
      type: A,
      required: !0
    }
  },
  setup(r) {
    const e = f("custom-user-info"), t = r.controller, s = L({}), i = C();
    t.setRouter(i);
    const o = () => {
      t.openUserInfoPopover(s.value);
    };
    return B(() => {
      t.onDestroyed();
    }), {
      c: t,
      ns: e,
      userInfo: s,
      onOpenUserInfoPopover: o
    };
  },
  render() {
    return n("div", {
      ref: "userInfo",
      class: [this.ns.b(), this.ns.m(this.modelData.id), ...this.c.containerClass, this.ns.is("left", this.c.menuAlign === "LEFT"), this.ns.is("top", this.c.menuAlign === "TOP"), this.ns.is("collapse", this.c.isCollapse)],
      onClick: this.onOpenUserInfoPopover
    }, [n(y, {
      class: this.ns.e("avatar"),
      label: this.c.userInfo.srfusername,
      img: this.c.userInfo.avatar,
      readOnly: !0
    }, null), !this.c.isCollapse && n("div", {
      class: this.ns.e("info")
    }, [n("div", {
      class: this.ns.em("info", "user-name")
    }, [this.c.userInfo.srfusername]), this.c.menuAlign === "LEFT" && n("div", {
      class: this.ns.em("info", "description")
    }, [this.c.userInfo.srfpersonname])])]);
  }
});
class q {
  constructor() {
    l(this, "component", "CustomUserInfo");
  }
  async createController(e, t, s) {
    const i = new A(e, t, s);
    return await i.init(), i;
  }
}
class M {
  handle(e) {
    if (e instanceof V && e.status === 403)
      return $.getRouter().push({
        name: "errorView2",
        params: { code: "403" }
      }), !0;
  }
}
const Z = /* @__PURE__ */ p({
  name: "IBizView403",
  setup() {
    const r = f("403-view"), e = C(), t = N(), s = async () => {
      await e.push("/"), window.location.reload();
    };
    R(() => ibiz.util.hiddenAppLoading());
    const i = j(() => t && !t.params.view1);
    return {
      ns: r,
      isTop: i,
      gotoIndexView: s
    };
  },
  render() {
    return n("div", {
      class: [this.ns.b(), this.ns.is("top", this.isTop)]
    }, [n("img", {
      class: this.ns.b("img"),
      src: "./assets/images/404.png"
    }, null), n("div", {
      class: this.ns.b("text")
    }, [n("div", {
      class: this.ns.be("text", "text1")
    }, [b("抱歉，您没有访问该页面的权限")])])]);
  }
}), H = P(
  g,
  function(r) {
    r.component(g.name, g), O(
      "CUSTOM_CUSTOM_AUTH_USERINFO",
      () => new q()
    );
  }
), ee = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(r) {
    r.use(H), ibiz.util.error.register(new M()), z("403", () => ({ component: Z }));
  }
};
export {
  H as IBizCustomUserInfo,
  ee as default
};
