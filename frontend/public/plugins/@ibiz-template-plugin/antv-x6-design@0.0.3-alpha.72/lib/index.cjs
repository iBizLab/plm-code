'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var runtime = require('@ibiz-template/runtime');
var DesignBase = require('@ibiz-template-plugin/design-base');
var index$1 = require('./panel-items/index.cjs');
var index$2 = require('./plugins/index.cjs');
require('./views/index.cjs');
require('./provider/index.cjs');
require('./style/index.css');
require('./service/index.cjs');
var x6DesignView_provider = require('./views/x6-design-view/x6-design-view.provider.cjs');
var editForm_provider = require('./provider/edit-form.provider.cjs');
var pswflinkcond_service = require('./service/pswflinkcond/pswflinkcond.service.cjs');
var pswfprocess_service = require('./service/pswfprocess/pswfprocess.service.cjs');
var pswflink_service = require('./service/pswflink/pswflink.service.cjs');
var psdedfjoincond_service = require('./service/psdedfjoincond/psdedfjoincond.service.cjs');
var psdelogicnode_service = require('./service/psdelogicnode/psdelogicnode.service.cjs');
var psdelogiclink_service = require('./service/psdelogiclink/psdelogiclink.service.cjs');
var psdellcond_service = require('./service/psdellcond/psdellcond.service.cjs');

"use strict";
var index = {
  install(app) {
    app.use(DesignBase);
    app.use(index$1.default);
    app.use(index$2.default);
    runtime.registerViewProvider(
      "VIEW_CUSTOM_X6DesignView",
      () => new x6DesignView_provider.X6DesignViewProvider()
    );
    runtime.registerControlProvider(
      "EDITFORM_RENDER_X6DesignNode",
      () => new editForm_provider.EditFormProvider()
    );
    runtime.registerControlProvider(
      "EDITFORM_RENDER_X6DesignLink",
      () => new editForm_provider.EditFormProvider()
    );
    runtime.registerControlProvider(
      "EDITFORM_RENDER_X6WFDesignNode",
      () => new editForm_provider.EditFormProvider()
    );
    runtime.registerControlProvider(
      "EDITFORM_RENDER_X6WFDesignLink",
      () => new editForm_provider.EditFormProvider()
    );
    runtime.DEServiceUtil.register(
      "workflowdesign.pswflinkcond",
      async (srfSessionId, entityModel) => {
        return new pswflinkcond_service.PSWFLinkCondService(srfSessionId, entityModel);
      }
    );
    runtime.DEServiceUtil.register(
      "workflowdesign.pswfprocess",
      async (srfSessionId, entityModel) => {
        return new pswfprocess_service.PSWFProcessService(srfSessionId, entityModel);
      }
    );
    runtime.DEServiceUtil.register(
      "workflowdesign.pswflink",
      async (srfSessionId, entityModel) => {
        return new pswflink_service.PSWFLinkService(srfSessionId, entityModel);
      }
    );
    runtime.DEServiceUtil.register(
      "dataflowdesign.psdedfjoincond",
      async (srfSessionId, entityModel) => {
        return new psdedfjoincond_service.PSDEDFJoinCondService(srfSessionId, entityModel);
      }
    );
    runtime.DEServiceUtil.register(
      "dataflowdesign.psdelogicnode",
      async (srfSessionId, entityModel) => {
        return new psdelogicnode_service.PSDELogicNodeService(srfSessionId, entityModel);
      }
    );
    runtime.DEServiceUtil.register(
      "logicdesign.psdelogicnode",
      async (srfSessionId, entityModel) => {
        return new psdelogicnode_service.PSDELogicNodeService(srfSessionId, entityModel);
      }
    );
    runtime.DEServiceUtil.register(
      "logicdesign.psdelogiclink",
      async (srfSessionId, entityModel) => {
        return new psdelogiclink_service.PSDELogicLinkService(srfSessionId, entityModel);
      }
    );
    runtime.DEServiceUtil.register(
      "logicdesign.psdellcond",
      async (srfSessionId, entityModel) => {
        return new psdellcond_service.PSDellCondService(srfSessionId, entityModel);
      }
    );
  }
};

exports.default = index;
