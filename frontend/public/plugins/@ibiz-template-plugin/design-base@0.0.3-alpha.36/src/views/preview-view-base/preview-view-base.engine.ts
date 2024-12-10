import { IAppView } from '@ibiz/model-core';
import { IAppDEService, ViewEngineBase } from '@ibiz-template/runtime';
import { PreviewViewControllerBase } from './preview-view-base.controller';
import { IPreviewViewEvent, IPreviewViewState } from '../../interface';

/**
 * 预览视图引擎基类
 *
 * @export
 * @class PreviewViewEngineBase
 * @extends {ViewEngineBase}
 */
export class PreviewViewEngineBase extends ViewEngineBase {
  /**
   * 视图控制器
   *
   * @protected
   * @type {PreviewViewControllerBase<
   *     IAppView,
   *     IPreviewViewState,
   *     IPreviewViewEvent
   *   >}
   * @memberof PreviewViewEngineBase
   */
  protected declare view: PreviewViewControllerBase<
    IAppView,
    IPreviewViewState,
    IPreviewViewEvent
  >;

  /**
   * 主实体服务
   *
   * @protected
   * @type {IAppDEService}
   * @memberof PreviewViewEngineBase
   */
  protected service!: IAppDEService;

  /**
   * 视图created生命周期执行逻辑
   *
   * @return {*}  {Promise<void>}
   * @memberof PreviewViewEngineBase
   */
  async onCreated(): Promise<void> {
    await super.onCreated();
    await this.initDeService();
    await this.load();
  }

  /**
   * 初始化实体服务
   *
   * @return {*}  {Promise<void>}
   * @memberof PreviewViewEngineBase
   */
  async initDeService(): Promise<void> {
    const { appId, appDataEntityId } = this.view.model;
    const app = ibiz.hub.getApp(appId);
    this.service = await app.deService.getService(
      this.view.context,
      appDataEntityId!,
    );
  }

  /**
   * 加载主数据
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof PreviewViewEngineBase
   */
  protected async load(): Promise<void> {
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
