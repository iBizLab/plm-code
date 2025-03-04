import { App } from 'vue';
import Component from './form-item';
import { FormItemProvider } from './form-item.provider';
import { dndProviderRegister } from '../../utils';

export default {
  install(app: App) {
    // 注册组件
    app.component(Component.name, Component);
    const provider = new FormItemProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  },
};
