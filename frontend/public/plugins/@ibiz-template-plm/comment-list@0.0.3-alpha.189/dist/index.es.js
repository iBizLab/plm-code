import './style.css';
var O = Object.defineProperty;
var N = (n, r, t) => r in n ? O(n, r, { enumerable: !0, configurable: !0, writable: !0, value: t }) : n[r] = t;
var p = (n, r, t) => (N(n, typeof r != "symbol" ? r + "" : r, t), t);
import { EditorController as S, ControllerEvent as T, registerEditorProvider as M } from "@ibiz-template/runtime";
import { defineComponent as j, ref as C, watch as F, onBeforeUnmount as z, createVNode as l, resolveComponent as $ } from "vue";
import { getInputProps as U, getEditorEmits as _, useNamespace as Z } from "@ibiz-template/vue3-util";
const H = () => {
  const n = document.documentElement;
  return n ? getComputedStyle(n).getPropertyValue("--ibiz-color-primary") : null;
}, B = (n) => /[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(n), R = (n) => /[\u4E00-\u9FA5]/.test(n), W = (n) => {
  if (!n)
    return "";
  let r = 0;
  for (let u = 0; u < n.length; u++)
    if (R(n))
      r = n.charCodeAt(u) + ((r << 5) - r), r = r & r;
    else {
      const g = n.charCodeAt(u);
      r += g.toString(16);
    }
  const t = String(r).substring(0, 6);
  let e = parseInt(t.substring(0, 2), 16), a = parseInt(t.substring(2, 4), 16), i = parseInt(t.substring(4, 6), 16);
  e < 0 && (e = 10), a < 0 && (a = 10), i < 0 && (i = 10);
  const m = "#".concat(e.toString(16).padStart(2, "0")).concat(a.toString(16).padStart(2, "0")).concat(i.toString(16).padStart(2, "0")).replaceAll("-", "0");
  return m === "#FFFFFF" && H() || m;
}, x = (n) => {
  if (n && n.toString().length < 2)
    return n;
  if (n && n.toString().length >= 2) {
    if (B(n)) {
      const a = n.split("").find((m) => /[a-zA-Z]/.test(m)) || "", i = n.split("").find((m) => /[\u4E00-\u9FA5]/.test(m)) || "";
      return "".concat(a).concat(i).toLowerCase();
    }
    return /[a-zA-Z]/.test(n) ? n.split("").filter((a) => /[a-zA-Z]/.test(a)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(n) ? n.split("").filter((a) => /[\u4E00-\u9FA5]/.test(a)).slice(-2).join("") : n.replaceAll(" ", "").substring(0, 2);
  }
};
const b = /* @__PURE__ */ j({
  name: "CommentList",
  props: {
    ...U(),
    value: {
      type: Array,
      default: () => []
    }
  },
  emits: _(),
  setup(n) {
    const r = Z("comment-list"), t = n.controller, e = C([]), a = C([]);
    F(() => n.value, async (s) => {
      if (t.isLocal) {
        e.value = [];
        const c = await t.getLocalTempData();
        if (c) {
          const o = await c.fetchDefault(t.context);
          o.data && Array.isArray(o.data) && (e.value = o.data);
        }
      } else
        s ? Array.isArray(s) ? e.value = [...s] : e.value = [] : e.value = [];
    }, {
      immediate: !0,
      deep: !0
    });
    const i = (s) => {
      const {
        eventArg: c
      } = s;
      if (c) {
        const o = e.value.findIndex((d) => d.id === c);
        o >= 0 && e.value.splice(o, 1);
      }
    }, m = (s) => {
      e.value.push(s.eventArg);
    }, u = (s) => {
      const c = e.value.findIndex((o) => o.id === s.id);
      c > -1 && e.value.splice(c, 1, s);
    };
    t.evt.on("deleteItem", i), t.evt.on("addItem", m), t.evt.on("editreply", u);
    const g = async (s) => {
      t.deleteComment(s);
    }, L = (s) => {
      console.log("头像加载失败"), a.value.push(s);
    }, A = (s) => {
      if (!s)
        return null;
      const c = JSON.parse(s);
      if (c.length === 0)
        return null;
      const {
        downloadUrl: o
      } = ibiz.util.file.calcFileUpDownUrl(t.context, t.params, n.data, t.editorParams), d = o.replace("%fileId%", c[0].id);
      return l("img", {
        src: d,
        onError: () => L(s),
        alt: ""
      }, null);
    }, y = (s) => {
      const c = t.operatorMap.get(s);
      let o, d = s;
      if (c) {
        const {
          label: h,
          iconurl: f
        } = c.data;
        d = h, f ? o = A(f) : o = x(h);
      } else
        o = x(s);
      return l("div", {
        class: r.em("item", "avatar")
      }, [l("div", {
        class: r.em("item", "img"),
        style: "background-color:".concat(W(d))
      }, [o]), l("div", {
        class: r.em("item", "label")
      }, [d])]);
    }, E = (s) => {
      const c = s.split(" ");
      if (c.length === 2) {
        const o = c[0].split("-"), d = /* @__PURE__ */ new Date(), h = d.getFullYear() - Number(o[0]), f = d.getMonth() + 1 - Number(o[1]), v = d.getDate() - Number(o[2]);
        if (h === 0) {
          if (f === 0) {
            if (v === 0)
              return "今天 ".concat(s.slice(11, -3));
            if (v === 1)
              return "昨天 ".concat(s.slice(11, -3));
            if (v === 2)
              return "前天 ".concat(s.slice(11, -3));
          }
          return s.slice(5, -3);
        }
        return s.slice(0, -3);
      }
    }, P = (s) => {
      t.updateComment(s);
    }, D = (s) => l("div", {
      class: r.e("item")
    }, [l("div", {
      class: r.em("item", "header")
    }, [y(s.create_man), l("span", {
      class: r.em("item", "time")
    }, [E(s.create_time)]), s.create_man === t.context.srfuserid ? l("div", null, [l("span", {
      class: r.em("item", "edit"),
      onClick: () => P(s),
      title: "编辑"
    }, [l("i", {
      class: "fa fa-edit",
      "aria-hidden": "true"
    }, null)]), l("span", {
      class: r.em("item", "delicon"),
      onClick: () => g(s),
      title: "删除"
    }, [l("i", {
      class: "fa fa-trash-o",
      "aria-hidden": "true"
    }, null)])]) : null]), l("div", {
      class: r.em("item", "content")
    }, [l("div", {
      innerHTML: s.content
    }, null)])]), I = () => e.value.length === 0 ? l($("iBizNoData"), {
      class: r.e("nodata")
    }, null) : l("div", {
      class: r.e("list")
    }, [e.value.map((s) => D(s))]), w = (s) => {
      s.stopPropagation(), s.preventDefault();
    };
    return z(() => {
      t.evt.off("addItem", m), t.evt.off("deleteItem", i), t.evt.off("editreply", u);
    }), {
      ns: r,
      c: t,
      renderList: I,
      stopClick: w
    };
  },
  render() {
    return l("div", {
      class: this.ns.b(),
      onClick: this.stopClick
    }, [this.renderList()]);
  }
});
class Y extends S {
  constructor() {
    super(...arguments);
    /**
     * 是否走本地模式
     *
     * @type {boolean}
     * @memberof CommentListComtroller
     */
    p(this, "isLocal", !1);
    /**
     * 用户列表
     *
     * @memberof CommentListComtroller
     */
    p(this, "operatorMap", /* @__PURE__ */ new Map());
    p(this, "evt", new T(
      () => ({
        context: this.context,
        params: this.params,
        data: [],
        eventArg: "",
        targetName: this.model.name,
        view: this.parent.view
      })
    ));
    /**
     * 代码表模型
     * @return {*}
     * @author: zhujiamin
     * @Date: 2023-05-24 10:55:50
     */
    p(this, "codeList");
    p(this, "extraParams", {});
    /**
     * 实体codeName
     * @type {string}
     */
    p(this, "deCodeName", "comment");
  }
  async onInit() {
    super.onInit(), await this.getOperatorUserList(), this.editorParams && this.editorParams.PID && Object.assign(this.extraParams, { pid: this.editorParams.PID }), this.editorParams && this.editorParams.ISLOCAL === "TRUE" && (this.isLocal = !0), this.editorParams && this.editorParams.DECODENAME && (this.deCodeName = this.editorParams.DECODENAME);
  }
  /**
   * 删除项
   *
   * @param {string} key
   * @memberof CommentListComtroller
   */
  async deleteItem(t) {
    var e;
    if (this.isLocal) {
      const a = await this.getLocalTempData();
      if (a) {
        await ((e = a.local) == null ? void 0 : e.delete(this.context, t));
        const i = ibiz.uiDomainManager.get(this.context.srfsessionid);
        i && i.dataChangeCompleted();
      }
    }
    this.evt.emit("deleteItem", {
      eventArg: t
    });
  }
  async getLocalTempData() {
    const { form: t } = this.parent;
    if (t) {
      const { srfappid: e } = this.context, a = e.split("_").pop();
      return await ibiz.hub.getAppDEService(
        e,
        "".concat(a, ".").concat(this.deCodeName),
        this.context
      );
    }
  }
  /**
   * 添加项
   *
   * @param {IData} item
   * @memberof CommentListComtroller
   */
  async addItem(t) {
    if (this.isLocal) {
      const e = await this.getLocalTempData();
      if (e) {
        await e.create(this.context, t);
        const a = ibiz.uiDomainManager.get(this.context.srfsessionid);
        a && a.dataChangeCompleted();
      }
    }
    this.evt.emit("addItem", {
      eventArg: t
    });
  }
  /**
   * 更新项
   *
   * @param {IData} item
   * @return {*}  {Promise<void>}
   * @memberof CommentListComtroller
   */
  async upadteItem(t) {
    if (this.isLocal) {
      const e = await this.getLocalTempData();
      if (e) {
        await e.update(this.context, t);
        const a = ibiz.uiDomainManager.get(this.context.srfsessionid);
        a && a.dataChangeCompleted();
      }
    }
    this.evt.emit("editreply", {
      eventArg: t
    });
  }
  /**
   * 重新编辑评论
   *
   * @param {IData} item
   * @memberof CommentListComtroller
   */
  updateComment(t) {
    const e = this.parent.panel, a = this.parent.form;
    e ? e.evt.emit("editreply", {
      targetName: "comments",
      context: this.context,
      params: this.params,
      data: [t]
    }) : a && a.evt.emit("editreply", {
      targetName: "comments",
      context: this.context,
      params: this.params,
      data: [t]
    });
  }
  /**
   * 删除评论
   *
   * @param {IData} item
   * @memberof CommentListComtroller
   */
  deleteComment(t) {
    const e = this.parent.panel, a = this.parent.form;
    e ? e.evt.emit("deletecomment", {
      targetName: "comments",
      context: this.context,
      params: this.params,
      data: [t]
    }) : a && a.evt.emit("deletecomment", {
      targetName: "comments",
      context: this.context,
      params: this.params,
      data: [t]
    });
  }
  handleExtraParams(t) {
    const e = {};
    return Object.keys(this.extraParams).forEach((a) => {
      if (this.extraParams[a].startsWith("%") && this.extraParams[a].endsWith("%")) {
        const i = this.extraParams[a].slice(1, -1);
        Object.prototype.hasOwnProperty.call(this.context, i) ? Object.assign(e, { [a]: this.context[i] }) : Object.prototype.hasOwnProperty.call(this.params, i) ? Object.assign(e, { [a]: this.params[i] }) : Object.prototype.hasOwnProperty.call(t, i) ? Object.assign(e, { [a]: t[i] }) : Object.assign(e, { [a]: null });
      } else
        Object.assign(e, { [a]: this.extraParams[a] });
    }), e;
  }
  /**
   * 发送评论
   *
   * @memberof CommentListComtroller
   */
  sendComment(t, e) {
    const a = this.parent.panel, i = this.parent.form;
    if (a) {
      const m = this.handleExtraParams(a.inputData);
      Object.assign(m, { value: t }), a.evt.emit("sendcomment", {
        targetName: "comments",
        context: this.context,
        params: this.params,
        data: [m]
      });
    } else if (i) {
      const m = this.handleExtraParams(e);
      Object.assign(m, { value: t }), i.evt.emit("sendcomment", {
        targetName: "comments",
        context: this.context,
        params: this.params,
        data: [m]
      });
    }
  }
  /**
   * 获取操作用户列表
   *
   * @memberof PersonelSelectController
   */
  async getOperatorUserList() {
    const t = await ibiz.hub.getApp(this.context.srfappid);
    let e = [];
    e = await t.codeList.get(
      "SysOperator",
      this.context,
      this.params
    ), this.operatorMap = new Map(
      e.map((a) => [a.value, a])
    );
  }
}
class J {
  constructor() {
    p(this, "component", "CommentList");
    p(this, "formEditor", "CommentList");
    p(this, "gridEditor", "CommentList");
  }
  async createController(r, t) {
    const e = new Y(r, t);
    return await e.init(), e;
  }
}
const Q = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(n) {
    n.component(b.name, b), M(
      "EDITOR_CUSTOMSTYLE_COMMENT_LIST",
      () => new J()
    );
  }
};
export {
  Q as default
};
