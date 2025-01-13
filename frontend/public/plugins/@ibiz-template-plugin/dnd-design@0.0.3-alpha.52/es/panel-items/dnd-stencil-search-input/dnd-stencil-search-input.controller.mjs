import { PanelItemController } from '@ibiz-template/runtime';

"use strict";
class DndStencilSearchInputController extends PanelItemController {
  get view() {
    return this.panel.view;
  }
  /**
   * 发送消息
   *
   * @author zhanghengfeng
   * @date 2024-01-11 17:01:34
   * @param {string} searchValue
   */
  sendMessage(searchValue) {
    this.view.evt.emit("onStencilSearch", { eventArg: searchValue });
  }
}

export { DndStencilSearchInputController };
