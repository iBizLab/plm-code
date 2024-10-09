import { registerPanelItemProvider } from '@ibiz-template/runtime';
import HiddenFormItemSwitch$1 from './hidden-form-item-switch.mjs';
import { HiddenFormItemSwitchProvider } from './hidden-form-item-switch.provider.mjs';

"use strict";
var HiddenFormItemSwitch = {
  install(app) {
    app.component(HiddenFormItemSwitch$1.name, HiddenFormItemSwitch$1);
    registerPanelItemProvider(
      "FIELD_HIDDEN_FORM_ITEM_SWITCH",
      () => new HiddenFormItemSwitchProvider()
    );
  }
};

export { HiddenFormItemSwitch as default };
