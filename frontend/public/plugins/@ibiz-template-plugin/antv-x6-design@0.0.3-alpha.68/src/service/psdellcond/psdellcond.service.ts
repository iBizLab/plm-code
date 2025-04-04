import { DEService, IAppService, IDataEntity } from '@ibiz-template/runtime';
import { IAppDataEntity, ICodeItem } from '@ibiz/model-core';
import { IHttpResponse } from '@ibiz-template/core';
import { PSDellCond } from '../../entity';

/**
 * 表单项服务对象
 *
 * @author chitanda
 * @date 2023-12-23 18:12:50
 * @export
 * @class PSDellCondService
 * @extends {DEService}
 */
export class PSDellCondService extends DEService {
  /**
   * 类型代码表
   * @author lxm
   * @date 2023-12-27 05:06:47
   * @protected
   * @type {ICodeItem[]}
   */
  protected typeCodeItems: ICodeItem[];

  protected app: IAppService;

  constructor(srfSessionId: string, model: IAppDataEntity) {
    super(srfSessionId, model);
    const app = ibiz.hub.getApp(model.appId);
    this.typeCodeItems = app.codeList.getCodeList(
      'Config__DELogicLinkCondType',
    )!.codeItems!;
    this.app = app;
  }

  protected newEntity(data: IData | IDataEntity): IDataEntity {
    if (data instanceof PSDellCond) {
      return data.clone();
    }
    return new PSDellCond(this.model, data, this.typeCodeItems);
  }

  protected async updateLogicLinkCount(context: IContext): Promise<void> {
    const service = await this.app.deService.getService(
      context,
      'logicdesign.psdelogiclink',
    );
    const res = await service.get(context);
    if (!res.ok || !res.data) {
      return;
    }
    const logicLink = res.data;
    const result = await this.exec('FetchCurLogicLink', {
      ...context,
      psdellcond: null,
    });
    if (!result.ok) {
      return;
    }
    if (Array.isArray(result.data) && result.data.length > 0) {
      logicLink.linklogiccount = result.data.length;
      logicLink.psdellconds = result.data;
    } else {
      logicLink.linklogiccount = 0;
      logicLink.psdellconds = [];
    }
    const updateResult = await service.update(context, logicLink);
    if (updateResult.ok && updateResult.data) {
      const entity = updateResult.data;
      ibiz.mc.command.update.send(entity as IDataEntity);
    }
  }

  async exec(
    id: string,
    context: IContext,
    params?: IData | IData[],
    params2?: IParams,
  ): Promise<IHttpResponse<IData>> {
    const result = await super.exec(id, context, params, params2);
    if (id === 'create' || id === 'remove') {
      await this.updateLogicLinkCount(context);
    }
    return result;
  }
}
