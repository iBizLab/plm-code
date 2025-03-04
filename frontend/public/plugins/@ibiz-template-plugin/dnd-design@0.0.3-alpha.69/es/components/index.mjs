import DndDraggableItem from './dnd-draggable-item/dnd-draggable-item.mjs';
import DndDraggableTabs from './dnd-draggable-tabs/dnd-draggable-tabs.mjs';
import IBizFormShell from './form-shell/form-shell.mjs';

"use strict";
var Components = {
  install(app) {
    app.component(DndDraggableItem.name, DndDraggableItem);
    app.component(DndDraggableTabs.name, DndDraggableTabs);
    app.component(IBizFormShell.name, IBizFormShell);
  }
};

export { Components as default };
