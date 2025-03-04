import { PanelItemController } from '@ibiz-template/runtime';
import { IPanelContainer } from '@ibiz/model-core';
import { X6PanelItemState } from './x6-panel-item.state';
import { X6Controller } from '../../controller';
import { X6DesignViewController } from '../../views';
import { X6CellDataProvider } from '../../interface';
export declare class X6PanelItemController extends PanelItemController<IPanelContainer> {
    x6: X6Controller;
    state: X6PanelItemState;
    get view(): X6DesignViewController;
    /**
     * @description 自定义补充参数
     * @type {IData}
     * @memberof X6PanelItemController
     */
    rawItemParams: IData;
    protected onInit(): Promise<void>;
    /**
     * 监听布局面板激活
     *
     * @author zhanghengfeng
     * @date 2025-01-10 19:01:16
     * @return {*}  {void}
     */
    onPanelActivated(): void;
    /**
     *监听选中数据变化
     *
     * @author zhanghengfeng
     * @date 2024-01-10 17:01:54
     * @protected
     * @param {(X6CellDataProvider | undefined | null)} data
     */
    protected onSelectDataChange(data: X6CellDataProvider | undefined | null): void;
    /**
     * 创建面板状态对象
     *
     * @author chitanda
     * @date 2023-01-04 10:01:00
     * @protected
     * @return {*}  {X6PanelItemState}
     */
    protected createState(): X6PanelItemState;
    /**
     * 初始化 x6
     *
     * @author chitanda
     * @date 2023-11-11 13:11:39
     * @param {HTMLDivElement} container
     */
    initX6(container: HTMLDivElement, minimap: HTMLElement): void;
    /**
     * 初始化画布元素选中
     *
     * @author zhanghengfeng
     * @date 2024-01-25 15:01:38
     * @protected
     */
    protected initCellSelection(): void;
    /**
     * x6 加载数据
     *
     * @author chitanda
     * @date 2023-11-20 11:11:09
     * @return {*}  {Promise<void>}
     */
    load(): Promise<void>;
    /**
     * @description 处理直接内容项参数
     * @protected
     * @memberof X6PanelItemController
     */
    protected handleRawItemParams(): void;
    destroy(): void;
}
