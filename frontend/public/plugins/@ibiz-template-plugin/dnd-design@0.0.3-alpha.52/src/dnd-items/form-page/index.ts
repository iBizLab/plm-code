import { App } from 'vue';
import Component from './form-page';

export default {
  install(app: App) {
    // 注册组件
    app.component(Component.name, Component);
  },
};
