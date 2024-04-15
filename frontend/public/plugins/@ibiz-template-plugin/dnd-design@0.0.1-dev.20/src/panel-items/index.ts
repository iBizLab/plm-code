import { App } from 'vue';
import VueDraggable from 'vuedraggable';
import DndDesign from './dnd-design';
import DndStencil from './dnd-stencil';
import DndStructure from './dnd-structure';
import DndStencilSearchInput from './dnd-stencil-search-input';

export default {
  install(app: App) {
    app.component('IBizDraggable', VueDraggable);
    app.use(DndDesign);
    app.use(DndStencil);
    app.use(DndStructure);
    app.use(DndStencilSearchInput);
  },
};
