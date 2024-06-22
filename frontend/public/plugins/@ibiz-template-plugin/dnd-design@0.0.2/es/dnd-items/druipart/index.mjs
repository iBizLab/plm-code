import Component from './druipart.mjs';
import { DRUIPartProvider } from './druipart.provider.mjs';
import '../../utils/index.mjs';
import { dndProviderRegister } from '../../utils/dnd-provider-register/dnd-provider-register.mjs';

"use strict";
var DRUIPart = {
  install(app) {
    app.component(Component.name, Component);
    const provider = new DRUIPartProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  }
};

export { DRUIPart as default };
