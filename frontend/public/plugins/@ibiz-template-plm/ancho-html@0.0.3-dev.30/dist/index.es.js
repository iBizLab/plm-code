import './style.css';
var te = Object.defineProperty;
var se = (i, n, o) => n in i ? te(i, n, { enumerable: !0, configurable: !0, writable: !0, value: o }) : i[n] = o;
var C = (i, n, o) => (se(i, typeof n != "symbol" ? n + "" : n, o), o);
import { EditorController as ie, registerEditorProvider as ae } from "@ibiz-template/runtime";
import { defineComponent as B, ref as l, watch as V, createVNode as s, resolveComponent as P, nextTick as F, computed as ne } from "vue";
import { useNamespace as X, getRawProps as re, getEditorEmits as le } from "@ibiz-template/vue3-util";
import { createUUID as _ } from "qx-util";
const N = /* @__PURE__ */ B({
  name: "AnchoHtmlNavBar",
  props: {
    type: {
      type: String,
      required: !1
    },
    content: {
      type: [String, Object, Number]
    },
    rawItem: {
      type: Object,
      required: !1
    },
    title: {
      type: String
    }
  },
  setup(i) {
    const n = X("rawitem");
    let o = null, a = "";
    i.rawItem && (o = i.rawItem.rawItem, a = o.contentType);
    const h = l(i.type || a || ""), c = l("");
    let p = null;
    a === "IMAGE" && (p = o.sysImage), a === "RAW" || a === "HTML" ? a === "RAW" ? (h.value = "TEXT", c.value = o.caption) : c.value = o.content : ["VIDEO", "DIVIDER", "INFO", "WARNING", "ERROR"].includes(a) || a === "IMAGE" && p && (c.value = p);
    const d = (t) => /^https?:|^http?:|(\.png|\.svg|\.jpg|\.png|\.gif|\.psd|\.tif|\.bmp|\.jpeg)/.test(t), R = l({
      id: _(),
      path: "",
      mute: !0,
      autoplay: !0,
      replay: !1,
      showcontrols: !0
    }), T = l({
      contentPosition: "center",
      html: ""
    }), f = l({
      type: "info",
      title: "",
      closeabled: !0,
      showIcon: !1
    }), u = l(""), I = l(!1), g = l([]), m = l(""), v = l([]), E = l(0), A = l(!1);
    let y = [], w = [];
    const x = l(!1), D = () => {
      if (h.value === "IMAGE" && typeof i.content == "string" && (d(i.content) ? c.value = {
        imagePath: i.content
      } : c.value = {
        cssClass: i.content
      }), ["TEXT", "HEADING1", "HEADING2", "HEADING3", "HEADING4", "HEADING5", "HEADING6", "PARAGRAPH", "HTML", "RAW"].includes(h.value) && (u.value = c.value, typeof u.value == "string")) {
        const t = u.value;
        u.value = t.replace(/&lt;/g, "<").replace(/&gt;/g, ">").replace(/&amp;nbsp;/g, " ").replace(/&nbsp;/g, " ");
      }
      if (["VIDEO", "DIVIDER", "INFO", "WARNING", "ERROR"].includes(h.value) && c.value) {
        let t = {};
        try {
          if (typeof c.value == "string")
            switch (t = new Function("return (".concat(c.value, ");"))(), h.value) {
              case "VIDEO":
                Object.assign(R.value, t);
                break;
              case "DIVIDER":
                Object.assign(T.value, t);
                break;
              case "INFO":
              case "WARNING":
              case "ERROR":
                f.value.type = h.value.toLocaleLowerCase(), Object.assign(f.value, t);
                break;
              default:
                break;
            }
        } catch (e) {
          ibiz.log.error(ibiz.i18n.t("component.rawItem.errorConfig", {
            type: h.value
          }));
        }
      }
    }, U = () => {
      if (w.length === 0)
        return;
      let t = y.length;
      w.forEach((e) => {
        const r = y.indexOf(e);
        r > -1 && t > r && (t = r);
      }), m.value = y[t];
    }, L = new IntersectionObserver((t) => {
      t.forEach((e) => {
        if (e.isIntersecting)
          e.target && e.target.id && w.push(e.target.id);
        else if (e.target && e.target.id) {
          const r = w.indexOf(e.target.id);
          r >= 0 && w.splice(r, 1);
        }
      }), U();
    }), O = (t, e = 1) => {
      if (e > 6)
        return [t];
      const r = [], b = new RegExp("<h".concat(e, "[\\s\\S]*?>[\\s\\S]*?<\\/h").concat(e, ">"), "g"), ee = new RegExp("<h".concat(e, "[\\s\\S]*?>([\\s\\S]*?)<\\/h").concat(e, ">"), "g"), W = t.split(b), $ = t.match(ee) || [];
      $.length > 0 && (x.value = !0);
      for (let H = 0; H < W.length; H++) {
        const z = "title_".concat(_());
        y.push(z), r.push({
          id: z,
          title: $[H - 1],
          level: e,
          children: O(W[H], e + 1)
        });
      }
      return r;
    }, G = () => {
      var t;
      if (y = [], w = [], x.value = !1, g.value = [], v.value = [], h.value === "HTML" && u.value && typeof u.value == "string") {
        const e = ((t = u.value.match(/src="([^"]+)"/g)) == null ? void 0 : t.map((r) => r.slice(5, -1))) || [];
        v.value = e, g.value = O(u.value, 1);
      }
    }, M = (t) => {
      const e = document.getElementById(t);
      e && e.scrollIntoView({
        behavior: "smooth",
        block: "start"
      });
    }, J = () => {
      I.value = !I.value;
    }, S = (t) => t.map((e) => [e.title ? s("p", {
      id: e.id,
      innerHTML: e.title
    }, null) : null, e.children && e.children.length > 0 ? S(e.children) : s("p", {
      innerHTML: e,
      onClick: j
    }, null)]), K = (t) => {
      const e = />(.*?)</g;
      return (t.match(e) || []).map((b) => b.slice(1, -1)).join("");
    }, k = (t) => t.map((e) => s("div", {
      class: [n.bem("ancho", "title-item", "text")]
    }, [e.title ? s("p", {
      class: [n.bem("ancho", "title-item", "text-title"), n.bem("ancho", "title-item", "text-".concat(e.level)), n.is("ancho-select", m.value === e.id)],
      title: K(e.title),
      innerHTML: e.title,
      onClick: () => M(e.id)
    }, null) : null, e.children && e.children.length > 0 ? k(e.children) : null])), Y = (t) => {
      (t.key === "Escape" || t.keyCode === 27) && (A.value = !1, t.stopPropagation(), t.preventDefault());
    }, j = async (t) => {
      if (t && t.target instanceof HTMLElement && t.target.tagName === "IMG") {
        t.stopPropagation(), t.preventDefault();
        const e = t.target.getAttribute("src") || "";
        if (e) {
          const b = v.value.indexOf(e);
          E.value = b;
        }
        A.value = !0, await F();
        const r = document.querySelector(".el-image-viewer__wrapper");
        r && r.addEventListener("keydown", Y);
      }
    }, Q = () => {
      A.value = !1;
    }, Z = async () => {
      L.disconnect(), await F(), y.forEach((t) => {
        const e = document.querySelector("#".concat(t));
        e && L.observe(e);
      });
    };
    return D(), G(), V(() => i.content, (t, e) => {
      t !== e && (c.value = t, D(), G(), Z());
    }, {
      immediate: !0
    }), {
      ns: n,
      rawItemText: u,
      playerParams: R,
      dividerParams: T,
      alertParams: f,
      rawItemType: h,
      rawItemContent: c,
      htmlContent: g,
      isCollapse: I,
      previewSrcList: v,
      selectAncho: m,
      showImg: A,
      previewImgIndex: E,
      showTitle: x,
      jumpAncho: M,
      changeCollapse: J,
      renderHTMLContent: S,
      renderAnchoList: k,
      closeImgPreview: Q,
      imgClick: j
    };
  },
  render() {
    const i = () => this.rawItemType === "IMAGE" ? s(P("i-biz-icon"), {
      class: [this.ns.e("image")],
      icon: this.rawItemContent
    }, null) : this.rawItemType === "TEXT" || this.rawItemType === "RAW" ? s("span", {
      class: this.ns.e("text")
    }, [this.rawItemText]) : this.rawItemType === "HEADING1" ? s("h1", {
      class: this.ns.e("h1")
    }, [this.rawItemText]) : this.rawItemType === "HEADING2" ? s("h2", {
      class: this.ns.e("h2")
    }, [this.rawItemText]) : this.rawItemType === "HEADING3" ? s("h3", {
      class: this.ns.e("h3")
    }, [this.rawItemText]) : this.rawItemType === "HEADING4" ? s("h4", {
      class: this.ns.e("h4")
    }, [this.rawItemText]) : this.rawItemType === "HEADING5" ? s("h5", {
      class: this.ns.e("h5")
    }, [this.rawItemText]) : this.rawItemType === "HEADING6" ? s("h6", {
      class: this.ns.e("h6")
    }, [this.rawItemText]) : this.rawItemType === "PARAGRAPH" ? s("p", {
      class: this.ns.e("paragraph")
    }, [this.rawItemText]) : this.rawItemType === "HTML" ? s("div", {
      class: this.ns.e("paragraph")
    }, [s("div", {
      class: this.ns.em("paragraph", "html-content")
    }, [this.renderHTMLContent(this.htmlContent)]), this.showTitle ? s("div", {
      class: this.ns.em("paragraph", "ancho-container")
    }, [s("div", {
      class: [this.ns.em("paragraph", "ancho"), this.ns.b("ancho"), this.ns.is("ancho-collapse", this.isCollapse)]
    }, [s("div", {
      class: this.ns.be("ancho", "directory"),
      title: this.title
    }, [s("i", {
      class: "fa fa-sitemap",
      "aria-hidden": "true",
      onClick: this.changeCollapse,
      title: this.isCollapse ? "展开" : "收起"
    }, null), this.isCollapse ? null : s("span", {
      class: this.ns.bem("ancho", "directory", "title")
    }, [this.title || "目录"])]), s("div", {
      class: this.ns.be("ancho", "title-item")
    }, [this.renderAnchoList(this.htmlContent)])])]) : null]) : this.rawItemType === "VIDEO" ? s("div", {
      class: this.ns.e("video")
    }, [s("video", {
      id: this.playerParams.id,
      src: this.playerParams.path,
      autoplay: this.playerParams.autoplay,
      controls: this.playerParams.showcontrols,
      loop: this.playerParams.replay,
      muted: this.playerParams.mute
    }, [s("source", {
      src: this.playerParams.path,
      type: "video/mp4"
    }, null), s("source", {
      src: this.playerParams.path,
      type: "video/ogg"
    }, null), s("source", {
      src: this.playerParams.path,
      type: "video/webm"
    }, null), ibiz.i18n.t("component.rawItem.noSupportVideo")])]) : this.rawItemType === "DIVIDER" ? s(P("el-divider"), {
      "content-position": this.dividerParams.contentPosition
    }, {
      default: () => [s("span", {
        innerHTML: this.dividerParams.html
      }, null)]
    }) : this.rawItemType === "INFO" || this.rawItemType === "WARNING" || this.rawItemType === "ERROR" ? s(P("el-alert"), {
      title: this.alertParams.title,
      type: this.alertParams.type,
      "show-icon": this.alertParams.showIcon,
      closable: this.alertParams.closeabled
    }, null) : this.rawItemType === "MARKDOWN" ? s(P("iBizMarkDown"), {
      value: this.content,
      disabled: !0
    }, null) : (["PLACEHOLDER"].includes(this.rawItemType), null);
    return s("div", {
      class: this.ns.b()
    }, [i(), this.showImg ? s(P("el-image-viewer"), {
      urlList: this.previewSrcList,
      "initial-index": this.previewImgIndex,
      "hide-on-click-modal": !0,
      onClose: this.closeImgPreview
    }, null) : null]);
  }
}), q = /* @__PURE__ */ B({
  name: "AnchoHtml",
  props: re(),
  emits: le(),
  setup(i) {
    var T, f, u, I, g;
    const n = X("raw"), a = i.controller.model, h = l(""), c = l("");
    let p = "TEXT", d = "";
    a.contentType && (p = a.contentType), (T = a.editorParams) != null && T.contenttype && (p = (f = a.editorParams) == null ? void 0 : f.contenttype), (u = a.editorParams) != null && u.template && (d = a.editorParams.template.replaceAll("//n", "\n")), (I = a.editorParams) != null && I.TEMPLATE && (d = a.editorParams.TEMPLATE.replaceAll("//n", "\n")), (g = a.editorParams) != null && g.TITLE && (c.value = i.data[a.editorParams.TITLE]);
    const R = ne(() => !!(i.controlParams && i.controlParams.editmode === "hover"));
    return V(() => i.value, async (m, v) => {
      if (m !== v && ((typeof m == "string" || typeof m == "number") && (h.value = m), d && m)) {
        let E = null;
        if (typeof m == "string")
          try {
            E = JSON.parse(m);
          } catch (A) {
            ibiz.log.error("JSON字符串转换错误");
          }
        h.value = await ibiz.util.hbs.render(d, E || m);
      }
    }, {
      immediate: !0
    }), {
      ns: n,
      content: h,
      type: p,
      template: d,
      title: c,
      showFormDefaultContent: R
    };
  },
  render() {
    return s("div", {
      class: [this.ns.b(), this.disabled ? this.ns.m("disabled") : "", this.readonly ? this.ns.m("readonly") : "", this.ns.is("show-default", this.showFormDefaultContent)]
    }, [this.content && s(N, {
      class: this.ns.b("content"),
      content: this.content,
      type: this.type,
      title: this.title
    }, null)]);
  }
});
class oe extends ie {
}
class ce {
  constructor() {
    C(this, "formEditor", "AnchoHtml");
    C(this, "gridEditor", "AnchoHtml");
  }
  async createController(n, o) {
    const a = new oe(n, o);
    return await a.init(), a;
  }
}
const fe = {
  install(i) {
    i.component(N.name, N), i.component(q.name, q), ae(
      "EDITOR_CUSTOMSTYLE_ANCHO_HTML",
      () => new ce()
    );
  }
};
export {
  fe as default
};
