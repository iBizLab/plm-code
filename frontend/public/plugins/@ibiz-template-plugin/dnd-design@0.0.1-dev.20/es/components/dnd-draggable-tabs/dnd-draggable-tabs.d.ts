import { PropType } from 'vue';
import { IDataEntity } from '@ibiz-template/runtime';
import './dnd-draggable-tabs.scss';
declare const _default: import("vue").DefineComponent<{
    value: {
        type: StringConstructor;
    };
    items: {
        type: PropType<IDataEntity[]>;
        required: true;
        default: () => IDataEntity[];
    };
    dragSwitchPage: {
        type: BooleanConstructor;
        default: boolean;
    };
    select: {
        type: PropType<IDataEntity>;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    uuid: string;
    onDragChange: (evt: IData) => void;
    onItemClick: (item: IDataEntity) => void;
    onConfirm: (item: IDataEntity) => void;
    onAddButtonClick: (e: MouseEvent) => void;
    onDragenter: (_e: DragEvent, item: IDataEntity) => void;
    onDragLeave: (_e: DragEvent, item: IDataEntity) => void;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, ("change" | "drag-change" | "remove" | "add")[], "change" | "drag-change" | "remove" | "add", import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    value: {
        type: StringConstructor;
    };
    items: {
        type: PropType<IDataEntity[]>;
        required: true;
        default: () => IDataEntity[];
    };
    dragSwitchPage: {
        type: BooleanConstructor;
        default: boolean;
    };
    select: {
        type: PropType<IDataEntity>;
    };
}>> & {
    onChange?: ((...args: any[]) => any) | undefined;
    "onDrag-change"?: ((...args: any[]) => any) | undefined;
    onRemove?: ((...args: any[]) => any) | undefined;
    onAdd?: ((...args: any[]) => any) | undefined;
}, {
    items: IDataEntity[];
    dragSwitchPage: boolean;
}, {}>;
export default _default;
