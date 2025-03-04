import { IPortalMessage } from '@ibiz-template/core';
import { IDataEntity, IAppDEService, PanelItemController } from '@ibiz-template/runtime';
import { IPanelContainer, IDEForm } from '@ibiz/model-core';
import { DndDesignPanelItemState } from './dnd-design.state';
import { DndItemProvider, IDndDesignPanelItemController, IDndItemController } from '../../interface';
import { DndDesignViewController } from '../../views';
/**
 * 拖拽素材区控制器
 *
 * @author chitanda
 * @date 2023-12-14 16:12:54
 * @export
 * @class DndDesignPanelItemController
 * @extends {PanelItemController<IPanelContainer>}
 */
export declare class DndDesignPanelItemController extends PanelItemController<IPanelContainer> implements IDndDesignPanelItemController {
    protected service: IAppDEService;
    protected form: IDEForm;
    readonly providers: Record<string, DndItemProvider>;
    readonly controllers: Record<string, IDndItemController>;
    state: DndDesignPanelItemState;
    get view(): DndDesignViewController;
    protected items: IDataEntity[];
    /**
     * 定时器
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:01
     * @protected
     * @type {(number | null)}
     */
    protected timer: number | null;
    /**
     * 是否禁止处理消息
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:58
     * @protected
     * @type {boolean}
     */
    protected isDisableMessage: boolean;
    /**
     * 主表单
     *
     * @author zhanghengfeng
     * @date 2025-02-14 20:02:12
     * @protected
     * @type {IDEForm}
     */
    protected majorForm: IDEForm;
    /**
     * 主表单服务
     *
     * @author zhanghengfeng
     * @date 2025-02-14 20:02:22
     * @protected
     * @type {IAppDEService}
     */
    protected majorService: IAppDEService;
    /**
     * 创建面板状态对象
     *
     * @author zhanghengfeng
     * @date 2025-01-21 19:01:03
     * @protected
     * @return {*}  {DndDesignPanelItemState}
     */
    protected createState(): DndDesignPanelItemState;
    protected onInit(): Promise<void>;
    /**
     * 预览表单
     *
     * @author zhanghengfeng
     * @date 2025-02-14 20:02:27
     * @return {*}  {Promise<void>}
     */
    preview(): Promise<void>;
    /**
     * 处理素材添加
     *
     * @author zhanghengfeng
     * @date 2025-02-12 22:02:48
     * @param {IData} stencil
     * @param {string} [id]
     * @param {IDataEntity} [child]
     * @return {*}  {void}
     */
    handleStencilAdd(stencil: IData, id?: string, child?: IDataEntity): void;
    /**
     * 更新逻辑映射map
     *
     * @author zhanghengfeng
     * @date 2025-02-12 22:02:38
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected updateLogicMap(): Promise<void>;
    /**
     * 监听数据变化
     *
     * @author zhanghengfeng
     * @date 2025-02-12 22:02:29
     * @protected
     * @param {IPortalMessage} msg
     */
    protected onDEDataChange(msg: IPortalMessage): void;
    /**
     * 打开逻辑视图
     *
     * @author zhanghengfeng
     * @date 2025-02-12 22:02:40
     * @param {IDataEntity} item
     * @return {*}  {Promise<void>}
     */
    openLogicView(item: IDataEntity): Promise<void>;
    /**
     * 更新隐藏表单项可见性
     *
     * @author zhanghengfeng
     * @date 2024-06-05 13:06:07
     * @param {boolean} value
     */
    updateHiddenFormItemVisible(value: boolean): void;
    /**
     * 监听数据变化
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:35
     * @protected
     * @param {IPortalMessage} msg
     * @return {*}  {void}
     */
    protected onDataUpdate(msg: IPortalMessage): void;
    /**
     * 发送消息
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:47
     * @param {IDataEntity[]} items
     * @param {IPortalMessage['subtype']} [type]
     * @param {IPortalMessage} [msg]
     */
    protected sendMessage(items: IDataEntity[], type?: IPortalMessage['subtype'], msg?: IPortalMessage): void;
    /**
     * 刷新
     *
     * @author zhanghengfeng
     * @date 2024-12-30 21:12:42
     * @return {*}  {Promise<void>}
     */
    refresh(): Promise<void>;
    /**
     * 订阅消息
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:59
     */
    protected subscribeMessage(): void;
    /**
     * 取消订阅消息
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:13
     */
    protected unsubscribeMessage(): void;
    /**
     * 销毁方法
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:26
     */
    destroy(): void;
    /**
     * 初始化数据项
     *
     * @author chitanda
     * @date 2023-12-21 11:12:17
     * @protected
     * @param {IDataEntity} item
     * @return {*}  {Promise<void>}
     */
    protected initItem(item: IDataEntity): Promise<void>;
    /**
     * 加载项数据，并初始化适配器相关
     *
     * @author chitanda
     * @date 2023-12-18 16:12:27
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected load(): Promise<void>;
    /**
     * 重新计算现有数据的递归结构
     *
     * @author chitanda
     * @date 2023-12-28 15:12:31
     */
    recalculateDeppItems(): void;
    /**
     * 计算递归数据，用于渲染树界面
     *
     * @author chitanda
     * @date 2023-12-15 16:12:32
     * @protected
     * @param {IDataEntity[]} items
     * @param {IDataEntity} [parent]
     * @param {string} [key='children']
     * @return {*}  {IDataEntity[]}
     */
    protected calcDeepItems(items: IDataEntity[], parent?: IDataEntity, key?: string): IDataEntity[];
    /**
     * 拖拽放生变更
     *
     * @author chitanda
     * @date 2023-12-21 11:12:03
     * @param {IData} evt
     * @param {IDataEntity[]} items
     * @param {IDataEntity} [parent]
     */
    change(evt: IData, items: IDataEntity[], parent?: IDataEntity): void;
    /**
     * 新增一个项
     *
     * @author chitanda
     * @date 2023-12-21 11:12:53
     * @protected
     * @param {IData} evt
     * @param {IDataEntity[]} items
     * @param {IDataEntity} [parent]
     * @return {*}  {Promise<void>}
     */
    protected add(evt: IData, items: IDataEntity[], parent?: IDataEntity): Promise<void>;
    /**
     * 节点排序并更新
     *
     * @author chitanda
     * @date 2023-12-21 11:12:25
     * @protected
     * @param {IDataEntity[]} items
     * @param {number} oldIndex
     * @param {number} newIndex
     * @return {*}  {Promise<void>}
     */
    protected move(items: IDataEntity[], oldIndex: number, newIndex: number): Promise<void>;
    /**
     * 删除项
     *
     * @author chitanda
     * @date 2024-01-03 15:01:19
     * @param {IDataEntity[]} items
     * @param {IDataEntity} item
     * @return {*}  {Promise<boolean>}
     */
    remove(items: IDataEntity[], item: IDataEntity): Promise<boolean>;
    /**
     * 删除项控制器实例
     *
     * @author chitanda
     * @date 2024-01-03 16:01:04
     * @protected
     * @param {IDataEntity} item
     */
    protected removeController(item: IDataEntity): void;
    /**
     * 获取模型状态
     *
     * @author zhanghengfeng
     * @date 2024-04-23 20:04:49
     * @param {IDataEntity} entity
     * @return {*}  {number}
     */
    getModelState(entity: IDataEntity): number;
    showMaskType: string[];
    isShowMask(entity: IDataEntity): boolean;
}
