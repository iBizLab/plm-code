import './style.css';
var z = Object.defineProperty;
var H = (i, s, t) => s in i ? z(i, s, { enumerable: !0, configurable: !0, writable: !0, value: t }) : i[s] = t;
var p = (i, s, t) => (H(i, typeof s != "symbol" ? s + "" : s, t), t);
import { EditorController as U, ScriptFactory as $, PanelItemEventName as F, OpenAppViewCommand as J, registerEditorProvider as _ } from "@ibiz-template/runtime";
import { getRawProps as K, getEditorEmits as q, useNamespace as B, withInstall as V } from "@ibiz-template/vue3-util";
import { defineComponent as W, ref as u, computed as b, watch as S, createVNode as h, resolveComponent as L, nextTick as w } from "vue";
const I = /* @__PURE__ */ W({
  name: "CommentItemRawItem",
  props: K(),
  emits: {
    ...q(),
    /** 点击事件 */
    click: (i, s) => !0
  },
  setup(i) {
    var P, R, k, T;
    const s = B("raw"), t = i.controller, n = t.model, l = u(""), f = u(""), r = u(), o = u(), v = u([]);
    let C = "TEXT", d = "";
    n.contentType && (C = n.contentType), (P = n.editorParams) != null && P.contenttype && (C = (R = n.editorParams) == null ? void 0 : R.contenttype), (k = n.editorParams) != null && k.template && (d = n.editorParams.template.replaceAll("//n", "\n")), (T = n.editorParams) != null && T.TEMPLATE && (d = n.editorParams.TEMPLATE.replaceAll("//n", "\n"));
    const M = b(() => !!(i.controlParams && i.controlParams.editmode === "hover")), N = (e) => e.replaceAll(/{"emoji":"(.+?)"}/g, (c, a) => {
      const m = decodeURIComponent(atob(a));
      return '<span class="emoji-tag">'.concat(m, "</span>");
    }).replaceAll(/<span data-w-e-type="emoji" class='emoji'>(.+?)<\/span>/g, (c, a) => {
      const m = decodeURIComponent(atob(a));
      return "<span data-w-e-type=\"emoji\" class='emoji'>".concat(m, "</span>");
    });
    S(() => i.value, async (e, c) => {
      if (e !== c) {
        if ((typeof e == "string" || typeof e == "number") && (l.value = e), d && e) {
          let a = null;
          if (typeof e == "string")
            try {
              a = JSON.parse(e);
            } catch (m) {
              ibiz.log.error("JSON字符串转换错误");
            }
          l.value = await ibiz.util.hbs.render(d, a || e);
        }
        l.value = N(l.value ? "".concat(l.value) : "");
      }
    }, {
      immediate: !0
    });
    const y = b(() => t.scriptCode ? i.controller.getPanelItemCustomHtml(t.scriptCode, {
      content: l.value
    }) : ""), x = async (e) => {
      if (f.value = e, v.value = [e], await w(), r.value) {
        const {
          container: c
        } = r.value.$refs;
        c && c.children[0].click();
      }
    }, O = async () => {
      await w(), o.value && o.value.querySelectorAll("img").forEach((c) => {
        c.onclick = (a) => {
          const m = a.target;
          m && x(m.src);
        };
      });
    }, E = (e) => {
      if (r.value) {
        const {
          container: c
        } = r.value.$refs;
        if (c) {
          const a = c.querySelector(".el-image-viewer__wrapper");
          a == null || a[e]("keydown", g);
        }
      }
    }, g = async (e) => {
      (e.key === "Escape" || e.keyCode === 27) && (e.stopPropagation(), e.preventDefault(), await w(), E("removeEventListener"), v.value = []);
    }, j = async () => {
      await w(), E("addEventListener");
    }, D = (e) => {
      e.stopPropagation(), e.preventDefault(), t.handleClick(e);
    };
    return S(() => y, () => {
      O();
    }, {
      immediate: !0
    }), {
      ns: s,
      c: t,
      rawRef: o,
      previewRef: r,
      content: l,
      previewUrl: f,
      type: C,
      template: d,
      htmlCode: y,
      showFormDefaultContent: M,
      previewSrcList: v,
      onShow: j,
      handleKeyPress: g,
      handleClick: D
    };
  },
  render() {
    return h("div", {
      class: [this.ns.b(), this.ns.is("comment-item", !0), this.disabled ? this.ns.m("disabled") : "", this.readonly ? this.ns.m("readonly") : "", this.ns.is("show-default", this.showFormDefaultContent)]
    }, [this.htmlCode ? h("div", {
      ref: "rawRef",
      onClick: this.handleClick,
      class: this.ns.e("script"),
      innerHTML: this.htmlCode
    }, null) : this.content && h(L("iBizRawItem"), {
      class: this.ns.b("content"),
      content: this.content,
      type: this.type
    }, null), h(L("el-image"), {
      class: this.ns.e("preview"),
      ref: "previewRef",
      "zoom-rate": 1.1,
      src: this.previewUrl,
      "preview-src-list": this.previewSrcList,
      "hide-on-click-modal": !0,
      onShow: this.onShow,
      fit: "cover"
    }, null)]);
  }
});
class G extends U {
  constructor() {
    super(...arguments);
    /**
     * 绘制器脚本代码
     *
     * @type {string}
     * @memberof CommentItemRawItemEditorController
     */
    p(this, "scriptCode", "");
    /**
     * @description 链接视图id
     * @type {string}
     * @memberof CommentItemRawItemEditorController
     */
    p(this, "linkViewId", "plmweb.recent_redirect_view");
  }
  async onInit() {
    await super.onInit();
    const { SCRIPTCODE: t, LINKVIEWID: n } = this.editorParams;
    t && (this.scriptCode = t), n && (this.linkViewId = n);
  }
  /**
   * 获取面板绘制器自定义html
   *
   * @param {string} controlRenders
   * @param {(IData | undefined)} data
   * @return {*}  {(string | undefined)}
   * @memberof CommentItemRawItemEditorController
   */
  getPanelItemCustomHtml(t, n) {
    if (t)
      return $.execScriptFn({ data: n || {} }, t, {
        singleRowReturn: !0,
        isAsync: !1
      });
  }
  /**
   * @description 点击事件
   * @param {MouseEvent} event
   * @memberof CommentItemRawItemEditorController
   */
  onClick(t) {
    const { panel: n } = this.parent;
    n && n.evt.emit("onPanelItemEvent", {
      panelItemName: this.model.id,
      panelItemEventName: F.CLICK,
      event: t
    });
  }
  /**
   * @description 处理点击事件
   * @param {MouseEvent} event
   * @return {*}  {void}
   * @memberof CommentItemRawItemEditorController
   */
  handleClick(t) {
    const { classList: n, dataset: l } = t.target;
    if (n && n.contains("comment-tag")) {
      const f = l.value || "", r = this.context.clone(), o = JSON.parse(f);
      if (!o.owner_type)
        return;
      r.srfkey = o.id, o.owner_subtype === "page" ? r.article_page = o.owner_id : r[o.owner_subtype] = o.owner_id, r[o.owner_type] = o.recent_parent, delete o.script, delete o.icon, delete o.id, Object.assign(r, o), o && this.linkViewId && ibiz.commands.execute(
        J.TAG,
        this.linkViewId,
        r,
        this.params
      );
    }
  }
}
class A {
  constructor() {
    p(this, "formEditor", "CommentItemRawItem");
    p(this, "gridEditor", "CommentItemRawItem");
  }
  async createController(s, t) {
    const n = new G(
      s,
      t
    );
    return await n.init(), n;
  }
}
const X = V(
  I,
  function(i) {
    i.component(I.name, I), _(
      "RAW_COMMENT_ITEM",
      () => new A()
    ), _(
      "EDITOR_CUSTOMSTYLE_COMMENT_ITEM",
      () => new A()
    );
  }
), te = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(i) {
    i.use(X);
  }
};
export {
  X as IBizCommentItemRawItem,
  te as default
};
