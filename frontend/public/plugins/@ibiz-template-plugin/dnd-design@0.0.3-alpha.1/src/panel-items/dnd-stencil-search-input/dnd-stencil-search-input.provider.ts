import {
  IPanelItemController,
  IPanelItemProvider,
  IPanelController,
} from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
import { DndStencilSearchInputController } from './dnd-stencil-search-input.controller';

export class DndStencilSearchInputProvider implements IPanelItemProvider {
  component = 'IBizDndStencilSearchInput';

  async createController(
    panelItem: IPanelItem,
    panel: IPanelController,
    parent?: IPanelItemController,
  ): Promise<IPanelItemController> {
    const c = new DndStencilSearchInputController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}
