import { registerPanelItemProvider } from '@ibiz-template/runtime';
import X6PanelItemStencil$1 from './x6-panel-item-stencil.mjs';
import { X6PanelItemStencilProvider } from './x6-panel-item-stencil.provider.mjs';

"use strict";
var X6PanelItemStencil = {
  install(app) {
    app.component("IBizX6PanelItemStencil", X6PanelItemStencil$1);
    registerPanelItemProvider(
      "FIELD_X6_PANEL_ITEM_STENCIL",
      () => new X6PanelItemStencilProvider()
    );
  }
};

export { X6PanelItemStencil as default };
