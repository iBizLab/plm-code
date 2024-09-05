import { IButtonContainerState, PanelItemController } from '@ibiz-template/runtime';
import { IAppCodeList, ICodeItem, IDEFormGroupPanel, IPanelField, IUIActionGroupDetail } from '@ibiz/model-core';
import { DndDesignViewController } from '../../views';
import { DndStencilPanelItemState } from './dnd-stencil.state';
/**
 * 拖拽素材区控制器
 *
 * @author chitanda
 * @date 2023-12-14 16:12:54
 * @export
 * @class DndStencilPanelItemController
 * @extends {PanelItemController<IPanelField>}
 */
export declare class DndStencilPanelItemController extends PanelItemController<IPanelField> {
    codeList: IAppCodeList;
    /**
     * 代码表项
     *
     * @author zhanghengfeng
     * @date 2024-01-11 18:01:27
     * @protected
     * @type {ICodeItem[]}
     */
    protected codeItems: ICodeItem[];
    /**
     * 是否启用分组呈现
     *
     * @author chitanda
     * @date 2023-12-23 15:12:05
     * @type {boolean}
     */
    enableGroup: boolean;
    state: DndStencilPanelItemState;
    protected createState(): DndStencilPanelItemState;
    get view(): DndDesignViewController;
    /**
     * 按钮分组映射
     *
     * @author zhanghengfeng
     * @date 2024-01-12 18:01:05
     * @type {Map<
     *     string,
     *     { model: IDEFormGroupPanel; state: IButtonContainerState }
     *   >}
     */
    buttonGroupMap: Map<string, {
        model: IDEFormGroupPanel;
        state: IButtonContainerState;
    }>;
    protected onInit(): Promise<void>;
    load(): Promise<void>;
    /**
     * 过滤项
     *
     * @author zhanghengfeng
     * @date 2024-01-11 19:01:19
     * @protected
     * @return {*}  {void}
     */
    protected filter(): void;
    /**
     * 监听行为组点击
     *
     * @author zhanghengfeng
     * @date 2024-01-12 18:01:48
     * @param {IUIActionGroupDetail} detail
     * @param {MouseEvent} event
     * @return {*}  {Promise<void>}
     */
    onActionClick(detail: IUIActionGroupDetail, event: MouseEvent): Promise<void>;
}
