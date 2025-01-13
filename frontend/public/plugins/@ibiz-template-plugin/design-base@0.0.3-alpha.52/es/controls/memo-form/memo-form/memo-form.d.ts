import { FormController } from '@ibiz-template/runtime';
import { IDEFormDetail } from '@ibiz/model-core';
import { PropType, VNode } from 'vue';
import './memo-form.scss';
export declare const MemoFormControl: import("vue").DefineComponent<{
    controller: {
        type: PropType<FormController<import("@ibiz/model-core").IDEForm, import("@ibiz-template/runtime").IFormState, import("@ibiz-template/runtime").IFormEvent>>;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    c: FormController<import("@ibiz/model-core").IDEForm, import("@ibiz-template/runtime").IFormState, import("@ibiz-template/runtime").IFormEvent>;
    FormDetail: {
        (_props: {
            modelData: IDEFormDetail | IDEFormDetail[];
        }): (VNode | VNode[] | undefined)[];
        props: string[];
    };
    slotProps: IData;
    renderByDetailType: (detail: IDEFormDetail, hidden?: boolean) => VNode | VNode[] | undefined;
    renderAttrs: (model: IDEFormDetail) => IParams;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    controller: {
        type: PropType<FormController<import("@ibiz/model-core").IDEForm, import("@ibiz-template/runtime").IFormState, import("@ibiz-template/runtime").IFormEvent>>;
        required: true;
    };
}>>, {}, {}>;
