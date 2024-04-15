import { RuntimeModelError } from '@ibiz-template/core';
import { UIActionProviderBase } from '@ibiz-template/runtime';
import { isArray } from 'qx-util';
import '../components/index.mjs';
import { CodeListSelect } from '../components/codelist-select/codelist-select.mjs';

"use strict";
class AddLogicProvider extends UIActionProviderBase {
  async execAction(action, args) {
    const { context, params, data, event } = args;
    const actionResult = {};
    const entityName = action.appDataEntityId;
    const methodName = action.appDEMethodId;
    if (!entityName || !methodName) {
      throw new RuntimeModelError(action, "\u672A\u914D\u7F6E\u5B9E\u4F53\u6216\u5B9E\u4F53\u884C\u4E3A");
    }
    const _context = context.clone();
    const codeListId = action.userTag;
    if (codeListId) {
      let selectedItem = null;
      const overlay = ibiz.overlay.createPopover(
        CodeListSelect,
        {
          codeListId,
          context: _context,
          params,
          onSelect: (item) => {
            selectedItem = item;
            overlay.dismiss();
          }
        },
        {
          autoClose: true,
          placement: "right",
          noArrow: true
        }
      );
      overlay.present(event.target);
      await overlay.onWillDismiss();
      if (!selectedItem) {
        return { cancel: true };
      }
      _context.srfselectedtype = selectedItem.value;
    }
    //! 处理参数，需要配置srfselectedtype的转换,才能在视图参数里有对应的参数
    const { resultContext, resultParams } = await this.handleParams(
      action,
      _context,
      data,
      params
    );
    const tempParams = { ...resultParams };
    const app = ibiz.hub.getApp(_context == null ? void 0 : _context.srfappid);
    const res = await app.deService.exec(
      entityName,
      methodName,
      resultContext,
      tempParams
    );
    if (res.ok) {
      const successMsg = this.calcMessage("success", action, args);
      if (successMsg) {
        ibiz.message.success(successMsg);
      }
    }
    Object.assign(actionResult, {
      data: isArray(res.data) ? res.data : [res.data],
      nextContext: resultContext,
      nextParams: tempParams,
      toSelectSrfkey: res.data.srfkey
    });
    return actionResult;
  }
}

export { AddLogicProvider };
