import { App } from 'vue';
import { registerPanelItemProvider } from '@ibiz-template/runtime';
import { DndDesignPreviewButtonProvider } from './dnd-design-preview-button.provider';
import DndDesignPreviewButton from './dnd-design-preview-button';

export default {
  install(app: App): void {
    app.component('IBizDndDesignPreviewButton', DndDesignPreviewButton);
    registerPanelItemProvider(
      'FIELD_DND_DESIGN_PREVIEW_BUTTON',
      () => new DndDesignPreviewButtonProvider(),
    );
  },
};
