import '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/index.mjs';
import { LogicLink } from './logic-link.mjs';
import { Graph } from '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/graph/graph.mjs';

"use strict";
function installCustomEdge() {
  Graph.registerEdge("wf-link", LogicLink, true);
}

export { installCustomEdge };
