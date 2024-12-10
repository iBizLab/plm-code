import { X6PanelItemTableController } from './x6-panel-item-table.controller.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class X6PanelItemTableProvider {
  constructor() {
    __publicField(this, "component", "IBizX6PanelItemTable");
  }
  async createController(panelItem, panel, parent) {
    const c = new X6PanelItemTableController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}

export { X6PanelItemTableProvider };
