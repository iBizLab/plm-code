import { App } from 'vue';
import MarkdownMemo from './markdown-memo';
import ViewNavParams from './view-nav-params';
import EditorParams from './editor-params';

export default {
  install(app: App) {
    app.use(MarkdownMemo);
    app.use(ViewNavParams);
    app.use(EditorParams);
  },
};
