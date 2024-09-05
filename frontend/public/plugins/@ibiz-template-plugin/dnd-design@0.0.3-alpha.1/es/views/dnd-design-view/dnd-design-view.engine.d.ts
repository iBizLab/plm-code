import { IAppDEService, ViewEngineBase } from '@ibiz-template/runtime';
import { IDEEditForm } from '@ibiz/model-core';
import { NavPosController } from '@ibiz-template/vue3-util';
import { DndDesignViewController } from './dnd-design-view.controller';
/**
 * dnd 设计视图引擎
 *
 * @author chitanda
 * @date 2023-11-11 17:11:39
 * @export
 * @class DndDesignViewEngine
 * @extends {ViewEngineBase}
 */
export declare class DndDesignViewEngine extends ViewEngineBase {
    protected view: DndDesignViewController;
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
     * @type {IAppDEService}
     */
    protected service: IAppDEService;
    onCreated(): Promise<void>;
    protected onSelect(data: IData | null | undefined): void;
    onMounted(): Promise<void>;
    onDestroyed(): Promise<void>;
    /**
     * 激活根节点
     *
     * @author chitanda
     * @date 2023-11-22 21:11:04
     * @protected
     */
    protected activeRoot(): void;
    protected load(): Promise<IData | null>;
    protected save(): Promise<IData | null>;
    call(key: string, args?: IData): Promise<IData | null | undefined>;
    /**
     * 设置激活数据
     *
     * @description 主要控制右侧属性视图的显示
     * @author chitanda
     * @date 2023-11-22 12:11:36
     * @protected
     * @param {IData} data
     */
    protected onActive(data: IData): void;
}
