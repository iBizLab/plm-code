import './style.css';
var _ = Object.defineProperty;
var q = (l, n, i) => n in l ? _(l, n, { enumerable: !0, configurable: !0, writable: !0, value: i }) : l[n] = i;
var f = (l, n, i) => (q(l, typeof n != "symbol" ? n + "" : n, i), i);
import { EditorController as X, ButtonContainerState as Y, getDeACMode as $, calcDeCodeNameById as J, UIActionButtonState as Q, UIActionUtil as W, openRedirectView as Z, registerEditorProvider as ee } from "@ibiz-template/runtime";
import { parseRouteViewData as te, getDataPickerProps as oe, getEditorEmits as ie, useNamespace as ae, renderString as se, route2routePath as K, routePath2string as T, withInstall as ne } from "@ibiz-template/vue3-util";
import { RuntimeModelError as re, listenJSEvent as le, NOOP as L, IBizContext as ce } from "@ibiz-template/core";
import { mergeDeepLeft as de } from "ramda";
import { defineComponent as ue, ref as D, computed as V, watch as N, onMounted as pe, onBeforeUnmount as he, onActivated as fe, createVNode as h, resolveComponent as y } from "vue";
import { useRoute as me } from "vue-router";
import { isUndefined as ye } from "lodash-es";
class ve extends X {
  constructor() {
    super(...arguments);
    /**
     * 主键属性名称
     */
    f(this, "keyName", "srfkey");
    /**
     * 主文本属性名称
     */
    f(this, "textName", "srfmajortext");
    /**
     * 数据集codeName
     */
    f(this, "interfaceName", "");
    /**
     * 自填模式sort排序
     */
    f(this, "sort", "");
    /**
     * 实体自填模式模型
     */
    f(this, "deACMode");
    /**
     * 自填数据项集合（已排除了value和text)
     */
    f(this, "dataItems", []);
    /**
     * 分组行为状态
     *
     * @type {IButtonContainerState}
     * @memberof RoutePickerController
     */
    f(this, "groupActionState", new Y());
    /**
     * 后缀图标
     *
     * @type {string}
     * @memberof RoutePickerController
     */
    f(this, "suffix", "");
    /**
     * 允许搜索
     *
     * @type {boolean}
     * @memberof RoutePickerController
     */
    f(this, "enablesearch", !1);
    /**
     * 路由属性标识
     *
     * @type {string}
     * @memberof RoutePickerController
     */
    f(this, "routeKey", "");
    /**
     * 值变更模式
     *
     * @type {'ROUTECHANGE' | 'CONTEXTCHANGE'}
     * @memberof RoutePickerController
     */
    f(this, "valueMode", "ROUTECHANGE");
    // 项布局面板
    f(this, "itemLayoutPanel");
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
    var i;
    return (i = this.parent.panel.model.appViewRefs) == null ? void 0 : i.find(
      (e) => e.name === "REDIRECT"
    );
  }
  async onInit() {
    if (super.onInit(), this.model.appDataEntityId) {
      if (this.model.appDEDataSetId && (this.interfaceName = this.model.appDEDataSetId), this.model.appDEACModeId && (this.deACMode = await $(
        this.model.appDEACModeId,
        this.model.appDataEntityId,
        this.context.srfappid
      ), this.deACMode)) {
        const { minorSortAppDEFieldId: e, minorSortDir: s } = this.deACMode;
        e && s && (this.sort = "".concat(e.toLowerCase(), ",").concat(s.toLowerCase())), this.deACMode.textAppDEFieldId && (this.textName = this.deACMode.textAppDEFieldId), this.deACMode.valueAppDEFieldId && (this.keyName = this.deACMode.valueAppDEFieldId), this.deACMode.deacmodeDataItems && (this.dataItems = [], this.deACMode.deacmodeDataItems.forEach(
          (d) => {
            d.id !== "value" && d.id !== "text" && this.dataItems.push(d);
          }
        )), this.deACMode.itemLayoutPanel && (this.itemLayoutPanel = this.deACMode.itemLayoutPanel);
      }
      this.routeKey = J(this.model.appDataEntityId);
    }
    if (this.model.uiactionGroup) {
      const e = this.model.uiactionGroup.uiactionGroupDetails || [];
      e.length > 0 && e.forEach((s) => {
        const d = s.uiactionId;
        if (d) {
          const c = new Q(
            s.id,
            this.context.srfappid,
            d
          );
          this.groupActionState.addState(s.id, c);
        }
      });
    }
    const { editorParams: i } = this.model;
    i && (i.ROUTEKEY && (this.routeKey = i.ROUTEKEY), i.SUFFIX && (this.suffix = i.SUFFIX), i.MODE && (this.valueMode = i.MODE), i.ENABLESEARCH && (this.enablesearch = Object.is(i.ENABLESEARCH, "true") || Object.is(i.ENABLESEARCH, "TRUE")));
  }
  /**
   * 加载实体数据集数据
   *
   * @param {string} query 模糊匹配字符串
   * @param {IData} data 表单数据
   * @returns {*}  {Promise<IHttpResponse<IData[]>>}
   * @memberof RoutePickerController
   */
  async getServiceData(i, e) {
    const { context: s, params: d } = this.handlePublicParams(
      e,
      this.context,
      this.params
    ), c = {};
    this.sort && !Object.is(this.sort, "") && Object.assign(c, { sort: this.sort }), i && Object.assign(c, { query: i }), Object.assign(c, { size: 1e3 });
    const m = de(d, c);
    if (this.interfaceName)
      return await ibiz.hub.getApp(this.context.srfappid).deService.exec(
        this.model.appDataEntityId,
        this.interfaceName,
        s,
        m
      );
    throw new re(this.model, "请配置实体和实体数据集");
  }
  /**
   * 计算回填数据
   *
   * @author lxm
   * @date 2022-10-24 16:10:24
   * @param {IData} data 选中数据
   * @returns {*}  {Promise<Array<{ id: string; value: any }>>}
   */
  async calcFillDataItems(i) {
    return this.deACMode ? this.dataItems.length === 0 ? [] : await Promise.all(
      this.dataItems.map((s) => {
        const d = i[s.appDEFieldId];
        return s.format || s.convertToCodeItemText && s.codeListId || s.customCode, { id: s.id, value: d };
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
  async onActionClick(i, e) {
    const s = i.uiactionId;
    Object.assign(this.context, {
      srfdefaulttoroutedepth: this.parent.panel.view.modal.routeDepth
    }), await W.execAndResolved(
      s,
      {
        context: this.context,
        params: this.params,
        data: [],
        view: this.parent.panel.view,
        event: e
      },
      i.appId
    );
  }
  /**
   * 获取路由主信息
   *
   * @param {RouteLocationNormalizedLoaded} route
   * @return {*}
   * @memberof RoutePickerController
   */
  async getRouteKey(i, e, s = !1) {
    let c = (await te(i, this.routeDepth)).context[this.routeKey];
    return !c && s && (c = e[0].srfkey), c;
  }
}
class Ce {
  constructor() {
    f(this, "formEditor");
    f(this, "gridEditor");
    this.formEditor = "RoutePicker", this.gridEditor = "RoutePicker";
  }
  async createController(n, i) {
    const e = new ve(n, i);
    return await e.init(), e;
  }
}
const A = /* @__PURE__ */ ue({
  name: "RoutePicker",
  props: oe(),
  emits: ie(),
  setup(l, {
    emit: n
  }) {
    const i = ae("route-picker"), e = l.controller, s = me(), d = D(""), c = D({}), m = D({}), u = D([]), v = D("");
    let g = !1;
    const R = () => {
      c.value = u.value.find((t) => t[e.textName] === d.value) || {};
    }, C = V(() => {
      var t, o, a;
      return (a = (o = (t = m.value) == null ? void 0 : t.popperRef) == null ? void 0 : o.popperRef) == null ? void 0 : a.contentRef;
    });
    N(() => l.value, (t) => {
      var o;
      (t || t === null) && (d.value = t, t === null && (d.value = "")), R(), (o = ibiz.util) == null || o.setBrowserTitle(d.value);
    }, {
      immediate: !0
    });
    const P = (t = 0) => {
      if (C.value) {
        const o = C.value.querySelector(".ibiz-route-picker__dropdown-list"), a = u.value.findIndex((r) => r[e.keyName] === c.value[e.keyName]);
        o && a > -1 && setTimeout(() => {
          const r = o.offsetHeight, p = Math.floor(r / 38);
          a + 1 > p ? o.scrollTop = 38 * (a + 1 - p) : o.scrollTop = 0;
        }, t);
      }
    };
    N(() => c.value, () => {
      P();
    });
    const b = () => {
      var t, o, a;
      m.value && ((t = m.value) != null && t.popperRef) && ((a = (o = m.value) == null ? void 0 : o.popperRef) == null || a.hide());
    }, U = () => {
      v.value || E(v.value);
    }, j = (t) => {
      var o;
      t.keyCode === 13 && (t.stopPropagation(), t.preventDefault(), E(v.value)), ((t == null ? void 0 : t.keyCode) === 38 || (t == null ? void 0 : t.keyCode) === 40) && ((o = t.target) == null || o.blur());
    }, M = (t) => {
      (t.keyCode === 13 || t.keyCode === 32) && (t.stopPropagation(), t.preventDefault());
    };
    let x = L;
    pe(() => {
      x = le(window, "keyup", (t) => {
        g && (t.keyCode === 27 && b(), t.keyCode === 40 ? I("down") : t.keyCode === 38 ? I("up") : t.keyCode === 13 && I("enter"));
      }), m.value && (m.value.triggerKeys = []), C.value && C.value.addEventListener("keydown", M, !0);
    }), he(() => {
      x !== L && x(), C.value && C.value.removeEventListener("keydown", M);
    });
    const I = (t) => {
      let o = u.value.findIndex((a) => a[e.keyName] === c.value[e.keyName]);
      switch (t) {
        case "up":
          o--, (o === -1 || o === -2) && (o = u.value.length - 1), c.value = u.value[o];
          break;
        case "down":
          o++, o === u.value.length && (o = 0), c.value = u.value[o];
          break;
        case "enter":
          w(c.value, !1);
          break;
      }
    }, B = async (t) => {
      const o = t[e.keyName];
      if (await e.getRouteKey(s, u.value) === o)
        return;
      let r = s.fullPath;
      if (e.valueMode && e.valueMode === "ROUTECHANGE") {
        if (e.RedirectViewModel) {
          const k = await ibiz.hub.getAppView(e.RedirectViewModel.refAppViewId), O = e.context.clone();
          return Object.assign(O, {
            [e.routeKey]: o
          }), Z(k, O, e.params, {});
        }
        const p = K(s);
        p.pathNodes[e.routeDepth - 2].context[e.routeKey] = o, p.pathNodes.splice(e.routeDepth), p.pathNodes[e.routeDepth - 1] && p.pathNodes[e.routeDepth - 1].srfnav && delete p.pathNodes[e.routeDepth - 1].srfnav, r = T(p);
      } else {
        const p = K(s), k = p.pathNodes[e.routeDepth - 1];
        ye(k.context) && Object.assign(p.pathNodes[e.routeDepth - 1], {
          context: ce.create()
        }), p.pathNodes[e.routeDepth - 1].context[e.routeKey] = o, r = T(p);
      }
      ibiz.openView.push(r);
    }, w = async (t, o) => {
      b();
      const a = await e.calcFillDataItems(t);
      a.length && a.forEach((p) => {
        n("change", p.value, p.id);
      });
      const r = {};
      Object.assign(r, t), Object.assign(r, {
        [e.keyName]: r[e.keyName] ? r[e.keyName] : r.srfkey,
        [e.textName]: r[e.textName] ? r[e.textName] : r.srfmajortext
      }), n("change", t[e.textName]), !(o && e.valueMode && e.valueMode === "CONTEXTCHANGE") && B(t);
    }, E = async (t, o) => {
      if (e.model.appDataEntityId) {
        let a = "";
        t !== l.value && (a = t.trim());
        const r = await e.getServiceData(a, l.data);
        r && (u.value = r.data, o && o instanceof Function && o(u.value));
      }
    }, S = V(() => se(d.value));
    N(S, (t, o) => {
      t !== o && n("infoTextChange", t);
    }, {
      immediate: !0
    });
    const F = async () => {
      const t = await e.getServiceData("", l.data);
      if (t) {
        u.value = t.data;
        const o = await e.getRouteKey(s, u.value, !0), a = u.value.find((r) => r[e.keyName] === o);
        a && w(a, !0);
      }
    };
    e.currentView.evt.on("onMounted", () => {
      F();
    }), fe(async () => {
      const t = await e.getRouteKey(s, u.value, !0), o = u.value.find((a) => a[e.keyName] === t);
      o && w(o, !1);
    });
    const G = (t) => {
      g = t, g ? (E(""), P(300)) : (v.value = "", R());
    }, z = (t) => {
      w(t, !1);
    }, H = () => {
      m.value && m.value.handleClose();
    };
    return {
      ns: i,
      c: e,
      dropDown: m,
      curValue: d,
      curSelect: c,
      valueText: S,
      items: u,
      query: v,
      onACSelect: w,
      onSearch: E,
      onKeyup: j,
      onInput: U,
      onVisibleChange: G,
      onCommand: z,
      renderGroupAction: () => {
        const {
          uiactionGroup: t
        } = e.model;
        if (t)
          return h("div", {
            class: i.e("group-action")
          }, [h(y("iBizActionToolbar"), {
            class: i.be("group", "header-actions"),
            actionDetails: t.uiactionGroupDetails,
            "actions-state": e.groupActionState,
            onActionClick: (o, a) => {
              e.onActionClick(o, a), H();
            }
          }, null)]);
      },
      renderPanelItemLayout: (t, o) => {
        const {
          context: a,
          params: r
        } = e;
        return h(y("iBizControlShell"), {
          data: t,
          modelData: o,
          context: a,
          params: r
        }, null);
      }
    };
  },
  render() {
    return h("div", {
      class: [this.ns.b(), this.ns.m("route"), this.disabled ? this.ns.m("disabled") : ""]
    }, [h("div", {
      class: [this.ns.e("dropdown")]
    }, [h(y("el-dropdown"), {
      trigger: "click",
      ref: "dropDown",
      "popper-class": this.ns.em("dropdown", "transfer"),
      onVisibleChange: this.onVisibleChange,
      onCommand: this.onCommand
    }, {
      default: () => h("div", null, [h("span", {
        class: this.ns.em("dropdown", "cur-text"),
        title: this.curValue || ""
      }, [this.curValue]), h(y("ion-icon"), {
        name: this.c.suffix
      }, null)]),
      dropdown: () => {
        var l;
        return h("div", null, [this.c.enablesearch && h(y("el-input"), {
          modelValue: this.query,
          "onUpdate:modelValue": (n) => this.query = n,
          placeholder: "搜索",
          onKeyup: this.onKeyup,
          onInput: this.onInput
        }, null), h("div", {
          class: this.ns.e("dropdown-list")
        }, [((l = this.items) == null ? void 0 : l.length) > 0 ? this.items.map((n) => h(y("el-dropdown-item"), {
          class: [this.ns.e("dropdown-item"), this.ns.is("active", n[this.c.textName] === this.curValue), this.ns.is("hover", n[this.c.keyName] === this.curSelect[this.c.keyName])],
          id: n[this.c.keyName],
          title: n[this.c.textName],
          command: n
        }, {
          default: () => [this.c.itemLayoutPanel ? this.renderPanelItemLayout(n, this.c.itemLayoutPanel) : h("span", {
            class: this.ns.em("dropdown-item", "text")
          }, [n[this.c.textName]])]
        })) : h(y("el-dropdown-item"), {
          class: this.ns.e("no-data")
        }, {
          default: () => [h(y("iBizNoData"), {
            text: "暂无数据"
          }, null)]
        })]), this.renderGroupAction()]);
      }
    })])]);
  }
}), we = ne(A, function(l) {
  l.component(A.name, A), ee("PICKER_ROUTE", () => new Ce());
}), be = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(l) {
    l.use(we);
  }
};
export {
  we as IBizRoutePicker,
  be as default
};
