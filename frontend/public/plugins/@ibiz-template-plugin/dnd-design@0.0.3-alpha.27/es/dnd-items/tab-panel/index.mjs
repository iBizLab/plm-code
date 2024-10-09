import Component from './tab-panel.mjs';
import { TabPanelProvider } from './tab-panel.provider.mjs';
import '../../utils/index.mjs';
import { dndProviderRegister } from '../../utils/dnd-provider-register/dnd-provider-register.mjs';

"use strict";
var TabPanel = {
  install(app) {
    app.component(Component.name, Component);
    const provider = new TabPanelProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  }
};

export { TabPanel as default };
