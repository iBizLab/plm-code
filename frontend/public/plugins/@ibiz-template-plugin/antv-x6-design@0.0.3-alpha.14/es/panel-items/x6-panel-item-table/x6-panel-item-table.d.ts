import { PropType } from 'vue';
import { IPanelRawItem } from '@ibiz/model-core';
import { IDataEntity } from '@ibiz-template/runtime';
import { X6PanelItemTableController } from './x6-panel-item-table.controller';
import { X6PanelItemTableLinkData } from '../../interface';
import './x6-panel-item-table.scss';
declare const _default: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IPanelRawItem>;
        required: true;
    };
    controller: {
        type: typeof X6PanelItemTableController;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    activeStatus: import("vue").Ref<string>;
    table: import("vue").Ref<{
        doLayout: () => void;
    } | null>;
    sourceList: import("vue").Ref<Set<string>>;
    onConnectionChange: (value: boolean, item: X6PanelItemTableLinkData) => Promise<void>;
    onCommand: (command: string, source: IDataEntity) => Promise<void>;
    onEdit: (item: X6PanelItemTableLinkData) => void;
    addStatus: (e: MouseEvent) => Promise<void>;
    onVisibleChange: (visible: boolean, value: string) => void;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IPanelRawItem>;
        required: true;
    };
    controller: {
        type: typeof X6PanelItemTableController;
        required: true;
    };
}>>, {}, {}>;
export default _default;
