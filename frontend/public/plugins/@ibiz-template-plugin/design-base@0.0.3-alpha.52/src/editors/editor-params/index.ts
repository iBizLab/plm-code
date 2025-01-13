import { App } from 'vue';
import { registerEditorProvider } from '@ibiz-template/runtime';
import EditorParams from './editor-params';
import { EditorParamsProvider } from './editor-params-provider';

export default {
  install(app: App): void {
    app.component(EditorParams.name!, EditorParams);
    registerEditorProvider(
      'EDITOR_CUSTOMSTYLE_EditorParamCustom',
      () => new EditorParamsProvider(),
    );
  },
};
