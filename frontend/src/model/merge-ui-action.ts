import { IApplication } from '@ibiz/model-core';
import { mergeModel } from './merge-model';

const PSSysApp = {
  appDEUIActions: {
    New: {
      refreshMode: 1,
      reloadData: true,
      showBusyIndicator: true,
    },
    Save: {
      showBusyIndicator: false,
    },
  },
};

/**
 * 合并处理全局界面行为模型
 * @author lxm
 * @date 2024-03-26 02:28:21
 * @export
 * @param {IApplication} app
 * @return {*}  {IApplication}
 */
export function mergeUIActions(app: IApplication): IApplication {
  // 特殊处理预置全局界面行为，附加一些特殊的模板预置模型
  if (app.appDEUIActions) {
    mergeModel(app.appDEUIActions, PSSysApp.appDEUIActions, 'codeName');
  }
  return app;
}
