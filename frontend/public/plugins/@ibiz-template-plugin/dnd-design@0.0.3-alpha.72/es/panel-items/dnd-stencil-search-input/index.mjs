import { registerPanelItemProvider } from '@ibiz-template/runtime';
import DndStencilSearchInput$1 from './dnd-stencil-search-input.mjs';
import { DndStencilSearchInputProvider } from './dnd-stencil-search-input.provider.mjs';

"use strict";
var DndStencilSearchInput = {
  install(app) {
    app.component("IBizDndStencilSearchInput", DndStencilSearchInput$1);
    registerPanelItemProvider(
      "FIELD_DND_PANEL_ITEM_STENCIL_SEARCH",
      () => new DndStencilSearchInputProvider()
    );
  }
};

export { DndStencilSearchInput as default };
