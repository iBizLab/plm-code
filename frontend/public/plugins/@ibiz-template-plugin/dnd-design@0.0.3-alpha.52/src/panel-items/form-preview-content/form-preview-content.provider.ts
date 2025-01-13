import {
  IPanelItemController,
  IPanelItemProvider,
  IPanelController,
} from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
import { FormPreviewContentController } from './form-preview-content.controller';

/**
 * 表单预览内容区适配器
 *
 * @export
 * @class FormPreviewContentProvider
 * @implements {IPanelItemProvider}
 */
export class FormPreviewContentProvider implements IPanelItemProvider {
  component = 'IBizFormPreviewContent';

  async createController(
    panelItem: IPanelItem,
    panel: IPanelController,
    parent?: IPanelItemController,
  ): Promise<IPanelItemController> {
    const c = new FormPreviewContentController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}
