import { PropType } from 'vue';
import { IDataEntity } from '@ibiz-template/runtime';
import { X6LinkDataProvider } from '../../../../interface';
import './logic-design-label.scss';
export declare const LogicDesignLabel: import("vue").DefineComponent<{
    dataProvider: {
        type: PropType<X6LinkDataProvider<IDataEntity>>;
        required: true;
    };
    isOpenLoopPostProcess: {
        type: BooleanConstructor;
        default: boolean;
    };
    sourceNodeOutgoingEdgeLength: {
        type: NumberConstructor;
        default: number;
    };
    logicType: {
        type: StringConstructor;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    logicLinkCount: number;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    dataProvider: {
        type: PropType<X6LinkDataProvider<IDataEntity>>;
        required: true;
    };
    isOpenLoopPostProcess: {
        type: BooleanConstructor;
        default: boolean;
    };
    sourceNodeOutgoingEdgeLength: {
        type: NumberConstructor;
        default: number;
    };
    logicType: {
        type: StringConstructor;
    };
}>>, {
    isOpenLoopPostProcess: boolean;
    sourceNodeOutgoingEdgeLength: number;
}, {}>;
