import { TreeService } from '@ibiz-template/runtime';

"use strict";
class LogicDesignTreeService extends TreeService {
  getNodeRSFilterParams(nodeRS, parentNodeData, opts) {
    const result = super.getNodeRSFilterParams(nodeRS, parentNodeData, opts);
    const reg = /^n_.*_eq$/;
    Object.keys(result.navParams).forEach((key) => {
      if (reg.test(key)) {
        delete result.navParams[key];
      }
    });
    Object.keys(result.params).forEach((key) => {
      if (reg.test(key)) {
        delete result.params[key];
      }
    });
    return result;
  }
}

export { LogicDesignTreeService };
