import { PanelItemController, ScriptFactory } from '@ibiz-template/runtime';
import { Stencil } from '../../node_modules/.pnpm/@antv_x6-plugin-stencil@2.1.5_@antv_x6@2.18.1/node_modules/@antv/x6-plugin-stencil/es/index.mjs';
import { awaitTimeout, RuntimeModelError } from '@ibiz-template/core';
import { X6PanelItemStencilState } from './x6-panel-item-stencil.state.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class X6PanelItemStencilController extends PanelItemController {
  constructor() {
    super(...arguments);
    /**
     * 挂载容器
     *
     * @author chitanda
     * @date 2023-11-11 15:11:06
     * @protected
     * @type {HTMLDivElement}
     */
    __publicField(this, "container");
    __publicField(this, "s");
  }
  get x6Controller() {
    return this.panel.panelItems.x6_panel_item;
  }
  /**
   * 节点适配器
   *
   * @author chitanda
   * @date 2023-11-16 18:11:29
   * @type {X6NodeServiceProvider}
   */
  get provider() {
    return this.x6.node.provider;
  }
  get x6() {
    return this.x6Controller.x6;
  }
  createState() {
    var _a;
    return new X6PanelItemStencilState((_a = this.parent) == null ? void 0 : _a.state);
  }
  async initStencil(container, count = 0) {
    if (this.s) {
      return;
    }
    if (!this.x6Controller || !this.x6) {
      if (count > 10) {
        throw new Error(
          "X6PanelItemStencil: \u521D\u59CB\u5316 stencil \u5B9E\u4F8B\u5931\u8D25\uFF0C\u672A\u80FD\u7B49\u627E\u5230 x6 \u63A7\u5236\u5668"
        );
      }
      await awaitTimeout(300);
      return this.initStencil(container);
    }
    this.container = container;
    if (this.container) {
      let codeList = null;
      let codeListItems = [];
      const { editor } = this.model;
      if (editor) {
        const { appCodeListId } = editor;
        if (appCodeListId) {
          const app = await ibiz.hub.getApp(this.model.appId);
          codeList = app.codeList.getCodeList(appCodeListId);
          const codeItems = await app.codeList.get(
            appCodeListId,
            this.panel.context,
            this.panel.params
          );
          codeListItems = codeItems.filter(
            (item) => Array.isArray(item.children) && item.children.length
          );
          codeListItems.forEach((item) => {
            if (Array.isArray(item.children)) {
              item.children.forEach((child) => {
                if (typeof child.data === "string") {
                  child.data = ScriptFactory.execSingleLine(
                    child.data
                  );
                }
              });
            }
          });
        }
      }
      if (!codeList) {
        throw new RuntimeModelError(this.model, "\u672A\u914D\u7F6E\u7D20\u6750\u533A\u4EE3\u7801\u8868");
      }
      const { x6 } = this;
      this.s = new Stencil({
        target: this.x6.g,
        search(cell, keyword) {
          if (!keyword) {
            return true;
          }
          const data = cell.getData();
          const text = data && data.text || "";
          const searchText = keyword.trim().toLowerCase();
          return text.toLowerCase().indexOf(searchText) !== -1;
        },
        title: "\u7D20\u6750",
        placeholder: "\u8282\u70B9\u540D\u79F0/\u8282\u70B9\u6807\u8BC6",
        notFoundText: codeList.emptyText,
        collapsable: false,
        stencilGraphHeight: 0,
        layoutOptions: {
          columns: 3,
          center: false
        },
        getDragNode: (draggingNode, _options) => {
          const codeItem = draggingNode.data;
          const node = x6.g.createNode(this.provider.createDragCell(codeItem));
          return node;
        },
        validateNode: (droppingNode, options) => {
          return this.provider.validateNode(droppingNode, options);
        },
        groups: codeListItems.map((item) => {
          return {
            name: item.id,
            title: item.text,
            graphHeight: 0,
            collapsable: true,
            collapsed: item.userData === "contract"
          };
        })
      });
      this.container.appendChild(this.s.container);
      codeListItems.forEach((item) => {
        if (item.children) {
          const nodes = item.children.map((codeItem) => {
            const node = this.x6.g.createNode(
              this.provider.createMaterialCell(codeItem)
            );
            return node;
          });
          this.s.load(nodes, item.id);
        }
      });
    } else {
      throw new Error("X6PanelItemStencil: \u521D\u59CB\u5316\u5BB9\u5668\u4E3A\u7A7A not found");
    }
  }
}

export { X6PanelItemStencilController };
