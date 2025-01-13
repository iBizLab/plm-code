import Component from './button-list.mjs';
import { ButtonListProvider } from './button-list.provider.mjs';
import '../../utils/index.mjs';
import { dndProviderRegister } from '../../utils/dnd-provider-register/dnd-provider-register.mjs';

"use strict";
var ButtonList = {
  install(app) {
    app.component(Component.name, Component);
    const provider = new ButtonListProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  }
};

export { ButtonList as default };
