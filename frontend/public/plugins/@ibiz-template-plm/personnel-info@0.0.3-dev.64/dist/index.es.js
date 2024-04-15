import './style.css';
var ie = Object.defineProperty;
var ae = (i, g, c) => g in i ? ie(i, g, { enumerable: !0, configurable: !0, writable: !0, value: c }) : i[g] = c;
var P = (i, g, c) => (ae(i, typeof g != "symbol" ? g + "" : g, c), c);
import { CodeListEditorController as ce, OpenAppViewCommand as le, registerEditorProvider as ue } from "@ibiz-template/runtime";
import { getSpanProps as de, useNamespace as fe, useFocusAndBlur as me, withInstall as he } from "@ibiz-template/vue3-util";
import { defineComponent as pe, ref as Q, watch as W, computed as V, createVNode as E } from "vue";
import { isNil as ge } from "ramda";
import { DataTypes as ve, RuntimeModelError as ye, RuntimeError as be } from "@ibiz-template/core";
import Z from "dayjs";
var Ae = typeof globalThis < "u" ? globalThis : typeof window < "u" ? window : typeof global < "u" ? global : typeof self < "u" ? self : {};
function Le(i) {
  return i && i.__esModule && Object.prototype.hasOwnProperty.call(i, "default") ? i.default : i;
}
var ee = { exports: {} };
(function(i, g) {
  (function(c, r) {
    i.exports = r();
  })(Ae, function() {
    var c = { LTS: "h:mm:ss A", LT: "h:mm A", L: "MM/DD/YYYY", LL: "MMMM D, YYYY", LLL: "MMMM D, YYYY h:mm A", LLLL: "dddd, MMMM D, YYYY h:mm A" }, r = /(\[[^[]*\])|([-_:/.,()\s]+)|(A|a|YYYY|YY?|MM?M?M?|Do|DD?|hh?|HH?|mm?|ss?|S{1,3}|z|ZZ?)/g, v = /\d\d/, y = /\d\d?/, C = /\d*[^-_:/,()\s\d]+/, A = {}, $ = function(t) {
      return (t = +t) + (t > 68 ? 1900 : 2e3);
    }, b = function(t) {
      return function(s) {
        this[t] = +s;
      };
    }, x = [/[+-]\d\d:?(\d\d)?|Z/, function(t) {
      (this.zone || (this.zone = {})).offset = function(s) {
        if (!s || s === "Z")
          return 0;
        var d = s.match(/([+-]|\d\d)/g), u = 60 * d[1] + (+d[2] || 0);
        return u === 0 ? 0 : d[0] === "+" ? -u : u;
      }(t);
    }], w = function(t) {
      var s = A[t];
      return s && (s.indexOf ? s : s.s.concat(s.f));
    }, z = function(t, s) {
      var d, u = A.meridiem;
      if (u) {
        for (var e = 1; e <= 24; e += 1)
          if (t.indexOf(u(e, 0, s)) > -1) {
            d = e > 12;
            break;
          }
      } else
        d = t === (s ? "pm" : "PM");
      return d;
    }, R = { A: [C, function(t) {
      this.afternoon = z(t, !1);
    }], a: [C, function(t) {
      this.afternoon = z(t, !0);
    }], S: [/\d/, function(t) {
      this.milliseconds = 100 * +t;
    }], SS: [v, function(t) {
      this.milliseconds = 10 * +t;
    }], SSS: [/\d{3}/, function(t) {
      this.milliseconds = +t;
    }], s: [y, b("seconds")], ss: [y, b("seconds")], m: [y, b("minutes")], mm: [y, b("minutes")], H: [y, b("hours")], h: [y, b("hours")], HH: [y, b("hours")], hh: [y, b("hours")], D: [y, b("day")], DD: [v, b("day")], Do: [C, function(t) {
      var s = A.ordinal, d = t.match(/\d+/);
      if (this.day = d[0], s)
        for (var u = 1; u <= 31; u += 1)
          s(u).replace(/\[|\]/g, "") === t && (this.day = u);
    }], M: [y, b("month")], MM: [v, b("month")], MMM: [C, function(t) {
      var s = w("months"), d = (w("monthsShort") || s.map(function(u) {
        return u.slice(0, 3);
      })).indexOf(t) + 1;
      if (d < 1)
        throw new Error();
      this.month = d % 12 || d;
    }], MMMM: [C, function(t) {
      var s = w("months").indexOf(t) + 1;
      if (s < 1)
        throw new Error();
      this.month = s % 12 || s;
    }], Y: [/[+-]?\d+/, b("year")], YY: [v, function(t) {
      this.year = $(t);
    }], YYYY: [/\d{4}/, b("year")], Z: x, ZZ: x };
    function B(t) {
      var s, d;
      s = t, d = A && A.formats;
      for (var u = (t = s.replace(/(\[[^\]]+])|(LTS?|l{1,4}|L{1,4})/g, function(p, l, m) {
        var L = m && m.toUpperCase();
        return l || d[m] || c[m] || d[L].replace(/(\[[^\]]+])|(MMMM|MM|DD|dddd)/g, function(M, S, D) {
          return S || D.slice(1);
        });
      })).match(r), e = u.length, o = 0; o < e; o += 1) {
        var f = u[o], n = R[f], a = n && n[0], h = n && n[1];
        u[o] = h ? { regex: a, parser: h } : f.replace(/^\[|\]$/g, "");
      }
      return function(p) {
        for (var l = {}, m = 0, L = 0; m < e; m += 1) {
          var M = u[m];
          if (typeof M == "string")
            L += M.length;
          else {
            var S = M.regex, D = M.parser, j = p.slice(L), Y = S.exec(j)[0];
            D.call(l, Y), p = p.replace(Y, "");
          }
        }
        return function(T) {
          var I = T.afternoon;
          if (I !== void 0) {
            var F = T.hours;
            I ? F < 12 && (T.hours += 12) : F === 12 && (T.hours = 0), delete T.afternoon;
          }
        }(l), l;
      };
    }
    return function(t, s, d) {
      d.p.customParseFormat = !0, t && t.parseTwoDigitYear && ($ = t.parseTwoDigitYear);
      var u = s.prototype, e = u.parse;
      u.parse = function(o) {
        var f = o.date, n = o.utc, a = o.args;
        this.$u = n;
        var h = a[1];
        if (typeof h == "string") {
          var p = a[2] === !0, l = a[3] === !0, m = p || l, L = a[2];
          l && (L = a[2]), A = this.$locale(), !p && L && (A = d.Ls[L]), this.$d = function(j, Y, T) {
            try {
              if (["x", "X"].indexOf(Y) > -1)
                return new Date((Y === "X" ? 1e3 : 1) * j);
              var I = B(Y)(j), F = I.year, O = I.month, te = I.day, re = I.hours, ne = I.minutes, oe = I.seconds, se = I.milliseconds, q = I.zone, U = /* @__PURE__ */ new Date(), H = te || (F || O ? 1 : U.getDate()), _ = F || U.getFullYear(), N = 0;
              F && !O || (N = O > 0 ? O - 1 : U.getMonth());
              var k = re || 0, J = ne || 0, X = oe || 0, G = se || 0;
              return q ? new Date(Date.UTC(_, N, H, k, J, X, G + 60 * q.offset * 1e3)) : T ? new Date(Date.UTC(_, N, H, k, J, X, G)) : new Date(_, N, H, k, J, X, G);
            } catch (Ee) {
              return /* @__PURE__ */ new Date("");
            }
          }(f, h, n), this.init(), L && L !== !0 && (this.$L = this.locale(L).$L), m && f != this.format(h) && (this.$d = /* @__PURE__ */ new Date("")), A = {};
        } else if (h instanceof Array)
          for (var M = h.length, S = 1; S <= M; S += 1) {
            a[1] = h[S - 1];
            var D = d.apply(this, a);
            if (D.isValid()) {
              this.$d = D.$d, this.$L = D.$L, this.init();
              break;
            }
            S === M && (this.$d = /* @__PURE__ */ new Date(""));
          }
        else
          e.call(this, o);
      };
    };
  });
})(ee);
var Ce = ee.exports;
const Ie = /* @__PURE__ */ Le(Ce);
Z.extend(Ie);
function Me(i, g) {
  return i === g ? !1 : Z(i, g, !0).isValid();
}
const K = /* @__PURE__ */ pe({
  name: "IBizPersonnelInfo",
  props: de(),
  setup(i, {
    emit: g
  }) {
    var u;
    const c = fe("personnel-info"), r = i.controller, v = Q(""), y = r.codeList, C = r.model.textSeparator || ((u = r.editorParams) == null ? void 0 : u.TEXTSEPARATOR) || ",", A = Q([]);
    y && W(() => i.data, (e) => {
      r.loadCodeList(e).then((o) => {
        A.value = o;
      });
    }, {
      immediate: !0,
      deep: !0
    });
    const {
      componentRef: $
    } = me(() => g("focus"), () => g("blur")), b = V(() => !!(i.controlParams && i.controlParams.editmode === "hover")), x = () => {
      const e = document.documentElement;
      return e ? getComputedStyle(e).getPropertyValue("--ibiz-color-primary") : null;
    }, w = (e) => /[\u4E00-\u9FA5]/.test(e), z = (e) => /[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(e), R = (e) => {
      if (!e)
        return "";
      let o = 0;
      for (let l = 0; l < e.length; l++)
        if (w(e))
          o = e.charCodeAt(l) + ((o << 5) - o), o = o & o;
        else {
          const m = e.charCodeAt(l);
          o += m.toString(16);
        }
      const f = String(o).substring(0, 6);
      let n = parseInt(f.substring(0, 2), 16), a = parseInt(f.substring(2, 4), 16), h = parseInt(f.substring(4, 6), 16);
      n < 0 && (n = 10), a < 0 && (a = 10), h < 0 && (h = 10);
      const p = "#".concat(n.toString(16).padStart(2, "0")).concat(a.toString(16).padStart(2, "0")).concat(h.toString(16).padStart(2, "0"));
      return p === "#FFFFFF" && x() || p;
    }, B = (e) => {
      if (e && e.toString().length < 2)
        return e;
      if (e && e.toString().length >= 2) {
        if (z(e)) {
          const a = e.split("").find((p) => /[a-zA-Z]/.test(p)) || "", h = e.split("").find((p) => /[\u4E00-\u9FA5]/.test(p)) || "";
          return "".concat(a).concat(h).toLowerCase();
        }
        return /[a-zA-Z]/.test(e) ? e.split("").filter((a) => /[a-zA-Z]/.test(a)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(e) ? e.split("").filter((a) => /[\u4E00-\u9FA5]/.test(a)).slice(-2).join("") : e.replaceAll(" ", "").substring(0, 2);
      }
    }, t = (e, o) => {
      if (e) {
        const f = e.find((n) => n.value == o);
        if (f)
          return f;
        for (let n = 0; n < e.length; n++) {
          const a = t(e[n].children, o);
          if (a)
            return a;
        }
      }
    };
    W(() => i.value, (e, o) => {
      var f;
      if (e !== o) {
        if (ge(e)) {
          v.value = "";
          return;
        }
        let n = "";
        const {
          valueFormat: a,
          dataType: h,
          unitName: p
        } = r.parent;
        if (r.model.valueType === "SIMPLES")
          n = e.join(C);
        else if (r.model.valueType === "OBJECT")
          n = e[r.model.objectNameField ? r.model.objectNameField : "srfmajortext"];
        else if (r.model.valueType === "OBJECTS") {
          const l = [];
          e.forEach((m) => {
            l.push(m[r.model.objectNameField ? r.model.objectNameField : "srfmajortext"]);
          }), n = l.join(C);
        } else if (r.model.editorType === "ADDRESSPICKUP")
          try {
            const l = [];
            JSON.parse(e).forEach((L) => {
              l.push(L[r.model.objectNameField ? r.model.objectNameField : "srfmajortext"]);
            }), n = l.join(C);
          } catch (l) {
            ibiz.log.error("标签地址选择器的值不符合JSON格式".concat(e));
          }
        else if (a)
          try {
            if (h != null && ve.isDate(h))
              n = Z(e).format(a);
            else {
              const l = Z(e).format(a);
              Me(n, a) ? n = l : n = ibiz.util.text.format("".concat(e), a);
            }
          } catch (l) {
            n = "".concat(e), ibiz.log.error("".concat(e, " 值格式化错误"));
          }
        else
          n = "".concat(e);
        if (p && (n += p), r.codeList && ((f = A.value) == null ? void 0 : f.length) > 0) {
          const l = A.value, m = t(l, n);
          n = (m == null ? void 0 : m.text) || n;
        }
        v.value = n;
      }
    }, {
      immediate: !0
    });
    const s = V(() => {
      var o;
      let e = v.value;
      if (r.codeList && ((o = A.value) == null ? void 0 : o.length) > 0) {
        const f = A.value, n = t(f, e);
        e = (n == null ? void 0 : n.text) || e;
      }
      return e;
    });
    return {
      ns: c,
      c: r,
      text: v,
      editorRef: $,
      showFormDefaultContent: b,
      renderContent: () => {
        const e = v.value;
        if (!e)
          return "- - -";
        const o = r.parseAvatar(e);
        return o ? E("div", {
          class: c.b("content")
        }, [E("div", {
          class: c.be("content", "head-sculpture")
        }, [E("img", {
          src: o
        }, null)])]) : E("div", {
          class: c.b("content")
        }, [E("div", {
          class: c.be("content", "head-sculpture"),
          style: "background-color:".concat(R(s.value))
        }, [B(s.value)]), E("div", {
          class: c.be("content", "tip")
        }, [s.value])]);
      }
    };
  },
  render() {
    return E("div", {
      class: [this.ns.b(), this.readonly ? this.ns.m("readonly") : "", this.ns.is("show-default", this.showFormDefaultContent)],
      ref: "editorRef"
    }, [this.renderContent()]);
  }
});
class Se extends ce {
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
    /**
     * 是否支持头像
     *
     * @type {boolean}
     * @memberof PersonnelInfoEditorController
     */
    P(this, "enableAvatar", !1);
  }
  async onInit() {
    var r, v;
    if (super.onInit(), (v = (r = this.model) == null ? void 0 : r.editorItems) != null && v[0] && (this.valueItem = this.model.editorItems[0].id), this.model.appCodeListId) {
      const y = await ibiz.hub.getApp(this.context.srfappid);
      this.codeList = y.codeList.getCodeList(this.model.appCodeListId);
    }
    const { ENABLEAVATAR: c } = this.editorParams;
    c && (this.enableAvatar = this.toBoolean(c));
  }
  /**
   * 打开数据链接视图
   */
  async openLinkView(c) {
    const r = this.context.clone();
    c[this.valueItem] && (r.srfkey = c[this.valueItem]);
    const { context: v, params: y } = this.handlePublicParams(
      c,
      r,
      this.params
    ), { linkAppViewId: C } = this.model;
    if (!C)
      throw new ye(this.model, "请配置数据链接视图");
    return ibiz.commands.execute(
      le.TAG,
      C,
      v,
      y
    );
  }
  /**
   * 解析头像数据
   *
   * @param {string} avatar
   * @return {*}
   * @memberof PersonnelInfoEditorController
   */
  parseAvatar(c) {
    if (this.enableAvatar)
      try {
        const r = JSON.parse(c);
        if (r) {
          const v = Array.isArray(r) ? r[0] : r;
          return ibiz.util.file.calcFileUpDownUrl(
            this.context,
            this.params
          ).downloadUrl.replace("%fileId%", v.id);
        }
      } catch (r) {
        throw new be("头像数据解析异常");
      }
  }
}
class De {
  constructor() {
    P(this, "formEditor", "IBizPersonnelInfo");
    P(this, "gridEditor", "IBizPersonnelInfo");
  }
  async createController(g, c) {
    const r = new Se(g, c);
    return await r.init(), r;
  }
}
const Te = he(K, (i) => {
  i.component(K.name, K), ue(
    "EDITOR_CUSTOMSTYLE_PERSONNEL_INFO",
    () => new De()
  );
}), je = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(i) {
    i.use(Te);
  }
};
export {
  Te as IBizPersonnelInfo,
  je as default
};
