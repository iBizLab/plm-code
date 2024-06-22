import {
  IPanelItemController,
  IPanelItemProvider,
  IPanelController,
} from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
import { ActiveHomeButtonController } from './active-home-button.controller';

export class ActiveHomeButtonProvider implements IPanelItemProvider {
  component = 'IBizActiveHomeButton';

  async createController(
    panelItem: IPanelItem,
    panel: IPanelController,
    parent?: IPanelItemController,
  ): Promise<IPanelItemController> {
    const c = new ActiveHomeButtonController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}
