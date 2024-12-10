import './style.css';
var st = Object.defineProperty;
var it = (o, m, r) => m in o ? st(o, m, { enumerable: !0, configurable: !0, writable: !0, value: r }) : o[m] = r;
var h = (o, m, r) => (it(o, typeof m != "symbol" ? m + "" : m, r), r);
import { useNamespace as ae, getDataPickerProps as lt, getEditorEmits as nt, renderString as rt, withInstall as ot } from "@ibiz-template/vue3-util";
import { EditorController as ct, getDeACMode as ut, UIActionUtil as dt, OpenAppViewCommand as Me, registerEditorProvider as pt } from "@ibiz-template/runtime";
import { RuntimeModelError as X } from "@ibiz-template/core";
import { mergeDeepLeft as ht, clone as te } from "ramda";
import { notNilEmpty as K } from "qx-util";
import { defineComponent as se, ref as M, onMounted as we, watch as R, createVNode as l, computed as D, onUnmounted as mt, resolveComponent as P, onBeforeUnmount as ft, withDirectives as vt, resolveDirective as gt, createTextVNode as V, nextTick as bt, mergeProps as Mt, isVNode as wt } from "vue";
import { isArray as Et } from "lodash-es";
class Ee extends ct {
  constructor() {
    super(...arguments);
    /**
     * 云系统操作者Map
     *
     * @memberof AttentionController
     */
    h(this, "operatorMap", /* @__PURE__ */ new Map());
    /**
     * 总数
     */
    h(this, "total", 0);
    /**
     * 当前人员数量
     */
    h(this, "currentNumber", -1);
    /**
     * 人员当前页
     */
    h(this, "page", 0);
    /**
     * 部门人员数据页数
     */
    h(this, "deptpage", 0);
    /**
     * 当前部门人员数量
     */
    h(this, "deptcurrentNumber", -1);
    /**
     * 部门人员总数
     */
    h(this, "depttotal", 0);
    /**
     * 每页数量
     */
    h(this, "size", 20);
    /**
     * 是否多选
     */
    h(this, "multiple", !0);
    /**
     * 多选时拼接的字符串
     */
    h(this, "separator", ",");
    /**
     *选择视图相关参数
     */
    h(this, "pickupView", null);
    /**
     *链接视图相关参数
     */
    h(this, "linkView", null);
    /**
     * 人员UI转化
     */
    h(this, "userFilterMap", {
      id: "id",
      name: "name"
    });
    /**
     * 部门人员UI转化
     */
    h(this, "deptFilterMap", {
      id: "id",
      name: "name"
    });
    /**
     *值项
     */
    h(this, "valueItem", "");
    /**
     * 主键属性名称
     */
    h(this, "keyName", "srfkey");
    /**
     * 主文本属性名称
     */
    h(this, "textName", "srfmajortext");
    /**
     * 数据集codeName
     */
    h(this, "interfaceName", "");
    /**
     * 自填模式sort排序
     */
    h(this, "sort", "");
    /**
     * 不支持AC（根据编辑器类型得）
     */
    h(this, "noAC", !1);
    /**
     * 不支持按钮（根据编辑器类型得）
     */
    h(this, "noButton", !1);
    /**
     * 实体自填模式模型
     */
    h(this, "deACMode");
    /**
     * 自填数据项集合（已排除了value和text)
     */
    h(this, "dataItems", []);
    // 对象标识属性
    h(this, "objectIdField", "");
    // 对象名称属性
    h(this, "objectNameField", "");
    // 对象值属性
    h(this, "objectValueField", "");
    // 人员请求地址
    h(this, "userUrl", "");
    // 部门请求地址
    h(this, "deptUrl", "");
    // 复制人员请求url,这是用来保证当配置的URL中的动态参数变化后可以刷新当前请求状态
    h(this, "copyUserUrl", "");
    // 复制部门人员请求url
    h(this, "copyDeptUrl", "");
    // 人员请求方式
    h(this, "userMethod", "post");
    // 部门人员请求方式
    h(this, "deptMethod", "post");
    /**
     * 上下文替换正则
     *
     */
    h(this, "contextReg", /\$\{context.[a-zA-Z_$][a-zA-Z0-9_$]{1,}\}/g);
    /**
     * 数据替换正则
     *
     */
    h(this, "dataReg", /\$\{data.[a-zA-Z_$][a-zA-Z0-9_$]{1,}\}/g);
    /**
     * 参数替换正则
     *
     */
    h(this, "paramsReg", /\$\{params.[a-zA-Z_$][a-zA-Z0-9_$]{1,}\}/g);
    /**
     * 值类型
     */
    h(this, "valueType", "OBJECTS");
    /**
     * 代码表的代码标识
     *
     */
    h(this, "codeListId", "");
    /**
     * 代码表值映射
     *
     */
    h(this, "codeListMap");
    /**
     * 关注类型属性
     *
     */
    h(this, "attentionTypeField", "type");
    /**
     * 自填充映射
     */
    h(this, "selfFillMap", {
      user_id: "user_id",
      user_name: "name"
    });
    /**
     * 默认选中项
     *
     */
    h(this, "defaultSelected", "");
    /**
     * 选中后默认关注值
     *
     */
    h(this, "defaultAttentionValue", "");
    /**
     * 启用确认按钮
     */
    h(this, "enableBottomButton", !1);
    /**
     * 额外抛值字段映射
     */
    h(this, "fieldMap", "");
  }
  async onInit() {
    var s, e, u, c, f, v, w;
    if (super.onInit(), this.initParams(), await this.getOperatorUserList(), this.valueItem = ((s = this.model.valueItemName) == null ? void 0 : s.toLowerCase()) || "", this.model.appDataEntityId && (this.model.appDEDataSetId && (this.interfaceName = this.model.appDEDataSetId), this.model.appDEACModeId && (this.deACMode = await ut(
      this.model.appDEACModeId,
      this.model.appDataEntityId,
      this.context.srfappid
    ), this.deACMode))) {
      const { minorSortAppDEFieldId: F, minorSortDir: E } = this.deACMode;
      F && E && (this.sort = "".concat(F.toLowerCase(), ",").concat(E.toLowerCase())), this.deACMode.textAppDEFieldId && (this.textName = this.deACMode.textAppDEFieldId), this.deACMode.valueAppDEFieldId && (this.keyName = this.deACMode.valueAppDEFieldId), this.deACMode.deacmodeDataItems && (this.dataItems = [], this.deACMode.deacmodeDataItems.forEach(
        (y) => {
          y.id !== "value" && y.id !== "text" && this.dataItems.push(y);
        }
      ));
    }
    const r = [
      "PICKEREX_DROPDOWNVIEW",
      "PICKEREX_DROPDOWNVIEW_LINK",
      "PICKUPVIEW"
    ];
    this.model.editorType && r.includes(this.model.editorType) && this.initPickupViewParams(), this.objectIdField = (u = (e = this.model) == null ? void 0 : e.objectIdField) == null ? void 0 : u.toLowerCase(), this.objectNameField = (f = (c = this.model) == null ? void 0 : c.objectNameField) == null ? void 0 : f.toLowerCase(), this.objectValueField = (w = (v = this.model) == null ? void 0 : v.objectValueField) == null ? void 0 : w.toLowerCase();
  }
  /**
   * 初始化noAc和noButton
   */
  initParams() {
    var r, s, e, u, c, f, v, w, F, E, y, g;
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
    if (this.userUrl = this.editorParams.URL, this.deptUrl = this.editorParams.DEPTURL, this.userMethod = this.editorParams.USERMETHOD || "post", this.deptMethod = this.editorParams.DEPTMETHOD || "post", this.separator = this.editorParams.SEPARATOR || ",", (r = this.editorParams) != null && r.CODELISTID && (this.codeListId = (s = this.editorParams) == null ? void 0 : s.CODELISTID), (e = this.editorParams) != null && e.DEFAULTATNVALUE && (this.defaultAttentionValue = (u = this.editorParams) == null ? void 0 : u.DEFAULTATNVALUE), (c = this.editorParams) != null && c.VALUETYPE && (this.valueType = (f = this.editorParams) == null ? void 0 : f.VALUETYPE), (v = this.editorParams) != null && v.ENABLEBOTTOMBUTTON && (this.enableBottomButton = ((w = this.editorParams) == null ? void 0 : w.ENABLEBOTTOMBUTTON) === "true"), (F = this.editorParams) != null && F.FIELDMAP && (this.fieldMap = (E = this.editorParams) == null ? void 0 : E.FIELDMAP), this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "CODELISTMAP"))
      try {
        const p = JSON.parse((y = this.editorParams) == null ? void 0 : y.CODELISTMAP);
        Object.assign(this.codeListMap, p);
      } catch (p) {
        this.codeListMap = { FOLLOWED: [20, 30, 40], NOTFOLLOWING: [10] };
      }
    if (this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "SELFFILLMAP"))
      try {
        const p = JSON.parse((g = this.editorParams) == null ? void 0 : g.SELFFILLMAP);
        Object.assign(this.selfFillMap, p);
      } catch (p) {
        this.selfFillMap = {
          user_id: "user_id",
          user_name: "name"
        };
      }
    if (this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "USERMAP"))
      try {
        const p = JSON.parse(this.editorParams.USERMAP);
        Object.assign(this.userFilterMap, p);
      } catch (p) {
        this.userFilterMap = {
          id: "id",
          name: "name"
        };
      }
    if (this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "DEPTMAP"))
      try {
        const p = JSON.parse(this.editorParams.DEPTMAP);
        Object.assign(this.deptFilterMap, p);
      } catch (p) {
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
  async loadMore(r, s, e = {}) {
    if (s === "user" && this.currentNumber < this.total) {
      const u = await this.getServiceData(s, r, e);
      if (u)
        return this.page += 1, this.currentNumber < 0 && (this.currentNumber += 1), this.currentNumber += this.size, this.total = u.total ? Number(u.total) : Number(u.headers["x-total"]), u.data.forEach((c) => {
          Object.keys(this.userFilterMap).forEach((f) => {
            c[f] = c[this.userFilterMap[f]];
          });
        }), u;
    } else if (s === "department" && this.deptcurrentNumber < this.depttotal) {
      const u = await this.getServiceData(s, r, e);
      if (u)
        return this.deptpage += 1, this.deptcurrentNumber < 0 && (this.deptcurrentNumber += 1), this.deptcurrentNumber += this.size, this.depttotal = u.total ? Number(u.total) : Number(u.headers["x-total"]), u.data.forEach((c) => {
          Object.keys(this.deptFilterMap).forEach((f) => {
            c[f] = c[this.deptFilterMap[f]];
          });
        }), u;
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
  async onActionClick(r, s, e) {
    const u = r.uiactionId;
    await dt.execAndResolved(
      u,
      {
        context: this.context,
        params: this.params,
        data: s,
        view: this.parent.form.ctx.view,
        event: e
      },
      r.appId
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
  fill(r, s, e, u) {
    if (K(r)) {
      if (K(s)) {
        const c = r.match(this.contextReg);
        c == null || c.forEach((f) => {
          const v = f.slice(10, f.length - 1);
          r = r.replace("${context.".concat(v, "}"), s[v] || "");
        });
      }
      if (K(e)) {
        const c = r.match(this.paramsReg);
        c == null || c.forEach((f) => {
          const v = f.slice(9, f.length - 1);
          r = r.replace("${params.".concat(v, "}"), e[v] || "");
        });
      }
      if (K(u)) {
        const c = r.match(this.dataReg);
        c == null || c.forEach((f) => {
          const v = f.slice(7, f.length - 1);
          r = r.replace("${data.".concat(v, "}"), u[v] || "");
        });
      }
    }
    return r;
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
  async getServiceData(r, s, e) {
    const { context: u, params: c } = this.handlePublicParams(
      s,
      this.context,
      this.params
    ), f = {};
    this.sort && !Object.is(this.sort, "") && Object.assign(f, { sort: this.sort }), Object.assign(f, { size: this.size }), e && Object.assign(f, e);
    const v = ht(c, f);
    let w = "";
    const F = this.fill(this.userUrl, u, c, s).replaceAll(
      "//",
      "/"
    ), E = this.fill(this.deptUrl, u, c, s).replaceAll(
      "//",
      "/"
    );
    this.copyUserUrl = F, this.copyDeptUrl = E;
    let y = "post";
    const g = {};
    if (r === "user" ? (w = F, y = this.userMethod.toLowerCase(), Object.assign(g, { method: y, data: v })) : (w = E, y = this.deptMethod.toLowerCase(), Object.assign(g, { method: y, params: v })), w)
      return await ibiz.net.request(w, g);
    throw new X(this.model, "请配置数据接口地址");
  }
  /**
   * 打开数据选择视图
   *
   * @param {IData} data 数据对象
   * @param {IData[]} selectedData 选中项集合
   * @returns {*}  {(Promise<IData[] | undefined>)}
   * @memberof PersonelSelectController
   */
  async openPickUpView(r, s) {
    await this.initPickupViewParams();
    const { context: e, params: u } = this.handlePublicParams(
      r,
      this.context,
      this.params
    );
    if (s && (u.selectedData = s), !this.pickupView)
      throw new X(this.model, "请配置数据选择视图");
    const c = await ibiz.commands.execute(
      Me.TAG,
      this.pickupView.id,
      e,
      u,
      { openMode: "POPUPMODAL" }
    );
    if (c && c.ok && c.data)
      return c.data;
    ibiz.log.debug("模态取消或关闭异常", c);
  }
  /**
   * 打开数据链接视图
   */
  async openLinkView(r) {
    const s = this.context.clone();
    r[this.valueItem] && (s.srfkey = r[this.valueItem]);
    const { context: e, params: u } = this.handlePublicParams(
      r,
      s,
      this.params
    ), { linkAppViewId: c } = this.model;
    if (!c)
      throw new X(this.model, "请配置数据链接视图");
    return ibiz.commands.execute(
      Me.TAG,
      c,
      e,
      u
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
  async calcFillDataItems(r) {
    return this.deACMode ? this.dataItems.length === 0 ? [] : await Promise.all(
      this.dataItems.map((e) => {
        const c = r.map((f) => f[e.appDEFieldId]).join(this.separator);
        return e.format || e.convertToCodeItemText && e.codeListId || e.customCode, { id: e.id, value: c };
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
  handleObjectParams(r) {
    const s = {};
    return this.objectIdField && Object.assign(s, {
      [this.objectIdField]: r[this.keyName]
    }), this.objectNameField && Object.assign(s, {
      [this.objectNameField]: r[this.textName]
    }), this.objectValueField && Object.assign(s, {
      [this.objectValueField]: te(r)
    }), s;
  }
  /**
   * 获取操作用户列表
   *
   * @return {*}  {Promise<void>}
   * @memberof AttentionController
   */
  async getOperatorUserList() {
    const r = await ibiz.hub.getApp(this.context.srfappid);
    let s = [];
    s = await r.codeList.get(
      "SysOperator",
      this.context,
      this.params
    ), this.operatorMap = new Map(
      s.map((e) => [e.value, e])
    );
  }
  /**
   * 动态匹配${}
   *
   * @param {string} str
   * @param {Record<string, IData>} values
   * @return {*}  {string}
   */
  dynamicMatch(r, s) {
    return r.replace(/\${(.*?)}/g, (e, u) => {
      const [c, f] = u.split("."), v = s[c];
      return v && v[f] || "";
    });
  }
}
class yt {
  constructor() {
    h(this, "component", "IBizAttention");
    h(this, "formEditor", "IBizAttention");
    h(this, "gridEditor", "IBizAttention");
  }
  async createController(m, r) {
    const s = new Ee(m, r);
    return await s.init(), s;
  }
}
const Ft = /* @__PURE__ */ se({
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
  setup(o, {
    emit: m
  }) {
    const r = ae("virtual-list-box"), s = M(36), e = M(), u = M([]), c = M(0), f = M(0), v = M(0), w = M(0), F = (g, p) => {
      m("scrollEvent", g, p);
    }, E = () => {
      f.value = Math.floor(w.value / o.itemHeight), v.value = f.value + o.showNum, u.value = o.items.slice(f.value, v.value);
      const g = w.value - w.value % o.itemHeight;
      c.value = g;
    }, y = () => {
      w.value = e.value.scrollTop, E(), F(s.value, w.value);
    };
    return we(() => {
      setTimeout(() => {
        scroll();
      }, 1e3);
    }), R(() => o.items, () => {
      s.value = o.itemHeight * o.items.length, E();
    }, {
      immediate: !0,
      deep: !0
    }), {
      ns: r,
      contentHeight: s,
      showList: u,
      contentBox: e,
      top: c,
      onScroll: y
    };
  },
  render() {
    return l("div", {
      ref: "contentBox",
      class: this.ns.b(),
      onScroll: () => this.onScroll()
    }, [l("div", {
      class: this.ns.e("container"),
      style: "height:".concat(this.contentHeight, "px;")
    }, [l("div", {
      class: this.ns.e("content"),
      style: "top:".concat(this.top, "px;")
    }, [this.showList.map((o, m) => l("div", {
      key: m,
      class: this.ns.m("item")
    }, [this.$slots.default ? this.$slots.default({
      ...o,
      index: m
    }) : o.name]))])])]);
  }
});
const It = /* @__PURE__ */ se({
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
      type: Ee,
      required: !0
    },
    defaultSelected: {
      type: String
    }
  },
  emits: {
    /** 值变更事件 */
    change: (o, m) => !0,
    /** 失焦事件 */
    blur: (o) => !0,
    /** 聚焦事件 */
    focus: (o) => !0,
    /** 回车事件 */
    enter: (o) => !0,
    /** 信息文本变更事件 */
    infoTextChange: (o) => !0
  },
  setup(o, {
    emit: m
  }) {
    const r = ae("follow"), s = o.controller, e = M(), u = M(!1), c = M(!1), f = M(), v = M(!1), w = M(!1), F = M(null), E = M(!1), y = M([]), g = D(() => o.codeListMap || {}), p = D(() => ({})), N = async () => {
      if (v.value = !0, o.codeListId) {
        const A = await ibiz.hub.getApp(s.context.srfappid).codeList.get(o.codeListId, s.context, s.params);
        A && A.length > 0 && (y.value = A), u.value = !0;
      }
      v.value = !1;
    }, C = (b) => {
      var O, x;
      F.value = b, ((x = (O = g.value) == null ? void 0 : O.FOLLOWED) == null ? void 0 : x.find((S) => String(S) === String(b))) ? w.value = !0 : w.value = !1;
    };
    R(
      () => o.value,
      // eslint-disable-next-line @typescript-eslint/no-unused-vars
      async (b, A) => {
        var x;
        let O = b;
        !b && o.codeListMap && (O = ((x = g.value) == null ? void 0 : x.NOTFOLLOWING[0]) || ""), C(O);
      },
      {
        immediate: !0,
        deep: !0
      }
    );
    const k = (b) => {
      b ? c.value = b : setTimeout(() => {
        c.value = b;
      }, 100);
    }, L = D({
      get() {
        var b;
        return (b = o.value) == null ? void 0 : b.toString();
      },
      set(b) {
        m("change", b), k(!1);
      }
    }), _ = D(() => {
      const b = Array.isArray(L.value) ? L.value : [L.value], A = y.value, O = [];
      return b.forEach((x) => {
        A.forEach((S) => {
          S.value === x && O.push(S.text);
        });
      }), O.join(",");
    });
    R(_, (b, A) => {
      b !== A && m("infoTextChange", b);
    }, {
      immediate: !0
    });
    const j = (b) => y.value.find((O) => O.text === b), W = async (b) => {
      E.value = b, b && !u.value && await N();
    }, z = (b) => {
      F.value = b.value, C(b.value), m("change", b.value);
    }, $ = (b) => {
      var A;
      (b.key === "Escape" || b.keyCode === 27) && (b.stopPropagation(), (A = e.value) == null || A.handleClose());
    };
    return mt(() => {
    }), {
      ns: r,
      curValue: L,
      items: y,
      valueText: _,
      editorRef: f,
      cssVars: p,
      isEditable: c,
      isLoading: v,
      followState: w,
      selectd: F,
      showState: E,
      dropdownRef: e,
      setEditable: k,
      getCodeListItem: j,
      onShowChange: W,
      onItemClick: z,
      handleKeyDown: $
    };
  },
  render() {
    const o = l("div", {
      class: [this.ns.e("showcase"), this.showState ? "is-active" : ""]
    }, [l("span", {
      class: this.ns.em("showcase", "icon")
    }, [l("svg", {
      viewBox: "0 0 16 16",
      xmlns: "http://www.w3.org/2000/svg",
      height: "1em",
      width: "1em",
      focusable: "false"
    }, [l("g", {
      id: "follow/with/interest",
      "stroke-width": "1",
      "fill-rule": "evenodd"
    }, [l("path", {
      d: "M8 3.4c2.823 0 5.04 1.367 7.38 3.637a2.037 2.037 0 0 1 0 2.925C13.04 12.232 10.824 13.6 8 13.6c-2.823 0-5.032-1.364-7.376-3.637a2.037 2.037 0 0 1 0-2.925C2.967 4.764 5.176 3.4 8 3.4zm0 1.2c-2.417 0-4.405 1.228-6.542 3.3a.837.837 0 0 0 0 1.2C3.596 11.173 5.584 12.4 8 12.4s4.413-1.231 6.546-3.3a.837.837 0 0 0 0-1.2C12.412 5.83 10.415 4.6 8 4.6zM8 11a2.5 2.5 0 1 1 0-5 2.5 2.5 0 0 1 0 5zm0-1.2a1.3 1.3 0 1 0 0-2.6 1.3 1.3 0 0 0 0 2.6z",
      id: "attention"
    }, null)])])]), l("span", {
      class: this.ns.em("showcase", "text")
    }, [this.followState ? "已关注" : "未关注"])]), m = l(P("el-dropdown"), {
      "popper-class": this.ns.b("popover"),
      ref: (r) => {
        this.dropdownRef = r;
      },
      trigger: "click",
      placement: "top-start",
      onVisibleChange: this.onShowChange,
      onKeydown: (r) => {
        this.handleKeyDown(r);
      }
    }, {
      default: () => o,
      dropdown: () => l(P("el-dropdown-menu"), {
        class: this.ns.be("popper", "dropdown-menu")
      }, {
        default: () => this.items.map((r, s) => l(P("el-dropdown-item"), {
          onClick: () => this.onItemClick(r)
        }, {
          default: () => [l("div", {
            class: [this.ns.b("content"), String(this.selectd) === String(r.value) ? "is-active" : ""]
          }, [l("div", {
            class: this.ns.em("item", "text")
          }, [r.text]), l("div", {
            class: this.ns.em("item", "tooltip")
          }, [r.tooltip])]), s === this.items.length - 1 ? null : l("div", {
            class: this.ns.em("item", "divider")
          }, [l(P("el-divider"), null, null)])]
        }))
      })
    });
    return l("div", {
      class: [this.ns.b(), this.disabled ? this.ns.m("disabled") : "", this.readonly ? this.ns.m("readonly") : "", this.ns.is("editable", this.isEditable)],
      style: this.cssVars
    }, [this.readonly ? o : m]);
  }
});
class At {
  /**
   * 计算选中项绘制个数 多选场景需计算显示人员是否超出
   * @author ljx
   * @date 2024-03-05 02:42:45
   * @param {IData} values 选中项key值集合
   * @returns {number} selRenderNum
   */
  static calcSelItemRenderNum(m, r) {
    let s = 0;
    if (r && (m == null ? void 0 : m.length) > 0) {
      const e = (r == null ? void 0 : r.offsetWidth) || 0, u = window.getComputedStyle(r), c = parseInt(u.marginLeft, 10), f = parseInt(u.marginRight, 10), v = parseInt(u.paddingLeft, 10), w = parseInt(u.paddingRight, 10), F = c + f + v + w, E = 70, y = 33, g = 28, p = 8, N = (g + p) * m.length;
      e - F - E - y - N < 0 && (s = Math.floor(
        (e - F - E - y) / (g + p)
      ), s -= 1);
    }
    return s;
  }
}
function Q(o) {
  return typeof o == "function" || Object.prototype.toString.call(o) === "[object Object]" && !wt(o);
}
const ee = /* @__PURE__ */ se({
  name: "IBizAttention",
  props: lt(),
  emits: nt(),
  setup(o, {
    emit: m,
    attrs: r
  }) {
    const s = ae("attention"), e = o.controller, u = M(""), c = M([]), f = M([]), v = M(""), w = M(!1), F = M(!1), E = M(""), y = M([]), g = M("user"), p = M([]), N = M([]), C = M(!1), k = M(!1), L = M(!1), _ = M(""), j = M(!1), W = M(), z = M(), $ = M(""), b = M();
    let A = 0;
    const O = D(() => o == null ? void 0 : o.readonly), x = D(() => !!(o.controlParams && o.controlParams.editmode === "hover")), S = D(() => rt(u.value)), J = (t) => {
      t.preventDefault(), t.stopPropagation();
    }, Z = () => {
      var i;
      const t = [], a = [];
      $.value = "", ((i = p.value) == null ? void 0 : i.length) > 0 && p.value.forEach((n) => {
        t.push(n[e.selfFillMap.user_id]), a.push(n[e.selfFillMap.user_name]), n[e.selfFillMap.user_id] === e.context.srfuserid && ($.value = n[e.attentionTypeField]);
      }), v.value = t == null ? void 0 : t.toString(), u.value = a == null ? void 0 : a.toString();
    }, ye = (t) => {
      var a, i;
      return (i = (a = e.codeListMap) == null ? void 0 : a.FOLLOWED) == null ? void 0 : i.some((n) => String(n) === String(t));
    }, Y = () => {
      const t = v.value.split(e.separator);
      A = At.calcSelItemRenderNum(t, z.value), v.value = "", Z();
    }, ie = (t) => {
      if (t) {
        const a = Et(t) ? t : [];
        p.value = [], a.forEach((i) => {
          const n = te(i);
          e.selfFillMap.user_id && e.selfFillMap.user_name && Object.assign(n, {
            id: i[e.selfFillMap.user_id],
            name: i[e.selfFillMap.user_name],
            [e.attentionTypeField]: i[e.attentionTypeField]
          }), e.objectValueField && (Object.assign(n, {
            ...i[e.objectValueField]
          }), delete n[e.objectValueField]), p.value.push(n);
        });
      } else
        p.value = [];
      N.value = te(p.value);
    };
    R(() => o.value, (t) => {
      t ? e.valueType === "OBJECT" ? u.value = t ? t[e.objectNameField] : null : e.valueType === "OBJECTS" ? (ie(t), Z()) : u.value = t : (u.value = "", p.value = []), Y();
    }, {
      immediate: !0
    });
    const Fe = D(() => o.data && o.data[e.valueItem] || void 0);
    R(Fe, (t, a) => {
      t !== a && (v.value = t, t === null && (p.value = [], m("change", null)));
    }, {
      immediate: !0,
      deep: !0
    });
    const le = (t) => {
      t ? F.value = t : setTimeout(() => {
        F.value = t;
      }, 100);
    }, Ie = (t) => {
      const a = {}, i = N.value.find((n) => n.id === t.id) || {};
      try {
        const n = e.dynamicMatch(e.fieldMap, {
          item: {
            ...i,
            ...t
          }
        }), d = JSON.parse(n);
        Object.keys(d).forEach((I) => {
          d[I] && Object.assign(a, {
            [I]: d[I]
          });
        });
      } catch (n) {
        ibiz.log.debug("".concat(e.fieldMap, "额外抛值字段映射"));
      }
      return a;
    }, H = () => {
      if (e.enableBottomButton && !j.value)
        return;
      const t = p.value.map((a) => {
        const i = {};
        return Object.assign(i, {
          [e.selfFillMap.user_id]: a.id,
          [e.selfFillMap.user_name]: a.name,
          [e.attentionTypeField]: a[e.attentionTypeField]
        }), e.fieldMap && Object.assign(i, Ie(a)), i;
      });
      m("change", t);
    }, Ae = (t, a) => {
      J(a);
      const i = p.value.findIndex((n) => n.id === t.id);
      if (i > -1 && p.value.splice(i, 1), e.valueItem) {
        const n = p.value.map((d) => d.id);
        m("change", n.join(e.separator), e.valueItem);
      }
      if (e.valueType === "OBJECTS")
        j.value = !0, H(), j.value = !1;
      else {
        const n = p.value.map((d) => d.name);
        m("change", n.join(e.separator));
      }
    }, Ce = async (t) => {
      E.value && (g.value === "user" ? c.value.unshift(t) : f.value.unshift(t));
      const a = {};
      if (Object.assign(a, t), g.value === "user") {
        Object.assign(a, {
          [e.userFilterMap.id]: a[e.userFilterMap.id] ? a[e.userFilterMap.id] : a.srfkey,
          [e.userFilterMap.name]: a[e.userFilterMap.name] ? a[e.userFilterMap.name] : a.srfmajortext
        });
        const i = p.value.findIndex((n) => n.id === a[e.userFilterMap.id]);
        i < 0 ? p.value.push({
          ...a,
          id: a[e.userFilterMap.id],
          name: a[e.userFilterMap.name],
          [e.attentionTypeField]: e.defaultAttentionValue
        }) : p.value.splice(i, 1);
      } else {
        Object.assign(a, {
          [e.deptFilterMap.id]: a[e.deptFilterMap.id] ? a[e.deptFilterMap.id] : a.srfkey,
          [e.deptFilterMap.name]: a[e.deptFilterMap.name] ? a[e.deptFilterMap.name] : a.srfmajortext
        });
        const i = p.value.findIndex((n) => n.id === a[e.deptFilterMap.id]);
        i < 0 ? p.value.push({
          ...a,
          id: a[e.deptFilterMap.id],
          name: a[e.deptFilterMap.name],
          [e.attentionTypeField]: e.defaultAttentionValue
        }) : p.value.splice(i, 1);
      }
      if (e.multiple) {
        if (e.valueItem) {
          const n = p.value.map((d) => d.id);
          m("change", n.join(e.separator), e.valueItem);
        }
        const i = p.value.map((n) => n.name);
        e.valueType === "OBJECTS" ? H() : m("change", i.join(e.separator));
      } else {
        const i = await e.calcFillDataItems([t]);
        if (i.length && i.forEach((n) => {
          m("change", n.value, n.id);
        }), e.valueItem && (g.value === "user" ? m("change", a[e.userFilterMap.id], e.valueItem) : m("change", a[e.deptFilterMap.id], e.valueItem)), e.valueType === "OBJECT")
          m("change", e.handleObjectParams(a));
        else if (e.valueType === "OBJECTS") {
          const n = {};
          g.value === "user" ? Object.assign(n, {
            id: a[e.userFilterMap.id],
            name: a[e.userFilterMap.name]
          }) : Object.assign(n, {
            id: a[e.deptFilterMap.id],
            name: a[e.deptFilterMap.name]
          }), p.value = [n], H();
        } else
          g.value === "user" ? m("change", t[e.userFilterMap.name]) : m("change", t[e.deptFilterMap.name]);
        L.value = !1;
      }
      e.valueType !== "OBJECTS" && m("blur", t), le(!1);
    }, Se = (t, a) => {
      t.forEach((i) => {
        const n = c.value.findIndex((d) => d[a] === i[a]);
        n > -1 ? c.value.splice(n, 1, i) : c.value.push(i);
      });
    }, B = async (t = !1) => {
      if (E.value)
        return;
      C.value = !0;
      const a = {};
      g.value === "department" ? a.page = e.deptpage : a.page = e.page;
      try {
        const i = await e.loadMore(o.data, g.value, a);
        i && (g.value === "user" ? c.value.length === 0 ? c.value = i.data : Se(i.data, e.userFilterMap.id) : f.value.length === 0 ? f.value = i.data : f.value.push(...i.data));
      } catch (i) {
        C.value = !1;
      }
      C.value = !1;
    }, ne = (t) => {
      const {
        dataItems: a
      } = e;
      a != null && a.length && a.forEach((i) => {
        m("change", null, i.id);
      }), e.valueItem && m("change", null, e.valueItem), e.valueType === "OBJECTS" ? m("change", []) : (m("change", null), m("blur", t)), t.stopPropagation(), t.preventDefault();
    }, Pe = (t) => {
      if (!e.codeListMap)
        return;
      if (ye(String(t))) {
        const i = p.value.find((n) => {
          var d;
          return n[e.selfFillMap.user_id] === ((d = e.context) == null ? void 0 : d.srfuserid);
        });
        if (i)
          Object.assign(i, {
            [e.attentionTypeField]: t
          });
        else {
          const n = {
            id: e.context.srfuserid,
            name: e.context.srfusername,
            [e.attentionTypeField]: t
          };
          p.value.push(n);
        }
      } else {
        const i = p.value.findIndex((n) => {
          var d;
          return n[e.selfFillMap.user_id] === ((d = e.context) == null ? void 0 : d.srfuserid);
        });
        i > -1 && p.value.splice(i, 1);
      }
      Z(), H();
    };
    R(S, (t, a) => {
      t !== a && e.valueType !== "OBJECTS" && m("infoTextChange", t);
    }, {
      immediate: !0
    });
    const re = async (t) => {
      C.value = !0;
      try {
        const a = {};
        Object.assign(a, {
          query: t,
          size: 1e3
        });
        const i = await e.getServiceData(g.value, o.data, a);
        i && (g.value === "user" ? i.data.forEach((n) => {
          Object.keys(e.userFilterMap).forEach((d) => {
            n[d] = n[e.userFilterMap[d]];
          });
        }) : i.data.forEach((n) => {
          Object.keys(e.deptFilterMap).forEach((d) => {
            n[d] = n[e.deptFilterMap[d]];
          });
        }), y.value = i.data, C.value = !1);
      } catch (a) {
        C.value = !1;
      }
    }, oe = (t) => {
      if (g.value !== t) {
        if (g.value = t, E.value) {
          re(E.value);
          return;
        }
        g.value === "user" && c.value.length === 0 && B(), g.value === "department" && f.value.length === 0 && B();
      }
    }, Oe = () => {
      const t = document.documentElement;
      return t ? getComputedStyle(t).getPropertyValue("--ibiz-color-primary") : null;
    }, Le = (t) => /[\u4E00-\u9FA5]/.test(t), Te = (t) => /[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(t), G = (t) => {
      if (!t)
        return "";
      let a = 0;
      for (let U = 0; U < t.length; U++)
        if (Le(t))
          a = t.charCodeAt(U) + ((a << 5) - a), a = a & a;
        else {
          const at = t.charCodeAt(U);
          a += at.toString(16);
        }
      const i = String(a).substring(0, 6);
      let n = parseInt(i.substring(0, 2), 16), d = parseInt(i.substring(2, 4), 16), I = parseInt(i.substring(4, 6), 16);
      n < 0 && (n = 10), d < 0 && (d = 10), I < 0 && (I = 10);
      const T = "#".concat(n.toString(16).padStart(2, "0")).concat(d.toString(16).padStart(2, "0")).concat(I.toString(16).padStart(2, "0"));
      return T === "#FFFFFF" && Oe() || T;
    }, xe = (t) => {
      clearTimeout(b.value), b.value = setTimeout(() => {
        !t && t !== 0 ? B() : re(t), clearTimeout(b.value);
      }, 300);
    }, je = (t) => {
      t.forEach((a) => {
        if (a.capLanguageRes && a.capLanguageRes.lanResTag) {
          const i = ibiz.i18n.t(a.capLanguageRes.lanResTag, a.caption);
          Object.assign(a, {
            caption: i
          });
        }
        if (a.tooltipLanguageRes && a.tooltipLanguageRes.lanResTag) {
          const i = ibiz.i18n.t(a.tooltipLanguageRes.lanResTag, a.tooltip);
          Object.assign(a, {
            caption: i
          });
        }
      });
    }, De = async (t, a) => {
      await e.onActionClick(t, [o.data], a);
    }, Ne = (t) => E.value ? y.value : t, ce = () => {
      k.value = !1;
    }, Be = () => {
      j.value = !1, L.value = !1, setTimeout(() => {
        ie(o.value);
      }, 200);
    }, Ve = () => {
      j.value = !0, L.value = !1, H(), j.value = !1;
    }, ke = () => l(P("el-input"), {
      class: s.be("select-modal", "search-input"),
      ref: W,
      modelValue: E.value,
      "onUpdate:modelValue": (t) => E.value = t,
      placeholder: "搜索",
      onInput: (t) => xe(t)
    }, {
      suffix: () => l("svg", {
        viewBox: "0 0 16 16",
        xmlns: "http://www.w3.org/2000/svg",
        height: "1em",
        width: "1em",
        preserveAspectRatio: "xMidYMid meet",
        focusable: "false"
      }, [l("g", {
        id: "atwnormal/search",
        "stroke-width": "1",
        "fill-rule": "evenodd"
      }, [l("path", {
        d: "M6.751 12.303A5.557 5.557 0 0 1 1.2 6.751C1.2 3.691 3.69 1.2 6.751 1.2a5.558 5.558 0 0 1 5.551 5.551 5.557 5.557 0 0 1-5.551 5.552M6.751 0a6.751 6.751 0 1 0 4.309 11.949l3.855 3.855a.6.6 0 1 0 .849-.849l-3.854-3.853A6.751 6.751 0 0 0 6.751 0",
        id: "atwFill-1"
      }, null)])])
    }), ze = () => l("div", {
      class: s.be("select-modal", "select-state")
    }, [l("div", {
      class: [s.bem("select-modal", "select-state", "select-slider"), s.is("left", g.value === "user"), s.is("right", g.value !== "user")]
    }, null), l("div", {
      class: s.bem("select-modal", "select-state", "select-personel"),
      onClick: () => oe("user")
    }, [V("人员")]), l("div", {
      class: s.bem("select-modal", "select-state", "select-department"),
      onClick: () => oe("department")
    }, [V("部门")])]), Ue = (t) => l("div", {
      class: s.bem("select-modal", "actions", "item"),
      title: t.tooltip,
      onClick: (a) => De(t, a)
    }, [t.showIcon && t.sysImage && l(P("iBizIcon"), {
      icon: t.sysImage
    }, null)]), Re = () => {
      var a;
      const t = ((a = e.model.uiactionGroup) == null ? void 0 : a.uiactionGroupDetails) || [];
      return je(t), l("div", {
        class: s.be("select-modal", "actions")
      }, [t.map((i) => Ue(i))]);
    }, _e = () => l("div", {
      class: s.be("select-modal", "select")
    }, [ze(), Re()]), $e = (t) => {
      if (e.multiple) {
        let a = -1;
        return v.value && (a = v.value.split(e.separator).findIndex((n) => n === t)), e.enableBottomButton && (a = p.value.findIndex((i) => (g.value === "user" ? i[e.userFilterMap.id] : i[e.deptFilterMap.id]) === t)), a > -1 ? l("div", {
          class: s.bem("select-modal", "personel-list", "icon")
        }, [l("i", {
          class: "fa fa-check",
          "aria-hidden": "true"
        }, null)]) : null;
      }
      return v.value === t ? l("div", {
        class: s.bem("select-modal", "personel-list", "icon")
      }, [l("i", {
        class: "fa fa-check",
        "aria-hidden": "true"
      }, null)]) : null;
    }, He = (t) => {
      if (t && t.toString().length < 2)
        return t;
      if (t && t.toString().length >= 2) {
        if (Te(t)) {
          const d = t.split("").find((T) => /[a-zA-Z]/.test(T)) || "", I = t.split("").find((T) => /[\u4E00-\u9FA5]/.test(T)) || "";
          return "".concat(d).concat(I).toLowerCase();
        }
        return /[a-zA-Z]/.test(t) ? t.split("").filter((d) => /[a-zA-Z]/.test(d)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(t) ? t.split("").filter((d) => /[\u4E00-\u9FA5]/.test(d)).slice(-2).join("") : t.replaceAll(" ", "").substring(0, 2);
      }
    }, We = (t) => {
      if (!t)
        return null;
      const a = JSON.parse(t);
      if (a.length === 0)
        return null;
      const {
        downloadUrl: i
      } = ibiz.util.file.calcFileUpDownUrl(e.context, e.params, o.data, e.editorParams), n = i.replace("%fileId%", a[0].id);
      return l("img", {
        class: s.bem("select-modal", "personel-list", "avatar"),
        src: n,
        alt: ""
      }, null);
    }, q = (t, a) => e.operatorMap && e.operatorMap.get(t) && e.operatorMap.get(t).data.iconurl ? We(e.operatorMap.get(t).data.iconurl) : He(a), ue = (t) => {
      const a = g.value === "user" ? t[e.userFilterMap.name] || t.name : t[e.deptFilterMap.name] || t.name, i = g.value === "user" ? t[e.userFilterMap.id] : t[e.deptFilterMap.id];
      return l("div", {
        class: [s.bem("select-modal", "personel-list", "item"), s.is("selected", v.value === i)],
        onClick: () => Ce(t)
      }, [l("div", {
        class: s.bem("select-modal", "personel-list", "text")
      }, [l("div", {
        class: s.bem("select-modal", "personel-list", "text-img"),
        style: "background-color:".concat(G(a))
      }, [q(i, a)]), l("div", {
        class: s.bem("select-modal", "personel-list", "text-label")
      }, [a]), i === e.context.srfuserid ? l("div", {
        class: s.bem("select-modal", "personel-list", "myself")
      }, [V("我自己")]) : null]), $e(i)]);
    }, Je = (t, a) => {
      const {
        context: i,
        params: n
      } = e;
      return l(P("iBizControlShell"), {
        class: s.b("panel-item"),
        data: t,
        modelData: a,
        context: i,
        params: n
      }, null);
    }, Ke = (t, a) => l(P("el-popover"), {
      target: "hover",
      placement: "right",
      offset: 24,
      width: "auto"
    }, {
      reference: () => ue(t),
      default: () => Je(t, a)
    }), Ze = (t, a) => {
      k.value && (g.value === "user" ? t - a < 305 && (C.value || B()) : t - a < 265 && (C.value || B()));
    }, de = (t) => {
      var n;
      const a = Ne(t), i = (n = e.deACMode) == null ? void 0 : n.itemLayoutPanel;
      return l(Ft, {
        items: a,
        itemHeight: 36,
        class: [s.be("select-modal", "personel-list"), s.be("select-modal", "personel-list-".concat(g.value))],
        onScrollEvent: (d, I) => Ze(d, I)
      }, {
        default: (d) => i ? Ke(d, i) : ue(d)
      });
    }, pe = (t) => {
      w.value = t;
    }, Ye = () => l("div", {
      class: s.be("select-modal", "deptpersonel")
    }, [l("div", {
      class: s.bem("select-modal", "deptpersonel", "dept")
    }, [l("div", {
      class: "collpase-icon"
    }, [w.value ? l("i", {
      class: "fa fa-angle-right",
      "aria-hidden": "true",
      onClick: () => pe(!1)
    }, null) : l("i", {
      class: "fa fa-angle-down",
      "aria-hidden": "true",
      onClick: () => pe(!0)
    }, null)]), l("svg", {
      viewBox: "0 0 16 16",
      xmlns: "http://www.w3.org/2000/svg",
      height: "1em",
      width: "1em",
      preserveAspectRatio: "xMidYMid meet",
      focusable: "false"
    }, [l("g", {
      id: "aqf1.Base基础/1.icon图标/2.normal/部门",
      "stroke-width": "1",
      "fill-rule": "evenodd"
    }, [l("path", {
      d: "M9 1a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-.39l-.016 2.138H11.5a2.1 2.1 0 0 1 2.095 1.95l.005.15V11h.4a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-2a1 1 0 0 1 1-1h.4V9.238a.9.9 0 0 0-.787-.893l-.113-.007h-7a.9.9 0 0 0-.893.787l-.007.113V11H4a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1v-2a1 1 0 0 1 1-1h.4V9.238a2.1 2.1 0 0 1 1.95-2.094l.15-.006h2.894L7.41 5H7a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h2zm4.8 11.2h-1.6v1.6h1.6v-1.6zm-10 0H2.2v1.6h1.6v-1.6zm5-10H7.2v1.6h1.6V2.2z",
      id: "aqf形状结合"
    }, null)])]), l("span", null, ["".concat(e.context.srfusername, "的团队")]), l("span", null, [V("·")]), l("span", null, [e.depttotal])]), w.value ? null : l("div", {
      class: s.bem("select-modal", "deptpersonel", "dept-person")
    }, [de(f.value)])]), Ge = () => {
      let t, a;
      return l("div", {
        class: s.be("select-modal", "bottom")
      }, [l(P("el-button"), {
        type: "text",
        onClick: Be
      }, Q(t = ibiz.i18n.t("app.cancel")) ? t : {
        default: () => [t]
      }), l(P("el-button"), {
        onClick: Ve
      }, Q(a = ibiz.i18n.t("app.confirm")) ? a : {
        default: () => [a]
      })]);
    }, he = () => vt(l("div", {
      class: s.b("select-modal"),
      onPointerdown: J,
      onPointerup: J,
      onClick: J
    }, [ke(), _e(), g.value === "user" ? de(c.value) : Ye(), e.enableBottomButton && Ge()]), [[gt("loading"), C.value]]), me = () => l("div", {
      class: s.b("no-select-value")
    }, [l("svg", {
      viewBox: "0 0 16 16",
      xmlns: "http://www.w3.org/2000/svg",
      height: "1em",
      width: "1em",
      preserveAspectRatio: "xMidYMid meet",
      focusable: "false"
    }, [l("g", {
      id: "azeaction/user-add",
      "stroke-width": "1"
    }, [l("path", {
      d: "M7.9.4a4.1 4.1 0 1 1-.265 8.192.593.593 0 0 1-.268.126 6.411 6.411 0 0 0-4.624 3.698A6.375 6.375 0 0 0 2.2 15 .6.6 0 0 1 1 15c0-1.07.222-2.11.645-3.069a7.622 7.622 0 0 1 4.069-3.963A4.1 4.1 0 0 1 7.9.4zm4.6 9.9a.6.6 0 0 1 .592.503l.008.097-.001 1.399 1.401.001a.6.6 0 0 1 .592.503l.008.097a.6.6 0 0 1-.503.592l-.097.008-1.401-.001.001 1.401a.6.6 0 0 1-.503.592l-.097.008a.6.6 0 0 1-.592-.503L11.9 14.9v-1.401l-1.4.001a.6.6 0 0 1-.592-.503L9.9 12.9a.6.6 0 0 1 .503-.592l.097-.008h1.4v-1.4a.6.6 0 0 1 .503-.592l.097-.008zM7.9 1.6a2.9 2.9 0 1 0 0 5.8 2.9 2.9 0 0 0 0-5.8z",
      id: "aze形状结合"
    }, null)])]), l("span", null, [V("未设置")])]), qe = () => l("div", {
      class: s.b("no-select-value")
    }, [l("span", null, [V("未设置")])]), fe = () => {
      var t, a;
      if (e.multiple) {
        const i = [];
        if (v.value) {
          const d = v.value.split(e.separator), I = S.value.split(e.separator);
          d.forEach((T, U) => {
            i.push({
              id: T,
              name: I[U]
            });
          });
        }
        let n = !1;
        return A > 0 && (n = e.enableBottomButton ? A < ((t = N.value) == null ? void 0 : t.length) : A < ((a = p.value) == null ? void 0 : a.length), i == null || i.splice(A, i == null ? void 0 : i.length)), l("div", {
          class: [s.b("select-value-multiple"), s.is("hidden", n)]
        }, [i == null ? void 0 : i.map((d) => {
          let I;
          return l("div", {
            class: s.be("select-value-multiple", "item")
          }, [l("div", {
            class: [s.be("select-value", "textimg"), s.bem("select-value-multiple", "item", "textimg")],
            style: "background-color:".concat(G(d.name))
          }, [l(P("el-tooltip"), {
            class: "box-item",
            effect: "dark",
            content: d.name,
            placement: "top",
            offset: 12
          }, Q(I = q(d.id, d.name)) ? I : {
            default: () => [I]
          }), o.readonly ? null : l("div", {
            class: [s.bem("select-value-multiple", "item", "close")],
            onClick: (T) => Ae(d, T)
          }, [l("i", {
            class: "fa fa-close",
            "aria-hidden": "true"
          }, null)])])]);
        }), n ? l(P("el-tooltip"), {
          class: s.b("multiple-ellipsis"),
          "popper-class": s.be("multiple-ellipsis", "popper"),
          effect: "dark",
          content: S.value,
          placement: "top",
          offset: 12
        }, {
          default: () => [l("span", {
            class: s.be("multiple-ellipsis", "default")
          }, [V("...")])]
        }) : null]);
      }
    }, ve = () => e.multiple ? l("div", {
      class: s.b("select-value-multiple")
    }, [l("div", {
      class: s.b("select-value"),
      title: "选择人员"
    }, [l("svg", {
      viewBox: "0 0 16 16",
      xmlns: "http://www.w3.org/2000/svg",
      height: "1em",
      width: "1em",
      preserveAspectRatio: "xMidYMid meet",
      focusable: "false"
    }, [l("g", {
      id: "azeaction/user-add",
      "stroke-width": "1"
    }, [l("path", {
      d: "M7.9.4a4.1 4.1 0 1 1-.265 8.192.593.593 0 0 1-.268.126 6.411 6.411 0 0 0-4.624 3.698A6.375 6.375 0 0 0 2.2 15 .6.6 0 0 1 1 15c0-1.07.222-2.11.645-3.069a7.622 7.622 0 0 1 4.069-3.963A4.1 4.1 0 0 1 7.9.4zm4.6 9.9a.6.6 0 0 1 .592.503l.008.097-.001 1.399 1.401.001a.6.6 0 0 1 .592.503l.008.097a.6.6 0 0 1-.503.592l-.097.008-1.401-.001.001 1.401a.6.6 0 0 1-.503.592l-.097.008a.6.6 0 0 1-.592-.503L11.9 14.9v-1.401l-1.4.001a.6.6 0 0 1-.592-.503L9.9 12.9a.6.6 0 0 1 .503-.592l.097-.008h1.4v-1.4a.6.6 0 0 1 .503-.592l.097-.008zM7.9 1.6a2.9 2.9 0 1 0 0 5.8 2.9 2.9 0 0 0 0-5.8z",
      id: "aze形状结合"
    }, null)])])])]) : l("div", {
      class: s.b("select-value")
    }, [l("div", {
      class: s.be("select-value", "textimg"),
      style: "background-color:".concat(G(S.value))
    }, [q(v.value, S.value)]), l("div", {
      class: s.be("select-value", "text")
    }, [l("div", {
      class: s.bem("select-value", "text", "label")
    }, [S.value])]), o.readonly ? null : l("i", {
      class: ["fa fa-times-circle", s.be("select-value", "close")],
      "aria-hidden": "true",
      onClick: (t) => ne(t)
    }, null)]), ge = async () => {
      var d, I;
      k.value = !0;
      const {
        context: t,
        params: a
      } = e.handlePublicParams(o.data, e.context, e.params), i = e.fill(e.userUrl, t, a, o.data).replaceAll("//", "/"), n = e.fill(e.deptUrl, t, a, o.data).replaceAll("//", "/");
      (i !== e.copyUserUrl || n !== e.copyDeptUrl || o.data && o.data.srfkey !== _.value) && (_.value = ((d = o.data) == null ? void 0 : d.srfkey) || "", c.value = [], f.value = [], e.resetState(), B(!0)), await bt(), (I = W.value) == null || I.focus();
    }, Xe = () => S.value ? ve() : me(), Qe = () => S.value ? [fe()] : qe(), et = () => l(P("el-popover"), Mt({
      ref: "popoverRef",
      visible: L.value,
      "onUpdate:visible": (t) => L.value = t,
      trigger: "click",
      popperClass: s.b("person-select"),
      placement: "top-start",
      width: 320,
      teleported: !0,
      onShow: () => ge(),
      onHide: () => ce()
    }, r), {
      reference: () => Xe(),
      default: () => he()
    }), tt = () => [fe(), et()], be = () => {
      Y();
    };
    return we(() => {
      z.value && (window == null || window.addEventListener("resize", be), Y());
    }), ft(() => {
      e.resetState(), z.value && (window == null || window.removeEventListener("resize", be));
    }), {
      ns: s,
      c: e,
      refValue: v,
      curValue: u,
      valueText: S,
      loading: C,
      items: c,
      isEditable: F,
      showFormDefaultContent: x,
      modelVisible: L,
      curAttentionValue: $,
      attentionRef: z,
      readonlyState: O,
      onClear: ne,
      load: B,
      setEditable: le,
      renderDropModal: he,
      renderNoSelectValue: me,
      renderSelectInput: ve,
      onPopShow: ge,
      onPageHide: ce,
      onAttentionChange: Pe,
      renderEditContent: tt,
      renderReadonlyContent: Qe
    };
  },
  render() {
    return l("div", {
      ref: "attentionRef",
      class: [this.ns.b(), this.ns.b("person-value"), this.disabled ? this.ns.m("disabled") : "", this.readonlyState ? this.ns.m("readonly") : "", this.ns.is("editable", this.isEditable), this.ns.is("show-default", this.showFormDefaultContent)]
    }, [this.readonlyState ? this.renderReadonlyContent() : this.renderEditContent(), l(It, {
      disabled: this.disabled,
      value: this.curAttentionValue,
      codeListId: this.c.codeListId,
      codeListMap: this.c.codeListMap,
      defaultSelected: this.c.defaultSelected,
      controller: this.c,
      onChange: this.onAttentionChange
    }, null)]);
  }
}), Ct = ot(ee, function(o) {
  o.component(ee.name, ee), pt(
    "EDITOR_CUSTOMSTYLE_ATTENTION",
    () => new yt()
  );
}), Nt = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(o) {
    o.use(Ct);
  }
};
export {
  Ct as IBizAttention,
  Nt as default
};
