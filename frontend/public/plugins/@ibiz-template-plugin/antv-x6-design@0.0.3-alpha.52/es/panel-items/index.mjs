import X6PanelItem from './x6-panel-item/index.mjs';
import X6PanelItemStencil from './x6-panel-item-stencil/index.mjs';
import X6PanelItemSwitch from './x6-panel-item-switch/index.mjs';
import X6PanelItemTable from './x6-panel-item-table/index.mjs';

"use strict";
var PanelItems = {
  install(app) {
    app.use(X6PanelItem);
    app.use(X6PanelItemStencil);
    app.use(X6PanelItemSwitch);
    app.use(X6PanelItemTable);
  }
};

export { PanelItems as default };
