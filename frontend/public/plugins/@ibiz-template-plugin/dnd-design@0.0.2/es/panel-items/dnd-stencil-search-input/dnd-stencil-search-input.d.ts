import { IPanelRawItem } from '@ibiz/model-core';
import { PropType } from 'vue';
import { DndStencilSearchInputController } from './dnd-stencil-search-input.controller';
import './dnd-stencil-search-input.scss';
declare const _default: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IPanelRawItem>;
        required: true;
    };
    controller: {
        type: typeof DndStencilSearchInputController;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    searchValue: import("vue").Ref<string>;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IPanelRawItem>;
        required: true;
    };
    controller: {
        type: typeof DndStencilSearchInputController;
        required: true;
    };
}>>, {}, {}>;
export default _default;
