import { App } from 'vue';
import EditorParams from './editor-params/editor-params';

export default {
  install(app: App) {
    app.component(EditorParams.name, EditorParams);
  },
};
