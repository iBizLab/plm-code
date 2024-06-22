import EditorParams from './editor-params/editor-params.mjs';

"use strict";
var editorPulgin = {
  install(app) {
    app.component(EditorParams.name, EditorParams);
  }
};

export { editorPulgin as default };
