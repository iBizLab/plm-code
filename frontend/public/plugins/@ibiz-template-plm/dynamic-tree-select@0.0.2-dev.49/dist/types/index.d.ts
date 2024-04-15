import { App } from 'vue';
export declare const IBizDynamicTreeSelect: import("@ibiz-template/vue3-util").TypeWithInstall<import("vue").DefineComponent<{
    value: (ObjectConstructor | ArrayConstructor | NumberConstructor | StringConstructor)[];
    controller: import("@ibiz-template/vue3-util").RequiredProp<import("vue").PropType<import("./dynamic-tree-select-controller").DynamicTreeSelectController>, undefined, undefined>;
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
    c: import("./dynamic-tree-select-controller").DynamicTreeSelectController;
    refValue: import("vue").Ref<string>;
    curValue: import("vue").Ref<string | null>;
    valueText: import("vue").ComputedRef<string>;
    loading: import("vue").Ref<boolean>;
    items: import("vue").Ref<IData[]>;
    onOpenChange: (isOpen: boolean) => void;
    onClear: () => void;
    onSelect: (select: string | string[]) => void;
    onSearch: (query: string) => Promise<void>;
    onFocus: (e: IData) => void;
    onBlur: (e: IData) => void;
    onClick: () => void;
    handleKeyUp: (e: KeyboardEvent) => void;
    editorRef: import("vue").Ref<any>;
    isEditable: import("vue").Ref<boolean>;
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
    controller: import("@ibiz-template/vue3-util").RequiredProp<import("vue").PropType<import("./dynamic-tree-select-controller").DynamicTreeSelectController>, undefined, undefined>;
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
}, {}>>;
declare const _default: {
    install(app: App): void;
};
export default _default;
