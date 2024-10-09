import {
  UIActionProviderBase,
  IUILogicParams,
  IUIActionResult,
} from '@ibiz-template/runtime';
import { IAppDEUIAction } from '@ibiz/model-core';
import { DndStencilFieldController } from '../plugins/dnd-stencil-field';

export class RefreshFieldProvider extends UIActionProviderBase {
  async execAction(
    _action: IAppDEUIAction,
    args: IUILogicParams,
  ): Promise<IUIActionResult> {
    const view = args.view;
    const layoutPanel = view.layoutPanel;
    if (layoutPanel) {
      const panelItems = layoutPanel.panelItems;
      if (panelItems) {
        const field =
          panelItems.dnd_panel_item_stencil_field as DndStencilFieldController;
        if (field) {
          await field.load();
        }
      }
    }
    return {};
  }
}
