import { DEService, IDataEntity } from '@ibiz-template/runtime';
import { IHttpResponse } from '@ibiz-template/core';
/**
 * 表单项服务对象
 *
 * @author chitanda
 * @date 2024-01-17 11:01:28
 * @export
 * @class PSWFProcessService
 * @extends {DEService}
 */
export declare class PSWFProcessService extends DEService {
    exec(id: string, context: IContext, params?: IData | IData[], params2?: IParams): Promise<IHttpResponse<IData>>;
    protected fillDefault(context: IContext, process: IDataEntity): Promise<void>;
}
