import Component from './iframe.mjs';
import { IframeProvider } from './iframe.provider.mjs';
import '../../utils/index.mjs';
import { dndProviderRegister } from '../../utils/dnd-provider-register/dnd-provider-register.mjs';

"use strict";
var Iframe = {
  install(app) {
    app.component(Component.name, Component);
    const provider = new IframeProvider();
    dndProviderRegister.registerItemProvider(provider.type, provider);
  }
};

export { Iframe as default };
