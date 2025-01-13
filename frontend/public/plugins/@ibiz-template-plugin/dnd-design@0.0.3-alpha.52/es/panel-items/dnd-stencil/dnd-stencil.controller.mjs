import { RuntimeModelError } from '@ibiz-template/core';
import { PanelItemController, UIActionUtil } from '@ibiz-template/runtime';
import { DndStencilPanelItemState } from './dnd-stencil.state.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndStencilPanelItemController extends PanelItemController {
  constructor() {
    super(...arguments);
    __publicField(this, "codeList");
    /**
     * 代码表项
     *
     * @author zhanghengfeng
     * @date 2024-01-11 18:01:27
     * @protected
     * @type {ICodeItem[]}
     */
    __publicField(this, "codeItems", []);
    /**
     * 是否启用分组呈现
     *
     * @author chitanda
     * @date 2023-12-23 15:12:05
     * @type {boolean}
     */
    __publicField(this, "enableGroup", false);
    /**
     * 按钮分组映射
     *
     * @author zhanghengfeng
     * @date 2024-01-12 18:01:05
     * @type {Map<
     *     string,
     *     { model: IDEFormGroupPanel; state: IButtonContainerState }
     *   >}
     */
    __publicField(this, "buttonGroupMap", /* @__PURE__ */ new Map());
  }
  createState() {
    var _a;
    return new DndStencilPanelItemState((_a = this.parent) == null ? void 0 : _a.state);
  }
  get view() {
    return this.panel.view;
  }
  async onInit() {
    await super.onInit();
    await this.load();
    this.view.evt.on("onStencilSearch", (e) => {
      const searchValue = e.eventArg || "";
      this.state.filterValue = searchValue.trim().toLowerCase();
      this.filter();
    });
  }
  async load() {
    const editor = this.model.editor;
    if (editor) {
      const { appCodeListId } = editor;
      if (appCodeListId) {
        const app = await ibiz.hub.getApp(this.model.appId);
        this.codeList = app.codeList.getCodeList(appCodeListId);
      }
      if (!this.codeList) {
        throw new RuntimeModelError(this.model, "\u672A\u914D\u7F6E\u7D20\u6750\u533A\u4EE3\u7801\u8868");
      }
      this.codeItems = this.codeList.codeItems || [];
      const index = this.codeItems.findIndex((item) => {
        if (item.codeItems && item.codeItems.length > 1) {
          return true;
        }
        return false;
      });
      this.enableGroup = index !== -1;
      this.state.items = this.codeItems;
      this.filter();
    } else {
      ibiz.log.warn("\u62D6\u62FD\u7D20\u6750\u533A\u63A7\u5236\u5668\u7684 editor \u4E3A\u7A7A");
    }
  }
  /**
   * 过滤项
   *
   * @author zhanghengfeng
   * @date 2024-01-11 19:01:19
   * @protected
   * @return {*}  {void}
   */
  filter() {
    if (!this.state.filterValue) {
      this.state.items = this.codeItems;
      return;
    }
    if (this.enableGroup) {
      this.state.items = [];
      this.codeItems.forEach((item) => {
        const group = { ...item };
        if (!Array.isArray(group.codeItems)) {
          group.codeItems = [];
        }
        group.codeItems = group.codeItems.filter((codeItem) => {
          return codeItem.text && codeItem.text.toLowerCase().includes(this.state.filterValue);
        });
        this.state.items.push(group);
      });
    } else {
      this.state.items = this.codeItems.filter((item) => {
        return item.text && item.text.toLowerCase().includes(this.state.filterValue);
      });
    }
  }
  /**
   * 监听行为组点击
   *
   * @author zhanghengfeng
   * @date 2024-01-12 18:01:48
   * @param {IUIActionGroupDetail} detail
   * @param {MouseEvent} event
   * @return {*}  {Promise<void>}
   */
  async onActionClick(detail, event) {
    const actionId = detail.uiactionId;
    await UIActionUtil.execAndResolved(
      actionId,
      {
        context: this.panel.context,
        params: this.panel.params,
        data: [],
        view: this.panel.view,
        event
      },
      detail.appId
    );
  }
}

export { DndStencilPanelItemController };
