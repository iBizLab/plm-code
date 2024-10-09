import { getPFPlugin } from '@ibiz-template/runtime';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class CellProviderImpl {
  constructor(model) {
    __publicField(this, "model");
    __publicField(this, "pluginConfig");
    __publicField(this, "app");
    __publicField(this, "entityModel");
    __publicField(this, "deService");
    __publicField(this, "codeItems", []);
    __publicField(this, "codeItemMap", /* @__PURE__ */ new Map());
    __publicField(this, "initialized", false);
    this.model = model;
    this.pluginConfig = getPFPlugin(
      this.model.sysPFPluginId,
      this.model.appId
    );
    this.app = ibiz.hub.getApp(model.appId);
  }
  async init(context, params) {
    if (this.initialized) {
      return;
    }
    await this.initCodeItems(context, params);
    this.initialized = true;
  }
  async initCodeItems(context, params) {
    const pages = this.model.deformPages;
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
      const codeItems = [];
      codeListItems.forEach((item) => {
        codeItems.push(item);
        if (item.value) {
          this.codeItemMap.set(item.value, item);
        }
        if (Array.isArray(item.children)) {
          item.children.forEach((child) => {
            codeItems.push(child);
            if (child.value) {
              this.codeItemMap.set(child.value, child);
            }
          });
        }
      });
      this.codeItems = codeItems;
    }
  }
  async select(context, params) {
    const deService = await this.getDeService(context);
    const res = await deService.fetchDefault(context, params);
    return res.data || [];
  }
  /**
   * 获取当前节点对应的应用实体模型
   *
   * @author chitanda
   * @date 2023-11-23 15:11:04
   * @protected
   * @return {*}  {Promise<IAppDataEntity>}
   */
  async getAppDataEntity() {
    if (!this.entityModel) {
      this.entityModel = await ibiz.hub.getAppDataEntity(
        this.model.appDataEntityId,
        this.model.appId
      );
    }
    return this.entityModel;
  }
  /**
   * 获取当前表单对应实体的数据服务
   *
   * @author chitanda
   * @date 2023-11-21 15:11:48
   * @protected
   * @return {*}  {Promise<IAppDEService>}
   */
  async getDeService(context) {
    if (!this.deService) {
      this.deService = await this.app.deService.getService(
        context,
        this.model.appDataEntityId
      );
    }
    return this.deService;
  }
}

export { CellProviderImpl };
