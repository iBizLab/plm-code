import { Graph, Node } from '@antv/x6';
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
    create(context: IContext, params: IParams, node: Node): Promise<IDataEntity>;
    update(context: IContext, _params: IParams, node: Node): Promise<IDataEntity>;
    delete(context: IContext, _params: IParams, id: string): Promise<IDataEntity>;
    get(_context: IContext, _params: IParams, _id: string): Promise<IDataEntity>;
    copy?(_context: IContext, _params: IParams, _cell: Node): Promise<IDataEntity>;
    protected getIcon(codeItem?: CodeListItem): string | undefined;
    createCell(data: X6NodeDataProvider<IDataEntity>): Node.Metadata;
    createDragCell(codeItem: CodeListItem): Node.Metadata;
    createMaterialCell(codeItem: CodeListItem): Node.Metadata;
    createMaterialAddCell(codeItem: CodeListItem): Node.Metadata;
    validateNode(node: Node, options: Dnd.ValidateNodeOptions): boolean;
    createEdges(_node: Node<Node.Properties>, _g: Graph): Promise<void>;
}
