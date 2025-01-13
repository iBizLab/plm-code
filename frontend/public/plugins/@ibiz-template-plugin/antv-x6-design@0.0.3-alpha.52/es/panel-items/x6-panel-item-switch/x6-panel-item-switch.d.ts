import { PropType, Ref } from 'vue';
import { ICodeItem, IPanelField } from '@ibiz/model-core';
import { X6PanelItemSwitchController } from './x6-panel-item-switch.controller';
import './x6-panel-item-switch.scss';
declare const _default: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IPanelField>;
        required: true;
    };
    controller: {
        type: typeof X6PanelItemSwitchController;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    activeItem: Ref<string>;
    indicatorStyle: Ref<IData>;
    content: Ref<any>;
    onClick: (e: MouseEvent, item: ICodeItem) => void;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IPanelField>;
        required: true;
    };
    controller: {
        type: typeof X6PanelItemSwitchController;
        required: true;
    };
}>>, {}, {}>;
export default _default;
