import { Node, Dom } from '@antv/x6';
import { X6CellController } from '../x6-cell-controller/x6-cell-controller';
import { X6NodeServiceProvider } from '../../interface';
/**
 * 节点控制器
 *
 * @author chitanda
 * @date 2023-11-16 18:11:19
 * @export
 * @class X6NodeController
 */
export declare class X6NodeController extends X6CellController {
    /**
     * 节点适配器
     *
     * @author chitanda
     * @date 2023-11-16 18:11:29
     * @type {X6NodeServiceProvider}
     */
    provider: X6NodeServiceProvider;
    protected onInit(): void;
    protected initEvents(): void;
    /**
     * 触发右键菜单
     *
     * @author chitanda
     * @date 2023-11-27 11:11:44
     * @protected
     * @param {Dom.ContextMenuEvent} e
     * @param {Node} node
     */
    protected contextMenu(e: Dom.ContextMenuEvent, node: Node): void;
    load(): Promise<void>;
    /**
     * 新建节点
     *
     * @author chitanda
     * @date 2023-11-23 16:11:16
     * @param {Node} node
     * @return {*}  {Promise<void>}
     */
    createNode(node: Node): Promise<void>;
    /**
     * 拷贝节点
     *
     * @author chitanda
     * @date 2023-11-29 14:11:20
     * @param {Node} node
     * @return {*}  {Promise<void>}
     */
    copyNode(node: Node): Promise<void>;
    /**
     * 更新节点数据
     *
     * @author chitanda
     * @date 2023-11-24 16:11:35
     * @param {Node} node
     * @return {*}  {Promise<void>}
     */
    updateNode(node: Node): Promise<void>;
    /**
     * 删除节点数据
     *
     * @author chitanda
     * @date 2023-11-23 20:11:58
     * @param {Node} node
     * @return {*}  {Promise<void>}
     */
    removeNode(node: Node): Promise<boolean>;
}
