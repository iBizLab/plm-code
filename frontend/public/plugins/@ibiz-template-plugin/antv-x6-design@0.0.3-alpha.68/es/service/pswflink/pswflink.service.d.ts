import { IHttpResponse } from '@ibiz-template/core';
import { DEService } from '@ibiz-template/runtime';
export declare class PSWFLinkService extends DEService {
    exec(id: string, context: IContext, params?: IData | IData[], params2?: IParams): Promise<IHttpResponse<IData>>;
    /**
     * 同步父数据
     *
     * @author tony001
     * @date 2025-01-07 18:01:58
     * @param {IContext} context
     * @param {IData[]} items
     * @return {*}  {Promise<void>}
     */
    asyncParentData(context: IContext, items: IData[]): Promise<void>;
}
