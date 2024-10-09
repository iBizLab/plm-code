import { Graph, Node } from '@antv/x6';
import { Dnd } from '@antv/x6-plugin-dnd';
import { CodeListItem, IDataEntity } from '@ibiz-template/runtime';
import { X6CellServiceProvider } from './x6-cell.service.provider';
import { X6NodeDataProvider } from './x6-node-data.provider';

/**
 * 节点适配器
 *
 * @author chitanda
 * @date 2023-11-09 21:11:45
 * @export
 * @interface X6NodeServiceProvider
 */
export interface X6NodeServiceProvider extends X6CellServiceProvider<Node> {
  createDataProvider(data: IDataEntity): X6NodeDataProvider<IDataEntity>;

  /**
   * 创建节点实例
   *
   * @author chitanda
   * @date 2023-11-21 17:11:55
   * @param {X6NodeDataProvider<IDataEntity>} data
   * @return {*}  {Node.Metadata}
   */
  createCell(data: X6NodeDataProvider<IDataEntity>): Node.Metadata;

  /**
   * 创建拖拽节点实例
   *
   * @author zhanghengfeng
   * @date 2024-02-19 16:02:49
   * @param {CodeListItem} codeItem
   * @return {*}  {Node.Metadata}
   */
  createDragCell(codeItem: CodeListItem): Node.Metadata;

  /**
   * 创建节点素材实例
   *
   * @author zhanghengfeng
   * @date 2024-02-19 16:02:58
   * @param {CodeListItem} codeItem
   * @return {*}  {Node.Metadata}
   */
  createMaterialCell(codeItem: CodeListItem): Node.Metadata;

  /**
   * 创建节点素材实例
   *
   * @author zhanghengfeng
   * @date 2024-02-19 16:02:58
   * @param {CodeListItem} codeItem
   * @return {*}  {Node.Metadata}
   */
  createMaterialAddCell(codeItem: CodeListItem): Node.Metadata;

  /**
   * 过滤节点
   *
   * @description 可以过滤节点是否显示，或者搜索过滤高亮等。具体以 mode 模式区分
   * @author chitanda
   * @date 2023-12-04 10:12:16
   * @param {string} mode 过滤模式
   * @param {IDataEntity} data 节点数据
   * @return {*}  {boolean}
   */
  filter?(mode: string, data: IDataEntity): boolean;

  /**
   * 验证节点是否可以添加
   *
   * @author zhanghengfeng
   * @date 2024-01-11 13:01:17
   * @param {Node} node
   * @param {Dnd.ValidateNodeOptions} options
   * @return {*}  {boolean}
   */
  validateNode(node: Node, options: Dnd.ValidateNodeOptions): boolean;

  /**
   * 创建相关连线
   *
   * @author zhanghengfeng
   * @date 2024-01-19 17:01:12
   * @param {Node} node
   * @param {Graph} g
   * @return {*}  {Promise<void>}
   */
  createEdges(node: Node, g: Graph): Promise<void>;
}
