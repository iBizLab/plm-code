import { FormPreviewContentController } from './form-preview-content.controller.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class FormPreviewContentProvider {
  constructor() {
    __publicField(this, "component", "IBizFormPreviewContent");
  }
  async createController(panelItem, panel, parent) {
    const c = new FormPreviewContentController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}

export { FormPreviewContentProvider };
