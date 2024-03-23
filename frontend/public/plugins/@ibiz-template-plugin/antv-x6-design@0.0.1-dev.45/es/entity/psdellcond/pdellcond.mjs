import { AppDataEntity } from '@ibiz-template/runtime';

"use strict";
class PSDellCond extends AppDataEntity {
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
      return "".concat(this.groupop || "");
    }
    return "".concat(this.dstpsdefname || this.customdstparam || "", " ").concat(this.psdbvalueopname || "", " ").concat(this.condvalue || "");
  }
  /**
   * 类型
   * @author lxm
   * @date 2023-12-27 05:20:06
   */
  get srftype() {
    return this.logictype;
  }
  set srftype(value) {
    this.logictype = value;
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
   * @return {*}  {PSDellCond}
   */
  clone() {
    const entity = new PSDellCond(
      this._entity,
      this._data,
      this._typeCodeItems
    );
    entity.srfkey = this.srfkey;
    return entity;
  }
}

export { PSDellCond };
