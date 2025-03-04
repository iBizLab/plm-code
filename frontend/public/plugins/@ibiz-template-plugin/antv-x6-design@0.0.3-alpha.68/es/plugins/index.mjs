import LogicDesignPlugin from './logic-design/index.mjs';
import workFlowDesign from './work-flow-design/index.mjs';

"use strict";
var Plugins = {
  install(app) {
    app.use(LogicDesignPlugin);
    app.use(workFlowDesign);
  }
};

export { Plugins as default };
