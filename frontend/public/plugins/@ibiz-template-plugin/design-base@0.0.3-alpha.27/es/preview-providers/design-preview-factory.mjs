"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
const _DesignPreViewFactory = class _DesignPreViewFactory {
  constructor() {
    /**
     * 预览适配器Map
     *
     * @author tony001
     * @date 2024-09-10 11:09:00
     * @private
     * @type {Map<string, IDesignPreviewProvider>}
     */
    __publicField(this, "preViewProviderMap", /* @__PURE__ */ new Map());
  }
  /**
   * 获取 DesignPreViewFactory 单例对象
   *
   * @static
   * @returns {DesignPreViewFactory}
   * @memberof DesignPreViewFactory
   */
  static getInstance() {
    if (!_DesignPreViewFactory.DesignPreViewFactory) {
      _DesignPreViewFactory.DesignPreViewFactory = new _DesignPreViewFactory();
    }
    return this.DesignPreViewFactory;
  }
  /**
   * 注册预览适配器
   *
   * @author tony001
   * @date 2024-09-10 11:09:21
   * @param {string} key
   * @param {IDesignPreviewProvider} provider
   */
  registerProvider(key, provider) {
    this.preViewProviderMap.set(key, provider);
  }
  /**
   * 获取预览适配器
   *
   * @author tony001
   * @date 2024-09-10 11:09:34
   * @param {string} key
   * @return {*}  {(IDesignPreviewProvider | undefined)}
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
 * @type {DesignPreViewFactory}
 * @memberof DesignPreViewFactory
 */
__publicField(_DesignPreViewFactory, "DesignPreViewFactory");
let DesignPreViewFactory = _DesignPreViewFactory;

export { DesignPreViewFactory };
