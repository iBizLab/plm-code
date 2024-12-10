import { PreviewViewControllerBase } from '@ibiz-template-plugin/design-base';
import { FormPreviewViewEngine } from './form-preview-view.engine.mjs';
import { DndPreViewFactory } from '../../preview-providers/dnd-preview-factory.mjs';

"use strict";
class FormPreviewViewController extends PreviewViewControllerBase {
  /**
   * 初始化预览适配器
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof FormPreviewViewController
   */
  async initPreViewProvider() {
    this.preViewProvider = DndPreViewFactory.getInstance().getProvider(
      "DESIGN"
    );
    await this.preViewProvider.init(this);
  }
  /**
   * 初始化引擎
   *
   * @protected
   * @memberof FormPreviewViewController
   */
  initEngines() {
    this.engines.push(new FormPreviewViewEngine(this));
  }
}

export { FormPreviewViewController };
