import { App } from 'vue';
import { registerPanelItemProvider } from '@ibiz-template/runtime';
import X6PanelItemStencil from './x6-panel-item-stencil';
import { X6PanelItemStencilProvider } from './x6-panel-item-stencil.provider';

export default {
  install(app: App) {
    // 注册组件
    app.component('IBizX6PanelItemStencil', X6PanelItemStencil);
    registerPanelItemProvider(
      'FIELD_X6_PANEL_ITEM_STENCIL',
      () => new X6PanelItemStencilProvider(),
    );
  },
};
