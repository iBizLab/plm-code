import { Ref } from 'vue';
import { DynamicTreeSelectController } from './dynamic-tree-select-controller';
export declare const DynamicTreeSelect: import("vue").DefineComponent<{
    value: (ObjectConstructor | ArrayConstructor | NumberConstructor | StringConstructor)[];
    controller: import("@ibiz-template/vue3-util").RequiredProp<import("vue").PropType<DynamicTreeSelectController>, undefined, undefined>;
    data: import("@ibiz-template/vue3-util").RequiredProp<import("vue").PropType<IData>, undefined, undefined>;
    disabled: {
        type: BooleanConstructor;
    };
    readonly: {
        type: BooleanConstructor;
        default: boolean;
    };
    autoFocus: {
        type: BooleanConstructor;
        default: boolean;
    };
    overflowMode: {
        type: StringConstructor;
    };
    controlParams: {
        type: ObjectConstructor;
        required: boolean;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    c: DynamicTreeSelectController;
    refValue: Ref<string>;
    curValue: Ref<string | null>;
    valueText: import("vue").ComputedRef<string>;
    loading: Ref<boolean>;
    items: Ref<IData[]>;
    onOpenChange: (isOpen: boolean) => void;
    onClear: () => void;
    onSelect: (select: string | Array<string>) => void;
    onSearch: (query: string) => Promise<void>;
    onFocus: (e: IData) => void;
    onBlur: (e: IData) => void;
    onClick: () => void;
    handleKeyUp: (e: KeyboardEvent) => void;
    editorRef: Ref<any>;
    isEditable: Ref<boolean>;
    setEditable: (flag: boolean) => void;
    showFormDefaultContent: import("vue").ComputedRef<boolean>;
    customNodeClass: (data: IData, _node: Node) => string | null;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {
    change: (_value: unknown, _name?: string | undefined) => boolean;
    blur: (_event?: IData | undefined) => boolean;
    focus: (_event?: IData | undefined) => boolean;
    enter: (_event?: IData | undefined) => boolean;
    infoTextChange: (_text: string) => boolean;
}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    value: (ObjectConstructor | ArrayConstructor | NumberConstructor | StringConstructor)[];
    controller: import("@ibiz-template/vue3-util").RequiredProp<import("vue").PropType<DynamicTreeSelectController>, undefined, undefined>;
    data: import("@ibiz-template/vue3-util").RequiredProp<import("vue").PropType<IData>, undefined, undefined>;
    disabled: {
        type: BooleanConstructor;
    };
    readonly: {
        type: BooleanConstructor;
        default: boolean;
    };
    autoFocus: {
        type: BooleanConstructor;
        default: boolean;
    };
    overflowMode: {
        type: StringConstructor;
    };
    controlParams: {
        type: ObjectConstructor;
        required: boolean;
    };
}>> & {
    onChange?: ((_value: unknown, _name?: string | undefined) => any) | undefined;
    onBlur?: ((_event?: IData | undefined) => any) | undefined;
    onFocus?: ((_event?: IData | undefined) => any) | undefined;
    onEnter?: ((_event?: IData | undefined) => any) | undefined;
    onInfoTextChange?: ((_text: string) => any) | undefined;
}, {
    disabled: boolean;
    readonly: boolean;
    autoFocus: boolean;
}, {}>;
