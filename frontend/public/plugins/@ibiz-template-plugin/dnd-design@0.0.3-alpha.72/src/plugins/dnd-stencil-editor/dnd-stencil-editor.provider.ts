import {
  IPanelItemController,
  IPanelItemProvider,
  IPanelController,
} from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
import { DndStencilEditorController } from './dnd-stencil-editor.controller';

export class DndStencilEditorProvider implements IPanelItemProvider {
  component = 'IBizDndStencilPanelItem';

  async createController(
    panelItem: IPanelItem,
    panel: IPanelController,
    parent?: IPanelItemController,
  ): Promise<IPanelItemController> {
    const c = new DndStencilEditorController(panelItem, panel, parent);
    await c.init();
    return c;
  }
}
