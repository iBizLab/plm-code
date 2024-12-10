import { PropType } from 'vue';
import { IDEFormMDCtrl, IUIActionGroupDetail } from '@ibiz/model-core';
import { FormMDCtrlController } from '@ibiz-template/runtime';
export declare const FormMDCtrlPlugin: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IDEFormMDCtrl>;
        required: true;
    };
    controller: {
        type: typeof FormMDCtrlController;
        required: true;
    };
}, {
    c: FormMDCtrlController;
    ns: import("@ibiz-template/core").Namespace;
    hasCaption: boolean | undefined;
    hasHeader: true | import("@ibiz/model-core").IUIActionGroup | undefined;
    onActionClick: (detail: IUIActionGroupDetail, event: MouseEvent) => Promise<void>;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IDEFormMDCtrl>;
        required: true;
    };
    controller: {
        type: typeof FormMDCtrlController;
        required: true;
    };
}>>, {}, {}>;
export default FormMDCtrlPlugin;
