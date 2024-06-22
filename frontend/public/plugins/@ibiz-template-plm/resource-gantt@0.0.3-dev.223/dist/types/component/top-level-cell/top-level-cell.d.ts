import { PropType } from 'vue';
export declare const TopLevelCell: import("vue").DefineComponent<{
    cellData: {
        type: ObjectConstructor;
        required: true;
        default: () => void;
    };
    showText: {
        type: BooleanConstructor;
        required: true;
        default: boolean;
    };
    capacityCalc: {
        type: ObjectConstructor;
        required: true;
        default: () => void;
    };
    weekdays: {
        type: PropType<number[]>;
        default: () => never[];
    };
    dayCapacity: {
        type: NumberConstructor;
        default: number;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    renderContent: () => "" | JSX.Element;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, "cellClick"[], "cellClick", import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    cellData: {
        type: ObjectConstructor;
        required: true;
        default: () => void;
    };
    showText: {
        type: BooleanConstructor;
        required: true;
        default: boolean;
    };
    capacityCalc: {
        type: ObjectConstructor;
        required: true;
        default: () => void;
    };
    weekdays: {
        type: PropType<number[]>;
        default: () => never[];
    };
    dayCapacity: {
        type: NumberConstructor;
        default: number;
    };
}>> & {
    onCellClick?: ((...args: any[]) => any) | undefined;
}, {
    cellData: Record<string, any>;
    capacityCalc: Record<string, any>;
    weekdays: number[];
    dayCapacity: number;
}, {}>;
