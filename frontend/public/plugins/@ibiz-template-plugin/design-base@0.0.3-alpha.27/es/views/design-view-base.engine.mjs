import { ViewEngineBase, getControl, SysUIActionTag, convertNavData } from '@ibiz-template/runtime';
import { RuntimeModelError } from '@ibiz-template/core';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DesignViewEngineBase extends ViewEngineBase {
  constructor() {
    super(...arguments);
    /**
     * 主数据表单(主要用于主数据加载相关接口模型)
     *
     * @author tony001
     * @date 2024-09-10 10:09:59
     * @protected
     * @type {IDEEditForm}
     */
    __publicField(this, "form");
    /**
     * 主数据表单服务
     *
     * @author tony001
     * @date 2024-09-10 10:09:30
     * @protected
     * @type {IAppDEService}
     */
    __publicField(this, "service");
    /**
     * 属性区导航占位控制器
     *
     * @author tony001
     * @date 2024-09-10 10:09:08
     * @protected
     * @type {NavPosController}
     */
    __publicField(this, "navPos");
    /**
     * 当前激活属性视图
     *
     * @author tony001
     * @date 2024-09-10 10:09:48
     * @protected
     * @type {ViewController}
     */
    __publicField(this, "activePropertyView");
  }
  /**
   * 视图初始化
   *
   * @author tony001
   * @date 2024-09-10 10:09:10
   * @return {*}  {Promise<void>}
   */
  async onCreated() {
    await super.onCreated();
    {
      const form = getControl(this.view.model, "form");
      if (!form) {
        throw new RuntimeModelError(this.view, "\u672A\u627E\u5230\u4E3B\u6570\u636E\u8868\u5355\u6A21\u578B");
      }
      this.form = form;
      const app = ibiz.hub.getApp(this.view.model.appId);
      this.service = await app.deService.getService(
        this.view.context,
        this.form.appDataEntityId
      );
    }
    this.onSelect = this.onSelect.bind(this);
    this.view.select.on(this.onSelect);
    this.initViewShouldDismissHook();
    await this.load();
  }
  /**
   * 视图挂载
   *
   * @author tony001
   * @date 2024-09-10 11:09:22
   * @return {*}  {Promise<void>}
   */
  async onMounted() {
    var _a;
    await super.onMounted();
    (_a = this.toolbar) == null ? void 0 : _a.calcButtonState(
      this.view.state.data,
      this.form.appDataEntityId
    );
    this.navPos = this.view.layoutPanel.panelItems.nav_pos;
    this.activeRoot();
    this.initPropertyView();
    this.view.evt.emit("onViewInfoChange", {
      dataInfo: this.view.state.data.srfmajortext || ""
    });
  }
  /**
   * 初始化视图hook
   *
   * @author tony001
   * @date 2024-09-10 11:09:37
   * @protected
   */
  initViewShouldDismissHook() {
    this.view.modal.hooks.shouldDismiss.tapPromise(async (context) => {
      const uiDomain = ibiz.uiDomainManager.get(this.view.context.srfsessionid);
      if (uiDomain.dataModification === true && context.allowClose == null) {
        const isAllow = await ibiz.confirm.error({
          title: "\u5173\u95ED\u63D0\u9192",
          desc: "\u6570\u636E\u5DF2\u7ECF\u4FEE\u6539\uFF0C\u786E\u5B9A\u8981\u5173\u95ED\uFF1F"
        });
        if (!isAllow) {
          context.allowClose = false;
        } else {
          context.allowClose = true;
        }
      }
    });
  }
  /**
   * 初始化属性视图
   *
   * @author tony001
   * @date 2024-09-10 11:09:01
   * @protected
   */
  initPropertyView() {
    var _a;
    ((_a = this.view.layoutPanel) == null ? void 0 : _a.evt).on(
      "onPresetPanelItemEvent",
      (event) => {
        const { panelItemEventName, panelItemName, presetParams } = event;
        if (panelItemName === "nav_pos" && panelItemEventName === "onViewCreated") {
          this.activePropertyView = presetParams.view;
        }
      }
    );
  }
  /**
   * 选中数据
   *
   * @author tony001
   * @date 2024-09-10 11:09:22
   * @protected
   * @param {(IData | undefined | null)} data
   */
  onSelect(data) {
    if (data) {
      this.onActive(data);
    }
  }
  /**
   * 激活根节点
   *
   * @author tony001
   * @date 2024-09-02 17:09:06
   * @protected
   */
  activeRoot() {
    this.view.select.set({
      id: this.view.state.data.srfkey,
      label: this.view.state.data.srfmajortext,
      type: "",
      data: this.view.state.data
    });
  }
  /**
   * 加载数据
   *
   * @author tony001
   * @date 2024-09-10 11:09:50
   * @protected
   * @return {*}  {(Promise<IData | null>)}
   */
  async load() {
    try {
      this.view.startLoading();
      const res = await this.service.get(this.view.context, this.view.params);
      if (res.ok && res.data) {
        this.service.local.add(this.view.context, res.data);
        this.view.state.data = res.data;
        return res.data;
      }
      return null;
    } finally {
      this.view.endLoading();
    }
  }
  /**
   * 保存数据
   *
   * @author tony001
   * @date 2024-09-10 11:09:06
   * @protected
   * @return {*}  {(Promise<IData | null>)}
   */
  async save() {
    try {
      this.view.startLoading();
      const majorResult = await this.service.getTemp(this.view.context);
      if (majorResult.ok && majorResult.data) {
        const majorData = majorResult.data;
        for (const key in majorData) {
          if (Object.prototype.hasOwnProperty.call(majorData, key)) {
            const val = majorData[key];
            if (typeof val === "object") {
              majorData[key] = void 0;
            }
          }
        }
        const res = await this.service.update(this.view.context, majorData);
        if (res.ok && res.data) {
          this.service.local.add(this.view.context, res.data);
          this.view.state.data = res.data;
          this.view.evt.emit("onViewInfoChange", {
            dataInfo: this.view.state.data.srfmajortext || ""
          });
          ibiz.message.success("".concat(this.view.state.data.srfmajortext, "\u4FDD\u5B58\u6210\u529F!"));
          return res.data;
        }
      }
      return null;
    } finally {
      this.view.endLoading();
    }
  }
  /**
   * 视图能力调用
   *
   * @author tony001
   * @date 2024-09-10 11:09:29
   * @param {string} key
   * @param {IData} [args]
   * @return {*}  {(Promise<IData | null | undefined>)}
   */
  async call(key, args) {
    if (key === SysUIActionTag.SAVE) {
      return this.save();
    }
    if (key === "onActive") {
      this.view.select.set(args);
      return void 0;
    }
    if (key === "onActiveRoot") {
      this.activeRoot();
      return void 0;
    }
    return super.call(key, args);
  }
  /**
   * 激活数据（主要控制右侧属性视图的显示）
   *
   * @author tony001
   * @date 2024-09-10 11:09:57
   * @protected
   * @param {IData} data
   * @return {*}  {Promise<void>}
   */
  async onActive(data) {
    const deName = data.data.srfdecodename;
    const refs = this.view.model.viewLayoutPanel.appViewRefs;
    if (refs) {
      const type = data.type ? data.type.toUpperCase() : null;
      const ref = refs.find((item) => {
        return item.name === "EDITDATA:".concat(deName.toUpperCase()).concat(type ? ":".concat(type) : "");
      });
      if (ref) {
        const context = this.view.context.clone();
        context[deName.toLowerCase()] = data.id;
        const { navigateContexts } = ref;
        Object.assign(
          context,
          convertNavData(navigateContexts, data.data, context)
        );
        this.navPos.openView({
          key: data.id,
          viewId: ref.refAppViewId,
          context
        });
      }
    }
  }
}

export { DesignViewEngineBase };
