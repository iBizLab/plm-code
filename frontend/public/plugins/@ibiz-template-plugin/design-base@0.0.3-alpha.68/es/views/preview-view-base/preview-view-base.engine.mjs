import { ViewEngineBase } from '@ibiz-template/runtime';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class PreviewViewEngineBase extends ViewEngineBase {
  constructor() {
    super(...arguments);
    /**
     * 主实体服务
     *
     * @protected
     * @type {IAppDEService}
     * @memberof PreviewViewEngineBase
     */
    __publicField(this, "service");
  }
  /**
   * 初始化tab导航
   *
   * @author zhanghengfeng
   * @date 2025-02-11 18:02:31
   * @protected
   * @return {*}  {void}
   */
  initNavTab() {
    var _a, _b, _c, _d;
    const parentView = this.view.parentView;
    if (!parentView) {
      return;
    }
    const panelItems = (_a = parentView.layoutPanel) == null ? void 0 : _a.panelItems;
    if (!panelItems || !panelItems.nav_pos_index) {
      return;
    }
    const navPosIndex = panelItems.nav_pos_index;
    if (navPosIndex.navTabs && ((_b = navPosIndex.state) == null ? void 0 : _b.currentKey)) {
      const key = navPosIndex.state.currentKey;
      (_d = (_c = navPosIndex.navTabs).updateViewInfo) == null ? void 0 : _d.call(_c, key, {
        caption: this.view.model.caption,
        sysImage: this.view.model.sysImage
      });
    }
  }
  /**
   * 视图created生命周期执行逻辑
   *
   * @return {*}  {Promise<void>}
   * @memberof PreviewViewEngineBase
   */
  async onCreated() {
    await super.onCreated();
    this.initNavTab();
    await this.initDeService();
    await this.load();
  }
  /**
   * 初始化实体服务
   *
   * @return {*}  {Promise<void>}
   * @memberof PreviewViewEngineBase
   */
  async initDeService() {
    const { appId, appDataEntityId } = this.view.model;
    const app = ibiz.hub.getApp(appId);
    this.service = await app.deService.getService(
      this.view.context,
      appDataEntityId
    );
  }
  /**
   * 加载主数据
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof PreviewViewEngineBase
   */
  async load() {
    try {
      this.view.startLoading();
      const res = await this.service.get(this.view.context, this.view.params);
      if (res.ok && res.data) {
        this.view.state.data = res.data;
      }
    } finally {
      this.view.endLoading();
    }
  }
}

export { PreviewViewEngineBase };
