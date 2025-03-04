import { PanelItemState } from '@ibiz-template/runtime';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndStructurePanelItemState extends PanelItemState {
  constructor() {
    super(...arguments);
    /**
     * 树节点数据
     *
     * @author zhanghengfeng
     * @date 2023-12-28 19:12:54
     * @type {IDndStructureNodeData[]}
     */
    __publicField(this, "items", []);
  }
}

export { DndStructurePanelItemState };
