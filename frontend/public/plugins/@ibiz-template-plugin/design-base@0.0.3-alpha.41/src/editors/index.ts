import { App } from 'vue';
import MarkdownMemo from './markdown-memo';

export default {
  install(app: App) {
    app.use(MarkdownMemo);
  },
};
