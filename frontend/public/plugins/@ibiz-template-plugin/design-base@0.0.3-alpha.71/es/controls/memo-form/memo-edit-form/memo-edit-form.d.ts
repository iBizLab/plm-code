import { IControlProvider } from '@ibiz-template/runtime';
import { IDEEditForm } from '@ibiz/model-core';
import { PropType } from 'vue';
import { MemoEditFormController } from './memo-edit-form.controller';
export declare const MemoEditFormControl: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IDEEditForm>;
        required: true;
    };
    context: {
        type: PropType<IContext>;
        required: true;
    };
    params: {
        type: PropType<IParams>;
        default: () => {};
    };
    provider: {
        type: PropType<IControlProvider>;
    };
    isSimple: {
        type: BooleanConstructor;
        required: false;
    };
    data: {
        type: PropType<IData>;
        required: false;
    };
    loadDefault: {
        type: BooleanConstructor;
        default: boolean;
    };
}, {
    c: MemoEditFormController;
    ns: import("@ibiz-template/core").Namespace;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IDEEditForm>;
        required: true;
    };
    context: {
        type: PropType<IContext>;
        required: true;
    };
    params: {
        type: PropType<IParams>;
        default: () => {};
    };
    provider: {
        type: PropType<IControlProvider>;
    };
    isSimple: {
        type: BooleanConstructor;
        required: false;
    };
    data: {
        type: PropType<IData>;
        required: false;
    };
    loadDefault: {
        type: BooleanConstructor;
        default: boolean;
    };
}>>, {
    params: IParams;
    isSimple: boolean;
    loadDefault: boolean;
}, {}>;
