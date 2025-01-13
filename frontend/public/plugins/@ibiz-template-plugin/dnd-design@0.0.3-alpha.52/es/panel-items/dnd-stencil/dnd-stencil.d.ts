import { PropType } from 'vue';
import { IPanelRawItem, ICodeItem } from '@ibiz/model-core';
import { DndStencilPanelItemController } from './dnd-stencil.controller';
import './dnd-stencil.scss';
declare const _default: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IPanelRawItem>;
        required: true;
    };
    controller: {
        type: typeof DndStencilPanelItemController;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    renderGroup: (groupName: string, items: ICodeItem[], i: number, codeName: string) => JSX.Element;
    clone: (item: ICodeItem) => any;
    actives: string[];
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IPanelRawItem>;
        required: true;
    };
    controller: {
        type: typeof DndStencilPanelItemController;
        required: true;
    };
}>>, {}, {}>;
export default _default;
