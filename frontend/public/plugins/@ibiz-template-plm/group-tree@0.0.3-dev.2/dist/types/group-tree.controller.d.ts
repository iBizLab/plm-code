import { ITreeEvent, TreeController, ITreeState, ITreeNodeData, MDCtrlRemoveParams } from '@ibiz-template/runtime';
import { IDETree, IDETreeNode } from '@ibiz/model-core';
export type DropNodeRSEx = {
    minorEntityId: string;
    pickupDEFName: string;
    childDETreeNodeId: string;
    detreeNodeRSParams: Array<IData> | undefined;
};
interface IGroupTreeStateEx extends ITreeState {
    /**
     * 新建节点模型
     *
     * @type {Object}
     * @memberof IGroupTreeStateEx
     */
    newingNodeModel: IDETreeNode | undefined | null;
    /**
     * 新建节点文本
     *
     * @type {string | null}
     * @memberof IGroupTreeStateEx
     */
    newingNodeText: string | null;
    /**
     * 新建节点默认值
     *
     * @type {IParams | null}
     * @memberof IGroupTreeStateEx
     */
    newingNodeDefault: IParams | null;
    /**
     * 编辑节点Key值
     *
     * @type {string | null}
     * @memberof IGroupTreeStateEx
     */
    editingNodeKey: string | null;
    /**
     * 编辑节点文本
     *
     * @type {string | null}
     * @memberof IGroupTreeStateEx
     */
    editingNodeText: string | null;
    /**
     * 编辑节点默认值
     *
     * @type {IParams | null}
     * @memberof IGroupTreeStateEx
     */
    editingNodeDefault: IParams | null;
}
export declare class GroupTreeController<T extends IDETree = IDETree, S extends ITreeState = ITreeState, E extends ITreeEvent = ITreeEvent> extends TreeController {
    /**
     * 状态对象
     *
     * @type {IGroupTreeStateEx}
     * @memberof GroupTreeController
     */
    state: IGroupTreeStateEx;
    protected initState(): void;
    /**
     * 临时取消监听
     *
     * @protected
     * @param {IData} msg
     * @memberof GroupTreeController
     */
    protected onDataChange(msg: IData): void;
    /**
     *  初始化节点拖入关系处理
     */
    protected initDropNodeRss(): void;
    /**
     * 编辑指定节点的文本
     * @author ljx
     * @date 2023-12-27 05:46:02
     * @return {*}  {void}
     */
    updateTreeNode({ nodeKey, defaultValue, }: {
        nodeKey: string;
        defaultValue: IParams;
    }): void;
    /**
     * 删除指定节点
     * @author ljx
     * @date 2023-12-27 05:46:02
     * @return {*}  {void}
     */
    removeTreeNode(nodeKey: string): void;
    /**
     * 新建树节点
     * @author ljx
     * @date 2023-12-27 05:46:02
     * @return {*}  {void}
     */
    newTreeNode({ nodeType, defaultValue, }: {
        nodeType: string;
        defaultValue: IParams;
    }): void;
    /**
     * 创建实体节点数据
     * @author ljx
     * @date 2023-12-27 04:19:36
     * @protected
     * @param {ITreeNodeData[]} nodeDatas 节点数据集合
     * @return {*}  {Promise<void>}
     */
    createDeNodeData(nodeDatas: IData[]): Promise<void>;
    /**
     * 创建树节点
     * @author ljx
     * @date 2023-12-27 04:32:52
     * @return {*}  {Promise<void>}
     */
    onCreateTreeNode(): Promise<void>;
    /**
     * 修改节点文本
     * @param nodeData 节点数据
     * @param _text 节点文本
     */
    onModifyTreeNode(nodeData: IData, _text: string): Promise<void>;
    /**
     * 删除树节点
     * @param args 参数
     * @returns
     */
    onRemoveTreeNode(args?: MDCtrlRemoveParams): Promise<void>;
    /**
     * 计算是否允许拖入
     * @param draggingNode
     * @param dropNode
     * @param type
     * @returns
     */
    calcAllowDrop(draggingNode: ITreeNodeData, dropNode: ITreeNodeData, type: 'inner' | 'prev' | 'next'): boolean;
    /**
     * 处理节点拖入事件
     * @param draggingNode
     * @param dropNode
     * @param dropType
     */
    onNodeDrop(draggingNode: ITreeNodeData, dropNode: ITreeNodeData, dropType: 'inner' | 'prev' | 'next'): Promise<void>;
}
export {};
