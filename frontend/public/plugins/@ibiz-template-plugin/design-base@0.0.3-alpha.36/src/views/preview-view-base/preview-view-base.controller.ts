import { IAppView } from '@ibiz/model-core';
import { ViewController } from '@ibiz-template/runtime';
import {
  IDesignPreviewProvider,
  IPreviewViewEvent,
  IPreviewViewState,
} from '../../interface';
import { PreviewViewEngineBase } from './preview-view-base.engine';

/**
 * 预览视图控制器基类
 *
 * @export
 * @class PreviewViewControllerBase
 * @extends {ViewController<M, S, E>}
 * @template M
 * @template S
 * @template E
 */
export class PreviewViewControllerBase<
  M extends IAppView,
  S extends IPreviewViewState,
  E extends IPreviewViewEvent,
> extends ViewController<M, S, E> {
  /**
   * 预览适配器
   *
   * @public
   * @type {IDesignPreviewProvider}
   * @memberof PreviewViewControllerBase
   */
  public preViewProvider!: IDesignPreviewProvider;

  /**
   * 获取预览区适配器
   *
   * @return {*}  {IDesignPreviewProvider}
   * @memberof PreviewViewControllerBase
   */
  public getPreViewProvider(): IDesignPreviewProvider {
    return this.preViewProvider;
  }

  /**
   * 生命周期-创建完成
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof PreviewViewControllerBase
   */
  protected async onCreated(): Promise<void> {
    await super.onCreated();
    this.context.srfrunmode = 'DESIGN';
    await this.initPreViewProvider();
  }

  /**
   * 初始化预览视图引擎
   *
   * @protected
   * @memberof PreviewViewControllerBase
   */
  protected initEngines(): void {
    this.engines.push(new PreviewViewEngineBase(this));
  }

  /**
   * 初始化预览编辑器
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof PreviewViewControllerBase
   */
  protected async initPreViewProvider(): Promise<void> {
    throw new Error('Method not implemented.');
  }
}
