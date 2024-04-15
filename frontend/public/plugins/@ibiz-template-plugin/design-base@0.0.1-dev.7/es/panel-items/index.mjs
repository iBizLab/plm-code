import ActiveHomeButton from './active-home-button/index.mjs';

"use strict";
var PanelItems = {
  install(app) {
    app.use(ActiveHomeButton);
  }
};

export { PanelItems as default };
