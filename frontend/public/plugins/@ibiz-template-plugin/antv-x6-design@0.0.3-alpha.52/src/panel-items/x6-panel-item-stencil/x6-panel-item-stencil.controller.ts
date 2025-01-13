import {
  CodeListItem,
  PanelItemController,
  ScriptFactory,
  UIActionUtil,
} from '@ibiz-template/runtime';
import { IPanelField, ICodeListEditor, IAppCodeList } from '@ibiz/model-core';
import { Stencil } from '@antv/x6-plugin-stencil';
import { RuntimeModelError, awaitTimeout } from '@ibiz-template/core';
import { Graph } from '@antv/x6';
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

  /**
   * @description 行为参数
   * @type {IData}
   * @memberof X6PanelItemStencilController
   */
  actionParams: IData = {};

  /**
   * @description 是否显示分组头
   * @type {boolean}
   * @memberof X6PanelItemStencilController
   */
  showGroupHeader: boolean = false;

  /**
   * @description 节点数组
   * @type {IData[]}
   * @memberof X6PanelItemStencilController
   */
  nodes: IData[] = [];

  protected createState(): X6PanelItemStencilState {
    return new X6PanelItemStencilState(this.parent?.state);
  }

  /**
   *  加载代码表
   *
   * @author fangZhiHao
   * @date 2024-07-24 09:07:24
   * @param {string} appCodeListId
   * @return {*}
   */
  public async loadCodeList(appCodeListId: string) {
    let codeListItems: CodeListItem[] = [];
    const app = await ibiz.hub.getApp(this.model.appId);
    const codeItems = (await app.codeList.get(
      appCodeListId,
      this.panel.context,
      this.panel.params,
    )) as CodeListItem[];
    if (this.showGroupHeader) {
      codeListItems = codeItems;
    } else {
      codeListItems = codeItems.filter(
        item => Array.isArray(item.children) && item.children.length,
      );
    }
    codeListItems.forEach(item => {
      if (Array.isArray(item.children)) {
        item.children.forEach(child => {
          if (typeof child.data === 'string') {
            child.data = ScriptFactory.execSingleLine(child.data) as IData;
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
  fillAction(codeListItems: CodeListItem[]) {
    codeListItems.forEach(item => {
      const action = this.actionParams[item.id];
      if (action) {
        const data = item.data || {};
        Object.assign(item, { data: { action, ...data } });
      }
      if (Array.isArray(item.children)) {
        item.children.forEach(x => {
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
  public loadNodes(codeListItems: CodeListItem[]) {
    this.nodes = [];
    codeListItems.forEach(item => {
      let nodes: IData[] = [];
      if (item.children) {
        nodes = item.children.map(codeItem => {
          const param = codeItem;
          if (param.data && param.data.action && param.data.action.remove) {
            Object.assign(param.data, {
              actionID: param.data.action.remove,
            });
          }
          const node = this.x6.g.createNode(
            this.provider.createMaterialCell(param),
          );
          return node;
        });
      }
      const data = item.data || {};
      if (data.action && data.action.add) {
        const addNode = this.x6.g.createNode(
          this.provider.createMaterialAddCell({
            id: 'add',
            data: { actionID: data.action.add },
            text: '新增',
            value: 'add',
          } as CodeListItem),
        );
        nodes.push(addNode);
      }
      this.nodes.push(...nodes);
      this.s!.load(nodes, item.id!);
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
    const graphs = (this.s! as IData).graphs;
    Object.keys(this.actionParams).forEach(key => {
      const graph: Graph = graphs[key];
      if (graph) {
        graph.on('render:done', () => {
          const nodes = graph.container.querySelectorAll('.x6-node');
          nodes.forEach(node => {
            const dataId = node.getAttribute('data-cell-id');
            const cell = graph.getCellById(dataId!);
            if (this.actionParams[key].remove) {
              this.registerNodeEvent(
                node,
                cell,
                '.ibiz-material-node-delete-icon',
              );
            }
            if (this.actionParams[key].add) {
              this.registerNodeEvent(node, cell, '.ibiz-material-add-node');
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
  async registerNodeEvent(container: Element, cell: IData, className: string) {
    const element = container.querySelector(className) as IData;
    if (element) {
      if (element.classList.contains('is-active')) {
        return;
      }
      element.classList.add('is-active');
      element.addEventListener(
        'mousedown',
        async (event: MouseEvent) => {
          if (cell.data && cell.data.data && cell.data.data.actionID) {
            const uiActionId = `${cell.data.data.actionID}`;
            event.preventDefault();
            event.stopPropagation();
            await UIActionUtil.execAndResolved(
              uiActionId,
              {
                context: this.panel.context,
                params: {
                  panelDataParent: this.dataParent.model.id!,
                  cellid: cell.data.id,
                  ...this.panel.params,
                },
                data: [this.data],
                view: this.panel.view,
                event,
                noWaitRoute: true,
              },
              this.model.appId,
            );
          }
        },
        { captrue: true, passive: false },
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
    const graphs = (this.s! as IData).graphs as Graph[];
    Object.values(graphs).forEach((graph: Graph) => {
      graph.clearCells({ refresh: true });
    });
    const { appCodeListId } = this.model.editor as ICodeListEditor;
    if (appCodeListId) {
      const codeListItems: CodeListItem[] =
        await this.loadCodeList(appCodeListId);
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
  initEditorParams(editorParams: IData) {
    if (editorParams) {
      Object.keys(editorParams).forEach((key: string) => {
        const keys = key.split('_');
        if (keys.length === 3 && keys[2] === 'ACTION') {
          const action = this.actionParams[keys[0]] || {};
          this.actionParams[keys[0]] = {
            [keys[1].toLowerCase()]: editorParams[key],
            ...action,
          };
        }
      });
      if (editorParams.SHOWHEADER) {
        this.showGroupHeader =
          editorParams.SHOWHEADER === 'true' ||
          editorParams.SHOWHEADER === 'TRUE';
      }
    }
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
      let codeListItems: CodeListItem[] = [];
      const { editor } = this.model;
      if (editor) {
        const { appCodeListId, editorParams = {} } = editor as ICodeListEditor;
        this.initEditorParams(editorParams);
        if (appCodeListId) {
          // 加载代码表 并计算界面行为
          const app = await ibiz.hub.getApp(this.model.appId);
          codeList = app.codeList.getCodeList(appCodeListId)!;
          codeListItems = await this.loadCodeList(appCodeListId);
          this.fillAction(codeListItems);
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
      this.loadNodes(codeListItems);
      this.initEevnt();
    } else {
      throw new Error('X6PanelItemStencil: 初始化容器为空 not found');
    }
  }
}
