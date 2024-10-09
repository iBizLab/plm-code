import { PropType } from 'vue';
import { IDataEntity } from '@ibiz-template/runtime';
import { IDndDesignPanelItemController, IDndItemController } from '../../interface';
import './tab-panel.scss';
declare const _default: import("vue").DefineComponent<{
    controller: {
        type: PropType<IDndItemController>;
        required: true;
    };
    dndDesignController: {
        type: PropType<IDndDesignPanelItemController>;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    activePage: import("vue").Ref<string | undefined>;
    select: import("vue").Ref<{
        [x: string]: any;
        [x: symbol]: any;
        srfdeid: string;
        srfdecodename: string;
        srfkeyfield: string;
        srfmajorfield: string;
        srfpkey?: string | undefined;
        srfkey: string;
        tempsrfkey: string;
        srfmajortext: string;
        srfuf: import("@ibiz-template/runtime").Srfuf;
        clone: () => IDataEntity;
        assign: (data: IData | IDataEntity) => IDataEntity;
    }>;
    onActivePageChange: (item: IDataEntity) => void;
    onPagePositionChange: (evt: IData) => Promise<void>;
    onPageAdd: () => Promise<void>;
    onPageRemove: (page: IDataEntity) => Promise<void>;
    renderItems: (items: IDataEntity[], parent?: IDataEntity | undefined, renderChildren?: ((items2: IDataEntity[], parent2: IDataEntity) => import("vue").VNode<import("vue").RendererNode, import("vue").RendererElement, {
        [key: string]: any;
    }> | import("vue").VNode<import("vue").RendererNode, import("vue").RendererElement, {
        [key: string]: any;
    }>[]) | undefined) => import("vue").VNode<import("vue").RendererNode, import("vue").RendererElement, {
        [key: string]: any;
    }>;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    controller: {
        type: PropType<IDndItemController>;
        required: true;
    };
    dndDesignController: {
        type: PropType<IDndDesignPanelItemController>;
        required: true;
    };
}>>, {}, {}>;
export default _default;
