import './style.css';
var Je = Object.defineProperty;
var Ke = (r, u, a) => u in r ? Je(r, u, { enumerable: !0, configurable: !0, writable: !0, value: a }) : r[u] = a;
var p = (r, u, a) => (Ke(r, typeof u != "symbol" ? u + "" : u, a), a);
import { useNamespace as X, getDataPickerProps as Ze, getEditorEmits as Ye, renderString as Ge, withInstall as qe } from "@ibiz-template/vue3-util";
import { EditorController as Xe, getDeACMode as Qe, UIActionUtil as et, OpenAppViewCommand as me, registerEditorProvider as tt } from "@ibiz-template/runtime";
import { RuntimeModelError as G } from "@ibiz-template/core";
import { mergeDeepLeft as st, clone as fe } from "ramda";
import { notNilEmpty as W } from "qx-util";
import { defineComponent as Q, ref as w, onMounted as ve, watch as z, createVNode as i, computed as T, onUnmounted as at, resolveComponent as P, onBeforeUnmount as it, withDirectives as lt, resolveDirective as nt, createTextVNode as k, nextTick as rt, isVNode as ot } from "vue";
import { isArray as ct } from "lodash-es";
class ge extends Xe {
  constructor() {
    super(...arguments);
    /**
     * 总数
     */
    p(this, "total", 0);
    /**
     * 当前人员数量
     */
    p(this, "currentNumber", -1);
    /**
     * 人员当前页
     */
    p(this, "page", 0);
    /**
     * 部门人员数据页数
     */
    p(this, "deptpage", 0);
    /**
     * 当前部门人员数量
     */
    p(this, "deptcurrentNumber", -1);
    /**
     * 部门人员总数
     */
    p(this, "depttotal", 0);
    /**
     * 每页数量
     */
    p(this, "size", 20);
    /**
     * 是否多选
     */
    p(this, "multiple", !0);
    /**
     * 多选时拼接的字符串
     */
    p(this, "separator", ",");
    /**
     *选择视图相关参数
     */
    p(this, "pickupView", null);
    /**
     *链接视图相关参数
     */
    p(this, "linkView", null);
    /**
     * 人员UI转化
     */
    p(this, "userFilterMap", {
      id: "id",
      name: "name"
    });
    /**
     * 部门人员UI转化
     */
    p(this, "deptFilterMap", {
      id: "id",
      name: "name"
    });
    /**
     *值项
     */
    p(this, "valueItem", "");
    /**
     * 主键属性名称
     */
    p(this, "keyName", "srfkey");
    /**
     * 主文本属性名称
     */
    p(this, "textName", "srfmajortext");
    /**
     * 数据集codeName
     */
    p(this, "interfaceName", "");
    /**
     * 自填模式sort排序
     */
    p(this, "sort", "");
    /**
     * 不支持AC（根据编辑器类型得）
     */
    p(this, "noAC", !1);
    /**
     * 不支持按钮（根据编辑器类型得）
     */
    p(this, "noButton", !1);
    /**
     * 实体自填模式模型
     */
    p(this, "deACMode");
    /**
     * 自填数据项集合（已排除了value和text)
     */
    p(this, "dataItems", []);
    // 对象标识属性
    p(this, "objectIdField", "");
    // 对象名称属性
    p(this, "objectNameField", "");
    // 对象值属性
    p(this, "objectValueField", "");
    // 人员请求地址
    p(this, "userUrl", "");
    // 部门请求地址
    p(this, "deptUrl", "");
    // 复制人员请求url,这是用来保证当配置的URL中的动态参数变化后可以刷新当前请求状态
    p(this, "copyUserUrl", "");
    // 复制部门人员请求url
    p(this, "copyDeptUrl", "");
    // 人员请求方式
    p(this, "userMethod", "post");
    // 部门人员请求方式
    p(this, "deptMethod", "post");
    /**
     * 上下文替换正则
     *
     */
    p(this, "contextReg", /\$\{context.[a-zA-Z_$][a-zA-Z0-9_$]{1,}\}/g);
    /**
     * 数据替换正则
     *
     */
    p(this, "dataReg", /\$\{data.[a-zA-Z_$][a-zA-Z0-9_$]{1,}\}/g);
    /**
     * 参数替换正则
     *
     */
    p(this, "paramsReg", /\$\{params.[a-zA-Z_$][a-zA-Z0-9_$]{1,}\}/g);
    /**
     * 值类型
     */
    p(this, "valueType", "OBJECTS");
    /**
     * 代码表的代码标识
     *
     */
    p(this, "codeListId", "");
    /**
     * 代码表值映射
     *
     */
    p(this, "codeListMap");
    /**
     * 关注类型属性
     *
     */
    p(this, "attentionTypeField", "type");
    /**
     * 自填充映射
     */
    p(this, "selfFillMap", {
      user_id: "user_id",
      user_name: "name"
    });
    /**
     * 默认选中项
     *
     */
    p(this, "defaultSelected", "");
    /**
     * 选中后默认关注值
     *
     */
    p(this, "defaultAttentionValue", "");
  }
  async onInit() {
    var e, h, o, c, d, y, M;
    if (super.onInit(), this.initParams(), this.valueItem = ((e = this.model.valueItemName) == null ? void 0 : e.toLowerCase()) || "", this.model.appDataEntityId && (this.model.appDEDataSetId && (this.interfaceName = this.model.appDEDataSetId), this.model.appDEACModeId && (this.deACMode = await Qe(
      this.model.appDEACModeId,
      this.model.appDataEntityId,
      this.context.srfappid
    ), this.deACMode))) {
      const { minorSortAppDEFieldId: b, minorSortDir: I } = this.deACMode;
      b && I && (this.sort = "".concat(b.toLowerCase(), ",").concat(I.toLowerCase())), this.deACMode.textAppDEFieldId && (this.textName = this.deACMode.textAppDEFieldId), this.deACMode.valueAppDEFieldId && (this.keyName = this.deACMode.valueAppDEFieldId), this.deACMode.deacmodeDataItems && (this.dataItems = [], this.deACMode.deacmodeDataItems.forEach(
        (f) => {
          f.id !== "value" && f.id !== "text" && this.dataItems.push(f);
        }
      ));
    }
    const a = [
      "PICKEREX_DROPDOWNVIEW",
      "PICKEREX_DROPDOWNVIEW_LINK",
      "PICKUPVIEW"
    ];
    this.model.editorType && a.includes(this.model.editorType) && this.initPickupViewParams(), this.objectIdField = (o = (h = this.model) == null ? void 0 : h.objectIdField) == null ? void 0 : o.toLowerCase(), this.objectNameField = (d = (c = this.model) == null ? void 0 : c.objectNameField) == null ? void 0 : d.toLowerCase(), this.objectValueField = (M = (y = this.model) == null ? void 0 : y.objectValueField) == null ? void 0 : M.toLowerCase();
  }
  /**
   * 初始化noAc和noButton
   */
  initParams() {
    var a, e, h, o, c, d, y, M;
    switch (this.model.editorType) {
      case "PICKEREX_NOAC":
      case "PICKEREX_NOAC_LINK":
        this.noAC = !0;
        break;
      case "PICKEREX_NOBUTTON":
        this.noButton = !0;
        break;
      default:
        this.noButton = !1, this.noAC = !1;
    }
    if (this.userUrl = this.editorParams.URL, this.deptUrl = this.editorParams.DEPTURL, this.userMethod = this.editorParams.USERMETHOD || "post", this.deptMethod = this.editorParams.DEPTMETHOD || "post", this.separator = this.editorParams.SEPARATOR || ",", (a = this.editorParams) != null && a.CODELISTID && (this.codeListId = (e = this.editorParams) == null ? void 0 : e.CODELISTID), (h = this.editorParams) != null && h.DEFAULTATNVALUE && (this.defaultAttentionValue = (o = this.editorParams) == null ? void 0 : o.DEFAULTATNVALUE), (c = this.editorParams) != null && c.VALUETYPE && (this.valueType = (d = this.editorParams) == null ? void 0 : d.VALUETYPE), this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "CODELISTMAP"))
      try {
        const b = JSON.parse((y = this.editorParams) == null ? void 0 : y.CODELISTMAP);
        Object.assign(this.codeListMap, b);
      } catch (b) {
        this.codeListMap = { FOLLOWED: [20, 30, 40], NOTFOLLOWING: [10] };
      }
    if (this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "SELFFILLMAP"))
      try {
        const b = JSON.parse((M = this.editorParams) == null ? void 0 : M.SELFFILLMAP);
        Object.assign(this.selfFillMap, b);
      } catch (b) {
        this.selfFillMap = {
          user_id: "user_id",
          user_name: "name"
        };
      }
    if (this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "USERMAP"))
      try {
        const b = JSON.parse(this.editorParams.USERMAP);
        Object.assign(this.userFilterMap, b);
      } catch (b) {
        this.userFilterMap = {
          id: "id",
          name: "name"
        };
      }
    if (this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "DEPTMAP"))
      try {
        const b = JSON.parse(this.editorParams.DEPTMAP);
        Object.assign(this.deptFilterMap, b);
      } catch (b) {
        this.deptFilterMap = {
          id: "id",
          name: "name"
        };
      }
  }
  /**
   * 初始化选择视图相关参数
   */
  async initPickupViewParams() {
    this.model.pickupAppViewId && (this.pickupView = await ibiz.hub.config.view.get(
      this.model.pickupAppViewId
    ));
  }
  /**
   * 初始化链接视图相关参数
   */
  async initLinkViewParams() {
    this.model.linkAppViewId && (this.linkView = await ibiz.hub.config.view.get(this.model.linkAppViewId));
  }
  /**
   * 重置状态
   */
  resetState() {
    this.total = 0, this.currentNumber = -1, this.page = 0, this.deptpage = 0, this.depttotal = 0, this.deptcurrentNumber = -1, this.copyDeptUrl = "", this.copyUserUrl = "";
  }
  /**
   * 加载更多
   */
  async loadMore(a, e, h = {}) {
    if (e === "user" && this.currentNumber < this.total) {
      const o = await this.getServiceData(e, a, h);
      if (o)
        return this.page += 1, this.currentNumber < 0 && (this.currentNumber += 1), this.currentNumber += this.size, this.total = o.total ? Number(o.total) : Number(o.headers["x-total"]), o.data.forEach((c) => {
          Object.keys(this.userFilterMap).forEach((d) => {
            c[d] = c[this.userFilterMap[d]];
          });
        }), o;
    } else if (e === "department" && this.deptcurrentNumber < this.depttotal) {
      const o = await this.getServiceData(e, a, h);
      if (o)
        return this.deptpage += 1, this.deptcurrentNumber < 0 && (this.deptcurrentNumber += 1), this.deptcurrentNumber += this.size, this.depttotal = o.total ? Number(o.total) : Number(o.headers["x-total"]), o.data.forEach((c) => {
          Object.keys(this.deptFilterMap).forEach((d) => {
            c[d] = c[this.deptFilterMap[d]];
          });
        }), o;
    }
  }
  /**
   * 触发界面行为组点击事件
   *
   * @param {IUIActionGroupDetail} detail
   * @param {GridRowState} row
   * @param {MouseEvent} event
   * @return {*}  {Promise<void>}
   * @memberof GridFieldColumnController
   */
  async onActionClick(a, e, h) {
    const o = a.uiactionId;
    await et.execAndResolved(
      o,
      {
        context: this.context,
        params: this.params,
        data: e,
        view: this.parent.form.ctx.view,
        event: h
      },
      a.appId
    );
  }
  /**
   * 填充字符串中的数据
   *
   * @author chitanda
   * @date 2021-04-23 20:04:17
   * @static
   * @param {string} str
   * @param {*} [context]
   * @param {*} [data]
   * @return {*}  {string}
   */
  fill(a, e, h, o) {
    if (W(a)) {
      if (W(e)) {
        const c = a.match(this.contextReg);
        c == null || c.forEach((d) => {
          const y = d.slice(10, d.length - 1);
          a = a.replace("${context.".concat(y, "}"), e[y] || "");
        });
      }
      if (W(h)) {
        const c = a.match(this.paramsReg);
        c == null || c.forEach((d) => {
          const y = d.slice(9, d.length - 1);
          a = a.replace("${params.".concat(y, "}"), h[y] || "");
        });
      }
      if (W(o)) {
        const c = a.match(this.dataReg);
        c == null || c.forEach((d) => {
          const y = d.slice(7, d.length - 1);
          a = a.replace("${data.".concat(y, "}"), o[y] || "");
        });
      }
    }
    return a;
  }
  /**
   * 加载实体数据集数据
   *
   * @param {string} tag 当前分类 user || department
   * @param {IData} data 表单数据
   * @param {string} query 模糊匹配字符串
   * @returns {*}  {Promise<IHttpResponse<IData[]>>}
   * @memberof PersonelSelectController
   */
  async getServiceData(a, e, h) {
    const { context: o, params: c } = this.handlePublicParams(
      e,
      this.context,
      this.params
    ), d = {};
    this.sort && !Object.is(this.sort, "") && Object.assign(d, { sort: this.sort }), Object.assign(d, { size: this.size }), h && Object.assign(d, h);
    const y = st(c, d);
    let M = "";
    const b = this.fill(this.userUrl, o, c, e).replaceAll(
      "//",
      "/"
    ), I = this.fill(this.deptUrl, o, c, e).replaceAll(
      "//",
      "/"
    );
    this.copyUserUrl = b, this.copyDeptUrl = I;
    let f = "post";
    const v = {};
    if (a === "user" ? (M = b, f = this.userMethod.toLowerCase(), Object.assign(v, { method: f, data: y })) : (M = I, f = this.deptMethod.toLowerCase(), Object.assign(v, { method: f, params: y })), M)
      return await ibiz.net.request(M, v);
    throw new G(this.model, "请配置数据接口地址");
  }
  /**
   * 打开数据选择视图
   *
   * @param {IData} data 数据对象
   * @param {IData[]} selectedData 选中项集合
   * @returns {*}  {(Promise<IData[] | undefined>)}
   * @memberof PersonelSelectController
   */
  async openPickUpView(a, e) {
    await this.initPickupViewParams();
    const { context: h, params: o } = this.handlePublicParams(
      a,
      this.context,
      this.params
    );
    if (e && (o.selectedData = e), !this.pickupView)
      throw new G(this.model, "请配置数据选择视图");
    const c = await ibiz.commands.execute(
      me.TAG,
      this.pickupView.id,
      h,
      o,
      { openMode: "POPUPMODAL" }
    );
    if (c && c.ok && c.data)
      return c.data;
    ibiz.log.debug("模态取消或关闭异常", c);
  }
  /**
   * 打开数据链接视图
   */
  async openLinkView(a) {
    const e = this.context.clone();
    a[this.valueItem] && (e.srfkey = a[this.valueItem]);
    const { context: h, params: o } = this.handlePublicParams(
      a,
      e,
      this.params
    ), { linkAppViewId: c } = this.model;
    if (!c)
      throw new G(this.model, "请配置数据链接视图");
    return ibiz.commands.execute(
      me.TAG,
      c,
      h,
      o
    );
  }
  /**
   * 计算回填数据
   *
   * @author lxm
   * @date 2022-10-24 16:10:24
   * @param {IData} data 选中数据
   * @returns {*}  {Promise<Array<{ id: string; value: any }>>}
   */
  async calcFillDataItems(a) {
    return this.deACMode ? this.dataItems.length === 0 ? [] : await Promise.all(
      this.dataItems.map((h) => {
        const c = a.map((d) => d[h.appDEFieldId]).join(this.separator);
        return h.format || h.convertToCodeItemText && h.codeListId || h.customCode, { id: h.id, value: c };
      })
    ) : [];
  }
  /**
   * 处理对象数据类型抛值
   * @param {IData} select
   * @return {*}
   * @author: zhujiamin
   * @Date: 2023-08-22 15:58:56
   */
  handleObjectParams(a) {
    const e = {};
    return this.objectIdField && Object.assign(e, {
      [this.objectIdField]: a[this.keyName]
    }), this.objectNameField && Object.assign(e, {
      [this.objectNameField]: a[this.textName]
    }), this.objectValueField && Object.assign(e, {
      [this.objectValueField]: fe(a)
    }), e;
  }
}
class ut {
  constructor() {
    p(this, "component", "IBizAttention");
    p(this, "formEditor", "IBizAttention");
    p(this, "gridEditor", "IBizAttention");
  }
  async createController(u, a) {
    const e = new ge(u, a);
    return await e.init(), e;
  }
}
const dt = /* @__PURE__ */ Q({
  name: "VirtualList",
  props: {
    items: {
      //  数据源
      type: Array,
      default: () => []
    },
    itemHeight: {
      //  每行高度
      type: Number,
      default: 36
    },
    showNum: {
      //  可视数量
      type: Number,
      default: 20
    }
  },
  emits: ["scrollEvent"],
  setup(r, {
    emit: u
  }) {
    const a = X("virtual-list-box"), e = w(36), h = w(), o = w([]), c = w(0), d = w(0), y = w(0), M = w(0), b = (v, F) => {
      u("scrollEvent", v, F);
    }, I = () => {
      d.value = Math.floor(M.value / r.itemHeight), y.value = d.value + r.showNum, o.value = r.items.slice(d.value, y.value);
      const v = M.value - M.value % r.itemHeight;
      c.value = v;
    }, f = () => {
      M.value = h.value.scrollTop, I(), b(e.value, M.value);
    };
    return ve(() => {
      setTimeout(() => {
        scroll();
      }, 1e3);
    }), z(() => r.items, () => {
      e.value = r.itemHeight * r.items.length, I();
    }, {
      immediate: !0,
      deep: !0
    }), {
      ns: a,
      contentHeight: e,
      showList: o,
      contentBox: h,
      top: c,
      onScroll: f
    };
  },
  render() {
    return i("div", {
      ref: "contentBox",
      class: this.ns.b(),
      onScroll: () => this.onScroll()
    }, [i("div", {
      class: this.ns.e("container"),
      style: "height:".concat(this.contentHeight, "px;")
    }, [i("div", {
      class: this.ns.e("content"),
      style: "top:".concat(this.top, "px;")
    }, [this.showList.map((r, u) => i("div", {
      key: u,
      class: this.ns.m("item")
    }, [this.$slots.default ? this.$slots.default({
      ...r,
      index: u
    }) : r.name]))])])]);
  }
});
const pt = /* @__PURE__ */ Q({
  name: "IBizFollow",
  props: {
    readonly: {
      type: Boolean
    },
    disabled: {
      type: Boolean
    },
    value: {
      type: String
    },
    codeListId: {
      type: String
    },
    codeListMap: {
      type: Object
    },
    controller: {
      type: ge,
      required: !0
    },
    defaultSelected: {
      type: String
    }
  },
  emits: {
    /** 值变更事件 */
    change: (r, u) => !0,
    /** 失焦事件 */
    blur: (r) => !0,
    /** 聚焦事件 */
    focus: (r) => !0,
    /** 回车事件 */
    enter: (r) => !0,
    /** 信息文本变更事件 */
    infoTextChange: (r) => !0
  },
  setup(r, {
    emit: u
  }) {
    const a = X("follow"), e = r.controller, h = w(), o = w(!1), c = w(!1), d = w(), y = w(!1), M = w(!1), b = w(null), I = w(!1), f = w([]), v = T(() => r.codeListMap || {}), F = T(() => ({})), O = async () => {
      if (y.value = !0, r.codeListId) {
        const E = await ibiz.hub.getApp(e.context.srfappid).codeList.get(r.codeListId, e.context, e.params);
        E && E.length > 0 && (f.value = E), o.value = !0;
      }
      y.value = !1;
    }, L = (g) => {
      var A, S;
      b.value = g, ((S = (A = v.value) == null ? void 0 : A.FOLLOWED) == null ? void 0 : S.find((R) => String(R) === String(g))) ? M.value = !0 : M.value = !1;
    };
    z(
      () => r.value,
      // eslint-disable-next-line @typescript-eslint/no-unused-vars
      async (g, E) => {
        var S;
        let A = g;
        !g && r.codeListMap && (A = ((S = v.value) == null ? void 0 : S.NOTFOLLOWING[0]) || ""), L(A);
      },
      {
        immediate: !0,
        deep: !0
      }
    );
    const U = (g) => {
      g ? c.value = g : setTimeout(() => {
        c.value = g;
      }, 100);
    }, D = T({
      get() {
        var g;
        return (g = r.value) == null ? void 0 : g.toString();
      },
      set(g) {
        u("change", g), U(!1);
      }
    }), j = T(() => {
      const g = Array.isArray(D.value) ? D.value : [D.value], E = f.value, A = [];
      return g.forEach((S) => {
        E.forEach((R) => {
          R.value === S && A.push(R.text);
        });
      }), A.join(",");
    });
    z(j, (g, E) => {
      g !== E && u("infoTextChange", g);
    }, {
      immediate: !0
    });
    const B = (g) => f.value.find((A) => A.text === g), _ = async (g) => {
      I.value = g, g && !o.value && await O();
    }, V = (g) => {
      b.value = g.value, L(g.value), u("change", g.value);
    }, J = (g) => {
      var E;
      (g.key === "Escape" || g.keyCode === 27) && (g.stopPropagation(), (E = h.value) == null || E.handleClose());
    };
    return at(() => {
    }), {
      ns: a,
      curValue: D,
      items: f,
      valueText: j,
      editorRef: d,
      cssVars: F,
      isEditable: c,
      isLoading: y,
      followState: M,
      selectd: b,
      showState: I,
      dropdownRef: h,
      setEditable: U,
      getCodeListItem: B,
      onShowChange: _,
      onItemClick: V,
      handleKeyDown: J
    };
  },
  render() {
    const r = i("div", {
      class: [this.ns.e("showcase"), this.showState ? "is-active" : ""]
    }, [i("span", {
      class: this.ns.em("showcase", "icon")
    }, [i("svg", {
      viewBox: "0 0 16 16",
      xmlns: "http://www.w3.org/2000/svg",
      height: "1em",
      width: "1em",
      focusable: "false"
    }, [i("g", {
      id: "follow/with/interest",
      "stroke-width": "1",
      "fill-rule": "evenodd"
    }, [i("path", {
      d: "M8 3.4c2.823 0 5.04 1.367 7.38 3.637a2.037 2.037 0 0 1 0 2.925C13.04 12.232 10.824 13.6 8 13.6c-2.823 0-5.032-1.364-7.376-3.637a2.037 2.037 0 0 1 0-2.925C2.967 4.764 5.176 3.4 8 3.4zm0 1.2c-2.417 0-4.405 1.228-6.542 3.3a.837.837 0 0 0 0 1.2C3.596 11.173 5.584 12.4 8 12.4s4.413-1.231 6.546-3.3a.837.837 0 0 0 0-1.2C12.412 5.83 10.415 4.6 8 4.6zM8 11a2.5 2.5 0 1 1 0-5 2.5 2.5 0 0 1 0 5zm0-1.2a1.3 1.3 0 1 0 0-2.6 1.3 1.3 0 0 0 0 2.6z",
      id: "attention"
    }, null)])])]), i("span", {
      class: this.ns.em("showcase", "text")
    }, [this.followState ? "已关注" : "未关注"])]), u = i(P("el-dropdown"), {
      "popper-class": this.ns.b("popover"),
      ref: (a) => {
        this.dropdownRef = a;
      },
      trigger: "click",
      placement: "top-start",
      onVisibleChange: this.onShowChange,
      onKeydown: (a) => {
        this.handleKeyDown(a);
      }
    }, {
      default: () => r,
      dropdown: () => i(P("el-dropdown-menu"), {
        class: this.ns.be("popper", "dropdown-menu")
      }, {
        default: () => this.items.map((a, e) => i(P("el-dropdown-item"), {
          onClick: () => this.onItemClick(a)
        }, {
          default: () => [i("div", {
            class: [this.ns.b("content"), String(this.selectd) === String(a.value) ? "is-active" : ""]
          }, [i("div", {
            class: this.ns.em("item", "text")
          }, [a.text]), i("div", {
            class: this.ns.em("item", "tooltip")
          }, [a.tooltip])]), e === this.items.length - 1 ? null : i("div", {
            class: this.ns.em("item", "divider")
          }, [i(P("el-divider"), null, null)])]
        }))
      })
    });
    return i("div", {
      class: [this.ns.b(), this.disabled ? this.ns.m("disabled") : "", this.readonly ? this.ns.m("readonly") : "", this.ns.is("editable", this.isEditable)],
      style: this.cssVars
    }, [this.readonly ? r : u]);
  }
});
class ht {
  /**
   * 计算选中项绘制个数 多选场景需计算显示人员是否超出
   * @author ljx
   * @date 2024-03-05 02:42:45
   * @param {IData} values 选中项key值集合
   * @returns {number} selRenderNum
   */
  static calcSelItemRenderNum(u, a) {
    let e = 0;
    if (a && (u == null ? void 0 : u.length) > 0) {
      const h = (a == null ? void 0 : a.offsetWidth) || 0, o = window.getComputedStyle(a), c = parseInt(o.marginLeft, 10), d = parseInt(o.marginRight, 10), y = parseInt(o.paddingLeft, 10), M = parseInt(o.paddingRight, 10), b = c + d + y + M, I = 70, f = 33, v = 28, F = 8, O = (v + F) * u.length;
      h - b - I - f - O < 0 && (e = Math.floor(
        (h - b - I - f) / (v + F)
      ), e -= 1);
    }
    return e;
  }
}
function mt(r) {
  return typeof r == "function" || Object.prototype.toString.call(r) === "[object Object]" && !ot(r);
}
const q = /* @__PURE__ */ Q({
  name: "IBizAttention",
  props: Ze(),
  emits: Ye(),
  setup(r, {
    emit: u
  }) {
    const a = X("attention"), e = r.controller, h = w(""), o = w([]), c = w([]), d = w(""), y = w(!1), M = w(!1), b = w(""), I = w([]), f = w("user"), v = w([]), F = w(!1), O = w(!1), L = w(!1), U = w(""), D = w(), j = w(), B = w(""), _ = w();
    let V = 0;
    const J = T(() => (r == null ? void 0 : r.readonly) || e.context.srfreadonly), g = T(() => !!(r.controlParams && r.controlParams.editmode === "hover")), E = T(() => Ge(h.value)), A = (t) => {
      t.preventDefault(), t.stopPropagation();
    }, S = () => {
      var l;
      const t = [], s = [];
      B.value = "", ((l = v.value) == null ? void 0 : l.length) > 0 && v.value.forEach((n) => {
        t.push(n[e.selfFillMap.user_id]), s.push(n[e.selfFillMap.user_name]), n[e.selfFillMap.user_id] === e.context.srfuserid && (B.value = n[e.attentionTypeField]);
      }), d.value = t == null ? void 0 : t.toString(), h.value = s == null ? void 0 : s.toString();
    }, R = (t) => {
      var s, l;
      return (l = (s = e.codeListMap) == null ? void 0 : s.FOLLOWED) == null ? void 0 : l.some((n) => String(n) === String(t));
    }, K = () => {
      const t = d.value.split(e.separator);
      V = ht.calcSelItemRenderNum(t, j.value), d.value = "", S();
    };
    z(() => r.value, (t) => {
      if (t)
        if (e.valueType === "OBJECT")
          h.value = t ? t[e.objectNameField] : null;
        else if (e.valueType === "OBJECTS") {
          const s = ct(t) ? t : [];
          v.value = [], s.forEach((l) => {
            const n = fe(l);
            e.selfFillMap.user_id && e.selfFillMap.user_name && Object.assign(n, {
              id: l[e.selfFillMap.user_id],
              name: l[e.selfFillMap.user_name],
              [e.attentionTypeField]: l[e.attentionTypeField]
            }), e.objectValueField && (Object.assign(n, {
              ...l[e.objectValueField]
            }), delete n[e.objectValueField]), v.value.push(n);
          }), S();
        } else
          h.value = t;
      else
        h.value = "", v.value = [];
      K();
    }, {
      immediate: !0
    });
    const be = T(() => r.data && r.data[e.valueItem] || void 0);
    z(be, (t, s) => {
      t !== s && (d.value = t, t === null && (v.value = [], u("change", null)));
    }, {
      immediate: !0,
      deep: !0
    });
    const ee = (t) => {
      t ? M.value = t : setTimeout(() => {
        M.value = t;
      }, 100);
    }, $ = () => {
      const t = v.value.map((s) => {
        const l = {};
        return Object.assign(l, {
          [e.selfFillMap.user_id]: s.id,
          [e.selfFillMap.user_name]: s.name,
          [e.attentionTypeField]: s[e.attentionTypeField]
        }), l;
      });
      u("change", t);
    }, we = (t, s) => {
      A(s);
      const l = v.value.findIndex((n) => n.id === t.id);
      if (l > -1 && v.value.splice(l, 1), e.valueItem) {
        const n = v.value.map((m) => m.id);
        u("change", n.join(e.separator), e.valueItem);
      }
      if (e.valueType === "OBJECTS")
        $();
      else {
        const n = v.value.map((m) => m.name);
        u("change", n.join(e.separator));
      }
    }, ye = async (t) => {
      b.value && (f.value === "user" ? o.value.unshift(t) : c.value.unshift(t));
      const s = {};
      if (Object.assign(s, t), f.value === "user") {
        Object.assign(s, {
          [e.userFilterMap.id]: s[e.userFilterMap.id] ? s[e.userFilterMap.id] : s.srfkey,
          [e.userFilterMap.name]: s[e.userFilterMap.name] ? s[e.userFilterMap.name] : s.srfmajortext
        });
        const l = v.value.findIndex((n) => n.id === s[e.userFilterMap.id]);
        l < 0 ? v.value.push({
          id: s[e.userFilterMap.id],
          name: s[e.userFilterMap.name],
          [e.attentionTypeField]: e.defaultAttentionValue
        }) : v.value.splice(l, 1);
      } else {
        Object.assign(s, {
          [e.deptFilterMap.id]: s[e.deptFilterMap.id] ? s[e.deptFilterMap.id] : s.srfkey,
          [e.deptFilterMap.name]: s[e.deptFilterMap.name] ? s[e.deptFilterMap.name] : s.srfmajortext
        });
        const l = v.value.findIndex((n) => n.id === s[e.deptFilterMap.id]);
        l < 0 ? v.value.push({
          id: s[e.deptFilterMap.id],
          name: s[e.deptFilterMap.name],
          [e.attentionTypeField]: e.defaultAttentionValue
        }) : v.value.splice(l, 1);
      }
      if (e.multiple) {
        if (e.valueItem) {
          const n = v.value.map((m) => m.id);
          u("change", n.join(e.separator), e.valueItem);
        }
        const l = v.value.map((n) => n.name);
        e.valueType === "OBJECTS" ? $() : u("change", l.join(e.separator));
      } else {
        const l = await e.calcFillDataItems([t]);
        if (l.length && l.forEach((n) => {
          u("change", n.value, n.id);
        }), e.valueItem && (f.value === "user" ? u("change", s[e.userFilterMap.id], e.valueItem) : u("change", s[e.deptFilterMap.id], e.valueItem)), e.valueType === "OBJECT")
          u("change", e.handleObjectParams(s));
        else if (e.valueType === "OBJECTS") {
          const n = {};
          f.value === "user" ? Object.assign(n, {
            id: s[e.userFilterMap.id],
            name: s[e.userFilterMap.name]
          }) : Object.assign(n, {
            id: s[e.deptFilterMap.id],
            name: s[e.deptFilterMap.name]
          }), v.value = [n], $();
        } else
          f.value === "user" ? u("change", t[e.userFilterMap.name]) : u("change", t[e.deptFilterMap.name]);
        L.value = !1;
      }
      e.valueType !== "OBJECTS" && u("blur", t), ee(!1);
    }, Me = (t, s) => {
      t.forEach((l) => {
        const n = o.value.findIndex((m) => m[s] === l[s]);
        n > -1 ? o.value.splice(n, 1, l) : o.value.push(l);
      });
    }, N = async (t = !1) => {
      if (b.value)
        return;
      F.value = !0;
      const s = {};
      f.value === "department" ? s.page = e.deptpage : s.page = e.page;
      try {
        const l = await e.loadMore(r.data, f.value, s);
        l && (f.value === "user" ? o.value.length === 0 ? o.value = l.data : Me(l.data, e.userFilterMap.id) : c.value.length === 0 ? c.value = l.data : c.value.push(...l.data));
      } catch (l) {
        F.value = !1;
      }
      F.value = !1;
    }, te = (t) => {
      const {
        dataItems: s
      } = e;
      s != null && s.length && s.forEach((l) => {
        u("change", null, l.id);
      }), e.valueItem && u("change", null, e.valueItem), e.valueType === "OBJECTS" ? u("change", []) : (u("change", null), u("blur", t)), t.stopPropagation(), t.preventDefault();
    }, Ee = (t) => {
      if (!e.codeListMap)
        return;
      if (R(String(t))) {
        const l = v.value.find((n) => {
          var m;
          return n[e.selfFillMap.user_id] === ((m = e.context) == null ? void 0 : m.srfuserid);
        });
        if (l)
          Object.assign(l, {
            [e.attentionTypeField]: t
          });
        else {
          const n = {
            id: e.context.srfuserid,
            name: e.context.srfusername,
            [e.attentionTypeField]: t
          };
          v.value.push(n);
        }
      } else {
        const l = v.value.findIndex((n) => {
          var m;
          return n[e.selfFillMap.user_id] === ((m = e.context) == null ? void 0 : m.srfuserid);
        });
        l > -1 && v.value.splice(l, 1);
      }
      S(), $();
    };
    z(E, (t, s) => {
      t !== s && e.valueType !== "OBJECTS" && u("infoTextChange", t);
    }, {
      immediate: !0
    });
    const se = async (t) => {
      F.value = !0;
      try {
        const s = {};
        Object.assign(s, {
          query: t,
          size: 1e3
        });
        const l = await e.getServiceData(f.value, r.data, s);
        l && (f.value === "user" ? l.data.forEach((n) => {
          Object.keys(e.userFilterMap).forEach((m) => {
            n[m] = n[e.userFilterMap[m]];
          });
        }) : l.data.forEach((n) => {
          Object.keys(e.deptFilterMap).forEach((m) => {
            n[m] = n[e.deptFilterMap[m]];
          });
        }), I.value = l.data, F.value = !1);
      } catch (s) {
        F.value = !1;
      }
    }, ae = (t) => {
      if (f.value !== t) {
        if (f.value = t, b.value) {
          se(b.value);
          return;
        }
        f.value === "user" && o.value.length === 0 && N(), f.value === "department" && c.value.length === 0 && N();
      }
    }, Fe = () => {
      const t = document.documentElement;
      return t ? getComputedStyle(t).getPropertyValue("--ibiz-color-primary") : null;
    }, Ie = (t) => /[\u4E00-\u9FA5]/.test(t), Ae = (t) => /[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(t), Z = (t) => {
      if (!t)
        return "";
      let s = 0;
      for (let H = 0; H < t.length; H++)
        if (Ie(t))
          s = t.charCodeAt(H) + ((s << 5) - s), s = s & s;
        else {
          const We = t.charCodeAt(H);
          s += We.toString(16);
        }
      const l = String(s).substring(0, 6), n = parseInt(l.substring(0, 2), 16), m = parseInt(l.substring(2, 4), 16), C = parseInt(l.substring(4, 6), 16), x = "#".concat(n.toString(16).padStart(2, "0")).concat(m.toString(16).padStart(2, "0")).concat(C.toString(16).padStart(2, "0"));
      return x === "#FFFFFF" && Fe() || x;
    }, Ce = (t) => {
      clearTimeout(_.value), _.value = setTimeout(() => {
        !t && t !== 0 ? N() : se(t), clearTimeout(_.value);
      }, 300);
    }, Se = (t) => {
      t.forEach((s) => {
        if (s.capLanguageRes && s.capLanguageRes.lanResTag) {
          const l = ibiz.i18n.t(s.capLanguageRes.lanResTag, s.caption);
          Object.assign(s, {
            caption: l
          });
        }
        if (s.tooltipLanguageRes && s.tooltipLanguageRes.lanResTag) {
          const l = ibiz.i18n.t(s.tooltipLanguageRes.lanResTag, s.tooltip);
          Object.assign(s, {
            caption: l
          });
        }
      });
    }, Pe = async (t, s) => {
      await e.onActionClick(t, [r.data], s);
    }, xe = (t) => b.value ? I.value : t, ie = () => {
      O.value = !1;
    }, Le = () => i(P("el-input"), {
      class: a.be("select-modal", "search-input"),
      ref: D,
      modelValue: b.value,
      "onUpdate:modelValue": (t) => b.value = t,
      placeholder: "搜索",
      onInput: (t) => Ce(t)
    }, {
      suffix: () => i("svg", {
        viewBox: "0 0 16 16",
        xmlns: "http://www.w3.org/2000/svg",
        height: "1em",
        width: "1em",
        preserveAspectRatio: "xMidYMid meet",
        focusable: "false"
      }, [i("g", {
        id: "atwnormal/search",
        "stroke-width": "1",
        "fill-rule": "evenodd"
      }, [i("path", {
        d: "M6.751 12.303A5.557 5.557 0 0 1 1.2 6.751C1.2 3.691 3.69 1.2 6.751 1.2a5.558 5.558 0 0 1 5.551 5.551 5.557 5.557 0 0 1-5.551 5.552M6.751 0a6.751 6.751 0 1 0 4.309 11.949l3.855 3.855a.6.6 0 1 0 .849-.849l-3.854-3.853A6.751 6.751 0 0 0 6.751 0",
        id: "atwFill-1"
      }, null)])])
    }), Te = () => i("div", {
      class: a.be("select-modal", "select-state")
    }, [i("div", {
      class: [a.bem("select-modal", "select-state", "select-slider"), a.is("left", f.value === "user"), a.is("right", f.value !== "user")]
    }, null), i("div", {
      class: a.bem("select-modal", "select-state", "select-personel"),
      onClick: () => ae("user")
    }, [k("人员")]), i("div", {
      class: a.bem("select-modal", "select-state", "select-department"),
      onClick: () => ae("department")
    }, [k("部门")])]), Oe = (t) => i("div", {
      class: a.bem("select-modal", "actions", "item"),
      title: t.tooltip,
      onClick: (s) => Pe(t, s)
    }, [t.showIcon && t.sysImage && i(P("iBizIcon"), {
      icon: t.sysImage
    }, null)]), De = () => {
      var s;
      const t = ((s = e.model.uiactionGroup) == null ? void 0 : s.uiactionGroupDetails) || [];
      return Se(t), i("div", {
        class: a.be("select-modal", "actions")
      }, [t.map((l) => Oe(l))]);
    }, je = () => i("div", {
      class: a.be("select-modal", "select")
    }, [Te(), De()]), Ne = (t) => {
      if (e.multiple) {
        if (d.value)
          return d.value.split(e.separator).findIndex((n) => n === t) > -1 ? i("div", {
            class: a.bem("select-modal", "personel-list", "icon")
          }, [i("i", {
            class: "fa fa-check",
            "aria-hidden": "true"
          }, null)]) : null;
      } else
        return d.value === t ? i("div", {
          class: a.bem("select-modal", "personel-list", "icon")
        }, [i("i", {
          class: "fa fa-check",
          "aria-hidden": "true"
        }, null)]) : null;
    }, Y = (t) => {
      if (t && t.toString().length < 2)
        return t;
      if (t && t.toString().length >= 2) {
        if (Ae(t)) {
          const m = t.split("").find((x) => /[a-zA-Z]/.test(x)) || "", C = t.split("").find((x) => /[\u4E00-\u9FA5]/.test(x)) || "";
          return "".concat(m).concat(C).toLowerCase();
        }
        return /[a-zA-Z]/.test(t) ? t.split("").filter((m) => /[a-zA-Z]/.test(m)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(t) ? t.split("").filter((m) => /[\u4E00-\u9FA5]/.test(m)).slice(-2).join("") : t.replaceAll(" ", "").substring(0, 2);
      }
    }, le = (t) => {
      const s = f.value === "user" ? t[e.userFilterMap.name] || t.name : t[e.deptFilterMap.name] || t.name, l = f.value === "user" ? t[e.userFilterMap.id] : t[e.deptFilterMap.id];
      return i("div", {
        class: [a.bem("select-modal", "personel-list", "item"), a.is("selected", d.value === l)],
        onClick: () => ye(t)
      }, [i("div", {
        class: a.bem("select-modal", "personel-list", "text")
      }, [i("div", {
        class: a.bem("select-modal", "personel-list", "text-img"),
        style: "background-color:".concat(Z(s))
      }, [Y(s)]), i("div", {
        class: a.bem("select-modal", "personel-list", "text-label")
      }, [s]), l === e.context.srfuserid ? i("div", {
        class: a.bem("select-modal", "personel-list", "myself")
      }, [k("我自己")]) : null]), Ne(l)]);
    }, ke = (t, s) => {
      const {
        context: l,
        params: n
      } = e;
      return i(P("iBizControlShell"), {
        class: a.b("panel-item"),
        data: t,
        modelData: s,
        context: l,
        params: n
      }, null);
    }, Ve = (t, s) => i(P("el-popover"), {
      target: "hover",
      placement: "right",
      offset: 24,
      width: "auto"
    }, {
      reference: () => le(t),
      default: () => ke(t, s)
    }), Re = (t, s) => {
      O.value && (f.value === "user" ? t - s < 305 && (F.value || N()) : t - s < 265 && (F.value || N()));
    }, ne = (t) => {
      var n;
      const s = xe(t), l = (n = e.deACMode) == null ? void 0 : n.itemLayoutPanel;
      return i(dt, {
        items: s,
        itemHeight: 36,
        class: [a.be("select-modal", "personel-list"), a.be("select-modal", "personel-list-".concat(f.value))],
        onScrollEvent: (m, C) => Re(m, C)
      }, {
        default: (m) => l ? Ve(m, l) : le(m)
      });
    }, re = (t) => {
      y.value = t;
    }, ze = () => i("div", {
      class: a.be("select-modal", "deptpersonel")
    }, [i("div", {
      class: a.bem("select-modal", "deptpersonel", "dept")
    }, [i("div", {
      class: "collpase-icon"
    }, [y.value ? i("i", {
      class: "fa fa-angle-right",
      "aria-hidden": "true",
      onClick: () => re(!1)
    }, null) : i("i", {
      class: "fa fa-angle-down",
      "aria-hidden": "true",
      onClick: () => re(!0)
    }, null)]), i("svg", {
      viewBox: "0 0 16 16",
      xmlns: "http://www.w3.org/2000/svg",
      height: "1em",
      width: "1em",
      preserveAspectRatio: "xMidYMid meet",
      focusable: "false"
    }, [i("g", {
      id: "aqf1.Base基础/1.icon图标/2.normal/部门",
      "stroke-width": "1",
      "fill-rule": "evenodd"
    }, [i("path", {
      d: "M9 1a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-.39l-.016 2.138H11.5a2.1 2.1 0 0 1 2.095 1.95l.005.15V11h.4a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-2a1 1 0 0 1 1-1h.4V9.238a.9.9 0 0 0-.787-.893l-.113-.007h-7a.9.9 0 0 0-.893.787l-.007.113V11H4a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1v-2a1 1 0 0 1 1-1h.4V9.238a2.1 2.1 0 0 1 1.95-2.094l.15-.006h2.894L7.41 5H7a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h2zm4.8 11.2h-1.6v1.6h1.6v-1.6zm-10 0H2.2v1.6h1.6v-1.6zm5-10H7.2v1.6h1.6V2.2z",
      id: "aqf形状结合"
    }, null)])]), i("span", null, ["".concat(e.context.srfusername, "的团队")]), i("span", null, [k("·")]), i("span", null, [e.depttotal])]), y.value ? null : i("div", {
      class: a.bem("select-modal", "deptpersonel", "dept-person")
    }, [ne(c.value)])]), oe = () => lt(i("div", {
      class: a.b("select-modal"),
      onPointerdown: A,
      onPointerup: A,
      onClick: A
    }, [Le(), je(), f.value === "user" ? ne(o.value) : ze()]), [[nt("loading"), F.value]]), ce = () => i("div", {
      class: a.b("no-select-value")
    }, [i("svg", {
      viewBox: "0 0 16 16",
      xmlns: "http://www.w3.org/2000/svg",
      height: "1em",
      width: "1em",
      preserveAspectRatio: "xMidYMid meet",
      focusable: "false"
    }, [i("g", {
      id: "azeaction/user-add",
      "stroke-width": "1"
    }, [i("path", {
      d: "M7.9.4a4.1 4.1 0 1 1-.265 8.192.593.593 0 0 1-.268.126 6.411 6.411 0 0 0-4.624 3.698A6.375 6.375 0 0 0 2.2 15 .6.6 0 0 1 1 15c0-1.07.222-2.11.645-3.069a7.622 7.622 0 0 1 4.069-3.963A4.1 4.1 0 0 1 7.9.4zm4.6 9.9a.6.6 0 0 1 .592.503l.008.097-.001 1.399 1.401.001a.6.6 0 0 1 .592.503l.008.097a.6.6 0 0 1-.503.592l-.097.008-1.401-.001.001 1.401a.6.6 0 0 1-.503.592l-.097.008a.6.6 0 0 1-.592-.503L11.9 14.9v-1.401l-1.4.001a.6.6 0 0 1-.592-.503L9.9 12.9a.6.6 0 0 1 .503-.592l.097-.008h1.4v-1.4a.6.6 0 0 1 .503-.592l.097-.008zM7.9 1.6a2.9 2.9 0 1 0 0 5.8 2.9 2.9 0 0 0 0-5.8z",
      id: "aze形状结合"
    }, null)])]), i("span", null, [k("未设置")])]), Ue = () => i("div", {
      class: a.b("no-select-value")
    }, [i("span", null, [k("未设置")])]), ue = () => {
      var t;
      if (e.multiple) {
        const s = [];
        if (d.value) {
          const n = d.value.split(e.separator), m = E.value.split(e.separator);
          n.forEach((C, x) => {
            s.push({
              id: C,
              name: m[x]
            });
          });
        }
        let l = !1;
        return V > 0 && (l = V < ((t = v.value) == null ? void 0 : t.length), s == null || s.splice(V, s == null ? void 0 : s.length)), i("div", {
          class: [a.b("select-value-multiple"), a.is("hidden", l)]
        }, [s == null ? void 0 : s.map((n) => {
          let m;
          return i("div", {
            class: a.be("select-value-multiple", "item")
          }, [i("div", {
            class: [a.be("select-value", "textimg"), a.bem("select-value-multiple", "item", "textimg")],
            style: "background-color:".concat(Z(n.name))
          }, [i(P("el-tooltip"), {
            class: "box-item",
            effect: "dark",
            content: n.name,
            placement: "top",
            offset: 12
          }, mt(m = Y(n.name)) ? m : {
            default: () => [m]
          }), r.readonly ? null : i("div", {
            class: [a.bem("select-value-multiple", "item", "close")],
            onClick: (C) => we(n, C)
          }, [i("i", {
            class: "fa fa-close",
            "aria-hidden": "true"
          }, null)])])]);
        }), l ? i(P("el-tooltip"), {
          class: a.b("multiple-ellipsis"),
          "popper-class": a.be("multiple-ellipsis", "popper"),
          effect: "dark",
          content: E.value,
          placement: "top",
          offset: 12
        }, {
          default: () => [i("span", {
            class: a.be("multiple-ellipsis", "default")
          }, [k("...")])]
        }) : null]);
      }
    }, de = () => e.multiple ? i("div", {
      class: a.b("select-value-multiple")
    }, [i("div", {
      class: a.b("select-value")
    }, [i("svg", {
      viewBox: "0 0 16 16",
      xmlns: "http://www.w3.org/2000/svg",
      height: "1em",
      width: "1em",
      preserveAspectRatio: "xMidYMid meet",
      focusable: "false"
    }, [i("g", {
      id: "azeaction/user-add",
      "stroke-width": "1"
    }, [i("path", {
      d: "M7.9.4a4.1 4.1 0 1 1-.265 8.192.593.593 0 0 1-.268.126 6.411 6.411 0 0 0-4.624 3.698A6.375 6.375 0 0 0 2.2 15 .6.6 0 0 1 1 15c0-1.07.222-2.11.645-3.069a7.622 7.622 0 0 1 4.069-3.963A4.1 4.1 0 0 1 7.9.4zm4.6 9.9a.6.6 0 0 1 .592.503l.008.097-.001 1.399 1.401.001a.6.6 0 0 1 .592.503l.008.097a.6.6 0 0 1-.503.592l-.097.008-1.401-.001.001 1.401a.6.6 0 0 1-.503.592l-.097.008a.6.6 0 0 1-.592-.503L11.9 14.9v-1.401l-1.4.001a.6.6 0 0 1-.592-.503L9.9 12.9a.6.6 0 0 1 .503-.592l.097-.008h1.4v-1.4a.6.6 0 0 1 .503-.592l.097-.008zM7.9 1.6a2.9 2.9 0 1 0 0 5.8 2.9 2.9 0 0 0 0-5.8z",
      id: "aze形状结合"
    }, null)])])])]) : i("div", {
      class: a.b("select-value")
    }, [i("div", {
      class: a.be("select-value", "textimg"),
      style: "background-color:".concat(Z(E.value))
    }, [Y(E.value)]), i("div", {
      class: a.be("select-value", "text")
    }, [i("div", {
      class: a.bem("select-value", "text", "label")
    }, [E.value])]), r.readonly ? null : i("i", {
      class: ["fa fa-times-circle", a.be("select-value", "close")],
      "aria-hidden": "true",
      onClick: (t) => te(t)
    }, null)]), pe = async () => {
      var m, C;
      O.value = !0;
      const {
        context: t,
        params: s
      } = e.handlePublicParams(r.data, e.context, e.params), l = e.fill(e.userUrl, t, s, r.data).replaceAll("//", "/"), n = e.fill(e.deptUrl, t, s, r.data).replaceAll("//", "/");
      (l !== e.copyUserUrl || n !== e.copyDeptUrl || r.data && r.data.srfkey !== U.value) && (U.value = ((m = r.data) == null ? void 0 : m.srfkey) || "", o.value = [], c.value = [], e.resetState(), N(!0)), await rt(), (C = D.value) == null || C.focus();
    }, Be = () => E.value ? de() : ce(), _e = () => E.value ? [ue()] : Ue(), $e = () => i(P("el-popover"), {
      ref: "popoverRef",
      visible: L.value,
      "onUpdate:visible": (t) => L.value = t,
      trigger: "click",
      popperClass: a.b("person-select"),
      placement: "top-start",
      width: 320,
      teleported: !0,
      onShow: () => pe(),
      onHide: () => ie()
    }, {
      reference: () => Be(),
      default: () => oe()
    }), He = () => [ue(), $e()], he = () => {
      K();
    };
    return ve(() => {
      j.value && (window == null || window.addEventListener("resize", he), K());
    }), it(() => {
      e.resetState(), j.value && (window == null || window.removeEventListener("resize", he));
    }), {
      ns: a,
      c: e,
      refValue: d,
      curValue: h,
      valueText: E,
      loading: F,
      items: o,
      isEditable: M,
      showFormDefaultContent: g,
      modelVisible: L,
      curAttentionValue: B,
      attentionRef: j,
      readonlyState: J,
      onClear: te,
      load: N,
      setEditable: ee,
      renderDropModal: oe,
      renderNoSelectValue: ce,
      renderSelectInput: de,
      onPopShow: pe,
      onPageHide: ie,
      onAttentionChange: Ee,
      renderEditContent: He,
      renderReadonlyContent: _e
    };
  },
  render() {
    return i("div", {
      ref: "attentionRef",
      class: [this.ns.b(), this.ns.b("person-value"), this.disabled ? this.ns.m("disabled") : "", this.readonlyState ? this.ns.m("readonly") : "", this.ns.is("editable", this.isEditable), this.ns.is("show-default", this.showFormDefaultContent)]
    }, [this.readonlyState ? this.renderReadonlyContent() : this.renderEditContent(), i(pt, {
      readonly: this.readonlyState,
      disabled: this.disabled,
      value: this.curAttentionValue,
      codeListId: this.c.codeListId,
      codeListMap: this.c.codeListMap,
      defaultSelected: this.c.defaultSelected,
      controller: this.c,
      onChange: this.onAttentionChange
    }, null)]);
  }
}), ft = qe(q, function(r) {
  r.component(q.name, q), tt(
    "EDITOR_CUSTOMSTYLE_ATTENTION",
    () => new ut()
  );
}), It = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(r) {
    r.use(ft);
  }
};
export {
  ft as IBizAttention,
  It as default
};