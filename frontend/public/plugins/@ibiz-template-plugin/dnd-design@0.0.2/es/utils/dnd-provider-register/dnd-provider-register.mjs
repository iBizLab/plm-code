"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndProviderRegister {
  constructor() {
    __publicField(this, "dndProviderMap", /* @__PURE__ */ new Map());
  }
  /**
   * 注册拖拽组件绘制
   *
   * @author chitanda
   * @date 2023-12-15 18:12:33
   * @param {DndItemProvider} dndProvider
   */
  registerItemProvider(type, dndProvider) {
    this.dndProviderMap.set(type.toUpperCase(), dndProvider);
  }
  /**
   * 获取拖拽组件绘制
   *
   * @author chitanda
   * @date 2023-12-18 16:12:17
   * @param {string} type
   * @return {*}  {DndItemProvider}
   */
  getItemProvider(type) {
    const upperType = type.toUpperCase();
    if (this.dndProviderMap.has(upperType)) {
      return this.dndProviderMap.get(upperType);
    }
    throw new Error("\u672A\u627E\u5230".concat(upperType, "\u5BF9\u5E94\u7684\u62D6\u62FD\u7EC4\u4EF6\u7ED8\u5236"));
  }
}
const dndProviderRegister = new DndProviderRegister();

export { DndProviderRegister, dndProviderRegister };
