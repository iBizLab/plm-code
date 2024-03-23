import './style.css';
var $ = Object.defineProperty;
var W = (s, a, e) => a in s ? $(s, a, { enumerable: !0, configurable: !0, writable: !0, value: e }) : s[a] = e;
var h = (s, a, e) => (W(s, typeof a != "symbol" ? a + "" : a, e), e);
import { PanelItemState as Y, PanelItemController as H, UIActionButtonState as J, UIActionUtil as Q, registerPanelItemProvider as X } from "@ibiz-template/runtime";
import { defineComponent as Z, ref as p, computed as C, createVNode as o, resolveComponent as c } from "vue";
import { useNamespace as tt } from "@ibiz-template/vue3-util";
class et extends Y {
  constructor() {
    super(...arguments);
    /**
     * 加载中
     * @author lxm
     * @date 2023-07-21 10:11:21
     * @type {boolean}
     */
    h(this, "loading", !1);
    /**
     * 界面行为状态
     * @author lxm
     * @date 2023-07-21 03:34:27
     * @type {UIActionButtonState}
     */
    h(this, "uiActionState");
  }
}
class L extends H {
  /**
   * Creates an instance of KanbanOperateController.
   * @param {IPanelButton} model
   * @param {PanelController} panel
   * @param {PanelItemController} [parent]
   * @memberof KanbanOperateController
   */
  constructor(e, r, l) {
    super(e, r, l);
    /**
     * 行为模型
     */
    h(this, "actionModel", {});
    this.state.uiActionState = this.createUIActionState();
  }
  createState() {
    var e;
    return new et((e = this.parent) == null ? void 0 : e.state);
  }
  /**
   * 父容器数据对象数据
   * @author lxm
   * @date 2023-07-15 01:33:58
   * @readonly
   * @type {IData}
   */
  get data() {
    return this.dataParent.data;
  }
  /**
   * 初始化
   *
   * @return {*}  {Promise<void>}
   * @memberof KanbanOperateController
   */
  async onInit() {
    await super.onInit(), this.updateButtonState();
    const e = this.panel.view, r = this.model.userTag || "OPERATE", l = e.getController("kanban");
    if (l) {
      const { dedataViewItems: d = [] } = l.model;
      this.actionModel = d.find(
        (m) => Object.is(m.name, r)
      );
    }
  }
  /**
   * 创建界面行为状态对象
   *
   * @protected
   * @return {*}  {KanbanOperateState}
   * @memberof KanbanOperateController
   */
  createUIActionState() {
    const { uiactionId: e, name: r } = this.model;
    return new J(
      r,
      this.panel.context.srfappid,
      e
    );
  }
  /**
   * 面板数据变更通知(由面板控制器调用)
   *
   * @param {string[]} names
   * @memberof KanbanOperateController
   */
  async dataChangeNotify(e) {
    await this.updateButtonState(), super.dataChangeNotify(e);
  }
  /**
   * 面板状态变更通知
   *
   * @param {PanelNotifyState} _state
   * @memberof KanbanOperateController
   */
  async panelStateNotify(e) {
    await this.updateButtonState(), super.panelStateNotify(e);
  }
  /**
   * 更新按钮权限状态
   *
   * @memberof KanbanOperateController
   */
  async updateButtonState() {
    await this.state.uiActionState.update(
      this.data,
      this.panel.model.appDataEntityId
    );
  }
  /**
   * 行为点击
   *
   * @param {MouseEvent} event
   * @return {*}  {Promise<void>}
   * @memberof KanbanOperateController
   */
  async onActionClick(e) {
  }
  calcItemVisible(e) {
    if (this.state.uiActionState.visible === !1) {
      this.state.visible = !1;
      return;
    }
    super.calcItemVisible(e);
  }
  calcItemDisabled(e) {
    if (this.state.uiActionState.disabled === !0) {
      this.state.disabled = !0;
      return;
    }
    super.calcItemDisabled(e);
  }
}
const K = /* @__PURE__ */ Z({
  name: "IBizKanbanOperate",
  props: {
    modelData: {
      type: Object,
      required: !0
    },
    controller: {
      type: L,
      required: !0
    }
  },
  setup(s) {
    const a = tt("panel-button"), e = s.controller, r = p(), l = p(), d = p(), m = p(!1), b = p(!1), {
      caption: V,
      captionItemName: S,
      renderMode: w,
      showCaption: A,
      sysImage: R,
      codeName: z,
      itemStyle: N,
      tooltip: k,
      buttonCssStyle: I
    } = s.modelData, {
      panel: u,
      state: f
    } = s.controller, O = p("");
    I && (O.value = I);
    const B = C(() => S && u.data ? u.data[S.toLowerCase()] : V);
    let y = !1;
    Object.is(w, "LINK") && (y = !0);
    const E = C(() => {
      if (Object.is(w, "LINK"))
        return null;
      switch (N) {
        case "PRIMARY":
          return "primary";
        case "SUCCESS":
          return "success";
        case "INFO":
          return "info";
        case "WARNING":
          return "warning";
        case "DANGER":
          return "danger";
        case "INVERSE":
          return "info";
        default:
          return null;
      }
    }), T = () => {
      const {
        actionModel: n
      } = e, t = [], i = [];
      if (n && n.deuiactionGroup) {
        const {
          uiactionGroupDetails: v
        } = n.deuiactionGroup;
        v.forEach((g) => {
          g.actionLevel === 250 ? t.push(g) : i.push(g);
        });
      }
      return {
        deActions: i,
        keyActions: t
      };
    }, U = (n, t) => {
      const i = {
        ...t
      };
      if (d.value) {
        const v = d.value.querySelector(".".concat(n.id));
        v && (i.target = v);
      }
      return i;
    }, x = async (n, t) => {
      t.stopPropagation(), b.value = !0;
      const i = {
        context: u.context,
        params: u.params,
        data: [u.inputData],
        view: u.view,
        event: U(n, t)
      };
      await Q.execAndResolved(n.uiactionId, i, n.appId), b.value = !1;
    }, P = async (n) => {
      try {
        f.loading = !0, await s.controller.onActionClick(n), s.controller.onClick();
      } finally {
        f.loading = !1;
      }
    }, D = (n) => {
      const {
        actionLevel: t
      } = n;
      return [n.id, a.e("item"), a.is("disabled", !1), a.em("item", "level-".concat(t))];
    }, M = (n) => n.length === 0 ? null : o("div", {
      class: a.be("poper-content", "keyaction")
    }, [n.map((t) => o(c("el-button"), {
      class: [a.bem("poper-content", "keyaction", "action"), ...D(t)],
      text: !0,
      size: "small",
      onClick: (i) => x(t, i),
      title: t.tooltip || t.caption
    }, {
      default: () => [t.showIcon && t.sysImage ? o(c("iBizIcon"), {
        icon: t.sysImage
      }, null) : o(c("iBizIcon"), {
        icon: "fa fa-save"
      }, null)]
    }))]), G = (n) => n.length === 0 ? null : o("div", {
      class: a.be("poper-content", "deaction"),
      ref: d
    }, [n.map((t) => o("div", {
      class: [a.bem("poper-content", "deaction", "action"), ...D(t)],
      onClick: (i) => x(t, i),
      title: t.tooltip || t.caption
    }, [t.showIcon && t.sysImage ? o(c("iBizIcon"), {
      icon: t.sysImage
    }, null) : o("i", {
      class: "ibiz-icon fa fa-ravelry",
      "aria-hidden": "true"
    }, null), o("span", {
      class: a.bem("poper-content", "deaction", "action-text")
    }, [t.showCaption ? t.capLanguageRes ? ibiz.i18n.t(t.capLanguageRes.lanResTag, t.caption) : t.caption : ""])]))]), j = () => {
      const {
        keyActions: n,
        deActions: t
      } = T();
      return o("div", {
        class: a.b("poper-content")
      }, [M(n), G(t)]);
    }, q = () => o("div", null, [o(c("el-tooltip"), {
      popperClass: a.b("title"),
      effect: "dark",
      content: k,
      placement: "top",
      "show-arrow": !0
    }, {
      default: () => [o(c("el-button"), {
        ref: "buttonRef",
        type: E.value,
        text: y,
        disabled: f.disabled,
        loading: f.loading,
        onClick: P
      }, {
        default: () => [o("div", {
          class: a.b("content")
        }, [o(c("iBizIcon"), {
          class: a.bm("content", "icon"),
          icon: R
        }, null), A ? o("span", {
          class: a.bm("content", "caption")
        }, [B]) : ""])]
      })]
    })]), _ = (n) => {
      n.stopPropagation(), n.preventDefault();
    }, F = C({
      get() {
        return m.value || b.value;
      },
      set(n) {
        m.value = n;
      }
    });
    return {
      ns: a,
      isText: y,
      captionText: B,
      buttonType: E,
      showCaption: A,
      sysImage: R,
      codeName: z,
      state: f,
      tooltip: k,
      handleButtonClick: P,
      buttonCssStyle: I,
      tempStyle: O,
      itemStyle: N,
      buttonRef: r,
      popoverRef: l,
      popoverRefVisible: m,
      renderPoperContent: j,
      renderBtn: q,
      stopEvent: _,
      processing: b,
      isVisible: F
    };
  },
  render() {
    return this.state.visible ? o("div", {
      class: [this.ns.b(), this.ns.m(this.codeName), this.ns.is("loading", this.state.loading), this.itemStyle && this.ns.m(this.itemStyle.toLowerCase()), this.ns.is("show-popover", this.isVisible), ...this.controller.containerClass],
      onClick: this.stopEvent,
      style: this.tempStyle
    }, [o(c("el-popover"), {
      ref: "popoverRef",
      visible: this.isVisible,
      "onUpdate:visible": (s) => this.isVisible = s,
      popperClass: [this.ns.b("one-popover")],
      width: 278,
      placement: "right-start",
      trigger: "click"
    }, {
      reference: () => this.renderBtn(),
      default: () => this.renderPoperContent()
    })]) : null;
  }
});
class nt {
  constructor() {
    h(this, "component", "IBizKanbanOperate");
  }
  async createController(a, e, r) {
    const l = new L(a, e, r);
    return await l.init(), l;
  }
}
const rt = {
  install(s) {
    s.component(K.name, K), X(
      "FORM_USERCONTROL_KANBAN_OPERATE",
      () => new nt()
    );
  }
};
export {
  L as KanbanOperateController,
  rt as default
};
