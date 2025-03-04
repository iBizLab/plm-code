import { DndItemController } from '../../controller';
import './form-item.scss';
declare const _default: import("vue").DefineComponent<{
    controller: {
        type: typeof DndItemController;
        required: true;
    };
    formItemLabelWidth: {
        type: NumberConstructor;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    renderDesignItem: () => JSX.Element;
    renderContent: () => JSX.Element;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    controller: {
        type: typeof DndItemController;
        required: true;
    };
    formItemLabelWidth: {
        type: NumberConstructor;
    };
}>>, {}, {}>;
export default _default;
