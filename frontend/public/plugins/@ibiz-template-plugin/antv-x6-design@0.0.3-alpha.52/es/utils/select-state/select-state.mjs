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
     * @author chitanda
     * @date 2022-02-21 13:02:29
     * @protected
     * @type {(T | null)}
     */
    __publicField(this, "_data", null);
    __publicField(this, "evt", new QXEvent());
  }
  get data() {
    return this._data;
  }
  /**
   * 设置选中项
   *
   * @author chitanda
   * @date 2022-02-21 13:02:24
   * @param {T} data
   */
  set(data) {
    this._data = data;
    this.evt.emit("change", this._data);
  }
  /**
   * 获取选中项
   *
   * @author chitanda
   * @date 2022-02-21 13:02:18
   * @return {*}  {(T | null)}
   */
  get() {
    return this.data;
  }
  /**
   * 重置选中项
   *
   * @author chitanda
   * @date 2022-02-21 13:02:12
   */
  reset() {
    this._data = null;
    this.evt.emit("change", null);
  }
  /**
   * 订阅选中变更
   *
   * @author chitanda
   * @date 2022-02-21 14:02:04
   * @param {((data?: T | null) => void)} cb
   * @return {*}  {void}
   */
  on(cb) {
    return this.evt.on("change", cb);
  }
  /**
   * 取消选中订阅
   *
   * @author chitanda
   * @date 2022-02-21 14:02:26
   * @param {((data?: T | null) => void)} cb 一定要确定，传进来要取消订阅的方法和订阅时方法在内存中指向的是同一个
   */
  off(cb) {
    this.evt.off("change", cb);
  }
}

export { SelectState };
