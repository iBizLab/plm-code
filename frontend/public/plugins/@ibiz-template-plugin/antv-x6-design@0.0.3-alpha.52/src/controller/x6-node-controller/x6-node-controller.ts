/* eslint-disable @typescript-eslint/no-explicit-any */
import { Node, Dom } from '@antv/x6';
import { getControl, getPFPlugin } from '@ibiz-template/runtime';
import { IDEEditForm } from '@ibiz/model-core';
import { RuntimeModelError, debounce } from '@ibiz-template/core';
import ContextMenu from '@imengyu/vue3-context-menu';
import { X6CellController } from '../x6-cell-controller/x6-cell-controller';
import { X6NodeServiceProvider } from '../../interface';
import { x6ProviderRegister } from '../../utils';
import { Trash } from './icons';

/**
 * 节点控制器
 *
 * @author chitanda
 * @date 2023-11-16 18:11:19
 * @export
 * @class X6NodeController
 */
export class X6NodeController extends X6CellController {
  /**
   * 节点适配器
   *
   * @author chitanda
   * @date 2023-11-16 18:11:29
   * @type {X6NodeServiceProvider}
   */
  declare provider: X6NodeServiceProvider;

  protected onInit(): void {
    super.onInit();
    const { view } = this.panel;
    this.model = getControl(view.model, 'node') as IDEEditForm;
    if (!this.model) {
      throw new RuntimeModelError(view.model, '未找到节点表单模型对象');
    }
    const link = getControl(view.model, 'link') as IDEEditForm;
    if (!link) {
      throw new RuntimeModelError(view.model, '未找到连线表单模型对象');
    }
    const pluginConfig = getPFPlugin(
      this.model.sysPFPluginId!,
      this.model.appId,
    );
    if (!pluginConfig) {
      throw new RuntimeModelError(this.model!, '未找到节点插件配置');
    }
    const tag = `${pluginConfig.pluginType}_${pluginConfig.pluginCode}`;
    const provider = x6ProviderRegister.getNode(tag);
    if (!provider) {
      throw new RuntimeModelError(this.model!, `未找到节点插件[${tag}]`);
    }
    this.provider = provider(this.model, link);
    this.initEvents();
  }

  protected initEvents(): void {
    const g = this.g;
    g.on('node:added', ({ node }) => {
      if (node.data) {
        if (node.data.isCopy) {
          this.copyNode(node);
        } else if (node.data.isNew) {
          this.createNode(node);
        }
      }
    });
    const fn = debounce(node => {
      this.updateNode(node as Node);
    }, 500);
    g.on('node:change:position', ({ node }) => {
      fn(node);
    });
    g.on('node:removed', args => {
      const { node, options } = args;
      if (options.refresh) {
        return;
      }
      this.removeNode(node);
    });
    g.on('node:selected', args => {
      const { node } = args;
      const data = this.map.get(node.id);
      // 向视图发送激活数据事件
      this.panel.view.call('onActive', data);
      node.trigger('selected', args);
    });
    g.on('node:unselected', args => {
      const { node } = args;
      node.trigger('unselected', args);
    });
    g.on('node:mouseenter', args => {
      const { node } = args;
      node.trigger('mouseenter', args);
    });
    g.on('node:mouseleave', args => {
      const { node } = args;
      node.trigger('mouseleave', args);
    });
    g.on('node:contextmenu', ({ e, node }) => {
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
  protected contextMenu(e: Dom.ContextMenuEvent, node: Node): void {
    ContextMenu.showContextMenu({
      x: e.clientX,
      y: e.clientY,
      zIndex: 9999,
      items: [
        {
          icon: Trash() as any,
          label: '删除',
          onClick: async () => {
            const edges = this.g.getConnectedEdges(node);
            if (edges.length) {
              const isDelete = await ibiz.confirm.warning({
                title: '节点删除提示',
                desc: '删除节点会删除与之相关的连线，是否确认删除？',
              });
              if (!isDelete) {
                return;
              }
            }
            const bol = await this.removeNode(node);
            if (bol) {
              const index = this.g
                .getSelectedCells()
                .findIndex(cell => cell.id === node.id);
              if (index !== -1) {
                this.panel.view.call('onActiveRoot');
              }
              this.g.removeNode(node.id);
            }
          },
        },
      ],
    });
  }

  async load(): Promise<void> {
    await this.provider.init(this.context, this.params);
    this.items = await this.provider.select(this.context, this.params);
    this.g.addNodes(
      this.items.map(item => {
        const data = this.provider.createDataProvider(item);
        this.map.set(data.id, data);
        return this.provider.createCell(data);
      }),
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
  async createNode(node: Node): Promise<void> {
    if (this.map.has(node.id) === false) {
      try {
        // 创建实际节点数据
        const data = await this.provider.create(
          this.context,
          this.params,
          node,
          this.items.filter(item => this.map.has(item.srfkey)),
        );
        this.items.push(data);
        // 创建节点适配器
        const dataProvider = this.provider.createDataProvider(data);
        // 缓存数据
        this.map.set(dataProvider.id, dataProvider);
        // 删除原节点后,创建新节点并选中。主要是因为x6的节点id是不可变的，所以只能删除原节点，创建新节点
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
  async copyNode(node: Node): Promise<void> {
    if (this.map.has(node.id)) {
      try {
        // 创建实际节点数据
        const data = await this.provider.copy!(this.context, this.params, node);
        // 创建节点适配器
        const dataProvider = this.provider.createDataProvider(data);
        // 缓存数据
        this.map.set(dataProvider.id, dataProvider);
        // 删除原节点后,创建新节点并选中。主要是因为x6的节点id是不可变的，所以只能删除原节点，创建新节点
        this.g.removeNode(node.id);
        const newNode = this.g.addNode(this.provider.createCell(dataProvider));
        this.g.resetSelection([newNode]);
        this.g.trigger('node:selected', { node: newNode });
      } catch (error) {
        ibiz.log.error(error);
        this.g.removeNode(node.id);
      }
    } else {
      ibiz.log.error(`拷贝节点[${node.id}]失败，未找到节点数据`);
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
  async updateNode(node: Node): Promise<void> {
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
  async removeNode(node: Node): Promise<boolean> {
    if (this.map.has(node.id) === true) {
      const data = await this.provider.delete(
        this.context,
        this.params,
        node.id,
      );
      if (data) {
        this.map.delete(node.id);
        return true;
      }
    }
    return false;
  }
}
