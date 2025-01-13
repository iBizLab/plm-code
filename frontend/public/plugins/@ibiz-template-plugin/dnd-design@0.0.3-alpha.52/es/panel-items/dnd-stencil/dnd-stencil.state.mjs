import { PanelItemState } from '@ibiz-template/runtime';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndStencilPanelItemState extends PanelItemState {
  constructor() {
    super(...arguments);
    /**
     * 代码表项
     *
     * @author zhanghengfeng
     * @date 2024-01-08 17:01:55
     * @type {ICodeItem[]}
     */
    __publicField(this, "items", []);
    /**
     * 过滤值
     *
     * @author zhanghengfeng
     * @date 2024-01-11 17:01:34
     * @type {string}
     */
    __publicField(this, "filterValue", "");
  }
}

export { DndStencilPanelItemState };
