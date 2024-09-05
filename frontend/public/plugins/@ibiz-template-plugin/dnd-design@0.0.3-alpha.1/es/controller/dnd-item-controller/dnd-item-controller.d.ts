import { IDataEntity } from '@ibiz-template/runtime';
import { IDEForm } from '@ibiz/model-core';
import { IActionItem, IDndDesignPanelItemController, IDndItemController } from '../../interface';
import { SelectState } from '../../utils';
/**
 * 拖拽项控制器
 *
 * @author chitanda
 * @date 2023-12-15 17:12:39
 * @export
 * @class DndItemController
 */
export declare class DndItemController implements IDndItemController {
    protected c: IDndDesignPanelItemController;
    data: IDataEntity;
    protected model: IDEForm;
    readonly select: SelectState<IData>;
    actions: IActionItem[];
    constructor(c: IDndDesignPanelItemController, model: IDEForm, data: IDataEntity);
    onAction(_action: IActionItem): Promise<boolean>;
    destroy(): void;
    change(evt: IData, items: IDataEntity[], parent?: IDataEntity): void;
    remove(items: IDataEntity[], item: IDataEntity): Promise<boolean>;
}
