import { PanelItemState } from '@ibiz-template/runtime';
import { createUUID } from 'qx-util';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DesignContentState extends PanelItemState {
  constructor() {
    super(...arguments);
    /**
     *主数据
     *
     * @author tony001
     * @date 2024-09-10 14:09:45
     * @type {IData}
     */
    __publicField(this, "majorData", {});
    /**
     * item子数据
     *
     * @author tony001
     * @date 2024-09-10 14:09:40
     * @type {IData[]}
     */
    __publicField(this, "itemDatas", []);
    /**
     * 刷新标识
     *
     * @author tony001
     * @date 2024-09-11 10:09:43
     * @type {string}
     */
    __publicField(this, "refreshTag", createUUID());
  }
}

export { DesignContentState };
