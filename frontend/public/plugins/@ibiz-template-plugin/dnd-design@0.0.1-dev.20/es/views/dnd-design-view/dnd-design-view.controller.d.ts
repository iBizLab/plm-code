import { ViewController } from '@ibiz-template/runtime';
import { IAppDECustomView } from '@ibiz/model-core';
import { DndDesignViewState } from './interface/dnd-design-view.state';
import { DndDesignViewEvent } from './interface/dnd-design-view.event';
import { SelectState } from '../../utils';
export declare class DndDesignViewController extends ViewController<IAppDECustomView, DndDesignViewState, DndDesignViewEvent> {
    /**
     * 视图中的选中数据
     *
     * @author chitanda
     * @date 2023-12-21 18:12:25
     */
    readonly select: SelectState<IData>;
    protected initEngines(): void;
}