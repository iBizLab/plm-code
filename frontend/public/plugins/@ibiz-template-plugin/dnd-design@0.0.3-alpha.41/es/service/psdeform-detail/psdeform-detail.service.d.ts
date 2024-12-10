import { DEService, IDataEntity } from '@ibiz-template/runtime';
import { IHttpResponse } from '@ibiz-template/core';
import { PSDEFormDetail } from '../../entity';
/**
 * 表单项服务对象
 *
 * @author chitanda
 * @date 2023-12-23 18:12:50
 * @export
 * @class PSDEFormDetailService
 * @extends {DEService}
 */
export declare class PSDEFormDetailService extends DEService {
    exec(id: string, context: IContext, params?: PSDEFormDetail | PSDEFormDetail[], params2?: IParams): Promise<IHttpResponse<IData>>;
    protected calcDefault(context: IContext, entity: PSDEFormDetail): Promise<void>;
    protected newEntity(data: IData | IDataEntity): IDataEntity;
}
