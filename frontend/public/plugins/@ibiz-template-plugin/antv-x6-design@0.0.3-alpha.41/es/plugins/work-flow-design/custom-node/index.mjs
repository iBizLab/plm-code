import '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/index.mjs';
import { LogicNode } from './logic-node.mjs';
import { MaterialNode } from './material-node.mjs';
import { Graph } from '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/graph/graph.mjs';

"use strict";
function installCustomNode() {
  Graph.registerNode("wf-node", LogicNode, true);
  Graph.registerNode("wf-material-node", MaterialNode, true);
}

export { installCustomNode };
