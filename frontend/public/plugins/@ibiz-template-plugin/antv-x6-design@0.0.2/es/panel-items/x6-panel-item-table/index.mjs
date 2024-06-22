import { registerPanelItemProvider } from '@ibiz-template/runtime';
import X6PanelItemTable$1 from './x6-panel-item-table.mjs';
import { X6PanelItemTableProvider } from './x6-panel-item-table.provider.mjs';

"use strict";
var X6PanelItemTable = {
  install(app) {
    app.component("IBizX6PanelItemTable", X6PanelItemTable$1);
    registerPanelItemProvider(
      "FIELD_X6_PANEL_ITEM_TABLE",
      () => new X6PanelItemTableProvider()
    );
  }
};

export { X6PanelItemTable as default };
