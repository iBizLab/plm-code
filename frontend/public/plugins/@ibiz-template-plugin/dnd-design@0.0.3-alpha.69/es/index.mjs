import { DEServiceUtil, registerViewProvider } from '@ibiz-template/runtime';
import DesignBase from '@ibiz-template-plugin/design-base';
import './views/index.mjs';
import Components from './components/index.mjs';
import PanelItems from './panel-items/index.mjs';
import DndItems from './dnd-items/index.mjs';
import Plugins from './plugins/index.mjs';
import UIAction from './ui-action/index.mjs';
import PreviewProviders from './preview-providers/index.mjs';
import './service/index.mjs';
import './style/index.css';
import { PSDEFormDetailService } from './service/psdeform-detail/psdeform-detail.service.mjs';
import { PSDEFDLogicService } from './service/psdefdlogic/psdefdlogic.service.mjs';
import { DndDesignViewProvider } from './views/dnd-design-view/dnd-design-view.provider.mjs';
import { FormPreviewViewProvider } from './views/form-preview-view/form-preview-view.provider.mjs';

"use strict";
var index = {
  install(app) {
    DEServiceUtil.register(
      "formdesign.psdeformdetail",
      async (srfSessionId, entityModel) => {
        return new PSDEFormDetailService(srfSessionId, entityModel);
      }
    );
    DEServiceUtil.register(
      "formdesign.psdefdlogic",
      async (srfSessionId, entityModel) => {
        return new PSDEFDLogicService(srfSessionId, entityModel);
      }
    );
    app.use(PreviewProviders);
    app.use(UIAction);
    app.use(DesignBase);
    app.use(Components);
    app.use(PanelItems);
    app.use(DndItems);
    app.use(Plugins);
    registerViewProvider(
      "VIEW_CUSTOM_DndDesign",
      () => new DndDesignViewProvider()
    );
    registerViewProvider(
      "VIEW_CUSTOM_DndDesign_DESIGN",
      () => new DndDesignViewProvider()
    );
    registerViewProvider(
      "VIEW_CUSTOM_FORM_PREVIEW_VIEW",
      () => new FormPreviewViewProvider()
    );
  }
};

export { index as default };
