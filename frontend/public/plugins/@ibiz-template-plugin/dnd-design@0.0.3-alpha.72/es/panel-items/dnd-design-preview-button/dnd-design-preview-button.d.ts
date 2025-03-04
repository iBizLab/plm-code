import { PropType } from 'vue';
import { IPanelRawItem } from '@ibiz/model-core';
import { DndDesignPreviewButtonController } from './dnd-design-preview-button.controller';
import './dnd-design-preview-button.scss';
declare const _default: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IPanelRawItem>;
        required: true;
    };
    controller: {
        type: typeof DndDesignPreviewButtonController;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IPanelRawItem>;
        required: true;
    };
    controller: {
        type: typeof DndDesignPreviewButtonController;
        required: true;
    };
}>>, {}, {}>;
export default _default;
