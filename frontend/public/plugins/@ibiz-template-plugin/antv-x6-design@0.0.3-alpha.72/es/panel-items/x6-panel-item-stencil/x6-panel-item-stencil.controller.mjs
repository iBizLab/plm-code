import { PanelItemController, ScriptFactory, UIActionUtil } from '@ibiz-template/runtime';
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
    /**
     * @description 行为参数
     * @type {IData}
     * @memberof X6PanelItemStencilController
     */
    __publicField(this, "actionParams", {});
    /**
     * @description 是否显示分组头
     * @type {boolean}
     * @memberof X6PanelItemStencilController
     */
    __publicField(this, "showGroupHeader", false);
    /**
     * @description 节点数组
     * @type {IData[]}
     * @memberof X6PanelItemStencilController
     */
    __publicField(this, "nodes", []);
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
  /**
   *  加载代码表
   *
   * @author fangZhiHao
   * @date 2024-07-24 09:07:24
   * @param {string} appCodeListId
   * @return {*}
   */
  async loadCodeList(appCodeListId) {
    let codeListItems = [];
    const app = await ibiz.hub.getApp(this.model.appId);
    const codeItems = await app.codeList.get(
      appCodeListId,
      this.panel.context,
      this.panel.params
    );
    if (this.showGroupHeader) {
      codeListItems = codeItems;
    } else {
      codeListItems = codeItems.filter(
        (item) => Array.isArray(item.children) && item.children.length
      );
    }
    codeListItems.forEach((item) => {
      if (Array.isArray(item.children)) {
        item.children.forEach((child) => {
          if (typeof child.data === "string") {
            child.data = ScriptFactory.execSingleLine(child.data);
          }
        });
      }
    });
    return codeListItems;
  }
  /**
   * 填充界面行为
   *
   * @author fangZhiHao
   * @date 2024-07-24 19:07:45
   * @param {CodeListItem[]} codeListItems
   */
  fillAction(codeListItems) {
    codeListItems.forEach((item) => {
      const action = this.actionParams[item.id];
      if (action) {
        const data = item.data || {};
        Object.assign(item, { data: { action, ...data } });
      }
      if (Array.isArray(item.children)) {
        item.children.forEach((x) => {
          if (action) {
            const data = x.data || {};
            Object.assign(x, { data: { action, ...data } });
          }
        });
      }
    });
  }
  /**
   * 挂载 stencil 节点
   *
   * @author fangZhiHao
   * @date 2024-07-24 09:07:35
   * @param {CodeListItem[]} codeListItems
   */
  loadNodes(codeListItems) {
    this.nodes = [];
    codeListItems.forEach((item) => {
      let nodes = [];
      if (item.children) {
        nodes = item.children.map((codeItem) => {
          const param = codeItem;
          if (param.data && param.data.action && param.data.action.remove) {
            Object.assign(param.data, {
              actionID: param.data.action.remove
            });
          }
          const node = this.x6.g.createNode(
            this.provider.createMaterialCell(param)
          );
          return node;
        });
      }
      const data = item.data || {};
      if (data.action && data.action.add) {
        const addNode = this.x6.g.createNode(
          this.provider.createMaterialAddCell({
            id: "add",
            data: { actionID: data.action.add },
            text: "\u65B0\u589E",
            value: "add"
          })
        );
        nodes.push(addNode);
      }
      this.nodes.push(...nodes);
      this.s.load(nodes, item.id);
    });
  }
  /**
   *  设置事件
   *
   * @author fangZhiHao
   * @date 2024-07-24 18:07:17
   * @param {IData} action
   * @param {CodeListItem[]} codeListItems
   */
  initEevnt() {
    const graphs = this.s.graphs;
    Object.keys(this.actionParams).forEach((key) => {
      const graph = graphs[key];
      if (graph) {
        graph.on("render:done", () => {
          const nodes = graph.container.querySelectorAll(".x6-node");
          nodes.forEach((node) => {
            const dataId = node.getAttribute("data-cell-id");
            const cell = graph.getCellById(dataId);
            if (this.actionParams[key].remove) {
              this.registerNodeEvent(
                node,
                cell,
                ".ibiz-material-node-delete-icon"
              );
            }
            if (this.actionParams[key].add) {
              this.registerNodeEvent(node, cell, ".ibiz-material-add-node");
            }
          });
        });
      }
    });
  }
  /**
   *  注册节点事件
   *
   * @author fangZhiHao
   * @date 2024-07-24 19:07:15
   * @param {string} className
   * @param {IData} action
   * @param {string} key
   */
  async registerNodeEvent(container, cell, className) {
    const element = container.querySelector(className);
    if (element) {
      if (element.classList.contains("is-active")) {
        return;
      }
      element.classList.add("is-active");
      element.addEventListener(
        "mousedown",
        async (event) => {
          if (cell.data && cell.data.data && cell.data.data.actionID) {
            const uiActionId = "".concat(cell.data.data.actionID);
            event.preventDefault();
            event.stopPropagation();
            await UIActionUtil.execAndResolved(
              uiActionId,
              {
                context: this.panel.context,
                params: {
                  panelDataParent: this.dataParent.model.id,
                  cellid: cell.data.id,
                  ...this.panel.params
                },
                data: [this.data],
                view: this.panel.view,
                event,
                noWaitRoute: true
              },
              this.model.appId
            );
          }
        },
        { captrue: true, passive: false }
      );
    }
  }
  /**
   * 重新加载代码表
   *
   * @author fangZhiHao
   * @date 2024-07-24 20:07:19
   * @param {IData} action
   */
  async refresh() {
    const graphs = this.s.graphs;
    Object.values(graphs).forEach((graph) => {
      graph.clearCells({ refresh: true });
    });
    const { appCodeListId } = this.model.editor;
    if (appCodeListId) {
      const codeListItems = await this.loadCodeList(appCodeListId);
      this.fillAction(codeListItems);
      this.loadNodes(codeListItems);
      this.initEevnt();
    }
  }
  /**
   * @description 初始化编辑器参数
   * @param {IData} editorParams
   * @memberof X6PanelItemStencilController
   */
  initEditorParams(editorParams) {
    if (editorParams) {
      Object.keys(editorParams).forEach((key) => {
        const keys = key.split("_");
        if (keys.length === 3 && keys[2] === "ACTION") {
          const action = this.actionParams[keys[0]] || {};
          this.actionParams[keys[0]] = {
            [keys[1].toLowerCase()]: editorParams[key],
            ...action
          };
        }
      });
      if (editorParams.SHOWHEADER) {
        this.showGroupHeader = editorParams.SHOWHEADER === "true" || editorParams.SHOWHEADER === "TRUE";
      }
    }
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
        const { appCodeListId, editorParams = {} } = editor;
        this.initEditorParams(editorParams);
        if (appCodeListId) {
          const app = await ibiz.hub.getApp(this.model.appId);
          codeList = app.codeList.getCodeList(appCodeListId);
          codeListItems = await this.loadCodeList(appCodeListId);
          this.fillAction(codeListItems);
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
      this.loadNodes(codeListItems);
      this.initEevnt();
    } else {
      throw new Error("X6PanelItemStencil: \u521D\u59CB\u5316\u5BB9\u5668\u4E3A\u7A7A not found");
    }
  }
}

export { X6PanelItemStencilController };
