import { AppDataEntity } from '@ibiz-template/runtime';
import { isNilOrEmpty, notNilEmpty } from 'qx-util';

"use strict";
class PSDEFormDetail extends AppDataEntity {
  get srftext() {
    let caption = this.caption;
    const psdefformitemname = this.psdefformitemname || this.psdefuimodename;
    const itemname = this.psdeformdetailname || this.psdefname;
    if (this.detailtype === "FORMITEM") {
      const logicname = this.logicname;
      if (isNilOrEmpty(caption) && notNilEmpty(logicname)) {
        if (isNilOrEmpty(psdefformitemname)) {
          caption = logicname;
        }
      }
      if (notNilEmpty(caption)) {
        if (notNilEmpty(psdefformitemname)) {
          return "".concat(caption, "(").concat(itemname, ")[").concat(psdefformitemname, "]");
        }
        return "".concat(caption, "(").concat(itemname, ")");
      }
      if (notNilEmpty(psdefformitemname)) {
        return "".concat(itemname, "(").concat(psdefformitemname, ")");
      }
      return itemname;
    }
    if (notNilEmpty(caption)) {
      return "".concat(caption, "(").concat(itemname, ")");
    }
    return itemname;
  }
  get srftype() {
    return this.detailtype;
  }
  set srftype(value) {
    this.detailtype = value;
  }
  get srfpkey() {
    return this.ppsdeformdetailid;
  }
  set srfpkey(value) {
    this.ppsdeformdetailid = value;
  }
  //  @ts-expect-error
  get srfordervalue() {
    return this.ordervalue;
  }
  set srfordervalue(value) {
    this.ordervalue = value;
  }
  /**
   * 克隆数据
   *
   * @author chitanda
   * @date 2022-10-11 00:10:15
   * @return {*}  {PSDEFormDetail}
   */
  clone() {
    const entity = new PSDEFormDetail(this._entity, this._data);
    entity.srfkey = this.srfkey;
    entity.srfordervalue = this.srfordervalue;
    return entity;
  }
  /**
   * 合并数据
   *
   * @param {(AppDataEntity | IData)} data
   * @return {*}  {AppDataEntity}
   * @memberof PSDEFormDetail
   */
  assign(data) {
    if (data.srfordervalue === void 0) {
      data.srfordervalue = this.srfordervalue;
    }
    return super.assign(data);
  }
}

export { PSDEFormDetail };
