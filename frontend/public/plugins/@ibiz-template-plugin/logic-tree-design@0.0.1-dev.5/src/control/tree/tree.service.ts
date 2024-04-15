import {
  ITreeNodeData,
  TreeFetchOpts,
  TreeService,
} from '@ibiz-template/runtime';
import { IDETreeNodeRS } from '@ibiz/model-core';

export class LogicDesignTreeService extends TreeService {
  getNodeRSFilterParams(
    nodeRS: IDETreeNodeRS,
    parentNodeData: ITreeNodeData | undefined,
    opts: TreeFetchOpts,
  ): {
    context: IContext;
    params: IParams;
    navContext: IParams;
    navParams: IParams;
  } {
    // 删除n__eq格式的视图参数
    const result = super.getNodeRSFilterParams(nodeRS, parentNodeData, opts);
    const reg = /^n_.*_eq$/;
    Object.keys(result.navParams).forEach(key => {
      if (reg.test(key)) {
        delete result.navParams[key];
      }
    });
    Object.keys(result.params).forEach(key => {
      if (reg.test(key)) {
        delete result.params[key];
      }
    });

    return result;
  }
}
