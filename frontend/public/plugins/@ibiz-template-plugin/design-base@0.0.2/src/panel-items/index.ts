import { App } from 'vue';
import ActiveHomeButton from './active-home-button';

export default {
  install(app: App) {
    app.use(ActiveHomeButton);
  },
};
