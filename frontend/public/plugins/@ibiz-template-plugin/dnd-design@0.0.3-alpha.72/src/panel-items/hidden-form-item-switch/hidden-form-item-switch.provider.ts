import {
  IPanelItemController,
  IPanelItemProvider,
  IPanelController,
  PanelItemController,
} from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';

export class HiddenFormItemSwitchProvider implements IPanelItemProvider {
  component = 'IBizHiddenFormItemSwitch';

  async createController(
    panelItem: IPanelItem,
    panel: IPanelController,
    parent?: IPanelItemController,
  ): Promise<IPanelItemController> {
    const c = new PanelItemController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}
