import { registerPanelItemProvider } from '@ibiz-template/runtime';
import X6PanelItemSwitch$1 from './x6-panel-item-switch.mjs';
import { X6PanelItemSwitchProvider } from './x6-panel-item-switch.provider.mjs';

"use strict";
var X6PanelItemSwitch = {
  install(app) {
    app.component("IBizX6PanelItemSwitch", X6PanelItemSwitch$1);
    registerPanelItemProvider(
      "FIELD_X6_PANEL_ITEM_SWITCH",
      () => new X6PanelItemSwitchProvider()
    );
  }
};

export { X6PanelItemSwitch as default };
