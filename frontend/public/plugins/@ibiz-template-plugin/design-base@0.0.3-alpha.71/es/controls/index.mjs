import MemoForm from './memo-form/index.mjs';

"use strict";
var Controls = {
  install(app) {
    app.use(MemoForm);
  }
};

export { Controls as default };
