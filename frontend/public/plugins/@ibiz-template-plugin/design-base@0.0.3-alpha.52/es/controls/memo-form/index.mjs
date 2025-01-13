import MemoFormComp from './memo-form/index.mjs';
import MemoEditFormControl from './memo-edit-form/index.mjs';

"use strict";
var MemoForm = {
  install(app) {
    app.use(MemoFormComp);
    app.use(MemoEditFormControl);
  }
};

export { MemoForm as default };
