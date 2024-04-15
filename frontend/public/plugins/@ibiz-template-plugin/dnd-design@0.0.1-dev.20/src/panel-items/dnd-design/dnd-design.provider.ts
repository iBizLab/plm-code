import {
  IPanelItemController,
  IPanelItemProvider,
  IPanelController,
} from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
import { DndDesignPanelItemController } from './dnd-design.controller';

export class DndDesignPanelItemProvider implements IPanelItemProvider {
  component = 'IBizDndDesignPanelItem';

  async createController(
    panelItem: IPanelItem,
    panel: IPanelController,
    parent?: IPanelItemController,
  ): Promise<IPanelItemController> {
    const c = new DndDesignPanelItemController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}
