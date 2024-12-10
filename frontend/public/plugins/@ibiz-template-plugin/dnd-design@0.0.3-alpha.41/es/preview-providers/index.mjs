import { DndPreViewFactory } from './dnd-preview-factory.mjs';
import { DndDesignPreViewProvider } from './design-preview-provider.mjs';
import { DndRuntimePreViewProvider } from './runtime-preview-provider.mjs';

"use strict";
var PreviewProviders = {
  install(app) {
    DndPreViewFactory.getInstance().registerProvider(
      "DESIGN",
      new DndDesignPreViewProvider()
    );
    DndPreViewFactory.getInstance().registerProvider(
      "RUNTIME",
      new DndRuntimePreViewProvider()
    );
  }
};

export { PreviewProviders as default };
