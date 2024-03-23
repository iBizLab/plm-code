import './style.css';
var b = Object.defineProperty;
var w = (t, i, r) => i in t ? b(t, i, { enumerable: !0, configurable: !0, writable: !0, value: r }) : t[i] = r;
var I = (t, i, r) => (w(t, typeof i != "symbol" ? i + "" : i, r), r);
import { EditorController as C, registerEditorProvider as L } from "@ibiz-template/runtime";
import { getRawProps as z, getEditorEmits as v, useNamespace as A, withInstall as B } from "@ibiz-template/vue3-util";
import { defineComponent as M, ref as N, watch as O, createVNode as T, resolveComponent as S } from "vue";
const f = /* @__PURE__ */ M({
  name: "IBizIconRawItem",
  props: z(),
  emits: v(),
  setup(t) {
    var h, y, E, P, g, R;
    const i = A("icon-rawitem"), r = t.controller, o = r.model, m = N("");
    let l, p = "TEXT", a = "";
    o.contentType && (p = o.contentType), (h = o.editorParams) != null && h.contenttype && (p = (y = o.editorParams) == null ? void 0 : y.contenttype), (E = o.editorParams) != null && E.template && (a = o.editorParams.template.replaceAll("//n", "\n")), (P = o.editorParams) != null && P.TEMPLATE && (a = o.editorParams.TEMPLATE.replaceAll("//n", "\n")), (g = o.editorParams) != null && g.codeListId && (l = ibiz.hub.getApp(r.context.srfappid).codeList.getCodeList((R = o.editorParams) == null ? void 0 : R.codeListId));
    const u = (e, d) => {
      if (e) {
        const c = e.find((n) => n.value == d);
        if (c)
          return c;
        for (let n = 0; n < e.length; n++) {
          const s = u(e[n].children, d);
          if (s)
            return s;
        }
      }
    };
    return O(() => t.value, async (e, d) => {
      var c;
      if (e !== d) {
        let n = null;
        if ((typeof e == "string" || typeof e == "number") && (n = e), a && e) {
          let s = null;
          if (typeof e == "string")
            try {
              s = JSON.parse(e);
            } catch (j) {
              ibiz.log.error("JSON字符串转换错误");
            }
          n = await ibiz.util.hbs.render(a, s || e);
        }
        if (n && l) {
          const s = u(l.codeItems, "".concat((c = String(n)) == null ? void 0 : c.toLowerCase()));
          m.value = s == null ? void 0 : s.sysImage;
        } else
          m.value = n;
      }
    }, {
      immediate: !0
    }), {
      ns: i,
      content: m,
      type: p,
      template: a
    };
  },
  render() {
    return T("div", {
      class: [this.ns.b(), this.disabled ? this.ns.m("disabled") : "", this.readonly ? this.ns.m("readonly") : ""]
    }, [this.content && T(S("iBizRawItem"), {
      class: this.ns.b("content"),
      content: this.content,
      type: this.type
    }, null)]);
  }
});
class x extends C {
}
class _ {
  constructor() {
    I(this, "formEditor", "IBizIconRawItem");
    I(this, "gridEditor", "IBizIconRawItem");
  }
  async createController(i, r) {
    const o = new x(i, r);
    return await o.init(), o;
  }
}
const J = B(f, function(t) {
  t.component(f.name, f), L(
    "EDITOR_CUSTOMSTYLE_ICON_RAWITEM",
    () => new _()
  );
}), Y = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(t) {
    t.use(J);
  }
};
export {
  J as IBizIconRawItem,
  Y as default
};
