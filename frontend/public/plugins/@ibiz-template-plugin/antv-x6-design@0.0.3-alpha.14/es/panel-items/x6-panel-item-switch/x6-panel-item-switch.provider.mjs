import { X6PanelItemSwitchController } from './x6-panel-item-switch.controller.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class X6PanelItemSwitchProvider {
  constructor() {
    __publicField(this, "component", "IBizX6PanelItemSwitch");
  }
  async createController(panelItem, panel, parent) {
    const c = new X6PanelItemSwitchController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}

export { X6PanelItemSwitchProvider };
