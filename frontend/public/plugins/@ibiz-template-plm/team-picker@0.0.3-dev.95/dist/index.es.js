import './style.css';
var N = Object.defineProperty;
var O = (a, l, t) => l in a ? N(a, l, { enumerable: !0, configurable: !0, writable: !0, value: t }) : a[l] = t;
var o = (a, l, t) => (O(a, typeof l != "symbol" ? l + "" : l, t), t);
import { EditorController as k, getDeACMode as R, registerEditorProvider as _ } from "@ibiz-template/runtime";
import { defineComponent as Z, ref as E, computed as $, watch as U, onMounted as B, createVNode as r, resolveComponent as b, createTextVNode as h } from "vue";
import { getDataPickerProps as H, getEditorEmits as G, useNamespace as Y } from "@ibiz-template/vue3-util";
import { RuntimeModelError as J } from "@ibiz-template/core";
import { mergeDeepLeft as q } from "ramda";
const P = /* @__PURE__ */ Z({
  name: "TeamPicker",
  props: H(),
  emits: G(),
  setup(a, {
    emit: l
  }) {
    const t = Y("team-picker"), s = a.controller, c = E(""), n = E([]), m = $(() => !!(a.controlParams && a.controlParams.editmode === "hover" && !a.readonly)), p = () => {
      const e = document.documentElement;
      return e ? getComputedStyle(e).getPropertyValue("--ibiz-color-primary") : null;
    }, g = (e) => /[\u4E00-\u9FA5]/.test(e), v = (e) => /[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(e), F = (e) => {
      if (!e)
        return "";
      let i = 0;
      for (let w = 0; w < e.length; w++)
        if (g(e))
          i = e.charCodeAt(w) + ((i << 5) - i), i = i & i;
        else {
          const j = e.charCodeAt(w);
          i += j.toString(16);
        }
      const d = String(i).substring(0, 6);
      let C = parseInt(d.substring(0, 2), 16), u = parseInt(d.substring(2, 4), 16), y = parseInt(d.substring(4, 6), 16);
      C < 0 && (C = 10), u < 0 && (u = 10), y < 0 && (y = 10);
      const f = "#".concat(C.toString(16).padStart(2, "0")).concat(u.toString(16).padStart(2, "0")).concat(y.toString(16).padStart(2, "0"));
      return f === "#FFFFFF" && p() || f;
    }, D = (e) => {
      if (e && e.toString().length < 2)
        return e;
      if (e && e.toString().length >= 2) {
        if (v(e)) {
          const u = e.split("").find((f) => /[a-zA-Z]/.test(f)) || "", y = e.split("").find((f) => /[\u4E00-\u9FA5]/.test(f)) || "";
          return "".concat(u).concat(y).toLowerCase();
        }
        return /[a-zA-Z]/.test(e) ? e.split("").filter((u) => /[a-zA-Z]/.test(u)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(e) ? e.split("").filter((u) => /[\u4E00-\u9FA5]/.test(u)).slice(-2).join("") : e.replaceAll(" ", "").substring(0, 2);
      }
    }, I = (e) => {
      if (e.avatar) {
        const d = JSON.parse(e.avatar), u = ibiz.util.file.calcFileUpDownUrl(s.context, s.params).downloadUrl.replace("%fileId%", d[0].id);
        return r("img", {
          class: t.em("item", "img-avatar"),
          src: u,
          alt: ""
        }, null);
      }
      const i = e.name;
      return r("div", {
        class: t.em("item", "text-avatar"),
        style: "background-color:".concat(F(i))
      }, [D(i)]);
    }, S = (e) => r("div", {
      class: t.e("item")
    }, [r("svg", {
      class: t.em("item", "org-icon"),
      viewBox: "0 0 24 24",
      xmlns: "http://www.w3.org/2000/svg",
      height: "1em",
      width: "1em",
      preserveAspectRatio: "xMidYMid meet",
      focusable: "false",
      fill: "currentColor"
    }, [r("g", {
      id: "aqm画板",
      "stroke-width": "1",
      "fill-rule": "evenodd"
    }, [r("path", {
      d: "M11.838 0c6.538 0 11.838 5.373 11.838 12s-5.3 12-11.838 12C5.3 24 0 18.627 0 12S5.3 0 11.838 0zM13 4h-2a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1l.41-.001-.016 2.139H8.5l-.15.006a2.1 2.1 0 0 0-1.95 2.094V14H6a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1h-.4v-1.762l.007-.113a.9.9 0 0 1 .893-.787h7l.113.007a.9.9 0 0 1 .787.893V14H16a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1h-.4v-1.762l-.005-.15a2.1 2.1 0 0 0-2.095-1.95h-2.906l.016-2.139L13 8a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1zm4.8 11.2v1.6h-1.6v-1.6h1.6zm-10 0v1.6H6.2v-1.6h1.6zm5-10v1.6h-1.6V5.2h1.6z",
      id: "aqm形状结合"
    }, null)])]), r("div", {
      class: t.em("item", "content")
    }, [r("span", {
      class: t.em("item", "type")
    }, [h("组织")]), r("span", {
      class: t.em("item", "type-divide")
    }, [h("/")]), r("span", {
      class: t.em("item", "orgname"),
      title: e.name
    }, [e.name])])]), x = (e) => r("div", {
      class: t.e("item")
    }, [r("div", {
      class: t.em("item", "text-icon")
    }, [I(e)]), r("div", {
      class: t.em("item", "content")
    }, [r("span", {
      class: t.em("item", "type")
    }, [h("个人")]), r("span", {
      class: t.em("item", "type-divide")
    }, [h("/")]), r("span", {
      class: t.em("item", "personname"),
      title: e.name
    }, [e.name])])]), L = (e) => r("div", {
      class: t.e("item")
    }, [e.avatar ? r("div", {
      class: t.em("item", "text-icon")
    }, [I(e)]) : r("svg", {
      class: t.em("item", "team-icon"),
      viewBox: "0 0 16 16",
      version: "1.1",
      height: "1em",
      width: "1em",
      xmlns: "http://www.w3.org/2000/svg",
      preserveAspectRatio: "xMidYMid meet",
      focusable: "false",
      fill: "currentColor"
    }, [r("title", null, [h("normal/user-group-avatar@1x")]), r("g", {
      id: "团队",
      "stroke-width": "1",
      "fill-rule": "evenodd"
    }, [r("path", {
      d: "M8,0 C12.418278,-8.11624501e-16 16,3.581722 16,8 C16,12.418278 12.418278,16 8,16 C3.581722,16 5.41083001e-16,12.418278 0,8 C-5.41083001e-16,3.581722 3.581722,8.11624501e-16 8,0 Z M6.94814892,4.5 C5.8297723,4.5 4.92314892,5.40662338 4.92314892,6.525 C4.92314892,7.17754041 5.23179842,7.75799186 5.71074948,8.1273513 C4.58627683,8.60821226 3.79861678,9.72458136 3.80000182,11.025 C3.80000182,11.2113961 3.95110572,11.3625 4.13750182,11.3625 L4.20551985,11.3556432 C4.3593129,11.3241726 4.47500182,11.1880966 4.47500182,11.025 L4.473,11.01 L4.47841342,10.8622681 C4.55871908,9.62501422 5.54816314,8.63557016 6.78541699,8.5552645 L6.942,8.549 L6.96130368,8.55003422 C8.32215601,8.55711636 9.42316527,9.66248284 9.42824334,11.025 C9.42824334,11.2113961 9.57934724,11.3625 9.76574334,11.3625 C9.95213944,11.3625 10.1032433,11.2113961 10.1032433,11.025 L10.0963865,10.956982 L10.0931624,10.8462507 C10.0247081,9.62255373 9.25778371,8.58538265 8.18522666,8.12832813 C8.66449942,7.75799186 8.97314892,7.17754041 8.97314892,6.525 C8.97314892,5.40662338 8.06652554,4.5 6.94814892,4.5 Z M9.47939892,5.0625 L9.47939892,5.7375 C10.0696532,5.7375 10.5481489,6.21599567 10.5481489,6.80625 C10.5481489,7.39650433 10.0696532,7.875 9.47939892,7.875 L9.47939892,8.55 C10.5880137,8.55 11.5045613,9.37233726 11.651361,10.4406322 L11.6509718,10.4569843 C11.6509718,10.6433804 11.8020757,10.7944843 11.9884718,10.7944843 C12.1728418,10.7944843 12.3226827,10.6466474 12.3344785,10.4618968 C12.2317937,9.40890588 11.5598087,8.52274877 10.6305547,8.11605224 C10.9938747,7.79648694 11.2231489,7.3281434 11.2231489,6.80625 C11.2231489,5.84320347 10.4424455,5.0625 9.47939892,5.0625 Z M6.94814892,5.175 C7.69373333,5.175 8.29814892,5.77941559 8.29814892,6.525 C8.29814892,7.26653599 7.7002793,7.86843205 6.96028162,7.87494661 L6.943,7.875 L6.81813491,7.86882008 C6.13354819,7.80340381 5.59814892,7.22672651 5.59814892,6.525 C5.59814892,5.77941559 6.20256451,5.175 6.94814892,5.175 Z",
      id: "normal/user-group-circle-fill"
    }, null)])]), r("div", {
      class: t.em("item", "content")
    }, [r("span", {
      class: t.em("item", "type")
    }, [h("团队")]), r("span", {
      class: t.em("item", "type-divide")
    }, [h("/")]), r("span", {
      class: t.em("item", "personname"),
      title: e.name
    }, [e.name])])]), A = (e) => e.type === "organization" ? S(e) : e.type === "user" ? x(e) : L(e), M = () => {
      const e = n.value.find((i) => i.id === c.value);
      if (e) {
        const i = s.fillMap[e.type];
        l("change", i), s.valueItem && l("change", e.id, s.valueItem);
      }
    };
    U(() => a.value, () => {
      if (s.valueItem) {
        const e = a.data[s.valueItem];
        c.value = e;
      }
    }, {
      immediate: !0
    });
    const z = async () => {
      const e = await s.getServiceData("", a.data);
      e && e.data && (n.value = e.data.map((i) => ({
        ...i,
        type: "user_group"
      })));
    }, T = () => {
      if (!a.value || !a.data[s.valueItem])
        return null;
      const e = {};
      Object.keys(s.fillMap).some((d) => {
        if (s.fillMap[d] === a.value)
          return e.type = d, !0;
      });
      const i = n.value.find((d) => d.id === a.data[s.valueItem]);
      return i && Object.assign(e, i), r("div", {
        class: t.em("item", "readonly")
      }, [A(e)]);
    };
    return B(async () => {
      if (await z(), s.hasORG_M && n.value.unshift({
        type: "organization",
        id: s.context.srforgid,
        name: s.context.srforgname
      }), s.showPerson && n.value.push({
        type: "user",
        id: s.context.srfpersonid,
        name: s.context.srfpersonname,
        avatar: s.context.avatar
      }), !a.value && !a.readonly && !a.disabled && n.value && n.value.length > 0) {
        if (s.params && s.params.srfdefaulttype) {
          const e = n.value.filter((i) => i.type === s.params.srfdefaulttype);
          e.length > 0 ? c.value = e[0].id : c.value = n.value[0].id;
        } else
          c.value = n.value[0].id;
        M();
      }
    }), {
      ns: t,
      c: s,
      curValue: c,
      items: n,
      renderItem: A,
      onChange: M,
      renderReadOnlyState: T,
      showFormDefaultContent: m
    };
  },
  render() {
    return r("div", {
      class: [this.ns.b(), this.readonly ? this.ns.m("readonly") : "", this.ns.is("show-default", this.showFormDefaultContent)]
    }, [this.readonly ? this.renderReadOnlyState() : r(b("el-select"), {
      modelValue: this.curValue,
      "onUpdate:modelValue": (a) => this.curValue = a,
      "fit-input-width": !0,
      onChange: this.onChange
    }, {
      default: () => this.items.map((a) => r(b("el-option"), {
        key: a.id,
        value: a.id,
        label: a.name
      }, {
        default: () => [this.renderItem(a), h(";")]
      }))
    })]);
  }
});
class K extends k {
  constructor() {
    super(...arguments);
    /**
     * 当前应用是否拥有ORG_M统一资源权限,有则数据集添加组织，没有则不添加
     *
     * @memberof TeamPickerController
     */
    o(this, "hasORG_M", !1);
    /**
     * 是否显示个人
     *
     * @type {boolean}
     * @memberof TeamPickerController
     */
    o(this, "showPerson", !1);
    /**
     * 所属类型代码表映射
     *
     * @type {IData}
     * @memberof TeamPickerController
     */
    o(this, "fillMap", {
      user: "user",
      user_group: "user_group",
      organization: "organization"
    });
    /**
     *自填模式sort排序
     *
     * @type {(string | undefined)}
     * @memberof TeamPickerController
     */
    o(this, "sort", "");
    /**
     * 数据集codeName
     */
    o(this, "interfaceName", "");
    /**
     *值项
     */
    o(this, "valueItem", "");
    /*
     * 实体自填模式模型
     */
    o(this, "deACMode");
    /**
     * 主键属性名称
     */
    o(this, "keyName", "srfkey");
    /**
     * 主文本属性名称
     */
    o(this, "textName", "srfmajortext");
    /**
     * 自填数据项集合（已排除了value和text)
     */
    o(this, "dataItems", []);
    // 对象标识属性
    o(this, "objectIdField", "");
    // 对象名称属性
    o(this, "objectNameField", "");
    // 对象值属性
    o(this, "objectValueField", "");
  }
  async onInit() {
    var s, c, n, m;
    super.onInit(), this.valueItem = ((s = this.model.valueItemName) == null ? void 0 : s.toLowerCase()) || "";
    const t = await ibiz.hub.getApp(this.context.srfappid);
    if (this.hasORG_M = t.authority.calcByResCode("ORG_M"), this.model.appDataEntityId && (this.model.appDEDataSetId && (this.interfaceName = this.model.appDEDataSetId), this.model.appDEACModeId && (this.deACMode = await R(
      this.model.appDEACModeId,
      this.model.appDataEntityId,
      this.context.srfappid
    ), this.deACMode))) {
      const { minorSortAppDEFieldId: p, minorSortDir: g } = this.deACMode;
      p && g && (this.sort = "".concat(p.toLowerCase(), ",").concat(g.toLowerCase())), this.deACMode.textAppDEFieldId && (this.textName = this.deACMode.textAppDEFieldId), this.deACMode.valueAppDEFieldId && (this.keyName = this.deACMode.valueAppDEFieldId), this.deACMode.deacmodeDataItems && (this.dataItems = [], this.deACMode.deacmodeDataItems.forEach(
        (v) => {
          v.id !== "value" && v.id !== "text" && this.dataItems.push(v);
        }
      ));
    }
    if (this.objectIdField = (c = this.model.objectIdField) == null ? void 0 : c.toLowerCase(), this.objectNameField = (n = this.model.objectNameField) == null ? void 0 : n.toLowerCase(), this.objectValueField = (m = this.model.objectValueField) == null ? void 0 : m.toLowerCase(), this.editorParams && this.editorParams.enablePerson && (this.showPerson = this.editorParams.enablePerson === "true"), this.editorParams && this.editorParams.fillMap)
      try {
        this.fillMap = JSON.parse(this.editorParams.fillMap);
      } catch (p) {
        this.fillMap = {
          user: "user",
          user_group: "user_group",
          organization: "organization"
        };
      }
  }
  /**
   * 加载实体数据集数据
   *
   * @param {string} query 模糊匹配字符串
   * @param {IData} data 表单数据
   * @returns {*}  {Promise<IHttpResponse<IData[]>>}
   * @memberof TeamPickerController
   */
  async getServiceData(t, s) {
    const { context: c, params: n } = this.handlePublicParams(
      s,
      this.context,
      this.params
    ), m = {};
    this.sort && !Object.is(this.sort, "") && Object.assign(m, { sort: this.sort }), t && Object.assign(m, { query: t }), Object.assign(m, { size: 1e3 });
    const p = q(n, m);
    if (this.interfaceName)
      return await ibiz.hub.getApp(this.context.srfappid).deService.exec(
        this.model.appDataEntityId,
        this.interfaceName,
        c,
        p
      );
    throw new J(this.model, "请配置实体和实体数据集");
  }
}
class Q {
  constructor() {
    o(this, "formEditor", "TeamPicker");
    o(this, "gridEditor", "TeamPicker");
  }
  async createController(l, t) {
    const s = new K(l, t);
    return await s.init(), s;
  }
}
const se = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(a) {
    a.component(P.name, P), _(
      "EDITOR_CUSTOMSTYLE_TEAM_PICKER",
      () => new Q()
    );
  }
};
export {
  se as default
};