import { App } from 'vue';
import X6PanelItem from './x6-panel-item';
import X6PanelItemStencil from './x6-panel-item-stencil';
import X6PanelItemSwitch from './x6-panel-item-switch';
import X6PanelItemTable from './x6-panel-item-table';

export default {
  install(app: App) {
    app.use(X6PanelItem);
    app.use(X6PanelItemStencil);
    app.use(X6PanelItemSwitch);
    app.use(X6PanelItemTable);
  },
};
