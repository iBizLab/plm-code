import { IDEEditForm, ISysPFPlugin, IAppDataEntity } from '@ibiz/model-core';
import { CodeListItem, IAppDEService, IAppService, IDataEntity } from '@ibiz-template/runtime';
import { Cell } from '@antv/x6';
import { X6CellDataProvider, X6CellServiceProvider } from '../../interface';
/**
 * 元素适配器
 *
 * @author chitanda
 * @date 2023-11-21 15:11:10
 * @export
 * @abstract
 * @class CellProviderImpl
 * @implements {X6CellServiceProvider<C, IDataEntity>}
 * @template C
 */
export declare abstract class CellProviderImpl<C> implements X6CellServiceProvider<C, IDataEntity> {
    protected model: IDEEditForm;
    protected pluginConfig: ISysPFPlugin;
    protected app: IAppService;
    protected entityModel?: IAppDataEntity;
    protected deService?: IAppDEService;
    protected codeItems: CodeListItem[];
    protected codeItemMap: Map<string | number, CodeListItem>;
    protected initialized: boolean;
    constructor(model: IDEEditForm);
    init(context: IContext, params: IParams): Promise<void>;
    protected initCodeItems(context: IContext, params: IParams): Promise<void>;
    abstract create(context: IContext, params: IParams, cell: C): Promise<IDataEntity>;
    abstract update(context: IContext, params: IParams, cell: C): Promise<IDataEntity>;
    abstract delete(context: IContext, params: IParams, id: string): Promise<IDataEntity>;
    select(context: IContext, params: IParams): Promise<IDataEntity[]>;
    abstract get(context: IContext, params: IParams, id: string): Promise<IDataEntity>;
    abstract copy?(context: IContext, params: IParams, cell: C): Promise<IDataEntity>;
    abstract createDataProvider(data: IDataEntity): X6CellDataProvider<IDataEntity>;
    abstract createCell(data: X6CellDataProvider<IDataEntity>): Cell.Metadata;
    /**
     * 获取当前节点对应的应用实体模型
     *
     * @author chitanda
     * @date 2023-11-23 15:11:04
     * @protected
     * @return {*}  {Promise<IAppDataEntity>}
     */
    protected getAppDataEntity(): Promise<IAppDataEntity>;
    /**
     * 获取当前表单对应实体的数据服务
     *
     * @author chitanda
     * @date 2023-12-23 14:12:37
     * @protected
     * @param {IContext} context
     * @return {*}  {Promise<IAppDEService>}
     */
    protected getDeService(context: IContext): Promise<IAppDEService>;
}
