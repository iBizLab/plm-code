import { registerPanelItemProvider } from '@ibiz-template/runtime';
import './dnd-stencil-field/index.mjs';
import FormLogicEventScript from './form-logic-event-script/index.mjs';
import './dnd-stencil-editor/index.mjs';
import { DndStencilFieldProvider } from './dnd-stencil-field/dnd-stencil-field.provider.mjs';
import { DndStencilEditorProvider } from './dnd-stencil-editor/dnd-stencil-editor.provider.mjs';

"use strict";
var Plugins = {
  install(v) {
    registerPanelItemProvider(
      "FIELD_DND_PANEL_ITEM_STENCIL_FIELD",
      () => new DndStencilFieldProvider()
    );
    v.use(FormLogicEventScript);
    registerPanelItemProvider(
      "FIELD_DND_PANEL_ITEM_STENCIL_EDITOR",
      () => new DndStencilEditorProvider()
    );
  }
};

export { Plugins as default };
