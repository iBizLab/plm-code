import { FormPreviewViewController } from './form-preview-view.controller.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class FormPreviewViewProvider {
  constructor() {
    __publicField(this, "component", "IBizView");
  }
  createController(model, context, params, ctx) {
    const c = new FormPreviewViewController(model, context, params, ctx);
    return c;
  }
}

export { FormPreviewViewProvider };
