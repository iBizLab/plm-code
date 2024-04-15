import { IDataEntity } from '@ibiz-template/runtime';
import { IDEForm } from '@ibiz/model-core';
import { DndItemProvider, IDndDesignPanelItemController, IDndItemController } from '../interface';
/**
 * 拖拽项适配器基类
 *
 * @author chitanda
 * @date 2023-12-18 17:12:00
 * @export
 * @abstract
 * @class DndProvider
 * @implements {DndItemProvider}
 */
export declare abstract class DndProvider implements DndItemProvider {
    abstract type: string;
    abstract component: string;
    createController(c: IDndDesignPanelItemController, model: IDEForm, item: IDataEntity): IDndItemController;
}
