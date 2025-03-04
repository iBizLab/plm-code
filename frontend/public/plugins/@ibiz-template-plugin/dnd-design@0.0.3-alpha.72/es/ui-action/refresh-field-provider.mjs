import { UIActionProviderBase } from '@ibiz-template/runtime';

"use strict";
class RefreshFieldProvider extends UIActionProviderBase {
  async execAction(_action, args) {
    const view = args.view;
    const layoutPanel = view.layoutPanel;
    if (layoutPanel) {
      const panelItems = layoutPanel.panelItems;
      if (panelItems) {
        const field = panelItems.dnd_panel_item_stencil_field;
        if (field) {
          await field.load();
        }
      }
    }
    return {};
  }
}

export { RefreshFieldProvider };
