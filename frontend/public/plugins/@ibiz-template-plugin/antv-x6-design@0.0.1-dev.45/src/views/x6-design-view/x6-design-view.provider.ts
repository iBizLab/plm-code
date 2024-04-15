import { CTX, IViewController, IViewProvider } from '@ibiz-template/runtime';
import { IAppDECustomView } from '@ibiz/model-core';
import { X6DesignViewController } from './x6-design-view.controller';

/**
 * 视图适配器
 *
 * @author lxm
 * @date 2022-10-25 18:10:57
 * @export
 * @class ViewProvider
 * @implements {IViewProvider}
 */
export class X6DesignViewProvider implements IViewProvider {
  component: string = 'IBizView';

  createController(
    model: IAppDECustomView,
    context: IContext,
    params?: IParams,
    ctx?: CTX,
  ): IViewController {
    const c = new X6DesignViewController(model, context, params, ctx);
    return c;
  }
}
