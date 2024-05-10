import './style.css';
var He = Object.defineProperty;
var We = (n, h, s) => h in n ? He(n, h, { enumerable: !0, configurable: !0, writable: !0, value: s }) : n[h] = s;
var p = (n, h, s) => (We(n, typeof h != "symbol" ? h + "" : h, s), s);
import { useNamespace as ue, getDataPickerProps as Ze, getEditorEmits as Ke, renderString as Ge, withInstall as Xe } from "@ibiz-template/vue3-util";
import { EditorController as Ye, getDeACMode as qe, UIActionUtil as Qe, OpenAppViewCommand as oe, PluginStaticResource as et, registerEditorProvider as tt } from "@ibiz-template/runtime";
import { RuntimeModelError as _ } from "@ibiz-template/core";
import { mergeDeepLeft as at, clone as ce } from "ramda";
import { notNilEmpty as L } from "qx-util";
import { defineComponent as de, ref as g, onMounted as pe, watch as D, createVNode as r, computed as J, onBeforeUnmount as st, resolveComponent as w, withDirectives as lt, resolveDirective as it, createTextVNode as T, nextTick as rt, isVNode as nt } from "vue";
import { isArray as ot } from "lodash-es";
class ut extends Ye {
  constructor() {
    super(...arguments);
    /**
     * 云系统操作者Map
     *
     * @memberof PersonelSelectController
     */
    p(this, "operatorMap", /* @__PURE__ */ new Map());
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
    p(this, "selfFillMap", {});
    /**
     * 选中后默认关注值
     *
     */
    p(this, "defaultAttentionValue", "");
  }
  async onInit() {
    var e, m, u, o;
    if (super.onInit(), this.initDefaultAttribute(), this.initParams(), await this.getOperatorUserList(), this.valueItem = ((e = this.model.valueItemName) == null ? void 0 : e.toLowerCase()) || "", this.model.appDataEntityId && (this.model.appDEDataSetId && (this.interfaceName = this.model.appDEDataSetId), this.model.appDEACModeId && (this.deACMode = await qe(
      this.model.appDEACModeId,
      this.model.appDataEntityId,
      this.context.srfappid
    ), this.deACMode))) {
      const { minorSortAppDEFieldId: c, minorSortDir: b } = this.deACMode;
      c && b && (this.sort = "".concat(c.toLowerCase(), ",").concat(b.toLowerCase())), this.deACMode.textAppDEFieldId && (this.textName = this.deACMode.textAppDEFieldId), this.deACMode.valueAppDEFieldId && (this.keyName = this.deACMode.valueAppDEFieldId), this.deACMode.deacmodeDataItems && (this.dataItems = [], this.deACMode.deacmodeDataItems.forEach(
        (S) => {
          S.id !== "value" && S.id !== "text" && this.dataItems.push(S);
        }
      ));
    }
    const s = [
      "PICKEREX_DROPDOWNVIEW",
      "PICKEREX_DROPDOWNVIEW_LINK",
      "PICKUPVIEW"
    ];
    this.model.editorType && s.includes(this.model.editorType) && this.initPickupViewParams(), this.objectIdField = (m = this.model.objectIdField) == null ? void 0 : m.toLowerCase(), this.objectNameField = (u = this.model.objectNameField) == null ? void 0 : u.toLowerCase(), this.objectValueField = (o = this.model.objectValueField) == null ? void 0 : o.toLowerCase();
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
    var s, e, m, u, o;
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
    if (this.userUrl = this.editorParams.URL, this.deptUrl = this.editorParams.DEPTURL, this.userMethod = this.editorParams.USERMETHOD || "post", this.deptMethod = this.editorParams.DEPTMETHOD || "post", this.multiple = this.editorParams.MULTIPLE === "true", this.defaultSelCurUser = this.editorParams.DEFAULTSELCURUSER === "true", this.separator = this.editorParams.SEPARATOR || ",", this.isAddSymbol = this.editorParams.ISADDSYMBOL === "true" && this.multiple === !0, this.isShowTab = this.editorParams.ISSHOWTAB !== "false", (s = this.editorParams) != null && s.VALUETYPE && (this.valueType = (e = this.editorParams) == null ? void 0 : e.VALUETYPE), (m = this.editorParams) != null && m.DEFAULTATNVALUE && (this.defaultAttentionValue = (u = this.editorParams) == null ? void 0 : u.DEFAULTATNVALUE), this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "SELFFILLMAP"))
      try {
        const c = JSON.parse((o = this.editorParams) == null ? void 0 : o.SELFFILLMAP);
        Object.assign(this.selfFillMap, c);
      } catch (c) {
        this.selfFillMap = {};
      }
    if (this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "USERMAP"))
      try {
        const c = JSON.parse(this.editorParams.USERMAP);
        Object.assign(this.userFilterMap, c);
      } catch (c) {
        this.userFilterMap = {
          id: "id",
          name: "name"
        };
      }
    if (this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "DEPTMAP"))
      try {
        const c = JSON.parse(this.editorParams.DEPTMAP);
        Object.assign(this.deptFilterMap, c);
      } catch (c) {
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
  async loadMore(s, e, m = {}) {
    if (e === "user" && this.currentNumber < this.total) {
      const u = await this.getServiceData(e, s, m);
      if (u)
        return this.page += 1, this.currentNumber < 0 && (this.currentNumber += 1), this.currentNumber += this.size, this.total = u.total ? Number(u.total) : Number(u.headers["x-total"]), u.data.forEach((o) => {
          Object.keys(this.userFilterMap).forEach((c) => {
            o[c] = o[this.userFilterMap[c]];
          });
        }), u;
    } else if (e === "department" && this.deptcurrentNumber < this.depttotal) {
      const u = await this.getServiceData(e, s, m);
      if (u)
        return this.deptpage += 1, this.deptcurrentNumber < 0 && (this.deptcurrentNumber += 1), this.deptcurrentNumber += this.size, this.depttotal = u.total ? Number(u.total) : Number(u.headers["x-total"]), u.data.forEach((o) => {
          Object.keys(this.deptFilterMap).forEach((c) => {
            o[c] = o[this.deptFilterMap[c]];
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
  async onActionClick(s, e, m) {
    const u = s.uiactionId;
    let o = {};
    this.parent.form ? o = this.parent.form.ctx.view : this.parent.grid && (o = this.parent.grid.ctx.view), await Qe.execAndResolved(
      u,
      {
        context: this.context,
        params: this.params,
        data: e,
        view: o,
        event: m
      },
      s.appId
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
  fill(s = "", e, m, u) {
    if (L(s)) {
      if (L(e)) {
        const o = s.match(this.contextReg);
        o == null || o.forEach((c) => {
          const b = c.slice(10, c.length - 1);
          s = s.replace("${context.".concat(b, "}"), e[b] || "");
        });
      }
      if (L(m)) {
        const o = s.match(this.paramsReg);
        o == null || o.forEach((c) => {
          const b = c.slice(9, c.length - 1);
          s = s.replace("${params.".concat(b, "}"), m[b] || "");
        });
      }
      if (L(u)) {
        const o = s.match(this.dataReg);
        o == null || o.forEach((c) => {
          const b = c.slice(7, c.length - 1);
          s = s.replace("${data.".concat(b, "}"), u[b] || "");
        });
      }
    }
    return s;
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
  async getServiceData(s, e, m) {
    const { context: u, params: o } = this.handlePublicParams(
      e,
      this.context,
      this.params
    ), c = {};
    this.sort && !Object.is(this.sort, "") && Object.assign(c, { sort: this.sort }), Object.assign(c, { size: this.size }), m && Object.assign(c, m);
    const b = at(o, c);
    let S = "";
    const P = this.fill(this.userUrl, u, o, e).replaceAll(
      "//",
      "/"
    ), A = this.fill(this.deptUrl, u, o, e).replaceAll(
      "//",
      "/"
    );
    this.copyUserUrl = P, this.copyDeptUrl = A;
    let v = "post";
    const f = {};
    if (s === "user" ? (S = P, v = this.userMethod.toLowerCase(), v === "get" ? Object.assign(f, { method: v, params: b }) : Object.assign(f, { method: v, data: b })) : (S = A, v = this.deptMethod.toLowerCase(), v === "get" ? Object.assign(f, { method: v, params: b }) : Object.assign(f, { method: v, data: b })), S)
      return await ibiz.net.request(S, f);
    throw new _(this.model, "请配置数据接口地址");
  }
  /**
   * 打开数据选择视图
   *
   * @param {IData} data 数据对象
   * @param {IData[]} selectedData 选中项集合
   * @returns {*}  {(Promise<IData[] | undefined>)}
   * @memberof PersonelSelectController
   */
  async openPickUpView(s, e) {
    await this.initPickupViewParams();
    const { context: m, params: u } = this.handlePublicParams(
      s,
      this.context,
      this.params
    );
    if (e && (u.selectedData = e), !this.pickupView)
      throw new _(this.model, "请配置数据选择视图");
    const o = await ibiz.commands.execute(
      oe.TAG,
      this.pickupView.id,
      m,
      u,
      { openMode: "POPUPMODAL" }
    );
    if (o && o.ok && o.data)
      return o.data;
    ibiz.log.debug("模态取消或关闭异常", o);
  }
  /**
   * 打开数据链接视图
   */
  async openLinkView(s) {
    const e = this.context.clone();
    s[this.valueItem] && (e.srfkey = s[this.valueItem]);
    const { context: m, params: u } = this.handlePublicParams(
      s,
      e,
      this.params
    ), { linkAppViewId: o } = this.model;
    if (!o)
      throw new _(this.model, "请配置数据链接视图");
    return ibiz.commands.execute(
      oe.TAG,
      o,
      m,
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
  async calcFillDataItems(s) {
    return this.deACMode ? this.dataItems.length === 0 ? [] : await Promise.all(
      this.dataItems.map((m) => {
        const o = s.map((c) => c[m.appDEFieldId]).join(this.separator);
        return m.format || m.convertToCodeItemText && m.codeListId || m.customCode, { id: m.id, value: o };
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
  handleObjectParams(s) {
    const e = {};
    return this.objectIdField && Object.assign(e, {
      [this.objectIdField]: s[this.keyName]
    }), this.objectNameField && Object.assign(e, {
      [this.objectNameField]: s[this.textName]
    }), this.objectValueField && Object.assign(e, {
      [this.objectValueField]: ce(s)
    }), e;
  }
  /**
   * 获取操作用户列表
   *
   * @memberof PersonelSelectController
   */
  async getOperatorUserList() {
    const s = await ibiz.hub.getApp(this.context.srfappid);
    let e = [];
    e = await s.codeList.get(
      "SysOperator",
      this.context,
      this.params
    ), this.operatorMap = new Map(
      e.map((m) => [m.value, m])
    );
  }
}
class ct {
  constructor() {
    p(this, "component", "PersonelSelect");
    p(this, "formEditor", "PersonelSelect");
    p(this, "gridEditor", "PersonelSelect");
  }
  async createController(h, s) {
    const e = new ut(h, s);
    return await e.init(), e;
  }
}
const dt = /* @__PURE__ */ de({
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
    const s = ue("virtual-list"), e = g(36), m = g(), u = g([]), o = g(0), c = g(0), b = g(0), S = g(0), P = () => {
      c.value = Math.floor(S.value / n.itemHeight), b.value = c.value + n.showNum, u.value = n.items.slice(c.value, b.value);
      const f = S.value - S.value % n.itemHeight;
      o.value = f;
    }, A = () => {
      S.value = m.value.scrollTop, P(), v(e.value, S.value);
    }, v = (f, M) => {
      h("scrollEvent", f, M);
    };
    return pe(() => {
      setTimeout(() => {
        scroll();
      }, 1e3);
    }), D(() => n.items, () => {
      e.value = n.itemHeight * n.items.length, P();
    }, {
      immediate: !0,
      deep: !0
    }), {
      ns: s,
      contentHeight: e,
      showList: u,
      contentBox: m,
      top: o,
      onScroll: A
    };
  },
  render() {
    return r("div", {
      ref: "contentBox",
      class: this.ns.b(),
      onScroll: () => this.onScroll()
    }, [r("div", {
      class: this.ns.e("container"),
      style: "height:".concat(this.contentHeight, "px;")
    }, [r("div", {
      class: this.ns.e("content"),
      style: "top:".concat(this.top, "px;")
    }, [this.showList.map((n, h) => r("div", {
      key: h,
      class: this.ns.m("item")
    }, [this.$slots.default ? this.$slots.default({
      ...n,
      // eslint-disable-next-line object-shorthand
      index: h
    }) : n.name]))])])]);
  }
}), R = new et(import.meta.url);
class pt {
  /**
   * 计算选中项绘制个数 多选场景需计算显示人员是否超出
   * @author ljx
   * @date 2024-03-05 02:42:45
   * @param {IData} values 选中项key值集合
   * @returns {number} selRenderNum
   */
  static calcSelItemRenderNum(h, s) {
    let e = 0;
    if (s && (h == null ? void 0 : h.length) > 0) {
      const m = (s == null ? void 0 : s.offsetWidth) || 0, u = window.getComputedStyle(s), o = parseInt(u.marginLeft, 10), c = parseInt(u.marginRight, 10), b = parseInt(u.paddingLeft, 10), S = parseInt(u.paddingRight, 10), P = o + c + b + S, A = 30, v = 28, f = 8, M = (v + f) * h.length;
      m - P - A - M < 0 && (e = Math.floor(
        (m - P - A) / (v + f)
      ), e -= 1);
    }
    return e;
  }
}
function ht(n) {
  return typeof n == "function" || Object.prototype.toString.call(n) === "[object Object]" && !nt(n);
}
const H = /* @__PURE__ */ de({
  name: "PersonelSelect",
  props: Ze(),
  emits: Ke(),
  setup(n, {
    emit: h
  }) {
    const s = ue("picker-dropdown"), e = n.controller, m = g(""), u = g([]), o = g([]), c = g(""), b = g(!1), S = g(!1), P = g(""), A = g([]), v = g("user"), f = g([]), M = g(!1), U = g(!1), W = g(!1), Z = g(""), K = g(), k = g(), G = g();
    let O;
    const V = g();
    let j = 0;
    const he = J(() => !!(n.controlParams && n.controlParams.editmode === "hover")), X = (t) => {
      const a = [], l = [];
      f.value = [], t.forEach((i) => {
        var E, y;
        const d = ce(i);
        (E = e.selfFillMap) != null && E.user_id && ((y = e.selfFillMap) != null && y.user_name) && Object.assign(d, {
          id: i[e.selfFillMap.user_id],
          name: i[e.selfFillMap.user_name]
        }), a.push(i[e.selfFillMap.user_id]), l.push(i[e.selfFillMap.user_name]), f.value.push(d);
      }), c.value = a == null ? void 0 : a.join(e.separator), m.value = l == null ? void 0 : l.toString();
    }, x = () => {
      const t = f.value.map((a) => {
        var i, d;
        const l = {};
        return Object.assign(l, {
          [(i = e.selfFillMap) == null ? void 0 : i.user_id]: a.id,
          [(d = e.selfFillMap) == null ? void 0 : d.user_name]: a.name
        }), e.attentionTypeField && e.defaultAttentionValue && Object.assign(l, {
          [e.attentionTypeField]: e.defaultAttentionValue
        }), l;
      });
      h("change", t), e.parent.form && (e.parent.form.state.modified = !1);
    }, me = (t) => {
      const a = {};
      return v.value === "user" ? Object.assign(a, {
        id: t[e.userFilterMap.id],
        name: t[e.userFilterMap.name]
      }) : Object.assign(a, {
        id: t[e.deptFilterMap.id],
        name: t[e.deptFilterMap.name]
      }), a;
    }, fe = () => {
      var t, a;
      if (e.defaultSelCurUser) {
        const l = {};
        Object.assign(l, {
          id: (t = e.context) == null ? void 0 : t.srfuserid,
          name: (a = e.context) == null ? void 0 : a.srfusername
        }), e.multiple ? f.value.push(l) : f.value.length === 0 && (f.value = [l]), x();
      }
    }, Y = () => {
      O != null && O.value && O.value.hide(), k.value && k.value.hide();
    }, ve = (t) => {
      (t.key === "Escape" || t.keyCode === 27) && (t.stopPropagation(), Y());
    }, $ = () => {
      if (!(e.defaultAttentionValue && e.valueType === "OBJECTS"))
        return;
      const t = c.value.split(e.separator);
      j = pt.calcSelItemRenderNum(t, G.value), c.value = "", X(f.value);
    };
    D(() => n.value, (t) => {
      if (t || t === null || t === void 0) {
        if (e.model.valueType === "OBJECT")
          m.value = t ? t[e.objectNameField] : null;
        else if (e.valueType === "OBJECTS") {
          const a = ot(t) ? t : [];
          X(a), $();
          return;
        } else
          m.value = t;
        if (t == null) {
          m.value = "", f.value = [], h("change", null, e.valueItem), h("blur");
          return;
        } else if (e.multiple && f.value.length === 0 && e.valueItem && n.data && n.data[e.valueItem]) {
          let a = n.data[e.valueItem].split(e.separator), l = m.value.split(e.separator);
          a.length > 1 && e.isAddSymbol && (a = a.map((i) => i.slice(1, -1))), l.length > 1 && e.isAddSymbol && (l = l.map((i) => i.slice(1, -1))), a.forEach((i, d) => {
            f.value.push({
              id: i,
              name: l[d]
            });
          });
        }
      }
    }, {
      immediate: !0
    });
    const ge = J(() => n.data && n.data[e.valueItem] || void 0);
    D(ge, (t, a) => {
      t !== a && (c.value = t, t == null && (f.value = [], h("change", null)));
    }, {
      immediate: !0,
      deep: !0
    });
    const q = (t) => {
      t ? S.value = t : setTimeout(() => {
        S.value = t;
      }, 100);
    }, be = (t, a) => {
      N(a);
      const l = f.value.findIndex((i) => i.id === t.id);
      if (l > -1 && f.value.splice(l, 1), e.valueItem) {
        let i = f.value.map((d) => d.id);
        i.length > 1 && e.isAddSymbol && (i = i.map((d) => "'".concat(d, "'"))), h("change", i.join(e.separator), e.valueItem);
      }
      if (e.valueType === "OBJECTS")
        x();
      else {
        let i = f.value.map((d) => d.name);
        i.length > 1 && e.isAddSymbol && (i = i.map((d) => "'".concat(d, "'"))), h("change", i.join(e.separator));
      }
    }, Se = async (t) => {
      P.value && (v.value === "user" ? u.value.unshift(t) : o.value.unshift(t));
      const a = {};
      if (Object.assign(a, t), v.value === "user") {
        Object.assign(a, {
          [e.userFilterMap.id]: a[e.userFilterMap.id] ? a[e.userFilterMap.id] : a.srfkey,
          [e.userFilterMap.name]: a[e.userFilterMap.name] ? a[e.userFilterMap.name] : a.srfmajortext
        });
        const l = f.value.findIndex((i) => i.id === a[e.userFilterMap.id]);
        l < 0 ? f.value.push({
          id: a[e.userFilterMap.id],
          name: a[e.userFilterMap.name]
        }) : f.value.splice(l, 1);
      } else {
        Object.assign(a, {
          [e.deptFilterMap.id]: a[e.deptFilterMap.id] ? a[e.deptFilterMap.id] : a.srfkey,
          [e.deptFilterMap.name]: a[e.deptFilterMap.name] ? a[e.deptFilterMap.name] : a.srfmajortext
        });
        const l = f.value.findIndex((i) => i.id === a[e.deptFilterMap.id]);
        l < 0 ? f.value.push({
          id: a[e.deptFilterMap.id],
          name: a[e.deptFilterMap.name]
        }) : f.value.splice(l, 1);
      }
      if (e.multiple) {
        if (e.valueItem) {
          let l = f.value.map((i) => i.id);
          l.length > 1 && e.isAddSymbol && (l = l.map((i) => "'".concat(i, "'"))), h("change", l.join(e.separator), e.valueItem);
        }
        if (e.valueType === "OBJECTS")
          x();
        else {
          let l = f.value.map((i) => i.name);
          l.length > 1 && e.isAddSymbol && (l = l.map((i) => "'".concat(i, "'"))), h("change", l.join(e.separator));
        }
      } else {
        const l = await e.calcFillDataItems([t]);
        l.length && l.forEach((i) => {
          h("change", i.value, i.id);
        }), e.valueItem && (v.value === "user" ? h("change", a[e.userFilterMap.id], e.valueItem) : h("change", a[e.deptFilterMap.id], e.valueItem)), e.model.valueType === "OBJECT" ? h("change", e.handleObjectParams(a)) : e.valueType === "OBJECTS" ? (f.value = [me(a)], x()) : v.value === "user" ? h("change", t[e.userFilterMap.name]) : h("change", t[e.deptFilterMap.name]), W.value = !1;
      }
      e.valueType !== "OBJECTS" && h("blur", t), q(!1);
    }, Ee = (t, a) => {
      t.forEach((l) => {
        const i = u.value.findIndex((d) => d[a] === l[a]);
        i > -1 ? u.value.splice(i, 1, l) : u.value.push(l);
      });
    }, F = async (t = !1) => {
      if (P.value)
        return;
      M.value = !0;
      const a = {};
      v.value === "department" ? a.page = e.deptpage : a.page = e.page;
      try {
        const l = await e.loadMore(n.data, v.value, a);
        l && (v.value === "user" ? u.value.length === 0 ? u.value = l.data : Ee(l.data, e.userFilterMap.id) : o.value.length === 0 ? o.value = l.data : o.value.push(...l.data));
      } catch (l) {
        M.value = !1;
      }
      M.value = !1;
    }, Q = (t) => {
      const {
        dataItems: a
      } = e;
      a != null && a.length && a.forEach((l) => {
        h("change", null, l.id);
      }), e.valueItem && h("change", null, e.valueItem), e.valueType === "OBJECTS" ? h("change", []) : (h("change", null), h("blur", t)), t.stopPropagation(), t.preventDefault();
    }, I = J(() => Ge(m.value));
    D(I, (t, a) => {
      t !== a && e.valueType !== "OBJECTS" && h("infoTextChange", t);
    }, {
      immediate: !0
    });
    const ee = async (t) => {
      M.value = !0;
      try {
        const a = {};
        Object.assign(a, {
          query: t,
          size: 1e3
        });
        const l = await e.getServiceData(v.value, n.data, a);
        l && (v.value === "user" ? l.data.forEach((i) => {
          Object.keys(e.userFilterMap).forEach((d) => {
            i[d] = i[e.userFilterMap[d]];
          });
        }) : l.data.forEach((i) => {
          Object.keys(e.deptFilterMap).forEach((d) => {
            i[d] = i[e.deptFilterMap[d]];
          });
        }), A.value = l.data, M.value = !1);
      } catch (a) {
        M.value = !1;
      }
    }, te = (t) => {
      if (v.value !== t) {
        if (v.value = t, P.value) {
          ee(P.value);
          return;
        }
        v.value === "user" && u.value.length === 0 && (e.resetUserState(), F()), v.value === "department" && o.value.length === 0 && (e.resetDeptState(), F());
      }
    }, ye = () => {
      const t = document.documentElement;
      return t ? getComputedStyle(t).getPropertyValue("--ibiz-color-primary") : null;
    }, Pe = (t) => /[\u4E00-\u9FA5]/.test(t), Me = (t) => /[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(t), z = (t) => {
      if (!t)
        return "";
      let a = 0;
      for (let C = 0; C < t.length; C++)
        if (Pe(t))
          a = t.charCodeAt(C) + ((a << 5) - a), a = a & a;
        else {
          const Je = t.charCodeAt(C);
          a += Je.toString(16);
        }
      const l = String(a).substring(0, 6), i = parseInt(l.substring(0, 2), 16), d = parseInt(l.substring(2, 4), 16), E = parseInt(l.substring(4, 6), 16), y = "#".concat(i.toString(16).padStart(2, "0")).concat(d.toString(16).padStart(2, "0")).concat(E.toString(16).padStart(2, "0"));
      return y === "#FFFFFF" && ye() || y;
    }, Ae = (t) => {
      clearTimeout(V.value), V.value = setTimeout(() => {
        !t && t !== 0 ? F() : ee(t), clearTimeout(V.value);
      }, 300);
    }, Ie = () => r(w("el-input"), {
      class: s.be("select-modal", "search-input"),
      ref: K,
      modelValue: P.value,
      "onUpdate:modelValue": (t) => P.value = t,
      placeholder: "搜索",
      onInput: (t) => Ae(t),
      onKeydown: ve
    }, {
      suffix: () => r("img", {
        src: "".concat(R.dir("assets/images/svg/search.svg")),
        alt: ""
      }, null)
    }), Fe = () => r("div", {
      class: s.be("select-modal", "select-state")
    }, [r("div", {
      class: [s.bem("select-modal", "select-state", "select-slider"), s.is("left", v.value === "user"), s.is("right", v.value !== "user")]
    }, null), r("div", {
      class: s.bem("select-modal", "select-state", "select-personel"),
      onClick: () => te("user")
    }, [T("人员")]), r("div", {
      class: s.bem("select-modal", "select-state", "select-department"),
      onClick: () => te("department")
    }, [T("部门")])]), Ce = (t) => {
      t.forEach((a) => {
        a.capLanguageRes && a.capLanguageRes.lanResTag && (a.caption = ibiz.i18n.t(a.capLanguageRes.lanResTag, a.caption)), a.tooltipLanguageRes && a.tooltipLanguageRes.lanResTag && (a.tooltip = ibiz.i18n.t(a.tooltipLanguageRes.lanResTag, a.tooltip));
      });
    }, we = async (t, a) => {
      await e.onActionClick(t, [n.data], a);
    }, Te = (t) => r("div", {
      class: s.bem("select-modal", "actions", "item"),
      title: t.tooltip || t.caption,
      onClick: (a) => we(t, a)
    }, [t.showIcon && t.sysImage && r(w("iBizIcon"), {
      icon: t.sysImage
    }, null)]), Oe = () => {
      var a;
      const t = ((a = e.model.uiactionGroup) == null ? void 0 : a.uiactionGroupDetails) || [];
      return Ce(t), r("div", {
        class: s.be("select-modal", "actions")
      }, [t.map((l) => Te(l))]);
    }, De = () => {
      var a;
      const t = ((a = e.model.uiactionGroup) == null ? void 0 : a.uiactionGroupDetails) || [];
      return !e.isShowTab && t.length === 0 ? null : r("div", {
        class: [s.be("select-modal", "select"), s.is("no-solider-tab", !e.isShowTab && t.length > 0)]
      }, [e.isShowTab ? Fe() : null, Oe()]);
    }, Ue = (t) => {
      if (e.multiple) {
        if (c.value) {
          let a = c.value.split(e.separator);
          return a.length > 1 && e.isAddSymbol && (a = a.map((i) => i.slice(1, -1))), a.findIndex((i) => i === t) > -1 ? r("div", {
            class: s.bem("select-modal", "personel-list", "icon")
          }, [r("i", {
            class: "fa fa-check",
            "aria-hidden": "true"
          }, null)]) : null;
        }
      } else
        return c.value === t ? r("div", {
          class: s.bem("select-modal", "personel-list", "icon")
        }, [r("i", {
          class: "fa fa-check",
          "aria-hidden": "true"
        }, null)]) : null;
    }, je = (t) => {
      if (t && t.toString().length < 2)
        return t;
      if (t && t.toString().length >= 2) {
        if (Me(t)) {
          const d = t.split("").find((y) => /[a-zA-Z]/.test(y)) || "", E = t.split("").find((y) => /[\u4E00-\u9FA5]/.test(y)) || "";
          return "".concat(d).concat(E).toLowerCase();
        }
        return /[a-zA-Z]/.test(t) ? t.split("").filter((d) => /[a-zA-Z]/.test(d)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(t) ? t.split("").filter((d) => /[\u4E00-\u9FA5]/.test(d)).slice(-2).join("") : t.replaceAll(" ", "").substring(0, 2);
      }
    }, xe = (t) => {
      if (!t)
        return null;
      const a = JSON.parse(t);
      if (a.length === 0)
        return null;
      const {
        downloadUrl: l
      } = ibiz.util.file.calcFileUpDownUrl(e.context, e.params, n.data, e.editorParams), i = l.replace("%fileId%", a[0].id);
      return r("img", {
        class: s.bem("select-modal", "personel-list", "avatar"),
        src: i,
        alt: ""
      }, null);
    }, B = (t, a) => e.operatorMap && e.operatorMap.get(t) && e.operatorMap.get(t).data.iconurl ? xe(e.operatorMap.get(t).data.iconurl) : je(a), ae = (t) => {
      const a = v.value === "user" ? t[e.userFilterMap.name] || t.name : t[e.deptFilterMap.name] || t.name, l = v.value === "user" ? t[e.userFilterMap.id] : t[e.deptFilterMap.id];
      return r("div", {
        class: [s.bem("select-modal", "personel-list", "item"), s.is("selected", c.value === l)],
        onClick: () => Se(t)
      }, [r("div", {
        class: s.bem("select-modal", "personel-list", "text")
      }, [r("div", {
        class: s.bem("select-modal", "personel-list", "text-img"),
        style: "background-color:".concat(z(a))
      }, [B(l, a)]), r("div", {
        class: s.bem("select-modal", "personel-list", "text-label")
      }, [a]), l === e.context.srfuserid ? r("div", {
        class: s.bem("select-modal", "personel-list", "myself")
      }, [T("我自己")]) : null]), Ue(l)]);
    }, Ne = (t, a) => {
      const {
        context: l,
        params: i
      } = e;
      return r(w("iBizControlShell"), {
        class: s.b("panel-item"),
        data: t,
        modelData: a,
        context: l,
        params: i
      }, null);
    }, Le = (t, a) => {
      const l = g();
      return r(w("el-popover"), {
        ref: l,
        target: "hover",
        placement: "right",
        offset: 24,
        width: "auto",
        onShow: (i) => {
          O = l;
        }
      }, {
        reference: () => ae(t),
        default: () => Ne(t, a)
      });
    }, Re = (t) => P.value ? A.value : t, N = (t) => {
      t.preventDefault(), t.stopPropagation();
    }, ke = (t, a) => {
      U.value && (v.value === "user" ? t - a < 305 && (M.value || F()) : t - a < 250 && (M.value || F()));
    }, se = (t) => {
      var d, E;
      const a = ((d = e.model.uiactionGroup) == null ? void 0 : d.uiactionGroupDetails) || [], l = Re(t), i = (E = e.deACMode) == null ? void 0 : E.itemLayoutPanel;
      return r(dt, {
        items: l,
        itemHeight: 36,
        class: [s.be("select-modal", "personel-list"), s.be("select-modal", "personel-list-".concat(v.value)), s.is("no-solider-tab", !e.isShowTab && a.length > 0)],
        onScrollEvent: (y, C) => ke(y, C)
      }, {
        default: (y) => i ? Le(y, i) : ae(y)
      });
    }, le = (t) => {
      b.value = t;
    }, Ve = () => r("div", {
      class: s.be("select-modal", "deptpersonel")
    }, [r("div", {
      class: s.bem("select-modal", "deptpersonel", "dept")
    }, [r("div", {
      class: "collpase-icon"
    }, [b.value ? r("i", {
      class: "fa fa-angle-right",
      "aria-hidden": "true",
      onClick: () => le(!1)
    }, null) : r("i", {
      class: "fa fa-angle-down",
      "aria-hidden": "true",
      onClick: () => le(!0)
    }, null)]), r("img", {
      src: "".concat(R.dir("assets/images/svg/org.svg"))
    }, null), r("span", null, ["".concat(e.context.srfusername, "的团队")]), r("span", null, [T("·")]), r("span", null, [e.depttotal])]), b.value ? null : r("div", {
      class: s.bem("select-modal", "deptpersonel", "dept-person")
    }, [se(o.value)])]), $e = () => lt(r("div", {
      class: s.b("select-modal"),
      onPointerdown: N,
      onPointerup: N,
      onClick: N
    }, [Ie(), De(), v.value === "user" ? se(u.value) : Ve()]), [[it("loading"), M.value]]), ie = () => r("div", {
      class: s.b("no-select-value")
    }, [r("img", {
      src: "".concat(R.dir("assets/images/svg/member.svg")),
      alt: ""
    }, null), r("span", null, [T("未设置")])]), re = () => {
      var t;
      if (e.multiple) {
        let a = !1;
        const l = [];
        if (c.value) {
          let i = c.value.split(e.separator), d = I.value.split(e.separator);
          i.length > 1 && e.isAddSymbol && (i = i.map((E) => E.slice(1, -1))), d.length > 1 && e.isAddSymbol && (d = d.map((E) => E.slice(1, -1))), i.forEach((E, y) => {
            l.push({
              id: E,
              name: d[y]
            });
          });
        } else
          I.value === "当前用户" && n.disabled && l.push({
            id: I.value,
            name: I.value
          });
        return e.defaultAttentionValue && e.valueType === "OBJECTS" && j > 0 && (a = j < ((t = f.value) == null ? void 0 : t.length), l == null || l.splice(j, l == null ? void 0 : l.length)), r("div", {
          class: [s.b("select-value-multiple"), a ? s.be("select-value-multiple", "hidden") : ""]
        }, [l == null ? void 0 : l.map((i) => {
          let d;
          return r("div", {
            class: s.be("select-value-multiple", "item")
          }, [r("div", {
            class: [s.be("select-value", "textimg"), s.bem("select-value-multiple", "item", "textimg")],
            style: "background-color:".concat(z(i.name))
          }, [r(w("el-tooltip"), {
            class: "box-item",
            effect: "dark",
            content: i.name,
            placement: "top",
            offset: 12
          }, ht(d = B(i.id, i.name)) ? d : {
            default: () => [d]
          }), n.readonly || n.disabled ? null : r("div", {
            class: [s.bem("select-value-multiple", "item", "close")],
            onClick: (E) => be(i, E)
          }, [r("i", {
            class: "fa fa-close",
            "aria-hidden": "true"
          }, null)])])]);
        }), a ? r("span", {
          class: s.bem("select-value-multiple", "hidden", "ellipsis")
        }, [T("...")]) : null, r("div", {
          class: s.b("no-select-value")
        }, [r("img", {
          src: "".concat(R.dir("assets/images/svg/member.svg")),
          alt: ""
        }, null)])]);
      }
      return r("div", {
        class: s.b("select-value")
      }, [r("div", {
        class: s.be("select-value", "textimg"),
        style: "background-color:".concat(z(I.value))
      }, [B(c.value, I.value)]), r("div", {
        class: s.be("select-value", "text")
      }, [r("div", {
        class: s.bem("select-value", "text", "label")
      }, [I.value])]), n.readonly || n.disabled ? null : r("i", {
        class: ["fa fa-times-circle", s.be("select-value", "close")],
        "aria-hidden": "true",
        onClick: (a) => Q(a)
      }, null)]);
    }, ze = async () => {
      var d, E;
      U.value = !0;
      const {
        context: t,
        params: a
      } = e.handlePublicParams(n.data, e.context, e.params), l = e.fill(e.userUrl, t, a, n.data).replaceAll("//", "/"), i = e.fill(e.deptUrl, t, a, n.data).replaceAll("//", "/");
      (l !== e.copyUserUrl || i !== e.copyDeptUrl || n.data && n.data.srfkey !== Z.value) && (Z.value = ((d = n.data) == null ? void 0 : d.srfkey) || "", u.value = [], o.value = [], e.resetState(), F(!0)), await rt(), (E = K.value) == null || E.focus();
    }, Be = () => I.value ? re() : ie(), _e = () => {
      U.value = !1;
    };
    D(() => n.readonly, (t) => {
      t && Y();
    }, {
      deep: !0
    });
    const ne = () => {
      $();
    };
    return pe(() => {
      fe(), window == null || window.addEventListener("resize", ne), $();
    }), st(() => {
      e.resetState(), window == null || window.removeEventListener("resize", ne);
    }), {
      ns: s,
      c: e,
      refValue: c,
      curValue: m,
      valueText: I,
      loading: M,
      items: u,
      personelSelRef: G,
      onClear: Q,
      load: F,
      isEditable: S,
      popoverRef: k,
      setEditable: q,
      renderDropModal: $e,
      renderNoSelectValue: ie,
      renderSelectInput: re,
      renderReadState: Be,
      onPopShow: ze,
      onPageHide: _e,
      showFormDefaultContent: he,
      modelVisible: W
    };
  },
  render() {
    const n = r(w("el-popover"), {
      ref: "popoverRef",
      visible: this.modelVisible,
      "onUpdate:visible": (h) => this.modelVisible = h,
      trigger: "click",
      popperClass: this.ns.b("person-select"),
      width: 320,
      teleported: !0,
      onShow: () => this.onPopShow(),
      onHide: () => this.onPageHide()
    }, {
      reference: () => this.renderReadState(),
      default: () => this.renderDropModal()
    });
    return r("div", {
      ref: "personelSelRef",
      class: [this.ns.b(), this.ns.b("person-value"), this.disabled ? this.ns.m("disabled") : "", this.readonly ? this.ns.m("readonly") : "", this.ns.is("editable", this.isEditable), this.ns.is("show-default", this.showFormDefaultContent)]
    }, [this.readonly || this.disabled ? this.renderReadState() : n]);
  }
}), mt = Xe(
  H,
  function(n) {
    n.component(H.name, H), tt(
      "EDITOR_CUSTOMSTYLE_PERSON_SELECT",
      () => new ct()
    );
  }
), Mt = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(n) {
    n.use(mt);
  }
};
export {
  mt as IBizPersonelSelect,
  Mt as default
};
