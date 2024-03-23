import { App } from 'vue';
import Component from './group-panel';
import { GroupPanelProvider } from './group-panel.provider';
import { dndProviderRegister } from '../../utils';

export default {
  install(app: App) {
    // 注册组件
    app.component(Component.name, Component);
    const provider = new GroupPanelProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  },
};
