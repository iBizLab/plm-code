export declare const IBizFormMDCtrl: import("@ibiz-template/vue3-util").TypeWithInstall<import("vue").DefineComponent<{
    modelData: {
        type: import("vue").PropType<import("@ibiz/model-core").IDEFormMDCtrl>;
        required: true;
    };
    controller: {
        type: typeof import("@ibiz-template/runtime").FormMDCtrlController;
        required: true;
    };
}, {
    c: import("@ibiz-template/runtime").FormMDCtrlController;
    ns: import("@ibiz-template/core").Namespace;
    hasCaption: boolean | undefined;
    hasHeader: true | import("@ibiz/model-core").IUIActionGroup | undefined;
    onActionClick: (detail: import("@ibiz/model-core").IUIActionGroupDetail, event: MouseEvent) => Promise<void>;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: import("vue").PropType<import("@ibiz/model-core").IDEFormMDCtrl>;
        required: true;
    };
    controller: {
        type: typeof import("@ibiz-template/runtime").FormMDCtrlController;
        required: true;
    };
}>>, {}, {}>>;
export default IBizFormMDCtrl;
