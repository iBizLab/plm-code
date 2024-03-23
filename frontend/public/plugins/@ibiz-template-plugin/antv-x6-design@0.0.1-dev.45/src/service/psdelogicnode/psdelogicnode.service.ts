import { DEService, IDataEntity, MethodDto } from '@ibiz-template/runtime';
import { IAppDEMethodDTO } from '@ibiz/model-core';
import { IHttpResponse } from '@ibiz-template/core';
import { PSDELogicMethodDto } from './psdelogicnode-method-dto';

/**
 * 实体处理逻辑节点服务
 *
 * @author lxm
 * @date 2024-01-05 02:26:20
 * @export
 * @class PSDELogicNodeService
 * @extends {DEService}
 */
export class PSDELogicNodeService extends DEService {
  createMethodDto(
    dto?: IAppDEMethodDTO,
    opts?: {
      isLocalMode?: boolean;
    },
  ): MethodDto {
    if (
      ibiz.appData &&
      ibiz.appData.context &&
      ibiz.appData.context.srfsystemid === 'dataflowdesign'
    ) {
      return new PSDELogicMethodDto(this, this.model, opts?.isLocalMode, dto);
    }
    return super.createMethodDto(dto, opts);
  }

  async exec(
    id: string,
    context: IContext,
    params?: IData | IData[],
    params2?: IParams,
  ): Promise<IHttpResponse<IData>> {
    if ((id === 'Create' || id === 'create') && params) {
      if (Array.isArray(params)) {
        await Promise.all(
          params.map(item => {
            return this.fillDefault(context, item);
          }),
        );
      } else {
        await this.fillDefault(context, params as IDataEntity);
      }
    }
    return super.exec(id, context, params, params2);
  }

  protected async fillDefault(context: IContext, logicNode: IDataEntity) {
    if (!logicNode.codename) {
      const res = await this.fetchDefault(context);
      if (res.ok) {
        const details = res.data;
        const codeNames = details.map((item: IDataEntity) => item.codename);
        let num = 1;
        let codeName = `${logicNode.logicnodetype}_0${num}`;
        while (codeNames.includes(codeName)) {
          num += 1;
          codeName = `${logicNode.logicnodetype}_0${num}`;
        }
        logicNode.codename = codeName;
      }
    }
  }
}
