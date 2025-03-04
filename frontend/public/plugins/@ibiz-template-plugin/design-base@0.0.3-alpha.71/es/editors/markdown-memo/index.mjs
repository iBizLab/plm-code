import { registerEditorProvider } from '@ibiz-template/runtime';
import { MarkdownMemoEditor } from './markdown-memo-editor.mjs';
import { MarkdownMemoEditorProvider } from './markdown-memo-editor.provider.mjs';

"use strict";
var MarkdownMemo = {
  install(app) {
    app.component(MarkdownMemoEditor.name, MarkdownMemoEditor);
    registerEditorProvider(
      "EDITOR_CUSTOMSTYLE_MARKDOWNMEMO",
      () => new MarkdownMemoEditorProvider()
    );
  }
};

export { MarkdownMemo as default };
