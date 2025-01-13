import Component from './form-page.mjs';

"use strict";
var FormPage = {
  install(app) {
    app.component(Component.name, Component);
  }
};

export { FormPage as default };
