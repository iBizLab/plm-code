import { registerEditorProvider } from '@ibiz-template/runtime';
import EditorParams$1 from './editor-params.mjs';
import { EditorParamsProvider } from './editor-params-provider.mjs';

"use strict";
var EditorParams = {
  install(app) {
    app.component(EditorParams$1.name, EditorParams$1);
    registerEditorProvider(
      "EDITOR_CUSTOMSTYLE_EditorParamCustom",
      () => new EditorParamsProvider()
    );
  }
};

export { EditorParams as default };
