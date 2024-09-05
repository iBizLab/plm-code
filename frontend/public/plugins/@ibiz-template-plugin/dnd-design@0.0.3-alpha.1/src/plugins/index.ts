import { App } from 'vue';
import { registerPanelItemProvider } from '@ibiz-template/runtime';
import { DndStencilFieldProvider } from './dnd-stencil-field';

export default {
  install(_app: App) {
    registerPanelItemProvider(
      'FIELD_DND_PANEL_ITEM_STENCIL_FIELD',
      () => new DndStencilFieldProvider(),
    );
  },
};
