import {
  IPanelItemController,
  IPanelItemProvider,
  IPanelController,
} from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
import { X6PanelItemSwitchController } from './x6-panel-item-switch.controller';

export class X6PanelItemSwitchProvider implements IPanelItemProvider {
  component = 'IBizX6PanelItemSwitch';

  async createController(
    panelItem: IPanelItem,
    panel: IPanelController,
    parent?: IPanelItemController,
  ): Promise<IPanelItemController> {
    const c = new X6PanelItemSwitchController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}
