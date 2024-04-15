import './style.css';
var M = Object.defineProperty;
var N = (e, t, n) => t in e ? M(e, t, { enumerable: !0, configurable: !0, writable: !0, value: n }) : e[t] = n;
var h = (e, t, n) => (N(e, typeof t != "symbol" ? t + "" : t, n), n);
import { PanelItemState as x, PanelItemController as g, UIActionButtonState as O, UIActionUtil as _, registerPanelItemProvider as B } from "@ibiz-template/runtime";
import { useNamespace as j, withInstall as z } from "@ibiz-template/vue3-util";
import { defineComponent as V, ref as f, computed as E, createVNode as s, resolveComponent as r, isVNode as P } from "vue";
class D extends x {
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
class I extends g {
  createState() {
    var t;
    return new D((t = this.parent) == null ? void 0 : t.state);
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
   * Creates an instance of SwitchShowModeController.
   * @param {IPanelButton} model
   * @param {PanelController} panel
   * @param {PanelItemController} [parent]
   * @memberof SwitchShowModeController
   */
  constructor(t, n, a) {
    super(t, n, a), this.state.uiActionState = this.createUIActionState();
  }
  /**
   * 初始化
   *
   * @return {*}  {Promise<void>}
   * @memberof SwitchShowModeController
   */
  async onInit() {
    await super.onInit(), this.updateButtonState();
  }
  /**
   * 创建界面行为状态对象
   *
   * @protected
   * @return {*}  {SwitchShowModeState}
   * @memberof SwitchShowModeController
   */
  createUIActionState() {
    const { uiactionId: t, name: n } = this.model;
    return new O(
      n,
      this.panel.context.srfappid,
      t
    );
  }
  /**
   * 面板数据变更通知(由面板控制器调用)
   *
   * @param {string[]} names
   * @memberof SwitchShowModeController
   */
  async dataChangeNotify(t) {
    await this.updateButtonState(), super.dataChangeNotify(t);
  }
  /**
   * 面板状态变更通知
   *
   * @param {PanelNotifyState} _state
   * @memberof SwitchShowModeController
   */
  async panelStateNotify(t) {
    await this.updateButtonState(), super.panelStateNotify(t);
  }
  /**
   * 更新按钮权限状态
   *
   * @memberof SwitchShowModeController
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
   * @memberof SwitchShowModeController
   */
  async onActionClick(t, n) {
    const { uiactionId: a, actionType: c } = this.model;
    if (c === "NONE")
      return;
    const l = {};
    Object.assign(l, {
      ...this.panel.params,
      showMode: n == null ? void 0 : n.showMode
    }), await _.execAndResolved(
      a,
      {
        context: this.panel.context,
        params: l,
        data: [this.data],
        view: this.panel.view,
        event: t,
        noWaitRoute: !0
      },
      this.model.appId
    );
  }
  calcItemVisible(t) {
    if (this.state.uiActionState.visible === !1) {
      this.state.visible = !1;
      return;
    }
    super.calcItemVisible(t);
  }
  calcItemDisabled(t) {
    if (this.state.uiActionState.disabled === !0) {
      this.state.disabled = !0;
      return;
    }
    super.calcItemDisabled(t);
  }
}
function m(e) {
  return typeof e == "function" || Object.prototype.toString.call(e) === "[object Object]" && !P(e);
}
const p = /* @__PURE__ */ V({
  name: "IBizSwitchShowMode",
  props: {
    modelData: {
      type: Object,
      required: !0
    },
    controller: {
      type: I,
      required: !0
    }
  },
  setup(e) {
    const t = j("switch-show-mode"), {
      renderMode: n,
      codeName: a,
      itemStyle: c
    } = e.modelData, {
      state: l
    } = e.controller, u = f([{
      _icon: {},
      _text: "视图",
      _showCaption: !0,
      _className: "item-view"
    }, {
      _icon: {},
      _text: "",
      _showCaption: !0,
      _className: "item-divider"
    }, {
      _icon: {
        htmlStr: '<svg t="1706002902701" class="icon" viewBox="0 0 1088 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1501" width="1em" height="1em"><path d="M480 64a32 32 0 0 0-32 32v128a32 32 0 0 0 32 32h128a32 32 0 0 0 32-32v-128a32 32 0 0 0-32-32h-128zM192 704h32A96 96 0 0 1 320 800v128A96 96 0 0 1 224 1024h-128A96 96 0 0 1 0 928v-128A96 96 0 0 1 96 704H128V512a64 64 0 0 1 64-64h320V320h-32A96 96 0 0 1 384 224v-128A96 96 0 0 1 480 0h128A96 96 0 0 1 704 96v128A96 96 0 0 1 608 320H576v128h320a64 64 0 0 1 64 64v192h32a96 96 0 0 1 96 96v128a96 96 0 0 1-96 96h-128a96 96 0 0 1-96-96v-128a96 96 0 0 1 96-96h32V512H576v192h32a96 96 0 0 1 96 96v128A96 96 0 0 1 608 1024h-128A96 96 0 0 1 384 928v-128A96 96 0 0 1 480 704H512V512H192v192z m672 64a32 32 0 0 0-32 32v128a32 32 0 0 0 32 32h128a32 32 0 0 0 32-32v-128a32 32 0 0 0-32-32h-128z m-384 0a32 32 0 0 0-32 32v128a32 32 0 0 0 32 32h128a32 32 0 0 0 32-32v-128a32 32 0 0 0-32-32h-128z m-384 0a32 32 0 0 0-32 32v128a32 32 0 0 0 32 32h128a32 32 0 0 0 32-32v-128a32 32 0 0 0-32-32h-128z" p-id="1502"></path></svg>'
      },
      _text: "树状",
      showMode: "tree",
      _showCaption: !0,
      selected: !0
    }, {
      _icon: {
        cssClass: "fa fa-reorder"
      },
      _text: "平铺",
      showMode: "grid",
      _showCaption: !0,
      selected: !1
    }]), w = f(u.value[2]);
    let S = !1;
    Object.is(n, "LINK") && (S = !0);
    const b = E(() => {
      if (Object.is(n, "LINK"))
        return null;
      switch (c) {
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
    }), C = (i) => {
      u.value.forEach((o) => {
        (i == null ? void 0 : i.showMode) === (o == null ? void 0 : o.showMode) ? Object.assign(o, {
          selected: !0
        }) : Object.assign(o, {
          selected: !1
        });
      }), w.value = i;
    }, v = async (i, o) => {
      var d;
      if (!((o == null ? void 0 : o.showMode) === ((d = w.value) == null ? void 0 : d.showMode) || !(o != null && o.showMode)))
        try {
          l.loading = !0, await e.controller.onActionClick(i, o), C(o), e.controller.onClick();
        } finally {
          l.loading = !1;
        }
    };
    return {
      ns: t,
      isText: S,
      buttonType: b,
      codeName: a,
      state: l,
      dropdownItems: u,
      selected: w,
      handleButtonClick: v,
      renderContentItem: (i) => {
        const {
          _icon: o,
          _text: d,
          _showCaption: A
        } = i;
        return s("div", {
          class: [t.b("content"), i == null ? void 0 : i._className, i != null && i.selected ? t.be("content", "selected") : ""],
          onClick: (y) => {
            v(y, i);
          }
        }, [s(r("iBizIcon"), {
          class: t.bm("content", "icon"),
          icon: o
        }, null), A ? s("span", {
          class: t.bm("content", "caption")
        }, [d]) : ""]);
      }
    };
  },
  render() {
    return this.state.visible ? s("div", {
      class: [this.ns.b(), this.ns.m(this.codeName), this.ns.is("loading", this.state.loading), ...this.controller.containerClass]
    }, [s(r("el-dropdown"), {
      trigger: "click",
      "popper-class": this.ns.b("popper")
    }, {
      default: () => {
        let e;
        return s(r("el-button"), {
          type: this.buttonType,
          text: this.isText,
          disabled: this.state.disabled,
          loading: this.state.loading
        }, m(e = this.renderContentItem(this.selected)) ? e : {
          default: () => [e]
        });
      },
      dropdown: () => s(r("el-dropdown-menu"), null, {
        default: () => this.dropdownItems.map((e) => {
          let t;
          return s(r("el-dropdown-item"), null, m(t = this.renderContentItem(e)) ? t : {
            default: () => [t]
          });
        })
      })
    })]) : null;
  }
});
class H {
  constructor() {
    h(this, "component", "IBizSwitchShowMode");
  }
  async createController(t, n, a) {
    const c = new I(t, n, a);
    return await c.init(), c;
  }
}
const R = z(
  p,
  function(e) {
    e.component(p.name, p), B(
      "CUSTOM_SWITCH_SHOW_MODE",
      () => new H()
    );
  }
), G = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(e) {
    e.use(R);
  }
};
export {
  R as IBizSwitchShowModeButton,
  G as default
};
