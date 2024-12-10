'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var runtime = require('@ibiz-template/runtime');
var DesignBase = require('@ibiz-template-plugin/design-base');
require('./views/index.cjs');
require('./editor-plugin/editor-params/index.cjs');
var index$3 = require('./components/index.cjs');
var index$4 = require('./editor-plugin/index.cjs');
var index$5 = require('./panel-items/index.cjs');
var index$6 = require('./dnd-items/index.cjs');
var index$7 = require('./plugins/index.cjs');
var index$2 = require('./ui-action/index.cjs');
var index$1 = require('./preview-providers/index.cjs');
require('./service/index.cjs');
require('./style/index.css');
var psdeformDetail_service = require('./service/psdeform-detail/psdeform-detail.service.cjs');
var psdefdlogic_service = require('./service/psdefdlogic/psdefdlogic.service.cjs');
var dndDesignView_provider = require('./views/dnd-design-view/dnd-design-view.provider.cjs');
var formPreviewView_provider = require('./views/form-preview-view/form-preview-view.provider.cjs');
var editorParamsProvider = require('./editor-plugin/editor-params/editor-params-provider.cjs');

"use strict";
var index = {
  install(app) {
    runtime.DEServiceUtil.register(
      "formdesign.psdeformdetail",
      async (srfSessionId, entityModel) => {
        return new psdeformDetail_service.PSDEFormDetailService(srfSessionId, entityModel);
      }
    );
    runtime.DEServiceUtil.register(
      "formdesign.psdefdlogic",
      async (srfSessionId, entityModel) => {
        return new psdefdlogic_service.PSDEFDLogicService(srfSessionId, entityModel);
      }
    );
    app.use(index$1.default);
    app.use(index$2.default);
    app.use(DesignBase);
    app.use(index$3.default);
    app.use(index$4.default);
    app.use(index$5.default);
    app.use(index$6.default);
    app.use(index$7.default);
    runtime.registerViewProvider(
      "VIEW_CUSTOM_DndDesign",
      () => new dndDesignView_provider.DndDesignViewProvider()
    );
    runtime.registerViewProvider(
      "VIEW_CUSTOM_DndDesign_DESIGN",
      () => new dndDesignView_provider.DndDesignViewProvider()
    );
    runtime.registerViewProvider(
      "VIEW_CUSTOM_FORM_PREVIEW_VIEW",
      () => new formPreviewView_provider.FormPreviewViewProvider()
    );
    runtime.registerEditorProvider(
      "EDITOR_CUSTOMSTYLE_EditorParamCustom",
      () => new editorParamsProvider.EditorParamsProvider()
    );
  }
};

exports.default = index;
