import { App } from 'vue';
import { MemoFormControl } from './memo-form';

export default {
  install(app: App) {
    app.component(MemoFormControl.name!, MemoFormControl);
  },
};
