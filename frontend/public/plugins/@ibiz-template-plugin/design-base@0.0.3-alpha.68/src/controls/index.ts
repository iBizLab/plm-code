import { App } from 'vue';
import MemoForm from './memo-form';

export default {
  install(app: App) {
    app.use(MemoForm);
  },
};
