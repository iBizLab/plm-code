import { getControl, ButtonContainerState, UIActionButtonState } from '@ibiz-template/runtime';
import { RuntimeModelError } from '@ibiz-template/core';
import { debounce } from 'lodash-es';
import { DndStencilPanelItemController } from '../../panel-items/dnd-stencil/dnd-stencil.controller.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndStencilFieldController extends DndStencilPanelItemController {
  constructor() {
    super(...arguments);
    __publicField(this, "app");
    __publicField(this, "form");
    __publicField(this, "service");
    __publicField(this, "fieldForm");
    __publicField(this, "fieldService");
    __publicField(this, "fieldItems", []);
    __publicField(this, "items", []);
    __publicField(this, "enableGroup", true);
    __publicField(this, "mdCtrlFieldType", [
      "ONE2MANYDATA",
      "ONE2ONEDATA",
      "ONE2MANYDATA_MAP",
      "ONE2MANYOBJ",
      "ONE2ONEOBJ",
      "ONE2MANYOBJ_MAP"
    ]);
  }
  get view() {
    return this.panel.view;
  }
  async onInit() {
    this.app = await ibiz.hub.getApp(this.model.appId);
    const form = getControl(this.panel.view.model, "item");
    if (!form) {
      throw new RuntimeModelError(this.panel.view, "\u672A\u627E\u5230 item \u8868\u5355\u6A21\u578B");
    }
    this.form = form;
    this.service = await this.app.deService.getService(
      this.panel.context,
      form.appDataEntityId
    );
    const fieldForm = getControl(this.panel.view.model, "field");
    if (!fieldForm) {
      throw new RuntimeModelError(this.panel.view, "\u672A\u627E\u5230 field \u8868\u5355\u6A21\u578B");
    }
    this.fieldForm = fieldForm;
    this.fieldService = await this.app.deService.getService(
      this.panel.context,
      fieldForm.appDataEntityId
    );
    const editor = this.model.editor;
    if (editor) {
      const { appCodeListId } = editor;
      if (appCodeListId) {
        this.codeList = this.app.codeList.getCodeList(appCodeListId);
      }
      if (!this.codeList) {
        throw new RuntimeModelError(this.model, "\u672A\u914D\u7F6E\u5C5E\u6027\u9879\u4EE3\u7801\u8868");
      }
    } else {
      ibiz.log.warn("\u62D6\u62FD\u7D20\u6750\u533A\u63A7\u5236\u5668\u7684 editor \u4E3A\u7A7A");
    }
    await this.initButtonGroup();
    this.view.evt.on("onSaveSuccess", async () => {
      await this.load();
    });
    await super.onInit();
    this.debounceTransformFieldItems = debounce(
      this.debounceTransformFieldItems,
      50
    );
    this.subscribeMessage();
  }
  /**
   * 初始化界面行为按钮
   *
   * @author zhanghengfeng
   * @date 2024-01-12 18:01:04
   * @protected
   * @return {*}  {Promise<void>}
   */
  async initButtonGroup() {
    var _a;
    if (this.fieldForm) {
      const pages = this.fieldForm.deformPages;
      if (!Array.isArray(pages) || !pages[0]) {
        ibiz.log.warn("field \u8868\u5355\u6A21\u578B\u672A\u914D\u7F6E\u8868\u5355\u5206\u9875");
        return;
      }
      const page = pages[0];
      const formDetails = page.deformDetails;
      const group = formDetails == null ? void 0 : formDetails.find(
        (item) => item.codeName === "filed_group"
      );
      if (!group) {
        ibiz.log.warn("field \u8868\u5355\u6A21\u578B\u672A\u914D\u7F6E\u6807\u8BC6\u4E3A filed_group \u8868\u5355\u5206\u7EC4");
        return;
      }
      const state = await this.initActionStates(group);
      (_a = this.codeList.codeItems) == null ? void 0 : _a.forEach((item) => {
        if (item.codeName) {
          if (state) {
            this.buttonGroupMap.set(item.codeName, { model: group, state });
          }
        }
      });
    }
  }
  /**
   * 初始化界面行为按钮的状态
   *
   * @author zhanghengfeng
   * @date 2024-01-12 18:01:53
   * @param {IDEFormGroupPanel} model
   * @return {*}  {(Promise<IButtonContainerState | undefined>)}
   */
  async initActionStates(model) {
    var _a;
    const { uiactionGroup } = model;
    if (!((_a = uiactionGroup == null ? void 0 : uiactionGroup.uiactionGroupDetails) == null ? void 0 : _a.length)) {
      return;
    }
    const containerState = new ButtonContainerState();
    uiactionGroup.uiactionGroupDetails.forEach((detail) => {
      const actionid = detail.uiactionId;
      if (actionid) {
        const buttonState = new UIActionButtonState(
          detail.id,
          this.panel.context.srfappid,
          actionid
        );
        containerState.addState(detail.id, buttonState);
      }
    });
    await containerState.update();
    return containerState;
  }
  /**
   * 监听数据更新
   *
   * @author zhanghengfeng
   * @date 2024-02-04 17:02:27
   * @protected
   * @param {IPortalMessage} msg
   */
  onDataUpdate(msg) {
    if (msg.data && typeof msg.data === "object") {
      const data = msg.data;
      if (data.srfkey) {
        const index = this.items.findIndex((item) => item.srfkey === data.srfkey);
        if (index !== -1) {
          this.items[index] = data;
          this.debounceTransformFieldItems();
        }
      }
    }
  }
  /**
   * 监听数据新建
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:06
   * @protected
   * @param {IPortalMessage} msg
   */
  onDataCreate(msg) {
    if (msg.messageid !== this.panel.context.srfsessionid) {
      return;
    }
    if (msg.data && typeof msg.data === "object") {
      const data = msg.data;
      if (data.srfkey) {
        this.items.push(data);
        this.transformFieldItems();
      }
    }
  }
  /**
   * 监听数据删除
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:17
   * @protected
   * @param {IPortalMessage} msg
   */
  onDataRemove(msg) {
    if (msg.data && typeof msg.data === "object") {
      const data = msg.data;
      if (data.srfkey) {
        const index = this.items.findIndex((item) => item.srfkey === data.srfkey);
        if (index !== -1) {
          this.loadItems();
        }
      }
    }
  }
  /**
   * 订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:54
   * @protected
   */
  subscribeMessage() {
    this.onDataUpdate = this.onDataUpdate.bind(this);
    this.onDataCreate = this.onDataCreate.bind(this);
    this.onDataRemove = this.onDataRemove.bind(this);
    ibiz.mc.command.update.on(this.onDataUpdate);
    ibiz.mc.command.create.on(this.onDataCreate);
    ibiz.mc.command.remove.on(this.onDataRemove);
  }
  /**
   * 取消订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:03
   * @protected
   */
  unsubscribeMessage() {
    ibiz.mc.command.update.off(this.onDataUpdate);
    ibiz.mc.command.remove.off(this.onDataRemove);
    ibiz.mc.command.create.off(this.onDataCreate);
  }
  /**
   * 销毁方法
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:29
   */
  destroy() {
    super.destroy();
    this.unsubscribeMessage();
  }
  /**
   * 数据加载
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:35
   * @return {*}  {Promise<void>}
   */
  async load() {
    const res = await this.fieldService.exec("fetchcurde", this.panel.context, {
      n_psdeid_eq: this.view.state.data.psdeid,
      n_usertag4_noteq: "INTENAL"
    });
    this.state.items = this.codeList.codeItems || [];
    if (res.ok && Array.isArray(res.data)) {
      this.fieldItems = res.data;
      await this.loadItems();
    }
  }
  /**
   * 加载数据集
   *
   * @author zhanghengfeng
   * @date 2024-02-04 16:02:27
   * @return {*}  {Promise<void>}
   */
  async loadItems() {
    const result = await this.service.fetchDefault(this.panel.context);
    if (result.ok && Array.isArray(result.data)) {
      this.items = result.data;
      this.transformFieldItems();
    }
  }
  /**
   * 过滤属性项
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:46
   * @protected
   * @return {*}  {IDataEntity[]}
   */
  filterFieldItems() {
    const mdCtrlList = [];
    const data = this.view.state.data;
    const str = this.items.map((item) => {
      if (item.detailtype === "FORMITEM") {
        if (data.formtype === "EDITFORM") {
          return "|".concat(item.psdefid);
        }
        if (data.formtype === "SEARCHFORM") {
          return "|".concat(item.psdefsfitemid);
        }
      }
      if (item.detailtype === "MDCTRL" && item.psdefid) {
        mdCtrlList.push(item.psdefid);
      }
      return "";
    }).join("");
    return this.fieldItems.filter((item) => {
      if (this.mdCtrlFieldType.includes(item.psdatatypeid)) {
        if (!mdCtrlList.includes(item.srfkey)) {
          return true;
        }
        return false;
      }
      if (item.srfkey && str.indexOf("|".concat(item.srfkey)) === -1) {
        return true;
      }
      return false;
    });
  }
  /**
   * 转换属性项
   *
   * @author zhanghengfeng
   * @date 2024-02-04 17:02:39
   * @protected
   */
  debounceTransformFieldItems() {
    this.transformFieldItems();
  }
  /**
   * 转换属性项
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:59
   * @protected
   * @return {*}  {void}
   */
  transformFieldItems() {
    const items = this.filterFieldItems();
    this.state.items.forEach((parent) => {
      parent.codeItems = items.map((item) => {
        let text = item.logicname || item.caption;
        if (item.psdefsfitemname || item.psdefieldname) {
          text += "[".concat(item.psdefsfitemname || item.psdefieldname, "]");
        }
        if (this.view.state.data.formtype === "EDITFORM") {
          return {
            appId: parent.appId,
            text,
            iconPath: parent.iconPath,
            data: JSON.stringify({
              caption: item.logicname,
              logicname: item.logicname,
              psdefid: item.psdefieldid,
              psdefname: item.psdefieldname,
              detailtype: this.mdCtrlFieldType.includes(item.psdatatypeid) ? "MDCTRL" : "FORMITEM",
              formtype: this.view.state.data.formtype
            })
          };
        }
        return {
          appId: parent.appId,
          text,
          iconPath: parent.iconPath,
          data: JSON.stringify({
            caption: item.logicname,
            logicname: item.logicname,
            psdefsfitemid: item.psdefsfitemid,
            psdefsfitemname: item.psdefsfitemname,
            psdefname: item.psdefname,
            psdefid: item.psdefid,
            detailtype: "FORMITEM",
            formtype: this.view.state.data.formtype
          })
        };
      });
    });
    this.codeItems = this.state.items;
    this.filter();
  }
}

export { DndStencilFieldController };
