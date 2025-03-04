import { registerViewProvider, registerControlProvider, DEServiceUtil } from '@ibiz-template/runtime';
import DesignBase from '@ibiz-template-plugin/design-base';
import PanelItems from './panel-items/index.mjs';
import Plugins from './plugins/index.mjs';
import './views/index.mjs';
import './provider/index.mjs';
import './style/index.css';
import './service/index.mjs';
import { X6DesignViewProvider } from './views/x6-design-view/x6-design-view.provider.mjs';
import { EditFormProvider } from './provider/edit-form.provider.mjs';
import { PSWFLinkCondService } from './service/pswflinkcond/pswflinkcond.service.mjs';
import { PSWFProcessService } from './service/pswfprocess/pswfprocess.service.mjs';
import { PSWFLinkService } from './service/pswflink/pswflink.service.mjs';
import { PSDEDFJoinCondService } from './service/psdedfjoincond/psdedfjoincond.service.mjs';
import { PSDELogicNodeService } from './service/psdelogicnode/psdelogicnode.service.mjs';
import { PSDELogicLinkService } from './service/psdelogiclink/psdelogiclink.service.mjs';
import { PSDellCondService } from './service/psdellcond/psdellcond.service.mjs';

"use strict";
var index = {
  install(app) {
    app.use(DesignBase);
    app.use(PanelItems);
    app.use(Plugins);
    registerViewProvider(
      "VIEW_CUSTOM_X6DesignView",
      () => new X6DesignViewProvider()
    );
    registerControlProvider(
      "EDITFORM_RENDER_X6DesignNode",
      () => new EditFormProvider()
    );
    registerControlProvider(
      "EDITFORM_RENDER_X6DesignLink",
      () => new EditFormProvider()
    );
    registerControlProvider(
      "EDITFORM_RENDER_X6WFDesignNode",
      () => new EditFormProvider()
    );
    registerControlProvider(
      "EDITFORM_RENDER_X6WFDesignLink",
      () => new EditFormProvider()
    );
    DEServiceUtil.register(
      "workflowdesign.pswflinkcond",
      async (srfSessionId, entityModel) => {
        return new PSWFLinkCondService(srfSessionId, entityModel);
      }
    );
    DEServiceUtil.register(
      "workflowdesign.pswfprocess",
      async (srfSessionId, entityModel) => {
        return new PSWFProcessService(srfSessionId, entityModel);
      }
    );
    DEServiceUtil.register(
      "workflowdesign.pswflink",
      async (srfSessionId, entityModel) => {
        return new PSWFLinkService(srfSessionId, entityModel);
      }
    );
    DEServiceUtil.register(
      "dataflowdesign.psdedfjoincond",
      async (srfSessionId, entityModel) => {
        return new PSDEDFJoinCondService(srfSessionId, entityModel);
      }
    );
    DEServiceUtil.register(
      "dataflowdesign.psdelogicnode",
      async (srfSessionId, entityModel) => {
        return new PSDELogicNodeService(srfSessionId, entityModel);
      }
    );
    DEServiceUtil.register(
      "logicdesign.psdelogicnode",
      async (srfSessionId, entityModel) => {
        return new PSDELogicNodeService(srfSessionId, entityModel);
      }
    );
    DEServiceUtil.register(
      "logicdesign.psdelogiclink",
      async (srfSessionId, entityModel) => {
        return new PSDELogicLinkService(srfSessionId, entityModel);
      }
    );
    DEServiceUtil.register(
      "logicdesign.psdellcond",
      async (srfSessionId, entityModel) => {
        return new PSDellCondService(srfSessionId, entityModel);
      }
    );
  }
};

export { index as default };
