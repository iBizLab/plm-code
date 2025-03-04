import {
  IPanelItemController,
  IPanelItemProvider,
  IPanelController,
} from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
import { DndDesignPreviewButtonController } from './dnd-design-preview-button.controller';

export class DndDesignPreviewButtonProvider implements IPanelItemProvider {
  component = 'IBizDndDesignPreviewButton';

  async createController(
    panelItem: IPanelItem,
    panel: IPanelController,
    parent?: IPanelItemController,
  ): Promise<IPanelItemController> {
    const c = new DndDesignPreviewButtonController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}
