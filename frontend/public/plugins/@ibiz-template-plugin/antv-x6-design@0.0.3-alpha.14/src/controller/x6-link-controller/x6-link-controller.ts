import { getControl, getPFPlugin } from '@ibiz-template/runtime';
import { IDEEditForm } from '@ibiz/model-core';
import { RuntimeModelError } from '@ibiz-template/core';
import { Dom, Edge } from '@antv/x6';
import { debounce } from 'lodash-es';
import ContextMenu from '@imengyu/vue3-context-menu';
import { X6CellController } from '../x6-cell-controller/x6-cell-controller';
import { X6LinkServiceProvider } from '../../interface';
import { x6ProviderRegister } from '../../utils';
import { X6DesignViewController } from '../../views';

/**
 * 连线控制器
 *
 * @author chitanda
 * @date 2023-11-16 18:11:07
 * @export
 * @class X6LinkController
 */
export class X6LinkController extends X6CellController {
  /**
   * 连线适配器
   *
   * @author chitanda
   * @date 2023-11-16 18:11:00
   * @type {X6LinkServiceProvider}
   */
  declare provider: X6LinkServiceProvider;

  protected onInit(): void {
    super.onInit();
    const { view } = this.panel;
    this.model = getControl(view.model, 'link') as IDEEditForm;
    if (!this.model) {
      throw new RuntimeModelError(view.model, '未找到连线表单模型对象');
    }
    const node = getControl(view.model, 'node') as IDEEditForm;
    if (!node) {
      throw new RuntimeModelError(view.model, '未找到节点表单模型对象');
    }
    const pluginConfig = getPFPlugin(
      this.model.sysPFPluginId!,
      this.model.appId,
    );
    if (!pluginConfig) {
      throw new RuntimeModelError(this.model!, '未找到连线插件配置');
    }
    this.provider = x6ProviderRegister.getLink(
      `${pluginConfig.pluginType}_${pluginConfig.pluginCode}`,
    )(node, this.model);
    this.initEvents();
    this.g.options.onEdgeLabelRendered = args => {
      return this.provider.onEdgeLabelRendered(args);
    };
    this.debounceUpdateEdge = debounce(this.debounceUpdateEdge, 300);
  }

  protected initEvents(): void {
    const g = this.g;
    g.on('edge:connected', async ({ edge }) => {
      if (this.map.has(edge.id) === true) {
        await this.updateEdge(edge);
      } else {
        await this.createEdge(edge);
      }
    });
    g.on('edge:removed', args => {
      const { edge, options } = args;
      if (options.refresh) {
        return;
      }
      this.removeEdge(edge);
    });
    g.on('edge:selected', args => {
      const { edge } = args;
      const data = this.map.get(edge.id);
      // 向视图发送激活数据事件
      this.panel.view.call('onActive', data);
      edge.trigger('selected', args);
    });
    g.on('edge:unselected', args => {
      const { edge } = args;
      edge.trigger('unselected', args);
    });
    g.on('edge:mouseenter', args => {
      const { edge } = args;
      edge.trigger('mouseenter', { ...args, data: this.map.get(edge.id) });
    });
    g.on('edge:mouseleave', args => {
      const { edge } = args;
      edge.trigger('mouseleave', { ...args, data: this.map.get(edge.id) });
    });
    g.on('edge:contextmenu', ({ e, edge }) => {
      this.contextMenu(e, edge);
    });
    g.on('node:change:position', ({ node }) => {
      const edges = g.getConnectedEdges(node);
      if (Array.isArray(edges)) {
        edges.forEach(edge => {
          this.updateLabel(edge);
        });
      }
    });
    g.on('edge:change:source', ({ edge }) => {
      this.updateLabel(edge);
    });
    g.on('edge:change:target', ({ edge }) => {
      this.updateLabel(edge);
    });
    g.on('edge:change:vertices', ({ edge }) => {
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
  protected debounceUpdateEdge(edge: Edge): void {
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
  protected updateLabel(edge: Edge): void {
    if (this.map.has(edge.id)) {
      edge.trigger('update', this.map.get(edge.id));
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
  protected contextMenu(e: Dom.ContextMenuEvent, edge: Edge): void {
    ContextMenu.showContextMenu({
      x: e.clientX,
      y: e.clientY,
      zIndex: 9999,
      items: [
        {
          label: '删除',
          onClick: async () => {
            const bol = await this.removeEdge(edge);
            if (bol) {
              const index = this.g
                .getSelectedCells()
                .findIndex(cell => cell.id === edge.id);
              if (index !== -1) {
                this.panel.view.call('onActiveRoot');
              }
              this.g.removeEdge(edge.id, { g: this.g });
            }
          },
        },
      ],
    });
  }

  async load(): Promise<void> {
    await this.provider.init(this.context, this.params);
    this.items = await this.provider.select(this.context, this.params);
    if (this.provider.afterLoad) {
      this.provider.afterLoad(this.panel.view as X6DesignViewController);
    }
    this.g.addEdges(
      this.items.map(item => {
        const data = this.provider.createDataProvider(item);
        this.map.set(data.id, data);
        return this.provider.createCell(data);
      }),
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
  async createEdge(edge: Edge): Promise<void> {
    try {
      // 创建连线数据
      const data = await this.provider.create(this.context, this.params, edge);
      // 创建连线数据适配器
      const dataProvider = this.provider.createDataProvider(data);
      // 缓存数据
      this.map.set(dataProvider.id, dataProvider);
      // 删除原本连线，创建新连线并选中。因为连线的id是不可变的，所以需要先删除再创建
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
  async updateEdge(edge: Edge): Promise<void> {
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
  async removeEdge(edge: Edge): Promise<boolean> {
    if (this.map.has(edge.id) === true) {
      const data = await this.provider.delete(
        this.context,
        this.params,
        edge.id,
      );
      if (data) {
        this.map.delete(edge.id);
        return true;
      }
    }
    return false;
  }
}
