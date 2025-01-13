import { App } from 'vue';
import MemoFormComp from './memo-form';
import MemoEditFormControl from './memo-edit-form';

export default {
  install(app: App) {
    app.use(MemoFormComp);
    app.use(MemoEditFormControl);
  },
};
