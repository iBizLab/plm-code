"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class X6ProviderRegister {
  constructor() {
    /**
     * 节点适配器
     *
     * @author chitanda
     * @date 2023-11-21 11:11:47
     * @protected
     * @type {Map<string, registerNode>}
     */
    __publicField(this, "nodeProviderMap", /* @__PURE__ */ new Map());
    /**
     * 连线适配器
     *
     * @author chitanda
     * @date 2023-11-21 11:11:52
     * @protected
     * @type {Map<string, registerLink>}
     */
    __publicField(this, "linkProviderMap", /* @__PURE__ */ new Map());
    /**
     * 节点数据适配器
     *
     * @author chitanda
     * @date 2023-11-21 11:11:00
     * @protected
     * @type {Map<string, registerNodeData<unknown>>}
     */
    __publicField(this, "nodeDataProviderMap", /* @__PURE__ */ new Map());
    /**
     * 连线数据适配器
     *
     * @author chitanda
     * @date 2023-11-21 11:11:07
     * @protected
     * @type {Map<string, registerLinkData<unknown>>}
     */
    __publicField(this, "linkDataProviderMap", /* @__PURE__ */ new Map());
  }
  /**
   * 注册节点适配器
   *
   * @author chitanda
   * @date 2023-11-21 11:11:49
   * @param {string} tag
   * @param {registerNode} provider
   */
  registerNode(tag, provider) {
    this.nodeProviderMap.set(tag.toUpperCase(), provider);
  }
  /**
   * 注册连线适配器
   *
   * @author chitanda
   * @date 2023-11-21 11:11:57
   * @param {string} tag
   * @param {registerLink} provider
   */
  registerLink(tag, provider) {
    this.linkProviderMap.set(tag.toUpperCase(), provider);
  }
  /**
   * 注册节点数据适配器
   *
   * @author chitanda
   * @date 2023-11-21 11:11:05
   * @param {string} tag
   * @param {registerNodeData} provider
   */
  registerNodeData(tag, provider) {
    this.nodeDataProviderMap.set(
      tag.toUpperCase(),
      provider
    );
  }
  /**
   * 注册连线数据适配器
   *
   * @author chitanda
   * @date 2023-11-21 11:11:13
   * @param {string} tag
   * @param {registerLinkData} provider
   */
  registerLinkData(tag, provider) {
    this.linkDataProviderMap.set(
      tag.toUpperCase(),
      provider
    );
  }
  /**
   * 获取节点适配器对象
   *
   * @author chitanda
   * @date 2023-11-21 11:11:19
   * @param {string} tag
   * @return {*}  {registerNode}
   */
  getNode(tag) {
    tag = tag.toUpperCase();
    if (this.nodeProviderMap.has(tag)) {
      return this.nodeProviderMap.get(tag);
    }
    throw new Error("\u672A\u627E\u5230\u8282\u70B9\u9002\u914D\u5668\uFF1A".concat(tag));
  }
  /**
   * 获取连线适配器对象
   *
   * @author chitanda
   * @date 2023-11-21 11:11:29
   * @param {string} tag
   * @return {*}  {registerLink}
   */
  getLink(tag) {
    tag = tag.toUpperCase();
    if (this.linkProviderMap.has(tag)) {
      return this.linkProviderMap.get(tag);
    }
    throw new Error("\u672A\u627E\u5230\u8FDE\u7EBF\u9002\u914D\u5668\uFF1A".concat(tag));
  }
  /**
   * 获取节点数据适配器对象
   *
   * @author chitanda
   * @date 2023-11-21 11:11:13
   * @template T
   * @param {string} tag
   * @return {*}  {registerNodeData<T>}
   */
  getNodeData(tag) {
    tag = tag.toUpperCase();
    if (this.nodeDataProviderMap.has(tag)) {
      return this.nodeDataProviderMap.get(tag);
    }
    throw new Error("\u672A\u627E\u5230\u8282\u70B9\u6570\u636E\u9002\u914D\u5668\uFF1A".concat(tag));
  }
  /**
   * 获取连线数据适配器对象
   *
   * @author chitanda
   * @date 2023-11-21 11:11:20
   * @template T
   * @param {string} tag
   * @return {*}  {registerLinkData<T>}
   */
  getLinkData(tag) {
    tag = tag.toUpperCase();
    if (this.linkDataProviderMap.has(tag)) {
      return this.linkDataProviderMap.get(tag);
    }
    throw new Error("\u672A\u627E\u5230\u8FDE\u7EBF\u6570\u636E\u9002\u914D\u5668\uFF1A".concat(tag));
  }
}
const x6ProviderRegister = new X6ProviderRegister();

export { x6ProviderRegister };
