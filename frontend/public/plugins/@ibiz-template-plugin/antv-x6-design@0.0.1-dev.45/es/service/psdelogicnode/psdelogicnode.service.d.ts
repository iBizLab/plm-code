import { DEService, IDataEntity, MethodDto } from '@ibiz-template/runtime';
import { IAppDEMethodDTO } from '@ibiz/model-core';
import { IHttpResponse } from '@ibiz-template/core';
/**
 * 实体处理逻辑节点服务
 *
 * @author lxm
 * @date 2024-01-05 02:26:20
 * @export
 * @class PSDELogicNodeService
 * @extends {DEService}
 */
export declare class PSDELogicNodeService extends DEService {
    createMethodDto(dto?: IAppDEMethodDTO, opts?: {
        isLocalMode?: boolean;
    }): MethodDto;
    exec(id: string, context: IContext, params?: IData | IData[], params2?: IParams): Promise<IHttpResponse<IData>>;
    protected fillDefault(context: IContext, logicNode: IDataEntity): Promise<void>;
}
