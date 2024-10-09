import { App } from 'vue';
import { registerPanelItemProvider } from '@ibiz-template/runtime';
import X6PanelItemSwitch from './x6-panel-item-switch';
import { X6PanelItemSwitchProvider } from './x6-panel-item-switch.provider';

export default {
  install(app: App) {
    // 注册组件
    app.component('IBizX6PanelItemSwitch', X6PanelItemSwitch);
    registerPanelItemProvider(
      'FIELD_X6_PANEL_ITEM_SWITCH',
      () => new X6PanelItemSwitchProvider(),
    );
  },
};
