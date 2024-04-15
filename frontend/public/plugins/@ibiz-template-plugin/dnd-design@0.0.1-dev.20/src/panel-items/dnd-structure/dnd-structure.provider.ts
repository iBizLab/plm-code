import {
  IPanelItemController,
  IPanelItemProvider,
  IPanelController,
} from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
import { DndStructurePanelItemController } from './dnd-structure.controller';

export class DndStructurePanelItemProvider implements IPanelItemProvider {
  component = 'IBizDndStructurePanelItem';

  async createController(
    panelItem: IPanelItem,
    panel: IPanelController,
    parent?: IPanelItemController,
  ): Promise<IPanelItemController> {
    const c = new DndStructurePanelItemController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}
