import { RuntimeModelError } from '@ibiz-template/core';
import { TreeController, UIActionUtil } from '@ibiz-template/runtime';
import { isNil } from 'lodash-es';
import { LogicDesignTreeService } from './tree.service.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class LogicTreeDesignTreeController extends TreeController {
  constructor() {
    super(...arguments);
    /**
     * @description 下一步选中数据
     * @type {string}
     * @memberof LogicTreeDesignTreeController
     */
    __publicField(this, "toSelectSrfkey", "");
  }
  async initService() {
    this.service = new LogicDesignTreeService(this.model);
    await this.service.init(this.context);
  }
  /**
   * @description 设置下一步选中数据
   * @memberof LogicTreeDesignTreeController
   */
  setToSelectData() {
    if (!this.toSelectSrfkey) {
      return;
    }
    const toActiveNode = this.state.items.find(
      (item) => item.srfkey === this.toSelectSrfkey
    );
    if (toActiveNode) {
      this.onTreeNodeClick(toActiveNode, {});
      this.toSelectSrfkey = "";
    }
  }
  async onCreated() {
    var _a;
    (_a = this.model.detreeNodes) == null ? void 0 : _a.forEach((node) => {
      if (node.rootNode) {
        node.allowDrop = true;
      }
    });
    await super.onCreated();
  }
  async afterLoad(args, items) {
    this.setToSelectData();
    return items;
  }
  /**
   * 当数据放生变更时，若为当前应用实体数据。则多数据部件进行刷新
   *
   * @author chitanda
   * @date 2023-09-13 17:09:04
   * @protected
   * @param {IData} msg
   */
  onDataChange(msg) {
    if (msg.data && msg.data.srfdecodename === this.dataEntity.codeName) {
      if (this.state.activated) {
        const findNode = this.state.items.find(
          (item) => item.srfkey === msg.data.srfkey
        );
        if (findNode) {
          findNode._deData = msg.data;
        }
      }
    }
  }
  calcAllowDrop(draggingNode, dropNode, type) {
    const dropInNode = type === "inner" ? dropNode : dropNode._parent;
    if ((dropInNode == null ? void 0 : dropInNode._deData) && !isNil(dropInNode._deData.srfallowdrop)) {
      return dropInNode._deData.srfallowdrop;
    }
    const result = super.calcAllowDrop(draggingNode, dropNode, type);
    return result;
  }
  async onNodeDrop(draggingNode, dropNode, dropType) {
    var _a, _b, _c;
    if (dropType === "inner" && !dropNode._leaf && dropNode._children === void 0) {
      await this.expandNodeByKey([dropNode._id]);
    }
    const modifiedNodeDatas = [];
    const draggingNodeModel = this.getNodeModel(draggingNode._nodeId);
    const dropInNode = dropType === "inner" ? dropNode : dropNode._parent;
    const isChangedParent = (dropNode == null ? void 0 : dropNode._id) !== ((_a = draggingNode._parent) == null ? void 0 : _a._id);
    let orderNodeModel = this.getNodeModel(dropNode._nodeId);
    if (dropType === "inner" || ((_b = dropNode._parent) == null ? void 0 : _b._id) !== ((_c = draggingNode._parent) == null ? void 0 : _c._id)) {
      const dropNodeRs = this.findDropNodeRS(
        dropInNode._nodeId,
        draggingNodeModel.appDataEntityId
      );
      if (dropNodeRs) {
        draggingNode._deData[dropNodeRs.pickupDEFName] = isNil(
          dropInNode._value
        ) ? null : dropInNode._value;
        modifiedNodeDatas.push(draggingNode);
        orderNodeModel = this.getNodeModel(dropNodeRs.childDETreeNodeId);
      }
    }
    const originArr = draggingNode._parent._children;
    originArr.splice(originArr.indexOf(draggingNode), 1);
    if (dropType === "inner") {
      if (!dropNode._children) {
        dropNode._children = [];
        dropNode._leaf = true;
        this.state.expandedKeys.push(dropNode._id);
      }
      dropNode._children.push(draggingNode);
    } else {
      let insertIndex = dropInNode._children.indexOf(dropNode);
      if (dropType === "next") {
        insertIndex += 1;
      }
      dropInNode._children.splice(insertIndex, 0, draggingNode);
    }
    if (dropType === "inner" || isChangedParent) {
      draggingNode._parent = dropInNode;
      draggingNode._nodeId = orderNodeModel.id;
      this.state.expandedKeys = this.calcExpandedKeys([dropInNode]);
    }
    const { sortAppDEFieldId, sortDir, allowOrder } = orderNodeModel;
    if (allowOrder === true) {
      if (!sortAppDEFieldId) {
        throw new RuntimeModelError(orderNodeModel, "\u7F3A\u5C11\u914D\u7F6E\u6392\u5E8F\u5C5E\u6027");
      }
      const sortField = sortAppDEFieldId.toLowerCase();
      const isAsc = sortDir === "ASC";
      const changedArr = [...dropInNode._children];
      if (!isAsc) {
        changedArr.reverse();
      }
      const getNextSort = (num) => {
        return num + (100 - num % 100);
      };
      const getSort = (deData) => {
        return deData[sortField] || 0;
      };
      let lastSort;
      changedArr.forEach((item, index) => {
        const deData = item._deData;
        if (lastSort === void 0) {
          if (item === draggingNode) {
            if (index === 0) {
              lastSort = 100;
            } else {
              lastSort = getNextSort(getSort(changedArr[index - 1]._deData));
            }
            deData[sortField] = lastSort;
            if (modifiedNodeDatas.indexOf(item) === -1) {
              modifiedNodeDatas.push(item);
            }
          }
        } else {
          if (lastSort >= getSort(deData)) {
            deData[sortField] = getNextSort(lastSort);
            modifiedNodeDatas.push(item);
          }
          lastSort = getSort(deData);
        }
      });
    }
    await this.updateDeNodeData(modifiedNodeDatas);
    this._evt.emit("onAfterNodeDrop", { isChangedParent });
  }
  /**
   * 删除强制静默，其他不变
   * @author lxm
   * @date 2023-12-27 03:32:36
   * @param {MDCtrlRemoveParams} [args]
   * @return {*}  {Promise<void>}
   */
  remove(args) {
    const _args = args || {};
    _args.silent = true;
    return super.remove(args);
  }
  /**
   * 执行界面行为
   *
   * @author chitanda
   * @date 2023-12-07 15:12:26
   * @param {string} uiActionId
   * @param {ITreeNodeData} nodeData
   * @param {MouseEvent} event
   * @param {string} appId
   * @return {*}  {Promise<void>}
   */
  async doUIAction(uiActionId, nodeData, event, appId) {
    const eventArgs = this.getEventArgs();
    const nodeParams = this.parseTreeNodeData(nodeData);
    const result = await UIActionUtil.exec(
      uiActionId,
      {
        ...eventArgs,
        ...nodeParams,
        event
      },
      appId
    );
    if (result.closeView) {
      this.view.closeView();
    } else if (result.refresh) {
      switch (result.refreshMode) {
        case 1:
          await this.refreshNodeChildren(nodeData);
          break;
        case 2:
          await this.refreshNodeChildren(nodeData, true);
          break;
        case 3:
          await this.refresh();
          break;
        default:
      }
    }
    const { toSelectSrfkey } = result;
    if (toSelectSrfkey) {
      this.toSelectSrfkey = toSelectSrfkey;
      this.setToSelectData();
    }
  }
}

export { LogicTreeDesignTreeController };
