import { DEService } from '@ibiz-template/runtime';
import '../../entity/index.mjs';
import { PSDEFDLogic } from '../../entity/psdefdlogic/psdefdlogic.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class PSDEFDLogicService extends DEService {
  constructor(srfSessionId, model) {
    super(srfSessionId, model);
    /**
     * 类型代码表
     * @author lxm
     * @date 2023-12-27 05:06:47
     * @protected
     * @type {ICodeItem[]}
     */
    __publicField(this, "typeCodeItems");
    const app = ibiz.hub.getApp(model.appId);
    this.typeCodeItems = app.codeList.getCodeList(
      "Config__FDLogicType"
    ).codeItems;
  }
  newEntity(data) {
    if (data instanceof PSDEFDLogic) {
      return data.clone();
    }
    return new PSDEFDLogic(this.model, data, this.typeCodeItems);
  }
}

export { PSDEFDLogicService };
