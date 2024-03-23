import './style.css';
var _ = Object.defineProperty;
var k = (n, o, r) => o in n ? _(n, o, { enumerable: !0, configurable: !0, writable: !0, value: r }) : n[o] = r;
var F = (n, o, r) => (k(n, typeof o != "symbol" ? o + "" : o, r), r);
import { useNamespace as T, useCtx as j, withInstall as $ } from "@ibiz-template/vue3-util";
import { FormMDCtrlRepeaterController as z, getDefaultValue as N, EditFormController as M, registerFormDetailProvider as q } from "@ibiz-template/runtime";
import { createUUID as C } from "qx-util";
import { defineComponent as P, createVNode as i, createTextVNode as A, resolveComponent as c, computed as U, reactive as L, watch as X, toRaw as H, h as J, isVNode as Q } from "vue";
import { recursiveIterate as W } from "@ibiz-template/core";
import B from "vuedraggable";
import { clone as Y } from "ramda";
class G extends z {
  constructor() {
    super(...arguments);
    /**
     * 分组判断标识
     *
     * @memberof RepeaterGridCaseStepsController
     */
    F(this, "groupField", "is_group");
    /**
     * 分组父标识
     *
     * @memberof RepeaterGridCaseStepsController
     */
    F(this, "parentField", "group_id");
    /**
     * 实体主键
     *
     * @memberof RepeaterGridCaseStepsController
     */
    F(this, "entityKey", "id");
    /**
     * 预置添加行为组
     *
     * @type {IData[]}
     * @memberof RepeaterGridCaseStepsController
     */
    F(this, "presetAddAction", [
      { text: "添加步骤", value: "addSteps", icon: "add-outline" },
      { text: "添加分组", value: "addGroup", icon: "menu-outline" }
    ]);
    /**
     * 预置分组行为
     *
     * @type {IData[]}
     * @memberof RepeaterGridCaseStepsController
     */
    F(this, "presetGroupActions", [
      {
        text: "向上添加步骤",
        value: "addTopStep",
        icon: "arrow-up-outline",
        allow: ["children"]
      },
      {
        text: "向下添加步骤",
        value: "addBottomStep",
        icon: "arrow-down-outline",
        allow: ["children"]
      },
      {
        text: "添加子步骤",
        value: "addChildrenStep",
        icon: "copy-outline",
        allow: ["group"]
      },
      {
        text: "复制",
        value: "copy",
        icon: "copy-outline",
        allow: ["group", "children"]
      },
      {
        text: "转换为分组",
        value: "transform",
        icon: "shuffle-outline",
        allow: []
      }
    ]);
  }
  /**
   * 处理添加行为组
   *
   * @param {string} value
   * @memberof RepeaterGridCaseStepsController
   */
  handleAddAction(r) {
    switch (r) {
      case "addSteps":
        this.create();
        break;
      case "addGroup":
        const e = C();
        this.insertValue({
          [this.groupField]: 1,
          [this.entityKey]: e
        }), this.insertValue({
          [this.parentField]: e,
          [this.entityKey]: C()
        });
        break;
    }
  }
  /**
   * 新建分组数据
   *
   * @memberof RepeaterGridCaseStepsController
   */
  insertValue(r, e) {
    let t = this.value;
    t = t ? [...t] : [], e !== void 0 ? t.splice(e, 0, r) : t.push(r), this.setValue(t);
  }
  /**
   * 获取分组行为
   *
   * @param {boolean} isGroup
   * @param {boolean} isChildren
   * @return {*}
   * @memberof RepeaterGridCaseStepsController
   */
  getActionsByType(r, e) {
    return r ? this.presetGroupActions.filter((t) => t.allow.includes("group")) : e ? this.presetGroupActions.filter((t) => t.allow.includes("children")) : this.presetGroupActions;
  }
  handleGroupAction(r) {
    const { actionType: e, index: t, row: u } = r;
    switch (e) {
      case "addTopStep":
        this.insertValue(
          {
            [this.parentField]: u[this.parentField],
            [this.groupField]: 0,
            [this.entityKey]: C()
          },
          t
        );
        break;
      case "addBottomStep":
        this.insertValue(
          {
            [this.parentField]: u[this.parentField],
            [this.groupField]: 0,
            [this.entityKey]: C()
          },
          t + 1
        );
        break;
      case "addChildrenStep":
        this.insertValue(
          {
            [this.parentField]: u[this.entityKey],
            [this.groupField]: 0,
            [this.entityKey]: C()
          },
          t + 1
        );
        break;
      case "copy":
        this.handleCopy(r);
        break;
      case "transform":
        const p = C(), l = [...this.value];
        l[t][this.groupField] = 1, l[t][this.entityKey] = p, l[t].name = l[t].description, delete l[t].description, l.splice(t + 1, 0, {
          [this.parentField]: l[t][this.entityKey],
          [this.groupField]: 0,
          [this.entityKey]: C()
        }), this.setValue(l);
        break;
    }
  }
  /**
   * 处理拷贝
   *
   * @param {IData} item
   * @memberof RepeaterGridCaseStepsController
   */
  handleCopy(r) {
    const { index: e, row: t } = r, u = C();
    if (t[this.groupField]) {
      const p = t[this.entityKey], l = [...this.value], g = l.filter((y) => Object.is(y[this.parentField], p)).map((y) => ({
        ...y,
        [this.parentField]: u,
        [this.entityKey]: C()
      }));
      l.splice(
        e + 1 + g.length,
        0,
        { ...t, [this.entityKey]: u },
        ...g
      ), this.setValue(l);
    } else
      this.insertValue({ ...t, [this.entityKey]: u }, e + 1);
  }
  /**
   * 新建行数据（重写）
   *
   * @param {number} [index]
   * @memberof RepeaterGridCaseStepsController
   */
  create(r) {
    const e = this.calcDefaultValue({});
    if (this.isSingleData)
      this.setValue(e);
    else {
      let t = this.value;
      t = t ? [...t] : [], r !== void 0 ? t.splice(r, 0, e) : t.push(e), this.setValue(t);
    }
  }
  /**
   * 自定义删除
   *
   * @param {number} [index]
   * @return {*}  {void}
   * @memberof RepeaterGridCaseStepsController
   */
  remove(r) {
    if (this.isSingleData) {
      this.setValue(null);
      return;
    }
    const e = [...this.value], t = e[r];
    if (t[this.groupField] == 1) {
      const u = e.filter(
        (p) => Object.is(p[this.parentField], t[this.entityKey])
      );
      e.splice(r, u.length + 1), this.setValue(e);
    } else {
      const u = this.value.filter((p, l) => r !== l);
      this.setValue(u);
    }
  }
  /**
   * 计算新建默认值
   *
   * @param {IData} data
   * @return {*}  {IData}
   * @memberof RepeaterGridCaseStepsController
   */
  calcDefaultValue(r) {
    const e = {}, t = this.model.deformDetails || [];
    return Object.values(t).forEach((u) => {
      const { createDV: p, createDVT: l } = u, g = N(
        {
          name: "",
          valueType: l,
          defaultValue: p,
          valueFormat: u.valueFormat
        },
        { data: r, context: this.context, params: this.params }
      );
      g !== void 0 && (e[u.codeName] = g);
    }), e;
  }
  /**
   * 批量操作列数据
   *
   * @param {string} name
   * @param {string} value
   * @memberof RepeaterGridCaseStepsController
   */
  batchSetColumnData(r, e) {
    const t = [...this.value];
    this.setValue(
      t.map((u) => Object.assign(u, { [r]: e }))
    );
  }
}
class Z {
  constructor() {
    F(this, "component", "IBizRepeaterGridCaseSteps");
  }
  async createController(o, r, e) {
    const t = new G(o, r, e);
    return await t.init(), t;
  }
}
const S = /* @__PURE__ */ P({
  name: "CaseStepsCell",
  props: {
    width: {
      type: Number
    },
    align: {
      validator: (n) => ["left", "center", "right"].includes(n)
    }
  },
  setup() {
    return {
      ns: T("case-steps-cell")
    };
  },
  render() {
    var n, o;
    return i("div", {
      class: [this.ns.b(), this.ns.is("center", this.align === "center"), this.ns.is("left", this.align === "left"), this.ns.is("right", this.align === "right")],
      style: {
        width: "".concat(this.width, "px")
      }
    }, [(o = (n = this.$slots).default) == null ? void 0 : o.call(n)]);
  }
});
const ee = /* @__PURE__ */ P({
  name: "CaseStepsTable",
  components: {
    draggable: B
  },
  props: {
    data: {
      type: Array,
      required: !0
    },
    model: {
      type: Object,
      required: !0
    },
    columns: {
      type: Array
    },
    indexProps: {
      type: Object
    },
    operationsProps: {
      type: Object
    }
  },
  emits: {
    dragChange: (n) => !0
  },
  setup(n, {
    emit: o,
    slots: r
  }) {
    const e = T("case-steps-table");
    return {
      ns: e,
      onChange: (p) => {
        const l = Y(n.data);
        if (p.moved) {
          const {
            oldIndex: g,
            newIndex: y
          } = p.moved, x = l[y], b = l.splice(g, 1);
          x.group_id ? b[0].group_id = x.group_id : delete b[0].group_id, l.splice(y, 0, ...b), o("dragChange", l);
        }
      },
      renderRows: (p, l) => {
        var g, y, x, b;
        return i("div", {
          class: [e.e("row"), e.is("group", p.is_group)],
          key: p.id
        }, [r.index && i(S, {
          class: e.em("cell", "index"),
          width: (g = n.indexProps) == null ? void 0 : g.width,
          align: (y = n.indexProps) == null ? void 0 : y.align
        }, {
          default: () => {
            var w;
            return [i(c("ion-icon"), {
              class: e.em("cell", "icon"),
              name: "menu-sharp"
            }, null), (w = r.index) == null ? void 0 : w.call(r, {
              $index: l
            })];
          }
        }), n.columns && n.columns.map((w) => {
          if (!w.hidden)
            return i(S, {
              key: p.id
            }, {
              default: () => {
                var V;
                return [(V = r[w.id]) == null ? void 0 : V.call(r, {
                  $index: l,
                  row: p
                })];
              }
            });
        }), r.operations && i(S, {
          class: e.em("cell", "operations"),
          width: (x = n.operationsProps) == null ? void 0 : x.width,
          align: (b = n.operationsProps) == null ? void 0 : b.align
        }, {
          default: () => {
            var w;
            return [(w = r.operations) == null ? void 0 : w.call(r, {
              $index: l,
              row: p
            })];
          }
        })]);
      }
    };
  },
  render() {
    var n, o, r, e;
    return i("div", {
      class: this.ns.b()
    }, [i("div", {
      class: this.ns.e("header")
    }, [i("div", {
      class: this.ns.e("row")
    }, [this.$slots.index && i(S, {
      class: this.ns.em("cell", "index"),
      width: (n = this.indexProps) == null ? void 0 : n.width,
      align: (o = this.indexProps) == null ? void 0 : o.align
    }, {
      default: () => [A("#")]
    }), this.columns && this.columns.map((t) => {
      if (!(t.hidden || !t.caption))
        return i(S, {
          align: "center"
        }, {
          default: () => [i("span", null, [t.caption])]
        });
    }), this.$slots.operations && i(S, {
      class: this.ns.em("cell", "operations"),
      width: (r = this.operationsProps) == null ? void 0 : r.width,
      align: (e = this.operationsProps) == null ? void 0 : e.align
    }, {
      default: () => [A("操作")]
    })])]), i("div", {
      class: this.ns.e("body")
    }, [i(B, {
      modelValue: this.data,
      itemKey: "step_id",
      "ghost-class": this.ns.em("row", "ghost"),
      "drag-class": this.ns.em("row", "drag"),
      "chosen-class": this.ns.em("row", "chosen"),
      "force-fallback": !0,
      handle: ".".concat(this.ns.em("cell", "icon")),
      onChange: (t) => this.onChange(t)
    }, {
      item: ({
        element: t,
        index: u
      }) => this.renderRows(t, u)
    })])]);
  }
});
function K(n) {
  return typeof n == "function" || Object.prototype.toString.call(n) === "[object Object]" && !Q(n);
}
const R = /* @__PURE__ */ P({
  name: "IBizRepeaterGridCaseSteps",
  props: {
    controller: {
      type: G,
      required: !0
    }
  },
  emits: {
    change: (n) => !0
  },
  setup(n) {
    const o = T("repeater-grid"), r = [], e = n.controller, t = U(() => {
      const s = [];
      let a = 0, d = 0;
      return e.value && e.value.forEach((f, v) => {
        f[e.groupField] || !v || !f[e.parentField] ? (a++, d = 0, s.push("".concat(a))) : (d++, s.push("".concat(a, ".").concat(d)));
      }), s;
    });
    W(n.controller.repeatedForm, (s) => {
      s.detailType === "FORMITEM" && r.push(s);
    }, {
      childrenFields: ["deformPages", "deformTabPages", "deformDetails"]
    });
    const u = (s, a) => {
      const d = [...n.controller.value];
      d[a] = s, e.setValue(d);
    }, p = j(), l = L([]), g = async (s, a = {}) => {
      const d = new M(n.controller.repeatedForm, n.controller.context, n.controller.params, p);
      d.state.isSimple = !0, await d.created(), d.setSimpleData(a), l.splice(s, 0, d), d.evt.on("onFormDataChange", (f) => {
        const v = {
          ...f.data[0]
        }, h = x(d);
        u(v, h);
      });
    }, y = (s) => {
      const a = s[e.entityKey];
      return l.find((d) => d.state.data[e.entityKey] === a);
    }, x = (s) => (n.controller.value || []).findIndex((d) => s.state.data[e.entityKey] === d[e.entityKey]);
    X(() => n.controller.value, (s) => {
      s && s.length > 0 && s.forEach((a, d) => {
        const f = y(a);
        if (f) {
          const v = a || {};
          Object.keys(f.data).find((m) => v[m] !== f.data[m]) && f.setSimpleData(v);
        } else
          g(d, a);
      });
    }, {
      immediate: !0,
      deep: !0
    });
    const b = (s) => n.controller.enableDelete ? ibiz.config.form.mdCtrlConfirmBeforeRemove ? i(c("el-popconfirm"), {
      title: "是否删除选中项",
      "confirm-button-text": "确认",
      "cancel-button-text": "取消",
      onConfirm: () => n.controller.remove(s)
    }, {
      reference: () => i(c("el-button"), {
        text: !0,
        class: [o.be("index", "remove")]
      }, {
        default: () => [i(c("ion-icon"), {
          name: "trash-outline"
        }, null)]
      })
    }) : i(c("el-button"), {
      text: !0,
      class: [o.be("index", "remove")],
      onClick: () => n.controller.remove(s)
    }, {
      default: () => [i(c("ion-icon"), {
        name: "trash-outline"
      }, null)]
    }) : null, w = () => e.enableCreate ? i("div", {
      class: o.e("add-row")
    }, [i(c("ion-icon"), {
      class: o.e("add-icon"),
      name: "add-outline"
    }, null), i(c("el-dropdown"), {
      "popper-class": o.e("add-dropdown"),
      trigger: "click",
      "split-button": !0,
      type: "text",
      onCommand: (s) => {
        e.handleAddAction(s);
      },
      onClick: () => {
        e.create();
      }
    }, {
      default: () => i(c("el-button"), {
        class: o.e("add-btn"),
        text: !0
      }, {
        default: () => [A("添加步骤")]
      }),
      dropdown: () => {
        let s;
        return i(c("el-dropdown-menu"), null, K(s = e.presetAddAction.map((a) => i(c("el-dropdown-item"), {
          command: a.value
        }, {
          default: () => [i(c("ion-icon"), {
            class: o.e("add-dropdown-icon"),
            name: a.icon
          }, null), a.text]
        }))) ? s : {
          default: () => [s]
        });
      }
    })]) : null, V = (s) => {
      if (!e.enableCreate)
        return null;
      const {
        row: a,
        $index: d
      } = s, f = a[e.groupField] == 1, v = !!a[e.parentField], h = e.getActionsByType(f, v) || [];
      return i(c("el-dropdown"), {
        "popper-class": o.be("action", "group"),
        trigger: "click",
        type: "text",
        onCommand: (m) => {
          e.handleGroupAction(m);
        }
      }, {
        default: () => i(c("el-button"), {
          text: !0
        }, {
          default: () => [i(c("ion-icon"), {
            name: "ellipsis-vertical-sharp"
          }, null)]
        }),
        dropdown: () => {
          let m;
          return i(c("el-dropdown-menu"), null, K(m = h.map((D) => i(c("el-dropdown-item"), {
            command: {
              actionType: D.value,
              index: d,
              row: a
            }
          }, {
            default: () => [i(c("ion-icon"), {
              class: o.e("add-dropdown-icon"),
              name: D.icon
            }, null), D.text]
          }))) ? m : {
            default: () => [m]
          });
        }
      });
    }, I = (s) => {
      const {
        editor: a
      } = s;
      return i(c("el-input"), {
        clearable: !0,
        "model-value": s.value,
        placeholder: a == null ? void 0 : a.model.placeHolder,
        type: "textarea",
        resize: "none",
        autosize: !0,
        onInput: (d) => {
          s.setDataValue(d);
        },
        class: o.b("input"),
        disabled: s.state.disabled
      }, null);
    };
    return {
      c: e,
      ns: o,
      formItems: r,
      formControllers: l,
      indexMap: t,
      renderRemoveBtn: b,
      renderAddRow: w,
      renderActions: V,
      renderContent: () => {
        const s = {};
        return r.forEach((a) => {
          a.hidden || (s[a.id] = (d) => {
            const {
              row: f
            } = d, v = H(y(f));
            if (!v || !v.state.isLoaded)
              return i("div", null, [A("不存在或加载中")]);
            const h = v.formItems.find((D) => D.name === a.id);
            if (!h.state.visible)
              return null;
            let m = null;
            if (!h.editorProvider)
              m = i(c("not-supported-editor"), {
                modelData: a.editor
              }, null);
            else if (a.editor && a.editor.editorType === "TEXTBOX")
              m = I(h);
            else {
              const D = c(h.editorProvider.formEditor);
              m = J(D, {
                value: h.value,
                data: h.data,
                controller: h.editor,
                disabled: h.state.disabled,
                readonly: h.model.editor.readOnly,
                onChange: (E, O) => {
                  h.setDataValue(E, O);
                }
              });
            }
            return i(c("iBizGridEditItem"), {
              class: [...h.containerClass],
              error: h.state.error,
              required: h.state.required
            }, K(m) ? m : {
              default: () => [m]
            });
          });
        }), s;
      }
    };
  },
  render() {
    return i("div", {
      class: [this.ns.b(), this.ns.is("case-steps", !0)]
    }, [i(ee, {
      class: [this.ns.e("table"), this.ns.is("disabled", !this.controller.enableCreate && !this.controller.enableDelete)],
      model: this.c.model,
      data: this.controller.value,
      columns: this.formItems,
      indexProps: {
        width: 66,
        align: "center"
      },
      operationsProps: {
        width: 120,
        align: "center"
      },
      onDragChange: (n) => this.c.setValue(n)
    }, {
      index: (n) => {
        const {
          $index: o
        } = n;
        return i("span", null, [this.indexMap[o]]);
      },
      operations: (n) => {
        if (!this.controller.enableCreate && !this.controller.enableDelete)
          return null;
        const {
          $index: o
        } = n;
        return [this.renderRemoveBtn(o), this.renderActions(n)];
      },
      ...this.renderContent()
    }), this.renderAddRow()]);
  }
}), te = $(
  R,
  function(n) {
    n.component(R.name, R), q(
      "FORM_USERCONTROL_CASE_STEPS",
      () => new Z()
    );
  }
), ce = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(n) {
    n.use(te);
  }
};
export {
  te as IBizRepeaterGridCaseSteps,
  ce as default
};
