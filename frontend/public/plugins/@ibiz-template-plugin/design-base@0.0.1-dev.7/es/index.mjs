import PanelItems from './panel-items/index.mjs';
import './style/index.css';

"use strict";
var index = {
  install(app) {
    app.use(PanelItems);
  }
};

export { index as default };
