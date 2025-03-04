import { registerControlProvider } from '@ibiz-template/runtime';
import { MemoEditFormProvider } from './memo-edit-form.provider.mjs';
import { MemoEditFormControl as MemoEditFormControl$1 } from './memo-edit-form.mjs';

"use strict";
var MemoEditFormControl = {
  install(app) {
    app.component(MemoEditFormControl$1.name, MemoEditFormControl$1);
    registerControlProvider(
      "EDITFORM_RENDER_MEMOFORM",
      () => new MemoEditFormProvider()
    );
  }
};

export { MemoEditFormControl as default };
