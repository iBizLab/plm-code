import { IDataEntity } from '@ibiz-template/runtime';
import { IDEForm } from '@ibiz/model-core';
import { DndItemController } from '../../controller';
import { DndItemProvider, IDndDesignPanelItemController } from '../../interface';
export declare class RawItemProvider implements DndItemProvider {
    type: string;
    component: string;
    createController(c: IDndDesignPanelItemController, model: IDEForm, item: IDataEntity): DndItemController;
}
