import { App } from 'vue';
import { registerEditorProvider } from '@ibiz-template/runtime';
import { withInstall } from '@ibiz-template/vue3-util';
import NoVue3Cron from './no-vue3-cron/noVue3Cron.vue';
import { CronEditorProvider } from './cron-editor';
import CronEditor from './cron-editor/cron-editor';
import './no-vue3-cron/noVue3Cron.scss';

export const IBizCronEditor = withInstall(CronEditor, function (v: App) {
  v.component(CronEditor.name, CronEditor);
  registerEditorProvider(
    'EDITOR_CUSTOMSTYLE_CronEditor',
    () => new CronEditorProvider(),
  );
});

export default {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(app: App) {
    // eslint-disable-next-line @typescript-eslint/no-explicit-any
    app.component('NoVue3Cron', NoVue3Cron as any);

    app.use(IBizCronEditor);
  },
};
