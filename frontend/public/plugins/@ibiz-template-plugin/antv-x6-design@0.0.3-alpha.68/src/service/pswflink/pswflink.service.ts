/* eslint-disable no-await-in-loop */
import { IHttpResponse } from '@ibiz-template/core';
import { DEService } from '@ibiz-template/runtime';

export class PSWFLinkService extends DEService {
  async exec(
    id: string,
    context: IContext,
    params?: IData | IData[],
    params2?: IParams,
  ): Promise<IHttpResponse<IData>> {
    const res = await super.exec(id, context, params, params2);
    if (id === 'FetchDefault') {
      if (res.ok && res.data) {
        this.asyncParentData(context, res.data as IData[]);
      }
    }
    return res;
  }

  /**
   * 同步父数据
   *
   * @author tony001
   * @date 2025-01-07 18:01:58
   * @param {IContext} context
   * @param {IData[]} items
   * @return {*}  {Promise<void>}
   */
  async asyncParentData(context: IContext, items: IData[]): Promise<void> {
    if (items && items.length > 0) {
      const app = ibiz.hub.getApp(context.srfappid);
      const wfProcessService = await app.deService.getService(
        context,
        'workflowdesign.pswfprocess',
      );
      for (let i = 0; i < items.length; i++) {
        const item = items[i];
        if (item.frompswfprocid) {
          const tempContext = context.clone();
          tempContext.pswfprocess = item.frompswfprocid;
          const res1 = await wfProcessService.getTemp(tempContext);
          if (res1.ok && res1.data) {
            item.psdeid = res1.data.psdeid;
          }
        } else {
          item.psdeid = undefined;
        }
      }
    }
  }
}
