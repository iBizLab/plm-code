import { Graph } from '@antv/x6';
import { LogicNode } from './logic-node';
import { MaterialNode } from './material-node';

/**
 * 安装自定义节点
 *
 * @author chitanda
 * @date 2023-11-24 14:11:35
 * @export
 */
export function installCustomNode(): void {
  Graph.registerNode('wf-node', LogicNode, true);
  Graph.registerNode('wf-material-node', MaterialNode, true);
}
