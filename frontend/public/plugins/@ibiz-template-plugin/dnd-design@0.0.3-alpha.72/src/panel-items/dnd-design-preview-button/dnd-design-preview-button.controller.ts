import { PanelItemController } from '@ibiz-template/runtime';
import { IPanelField } from '@ibiz/model-core';
import { DndDesignPreviewButtonState } from './dnd-design-preview-button.state';
import { DndDesignViewController } from '../../views';

export class DndDesignPreviewButtonController extends PanelItemController<IPanelField> {
  /**
   * 面板项状态
   *
   * @author zhanghengfeng
   * @date 2025-02-14 20:02:26
   * @type {DndDesignPreviewButtonState}
   */
  declare state: DndDesignPreviewButtonState;

  /**
   * 创建面板状态对象
   *
   * @author zhanghengfeng
   * @date 2025-02-14 20:02:36
   * @protected
   * @return {*}  {DndDesignPreviewButtonState}
   */
  protected createState(): DndDesignPreviewButtonState {
    return new DndDesignPreviewButtonState(this.parent?.state);
  }

  /**
   * 视图控制器
   *
   * @author zhanghengfeng
   * @date 2025-02-14 20:02:43
   * @readonly
   * @type {DndDesignViewController}
   */
  get view(): DndDesignViewController {
    return this.panel.view as DndDesignViewController;
  }

  /**
   * 处理按钮点击
   *
   * @author zhanghengfeng
   * @date 2025-02-14 20:02:05
   */
  handleButtonClick(): void {
    this.state.isPreview = !this.state.isPreview;
    this.view.evt.emit('onPreviewStateChange', {
      isPreview: this.state.isPreview,
    });
  }
}
