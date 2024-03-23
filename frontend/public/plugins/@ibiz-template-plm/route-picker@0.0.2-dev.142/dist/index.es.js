import './style.css';
var j = Object.defineProperty;
var z = (l, n, o) => n in l ? j(l, n, { enumerable: !0, configurable: !0, writable: !0, value: o }) : l[n] = o;
var m = (l, n, o) => (z(l, typeof n != "symbol" ? n + "" : n, o), o);
import { EditorController as H, ButtonContainerState as _, getDeACMode as q, calcDeCodeNameById as X, UIActionButtonState as Y, UIActionUtil as $, openRedirectView as J, registerEditorProvider as Q } from "@ibiz-template/runtime";
import { parseRouteViewData as W, getDataPickerProps as Z, getEditorEmits as ee, useNamespace as te, renderString as ie, route2routePath as K, routePath2string as O, withInstall as oe } from "@ibiz-template/vue3-util";
import { RuntimeModelError as ae, listenJSEvent as se, NOOP as T } from "@ibiz-template/core";
import { mergeDeepLeft as ne } from "ramda";
import { defineComponent as re, ref as D, computed as V, watch as x, onMounted as le, onBeforeUnmount as de, onActivated as ce, createVNode as p, resolveComponent as y } from "vue";
import { useRoute as ue } from "vue-router";
class pe extends H {
  constructor() {
    super(...arguments);
    /**
     * 主键属性名称
     */
    m(this, "keyName", "srfkey");
    /**
     * 主文本属性名称
     */
    m(this, "textName", "srfmajortext");
    /**
     * 数据集codeName
     */
    m(this, "interfaceName", "");
    /**
     * 自填模式sort排序
     */
    m(this, "sort", "");
    /**
     * 实体自填模式模型
     */
    m(this, "deACMode");
    /**
     * 自填数据项集合（已排除了value和text)
     */
    m(this, "dataItems", []);
    /**
     * 分组行为状态
     *
     * @type {IButtonContainerState}
     * @memberof RoutePickerController
     */
    m(this, "groupActionState", new _());
    /**
     * 后缀图标
     *
     * @type {string}
     * @memberof RoutePickerController
     */
    m(this, "suffix", "");
    /**
     * 允许搜索
     *
     * @type {boolean}
     * @memberof RoutePickerController
     */
    m(this, "enablesearch", !1);
    /**
     * 路由属性标识
     *
     * @type {string}
     * @memberof RoutePickerController
     */
    m(this, "routeKey", "");
    /**
     * 值变更模式
     *
     * @type {'ROUTECHANGE' | 'CONTEXTCHANGE'}
     * @memberof RoutePickerController
     */
    m(this, "valueMode", "ROUTECHANGE");
    // 项布局面板
    m(this, "itemLayoutPanel");
  }
  /**
   * 当前视图
   *
   * @readonly
   * @type {(number)}
   * @memberof RoutePickerController
   */
  get currentView() {
    return this.parent.panel.view;
  }
  /**
   * 当前路由视图的层级
   *
   * @readonly
   * @type {(number)}
   * @memberof RoutePickerController
   */
  get routeDepth() {
    return this.parent.panel.view.modal.routeDepth;
  }
  /**
   * 当前视图重定向引用
   * @readonly
   * @type {(IData | undefined)}
   * @memberof RoutePickerController
   */
  get RedirectViewModel() {
    var o;
    return (o = this.parent.panel.model.appViewRefs) == null ? void 0 : o.find(
      (t) => t.name === "REDIRECT"
    );
  }
  async onInit() {
    if (super.onInit(), this.model.appDataEntityId) {
      if (this.model.appDEDataSetId && (this.interfaceName = this.model.appDEDataSetId), this.model.appDEACModeId && (this.deACMode = await q(
        this.model.appDEACModeId,
        this.model.appDataEntityId,
        this.context.srfappid
      ), this.deACMode)) {
        const { minorSortAppDEFieldId: t, minorSortDir: s } = this.deACMode;
        t && s && (this.sort = "".concat(t.toLowerCase(), ",").concat(s.toLowerCase())), this.deACMode.textAppDEFieldId && (this.textName = this.deACMode.textAppDEFieldId), this.deACMode.valueAppDEFieldId && (this.keyName = this.deACMode.valueAppDEFieldId), this.deACMode.deacmodeDataItems && (this.dataItems = [], this.deACMode.deacmodeDataItems.forEach(
          (c) => {
            c.id !== "value" && c.id !== "text" && this.dataItems.push(c);
          }
        )), this.deACMode.itemLayoutPanel && (this.itemLayoutPanel = this.deACMode.itemLayoutPanel);
      }
      this.routeKey = X(this.model.appDataEntityId);
    }
    if (this.model.uiactionGroup) {
      const t = this.model.uiactionGroup.uiactionGroupDetails || [];
      t.length > 0 && t.forEach((s) => {
        const c = s.uiactionId;
        if (c) {
          const d = new Y(
            s.id,
            this.context.srfappid,
            c
          );
          this.groupActionState.addState(s.id, d);
        }
      });
    }
    const { editorParams: o } = this.model;
    o && (o.ROUTEKEY && (this.routeKey = o.ROUTEKEY), o.SUFFIX && (this.suffix = o.SUFFIX), o.MODE && (this.valueMode = o.MODE), o.ENABLESEARCH && (this.enablesearch = Object.is(o.ENABLESEARCH, "true") || Object.is(o.ENABLESEARCH, "TRUE")));
  }
  /**
   * 加载实体数据集数据
   *
   * @param {string} query 模糊匹配字符串
   * @param {IData} data 表单数据
   * @returns {*}  {Promise<IHttpResponse<IData[]>>}
   * @memberof RoutePickerController
   */
  async getServiceData(o, t) {
    const { context: s, params: c } = this.handlePublicParams(
      t,
      this.context,
      this.params
    ), d = {};
    this.sort && !Object.is(this.sort, "") && Object.assign(d, { sort: this.sort }), o && Object.assign(d, { query: o }), Object.assign(d, { size: 1e3 });
    const f = ne(c, d);
    if (this.interfaceName)
      return await ibiz.hub.getApp(this.context.srfappid).deService.exec(
        this.model.appDataEntityId,
        this.interfaceName,
        s,
        f
      );
    throw new ae(this.model, "请配置实体和实体数据集");
  }
  /**
   * 计算回填数据
   *
   * @author lxm
   * @date 2022-10-24 16:10:24
   * @param {IData} data 选中数据
   * @returns {*}  {Promise<Array<{ id: string; value: any }>>}
   */
  async calcFillDataItems(o) {
    return this.deACMode ? this.dataItems.length === 0 ? [] : await Promise.all(
      this.dataItems.map((s) => {
        const c = o[s.appDEFieldId];
        return s.format || s.convertToCodeItemText && s.codeListId || s.customCode, { id: s.id, value: c };
      })
    ) : [];
  }
  /**
   * 分组行为项点击
   *
   * @param {IUIActionGroupDetail} detail
   * @param {MouseEvent} event
   * @return {*}  {Promise<void>}
   * @memberof RoutePickerController
   */
  async onActionClick(o, t) {
    const s = o.uiactionId;
    await $.execAndResolved(
      s,
      {
        context: this.context,
        params: this.params,
        data: [],
        view: this.parent.panel.view,
        event: t
      },
      o.appId
    );
  }
  /**
   * 获取路由主信息
   *
   * @param {RouteLocationNormalizedLoaded} route
   * @return {*}
   * @memberof RoutePickerController
   */
  async getRouteKey(o, t, s = !1) {
    let d = (await W(o, this.routeDepth)).context[this.routeKey];
    return !d && s && (d = t[0].srfkey), d;
  }
}
class he {
  constructor() {
    m(this, "formEditor");
    m(this, "gridEditor");
    this.formEditor = "RoutePicker", this.gridEditor = "RoutePicker";
  }
  async createController(n, o) {
    const t = new pe(n, o);
    return await t.init(), t;
  }
}
const A = /* @__PURE__ */ re({
  name: "RoutePicker",
  props: Z(),
  emits: ee(),
  setup(l, {
    emit: n
  }) {
    const o = te("route-picker"), t = l.controller, s = ue(), c = D(""), d = D({}), f = D({}), u = D([]), v = D("");
    let g = !1;
    const N = () => {
      d.value = u.value.find((e) => e[t.textName] === c.value) || {};
    }, C = V(() => {
      var e, i, a;
      return (a = (i = (e = f.value) == null ? void 0 : e.popperRef) == null ? void 0 : i.popperRef) == null ? void 0 : a.contentRef;
    });
    x(() => l.value, (e) => {
      (e || e === null) && (c.value = e, e === null && (c.value = "")), N(), ibiz.util.setBrowserTitle(c.value);
    }, {
      immediate: !0
    });
    const R = (e = 0) => {
      if (C.value) {
        const i = C.value.querySelector(".ibiz-route-picker__dropdown-list"), a = u.value.findIndex((r) => r[t.keyName] === d.value[t.keyName]);
        i && a > -1 && setTimeout(() => {
          const r = i.offsetHeight, h = Math.floor(r / 38);
          a + 1 > h ? i.scrollTop = 38 * (a + 1 - h) : i.scrollTop = 0;
        }, e);
      }
    };
    x(() => d.value, () => {
      R();
    });
    const P = () => {
      var e, i, a;
      f.value && ((e = f.value) != null && e.popperRef) && ((a = (i = f.value) == null ? void 0 : i.popperRef) == null || a.hide());
    }, L = () => {
      v.value || E(v.value);
    }, F = (e) => {
      var i;
      e.keyCode === 13 && (e.stopPropagation(), e.preventDefault(), E(v.value)), ((e == null ? void 0 : e.keyCode) === 38 || (e == null ? void 0 : e.keyCode) === 40) && ((i = e.target) == null || i.blur());
    }, b = (e) => {
      (e.keyCode === 13 || e.keyCode === 32) && (e.stopPropagation(), e.preventDefault());
    };
    let I = T;
    le(() => {
      I = se(window, "keyup", (e) => {
        g && (e.keyCode === 27 && P(), e.keyCode === 40 ? k("down") : e.keyCode === 38 ? k("up") : e.keyCode === 13 && k("enter"));
      }), f.value && (f.value.triggerKeys = []), C.value && C.value.addEventListener("keydown", b, !0);
    }), de(() => {
      I !== T && I(), C.value && C.value.removeEventListener("keydown", b);
    });
    const k = (e) => {
      let i = u.value.findIndex((a) => a[t.keyName] === d.value[t.keyName]);
      switch (e) {
        case "up":
          i--, (i === -1 || i === -2) && (i = u.value.length - 1), d.value = u.value[i];
          break;
        case "down":
          i++, i === u.value.length && (i = 0), d.value = u.value[i];
          break;
        case "enter":
          w(d.value, !1);
          break;
      }
    }, U = async (e) => {
      const i = e[t.keyName];
      if (await t.getRouteKey(s, u.value) === i)
        return;
      let r = s.fullPath;
      if (t.valueMode && t.valueMode === "ROUTECHANGE") {
        if (t.RedirectViewModel) {
          const G = await ibiz.hub.getAppView(t.RedirectViewModel.refAppViewId), S = t.context.clone();
          return Object.assign(S, {
            [t.routeKey]: i
          }), J(G, S, t.params, {});
        }
        const h = K(s);
        h.pathNodes[t.routeDepth - 2].context[t.routeKey] = i, h.pathNodes.splice(t.routeDepth), h.pathNodes[t.routeDepth - 1] && h.pathNodes[t.routeDepth - 1].srfnav && delete h.pathNodes[t.routeDepth - 1].srfnav, r = O(h);
      } else {
        const h = K(s);
        h.pathNodes[t.routeDepth - 1].context[t.routeKey] = i, r = O(h);
      }
      ibiz.openView.push(r);
    }, w = async (e, i) => {
      P();
      const a = await t.calcFillDataItems(e);
      a.length && a.forEach((h) => {
        n("change", h.value, h.id);
      });
      const r = {};
      Object.assign(r, e), Object.assign(r, {
        [t.keyName]: r[t.keyName] ? r[t.keyName] : r.srfkey,
        [t.textName]: r[t.textName] ? r[t.textName] : r.srfmajortext
      }), n("change", e[t.textName]), !(i && t.valueMode && t.valueMode === "CONTEXTCHANGE") && U(e);
    }, E = async (e, i) => {
      if (t.model.appDataEntityId) {
        let a = "";
        e !== l.value && (a = e.trim());
        const r = await t.getServiceData(a, l.data);
        r && (u.value = r.data, i && i instanceof Function && i(u.value));
      }
    }, M = V(() => ie(c.value));
    x(M, (e, i) => {
      e !== i && n("infoTextChange", e);
    }, {
      immediate: !0
    });
    const B = async () => {
      const e = await t.getServiceData("", l.data);
      if (e) {
        u.value = e.data;
        const i = await t.getRouteKey(s, u.value, !0), a = u.value.find((r) => r[t.keyName] === i);
        a && w(a, !0);
      }
    };
    return t.currentView.evt.on("onMounted", () => {
      B();
    }), ce(async () => {
      const e = await t.getRouteKey(s, u.value, !0), i = u.value.find((a) => a[t.keyName] === e);
      i && w(i, !1);
    }), {
      ns: o,
      c: t,
      dropDown: f,
      curValue: c,
      curSelect: d,
      valueText: M,
      items: u,
      query: v,
      onACSelect: w,
      onSearch: E,
      onKeyup: F,
      onInput: L,
      onVisibleChange: (e) => {
        g = e, g ? (E(""), R(300)) : (v.value = "", N());
      },
      onCommand: (e) => {
        w(e, !1);
      },
      renderGroupAction: () => {
        const {
          uiactionGroup: e
        } = t.model;
        if (e)
          return p("div", {
            class: o.e("group-action")
          }, [p(y("iBizActionToolbar"), {
            class: o.be("group", "header-actions"),
            actionDetails: e.uiactionGroupDetails,
            "actions-state": t.groupActionState,
            onActionClick: (i, a) => {
              t.onActionClick(i, a);
            }
          }, null)]);
      },
      renderPanelItemLayout: (e, i) => {
        const {
          context: a,
          params: r
        } = t;
        return p(y("iBizControlShell"), {
          data: e,
          modelData: i,
          context: a,
          params: r
        }, null);
      }
    };
  },
  render() {
    return this.readonly ? p("div", {
      class: (this.ns.b(), this.ns.m("readonly"))
    }, [this.valueText]) : p("div", {
      class: [this.ns.b(), this.ns.m("route"), this.disabled ? this.ns.m("disabled") : ""]
    }, [p("div", {
      class: [this.ns.e("dropdown")]
    }, [p(y("el-dropdown"), {
      trigger: "click",
      ref: "dropDown",
      "popper-class": this.ns.em("dropdown", "transfer"),
      onVisibleChange: this.onVisibleChange,
      onCommand: this.onCommand
    }, {
      default: () => p("div", null, [p("span", {
        class: this.ns.em("dropdown", "cur-text"),
        title: this.curValue || ""
      }, [this.curValue]), p(y("ion-icon"), {
        name: this.c.suffix
      }, null)]),
      dropdown: () => {
        var l;
        return p("div", null, [this.c.enablesearch && p(y("el-input"), {
          modelValue: this.query,
          "onUpdate:modelValue": (n) => this.query = n,
          placeholder: "搜索",
          onKeyup: this.onKeyup,
          onInput: this.onInput
        }, null), p("div", {
          class: this.ns.e("dropdown-list")
        }, [((l = this.items) == null ? void 0 : l.length) > 0 ? this.items.map((n) => p(y("el-dropdown-item"), {
          class: [this.ns.e("dropdown-item"), this.ns.is("active", n[this.c.textName] === this.curValue), this.ns.is("hover", n[this.c.keyName] === this.curSelect[this.c.keyName])],
          id: n[this.c.keyName],
          title: n[this.c.textName],
          command: n
        }, {
          default: () => [this.c.itemLayoutPanel ? this.renderPanelItemLayout(n, this.c.itemLayoutPanel) : p("span", {
            class: this.ns.em("dropdown-item", "text")
          }, [n[this.c.textName]])]
        })) : p(y("el-dropdown-item"), {
          class: this.ns.e("no-data")
        }, {
          default: () => [p(y("iBizNoData"), {
            text: "暂无数据"
          }, null)]
        })]), this.renderGroupAction()]);
      }
    })])]);
  }
}), me = oe(A, function(l) {
  l.component(A.name, A), Q("PICKER_ROUTE", () => new he());
}), Ae = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(l) {
    l.use(me);
  }
};
export {
  me as IBizRoutePicker,
  Ae as default
};
