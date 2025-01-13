import { IDataEntity } from '@ibiz-template/runtime';
import { IDEForm } from '@ibiz/model-core';
import { DndItemController } from '../../controller';
import {
  DndItemProvider,
  IDndDesignPanelItemController,
  IDndItemController,
} from '../../interface';

export class ButtonListProvider implements DndItemProvider {
  type: string = 'PSDEFORMDETAIL_BUTTONLIST';

  component: string = 'IBizDndDesignButtonList';

  createController(
    c: IDndDesignPanelItemController,
    model: IDEForm,
    item: IDataEntity,
  ): IDndItemController {
    return new DndItemController(c, model, item);
  }
}
