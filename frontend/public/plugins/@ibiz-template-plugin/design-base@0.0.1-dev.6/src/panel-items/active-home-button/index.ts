import { App } from 'vue';
import { registerPanelItemProvider } from '@ibiz-template/runtime';
import ActiveHomeButton from './active-home-button';
import { ActiveHomeButtonProvider } from './active-home-button.provider';

export default {
  install(app: App) {
    // 注册组件
    app.component('IBizActiveHomeButton', ActiveHomeButton);
    registerPanelItemProvider(
      'FIELD_ACTIVE_HOME_BUTTON',
      () => new ActiveHomeButtonProvider(),
    );
  },
};
