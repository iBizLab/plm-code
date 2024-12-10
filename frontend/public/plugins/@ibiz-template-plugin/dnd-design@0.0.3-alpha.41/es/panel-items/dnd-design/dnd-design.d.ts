import { PropType, VNode } from 'vue';
import { IPanelRawItem } from '@ibiz/model-core';
import { IDataEntity } from '@ibiz-template/runtime';
import { DndDesignPanelItemController } from './dnd-design.controller';
import './dnd-design.scss';
declare const _default: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IPanelRawItem>;
        required: true;
    };
    controller: {
        type: typeof DndDesignPanelItemController;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    shellNS: import("@ibiz-template/core").Namespace;
    theme: import("vue").Ref<string>;
    renderItems: (items: IDataEntity[], parent?: IDataEntity, renderChildren?: ((items2: IDataEntity[], parent2: IDataEntity) => VNode | VNode[]) | undefined) => VNode;
    renderFormPage: () => VNode;
    onActiveRoot: (e: MouseEvent) => void;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IPanelRawItem>;
        required: true;
    };
    controller: {
        type: typeof DndDesignPanelItemController;
        required: true;
    };
}>>, {}, {}>;
export default _default;
