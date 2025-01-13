import { PanelItemState } from '@ibiz-template/runtime';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DesignOperationState extends PanelItemState {
  constructor() {
    super(...arguments);
    /**
     * 所有数据
     *
     * @author tony001
     * @date 2024-09-10 16:09:44
     * @type {IDataEntity[]}
     */
    __publicField(this, "items", []);
    /**
     * 树数据
     *
     * @author tony001
     * @date 2024-09-10 16:09:54
     * @type {ITreeNode[]}
     */
    __publicField(this, "treeData", []);
    /**
     * 操作行为
     *
     * @author tony001
     * @date 2024-09-10 16:09:04
     * @type {IActionItem[]}
     */
    __publicField(this, "actions", [
      {
        type: "add",
        icon: "add-outline",
        tooltip: "\u65B0\u589E"
      },
      {
        type: "remove",
        icon: "close-outline",
        tooltip: "\u5220\u9664"
      }
    ]);
    /**
     * 打开行为规则
     *
     * @author tony001
     * @date 2024-09-10 16:09:15
     * @type {Map<string, RegExp>}
     */
    __publicField(this, "rules", /* @__PURE__ */ new Map());
    /**
     * 激活节点标识
     *
     * @author tony001
     * @date 2024-09-10 17:09:17
     * @type {string}
     */
    __publicField(this, "activeNode", "");
  }
}

export { DesignOperationState };
