import { IAppDEService, PanelItemController } from '@ibiz-template/runtime';
import { IAppDataEntity, IAppView, IDEEditForm, IPanelContainer } from '@ibiz/model-core';
import { IPortalMessage } from '@ibiz-template/core';
import { DesignContentState } from './design_content.state';
import { DesignViewControllerBase } from '../../views';
import { IDesignViewEvent, IDesignViewState } from '../../interface';
export declare class DesignContentController extends PanelItemController<IPanelContainer> {
    /**
     * 当前状态
     *
     * @author tony001
     * @date 2024-09-10 14:09:09
     * @type {DesignContentState}
     */
    state: DesignContentState;
    /**
     * 主服务
     *
     * @author tony001
     * @date 2024-09-10 14:09:22
     * @protected
     * @type {IAppDEService}
     */
    protected majorService: IAppDEService;
    /**
     * 从数据服务
     *
     * @author tony001
     * @date 2024-09-10 14:09:31
     * @protected
     * @type {IAppDEService}
     */
    protected itemService: IAppDEService;
    /**
     * 主实体
     *
     * @author tony001
     * @date 2024-09-10 14:09:46
     * @protected
     * @type {IAppDataEntity}
     */
    protected majorEntity: IAppDataEntity;
    /**
     * 从实体
     *
     * @author tony001
     * @date 2024-09-10 14:09:05
     * @protected
     * @type {IAppDataEntity}
     */
    protected itemEntity: IAppDataEntity;
    /**
     * 主表单
     *
     * @author tony001
     * @date 2024-09-10 14:09:17
     * @readonly
     * @type {IDEEditForm}
     */
    get majorForm(): IDEEditForm;
    /**
     * 项表单
     *
     * @author tony001
     * @date 2024-09-10 14:09:26
     * @readonly
     * @type {IDEEditForm}
     */
    get itemForm(): IDEEditForm;
    /**
     * 视图对象
     *
     * @author tony001
     * @date 2024-09-10 15:09:46
     * @readonly
     * @type {DesignViewControllerBase<
     *     IAppView,
     *     IDesignViewState,
     *     IDesignViewEvent
     *   >}
     */
    get view(): DesignViewControllerBase<IAppView, IDesignViewState, IDesignViewEvent>;
    /**
     * 创建面板状态对象
     *
     * @author tony001
     * @date 2024-09-10 14:09:24
     * @protected
     * @return {*}  {DesignContentState}
     */
    protected createState(): DesignContentState;
    /**
     * 初始化
     *
     * @author tony001
     * @date 2024-08-19 16:08:12
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected onInit(): Promise<void>;
    /**
     * 初始化基础资源
     *
     * @author tony001
     * @date 2024-09-10 15:09:30
     * @protected
     */
    protected initBaseResource(): Promise<void>;
    /**
     * 订阅数据变化
     *
     * @author tony001
     * @date 2024-09-10 15:09:10
     * @protected
     */
    protected subscribeDataChange(): Promise<void>;
    /**
     * 取消订阅数据变化
     *
     * @author tony001
     * @date 2024-09-10 15:09:06
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected unSubscribeDataChange(): Promise<void>;
    /**
     * 加载数据
     *
     * @author tony001
     * @date 2024-09-04 09:09:05
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected load(): Promise<void>;
    /**
     * 加载之后
     *
     * @author tony001
     * @date 2024-09-10 15:09:35
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected afterLoad(args: IData): Promise<void>;
    /**
     * 刷新
     *
     * @author tony001
     * @date 2024-09-10 15:09:27
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected refresh(): Promise<void>;
    /**
     * 监听数据变化
     *
     * @author tony001
     * @date 2024-09-10 15:09:25
     * @protected
     * @param {IPortalMessage} msg
     */
    protected onDEDataChange(msg: IPortalMessage): void;
    /**
     * 预览项选中
     *
     * @param {string} id
     * @memberof DesignContentController
     */
    onSelect(id: string): void;
    /**
     * 销毁
     *
     * @author tony001
     * @date 2024-09-02 18:09:42
     */
    destroy(): void;
}
