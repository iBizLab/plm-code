import { PanelItemController } from '@ibiz-template/runtime';
import { notNilEmpty } from 'qx-util';
import { X6PanelItemState } from './x6-panel-item.state.mjs';
import '../../controller/index.mjs';
import { X6Controller } from '../../controller/x6-controller/x6-controller.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class X6PanelItemController extends PanelItemController {
  constructor() {
    super(...arguments);
    __publicField(this, "x6");
    /**
     * @description 自定义补充参数
     * @type {IData}
     * @memberof X6PanelItemController
     */
    __publicField(this, "rawItemParams", {});
  }
  get view() {
    return this.panel.view;
  }
  async onInit() {
    await super.onInit();
    this.handleRawItemParams();
    this.onSelectDataChange = this.onSelectDataChange.bind(this);
    this.view.select.on(this.onSelectDataChange);
    this.view.evt.on("onSaveSuccess", async () => {
      if (!this.x6 || this.x6.g.disposed) {
        return;
      }
      await this.x6.refresh();
    });
    this.view.evt.on("onRefreshView", async () => {
      if (!this.x6 || this.x6.g.disposed) {
        return;
      }
      await this.x6.refresh();
    });
    this.onPanelActivated = this.onPanelActivated.bind(this);
    this.panel.evt.on("onActivated", this.onPanelActivated);
  }
  /**
   * 监听布局面板激活
   *
   * @author zhanghengfeng
   * @date 2025-01-10 19:01:16
   * @return {*}  {void}
   */
  onPanelActivated() {
    if (!this.x6) {
      return;
    }
    this.x6.g.setScrollbarPosition(
      this.x6.scrollbarPosition.left,
      this.x6.scrollbarPosition.top
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
  onSelectDataChange(data) {
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
  createState() {
    var _a;
    return new X6PanelItemState((_a = this.parent) == null ? void 0 : _a.state);
  }
  /**
   * 初始化 x6
   *
   * @author chitanda
   * @date 2023-11-11 13:11:39
   * @param {HTMLDivElement} container
   */
  initX6(container, minimap) {
    this.x6 = new X6Controller(this.panel, container, minimap);
    if (this.rawItemParams.showloading) {
      this.x6.evt.on("onBeforeLoad", () => {
        this.state.loading = true;
      });
      this.x6.evt.on("onLoadSuccess", () => {
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
  initCellSelection() {
    if (this.view.select.data && this.view.select.data.data && this.view.select.data.data !== this.view.state.data) {
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
  async load() {
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
  handleRawItemParams() {
    let params = {};
    const rawItem = this.model.rawItem || {};
    const rawItemParams = rawItem.rawItemParams;
    if (notNilEmpty(rawItemParams)) {
      params = rawItemParams.reduce((param, item) => {
        param[item.key.toLowerCase()] = item.value;
        return param;
      }, {});
    }
    Object.assign(this.rawItemParams, params);
  }
  destroy() {
    var _a;
    super.destroy();
    (_a = this.x6) == null ? void 0 : _a.destroy();
    this.view.select.off(this.onSelectDataChange);
    this.panel.evt.off("onActivated", this.onPanelActivated);
  }
}

export { X6PanelItemController };
