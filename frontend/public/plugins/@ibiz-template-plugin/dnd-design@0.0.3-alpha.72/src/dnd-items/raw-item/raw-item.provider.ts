import { IDataEntity } from '@ibiz-template/runtime';
import { IDEForm } from '@ibiz/model-core';
import { DndItemController } from '../../controller';
import {
  DndItemProvider,
  IDndDesignPanelItemController,
} from '../../interface';

export class RawItemProvider implements DndItemProvider {
  type: string = 'PSDEFORMDETAIL_RAWITEM';

  component: string = 'IBizDndDesignRawItem';

  createController(
    c: IDndDesignPanelItemController,
    model: IDEForm,
    item: IDataEntity,
  ): DndItemController {
    return new DndItemController(c, model, item);
  }
}
