import {
  IPanelItemController,
  IPanelItemProvider,
  IPanelController,
} from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
import { DndStencilFieldController } from './dnd-stencil-field.controller';

export class DndStencilFieldProvider implements IPanelItemProvider {
  component = 'IBizDndStencilPanelItem';

  async createController(
    panelItem: IPanelItem,
    panel: IPanelController,
    parent?: IPanelItemController,
  ): Promise<IPanelItemController> {
    const c = new DndStencilFieldController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}
