import { DndStencilFieldController } from './dnd-stencil-field.controller.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndStencilFieldProvider {
  constructor() {
    __publicField(this, "component", "IBizDndStencilPanelItem");
  }
  async createController(panelItem, panel, parent) {
    const c = new DndStencilFieldController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}

export { DndStencilFieldProvider };
