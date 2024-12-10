import { App } from 'vue';
import { registerPanelItemProvider } from '@ibiz-template/runtime';
import { DndDesignPanelItemProvider } from './dnd-design.provider';
import DndDesign from './dnd-design';

export default {
  install(app: App) {
    // 注册组件
    app.component('IBizDndDesignPanelItem', DndDesign);
    registerPanelItemProvider(
      'RAWITEM_DND_DESIGN_PANEL_ITEM',
      () => new DndDesignPanelItemProvider(),
    );
  },
};
