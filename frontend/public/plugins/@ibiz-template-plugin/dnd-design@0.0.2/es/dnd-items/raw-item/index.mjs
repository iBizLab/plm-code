import Component from './raw-item.mjs';
import { RawItemProvider } from './raw-item.provider.mjs';
import '../../utils/index.mjs';
import { dndProviderRegister } from '../../utils/dnd-provider-register/dnd-provider-register.mjs';

"use strict";
var RawItem = {
  install(app) {
    app.component(Component.name, Component);
    const provider = new RawItemProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  }
};

export { RawItem as default };
