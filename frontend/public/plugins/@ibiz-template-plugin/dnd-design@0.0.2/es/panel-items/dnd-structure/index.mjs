import { registerPanelItemProvider } from '@ibiz-template/runtime';
import DndStructure$1 from './dnd-structure.mjs';
import { DndStructurePanelItemProvider } from './dnd-structure.provider.mjs';

"use strict";
var DndStructure = {
  install(app) {
    app.component("IBizDndStructurePanelItem", DndStructure$1);
    registerPanelItemProvider(
      "FIELD_DND_PANEL_STRUCTURE",
      () => new DndStructurePanelItemProvider()
    );
  }
};

export { DndStructure as default };
