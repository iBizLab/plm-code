import '../../controller/index.mjs';
import { DndItemController } from '../../controller/dnd-item-controller/dnd-item-controller.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class IframeProvider {
  constructor() {
    __publicField(this, "type", "PSDEFORMDETAIL_IFRAME");
    __publicField(this, "component", "IBizDndDesignIframe");
  }
  createController(c, model, item) {
    return new DndItemController(c, model, item);
  }
}

export { IframeProvider };