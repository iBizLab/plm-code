import { PropType } from 'vue';
import { GridController } from '@ibiz-template/runtime';
export declare const GanttColumns: import("vue").DefineComponent<{
    controller: {
        type: PropType<GridController<import("@ibiz/model-core").IDEGrid, import("@ibiz-template/runtime").IGridState, import("@ibiz-template/runtime").IGridEvent>>;
        required: true;
    };
    columns: {
        type: PropType<IData[]>;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    renderColumn: (column: IData) => JSX.Element;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    controller: {
        type: PropType<GridController<import("@ibiz/model-core").IDEGrid, import("@ibiz-template/runtime").IGridState, import("@ibiz-template/runtime").IGridEvent>>;
        required: true;
    };
    columns: {
        type: PropType<IData[]>;
        required: true;
    };
}>>, {}, {}>;
export default GanttColumns;
