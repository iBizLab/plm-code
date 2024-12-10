import Component from './mdctrl.mjs';
import { MDCtrlProvider } from './mdctrl.provider.mjs';
import '../../utils/index.mjs';
import { dndProviderRegister } from '../../utils/dnd-provider-register/dnd-provider-register.mjs';

"use strict";
var MDCtrl = {
  install(app) {
    app.component(Component.name, Component);
    const provider = new MDCtrlProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  }
};

export { MDCtrl as default };
