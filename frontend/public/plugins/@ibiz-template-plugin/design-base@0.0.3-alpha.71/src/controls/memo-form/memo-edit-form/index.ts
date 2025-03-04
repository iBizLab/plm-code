import { registerControlProvider } from '@ibiz-template/runtime';
import { App } from 'vue';
import { MemoEditFormProvider } from './memo-edit-form.provider';
import { MemoEditFormControl } from './memo-edit-form';

export default {
  install(app: App) {
    app.component(MemoEditFormControl.name!, MemoEditFormControl);
    registerControlProvider(
      'EDITFORM_RENDER_MEMOFORM',
      () => new MemoEditFormProvider(),
    );
  },
};
