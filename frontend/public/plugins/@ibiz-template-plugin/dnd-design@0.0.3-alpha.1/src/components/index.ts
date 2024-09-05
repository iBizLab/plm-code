import { App } from 'vue';
import DndDraggableItem from './dnd-draggable-item/dnd-draggable-item';
import DndDraggableTabs from './dnd-draggable-tabs/dnd-draggable-tabs';

export default {
  install(app: App) {
    app.component(DndDraggableItem.name, DndDraggableItem);
    app.component(DndDraggableTabs.name, DndDraggableTabs);
  },
};
