import { EditFormService, ViewEngineBase } from '@ibiz-template/runtime';
import { IDEEditForm } from '@ibiz/model-core';
import { NavPosController } from '@ibiz-template/vue3-util';
import { X6DesignViewController } from './x6-design-view.controller';
import { X6PanelItemController } from '../../panel-items/x6-panel-item/x6-panel-item.controller';
import { X6CellDataProvider } from '../../interface';
/**
 * x6 设计视图引擎
 *
 * @author chitanda
 * @date 2023-11-11 17:11:39
 * @export
 * @class X6DesignViewEngine
 * @extends {ViewEngineBase}
 */
export declare class X6DesignViewEngine extends ViewEngineBase {
    protected view: X6DesignViewController;
    /**
     * 主数据表单(主要用于主数据加载相关接口模型)
     *
     * @author chitanda
     * @date 2023-11-16 17:11:08
     * @protected
     * @type {IDEEditForm}
     */
    protected form: IDEEditForm;
    /**
     * X6 设计主内容区组件控制器
     *
     * @author chitanda
     * @date 2023-11-20 11:11:07
     * @protected
     * @type {X6PanelItemController}
     */
    protected x6: X6PanelItemController;
    /**
     * 属性区导航占位控制器
     *
     * @author chitanda
     * @date 2023-11-22 12:11:07
     * @protected
     * @type {NavPosController}
     */
    protected navPos: NavPosController;
    /**
     * 主数据表单服务
     *
     * @author chitanda
     * @date 2023-11-16 17:11:13
     * @protected
     * @type {EditFormService}
     */
    protected service: EditFormService;
    /**
     * 初始化tab导航
     *
     * @author zhanghengfeng
     * @date 2025-02-11 18:02:32
     * @protected
     * @return {*}  {void}
     */
    protected initNavTab(): void;
    onCreated(): Promise<void>;
    protected onSelect(data: X6CellDataProvider | undefined | null): void;
    onMounted(): Promise<void>;
    /**
     * 激活根节点
     *
     * @author zhanghengfeng
     * @date 2025-01-09 19:01:57
     * @protected
     * @param {boolean} [forceRefresh=false]
     */
    protected activeRoot(forceRefresh?: boolean): void;
    protected load(): Promise<IData | null>;
    protected save(): Promise<IData | null>;
    call(key: string, args?: IData): Promise<IData | null | undefined>;
    /**
     * 刷新视图
     *
     * @author zhanghengfeng
     * @date 2025-01-09 19:01:18
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected refreshView(): Promise<void>;
    /**
     * 设置激活数据
     *
     * @description 主要控制右侧属性视图的显示
     * @author chitanda
     * @date 2023-11-22 12:11:36
     * @protected
     * @param {X6CellDataProvider} data
     */
    protected onActive(data: X6CellDataProvider): void;
}
