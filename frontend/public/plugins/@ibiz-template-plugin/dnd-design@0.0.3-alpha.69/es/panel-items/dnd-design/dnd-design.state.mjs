import { PanelItemState } from '@ibiz-template/runtime';
import { createUUID } from 'qx-util';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndDesignPanelItemState extends PanelItemState {
  constructor() {
    super(...arguments);
    /**
     * 数据项
     *
     * @description 子数据为 children
     * @author chitanda
     * @date 2023-12-18 15:12:15
     * @type {IDataEntity[]}
     */
    __publicField(this, "items", []);
    /**
     * 当前选中的数据
     *
     * @author chitanda
     * @date 2023-12-21 17:12:52
     * @type {(IDataEntity | null)}
     */
    __publicField(this, "activeData", null);
    /**
     * key标识，用于触发重新渲染
     *
     * @author zhanghengfeng
     * @date 2024-01-05 15:01:51
     * @type {string}
     */
    __publicField(this, "uuid", createUUID());
    /**
     * 隐藏表单项是否可见
     *
     * @author zhanghengfeng
     * @date 2024-06-05 13:06:17
     * @type {boolean}
     */
    __publicField(this, "hiddenFormItemVisible", true);
    /**
     * 逻辑映射map
     *
     * @author zhanghengfeng
     * @date 2025-02-12 22:02:01
     * @type {Record<string, number>}
     */
    __publicField(this, "logicMap", {});
  }
}

export { DndDesignPanelItemState };
