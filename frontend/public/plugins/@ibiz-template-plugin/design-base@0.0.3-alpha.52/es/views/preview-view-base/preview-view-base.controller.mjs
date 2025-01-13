import { ViewController } from '@ibiz-template/runtime';
import { PreviewViewEngineBase } from './preview-view-base.engine.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class PreviewViewControllerBase extends ViewController {
  constructor() {
    super(...arguments);
    /**
     * 预览适配器
     *
     * @public
     * @type {IDesignPreviewProvider}
     * @memberof PreviewViewControllerBase
     */
    __publicField(this, "preViewProvider");
  }
  /**
   * 获取预览区适配器
   *
   * @return {*}  {IDesignPreviewProvider}
   * @memberof PreviewViewControllerBase
   */
  getPreViewProvider() {
    return this.preViewProvider;
  }
  /**
   * 生命周期-创建完成
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof PreviewViewControllerBase
   */
  async onCreated() {
    await super.onCreated();
    this.context.srfrunmode = "DESIGN";
    await this.initPreViewProvider();
  }
  /**
   * 初始化预览视图引擎
   *
   * @protected
   * @memberof PreviewViewControllerBase
   */
  initEngines() {
    this.engines.push(new PreviewViewEngineBase(this));
  }
  /**
   * 初始化预览编辑器
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof PreviewViewControllerBase
   */
  async initPreViewProvider() {
    throw new Error("Method not implemented.");
  }
}

export { PreviewViewControllerBase };
