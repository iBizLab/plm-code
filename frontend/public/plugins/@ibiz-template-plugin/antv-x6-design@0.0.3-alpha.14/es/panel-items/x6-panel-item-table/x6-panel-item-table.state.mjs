import { PanelItemState } from '@ibiz-template/runtime';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class X6PanelItemTableState extends PanelItemState {
  constructor() {
    super(...arguments);
    /**
     * 节点
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:08
     * @type {IDataEntity[]}
     */
    __publicField(this, "nodes", []);
    /**
     * 连线
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:16
     * @type {IDataEntity[]}
     */
    __publicField(this, "links", []);
    /**
     * 表格行数据
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:27
     * @type {Record<string, X6PanelItemTableLinkData>[]}
     */
    __publicField(this, "rows", []);
  }
}

export { X6PanelItemTableState };
