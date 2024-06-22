import { DEService } from '@ibiz-template/runtime';
import { PSDELogicMethodDto } from './psdelogicnode-method-dto.mjs';

"use strict";
class PSDELogicNodeService extends DEService {
  createMethodDto(dto, opts) {
    if (ibiz.appData && ibiz.appData.context && ibiz.appData.context.srfsystemid === "dataflowdesign") {
      return new PSDELogicMethodDto(this, this.model, opts == null ? void 0 : opts.isLocalMode, dto);
    }
    return super.createMethodDto(dto, opts);
  }
  async exec(id, context, params, params2) {
    if ((id === "Create" || id === "create") && params) {
      if (Array.isArray(params)) {
        await Promise.all(
          params.map((item) => {
            return this.fillDefault(context, item);
          })
        );
      } else {
        await this.fillDefault(context, params);
      }
    }
    return super.exec(id, context, params, params2);
  }
  async fillDefault(context, logicNode) {
    if (!logicNode.codename) {
      const res = await this.fetchDefault(context);
      if (res.ok) {
        const details = res.data;
        const codeNames = details.map((item) => item.codename);
        let num = 1;
        let codeName = "".concat(logicNode.logicnodetype, "_0").concat(num);
        while (codeNames.includes(codeName)) {
          num += 1;
          codeName = "".concat(logicNode.logicnodetype, "_0").concat(num);
        }
        logicNode.codename = codeName;
      }
    }
  }
}

export { PSDELogicNodeService };
