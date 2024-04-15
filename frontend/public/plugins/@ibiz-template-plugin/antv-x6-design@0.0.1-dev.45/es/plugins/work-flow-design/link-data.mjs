import { CellDataProviderImpl } from './cell-data.mjs';

"use strict";
class LinkDataProviderImpl extends CellDataProviderImpl {
  get type() {
    return this.data.wflinktype || "";
  }
  get source() {
    if (this.data.srcendpoint) {
      return {
        cell: this.data.frompswfprocid,
        port: this.data.srcendpoint
      };
    }
    return this.data.frompswfprocid;
  }
  get target() {
    if (this.data.dstendpoint) {
      return {
        cell: this.data.topswfprocid,
        port: this.data.dstendpoint
      };
    }
    return this.data.topswfprocid;
  }
  get label() {
    let text = this.data.logicname || this.data.pswflinkname || "";
    if (this.data.nextcond) {
      text = text ? "".concat(text, "\n").concat(this.data.nextcond) : this.data.nextcond;
    }
    return text;
  }
}

export { LinkDataProviderImpl };
