import { DEService } from '@ibiz-template/runtime';
import { generateOrderValue } from 'qx-util';

"use strict";
class PSDELogicLinkService extends DEService {
  async exec(id, context, params, params2) {
    if ((id === "Create" || id === "create") && params) {
      if (Array.isArray(params)) {
        await Promise.all(
          params.map((item) => {
            return this.fillDefault(context, item);
          })
        );
      } else {
        await this.fillDefault(context, params);
      }
    }
    return super.exec(id, context, params, params2);
  }
  async fillDefault(context, params) {
    const res = await this.fetchDefault(context);
    if (res && res.ok && Array.isArray(res.data)) {
      const orderValue = Math.max(
        ...res.data.map((item) => item.ordervalue || 0),
        0
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

export { PSDELogicLinkService };
