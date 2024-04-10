var h = Object.defineProperty;
var p = (s, r, e) => r in s ? h(s, r, { enumerable: !0, configurable: !0, writable: !0, value: e }) : s[r] = e;
var u = (s, r, e) => (p(s, typeof r != "symbol" ? r + "" : r, e), e);
import { UIActionProviderBase as f, registerUIActionProvider as P } from "@ibiz-template/runtime";
import { defineComponent as g, ref as b, reactive as d, createVNode as o, resolveComponent as t, createTextVNode as v, h as C } from "vue";
import { useNamespace as y } from "@ibiz-template/vue3-util";
const B = /* @__PURE__ */ g({
  name: "ChangePassword",
  props: {
    modal: {
      type: Object
    }
  },
  setup(s) {
    const r = y("change-password"), e = b(), a = d({
      oldPassword: "",
      newPassword: "",
      surePassword: ""
    }), n = d({
      oldPassword: [{
        required: !0,
        message: "旧密码不能为空",
        trigger: "blur"
      }],
      newPassword: [{
        required: !0,
        message: "新密码不能为空",
        trigger: "blur"
      }],
      surePassword: [{
        required: !0,
        message: "确认密码不能为空",
        trigger: "blur"
      }]
    });
    return {
      ns: r,
      form: a,
      rules: n,
      formRef: e,
      onConfirm: async () => {
        var l;
        if (!e.value)
          return;
        await e.value.validate();
        const {
          oldPassword: c,
          newPassword: i,
          surePassword: m
        } = a;
        if (c === i) {
          ibiz.message.error("新密码不能与旧密码一致");
          return;
        }
        if (i !== m) {
          ibiz.message.error("两次密码不一致");
          return;
        }
        if (s.modal) {
          const w = {
            ok: !0,
            data: [a]
          };
          (l = s.modal) == null || l.dismiss(w);
        }
      }
    };
  },
  render() {
    return o(t("el-form"), {
      ref: "formRef",
      model: this.form,
      rules: this.rules,
      class: this.ns.b()
    }, {
      default: () => [o(t("el-form-item"), {
        class: this.ns.b("item"),
        label: "旧密码",
        prop: "oldPassword"
      }, {
        default: () => [o(t("el-input"), {
          type: "password",
          "show-password": !0,
          class: this.ns.be("item", "content"),
          modelValue: this.form.oldPassword,
          "onUpdate:modelValue": (s) => this.form.oldPassword = s,
          placeholder: "输入旧密码"
        }, null)]
      }), o(t("el-form-item"), {
        class: this.ns.b("item"),
        label: "新密码",
        prop: "newPassword"
      }, {
        default: () => [o(t("el-input"), {
          type: "password",
          "show-password": !0,
          class: this.ns.be("item", "content"),
          modelValue: this.form.newPassword,
          "onUpdate:modelValue": (s) => this.form.newPassword = s,
          placeholder: "输入新密码"
        }, null)]
      }), o(t("el-form-item"), {
        class: this.ns.b("item"),
        label: "确认新密码",
        prop: "surePassword"
      }, {
        default: () => [o(t("el-input"), {
          type: "password",
          "show-password": !0,
          class: this.ns.be("item", "content"),
          modelValue: this.form.surePassword,
          "onUpdate:modelValue": (s) => this.form.surePassword = s,
          placeholder: "再次输入新密码"
        }, null)]
      }), o("div", {
        class: this.ns.b("footer")
      }, [o(t("el-button"), {
        size: "large",
        round: !0,
        onClick: this.onConfirm
      }, {
        default: () => [v("确认")]
      })])]
    });
  }
});
class V extends f {
  constructor() {
    super(...arguments);
    /**
     * 气泡容器
     *
     * @type {IOverlayPopoverContainer}
     * @memberof ChangePasswordUIActionProvider
     */
    u(this, "overlay", null);
  }
  /**
   * 执行界面行为
   *
   * @param {IAppDEUIAction} _action
   * @param {IUILogicParams} _params
   * @return {*}  {Promise<IUIActionResult>}
   * @memberof ChangePasswordUIActionProvider
   */
  async execAction(e, a) {
    const n = await this.openModal();
    return n.length > 0 && await this.changePass(n[0]), {};
  }
  /**
   * 打开模态
   *
   * @return {*}
   * @memberof ChangePasswordUIActionProvider
   */
  async openModal() {
    const e = {
      width: "600px"
    };
    return this.overlay = ibiz.overlay.createModal(
      this.createOverlayView(),
      void 0,
      e
    ), await this.overlay.present(), (await this.overlay.onWillDismiss()).data || [];
  }
  /**
   * 创建overlay
   *
   * @return {*}  {(modal: IModal) => VNode}
   * @memberof ChangePasswordUIActionProvider
   */
  createOverlayView() {
    return (e) => C(B, {
      modal: e
    });
  }
  /**
   * 修改密码
   *
   * @param {IData} data
   * @return {*}  {Promise<boolean>}
   * @memberof ChangePasswordUIActionProvider
   */
  async changePass(e) {
    try {
      return await ibiz.net.post("/uaa/changepwd", {
        oldPwd: e.oldPassword,
        newPwd: e.newPassword
      }), ibiz.message.success("修改密码成功"), !0;
    } catch (a) {
      ibiz.notification.error({
        title: "修改密码失败",
        desc: a.message || ""
      });
    }
    return !1;
  }
}
function A() {
  P(
    "DEUIACTION_CHANGE_PASSWORD",
    () => new V()
  );
}
const I = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install() {
    A();
  }
};
export {
  I as default,
  A as registerChangePasswordProvider
};
