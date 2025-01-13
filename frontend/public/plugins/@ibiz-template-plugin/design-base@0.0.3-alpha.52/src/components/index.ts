import { App } from 'vue';
import IBizDesignTree from './design-tree/design-tree';

export default {
  install(app: App) {
    app.component('IBizDesignTree', IBizDesignTree);
  },
};
