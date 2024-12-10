import { ViewEngineBase, getControl, EditFormService, SysUIActionTag } from '@ibiz-template/runtime';
import { RuntimeModelError } from '@ibiz-template/core';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class X6DesignViewEngine extends ViewEngineBase {
  constructor() {
    super(...arguments);
    /**
     * 主数据表单(主要用于主数据加载相关接口模型)
     *
     * @author chitanda
     * @date 2023-11-16 17:11:08
     * @protected
     * @type {IDEEditForm}
     */
    __publicField(this, "form");
    /**
     * X6 设计主内容区组件控制器
     *
     * @author chitanda
     * @date 2023-11-20 11:11:07
     * @protected
     * @type {X6PanelItemController}
     */
    __publicField(this, "x6");
    /**
     * 属性区导航占位控制器
     *
     * @author chitanda
     * @date 2023-11-22 12:11:07
     * @protected
     * @type {NavPosController}
     */
    __publicField(this, "navPos");
    /**
     * 主数据表单服务
     *
     * @author chitanda
     * @date 2023-11-16 17:11:13
     * @protected
     * @type {EditFormService}
     */
    __publicField(this, "service");
  }
  async onCreated() {
    await super.onCreated();
    {
      const form = getControl(this.view.model, "form");
      if (!form) {
        throw new RuntimeModelError(this.view, "\u672A\u627E\u5230\u4E3B\u6570\u636E\u8868\u5355\u6A21\u578B");
      }
      this.form = form;
      this.service = new EditFormService(this.form);
      await this.service.init(this.view.context);
    }
    this.onSelect = this.onSelect.bind(this);
    this.view.select.on(this.onSelect);
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
    await this.load();
  }
  onSelect(data) {
    if (data) {
      this.onActive(data);
    }
  }
  async onMounted() {
    var _a;
    await super.onMounted();
    (_a = this.toolbar) == null ? void 0 : _a.calcButtonState(
      this.view.state.data,
      this.form.appDataEntityId
    );
    this.navPos = this.view.layoutPanel.panelItems.nav_pos;
    this.x6 = this.view.layoutPanel.panelItems.x6_panel_item;
    this.activeRoot();
    this.view.evt.emit("onViewInfoChange", {
      dataInfo: this.view.state.data.srfmajortext || ""
    });
    await this.x6.load();
  }
  /**
   * 激活根节点
   *
   * @author chitanda
   * @date 2023-11-22 21:11:04
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
  async load() {
    try {
      this.view.startLoading();
      const uiDomain = ibiz.uiDomainManager.get(this.view.context.srfsessionid);
      if (uiDomain && uiDomain.state.rsInit) {
        uiDomain.state.rsInit = false;
      }
      const res = await this.service.get(this.view.context, this.view.params);
      const app = ibiz.hub.getApp(this.view.model.appId);
      const service = await app.deService.getService(
        this.view.context,
        this.form.appDataEntityId
      );
      service.local.add(this.view.context, res.data.getOrigin());
      this.view.state.data = res.data.getOrigin();
      return res.data;
    } finally {
      this.view.endLoading();
    }
  }
  async save() {
    var _a;
    try {
      this.view.startLoading();
      const app = ibiz.hub.getApp(this.view.model.appId);
      const service = await app.deService.getService(
        this.view.context,
        this.form.appDataEntityId
      );
      const data = service.local.get(
        this.view.context,
        this.view.state.data.srfkey
      );
      const res = await this.service.update(this.view.context, data);
      service.local.add(this.view.context, res.data.getOrigin());
      this.view.state.data = res.data.getOrigin();
      await this.view.evt.emit("onSaveSuccess", void 0);
      this.activeRoot();
      this.view.evt.emit("onViewInfoChange", {
        dataInfo: this.view.state.data.srfmajortext || ""
      });
      (_a = this.toolbar) == null ? void 0 : _a.calcButtonState(
        this.view.state.data,
        this.form.appDataEntityId
      );
      return res.data;
    } finally {
      this.view.endLoading();
    }
  }
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
   * 设置激活数据
   *
   * @description 主要控制右侧属性视图的显示
   * @author chitanda
   * @date 2023-11-22 12:11:36
   * @protected
   * @param {X6CellDataProvider} data
   */
  onActive(data) {
    const refs = this.view.model.appViewRefs;
    if (refs) {
      const type = data.type ? data.type.toUpperCase() : null;
      const ref = refs.find(
        (item) => item.name === "EDITDATA:".concat(data.data.srfdecodename.toUpperCase()).concat(type ? ":".concat(type) : "")
      );
      if (ref) {
        const context = this.view.context.clone();
        context[data.data.srfdecodename.toLowerCase()] = data.id;
        this.navPos.openView({
          key: data.id,
          viewId: ref.refAppViewId,
          context
        });
      } else {
        throw new RuntimeModelError(
          this.view.model,
          data.type ? "\u672A\u5339\u914D\u5230\u5BF9\u5E94[".concat(data.type, "]\u7684\u5C5E\u6027\u7F16\u8F91\u89C6\u56FE") : "\u5F53\u524D\u6570\u636E\u672A\u6307\u5B9A\u7C7B\u578B\uFF0C\u65E0\u6CD5\u5339\u914D\u5230\u5C5E\u6027\u7F16\u8F91\u89C6\u56FE"
        );
      }
    }
  }
}

export { X6DesignViewEngine };
