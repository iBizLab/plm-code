import '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/index.mjs';
import { LogicNode } from './logic-node.mjs';
import { MaterialNode } from './material-node.mjs';
import { MaterialAddNode } from './material-add-node.mjs';
import { Graph } from '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/graph/graph.mjs';

"use strict";
function installCustomNode() {
  Graph.registerNode("logic-node", LogicNode, true);
  Graph.registerNode("material-node", MaterialNode, true);
  Graph.registerNode("material-add-node", MaterialAddNode, true);
}

export { installCustomNode };
