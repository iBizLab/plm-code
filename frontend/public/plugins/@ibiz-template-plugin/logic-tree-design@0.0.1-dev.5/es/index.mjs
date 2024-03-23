import { registerUIActionProvider } from '@ibiz-template/runtime';
import { AddLogicProvider } from './ui-action/add-logic-provider.mjs';
import './control/index.mjs';
import { PackageTag } from './const/index.mjs';
import { IBizLogicTreeDesignTree } from './control/tree/index.mjs';

"use strict";
var index = {
  install(app) {
    const addLogicProvider = new AddLogicProvider();
    registerUIActionProvider(
      "DEUIACTION_".concat(PackageTag, "_AddLogic"),
      () => addLogicProvider
    );
    app.use(IBizLogicTreeDesignTree);
  }
};

export { index as default };
