import { IAppDECustomView } from '@ibiz/model-core';
import { CTX, IViewController, IViewProvider } from '@ibiz-template/runtime';
/**
 * 表单预览视图适配器
 *
 * @export
 * @class FormPreviewViewProvider
 * @implements {IViewProvider}
 */
export declare class FormPreviewViewProvider implements IViewProvider {
    component: string;
    createController(model: IAppDECustomView, context: IContext, params?: IParams, ctx?: CTX): IViewController;
}
