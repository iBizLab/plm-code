import { registerPanelItemProvider } from '@ibiz-template/runtime';
import './dnd-stencil-field/index.mjs';
import { DndStencilFieldProvider } from './dnd-stencil-field/dnd-stencil-field.provider.mjs';

"use strict";
var Plugins = {
  install(_app) {
    registerPanelItemProvider(
      "FIELD_DND_PANEL_ITEM_STENCIL_FIELD",
      () => new DndStencilFieldProvider()
    );
  }
};

export { Plugins as default };
