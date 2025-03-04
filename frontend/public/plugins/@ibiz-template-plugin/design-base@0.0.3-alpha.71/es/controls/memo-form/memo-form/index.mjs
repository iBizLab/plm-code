import { MemoFormControl } from './memo-form.mjs';

"use strict";
var MemoFormComp = {
  install(app) {
    app.component(MemoFormControl.name, MemoFormControl);
  }
};

export { MemoFormComp as default };
