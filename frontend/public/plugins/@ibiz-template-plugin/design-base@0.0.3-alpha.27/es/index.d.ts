import { App } from 'vue';
import './style/index.scss';
declare const _default: {
    install(app: App): void;
};
export default _default;
export * from './interface';
export * from './views';
export * from './utils';
export * from './preview-providers';
export { DesignContentState, DesignContentController, } from './panel-items/design-content';
export { DesignOperationState, DesignOperationController, } from './panel-items/design_operation';
