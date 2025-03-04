import { reactive } from 'vue';
import { RuntimeModelError, RuntimeError } from '@ibiz-template/core';
import { PanelItemController, getControl, getUIActionById, UIActionUtil } from '@ibiz-template/runtime';
import { createUUID, ascSort } from 'qx-util';
import { DndDesignPanelItemState } from './dnd-design.state.mjs';
import '../../utils/index.mjs';
import { modelStateUtil } from '../../utils/model-state-util/model-state-util.mjs';
import { dndProviderRegister } from '../../utils/dnd-provider-register/dnd-provider-register.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndDesignPanelItemController extends PanelItemController {
  constructor() {
    super(...arguments);
    __publicField(this, "service");
    __publicField(this, "form");
    __publicField(this, "providers", {});
    __publicField(this, "controllers", {});
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
    __publicField(this, "showMaskType", [
      "MDCTRL",
      "GROUPPANEL",
      "TABPANEL",
      "TABPAGE",
      "FORMPAGE"
    ]);
  }
  get view() {
    return this.panel.view;
  }
  /**
   * 创建面板状态对象
   *
   * @author zhanghengfeng
   * @date 2025-01-21 19:01:03
   * @protected
   * @return {*}  {DndDesignPanelItemState}
   */
  createState() {
    var _a;
    return new DndDesignPanelItemState((_a = this.parent) == null ? void 0 : _a.state);
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
    this.view.evt.on("onSaveSuccess", async () => {
      await this.load();
      this.state.uuid = createUUID();
    });
    this.view.evt.on("onStencilAdd", async (e) => {
      var _a;
      if (!e || !e.stencil) {
        return;
      }
      const id = (_a = this.view.select.data) == null ? void 0 : _a.srfkey;
      this.handleStencilAdd(e.stencil, id);
    });
    await this.load();
    this.subscribeMessage();
  }
  /**
   * 处理素材添加
   *
   * @author zhanghengfeng
   * @date 2025-02-12 22:02:48
   * @param {IData} stencil
   * @param {string} [id]
   * @param {IDataEntity} [child]
   * @return {*}  {void}
   */
  handleStencilAdd(stencil, id, child) {
    if (!id) {
      return;
    }
    const parent = this.items.find((item) => item.srfkey === id);
    if (!parent) {
      return;
    }
    const type = parent.srftype;
    if (!type) {
      return;
    }
    const container = [
      "GROUPPANEL",
      "FORMPAGE",
      "TABPAGE",
      "TABPANEL",
      "MDCTRL"
    ];
    if (!container.includes(type)) {
      this.handleStencilAdd(stencil, parent.srfpkey, child || parent);
      return;
    }
    if (type === "TABPANEL") {
      return;
    }
    if (type === "MDCTRL" && parent.mdctrltype !== "REPEATER") {
      return;
    }
    const children = parent.children || [];
    let newIndex = children.length;
    if (child) {
      const index = children.findIndex((item) => item.srfkey === child.srfkey);
      if (index !== -1) {
        newIndex = index + 1;
      }
    }
    this.add(
      {
        added: {
          element: stencil,
          newIndex
        }
      },
      children,
      parent
    );
  }
  /**
   * 更新逻辑映射map
   *
   * @author zhanghengfeng
   * @date 2025-02-12 22:02:38
   * @protected
   * @return {*}  {Promise<void>}
   */
  async updateLogicMap() {
    const appId = this.view.context.srfappid;
    if (!appId) {
      return;
    }
    const app = ibiz.hub.getApp(appId);
    if (!app) {
      return;
    }
    const entity = await ibiz.hub.getAppDataEntity("PSDEFDLogic", appId);
    if (!entity) {
      return;
    }
    const service = await app.deService.getService(
      this.view.context,
      entity.id
    );
    if (!service) {
      return;
    }
    const res = await service.fetchDefault(this.view.context);
    const map = {};
    if (res && Array.isArray(res.data)) {
      res.data.forEach((item) => {
        const key = item.psdeformdetailid;
        if (map[key]) {
          map[key] += 1;
        } else {
          map[key] = 1;
        }
      });
    }
    this.state.logicMap = map;
  }
  /**
   * 监听数据变化
   *
   * @author zhanghengfeng
   * @date 2025-02-12 22:02:29
   * @protected
   * @param {IPortalMessage} msg
   */
  onDEDataChange(msg) {
    if (msg && msg.data && typeof msg.data === "object") {
      const data = msg.data;
      if (data.srfdecodename === "PSDEFDLogic") {
        this.updateLogicMap();
      }
    }
  }
  /**
   * 打开逻辑视图
   *
   * @author zhanghengfeng
   * @date 2025-02-12 22:02:40
   * @param {IDataEntity} item
   * @return {*}  {Promise<void>}
   */
  async openLogicView(item) {
    if (!item) {
      return;
    }
    const structure = getControl(
      this.view.model,
      "structuretoolbar"
    );
    if (!structure) {
      return;
    }
    const toolbarItems = structure.detoolbarItems || [];
    if (toolbarItems && toolbarItems.length) {
      const action = toolbarItems.find((toolbarItem) => {
        if (item.srftype === "FORMITEM" || item.srftype === "FORMITEMEX") {
          return toolbarItem.id === "formitem";
        }
        return toolbarItem.id === "default";
      });
      if (action && action.itemType === "DEUIACTION") {
        const actionId = action.uiactionId;
        if (!actionId) {
          return;
        }
        const uiAction = await getUIActionById(actionId, action.appId);
        if (!uiAction) {
          throw new RuntimeError(
            ibiz.i18n.t("runtime.controller.control.toolbar.noFound", {
              actionId
            })
          );
        }
        const context = this.view.context.clone();
        delete context.srfrunmode;
        const modelState = this.getModelState(item);
        if (!modelStateUtil.isEnableUpdate(modelState)) {
          context.srfreadonly = true;
        }
        await UIActionUtil.execAndResolved(
          actionId,
          {
            context,
            params: this.view.params,
            data: [item],
            view: this.view
          },
          action.appId
        );
      }
    }
  }
  /**
   * 更新隐藏表单项可见性
   *
   * @author zhanghengfeng
   * @date 2024-06-05 13:06:07
   * @param {boolean} value
   */
  updateHiddenFormItemVisible(value) {
    this.state.hiddenFormItemVisible = value;
  }
  /**
   * 监听数据变化
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:35
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
          this.removeController(this.items[index]);
          this.items.splice(index, 1, data);
          this.initItem(data);
          if (this.timer) {
            window.clearTimeout(this.timer);
          }
          this.timer = window.setTimeout(() => {
            this.recalculateDeppItems();
          }, 50);
        }
      }
    }
  }
  /**
   * 发送消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:47
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
   * 刷新
   *
   * @author zhanghengfeng
   * @date 2024-12-30 21:12:42
   * @return {*}  {Promise<void>}
   */
  async refresh() {
    await this.load();
    this.state.uuid = createUUID();
  }
  /**
   * 订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:59
   */
  subscribeMessage() {
    this.onDataUpdate = this.onDataUpdate.bind(this);
    this.onDEDataChange = this.onDEDataChange.bind(this);
    this.refresh = this.refresh.bind(this);
    this.view.evt.on("onRefreshView", this.refresh);
    ibiz.mc.command.update.on(this.onDataUpdate);
    ibiz.mc.command.change.on(this.onDEDataChange);
  }
  /**
   * 取消订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:13
   */
  unsubscribeMessage() {
    this.view.evt.off("onRefreshView", this.refresh);
    ibiz.mc.command.update.off(this.onDataUpdate);
    ibiz.mc.command.change.off(this.onDEDataChange);
  }
  /**
   * 销毁方法
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:26
   */
  destroy() {
    super.destroy();
    this.unsubscribeMessage();
  }
  /**
   * 初始化数据项
   *
   * @author chitanda
   * @date 2023-12-21 11:12:17
   * @protected
   * @param {IDataEntity} item
   * @return {*}  {Promise<void>}
   */
  async initItem(item) {
    if (item.srftype === "FORMPAGE") {
      return;
    }
    const type = "".concat(item.srfdecodename, "_").concat(item.srftype);
    const provider = dndProviderRegister.getItemProvider(type);
    const c = provider.createController(this, this.form, item);
    this.providers[item.srfkey] = provider;
    this.controllers[item.srfkey] = c;
  }
  /**
   * 加载项数据，并初始化适配器相关
   *
   * @author chitanda
   * @date 2023-12-18 16:12:27
   * @protected
   * @return {*}  {Promise<void>}
   */
  async load() {
    await this.updateLogicMap();
    const result = await this.service.fetchDefault(this.panel.context);
    this.items = result.data;
    this.items.forEach((item) => {
      this.initItem(item);
    });
    this.state.items = this.calcDeepItems(this.items);
  }
  /**
   * 重新计算现有数据的递归结构
   *
   * @author chitanda
   * @date 2023-12-28 15:12:31
   */
  recalculateDeppItems() {
    this.state.items = this.calcDeepItems(this.items);
  }
  /**
   * 计算递归数据，用于渲染树界面
   *
   * @author chitanda
   * @date 2023-12-15 16:12:32
   * @protected
   * @param {IDataEntity[]} items
   * @param {IDataEntity} [parent]
   * @return {*}  {IDataEntity[]}
   */
  calcDeepItems(items, parent) {
    const list = [];
    items.filter((item) => {
      if (parent == null) {
        return item.srfpkey == null;
      }
      return item.srfpkey === parent.srfkey;
    }).forEach((item) => {
      list.push(item);
      let children = this.calcDeepItems(items, item);
      if (children.length > 0) {
        children = ascSort(children, "srfordervalue");
        item.children = reactive(children);
      } else {
        item.children = reactive([]);
      }
    });
    return list;
  }
  /**
   * 拖拽放生变更
   *
   * @author chitanda
   * @date 2023-12-21 11:12:03
   * @param {IData} evt
   * @param {IDataEntity[]} items
   * @param {IDataEntity} [parent]
   */
  change(evt, items, parent) {
    if (evt) {
      const { added, moved } = evt;
      if (added && added.element) {
        const item = added.element;
        if (!item.srfkey || Object.is(item.srfkey, "")) {
          items.splice(added.newIndex, 1);
          this.add(evt, items, parent);
        } else {
          if (parent) {
            item.srfpkey = parent.srfkey;
          } else {
            item.srfpkey = void 0;
          }
          this.move(items, 0, items.length - 1);
        }
      } else if (moved && moved.element) {
        this.move(items, 0, items.length - 1);
      }
    }
  }
  /**
   * 新增一个项
   *
   * @author chitanda
   * @date 2023-12-21 11:12:53
   * @protected
   * @param {IData} evt
   * @param {IDataEntity[]} items
   * @param {IDataEntity} [parent]
   * @return {*}  {Promise<void>}
   */
  async add(evt, items, parent) {
    const index = evt.added.newIndex;
    const item = evt.added.element;
    const res = await this.service.getDraft(this.panel.context, item);
    if (res.ok) {
      const { data } = res;
      if (item.caption && this.panel.context.srfrunmode === "DESIGN") {
        item.caption = void 0;
      }
      Object.assign(data, item);
      data.srfordervalue = (index + 1) * 10;
      if (parent) {
        data.srfpkey = parent.srfkey;
      }
      const res2 = await this.service.create(this.panel.context, data);
      if (res2.ok) {
        const data2 = res2.data;
        data2.children = reactive([]);
        await this.initItem(data2);
        this.items.push(data2);
        this.sendMessage([data2], void 0, {
          messageid: this.panel.context.srfsessionid,
          messagename: "command",
          type: "COMMAND",
          subtype: "OBJECTCREATED"
        });
        items.splice(index, 0, data2);
        this.view.select.set(res2.data);
        await this.move(items, index, items.length - 1);
      }
    }
  }
  /**
   * 节点排序并更新
   *
   * @author chitanda
   * @date 2023-12-21 11:12:25
   * @protected
   * @param {IDataEntity[]} items
   * @param {number} oldIndex
   * @param {number} newIndex
   * @return {*}  {Promise<void>}
   */
  async move(items, oldIndex, newIndex) {
    const start = 0;
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
  /**
   * 删除项
   *
   * @author chitanda
   * @date 2024-01-03 15:01:19
   * @param {IDataEntity[]} items
   * @param {IDataEntity} item
   * @return {*}  {Promise<boolean>}
   */
  async remove(items, item) {
    const res = await this.service.remove(this.panel.context, {}, item);
    if (res.ok) {
      const index = this.items.findIndex((it) => it.srfkey === item.srfkey);
      const index2 = items.findIndex((it) => it.srfkey === item.srfkey);
      if (index > -1) {
        this.items.splice(index, 1);
        items.splice(index2, 1);
        this.removeController(item);
        this.sendMessage([item], "OBJECTREMOVED");
        const select = items[0] || this.items.find((it) => it.srfkey === item.srfpkey);
        if (select) {
          this.view.select.set(select);
        } else {
          this.view.call("onActiveRoot");
        }
        this.recalculateDeppItems();
      }
      return true;
    }
    return false;
  }
  /**
   * 删除项控制器实例
   *
   * @author chitanda
   * @date 2024-01-03 16:01:04
   * @protected
   * @param {IDataEntity} item
   */
  removeController(item) {
    if (item.srftype === "FORMPAGE") {
      return;
    }
    const c = this.controllers[item.srfkey];
    c.destroy();
    delete this.controllers[item.srfkey];
  }
  /**
   * 获取模型状态
   *
   * @author zhanghengfeng
   * @date 2024-04-23 20:04:49
   * @param {IDataEntity} entity
   * @return {*}  {number}
   */
  getModelState(entity) {
    let modelState = 0;
    let current = entity;
    while (current) {
      if (current.modelstate) {
        modelState = current.modelstate;
        break;
      }
      let isChange = false;
      const key = current.srfpkey;
      if (key) {
        const parent = this.controllers[key];
        if (parent) {
          current = parent.data;
          isChange = true;
        } else {
          const parent2 = this.items.find((item) => item.srfkey === key);
          if (parent2) {
            current = parent2;
            isChange = true;
          }
        }
      }
      if (!isChange) {
        break;
      }
    }
    return modelState;
  }
  isShowMask(entity) {
    if (!entity) {
      return false;
    }
    const modelState = entity.modelstate;
    const mask = modelStateUtil.isEnablePlaceholder(modelState) && this.showMaskType.includes(entity.srftype);
    if (!mask) {
      return mask;
    }
    let current = entity;
    let mask2 = false;
    while (current) {
      let isChange = false;
      const key = current.srfpkey;
      if (key) {
        const parent = this.controllers[key];
        if (parent) {
          current = parent.data;
          mask2 = modelStateUtil.isEnablePlaceholder(current.modelstate) && this.showMaskType.includes(current.srftype) || mask2;
          isChange = true;
        } else {
          const parent2 = this.items.find((item) => item.srfkey === key);
          if (parent2) {
            current = parent2;
            mask2 = modelStateUtil.isEnablePlaceholder(current.modelstate) && this.showMaskType.includes(current.srftype) || mask2;
            isChange = true;
          }
        }
      }
      if (!isChange) {
        break;
      }
    }
    return !mask2;
  }
}

export { DndDesignPanelItemController };
