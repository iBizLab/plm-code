import { registerEditorProvider } from '@ibiz-template/runtime';
import { ViewNavParams as ViewNavParams$1 } from './view-nav-params.mjs';
import { ViewNavParamsProvider } from './view-nav-params.provider.mjs';

"use strict";
var ViewNavParams = {
  install(v) {
    v.component(ViewNavParams$1.name, ViewNavParams$1);
    registerEditorProvider(
      "EDITOR_CUSTOMSTYLE_VIEW_NAV_PARAMS",
      () => new ViewNavParamsProvider()
    );
  }
};

export { ViewNavParams as default };
