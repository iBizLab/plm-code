import { PropType } from 'vue';
import { IPanelRawItem } from '@ibiz/model-core';
import { ActiveHomeButtonController } from './active-home-button.controller';
import './active-home-button.scss';
declare const _default: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IPanelRawItem>;
        required: true;
    };
    controller: {
        type: typeof ActiveHomeButtonController;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    onActiveRoot: (e: MouseEvent) => void;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IPanelRawItem>;
        required: true;
    };
    controller: {
        type: typeof ActiveHomeButtonController;
        required: true;
    };
}>>, {}, {}>;
export default _default;