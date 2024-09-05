import { App } from 'vue';
import { registerPanelItemProvider } from '@ibiz-template/runtime';
import { DndStencilPanelItemProvider } from './dnd-stencil.provider';
import DndStencil from './dnd-stencil';

export default {
  install(app: App) {
    // 注册组件
    app.component('IBizDndStencilPanelItem', DndStencil);
    registerPanelItemProvider(
      'FIELD_DND_PANEL_ITEM_STENCIL',
      () => new DndStencilPanelItemProvider(),
    );
  },
};
