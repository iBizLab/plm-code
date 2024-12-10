import { CTX, IViewController, IViewProvider } from '@ibiz-template/runtime';
import { IAppDECustomView } from '@ibiz/model-core';
/**
 * 视图适配器
 *
 * @author lxm
 * @date 2022-10-25 18:10:57
 * @export
 * @class DndDesignViewProvider
 * @implements {IViewProvider}
 */
export declare class DndDesignViewProvider implements IViewProvider {
    component: string;
    createController(model: IAppDECustomView, context: IContext, params?: IParams, ctx?: CTX): IViewController;
}
