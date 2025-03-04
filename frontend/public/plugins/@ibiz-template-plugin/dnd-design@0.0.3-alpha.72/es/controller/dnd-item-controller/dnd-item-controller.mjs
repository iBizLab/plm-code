import { createVNode } from 'vue';
import { clone } from 'lodash-es';
import { resource } from '../../global.mjs';

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
        "src": resource.dir("./assets/svg/lightning.svg")
      }, null),
      text: "\u8868\u5355\u9879\u903B\u8F91",
      tooltip: "\u8868\u5355\u9879\u903B\u8F91",
      command: "logic"
    }, {
      icon: createVNode("ion-icon", {
        "name": "trash-outline"
      }, null),
      text: "\u5220\u9664",
      tooltip: "\u5220\u9664",
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
  getItemCaption() {
    const preViewProvider = this.c.view.getPreViewProvider();
    let data = clone(this.data);
    if (preViewProvider && this.data) {
      data = preViewProvider.getTargetDataBySourceData("FORMDETAIL", [data])[0];
    }
    return data.caption;
  }
}

export { DndItemController };
