import { IAppDEService, IAppService, IButtonContainerState, IDataEntity } from '@ibiz-template/runtime';
import { IDEForm, IDEFormGroupPanel } from '@ibiz/model-core';
import { IPortalMessage } from '@ibiz-template/core';
import { DndStencilPanelItemController } from '../../panel-items/dnd-stencil/dnd-stencil.controller';
import { DndDesignViewController } from '../../views';
export declare class DndStencilFieldController extends DndStencilPanelItemController {
    protected app: IAppService;
    protected form: IDEForm;
    protected service: IAppDEService;
    protected fieldForm: IDEForm;
    protected fieldService: IAppDEService;
    protected fieldItems: IDataEntity[];
    protected items: IDataEntity[];
    enableGroup: boolean;
    protected mdCtrlFieldType: string[];
    get view(): DndDesignViewController;
    protected onInit(): Promise<void>;
    /**
     * 初始化界面行为按钮
     *
     * @author zhanghengfeng
     * @date 2024-01-12 18:01:04
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected initButtonGroup(): Promise<void>;
    /**
     * 初始化界面行为按钮的状态
     *
     * @author zhanghengfeng
     * @date 2024-01-12 18:01:53
     * @param {IDEFormGroupPanel} model
     * @return {*}  {(Promise<IButtonContainerState | undefined>)}
     */
    initActionStates(model: IDEFormGroupPanel): Promise<IButtonContainerState | undefined>;
    /**
     * 监听数据更新
     *
     * @author zhanghengfeng
     * @date 2024-02-04 17:02:27
     * @protected
     * @param {IPortalMessage} msg
     */
    protected onDataUpdate(msg: IPortalMessage): void;
    /**
     * 监听数据新建
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:06
     * @protected
     * @param {IPortalMessage} msg
     */
    protected onDataCreate(msg: IPortalMessage): void;
    /**
     * 监听数据删除
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:17
     * @protected
     * @param {IPortalMessage} msg
     */
    protected onDataRemove(msg: IPortalMessage): void;
    /**
     * 订阅消息
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:54
     * @protected
     */
    protected subscribeMessage(): void;
    /**
     * 取消订阅消息
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:03
     * @protected
     */
    protected unsubscribeMessage(): void;
    /**
     * 销毁方法
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:29
     */
    destroy(): void;
    /**
     * 数据加载
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:35
     * @return {*}  {Promise<void>}
     */
    load(): Promise<void>;
    /**
     * 加载数据集
     *
     * @author zhanghengfeng
     * @date 2024-02-04 16:02:27
     * @return {*}  {Promise<void>}
     */
    loadItems(): Promise<void>;
    /**
     * 过滤属性项
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:46
     * @protected
     * @return {*}  {IDataEntity[]}
     */
    protected filterFieldItems(): IDataEntity[];
    /**
     * 转换属性项
     *
     * @author zhanghengfeng
     * @date 2024-02-04 17:02:39
     * @protected
     */
    protected debounceTransformFieldItems(): void;
    /**
     * 转换属性项
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:59
     * @protected
     * @return {*}  {void}
     */
    protected transformFieldItems(): void;
}
