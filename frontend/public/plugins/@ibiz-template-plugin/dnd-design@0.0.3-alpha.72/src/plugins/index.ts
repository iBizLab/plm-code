import { App } from 'vue';
import { registerPanelItemProvider } from '@ibiz-template/runtime';
import { DndStencilFieldProvider } from './dnd-stencil-field';
import FormLogicEventScript from './form-logic-event-script';
import { DndStencilEditorProvider } from './dnd-stencil-editor';

export default {
  install(v: App) {
    registerPanelItemProvider(
      'FIELD_DND_PANEL_ITEM_STENCIL_FIELD',
      () => new DndStencilFieldProvider(),
    );
    v.use(FormLogicEventScript);
    registerPanelItemProvider(
      'FIELD_DND_PANEL_ITEM_STENCIL_EDITOR',
      () => new DndStencilEditorProvider(),
    );
  },
};
