import {
  IEditorContainerController,
  IEditorProvider,
} from '@ibiz-template/runtime';
import { ITextBox } from '@ibiz/model-core';
import { EditorParamsController } from './editor-params.controller';

export class EditorParamsProvider implements IEditorProvider {
  formEditor: string = 'IBizEditorParmas';

  gridEditor: string = 'IBizEditorParmas';

  async createController(
    editorModel: ITextBox,
    parentController: IEditorContainerController,
  ): Promise<EditorParamsController> {
    const c = new EditorParamsController(editorModel, parentController);
    await c.init();
    return c;
  }
}
