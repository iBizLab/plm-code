import { Graph } from '@antv/x6';
import { LogicLink } from './logic-link';

/**
 * 安装自定义连线
 *
 * @author chitanda
 * @date 2023-11-24 14:11:05
 * @export
 */
export function installCustomEdge(): void {
  Graph.registerEdge('wf-link', LogicLink, true);
}
