import { App } from 'vue';
import { DEServiceUtil, registerViewProvider } from '@ibiz-template/runtime';
import { IAppDataEntity } from '@ibiz/model-core';
import DesignBase from '@ibiz-template-plugin/design-base';
import { DndDesignViewProvider, FormPreviewViewProvider } from './views';
import Components from './components';
import PanelItems from './panel-items';
import DndItems from './dnd-items';
import Plugins from './plugins';
import UIAction from './ui-action';
import PreviewProviders from './preview-providers';
import { PSDEFDLogicService, PSDEFormDetailService } from './service';
import './style/index.scss';

export default {
  install(app: App) {
    DEServiceUtil.register(
      'formdesign.psdeformdetail',
      async (srfSessionId: string, entityModel: IAppDataEntity) => {
        return new PSDEFormDetailService(srfSessionId, entityModel);
      },
    );

    DEServiceUtil.register(
      'formdesign.psdefdlogic',
      async (srfSessionId: string, entityModel: IAppDataEntity) => {
        return new PSDEFDLogicService(srfSessionId, entityModel);
      },
    );

    app.use(PreviewProviders);

    app.use(UIAction);
    app.use(DesignBase);
    app.use(Components);
    app.use(PanelItems);
    app.use(DndItems);
    app.use(Plugins);

    registerViewProvider(
      'VIEW_CUSTOM_DndDesign',
      () => new DndDesignViewProvider(),
    );

    registerViewProvider(
      'VIEW_CUSTOM_DndDesign_DESIGN',
      () => new DndDesignViewProvider(),
    );

    registerViewProvider(
      'VIEW_CUSTOM_FORM_PREVIEW_VIEW',
      () => new FormPreviewViewProvider(),
    );
  },
};
