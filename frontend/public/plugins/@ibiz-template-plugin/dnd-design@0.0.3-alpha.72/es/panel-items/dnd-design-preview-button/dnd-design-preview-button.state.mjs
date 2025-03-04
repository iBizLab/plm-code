import { PanelItemState } from '@ibiz-template/runtime';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndDesignPreviewButtonState extends PanelItemState {
  constructor() {
    super(...arguments);
    /**
     * 是否正在预览
     *
     * @author zhanghengfeng
     * @date 2025-02-14 20:02:03
     * @type {boolean}
     */
    __publicField(this, "isPreview", false);
  }
}

export { DndDesignPreviewButtonState };
