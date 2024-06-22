import { PropType } from 'vue';
import { IPanelField } from '@ibiz/model-core';
import { X6PanelItemStencilController } from './x6-panel-item-stencil.controller';
import './x6-panel-item-stencil.scss';
declare const _default: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IPanelField>;
        required: true;
    };
    controller: {
        type: typeof X6PanelItemStencilController;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    domRef: import("vue").Ref<null>;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IPanelField>;
        required: true;
    };
    controller: {
        type: typeof X6PanelItemStencilController;
        required: true;
    };
}>>, {}, {}>;
export default _default;
