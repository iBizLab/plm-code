import { App } from 'vue';
export declare const IBizTrackTreeGridControl: import("@ibiz-template/vue3-util").TypeWithInstall<import("vue").DefineComponent<{
    modelData: {
        type: import("vue").PropType<import("@ibiz/model-core").IDETree>;
        required: true;
    };
    context: {
        type: import("vue").PropType<IContext>;
        required: true;
    };
    params: {
        type: import("vue").PropType<IParams>;
        default: () => {};
    };
    provider: {
        type: import("vue").PropType<import("@ibiz-template/runtime").IControlProvider>;
    };
    mdctrlActiveMode: {
        type: NumberConstructor;
        default: undefined;
    };
    singleSelect: {
        type: BooleanConstructor;
        default: undefined;
    };
    navigational: {
        type: BooleanConstructor;
        default: undefined;
    };
    defaultExpandedKeys: {
        type: import("vue").PropType<string[]>;
    };
    loadDefault: {
        type: BooleanConstructor;
        default: boolean;
    };
    checkStrictly: {
        type: BooleanConstructor;
        default: boolean;
    };
    isSimple: {
        type: BooleanConstructor;
        default: boolean;
    };
    data: {
        type: {
            (arrayLength: number): import("./track-tree-grid.controller").ITrackTreeGridNodeData[];
            (...items: import("./track-tree-grid.controller").ITrackTreeGridNodeData[]): import("./track-tree-grid.controller").ITrackTreeGridNodeData[];
            new (arrayLength: number): import("./track-tree-grid.controller").ITrackTreeGridNodeData[];
            new (...items: import("./track-tree-grid.controller").ITrackTreeGridNodeData[]): import("./track-tree-grid.controller").ITrackTreeGridNodeData[];
            isArray(arg: any): arg is any[];
            readonly prototype: any[];
            from<T>(arrayLike: ArrayLike<T>): T[];
            from<T_1, U>(arrayLike: ArrayLike<T_1>, mapfn: (v: T_1, k: number) => U, thisArg?: any): U[];
            from<T_2>(iterable: Iterable<T_2> | ArrayLike<T_2>): T_2[];
            from<T_3, U_1>(iterable: Iterable<T_3> | ArrayLike<T_3>, mapfn: (v: T_3, k: number) => U_1, thisArg?: any): U_1[];
            of<T_4>(...items: T_4[]): T_4[];
            readonly [Symbol.species]: ArrayConstructor;
        };
        required: false;
    };
}, {
    c: import("./track-tree-grid.controller").TrackTreeGridController<import("@ibiz/model-core").IDETree, import("@ibiz-template/runtime").ITreeState, import("@ibiz-template/runtime").ITreeEvent>;
    ns: import("@ibiz-template/core").Namespace;
    renderContent: () => JSX.Element;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, "nodeClick"[], "nodeClick", import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: import("vue").PropType<import("@ibiz/model-core").IDETree>;
        required: true;
    };
    context: {
        type: import("vue").PropType<IContext>;
        required: true;
    };
    params: {
        type: import("vue").PropType<IParams>;
        default: () => {};
    };
    provider: {
        type: import("vue").PropType<import("@ibiz-template/runtime").IControlProvider>;
    };
    mdctrlActiveMode: {
        type: NumberConstructor;
        default: undefined;
    };
    singleSelect: {
        type: BooleanConstructor;
        default: undefined;
    };
    navigational: {
        type: BooleanConstructor;
        default: undefined;
    };
    defaultExpandedKeys: {
        type: import("vue").PropType<string[]>;
    };
    loadDefault: {
        type: BooleanConstructor;
        default: boolean;
    };
    checkStrictly: {
        type: BooleanConstructor;
        default: boolean;
    };
    isSimple: {
        type: BooleanConstructor;
        default: boolean;
    };
    data: {
        type: {
            (arrayLength: number): import("./track-tree-grid.controller").ITrackTreeGridNodeData[];
            (...items: import("./track-tree-grid.controller").ITrackTreeGridNodeData[]): import("./track-tree-grid.controller").ITrackTreeGridNodeData[];
            new (arrayLength: number): import("./track-tree-grid.controller").ITrackTreeGridNodeData[];
            new (...items: import("./track-tree-grid.controller").ITrackTreeGridNodeData[]): import("./track-tree-grid.controller").ITrackTreeGridNodeData[];
            isArray(arg: any): arg is any[];
            readonly prototype: any[];
            from<T>(arrayLike: ArrayLike<T>): T[];
            from<T_1, U>(arrayLike: ArrayLike<T_1>, mapfn: (v: T_1, k: number) => U, thisArg?: any): U[];
            from<T_2>(iterable: Iterable<T_2> | ArrayLike<T_2>): T_2[];
            from<T_3, U_1>(iterable: Iterable<T_3> | ArrayLike<T_3>, mapfn: (v: T_3, k: number) => U_1, thisArg?: any): U_1[];
            of<T_4>(...items: T_4[]): T_4[];
            readonly [Symbol.species]: ArrayConstructor;
        };
        required: false;
    };
}>> & {
    onNodeClick?: ((...args: any[]) => any) | undefined;
}, {
    params: IParams;
    mdctrlActiveMode: number;
    singleSelect: boolean;
    navigational: boolean;
    loadDefault: boolean;
    checkStrictly: boolean;
    isSimple: boolean;
}, {}>>;
declare const _default: {
    install(app: App): void;
};
export default _default;
