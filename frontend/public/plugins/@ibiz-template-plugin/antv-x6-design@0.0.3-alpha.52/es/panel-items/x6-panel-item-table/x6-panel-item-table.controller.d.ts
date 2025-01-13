import { IPortalMessage } from '@ibiz-template/core';
import { CodeListItem, IAppDEService, IAppService, IDataEntity, PanelItemController } from '@ibiz-template/runtime';
import { IAppDataEntity, IDEEditForm, IPanelContainer } from '@ibiz/model-core';
import { X6PanelItemTableState } from './x6-panel-item-table.state';
import { X6DesignViewController } from '../../views';
import { X6LinkServiceProvider, X6NodeServiceProvider, X6PanelItemTableLinkData } from '../../interface';
export declare class X6PanelItemTableController extends PanelItemController<IPanelContainer> {
    protected app: IAppService;
    protected node: IDEEditForm;
    protected link: IDEEditForm;
    protected nodeService: IAppDEService;
    protected linkService: IAppDEService;
    protected nodeProvider: X6NodeServiceProvider;
    protected linkProvider: X6LinkServiceProvider;
    protected nodeModel: IAppDataEntity;
    protected linkModel: IAppDataEntity;
    protected nodeMap: Map<string, IDataEntity>;
    protected linkMap: Map<string, IDataEntity>;
    protected codeItemMap: Map<string | number, CodeListItem>;
    protected addStatusUIActionId: string;
    state: X6PanelItemTableState;
    protected createState(): X6PanelItemTableState;
    get view(): X6DesignViewController;
    protected onInit(): Promise<void>;
    /**
     * 初始化代码表项
     *
     * @author zhanghengfeng
     * @date 2024-01-31 13:01:55
     * @protected
     * @return {*}  {void}
     */
    protected initCodeItems(context: IContext, params: IParams): Promise<void>;
    /**
     * 获取对应类型的代码表项
     *
     * @author zhanghengfeng
     * @date 2024-01-31 13:01:28
     * @protected
     * @param {string} [type]
     * @return {*}  {IData}
     */
    protected getCodeItemData(type?: string): IData;
    /**
     * 订阅消息变更
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:09
     */
    subscribeMessage(): void;
    /**
     * 取消订阅消息
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:02
     */
    unsubscribeMessage(): void;
    /**
     * 监听消息变更
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:08
     * @protected
     * @param {IPortalMessage} msg
     * @return {*}  {void}
     */
    protected onMessageChange(msg: IPortalMessage): void;
    /**
     * 获取当前表单对应实体的数据服务
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:33
     * @protected
     * @param {IDEEditForm} model
     * @return {*}  {Promise<IAppDEService>}
     */
    protected getDeService(model: IDEEditForm): Promise<IAppDEService>;
    /**
     * 初始化界面行为
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:13
     * @protected
     * @return {*}  {void}
     */
    protected initUIAction(): void;
    /**
     * 加载节点数据
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:15
     * @protected
     * @return {*}  {Promise<IDataEntity[]>}
     */
    protected loadNodes(): Promise<IDataEntity[]>;
    /**
     * 加载连线数据
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:48
     * @protected
     * @return {*}  {Promise<IDataEntity[]>}
     */
    protected loadLinks(): Promise<IDataEntity[]>;
    /**
     * 获取连线关系映射
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:18
     * @protected
     * @return {*}  {Map<string, Map<string, string>>}
     */
    protected getConnectionMap(): Map<string, Map<string, string>>;
    /**
     * 生成表格行数据
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:55
     * @protected
     */
    protected generateRows(): void;
    /**
     * 加载数据
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:20
     * @return {*}  {Promise<void>}
     */
    load(): Promise<void>;
    /**
     * 更新节点初始状态
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:32
     * @param {IDataEntity} item
     * @return {*}  {Promise<boolean>}
     */
    updateInitialState(item: IDataEntity): Promise<boolean>;
    /**
     * 获取排序值
     *
     * @author zhanghengfeng
     * @date 2024-01-26 20:01:07
     * @protected
     * @return {*}  {number}
     */
    protected getOrderValue(): number;
    /**
     * 创建节点
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:10
     * @param {MouseEvent} event
     * @return {*}  {Promise<void>}
     */
    createNode(event: MouseEvent): Promise<void>;
    /**
     * 删除节点
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:59
     * @param {IDataEntity} item
     * @return {*}  {Promise<boolean>}
     */
    removeNode(item: IDataEntity): Promise<boolean>;
    /**
     * 激活节点
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:43
     * @param {IDataEntity} item
     */
    activeNode(item: IDataEntity): void;
    /**
     * 创建连线
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:05
     * @param {X6PanelItemTableLinkData} cell
     * @return {*}  {Promise<boolean>}
     */
    createLink(cell: X6PanelItemTableLinkData): Promise<boolean>;
    /**
     * 删除连线
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:23
     * @param {string} key
     * @return {*}  {Promise<boolean>}
     */
    removeLink(cell: X6PanelItemTableLinkData): Promise<boolean>;
    /**
     * 激活连线
     *
     * @author zhanghengfeng
     * @date 2024-01-25 16:01:50
     * @param {X6PanelItemTableLinkData} cell
     * @return {*}  {void}
     */
    activeLink(cell: X6PanelItemTableLinkData): void;
    destroy(): void;
}
