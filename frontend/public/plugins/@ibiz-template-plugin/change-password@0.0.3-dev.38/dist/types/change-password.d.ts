import { PropType } from 'vue';
import { IModal } from '@ibiz-template/runtime';
export declare const ChangePassword: import("vue").DefineComponent<{
    modal: {
        type: PropType<IModal>;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    form: IData;
    rules: Partial<Record<string, import("element-plus/es/utils").Arrayable<import("element-plus").FormItemRule>>>;
    formRef: import("vue").Ref<any>;
    onConfirm: () => Promise<void>;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modal: {
        type: PropType<IModal>;
    };
}>>, {}, {}>;
