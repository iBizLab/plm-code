import { App } from 'vue';
import Components from './components';
import PanelItems from './panel-items';
import Controls from './controls';
import Editors from './editors';
import './style/index.scss';

export default {
  install(app: App) {
    app.use(Components);
    app.use(PanelItems);
    app.use(Controls);
    app.use(Editors);
  },
};

export * from './interface';
export * from './views';
export * from './utils';
export * from './preview-providers';
export {
  DesignContentState,
  DesignContentController,
} from './panel-items/design-content';
export {
  DesignOperationState,
  DesignOperationController,
} from './panel-items/design_operation';
export {
  PreviewContentState,
  PreviewContentController,
} from './panel-items/preview-content';
