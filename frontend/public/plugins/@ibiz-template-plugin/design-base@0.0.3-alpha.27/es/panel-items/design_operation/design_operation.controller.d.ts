import { IAppDEService, PanelItemController } from '@ibiz-template/runtime';
import { IAppDataEntity, IAppView, IDEEditForm, IPanelContainer } from '@ibiz/model-core';
import { IPortalMessage } from '@ibiz-template/core';
import { DesignOperationState } from './design_operation.state';
import { IActionItem, IDesignViewEvent, IDesignViewState, INewItem, ITreeNode } from '../../interface';
import { DesignViewControllerBase } from '../../views';
export declare class DesignOperationController extends PanelItemController<IPanelContainer> {
    /**
     * 当前状态
     *
     * @author tony001
     * @date 2024-09-10 16:09:07
     * @type {DesignOperationState}
     */
    state: DesignOperationState;
    /**
     * 主数据服务
     *
     * @author tony001
     * @date 2024-09-10 16:09:23
     * @protected
     * @type {IAppDEService}
     */
    protected majorService: IAppDEService;
    /**
     * 子项数据服务
     *
     * @author tony001
     * @date 2024-09-10 16:09:43
     * @protected
     * @type {IAppDEService}
     */
    protected itemService: IAppDEService;
    /**
     * 主实体
     *
     * @author tony001
     * @date 2024-09-10 16:09:53
     * @protected
     * @type {IAppDataEntity}
     */
    protected majorEntity: IAppDataEntity;
    /**
     * 从实体
     *
     * @author tony001
     * @date 2024-09-10 16:09:07
     * @protected
     * @type {IAppDataEntity}
     */
    protected itemEntity: IAppDataEntity;
    /**
     * 类型属性
     *
     * @author tony001
     * @date 2024-09-10 16:09:21
     * @protected
     * @type {string}
     */
    protected typeKeyName: string;
    /**
     * 子项实体主键名称
     *
     * @author tony001
     * @date 2024-09-10 16:09:31
     * @protected
     * @type {string}
     */
    protected itemEntityKeyName: string;
    /**
     * 可新建项
     *
     * @author tony001
     * @date 2024-09-10 16:09:04
     * @protected
     * @type {INewItem[]}
     */
    protected newItems: INewItem[];
    /**
     * 规则数据
     *
     * @author tony001
     * @date 2024-09-10 16:09:18
     * @protected
     * @type {*}
     */
    protected ruleData: any;
    /**
     * 根路径默认参数
     *
     * @author tony001
     * @date 2024-09-10 16:09:31
     * @protected
     * @type {*}
     */
    protected defaultRoot: any;
    /**
     * 绘制树引用
     *
     * @author tony001
     * @date 2024-09-10 16:09:40
     * @protected
     * @type {*}
     */
    protected treeRef: any;
    /**
     * 视图对象
     *
     * @author tony001
     * @date 2024-09-10 16:09:22
     * @readonly
     * @type {DesignViewControllerBase<
     *     IAppView,
     *     IDesignViewState,
     *     IDesignViewEvent
     *   >}
     */
    get view(): DesignViewControllerBase<IAppView, IDesignViewState, IDesignViewEvent>;
    /**
     * 主表单
     *
     * @author tony001
     * @date 2024-09-10 16:09:37
     * @readonly
     * @type {IDEEditForm}
     */
    get majorForm(): IDEEditForm;
    /**
     * 项表单
     *
     * @author tony001
     * @date 2024-09-10 16:09:45
     * @readonly
     * @type {IDEEditForm}
     */
    get itemForm(): IDEEditForm;
    /**
     * 创建面板状态对象
     *
     * @author tony001
     * @date 2024-09-10 16:09:33
     * @protected
     * @return {*}  {DesignOperationState}
     */
    protected createState(): DesignOperationState;
    /**
     * 初始化
     *
     * @author tony001
     * @date 2024-09-10 16:09:00
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected onInit(): Promise<void>;
    /**
     * 初始化基础资源
     *
     * @author tony001
     * @date 2024-09-10 16:09:29
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected initBaseResource(): Promise<void>;
    /**
     * 订阅数据变化
     *
     * @author tony001
     * @date 2024-09-10 17:09:50
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected subscribeDataChange(): Promise<void>;
    /**
     * 取消订阅数据变化
     *
     * @author tony001
     * @date 2024-09-10 17:09:13
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected unSubscribeDataChange(): Promise<void>;
    /**
     * 初始化用户参数
     *
     * @author tony001
     * @date 2024-09-10 16:09:41
     * @protected
     */
    protected initUserParam(): void;
    /**
     * 加载数据
     *
     * @author tony001
     * @date 2024-09-10 16:09:39
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected load(): Promise<void>;
    /**
     * 加载之后
     *
     * @protected
     * @memberof GridDesignOperationController
     */
    protected afterLoad(args: IData): Promise<void>;
    /**
     * 刷新
     *
     * @author tony001
     * @date 2024-09-10 17:09:48
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected refresh(): Promise<void>;
    /**
     * 选中数据变化
     *
     * @author tony001
     * @date 2024-09-10 17:09:57
     * @protected
     * @param {(IData | null)} [data]
     */
    protected onSelectDataChange(data?: IData | null): void;
    /**
     * 监听数据变化
     *
     * @author tony001
     * @date 2024-09-10 17:09:49
     * @protected
     * @param {IPortalMessage} msg
     */
    protected onDEDataChange(msg: IPortalMessage): void;
    /**
     * 生成树节点
     *
     * @author tony001
     * @date 2024-09-10 16:09:22
     * @protected
     * @param {IData} data
     * @return {*}  {ITreeNode}
     */
    protected generateTreeNode(data: IData): ITreeNode;
    /**
     * 递归计算树结构数据
     *
     * @author tony001
     * @date 2024-09-10 16:09:31
     * @protected
     * @param {any[]} items
     * @param {ITreeNode} p
     */
    protected calcTreeNodes(items: any[], p: ITreeNode): void;
    /**
     * 设置树引用
     *
     * @author tony001
     * @date 2024-09-10 17:09:25
     * @param {*} treeRef
     */
    setTreeRef(treeRef: any): void;
    /**
     * 树节点选中
     *
     * @author tony001
     * @date 2024-09-10 17:09:47
     * @param {ITreeNode} data
     * @param {IData} node
     */
    onNodeSelect(data: ITreeNode, node: IData): void;
    /**
     * 树节点行为项点击
     *
     * @author tony001
     * @date 2024-09-10 17:09:10
     * @param {MouseEvent} e
     * @param {IActionItem} action
     * @param {IData} [data]
     * @return {*}  {void}
     */
    onActionClick(e: MouseEvent, action: IActionItem, data?: IData): void;
    /**
     * 打开新建项
     *
     * @author tony001
     * @date 2024-09-10 17:09:52
     * @protected
     * @param {MouseEvent} e
     * @param {IData} data
     * @return {*}  {Promise<void>}
     */
    protected createItem(e: MouseEvent, data: IData): Promise<void>;
    /**
     * 新建
     *
     * @author tony001
     * @date 2024-09-10 17:09:36
     * @protected
     * @param {IData} data
     * @return {*}  {Promise<void>}
     */
    protected create(data: IData): Promise<void>;
    /**
     * 删除
     *
     * @author tony001
     * @date 2024-09-10 17:09:45
     * @protected
     * @param {IData} data
     * @return {*}  {Promise<void>}
     */
    protected remove(data: IData): Promise<void>;
    /**
     * 节点拖拽完成
     *
     * @author tony001
     * @date 2024-09-10 17:09:44
     * @param {IData} draggingNode
     * @param {IData} dropNode
     * @param {string} dropType
     * @return {*}  {Promise<void>}
     */
    onNodeDrop(draggingNode: IData, dropNode: IData, dropType: string): Promise<void>;
    /**
     * 销毁
     *
     * @author tony001
     * @date 2024-09-10 17:09:47
     */
    destroy(): void;
}
