import { registerEditorProvider } from '@ibiz-template/runtime';
import { withInstall } from '@ibiz-template/vue3-util';
import NoVue3Cron from './no-vue3-cron/noVue3Cron.vue.mjs';
import './cron-editor/index.mjs';
import CronEditor from './cron-editor/cron-editor.mjs';
import './no-vue3-cron/noVue3Cron.css';
import { CronEditorProvider } from './cron-editor/cron-editor-provider.mjs';

"use strict";
const IBizCronEditor = withInstall(CronEditor, function(v) {
  v.component(CronEditor.name, CronEditor);
  registerEditorProvider(
    "EDITOR_CUSTOMSTYLE_CronEditor",
    () => new CronEditorProvider()
  );
});
var index = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(app) {
    app.component("NoVue3Cron", NoVue3Cron);
    app.use(IBizCronEditor);
  }
};

export { IBizCronEditor, index as default };
