import { registerPanelItemProvider } from '@ibiz-template/runtime';
import ActiveHomeButton$1 from './active-home-button.mjs';
import { ActiveHomeButtonProvider } from './active-home-button.provider.mjs';

"use strict";
var ActiveHomeButton = {
  install(app) {
    app.component("IBizActiveHomeButton", ActiveHomeButton$1);
    registerPanelItemProvider(
      "FIELD_ACTIVE_HOME_BUTTON",
      () => new ActiveHomeButtonProvider()
    );
  }
};

export { ActiveHomeButton as default };
