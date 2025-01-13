import { App } from 'vue';
import Component from './mdctrl';
import { MDCtrlProvider } from './mdctrl.provider';
import { dndProviderRegister } from '../../utils';

export default {
  install(app: App) {
    // 注册组件
    app.component(Component.name, Component);
    const provider = new MDCtrlProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  },
};
