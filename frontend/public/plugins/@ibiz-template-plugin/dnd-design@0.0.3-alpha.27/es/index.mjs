import { DEServiceUtil, registerViewProvider, registerEditorProvider } from '@ibiz-template/runtime';
import DesignBase from '@ibiz-template-plugin/design-base';
import './views/index.mjs';
import './editor-plugin/editor-params/index.mjs';
import Components from './components/index.mjs';
import editorPulgin from './editor-plugin/index.mjs';
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
import { EditorParamsProvider } from './editor-plugin/editor-params/editor-params-provider.mjs';

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
    app.use(editorPulgin);
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
    registerEditorProvider(
      "EDITOR_CUSTOMSTYLE_EditorParamCustom",
      () => new EditorParamsProvider()
    );
  }
};

export { index as default };
