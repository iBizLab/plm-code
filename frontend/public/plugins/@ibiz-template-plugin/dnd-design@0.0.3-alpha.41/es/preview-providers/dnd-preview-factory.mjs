"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
const _DndPreViewFactory = class _DndPreViewFactory {
  constructor() {
    /**
     * 预览providerMap
     *
     * @author tony001
     * @date 2024-09-04 12:09:55
     * @private
     * @type {Map<string, IPreviewProvider>}
     */
    __publicField(this, "preViewProviderMap", /* @__PURE__ */ new Map());
  }
  /**
   * 获取 DndPreViewFactory 单例对象
   *
   * @static
   * @returns {DndPreViewFactory}
   * @memberof DndPreViewFactory
   */
  static getInstance() {
    if (!_DndPreViewFactory.DndPreViewFactory) {
      _DndPreViewFactory.DndPreViewFactory = new _DndPreViewFactory();
    }
    return this.DndPreViewFactory;
  }
  /**
   * 注册provider
   *
   * @author tony001
   * @date 2024-09-04 12:09:01
   * @param {string} key
   * @param {IPreviewProvider} provider
   */
  registerProvider(key, provider) {
    this.preViewProviderMap.set(key, provider);
  }
  /**
   * 获取provider
   *
   * @author tony001
   * @date 2024-09-04 12:09:41
   * @param {string} key
   * @return {*}  {IPreviewProvider}
   */
  getProvider(key) {
    return this.preViewProviderMap.get(key);
  }
};
/**
 * 单例变量声明
 *
 * @private
 * @static
 * @type {DndPreViewFactory}
 * @memberof DndPreViewFactory
 */
__publicField(_DndPreViewFactory, "DndPreViewFactory");
let DndPreViewFactory = _DndPreViewFactory;

export { DndPreViewFactory };
