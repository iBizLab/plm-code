import { PanelItemController } from '@ibiz-template/runtime';
import { PreviewContentState } from './preview-content.state.mjs';

"use strict";
class PreviewContentController extends PanelItemController {
  /**
   * 预览视图控制器
   *
   * @readonly
   * @type {PreviewViewControllerBase<
   *     IAppView,
   *     IPreviewViewState,
   *     IPreviewViewEvent
   *   >}
   * @memberof PreviewContentController
   */
  get view() {
    return this.panel.view;
  }
  /**
   * 主数据
   *
   * @readonly
   * @type {IData}
   * @memberof PreviewContentController
   */
  get majorData() {
    return this.view.state.data;
  }
  /**
   * 创建面板状态对象
   *
   * @protected
   * @return {*}  {PreviewContentState}
   * @memberof PreviewContentController
   */
  createState() {
    var _a;
    return new PreviewContentState((_a = this.parent) == null ? void 0 : _a.state);
  }
  /**
   * 初始化
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof PreviewContentController
   */
  async onInit() {
    await super.onInit();
    await this.load();
    await this.initItems();
  }
  /**
   * 加载数据
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof PreviewContentController
   */
  async load() {
  }
  /**
   * 初始化子项数据
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof PreviewContentController
   */
  async initItems() {
  }
}

export { PreviewContentController };
