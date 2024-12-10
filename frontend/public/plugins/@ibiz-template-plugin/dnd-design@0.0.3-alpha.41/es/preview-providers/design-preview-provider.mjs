import { notNilEmpty, isNilOrEmpty } from 'qx-util';
import { getControl } from '@ibiz-template/runtime';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndDesignPreViewProvider {
  constructor() {
    /**
     * 界面模式集合
     *
     * @author tony001
     * @date 2024-09-06 15:09:40
     * @type {IData[]}
     */
    __publicField(this, "uiModes", []);
    /**
     * 属性字段集合
     *
     * @author tony001
     * @date 2024-09-06 15:09:56
     * @type {IData[]}
     */
    __publicField(this, "fields", []);
  }
  /**
   * 初始化
   *
   * @author tony001
   * @date 2024-09-06 15:09:09
   * @param {IViewController} view
   * @return {*}  {Promise<void>}
   */
  async init(view) {
    const viewModel = view.model;
    const app = ibiz.hub.getApp(viewModel.appId);
    const psdeid = view.context.psdataentity;
    const uimode = getControl(viewModel, "uimode");
    if (uimode) {
      const uiModeService = await app.deService.getService(
        view.context,
        uimode.appDataEntityId
      );
      const uiModeResult = await uiModeService.fetchDefault(view.context, {
        n_psdeid_eq: psdeid,
        size: 1e3
      });
      if (uiModeResult.ok && uiModeResult.data) {
        this.uiModes = uiModeResult.data;
      }
    }
    const field = getControl(viewModel, "field");
    if (field) {
      const deFieldService = await app.deService.getService(
        view.context,
        field.appDataEntityId
      );
      const deFieldResult = await deFieldService.fetchDefault(view.context, {
        size: 1e3
      });
      if (deFieldResult.ok && deFieldResult.data) {
        this.fields = deFieldResult.data;
      }
    }
  }
  /**
   * 查找指定项界面模式
   *
   * @author tony001
   * @date 2024-09-06 15:09:39
   * @protected
   * @param {IData} item
   * @return {*}  {(IData | undefined)}
   */
  findUIMode(item) {
    const psdefuimode = this.uiModes.find((uiModel) => {
      if (item.formtype === "SEARCHFORM" && item.psdefsfitemid === uiModel.psdefsfitemid || item.formtype === "EDITFORM" && item.psdefid === uiModel.psdefid) {
        return uiModel;
      }
    });
    return psdefuimode;
  }
  /**
   * 获取表单项预览数据
   *
   * @author tony001
   * @date 2024-09-06 15:09:06
   * @private
   * @param {IData} item
   * @return {*}  {IData}
   */
  getFormItemPreviewData(item) {
    if (item.detailtype === "FORMITEM" && notNilEmpty(item.psdefid)) {
      const psDEFUIMode = this.findUIMode(item);
      if (psDEFUIMode) {
        if (isNilOrEmpty(item.caption) && psDEFUIMode.caption) {
          item.caption = psDEFUIMode.caption;
        }
        if (isNilOrEmpty(item.editortype) && psDEFUIMode.editortype) {
          item.editortype = psDEFUIMode.editortype;
        }
        if (isNilOrEmpty(item.ctrlheight) && psDEFUIMode.ctrlheight) {
          item.ctrlheight = psDEFUIMode.ctrlheight;
        }
        if (isNilOrEmpty(item.ctrlwidth) && psDEFUIMode.ctrlwidth) {
          item.ctrlwidth = psDEFUIMode.ctrlwidth;
        }
      }
      if (!isNilOrEmpty(item.editortype) && !isNilOrEmpty(item.caption)) {
        return item;
      }
      const psDEField = this.fields.find((psdefield) => {
        if (psdefield.psdefieldid === item.psdefid) {
          return psdefield;
        }
      });
      if (psDEField) {
        if (isNilOrEmpty(item.caption)) {
          item.caption = psDEField.logicname;
        }
      }
    }
    return item;
  }
  /**
   * 通过源数据获取目标数据
   *
   * @author tony001
   * @date 2024-09-06 15:09:27
   * @param {('FORMDETAIL' | string)} type
   * @param {IData[]} source
   * @return {*}  {IData[]}
   */
  getTargetDataBySourceData(type, source) {
    if (type === "FORMDETAIL") {
      return source.map((item) => {
        return this.getFormItemPreviewData(item);
      });
    }
    return source;
  }
  getPropertyByTag(tag) {
    return [];
  }
}

export { DndDesignPreViewProvider };
