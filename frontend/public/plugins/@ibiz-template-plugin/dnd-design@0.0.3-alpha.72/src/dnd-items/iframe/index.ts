import { App } from 'vue';
import Component from './iframe';
import { IframeProvider } from './iframe.provider';
import { dndProviderRegister } from '../../utils';

export default {
  install(app: App) {
    // 注册组件
    app.component(Component.name, Component);
    const provider = new IframeProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  },
};
