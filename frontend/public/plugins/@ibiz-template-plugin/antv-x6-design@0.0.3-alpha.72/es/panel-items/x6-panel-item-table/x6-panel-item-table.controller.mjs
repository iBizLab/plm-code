import { RuntimeModelError, clone } from '@ibiz-template/core';
import { PanelItemController, getControl, getPFPlugin, UIActionUtil } from '@ibiz-template/runtime';
import { ascSort } from 'qx-util';
import { X6PanelItemTableState } from './x6-panel-item-table.state.mjs';
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
class X6PanelItemTableController extends PanelItemController {
  constructor() {
    super(...arguments);
    __publicField(this, "app");
    __publicField(this, "node");
    __publicField(this, "link");
    __publicField(this, "nodeService");
    __publicField(this, "linkService");
    __publicField(this, "nodeProvider");
    __publicField(this, "linkProvider");
    __publicField(this, "nodeModel");
    __publicField(this, "linkModel");
    __publicField(this, "nodeMap", /* @__PURE__ */ new Map());
    __publicField(this, "linkMap", /* @__PURE__ */ new Map());
    __publicField(this, "codeItemMap", /* @__PURE__ */ new Map());
    __publicField(this, "addStatusUIActionId", "");
  }
  createState() {
    var _a;
    return new X6PanelItemTableState((_a = this.parent) == null ? void 0 : _a.state);
  }
  get view() {
    return this.panel.view;
  }
  async onInit() {
    await super.onInit();
    const { view } = this.panel;
    this.node = getControl(view.model, "node");
    if (!this.node) {
      throw new RuntimeModelError(view.model, "\u672A\u627E\u5230\u8282\u70B9\u8868\u5355\u6A21\u578B\u5BF9\u8C61");
    }
    this.link = getControl(view.model, "link");
    if (!this.link) {
      throw new RuntimeModelError(view.model, "\u672A\u627E\u5230\u8FDE\u7EBF\u8868\u5355\u6A21\u578B\u5BF9\u8C61");
    }
    this.app = await ibiz.hub.getApp(this.node.appId);
    const nodePluginConfig = getPFPlugin(
      this.node.sysPFPluginId,
      this.node.appId
    );
    if (!nodePluginConfig) {
      throw new RuntimeModelError(this.node, "\u672A\u627E\u5230\u8282\u70B9\u63D2\u4EF6\u914D\u7F6E");
    }
    const nodeTag = "".concat(nodePluginConfig.pluginType, "_").concat(nodePluginConfig.pluginCode);
    const nodeProvider = x6ProviderRegister.getNode(nodeTag);
    if (!nodeProvider) {
      throw new RuntimeModelError(this.node, "\u672A\u627E\u5230\u8282\u70B9\u63D2\u4EF6[".concat(nodeTag, "]"));
    }
    const linkPluginConfig = getPFPlugin(
      this.link.sysPFPluginId,
      this.link.appId
    );
    if (!linkPluginConfig) {
      throw new RuntimeModelError(this.link, "\u672A\u627E\u5230\u8FDE\u7EBF\u63D2\u4EF6\u914D\u7F6E");
    }
    const linkTag = "".concat(linkPluginConfig.pluginType, "_").concat(linkPluginConfig.pluginCode);
    const linkProvider = x6ProviderRegister.getLink(linkTag);
    if (!linkProvider) {
      throw new RuntimeModelError(this.link, "\u672A\u627E\u5230\u8FDE\u7EBF\u63D2\u4EF6[".concat(linkTag, "]"));
    }
    this.nodeProvider = nodeProvider(this.node, this.link);
    this.linkProvider = linkProvider(this.node, this.link);
    this.nodeService = await this.getDeService(this.node);
    this.linkService = await this.getDeService(this.link);
    this.nodeModel = await ibiz.hub.getAppDataEntity(
      this.node.appDataEntityId,
      this.node.appId
    );
    this.linkModel = await ibiz.hub.getAppDataEntity(
      this.link.appDataEntityId,
      this.link.appId
    );
    await this.initCodeItems(this.panel.context, this.panel.params);
    this.initUIAction();
    this.view.evt.on("onSaveSuccess", async () => {
      await this.load();
    });
    this.view.evt.on("onRefreshView", async () => {
      await this.load();
    });
  }
  /**
   * 初始化代码表项
   *
   * @author zhanghengfeng
   * @date 2024-01-31 13:01:55
   * @protected
   * @return {*}  {void}
   */
  async initCodeItems(context, params) {
    const pages = this.link.deformPages;
    if (!Array.isArray(pages) || !pages.length) {
      ibiz.log.debug("\u8868\u5355\u6A21\u578B\u672A\u914D\u7F6E\u8868\u5355\u5206\u9875");
      return;
    }
    const page = pages[0];
    const formDetails = page.deformDetails;
    if (!Array.isArray(formDetails)) {
      ibiz.log.debug("\u8868\u5355\u6A21\u578B\u7684\u8868\u5355\u5206\u9875\u91CC\u9762\u672A\u914D\u7F6E\u8868\u5355\u9879");
      return;
    }
    const formDetail = formDetails.find(
      (item) => item.codeName === "type"
    );
    if (!formDetail) {
      ibiz.log.debug("\u8868\u5355\u6A21\u578B\u7684\u8868\u5355\u5206\u9875\u91CC\u9762\u672A\u914D\u7F6E\u6807\u8BC6\u4E3Atype\u7684\u8868\u5355\u9879");
      return;
    }
    const appCodeListId = formDetail.editor && formDetail.editor.appCodeListId;
    if (!appCodeListId) {
      ibiz.log.debug("\u6807\u8BC6\u4E3Atype\u7684\u8868\u5355\u9879\u672A\u914D\u7F6E\u4EE3\u7801\u8868");
      return;
    }
    const codeListItems = await this.app.codeList.get(
      appCodeListId,
      context,
      params
    );
    if (codeListItems) {
      codeListItems.forEach((item) => {
        if (item.value) {
          this.codeItemMap.set(item.value, item);
        }
        if (Array.isArray(item.children)) {
          item.children.forEach((child) => {
            if (child.value) {
              this.codeItemMap.set(child.value, child);
            }
          });
        }
      });
    }
  }
  /**
   * 获取对应类型的代码表项
   *
   * @author zhanghengfeng
   * @date 2024-01-31 13:01:28
   * @protected
   * @param {string} [type]
   * @return {*}  {IData}
   */
  getCodeItemData(type) {
    const codeItem = this.codeItemMap.get(type || "default");
    const codeItemData = (codeItem == null ? void 0 : codeItem.data) || {};
    return codeItemData;
  }
  /**
   * 订阅消息变更
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:09
   */
  subscribeMessage() {
    this.onMessageChange = this.onMessageChange.bind(this);
    ibiz.mc.command.update.on(this.onMessageChange);
  }
  /**
   * 取消订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:02
   */
  unsubscribeMessage() {
    ibiz.mc.command.update.off(this.onMessageChange);
  }
  /**
   * 监听消息变更
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:08
   * @protected
   * @param {IPortalMessage} msg
   * @return {*}  {void}
   */
  onMessageChange(msg) {
    if (msg.data && typeof msg.data === "object") {
      const id = msg.data.srfkey;
      if (id) {
        const data = msg.data;
        if (this.nodeMap.get(id)) {
          this.nodeMap.set(id, data);
          const index = this.state.nodes.findIndex((item) => {
            return item.srfkey === id;
          });
          if (index !== -1) {
            this.state.nodes[index] = data;
          }
          return;
        }
        if (this.linkMap.get(id)) {
          this.linkMap.set(id, data);
          const index = this.state.links.findIndex((item) => {
            return item.srfkey === id;
          });
          if (index !== -1) {
            this.state.links[index] = data;
          }
        }
      }
    }
  }
  /**
   * 获取当前表单对应实体的数据服务
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:33
   * @protected
   * @param {IDEEditForm} model
   * @return {*}  {Promise<IAppDEService>}
   */
  async getDeService(model) {
    return this.app.deService.getService(
      this.panel.context,
      model.appDataEntityId
    );
  }
  /**
   * 初始化界面行为
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:13
   * @protected
   * @return {*}  {void}
   */
  initUIAction() {
    const pages = this.node.deformPages;
    if (!Array.isArray(pages) || !pages.length) {
      ibiz.log.error("\u8282\u70B9\u8868\u5355\u6A21\u578B\u672A\u914D\u7F6E\u8868\u5355\u5206\u9875");
      return;
    }
    const page = pages[0];
    const formDetails = page.deformDetails;
    if (!Array.isArray(formDetails)) {
      ibiz.log.error("\u8282\u70B9\u8868\u5355\u6A21\u578B\u7684\u8868\u5355\u5206\u9875\u91CC\u9762\u672A\u914D\u7F6E\u8868\u5355\u9879");
      return;
    }
    const formDetail = formDetails.find(
      (item) => item.codeName === "addstatusbutton"
    );
    if (!formDetail || !formDetail.uiactionId) {
      ibiz.log.error("\u8282\u70B9\u8868\u5355\u6A21\u578B\u672A\u914D\u7F6E\u6DFB\u52A0\u72B6\u6001\u6309\u94AE");
      return;
    }
    this.addStatusUIActionId = formDetail.uiactionId;
  }
  /**
   * 加载节点数据
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:15
   * @protected
   * @return {*}  {Promise<IDataEntity[]>}
   */
  async loadNodes() {
    const res = await this.nodeService.fetchDefault(this.panel.context);
    this.nodeMap.clear();
    if (res.ok && Array.isArray(res.data)) {
      const data = ascSort(res.data, "ordervalue");
      data.forEach((item) => {
        this.nodeMap.set(item.srfkey, item);
      });
      return data;
    }
    return [];
  }
  /**
   * 加载连线数据
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:48
   * @protected
   * @return {*}  {Promise<IDataEntity[]>}
   */
  async loadLinks() {
    const res = await this.linkService.fetchDefault(this.panel.context);
    this.linkMap.clear();
    if (res.ok && Array.isArray(res.data)) {
      const data = res.data;
      data.forEach((item) => {
        this.linkMap.set(item.srfkey, item);
      });
      return data;
    }
    return [];
  }
  /**
   * 获取连线关系映射
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:18
   * @protected
   * @return {*}  {Map<string, Map<string, string>>}
   */
  getConnectionMap() {
    const connectionMap = /* @__PURE__ */ new Map();
    this.state.links.forEach((link) => {
      const source = link.srcpsdelogicnodeid;
      const target = link.dstpsdelogicnodeid;
      if (source && target) {
        const map = connectionMap.get(source) || /* @__PURE__ */ new Map();
        map.set(target, link.srfkey);
        connectionMap.set(source, map);
      }
    });
    return connectionMap;
  }
  /**
   * 生成表格行数据
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:55
   * @protected
   */
  generateRows() {
    const connectionMap = this.getConnectionMap();
    this.state.rows = this.state.nodes.map((source) => {
      const data = {};
      const map = connectionMap.get(source.srfkey);
      this.state.nodes.forEach((target) => {
        if (target.srfkey) {
          const link = map ? map.get(target.srfkey) : void 0;
          data[target.srfkey] = {
            source: source.srfkey,
            target: target.srfkey,
            link,
            isConnected: !!link
          };
        }
      });
      return data;
    });
  }
  /**
   * 加载数据
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:20
   * @return {*}  {Promise<void>}
   */
  async load() {
    this.state.nodes = await this.loadNodes();
    this.state.links = await this.loadLinks();
    this.generateRows();
  }
  /**
   * 更新节点初始状态
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:32
   * @param {IDataEntity} item
   * @return {*}  {Promise<boolean>}
   */
  async updateInitialState(item) {
    const map = /* @__PURE__ */ new Map();
    const nodes = this.state.nodes.filter(
      (node) => node.param9 || node.srfkey === item.srfkey
    );
    nodes.forEach((node) => {
      map.set(node.srfkey, node.param9);
      if (node.srfkey === item.srfkey) {
        node.param9 = 1;
      } else {
        node.param9 = 0;
      }
    });
    const res = await this.nodeService.update(this.panel.context, nodes);
    if (res.ok) {
      return true;
    }
    nodes.forEach((node) => {
      node.param9 = map.get(node.srfkey);
    });
    return false;
  }
  /**
   * 获取排序值
   *
   * @author zhanghengfeng
   * @date 2024-01-26 20:01:07
   * @protected
   * @return {*}  {number}
   */
  getOrderValue() {
    let orderValue = 0;
    this.state.nodes.forEach((item) => {
      if (item.ordervalue) {
        orderValue = Math.max(orderValue, item.ordervalue);
      }
    });
    return orderValue + 10;
  }
  /**
   * 创建节点
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:10
   * @param {MouseEvent} event
   * @return {*}  {Promise<void>}
   */
  async createNode(event) {
    if (!this.addStatusUIActionId) {
      return;
    }
    await UIActionUtil.execAndResolved(
      this.addStatusUIActionId,
      {
        context: this.panel.context,
        params: {
          ...this.panel.params,
          leftpos: 30 * this.state.nodes.length,
          toppos: 70 * this.state.nodes.length,
          ordervalue: this.getOrderValue()
        },
        data: [],
        view: this.panel.view,
        event,
        noWaitRoute: true
      },
      this.model.appId
    );
    await this.load();
  }
  /**
   * 删除节点
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:59
   * @param {IDataEntity} item
   * @return {*}  {Promise<boolean>}
   */
  async removeNode(item) {
    if (!this.nodeModel.codeName) {
      return false;
    }
    const context = clone(this.panel.context);
    context[this.nodeModel.codeName.toLowerCase()] = item.srfkey;
    const res = await this.nodeService.remove(context);
    if (res.ok) {
      this.nodeMap.delete(item.srfkey);
      const index = this.state.nodes.findIndex((node) => {
        return node.srfkey === item.srfkey;
      });
      if (index !== -1) {
        this.state.nodes.splice(index, 1);
        this.state.rows.splice(index, 1);
      }
      return true;
    }
    return false;
  }
  /**
   * 激活节点
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:43
   * @param {IDataEntity} item
   */
  activeNode(item) {
    this.panel.view.call(
      "onActive",
      this.nodeProvider.createDataProvider(item)
    );
  }
  /**
   * 创建连线
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:05
   * @param {X6PanelItemTableLinkData} cell
   * @return {*}  {Promise<boolean>}
   */
  async createLink(cell) {
    const source = cell.source;
    const target = cell.target;
    if (!source || !target) {
      return false;
    }
    const transformData = dataTransformUtil.transform(
      this.getCodeItemData(),
      this.panel.context,
      this.panel.params
    );
    const res = await this.linkService.create(this.panel.context, {
      srcpsdelogicnodeid: source,
      defaultlink: 0,
      dstpsdelogicnodeid: target,
      psdelogiclinkname: "\u8FDE\u63A5\u540D\u79F0",
      ...transformData
    });
    if (res.ok && res.data) {
      const link = res.data;
      this.state.links.push(link);
      this.linkMap.set(link.srfkey, link);
      cell.link = link.srfkey;
      cell.isConnected = true;
      return true;
    }
    cell.isConnected = false;
    return false;
  }
  /**
   * 删除连线
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:23
   * @param {string} key
   * @return {*}  {Promise<boolean>}
   */
  async removeLink(cell) {
    if (!this.linkModel.codeName || !cell.link) {
      return false;
    }
    const context = clone(this.panel.context);
    context[this.linkModel.codeName.toLowerCase()] = cell.link;
    const res = await this.linkService.remove(context);
    if (res.ok) {
      this.linkMap.delete(cell.link);
      cell.link = void 0;
      cell.isConnected = false;
      const index = this.state.links.findIndex((node) => {
        return node.srfkey === cell.link;
      });
      if (index !== -1) {
        this.state.links.splice(index, 1);
      }
      return true;
    }
    cell.isConnected = true;
    return false;
  }
  /**
   * 激活连线
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:50
   * @param {X6PanelItemTableLinkData} cell
   * @return {*}  {void}
   */
  activeLink(cell) {
    if (!cell.link) {
      return;
    }
    const link = this.linkMap.get(cell.link);
    if (link) {
      this.panel.view.call(
        "onActive",
        this.linkProvider.createDataProvider(link)
      );
    }
  }
  destroy() {
    super.destroy();
    this.unsubscribeMessage();
  }
}

export { X6PanelItemTableController };
