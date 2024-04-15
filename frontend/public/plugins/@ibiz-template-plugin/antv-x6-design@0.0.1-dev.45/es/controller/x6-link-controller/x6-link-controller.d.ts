import { Dom, Edge } from '@antv/x6';
import { X6CellController } from '../x6-cell-controller/x6-cell-controller';
import { X6LinkServiceProvider } from '../../interface';
/**
 * 连线控制器
 *
 * @author chitanda
 * @date 2023-11-16 18:11:07
 * @export
 * @class X6LinkController
 */
export declare class X6LinkController extends X6CellController {
    /**
     * 连线适配器
     *
     * @author chitanda
     * @date 2023-11-16 18:11:00
     * @type {X6LinkServiceProvider}
     */
    provider: X6LinkServiceProvider;
    protected onInit(): void;
    protected initEvents(): void;
    /**
     * 更新连线
     *
     * @author zhanghengfeng
     * @date 2024-01-31 18:01:45
     * @protected
     * @param {Edge} edge
     */
    protected debounceUpdateEdge(edge: Edge): void;
    /**
     * 更新连线label标签
     *
     * @author zhanghengfeng
     * @date 2024-01-30 18:01:19
     * @protected
     * @param {Edge} edge
     */
    protected updateLabel(edge: Edge): void;
    /**
     * 触发右键菜单
     *
     * @author chitanda
     * @date 2023-11-27 11:11:44
     * @protected
     * @param {Dom.ContextMenuEvent} e
     * @param {Edge} edge
     */
    protected contextMenu(e: Dom.ContextMenuEvent, edge: Edge): void;
    load(): Promise<void>;
    /**
     * 新建连线数据
     *
     * @author chitanda
     * @date 2023-11-23 17:11:07
     * @param {Edge} edge
     * @return {*}  {Promise<void>}
     */
    createEdge(edge: Edge): Promise<void>;
    /**
     * 更新连线数据
     *
     * @author chitanda
     * @date 2023-11-24 17:11:39
     * @param {Edge} edge
     * @return {*}  {Promise<void>}
     */
    updateEdge(edge: Edge): Promise<void>;
    /**
     * 删除连线数据
     *
     * @author chitanda
     * @date 2023-11-23 20:11:34
     * @param {Edge} edge
     * @return {*}  {Promise<void>}
     */
    removeEdge(edge: Edge): Promise<boolean>;
}
