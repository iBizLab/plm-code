import { registerPanelItemProvider } from '@ibiz-template/runtime';
import { DndDesignPanelItemProvider } from './dnd-design.provider.mjs';
import DndDesign$1 from './dnd-design.mjs';

"use strict";
var DndDesign = {
  install(app) {
    app.component("IBizDndDesignPanelItem", DndDesign$1);
    registerPanelItemProvider(
      "RAWITEM_DND_DESIGN_PANEL_ITEM",
      () => new DndDesignPanelItemProvider()
    );
  }
};

export { DndDesign as default };
