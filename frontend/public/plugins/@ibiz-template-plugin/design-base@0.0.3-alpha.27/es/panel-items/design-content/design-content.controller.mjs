import { createUUID } from 'qx-util';
import { PanelItemController, getControl } from '@ibiz-template/runtime';
import { DesignContentState } from './design_content.state.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DesignContentController extends PanelItemController {
  constructor() {
    super(...arguments);
    /**
     * 主服务
     *
     * @author tony001
     * @date 2024-09-10 14:09:22
     * @protected
     * @type {IAppDEService}
     */
    __publicField(this, "majorService");
    /**
     * 从数据服务
     *
     * @author tony001
     * @date 2024-09-10 14:09:31
     * @protected
     * @type {IAppDEService}
     */
    __publicField(this, "itemService");
    /**
     * 主实体
     *
     * @author tony001
     * @date 2024-09-10 14:09:46
     * @protected
     * @type {IAppDataEntity}
     */
    __publicField(this, "majorEntity");
    /**
     * 从实体
     *
     * @author tony001
     * @date 2024-09-10 14:09:05
     * @protected
     * @type {IAppDataEntity}
     */
    __publicField(this, "itemEntity");
  }
  /**
   * 主表单
   *
   * @author tony001
   * @date 2024-09-10 14:09:17
   * @readonly
   * @type {IDEEditForm}
   */
  get majorForm() {
    return getControl(this.view.model, "form");
  }
  /**
   * 项表单
   *
   * @author tony001
   * @date 2024-09-10 14:09:26
   * @readonly
   * @type {IDEEditForm}
   */
  get itemForm() {
    return getControl(this.view.model, "item");
  }
  /**
   * 视图对象
   *
   * @author tony001
   * @date 2024-09-10 15:09:46
   * @readonly
   * @type {DesignViewControllerBase<
   *     IAppView,
   *     IDesignViewState,
   *     IDesignViewEvent
   *   >}
   */
  get view() {
    return this.panel.view;
  }
  /**
   * 创建面板状态对象
   *
   * @author tony001
   * @date 2024-09-10 14:09:24
   * @protected
   * @return {*}  {DesignContentState}
   */
  createState() {
    var _a;
    return new DesignContentState((_a = this.parent) == null ? void 0 : _a.state);
  }
  /**
   * 初始化
   *
   * @author tony001
   * @date 2024-08-19 16:08:12
   * @protected
   * @return {*}  {Promise<void>}
   */
  async onInit() {
    await super.onInit();
    await this.initBaseResource();
    await this.load();
    await this.subscribeDataChange();
  }
  /**
   * 初始化基础资源
   *
   * @author tony001
   * @date 2024-09-10 15:09:30
   * @protected
   */
  async initBaseResource() {
    const app = ibiz.hub.getApp(this.view.model.appId);
    this.majorEntity = await ibiz.hub.getAppDataEntity(
      this.majorForm.appDataEntityId,
      this.view.model.appId
    );
    this.majorService = await app.deService.getService(
      this.panel.context,
      this.majorForm.appDataEntityId
    );
    this.itemEntity = await ibiz.hub.getAppDataEntity(
      this.itemForm.appDataEntityId,
      this.view.model.appId
    );
    this.itemService = await app.deService.getService(
      this.panel.context,
      this.itemForm.appDataEntityId
    );
  }
  /**
   * 订阅数据变化
   *
   * @author tony001
   * @date 2024-09-10 15:09:10
   * @protected
   */
  async subscribeDataChange() {
    this.refresh = this.refresh.bind(this);
    this.onDEDataChange = this.onDEDataChange.bind(this);
    this.view.evt.on("onUpdateSuccess", this.refresh);
    this.view.evt.on("onCreateSuccess", this.refresh);
    this.view.evt.on("onRemoveSuccess", this.refresh);
    ibiz.mc.command.change.on(this.onDEDataChange);
  }
  /**
   * 取消订阅数据变化
   *
   * @author tony001
   * @date 2024-09-10 15:09:06
   * @protected
   * @return {*}  {Promise<void>}
   */
  async unSubscribeDataChange() {
    this.view.evt.off("onUpdateSuccess", this.refresh);
    this.view.evt.off("onCreateSuccess", this.refresh);
    this.view.evt.off("onRemoveSuccess", this.refresh);
    ibiz.mc.command.change.off(this.onDEDataChange);
  }
  /**
   * 加载数据
   *
   * @author tony001
   * @date 2024-09-04 09:09:05
   * @protected
   * @return {*}  {Promise<void>}
   */
  async load() {
    const majorResult = await this.majorService.getTemp(
      this.panel.context,
      this.panel.params
    );
    if (majorResult.ok && majorResult.data) {
      const majorData = majorResult.data;
      const itemResult = await this.itemService.fetchDefault(
        this.panel.context,
        this.panel.params
      );
      if (itemResult.ok && itemResult.data) {
        const itemDatas = itemResult.data;
        await this.afterLoad({ majorData, itemDatas });
      }
    }
  }
  /**
   * 加载之后
   *
   * @author tony001
   * @date 2024-09-10 15:09:35
   * @protected
   * @return {*}  {Promise<void>}
   */
  async afterLoad(args) {
    const { majorData, itemDatas } = args;
    this.state.majorData = majorData;
    this.state.itemDatas.length = 0;
    this.state.itemDatas.push(...itemDatas);
  }
  /**
   * 刷新
   *
   * @author tony001
   * @date 2024-09-10 15:09:27
   * @protected
   * @return {*}  {Promise<void>}
   */
  async refresh() {
    await this.load();
    this.state.refreshTag = createUUID();
  }
  /**
   * 监听数据变化
   *
   * @author tony001
   * @date 2024-09-10 15:09:25
   * @protected
   * @param {IPortalMessage} msg
   */
  onDEDataChange(msg) {
    const { data } = msg;
    if (data && data.srfdecodename === this.itemEntity.codeName) {
      this.refresh();
    }
  }
  /**
   * 销毁
   *
   * @author tony001
   * @date 2024-09-02 18:09:42
   */
  destroy() {
    super.destroy();
    this.unSubscribeDataChange();
  }
}

export { DesignContentController };
