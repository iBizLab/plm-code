'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var runtime = require('@ibiz-template/runtime');
var vue3Util = require('@ibiz-template/vue3-util');
var noVue3Cron = require('./no-vue3-cron/noVue3Cron.vue.cjs');
require('./cron-editor/index.cjs');
var cronEditor = require('./cron-editor/cron-editor.cjs');
require('./no-vue3-cron/noVue3Cron.css');
var cronEditorProvider = require('./cron-editor/cron-editor-provider.cjs');

"use strict";
const IBizCronEditor = vue3Util.withInstall(cronEditor.default, function(v) {
  v.component(cronEditor.default.name, cronEditor.default);
  runtime.registerEditorProvider(
    "EDITOR_CUSTOMSTYLE_CronEditor",
    () => new cronEditorProvider.CronEditorProvider()
  );
});
var index = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(app) {
    app.component("NoVue3Cron", noVue3Cron.default);
    app.use(IBizCronEditor);
  }
};

exports.IBizCronEditor = IBizCronEditor;
exports.default = index;
