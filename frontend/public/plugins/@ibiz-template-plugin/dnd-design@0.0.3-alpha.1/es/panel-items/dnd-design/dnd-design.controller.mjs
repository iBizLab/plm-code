import { reactive } from 'vue';
import { RuntimeModelError } from '@ibiz-template/core';
import { PanelItemController, getControl } from '@ibiz-template/runtime';
import { createUUID, ascSort } from 'qx-util';
import '../../utils/index.mjs';
import { dndProviderRegister } from '../../utils/dnd-provider-register/dnd-provider-register.mjs';
import { modelStateUtil } from '../../utils/model-state-util/model-state-util.mjs';

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
    await this.load();
    this.subscribeMessage();
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
   * 订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:59
   */
  subscribeMessage() {
    this.onDataUpdate = this.onDataUpdate.bind(this);
    ibiz.mc.command.update.on(this.onDataUpdate);
  }
  /**
   * 取消订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:13
   */
  unsubscribeMessage() {
    ibiz.mc.command.update.off(this.onDataUpdate);
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
          const { oldIndex, newIndex } = added;
          this.move(items, oldIndex, newIndex);
        }
      } else if (moved && moved.element) {
        const { oldIndex, newIndex } = moved;
        this.move(items, oldIndex, newIndex);
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
