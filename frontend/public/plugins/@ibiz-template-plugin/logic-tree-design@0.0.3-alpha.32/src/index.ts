import { App } from 'vue';
import { registerUIActionProvider } from '@ibiz-template/runtime';
import { AddLogicProvider } from './ui-action/add-logic-provider';
import { IBizLogicTreeDesignTree } from './control';
import { PackageTag } from './const';

export default {
  install(app: App) {
    // * 注册界面行为
    // 新增后台界面行为插件
    const addLogicProvider = new AddLogicProvider();
    registerUIActionProvider(
      `DEUIACTION_${PackageTag}_AddLogic`,
      () => addLogicProvider,
    );

    // *注册部件
    app.use(IBizLogicTreeDesignTree);
  },
};
