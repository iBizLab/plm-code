import { App } from 'vue';
import Component from './tab-page';
import { TabPageProvider } from './tab-page.provider';
import { dndProviderRegister } from '../../utils';

export default {
  install(app: App) {
    // 注册组件
    app.component(Component.name, Component);
    const provider = new TabPageProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  },
};
