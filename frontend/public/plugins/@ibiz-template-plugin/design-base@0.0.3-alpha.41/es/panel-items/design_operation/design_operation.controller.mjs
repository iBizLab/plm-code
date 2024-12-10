import { debounce } from 'lodash-es';
import { PanelItemController, getControl } from '@ibiz-template/runtime';
import { generateOrderValue } from 'qx-util';
import { DesignOperationState } from './design_operation.state.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DesignOperationController extends PanelItemController {
  constructor() {
    super(...arguments);
    /**
     * 主数据服务
     *
     * @author tony001
     * @date 2024-09-10 16:09:23
     * @protected
     * @type {IAppDEService}
     */
    __publicField(this, "majorService");
    /**
     * 子项数据服务
     *
     * @author tony001
     * @date 2024-09-10 16:09:43
     * @protected
     * @type {IAppDEService}
     */
    __publicField(this, "itemService");
    /**
     * 主实体
     *
     * @author tony001
     * @date 2024-09-10 16:09:53
     * @protected
     * @type {IAppDataEntity}
     */
    __publicField(this, "majorEntity");
    /**
     * 从实体
     *
     * @author tony001
     * @date 2024-09-10 16:09:07
     * @protected
     * @type {IAppDataEntity}
     */
    __publicField(this, "itemEntity");
    /**
     * 类型属性
     *
     * @author tony001
     * @date 2024-09-10 16:09:21
     * @protected
     * @type {string}
     */
    __publicField(this, "typeKeyName", "itemtype");
    /**
     * 子项实体主键名称
     *
     * @author tony001
     * @date 2024-09-10 16:09:31
     * @protected
     * @type {string}
     */
    __publicField(this, "itemEntityKeyName", "");
    /**
     * 可新建项
     *
     * @author tony001
     * @date 2024-09-10 16:09:04
     * @protected
     * @type {INewItem[]}
     */
    __publicField(this, "newItems", []);
    /**
     * 规则数据
     *
     * @author tony001
     * @date 2024-09-10 16:09:18
     * @protected
     * @type {*}
     */
    __publicField(this, "ruleData");
    /**
     * 根路径默认参数
     *
     * @author tony001
     * @date 2024-09-10 16:09:31
     * @protected
     * @type {*}
     */
    __publicField(this, "defaultRoot", null);
    /**
     * 绘制树引用
     *
     * @author tony001
     * @date 2024-09-10 16:09:40
     * @protected
     * @type {*}
     */
    __publicField(this, "treeRef");
  }
  /**
   * 视图对象
   *
   * @author tony001
   * @date 2024-09-10 16:09:22
   * @readonly
   * @type {DesignViewControllerBase<
   *     IAppView,
   *     IDesignViewState,
   *     IDesignViewEvent
   *   >}
   */
  get view() {
    return this.panel.view;
  }
  /**
   * 主表单
   *
   * @author tony001
   * @date 2024-09-10 16:09:37
   * @readonly
   * @type {IDEEditForm}
   */
  get majorForm() {
    return getControl(this.view.model, "form");
  }
  /**
   * 项表单
   *
   * @author tony001
   * @date 2024-09-10 16:09:45
   * @readonly
   * @type {IDEEditForm}
   */
  get itemForm() {
    return getControl(this.view.model, "item");
  }
  /**
   * 创建面板状态对象
   *
   * @author tony001
   * @date 2024-09-10 16:09:33
   * @protected
   * @return {*}  {DesignOperationState}
   */
  createState() {
    var _a;
    return new DesignOperationState((_a = this.parent) == null ? void 0 : _a.state);
  }
  /**
   * 初始化
   *
   * @author tony001
   * @date 2024-09-10 16:09:00
   * @protected
   * @return {*}  {Promise<void>}
   */
  async onInit() {
    var _a;
    await super.onInit();
    this.state.activeNode = ((_a = this.view.select.data) == null ? void 0 : _a.id) || "";
    await this.initBaseResource();
    this.initUserParam();
    await this.load();
    await this.subscribeDataChange();
  }
  /**
   * 初始化基础资源
   *
   * @author tony001
   * @date 2024-09-10 16:09:29
   * @protected
   * @return {*}  {Promise<void>}
   */
  async initBaseResource() {
    var _a;
    const app = ibiz.hub.getApp(this.view.model.appId);
    this.majorEntity = await ibiz.hub.getAppDataEntity(
      this.majorForm.appDataEntityId,
      this.view.model.appId
    );
    this.majorService = await app.deService.getService(
      this.panel.context,
      this.majorForm.appDataEntityId
    );
    this.itemEntity = await ibiz.hub.getAppDataEntity(
      this.itemForm.appDataEntityId,
      this.view.model.appId
    );
    this.itemEntityKeyName = "".concat((_a = this.itemEntity) == null ? void 0 : _a.codeName.toLowerCase(), "id");
    this.itemService = await app.deService.getService(
      this.panel.context,
      this.itemForm.appDataEntityId
    );
  }
  /**
   * 订阅数据变化
   *
   * @author tony001
   * @date 2024-09-10 17:09:50
   * @protected
   * @return {*}  {Promise<void>}
   */
  async subscribeDataChange() {
    this.refresh = this.refresh.bind(this);
    this.onDEDataChange = debounce(this.onDEDataChange.bind(this), 200);
    this.view.evt.on("onUpdateSuccess", this.refresh);
    this.view.evt.on("onCreateSuccess", this.refresh);
    this.view.evt.on("onRemoveSuccess", this.refresh);
    this.view.evt.on("onSaveSuccess", this.refresh);
    ibiz.mc.command.change.on(this.onDEDataChange);
    this.onSelectDataChange = this.onSelectDataChange.bind(this);
    this.view.select.on(this.onSelectDataChange);
  }
  /**
   * 取消订阅数据变化
   *
   * @author tony001
   * @date 2024-09-10 17:09:13
   * @protected
   * @return {*}  {Promise<void>}
   */
  async unSubscribeDataChange() {
    this.view.evt.off("onUpdateSuccess", this.refresh);
    this.view.evt.off("onCreateSuccess", this.refresh);
    this.view.evt.off("onRemoveSuccess", this.refresh);
    this.view.evt.off("onSaveSuccess", this.refresh);
    ibiz.mc.command.change.off(this.onDEDataChange);
    this.view.select.off(this.onSelectDataChange);
  }
  /**
   * 初始化用户参数
   *
   * @author tony001
   * @date 2024-09-10 16:09:41
   * @protected
   */
  initUserParam() {
    const userParam = this.majorForm.userParam;
    if (userParam) {
      this.typeKeyName = userParam.fileType;
      try {
        this.ruleData = (userParam == null ? void 0 : userParam.ruleData) ? JSON.parse(userParam.ruleData) : {};
        this.newItems = (userParam == null ? void 0 : userParam.newItems) ? JSON.parse(userParam.newItems) : [];
        this.defaultRoot = (userParam == null ? void 0 : userParam.defaultRoot) ? JSON.parse(userParam.defaultRoot) : {};
        if (this.ruleData) {
          const rules = /* @__PURE__ */ new Map();
          for (const key in this.ruleData) {
            rules.set(key, new RegExp(this.ruleData[key]));
          }
          this.state.rules = rules;
        }
      } catch (error) {
        ibiz.log.error("JSON\u5E8F\u5217\u5316\u51FA\u9519!".concat(error));
      }
    }
  }
  /**
   * 加载数据
   *
   * @author tony001
   * @date 2024-09-10 16:09:39
   * @protected
   * @return {*}  {Promise<void>}
   */
  async load() {
    const majorResult = await this.majorService.getTemp(
      this.panel.context,
      this.panel.params
    );
    let majorData = {};
    let itemDatas = [];
    if (majorResult.ok && majorResult.data) {
      majorData = majorResult.data;
    }
    if (majorData) {
      const itemResult = await this.itemService.fetchDefault(
        this.panel.context,
        this.panel.params
      );
      if (itemResult.ok && itemResult.data) {
        itemDatas = itemResult.data;
      }
    }
    await this.afterLoad({ majorData, itemDatas });
  }
  /**
   * 加载之后
   *
   * @protected
   * @memberof GridDesignOperationController
   */
  async afterLoad(args) {
    const { majorData, itemDatas } = args;
    const rootData = {};
    if (majorData) {
      const rootNode = this.generateTreeNode(majorData);
      Object.assign(rootData, { ...rootNode, children: [] });
    }
    if (itemDatas && itemDatas.length > 0) {
      this.state.items = itemDatas;
      itemDatas.forEach((item) => {
        if (!item["p".concat(this.itemEntityKeyName)]) {
          const node = this.generateTreeNode(item);
          this.calcTreeNodes(itemDatas, node);
          rootData.children.push(node);
        }
      });
    }
    this.state.treeData.length = 0;
    this.state.treeData.push(rootData);
    if (this.treeRef) {
      this.treeRef.expandAll();
    }
  }
  /**
   * 刷新
   *
   * @author tony001
   * @date 2024-09-10 17:09:48
   * @protected
   * @return {*}  {Promise<void>}
   */
  async refresh() {
    var _a;
    await this.load();
    if ((_a = this.view.select.data) == null ? void 0 : _a.id) {
      const data = this.state.items.find(
        (item) => {
          var _a2;
          return item.srfkey === ((_a2 = this.view.select.data) == null ? void 0 : _a2.id);
        }
      );
      if (!data) {
        this.panel.view.call("onActiveRoot");
      }
    }
  }
  /**
   * 选中数据变化
   *
   * @author tony001
   * @date 2024-09-10 17:09:57
   * @protected
   * @param {(IData | null)} [data]
   */
  onSelectDataChange(data) {
    this.state.activeNode = (data == null ? void 0 : data.id) || "";
  }
  /**
   * 监听数据变化
   *
   * @author tony001
   * @date 2024-09-10 17:09:49
   * @protected
   * @param {IPortalMessage} msg
   */
  onDEDataChange(msg) {
    const { data } = msg;
    if (data && data.srfdecodename) {
      const triggerDECodeName = data.srfdecodename;
      if (triggerDECodeName === this.itemEntity.codeName || triggerDECodeName === this.majorEntity.codeName) {
        this.refresh();
      }
    }
  }
  /**
   * 生成树节点
   *
   * @author tony001
   * @date 2024-09-10 16:09:22
   * @protected
   * @param {IData} data
   * @return {*}  {ITreeNode}
   */
  generateTreeNode(data) {
    const type = data[this.typeKeyName];
    const newItem = this.newItems.find((item) => item.type === type);
    let icon = "";
    if (newItem) {
      icon = newItem.icon;
    }
    if (data.hiddenitem === 1) {
      icon = "eye-off-outline";
    }
    if (data.enablemode === 0) {
      icon = "ban-outline";
    }
    const param = {
      id: data.srfkey,
      label: data.text,
      type: data.itemtype,
      icon,
      data
    };
    return param;
  }
  /**
   * 递归计算树结构数据
   *
   * @author tony001
   * @date 2024-09-10 16:09:31
   * @protected
   * @param {any[]} items
   * @param {ITreeNode} p
   */
  calcTreeNodes(items, p) {
    if (items) {
      p.children = [];
      items.forEach((item) => {
        const pk = "p".concat(this.itemEntityKeyName);
        if (item[pk] != null && item[pk] === p.id) {
          const data = this.generateTreeNode(item);
          p.children.push(data);
          this.calcTreeNodes(items, data);
        }
      });
    }
  }
  /**
   * 设置树引用
   *
   * @author tony001
   * @date 2024-09-10 17:09:25
   * @param {*} treeRef
   */
  setTreeRef(treeRef) {
    this.treeRef = treeRef;
  }
  /**
   * 树节点选中
   *
   * @author tony001
   * @date 2024-09-10 17:09:47
   * @param {ITreeNode} data
   * @param {IData} node
   */
  onNodeSelect(data, node) {
    const sourceData = data.data;
    if (node.level === 1) {
      this.view.call("onActiveRoot");
    } else {
      this.view.call("onActive", {
        id: sourceData.srfkey,
        label: sourceData.srfmajortext,
        type: sourceData.itemtype,
        data: sourceData
      });
    }
  }
  /**
   * 树节点行为项点击
   *
   * @author tony001
   * @date 2024-09-10 17:09:10
   * @param {MouseEvent} e
   * @param {IActionItem} action
   * @param {IData} [data]
   * @return {*}  {void}
   */
  onActionClick(e, action, data) {
    const { type } = action;
    switch (type) {
      case "add":
        this.createItem(e, data);
        return;
      case "remove":
        this.remove(data);
        return;
      default:
        ibiz.log.error("".concat(type, "\u7C7B\u578B\u6682\u4E0D\u652F\u6301"));
    }
  }
  /**
   * 打开新建项
   *
   * @author tony001
   * @date 2024-09-10 17:09:52
   * @protected
   * @param {MouseEvent} e
   * @param {IData} data
   * @return {*}  {Promise<void>}
   */
  async createItem(e, data) {
    throw new Error("Method not implemented.");
  }
  /**
   * 新建
   *
   * @author tony001
   * @date 2024-09-10 17:09:36
   * @protected
   * @param {IData} data
   * @return {*}  {Promise<void>}
   */
  async create(data) {
    const result = await this.itemService.createTemp(this.panel.context, data);
    if (result.ok && Array.isArray(result.data)) {
      this.view.evt.emit("onCreateSuccess", void 0);
      const item = result.data[result.data.length - 1];
      if (item) {
        this.view.call("onActive", {
          id: item.srfkey,
          label: item.srfmajortext,
          type: item.itemtype,
          data: item
        });
      }
    } else {
      ibiz.log.error("\u65B0\u5EFA\u8868\u683C\u5217\u5931\u8D25");
    }
  }
  /**
   * 删除
   *
   * @author tony001
   * @date 2024-09-10 17:09:45
   * @protected
   * @param {IData} data
   * @return {*}  {Promise<void>}
   */
  async remove(data) {
    var _a;
    const tempContext = this.panel.context.clone();
    Object.assign(tempContext, {
      [this.itemEntity.codeName.toLowerCase()]: data[this.itemEntityKeyName]
    });
    const res = await this.itemService.remove(
      tempContext,
      this.panel.params,
      data
    );
    if (res.ok) {
      this.view.evt.emit("onRemoveSuccess", void 0);
      if (((_a = this.view.select.data) == null ? void 0 : _a.id) === (data == null ? void 0 : data.srfkey)) {
        this.panel.view.call("onActiveRoot");
      }
    } else {
      ibiz.message.error("\u5220\u9664\u5931\u8D25!");
    }
  }
  /**
   * 节点拖拽完成
   *
   * @author tony001
   * @date 2024-09-10 17:09:44
   * @param {IData} draggingNode
   * @param {IData} dropNode
   * @param {string} dropType
   * @return {*}  {Promise<void>}
   */
  async onNodeDrop(draggingNode, dropNode, dropType) {
    var _a;
    let parent = dropNode.parent;
    if (dropType === "inner") {
      parent = dropNode;
    }
    const pData = (_a = parent == null ? void 0 : parent.data) == null ? void 0 : _a.data;
    const updateFn = async (data, index) => {
      var _a2, _b;
      data.ordervalue = generateOrderValue(index);
      data.srfordervalue = data.ordervalue;
      if (!(this.panel.context[this.majorEntity.codeName.toLowerCase()] === (pData == null ? void 0 : pData.srfkey))) {
        data["p".concat((_a2 = this.itemEntity.codeName) == null ? void 0 : _a2.toLowerCase(), "id")] = pData.srfkey;
      } else {
        data["p".concat((_b = this.itemEntity.codeName) == null ? void 0 : _b.toLowerCase(), "id")] = null;
        data.srfpmajortext = null;
      }
      await this.itemService.update(this.panel.context, data);
    };
    if (parent && parent.childNodes.length > 0) {
      for (let i = 0; i < parent.childNodes.length; i++) {
        const { data } = parent.childNodes[i].data;
        await updateFn(data, i);
      }
    }
    this.view.evt.emit("onUpdateSuccess", void 0);
  }
  /**
   * 销毁
   *
   * @author tony001
   * @date 2024-09-10 17:09:47
   */
  destroy() {
    super.destroy();
    this.unSubscribeDataChange();
  }
}

export { DesignOperationController };
