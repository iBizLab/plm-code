import { App } from 'vue';
import Component from './form-item-ex';
import { FormItemExProvider } from './form-item-ex.provider';
import { dndProviderRegister } from '../../utils';

export default {
  install(app: App) {
    // 注册组件
    app.component(Component.name, Component);
    const provider = new FormItemExProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  },
};
