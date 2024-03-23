import { PropType } from 'vue';
import { IDEDRTab } from '@ibiz/model-core';
import { IControlProvider } from '@ibiz-template/runtime';
import { DRTabController } from './controller';
export declare const TabExpSelect: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IDEDRTab>;
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
}, {
    c: DRTabController;
    ns: import("@ibiz-template/core").Namespace;
    valueChange: () => void;
    counterData: IData;
    handleTabChange: () => void;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IDEDRTab>;
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
}>>, {
    params: IParams;
}, {}>;
