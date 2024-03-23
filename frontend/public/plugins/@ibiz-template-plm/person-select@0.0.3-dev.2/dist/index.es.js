import './style.css';
var _e = Object.defineProperty;
var Je = (o, h, a) => h in o ? _e(o, h, { enumerable: !0, configurable: !0, writable: !0, value: a }) : o[h] = a;
var p = (o, h, a) => (Je(o, typeof h != "symbol" ? h + "" : h, a), a);
import { useNamespace as ue, getDataPickerProps as He, getEditorEmits as We, renderString as Ze, withInstall as Ke } from "@ibiz-template/vue3-util";
import { EditorController as Ge, getDeACMode as Xe, UIActionUtil as Ye, OpenAppViewCommand as oe, PluginStaticResource as qe, registerEditorProvider as Qe } from "@ibiz-template/runtime";
import { RuntimeModelError as _ } from "@ibiz-template/core";
import { mergeDeepLeft as et, clone as ce } from "ramda";
import { notNilEmpty as L } from "qx-util";
import { defineComponent as de, ref as g, onMounted as pe, watch as D, createVNode as r, computed as J, onBeforeUnmount as tt, resolveComponent as w, withDirectives as st, resolveDirective as at, createTextVNode as T, nextTick as lt, isVNode as it } from "vue";
import { isArray as rt } from "lodash-es";
class nt extends Ge {
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
    var e, m, u, n;
    if (super.onInit(), this.initDefaultAttribute(), this.initParams(), this.valueItem = ((e = this.model.valueItemName) == null ? void 0 : e.toLowerCase()) || "", this.model.appDataEntityId && (this.model.appDEDataSetId && (this.interfaceName = this.model.appDEDataSetId), this.model.appDEACModeId && (this.deACMode = await Xe(
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
    const a = [
      "PICKEREX_DROPDOWNVIEW",
      "PICKEREX_DROPDOWNVIEW_LINK",
      "PICKUPVIEW"
    ];
    this.model.editorType && a.includes(this.model.editorType) && this.initPickupViewParams(), this.objectIdField = (m = this.model.objectIdField) == null ? void 0 : m.toLowerCase(), this.objectNameField = (u = this.model.objectNameField) == null ? void 0 : u.toLowerCase(), this.objectValueField = (n = this.model.objectValueField) == null ? void 0 : n.toLowerCase();
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
    var a, e, m, u, n;
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
    if (this.userUrl = this.editorParams.URL, this.deptUrl = this.editorParams.DEPTURL, this.userMethod = this.editorParams.USERMETHOD || "post", this.deptMethod = this.editorParams.DEPTMETHOD || "post", this.multiple = this.editorParams.MULTIPLE === "true", this.defaultSelCurUser = this.editorParams.DEFAULTSELCURUSER === "true", this.separator = this.editorParams.SEPARATOR || ",", this.isAddSymbol = this.editorParams.ISADDSYMBOL === "true" && this.multiple === !0, this.isShowTab = this.editorParams.ISSHOWTAB !== "false", (a = this.editorParams) != null && a.VALUETYPE && (this.valueType = (e = this.editorParams) == null ? void 0 : e.VALUETYPE), (m = this.editorParams) != null && m.DEFAULTATNVALUE && (this.defaultAttentionValue = (u = this.editorParams) == null ? void 0 : u.DEFAULTATNVALUE), this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "SELFFILLMAP"))
      try {
        const c = JSON.parse((n = this.editorParams) == null ? void 0 : n.SELFFILLMAP);
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
  async loadMore(a, e, m = {}) {
    if (e === "user" && this.currentNumber < this.total) {
      const u = await this.getServiceData(e, a, m);
      if (u)
        return this.page += 1, this.currentNumber < 0 && (this.currentNumber += 1), this.currentNumber += this.size, this.total = u.total ? Number(u.total) : Number(u.headers["x-total"]), u.data.forEach((n) => {
          Object.keys(this.userFilterMap).forEach((c) => {
            n[c] = n[this.userFilterMap[c]];
          });
        }), u;
    } else if (e === "department" && this.deptcurrentNumber < this.depttotal) {
      const u = await this.getServiceData(e, a, m);
      if (u)
        return this.deptpage += 1, this.deptcurrentNumber < 0 && (this.deptcurrentNumber += 1), this.deptcurrentNumber += this.size, this.depttotal = u.total ? Number(u.total) : Number(u.headers["x-total"]), u.data.forEach((n) => {
          Object.keys(this.deptFilterMap).forEach((c) => {
            n[c] = n[this.deptFilterMap[c]];
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
  async onActionClick(a, e, m) {
    const u = a.uiactionId;
    let n = {};
    this.parent.form ? n = this.parent.form.ctx.view : this.parent.grid && (n = this.parent.grid.ctx.view), await Ye.execAndResolved(
      u,
      {
        context: this.context,
        params: this.params,
        data: e,
        view: n,
        event: m
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
  fill(a = "", e, m, u) {
    if (L(a)) {
      if (L(e)) {
        const n = a.match(this.contextReg);
        n == null || n.forEach((c) => {
          const b = c.slice(10, c.length - 1);
          a = a.replace("${context.".concat(b, "}"), e[b] || "");
        });
      }
      if (L(m)) {
        const n = a.match(this.paramsReg);
        n == null || n.forEach((c) => {
          const b = c.slice(9, c.length - 1);
          a = a.replace("${params.".concat(b, "}"), m[b] || "");
        });
      }
      if (L(u)) {
        const n = a.match(this.dataReg);
        n == null || n.forEach((c) => {
          const b = c.slice(7, c.length - 1);
          a = a.replace("${data.".concat(b, "}"), u[b] || "");
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
  async getServiceData(a, e, m) {
    const { context: u, params: n } = this.handlePublicParams(
      e,
      this.context,
      this.params
    ), c = {};
    this.sort && !Object.is(this.sort, "") && Object.assign(c, { sort: this.sort }), Object.assign(c, { size: this.size }), m && Object.assign(c, m);
    const b = et(n, c);
    let S = "";
    const P = this.fill(this.userUrl, u, n, e).replaceAll(
      "//",
      "/"
    ), A = this.fill(this.deptUrl, u, n, e).replaceAll(
      "//",
      "/"
    );
    this.copyUserUrl = P, this.copyDeptUrl = A;
    let v = "post";
    const f = {};
    if (a === "user" ? (S = P, v = this.userMethod.toLowerCase(), v === "get" ? Object.assign(f, { method: v, params: b }) : Object.assign(f, { method: v, data: b })) : (S = A, v = this.deptMethod.toLowerCase(), v === "get" ? Object.assign(f, { method: v, params: b }) : Object.assign(f, { method: v, data: b })), S)
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
  async openPickUpView(a, e) {
    await this.initPickupViewParams();
    const { context: m, params: u } = this.handlePublicParams(
      a,
      this.context,
      this.params
    );
    if (e && (u.selectedData = e), !this.pickupView)
      throw new _(this.model, "请配置数据选择视图");
    const n = await ibiz.commands.execute(
      oe.TAG,
      this.pickupView.id,
      m,
      u,
      { openMode: "POPUPMODAL" }
    );
    if (n && n.ok && n.data)
      return n.data;
    ibiz.log.debug("模态取消或关闭异常", n);
  }
  /**
   * 打开数据链接视图
   */
  async openLinkView(a) {
    const e = this.context.clone();
    a[this.valueItem] && (e.srfkey = a[this.valueItem]);
    const { context: m, params: u } = this.handlePublicParams(
      a,
      e,
      this.params
    ), { linkAppViewId: n } = this.model;
    if (!n)
      throw new _(this.model, "请配置数据链接视图");
    return ibiz.commands.execute(
      oe.TAG,
      n,
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
  async calcFillDataItems(a) {
    return this.deACMode ? this.dataItems.length === 0 ? [] : await Promise.all(
      this.dataItems.map((m) => {
        const n = a.map((c) => c[m.appDEFieldId]).join(this.separator);
        return m.format || m.convertToCodeItemText && m.codeListId || m.customCode, { id: m.id, value: n };
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
      [this.objectValueField]: ce(a)
    }), e;
  }
}
class ot {
  constructor() {
    p(this, "component", "PersonelSelect");
    p(this, "formEditor", "PersonelSelect");
    p(this, "gridEditor", "PersonelSelect");
  }
  async createController(h, a) {
    const e = new nt(h, a);
    return await e.init(), e;
  }
}
const ut = /* @__PURE__ */ de({
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
  setup(o, {
    emit: h
  }) {
    const a = ue("virtual-list"), e = g(36), m = g(), u = g([]), n = g(0), c = g(0), b = g(0), S = g(0), P = () => {
      c.value = Math.floor(S.value / o.itemHeight), b.value = c.value + o.showNum, u.value = o.items.slice(c.value, b.value);
      const f = S.value - S.value % o.itemHeight;
      n.value = f;
    }, A = () => {
      S.value = m.value.scrollTop, P(), v(e.value, S.value);
    }, v = (f, I) => {
      h("scrollEvent", f, I);
    };
    return pe(() => {
      setTimeout(() => {
        scroll();
      }, 1e3);
    }), D(() => o.items, () => {
      e.value = o.itemHeight * o.items.length, P();
    }, {
      immediate: !0,
      deep: !0
    }), {
      ns: a,
      contentHeight: e,
      showList: u,
      contentBox: m,
      top: n,
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
    }, [this.showList.map((o, h) => r("div", {
      key: h,
      class: this.ns.m("item")
    }, [this.$slots.default ? this.$slots.default({
      ...o,
      // eslint-disable-next-line object-shorthand
      index: h
    }) : o.name]))])])]);
  }
}), R = new qe(import.meta.url);
class ct {
  /**
   * 计算选中项绘制个数 多选场景需计算显示人员是否超出
   * @author ljx
   * @date 2024-03-05 02:42:45
   * @param {IData} values 选中项key值集合
   * @returns {number} selRenderNum
   */
  static calcSelItemRenderNum(h, a) {
    let e = 0;
    if (a && (h == null ? void 0 : h.length) > 0) {
      const m = (a == null ? void 0 : a.offsetWidth) || 0, u = window.getComputedStyle(a), n = parseInt(u.marginLeft, 10), c = parseInt(u.marginRight, 10), b = parseInt(u.paddingLeft, 10), S = parseInt(u.paddingRight, 10), P = n + c + b + S, A = 30, v = 28, f = 8, I = (v + f) * h.length;
      m - P - A - I < 0 && (e = Math.floor(
        (m - P - A) / (v + f)
      ), e -= 1);
    }
    return e;
  }
}
function dt(o) {
  return typeof o == "function" || Object.prototype.toString.call(o) === "[object Object]" && !it(o);
}
const H = /* @__PURE__ */ de({
  name: "PersonelSelect",
  props: He(),
  emits: We(),
  setup(o, {
    emit: h
  }) {
    const a = ue("picker-dropdown"), e = o.controller, m = g(""), u = g([]), n = g([]), c = g(""), b = g(!1), S = g(!1), P = g(""), A = g([]), v = g("user"), f = g([]), I = g(!1), j = g(!1), W = g(!1), Z = g(""), K = g(), k = g(), G = g();
    let O;
    const V = g();
    let x = 0;
    const he = J(() => !!(o.controlParams && o.controlParams.editmode === "hover")), X = (t) => {
      const s = [], l = [];
      f.value = [], t.forEach((i) => {
        var E, y;
        const d = ce(i);
        (E = e.selfFillMap) != null && E.user_id && ((y = e.selfFillMap) != null && y.user_name) && Object.assign(d, {
          id: i[e.selfFillMap.user_id],
          name: i[e.selfFillMap.user_name]
        }), s.push(i[e.selfFillMap.user_id]), l.push(i[e.selfFillMap.user_name]), f.value.push(d);
      }), c.value = s == null ? void 0 : s.join(e.separator), m.value = l == null ? void 0 : l.toString();
    }, U = () => {
      const t = f.value.map((s) => {
        var i, d;
        const l = {};
        return Object.assign(l, {
          [(i = e.selfFillMap) == null ? void 0 : i.user_id]: s.id,
          [(d = e.selfFillMap) == null ? void 0 : d.user_name]: s.name
        }), e.attentionTypeField && e.defaultAttentionValue && Object.assign(l, {
          [e.attentionTypeField]: e.defaultAttentionValue
        }), l;
      });
      h("change", t), e.parent.form && (e.parent.form.state.modified = !1);
    }, me = (t) => {
      const s = {};
      return v.value === "user" ? Object.assign(s, {
        id: t[e.userFilterMap.id],
        name: t[e.userFilterMap.name]
      }) : Object.assign(s, {
        id: t[e.deptFilterMap.id],
        name: t[e.deptFilterMap.name]
      }), s;
    }, fe = () => {
      var t, s;
      if (e.defaultSelCurUser) {
        const l = {};
        Object.assign(l, {
          id: (t = e.context) == null ? void 0 : t.srfuserid,
          name: (s = e.context) == null ? void 0 : s.srfusername
        }), e.multiple ? f.value.push(l) : f.value.length === 0 && (f.value = [l]), U();
      }
    }, Y = () => {
      O != null && O.value && O.value.hide(), k.value && k.value.hide();
    }, ve = (t) => {
      (t.key === "Escape" || t.keyCode === 27) && (t.stopPropagation(), Y());
    }, $ = () => {
      if (!(e.defaultAttentionValue && e.valueType === "OBJECTS"))
        return;
      const t = c.value.split(e.separator);
      x = ct.calcSelItemRenderNum(t, G.value), c.value = "", X(f.value);
    };
    D(() => o.value, (t) => {
      if (t || t === null || t === void 0) {
        if (e.model.valueType === "OBJECT")
          m.value = t ? t[e.objectNameField] : null;
        else if (e.valueType === "OBJECTS") {
          const s = rt(t) ? t : [];
          X(s), $();
          return;
        } else
          m.value = t;
        if (t == null) {
          m.value = "", f.value = [], h("change", null, e.valueItem), h("blur");
          return;
        } else if (e.multiple && f.value.length === 0 && e.valueItem && o.data && o.data[e.valueItem]) {
          let s = o.data[e.valueItem].split(e.separator), l = m.value.split(e.separator);
          s.length > 1 && e.isAddSymbol && (s = s.map((i) => i.slice(1, -1))), l.length > 1 && e.isAddSymbol && (l = l.map((i) => i.slice(1, -1))), s.forEach((i, d) => {
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
    const ge = J(() => o.data && o.data[e.valueItem] || void 0);
    D(ge, (t, s) => {
      t !== s && (c.value = t, t == null && (f.value = [], h("change", null)));
    }, {
      immediate: !0,
      deep: !0
    });
    const q = (t) => {
      t ? S.value = t : setTimeout(() => {
        S.value = t;
      }, 100);
    }, be = (t, s) => {
      N(s);
      const l = f.value.findIndex((i) => i.id === t.id);
      if (l > -1 && f.value.splice(l, 1), e.valueItem) {
        let i = f.value.map((d) => d.id);
        i.length > 1 && e.isAddSymbol && (i = i.map((d) => "'".concat(d, "'"))), h("change", i.join(e.separator), e.valueItem);
      }
      if (e.valueType === "OBJECTS")
        U();
      else {
        let i = f.value.map((d) => d.name);
        i.length > 1 && e.isAddSymbol && (i = i.map((d) => "'".concat(d, "'"))), h("change", i.join(e.separator));
      }
    }, Se = async (t) => {
      P.value && (v.value === "user" ? u.value.unshift(t) : n.value.unshift(t));
      const s = {};
      if (Object.assign(s, t), v.value === "user") {
        Object.assign(s, {
          [e.userFilterMap.id]: s[e.userFilterMap.id] ? s[e.userFilterMap.id] : s.srfkey,
          [e.userFilterMap.name]: s[e.userFilterMap.name] ? s[e.userFilterMap.name] : s.srfmajortext
        });
        const l = f.value.findIndex((i) => i.id === s[e.userFilterMap.id]);
        l < 0 ? f.value.push({
          id: s[e.userFilterMap.id],
          name: s[e.userFilterMap.name]
        }) : f.value.splice(l, 1);
      } else {
        Object.assign(s, {
          [e.deptFilterMap.id]: s[e.deptFilterMap.id] ? s[e.deptFilterMap.id] : s.srfkey,
          [e.deptFilterMap.name]: s[e.deptFilterMap.name] ? s[e.deptFilterMap.name] : s.srfmajortext
        });
        const l = f.value.findIndex((i) => i.id === s[e.deptFilterMap.id]);
        l < 0 ? f.value.push({
          id: s[e.deptFilterMap.id],
          name: s[e.deptFilterMap.name]
        }) : f.value.splice(l, 1);
      }
      if (e.multiple) {
        if (e.valueItem) {
          let l = f.value.map((i) => i.id);
          l.length > 1 && e.isAddSymbol && (l = l.map((i) => "'".concat(i, "'"))), h("change", l.join(e.separator), e.valueItem);
        }
        if (e.valueType === "OBJECTS")
          U();
        else {
          let l = f.value.map((i) => i.name);
          l.length > 1 && e.isAddSymbol && (l = l.map((i) => "'".concat(i, "'"))), h("change", l.join(e.separator));
        }
      } else {
        const l = await e.calcFillDataItems([t]);
        l.length && l.forEach((i) => {
          h("change", i.value, i.id);
        }), e.valueItem && (v.value === "user" ? h("change", s[e.userFilterMap.id], e.valueItem) : h("change", s[e.deptFilterMap.id], e.valueItem)), e.model.valueType === "OBJECT" ? h("change", e.handleObjectParams(s)) : e.valueType === "OBJECTS" ? (f.value = [me(s)], U()) : v.value === "user" ? h("change", t[e.userFilterMap.name]) : h("change", t[e.deptFilterMap.name]), W.value = !1;
      }
      e.valueType !== "OBJECTS" && h("blur", t), q(!1);
    }, Ee = (t, s) => {
      t.forEach((l) => {
        const i = u.value.findIndex((d) => d[s] === l[s]);
        i > -1 ? u.value.splice(i, 1, l) : u.value.push(l);
      });
    }, M = async (t = !1) => {
      if (P.value)
        return;
      I.value = !0;
      const s = {};
      v.value === "department" ? s.page = e.deptpage : s.page = e.page;
      try {
        const l = await e.loadMore(o.data, v.value, s);
        l && (v.value === "user" ? u.value.length === 0 ? u.value = l.data : Ee(l.data, e.userFilterMap.id) : n.value.length === 0 ? n.value = l.data : n.value.push(...l.data));
      } catch (l) {
        I.value = !1;
      }
      I.value = !1;
    }, Q = (t) => {
      const {
        dataItems: s
      } = e;
      s != null && s.length && s.forEach((l) => {
        h("change", null, l.id);
      }), e.valueItem && h("change", null, e.valueItem), e.valueType === "OBJECTS" ? h("change", []) : (h("change", null), h("blur", t)), t.stopPropagation(), t.preventDefault();
    }, F = J(() => Ze(m.value));
    D(F, (t, s) => {
      t !== s && e.valueType !== "OBJECTS" && h("infoTextChange", t);
    }, {
      immediate: !0
    });
    const ee = async (t) => {
      I.value = !0;
      try {
        const s = {};
        Object.assign(s, {
          query: t,
          size: 1e3
        });
        const l = await e.getServiceData(v.value, o.data, s);
        l && (v.value === "user" ? l.data.forEach((i) => {
          Object.keys(e.userFilterMap).forEach((d) => {
            i[d] = i[e.userFilterMap[d]];
          });
        }) : l.data.forEach((i) => {
          Object.keys(e.deptFilterMap).forEach((d) => {
            i[d] = i[e.deptFilterMap[d]];
          });
        }), A.value = l.data, I.value = !1);
      } catch (s) {
        I.value = !1;
      }
    }, te = (t) => {
      if (v.value !== t) {
        if (v.value = t, P.value) {
          ee(P.value);
          return;
        }
        v.value === "user" && u.value.length === 0 && (e.resetUserState(), M()), v.value === "department" && n.value.length === 0 && (e.resetDeptState(), M());
      }
    }, ye = () => {
      const t = document.documentElement;
      return t ? getComputedStyle(t).getPropertyValue("--ibiz-color-primary") : null;
    }, Pe = (t) => /[\u4E00-\u9FA5]/.test(t), Ie = (t) => /[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(t), z = (t) => {
      if (!t)
        return "";
      let s = 0;
      for (let C = 0; C < t.length; C++)
        if (Pe(t))
          s = t.charCodeAt(C) + ((s << 5) - s), s = s & s;
        else {
          const Be = t.charCodeAt(C);
          s += Be.toString(16);
        }
      const l = String(s).substring(0, 6), i = parseInt(l.substring(0, 2), 16), d = parseInt(l.substring(2, 4), 16), E = parseInt(l.substring(4, 6), 16), y = "#".concat(i.toString(16).padStart(2, "0")).concat(d.toString(16).padStart(2, "0")).concat(E.toString(16).padStart(2, "0"));
      return y === "#FFFFFF" && ye() || y;
    }, Ae = (t) => {
      clearTimeout(V.value), V.value = setTimeout(() => {
        !t && t !== 0 ? M() : ee(t), clearTimeout(V.value);
      }, 300);
    }, Fe = () => r(w("el-input"), {
      class: a.be("select-modal", "search-input"),
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
    }), Me = () => r("div", {
      class: a.be("select-modal", "select-state")
    }, [r("div", {
      class: [a.bem("select-modal", "select-state", "select-slider"), a.is("left", v.value === "user"), a.is("right", v.value !== "user")]
    }, null), r("div", {
      class: a.bem("select-modal", "select-state", "select-personel"),
      onClick: () => te("user")
    }, [T("人员")]), r("div", {
      class: a.bem("select-modal", "select-state", "select-department"),
      onClick: () => te("department")
    }, [T("部门")])]), Ce = (t) => {
      t.forEach((s) => {
        s.capLanguageRes && s.capLanguageRes.lanResTag && (s.caption = ibiz.i18n.t(s.capLanguageRes.lanResTag, s.caption)), s.tooltipLanguageRes && s.tooltipLanguageRes.lanResTag && (s.tooltip = ibiz.i18n.t(s.tooltipLanguageRes.lanResTag, s.tooltip));
      });
    }, we = async (t, s) => {
      await e.onActionClick(t, [o.data], s);
    }, Te = (t) => r("div", {
      class: a.bem("select-modal", "actions", "item"),
      title: t.tooltip || t.caption,
      onClick: (s) => we(t, s)
    }, [t.showIcon && t.sysImage && r(w("iBizIcon"), {
      icon: t.sysImage
    }, null)]), Oe = () => {
      var s;
      const t = ((s = e.model.uiactionGroup) == null ? void 0 : s.uiactionGroupDetails) || [];
      return Ce(t), r("div", {
        class: a.be("select-modal", "actions")
      }, [t.map((l) => Te(l))]);
    }, De = () => {
      var s;
      const t = ((s = e.model.uiactionGroup) == null ? void 0 : s.uiactionGroupDetails) || [];
      return !e.isShowTab && t.length === 0 ? null : r("div", {
        class: [a.be("select-modal", "select"), a.is("no-solider-tab", !e.isShowTab && t.length > 0)]
      }, [e.isShowTab ? Me() : null, Oe()]);
    }, je = (t) => {
      if (e.multiple) {
        if (c.value) {
          let s = c.value.split(e.separator);
          return s.length > 1 && e.isAddSymbol && (s = s.map((i) => i.slice(1, -1))), s.findIndex((i) => i === t) > -1 ? r("div", {
            class: a.bem("select-modal", "personel-list", "icon")
          }, [r("i", {
            class: "fa fa-check",
            "aria-hidden": "true"
          }, null)]) : null;
        }
      } else
        return c.value === t ? r("div", {
          class: a.bem("select-modal", "personel-list", "icon")
        }, [r("i", {
          class: "fa fa-check",
          "aria-hidden": "true"
        }, null)]) : null;
    }, B = (t) => {
      if (t && t.toString().length < 2)
        return t;
      if (t && t.toString().length >= 2) {
        if (Ie(t)) {
          const d = t.split("").find((y) => /[a-zA-Z]/.test(y)) || "", E = t.split("").find((y) => /[\u4E00-\u9FA5]/.test(y)) || "";
          return "".concat(d).concat(E).toLowerCase();
        }
        return /[a-zA-Z]/.test(t) ? t.split("").filter((d) => /[a-zA-Z]/.test(d)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(t) ? t.split("").filter((d) => /[\u4E00-\u9FA5]/.test(d)).slice(-2).join("") : t.replaceAll(" ", "").substring(0, 2);
      }
    }, se = (t) => {
      const s = v.value === "user" ? t[e.userFilterMap.name] || t.name : t[e.deptFilterMap.name] || t.name, l = v.value === "user" ? t[e.userFilterMap.id] : t[e.deptFilterMap.id];
      return r("div", {
        class: [a.bem("select-modal", "personel-list", "item"), a.is("selected", c.value === l)],
        onClick: () => Se(t)
      }, [r("div", {
        class: a.bem("select-modal", "personel-list", "text")
      }, [r("div", {
        class: a.bem("select-modal", "personel-list", "text-img"),
        style: "background-color:".concat(z(s))
      }, [B(s)]), r("div", {
        class: a.bem("select-modal", "personel-list", "text-label")
      }, [s]), l === e.context.srfuserid ? r("div", {
        class: a.bem("select-modal", "personel-list", "myself")
      }, [T("我自己")]) : null]), je(l)]);
    }, xe = (t, s) => {
      const {
        context: l,
        params: i
      } = e;
      return r(w("iBizControlShell"), {
        class: a.b("panel-item"),
        data: t,
        modelData: s,
        context: l,
        params: i
      }, null);
    }, Ue = (t, s) => {
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
        reference: () => se(t),
        default: () => xe(t, s)
      });
    }, Ne = (t) => P.value ? A.value : t, N = (t) => {
      t.preventDefault(), t.stopPropagation();
    }, Le = (t, s) => {
      j.value && (v.value === "user" ? t - s < 305 && (I.value || M()) : t - s < 250 && (I.value || M()));
    }, ae = (t) => {
      var d, E;
      const s = ((d = e.model.uiactionGroup) == null ? void 0 : d.uiactionGroupDetails) || [], l = Ne(t), i = (E = e.deACMode) == null ? void 0 : E.itemLayoutPanel;
      return r(ut, {
        items: l,
        itemHeight: 36,
        class: [a.be("select-modal", "personel-list"), a.be("select-modal", "personel-list-".concat(v.value)), a.is("no-solider-tab", !e.isShowTab && s.length > 0)],
        onScrollEvent: (y, C) => Le(y, C)
      }, {
        default: (y) => i ? Ue(y, i) : se(y)
      });
    }, le = (t) => {
      b.value = t;
    }, Re = () => r("div", {
      class: a.be("select-modal", "deptpersonel")
    }, [r("div", {
      class: a.bem("select-modal", "deptpersonel", "dept")
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
      class: a.bem("select-modal", "deptpersonel", "dept-person")
    }, [ae(n.value)])]), ke = () => st(r("div", {
      class: a.b("select-modal"),
      onPointerdown: N,
      onPointerup: N,
      onClick: N
    }, [Fe(), De(), v.value === "user" ? ae(u.value) : Re()]), [[at("loading"), I.value]]), ie = () => r("div", {
      class: a.b("no-select-value")
    }, [r("img", {
      src: "".concat(R.dir("assets/images/svg/member.svg")),
      alt: ""
    }, null), r("span", null, [T("未设置")])]), re = () => {
      var t;
      if (e.multiple) {
        let s = !1;
        const l = [];
        if (c.value) {
          let i = c.value.split(e.separator), d = F.value.split(e.separator);
          i.length > 1 && e.isAddSymbol && (i = i.map((E) => E.slice(1, -1))), d.length > 1 && e.isAddSymbol && (d = d.map((E) => E.slice(1, -1))), i.forEach((E, y) => {
            l.push({
              id: E,
              name: d[y]
            });
          });
        } else
          F.value === "当前用户" && o.disabled && l.push({
            id: F.value,
            name: F.value
          });
        return e.defaultAttentionValue && e.valueType === "OBJECTS" && x > 0 && (s = x < ((t = f.value) == null ? void 0 : t.length), l == null || l.splice(x, l == null ? void 0 : l.length)), r("div", {
          class: [a.b("select-value-multiple"), s ? a.be("select-value-multiple", "hidden") : ""]
        }, [l == null ? void 0 : l.map((i) => {
          let d;
          return r("div", {
            class: a.be("select-value-multiple", "item")
          }, [r("div", {
            class: [a.be("select-value", "textimg"), a.bem("select-value-multiple", "item", "textimg")],
            style: "background-color:".concat(z(i.name))
          }, [r(w("el-tooltip"), {
            class: "box-item",
            effect: "dark",
            content: i.name,
            placement: "top",
            offset: 12
          }, dt(d = B(i.name)) ? d : {
            default: () => [d]
          }), o.readonly || o.disabled ? null : r("div", {
            class: [a.bem("select-value-multiple", "item", "close")],
            onClick: (E) => be(i, E)
          }, [r("i", {
            class: "fa fa-close",
            "aria-hidden": "true"
          }, null)])])]);
        }), s ? r("span", {
          class: a.bem("select-value-multiple", "hidden", "ellipsis")
        }, [T("...")]) : null, r("div", {
          class: a.b("no-select-value")
        }, [r("img", {
          src: "".concat(R.dir("assets/images/svg/member.svg")),
          alt: ""
        }, null)])]);
      }
      return r("div", {
        class: a.b("select-value")
      }, [r("div", {
        class: a.be("select-value", "textimg"),
        style: "background-color:".concat(z(F.value))
      }, [B(F.value)]), r("div", {
        class: a.be("select-value", "text")
      }, [r("div", {
        class: a.bem("select-value", "text", "label")
      }, [F.value])]), o.readonly || o.disabled ? null : r("i", {
        class: ["fa fa-times-circle", a.be("select-value", "close")],
        "aria-hidden": "true",
        onClick: (s) => Q(s)
      }, null)]);
    }, Ve = async () => {
      var d, E;
      j.value = !0;
      const {
        context: t,
        params: s
      } = e.handlePublicParams(o.data, e.context, e.params), l = e.fill(e.userUrl, t, s, o.data).replaceAll("//", "/"), i = e.fill(e.deptUrl, t, s, o.data).replaceAll("//", "/");
      (l !== e.copyUserUrl || i !== e.copyDeptUrl || o.data && o.data.srfkey !== Z.value) && (Z.value = ((d = o.data) == null ? void 0 : d.srfkey) || "", u.value = [], n.value = [], e.resetState(), M(!0)), await lt(), (E = K.value) == null || E.focus();
    }, $e = () => F.value ? re() : ie(), ze = () => {
      j.value = !1;
    };
    D(() => o.readonly, (t) => {
      t && Y();
    }, {
      deep: !0
    });
    const ne = () => {
      $();
    };
    return pe(() => {
      fe(), window == null || window.addEventListener("resize", ne), $();
    }), tt(() => {
      e.resetState(), window == null || window.removeEventListener("resize", ne);
    }), {
      ns: a,
      c: e,
      refValue: c,
      curValue: m,
      valueText: F,
      loading: I,
      items: u,
      personelSelRef: G,
      onClear: Q,
      load: M,
      isEditable: S,
      popoverRef: k,
      setEditable: q,
      renderDropModal: ke,
      renderNoSelectValue: ie,
      renderSelectInput: re,
      renderReadState: $e,
      onPopShow: Ve,
      onPageHide: ze,
      showFormDefaultContent: he,
      modelVisible: W
    };
  },
  render() {
    const o = r(w("el-popover"), {
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
    }, [this.readonly || this.disabled ? this.renderReadState() : o]);
  }
}), pt = Ke(
  H,
  function(o) {
    o.component(H.name, H), Qe(
      "EDITOR_CUSTOMSTYLE_PERSON_SELECT",
      () => new ot()
    );
  }
), yt = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(o) {
    o.use(pt);
  }
};
export {
  pt as IBizPersonelSelect,
  yt as default
};
