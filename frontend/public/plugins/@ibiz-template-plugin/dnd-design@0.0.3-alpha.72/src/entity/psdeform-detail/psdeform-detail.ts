import { AppDataEntity } from '@ibiz-template/runtime';
import { isNilOrEmpty, notNilEmpty } from 'qx-util';

export class PSDEFormDetail extends AppDataEntity {
  get srftext() {
    let caption = this.caption;
    const psdefformitemname = this.psdefformitemname || this.psdefuimodename;
    const itemname = this.psdeformdetailname || this.psdefname;
    if (this.detailtype === 'FORMITEM') {
      const logicname = this.logicname;
      if (isNilOrEmpty(caption) && notNilEmpty(logicname)) {
        if (isNilOrEmpty(psdefformitemname)) {
          caption = logicname;
        }
      }
      if (notNilEmpty(caption)) {
        if (notNilEmpty(psdefformitemname)) {
          return `${caption}(${itemname})[${psdefformitemname}]`;
        }
        return `${caption}(${itemname})`;
      }
      if (notNilEmpty(psdefformitemname)) {
        return `${itemname}(${psdefformitemname})`;
      }
      return itemname;
    }
    if (notNilEmpty(caption)) {
      return `${caption}(${itemname})`;
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
  clone(): PSDEFormDetail {
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
  assign(data: AppDataEntity | IData): AppDataEntity {
    if (data.srfordervalue === undefined) {
      data.srfordervalue = this.srfordervalue;
    }
    return super.assign(data);
  }
}
