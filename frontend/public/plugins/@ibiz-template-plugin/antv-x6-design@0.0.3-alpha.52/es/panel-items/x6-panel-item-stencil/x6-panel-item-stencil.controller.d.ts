import { CodeListItem, PanelItemController } from '@ibiz-template/runtime';
import { IPanelField } from '@ibiz/model-core';
import { Stencil } from '@antv/x6-plugin-stencil';
import { X6PanelItemStencilState } from './x6-panel-item-stencil.state';
import { X6PanelItemController } from '../x6-panel-item/x6-panel-item.controller';
import { X6Controller } from '../../controller';
import { X6NodeServiceProvider } from '../../interface';
export declare class X6PanelItemStencilController extends PanelItemController<IPanelField> {
    protected get x6Controller(): X6PanelItemController;
    /**
     * 挂载容器
     *
     * @author chitanda
     * @date 2023-11-11 15:11:06
     * @protected
     * @type {HTMLDivElement}
     */
    protected container?: HTMLDivElement;
    /**
     * 节点适配器
     *
     * @author chitanda
     * @date 2023-11-16 18:11:29
     * @type {X6NodeServiceProvider}
     */
    get provider(): X6NodeServiceProvider;
    s?: Stencil;
    get x6(): X6Controller;
    /**
     * @description 行为参数
     * @type {IData}
     * @memberof X6PanelItemStencilController
     */
    actionParams: IData;
    /**
     * @description 是否显示分组头
     * @type {boolean}
     * @memberof X6PanelItemStencilController
     */
    showGroupHeader: boolean;
    /**
     * @description 节点数组
     * @type {IData[]}
     * @memberof X6PanelItemStencilController
     */
    nodes: IData[];
    protected createState(): X6PanelItemStencilState;
    /**
     *  加载代码表
     *
     * @author fangZhiHao
     * @date 2024-07-24 09:07:24
     * @param {string} appCodeListId
     * @return {*}
     */
    loadCodeList(appCodeListId: string): Promise<CodeListItem[]>;
    /**
     * 填充界面行为
     *
     * @author fangZhiHao
     * @date 2024-07-24 19:07:45
     * @param {CodeListItem[]} codeListItems
     */
    fillAction(codeListItems: CodeListItem[]): void;
    /**
     * 挂载 stencil 节点
     *
     * @author fangZhiHao
     * @date 2024-07-24 09:07:35
     * @param {CodeListItem[]} codeListItems
     */
    loadNodes(codeListItems: CodeListItem[]): void;
    /**
     *  设置事件
     *
     * @author fangZhiHao
     * @date 2024-07-24 18:07:17
     * @param {IData} action
     * @param {CodeListItem[]} codeListItems
     */
    initEevnt(): void;
    /**
     *  注册节点事件
     *
     * @author fangZhiHao
     * @date 2024-07-24 19:07:15
     * @param {string} className
     * @param {IData} action
     * @param {string} key
     */
    registerNodeEvent(container: Element, cell: IData, className: string): Promise<void>;
    /**
     * 重新加载代码表
     *
     * @author fangZhiHao
     * @date 2024-07-24 20:07:19
     * @param {IData} action
     */
    refresh(): Promise<void>;
    /**
     * @description 初始化编辑器参数
     * @param {IData} editorParams
     * @memberof X6PanelItemStencilController
     */
    initEditorParams(editorParams: IData): void;
    initStencil(container: HTMLDivElement, count?: number): Promise<void>;
}
