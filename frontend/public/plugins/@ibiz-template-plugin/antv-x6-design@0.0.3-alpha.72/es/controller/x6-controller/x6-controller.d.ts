import { Graph } from '@antv/x6';
import { ControllerEvent, EventBase, IPanelController } from '@ibiz-template/runtime';
import { Namespace } from '@ibiz-template/core';
import { X6Options } from '../../interface';
import { X6NodeController } from '../x6-node-controller/x6-node-controller';
import { X6LinkController } from '../x6-link-controller/x6-link-controller';
import { X6ControllerEvent } from './x6-controller.event';
/**
 * 负责对x6的图形进行操作
 *
 * @author chitanda
 * @date 2023-11-09 17:11:33
 * @export
 * @class X6Controller
 */
export declare class X6Controller {
    protected panel: IPanelController;
    protected dom: HTMLElement;
    protected minimap: HTMLElement;
    protected opt: X6Options;
    /**
     * 当前x6图形实例
     *
     * @author chitanda
     * @date 2023-11-09 18:11:46
     * @type {Graph}
     */
    readonly g: Graph;
    /**
     * 拖拽工具
     *
     * @author chitanda
     * @date 2023-11-09 21:11:50
     * @type {Dnd}
     */
    /**
     * 样式命名空间
     *
     * @author chitanda
     * @date 2023-11-09 17:11:12
     * @protected
     */
    protected ns: Namespace;
    /**
     * 节点控制器
     *
     * @author chitanda
     * @date 2023-11-16 18:11:29
     * @type {X6NodeController}
     */
    readonly node: X6NodeController;
    /**
     * 连线适控制器
     *
     * @author chitanda
     * @date 2023-11-16 18:11:00
     * @type {X6LinkController}
     */
    readonly link: X6LinkController;
    /**
     * @description x6事件
     * @type {ControllerEvent<X6ControllerEvent>}
     * @memberof X6Controller
     */
    evt: ControllerEvent<X6ControllerEvent>;
    /**
     * 滚动条位置
     *
     * @author zhanghengfeng
     * @date 2025-01-10 19:01:22
     * @type {{ left: number; top: number }}
     */
    scrollbarPosition: {
        left: number;
        top: number;
    };
    /**
     * 设置滚动条位置
     *
     * @author zhanghengfeng
     * @date 2025-01-10 19:01:42
     * @param {{ left: number; top: number }} position
     */
    setScrollbarPosition(position: {
        left: number;
        top: number;
    }): void;
    protected getEventArgs(): Omit<EventBase, 'eventName'>;
    /**
     * x6图形配置
     *
     * @author chitanda
     * @date 2023-11-09 18:11:29
     * @protected
     * @type {Graph.Options}
     */
    protected graphOptions: Graph.Options;
    /**
     * Creates an instance of X6Controller.
     * @author chitanda
     * @date 2023-11-20 16:11:50
     * @param {IPanelController} panel
     * @param {HTMLElement} dom
     * @param {X6Options} [opt={}]
     */
    constructor(panel: IPanelController, dom: HTMLElement, minimap: HTMLElement, opt?: X6Options);
    protected init(): void;
    protected initEvents(): void;
    load(): Promise<void>;
    refresh(): Promise<void>;
    /**
     * 销毁
     *
     * @author chitanda
     * @date 2023-11-09 17:11:16
     */
    destroy(): void;
}
