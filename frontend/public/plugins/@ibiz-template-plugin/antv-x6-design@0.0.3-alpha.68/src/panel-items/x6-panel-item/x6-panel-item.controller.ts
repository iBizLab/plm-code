import { PanelItemController } from '@ibiz-template/runtime';
import { IPanelContainer, IPanelRawItem } from '@ibiz/model-core';
import { notNilEmpty } from 'qx-util';
import { X6PanelItemState } from './x6-panel-item.state';
import { X6Controller } from '../../controller';
import { X6DesignViewController } from '../../views';
import { X6CellDataProvider } from '../../interface';

export class X6PanelItemController extends PanelItemController<IPanelContainer> {
  x6!: X6Controller;

  declare state: X6PanelItemState;

  get view(): X6DesignViewController {
    return this.panel.view as X6DesignViewController;
  }

  /**
   * @description 自定义补充参数
   * @type {IData}
   * @memberof X6PanelItemController
   */
  rawItemParams: IData = {};

  protected async onInit(): Promise<void> {
    await super.onInit();
    this.handleRawItemParams();
    this.onSelectDataChange = this.onSelectDataChange.bind(this);
    this.view.select.on(this.onSelectDataChange);
    this.view.evt.on('onSaveSuccess', async () => {
      if (!this.x6 || this.x6.g.disposed) {
        return;
      }
      await this.x6.refresh();
    });
    this.view.evt.on('onRefreshView', async () => {
      if (!this.x6 || this.x6.g.disposed) {
        return;
      }
      await this.x6.refresh();
    });
    this.onPanelActivated = this.onPanelActivated.bind(this);
    this.panel.evt.on('onActivated', this.onPanelActivated);
  }

  /**
   * 监听布局面板激活
   *
   * @author zhanghengfeng
   * @date 2025-01-10 19:01:16
   * @return {*}  {void}
   */
  onPanelActivated(): void {
    if (!this.x6) {
      return;
    }
    this.x6.g.setScrollbarPosition(
      this.x6.scrollbarPosition.left,
      this.x6.scrollbarPosition.top,
    );
  }

  /**
   *监听选中数据变化
   *
   * @author zhanghengfeng
   * @date 2024-01-10 17:01:54
   * @protected
   * @param {(X6CellDataProvider | undefined | null)} data
   */
  protected onSelectDataChange(
    data: X6CellDataProvider | undefined | null,
  ): void {
    if (!this.x6 || this.x6.g.disposed) {
      return;
    }
    if (data && this.view.state.data && data.data === this.view.state.data) {
      this.x6.g.cleanSelection();
    }
  }

  /**
   * 创建面板状态对象
   *
   * @author chitanda
   * @date 2023-01-04 10:01:00
   * @protected
   * @return {*}  {X6PanelItemState}
   */
  protected createState(): X6PanelItemState {
    return new X6PanelItemState(this.parent?.state);
  }

  /**
   * 初始化 x6
   *
   * @author chitanda
   * @date 2023-11-11 13:11:39
   * @param {HTMLDivElement} container
   */
  initX6(container: HTMLDivElement, minimap: HTMLElement): void {
    this.x6 = new X6Controller(this.panel, container, minimap);
    if (this.rawItemParams.showloading) {
      this.x6.evt.on('onBeforeLoad', () => {
        this.state.loading = true;
      });
      this.x6.evt.on('onLoadSuccess', () => {
        this.state.loading = false;
      });
    }
  }

  /**
   * 初始化画布元素选中
   *
   * @author zhanghengfeng
   * @date 2024-01-25 15:01:38
   * @protected
   */
  protected initCellSelection(): void {
    if (
      this.view.select.data &&
      this.view.select.data.data &&
      this.view.select.data.data !== this.view.state.data
    ) {
      const cell = this.x6.g.getCellById(this.view.select.data.id);
      if (cell) {
        this.x6.g.resetSelection(cell);
      }
    }
  }

  /**
   * x6 加载数据
   *
   * @author chitanda
   * @date 2023-11-20 11:11:09
   * @return {*}  {Promise<void>}
   */
  async load(): Promise<void> {
    if (!this.x6) {
      return;
    }
    await this.x6.load();
    this.initCellSelection();
    this.x6.setScrollbarPosition(this.x6.g.getScrollbarPosition());
  }

  /**
   * @description 处理直接内容项参数
   * @protected
   * @memberof X6PanelItemController
   */
  protected handleRawItemParams(): void {
    let params = {};
    const rawItem: IData = (this.model as IPanelRawItem).rawItem || {};
    const rawItemParams = rawItem.rawItemParams;
    if (notNilEmpty(rawItemParams)) {
      params = rawItemParams!.reduce((param: IData, item: IData) => {
        param[item.key!.toLowerCase()] = item.value;
        return param;
      }, {});
    }
    Object.assign(this.rawItemParams, params);
  }

  destroy(): void {
    super.destroy();
    this.x6?.destroy();
    this.view.select.off(this.onSelectDataChange);
    this.panel.evt.off('onActivated', this.onPanelActivated);
  }
}
