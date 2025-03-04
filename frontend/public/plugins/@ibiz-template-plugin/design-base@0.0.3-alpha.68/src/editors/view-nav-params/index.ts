/* eslint-disable @typescript-eslint/explicit-function-return-type */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { App } from 'vue';
import { registerEditorProvider } from '@ibiz-template/runtime';
import { ViewNavParams } from './view-nav-params';
import { ViewNavParamsProvider } from './view-nav-params.provider';

export default {
  install(v: App) {
    v.component(ViewNavParams.name!, ViewNavParams);
    registerEditorProvider(
      'EDITOR_CUSTOMSTYLE_VIEW_NAV_PARAMS',
      () => new ViewNavParamsProvider(),
    );
  },
};
