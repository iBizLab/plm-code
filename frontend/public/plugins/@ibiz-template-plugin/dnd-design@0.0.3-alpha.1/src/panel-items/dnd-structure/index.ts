import { App } from 'vue';
import { registerPanelItemProvider } from '@ibiz-template/runtime';
import DndStructure from './dnd-structure';
import { DndStructurePanelItemProvider } from './dnd-structure.provider';

export default {
  install(app: App) {
    // 注册组件
    app.component('IBizDndStructurePanelItem', DndStructure);
    registerPanelItemProvider(
      'FIELD_DND_PANEL_STRUCTURE',
      () => new DndStructurePanelItemProvider(),
    );
  },
};
