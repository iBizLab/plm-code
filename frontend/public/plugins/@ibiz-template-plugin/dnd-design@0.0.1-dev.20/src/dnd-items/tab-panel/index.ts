import { App } from 'vue';
import Component from './tab-panel';
import { TabPanelProvider } from './tab-panel.provider';
import { dndProviderRegister } from '../../utils';

export default {
  install(app: App) {
    // 注册组件
    app.component(Component.name, Component);
    const provider = new TabPanelProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  },
};
