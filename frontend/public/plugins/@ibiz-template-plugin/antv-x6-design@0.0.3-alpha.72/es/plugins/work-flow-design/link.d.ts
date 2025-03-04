import { Edge, Options, Point } from '@antv/x6';
import { IAppDEService, IDataEntity } from '@ibiz-template/runtime';
import { IDEEditForm } from '@ibiz/model-core';
import { X6LinkDataProvider, X6LinkServiceProvider } from '../../interface';
import { CellProviderImpl } from './cell';
export declare class LinkProviderImpl extends CellProviderImpl<Edge> implements X6LinkServiceProvider {
    protected nodeModel: IDEEditForm;
    protected nodeService?: IAppDEService;
    constructor(node: IDEEditForm, link: IDEEditForm);
    protected getNodeService(context: IContext): Promise<IAppDEService>;
    createDataProvider(data: IDataEntity): X6LinkDataProvider<IDataEntity>;
    getCodeItemData(type?: string): IData;
    protected getVertices(data: X6LinkDataProvider<IDataEntity>): Point.PointLike | Point.PointLike[] | undefined;
    protected getShapeParams(edge: Edge): string | undefined;
    create(context: IContext, params: IParams, edge: Edge): Promise<IDataEntity>;
    update(context: IContext, _params: IParams, edge: Edge): Promise<IDataEntity>;
    delete(context: IContext, _params: IParams, id: string): Promise<IDataEntity>;
    get(_context: IContext, _params: IParams, _id: string): Promise<IDataEntity>;
    copy?(_context: IContext, _params: IParams, _cell: Edge): Promise<IDataEntity>;
    createCell(data: X6LinkDataProvider<IDataEntity>): Edge.Metadata;
    onEdgeLabelRendered(_args: Options.OnEdgeLabelRenderedArgs): undefined;
}
