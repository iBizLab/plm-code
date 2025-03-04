import { PanelItemController } from '@ibiz-template/runtime';
import { DndDesignPreviewButtonState } from './dnd-design-preview-button.state.mjs';

"use strict";
class DndDesignPreviewButtonController extends PanelItemController {
  /**
   * 创建面板状态对象
   *
   * @author zhanghengfeng
   * @date 2025-02-14 20:02:36
   * @protected
   * @return {*}  {DndDesignPreviewButtonState}
   */
  createState() {
    var _a;
    return new DndDesignPreviewButtonState((_a = this.parent) == null ? void 0 : _a.state);
  }
  /**
   * 视图控制器
   *
   * @author zhanghengfeng
   * @date 2025-02-14 20:02:43
   * @readonly
   * @type {DndDesignViewController}
   */
  get view() {
    return this.panel.view;
  }
  /**
   * 处理按钮点击
   *
   * @author zhanghengfeng
   * @date 2025-02-14 20:02:05
   */
  handleButtonClick() {
    this.state.isPreview = !this.state.isPreview;
    this.view.evt.emit("onPreviewStateChange", {
      isPreview: this.state.isPreview
    });
  }
}

export { DndDesignPreviewButtonController };
