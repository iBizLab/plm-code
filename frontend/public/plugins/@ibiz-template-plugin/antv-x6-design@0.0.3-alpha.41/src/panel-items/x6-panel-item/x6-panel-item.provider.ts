import {
  IPanelItemController,
  IPanelItemProvider,
  IPanelController,
} from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
import { X6PanelItemController } from './x6-panel-item.controller';

export class X6PanelItemProvider implements IPanelItemProvider {
  component = 'IBizX6PanelItem';

  async createController(
    panelItem: IPanelItem,
    panel: IPanelController,
    parent?: IPanelItemController,
  ): Promise<IPanelItemController> {
    const c = new X6PanelItemController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}
