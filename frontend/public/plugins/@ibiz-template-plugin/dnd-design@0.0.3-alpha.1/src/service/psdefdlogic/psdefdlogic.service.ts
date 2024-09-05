import { DEService, IDataEntity } from '@ibiz-template/runtime';
import { IAppDataEntity, ICodeItem } from '@ibiz/model-core';
import { PSDEFDLogic } from '../../entity';

/**
 * 表单项服务对象
 *
 * @author chitanda
 * @date 2023-12-23 18:12:50
 * @export
 * @class PSDEFDLogicService
 * @extends {DEService}
 */
export class PSDEFDLogicService extends DEService {
  /**
   * 类型代码表
   * @author lxm
   * @date 2023-12-27 05:06:47
   * @protected
   * @type {ICodeItem[]}
   */
  protected typeCodeItems: ICodeItem[];

  constructor(srfSessionId: string, model: IAppDataEntity) {
    super(srfSessionId, model);
    const app = ibiz.hub.getApp(model.appId);
    this.typeCodeItems = app.codeList.getCodeList(
      'Config__FDLogicType',
    )!.codeItems!;
  }

  protected newEntity(data: IData | IDataEntity): IDataEntity {
    if (data instanceof PSDEFDLogic) {
      return data.clone();
    }
    return new PSDEFDLogic(this.model, data, this.typeCodeItems);
  }
}
