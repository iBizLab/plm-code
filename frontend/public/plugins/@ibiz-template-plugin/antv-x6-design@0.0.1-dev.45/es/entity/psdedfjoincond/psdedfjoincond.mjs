import { AppDataEntity } from '@ibiz-template/runtime';

"use strict";
class PSDEDFJoinCond extends AppDataEntity {
  constructor(entity, data, typeCodeItems) {
    super(entity, data);
    Object.defineProperty(this, "_typeCodeItems", {
      enumerable: false,
      configurable: true,
      value: typeCodeItems
    });
  }
  /**
   * 显示文本
   * @author lxm
   * @date 2023-12-27 05:20:00
   * @readonly
   */
  get srftext() {
    if (this.srftype === "GROUP") {
      return "".concat(this.op || "");
    }
    return "".concat(this.fieldscope || "", " ").concat(this.op || "", " ").concat(this.valuetype || "").concat(this.value ? "[".concat(this.value, "]") : "");
  }
  /**
   * 类型
   * @author lxm
   * @date 2023-12-27 05:20:06
   */
  get srftype() {
    return this.type;
  }
  set srftype(value) {
    this.type = value;
  }
  get srficon() {
    const codeItem = this._typeCodeItems.find(
      (item) => item.value === this.srftype
    );
    return codeItem ? codeItem.sysImage : void 0;
  }
  /**
   * 是否允许拖入
   * @author lxm
   * @date 2023-12-27 04:27:57
   * @readonly
   */
  get srfallowdrop() {
    return this.srftype === "GROUP";
  }
  /**
   * 克隆数据
   *
   * @author chitanda
   * @date 2022-10-11 00:10:15
   * @return {*}  {PSDEDFJoinCond}
   */
  clone() {
    const entity = new PSDEDFJoinCond(
      this._entity,
      this._data,
      this._typeCodeItems
    );
    entity.srfkey = this.srfkey;
    return entity;
  }
}

export { PSDEDFJoinCond };
