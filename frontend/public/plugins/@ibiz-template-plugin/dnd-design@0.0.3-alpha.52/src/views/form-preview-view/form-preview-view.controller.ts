import { IAppDECustomView } from '@ibiz/model-core';
import {
  IPreviewViewState,
  IPreviewViewEvent,
  PreviewViewControllerBase,
} from '@ibiz-template-plugin/design-base';
import { FormPreviewViewEngine } from './form-preview-view.engine';
import { DndPreViewFactory } from '../../preview-providers/dnd-preview-factory';
import { IPreviewProvider } from '../../interface';

/**
 * 表单预览视图控制器
 *
 * @export
 * @class FormPreviewViewController
 * @extends {PreviewViewControllerBase<IAppDECustomView, IPreviewViewState, IPreviewViewEvent>}
 */
export class FormPreviewViewController extends PreviewViewControllerBase<
  IAppDECustomView,
  IPreviewViewState,
  IPreviewViewEvent
> {
  /**
   * 初始化预览适配器
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof FormPreviewViewController
   */
  protected async initPreViewProvider(): Promise<void> {
    this.preViewProvider = DndPreViewFactory.getInstance().getProvider(
      'DESIGN',
    ) as IPreviewProvider;
    await this.preViewProvider.init(this);
  }

  /**
   * 初始化引擎
   *
   * @protected
   * @memberof FormPreviewViewController
   */
  protected initEngines(): void {
    this.engines.push(new FormPreviewViewEngine(this));
  }
}
