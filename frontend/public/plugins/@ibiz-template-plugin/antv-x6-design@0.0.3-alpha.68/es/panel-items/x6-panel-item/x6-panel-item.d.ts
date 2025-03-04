import { PropType } from 'vue';
import { IPanelRawItem } from '@ibiz/model-core';
import { X6PanelItemController } from './x6-panel-item.controller';
import './x6-panel-item.scss';
declare const _default: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IPanelRawItem>;
        required: true;
    };
    controller: {
        type: typeof X6PanelItemController;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    shellNS: import("@ibiz-template/core").Namespace;
    theme: import("vue").Ref<string>;
    x6Ref: import("vue").Ref<null>;
    x6ContainerRef: import("vue").Ref<HTMLElement | undefined>;
    x6MiniMapRef: import("vue").Ref<HTMLElement | undefined>;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IPanelRawItem>;
        required: true;
    };
    controller: {
        type: typeof X6PanelItemController;
        required: true;
    };
}>>, {}, {}>;
export default _default;
