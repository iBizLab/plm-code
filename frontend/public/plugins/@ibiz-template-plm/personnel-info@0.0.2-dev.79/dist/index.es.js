import './style.css';
var ie = Object.defineProperty;
var ae = (i, g, l) => g in i ? ie(i, g, { enumerable: !0, configurable: !0, writable: !0, value: l }) : i[g] = l;
var P = (i, g, l) => (ae(i, typeof g != "symbol" ? g + "" : g, l), l);
import { CodeListEditorController as ce, OpenAppViewCommand as ue, registerEditorProvider as le } from "@ibiz-template/runtime";
import { getSpanProps as de, useNamespace as fe, useFocusAndBlur as me, withInstall as he } from "@ibiz-template/vue3-util";
import { defineComponent as pe, ref as Q, watch as W, computed as V, createVNode as N } from "vue";
import { isNil as ge } from "ramda";
import { DataTypes as ve, RuntimeModelError as ye } from "@ibiz-template/core";
import Z from "dayjs";
var Ce = typeof globalThis < "u" ? globalThis : typeof window < "u" ? window : typeof global < "u" ? global : typeof self < "u" ? self : {};
function Le(i) {
  return i && i.__esModule && Object.prototype.hasOwnProperty.call(i, "default") ? i.default : i;
}
var ee = { exports: {} };
(function(i, g) {
  (function(l, o) {
    i.exports = o();
  })(Ce, function() {
    var l = { LTS: "h:mm:ss A", LT: "h:mm A", L: "MM/DD/YYYY", LL: "MMMM D, YYYY", LLL: "MMMM D, YYYY h:mm A", LLLL: "dddd, MMMM D, YYYY h:mm A" }, o = /(\[[^[]*\])|([-_:/.,()\s]+)|(A|a|YYYY|YY?|MM?M?M?|Do|DD?|hh?|HH?|mm?|ss?|S{1,3}|z|ZZ?)/g, y = /\d\d/, C = /\d\d?/, M = /\d*[^-_:/,()\s\d]+/, L = {}, $ = function(t) {
      return (t = +t) + (t > 68 ? 1900 : 2e3);
    }, v = function(t) {
      return function(n) {
        this[t] = +n;
      };
    }, w = [/[+-]\d\d:?(\d\d)?|Z/, function(t) {
      (this.zone || (this.zone = {})).offset = function(n) {
        if (!n || n === "Z")
          return 0;
        var d = n.match(/([+-]|\d\d)/g), u = 60 * d[1] + (+d[2] || 0);
        return u === 0 ? 0 : d[0] === "+" ? -u : u;
      }(t);
    }], F = function(t) {
      var n = L[t];
      return n && (n.indexOf ? n : n.s.concat(n.f));
    }, x = function(t, n) {
      var d, u = L.meridiem;
      if (u) {
        for (var e = 1; e <= 24; e += 1)
          if (t.indexOf(u(e, 0, n)) > -1) {
            d = e > 12;
            break;
          }
      } else
        d = t === (n ? "pm" : "PM");
      return d;
    }, R = { A: [M, function(t) {
      this.afternoon = x(t, !1);
    }], a: [M, function(t) {
      this.afternoon = x(t, !0);
    }], S: [/\d/, function(t) {
      this.milliseconds = 100 * +t;
    }], SS: [y, function(t) {
      this.milliseconds = 10 * +t;
    }], SSS: [/\d{3}/, function(t) {
      this.milliseconds = +t;
    }], s: [C, v("seconds")], ss: [C, v("seconds")], m: [C, v("minutes")], mm: [C, v("minutes")], H: [C, v("hours")], h: [C, v("hours")], HH: [C, v("hours")], hh: [C, v("hours")], D: [C, v("day")], DD: [y, v("day")], Do: [M, function(t) {
      var n = L.ordinal, d = t.match(/\d+/);
      if (this.day = d[0], n)
        for (var u = 1; u <= 31; u += 1)
          n(u).replace(/\[|\]/g, "") === t && (this.day = u);
    }], M: [C, v("month")], MM: [y, v("month")], MMM: [M, function(t) {
      var n = F("months"), d = (F("monthsShort") || n.map(function(u) {
        return u.slice(0, 3);
      })).indexOf(t) + 1;
      if (d < 1)
        throw new Error();
      this.month = d % 12 || d;
    }], MMMM: [M, function(t) {
      var n = F("months").indexOf(t) + 1;
      if (n < 1)
        throw new Error();
      this.month = n % 12 || n;
    }], Y: [/[+-]?\d+/, v("year")], YY: [y, function(t) {
      this.year = $(t);
    }], YYYY: [/\d{4}/, v("year")], Z: w, ZZ: w };
    function B(t) {
      var n, d;
      n = t, d = L && L.formats;
      for (var u = (t = n.replace(/(\[[^\]]+])|(LTS?|l{1,4}|L{1,4})/g, function(p, c, m) {
        var I = m && m.toUpperCase();
        return c || d[m] || l[m] || d[I].replace(/(\[[^\]]+])|(MMMM|MM|DD|dddd)/g, function(b, D, T) {
          return D || T.slice(1);
        });
      })).match(o), e = u.length, s = 0; s < e; s += 1) {
        var f = u[s], r = R[f], a = r && r[0], h = r && r[1];
        u[s] = h ? { regex: a, parser: h } : f.replace(/^\[|\]$/g, "");
      }
      return function(p) {
        for (var c = {}, m = 0, I = 0; m < e; m += 1) {
          var b = u[m];
          if (typeof b == "string")
            I += b.length;
          else {
            var D = b.regex, T = b.parser, z = p.slice(I), E = D.exec(z)[0];
            T.call(c, E), p = p.replace(E, "");
          }
        }
        return function(Y) {
          var S = Y.afternoon;
          if (S !== void 0) {
            var A = Y.hours;
            S ? A < 12 && (Y.hours += 12) : A === 12 && (Y.hours = 0), delete Y.afternoon;
          }
        }(c), c;
      };
    }
    return function(t, n, d) {
      d.p.customParseFormat = !0, t && t.parseTwoDigitYear && ($ = t.parseTwoDigitYear);
      var u = n.prototype, e = u.parse;
      u.parse = function(s) {
        var f = s.date, r = s.utc, a = s.args;
        this.$u = r;
        var h = a[1];
        if (typeof h == "string") {
          var p = a[2] === !0, c = a[3] === !0, m = p || c, I = a[2];
          c && (I = a[2]), L = this.$locale(), !p && I && (L = d.Ls[I]), this.$d = function(z, E, Y) {
            try {
              if (["x", "X"].indexOf(E) > -1)
                return new Date((E === "X" ? 1e3 : 1) * z);
              var S = B(E)(z), A = S.year, j = S.month, te = S.day, re = S.hours, ne = S.minutes, oe = S.seconds, se = S.milliseconds, q = S.zone, H = /* @__PURE__ */ new Date(), _ = te || (A || j ? 1 : H.getDate()), k = A || H.getFullYear(), O = 0;
              A && !j || (O = j > 0 ? j - 1 : H.getMonth());
              var U = re || 0, J = ne || 0, X = oe || 0, G = se || 0;
              return q ? new Date(Date.UTC(k, O, _, U, J, X, G + 60 * q.offset * 1e3)) : Y ? new Date(Date.UTC(k, O, _, U, J, X, G)) : new Date(k, O, _, U, J, X, G);
            } catch (Ye) {
              return /* @__PURE__ */ new Date("");
            }
          }(f, h, r), this.init(), I && I !== !0 && (this.$L = this.locale(I).$L), m && f != this.format(h) && (this.$d = /* @__PURE__ */ new Date("")), L = {};
        } else if (h instanceof Array)
          for (var b = h.length, D = 1; D <= b; D += 1) {
            a[1] = h[D - 1];
            var T = d.apply(this, a);
            if (T.isValid()) {
              this.$d = T.$d, this.$L = T.$L, this.init();
              break;
            }
            D === b && (this.$d = /* @__PURE__ */ new Date(""));
          }
        else
          e.call(this, s);
      };
    };
  });
})(ee);
var Ie = ee.exports;
const Me = /* @__PURE__ */ Le(Ie);
Z.extend(Me);
function Se(i, g) {
  return i === g ? !1 : Z(i, g, !0).isValid();
}
const K = /* @__PURE__ */ pe({
  name: "IBizPersonnelInfo",
  props: de(),
  setup(i, {
    emit: g
  }) {
    var u;
    const l = fe("personnel-info"), o = i.controller, y = Q(""), C = o.codeList, M = o.model.textSeparator || ((u = o.editorParams) == null ? void 0 : u.TEXTSEPARATOR) || ",", L = Q([]);
    C && W(() => i.data, (e) => {
      o.loadCodeList(e).then((s) => {
        L.value = s;
      });
    }, {
      immediate: !0,
      deep: !0
    });
    const {
      componentRef: $
    } = me(() => g("focus"), () => g("blur")), v = V(() => !!(i.controlParams && i.controlParams.editmode === "hover")), w = () => {
      const e = document.documentElement;
      return e ? getComputedStyle(e).getPropertyValue("--ibiz-color-primary") : null;
    }, F = (e) => /[\u4E00-\u9FA5]/.test(e), x = (e) => /[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(e), R = (e) => {
      if (!e)
        return "";
      let s = 0;
      for (let c = 0; c < e.length; c++)
        if (F(e))
          s = e.charCodeAt(c) + ((s << 5) - s), s = s & s;
        else {
          const m = e.charCodeAt(c);
          s += m.toString(16);
        }
      const f = String(s).substring(0, 6);
      let r = parseInt(f.substring(0, 2), 16), a = parseInt(f.substring(2, 4), 16), h = parseInt(f.substring(4, 6), 16);
      r < 0 && (r = 10), a < 0 && (a = 10), h < 0 && (h = 10);
      const p = "#".concat(r.toString(16).padStart(2, "0")).concat(a.toString(16).padStart(2, "0")).concat(h.toString(16).padStart(2, "0"));
      return p === "#FFFFFF" && w() || p;
    }, B = (e) => {
      if (e && e.toString().length < 2)
        return e;
      if (e && e.toString().length >= 2) {
        if (x(e)) {
          const a = e.split("").find((p) => /[a-zA-Z]/.test(p)) || "", h = e.split("").find((p) => /[\u4E00-\u9FA5]/.test(p)) || "";
          return "".concat(a).concat(h).toLowerCase();
        }
        return /[a-zA-Z]/.test(e) ? e.split("").filter((a) => /[a-zA-Z]/.test(a)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(e) ? e.split("").filter((a) => /[\u4E00-\u9FA5]/.test(a)).slice(-2).join("") : e.replaceAll(" ", "").substring(0, 2);
      }
    }, t = (e, s) => {
      if (e) {
        const f = e.find((r) => r.value == s);
        if (f)
          return f;
        for (let r = 0; r < e.length; r++) {
          const a = t(e[r].children, s);
          if (a)
            return a;
        }
      }
    };
    W(() => i.value, (e, s) => {
      var f;
      if (e !== s) {
        if (ge(e)) {
          y.value = "";
          return;
        }
        let r = "";
        const {
          valueFormat: a,
          dataType: h,
          unitName: p
        } = o.parent;
        if (o.model.valueType === "SIMPLES")
          r = e.join(M);
        else if (o.model.valueType === "OBJECT")
          r = e[o.model.objectNameField ? o.model.objectNameField : "srfmajortext"];
        else if (o.model.valueType === "OBJECTS") {
          const c = [];
          e.forEach((m) => {
            c.push(m[o.model.objectNameField ? o.model.objectNameField : "srfmajortext"]);
          }), r = c.join(M);
        } else if (o.model.editorType === "ADDRESSPICKUP")
          try {
            const c = [];
            JSON.parse(e).forEach((I) => {
              c.push(I[o.model.objectNameField ? o.model.objectNameField : "srfmajortext"]);
            }), r = c.join(M);
          } catch (c) {
            ibiz.log.error("标签地址选择器的值不符合JSON格式".concat(e));
          }
        else if (a)
          try {
            if (h != null && ve.isDate(h))
              r = Z(e).format(a);
            else {
              const c = Z(e).format(a);
              Se(r, a) ? r = c : r = ibiz.util.text.format("".concat(e), a);
            }
          } catch (c) {
            r = "".concat(e), ibiz.log.error("".concat(e, " 值格式化错误"));
          }
        else
          r = "".concat(e);
        if (p && (r += p), o.codeList && ((f = L.value) == null ? void 0 : f.length) > 0) {
          const c = L.value, m = t(c, r);
          r = (m == null ? void 0 : m.text) || r;
        }
        y.value = r;
      }
    }, {
      immediate: !0
    });
    const n = V(() => {
      var s;
      let e = y.value;
      if (o.codeList && ((s = L.value) == null ? void 0 : s.length) > 0) {
        const f = L.value, r = t(f, e);
        e = (r == null ? void 0 : r.text) || e;
      }
      return e;
    });
    return {
      ns: l,
      c: o,
      text: y,
      editorRef: $,
      showFormDefaultContent: v,
      renderContent: () => y.value ? N("div", {
        class: l.b("content")
      }, [N("div", {
        class: l.be("content", "head-sculpture"),
        style: "background-color:".concat(R(n.value))
      }, [B(n.value)]), N("div", {
        class: l.be("content", "tip")
      }, [n.value])]) : "- - -"
    };
  },
  render() {
    return N("div", {
      class: [this.ns.b(), this.readonly ? this.ns.m("readonly") : "", this.ns.is("show-default", this.showFormDefaultContent)],
      ref: "editorRef"
    }, [this.renderContent()]);
  }
});
class be extends ce {
  constructor() {
    super(...arguments);
    /**
     *值项
     */
    P(this, "valueItem", "");
    /**
     * 代码表模型
     * @return {*}
     * @author: zhujiamin
     * @Date: 2023-05-24 10:55:50
     */
    P(this, "codeList");
  }
  async onInit() {
    var l, o;
    if (super.onInit(), (o = (l = this.model) == null ? void 0 : l.editorItems) != null && o[0] && (this.valueItem = this.model.editorItems[0].id), this.model.appCodeListId) {
      const y = await ibiz.hub.getApp(this.context.srfappid);
      this.codeList = y.codeList.getCodeList(this.model.appCodeListId);
    }
  }
  /**
   * 打开数据链接视图
   */
  async openLinkView(l) {
    const o = this.context.clone();
    l[this.valueItem] && (o.srfkey = l[this.valueItem]);
    const { context: y, params: C } = this.handlePublicParams(
      l,
      o,
      this.params
    ), { linkAppViewId: M } = this.model;
    if (!M)
      throw new ye(this.model, "请配置数据链接视图");
    return ibiz.commands.execute(
      ue.TAG,
      M,
      y,
      C
    );
  }
}
class De {
  constructor() {
    P(this, "formEditor", "IBizPersonnelInfo");
    P(this, "gridEditor", "IBizPersonnelInfo");
  }
  async createController(g, l) {
    const o = new be(g, l);
    return await o.init(), o;
  }
}
const Te = he(K, (i) => {
  i.component(K.name, K), le(
    "EDITOR_CUSTOMSTYLE_PERSONNEL_INFO",
    () => new De()
  );
}), ze = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(i) {
    i.use(Te);
  }
};
export {
  Te as IBizPersonnelInfo,
  ze as default
};
