import './style.css';
var O = Object.defineProperty;
var M = (s, r, e) => r in s ? O(s, r, { enumerable: !0, configurable: !0, writable: !0, value: e }) : s[r] = e;
var b = (s, r, e) => (M(s, typeof r != "symbol" ? r + "" : r, e), e);
import { useNamespace as P, useClickOutside as D, useControlController as B, withInstall as L } from "@ibiz-template/vue3-util";
import { EditFormController as T, convertNavData as N, EditFormService as R, getEntitySchema as V, registerControlProvider as H } from "@ibiz-template/runtime";
import { ref as E, reactive as A, defineComponent as x, watch as C, onMounted as F, onUnmounted as _, createVNode as n, nextTick as q, computed as W, resolveComponent as U, h as J } from "vue";
import { debounce as K } from "lodash-es";
import { clone as X } from "ramda";
class Y {
  constructor() {
    b(this, "component", "IBizProjectAttributes");
  }
}
class G extends T {
  constructor() {
    super(...arguments);
    /**
     * jsonschema参数
     *
     * @author zhanghengfeng
     * @date 2024-07-05 15:07:47
     * @type {IParams}
     */
    b(this, "jsonSchemaParams", {});
    // 计算表单模型
    b(this, "calcFormDetail", (e) => {
      let o = "span";
      e.type === "string" ? o = "TEXTBOX" : e.type === "number" ? o = "NUMBER" : e.type === "picker" ? o = "MDROPDOWNLIST" : e.type === "date" && (o = "DATEPICKER");
      const t = {
        allowEmpty: !0,
        appDEFieldId: e.key,
        appId: ibiz.env.appId,
        capLanguageRes: { lanResTag: "DEF.LNAME.ID", appId: ibiz.env.appId },
        caption: e.description,
        codeName: e.key,
        dataType: 25,
        detailStyle: "DEFAULT",
        detailType: "FORMITEM",
        editor: {
          style: {},
          appId: ibiz.env.appId,
          editable: !0,
          editorType: o,
          halign: "LEFT",
          id: e.key,
          valign: "MIDDLE",
          valueType: "SIMPLE",
          wrapMode: "NOWRAP"
        },
        enableCond: 3,
        id: e.key,
        labelPos: "LEFT",
        labelWidth: 130,
        layoutPos: { colMD: 24, layout: "TABLE_24COL", appId: ibiz.env.appId },
        noPrivDisplayMode: 1,
        showCaption: !0
      };
      return e.type === "picker" && (Object.assign(t.editor, {
        appCodeListId: e.codelistId,
        valueItemName: e.key
      }), e.codelistId && Object.assign(t.editor, {
        appCodeListId: e.codelistId
      })), t;
    });
    // 扩展属性
    b(this, "addAttributes", E([]));
    // 扩展属性模型
    b(this, "addAttributesFormDetail", []);
  }
  /**
   * 初始化方法
   *
   * @author lxm
   * @date 2022-08-22 22:08:16
   * @protected
   * @returns {*}  {Promise<void>}
   */
  async onCreated() {
    const e = JSON.parse(
      this.controlParams.jsonschemaparams || "{}"
    );
    this.jsonSchemaParams = N(
      e,
      this.params,
      this.context
    ), await this.initByEntitySchema(), this.model.deformPages && this.model.deformPages[0] && this.addAttributesFormDetail.forEach((o) => {
      var t;
      (t = this.model.deformPages[0].deformDetails) == null || t.push(o);
    }), await super.onCreated(), this.service = new R(this.model), await this.service.init(this.context), this.autoSave = K(this.autoSave.bind(this), 500, {
      trailing: !0
    });
  }
  async onMounted() {
    await super.onMounted(), !this.state.isSimple && this.state.loadDefault && this.load();
  }
  async calcColumnModelBySchema(e, o) {
    var y;
    if (!e.properties)
      return;
    const { properties: t } = e;
    if (!(Object.keys(t).length > 0))
      return;
    const p = {};
    (y = (await ibiz.hub.getAppDataEntity(
      o.model.appDataEntityId,
      o.model.appId
    )).appDEFields) == null || y.forEach((l) => {
      p[l.codeName.toLowerCase()] = l.id;
    });
    const g = [];
    return Object.keys(t).forEach((l) => {
      if (!p[l]) {
        let h;
        switch (t[l].type) {
          case "string":
            h = "string", t[l].format === "date-time" && (h = "date");
            break;
          case "integer":
            h = "integer";
            break;
          case "number":
            h = "number";
            break;
          default:
            ibiz.log.error(
              ibiz.i18n.t("runtime.controller.control.grid.unsupported", {
                type: t[l].type
              })
            );
            return;
        }
        g.push({
          key: l,
          description: t[l].description || t[l].key,
          type: h,
          ref: A({ isFocus: !0 }),
          codelistId: t[l].enumSource ? t[l].enumSource : ""
        });
      }
    }), g;
  }
  /**
   * 根据jsonschema初始化自定义表格列
   * @author lxm
   * @date 2024-01-02 04:41:23
   * @return {*}  {Promise<void>}
   */
  async initByEntitySchema() {
    const e = X(this.jsonSchemaParams);
    Object.assign(e, this.params);
    const o = await V(
      this.model.appDataEntityId,
      this.context,
      e
    );
    if (!o)
      return;
    const t = await this.calcColumnModelBySchema(o, this);
    t.length && (this.addAttributes.value = t, this.addAttributes.value.forEach((p) => {
      this.addAttributesFormDetail.push(this.calcFormDetail(p));
    }));
  }
}
const Q = /* @__PURE__ */ x({
  name: "AutoInput",
  props: {
    controller: {
      // eslint-disable-next-line @typescript-eslint/no-explicit-any
      type: Object,
      required: !0
    },
    item: {
      type: Object,
      required: !0
    },
    emit: {
      // eslint-disable-next-line @typescript-eslint/ban-types
      type: Object,
      required: !0
    }
  },
  setup(s) {
    const r = P("project-attributes-input"), e = s.controller, o = E(""), t = E(!1), p = E();
    C(() => e.state.data, (c) => {
      if (c)
        for (const m in c)
          e.addAttributes.find((a) => a.key === m) && (o.value = c[m]);
    }, {
      immediate: !0
    });
    const f = E(), g = (c) => {
      c.stopPropagation(), t.value = !0, q(() => {
        p.value && p.value.focus();
      });
    }, y = (c) => {
      c.stopPropagation(), t.value = !1;
    }, l = () => n("svg", {
      viewBox: "0 0 16 16",
      xmlns: "http://www.w3.org/2000/svg",
      height: "1em",
      width: "1em",
      preserveAspectRatio: "xMidYMid meet",
      focusable: "false"
    }, [n("g", {
      id: "aizaction/edit",
      "stroke-width": "1",
      "fill-rule": "evenodd"
    }, [n("path", {
      d: "M2 8.34L10.71 0 15 4.17 6.538 13H2V8.34zm1.2.512V11.8h2.826l7.283-7.6-2.606-2.533L3.2 8.852zM0 16v-1.2h16V16H0z",
      id: "aiz编辑"
    }, null)])]), h = (c) => {
      o.value = c.target.value;
      const m = e.formItems.find((i) => i.name === s.item.key);
      m && (c.target.value ? m.setDataValue(c.target.value, s.item.key) : m.setDataValue(null, s.item.key));
    };
    let I;
    return F(() => {
      f.value && (I = D(f, async (c) => {
        f.value && (t.value = !1);
      }));
    }), _(() => {
      I && I.stop && I.stop();
    }), {
      ns: r,
      c: e,
      startEdit: g,
      stopEdit: y,
      text: o,
      isEditing: t,
      change: h,
      componentRef: f,
      editSvg: l,
      inputRef: p
    };
  },
  render() {
    return n("div", {
      ref: "componentRef",
      class: [this.ns.b(), this.isEditing ? "edit" : ""]
    }, [this.isEditing ? n("input", {
      ref: "inputRef",
      type: "text",
      value: this.text,
      autofocus: !0,
      tabindex: "0",
      onChange: this.change,
      onBlur: (s) => this.stopEdit(s)
    }, null) : n("div", {
      class: this.ns.e("text"),
      onClick: (s) => this.startEdit(s)
    }, [this.text]), n("div", {
      class: this.ns.e("item-edit-svg"),
      onClick: (s) => this.startEdit(s)
    }, [this.editSvg()])]);
  }
}), k = /* @__PURE__ */ x({
  name: "IBizProjectAttributes",
  component: [Q],
  props: {
    modelData: {
      type: Object,
      required: !0
    },
    context: {
      type: Object,
      required: !0
    },
    params: {
      type: Object,
      default: () => ({})
    },
    provider: {
      type: Object
    },
    isSimple: {
      type: Boolean,
      required: !1
    },
    data: {
      type: Object,
      required: !1
    },
    loadDefault: {
      type: Boolean,
      default: !0
    }
  },
  setup(s, {
    emit: r
  }) {
    const e = P("project-attributes"), o = [], t = B((...i) => new G(...i), {
      excludePropsKeys: ["data"]
    }), p = W(() => t.context.srfreadonly === !0 || t.context.srfreadonly === "true");
    s.isSimple && (t.evt.on("onMounted", () => {
      t.setSimpleData(s.data || {});
    }), C(() => s.data, (i) => {
      const a = i || {};
      Object.keys(t.data).find((d) => a[d] !== t.data[d]) && t.setSimpleData(a);
    }, {
      deep: !0
    })), t.evt.on("onCreated", () => {
      Object.keys(t.details).forEach((a) => {
        const u = t.details[a];
        u.state = A(u.state);
      });
    });
    const f = (i, a, u) => {
      const d = u || a;
      t.setDataValue(d, i);
    }, g = (i) => t.formItems.find((a) => a.name === i.key), y = (i, a) => {
      let u = null;
      const d = {};
      if (i.type === "string" ? d.autofocus = !0 : i.type === "number" && (d.controlsPosition = "right", d.controls = !0), !a)
        return;
      const S = {
        value: a.value,
        data: a.data,
        controller: a.editor,
        disabled: a.state.disabled,
        readonly: i.ref.isFocus,
        onChange: (v, z) => f(v, i.key, z),
        controlParams: a.form.controlParams,
        onFocus: (v) => {
          a.onFocus(v);
        },
        onBlur: (v) => {
          a.onBlur(v);
        },
        onEnter: (v) => a.onEnter(v),
        ...d
      };
      let w = "";
      i.type === "string" ? w = "IBizInput" : i.type === "number" ? w = "IBizInputNumber" : i.type === "picker" ? w = "IBizDropdown" : i.type === "date" && (w = "IBizDatePicker");
      const j = U(w);
      return u = J(j, {
        ...S
      }), u;
    }, l = () => n("svg", {
      viewBox: "0 0 16 16",
      xmlns: "http://www.w3.org/2000/svg",
      height: "1em",
      width: "1em",
      preserveAspectRatio: "xMidYMid meet",
      focusable: "false"
    }, [n("g", {
      id: "aizaction/edit",
      "stroke-width": "1",
      "fill-rule": "evenodd"
    }, [n("path", {
      d: "M2 8.34L10.71 0 15 4.17 6.538 13H2V8.34zm1.2.512V11.8h2.826l7.283-7.6-2.606-2.533L3.2 8.852zM0 16v-1.2h16V16H0z",
      id: "aiz编辑"
    }, null)])]), h = E();
    return F(() => {
      D(h, async (i) => {
        if (i && i.target) {
          if (p.value || i.target.tagName.toLowerCase() === "input" || i.target.tagName.toLowerCase() === "svg" || i.target.className === "ibiz-dropdown-select-option-content" || i.target.className === "el-date-table-cell__text")
            return;
          let {
            id: a
          } = i.target.parentElement, u = t.addAttributes.value.find((d) => d.key === a);
          i.target.className === "ibiz-project-attributes__item-edit" && (a = i.target.id, u = t.addAttributes.value.find((d) => d.key === a)), u ? (t.addAttributes.value.forEach((d) => {
            d.ref.isFocus = !0;
          }), u.ref.isFocus = !1) : h.value.contains(i.target) || t.addAttributes.value.forEach((d) => {
            d.ref.isFocus = !0;
          });
        }
      });
    }), {
      c: t,
      ns: e,
      readonly: p,
      formItems: o,
      emit: r,
      renderEditor: y,
      editSvg: l,
      pxx: h,
      findController: g,
      startsWithHttpProtocol: (i) => /^(http:\/\/|https:\/\/)/.test(i),
      linkSvg: () => n("svg", {
        class: "icon",
        viewBox: "0 0 1024 1024",
        version: "1.1",
        xmlns: "http://www.w3.org/2000/svg",
        "p-id": "4033",
        height: "1em",
        width: "1em"
      }, [n("path", {
        d: "M832 128H640v64h146.752L521.376 457.376l45.248 45.248L832 237.248V384h64V128z",
        fill: "#181818",
        "p-id": "4034"
      }, null), n("path", {
        d: "M768 832H192V256h352v-64H160a32 32 0 0 0-32 32v640a32 32 0 0 0 32 32h640a32 32 0 0 0 32-32V480h-64v352z",
        fill: "#181818",
        "p-id": "4035"
      }, null)]),
      linkOpen: (i) => {
        window.open(i);
      }
    };
  },
  render() {
    return n("div", {
      class: this.ns.b()
    }, [this.c.addAttributes.value.length > 0 && this.c.addAttributes.value.map((s) => {
      const r = this.findController(s);
      let e = !1;
      return r && r.value && s.type === "string" && (e = this.startsWithHttpProtocol(r.value)), n("div", {
        class: [this.ns.e("item"), e ? "link" : ""]
      }, [n("div", {
        class: this.ns.e("item-text")
      }, [s.description]), n("div", {
        class: [this.ns.e("item-edit"), s.ref.isFocus ? "" : "edit"],
        id: s.key
      }, [this.renderEditor(s, r), !this.readonly && n("div", {
        class: this.ns.e("item-edit-svg")
      }, [this.editSvg()])]), e && s.ref.isFocus ? n("div", {
        class: this.ns.e("item-link-svg"),
        onClick: () => this.linkOpen(r.value),
        title: "打开链接"
      }, [this.linkSvg()]) : null]);
    }), n("div", {
      ref: "pxx"
    }, null)]);
  }
}), Z = L(
  k,
  // eslint-disable-next-line func-names
  function(s) {
    s.component(k.name, k), H(
      "EDITFORM_RENDER_PROJECT_ATTRIBUTES",
      () => new Y()
    );
  }
), nt = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(s) {
    s.use(Z);
  }
};
export {
  Z as IBizProjectAttributes,
  nt as default
};
