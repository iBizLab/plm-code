import { App } from 'vue';
import { registerPanelItemProvider } from '@ibiz-template/runtime';
import X6PanelItemTable from './x6-panel-item-table';
import { X6PanelItemTableProvider } from './x6-panel-item-table.provider';

export default {
  install(app: App) {
    // 注册组件
    app.component('IBizX6PanelItemTable', X6PanelItemTable);
    registerPanelItemProvider(
      'FIELD_X6_PANEL_ITEM_TABLE',
      () => new X6PanelItemTableProvider(),
    );
  },
};
