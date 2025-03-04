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
    __publicField(this, "validateNodeType", ["BEGIN"]);
    this.linkModel = link;
  }
  createDataProvider(data) {
    return x6ProviderRegister.getNodeData(
      "".concat(this.pluginConfig.pluginType, "_").concat(this.pluginConfig.pluginCode, "_DataProvider")
    )(data);
  }
  /**
   * 获取排序值
   *
   * @author zhanghengfeng
   * @date 2024-01-26 20:01:18
   * @protected
   * @param {IDataEntity[]} items
   * @return {*}  {number}
   */
  getOrderValue(items) {
    let orderValue = 0;
    items.forEach((item) => {
      if (item.ordervalue) {
        orderValue = Math.max(orderValue, item.ordervalue);
      }
    });
    return orderValue + 10;
  }
  async create(context, params, node, items = []) {
    const { x, y } = node.position();
    const data = node.getData();
    const transformData = dataTransformUtil.transform(data, context, params);
    const deService = await this.getDeService(context);
    const res = await deService.create(context, {
      ...transformData,
      leftpos: x,
      toppos: y,
      ordervalue: this.getOrderValue(items)
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
  async get(context, _params, id) {
    const entityModel = await this.getAppDataEntity();
    const deService = await this.getDeService(context);
    const _context = clone(context);
    _context[entityModel.codeName.toLowerCase()] = id;
    const res = await deService.get(_context);
    return res.data;
  }
  async copy(context, params, cell) {
    const data = await this.get(context, params, cell.id);
    const { x, y } = cell.position();
    const deService = await this.getDeService(context);
    data.srfkey = "";
    const res = await deService.create(context, {
      ...data,
      leftpos: x,
      toppos: y
    });
    return res.data;
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
    let codeItem = this.codeItems.find((item) => item.value === data.type);
    let showTitle = false;
    const { ctrlParams = {} } = this.model.controlParam || {};
    if (ctrlParams.SHOWTITLE) {
      showTitle = ctrlParams.SHOWTITLE === "true";
    }
    if (!codeItem && ctrlParams.ICONKEY) {
      codeItem = this.codeItems.find(
        (item) => item.value === data.data[ctrlParams.ICONKEY]
      );
    }
    const icon = this.getIcon(codeItem);
    return {
      id: data.id,
      shape: "logic-node",
      x: data.x,
      y: data.y,
      label: data.label,
      icon,
      showTitle,
      typeLabel: (codeItem == null ? void 0 : codeItem.text) || "",
      type: data.type,
      data
    };
  }
  createDragCell(codeItem) {
    const data = {
      ...codeItem.data || {},
      isNew: true
    };
    const { ctrlParams = {} } = this.model.controlParam || {};
    if (ctrlParams.ICONKEY) {
      Object.assign(data, { [ctrlParams.ICONKEY]: codeItem.value });
    }
    return {
      id: createUUID(),
      shape: "logic-node",
      data,
      label: codeItem.text,
      icon: this.getIcon(codeItem),
      typeLabel: codeItem.text,
      type: data.logicnodetype
    };
  }
  createMaterialCell(codeItem) {
    return {
      shape: "material-node",
      label: codeItem.text,
      data: codeItem,
      icon: this.getIcon(codeItem)
    };
  }
  createMaterialAddCell(codeItem) {
    return {
      shape: "material-add-node",
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
    const name = data.psdelogicnodename || "";
    const type = data.logicnodetype || "";
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
  /**
   *  获取与节点相交的边
   *
   * @author zhanghengfeng
   * @date 2024-01-19 17:01:30
   * @protected
   * @param {Node} node
   * @param {Graph} g
   * @return {*}  {(Edge | null)}
   */
  findIntersectsEdge(node, g) {
    let intersectsEdge = null;
    const edges = g.getEdges();
    const bBox = node.getBBox();
    const lines = [
      bBox.leftLine,
      bBox.rightLine,
      bBox.topLine,
      bBox.bottomLine
    ];
    edges.forEach((edge) => {
      const view = g.findViewByCell(edge);
      if (view) {
        lines.forEach((line) => {
          if (view.path.intersectsWithLine(line)) {
            intersectsEdge = edge;
          }
        });
      }
    });
    return intersectsEdge;
  }
  async createEdges(node, g) {
    const edge = this.findIntersectsEdge(node, g);
    if (!edge) {
      return;
    }
    const sourceNode = edge.getSourceNode();
    const targetNode = edge.getTargetNode();
    if (sourceNode && targetNode && sourceNode.id && targetNode.id) {
      edge.setSource(sourceNode);
      edge.setTarget(node);
      await g.trigger("edge:connected", { edge });
      const newEdge = g.addEdge({ source: node, target: targetNode });
      await g.trigger("edge:connected", { edge: newEdge });
    }
  }
}

export { NodeProviderImpl };
