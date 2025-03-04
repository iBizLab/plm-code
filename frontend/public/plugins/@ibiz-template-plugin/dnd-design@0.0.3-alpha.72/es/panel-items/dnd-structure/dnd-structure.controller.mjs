import { RuntimeModelError } from '@ibiz-template/core';
import { PanelItemController, QXEventEx, getControl } from '@ibiz-template/runtime';
import { ascSort } from 'qx-util';
import { DndStructurePanelItemState } from './dnd-structure.state.mjs';
import '../../entity/index.mjs';
import { DndStructureNodeData } from '../../entity/dnd-structure-node-data/dnd-structure-node-data.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndStructurePanelItemController extends PanelItemController {
  constructor() {
    super(...arguments);
    __publicField(this, "codeList");
    __publicField(this, "service");
    __publicField(this, "form");
    /**
     * 事件中心
     *
     * @author zhanghengfeng
     * @date 2024-01-09 19:01:28
     */
    __publicField(this, "evt", new QXEventEx());
    /**
     * 数据
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:44
     * @protected
     * @type {IDataEntity[]}
     */
    __publicField(this, "items", []);
    /**
     * 定时器
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:01
     * @protected
     * @type {(number | null)}
     */
    __publicField(this, "timer", null);
    /**
     * 是否禁止处理消息
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:58
     * @protected
     * @type {boolean}
     */
    __publicField(this, "isDisableMessage", false);
    /**
     * 代码表列表
     *
     * @author zhanghengfeng
     * @date 2024-01-18 16:01:21
     * @type {{ key: string; map: Map<string, ICodeItem> }[]}
     */
    __publicField(this, "codeItemList", []);
  }
  get view() {
    return this.panel.view;
  }
  createState() {
    var _a;
    return new DndStructurePanelItemState((_a = this.parent) == null ? void 0 : _a.state);
  }
  async onInit() {
    await super.onInit();
    const form = getControl(this.panel.view.model, "item");
    if (!form) {
      throw new RuntimeModelError(this.panel.view, "\u672A\u627E\u5230 item \u8868\u5355\u6A21\u578B");
    }
    this.form = form;
    const app = await ibiz.hub.getApp(this.model.appId);
    this.service = await app.deService.getService(
      this.panel.context,
      form.appDataEntityId
    );
    const editor = this.model.editor;
    if (editor) {
      const { appCodeListId } = editor;
      if (appCodeListId) {
        this.codeList = app.codeList.getCodeList(appCodeListId);
      }
      if (!this.codeList) {
        throw new RuntimeModelError(this.model, "\u672A\u914D\u7F6E\u7ED3\u6784\u533A\u4EE3\u7801\u8868");
      }
      const codeItems = this.codeList.codeItems || [];
      const codeItemList = [];
      codeItems.forEach((item) => {
        const key = item.value;
        const children = item.codeItems;
        if (key && Array.isArray(children)) {
          const map = /* @__PURE__ */ new Map();
          children.forEach((child) => {
            const type = child.value;
            if (type) {
              map.set(type, child);
            }
          });
          codeItemList.push({ key, map });
        }
      });
      this.codeItemList = codeItemList;
    }
    this.view.evt.on("onSaveSuccess", async () => {
      await this.load();
    });
    await this.load();
    this.subscribeMessage();
  }
  /**
   * 获取节点图标
   *
   * @author zhanghengfeng
   * @date 2024-01-18 16:01:35
   * @param {IDndStructureNodeData} node
   * @return {*}  {string}
   */
  getNodeIcon(node) {
    const entity = node.entity;
    for (let i = 0; i < this.codeItemList.length; i++) {
      const codeItem = this.codeItemList[i];
      const { key, map } = codeItem;
      const type = entity[key];
      if (type && map.get(type)) {
        return map.get(type).iconPath;
      }
    }
  }
  /**
   * 监听数据变化
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:59
   * @protected
   * @param {IPortalMessage} msg
   * @return {*}  {void}
   */
  onDataUpdate(msg) {
    if (this.isDisableMessage) {
      return;
    }
    if (msg.data && typeof msg.data === "object") {
      const data = msg.data;
      if (data.srfkey) {
        const index = this.items.findIndex((item) => item.srfkey === data.srfkey);
        if (index !== -1) {
          this.items.splice(index, 1);
          this.items.push(data);
          if (this.timer) {
            window.clearTimeout(this.timer);
          }
          this.timer = window.setTimeout(() => {
            this.items = ascSort(this.items, "srfordervalue");
            this.state.items = this.transformItemsToTree(this.items);
            this.evt.emit("updateSelect");
          }, 50);
        }
      }
    }
  }
  /**
   * 监听数据创建
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:10
   * @protected
   * @param {IPortalMessage} msg
   * @return {*}  {void}
   */
  onDataCreate(msg) {
    if (this.isDisableMessage || msg.messageid !== this.panel.context.srfsessionid) {
      return;
    }
    if (msg.data && typeof msg.data === "object") {
      const data = msg.data;
      if (data.srfkey) {
        this.items.push(data);
        this.items = ascSort(this.items, "srfordervalue");
        this.state.items = this.transformItemsToTree(this.items);
        this.evt.emit("updateSelect");
      }
    }
  }
  /**
   * 监听数据删除
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:26
   * @protected
   * @param {IPortalMessage} msg
   * @return {*}  {void}
   */
  onDataRemove(msg) {
    if (this.isDisableMessage) {
      return;
    }
    if (msg.data && typeof msg.data === "object") {
      const data = msg.data;
      if (data.srfkey) {
        const index = this.items.findIndex((item) => item.srfkey === data.srfkey);
        if (index !== -1) {
          this.items.splice(index, 1);
          this.items = ascSort(this.items, "srfordervalue");
          this.state.items = this.transformItemsToTree(this.items);
          this.evt.emit("updateSelect");
        }
      }
    }
  }
  /**
   * 发送消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:39
   * @protected
   * @param {IDataEntity[]} items
   * @param {IPortalMessage['subtype']} [type]
   * @param {IPortalMessage} [msg]
   */
  sendMessage(items, type, msg) {
    this.isDisableMessage = true;
    items.forEach((item) => {
      if (type) {
        ibiz.mc.command.send(item, type);
        return;
      }
      if (msg) {
        ibiz.mc.command.next({ ...msg, data: item });
      }
    });
    this.isDisableMessage = false;
  }
  /**
   * 订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:44
   * @protected
   */
  subscribeMessage() {
    this.onDataUpdate = this.onDataUpdate.bind(this);
    this.onDataCreate = this.onDataCreate.bind(this);
    this.onDataRemove = this.onDataRemove.bind(this);
    this.load = this.load.bind(this);
    this.view.evt.on("onRefreshView", this.load);
    ibiz.mc.command.update.on(this.onDataUpdate);
    ibiz.mc.command.create.on(this.onDataCreate);
    ibiz.mc.command.remove.on(this.onDataRemove);
  }
  /**
   * 取消订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:55
   * @protected
   */
  unsubscribeMessage() {
    this.view.evt.off("onRefreshView", this.load);
    ibiz.mc.command.update.off(this.onDataUpdate);
    ibiz.mc.command.create.off(this.onDataCreate);
    ibiz.mc.command.remove.off(this.onDataRemove);
  }
  /**
   * 销毁方法
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:10
   */
  destroy() {
    super.destroy();
    this.unsubscribeMessage();
  }
  async load() {
    const result = await this.service.fetchDefault(this.panel.context);
    if (result.ok && Array.isArray(result.data)) {
      const items = ascSort(result.data, "srfordervalue");
      this.items = items;
      this.state.items = this.transformItemsToTree(items);
    } else {
      this.state.items = [];
    }
  }
  /**
   * 将列表数据转为树
   *
   * @author zhanghengfeng
   * @date 2023-12-28 19:12:36
   * @protected
   * @param {IDataEntity[]} items
   * @return {*}  {IDndStructureNodeData[]}
   */
  transformItemsToTree(items) {
    const map = {};
    const tree = [];
    items.forEach((item) => {
      const id = item.srfkey;
      if (id) {
        map[id] = new DndStructureNodeData(item);
      }
    });
    items.forEach((item) => {
      const child = map[item.srfkey];
      if (child) {
        if (item.srfpkey) {
          const parent = item.srfpkey ? map[item.srfpkey] : null;
          if (parent) {
            child.parent = parent;
            parent.children.push(child);
          }
        } else {
          child.parent = null;
          tree.push(child);
        }
      }
    });
    return tree;
  }
  /**
   * 数据拖拽变更
   *
   * @author zhanghengfeng
   * @date 2023-12-28 19:12:23
   * @param {IDndStructureNodeData} item
   * @param {IDndStructureNodeData[]} items
   * @param {IDndStructureNodeData} [parent]
   */
  change(item, items, parent) {
    if (parent) {
      item.parent = parent;
      item.entity.srfpkey = parent.entity.srfkey;
    } else {
      item.parent = null;
      item.entity.srfpkey = void 0;
    }
    this.move(
      items.map((node) => node.entity),
      0,
      items.length - 1
    );
  }
  /**
   * 节点排序并更新
   *
   * @author zhanghengfeng
   * @date 2023-12-28 19:12:45
   * @protected
   * @param {IDataEntity[]} items
   * @param {number} oldIndex
   * @param {number} newIndex
   * @return {*}  {Promise<void>}
   */
  async move(items, oldIndex, newIndex) {
    const start = oldIndex > newIndex ? newIndex : oldIndex;
    const end = oldIndex > newIndex ? oldIndex : newIndex;
    const list = [];
    items.forEach((item, index) => {
      if (index >= start && index <= end) {
        item.srfordervalue = (index + 1) * 10;
        list.push(item);
      }
    });
    const res = await this.service.update(this.panel.context, list);
    if (res.ok) {
      if (Array.isArray(res.data)) {
        this.sendMessage(res.data, "OBJECTUPDATED");
      }
      ibiz.log.debug("\u6392\u5E8F\u6210\u529F");
    }
  }
}

export { DndStructurePanelItemController };
