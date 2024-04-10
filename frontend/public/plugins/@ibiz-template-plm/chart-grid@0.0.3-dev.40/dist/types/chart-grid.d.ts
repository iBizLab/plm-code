import { PropType } from 'vue';
import { IDEChart } from '@ibiz/model-core';
import { IControlProvider } from '@ibiz-template/runtime';
import { ChartGridController } from './chart-grid-controller';
declare const ChartGrid: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IDEChart>;
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
    mdctrlActiveMode: {
        type: NumberConstructor;
        default: undefined;
    };
    loadDefault: {
        type: BooleanConstructor;
        default: boolean;
    };
}, {
    c: ChartGridController;
    ns: import("@ibiz-template/core").Namespace;
    uuid: string;
    headerStyle: () => {};
    isCollapse: import("vue").Ref<boolean>;
    collapse: () => Promise<void>;
    chartRef: import("vue").Ref<any>;
    tableRef: import("vue").Ref<any>;
    maxHeight: import("vue").Ref<number>;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IDEChart>;
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
    mdctrlActiveMode: {
        type: NumberConstructor;
        default: undefined;
    };
    loadDefault: {
        type: BooleanConstructor;
        default: boolean;
    };
}>>, {
    params: IParams;
    mdctrlActiveMode: number;
    loadDefault: boolean;
}, {}>;
export default ChartGrid;
