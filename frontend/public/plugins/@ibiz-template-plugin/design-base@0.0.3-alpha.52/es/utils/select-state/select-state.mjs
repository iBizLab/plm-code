import { QXEvent } from 'qx-util';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class SelectState {
  constructor() {
    /**
     * 选中数据
     *
     * @author tony001
     * @date 2024-08-19 15:08:36
     * @protected
     * @type {(T | null)}
     */
    __publicField(this, "_data", null);
    /**
     * 事件对象
     *
     * @author tony001
     * @date 2024-08-19 15:08:58
     * @protected
     */
    __publicField(this, "evt", new QXEvent());
  }
  /**
   * 原始数据
   *
   * @author tony001
   * @date 2024-08-19 15:08:45
   * @readonly
   * @type {(T | null)}
   */
  get data() {
    return this._data;
  }
  /**
   * 设置选中项
   *
   * @author tony001
   * @date 2024-08-19 16:08:12
   * @param {T} data
   */
  set(data) {
    this._data = data;
    this.evt.emit("change", this._data);
  }
  /**
   * 获取选中项
   *
   * @author tony001
   * @date 2024-08-19 16:08:20
   * @return {*}  {(T | null)}
   */
  get() {
    return this.data;
  }
  /**
   * 重置选中项
   *
   * @author tony001
   * @date 2024-08-19 16:08:31
   */
  reset() {
    this._data = null;
    this.evt.emit("change", null);
  }
  /**
   * 订阅选中变更
   *
   * @author tony001
   * @date 2024-08-19 16:08:40
   * @param {((data?: T | null) => void)} cb
   * @return {*}  {void}
   */
  on(cb) {
    return this.evt.on("change", cb);
  }
  /**
   * 取消选中订阅
   *
   * @author tony001
   * @date 2024-08-19 16:08:58
   * @param {((data?: T | null) => void)} cb 一定要确定，传进来要取消订阅的方法和订阅时方法在内存中指向的是同一个
   */
  off(cb) {
    this.evt.off("change", cb);
  }
}

export { SelectState };
