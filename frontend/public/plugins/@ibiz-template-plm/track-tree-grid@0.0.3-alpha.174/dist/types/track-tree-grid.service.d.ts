import { ITreeNodeData, TreeDataSetNodeData, TreeFetchOpts, TreeService } from '@ibiz-template/runtime';
import { IDETree, IDETreeDataSetNode, IDETreeNodeRS } from '@ibiz/model-core';
/**
 * 跟踪树表格部件服务
 * @export
 * @class TrackTreeGridService
 * @extends {TreeService<IDETree>}
 */
export declare class TrackTreeGridService<T extends IDETree = IDETree> extends TreeService<T> {
    /**
     * 获取实体数据集数据
     *
     * @protected
     * @param {TreeNodeRSModel} nodeRS
     * @param {TreeFetchOpts} opts
     * @returns {*}
     * @memberof TreeService
     */
    protected getDENodeDatas(nodeModel: IDETreeDataSetNode, nodeRS: IDETreeNodeRS | undefined, parentNodeData: ITreeNodeData | undefined, opts: TreeFetchOpts): Promise<TreeDataSetNodeData[]>;
}
