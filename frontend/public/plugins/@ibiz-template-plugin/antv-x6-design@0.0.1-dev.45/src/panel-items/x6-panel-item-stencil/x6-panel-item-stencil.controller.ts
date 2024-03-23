import { CodeListItem, PanelItemController } from '@ibiz-template/runtime';
import { IPanelField, ICodeListEditor, IAppCodeList } from '@ibiz/model-core';
import { Stencil } from '@antv/x6-plugin-stencil';
import { RuntimeModelError, awaitTimeout } from '@ibiz-template/core';
import { X6PanelItemStencilState } from './x6-panel-item-stencil.state';
import { X6PanelItemController } from '../x6-panel-item/x6-panel-item.controller';
import { X6Controller } from '../../controller';
import { X6NodeServiceProvider } from '../../interface';

export class X6PanelItemStencilController extends PanelItemController<IPanelField> {
  protected get x6Controller(): X6PanelItemController {
    return this.panel.panelItems.x6_panel_item as X6PanelItemController;
  }

  /**
   * 挂载容器
   *
   * @author chitanda
   * @date 2023-11-11 15:11:06
   * @protected
   * @type {HTMLDivElement}
   */
  protected container?: HTMLDivElement;

  /**
   * 节点适配器
   *
   * @author chitanda
   * @date 2023-11-16 18:11:29
   * @type {X6NodeServiceProvider}
   */
  get provider(): X6NodeServiceProvider {
    return this.x6.node.provider;
  }

  s?: Stencil;

  get x6(): X6Controller {
    return this.x6Controller.x6;
  }

  protected createState(): X6PanelItemStencilState {
    return new X6PanelItemStencilState(this.parent?.state);
  }

  async initStencil(
    container: HTMLDivElement,
    count: number = 0,
  ): Promise<void> {
    if (this.s) {
      return;
    }
    if (!this.x6Controller || !this.x6) {
      if (count > 10) {
        throw new Error(
          'X6PanelItemStencil: 初始化 stencil 实例失败，未能等找到 x6 控制器',
        );
      }
      await awaitTimeout(300);
      return this.initStencil(container);
    }
    this.container = container;
    if (this.container) {
      let codeList: IAppCodeList | null = null;
      let codeListItems: readonly CodeListItem[] = [];
      const { editor } = this.model;
      if (editor) {
        const { appCodeListId } = editor as ICodeListEditor;
        if (appCodeListId) {
          const app = await ibiz.hub.getApp(this.model.appId);
          codeList = app.codeList.getCodeList(appCodeListId)!;
          const codeItems = await app.codeList.get(
            appCodeListId,
            this.panel.context,
            this.panel.params,
          );
          codeListItems = codeItems.filter(
            item => Array.isArray(item.children) && item.children.length,
          );
        }
      }
      if (!codeList) {
        throw new RuntimeModelError(this.model, `未配置素材区代码表`);
      }
      const { x6 } = this;
      this.s = new Stencil({
        target: this.x6.g,
        search(cell, keyword) {
          if (!keyword) {
            return true;
          }
          const data = cell.getData();
          const text: string = (data && data.text) || '';
          const searchText: string = keyword.trim().toLowerCase();
          return text.toLowerCase().indexOf(searchText) !== -1;
        },
        title: '素材',
        placeholder: '节点名称/节点标识',
        notFoundText: codeList.emptyText,
        collapsable: false,
        stencilGraphHeight: 0,
        layoutOptions: {
          columns: 3,
          center: false,
        },
        getDragNode: (draggingNode, _options) => {
          const codeItem = draggingNode.data as CodeListItem;
          const node = x6.g.createNode(this.provider.createDragCell(codeItem));
          return node;
        },
        validateNode: (droppingNode, options) => {
          return this.provider.validateNode(droppingNode, options);
        },
        groups: codeListItems.map<Stencil.Group>(item => {
          return {
            name: item.id!,
            title: item.text,
            graphHeight: 0,
            collapsable: true,
            collapsed: item.userData === 'contract',
          };
        }),
      });
      this.container.appendChild(this.s.container);
      // 挂载 stencil 节点
      codeListItems.forEach(item => {
        if (item.children) {
          const nodes = item.children.map(codeItem => {
            const node = this.x6.g.createNode(
              this.provider.createMaterialCell(codeItem),
            );
            return node;
          });
          this.s!.load(nodes, item.id!);
        }
      });
    } else {
      throw new Error('X6PanelItemStencil: 初始化容器为空 not found');
    }
  }
}
