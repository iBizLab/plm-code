import '../controller/index.mjs';
import { DndItemController } from '../controller/dnd-item-controller/dnd-item-controller.mjs';

"use strict";
class DndProvider {
  createController(c, model, item) {
    return new DndItemController(c, model, item);
  }
}

export { DndProvider };
