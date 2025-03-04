import {
  IEditorContainerController,
  IEditorProvider,
} from '@ibiz-template/runtime';
import { ITextBox } from '@ibiz/model-core';
import { ViewNavParamsController } from './view-nav-params.controller';

export class ViewNavParamsProvider implements IEditorProvider {
  formEditor: string = 'ViewNavParams';

  gridEditor: string = 'ViewNavParams';

  async createController(
    editorModel: ITextBox,
    parentController: IEditorContainerController,
  ): Promise<ViewNavParamsController> {
    const c = new ViewNavParamsController(editorModel, parentController);
    await c.init();
    return c;
  }
}
