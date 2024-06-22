import { App } from 'vue';
import PanelItems from './panel-items';
import './style/index.scss';

export default {
  install(app: App) {
    app.use(PanelItems);
  },
};
