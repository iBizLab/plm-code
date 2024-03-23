import './style.css';
var R = Object.defineProperty;
var B = (s, i, a) => i in s ? R(s, i, { enumerable: !0, configurable: !0, writable: !0, value: a }) : s[i] = a;
var o = (s, i, a) => (B(s, typeof i != "symbol" ? i + "" : i, a), a);
import { getDataPickerProps as U, getEditorEmits as _, useNamespace as K, renderString as V, withInstall as z } from "@ibiz-template/vue3-util";
import { EditorController as H, getDeACMode as J, ScriptFactory as Q, registerEditorProvider as X } from "@ibiz-template/runtime";
import { defineComponent as $, ref as m, computed as g, watch as E, onBeforeMount as Y, createVNode as I, resolveComponent as G } from "vue";
import { isNil as j, clone as T, mergeDeepLeft as W } from "ramda";
import { RuntimeModelError as Z } from "@ibiz-template/core";
import { cloneDeep as q } from "lodash-es";
const N = /* @__PURE__ */ $({
  name: "DynamicTreeSelect",
  props: U(),
  emits: _(),
  setup(s, {
    emit: i
  }) {
    const a = K("picker-dropdown"), e = s.controller, l = m(""), c = m([]), n = m(!1), u = m(""), h = m(!1), p = m(), f = g(() => !!(s.controlParams && s.controlParams.editmode === "hover"));
    E(() => s.value, (t) => {
      if (t || t === null) {
        e.model.valueType === "OBJECT" ? l.value = t ? t[e.objectNameField] : null : l.value = t, t === null && (l.value = ""), u.value = l.value;
        const r = s.data[e.valueItem];
        if (e.copyData.findIndex((D) => Object.is(D[e.keyName], r)) !== -1)
          return;
        c.value = [], !j(t) && !j(r) && c.value.push({
          [e.textName]: t,
          [e.keyName]: r
        });
      }
    }, {
      immediate: !0
    }), E(() => s.data[e.valueItem], (t, r) => {
      t !== r && (u.value = t, t === null && i("change", null));
    }, {
      immediate: !0,
      deep: !0
    });
    const v = (t) => {
      t ? h.value = t : setTimeout(() => {
        h.value = t;
      }, 100);
    }, b = m(!1), x = async (t) => {
      const r = await e.calcFillDataItems(t);
      r.length && r.forEach((D) => {
        i("change", D.value, D.id);
      });
      const d = T(t);
      Object.assign(d, {
        [e.keyName]: d[e.keyName] ? d[e.keyName] : d.srfkey,
        [e.textName]: d[e.textName] ? d[e.textName] : d.srfmajortext
      }), e.valueItem && i("change", d[e.keyName], e.valueItem), e.model.valueType === "OBJECT" ? i("change", e.handleObjectParams(d)) : i("change", t[e.textName]), v(!1);
    }, O = (t) => {
      const r = e.copyData.findIndex((d) => Object.is(d[e.keyName], t));
      r >= 0 && x(e.copyData[r]), n.value = !1;
    };
    let C = null;
    const y = async (t) => {
      if (n.value)
        if (e.model.appDataEntityId && b.value === !1) {
          b.value = !0;
          try {
            let r = "";
            t !== s.value && (r = t.trim());
            const d = await e.getServiceData(r, s.data);
            d && (c.value = d.data);
          } finally {
            if (b.value = !1, C != null) {
              const r = C;
              C = null, await y(r);
            }
          }
        } else
          C = t;
    }, A = (t) => {
      t && (n.value = !0, c.value = [], y(""));
    }, P = () => {
      const {
        dataItems: t
      } = e;
      t != null && t.length && t.forEach((r) => {
        i("change", null, r.id);
      }), e.valueItem && i("change", null, e.valueItem), i("change", null);
    }, M = (t) => {
      n.value = !0, i("focus", t), v(!0);
    }, S = (t) => {
      n.value = !1, i("blur", t), v(!1);
    }, w = (t) => {
      t && t.code === "Enter" && i("enter", t);
    }, k = () => {
      n.value = !0;
    }, F = g(() => V(l.value));
    E(F, (t, r) => {
      t !== r && i("infoTextChange", t);
    }, {
      immediate: !0
    });
    const L = (t, r) => {
      var d;
      return (d = t.children) != null && d.length ? a.e("branch-node") : null;
    };
    return Y(() => {
      s.data && e.valueItem && s.data[e.valueItem] && !s.value && (n.value = !0, c.value = [], y(""));
    }), {
      ns: a,
      c: e,
      refValue: u,
      curValue: l,
      valueText: F,
      loading: b,
      items: c,
      onOpenChange: A,
      onClear: P,
      onSelect: O,
      onSearch: y,
      onFocus: M,
      onBlur: S,
      onClick: k,
      handleKeyUp: w,
      editorRef: p,
      isEditable: h,
      setEditable: v,
      showFormDefaultContent: f,
      customNodeClass: L
    };
  },
  render() {
    const s = this.readonly ? this.value : I(G("el-tree-select"), {
      ref: "editorRef",
      modelValue: this.curValue,
      "onUpdate:modelValue": (e) => this.curValue = e,
      clearable: !0,
      class: [this.ns.b("select")],
      popperClass: this.ns.b("select-pop"),
      filterable: !0,
      teleported: !this.showFormDefaultContent,
      data: this.items,
      "check-strictly": !0,
      multiple: this.c.multiple,
      placeholder: this.c.placeHolder ? this.c.placeHolder : " ",
      disabled: this.disabled,
      onBlur: this.onBlur,
      onVisibleChange: this.onOpenChange,
      onFocus: this.onFocus,
      onKeyup: this.handleKeyUp,
      onChange: this.onSelect,
      props: {
        class: this.customNodeClass
      }
    }, null), i = I("div", {
      class: (this.ns.b(), this.ns.m("readonly"))
    }, [this.valueText]), a = I("div", {
      class: this.ns.b("form-default-content")
    }, [this.curValue ? this.valueText : "-"]);
    return I("div", {
      class: [this.ns.b(), this.disabled ? this.ns.m("disabled") : "", this.readonly ? this.ns.m("readonly") : "", this.ns.is("editable", this.isEditable), this.ns.is("show-default", this.showFormDefaultContent)]
    }, [this.showFormDefaultContent && a, this.readonly ? i : s]);
  }
});
class ee extends H {
  constructor() {
    super(...arguments);
    /**
     * 是否多选
     */
    o(this, "multiple", !1);
    /**
     *选择视图相关参数
     */
    o(this, "pickupView", null);
    /**
     *链接视图相关参数
     */
    o(this, "linkView", null);
    /**
     *值项
     */
    o(this, "valueItem", "");
    /**
     * 主键属性名称
     */
    o(this, "keyName", "srfkey");
    /**
     * 主文本属性名称
     */
    o(this, "textName", "srfmajortext");
    /**
     * 数据集codeName
     */
    o(this, "interfaceName", "");
    /**
     * 自填模式sort排序
     */
    o(this, "sort", "");
    /**
     * 不支持AC（根据编辑器类型得）
     */
    o(this, "noAC", !1);
    /**
     * 不支持按钮（根据编辑器类型得）
     */
    o(this, "noButton", !1);
    /**
     * 实体自填模式模型
     */
    o(this, "deACMode");
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
    // UI转化参数
    o(this, "filterMap", {
      label: "name",
      value: "id"
    });
    // 复制数据
    o(this, "copyData", []);
    // 请求路径
    o(this, "url", "");
    // 请求方式
    o(this, "method", "post");
    // 父值属性
    o(this, "pvalue", "pid");
  }
  async onInit() {
    var a, e, l, c;
    if (super.onInit(), this.initParams(), this.valueItem = ((a = this.model.valueItemName) == null ? void 0 : a.toLowerCase()) || "", this.model.appDataEntityId && (this.model.appDEDataSetId && (this.interfaceName = this.model.appDEDataSetId), this.model.appDEACModeId && (this.deACMode = await J(
      this.model.appDEACModeId,
      this.model.appDataEntityId,
      this.context.srfappid
    ), this.deACMode))) {
      const { minorSortAppDEFieldId: n, minorSortDir: u } = this.deACMode;
      n && u && (this.sort = "".concat(n.toLowerCase(), ",").concat(u.toLowerCase())), this.deACMode.textAppDEFieldId && (this.textName = this.deACMode.textAppDEFieldId), this.deACMode.valueAppDEFieldId && (this.keyName = this.deACMode.valueAppDEFieldId), this.deACMode.deacmodeDataItems && (this.dataItems = [], this.deACMode.deacmodeDataItems.forEach(
        (h) => {
          h.id !== "value" && h.id !== "text" && this.dataItems.push(h);
        }
      ));
    }
    if (this.objectIdField = (e = this.model.objectIdField) == null ? void 0 : e.toLowerCase(), this.objectNameField = (l = this.model.objectNameField) == null ? void 0 : l.toLowerCase(), this.objectValueField = (c = this.model.objectValueField) == null ? void 0 : c.toLowerCase(), this.pvalue = this.editorParams.PVALUE, this.url = this.editorParams.URL, this.method = this.editorParams.METHOD || "post", this.editorParams && Object.prototype.hasOwnProperty.call(this.editorParams, "FILTERMAP"))
      try {
        const n = JSON.parse(this.editorParams.FILTERMAP);
        Object.assign(this.filterMap, n);
      } catch (n) {
        this.filterMap = {
          label: "name",
          value: "id"
        };
      }
  }
  /**
   * 初始化noAc和noButton
   */
  initParams() {
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
  }
  /**
   * 加载实体数据集数据
   *
   * @param {string} query 模糊匹配字符串
   * @param {IData} data 表单数据
   * @returns {*}  {Promise<IHttpResponse<IData[]>>}
   * @memberof PickerEditorController
   */
  async getServiceData(a, e) {
    const { context: l, params: c } = this.handlePublicParams(
      e,
      this.context,
      this.params
    ), n = {};
    this.sort && !Object.is(this.sort, "") && Object.assign(n, { sort: this.sort }), a && Object.assign(n, { query: a }), Object.assign(n, { size: 1e3 });
    const u = W(c, n), h = {};
    Object.assign(h, { method: this.method, data: u });
    const p = Q.execScriptFn(
      { data: e, context: l, params: c },
      this.url,
      {
        singleRowReturn: !0,
        isAsync: !1
      }
    );
    if (p) {
      const f = await ibiz.net.request(p, h);
      return f.data = this.handleTreeData(f), f;
    }
    throw new Z(this.model, "请配置实体和实体数据集");
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
      this.dataItems.map((l) => {
        const c = a[l.appDEFieldId];
        return l.format || l.convertToCodeItemText && l.codeListId || l.customCode, { id: l.id, value: c };
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
      [this.objectValueField]: T(a)
    }), e;
  }
  /**
   * 处理请求回来的数据
   * @param items 数据源
   */
  handleTreeData(a) {
    return a.data ? (a.data.forEach((e) => {
      Object.keys(this.filterMap).forEach((l) => {
        e[l] = e[this.filterMap[l]];
      });
    }), this.copyData = q(a.data), this.pvalue ? this.prepareTreeData(a.data) : a.data) : [];
  }
  /**
   * 组装树形数据
   * @param items
   * @returns
   */
  prepareTreeData(a) {
    const e = this.filterMap.value, l = this.pvalue, c = {}, n = [];
    return a.forEach((u) => {
      c[u[e]] = u;
    }), a.forEach((u) => {
      const h = c[u[l]];
      h ? (h.children = h.children || [], h.children.push(c[u[e]])) : n.push(c[u[e]]);
    }), n;
  }
}
class te {
  constructor() {
    o(this, "component", "DynamicTreeSelect");
    o(this, "formEditor", "DynamicTreeSelect");
    o(this, "gridEditor", "DynamicTreeSelect");
  }
  async createController(i, a) {
    const e = new ee(i, a);
    return await e.init(), e;
  }
}
const ae = z(
  N,
  function(s) {
    s.component(N.name, N), X(
      "EDITOR_CUSTOMSTYLE_MODEL_SELECT",
      () => new te()
    );
  }
), de = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(s) {
    s.use(ae);
  }
};
export {
  ae as IBizDynamicTreeSelect,
  de as default
};
