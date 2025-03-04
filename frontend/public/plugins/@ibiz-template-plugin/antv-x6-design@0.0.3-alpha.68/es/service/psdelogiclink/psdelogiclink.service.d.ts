import { DEService } from '@ibiz-template/runtime';
import { IHttpResponse } from '@ibiz-template/core';
/**
 * @description 实体处理逻辑连线服务
 * @export
 * @class PSDELogicLinkService
 * @extends {DEService}
 */
export declare class PSDELogicLinkService extends DEService {
    exec(id: string, context: IContext, params?: IData | IData[], params2?: IParams): Promise<IHttpResponse<IData>>;
    protected fillDefault(context: IContext, params: IData | IData[]): Promise<void>;
}
