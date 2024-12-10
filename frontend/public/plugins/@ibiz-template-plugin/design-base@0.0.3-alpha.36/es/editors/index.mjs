import MarkdownMemo from './markdown-memo/index.mjs';

"use strict";
var Editors = {
  install(app) {
    app.use(MarkdownMemo);
  }
};

export { Editors as default };
