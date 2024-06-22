"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndStructureNodeData {
  constructor(entity) {
    __publicField(this, "entity");
    __publicField(this, "parent", null);
    __publicField(this, "children", []);
    this.entity = entity;
  }
  get id() {
    return this.entity.srfkey || "";
  }
  get text() {
    return this.entity.srftext || "";
  }
  get type() {
    return this.entity.srftype || "";
  }
}

export { DndStructureNodeData };
