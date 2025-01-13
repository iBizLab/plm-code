import { App } from 'vue';
import Component from './button-list';
import { ButtonListProvider } from './button-list.provider';
import { dndProviderRegister } from '../../utils';

export default {
  install(app: App) {
    // 注册组件
    app.component(Component.name, Component);
    const provider = new ButtonListProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  },
};
