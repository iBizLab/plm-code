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
  Graph.registerEdge('logic-link', LogicLink, true);
  Graph.registerEdgeTool(
    'logic-link-shift-button',
    {
      inherit: 'button',
    },
    true,
  );
  Graph.registerEdgeTool(
    'logic-link-loop-icon',
    {
      inherit: 'button',
    },
    true,
  );
}
