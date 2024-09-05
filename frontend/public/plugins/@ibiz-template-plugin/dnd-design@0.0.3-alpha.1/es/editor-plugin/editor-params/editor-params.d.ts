import { Ref } from 'vue';
import { IDEFormItem } from '@ibiz/model-core';
import { EditorParamsController } from './editor-params.controller';
import './editor-params-custom.scss';
interface DynamicParam {
    id: string;
    key: string;
    value: string;
    type: 'param' | 'srfnavparam' | 'srfnavctx';
}
declare const _default: import("vue").DefineComponent<{
    value: (NumberConstructor | StringConstructor)[];
    controller: import("@ibiz-template/vue3-util").RequiredProp<import("vue").PropType<EditorParamsController>, undefined, undefined>;
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
    c: EditorParamsController;
    isCustom: Ref<boolean>;
    changeIscustom: () => void;
    dynamicItems: Ref<DynamicParam[]>;
    formItems: Ref<IDEFormItem[]>;
    addDynamicParam: (type: DynamicParam['type']) => void;
    editorParams: Ref<string | undefined>;
    typeMap: {
        param: string;
        srfnavparam: string;
        srfnavctx: string;
    };
    formData: Ref<Record<string, unknown>>;
    onEditorTypeChange: (editorTypeStr: string) => void;
    transformEditorParams: (editorParamsStr: string) => void;
    editorType: string | undefined;
    onCustomParamChange: (valueStr: string) => void;
    onDynamicParamChange: (value: string, item: DynamicParam, key: 'key' | 'value') => void;
    deleteDynamicParam: (index: number) => void;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {
    change: (_value: unknown, _name?: string | undefined) => boolean;
    blur: (_event?: IData | undefined) => boolean;
    focus: (_event?: IData | undefined) => boolean;
    enter: (_event?: IData | undefined) => boolean;
    infoTextChange: (_text: string) => boolean;
}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    value: (NumberConstructor | StringConstructor)[];
    controller: import("@ibiz-template/vue3-util").RequiredProp<import("vue").PropType<EditorParamsController>, undefined, undefined>;
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
    onFocus?: ((_event?: IData | undefined) => any) | undefined;
    onBlur?: ((_event?: IData | undefined) => any) | undefined;
    onChange?: ((_value: unknown, _name?: string | undefined) => any) | undefined;
    onEnter?: ((_event?: IData | undefined) => any) | undefined;
    onInfoTextChange?: ((_text: string) => any) | undefined;
}, {
    disabled: boolean;
    readonly: boolean;
    autoFocus: boolean;
}, {}>;
export default _default;
