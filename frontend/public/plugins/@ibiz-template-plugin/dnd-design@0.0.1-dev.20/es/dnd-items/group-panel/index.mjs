import Component from './group-panel.mjs';
import { GroupPanelProvider } from './group-panel.provider.mjs';
import '../../utils/index.mjs';
import { dndProviderRegister } from '../../utils/dnd-provider-register/dnd-provider-register.mjs';

"use strict";
var GroupPanel = {
  install(app) {
    app.component(Component.name, Component);
    const provider = new GroupPanelProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  }
};

export { GroupPanel as default };
