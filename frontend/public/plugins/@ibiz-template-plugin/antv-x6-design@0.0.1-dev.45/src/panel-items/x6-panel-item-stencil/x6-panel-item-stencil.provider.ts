import {
  IPanelItemController,
  IPanelItemProvider,
  IPanelController,
} from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
import { X6PanelItemStencilController } from './x6-panel-item-stencil.controller';

export class X6PanelItemStencilProvider implements IPanelItemProvider {
  component = 'IBizX6PanelItemStencil';

  async createController(
    panelItem: IPanelItem,
    panel: IPanelController,
    parent?: IPanelItemController,
  ): Promise<IPanelItemController> {
    const c = new X6PanelItemStencilController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}
