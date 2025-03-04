import { App } from 'vue';
import { registerEditorProvider } from '@ibiz-template/runtime';
import { MarkdownMemoEditor } from './markdown-memo-editor';
import { MarkdownMemoEditorProvider } from './markdown-memo-editor.provider';

export default {
  install(app: App) {
    app.component(MarkdownMemoEditor.name!, MarkdownMemoEditor);
    registerEditorProvider(
      'EDITOR_CUSTOMSTYLE_MARKDOWNMEMO',
      () => new MarkdownMemoEditorProvider(),
    );
  },
};
