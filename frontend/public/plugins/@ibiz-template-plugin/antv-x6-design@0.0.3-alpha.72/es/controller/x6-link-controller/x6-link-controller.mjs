import { getControl, getPFPlugin } from '@ibiz-template/runtime';
import { RuntimeModelError } from '@ibiz-template/core';
import { debounce } from 'lodash-es';
import ContextMenu from '@imengyu/vue3-context-menu';
import { X6CellController } from '../x6-cell-controller/x6-cell-controller.mjs';
import '../../utils/index.mjs';
import { x6ProviderRegister } from '../../utils/x6-provider-register/x6-provider-register.mjs';

"use strict";
class X6LinkController extends X6CellController {
  onInit() {
    super.onInit();
    const { view } = this.panel;
    this.model = getControl(view.model, "link");
    if (!this.model) {
      throw new RuntimeModelError(view.model, "\u672A\u627E\u5230\u8FDE\u7EBF\u8868\u5355\u6A21\u578B\u5BF9\u8C61");
    }
    const node = getControl(view.model, "node");
    if (!node) {
      throw new RuntimeModelError(view.model, "\u672A\u627E\u5230\u8282\u70B9\u8868\u5355\u6A21\u578B\u5BF9\u8C61");
    }
    const pluginConfig = getPFPlugin(
      this.model.sysPFPluginId,
      this.model.appId
    );
    if (!pluginConfig) {
      throw new RuntimeModelError(this.model, "\u672A\u627E\u5230\u8FDE\u7EBF\u63D2\u4EF6\u914D\u7F6E");
    }
    this.provider = x6ProviderRegister.getLink(
      "".concat(pluginConfig.pluginType, "_").concat(pluginConfig.pluginCode)
    )(node, this.model);
    this.initEvents();
    this.g.options.onEdgeLabelRendered = (args) => {
      return this.provider.onEdgeLabelRendered(args);
    };
    this.debounceUpdateEdge = debounce(this.debounceUpdateEdge, 300);
  }
  initEvents() {
    const g = this.g;
    g.on("edge:connected", async ({ edge }) => {
      if (this.map.has(edge.id) === true) {
        await this.updateEdge(edge);
      } else {
        await this.createEdge(edge);
      }
    });
    g.on("edge:removed", (args) => {
      const { edge, options } = args;
      if (options.refresh) {
        return;
      }
      this.removeEdge(edge);
    });
    g.on("edge:selected", (args) => {
      const { edge } = args;
      const data = this.map.get(edge.id);
      this.panel.view.call("onActive", data);
      edge.trigger("selected", args);
    });
    g.on("edge:unselected", (args) => {
      const { edge } = args;
      edge.trigger("unselected", args);
    });
    g.on("edge:mouseenter", (args) => {
      const { edge } = args;
      edge.trigger("mouseenter", { ...args, data: this.map.get(edge.id) });
    });
    g.on("edge:mouseleave", (args) => {
      const { edge } = args;
      edge.trigger("mouseleave", { ...args, data: this.map.get(edge.id) });
    });
    g.on("edge:contextmenu", ({ e, edge }) => {
      this.contextMenu(e, edge);
    });
    g.on("node:change:position", ({ node }) => {
      const edges = g.getConnectedEdges(node);
      if (Array.isArray(edges)) {
        edges.forEach((edge) => {
          this.updateLabel(edge);
        });
      }
    });
    g.on("edge:change:source", ({ edge }) => {
      this.updateLabel(edge);
    });
    g.on("edge:change:target", ({ edge }) => {
      this.updateLabel(edge);
    });
    g.on("edge:change:vertices", ({ edge }) => {
      this.updateLabel(edge);
      this.debounceUpdateEdge(edge);
    });
  }
  /**
   * 更新连线
   *
   * @author zhanghengfeng
   * @date 2024-01-31 18:01:45
   * @protected
   * @param {Edge} edge
   */
  debounceUpdateEdge(edge) {
    this.updateEdge(edge);
  }
  /**
   * 更新连线label标签
   *
   * @author zhanghengfeng
   * @date 2024-01-30 18:01:19
   * @protected
   * @param {Edge} edge
   */
  updateLabel(edge) {
    if (this.map.has(edge.id)) {
      edge.trigger("update", this.map.get(edge.id));
    }
  }
  /**
   * 触发右键菜单
   *
   * @author chitanda
   * @date 2023-11-27 11:11:44
   * @protected
   * @param {Dom.ContextMenuEvent} e
   * @param {Edge} edge
   */
  contextMenu(e, edge) {
    ContextMenu.showContextMenu({
      x: e.clientX,
      y: e.clientY,
      zIndex: 9999,
      items: [
        {
          label: "\u5220\u9664",
          onClick: async () => {
            const bol = await this.removeEdge(edge);
            if (bol) {
              const index = this.g.getSelectedCells().findIndex((cell) => cell.id === edge.id);
              if (index !== -1) {
                this.panel.view.call("onActiveRoot");
              }
              this.g.removeEdge(edge.id, { g: this.g });
            }
          }
        }
      ]
    });
  }
  async load() {
    await this.provider.init(this.context, this.params);
    this.items = await this.provider.select(this.context, this.params);
    if (this.provider.afterLoad) {
      this.provider.afterLoad(this.panel.view);
    }
    this.g.addEdges(
      this.items.map((item) => {
        const data = this.provider.createDataProvider(item);
        this.map.set(data.id, data);
        return this.provider.createCell(data);
      })
    );
  }
  /**
   * 新建连线数据
   *
   * @author chitanda
   * @date 2023-11-23 17:11:07
   * @param {Edge} edge
   * @return {*}  {Promise<void>}
   */
  async createEdge(edge) {
    try {
      const data = await this.provider.create(this.context, this.params, edge);
      const dataProvider = this.provider.createDataProvider(data);
      this.map.set(dataProvider.id, dataProvider);
      this.g.removeEdge(edge.id);
      const cell = this.provider.createCell(dataProvider);
      const newEdge = this.g.addEdge(cell);
      this.g.resetSelection([newEdge]);
    } catch (error) {
      ibiz.log.error(error);
      this.g.removeEdge(edge.id);
    }
  }
  /**
   * 更新连线数据
   *
   * @author chitanda
   * @date 2023-11-24 17:11:39
   * @param {Edge} edge
   * @return {*}  {Promise<void>}
   */
  async updateEdge(edge) {
    if (this.map.has(edge.id) === true) {
      await this.provider.update(this.context, this.params, edge);
    }
  }
  /**
   * 删除连线数据
   *
   * @author chitanda
   * @date 2023-11-23 20:11:34
   * @param {Edge} edge
   * @return {*}  {Promise<void>}
   */
  async removeEdge(edge) {
    if (this.map.has(edge.id) === true) {
      const data = await this.provider.delete(
        this.context,
        this.params,
        edge.id
      );
      if (data) {
        this.map.delete(edge.id);
        return true;
      }
    }
    return false;
  }
}

export { X6LinkController };
