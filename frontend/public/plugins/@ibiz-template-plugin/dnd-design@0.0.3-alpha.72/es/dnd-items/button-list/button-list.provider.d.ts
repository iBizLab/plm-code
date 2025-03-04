import { IDataEntity } from '@ibiz-template/runtime';
import { IDEForm } from '@ibiz/model-core';
import { DndItemProvider, IDndDesignPanelItemController, IDndItemController } from '../../interface';
export declare class ButtonListProvider implements DndItemProvider {
    type: string;
    component: string;
    createController(c: IDndDesignPanelItemController, model: IDEForm, item: IDataEntity): IDndItemController;
}
