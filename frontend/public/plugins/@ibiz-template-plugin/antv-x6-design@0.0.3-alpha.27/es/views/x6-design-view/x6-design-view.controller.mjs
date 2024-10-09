import { ViewController } from '@ibiz-template/runtime';
import { X6DesignViewEngine } from './x6-design-view.engine.mjs';
import '../../utils/index.mjs';
import { SelectState } from '../../utils/select-state/select-state.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class X6DesignViewController extends ViewController {
  constructor() {
    super(...arguments);
    /**
     * 视图中的选中数据
     *
     * @author chitanda
     * @date 2023-12-21 18:12:25
     */
    __publicField(this, "select", new SelectState());
  }
  initEngines() {
    this.engines.push(new X6DesignViewEngine(this));
  }
}

export { X6DesignViewController };
