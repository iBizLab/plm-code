import { IDataEntity } from '@ibiz-template/runtime';
import { PropType } from 'vue';
import { IDndDesignPanelItemController } from '../../interface';
import './form-page.scss';
declare const _default: import("vue").DefineComponent<{
    items: {
        type: PropType<IDataEntity[]>;
        required: true;
        default: () => IDataEntity[];
    };
    select: {
        type: PropType<IDataEntity>;
    };
    dndDesignController: {
        type: PropType<IDndDesignPanelItemController>;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    activePage: import("vue").Ref<string | undefined>;
    onActivePageChange: (item: IDataEntity) => void;
    onPagePositionChange: (evt: IData) => Promise<void>;
    onPageAdd: () => Promise<void>;
    onPageRemove: (page: IDataEntity) => Promise<void>;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, ("change" | "select" | "remove")[], "change" | "select" | "remove", import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    items: {
        type: PropType<IDataEntity[]>;
        required: true;
        default: () => IDataEntity[];
    };
    select: {
        type: PropType<IDataEntity>;
    };
    dndDesignController: {
        type: PropType<IDndDesignPanelItemController>;
        required: true;
    };
}>> & {
    onChange?: ((...args: any[]) => any) | undefined;
    onSelect?: ((...args: any[]) => any) | undefined;
    onRemove?: ((...args: any[]) => any) | undefined;
}, {
    items: IDataEntity[];
}, {}>;
export default _default;
