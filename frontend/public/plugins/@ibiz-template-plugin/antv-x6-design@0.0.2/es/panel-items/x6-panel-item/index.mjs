import { registerPanelItemProvider } from '@ibiz-template/runtime';
import X6PanelItem$1 from './x6-panel-item.mjs';
import { X6PanelItemProvider } from './x6-panel-item.provider.mjs';

"use strict";
var X6PanelItem = {
  install(app) {
    app.component("IBizX6PanelItem", X6PanelItem$1);
    registerPanelItemProvider(
      "RAWITEM_X6_PANEL_ITEM",
      () => new X6PanelItemProvider()
    );
  }
};

export { X6PanelItem as default };
