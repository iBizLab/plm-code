import { clone, recursiveIterate, RuntimeError } from '@ibiz-template/core';
import { MethodDto, findModelChild } from '@ibiz-template/runtime';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class PSDELogicMethodDto extends MethodDto {
  constructor() {
    super(...arguments);
    __publicField(this, "condDto");
  }
  async get(context, data, ignore = false) {
    const _context = clone(context);
    if (data.psdelogicnodeid) {
      _context.psdelogicnode = data.psdelogicnodeid;
    }
    const result = await super.get(_context, data, ignore);
    const dto = await this.getCondDto(_context);
    const service = await this.app.deService.getService(
      _context,
      "dataflowdesign.psdedfjoincond"
    );
    const res = await service.exec("FetchCurRootItems", _context, data);
    const items = res.data;
    const writeKey = result.logicnodetype === "DFJOINPROCESS" ? "param5" : "param6";
    if (items.length) {
      const arr = [];
      for (let j = 0; j < items.length; j++) {
        arr.push(await dto.get(_context, items[j], true));
      }
      result[writeKey] = JSON.stringify({
        op: "AND",
        type: "GROUP",
        items: arr
      });
    } else {
      result[writeKey] = null;
    }
    return result;
  }
  async sets(context, data) {
    const dto = await this.getCondDto(context);
    await Promise.all(
      data.map(async (datum) => {
        var _a;
        const condstr = datum.param6 || datum.param5;
        let items = [];
        try {
          items = condstr ? (_a = JSON.parse(condstr)) == null ? void 0 : _a.items : [];
        } catch (error) {
          ibiz.log.error(error);
        }
        if (items && items.length > 0) {
          const pKey = datum.psdelogicnodeid;
          recursiveIterate(
            { items },
            (item) => {
              item.psdelogicnodeid = pKey;
            },
            {
              childrenFields: ["items"]
            }
          );
          items.forEach((item) => {
            item.psdelogicnodeid = pKey;
          });
          await dto.sets(context, items);
        } else {
          await dto.sets(context, []);
        }
      })
    );
    const arr = await super.sets(context, data);
    return arr;
  }
  async getCondDto(context) {
    if (this.condDto) {
      return this.condDto;
    }
    const service = await this.app.deService.getService(
      context,
      "dataflowdesign.psdedfjoincond"
    );
    service.isLocalMode = true;
    const methodDto = findModelChild(
      service.model.appDEMethodDTOs || [],
      "psdedfjoinconddto"
    );
    if (!methodDto) {
      throw new RuntimeError("\u6CA1\u6709\u627E\u5230psdedfjoinconddto");
    }
    const dto = service.createMethodDto(methodDto, {
      isLocalMode: true
    });
    this.condDto = dto;
    return dto;
  }
  /**
   * 递归计算当前 DTO 相关实体的父关系配置
   *
   * @author chitanda
   * @date 2023-12-26 16:12:13
   * @param {IContext} context
   * @param {number} [depth=0] 递归层级，避免进入死循环。最大递归层级为 10
   * @return {*}  {Promise<void>}
   */
  async calcRs(context, depth = 0) {
    await super.calcRs(context, depth);
    if (depth === 0) {
      await this.getCondDto(context);
    }
  }
}

export { PSDELogicMethodDto };
