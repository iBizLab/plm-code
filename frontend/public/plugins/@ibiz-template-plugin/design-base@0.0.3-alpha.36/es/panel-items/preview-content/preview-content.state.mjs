import { PanelItemState } from '@ibiz-template/runtime';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class PreviewContentState extends PanelItemState {
  constructor() {
    super(...arguments);
    /**
     * 预览子项数据集合
     *
     * @type {IData[]}
     * @memberof PreviewContentState
     */
    __publicField(this, "items", []);
  }
}

export { PreviewContentState };
