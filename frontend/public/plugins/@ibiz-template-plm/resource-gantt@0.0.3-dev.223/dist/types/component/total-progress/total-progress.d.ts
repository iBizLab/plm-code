import { PropType } from 'vue';
import { TreeGridExRowState } from '@ibiz-template/runtime';
export declare const TotalProgress: import("vue").DefineComponent<{
    row: {
        type: typeof TreeGridExRowState;
        required: true;
    };
    weekdays: {
        type: PropType<number[]>;
        default: () => never[];
    };
    dayCapacity: {
        type: NumberConstructor;
        default: number;
    };
    capacityCalc: {
        type: ObjectConstructor;
        required: true;
        default: () => void;
    };
    dateRange: {
        type: ObjectConstructor;
        required: true;
        default: () => void;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    numerator: import("vue").Ref<number>;
    denominator: import("vue").Ref<number>;
    percentage: import("vue").ComputedRef<number>;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    row: {
        type: typeof TreeGridExRowState;
        required: true;
    };
    weekdays: {
        type: PropType<number[]>;
        default: () => never[];
    };
    dayCapacity: {
        type: NumberConstructor;
        default: number;
    };
    capacityCalc: {
        type: ObjectConstructor;
        required: true;
        default: () => void;
    };
    dateRange: {
        type: ObjectConstructor;
        required: true;
        default: () => void;
    };
}>>, {
    capacityCalc: Record<string, any>;
    weekdays: number[];
    dayCapacity: number;
    dateRange: Record<string, any>;
}, {}>;
