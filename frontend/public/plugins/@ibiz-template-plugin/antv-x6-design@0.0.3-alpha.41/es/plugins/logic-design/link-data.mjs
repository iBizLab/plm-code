import { CellDataProviderImpl } from './cell-data.mjs';

"use strict";
class LinkDataProviderImpl extends CellDataProviderImpl {
  get type() {
    return "";
  }
  get source() {
    if (this.data.srcendpoint) {
      return {
        cell: this.data.srcpsdelogicnodeid,
        port: this.data.srcendpoint
      };
    }
    return this.data.srcpsdelogicnodeid;
  }
  get target() {
    if (this.data.dstendpoint) {
      return {
        cell: this.data.dstpsdelogicnodeid,
        port: this.data.dstendpoint
      };
    }
    return this.data.dstpsdelogicnodeid;
  }
  get label() {
    return (this.data.psdelogiclinkname === "\u8FDE\u63A5\u540D\u79F0" ? "" : this.data.psdelogiclinkname) || "";
  }
}

export { LinkDataProviderImpl };
