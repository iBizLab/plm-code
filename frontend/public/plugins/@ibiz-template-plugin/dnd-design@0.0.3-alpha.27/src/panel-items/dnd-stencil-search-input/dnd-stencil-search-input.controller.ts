import { PanelItemController } from '@ibiz-template/runtime';
import { IPanelField } from '@ibiz/model-core';
import { DndDesignViewController } from '../../views';

export class DndStencilSearchInputController extends PanelItemController<IPanelField> {
  get view(): DndDesignViewController {
    return this.panel.view as DndDesignViewController;
  }

  /**
   * 发送消息
   *
   * @author zhanghengfeng
   * @date 2024-01-11 17:01:34
   * @param {string} searchValue
   */
  sendMessage(searchValue: string): void {
    this.view.evt.emit('onStencilSearch', { eventArg: searchValue });
  }
}
