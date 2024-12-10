import { CellDataProviderImpl } from './cell-data.mjs';

"use strict";
class NodeDataProviderImpl extends CellDataProviderImpl {
  set type(type) {
    this.data.logicnodetype = type;
  }
  get type() {
    return this.data.logicnodetype;
  }
  get x() {
    return this.data.leftpos;
  }
  get y() {
    return this.data.toppos;
  }
}

export { NodeDataProviderImpl };
