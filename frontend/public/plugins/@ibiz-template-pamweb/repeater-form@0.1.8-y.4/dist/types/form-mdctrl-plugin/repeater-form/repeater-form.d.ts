import { EventBase, FormMDCtrlRepeaterController } from '@ibiz-template/runtime';
export declare const RepeaterForm: import("vue").DefineComponent<{
    controller: {
        type: typeof FormMDCtrlRepeaterController;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    onFormDataChange: (index: number, event: EventBase) => void;
    onCreated: (index: number, event: EventBase) => void;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    controller: {
        type: typeof FormMDCtrlRepeaterController;
        required: true;
    };
}>>, {}, {}>;
