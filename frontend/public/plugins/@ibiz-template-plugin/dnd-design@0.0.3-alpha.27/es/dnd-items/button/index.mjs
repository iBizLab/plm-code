import Component from './button.mjs';
import { ButtonProvider } from './button.provider.mjs';
import '../../utils/index.mjs';
import { dndProviderRegister } from '../../utils/dnd-provider-register/dnd-provider-register.mjs';

"use strict";
var Button = {
  install(app) {
    app.component(Component.name, Component);
    const provider = new ButtonProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  }
};

export { Button as default };
