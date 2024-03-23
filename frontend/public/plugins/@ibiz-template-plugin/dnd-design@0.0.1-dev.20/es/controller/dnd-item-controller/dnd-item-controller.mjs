import { createVNode } from 'vue';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndItemController {
  constructor(c, model, data) {
    __publicField(this, "actions", [{
      icon: createVNode("ion-icon", {
        "name": "trash-outline"
      }, null),
      text: "\u5220\u9664",
      command: "delete"
    }]);
    this.c = c;
    this.data = data;
    this.model = model;
    this.select = c.view.select;
  }
  async onAction(_action) {
    return false;
  }
  destroy() {
  }
  change(evt, items, parent) {
    this.c.change(evt, items, parent);
  }
  async remove(items, item) {
    return this.c.remove(items, item);
  }
}

export { DndItemController };
