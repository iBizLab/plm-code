import { Edge, Graph, Node } from '@antv/x6';
import { CodeListItem, IDataEntity } from '@ibiz-template/runtime';
import { IDEEditForm } from '@ibiz/model-core';
import { Dnd } from '@antv/x6-plugin-dnd';
import { X6NodeDataProvider, X6NodeServiceProvider } from '../../interface';
import { CellProviderImpl } from './cell';
export declare class NodeProviderImpl extends CellProviderImpl<Node> implements X6NodeServiceProvider {
    protected linkModel: IDEEditForm;
    protected validateNodeType: string[];
    constructor(node: IDEEditForm, link: IDEEditForm);
    createDataProvider(data: IDataEntity): X6NodeDataProvider<IDataEntity>;
    /**
     * 获取排序值
     *
     * @author zhanghengfeng
     * @date 2024-01-26 20:01:18
     * @protected
     * @param {IDataEntity[]} items
     * @return {*}  {number}
     */
    protected getOrderValue(items: IDataEntity[]): number;
    create(context: IContext, params: IParams, node: Node, items?: IDataEntity[]): Promise<IDataEntity>;
    update(context: IContext, _params: IParams, node: Node): Promise<IDataEntity>;
    delete(context: IContext, _params: IParams, id: string): Promise<IDataEntity>;
    get(context: IContext, _params: IParams, id: string): Promise<IDataEntity>;
    copy(context: IContext, params: IParams, cell: Node): Promise<IDataEntity>;
    protected getIcon(codeItem?: CodeListItem): string | undefined;
    createCell(data: X6NodeDataProvider<IDataEntity>): Node.Metadata;
    createDragCell(codeItem: CodeListItem): Node.Metadata;
    createMaterialCell(codeItem: CodeListItem): Node.Metadata;
    createMaterialAddCell(codeItem: CodeListItem): Node.Metadata;
    validateNode(node: Node, options: Dnd.ValidateNodeOptions): boolean;
    /**
     *  获取与节点相交的边
     *
     * @author zhanghengfeng
     * @date 2024-01-19 17:01:30
     * @protected
     * @param {Node} node
     * @param {Graph} g
     * @return {*}  {(Edge | null)}
     */
    protected findIntersectsEdge(node: Node, g: Graph): Edge | null;
    createEdges(node: Node, g: Graph): Promise<void>;
}
