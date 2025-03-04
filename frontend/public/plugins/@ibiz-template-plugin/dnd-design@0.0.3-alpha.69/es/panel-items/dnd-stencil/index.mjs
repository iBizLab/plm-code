import { registerPanelItemProvider } from '@ibiz-template/runtime';
import { DndStencilPanelItemProvider } from './dnd-stencil.provider.mjs';
import DndStencil$1 from './dnd-stencil.mjs';

"use strict";
var DndStencil = {
  install(app) {
    app.component("IBizDndStencilPanelItem", DndStencil$1);
    registerPanelItemProvider(
      "FIELD_DND_PANEL_ITEM_STENCIL",
      () => new DndStencilPanelItemProvider()
    );
  }
};

export { DndStencil as default };
