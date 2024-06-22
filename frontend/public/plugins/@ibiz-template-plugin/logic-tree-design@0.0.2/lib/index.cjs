'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var runtime = require('@ibiz-template/runtime');
var addLogicProvider = require('./ui-action/add-logic-provider.cjs');
require('./control/index.cjs');
var index$1 = require('./const/index.cjs');
var index$2 = require('./control/tree/index.cjs');

"use strict";
var index = {
  install(app) {
    const addLogicProvider$1 = new addLogicProvider.AddLogicProvider();
    runtime.registerUIActionProvider(
      "DEUIACTION_".concat(index$1.PackageTag, "_AddLogic"),
      () => addLogicProvider$1
    );
    app.use(index$2.IBizLogicTreeDesignTree);
  }
};

exports.default = index;
