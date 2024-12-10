import { UIActionProviderBase, IUILogicParams, IUIActionResult } from '@ibiz-template/runtime';
import { IAppDEUIAction } from '@ibiz/model-core';
export declare class RefreshFieldProvider extends UIActionProviderBase {
    execAction(_action: IAppDEUIAction, args: IUILogicParams): Promise<IUIActionResult>;
}
