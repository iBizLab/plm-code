import { App } from 'vue';
import { registerPanelItemProvider } from '@ibiz-template/runtime';
import IBizFormPreviewContent from './form-preview-content';
import { FormPreviewContentProvider } from './form-preview-content.provider';

export default {
  install(app: App) {
    // 注册组件
    app.component('IBizFormPreviewContent', IBizFormPreviewContent);
    registerPanelItemProvider(
      'RAWITEM_FORM_PREVIEW',
      () => new FormPreviewContentProvider(),
    );
  },
};
