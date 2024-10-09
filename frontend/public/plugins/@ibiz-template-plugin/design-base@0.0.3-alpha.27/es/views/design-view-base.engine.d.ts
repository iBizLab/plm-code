import { IAppDEService, ViewController, ViewEngineBase } from '@ibiz-template/runtime';
import { IAppView, IDEEditForm } from '@ibiz/model-core';
import { NavPosController } from '@ibiz-template/vue3-util';
import { DesignViewControllerBase } from './design-view-base.controller';
import { IDesignViewEvent, IDesignViewState } from '../interface';
export declare class DesignViewEngineBase extends ViewEngineBase {
    /**
     * 视图控制器
     *
     * @author tony001
     * @date 2024-09-10 10:09:14
     * @protected
     * @type {DesignViewControllerBase<
     *     IAppView,
     *     IDesignViewState,
     *     IDesignViewEvent
     *   >}
     */
    protected view: DesignViewControllerBase<IAppView, IDesignViewState, IDesignViewEvent>;
    /**
     * 主数据表单(主要用于主数据加载相关接口模型)
     *
     * @author tony001
     * @date 2024-09-10 10:09:59
     * @protected
     * @type {IDEEditForm}
     */
    protected form: IDEEditForm;
    /**
     * 主数据表单服务
     *
     * @author tony001
     * @date 2024-09-10 10:09:30
     * @protected
     * @type {IAppDEService}
     */
    protected service: IAppDEService;
    /**
     * 属性区导航占位控制器
     *
     * @author tony001
     * @date 2024-09-10 10:09:08
     * @protected
     * @type {NavPosController}
     */
    protected navPos: NavPosController;
    /**
     * 当前激活属性视图
     *
     * @author tony001
     * @date 2024-09-10 10:09:48
     * @protected
     * @type {ViewController}
     */
    protected activePropertyView: ViewController;
    /**
     * 视图初始化
     *
     * @author tony001
     * @date 2024-09-10 10:09:10
     * @return {*}  {Promise<void>}
     */
    onCreated(): Promise<void>;
    /**
     * 视图挂载
     *
     * @author tony001
     * @date 2024-09-10 11:09:22
     * @return {*}  {Promise<void>}
     */
    onMounted(): Promise<void>;
    /**
     * 初始化视图hook
     *
     * @author tony001
     * @date 2024-09-10 11:09:37
     * @protected
     */
    protected initViewShouldDismissHook(): void;
    /**
     * 初始化属性视图
     *
     * @author tony001
     * @date 2024-09-10 11:09:01
     * @protected
     */
    protected initPropertyView(): void;
    /**
     * 选中数据
     *
     * @author tony001
     * @date 2024-09-10 11:09:22
     * @protected
     * @param {(IData | undefined | null)} data
     */
    protected onSelect(data: IData | undefined | null): void;
    /**
     * 激活根节点
     *
     * @author tony001
     * @date 2024-09-02 17:09:06
     * @protected
     */
    protected activeRoot(): void;
    /**
     * 加载数据
     *
     * @author tony001
     * @date 2024-09-10 11:09:50
     * @protected
     * @return {*}  {(Promise<IData | null>)}
     */
    protected load(): Promise<IData | null>;
    /**
     * 保存数据
     *
     * @author tony001
     * @date 2024-09-10 11:09:06
     * @protected
     * @return {*}  {(Promise<IData | null>)}
     */
    protected save(): Promise<IData | null>;
    /**
     * 视图能力调用
     *
     * @author tony001
     * @date 2024-09-10 11:09:29
     * @param {string} key
     * @param {IData} [args]
     * @return {*}  {(Promise<IData | null | undefined>)}
     */
    call(key: string, args?: IData): Promise<IData | null | undefined>;
    /**
     * 激活数据（主要控制右侧属性视图的显示）
     *
     * @author tony001
     * @date 2024-09-10 11:09:57
     * @protected
     * @param {IData} data
     * @return {*}  {Promise<void>}
     */
    protected onActive(data: IData): Promise<void>;
}
