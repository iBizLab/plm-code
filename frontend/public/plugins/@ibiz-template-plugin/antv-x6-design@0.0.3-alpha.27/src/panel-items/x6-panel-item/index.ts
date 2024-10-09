import { App } from 'vue';
import { registerPanelItemProvider } from '@ibiz-template/runtime';
import X6PanelItem from './x6-panel-item';
import { X6PanelItemProvider } from './x6-panel-item.provider';

export default {
  install(app: App) {
    // 注册组件
    app.component('IBizX6PanelItem', X6PanelItem);
    registerPanelItemProvider(
      'RAWITEM_X6_PANEL_ITEM',
      () => new X6PanelItemProvider(),
    );
  },
};
