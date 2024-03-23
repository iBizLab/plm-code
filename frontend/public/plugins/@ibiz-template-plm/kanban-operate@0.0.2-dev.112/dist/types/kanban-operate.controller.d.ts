import { PanelController, PanelItemController, PanelNotifyState, UIActionButtonState, ViewLayoutPanelController } from '@ibiz-template/runtime';
import { IPanelButton } from '@ibiz/model-core';
import { KanbanOperateState } from './kanban-operate.state';
/**
 * 面板按钮控制器
 *
 * @export
 * @class KanbanOperateController
 * @extends {PanelItemController<IPanelButton>}
 */
export declare class KanbanOperateController extends PanelItemController<IPanelButton> {
    state: KanbanOperateState;
    protected createState(): KanbanOperateState;
    /**
     * 面板控制器
     *
     * @type {ViewLayoutPanelController}
     * @memberof KanbanOperateController
     */
    panel: ViewLayoutPanelController;
    /**
     * 行为模型
     */
    actionModel: IData;
    /**
     * 父容器数据对象数据
     * @author lxm
     * @date 2023-07-15 01:33:58
     * @readonly
     * @type {IData}
     */
    get data(): IData;
    /**
     * Creates an instance of KanbanOperateController.
     * @param {IPanelButton} model
     * @param {PanelController} panel
     * @param {PanelItemController} [parent]
     * @memberof KanbanOperateController
     */
    constructor(model: IPanelButton, panel: PanelController, parent?: PanelItemController);
    /**
     * 初始化
     *
     * @return {*}  {Promise<void>}
     * @memberof KanbanOperateController
     */
    onInit(): Promise<void>;
    /**
     * 创建界面行为状态对象
     *
     * @protected
     * @return {*}  {KanbanOperateState}
     * @memberof KanbanOperateController
     */
    protected createUIActionState(): UIActionButtonState;
    /**
     * 面板数据变更通知(由面板控制器调用)
     *
     * @param {string[]} names
     * @memberof KanbanOperateController
     */
    dataChangeNotify(names: string[]): Promise<void>;
    /**
     * 面板状态变更通知
     *
     * @param {PanelNotifyState} _state
     * @memberof KanbanOperateController
     */
    panelStateNotify(_state: PanelNotifyState): Promise<void>;
    /**
     * 更新按钮权限状态
     *
     * @memberof KanbanOperateController
     */
    updateButtonState(): Promise<void>;
    /**
     * 行为点击
     *
     * @param {MouseEvent} event
     * @return {*}  {Promise<void>}
     * @memberof KanbanOperateController
     */
    onActionClick(event: MouseEvent): Promise<void>;
    calcItemVisible(data: IData): void;
    calcItemDisabled(data: IData): void;
}
