import { App } from 'vue';
import {
  DEServiceUtil,
  registerControlProvider,
  registerViewProvider,
} from '@ibiz-template/runtime';
import { IAppDataEntity } from '@ibiz/model-core';
import DesignBase from '@ibiz-template-plugin/design-base';
import PanelItems from './panel-items';
import Plugins from './plugins';
import { X6DesignViewProvider } from './views';
import { EditFormProvider } from './provider';
import './style/index.scss';
import {
  PSDEDFJoinCondService,
  PSDELogicNodeService,
  PSDELogicLinkService,
  PSWFLinkCondService,
  PSDellCondService,
  PSWFProcessService,
  PSWFLinkService,
} from './service';

export default {
  install(app: App) {
    app.use(DesignBase);
    app.use(PanelItems);
    app.use(Plugins);
    registerViewProvider(
      'VIEW_CUSTOM_X6DesignView',
      () => new X6DesignViewProvider(),
    );
    registerControlProvider(
      'EDITFORM_RENDER_X6DesignNode',
      () => new EditFormProvider(),
    );
    registerControlProvider(
      'EDITFORM_RENDER_X6DesignLink',
      () => new EditFormProvider(),
    );
    registerControlProvider(
      'EDITFORM_RENDER_X6WFDesignNode',
      () => new EditFormProvider(),
    );
    registerControlProvider(
      'EDITFORM_RENDER_X6WFDesignLink',
      () => new EditFormProvider(),
    );

    DEServiceUtil.register(
      'workflowdesign.pswflinkcond',
      async (srfSessionId: string, entityModel: IAppDataEntity) => {
        return new PSWFLinkCondService(srfSessionId, entityModel);
      },
    );

    DEServiceUtil.register(
      'workflowdesign.pswfprocess',
      async (srfSessionId: string, entityModel: IAppDataEntity) => {
        return new PSWFProcessService(srfSessionId, entityModel);
      },
    );

    DEServiceUtil.register(
      'workflowdesign.pswflink',
      async (srfSessionId: string, entityModel: IAppDataEntity) => {
        return new PSWFLinkService(srfSessionId, entityModel);
      },
    );

    // 数据流实体服务
    DEServiceUtil.register(
      'dataflowdesign.psdedfjoincond',
      async (srfSessionId: string, entityModel: IAppDataEntity) => {
        return new PSDEDFJoinCondService(srfSessionId, entityModel);
      },
    );

    DEServiceUtil.register(
      'dataflowdesign.psdelogicnode',
      async (srfSessionId: string, entityModel: IAppDataEntity) => {
        return new PSDELogicNodeService(srfSessionId, entityModel);
      },
    );
    DEServiceUtil.register(
      'logicdesign.psdelogicnode',
      async (srfSessionId: string, entityModel: IAppDataEntity) => {
        return new PSDELogicNodeService(srfSessionId, entityModel);
      },
    );

    DEServiceUtil.register(
      'logicdesign.psdelogiclink',
      async (srfSessionId: string, entityModel: IAppDataEntity) => {
        return new PSDELogicLinkService(srfSessionId, entityModel);
      },
    );

    DEServiceUtil.register(
      'logicdesign.psdellcond',
      async (srfSessionId: string, entityModel: IAppDataEntity) => {
        return new PSDellCondService(srfSessionId, entityModel);
      },
    );
  },
};
