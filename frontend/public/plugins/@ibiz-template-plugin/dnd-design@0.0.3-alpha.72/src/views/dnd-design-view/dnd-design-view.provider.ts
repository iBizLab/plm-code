import { CTX, IViewController, IViewProvider } from '@ibiz-template/runtime';
import { IAppDECustomView } from '@ibiz/model-core';
import { DndDesignViewController } from './dnd-design-view.controller';

/**
 * 视图适配器
 *
 * @author lxm
 * @date 2022-10-25 18:10:57
 * @export
 * @class DndDesignViewProvider
 * @implements {IViewProvider}
 */
export class DndDesignViewProvider implements IViewProvider {
  component: string = 'IBizView';

  createController(
    model: IAppDECustomView,
    context: IContext,
    params?: IParams,
    ctx?: CTX,
  ): IViewController {
    const c = new DndDesignViewController(model, context, params, ctx);
    return c;
  }
}
