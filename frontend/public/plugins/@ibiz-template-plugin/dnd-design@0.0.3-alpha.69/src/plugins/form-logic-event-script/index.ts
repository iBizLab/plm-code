import { App } from 'vue';
import { registerEditorProvider } from '@ibiz-template/runtime';
import { FormLogicEventScript } from './form-logic-event-script';
import { FormLogicEventScriptEditorProvider } from './form-logic-event-script.provider';

export default {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(v: App) {
    v.component(FormLogicEventScript.name!, FormLogicEventScript);
    registerEditorProvider(
      'CODE_FORM_LOGIC_EVENT_SCRIPT',
      () => new FormLogicEventScriptEditorProvider(),
    );
  },
};
