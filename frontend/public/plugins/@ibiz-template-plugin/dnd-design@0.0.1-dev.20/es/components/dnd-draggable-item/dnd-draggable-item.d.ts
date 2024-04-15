import { PropType } from 'vue';
import { IActionItem } from '../../interface';
import './dnd-draggable-item.scss';
declare const _default: import("vue").DefineComponent<{
    isSelect: {
        type: BooleanConstructor;
        default: boolean;
    };
    item: {
        type: PropType<IData>;
        required: true;
    };
    actions: {
        type: PropType<IActionItem[]>;
        required: false;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    layoutStyle: import("vue").ComputedRef<{
        width: string;
        height: string;
    }>;
    onClick: (e: MouseEvent, action: IActionItem) => void;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    isSelect: {
        type: BooleanConstructor;
        default: boolean;
    };
    item: {
        type: PropType<IData>;
        required: true;
    };
    actions: {
        type: PropType<IActionItem[]>;
        required: false;
    };
}>>, {
    isSelect: boolean;
}, {}>;
export default _default;
