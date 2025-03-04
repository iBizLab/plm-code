import './style.css';
var N = Object.defineProperty;
var z = (r, a, t) => a in r ? N(r, a, { enumerable: !0, configurable: !0, writable: !0, value: t }) : r[a] = t;
var S = (r, a, t) => (z(r, typeof a != "symbol" ? a + "" : a, t), t);
import { useNamespace as T, useCtx as M, withInstall as q } from "@ibiz-template/vue3-util";
import { FormMDCtrlRepeaterController as U, isValueChange as O, getDefaultValue as L, EditFormController as X, FormDetailEventName as H, registerFormDetailProvider as J } from "@ibiz-template/runtime";
import { debounce as Q } from "lodash-es";
import { createUUID as b } from "qx-util";
import { defineComponent as I, createVNode as i, createTextVNode as E, resolveComponent as h, getCurrentInstance as W, computed as Y, reactive as Z, watch as ee, toRaw as te, h as ne, isVNode as re } from "vue";
import { recursiveIterate as ie } from "@ibiz-template/core";
import G from "vuedraggable";
import { clone as se } from "ramda";
class _ extends U {
  constructor() {
    super(...arguments);
    /**
     * 分组判断标识
     *
     * @memberof RepeaterGridCaseStepsController
     */
    S(this, "groupField", "is_group");
    /**
     * 分组父标识
     *
     * @memberof RepeaterGridCaseStepsController
     */
    S(this, "parentField", "group_id");
    /**
     * 实体主键
     *
     * @memberof RepeaterGridCaseStepsController
     */
    S(this, "entityKey", "id");
    /**
     * 预置添加行为组
     *
     * @type {IData[]}
     * @memberof RepeaterGridCaseStepsController
     */
    S(this, "presetAddAction", [
      { text: "添加步骤", value: "addSteps", icon: "add-outline" },
      { text: "添加分组", value: "addGroup", icon: "menu-outline" }
    ]);
    /**
     * 预置分组行为
     *
     * @type {IData[]}
     * @memberof RepeaterGridCaseStepsController
     */
    S(this, "presetGroupActions", [
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
  async onInit() {
    await super.onInit(), this.form.evt.on("onSaveSuccess", async () => {
      if (this.data.updatedate) {
        const e = this.data.updatedate[this.name];
        O(e, this.value) && this.saveCaseSteps();
      }
    }), this.saveCaseSteps = Q(this.saveCaseSteps.bind(this), 1e3, {
      trailing: !0
    });
  }
  async saveCaseSteps() {
    if (!this.form.model.enableAutoSave)
      return;
    const t = {
      silent: !0,
      noFillBack: !0,
      silentVerify: !0
    };
    this.form.save(t);
  }
  /**
   * @description 重写setValue，防止抖动
   * @param {(IData[] | IData | null)} value
   * @memberof RepeaterGridCaseStepsController
   */
  async setValue(t) {
    if (Object.prototype.hasOwnProperty.call(this.form.state.data, this.name) && !O(this.form.state.data[this.name], t))
      return;
    const e = this.form.state.data[this.name];
    this.form.state.data[this.name] = t, this.form.state.modified = !0, await this.form.evt.emit("onFormDataChange", {
      name: this.name,
      value: t,
      oldValue: e
    }), this.saveCaseSteps();
  }
  /**
   * 处理添加行为组
   *
   * @param {string} value
   * @memberof RepeaterGridCaseStepsController
   */
  handleAddAction(t) {
    switch (t) {
      case "addSteps":
        this.create();
        break;
      case "addGroup":
        const e = b();
        this.insertValue({
          [this.groupField]: 1,
          [this.entityKey]: e
        }), this.insertValue({
          [this.parentField]: e,
          [this.entityKey]: b()
        });
        break;
    }
  }
  /**
   * 新建分组数据
   *
   * @memberof RepeaterGridCaseStepsController
   */
  insertValue(t, e) {
    let n = this.value;
    n = n ? [...n] : [], e !== void 0 ? n.splice(e, 0, t) : n.push(t), this.setValue(n);
  }
  /**
   * 获取分组行为
   *
   * @param {boolean} isGroup
   * @param {boolean} isChildren
   * @return {*}
   * @memberof RepeaterGridCaseStepsController
   */
  getActionsByType(t, e) {
    return t ? this.presetGroupActions.filter((n) => n.allow.includes("group")) : e ? this.presetGroupActions.filter((n) => n.allow.includes("children")) : this.presetGroupActions;
  }
  handleGroupAction(t) {
    const { actionType: e, index: n, row: u } = t;
    switch (e) {
      case "addTopStep":
        this.insertValue(
          {
            [this.parentField]: u[this.parentField],
            [this.groupField]: 0,
            [this.entityKey]: b()
          },
          n
        );
        break;
      case "addBottomStep":
        this.insertValue(
          {
            [this.parentField]: u[this.parentField],
            [this.groupField]: 0,
            [this.entityKey]: b()
          },
          n + 1
        );
        break;
      case "addChildrenStep":
        this.insertValue(
          {
            [this.parentField]: u[this.entityKey],
            [this.groupField]: 0,
            [this.entityKey]: b()
          },
          n + 1
        );
        break;
      case "copy":
        this.handleCopy(t);
        break;
      case "transform":
        const c = b(), l = [...this.value];
        l[n][this.groupField] = 1, l[n][this.entityKey] = c, l[n].name = l[n].description, delete l[n].description, l.splice(n + 1, 0, {
          [this.parentField]: l[n][this.entityKey],
          [this.groupField]: 0,
          [this.entityKey]: b()
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
  handleCopy(t) {
    const { index: e, row: n } = t, u = b();
    if (n[this.groupField]) {
      const c = n[this.entityKey], l = [...this.value], f = l.filter((v) => Object.is(v[this.parentField], c)).map((v) => ({
        ...v,
        [this.parentField]: u,
        [this.entityKey]: b()
      }));
      l.splice(
        e + 1 + f.length,
        0,
        { ...n, [this.entityKey]: u },
        ...f
      ), this.setValue(l);
    } else
      this.insertValue({ ...n, [this.entityKey]: u }, e + 1);
  }
  /**
   * 新建行数据（重写）
   *
   * @param {number} [index]
   * @memberof RepeaterGridCaseStepsController
   */
  create(t) {
    const e = this.calcDefaultValue({});
    if (this.isSingleData)
      this.setValue(e);
    else {
      let n = this.value;
      n = n ? [...n] : [], t !== void 0 ? n.splice(t, 0, e) : n.push(e), this.setValue(n);
    }
  }
  /**
   * 自定义删除
   *
   * @param {number} [index]
   * @return {*}  {void}
   * @memberof RepeaterGridCaseStepsController
   */
  remove(t) {
    if (this.isSingleData) {
      this.setValue(null);
      return;
    }
    const e = [...this.value], n = e[t];
    if (n[this.groupField] == 1) {
      const u = e.filter(
        (c) => Object.is(c[this.parentField], n[this.entityKey])
      );
      e.splice(t, u.length + 1), this.setValue(e);
    } else {
      const u = this.value.filter((c, l) => t !== l);
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
  calcDefaultValue(t) {
    const e = {
      [this.entityKey]: b()
    }, n = this.model.deformDetails || [];
    return Object.values(n).forEach((u) => {
      const { createDV: c, createDVT: l } = u, f = L(
        {
          name: "",
          valueType: l,
          defaultValue: c,
          valueFormat: u.valueFormat
        },
        { data: t, context: this.context, params: this.params }
      );
      f !== void 0 && (e[u.codeName] = f);
    }), e;
  }
  /**
   * 批量操作列数据
   *
   * @param {string} name
   * @param {string} value
   * @memberof RepeaterGridCaseStepsController
   */
  batchSetColumnData(t, e) {
    const n = [...this.value];
    this.setValue(
      n.map((u) => Object.assign(u, { [t]: e }))
    );
  }
}
class ae {
  constructor() {
    S(this, "component", "IBizRepeaterGridCaseSteps");
  }
  async createController(a, t, e) {
    const n = new _(a, t, e);
    return await n.init(), n;
  }
}
const A = /* @__PURE__ */ I({
  name: "CaseStepsCell",
  props: {
    width: {
      type: Number
    },
    align: {
      validator: (r) => ["left", "center", "right"].includes(r)
    }
  },
  setup() {
    return {
      ns: T("case-steps-cell")
    };
  },
  render() {
    var r, a;
    return i("div", {
      class: [this.ns.b(), this.ns.is("center", this.align === "center"), this.ns.is("left", this.align === "left"), this.ns.is("right", this.align === "right")],
      style: {
        width: "".concat(this.width, "px")
      }
    }, [(a = (r = this.$slots).default) == null ? void 0 : a.call(r)]);
  }
});
const oe = /* @__PURE__ */ I({
  name: "CaseStepsTable",
  components: {
    draggable: G
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
    dragChange: (r) => !0
  },
  setup(r, {
    emit: a,
    slots: t
  }) {
    const e = T("case-steps-table");
    return {
      ns: e,
      onChange: (c) => {
        const l = se(r.data);
        if (c.moved) {
          const {
            oldIndex: f,
            newIndex: v
          } = c.moved, F = l[v], x = l.splice(f, 1);
          F.group_id ? x[0].group_id = F.group_id : delete x[0].group_id, l.splice(v, 0, ...x), a("dragChange", l);
        }
      },
      renderRows: (c, l) => {
        var f, v, F, x;
        return i("div", {
          class: [e.e("row"), e.is("group", c.is_group)],
          key: c.id
        }, [t.index && i(A, {
          class: e.em("cell", "index"),
          width: (f = r.indexProps) == null ? void 0 : f.width,
          align: (v = r.indexProps) == null ? void 0 : v.align
        }, {
          default: () => {
            var w;
            return [i(h("ion-icon"), {
              class: e.em("cell", "icon"),
              name: "menu-sharp"
            }, null), (w = t.index) == null ? void 0 : w.call(t, {
              $index: l
            })];
          }
        }), r.columns && r.columns.map((w) => {
          if (!w.hidden)
            return i(A, {
              key: c.id
            }, {
              default: () => {
                var B;
                return [(B = t[w.id]) == null ? void 0 : B.call(t, {
                  $index: l,
                  row: c
                })];
              }
            });
        }), t.operations && i(A, {
          class: e.em("cell", "operations"),
          width: (F = r.operationsProps) == null ? void 0 : F.width,
          align: (x = r.operationsProps) == null ? void 0 : x.align
        }, {
          default: () => {
            var w;
            return [(w = t.operations) == null ? void 0 : w.call(t, {
              $index: l,
              row: c
            })];
          }
        })]);
      }
    };
  },
  render() {
    var r, a, t, e;
    return i("div", {
      class: this.ns.b()
    }, [i("div", {
      class: this.ns.e("header")
    }, [i("div", {
      class: this.ns.e("row")
    }, [this.$slots.index && i(A, {
      class: this.ns.em("cell", "index"),
      width: (r = this.indexProps) == null ? void 0 : r.width,
      align: (a = this.indexProps) == null ? void 0 : a.align
    }, {
      default: () => [E("#")]
    }), this.columns && this.columns.map((n) => {
      if (n.hidden || !n.caption)
        return;
      const {
        width: u
      } = n, c = {};
      return u && (c.width = "".concat(u, "px"), c.flex = "none"), i(A, {
        style: c,
        align: "center"
      }, {
        default: () => [i("span", null, [n.caption])]
      });
    }), this.$slots.operations && i(A, {
      class: this.ns.em("cell", "operations"),
      width: (t = this.operationsProps) == null ? void 0 : t.width,
      align: (e = this.operationsProps) == null ? void 0 : e.align
    }, {
      default: () => [E("操作")]
    })])]), i("div", {
      class: this.ns.e("body")
    }, [i(G, {
      modelValue: this.data,
      itemKey: "step_id",
      "ghost-class": this.ns.em("row", "ghost"),
      "drag-class": this.ns.em("row", "drag"),
      "chosen-class": this.ns.em("row", "chosen"),
      "force-fallback": !0,
      handle: ".".concat(this.ns.em("cell", "icon")),
      onChange: (n) => this.onChange(n)
    }, {
      item: ({
        element: n,
        index: u
      }) => this.renderRows(n, u)
    })])]);
  }
});
function P(r) {
  return typeof r == "function" || Object.prototype.toString.call(r) === "[object Object]" && !re(r);
}
const R = /* @__PURE__ */ I({
  name: "IBizRepeaterGridCaseSteps",
  props: {
    controller: {
      type: _,
      required: !0
    }
  },
  emits: {
    change: (r) => !0
  },
  setup(r) {
    const a = T("repeater-grid"), t = [], e = r.controller, n = W().proxy, u = Y(() => {
      const s = [];
      let o = 0, d = 0;
      return e.value && e.value.forEach((m, g) => {
        m[e.groupField] || !g || !m[e.parentField] ? (o++, d = 0, s.push("".concat(o))) : (d++, s.push("".concat(o, ".").concat(d)));
      }), s;
    });
    ie(r.controller.repeatedForm, (s) => {
      s.detailType === "FORMITEM" && t.push(s);
    }, {
      childrenFields: ["deformPages", "deformTabPages", "deformDetails"]
    });
    const c = (s, o) => {
      [...r.controller.value], n.$forceUpdate();
    }, l = M(), f = Z([]), v = async (s, o = {}) => {
      const d = new X(r.controller.repeatedForm, r.controller.context, r.controller.params, l);
      d.state.isSimple = !0, await d.created(), d.setSimpleData(o), f.splice(s, 0, d), d.evt.on("onFormDataChange", (m) => {
        ({
          ...m.data[0]
        }, x(d)), c();
      }), d.evt.on("onFormDetailEvent", (m) => {
        const {
          formDetailEventName: g
        } = m;
        if (g === H.BLUR) {
          const p = {
            ...m.data[0]
          }, y = x(d), C = [...r.controller.value];
          C[y] = p, e.setValue(C);
        }
      });
    }, F = (s) => {
      const o = s[e.entityKey];
      return f.find((d) => d.state.data[e.entityKey] === o);
    }, x = (s) => (r.controller.value || []).findIndex((d) => s.state.data[e.entityKey] === d[e.entityKey]);
    ee(() => r.controller.value, (s) => {
      s && s.length > 0 && s.forEach((o, d) => {
        const m = F(o);
        if (m) {
          const g = o || {};
          Object.keys(m.data).find((y) => g[y] !== m.data[y]) && m.setSimpleData(g);
        } else
          v(d, o);
      });
    }, {
      immediate: !0,
      deep: !0
    });
    const w = (s) => r.controller.enableDelete ? ibiz.config.form.mdCtrlConfirmBeforeRemove ? i(h("el-popconfirm"), {
      title: "是否删除选中项",
      "confirm-button-text": "确认",
      "cancel-button-text": "取消",
      onConfirm: () => r.controller.remove(s)
    }, {
      reference: () => i(h("el-button"), {
        text: !0,
        class: [a.be("index", "remove")]
      }, {
        default: () => [i(h("ion-icon"), {
          name: "trash-outline"
        }, null)]
      })
    }) : i(h("el-button"), {
      text: !0,
      class: [a.be("index", "remove")],
      onClick: () => r.controller.remove(s)
    }, {
      default: () => [i(h("ion-icon"), {
        name: "trash-outline"
      }, null)]
    }) : null, B = () => e.enableCreate ? i("div", {
      class: a.e("add-row")
    }, [i(h("ion-icon"), {
      class: a.e("add-icon"),
      name: "add-outline"
    }, null), i(h("el-dropdown"), {
      "popper-class": a.e("add-dropdown"),
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
      default: () => i(h("el-button"), {
        class: a.e("add-btn"),
        text: !0
      }, {
        default: () => [E("添加步骤")]
      }),
      dropdown: () => {
        let s;
        return i(h("el-dropdown-menu"), null, P(s = e.presetAddAction.map((o) => i(h("el-dropdown-item"), {
          command: o.value
        }, {
          default: () => [i(h("ion-icon"), {
            class: a.e("add-dropdown-icon"),
            name: o.icon
          }, null), o.text]
        }))) ? s : {
          default: () => [s]
        });
      }
    })]) : null, k = (s) => {
      if (!e.enableCreate)
        return null;
      const {
        row: o,
        $index: d
      } = s, m = o[e.groupField] == 1, g = !!o[e.parentField], p = e.getActionsByType(m, g) || [];
      return i(h("el-dropdown"), {
        "popper-class": a.be("action", "group"),
        trigger: "click",
        type: "text",
        onCommand: (y) => {
          e.handleGroupAction(y);
        }
      }, {
        default: () => i(h("el-button"), {
          text: !0
        }, {
          default: () => [i(h("ion-icon"), {
            name: "ellipsis-vertical-sharp"
          }, null)]
        }),
        dropdown: () => {
          let y;
          return i(h("el-dropdown-menu"), null, P(y = p.map((C) => i(h("el-dropdown-item"), {
            command: {
              actionType: C.value,
              index: d,
              row: o
            }
          }, {
            default: () => [i(h("ion-icon"), {
              class: a.e("add-dropdown-icon"),
              name: C.icon
            }, null), C.text]
          }))) ? y : {
            default: () => [y]
          });
        }
      });
    }, j = (s) => {
      const {
        editor: o
      } = s;
      return i(h("el-input"), {
        clearable: !0,
        "model-value": s.value,
        placeholder: o == null ? void 0 : o.model.placeHolder,
        type: "textarea",
        resize: "none",
        autosize: !0,
        onInput: (d) => {
          s.setDataValue(d);
        },
        onBlur: (d) => {
          s.onBlur(d);
        },
        class: a.b("input"),
        disabled: s.state.disabled
      }, null);
    };
    return {
      c: e,
      ns: a,
      formItems: t,
      formControllers: f,
      indexMap: u,
      renderRemoveBtn: w,
      renderAddRow: B,
      renderActions: k,
      renderContent: () => {
        const s = {};
        return t.forEach((o) => {
          o.hidden || (s[o.id] = (d) => {
            const {
              row: m
            } = d, g = te(F(m));
            if (!g || !g.state.isLoaded)
              return i("div", null, [E("不存在或加载中")]);
            const p = g.formItems.find((K) => K.name === o.id);
            if (!p.state.visible)
              return null;
            const {
              width: y
            } = p.model, C = {};
            y && (C.width = "".concat(y, "px"), C.flex = "none");
            let V = null;
            if (!p.editorProvider)
              V = i(h("not-supported-editor"), {
                modelData: o.editor
              }, null);
            else if (o.editor && o.editor.editorType === "TEXTBOX")
              V = j(p);
            else {
              const K = h(p.editorProvider.formEditor);
              V = ne(K, {
                value: p.value,
                data: p.data,
                controller: p.editor,
                disabled: p.state.disabled,
                readonly: p.model.editor.readOnly,
                onChange: (D, $) => {
                  p.setDataValue(D, $);
                },
                onBlur: (D) => p.onBlur(D),
                onFocus: (D) => p.onFocus(D),
                onEnter: (D) => p.onEnter(D)
              });
            }
            return i(h("iBizGridEditItem"), {
              style: C,
              class: [...p.containerClass],
              error: p.state.error,
              required: p.state.required
            }, P(V) ? V : {
              default: () => [V]
            });
          });
        }), s;
      }
    };
  },
  render() {
    return i("div", {
      class: [this.ns.b(), this.ns.is("case-steps", !0)]
    }, [i(oe, {
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
      onDragChange: (r) => this.c.setValue(r)
    }, {
      index: (r) => {
        const {
          $index: a
        } = r;
        return i("span", null, [this.indexMap[a]]);
      },
      operations: (r) => {
        if (!this.controller.enableCreate && !this.controller.enableDelete)
          return null;
        const {
          $index: a
        } = r;
        return [this.renderRemoveBtn(a), this.renderActions(r)];
      },
      ...this.renderContent()
    }), this.renderAddRow()]);
  }
}), le = q(
  R,
  function(r) {
    r.component(R.name, R), J(
      "FORM_USERCONTROL_CASE_STEPS",
      () => new ae()
    );
  }
), we = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(r) {
    r.use(le);
  }
};
export {
  le as IBizRepeaterGridCaseSteps,
  we as default
};
