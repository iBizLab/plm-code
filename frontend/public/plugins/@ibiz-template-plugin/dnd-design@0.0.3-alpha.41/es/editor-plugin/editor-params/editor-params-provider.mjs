import { EditorParamsController } from './editor-params.controller.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class EditorParamsProvider {
  constructor() {
    __publicField(this, "formEditor", "IBizEditorParmas");
    __publicField(this, "gridEditor", "IBizEditorParmas");
  }
  async createController(editorModel, parentController) {
    const c = new EditorParamsController(editorModel, parentController);
    await c.init();
    return c;
  }
}

export { EditorParamsProvider };
