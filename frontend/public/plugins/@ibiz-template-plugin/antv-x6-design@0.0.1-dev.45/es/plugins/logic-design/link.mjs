import { clone, Namespace } from '@ibiz-template/core';
import '../../utils/index.mjs';
import { CellProviderImpl } from './cell.mjs';
import { x6ProviderRegister } from '../../utils/x6-provider-register/x6-provider-register.mjs';
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
    __publicField(this, "logicType", "");
    this.nodeModel = node;
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
    var _a;
    try {
      const vertices = edge.vertices;
      const data = edge.getData();
      const shapeParams = JSON.parse(((_a = data == null ? void 0 : data.data) == null ? void 0 : _a.shapeparams) || "{}");
      if (shapeParams) {
        Object.assign(shapeParams, {
          vertices
        });
      }
      return JSON.stringify(shapeParams);
    } catch (err) {
      ibiz.log.error("".concat(edge.getData(), " \u6570\u636E\u89E3\u6790\u9519\u8BEF"));
    }
  }
  async create(context, params, edge) {
    const data = edge.getData();
    const sourceCell = edge.getSourceCell();
    const targetCell = edge.getTargetCell();
    const transformData = dataTransformUtil.transform(
      this.getCodeItemData(),
      context,
      params
    );
    const deService = await this.getDeService(context);
    const res = await deService.create(context, {
      ...data,
      srcpsdelogicnodeid: sourceCell.id,
      defaultlink: 0,
      dstpsdelogicnodeid: targetCell.id,
      psdelogiclinkname: "\u8FDE\u63A5\u540D\u79F0",
      ...transformData
    });
    return res.data;
  }
  async update(context, _params, edge) {
    const entityModel = await this.getAppDataEntity();
    const sourceCell = edge.getSourceCell();
    const targetCell = edge.getTargetCell();
    const deService = await this.getDeService(context);
    const data = {
      [entityModel.keyAppDEFieldId]: edge.id,
      srcpsdelogicnodeid: sourceCell.id,
      dstpsdelogicnodeid: targetCell.id
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
  async get(context, _params, id) {
    const entityModel = await this.getAppDataEntity();
    const deService = await this.getDeService(context);
    const _context = clone(context);
    _context[entityModel.codeName.toLowerCase()] = id;
    const res = await deService.get(_context);
    return res.data;
  }
  async copy(_context, _params, _cell) {
    throw new Error("Method not implemented.");
  }
  createCell(data) {
    return {
      shape: "logic-link",
      id: data.id,
      source: data.source,
      target: data.target,
      data,
      label: data.label,
      vertices: this.getVertices(data),
      logicType: this.logicType
    };
  }
  onEdgeLabelRendered(args) {
    const { container, edge, label } = args;
    if (container && edge && label && label.logicDesignLabel) {
      const { width, height, el } = label.logicDesignLabel;
      if (!width || !height || !el) {
        return;
      }
      const foreignObject = document.createElementNS(
        "http://www.w3.org/2000/svg",
        "foreignObject"
      );
      container.appendChild(foreignObject);
      foreignObject.setAttribute("width", "".concat(width));
      foreignObject.setAttribute("height", "".concat(height));
      foreignObject.style.transform = "translateY(-".concat(height / 2, "px)");
      const position = label.position;
      if (position && typeof position === "object") {
        const angle = position.angle;
        if (typeof angle === "number" && (angle < -90 || angle > 90)) {
          const ns = new Namespace("logic-design-label");
          foreignObject.classList.add(ns.bm("foreignObject", "left"));
        }
      }
      foreignObject.appendChild(el);
    }
  }
  afterLoad(view) {
    var _a;
    const data = (_a = view.state) == null ? void 0 : _a.data;
    if (data) {
      this.logicType = data.logictype || "";
    }
  }
}

export { LinkProviderImpl };
