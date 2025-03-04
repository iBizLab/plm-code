import { getControl, ButtonContainerState, UIActionButtonState } from '@ibiz-template/runtime';
import { RuntimeModelError } from '@ibiz-template/core';
import { DndStencilPanelItemController } from '../../panel-items/dnd-stencil/dnd-stencil.controller.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndStencilEditorController extends DndStencilPanelItemController {
  constructor() {
    super(...arguments);
    /**
     * 主表单
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:14
     * @protected
     * @type {IDEEditForm}
     */
    __publicField(this, "majorForm");
    /**
     * 主表单服务
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:22
     * @protected
     * @type {IAppDEService}
     */
    __publicField(this, "majorService");
    /**
     * 编辑器表单
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:33
     * @protected
     * @type {IDEEditForm}
     */
    __publicField(this, "editorForm");
    /**
     * 编辑器表单服务
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:46
     * @protected
     * @type {IAppDEService}
     */
    __publicField(this, "editorService");
    /**
     * 是否启用分组呈现
     *
     * @author zhanghengfeng
     * @date 2025-01-22 19:01:07
     * @type {boolean}
     */
    __publicField(this, "enableGroup", true);
  }
  /**
   * 初始化
   *
   * @author zhanghengfeng
   * @date 2025-01-22 19:01:17
   * @protected
   * @return {*}  {Promise<void>}
   */
  async onInit() {
    await this.initBaseResource();
    await super.onInit();
  }
  /**
   * 初始化基础资源
   *
   * @author zhanghengfeng
   * @date 2025-01-22 19:01:29
   * @protected
   * @return {*}  {Promise<void>}
   */
  async initBaseResource() {
    const app = ibiz.hub.getApp(this.view.model.appId);
    const majorForm = getControl(this.view.model, "form");
    if (!majorForm) {
      throw new RuntimeModelError(this.view, "\u672A\u627E\u5230 form \u8868\u5355\u6A21\u578B");
    }
    this.majorForm = majorForm;
    this.majorService = await app.deService.getService(
      this.panel.context,
      this.majorForm.appDataEntityId
    );
    const editorForm = getControl(this.view.model, "editor");
    if (!editorForm) {
      throw new RuntimeModelError(this.view, "\u672A\u627E\u5230 editor \u8868\u5355\u6A21\u578B");
    }
    this.editorForm = editorForm;
    this.editorService = await app.deService.getService(
      this.panel.context,
      this.editorForm.appDataEntityId
    );
    const editor = this.model.editor;
    if (editor) {
      const { appCodeListId } = editor;
      if (appCodeListId) {
        this.codeList = app.codeList.getCodeList(appCodeListId);
      }
      if (!this.codeList) {
        throw new RuntimeModelError(this.model, "\u672A\u914D\u7F6E\u7528\u6237\u6269\u5C55\u7F16\u8F91\u5668\u4EE3\u7801\u8868");
      }
    } else {
      ibiz.log.warn("\u62D6\u62FD\u7D20\u6750\u533A\u63A7\u5236\u5668\u7684 editor \u4E3A\u7A7A");
    }
    await this.initButtonGroup();
  }
  /**
   * 加载数据
   *
   * @author zhanghengfeng
   * @date 2025-01-22 19:01:20
   * @return {*}  {Promise<void>}
   */
  async load() {
    const majorResult = await this.majorService.getTemp(
      this.panel.context,
      this.panel.params
    );
    if (!majorResult || !majorResult.ok || !majorResult.data) {
      return;
    }
    const editorResult = await this.editorService.exec(
      "FetchCurSysWithIcon",
      this.panel.context,
      this.panel.params
    );
    if (!editorResult || !editorResult.ok || !Array.isArray(editorResult.data)) {
      return;
    }
    const formData = majorResult.data;
    const editorData = editorResult.data;
    const items = editorData.filter((item) => {
      const editorType = item.pseditortypeid;
      if (editorType === "HIDDEN" || editorType === "USERCONTROL" || editorType === "SPAN") {
        return true;
      }
      if (formData && item.validflag == 1) {
        if (formData.mobflag == 1 && /^MOB/.test(editorType)) {
          return true;
        }
        if (formData.mobflag != 1 && !/^MOB/.test(editorType)) {
          return true;
        }
      }
      return false;
    });
    const codeItems = this.codeList.codeItems || [];
    this.state.items = codeItems.map((codeItem) => {
      const parent = { ...codeItem };
      const data = JSON.parse(parent.data || "{}");
      parent.codeItems = items.map((item) => {
        let text = "".concat(item.pssyseditorstylename || "");
        text += item.pseditortypename ? "(".concat(item.pseditortypename, ")") : "";
        return {
          appId: parent.appId,
          text,
          iconPath: item.studioicon || parent.iconPath,
          data: JSON.stringify({
            ...data,
            detailtype: "FORMITEM",
            formtype: formData.formtype,
            pssyseditorstylename: item.pssyseditorstylename,
            pssyseditorstyleid: item.pssyseditorstyleid,
            editortype: item.pseditortypeid,
            editortypename: item.pseditortypename,
            width: item.width,
            height: item.height
          })
        };
      });
      return parent;
    });
    this.codeItems = this.state.items;
    this.filter();
  }
  /**
   * 初始化界面行为按钮
   *
   * @author zhanghengfeng
   * @date 2025-01-22 19:01:51
   * @protected
   * @return {*}  {Promise<void>}
   */
  async initButtonGroup() {
    var _a;
    if (this.editorForm) {
      const pages = this.editorForm.deformPages;
      if (!Array.isArray(pages) || !pages[0]) {
        ibiz.log.warn("editor \u8868\u5355\u6A21\u578B\u672A\u914D\u7F6E\u8868\u5355\u5206\u9875");
        return;
      }
      const page = pages[0];
      const formDetails = page.deformDetails;
      const group = formDetails == null ? void 0 : formDetails.find(
        (item) => item.codeName === "editor_group"
      );
      if (!group) {
        ibiz.log.warn("editor \u8868\u5355\u6A21\u578B\u672A\u914D\u7F6E\u6807\u8BC6\u4E3A editor_group \u8868\u5355\u5206\u7EC4");
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
   * @date 2025-01-22 19:01:04
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
    await containerState.update(this.panel.context);
    return containerState;
  }
}

export { DndStencilEditorController };
