import { registerUIActionProvider } from '@ibiz-template/runtime';
import { RefreshFieldProvider } from './refresh-field-provider.mjs';

"use strict";
var UIAction = {
  install(_app) {
    registerUIActionProvider(
      "FRONT_RefreshField",
      () => new RefreshFieldProvider()
    );
  }
};

export { UIAction as default };
