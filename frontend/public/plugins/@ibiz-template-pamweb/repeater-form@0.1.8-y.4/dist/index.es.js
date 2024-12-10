import './style.css';
var F = Object.defineProperty;
var v = (t, o, e) => o in t ? F(t, o, { enumerable: !0, configurable: !0, writable: !0, value: e }) : t[o] = e;
var u = (t, o, e) => (v(t, typeof o != "symbol" ? o + "" : o, e), e);
import { FormMDCtrlController as b, FormMDCtrlRepeaterController as C, FormMDCtrlFormController as R, FormMDCtrlMDController as M, ControlVO as f, registerFormDetailProvider as z } from "@ibiz-template/runtime";
import { useNamespace as d, useController as g, withInstall as w } from "@ibiz-template/vue3-util";
import { defineComponent as D, createVNode as r, resolveComponent as s } from "vue";
import { ModelError as k } from "@ibiz-template/core";
const m = /* @__PURE__ */ D({
  name: "IBizFormMDCtrlPlugin",
  props: {
    modelData: {
      type: Object,
      required: !0
    },
    controller: {
      type: b,
      required: !0
    }
  },
  setup(t) {
    const o = d("form--plugin");
    g(t.controller);
    const e = t.controller, n = e.model.showCaption && !!e.model.caption, l = n || e.model.uiactionGroup;
    return {
      c: e,
      ns: o,
      hasCaption: n,
      hasHeader: l,
      onActionClick: async (a, c) => {
        await t.controller.onActionClick(a, c);
      }
    };
  },
  render() {
    const {
      model: t
    } = this.c;
    let o;
    switch (t.contentType) {
      case "GRID":
      case "LIST":
      case "DATAVIEW":
        o = r(s("iBizFormMDCtrlMD"), {
          controller: this.c
        }, null);
        break;
      case "FORM":
        o = r(s("iBizFormMDCtrlForm"), {
          controller: this.c
        }, null);
        break;
      case "REPEATER":
        o = r(s("iBizRepeaterForm"), {
          controller: this.c
        }, null);
        break;
      default:
        r("div", null, [ibiz.i18n.t("app.noSupport")]);
        break;
    }
    return r("div", {
      class: [this.ns.b(), this.ns.m(this.modelData.codeName), ...this.controller.containerClass, this.hasCaption ? this.ns.m("show-caption") : ""]
    }, [this.hasHeader && r("div", {
      class: this.ns.b("header")
    }, [r("div", {
      class: this.ns.e("title")
    }, [this.hasCaption ? this.c.model.caption : ""]), t.uiactionGroup && r(s("iBizActionToolbar"), {
      class: this.ns.e("toolbar"),
      "action-details": t.uiactionGroup.uiactionGroupDetails,
      "actions-state": this.controller.state.actionGroupState,
      onActionClick: this.onActionClick
    }, null)]), o]);
  }
});
class A {
  constructor() {
    u(this, "component", "IBizFormMDCtrlPlugin");
  }
  async createController(o, e, n) {
    let l;
    switch (o.contentType) {
      case "LIST":
      case "GRID":
      case "DATAVIEW":
        l = new M(o, e, n);
        break;
      case "FORM":
        l = new R(o, e, n);
        break;
      case "REPEATER":
        l = new C(o, e, n);
        break;
      default:
        throw new k(
          o,
          "".concat(ibiz.i18n.t("control.form.formMDctrl.errorMessage", {
            contentType: o.contentType
          }))
        );
    }
    return await l.init(), l;
  }
}
const p = /* @__PURE__ */ D({
  name: "IBizRepeaterForm",
  props: {
    controller: {
      type: C,
      required: !0
    }
  },
  setup(t) {
    return {
      ns: d("repeater-form"),
      onFormDataChange: (l, i) => {
        const a = i.data[0], c = a instanceof f ? a.clone() : {
          ...a
        }, h = [...t.controller.value];
        h[l] = c, t.controller.setValue(h);
      },
      onCreated: (l, i) => {
        t.controller.setRepeaterController("".concat(l), i.ctrl);
      }
    };
  },
  render() {
    const t = this.controller.value || [];
    return r("div", {
      class: this.ns.b()
    }, [t.map((o, e) => r("div", {
      class: this.ns.b("item")
    }, [r("div", {
      class: this.ns.b("item-content")
    }, [r(s("iBizControlShell"), {
      context: this.controller.context,
      params: this.controller.params,
      modelData: this.controller.repeatedForm,
      isSimple: !0,
      data: o,
      onFormDataChange: (n) => this.onFormDataChange(e, n),
      onCreated: (n) => this.onCreated(e, n)
    }, null)]), r("div", {
      class: this.ns.b("item-toolbar")
    }, [this.controller.enableDelete && r("div", {
      class: this.ns.be("item-toolbar", "remove-btn"),
      title: "删除",
      onClick: () => this.controller.remove(e)
    }, [r("svg", {
      viewBox: "0 0 16 16"
    }, [r("g", null, [r("path", {
      "fill-opacity": ".01",
      fill: "currentColor",
      d: "M0 0h16v16H0z"
    }, null), r("path", {
      d: "M12.48 4.967a.5.5 0 0 1 .498.452l.002.048v7.214c0 .954-.86 1.694-1.9 1.729l-.076.001H5.232c-1.048 0-1.933-.717-1.975-1.66l-.002-.07V5.467a.5.5 0 0 1 .998-.048l.002.048v7.214c0 .366.388.703.913.729l.064.001h5.772c.536 0 .944-.323.974-.686l.002-.044V5.467a.5.5 0 0 1 .5-.5zm-5.68.996a.5.5 0 0 1 .497.452l.002.048v4.244a.5.5 0 0 1-.997.048l-.003-.048V6.463a.5.5 0 0 1 .5-.5zm2.83 0a.5.5 0 0 1 .497.452l.003.048v4.244a.5.5 0 0 1-.998.048l-.002-.048V6.463a.5.5 0 0 1 .5-.5zm.426-4.374c.66 0 1.201.52 1.235 1.173l.002.066v.45h2.196a.5.5 0 0 1 .048.997l-.048.002H2.51a.5.5 0 0 1-.048-.997l.048-.003h2.432v-.45c0-.661.519-1.202 1.171-1.236l.066-.002h3.876zm0 1H6.18c-.12 0-.22.09-.235.206l-.002.033v.45h4.35v-.45a.24.24 0 0 0-.205-.237l-.032-.002z",
      fill: "currentColor"
    }, null)])])])])]))]);
  }
}), E = w(m, function(t) {
  t.component(m.name, m), t.component(p.name, p), z(
    "FORM_USERCONTROL_REPEATER_FORM",
    () => new A()
  );
}), V = {
  install(t) {
    t.use(E);
  }
};
export {
  V as default
};
