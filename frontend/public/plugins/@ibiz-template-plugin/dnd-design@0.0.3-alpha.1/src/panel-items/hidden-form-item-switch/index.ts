import { App } from 'vue';
import { registerPanelItemProvider } from '@ibiz-template/runtime';
import HiddenFormItemSwitch from './hidden-form-item-switch';
import { HiddenFormItemSwitchProvider } from './hidden-form-item-switch.provider';

export default {
  install(app: App) {
    // 注册组件
    app.component(HiddenFormItemSwitch.name, HiddenFormItemSwitch);
    registerPanelItemProvider(
      'FIELD_HIDDEN_FORM_ITEM_SWITCH',
      () => new HiddenFormItemSwitchProvider(),
    );
  },
};
