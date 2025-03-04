import { AppDataEntity } from '@ibiz-template/runtime';
import { IAppDataEntity, ICodeItem, ISysImage } from '@ibiz/model-core';

export class PSWFLinkCond extends AppDataEntity {
  declare _typeCodeItems: ICodeItem[];

  constructor(
    entity: IAppDataEntity,
    data: IData | PSWFLinkCond,
    typeCodeItems: ICodeItem[],
  ) {
    super(entity, data);

    Object.defineProperty(this, '_typeCodeItems', {
      enumerable: false,
      configurable: true,
      value: typeCodeItems,
    });
  }

  /**
   * 显示文本
   * @author lxm
   * @date 2023-12-27 05:20:00
   * @readonly
   */
  get srftext() {
    if (this.srftype === 'GROUP') {
      return `${this.groupop || ''}`;
    }
    return `${this.dstpsdefname || this.customdstparam || ''} ${
      this.psdbvalueopname || ''
    } ${this.condvalue || ''}`;
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

  get srficon(): ISysImage | undefined {
    const codeItem = this._typeCodeItems.find(
      item => item.value === this.srftype,
    );
    return codeItem ? codeItem.sysImage : undefined;
  }

  /**
   * 是否允许拖入
   * @author lxm
   * @date 2023-12-27 04:27:57
   * @readonly
   */
  get srfallowdrop() {
    return this.srftype === 'GROUP';
  }

  /**
   * 克隆数据
   *
   * @author chitanda
   * @date 2022-10-11 00:10:15
   * @return {*}  {PSWFLinkCond}
   */
  clone(): PSWFLinkCond {
    const entity = new PSWFLinkCond(
      this._entity,
      this._data,
      this._typeCodeItems,
    );
    entity.srfkey = this.srfkey;
    return entity;
  }
}
