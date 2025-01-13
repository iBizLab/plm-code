/* eslint-disable no-empty-function */
import { IAppView, IPanelContainer } from '@ibiz/model-core';
import { PanelItemController } from '@ibiz-template/runtime';
import { PreviewContentState } from './preview-content.state';
import { PreviewViewControllerBase } from '../../views';
import { IPreviewViewEvent, IPreviewViewState } from '../../interface';

/**
 * 预览内容区控制器
 *
 * @export
 * @class PreviewContentController
 * @extends {PanelItemController<IPanelContainer>}
 */
export class PreviewContentController extends PanelItemController<IPanelContainer> {
  /**
   * 预览内容区状态
   *
   * @type {PreviewContentState}
   * @memberof PreviewContentController
   */
  declare state: PreviewContentState;

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
  get view(): PreviewViewControllerBase<
    IAppView,
    IPreviewViewState,
    IPreviewViewEvent
  > {
    return this.panel.view as PreviewViewControllerBase<
      IAppView,
      IPreviewViewState,
      IPreviewViewEvent
    >;
  }

  /**
   * 主数据
   *
   * @readonly
   * @type {IData}
   * @memberof PreviewContentController
   */
  get majorData(): IData {
    return this.view.state.data;
  }

  /**
   * 创建面板状态对象
   *
   * @protected
   * @return {*}  {PreviewContentState}
   * @memberof PreviewContentController
   */
  protected createState(): PreviewContentState {
    return new PreviewContentState(this.parent?.state);
  }

  /**
   * 初始化
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof PreviewContentController
   */
  protected async onInit(): Promise<void> {
    await super.onInit();
    // 加载数据
    await this.load();
    // 初始化子项数据
    await this.initItems();
  }

  /**
   * 加载数据
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof PreviewContentController
   */
  protected async load(): Promise<void> {}

  /**
   * 初始化子项数据
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof PreviewContentController
   */
  protected async initItems(): Promise<void> {}
}
