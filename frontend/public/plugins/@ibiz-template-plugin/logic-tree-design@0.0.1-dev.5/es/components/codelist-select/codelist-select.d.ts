import { PropType } from 'vue';
import { CodeListItem } from '@ibiz-template/runtime';
import './codelist-select.scss';
export declare const CodeListSelect: import("vue").DefineComponent<{
    codeListId: {
        type: StringConstructor;
        required: true;
    };
    context: {
        type: PropType<IContext>;
        required: true;
    };
    params: {
        type: PropType<IParams>;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    codeListItems: import("vue").Ref<readonly CodeListItem[] | undefined>;
    onSelect: (item: CodeListItem) => void;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, "select"[], "select", import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    codeListId: {
        type: StringConstructor;
        required: true;
    };
    context: {
        type: PropType<IContext>;
        required: true;
    };
    params: {
        type: PropType<IParams>;
    };
}>> & {
    onSelect?: ((...args: any[]) => any) | undefined;
}, {}, {}>;
