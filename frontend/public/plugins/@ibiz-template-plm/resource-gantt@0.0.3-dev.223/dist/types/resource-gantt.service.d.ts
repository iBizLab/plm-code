import { GanttService, IGanttNodeData, TreeFetchOpts } from '@ibiz-template/runtime';
import { IDETreeNode, IDETreeNodeRS } from '@ibiz/model-core';
interface ResourceGanttFetchOpts extends TreeFetchOpts {
    /**
     * 分组属性
     *
     * @type {string}
     * @memberof ResourceGanttFetchOpts
     */
    groupField: string;
}
/**
 * 资源甘特图服务
 *
 * @author tony001
 * @date 2023-12-11 16:12:57
 * @export
 * @class GanttService
 * @extends {TreeService}
 */
export declare class ResourceGanttService extends GanttService {
    /**
     * 通过节点类型加载节点数据
     *
     * @author tony001
     * @date 2023-12-11 18:12:35
     * @protected
     * @param {IDETreeNode} nodeModel
     * @param {(IDETreeNodeRS | undefined)} nodeRS
     * @param {(ITreeNodeData | undefined)} parentNodeData
     * @param {ResourceGanttFetchOpts} opts
     * @return {*}  {Promise<IGanttNodeData[]>}
     */
    protected fetchNodeDatasByType(nodeModel: IDETreeNode, nodeRS: IDETreeNodeRS | undefined, parentNodeData: IGanttNodeData | undefined, opts: ResourceGanttFetchOpts): Promise<IGanttNodeData[]>;
    /**
     * 获取子节点数据
     *
     * @param {(IGanttNodeData | undefined)} parentNodeData
     * @param {ResourceGanttFetchOpts} opts
     * @return {*}  {(Promise<IGanttNodeData[] | undefined>)}
     */
    fetchChildNodes(parentNodeData: IGanttNodeData | undefined, opts: ResourceGanttFetchOpts): Promise<IGanttNodeData[] | undefined>;
    /**
     * 分组排序
     *
     * @param {(IGanttNodeData[] | undefined)} parentNodeData
     * @param {string} groupField
     */
    groupSort(nodes: IGanttNodeData[], groupField: string): IGanttNodeData[];
}
export {};
