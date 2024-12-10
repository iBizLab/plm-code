import { ViewEngineBase, getControl, SysUIActionTag } from '@ibiz-template/runtime';
import { RuntimeModelError } from '@ibiz-template/core';
import '../../utils/index.mjs';
import { modelStateUtil } from '../../utils/model-state-util/model-state-util.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndDesignViewEngine extends ViewEngineBase {
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
     * @type {IAppDEService}
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
      const app = ibiz.hub.getApp(this.view.model.appId);
      this.service = await app.deService.getService(
        this.view.context,
        this.form.appDataEntityId
      );
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
    const data = this.view.state.data;
    if (data && data.psdeid) {
      this.view.context.psdataentity = data.psdeid;
    }
  }
  onSelect(data) {
    this.onActive(data);
  }
  async onMounted() {
    var _a;
    await super.onMounted();
    (_a = this.toolbar) == null ? void 0 : _a.calcButtonState(
      this.view.state.data,
      this.form.appDataEntityId
    );
    this.navPos = this.view.layoutPanel.panelItems.nav_pos;
    this.activeRoot();
    this.view.evt.emit("onViewInfoChange", {
      dataInfo: this.view.state.data.srfmajortext || ""
    });
  }
  async onDestroyed() {
    await super.onDestroyed();
    this.view.select.off(this.onSelect);
  }
  /**
   * 激活根节点
   *
   * @author chitanda
   * @date 2023-11-22 21:11:04
   * @protected
   */
  activeRoot() {
    this.view.select.set(this.view.state.data);
  }
  async load() {
    try {
      this.view.startLoading();
      const res = await this.service.get(this.view.context, this.view.params);
      this.service.local.add(this.view.context, res.data);
      this.view.state.data = res.data;
      return res.data;
    } finally {
      this.view.endLoading();
    }
  }
  async save() {
    var _a;
    try {
      this.view.startLoading();
      const data = this.service.local.get(
        this.view.context,
        this.view.state.data.srfkey
      );
      for (const key in data) {
        if (Object.prototype.hasOwnProperty.call(data, key)) {
          const val = data[key];
          if (typeof val === "object") {
            data[key] = void 0;
          }
        }
      }
      const res = await this.service.update(this.view.context, data);
      this.service.local.add(this.view.context, res.data);
      this.view.state.data = res.data;
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
    if (key === "onActive" && args) {
      this.onActive(args);
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
   * @param {IData} data
   */
  onActive(data) {
    var _a;
    const refs = this.view.model.appViewRefs;
    if (refs) {
      const type = data.srftype ? data.srftype.toUpperCase() : null;
      const ref = refs.find(
        (item) => item.name === "EDITDATA:".concat(data.srfdecodename.toUpperCase()).concat(type ? ":".concat(type) : "")
      );
      if (ref) {
        const context = this.view.context.clone();
        context[data.srfdecodename.toLowerCase()] = data.srfkey;
        delete context.srfrunmode;
        const dndDesignController = (_a = this.view.layoutPanel) == null ? void 0 : _a.panelItems.dnd_design_panel_item;
        const modelState = dndDesignController ? dndDesignController.getModelState(data) : 0;
        if (!modelStateUtil.isEnableUpdate(modelState)) {
          context.srfreadonly = true;
        }
        this.navPos.openView({
          key: data.srfkey,
          viewId: ref.refAppViewId,
          context
        });
      } else {
        throw new RuntimeModelError(
          this.view.model,
          "\u672A\u5339\u914D\u5230\u5BF9\u5E94[".concat(data.srftype, "]\u7684\u5C5E\u6027\u7F16\u8F91\u89C6\u56FE")
        );
      }
    }
  }
}

export { DndDesignViewEngine };
