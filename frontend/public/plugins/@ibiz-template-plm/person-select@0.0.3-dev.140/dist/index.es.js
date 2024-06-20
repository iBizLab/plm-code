import './style.css';
var Ze = Object.defineProperty;
var Ke = (r, m, s) => m in r ? Ze(r, m, { enumerable: !0, configurable: !0, writable: !0, value: s }) : r[m] = s;
var d = (r, m, s) => (Ke(r, typeof m != "symbol" ? m + "" : m, s), s);
import { useNamespace as ce, getDataPickerProps as Ge, getEditorEmits as Xe, renderString as Ye, withInstall as qe } from "@ibiz-template/vue3-util";
import { EditorController as Qe, getDeACMode as et, UIActionUtil as tt, OpenAppViewCommand as ue, PluginStaticResource as at, registerEditorProvider as st } from "@ibiz-template/runtime";
import { RuntimeModelError as _ } from "@ibiz-template/core";
import { mergeDeepLeft as lt, clone as de } from "ramda";
import { notNilEmpty as N } from "qx-util";
import { defineComponent as pe, ref as g, onMounted as me, watch as D, createVNode as n, computed as J, onBeforeUnmount as it, resolveComponent as w, withDirectives as rt, resolveDirective as nt, createTextVNode as T, nextTick as ot, isVNode as ut } from "vue";
import { isArray as ct } from "lodash-es";
class dt extends Qe {
  constructor() {
    super(...arguments);
    /**
     * 云系统操作者Map
     *
     * @memberof PersonelSelectController
     */
    d(this, "operatorMap", /* @__PURE__ */ new Map());
    /**
     * 总数
     */
    d(this, "total", 0);
    /**
     * 当前人员数量
     */
    d(this, "currentNumber", -1);
    /**
     * 人员当前页
     */
    d(this, "page", 0);
    /**
     * 部门人员数据页数
     */
    d(this, "deptpage", 0);
    /**
     * 当前部门人员数量
     */
    d(this, "deptcurrentNumber", -1);
    /**
     * 部门人员总数
     */
    d(this, "depttotal", 0);
    /**
     * 每页数量
     */
    d(this, "size", 20);
    /**
     * 是否多选
     */
    d(this, "multiple", !1);
    /**
     * 是否附加符号 多选且开启附加符号并且选择值为多个时，每个选择值前后都拼接上单引号后再抛出去
     */
    d(this, "isAddSymbol", !1);
    /**
     * 多选时拼接的字符串
     */
    d(this, "separator", ",");
    /**
     *选择视图相关参数
     */
    d(this, "pickupView", null);
    /**
     *链接视图相关参数
     */
    d(this, "linkView", null);
    /**
     * 人员UI转化
     */
    d(this, "userFilterMap", {
      id: "id",
      name: "name"
    });
    /**
     * 部门人员UI转化
     */
    d(this, "deptFilterMap", {
      id: "id",
      name: "name"
    });
    /**
     * 是否显示人员部门分页
     */
    d(this, "isShowTab", !0);
    /**
     *值项
     */
    d(this, "valueItem", "");
    /**
     * 主键属性名称
     */
    d(this, "keyName", "srfkey");
    /**
     * 主文本属性名称
     */
    d(this, "textName", "srfmajortext");
    /**
     * 数据集codeName
     */
    d(this, "interfaceName", "");
    /**
     * 自填模式sort排序
     */
    d(this, "sort", "");
    /**
     * 不支持AC（根据编辑器类型得）
     */
    d(this, "noAC", !1);
    /**
     * 不支持按钮（根据编辑器类型得）
     */
    d(this, "noButton", !1);
    /**
     * 实体自填模式模型
     */
    d(this, "deACMode");
    /**
     * 自填数据项集合（已排除了value和text)
     */
    d(this, "dataItems", []);
    // 对象标识属性
    d(this, "objectIdField", "");
    // 对象名称属性
    d(this, "objectNameField", "");
    // 对象值属性
    d(this, "objectValueField", "");
    // 人员请求地址
    d(this, "userUrl", "");
    // 部门请求地址
    d(this, "deptUrl", "");
    // 复制人员请求url,这是用来保证当配置的URL中的动态参数变化后可以刷新当前请求状态
    d(this, "copyUserUrl", "");
    // 复制部门人员请求url
    d(this, "copyDeptUrl", "");
    // 人员请求方式
    d(this, "userMethod", "post");
    // 部门人员请求方式
    d(this, "deptMethod", "post");
    /**
     * 上下文替换正则
     *
     */
    d(this, "contextReg", /\$\{context.[a-zA-Z_$][a-zA-Z0-9_$]{1,}\}/g);
    /**
     * 数据替换正则
     *
     */
    d(this, "dataReg", /\$\{data.[a-zA-Z_$][a-zA-Z0-9_$]{1,}\}/g);
    /**
     * 参数替换正则
     *
     */
    d(this, "paramsReg", /\$\{params.[a-zA-Z_$][a-zA-Z0-9_$]{1,}\}/g);
    /**
     * 是否配置了默认显示当前用户
     */
    d(this, "defaultSelCurUser", !1);
    /**
     * 值类型
     */
    d(this, "valueType", "OBJECTS");
    /**
     * 关注类型属性
     *
     */
    d(this, "attentionTypeField", "type");
    /**
     * 自填充映射
     */
    d(this, "selfFillMap", {});
    /**
     * 选中后默认关注值
     *
     */
    d(this, "defaultAttentionValue", "");
  }
  async onInit() {
    var e, h, u, o;
    if (super.onInit(), this.initDefaultAttribute(), this.initParams(), await this.getOperatorUserList(), this.valueItem = ((e = this.model.valueItemName) == null ? void 0 : e.toLowerCase()) || "", this.model.appDataEntityId && (this.model.appDEDataSetId && (this.interfaceName = this.model.appDEDataSetId), this.model.appDEACModeId && (this.deACMode = await et(
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
    this.model.editorType && s.includes(this.model.editorType) && this.initPickupViewParams(), this.objectIdField = (h = this.model.objectIdField) == null ? void 0 : h.toLowerCase(), this.objectNameField = (u = this.model.objectNameField) == null ? void 0 : u.toLowerCase(), this.objectValueField = (o = this.model.objectValueField) == null ? void 0 : o.toLowerCase();
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
    var s, e, h, u, o;
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
    if (this.userUrl = this.editorParams.URL, this.deptUrl = this.editorParams.DEPTURL, this.userMethod = this.editorParams.USERMETHOD || "post", this.deptMethod = this.editorParams.DEPTMETHOD || "post", this.multiple = this.editorParams.MULTIPLE === "true", this.defaultSelCurUser = this.editorParams.DEFAULTSELCURUSER === "true", this.separator = this.editorParams.SEPARATOR || ",", this.isAddSymbol = this.editorParams.ISADDSYMBOL === "true" && this.multiple === !0, this.isShowTab = this.editorParams.ISSHOWTAB !== "false", (s = this.editorParams) != null && s.VALUETYPE && (this.valueType = (e = this.editorParams) == null ? void 0 : e.VALUETYPE), (h = this.editorParams) != null && h.DEFAULTATNVALUE && (this.defaultAttentionValue = (u = this.editorParams) == null ? void 0 : u.DEFAULTATNVALUE), this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "SELFFILLMAP"))
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
  async loadMore(s, e, h = {}) {
    if (e === "user" && this.currentNumber < this.total) {
      const u = await this.getServiceData(e, s, h);
      if (u)
        return this.page += 1, this.currentNumber < 0 && (this.currentNumber += 1), this.currentNumber += this.size, this.total = u.total ? Number(u.total) : Number(u.headers["x-total"]), u.data.forEach((o) => {
          Object.keys(this.userFilterMap).forEach((c) => {
            o[c] = o[this.userFilterMap[c]];
          });
        }), u;
    } else if (e === "department" && this.deptcurrentNumber < this.depttotal) {
      const u = await this.getServiceData(e, s, h);
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
  async onActionClick(s, e, h) {
    const u = s.uiactionId;
    let o = {};
    this.parent.form ? o = this.parent.form.ctx.view : this.parent.grid && (o = this.parent.grid.ctx.view), await tt.execAndResolved(
      u,
      {
        context: this.context,
        params: this.params,
        data: e,
        view: o,
        event: h
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
  fill(s = "", e, h, u) {
    if (N(s)) {
      if (N(e)) {
        const o = s.match(this.contextReg);
        o == null || o.forEach((c) => {
          const b = c.slice(10, c.length - 1);
          s = s.replace("${context.".concat(b, "}"), e[b] || "");
        });
      }
      if (N(h)) {
        const o = s.match(this.paramsReg);
        o == null || o.forEach((c) => {
          const b = c.slice(9, c.length - 1);
          s = s.replace("${params.".concat(b, "}"), h[b] || "");
        });
      }
      if (N(u)) {
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
  async getServiceData(s, e, h) {
    const { context: u, params: o } = this.handlePublicParams(
      e,
      this.context,
      this.params
    ), c = {};
    this.sort && !Object.is(this.sort, "") && Object.assign(c, { sort: this.sort }), Object.assign(c, { size: this.size }), h && Object.assign(c, h);
    const b = lt(o, c);
    let S = "";
    const M = this.fill(this.userUrl, u, o, e).replaceAll(
      "//",
      "/"
    ), I = this.fill(this.deptUrl, u, o, e).replaceAll(
      "//",
      "/"
    );
    this.copyUserUrl = M, this.copyDeptUrl = I;
    let v = "post";
    const f = {};
    if (s === "user" ? (S = M, v = this.userMethod.toLowerCase(), v === "get" ? Object.assign(f, { method: v, params: b }) : Object.assign(f, { method: v, data: b })) : (S = I, v = this.deptMethod.toLowerCase(), v === "get" ? Object.assign(f, { method: v, params: b }) : Object.assign(f, { method: v, data: b })), S)
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
    const { context: h, params: u } = this.handlePublicParams(
      s,
      this.context,
      this.params
    );
    if (e && (u.selectedData = e), !this.pickupView)
      throw new _(this.model, "请配置数据选择视图");
    const o = await ibiz.commands.execute(
      ue.TAG,
      this.pickupView.id,
      h,
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
    const { context: h, params: u } = this.handlePublicParams(
      s,
      e,
      this.params
    ), { linkAppViewId: o } = this.model;
    if (!o)
      throw new _(this.model, "请配置数据链接视图");
    return ibiz.commands.execute(
      ue.TAG,
      o,
      h,
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
      this.dataItems.map((h) => {
        const o = s.map((c) => c[h.appDEFieldId]).join(this.separator);
        return h.format || h.convertToCodeItemText && h.codeListId || h.customCode, { id: h.id, value: o };
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
      [this.objectValueField]: de(s)
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
      e.map((h) => [h.value, h])
    );
  }
}
class pt {
  constructor() {
    d(this, "component", "PersonelSelect");
    d(this, "formEditor", "PersonelSelect");
    d(this, "gridEditor", "PersonelSelect");
  }
  async createController(m, s) {
    const e = new dt(m, s);
    return await e.init(), e;
  }
}
const mt = /* @__PURE__ */ pe({
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
  setup(r, {
    emit: m
  }) {
    const s = ce("virtual-list"), e = g(36), h = g(), u = g([]), o = g(0), c = g(0), b = g(0), S = g(0), M = () => {
      c.value = Math.floor(S.value / r.itemHeight), b.value = c.value + r.showNum, u.value = r.items.slice(c.value, b.value);
      const f = S.value - S.value % r.itemHeight;
      o.value = f;
    }, I = () => {
      S.value = h.value.scrollTop, M(), v(e.value, S.value);
    }, v = (f, P) => {
      m("scrollEvent", f, P);
    };
    return me(() => {
      setTimeout(() => {
        scroll();
      }, 1e3);
    }), D(() => r.items, () => {
      e.value = r.itemHeight * r.items.length, M();
    }, {
      immediate: !0,
      deep: !0
    }), {
      ns: s,
      contentHeight: e,
      showList: u,
      contentBox: h,
      top: o,
      onScroll: I
    };
  },
  render() {
    return n("div", {
      ref: "contentBox",
      class: this.ns.b(),
      onScroll: () => this.onScroll()
    }, [n("div", {
      class: this.ns.e("container"),
      style: "height:".concat(this.contentHeight, "px;")
    }, [n("div", {
      class: this.ns.e("content"),
      style: "top:".concat(this.top, "px;")
    }, [this.showList.map((r, m) => n("div", {
      key: m,
      class: this.ns.m("item")
    }, [this.$slots.default ? this.$slots.default({
      ...r,
      // eslint-disable-next-line object-shorthand
      index: m
    }) : r.name]))])])]);
  }
}), R = new at(import.meta.url);
class ht {
  /**
   * 计算选中项绘制个数 多选场景需计算显示人员是否超出
   * @author ljx
   * @date 2024-03-05 02:42:45
   * @param {IData} values 选中项key值集合
   * @returns {number} selRenderNum
   */
  static calcSelItemRenderNum(m, s) {
    let e = 0;
    if (s && (m == null ? void 0 : m.length) > 0) {
      const h = (s == null ? void 0 : s.offsetWidth) || 0, u = window.getComputedStyle(s), o = parseInt(u.marginLeft, 10), c = parseInt(u.marginRight, 10), b = parseInt(u.paddingLeft, 10), S = parseInt(u.paddingRight, 10), M = o + c + b + S, I = 30, v = 28, f = 8, P = (v + f) * m.length;
      h - M - I - P < 0 && (e = Math.floor(
        (h - M - I) / (v + f)
      ), e -= 1);
    }
    return e;
  }
}
function ft(r) {
  return typeof r == "function" || Object.prototype.toString.call(r) === "[object Object]" && !ut(r);
}
const H = /* @__PURE__ */ pe({
  name: "PersonelSelect",
  props: Ge(),
  emits: Xe(),
  setup(r, {
    emit: m
  }) {
    const s = ce("picker-dropdown"), e = r.controller, h = g(""), u = g([]), o = g([]), c = g(""), b = g(!1), S = g(!1), M = g(""), I = g([]), v = g("user"), f = g([]), P = g(!1), j = g(!1), W = g(!1), Z = g(""), K = g(), k = g(), G = g();
    let O;
    const V = g(), X = g([]);
    let x = 0;
    const he = J(() => !!(r.controlParams && r.controlParams.editmode === "hover")), Y = (t) => {
      const a = [], l = [];
      f.value = [], t.forEach((i) => {
        var y, E;
        const p = de(i);
        (y = e.selfFillMap) != null && y.user_id && ((E = e.selfFillMap) != null && E.user_name) && Object.assign(p, {
          id: i[e.selfFillMap.user_id],
          name: i[e.selfFillMap.user_name]
        }), a.push(i[e.selfFillMap.user_id]), l.push(i[e.selfFillMap.user_name]), f.value.push(p);
      }), c.value = a == null ? void 0 : a.join(e.separator), h.value = l == null ? void 0 : l.toString();
    }, U = () => {
      const t = f.value.map((a) => {
        var i, p;
        const l = {};
        return Object.assign(l, {
          [(i = e.selfFillMap) == null ? void 0 : i.user_id]: a.id,
          [(p = e.selfFillMap) == null ? void 0 : p.user_name]: a.name
        }), e.attentionTypeField && e.defaultAttentionValue && Object.assign(l, {
          [e.attentionTypeField]: e.defaultAttentionValue
        }), l;
      });
      m("change", t), e.parent.form && (e.parent.form.state.modified = !1);
    }, fe = (t) => {
      const a = {};
      return v.value === "user" ? Object.assign(a, {
        id: t[e.userFilterMap.id],
        name: t[e.userFilterMap.name]
      }) : Object.assign(a, {
        id: t[e.deptFilterMap.id],
        name: t[e.deptFilterMap.name]
      }), a;
    }, ve = () => {
      var t, a;
      if (e.defaultSelCurUser) {
        const l = {};
        Object.assign(l, {
          id: (t = e.context) == null ? void 0 : t.srfuserid,
          name: (a = e.context) == null ? void 0 : a.srfusername
        }), e.multiple ? f.value.push(l) : f.value.length === 0 && (f.value = [l]), U();
      }
    }, q = () => {
      O != null && O.value && O.value.hide(), k.value && k.value.hide();
    }, ge = (t) => {
      (t.key === "Escape" || t.keyCode === 27) && (t.stopPropagation(), q());
    }, $ = () => {
      if (!(e.defaultAttentionValue && e.valueType === "OBJECTS"))
        return;
      const t = c.value.split(e.separator);
      x = ht.calcSelItemRenderNum(t, G.value), c.value = "", Y(f.value);
    };
    D(() => r.value, (t) => {
      if (t || t === null || t === void 0) {
        if (e.model.valueType === "OBJECT")
          h.value = t ? t[e.objectNameField] : null;
        else if (e.valueType === "OBJECTS") {
          const a = ct(t) ? t : [];
          Y(a), $();
          return;
        } else
          h.value = t;
        if (t == null) {
          h.value = "", f.value = [], m("change", null, e.valueItem), m("blur");
          return;
        } else if (e.multiple && f.value.length === 0 && e.valueItem && r.data && r.data[e.valueItem]) {
          let a = r.data[e.valueItem].split(e.separator), l = h.value.split(e.separator);
          e.isAddSymbol && (a = a.map((i) => i.slice(1, -1)), l = l.map((i) => i.slice(1, -1))), a.forEach((i, p) => {
            f.value.push({
              id: i,
              name: l[p]
            });
          });
        }
      }
    }, {
      immediate: !0
    });
    const be = J(() => r.data && r.data[e.valueItem] || void 0);
    D(be, (t, a) => {
      t !== a && (c.value = t, t == null && (f.value = [], m("change", null)));
    }, {
      immediate: !0,
      deep: !0
    });
    const Q = (t) => {
      t ? S.value = t : setTimeout(() => {
        S.value = t;
      }, 100);
    }, Se = (t, a) => {
      L(a);
      const l = f.value.findIndex((i) => i.id === t.id);
      if (l > -1 && f.value.splice(l, 1), e.valueItem) {
        let i = f.value.map((p) => p.id);
        e.isAddSymbol && (i = i.map((p) => "'".concat(p, "'"))), m("change", i.join(e.separator), e.valueItem);
      }
      if (e.valueType === "OBJECTS")
        U();
      else {
        let i = f.value.map((p) => p.name);
        e.isAddSymbol && (i = i.map((p) => "'".concat(p, "'"))), m("change", i.join(e.separator));
      }
    }, ye = async (t) => {
      console.log("选中数据", t), M.value && (v.value === "user" ? u.value.unshift(t) : o.value.unshift(t));
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
          e.isAddSymbol && (l = l.map((i) => "'".concat(i, "'"))), m("change", l.join(e.separator), e.valueItem);
        }
        if (e.valueType === "OBJECTS")
          U();
        else {
          let l = f.value.map((i) => i.name);
          e.isAddSymbol && (l = l.map((i) => "'".concat(i, "'"))), m("change", l.join(e.separator));
        }
      } else {
        const l = await e.calcFillDataItems([t]);
        l.length && l.forEach((i) => {
          m("change", i.value, i.id);
        }), e.valueItem && (v.value === "user" ? m("change", a[e.userFilterMap.id], e.valueItem) : m("change", a[e.deptFilterMap.id], e.valueItem)), e.model.valueType === "OBJECT" ? m("change", e.handleObjectParams(a)) : e.valueType === "OBJECTS" ? (f.value = [fe(a)], U()) : v.value === "user" ? m("change", t[e.userFilterMap.name]) : m("change", t[e.deptFilterMap.name]), W.value = !1;
      }
      e.valueType !== "OBJECTS" && m("blur", t), Q(!1);
    }, Ee = (t, a) => {
      t.forEach((l) => {
        const i = u.value.findIndex((p) => p[a] === l[a]);
        i > -1 ? u.value.splice(i, 1, l) : u.value.push(l);
      });
    }, F = async (t = !1) => {
      if (M.value)
        return;
      P.value = !0;
      const a = {};
      v.value === "department" ? a.page = e.deptpage : a.page = e.page;
      try {
        const l = await e.loadMore(r.data, v.value, a);
        l && (v.value === "user" ? u.value.length === 0 ? u.value = l.data : Ee(l.data, e.userFilterMap.id) : o.value.length === 0 ? o.value = l.data : o.value.push(...l.data));
      } catch (l) {
        P.value = !1;
      }
      P.value = !1;
    }, ee = (t) => {
      const {
        dataItems: a
      } = e;
      a != null && a.length && a.forEach((l) => {
        m("change", null, l.id);
      }), e.valueItem && m("change", null, e.valueItem), e.valueType === "OBJECTS" ? m("change", []) : (m("change", null), m("blur", t)), t.stopPropagation(), t.preventDefault();
    }, A = J(() => Ye(h.value));
    D(A, (t, a) => {
      t !== a && e.valueType !== "OBJECTS" && m("infoTextChange", t);
    }, {
      immediate: !0
    });
    const te = async (t) => {
      P.value = !0;
      try {
        const a = {};
        Object.assign(a, {
          query: t,
          size: 1e3
        });
        const l = await e.getServiceData(v.value, r.data, a);
        l && (v.value === "user" ? l.data.forEach((i) => {
          Object.keys(e.userFilterMap).forEach((p) => {
            i[p] = i[e.userFilterMap[p]];
          });
        }) : l.data.forEach((i) => {
          Object.keys(e.deptFilterMap).forEach((p) => {
            i[p] = i[e.deptFilterMap[p]];
          });
        }), I.value = l.data, P.value = !1);
      } catch (a) {
        P.value = !1;
      }
    }, ae = (t) => {
      if (v.value !== t) {
        if (v.value = t, M.value) {
          te(M.value);
          return;
        }
        v.value === "user" && u.value.length === 0 && (e.resetUserState(), F()), v.value === "department" && o.value.length === 0 && (e.resetDeptState(), F());
      }
    }, Me = () => {
      const t = document.documentElement;
      return t ? getComputedStyle(t).getPropertyValue("--ibiz-color-primary") : null;
    }, Pe = (t) => /[\u4E00-\u9FA5]/.test(t), Ie = (t) => /[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(t), z = (t) => {
      if (!t)
        return "";
      let a = 0;
      for (let C = 0; C < t.length; C++)
        if (Pe(t))
          a = t.charCodeAt(C) + ((a << 5) - a), a = a & a;
        else {
          const We = t.charCodeAt(C);
          a += We.toString(16);
        }
      const l = String(a).substring(0, 6), i = parseInt(l.substring(0, 2), 16), p = parseInt(l.substring(2, 4), 16), y = parseInt(l.substring(4, 6), 16), E = "#".concat(i.toString(16).padStart(2, "0")).concat(p.toString(16).padStart(2, "0")).concat(y.toString(16).padStart(2, "0"));
      return E === "#FFFFFF" && Me() || E;
    }, Ae = (t) => {
      clearTimeout(V.value), V.value = setTimeout(() => {
        !t && t !== 0 ? F() : te(t), clearTimeout(V.value);
      }, 300);
    }, Fe = () => n(w("el-input"), {
      class: s.be("select-modal", "search-input"),
      ref: K,
      modelValue: M.value,
      "onUpdate:modelValue": (t) => M.value = t,
      placeholder: "搜索",
      onInput: (t) => Ae(t),
      onKeydown: ge
    }, {
      suffix: () => n("img", {
        src: "".concat(R.dir("assets/images/svg/search.svg")),
        alt: ""
      }, null)
    }), Ce = () => n("div", {
      class: s.be("select-modal", "select-state")
    }, [n("div", {
      class: [s.bem("select-modal", "select-state", "select-slider"), s.is("left", v.value === "user"), s.is("right", v.value !== "user")]
    }, null), n("div", {
      class: s.bem("select-modal", "select-state", "select-personel"),
      onClick: () => ae("user")
    }, [T("人员")]), n("div", {
      class: s.bem("select-modal", "select-state", "select-department"),
      onClick: () => ae("department")
    }, [T("部门")])]), we = (t) => {
      t.forEach((a) => {
        a.capLanguageRes && a.capLanguageRes.lanResTag && (a.caption = ibiz.i18n.t(a.capLanguageRes.lanResTag, a.caption)), a.tooltipLanguageRes && a.tooltipLanguageRes.lanResTag && (a.tooltip = ibiz.i18n.t(a.tooltipLanguageRes.lanResTag, a.tooltip));
      });
    }, Te = async (t, a) => {
      await e.onActionClick(t, [r.data], a);
    }, Oe = (t) => n("div", {
      class: s.bem("select-modal", "actions", "item"),
      title: t.tooltip || t.caption,
      onClick: (a) => Te(t, a)
    }, [t.showIcon && t.sysImage && n(w("iBizIcon"), {
      icon: t.sysImage
    }, null)]), De = () => {
      var a;
      const t = ((a = e.model.uiactionGroup) == null ? void 0 : a.uiactionGroupDetails) || [];
      return we(t), n("div", {
        class: s.be("select-modal", "actions")
      }, [t.map((l) => Oe(l))]);
    }, je = () => {
      var a;
      const t = ((a = e.model.uiactionGroup) == null ? void 0 : a.uiactionGroupDetails) || [];
      return !e.isShowTab && t.length === 0 ? null : n("div", {
        class: [s.be("select-modal", "select"), s.is("no-solider-tab", !e.isShowTab && t.length > 0)]
      }, [e.isShowTab ? Ce() : null, De()]);
    }, xe = (t) => {
      if (e.multiple) {
        if (c.value) {
          let a = c.value.split(e.separator);
          return e.isAddSymbol && (a = a.map((i) => i.slice(1, -1))), a.findIndex((i) => i === t) > -1 ? n("div", {
            class: s.bem("select-modal", "personel-list", "icon")
          }, [n("i", {
            class: "fa fa-check",
            "aria-hidden": "true"
          }, null)]) : null;
        }
      } else
        return c.value === t ? n("div", {
          class: s.bem("select-modal", "personel-list", "icon")
        }, [n("i", {
          class: "fa fa-check",
          "aria-hidden": "true"
        }, null)]) : null;
    }, Ue = (t) => {
      if (t && t.toString().length < 2)
        return t;
      if (t && t.toString().length >= 2) {
        if (Ie(t)) {
          const p = t.split("").find((E) => /[a-zA-Z]/.test(E)) || "", y = t.split("").find((E) => /[\u4E00-\u9FA5]/.test(E)) || "";
          return "".concat(p).concat(y).toLowerCase();
        }
        return /[a-zA-Z]/.test(t) ? t.split("").filter((p) => /[a-zA-Z]/.test(p)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(t) ? t.split("").filter((p) => /[\u4E00-\u9FA5]/.test(p)).slice(-2).join("") : t.replaceAll(" ", "").substring(0, 2);
      }
    }, Le = (t) => {
      console.log("头像加载失败"), X.value.push(t);
    }, Ne = (t) => {
      if (!t)
        return null;
      const a = JSON.parse(t);
      if (a.length === 0)
        return null;
      const {
        downloadUrl: l
      } = ibiz.util.file.calcFileUpDownUrl(e.context, e.params, r.data, e.editorParams), i = l.replace("%fileId%", a[0].id);
      return n("img", {
        class: s.bem("select-modal", "personel-list", "avatar"),
        src: i,
        onError: () => Le(t),
        alt: ""
      }, null);
    }, B = (t, a) => e.operatorMap && e.operatorMap.get(t) && e.operatorMap.get(t).data.iconurl && !X.value.includes(e.operatorMap.get(t).data.iconurl) ? Ne(e.operatorMap.get(t).data.iconurl) : Ue(a), se = (t) => {
      const a = v.value === "user" ? t[e.userFilterMap.name] || t.name : t[e.deptFilterMap.name] || t.name, l = v.value === "user" ? t[e.userFilterMap.id] : t[e.deptFilterMap.id];
      return n("div", {
        class: [s.bem("select-modal", "personel-list", "item"), s.is("selected", c.value === l)],
        onClick: () => ye(t)
      }, [n("div", {
        class: s.bem("select-modal", "personel-list", "text")
      }, [n("div", {
        class: s.bem("select-modal", "personel-list", "text-img"),
        style: "background-color:".concat(z(a))
      }, [B(l, a)]), n("div", {
        class: s.bem("select-modal", "personel-list", "text-label")
      }, [a]), l === e.context.srfuserid ? n("div", {
        class: s.bem("select-modal", "personel-list", "myself")
      }, [T("我自己")]) : null]), xe(l)]);
    }, Re = (t, a) => {
      const {
        context: l,
        params: i
      } = e;
      return n(w("iBizControlShell"), {
        class: s.b("panel-item"),
        data: t,
        modelData: a,
        context: l,
        params: i
      }, null);
    }, ke = (t, a) => {
      const l = g();
      return n(w("el-popover"), {
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
        default: () => Re(t, a)
      });
    }, Ve = (t) => M.value ? I.value : t, L = (t) => {
      t.preventDefault(), t.stopPropagation();
    }, $e = (t, a) => {
      j.value && (v.value === "user" ? t - a < 305 && (P.value || F()) : t - a < 250 && (P.value || F()));
    }, le = (t) => {
      var p, y;
      const a = ((p = e.model.uiactionGroup) == null ? void 0 : p.uiactionGroupDetails) || [], l = Ve(t), i = (y = e.deACMode) == null ? void 0 : y.itemLayoutPanel;
      return n(mt, {
        items: l,
        itemHeight: 36,
        class: [s.be("select-modal", "personel-list"), s.be("select-modal", "personel-list-".concat(v.value)), s.is("no-solider-tab", !e.isShowTab && a.length > 0)],
        onScrollEvent: (E, C) => $e(E, C)
      }, {
        default: (E) => i ? ke(E, i) : se(E)
      });
    }, ie = (t) => {
      b.value = t;
    }, ze = () => n("div", {
      class: s.be("select-modal", "deptpersonel")
    }, [n("div", {
      class: s.bem("select-modal", "deptpersonel", "dept")
    }, [n("div", {
      class: "collpase-icon"
    }, [b.value ? n("i", {
      class: "fa fa-angle-right",
      "aria-hidden": "true",
      onClick: () => ie(!1)
    }, null) : n("i", {
      class: "fa fa-angle-down",
      "aria-hidden": "true",
      onClick: () => ie(!0)
    }, null)]), n("img", {
      src: "".concat(R.dir("assets/images/svg/org.svg"))
    }, null), n("span", null, ["".concat(e.context.srfusername, "的团队")]), n("span", null, [T("·")]), n("span", null, [e.depttotal])]), b.value ? null : n("div", {
      class: s.bem("select-modal", "deptpersonel", "dept-person")
    }, [le(o.value)])]), Be = () => rt(n("div", {
      class: s.b("select-modal"),
      onPointerdown: L,
      onPointerup: L,
      onClick: L
    }, [Fe(), je(), v.value === "user" ? le(u.value) : ze()]), [[nt("loading"), P.value]]), re = () => n("div", {
      class: [s.b("no-select-value"), s.is("readonly", r.readonly || r.disabled)]
    }, [n("img", {
      src: "".concat(R.dir("assets/images/svg/member.svg")),
      alt: ""
    }, null), n("span", null, [T("未设置")])]), ne = () => {
      var t;
      if (e.multiple) {
        let a = !1;
        const l = [];
        if (c.value) {
          let i = c.value.split(e.separator), p = A.value.split(e.separator);
          e.isAddSymbol && (i = i.map((y) => y.slice(1, -1))), e.isAddSymbol && (p = p.map((y) => y.slice(1, -1))), i.forEach((y, E) => {
            l.push({
              id: y,
              name: p[E]
            });
          });
        } else
          A.value === "当前用户" && r.disabled && l.push({
            id: A.value,
            name: A.value
          });
        return e.defaultAttentionValue && e.valueType === "OBJECTS" && x > 0 && (a = x < ((t = f.value) == null ? void 0 : t.length), l == null || l.splice(x, l == null ? void 0 : l.length)), n("div", {
          class: [s.b("select-value-multiple"), s.is("readonly", r.readonly || r.disabled), a ? s.be("select-value-multiple", "hidden") : ""]
        }, [l == null ? void 0 : l.map((i) => {
          let p;
          return n("div", {
            class: s.be("select-value-multiple", "item")
          }, [n("div", {
            class: [s.be("select-value", "textimg"), s.bem("select-value-multiple", "item", "textimg")],
            style: "background-color:".concat(z(i.name))
          }, [n(w("el-tooltip"), {
            class: "box-item",
            effect: "dark",
            content: i.name,
            placement: "top",
            offset: 12
          }, ft(p = B(i.id, i.name)) ? p : {
            default: () => [p]
          }), r.readonly || r.disabled ? null : n("div", {
            class: [s.bem("select-value-multiple", "item", "close")],
            onClick: (y) => Se(i, y)
          }, [n("i", {
            class: "fa fa-close",
            "aria-hidden": "true"
          }, null)])])]);
        }), a ? n("span", {
          class: s.bem("select-value-multiple", "hidden", "ellipsis")
        }, [T("...")]) : null, n("div", {
          class: s.b("no-select-value")
        }, [n("img", {
          src: "".concat(R.dir("assets/images/svg/member.svg")),
          alt: ""
        }, null)])]);
      }
      return n("div", {
        class: [s.b("select-value"), s.is("readonly", r.readonly || r.disabled)]
      }, [n("div", {
        class: s.be("select-value", "textimg"),
        style: "background-color:".concat(z(A.value))
      }, [B(c.value, A.value)]), n("div", {
        class: s.be("select-value", "text")
      }, [n("div", {
        class: s.bem("select-value", "text", "label")
      }, [A.value])]), r.readonly || r.disabled ? null : n("i", {
        class: ["fa fa-times-circle", s.be("select-value", "close")],
        "aria-hidden": "true",
        onClick: (a) => ee(a)
      }, null)]);
    }, _e = async () => {
      var p, y;
      j.value = !0;
      const {
        context: t,
        params: a
      } = e.handlePublicParams(r.data, e.context, e.params), l = e.fill(e.userUrl, t, a, r.data).replaceAll("//", "/"), i = e.fill(e.deptUrl, t, a, r.data).replaceAll("//", "/");
      (l !== e.copyUserUrl || i !== e.copyDeptUrl || r.data && r.data.srfkey !== Z.value) && (Z.value = ((p = r.data) == null ? void 0 : p.srfkey) || "", u.value = [], o.value = [], e.resetState(), F(!0)), await ot(), (y = K.value) == null || y.focus();
    }, Je = () => A.value ? ne() : re(), He = () => {
      j.value = !1;
    };
    D(() => r.readonly, (t) => {
      t && q();
    }, {
      deep: !0
    });
    const oe = () => {
      $();
    };
    return me(() => {
      ve(), window == null || window.addEventListener("resize", oe), $();
    }), it(() => {
      e.resetState(), window == null || window.removeEventListener("resize", oe);
    }), {
      ns: s,
      c: e,
      refValue: c,
      curValue: h,
      valueText: A,
      loading: P,
      items: u,
      personelSelRef: G,
      onClear: ee,
      load: F,
      isEditable: S,
      popoverRef: k,
      setEditable: Q,
      renderDropModal: Be,
      renderNoSelectValue: re,
      renderSelectInput: ne,
      renderReadState: Je,
      onPopShow: _e,
      onPageHide: He,
      showFormDefaultContent: he,
      modelVisible: W
    };
  },
  render() {
    const r = n(w("el-popover"), {
      ref: "popoverRef",
      visible: this.modelVisible,
      "onUpdate:visible": (m) => this.modelVisible = m,
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
    return n("div", {
      ref: "personelSelRef",
      class: [this.ns.b(), this.ns.b("person-value"), this.disabled ? this.ns.m("disabled") : "", this.readonly ? this.ns.m("readonly") : "", this.ns.is("editable", this.isEditable), this.ns.is("show-default", this.showFormDefaultContent)]
    }, [this.readonly || this.disabled ? this.renderReadState() : r]);
  }
}), vt = qe(
  H,
  function(r) {
    r.component(H.name, H), st(
      "EDITOR_CUSTOMSTYLE_PERSON_SELECT",
      () => new pt()
    );
  }
), At = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(r) {
    r.use(vt);
  }
};
export {
  vt as IBizPersonelSelect,
  At as default
};
