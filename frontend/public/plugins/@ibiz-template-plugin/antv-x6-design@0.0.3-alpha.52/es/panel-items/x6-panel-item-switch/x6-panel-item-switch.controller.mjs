import { RuntimeModelError } from '@ibiz-template/core';
import { PanelItemController } from '@ibiz-template/runtime';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class X6PanelItemSwitchController extends PanelItemController {
  constructor() {
    super(...arguments);
    __publicField(this, "items", []);
  }
  async onInit() {
    await super.onInit();
    const { editor } = this.model;
    if (editor) {
      let codeList = null;
      const { appCodeListId } = editor;
      if (appCodeListId) {
        const app = await ibiz.hub.getApp(this.model.appId);
        codeList = app.codeList.getCodeList(appCodeListId);
      }
      if (!codeList) {
        throw new RuntimeModelError(
          this.model,
          "\u672A\u914D\u7F6E\u4E3B\u72B6\u6001\u8BBE\u8BA1\u5448\u73B0\u6A21\u5F0F\u4EE3\u7801\u8868"
        );
      }
      this.items = codeList.codeItems || [];
    }
  }
}

export { X6PanelItemSwitchController };
