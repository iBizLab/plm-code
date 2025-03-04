import MarkdownMemo from './markdown-memo/index.mjs';
import ViewNavParams from './view-nav-params/index.mjs';
import EditorParams from './editor-params/index.mjs';

"use strict";
var Editors = {
  install(app) {
    app.use(MarkdownMemo);
    app.use(ViewNavParams);
    app.use(EditorParams);
  }
};

export { Editors as default };
