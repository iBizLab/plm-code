import { GridFieldEditColumnController, GridRowState } from '@ibiz-template/runtime';
import { IUIActionGroupDetail } from '@ibiz/model-core';
export declare const GridEditColumn: import("vue").DefineComponent<{
    controller: {
        type: typeof GridFieldEditColumnController;
        required: true;
    };
    row: {
        type: typeof GridRowState;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    componentRef: import("vue").Ref<any>;
    fieldName: string;
    gridEditItemProps: IData;
    rowDataChange: (val: unknown, name?: string) => Promise<void>;
    editorProps: IData;
    onCellClick: (event: MouseEvent) => void;
    onTextClick: (event: MouseEvent) => void;
    onInfoTextChange: (text: string) => void;
    onActionClick: (detail: IUIActionGroupDetail, event: MouseEvent) => Promise<void>;
    renderActions: () => IData[];
    CustomHtml: import("vue").ComputedRef<string | undefined>;
    fieldValue: import("vue").ComputedRef<any>;
    formatValue: import("vue").ComputedRef<string>;
    tooltip: import("vue").ComputedRef<string | undefined>;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    controller: {
        type: typeof GridFieldEditColumnController;
        required: true;
    };
    row: {
        type: typeof GridRowState;
        required: true;
    };
}>>, {}, {}>;
