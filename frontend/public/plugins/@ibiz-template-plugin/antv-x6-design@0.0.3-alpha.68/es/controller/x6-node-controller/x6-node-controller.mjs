import { getControl, getPFPlugin } from '@ibiz-template/runtime';
import { RuntimeModelError, debounce } from '@ibiz-template/core';
import ContextMenu from '@imengyu/vue3-context-menu';
import { X6CellController } from '../x6-cell-controller/x6-cell-controller.mjs';
import '../../utils/index.mjs';
import { Trash } from './icons/index.mjs';
import { x6ProviderRegister } from '../../utils/x6-provider-register/x6-provider-register.mjs';

"use strict";
class X6NodeController extends X6CellController {
  onInit() {
    super.onInit();
    const { view } = this.panel;
    this.model = getControl(view.model, "node");
    if (!this.model) {
      throw new RuntimeModelError(view.model, "\u672A\u627E\u5230\u8282\u70B9\u8868\u5355\u6A21\u578B\u5BF9\u8C61");
    }
    const link = getControl(view.model, "link");
    if (!link) {
      throw new RuntimeModelError(view.model, "\u672A\u627E\u5230\u8FDE\u7EBF\u8868\u5355\u6A21\u578B\u5BF9\u8C61");
    }
    const pluginConfig = getPFPlugin(
      this.model.sysPFPluginId,
      this.model.appId
    );
    if (!pluginConfig) {
      throw new RuntimeModelError(this.model, "\u672A\u627E\u5230\u8282\u70B9\u63D2\u4EF6\u914D\u7F6E");
    }
    const tag = "".concat(pluginConfig.pluginType, "_").concat(pluginConfig.pluginCode);
    const provider = x6ProviderRegister.getNode(tag);
    if (!provider) {
      throw new RuntimeModelError(this.model, "\u672A\u627E\u5230\u8282\u70B9\u63D2\u4EF6[".concat(tag, "]"));
    }
    this.provider = provider(this.model, link);
    this.initEvents();
  }
  initEvents() {
    const g = this.g;
    g.on("node:added", ({ node }) => {
      if (node.data) {
        if (node.data.isCopy) {
          this.copyNode(node);
        } else if (node.data.isNew) {
          this.createNode(node);
        }
      }
    });
    const fn = debounce((node) => {
      this.updateNode(node);
    }, 500);
    g.on("node:change:position", ({ node }) => {
      fn(node);
    });
    g.on("node:removed", (args) => {
      const { node, options } = args;
      if (options.refresh) {
        return;
      }
      this.removeNode(node);
    });
    g.on("node:selected", (args) => {
      const { node } = args;
      const data = this.map.get(node.id);
      this.panel.view.call("onActive", data);
      node.trigger("selected", args);
    });
    g.on("node:unselected", (args) => {
      const { node } = args;
      node.trigger("unselected", args);
    });
    g.on("node:mouseenter", (args) => {
      const { node } = args;
      node.trigger("mouseenter", args);
    });
    g.on("node:mouseleave", (args) => {
      const { node } = args;
      node.trigger("mouseleave", args);
    });
    g.on("node:contextmenu", ({ e, node }) => {
      this.contextMenu(e, node);
    });
  }
  /**
   * 触发右键菜单
   *
   * @author chitanda
   * @date 2023-11-27 11:11:44
   * @protected
   * @param {Dom.ContextMenuEvent} e
   * @param {Node} node
   */
  contextMenu(e, node) {
    ContextMenu.showContextMenu({
      x: e.clientX,
      y: e.clientY,
      zIndex: 9999,
      items: [
        {
          icon: Trash(),
          label: "\u5220\u9664",
          onClick: async () => {
            const edges = this.g.getConnectedEdges(node);
            if (edges.length) {
              const isDelete = await ibiz.confirm.warning({
                title: "\u8282\u70B9\u5220\u9664\u63D0\u793A",
                desc: "\u5220\u9664\u8282\u70B9\u4F1A\u5220\u9664\u4E0E\u4E4B\u76F8\u5173\u7684\u8FDE\u7EBF\uFF0C\u662F\u5426\u786E\u8BA4\u5220\u9664\uFF1F"
              });
              if (!isDelete) {
                return;
              }
            }
            const bol = await this.removeNode(node);
            if (bol) {
              const index = this.g.getSelectedCells().findIndex((cell) => cell.id === node.id);
              if (index !== -1) {
                this.panel.view.call("onActiveRoot");
              }
              this.g.removeNode(node.id);
            }
          }
        }
      ]
    });
  }
  async load() {
    await this.provider.init(this.context, this.params);
    this.items = await this.provider.select(this.context, this.params);
    this.g.addNodes(
      this.items.map((item) => {
        const data = this.provider.createDataProvider(item);
        this.map.set(data.id, data);
        return this.provider.createCell(data);
      })
    );
  }
  /**
   * 新建节点
   *
   * @author chitanda
   * @date 2023-11-23 16:11:16
   * @param {Node} node
   * @return {*}  {Promise<void>}
   */
  async createNode(node) {
    if (this.map.has(node.id) === false) {
      try {
        const data = await this.provider.create(
          this.context,
          this.params,
          node,
          this.items.filter((item) => this.map.has(item.srfkey))
        );
        this.items.push(data);
        const dataProvider = this.provider.createDataProvider(data);
        this.map.set(dataProvider.id, dataProvider);
        this.g.removeNode(node.id);
        const newNode = this.g.addNode(this.provider.createCell(dataProvider));
        await this.provider.createEdges(newNode, this.g);
        this.g.resetSelection([newNode]);
      } catch (error) {
        ibiz.log.error(error);
        this.g.removeNode(node.id);
      }
    }
  }
  /**
   * 拷贝节点
   *
   * @author chitanda
   * @date 2023-11-29 14:11:20
   * @param {Node} node
   * @return {*}  {Promise<void>}
   */
  async copyNode(node) {
    if (this.map.has(node.id)) {
      try {
        const data = await this.provider.copy(this.context, this.params, node);
        const dataProvider = this.provider.createDataProvider(data);
        this.map.set(dataProvider.id, dataProvider);
        this.g.removeNode(node.id);
        const newNode = this.g.addNode(this.provider.createCell(dataProvider));
        this.g.resetSelection([newNode]);
        this.g.trigger("node:selected", { node: newNode });
      } catch (error) {
        ibiz.log.error(error);
        this.g.removeNode(node.id);
      }
    } else {
      ibiz.log.error("\u62F7\u8D1D\u8282\u70B9[".concat(node.id, "]\u5931\u8D25\uFF0C\u672A\u627E\u5230\u8282\u70B9\u6570\u636E"));
    }
  }
  /**
   * 更新节点数据
   *
   * @author chitanda
   * @date 2023-11-24 16:11:35
   * @param {Node} node
   * @return {*}  {Promise<void>}
   */
  async updateNode(node) {
    if (this.map.has(node.id) === true) {
      await this.provider.update(this.context, this.params, node);
    }
  }
  /**
   * 删除节点数据
   *
   * @author chitanda
   * @date 2023-11-23 20:11:58
   * @param {Node} node
   * @return {*}  {Promise<void>}
   */
  async removeNode(node) {
    if (this.map.has(node.id) === true) {
      const data = await this.provider.delete(
        this.context,
        this.params,
        node.id
      );
      if (data) {
        this.map.delete(node.id);
        return true;
      }
    }
    return false;
  }
}

export { X6NodeController };
