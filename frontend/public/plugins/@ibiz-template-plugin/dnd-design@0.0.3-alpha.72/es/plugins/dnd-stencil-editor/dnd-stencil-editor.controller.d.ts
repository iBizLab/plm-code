import { IDEEditForm, IDEFormGroupPanel } from '@ibiz/model-core';
import { IAppDEService, IButtonContainerState } from '@ibiz-template/runtime';
import { DndStencilPanelItemController } from '../../panel-items/dnd-stencil/dnd-stencil.controller';
export declare class DndStencilEditorController extends DndStencilPanelItemController {
    /**
     * 主表单
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:14
     * @protected
     * @type {IDEEditForm}
     */
    protected majorForm: IDEEditForm;
    /**
     * 主表单服务
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:22
     * @protected
     * @type {IAppDEService}
     */
    protected majorService: IAppDEService;
    /**
     * 编辑器表单
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:33
     * @protected
     * @type {IDEEditForm}
     */
    protected editorForm: IDEEditForm;
    /**
     * 编辑器表单服务
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:46
     * @protected
     * @type {IAppDEService}
     */
    protected editorService: IAppDEService;
    /**
     * 是否启用分组呈现
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:07
     * @type {boolean}
     */
    enableGroup: boolean;
    /**
     * 初始化
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:17
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected onInit(): Promise<void>;
    /**
     * 初始化基础资源
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:29
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected initBaseResource(): Promise<void>;
    /**
     * 加载数据
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:20
     * @return {*}  {Promise<void>}
     */
    load(): Promise<void>;
    /**
     * 初始化界面行为按钮
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:51
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected initButtonGroup(): Promise<void>;
    /**
     * 初始化界面行为按钮的状态
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:04
     * @param {IDEFormGroupPanel} model
     * @return {*}  {(Promise<IButtonContainerState | undefined>)}
     */
    initActionStates(model: IDEFormGroupPanel): Promise<IButtonContainerState | undefined>;
}
