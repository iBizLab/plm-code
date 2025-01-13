import { PropType } from 'vue';
import { IDEEditForm, IDESearchForm } from '@ibiz/model-core';
import './form-shell.scss';
declare const _default: import("vue").DefineComponent<{
    context: {
        type: PropType<IContext>;
        required: true;
    };
    data: {
        type: PropType<IData>;
        required: true;
    };
    items: {
        type: PropType<IData[]>;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    shellNS: import("@ibiz-template/core").Namespace;
    modelData: import("vue").Ref<IDEEditForm | IDESearchForm | undefined>;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    context: {
        type: PropType<IContext>;
        required: true;
    };
    data: {
        type: PropType<IData>;
        required: true;
    };
    items: {
        type: PropType<IData[]>;
        required: true;
    };
}>>, {}, {}>;
export default _default;
