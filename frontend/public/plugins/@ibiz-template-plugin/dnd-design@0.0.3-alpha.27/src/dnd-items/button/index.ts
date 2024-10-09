import { App } from 'vue';
import Component from './button';
import { ButtonProvider } from './button.provider';
import { dndProviderRegister } from '../../utils';

export default {
  install(app: App) {
    // 注册组件
    app.component(Component.name, Component);
    const provider = new ButtonProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  },
};
