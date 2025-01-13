import { PropType } from 'vue';
import { IDETree } from '@ibiz/model-core';
import { IControlProvider } from '@ibiz-template/runtime';
import { ITrackTreeGridNodeData, TrackTreeGridController } from './track-tree-grid.controller';
export declare const TrackTreeGrid: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IDETree>;
        required: true;
    };
    context: {
        type: PropType<IContext>;
        required: true;
    };
    params: {
        type: PropType<IParams>;
        default: () => {};
    };
    provider: {
        type: PropType<IControlProvider>;
    };
    /**
     * 部件行数据默认激活模式
     * - 0 不激活
     * - 1 单击激活
     * - 2 双击激活(默认值)
     *
     * @type {(number | 0 | 1 | 2)}
     */
    mdctrlActiveMode: {
        type: NumberConstructor;
        default: undefined;
    };
    /**
     * 是否为单选
     * - true 单选
     * - false 多选
     *
     * @type {(Boolean)}
     */
    singleSelect: {
        type: BooleanConstructor;
        default: undefined;
    };
    navigational: {
        type: BooleanConstructor;
        default: undefined;
    };
    defaultExpandedKeys: {
        type: PropType<string[]>;
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
            (arrayLength: number): ITrackTreeGridNodeData[];
            (...items: ITrackTreeGridNodeData[]): ITrackTreeGridNodeData[];
            new (arrayLength: number): ITrackTreeGridNodeData[];
            new (...items: ITrackTreeGridNodeData[]): ITrackTreeGridNodeData[];
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
    c: TrackTreeGridController<IDETree, import("@ibiz-template/runtime").ITreeState, import("@ibiz-template/runtime").ITreeEvent>;
    ns: import("@ibiz-template/core").Namespace;
    renderContent: () => JSX.Element;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, "nodeClick"[], "nodeClick", import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IDETree>;
        required: true;
    };
    context: {
        type: PropType<IContext>;
        required: true;
    };
    params: {
        type: PropType<IParams>;
        default: () => {};
    };
    provider: {
        type: PropType<IControlProvider>;
    };
    /**
     * 部件行数据默认激活模式
     * - 0 不激活
     * - 1 单击激活
     * - 2 双击激活(默认值)
     *
     * @type {(number | 0 | 1 | 2)}
     */
    mdctrlActiveMode: {
        type: NumberConstructor;
        default: undefined;
    };
    /**
     * 是否为单选
     * - true 单选
     * - false 多选
     *
     * @type {(Boolean)}
     */
    singleSelect: {
        type: BooleanConstructor;
        default: undefined;
    };
    navigational: {
        type: BooleanConstructor;
        default: undefined;
    };
    defaultExpandedKeys: {
        type: PropType<string[]>;
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
            (arrayLength: number): ITrackTreeGridNodeData[];
            (...items: ITrackTreeGridNodeData[]): ITrackTreeGridNodeData[];
            new (arrayLength: number): ITrackTreeGridNodeData[];
            new (...items: ITrackTreeGridNodeData[]): ITrackTreeGridNodeData[];
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
}, {}>;
