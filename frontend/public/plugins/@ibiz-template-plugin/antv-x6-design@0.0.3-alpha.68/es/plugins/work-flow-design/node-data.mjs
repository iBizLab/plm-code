import { CellDataProviderImpl } from './cell-data.mjs';

"use strict";
class NodeDataProviderImpl extends CellDataProviderImpl {
  set type(type) {
    this.data.wfprocesstype = type;
  }
  get type() {
    return this.data.wfprocesstype;
  }
  get x() {
    return this.data.leftpos;
  }
  get y() {
    return this.data.toppos;
  }
}

export { NodeDataProviderImpl };
