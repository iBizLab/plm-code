import { registerPanelItemProvider } from '@ibiz-template/runtime';
import IBizFormPreviewContent from './form-preview-content.mjs';
import { FormPreviewContentProvider } from './form-preview-content.provider.mjs';

"use strict";
var FormPreviewContent = {
  install(app) {
    app.component("IBizFormPreviewContent", IBizFormPreviewContent);
    registerPanelItemProvider(
      "RAWITEM_FORM_PREVIEW",
      () => new FormPreviewContentProvider()
    );
  }
};

export { FormPreviewContent as default };
