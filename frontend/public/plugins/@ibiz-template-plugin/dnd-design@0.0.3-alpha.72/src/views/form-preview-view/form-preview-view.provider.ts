import { IAppDECustomView } from '@ibiz/model-core';
import { CTX, IViewController, IViewProvider } from '@ibiz-template/runtime';
import { FormPreviewViewController } from './form-preview-view.controller';

/**
 * 表单预览视图适配器
 *
 * @export
 * @class FormPreviewViewProvider
 * @implements {IViewProvider}
 */
export class FormPreviewViewProvider implements IViewProvider {
  component: string = 'IBizView';

  createController(
    model: IAppDECustomView,
    context: IContext,
    params?: IParams,
    ctx?: CTX,
  ): IViewController {
    const c = new FormPreviewViewController(model, context, params, ctx);
    return c;
  }
}
