import { App } from 'vue';
import VueDraggable from 'vuedraggable';
import DndDesign from './dnd-design';
import DndStencil from './dnd-stencil';
import DndStructure from './dnd-structure';
import DndStencilSearchInput from './dnd-stencil-search-input';
import HiddenFormItemSwitch from './hidden-form-item-switch';
import FormPreviewContent from './form-preview-content';

export default {
  install(app: App) {
    app.component('IBizDraggable', VueDraggable);
    app.use(DndDesign);
    app.use(DndStencil);
    app.use(DndStructure);
    app.use(DndStencilSearchInput);
    app.use(HiddenFormItemSwitch);
    app.use(FormPreviewContent);
  },
};
