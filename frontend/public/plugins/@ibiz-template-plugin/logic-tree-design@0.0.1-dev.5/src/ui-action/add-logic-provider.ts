import { RuntimeModelError } from '@ibiz-template/core';
import {
  UIActionProviderBase,
  IUILogicParams,
  IUIActionResult,
  CodeListItem,
} from '@ibiz-template/runtime';
import { IAppDEUIAction } from '@ibiz/model-core';
import { isArray } from 'qx-util';
import { CodeListSelect } from '../components';

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
export class AddLogicProvider extends UIActionProviderBase {
  async execAction(
    action: IAppDEUIAction,
    args: IUILogicParams,
  ): Promise<IUIActionResult> {
    const { context, params, data, event } = args;
    const actionResult: IUIActionResult = {};
    const entityName = action.appDataEntityId;
    const methodName = action.appDEMethodId;
    if (!entityName || !methodName) {
      throw new RuntimeModelError(action, '未配置实体或实体行为');
    }

    const _context = context.clone();

    // 根据userTag配置的代码表选择，然后会写入到当前的上文的srfselectedtype
    const codeListId = (action as IData).userTag;
    if (codeListId) {
      let selectedItem: CodeListItem | null = null;
      const overlay = ibiz.overlay.createPopover(
        CodeListSelect,
        {
          codeListId,
          context: _context,
          params,
          onSelect: (item: CodeListItem) => {
            selectedItem = item;
            overlay.dismiss();
          },
        },
        {
          autoClose: true,
          placement: 'right',
          noArrow: true,
        },
      );

      overlay.present(event!.target as HTMLElement);
      await overlay.onWillDismiss();

      // 没选就关闭了，是取消
      if (!selectedItem) {
        return { cancel: true };
      }
      _context.srfselectedtype = (selectedItem as CodeListItem).value;
    }

    //! 处理参数，需要配置srfselectedtype的转换,才能在视图参数里有对应的参数
    const { resultContext, resultParams } = await this.handleParams(
      action,
      _context,
      data,
      params,
    );
    const tempParams = { ...resultParams };

    const app = ibiz.hub.getApp(_context?.srfappid);
    const res = await app.deService.exec(
      entityName!,
      methodName,
      resultContext,
      tempParams,
    );

    // 适配界面行为成功提示信息
    if (res.ok) {
      const successMsg = this.calcMessage('success', action, args);
      if (successMsg) {
        ibiz.message.success(successMsg);
      }
    }
    Object.assign(actionResult, {
      data: isArray(res.data) ? res.data : [res.data],
      nextContext: resultContext,
      nextParams: tempParams,
      toSelectSrfkey: res.data.srfkey,
    });

    return actionResult;
  }
}
