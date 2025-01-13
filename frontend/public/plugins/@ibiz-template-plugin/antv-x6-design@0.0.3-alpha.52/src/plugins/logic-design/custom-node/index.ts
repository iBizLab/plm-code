import { Graph } from '@antv/x6';
import { LogicNode } from './logic-node';
import { MaterialNode } from './material-node';
import { MaterialAddNode } from './material-add-node';

/**
 * 安装自定义节点
 *
 * @author chitanda
 * @date 2023-11-24 14:11:35
 * @export
 */
export function installCustomNode(): void {
  Graph.registerNode('logic-node', LogicNode, true);
  Graph.registerNode('material-node', MaterialNode, true);
  Graph.registerNode('material-add-node', MaterialAddNode, true);
}
