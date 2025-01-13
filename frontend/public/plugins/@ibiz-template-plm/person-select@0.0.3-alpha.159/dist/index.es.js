import './style.css';
var Ge = Object.defineProperty;
var Xe = (n, h, a) => h in n ? Ge(n, h, { enumerable: !0, configurable: !0, writable: !0, value: a }) : n[h] = a;
var p = (n, h, a) => (Xe(n, typeof h != "symbol" ? h + "" : h, a), a);
import { useNamespace as K, getDataPickerProps as Ye, getEditorEmits as qe, renderString as Qe, withInstall as et } from "@ibiz-template/vue3-util";
import { EditorController as tt, getDeACMode as st, UIActionUtil as at, OpenAppViewCommand as de, PluginStaticResource as it, registerEditorProvider as lt } from "@ibiz-template/runtime";
import { RuntimeModelError as J } from "@ibiz-template/core";
import { mergeDeepLeft as rt, clone as pe } from "ramda";
import { notNilEmpty as R } from "qx-util";
import { defineComponent as he, ref as S, onMounted as me, watch as O, createVNode as o, computed as W, onBeforeUnmount as nt, resolveComponent as C, mergeProps as ot, withDirectives as ut, resolveDirective as ct, createTextVNode as N, nextTick as dt, isVNode as pt } from "vue";
import { isArray as ht } from "lodash-es";
class mt extends tt {
  constructor() {
    super(...arguments);
    /**
     * 云系统操作者Map
     *
     * @memberof PersonelSelectController
     */
    p(this, "operatorMap", /* @__PURE__ */ new Map());
    /**
     * 当前操作者数据
     */
    p(this, "currentOperator");
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
    p(this, "multiple", !1);
    /**
     * 是否附加符号 多选且开启附加符号并且选择值为多个时，每个选择值前后都拼接上单引号后再抛出去
     */
    p(this, "isAddSymbol", !1);
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
      name: "name",
      title: "title"
    });
    /**
     * 部门人员UI转化
     */
    p(this, "deptFilterMap", {
      id: "id",
      name: "name",
      title: "title"
    });
    /**
     * 是否显示人员部门分页
     */
    p(this, "isShowTab", !0);
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
     * 是否配置了默认显示当前用户
     */
    p(this, "defaultSelCurUser", !1);
    /**
     * 值类型
     */
    p(this, "valueType", "OBJECTS");
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
      user_name: "name",
      user_title: "title"
    });
    /**
     * 选中后默认关注值
     *
     */
    p(this, "defaultAttentionValue", "");
    /**
     * 是否显示姓名文字
     */
    p(this, "showNameText", !0);
    /**
     * 是否显示姓名提示
     */
    p(this, "showNameTip", !1);
  }
  async onInit() {
    var u, e, c, r;
    if (super.onInit(), this.initDefaultAttribute(), this.valueItem = ((u = this.model.valueItemName) == null ? void 0 : u.toLowerCase()) || "", this.initParams(), await this.getOperatorUserList(), this.model.appDataEntityId && (this.model.appDEDataSetId && (this.interfaceName = this.model.appDEDataSetId), this.model.appDEACModeId && (this.deACMode = await st(
      this.model.appDEACModeId,
      this.model.appDataEntityId,
      this.context.srfappid
    ), this.deACMode))) {
      const { minorSortAppDEFieldId: m, minorSortDir: v } = this.deACMode;
      m && v && (this.sort = "".concat(m.toLowerCase(), ",").concat(v.toLowerCase())), this.deACMode.textAppDEFieldId && (this.textName = this.deACMode.textAppDEFieldId), this.deACMode.valueAppDEFieldId && (this.keyName = this.deACMode.valueAppDEFieldId), this.deACMode.deacmodeDataItems && (this.dataItems = [], this.deACMode.deacmodeDataItems.forEach(
        (b) => {
          b.id !== "value" && b.id !== "text" && this.dataItems.push(b);
        }
      ));
    }
    const a = [
      "PICKEREX_DROPDOWNVIEW",
      "PICKEREX_DROPDOWNVIEW_LINK",
      "PICKUPVIEW"
    ];
    this.model.editorType && a.includes(this.model.editorType) && this.initPickupViewParams(), this.objectIdField = (e = this.model.objectIdField) == null ? void 0 : e.toLowerCase(), this.objectNameField = (c = this.model.objectNameField) == null ? void 0 : c.toLowerCase(), this.objectValueField = (r = this.model.objectValueField) == null ? void 0 : r.toLowerCase();
  }
  /**
   * 初始化字段默认属性
   */
  initDefaultAttribute() {
    this.model.valueType && (this.valueType = this.model.valueType);
  }
  /**
   * 初始化noAc和noButton
   */
  initParams() {
    var a, u, e, c, r, m, v;
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
    if (this.userUrl = this.editorParams.URL, this.deptUrl = this.editorParams.DEPTURL, this.userMethod = this.editorParams.USERMETHOD || "post", this.deptMethod = this.editorParams.DEPTMETHOD || "post", this.multiple = this.editorParams.MULTIPLE === "true", this.defaultSelCurUser = this.editorParams.DEFAULTSELCURUSER === "true", this.separator = this.editorParams.SEPARATOR || ",", this.isAddSymbol = this.editorParams.ISADDSYMBOL === "true" && this.multiple === !0, this.isShowTab = this.editorParams.ISSHOWTAB !== "false", (a = this.editorParams) != null && a.VALUETYPE && (this.valueType = (u = this.editorParams) == null ? void 0 : u.VALUETYPE), (e = this.editorParams) != null && e.DEFAULTATNVALUE && (this.defaultAttentionValue = (c = this.editorParams) == null ? void 0 : c.DEFAULTATNVALUE), (r = this.editorParams) != null && r.VALUEITEMNAME && (this.valueItem = (m = this.editorParams) == null ? void 0 : m.VALUEITEMNAME), this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "SELFFILLMAP"))
      try {
        const b = JSON.parse((v = this.editorParams) == null ? void 0 : v.SELFFILLMAP);
        Object.assign(this.selfFillMap, b);
      } catch (b) {
        ibiz.log.error(b);
      }
    if (this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "USERMAP"))
      try {
        const b = JSON.parse(this.editorParams.USERMAP);
        Object.assign(this.userFilterMap, b);
      } catch (b) {
        this.userFilterMap = {
          id: "id",
          name: "name",
          title: "title"
        };
      }
    if (this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "DEPTMAP"))
      try {
        const b = JSON.parse(this.editorParams.DEPTMAP);
        Object.assign(this.deptFilterMap, b);
      } catch (b) {
        this.deptFilterMap = {
          id: "id",
          name: "name",
          title: "title"
        };
      }
    this.editorParams.SHOWNAMETEXT && (this.showNameText = this.toBoolean(this.editorParams.SHOWNAMETEXT)), this.editorParams.SHOWNAMETIP && (this.showNameTip = this.toBoolean(this.editorParams.SHOWNAMETIP));
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
   * 初始化当前操作者数据
   */
  async initCurrentOperator(a, u) {
    const e = this.context.srfuserid;
    if (!e)
      return;
    const c = await this.getServiceData(
      "department",
      a,
      {},
      {
        ...u,
        page: 0,
        size: 20,
        n_id_eq: e
      }
    );
    c && c.data && c.data.length > 0 && (this.currentOperator = c.data.find(
      (r) => r[this.deptFilterMap.id] === e
    ));
  }
  /**
   * 重置状态
   */
  resetState() {
    this.resetUserState(), this.resetDeptState();
  }
  /**
   * 重置全部人员分类的状态
   */
  resetUserState() {
    this.total = 0, this.currentNumber = -1, this.page = 0, this.copyUserUrl = "";
  }
  /**
   * 重置部门人员分类的状态
   */
  resetDeptState() {
    this.deptpage = 0, this.depttotal = 0, this.deptcurrentNumber = -1, this.copyDeptUrl = "";
  }
  /**
   * 加载更多
   */
  async loadMore(a, u, e = {}) {
    if (u === "user" && this.currentNumber < this.total) {
      const c = await this.getServiceData(u, a, e);
      if (c)
        return this.page += 1, this.currentNumber < 0 && (this.currentNumber += 1), this.currentNumber += this.size, this.total = (c.total ? Number(c.total) : Number(c.headers["x-total"])) || 0, c.data.forEach((r) => {
          Object.keys(this.userFilterMap).forEach((m) => {
            r[m] = r[this.userFilterMap[m]];
          });
        }), c;
    } else if (u === "department" && this.deptcurrentNumber < this.depttotal) {
      const c = await this.getServiceData(u, a, e);
      if (c)
        return this.deptpage += 1, this.deptcurrentNumber < 0 && (this.deptcurrentNumber += 1), this.deptcurrentNumber += this.size, this.depttotal = (c.total ? Number(c.total) : Number(c.headers["x-total"])) || 0, c.data.forEach((r) => {
          Object.keys(this.deptFilterMap).forEach((m) => {
            r[m] = r[this.deptFilterMap[m]];
          });
        }), c;
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
  async onActionClick(a, u, e) {
    const c = a.uiactionId;
    let r = {};
    this.parent.form ? r = this.parent.form.ctx.view : this.parent.grid && (r = this.parent.grid.ctx.view), await at.execAndResolved(
      c,
      {
        context: this.context,
        params: this.params,
        data: u,
        view: r,
        event: e
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
  fill(a = "", u, e, c) {
    if (R(a)) {
      if (R(u)) {
        const r = a.match(this.contextReg);
        r == null || r.forEach((m) => {
          const v = m.slice(10, m.length - 1);
          a = a.replace("${context.".concat(v, "}"), u[v] || "");
        });
      }
      if (R(e)) {
        const r = a.match(this.paramsReg);
        r == null || r.forEach((m) => {
          const v = m.slice(9, m.length - 1);
          a = a.replace("${params.".concat(v, "}"), e[v] || "");
        });
      }
      if (R(c)) {
        const r = a.match(this.dataReg);
        r == null || r.forEach((m) => {
          const v = m.slice(7, m.length - 1);
          a = a.replace("${data.".concat(v, "}"), c[v] || "");
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
  async getServiceData(a, u, e, c) {
    const { context: r, params: m } = this.handlePublicParams(
      u,
      this.context,
      this.params
    ), v = {};
    this.sort && !Object.is(this.sort, "") && Object.assign(v, { sort: this.sort }), Object.assign(v, { size: this.size }), e && Object.assign(v, e);
    const b = c || rt(m, v);
    let P = "";
    const y = this.fill(this.userUrl, r, m, u).replaceAll(
      "//",
      "/"
    ), I = this.fill(this.deptUrl, r, m, u).replaceAll(
      "//",
      "/"
    );
    this.copyUserUrl = y, this.copyDeptUrl = I;
    let f = "post";
    const g = {};
    if (a === "user" ? (P = y, f = this.userMethod.toLowerCase(), f === "get" ? Object.assign(g, { method: f, params: b }) : Object.assign(g, { method: f, data: b })) : (P = I, f = this.deptMethod.toLowerCase(), f === "get" ? Object.assign(g, { method: f, params: b }) : Object.assign(g, { method: f, data: b })), P)
      return await ibiz.net.request(P, g);
    throw new J(this.model, "请配置数据接口地址");
  }
  /**
   * 打开数据选择视图
   *
   * @param {IData} data 数据对象
   * @param {IData[]} selectedData 选中项集合
   * @returns {*}  {(Promise<IData[] | undefined>)}
   * @memberof PersonelSelectController
   */
  async openPickUpView(a, u) {
    await this.initPickupViewParams();
    const { context: e, params: c } = this.handlePublicParams(
      a,
      this.context,
      this.params
    );
    if (u && (c.selectedData = u), !this.pickupView)
      throw new J(this.model, "请配置数据选择视图");
    const r = await ibiz.commands.execute(
      de.TAG,
      this.pickupView.id,
      e,
      c,
      { openMode: "POPUPMODAL" }
    );
    if (r && r.ok && r.data)
      return r.data;
    ibiz.log.debug("模态取消或关闭异常", r);
  }
  /**
   * 打开数据链接视图
   */
  async openLinkView(a) {
    const u = this.context.clone();
    a[this.valueItem] && (u.srfkey = a[this.valueItem]);
    const { context: e, params: c } = this.handlePublicParams(
      a,
      u,
      this.params
    ), { linkAppViewId: r } = this.model;
    if (!r)
      throw new J(this.model, "请配置数据链接视图");
    return ibiz.commands.execute(
      de.TAG,
      r,
      e,
      c
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
      this.dataItems.map((e) => {
        const r = a.map((m) => m[e.appDEFieldId]).join(this.separator);
        return e.format || e.convertToCodeItemText && e.codeListId || e.customCode, { id: e.id, value: r };
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
    const u = {};
    return this.objectIdField && Object.assign(u, {
      [this.objectIdField]: a[this.keyName]
    }), this.objectNameField && Object.assign(u, {
      [this.objectNameField]: a[this.textName]
    }), this.objectValueField && Object.assign(u, {
      [this.objectValueField]: pe(a)
    }), u;
  }
  /**
   * 获取操作用户列表
   *
   * @memberof PersonelSelectController
   */
  async getOperatorUserList() {
    const a = await ibiz.hub.getApp(this.context.srfappid);
    let u = [];
    u = await a.codeList.get(
      "SysOperator",
      this.context,
      this.params
    ), this.operatorMap = new Map(
      u.map((e) => [e.value, e])
    );
  }
  /**
   * 判断是否显示姓名文字
   *
   * @return {*}  {boolean}
   * @memberof PersonelSelectController
   */
  isShowNameText() {
    return this.showNameText;
  }
  /**
   * 判断是否显示姓名提示
   *
   * @return {*}  {boolean}
   * @memberof PersonelSelectController
   */
  isShowNameTip() {
    return this.showNameTip;
  }
  /**
   * 获取人员头像路径
   *
   * @return {*}  {boolean}
   * @memberof PersonelSelectController
   */
  getUserPictureUrl(a, u) {
    if (this.operatorMap.size <= 0)
      return "";
    let e = {};
    return this.operatorMap.get(a) ? e = this.operatorMap.get(a) : Array.from(this.operatorMap.entries()).find((c) => {
      const r = c[1] || {};
      return r.text && u && r.text === u ? (e = r, !0) : !1;
    }), e.data && e.data.iconurl ? e.data.iconurl : "";
  }
}
class ft {
  constructor() {
    p(this, "component", "PersonelSelect");
    p(this, "formEditor", "PersonelSelect");
    p(this, "gridEditor", "PersonelSelect");
  }
  async createController(h, a) {
    const u = new mt(h, a);
    return await u.init(), u;
  }
}
const vt = /* @__PURE__ */ he({
  name: "VirtualList",
  props: {
    items: {
      // 数据源
      type: Array,
      default: () => []
    },
    itemHeight: {
      // 每行高度
      type: Number,
      default: 36
    },
    showNum: {
      // 可视数量
      type: Number,
      default: 20
    }
  },
  emits: ["scrollEvent"],
  setup(n, {
    emit: h
  }) {
    const a = K("virtual-list"), u = S(36), e = S(), c = S([]), r = S(0), m = S(0), v = S(0), b = S(0), P = () => {
      m.value = Math.floor(b.value / n.itemHeight), v.value = m.value + n.showNum, c.value = n.items.slice(m.value, v.value);
      const f = b.value - b.value % n.itemHeight;
      r.value = f;
    }, y = () => {
      b.value = e.value.scrollTop, P(), I(u.value, b.value);
    }, I = (f, g) => {
      h("scrollEvent", f, g);
    };
    return me(() => {
      setTimeout(() => {
        scroll();
      }, 1e3);
    }), O(() => n.items, () => {
      u.value = n.itemHeight * n.items.length, P();
    }, {
      immediate: !0,
      deep: !0
    }), {
      ns: a,
      contentHeight: u,
      showList: c,
      contentBox: e,
      top: r,
      onScroll: y
    };
  },
  render() {
    return o("div", {
      ref: "contentBox",
      class: this.ns.b(),
      onScroll: () => this.onScroll()
    }, [o("div", {
      class: this.ns.e("container"),
      style: "height:".concat(this.contentHeight, "px;")
    }, [o("div", {
      class: this.ns.e("content"),
      style: "top:".concat(this.top, "px;")
    }, [this.showList.map((n, h) => o("div", {
      key: h,
      class: this.ns.m("item")
    }, [this.$slots.default ? this.$slots.default({
      ...n,
      // eslint-disable-next-line object-shorthand
      index: h
    }) : n.name]))])])]);
  }
}), V = new it(import.meta.url);
class gt {
  /**
   * 计算选中项绘制个数 多选场景需计算显示人员是否超出
   * @author ljx
   * @date 2024-03-05 02:42:45
   * @param {IData} values 选中项key值集合
   * @returns {number} selRenderNum
   */
  static calcSelItemRenderNum(h, a) {
    let u = 0;
    if (a && (h == null ? void 0 : h.length) > 0) {
      const e = (a == null ? void 0 : a.offsetWidth) || 0, c = window.getComputedStyle(a), r = parseInt(c.marginLeft, 10), m = parseInt(c.marginRight, 10), v = parseInt(c.paddingLeft, 10), b = parseInt(c.paddingRight, 10), P = r + m + v + b, y = 30, I = 28, f = 8, g = (I + f) * h.length;
      e - P - y - g < 0 && (u = Math.floor(
        (e - P - y) / (I + f)
      ), u -= 1);
    }
    return u;
  }
}
function bt(n) {
  return typeof n == "function" || Object.prototype.toString.call(n) === "[object Object]" && !pt(n);
}
const Z = /* @__PURE__ */ he({
  name: "PersonelSelect",
  props: Ye(),
  emits: qe(),
  setup(n, {
    emit: h
  }) {
    const a = K("picker-dropdown"), u = K("personel-select"), e = n.controller, c = S(""), r = S([]), m = S([]), v = S(""), b = S(!1), P = S(!1), y = S(""), I = S([]), f = S("user"), g = S([]), A = S(!1), $ = S(!1), D = S(!1), G = S(""), X = S(), U = S(), Y = S();
    let x;
    const z = S(), q = S([]);
    let j = 0;
    const fe = W(() => !!(n.controlParams && n.controlParams.editmode === "hover")), Q = (t) => {
      const s = [], i = [];
      g.value = [], t.forEach((l) => {
        var E, M;
        const d = pe(l);
        (E = e.selfFillMap) != null && E.user_id && ((M = e.selfFillMap) != null && M.user_name) && Object.assign(d, {
          id: l[e.selfFillMap.user_id],
          name: l[e.selfFillMap.user_name]
        }), e.selfFillMap.user_title && Object.assign(d, {
          title: l[e.selfFillMap.user_title]
        }), s.push(l[e.selfFillMap.user_id]), i.push(l[e.selfFillMap.user_name]), g.value.push(d);
      }), v.value = s == null ? void 0 : s.join(e.separator), c.value = i == null ? void 0 : i.toString();
    }, L = () => {
      const t = g.value.map((s) => {
        var l, d, E;
        const i = {};
        return Object.assign(i, {
          [(l = e.selfFillMap) == null ? void 0 : l.user_id]: s.id,
          [(d = e.selfFillMap) == null ? void 0 : d.user_name]: s.name,
          [(E = e.selfFillMap) == null ? void 0 : E.user_title]: s.title
          // 添加用户职称
        }), e.attentionTypeField && e.defaultAttentionValue && Object.assign(i, {
          [e.attentionTypeField]: e.defaultAttentionValue
        }), i;
      });
      h("change", t), e.parent.form && (e.parent.form.state.modified = !1);
    }, ve = (t) => {
      const s = {};
      return f.value === "user" ? Object.assign(s, {
        id: t[e.userFilterMap.id],
        name: t[e.userFilterMap.name]
      }) : Object.assign(s, {
        id: t[e.deptFilterMap.id],
        name: t[e.deptFilterMap.name]
      }), s;
    }, ge = async () => {
      var t, s;
      if (e.defaultSelCurUser) {
        const i = {};
        if (Object.assign(i, {
          id: (t = e.context) == null ? void 0 : t.srfuserid,
          name: (s = e.context) == null ? void 0 : s.srfusername
        }), e.currentOperator || await e.initCurrentOperator({}), e.currentOperator && Object.assign(i, {
          title: e.currentOperator[e.deptFilterMap.title]
        }), e.multiple) {
          const l = g.value.findIndex((d) => d.id === i[e.deptFilterMap.id]);
          l < 0 ? g.value.push(i) : Object.assign(g.value[l], i);
        } else
          g.value.length === 0 && (g.value = [i]);
        L();
      }
    }, ee = () => {
      x != null && x.value && x.value.hide(), U.value && U.value.hide();
    }, be = (t) => {
      (t.key === "Escape" || t.keyCode === 27) && (t.stopPropagation(), ee());
    }, _ = () => {
      if (!(e.defaultAttentionValue && e.valueType === "OBJECTS"))
        return;
      const t = v.value.split(e.separator);
      j = gt.calcSelItemRenderNum(t, Y.value), v.value = "", Q(g.value);
    };
    O(() => n.value, (t) => {
      if (t || t === null || t === void 0) {
        if (e.model.valueType === "OBJECT")
          c.value = t ? t[e.objectNameField] : null;
        else if (e.valueType === "OBJECTS") {
          const s = ht(t) ? t : [];
          Q(s), _();
          return;
        } else
          c.value = t;
        if (t == null) {
          c.value = "", g.value = [], h("change", null, e.valueItem), h("blur");
          return;
        } else if (e.multiple && g.value.length === 0 && e.valueItem && n.data && n.data[e.valueItem]) {
          let s = n.data[e.valueItem].split(e.separator), i = c.value.split(e.separator);
          e.isAddSymbol && (s = s.map((l) => l.slice(1, -1)), i = i.map((l) => l.slice(1, -1))), s.forEach((l, d) => {
            g.value.push({
              id: l,
              name: i[d]
            });
          });
        }
      }
    }, {
      immediate: !0
    });
    const Se = W(() => n.data && n.data[e.valueItem] || void 0);
    O(Se, (t, s) => {
      t !== s && (v.value = t, t == null && (g.value = [], h("change", null)));
    }, {
      immediate: !0,
      deep: !0
    });
    const te = (t) => {
      t ? P.value = t : setTimeout(() => {
        P.value = t;
      }, 100);
    }, Ee = (t, s) => {
      k(s);
      const i = g.value.findIndex((l) => l.id === t.id);
      if (i > -1 && g.value.splice(i, 1), e.valueItem) {
        let l = g.value.map((d) => d.id);
        e.isAddSymbol && (l = l.map((d) => "'".concat(d, "'"))), h("change", l.join(e.separator), e.valueItem);
      }
      if (e.valueType === "OBJECTS")
        L();
      else {
        let l = g.value.map((d) => d.name);
        e.isAddSymbol && (l = l.map((d) => "'".concat(d, "'"))), h("change", l.join(e.separator));
      }
    }, Me = async (t) => {
      console.log("选中数据", t), y.value && (f.value === "user" ? r.value.unshift(t) : m.value.unshift(t));
      const s = {};
      if (Object.assign(s, t), f.value === "user") {
        Object.assign(s, {
          [e.userFilterMap.id]: s[e.userFilterMap.id] ? s[e.userFilterMap.id] : s.srfkey,
          [e.userFilterMap.name]: s[e.userFilterMap.name] ? s[e.userFilterMap.name] : s.srfmajortext
        });
        const i = g.value.findIndex((l) => l.id === s[e.userFilterMap.id]);
        i < 0 ? g.value.push({
          id: s[e.userFilterMap.id],
          name: s[e.userFilterMap.name],
          title: s[e.userFilterMap.title]
        }) : g.value.splice(i, 1);
      } else {
        Object.assign(s, {
          [e.deptFilterMap.id]: s[e.deptFilterMap.id] ? s[e.deptFilterMap.id] : s.srfkey,
          [e.deptFilterMap.name]: s[e.deptFilterMap.name] ? s[e.deptFilterMap.name] : s.srfmajortext
        });
        const i = g.value.findIndex((l) => l.id === s[e.deptFilterMap.id]);
        i < 0 ? g.value.push({
          id: s[e.deptFilterMap.id],
          name: s[e.deptFilterMap.name],
          title: s[e.deptFilterMap.title]
        }) : g.value.splice(i, 1);
      }
      if (e.multiple) {
        if (e.valueItem) {
          let i = g.value.map((l) => l.id);
          e.isAddSymbol && (i = i.map((l) => "'".concat(l, "'"))), h("change", i.join(e.separator), e.valueItem);
        }
        if (e.valueType === "OBJECTS")
          L();
        else {
          let i = g.value.map((l) => l.name);
          e.isAddSymbol && (i = i.map((l) => "'".concat(l, "'"))), h("change", i.join(e.separator));
        }
      } else {
        const i = await e.calcFillDataItems([t]);
        i.length && i.forEach((l) => {
          h("change", l.value, l.id);
        }), e.valueItem && (f.value === "user" ? h("change", s[e.userFilterMap.id], e.valueItem) : h("change", s[e.deptFilterMap.id], e.valueItem)), e.model.valueType === "OBJECT" ? h("change", e.handleObjectParams(s)) : e.valueType === "OBJECTS" ? (g.value = [ve(s)], L()) : f.value === "user" ? h("change", t[e.userFilterMap.name]) : h("change", t[e.deptFilterMap.name]), D.value = !1;
      }
      e.valueType !== "OBJECTS" && h("blur", t), te(!1);
    }, ye = (t, s) => {
      t.forEach((i) => {
        const l = r.value.findIndex((d) => d[s] === i[s]);
        l > -1 ? r.value.splice(l, 1, i) : r.value.push(i);
      });
    }, T = async (t = !1) => {
      if (y.value)
        return;
      A.value = !0;
      const s = {};
      f.value === "department" ? s.page = e.deptpage : s.page = e.page;
      try {
        const i = await e.loadMore(n.data, f.value, s);
        i && (f.value === "user" ? r.value.length === 0 ? r.value = i.data : ye(i.data, e.userFilterMap.id) : m.value.length === 0 ? m.value = i.data : m.value.push(...i.data));
      } catch (i) {
        A.value = !1;
      }
      A.value = !1;
    }, se = (t) => {
      const {
        dataItems: s
      } = e;
      s != null && s.length && s.forEach((i) => {
        h("change", null, i.id);
      }), e.valueItem && h("change", null, e.valueItem), e.valueType === "OBJECTS" ? h("change", []) : (h("change", null), h("blur", t)), t.stopPropagation(), t.preventDefault();
    }, F = W(() => Qe(c.value));
    O(F, (t, s) => {
      t !== s && e.valueType !== "OBJECTS" && h("infoTextChange", t);
    }, {
      immediate: !0
    }), O(U, (t) => {
      n.autoFocus && t && (D.value = !0);
    }), O(D, (t) => {
      t === !1 && h("blur");
    });
    const ae = async (t) => {
      A.value = !0;
      try {
        const s = {};
        Object.assign(s, {
          query: t,
          size: 1e3
        });
        const i = await e.getServiceData(f.value, n.data, s);
        i && (f.value === "user" ? i.data.forEach((l) => {
          Object.keys(e.userFilterMap).forEach((d) => {
            l[d] = l[e.userFilterMap[d]];
          });
        }) : i.data.forEach((l) => {
          Object.keys(e.deptFilterMap).forEach((d) => {
            l[d] = l[e.deptFilterMap[d]];
          });
        }), I.value = i.data, A.value = !1);
      } catch (s) {
        A.value = !1;
      }
    }, ie = (t) => {
      if (f.value !== t) {
        if (f.value = t, y.value) {
          ae(y.value);
          return;
        }
        f.value === "user" && r.value.length === 0 && (e.resetUserState(), T()), f.value === "department" && m.value.length === 0 && (e.resetDeptState(), T());
      }
    }, Pe = (t) => {
      e.isShowNameText() || t.stopPropagation();
    }, Ae = () => {
      const t = document.documentElement;
      return t ? getComputedStyle(t).getPropertyValue("--ibiz-color-primary") : null;
    }, Fe = (t) => /[\u4E00-\u9FA5]/.test(t), Ie = (t) => /[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(t), B = (t) => {
      if (!t)
        return "";
      let s = 0;
      for (let w = 0; w < t.length; w++)
        if (Fe(t))
          s = t.charCodeAt(w) + ((s << 5) - s), s = s & s;
        else {
          const Ke = t.charCodeAt(w);
          s += Ke.toString(16);
        }
      const i = String(s).substring(0, 6);
      let l = parseInt(i.substring(0, 2), 16), d = parseInt(i.substring(2, 4), 16), E = parseInt(i.substring(4, 6), 16);
      l < 0 && (l = 10), d < 0 && (d = 10), E < 0 && (E = 10);
      const M = "#".concat(l.toString(16).padStart(2, "0")).concat(d.toString(16).padStart(2, "0")).concat(E.toString(16).padStart(2, "0"));
      return M === "#FFFFFF" && Ae() || M;
    }, we = (t) => {
      clearTimeout(z.value), z.value = setTimeout(() => {
        !t && t !== 0 ? T() : ae(t), clearTimeout(z.value);
      }, 300);
    }, Te = () => o(C("el-input"), {
      class: a.be("select-modal", "search-input"),
      ref: X,
      modelValue: y.value,
      "onUpdate:modelValue": (t) => y.value = t,
      placeholder: "搜索",
      onInput: (t) => we(t),
      onKeydown: be
    }, {
      suffix: () => o("img", {
        src: "".concat(V.dir("assets/images/svg/search.svg")),
        alt: ""
      }, null)
    }), Ce = () => o("div", {
      class: a.be("select-modal", "select-state")
    }, [o("div", {
      class: [a.bem("select-modal", "select-state", "select-slider"), a.is("left", f.value === "user"), a.is("right", f.value !== "user")]
    }, null), o("div", {
      class: a.bem("select-modal", "select-state", "select-personel"),
      onClick: () => ie("user")
    }, [N("人员")]), o("div", {
      class: a.bem("select-modal", "select-state", "select-department"),
      onClick: () => ie("department")
    }, [N("部门")])]), Oe = (t) => {
      t.forEach((s) => {
        s.capLanguageRes && s.capLanguageRes.lanResTag && (s.caption = ibiz.i18n.t(s.capLanguageRes.lanResTag, s.caption)), s.tooltipLanguageRes && s.tooltipLanguageRes.lanResTag && (s.tooltip = ibiz.i18n.t(s.tooltipLanguageRes.lanResTag, s.tooltip));
      });
    }, Ne = async (t, s) => {
      await e.onActionClick(t, [n.data], s);
    }, xe = (t) => o("div", {
      class: a.bem("select-modal", "actions", "item"),
      title: t.tooltip || t.caption,
      onClick: (s) => Ne(t, s)
    }, [t.showIcon && t.sysImage && o(C("iBizIcon"), {
      icon: t.sysImage
    }, null)]), De = () => {
      var s;
      const t = ((s = e.model.uiactionGroup) == null ? void 0 : s.uiactionGroupDetails) || [];
      return Oe(t), o("div", {
        class: a.be("select-modal", "actions")
      }, [t.map((i) => xe(i))]);
    }, Ue = () => {
      var s;
      const t = ((s = e.model.uiactionGroup) == null ? void 0 : s.uiactionGroupDetails) || [];
      return !e.isShowTab && t.length === 0 ? null : o("div", {
        class: [a.be("select-modal", "select"), a.is("no-solider-tab", !e.isShowTab && t.length > 0)]
      }, [e.isShowTab ? Ce() : null, De()]);
    }, je = (t) => {
      if (e.multiple) {
        if (v.value) {
          let s = v.value.split(e.separator);
          return e.isAddSymbol && (s = s.map((l) => l.slice(1, -1))), s.findIndex((l) => l === t) > -1 ? o("div", {
            class: a.bem("select-modal", "personel-list", "icon")
          }, [o("i", {
            class: "fa fa-check",
            "aria-hidden": "true"
          }, null)]) : null;
        }
      } else
        return v.value === t ? o("div", {
          class: a.bem("select-modal", "personel-list", "icon")
        }, [o("i", {
          class: "fa fa-check",
          "aria-hidden": "true"
        }, null)]) : null;
    }, Le = (t) => {
      if (t && t.toString().length < 2)
        return t;
      if (t && t.toString().length >= 2) {
        if (Ie(t)) {
          const d = t.split("").find((M) => /[a-zA-Z]/.test(M)) || "", E = t.split("").find((M) => /[\u4E00-\u9FA5]/.test(M)) || "";
          return "".concat(d).concat(E).toLowerCase();
        }
        return /[a-zA-Z]/.test(t) ? t.split("").filter((d) => /[a-zA-Z]/.test(d)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(t) ? t.split("").filter((d) => /[\u4E00-\u9FA5]/.test(d)).slice(-2).join("") : t.replaceAll(" ", "").substring(0, 2);
      }
    }, ke = (t) => {
      console.log("头像加载失败"), q.value.push(t);
    }, Re = (t) => {
      if (!t)
        return null;
      const s = JSON.parse(t);
      if (s.length === 0)
        return null;
      const {
        downloadUrl: i
      } = ibiz.util.file.calcFileUpDownUrl(e.context, e.params, n.data, e.editorParams), l = i.replace("%fileId%", s[0].id);
      return o("img", {
        class: a.bem("select-modal", "personel-list", "avatar"),
        src: l,
        onError: () => ke(t),
        alt: ""
      }, null);
    }, H = (t, s) => {
      const i = e.getUserPictureUrl(t, s);
      return i && !q.value.includes(i) ? Re(i) : Le(s);
    }, le = (t) => {
      const s = f.value === "user" ? t[e.userFilterMap.name] || t.name : t[e.deptFilterMap.name] || t.name, i = f.value === "user" ? t[e.userFilterMap.id] : t[e.deptFilterMap.id], l = f.value === "user" ? t[e.userFilterMap.title] : t[e.deptFilterMap.title];
      return o("div", {
        class: [a.bem("select-modal", "personel-list", "item"), a.is("selected", v.value === i)],
        onClick: () => Me(t)
      }, [o("div", {
        class: a.bem("select-modal", "personel-list", "text")
      }, [o("div", {
        class: a.bem("select-modal", "personel-list", "text-img"),
        style: "background-color:".concat(B(s))
      }, [H(i, s)]), o("div", {
        class: a.bem("select-modal", "personel-list", "text-label")
      }, [s]), l && o("div", {
        class: a.bem("select-modal", "personel-list", "title-label")
      }, [l]), i === e.context.srfuserid ? o("div", {
        class: a.bem("select-modal", "personel-list", "myself")
      }, [N("我自己")]) : null]), je(i)]);
    }, Ve = (t, s) => {
      const {
        context: i,
        params: l
      } = e;
      return o(C("iBizControlShell"), {
        class: a.b("panel-item"),
        data: t,
        modelData: s,
        context: i,
        params: l
      }, null);
    }, $e = (t, s) => {
      const i = S();
      return o(C("el-popover"), {
        ref: i,
        target: "hover",
        placement: "right",
        offset: 24,
        width: "auto",
        onShow: (l) => {
          x = i;
        }
      }, {
        reference: () => le(t),
        default: () => Ve(t, s)
      });
    }, ze = (t) => y.value ? I.value : t, k = (t) => {
      t.preventDefault(), t.stopPropagation();
    }, _e = (t, s) => {
      $.value && (f.value === "user" ? t - s < 305 && (A.value || T()) : t - s < 250 && (A.value || T()));
    }, re = (t) => {
      var d, E;
      const s = ((d = e.model.uiactionGroup) == null ? void 0 : d.uiactionGroupDetails) || [], i = ze(t), l = (E = e.deACMode) == null ? void 0 : E.itemLayoutPanel;
      return o(vt, {
        items: i,
        itemHeight: 36,
        class: [a.be("select-modal", "personel-list"), a.be("select-modal", "personel-list-".concat(f.value)), a.is("no-solider-tab", !e.isShowTab && s.length > 0)],
        onScrollEvent: (M, w) => _e(M, w)
      }, {
        default: (M) => l ? $e(M, l) : le(M)
      });
    }, ne = (t) => {
      b.value = t;
    }, Be = () => o("div", {
      class: a.be("select-modal", "deptpersonel")
    }, [o("div", {
      class: a.bem("select-modal", "deptpersonel", "dept")
    }, [o("div", {
      class: "collpase-icon"
    }, [b.value ? o("i", {
      class: "fa fa-angle-right",
      "aria-hidden": "true",
      onClick: () => ne(!1)
    }, null) : o("i", {
      class: "fa fa-angle-down",
      "aria-hidden": "true",
      onClick: () => ne(!0)
    }, null)]), o("img", {
      src: "".concat(V.dir("assets/images/svg/org.svg"))
    }, null), o("span", null, ["".concat(e.context.srfusername, "的团队")]), o("span", null, [N("·")]), o("span", null, [e.depttotal])]), b.value ? null : o("div", {
      class: a.bem("select-modal", "deptpersonel", "dept-person")
    }, [re(m.value)])]), He = () => ut(o("div", {
      class: a.b("select-modal"),
      onPointerdown: k,
      onPointerup: k,
      onClick: k
    }, [Te(), Ue(), f.value === "user" ? re(r.value) : Be()]), [[ct("loading"), A.value]]), oe = () => o("div", {
      class: [a.b("no-select-value"), a.is("readonly", n.readonly || n.disabled)]
    }, [o("img", {
      src: "".concat(V.dir("assets/images/svg/member.svg")),
      alt: ""
    }, null), o("span", null, [N("未设置")])]), ue = () => {
      var s;
      const t = e.isShowNameTip();
      if (e.multiple) {
        let i = !1;
        const l = [];
        if (v.value) {
          let d = v.value.split(e.separator), E = F.value.split(e.separator);
          e.isAddSymbol && (d = d.map((M) => M.slice(1, -1))), e.isAddSymbol && (E = E.map((M) => M.slice(1, -1))), d.forEach((M, w) => {
            l.push({
              id: M,
              name: E[w]
            });
          });
        } else
          F.value === "当前用户" && n.disabled && l.push({
            id: F.value,
            name: F.value
          });
        return e.defaultAttentionValue && e.valueType === "OBJECTS" && j > 0 && (i = j < ((s = g.value) == null ? void 0 : s.length), l == null || l.splice(j, l == null ? void 0 : l.length)), o("div", {
          class: [a.b("select-value-multiple"), a.is("readonly", n.readonly || n.disabled), i ? a.be("select-value-multiple", "hidden") : ""]
        }, [l == null ? void 0 : l.map((d) => {
          let E;
          return o("div", {
            class: a.be("select-value-multiple", "item"),
            title: t ? d.name : ""
          }, [o("div", {
            class: [a.be("select-value", "textimg"), a.bem("select-value-multiple", "item", "textimg")],
            style: "background-color:".concat(B(d.name))
          }, [o(C("el-tooltip"), {
            class: "box-item",
            effect: "dark",
            content: d.name,
            placement: "top",
            offset: 12
          }, bt(E = H(d.id, d.name)) ? E : {
            default: () => [E]
          }), n.readonly || n.disabled ? null : o("div", {
            class: [a.bem("select-value-multiple", "item", "close")],
            onClick: (M) => Ee(d, M)
          }, [o("i", {
            class: "fa fa-close",
            "aria-hidden": "true"
          }, null)])])]);
        }), i ? o(C("el-tooltip"), {
          class: u.b("multiple-ellipsis"),
          "popper-class": u.be("multiple-ellipsis", "popper"),
          effect: "dark",
          content: F.value,
          placement: "top",
          offset: 12
        }, {
          default: () => [o("span", {
            class: u.be("multiple-ellipsis", "default")
          }, [N("...")])]
        }) : null, o("div", {
          class: a.b("no-select-value"),
          title: "选择人员"
        }, [o("img", {
          src: "".concat(V.dir("assets/images/svg/member.svg")),
          alt: ""
        }, null)])]);
      }
      return o("div", {
        class: [a.b("select-value"), a.is("readonly", n.readonly || n.disabled)],
        title: t ? F.value : ""
      }, [o("div", {
        class: a.be("select-value", "textimg"),
        style: "background-color:".concat(B(F.value))
      }, [H(v.value, F.value)]), o("div", {
        class: a.be("select-value", "text")
      }, [o("div", {
        class: a.bem("select-value", "text", "label")
      }, [F.value])]), n.readonly || n.disabled ? null : o("i", {
        class: ["fa fa-times-circle", a.be("select-value", "close")],
        "aria-hidden": "true",
        onClick: (i) => se(i)
      }, null)]);
    }, Je = async () => {
      var d, E;
      $.value = !0, h("focus");
      const {
        context: t,
        params: s
      } = e.handlePublicParams(n.data, e.context, e.params), i = e.fill(e.userUrl, t, s, n.data).replaceAll("//", "/"), l = e.fill(e.deptUrl, t, s, n.data).replaceAll("//", "/");
      (i !== e.copyUserUrl || l !== e.copyDeptUrl || n.data && n.data.srfkey !== G.value) && (G.value = ((d = n.data) == null ? void 0 : d.srfkey) || "", r.value = [], m.value = [], e.resetState(), T(!0)), await dt(), (E = X.value) == null || E.focus();
    }, We = () => F.value ? ue() : oe(), Ze = () => {
      $.value = !1;
    };
    O(() => n.readonly, (t) => {
      t && ee();
    }, {
      deep: !0
    });
    const ce = () => {
      _();
    };
    return me(() => {
      ge(), window == null || window.addEventListener("resize", ce), _();
    }), nt(() => {
      e.resetState(), window == null || window.removeEventListener("resize", ce);
    }), {
      ns: a,
      ns2: u,
      c: e,
      refValue: v,
      curValue: c,
      valueText: F,
      loading: A,
      items: r,
      personelSelRef: Y,
      onClear: se,
      load: T,
      isEditable: P,
      popoverRef: U,
      setEditable: te,
      renderDropModal: He,
      renderNoSelectValue: oe,
      renderSelectInput: ue,
      renderReadState: We,
      onPopShow: Je,
      onPageHide: Ze,
      handleClick: Pe,
      showFormDefaultContent: fe,
      modelVisible: D
    };
  },
  render() {
    const n = o(C("el-popover"), ot({
      ref: "popoverRef",
      visible: this.modelVisible,
      "onUpdate:visible": (h) => this.modelVisible = h,
      trigger: "click",
      popperClass: this.ns.b("person-select"),
      width: 320,
      teleported: !0,
      onShow: () => this.onPopShow(),
      onHide: () => this.onPageHide()
    }, this.$attrs), {
      reference: () => this.renderReadState(),
      default: () => this.renderDropModal()
    });
    return o("div", {
      ref: "personelSelRef",
      class: [this.ns.b(), this.ns2.b(), this.ns.b("person-value"), this.disabled ? this.ns.m("disabled") : "", this.readonly ? this.ns.m("readonly") : "", this.c.isShowNameText() ? "" : this.ns.m("only-icon"), this.ns.is("editable", this.isEditable), this.ns.is("show-default", this.showFormDefaultContent), this.ns2.is("multiple", this.c.multiple)],
      onClick: this.handleClick
    }, [this.readonly || this.disabled ? this.renderReadState() : n]);
  }
}), St = et(
  Z,
  function(n) {
    n.component(Z.name, Z), lt(
      "EDITOR_CUSTOMSTYLE_PERSON_SELECT",
      () => new ft()
    );
  }
), Tt = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(n) {
    n.use(St);
  }
};
export {
  St as IBizPersonelSelect,
  Tt as default
};
