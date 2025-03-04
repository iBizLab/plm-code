import { registerPanelItemProvider } from '@ibiz-template/runtime';
import { DndDesignPreviewButtonProvider } from './dnd-design-preview-button.provider.mjs';
import DndDesignPreviewButton$1 from './dnd-design-preview-button.mjs';

"use strict";
var DndDesignPreviewButton = {
  install(app) {
    app.component("IBizDndDesignPreviewButton", DndDesignPreviewButton$1);
    registerPanelItemProvider(
      "FIELD_DND_DESIGN_PREVIEW_BUTTON",
      () => new DndDesignPreviewButtonProvider()
    );
  }
};

export { DndDesignPreviewButton as default };
