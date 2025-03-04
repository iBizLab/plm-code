import {
  IPanelItemController,
  IPanelItemProvider,
  IPanelController,
} from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
import { DndStencilPanelItemController } from './dnd-stencil.controller';

export class DndStencilPanelItemProvider implements IPanelItemProvider {
  component = 'IBizDndStencilPanelItem';

  async createController(
    panelItem: IPanelItem,
    panel: IPanelController,
    parent?: IPanelItemController,
  ): Promise<IPanelItemController> {
    const c = new DndStencilPanelItemController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}
