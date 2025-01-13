import { PropType, Ref } from 'vue';
import { IActionItem, ITreeNode } from '../../interface';
import './design-tree.scss';
declare const _default: import("vue").DefineComponent<{
    readOnly: {
        type: BooleanConstructor;
        default: boolean;
    };
    draggable: {
        type: BooleanConstructor;
        default: boolean;
    };
    dropRules: {
        type: PropType<Map<string, RegExp>>;
        default: () => Map<any, any>;
    };
    actions: {
        type: PropType<IActionItem[]>;
        default: () => never[];
    };
    renderItem: {
        type: PropType<(h: any, context: any) => any>;
        required: false;
    };
    nodes: {
        type: PropType<ITreeNode[]>;
        required: true;
    };
    activeNode: {
        type: StringConstructor;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    expendNodeKeys: Ref<string[]>;
    tree: Ref<any>;
    renderTreeItem: (h: any, context: IData) => any;
    allowDrag: (node: IData) => boolean;
    allowDrop: (draggingNode: IData, dropNode: IData, type: string) => boolean;
    handleDrop: (draggingNode: IData, dropNode: IData, dropType: string) => void;
    handNodeSelect: (data: ITreeNode, node: IData) => void;
    handleNodeExpand: (data: ITreeNode) => void;
    handleNodeCollapse: (data: ITreeNode) => void;
    expandAll: () => void;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, ("nodeSelect" | "actionClick" | "nodeDrop")[], "nodeSelect" | "actionClick" | "nodeDrop", import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    readOnly: {
        type: BooleanConstructor;
        default: boolean;
    };
    draggable: {
        type: BooleanConstructor;
        default: boolean;
    };
    dropRules: {
        type: PropType<Map<string, RegExp>>;
        default: () => Map<any, any>;
    };
    actions: {
        type: PropType<IActionItem[]>;
        default: () => never[];
    };
    renderItem: {
        type: PropType<(h: any, context: any) => any>;
        required: false;
    };
    nodes: {
        type: PropType<ITreeNode[]>;
        required: true;
    };
    activeNode: {
        type: StringConstructor;
    };
}>> & {
    onNodeSelect?: ((...args: any[]) => any) | undefined;
    onActionClick?: ((...args: any[]) => any) | undefined;
    onNodeDrop?: ((...args: any[]) => any) | undefined;
}, {
    readOnly: boolean;
    draggable: boolean;
    dropRules: Map<string, RegExp>;
    actions: IActionItem[];
}, {}>;
export default _default;
