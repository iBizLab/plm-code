import Component from './form-item.mjs';
import { FormItemProvider } from './form-item.provider.mjs';
import '../../utils/index.mjs';
import { dndProviderRegister } from '../../utils/dnd-provider-register/dnd-provider-register.mjs';

"use strict";
var FormItem = {
  install(app) {
    app.component(Component.name, Component);
    const provider = new FormItemProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  }
};

export { FormItem as default };
