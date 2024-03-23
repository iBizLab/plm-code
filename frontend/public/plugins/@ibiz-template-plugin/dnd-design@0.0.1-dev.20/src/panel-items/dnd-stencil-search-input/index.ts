import { App } from 'vue';
import { registerPanelItemProvider } from '@ibiz-template/runtime';
import DndStencilSearchInput from './dnd-stencil-search-input';
import { DndStencilSearchInputProvider } from './dnd-stencil-search-input.provider';

export default {
  install(app: App) {
    // 注册组件
    app.component('IBizDndStencilSearchInput', DndStencilSearchInput);
    registerPanelItemProvider(
      'FIELD_DND_PANEL_ITEM_STENCIL_SEARCH',
      () => new DndStencilSearchInputProvider(),
    );
  },
};
