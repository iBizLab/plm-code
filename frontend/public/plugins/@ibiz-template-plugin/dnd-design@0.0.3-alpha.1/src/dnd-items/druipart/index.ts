import { App } from 'vue';
import Component from './druipart';
import { DRUIPartProvider } from './druipart.provider';
import { dndProviderRegister } from '../../utils';

export default {
  install(app: App) {
    // 注册组件
    app.component(Component.name, Component);
    const provider = new DRUIPartProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  },
};
