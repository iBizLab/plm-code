import { DEService } from '@ibiz-template/runtime';
import { isNilOrEmpty, notNilEmpty } from 'qx-util';
import '../../entity/index.mjs';
import { PSDEFormDetail } from '../../entity/psdeform-detail/psdeform-detail.mjs';

"use strict";
class PSDEFormDetailService extends DEService {
  async exec(id, context, params, params2) {
    if (id === "Create" && params) {
      if (Array.isArray(params)) {
        await Promise.all(
          params.map((item) => {
            return this.calcDefault(context, item);
          })
        );
      } else {
        await this.calcDefault(context, params);
      }
    }
    return super.exec(id, context, params, params2);
  }
  async calcDefault(context, entity) {
    let nStartIndex = 1;
    const strDetailType = entity.detailtype;
    let strRootName = strDetailType;
    if (strDetailType === "FORMITEM") {
      nStartIndex = 0;
      strRootName = entity.detailtype;
      if (entity.psdefname) {
        strRootName = entity.psdefname;
      }
      if (entity.formtype === "SEARCHFORM") {
        strRootName = entity.psdefsfitemname;
      }
      if (isNilOrEmpty(strRootName)) {
        strRootName = entity.srfdecodename;
      }
    }
    if (isNilOrEmpty(strRootName)) {
      return;
    }
    strRootName = strRootName.toLowerCase();
    const res = await this.fetchTempDefault(context);
    if (res.ok && res.data) {
      const details = res.data;
      const detailMap = /* @__PURE__ */ new Map();
      const detailMap2 = /* @__PURE__ */ new Map();
      details.forEach((item) => {
        if (notNilEmpty(item.psdeformdetailname)) {
          detailMap.set(item.psdeformdetailname.toLowerCase(), item);
        }
        if (notNilEmpty(item.psdeformdetailid)) {
          detailMap2.set(item.psdeformdetailid.toLowerCase(), item);
        }
      });
      while (true) {
        const strDefaultName = strRootName + (nStartIndex === 0 ? "" : nStartIndex);
        if (!detailMap.has(strDefaultName) && !detailMap2.has(strDefaultName)) {
          entity.psdeformdetailname = strDefaultName;
          entity.psdeformdetailid = strDefaultName;
          break;
        }
        nStartIndex += 1;
      }
    }
    if (isNilOrEmpty(entity.srfdecodename) && isNilOrEmpty(entity.logicname)) {
      if (strDetailType === "FORMPAGE") {
        entity.logicname = "\u8868\u5355\u5206\u9875";
      } else if (strDetailType === "GROUPPANEL") {
        entity.logicname = "\u5206\u7EC4\u9762\u677F";
      } else if (strDetailType === "TABPAGE") {
        entity.logicname = "\u5206\u9875";
      } else if (strDetailType === "BUTTON") {
        entity.logicname = "\u6309\u94AE";
      } else if (strDetailType === "USERCONTROL") {
        entity.logicname = "\u81EA\u5B9A\u4E49\u90E8\u4EF6";
      } else if (strDetailType === "RAWITEM") {
        entity.logicname = "\u76F4\u63A5\u5185\u5BB9";
      } else if (strDetailType === "DRUIPART") {
        entity.logicname = "\u5173\u7CFB\u754C\u9762";
      } else if (strDetailType === "FORMITEM") {
        entity.logicname = "\u8868\u5355\u9879";
      } else if (strDetailType === "FORMITEMEX") {
        entity.logicname = "\u590D\u5408\u8868\u5355\u9879";
      } else if (strDetailType === "FORMPART") {
        entity.logicname = "\u8868\u5355\u90E8\u4EF6";
      } else if (strDetailType === "IFRAME") {
        entity.logicname = "\u5D4C\u5165\u9875\u9762(iframe)";
      } else if (strDetailType === "TABPANEL") {
        entity.logicname = "\u5206\u9875\u9762\u677F";
      } else if (strDetailType === "DATAGRID") {
        entity.logicname = "\u6570\u636E\u8868\u683C";
      }
    }
  }
  newEntity(data) {
    if (data instanceof PSDEFormDetail) {
      return data.clone();
    }
    return new PSDEFormDetail(this.model, data);
  }
}

export { PSDEFormDetailService };
