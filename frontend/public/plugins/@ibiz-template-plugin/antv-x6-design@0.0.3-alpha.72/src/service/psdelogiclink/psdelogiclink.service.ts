import { DEService, IDataEntity } from '@ibiz-template/runtime';
import { generateOrderValue } from 'qx-util';
import { IHttpResponse } from '@ibiz-template/core';

/**
 * @description 实体处理逻辑连线服务
 * @export
 * @class PSDELogicLinkService
 * @extends {DEService}
 */
export class PSDELogicLinkService extends DEService {
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

  protected async fillDefault(
    context: IContext,
    params: IData | IData[],
  ): Promise<void> {
    const res = await this.fetchDefault(context);
    if (res && res.ok && Array.isArray(res.data)) {
      const orderValue = Math.max(
        ...res.data.map(item => item.ordervalue || 0),
        0,
      );
      const items = Array.isArray(params) ? params : [params];
      items.forEach((item, i) => {
        if (item.ordervalue == null) {
          item.ordervalue = orderValue + generateOrderValue(i);
        }
      });
    }
  }
}
