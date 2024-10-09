import { App } from 'vue';
import LogicDesignPlugin from './logic-design';
import workFlowDesign from './work-flow-design';

export default {
  install(app: App) {
    app.use(LogicDesignPlugin);
    app.use(workFlowDesign);
  },
};
