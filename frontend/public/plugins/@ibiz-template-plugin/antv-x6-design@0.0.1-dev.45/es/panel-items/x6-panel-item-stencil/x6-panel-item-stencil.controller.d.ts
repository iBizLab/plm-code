import { PanelItemController } from '@ibiz-template/runtime';
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
    protected createState(): X6PanelItemStencilState;
    initStencil(container: HTMLDivElement, count?: number): Promise<void>;
}
