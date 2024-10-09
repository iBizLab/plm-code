import Component from './tab-page.mjs';
import { TabPageProvider } from './tab-page.provider.mjs';
import '../../utils/index.mjs';
import { dndProviderRegister } from '../../utils/dnd-provider-register/dnd-provider-register.mjs';

"use strict";
var TabPage = {
  install(app) {
    app.component(Component.name, Component);
    const provider = new TabPageProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  }
};

export { TabPage as default };
