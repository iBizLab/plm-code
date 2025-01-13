import {
  IPanelItemController,
  IPanelItemProvider,
  IPanelController,
} from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
import { X6PanelItemTableController } from './x6-panel-item-table.controller';

export class X6PanelItemTableProvider implements IPanelItemProvider {
  component = 'IBizX6PanelItemTable';

  async createController(
    panelItem: IPanelItem,
    panel: IPanelController,
    parent?: IPanelItemController,
  ): Promise<IPanelItemController> {
    const c = new X6PanelItemTableController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}
