import { FormLogicEventScriptEditorController } from './form-logic-event-script.controller.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class FormLogicEventScriptEditorProvider {
  constructor() {
    __publicField(this, "formEditor", "IBizFormLogicEventScript");
    __publicField(this, "gridEditor", "IBizFormLogicEventScript");
  }
  async createController(editorModel, parentController) {
    const c = new FormLogicEventScriptEditorController(
      editorModel,
      parentController
    );
    await c.init();
    return c;
  }
}

export { FormLogicEventScriptEditorProvider };
