import VueDraggable from 'vuedraggable';
import DndDesign from './dnd-design/index.mjs';
import DndStencil from './dnd-stencil/index.mjs';
import DndStructure from './dnd-structure/index.mjs';
import DndStencilSearchInput from './dnd-stencil-search-input/index.mjs';
import HiddenFormItemSwitch from './hidden-form-item-switch/index.mjs';
import FormPreviewContent from './form-preview-content/index.mjs';

"use strict";
var PanelItems = {
  install(app) {
    app.component("IBizDraggable", VueDraggable);
    app.use(DndDesign);
    app.use(DndStencil);
    app.use(DndStructure);
    app.use(DndStencilSearchInput);
    app.use(HiddenFormItemSwitch);
    app.use(FormPreviewContent);
  }
};

export { PanelItems as default };
