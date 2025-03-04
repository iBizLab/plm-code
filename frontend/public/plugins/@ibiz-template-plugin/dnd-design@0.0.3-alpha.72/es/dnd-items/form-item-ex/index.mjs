import Component from './form-item-ex.mjs';
import { FormItemExProvider } from './form-item-ex.provider.mjs';
import '../../utils/index.mjs';
import { dndProviderRegister } from '../../utils/dnd-provider-register/dnd-provider-register.mjs';

"use strict";
var FormItemEx = {
  install(app) {
    app.component(Component.name, Component);
    const provider = new FormItemExProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  }
};

export { FormItemEx as default };
