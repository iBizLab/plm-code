import { UIActionProviderBase, IUILogicParams, IUIActionResult } from '@ibiz-template/runtime';
import { IAppDEUIAction } from '@ibiz/model-core';
/**
 * 后台调用界面行为适配器(添加逻辑)
 * 配置userTag作为加载的代码表来源
 * 配置视图参数转换作为新建给服务层的数据
 * 代码表选中的数据在上下文的srfselectedtype里，配置转换填充
 *
 * @author lxm
 * @date 2022-10-25 15:10:51
 * @export
 * @class BackendUIActionProvider
 * @implements {IUIActionProvider}
 */
export declare class AddLogicProvider extends UIActionProviderBase {
    execAction(action: IAppDEUIAction, args: IUILogicParams): Promise<IUIActionResult>;
}
