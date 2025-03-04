import { clone } from '@ibiz-template/core';
import '../../utils/index.mjs';
import { CellProviderImpl } from './cell.mjs';
import './utils/index.mjs';
import { x6ProviderRegister } from '../../utils/x6-provider-register/x6-provider-register.mjs';
import { linkUtil } from './utils/link-util.mjs';
import { dataTransformUtil } from '../../utils/data-transform-util/data-transform-util.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class LinkProviderImpl extends CellProviderImpl {
  constructor(node, link) {
    super(link);
    __publicField(this, "nodeModel");
    __publicField(this, "nodeService");
    this.nodeModel = node;
  }
  async getNodeService(context) {
    if (!this.nodeService) {
      this.nodeService = await this.app.deService.getService(
        context,
        this.nodeModel.appDataEntityId
      );
    }
    return this.nodeService;
  }
  createDataProvider(data) {
    return x6ProviderRegister.getLinkData(
      "".concat(this.pluginConfig.pluginType, "_").concat(this.pluginConfig.pluginCode, "_DataProvider")
    )(data);
  }
  getCodeItemData(type) {
    const codeItem = this.codeItemMap.get(type || "default");
    const codeItemData = (codeItem == null ? void 0 : codeItem.data) || {};
    return codeItemData;
  }
  getVertices(data) {
    if (!data) {
      return;
    }
    try {
      const entity = data.data;
      const shapeParams = JSON.parse((entity == null ? void 0 : entity.shapeparams) || "{}");
      return shapeParams == null ? void 0 : shapeParams.vertices;
    } catch (err) {
      ibiz.log.error("".concat(data, " \u6570\u636E\u89E3\u6790\u9519\u8BEF"));
    }
  }
  getShapeParams(edge) {
    try {
      const targetPort = edge.getTargetPortId();
      const data = JSON.parse(edge.getData() || "{}");
      const vertices = edge.vertices;
      let shapeParams = data.shapeparams;
      const isCenterTarget = targetPort === "center";
      if (data.shapeparams) {
        const originShapeParams = JSON.parse(data.shapeparams);
        Object.assign(originShapeParams, {
          vertices,
          isCenterTarget
        });
        shapeParams = JSON.stringify(originShapeParams);
      } else {
        shapeParams = JSON.stringify({ vertices, isCenterTarget });
      }
      return shapeParams;
    } catch (err) {
      ibiz.log.error("".concat(edge.getData(), " \u6570\u636E\u89E3\u6790\u9519\u8BEF"));
    }
  }
  async create(context, params, edge) {
    var _a;
    const data = edge.getData();
    const sourceCell = edge.getSourceCell();
    const targetCell = edge.getTargetCell();
    const nodeService = await this.getNodeService(context);
    let linkType = await linkUtil.getLinkType(
      {
        ...context,
        pswfprocess: sourceCell.id
      },
      nodeService
    );
    const deService = await this.getDeService(context);
    if (sourceCell) {
      const sourceData = (_a = sourceCell.getData()) == null ? void 0 : _a.data;
      if (sourceData && sourceData.enabletimeout) {
        const res2 = await deService.fetchDefault(context);
        if (res2 && res2.ok && Array.isArray(res2.data)) {
          const isTimeout = res2.data.some(
            (item) => item.frompswfprocid === sourceCell.id && item.wflinktype === "TIMEOUT"
          );
          if (!isTimeout) {
            const result = await ibiz.confirm.warning({
              title: "\u5DE5\u4F5C\u6D41\u8FDE\u7EBF",
              desc: "\u662F\u5426\u5EFA\u7ACB\u8D85\u65F6\u94FE\u63A5\uFF1F",
              options: {
                confirmButtonText: "\u662F",
                cancelButtonText: "\u5426"
              }
            });
            if (result) {
              linkType = "TIMEOUT";
            }
          }
        }
      }
    }
    const linkName = await linkUtil.getLinkName(context, linkType, deService);
    const sourcePort = edge.getSourcePortId();
    const targetPort = edge.getTargetPortId();
    const isCenterTarget = targetPort === "center";
    const shapeParams = JSON.stringify({ isCenterTarget });
    const transformData = dataTransformUtil.transform(
      this.getCodeItemData(linkType),
      context,
      params
    );
    const res = await deService.create(context, {
      ...data,
      frompswfprocid: sourceCell.id,
      topswfprocid: targetCell.id,
      wflinktype: linkType,
      pswflinkname: linkName,
      ordervalue: 100,
      srcendpoint: sourcePort !== "center" ? sourcePort : void 0,
      dstendpoint: targetPort !== "center" ? targetPort : void 0,
      shapeparams: shapeParams,
      ...transformData
    });
    return res.data;
  }
  async update(context, _params, edge) {
    const entityModel = await this.getAppDataEntity();
    const sourceCell = edge.getSourceCell();
    const targetCell = edge.getTargetCell();
    const deService = await this.getDeService(context);
    const sourcePort = edge.getSourcePortId();
    const targetPort = edge.getTargetPortId();
    const data = {
      [entityModel.keyAppDEFieldId]: edge.id,
      frompswfprocid: sourceCell.id,
      topswfprocid: targetCell.id,
      srcendpoint: sourcePort !== "center" ? sourcePort : void 0,
      dstendpoint: targetPort !== "center" ? targetPort : void 0
    };
    const shapeParams = this.getShapeParams(edge);
    if (shapeParams) {
      data.shapeparams = shapeParams;
    }
    const res = await deService.update(context, data);
    return res.data;
  }
  async delete(context, _params, id) {
    const entityModel = await this.getAppDataEntity();
    const deService = await this.getDeService(context);
    const _context = clone(context);
    _context[entityModel.codeName.toLowerCase()] = id;
    const res = await deService.remove(_context);
    return res.data;
  }
  async get(_context, _params, _id) {
    throw new Error("Method not implemented.");
  }
  async copy(_context, _params, _cell) {
    throw new Error("Method not implemented.");
  }
  createCell(data) {
    return {
      shape: "wf-link",
      id: data.id,
      source: data.source,
      target: data.target,
      data: JSON.stringify(data.data),
      label: data.label,
      dataProvider: data,
      vertices: this.getVertices(data)
    };
  }
  onEdgeLabelRendered(_args) {
  }
}

export { LinkProviderImpl };
