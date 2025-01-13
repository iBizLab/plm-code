import { CodeListEditorController } from '@ibiz-template/runtime';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class MarkdownMemoEditorProvider {
  constructor() {
    __publicField(this, "formEditor", "IBizMarkdownMemoEditor");
    __publicField(this, "gridEditor", "IBizMarkdownMemoEditor");
  }
  async createController(editorModel, parentController) {
    const c = new CodeListEditorController(editorModel, parentController);
    await c.init();
    return c;
  }
}

export { MarkdownMemoEditorProvider };
