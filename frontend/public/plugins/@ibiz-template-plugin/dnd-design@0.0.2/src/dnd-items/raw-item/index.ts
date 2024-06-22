import { App } from 'vue';
import Component from './raw-item';
import { RawItemProvider } from './raw-item.provider';
import { dndProviderRegister } from '../../utils';

export default {
  install(app: App) {
    // 注册组件
    app.component(Component.name, Component);
    const provider = new RawItemProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  },
};
