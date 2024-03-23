import { GridRowState, GridFieldEditColumnController } from '@ibiz-template/runtime';
import { Ref } from 'vue';
export declare function useCellEdit(props: {
    readonly row: GridRowState;
    readonly controller: GridFieldEditColumnController;
}, componentRef: Ref<any>): {
    gridEditItemProps: {
        showEditMask: boolean;
        stopPropagation: boolean;
    };
    editorProps: {
        autoFocus: boolean;
        disabled: boolean;
        readonly: boolean;
        onFocus: () => void;
        onBlur: () => void;
        onEnter: () => Promise<void>;
        onKeydown: (event: any) => void;
    };
    onMaskClick: () => void;
};
