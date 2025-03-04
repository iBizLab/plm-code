import { DndItemController } from '../../controller';
import './mdctrl.scss';
declare const _default: import("vue").DefineComponent<{
    controller: {
        type: typeof DndItemController;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    renderItems: (items: import("@ibiz-template/runtime").IDataEntity[], parent?: import("@ibiz-template/runtime").IDataEntity | undefined, renderChildren?: ((items2: import("@ibiz-template/runtime").IDataEntity[], parent2: import("@ibiz-template/runtime").IDataEntity) => import("vue").VNode<import("vue").RendererNode, import("vue").RendererElement, {
        [key: string]: any;
    }> | import("vue").VNode<import("vue").RendererNode, import("vue").RendererElement, {
        [key: string]: any;
    }>[]) | undefined) => import("vue").VNode<import("vue").RendererNode, import("vue").RendererElement, {
        [key: string]: any;
    }>;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    controller: {
        type: typeof DndItemController;
        required: true;
    };
}>>, {}, {}>;
export default _default;
