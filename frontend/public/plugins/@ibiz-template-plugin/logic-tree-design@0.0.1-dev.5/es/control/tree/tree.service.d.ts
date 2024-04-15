import { ITreeNodeData, TreeFetchOpts, TreeService } from '@ibiz-template/runtime';
import { IDETreeNodeRS } from '@ibiz/model-core';
export declare class LogicDesignTreeService extends TreeService {
    getNodeRSFilterParams(nodeRS: IDETreeNodeRS, parentNodeData: ITreeNodeData | undefined, opts: TreeFetchOpts): {
        context: IContext;
        params: IParams;
        navContext: IParams;
        navParams: IParams;
    };
}
