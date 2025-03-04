import { App } from 'vue';
import DndDraggableItem from './dnd-draggable-item/dnd-draggable-item';
import DndDraggableTabs from './dnd-draggable-tabs/dnd-draggable-tabs';
import IBizFormShell from './form-shell/form-shell';

export default {
  install(app: App) {
    app.component(DndDraggableItem.name, DndDraggableItem);
    app.component(DndDraggableTabs.name, DndDraggableTabs);
    app.component(IBizFormShell.name, IBizFormShell);
  },
};
