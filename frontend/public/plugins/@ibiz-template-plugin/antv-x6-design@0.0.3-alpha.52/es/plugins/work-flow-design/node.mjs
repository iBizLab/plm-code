import { clone, isSvg } from '@ibiz-template/core';
import { createUUID } from 'qx-util';
import { CellProviderImpl } from './cell.mjs';
import '../../utils/index.mjs';
import { x6ProviderRegister } from '../../utils/x6-provider-register/x6-provider-register.mjs';
import { dataTransformUtil } from '../../utils/data-transform-util/data-transform-util.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class NodeProviderImpl extends CellProviderImpl {
  constructor(node, link) {
    super(node);
    __publicField(this, "linkModel");
    __publicField(this, "validateNodeType", ["START"]);
    this.linkModel = link;
  }
  createDataProvider(data) {
    return x6ProviderRegister.getNodeData(
      "".concat(this.pluginConfig.pluginType, "_").concat(this.pluginConfig.pluginCode, "_DataProvider")
    )(data);
  }
  async create(context, params, node) {
    const { x, y } = node.position();
    const data = node.getData();
    const transformData = dataTransformUtil.transform(data, context, params);
    const deService = await this.getDeService(context);
    const res = await deService.create(context, {
      ...transformData,
      leftpos: x,
      toppos: y
    });
    return res.data;
  }
  async update(context, _params, node) {
    const { x, y } = node.position();
    const entityModel = await this.getAppDataEntity();
    const deService = await this.getDeService(context);
    const res = await deService.update(context, {
      [entityModel.keyAppDEFieldId]: node.id,
      leftpos: x,
      toppos: y
    });
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
  getIcon(codeItem) {
    if (!codeItem) {
      return;
    }
    const image = codeItem.sysImage;
    let icon;
    if (image) {
      if (image.imagePath && isSvg(image.imagePath)) {
        icon = image.imagePath;
      } else if (image.rawContent) {
        icon = image.rawContent;
      }
    }
    return icon;
  }
  createCell(data) {
    const codeItem = this.codeItems.find((item) => item.value === data.type);
    const icon = this.getIcon(codeItem);
    return {
      id: data.id,
      shape: "wf-node",
      x: data.x,
      y: data.y,
      label: data.label,
      icon,
      type: data.type,
      data
    };
  }
  createDragCell(codeItem) {
    const data = {
      ...codeItem.data || {},
      isNew: true
    };
    return {
      id: createUUID(),
      shape: "wf-node",
      data,
      label: codeItem.text,
      icon: this.getIcon(codeItem),
      type: data.wfprocesstype
    };
  }
  createMaterialCell(codeItem) {
    return {
      shape: "wf-material-node",
      label: codeItem.text,
      data: codeItem,
      icon: this.getIcon(codeItem)
    };
  }
  createMaterialAddCell(codeItem) {
    return {
      shape: "wf-material-node",
      label: codeItem.text,
      data: codeItem,
      icon: this.getIcon(codeItem)
    };
  }
  validateNode(node, options) {
    const data = node.data;
    if (!data) {
      return true;
    }
    const name = data.pswfprocessname || "";
    const type = data.wfprocesstype || "";
    const g = options.targetGraph;
    if (this.validateNodeType.includes(type)) {
      const index = g.getNodes().findIndex((cell) => {
        const nodeDate = cell.data;
        return nodeDate && nodeDate.type === type;
      });
      if (index !== -1) {
        ibiz.message.error("\u4E0D\u80FD\u91CD\u590D\u6DFB\u52A0".concat(name, "\u8282\u70B9"));
        return false;
      }
    }
    return true;
  }
  async createEdges(_node, _g) {
    return void 0;
  }
}

export { NodeProviderImpl };
