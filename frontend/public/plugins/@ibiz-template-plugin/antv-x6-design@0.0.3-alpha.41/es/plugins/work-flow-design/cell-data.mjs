"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class CellDataProviderImpl {
  constructor(data) {
    /**
     * 图形额外参数存储
     *
     * @author chitanda
     * @date 2023-11-24 18:11:29
     * @type {unknown}
     */
    __publicField(this, "shapeparams");
    __publicField(this, "data");
    this.data = data;
  }
  get id() {
    return this.data.srfkey;
  }
  get label() {
    return this.data.srfmajortext;
  }
}

export { CellDataProviderImpl };
