import Components from './components/index.mjs';
import PanelItems from './panel-items/index.mjs';
import Controls from './controls/index.mjs';
import Editors from './editors/index.mjs';
import './style/index.css';
import './interface/index.mjs';
import './views/index.mjs';
import './utils/index.mjs';
import './preview-providers/index.mjs';
import './panel-items/design-content/index.mjs';
import './panel-items/design_operation/index.mjs';
export { DesignContentState } from './panel-items/design-content/design_content.state.mjs';
export { DesignContentController } from './panel-items/design-content/design-content.controller.mjs';
export { DesignOperationState } from './panel-items/design_operation/design_operation.state.mjs';
export { DesignOperationController } from './panel-items/design_operation/design_operation.controller.mjs';
export { DesignViewControllerBase } from './views/design-view-base.controller.mjs';
export { DesignViewEngineBase } from './views/design-view-base.engine.mjs';
export { SelectState } from './utils/select-state/select-state.mjs';
export { DesignPreViewFactory } from './preview-providers/design-preview-factory.mjs';
export { PreViewProviderBase } from './preview-providers/preview-provider-base.mjs';

"use strict";
var index = {
  install(app) {
    app.use(Components);
    app.use(PanelItems);
    app.use(Controls);
    app.use(Editors);
  }
};

export { index as default };
