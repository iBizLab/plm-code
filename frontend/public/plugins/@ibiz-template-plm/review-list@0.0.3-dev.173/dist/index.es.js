import './style.css';
var x = Object.defineProperty;
var F = (r, e, t) => e in r ? x(r, e, { enumerable: !0, configurable: !0, writable: !0, value: t }) : r[e] = t;
var g = (r, e, t) => (F(r, typeof e != "symbol" ? e + "" : e, t), t);
import { ListController as E, registerControlProvider as N, ControlType as j } from "@ibiz-template/runtime";
import { useNamespace as A, useControlController as $, withInstall as O } from "@ibiz-template/vue3-util";
import { defineComponent as S, createVNode as n, ref as M, computed as q, resolveComponent as d, isVNode as Z, withDirectives as _, resolveDirective as G, createTextVNode as z } from "vue";
import { isArray as H, isNil as J } from "lodash-es";
import { RuntimeError as Q } from "@ibiz-template/core";
function W(r) {
  function e(i) {
    !i || i === r.state.curPage || (r.state.curPage = i, r.load());
  }
  function t(i) {
    !i || i === r.state.size || (r.state.size = i, r.state.curPage === 1 && r.load());
  }
  function o() {
    r.load();
  }
  return { onPageChange: e, onPageSizeChange: t, onPageRefresh: o };
}
const h = class h {
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
        const l = e.split("").find((u) => /[a-zA-Z]/.test(u)) || "", m = e.split("").find((u) => /[\u4E00-\u9FA5]/.test(u)) || "";
        return "".concat(l).concat(m).toLowerCase();
      }
      return /[a-zA-Z]/.test(e) ? e.split("").filter((l) => /[a-zA-Z]/.test(l)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(e) ? e.split("").filter((l) => /[\u4E00-\u9FA5]/.test(l)).slice(-2).join("") : e.replaceAll(" ", "").substring(0, 2);
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
g(h, "calcColorPhoto", (e) => {
  if (!e)
    return "";
  let t = 0;
  for (let f = 0; f < e.length; f++)
    if (h.isChineseChart(e))
      t = e.charCodeAt(f) + ((t << 5) - t), t = t & t;
    else {
      const b = e.charCodeAt(f);
      t += b.toString(16);
    }
  const o = String(t).substring(0, 6);
  let i = parseInt(o.substring(0, 2), 16), l = parseInt(o.substring(2, 4), 16), m = parseInt(o.substring(4, 6), 16);
  i < 0 && (i = 10), l < 0 && (l = 10), m < 0 && (m = 10);
  const u = "#".concat(i.toString(16).padStart(2, "0")).concat(l.toString(16).padStart(2, "0")).concat(m.toString(16).padStart(2, "0"));
  return u === "#FFFFFF" && h.getThemeVar() || u;
});
let p = h;
const K = /* @__PURE__ */ S({
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
    const e = A("custom-avatar");
    return {
      ns: e,
      renderAvatar: () => r.img ? n("img", {
        class: e.e("user-avatar"),
        src: r.img
      }, null) : n("div", {
        class: e.e("default-avatar"),
        style: "background-color: ".concat(p.calcColorPhoto(r.label))
      }, [p.calcTextPhoto(r.label)])
    };
  },
  render() {
    return n("div", {
      class: this.ns.b()
    }, [this.renderAvatar()]);
  }
});
class U extends E {
  constructor() {
    super(...arguments);
    /**
     * 头像属性
     *
     * @type {string}
     * @memberof ReviewListController
     */
    g(this, "avatarField", "avatar");
    /**
     * 用户信息
     *
     * @public
     * @type {IData}
     * @memberof ReviewListController
     */
    g(this, "userInfo");
  }
  async onCreated() {
    var t;
    await super.onCreated();
    try {
      const o = ((t = ibiz.appData) == null ? void 0 : t.context) || {}, { srfusername: i = "游客", srfpersonname: l } = o;
      this.userInfo = { srfusername: i, srfpersonname: l }, this.avatarField && o[this.avatarField] && Object.assign(this.userInfo, {
        avatar: this.parseAvatar(o[this.avatarField])
      });
    } catch (o) {
      ibiz.log.error(o);
    }
  }
  /**
   * 解析头像数据
   *
   * @param {string} avatar
   * @return {string | undefined}
   * @memberof ReviewListController
   */
  parseAvatar(t) {
    try {
      const o = JSON.parse(t);
      if (o) {
        const i = H(o) ? o[0] : o;
        return ibiz.util.file.calcFileUpDownUrl(
          this.context,
          this.params
        ).downloadUrl.replace("%fileId%", i.id);
      }
    } catch (o) {
      throw new Q("头像数据解析异常");
    }
  }
}
function B(r) {
  return typeof r == "function" || Object.prototype.toString.call(r) === "[object Object]" && !Z(r);
}
const X = () => n("svg", {
  viewBox: "0 0 16 16",
  xmlns: "http://www.w3.org/2000/svg",
  height: "1em",
  width: "1em",
  focusable: "false",
  fill: "rgb(255, 117, 117)"
}, [n("g", {
  "stroke-width": "1",
  "fill-rule": "evenodd"
}, [n("path", {
  d: "M0 8c0-4.4 3.6-8 8-8s8 3.6 8 8-3.6 8-8 8-8-3.6-8-8zm6-3a1 1 0 0 0-1 1v4a1 1 0 0 0 1 1h4a1 1 0 0 0 1-1V6a1 1 0 0 0-1-1H6z"
}, null)])]), Y = () => n("svg", {
  viewBox: "0 0 16 16",
  xmlns: "http://www.w3.org/2000/svg",
  height: "1em",
  width: "1em",
  focusable: "false"
}, [n("g", {
  id: "arrtips/play-circle-fill",
  "stroke-width": "1",
  "fill-rule": "evenodd"
}, [n("path", {
  d: "M0 8c0-4.4 3.6-8 8-8s8 3.6 8 8-3.6 8-8 8-8-3.6-8-8zm11.26.432a.5.5 0 0 0 0-.864l-4.508-2.63A.5.5 0 0 0 6 5.372v5.258a.5.5 0 0 0 .752.432l4.508-2.63z"
}, null)])]), C = /* @__PURE__ */ S({
  name: "IBizReviewListControl",
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
    /**
     * 部件行数据默认激活模式
     * - 0 不激活
     * - 1 单击激活
     * - 2 双击激活(默认值)
     *
     * @type {(number | 0 | 1 | 2)}
     */
    mdctrlActiveMode: {
      type: Number,
      default: void 0
    },
    /**
     * 是否为单选
     * - true 单选
     * - false 多选
     *
     * @type {(Boolean)}
     */
    singleSelect: {
      type: Boolean,
      default: void 0
    },
    isSimple: {
      type: Boolean,
      required: !1
    },
    loadDefault: {
      type: Boolean,
      default: !0
    }
  },
  setup(r) {
    const e = $((...a) => new U(...a)), t = A("control-review-".concat(e.model.controlType.toLowerCase())), o = M(0), {
      onPageChange: i,
      onPageRefresh: l,
      onPageSizeChange: m
    } = W(e), u = q(() => e.model.enablePagingBar === !0 ? !0 : e.state.items.length >= e.state.total || e.state.isLoading || e.state.total <= e.state.size), f = () => n("div", {
      class: t.b("custom-item")
    }, [n("div", {
      class: t.be("custom-item", "icon")
    }, [Y()]), n("div", {
      class: t.be("custom-item", "caption")
    }, [z("提交评审")]), n("div", {
      class: t.be("custom-item", "avatar")
    }, [Number(o.value) > 2 ? n(K, {
      label: e.userInfo.srfusername,
      img: e.userInfo.avatar,
      readOnly: !0
    }, null) : ""])]), b = () => n("div", {
      class: [t.b("custom-item"), t.is("last-item", !0)]
    }, [n("div", {
      class: t.be("custom-item", "icon")
    }, [X()]), n("div", {
      class: t.be("custom-item", "caption")
    }, [z("完成评审")])]), w = () => n("div", {
      class: t.b("dropdown-arrow"),
      style: ""
    }, [n("div", {
      class: t.be("dropdown-arrow", "vertical-line")
    }, null), n("div", {
      class: t.be("dropdown-arrow", "arrow-down")
    }, null)]), y = (a, s) => {
      const {
        context: c,
        params: v
      } = e, T = e.state.selectedData.findIndex((k) => k.srfkey === a.srfkey), R = [t.b("item"), t.is("active", T !== -1)];
      return n(d("iBizControlShell"), {
        class: R,
        data: a,
        modelData: s,
        context: c,
        params: v,
        onClick: () => e.onRowClick(a),
        onDblclick: () => e.onDbRowClick(a)
      }, null);
    }, P = (a) => {
      const s = e.state.selectedData.findIndex((v) => v.srfkey === a.srfkey), c = [t.b("item"), t.is("active", s !== -1)];
      return n("div", {
        class: c,
        key: a.srfkey,
        onClick: () => e.onRowClick(a),
        onDblclick: () => e.onDbRowClick(a)
      }, ["".concat(J(a.srfmajortext) ? "" : a.srfmajortext)]);
    }, D = (a) => {
      const s = r.modelData.itemLayoutPanel;
      return n(d("el-collapse-item"), {
        title: a.caption,
        class: t.be("group-content", "item")
      }, {
        default: () => [a.children.length > 0 ? a.children.map((c) => s ? y(c, s) : P(c)) : n("div", {
          class: t.bem("group-content", "item", "empty")
        }, [ibiz.i18n.t("app.noData")])]
      });
    }, I = () => {
      if (e.model.enableGroup && !e.state.isSimple)
        return n(d("el-collapse"), {
          class: [t.b("group-content"), t.b("content")]
        }, {
          default: () => {
            var s;
            return [(s = e.state.groups) == null ? void 0 : s.map((c) => n("div", {
              class: [t.b("scroll-item")]
            }, [D(c)]))];
          }
        });
      const a = r.modelData.itemLayoutPanel;
      return _(n("div", {
        class: [t.b("scroll"), t.b("content")],
        "infinite-scroll-distance": 10,
        "infinite-scroll-disabled": u.value
      }, [f(), w(), e.state.items.map((s) => n("div", {
        class: [t.b("scroll-item")]
      }, [a ? y(s, a) : P(s), w()])), b()]), [[G("infinite-scroll"), () => e.loadMore()]]);
    }, L = () => {
      var s;
      const a = (s = e.model.controls) == null ? void 0 : s.find((c) => c.name === "".concat(e.model.name, "_quicktoolbar"));
      if (a)
        return n(d("iBizToolbarControl"), {
          modelData: a,
          context: e.context,
          params: e.params
        }, null);
    };
    return {
      c: e,
      ns: t,
      renderListContent: I,
      renderNoData: () => {
        let a;
        const {
          isLoaded: s
        } = e.state;
        if (s)
          return s && n(d("iBizNoData"), {
            class: t.b("content"),
            text: e.model.emptyText,
            emptyTextLanguageRes: e.model.emptyTextLanguageRes
          }, B(a = L()) ? a : {
            default: () => [a]
          });
      },
      renderBatchToolBar: () => {
        var s;
        const a = (s = e.model.controls) == null ? void 0 : s.find((c) => c.name === "".concat(e.model.name, "_batchtoolbar"));
        if (a)
          return n("div", {
            class: t.b("batchtoolbar")
          }, [n(d("iBizToolbarControl"), {
            modelData: a,
            context: e.context,
            params: e.params
          }, null)]);
      },
      onPageChange: i,
      onPageRefresh: l,
      onPageSizeChange: m
    };
  },
  render() {
    const {
      enablePagingBar: r
    } = this.c.model;
    let e = null;
    return this.c.state.isCreated && (e = [this.c.state.items.length > 0 ? this.renderListContent() : this.renderNoData(), this.renderBatchToolBar(), r ? n(d("iBizPagination"), {
      class: this.ns.e("pagination"),
      total: this.c.state.total,
      curPage: this.c.state.curPage,
      size: this.c.state.size,
      totalPages: this.c.state.totalPages,
      onChange: this.onPageChange,
      onPageSizeChange: this.onPageSizeChange,
      onPageRefresh: this.onPageRefresh
    }, null) : null]), n(d("iBizControlBase"), {
      class: [this.ns.is("enable-page", !!r)],
      controller: this.c
    }, B(e) ? e : {
      default: () => [e]
    });
  }
});
class V {
  constructor() {
    g(this, "component", "IBizReviewListControl");
  }
}
const ee = O(
  C,
  function(r) {
    r.component(C.name, C), N(
      "".concat(j.LIST, "_RENDER_REVIEW_LIST"),
      () => new V()
    );
  }
), ce = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(r) {
    r.use(ee);
  }
};
export {
  ee as IBizReviewListControl,
  ce as default
};
