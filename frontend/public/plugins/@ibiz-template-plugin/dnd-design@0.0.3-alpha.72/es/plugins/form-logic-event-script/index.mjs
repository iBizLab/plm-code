import { registerEditorProvider } from '@ibiz-template/runtime';
import { FormLogicEventScript as FormLogicEventScript$1 } from './form-logic-event-script.mjs';
import { FormLogicEventScriptEditorProvider } from './form-logic-event-script.provider.mjs';

"use strict";
var FormLogicEventScript = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(v) {
    v.component(FormLogicEventScript$1.name, FormLogicEventScript$1);
    registerEditorProvider(
      "CODE_FORM_LOGIC_EVENT_SCRIPT",
      () => new FormLogicEventScriptEditorProvider()
    );
  }
};

export { FormLogicEventScript as default };
