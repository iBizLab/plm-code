import {
  IEditorContainerController,
  IEditorProvider,
} from '@ibiz-template/runtime';
import { ITextBox } from '@ibiz/model-core';
import { CronEditorController } from './cron-editor.controller';

export class CronEditorProvider implements IEditorProvider {
  formEditor: string = 'IBizCronEditor';

  gridEditor: string = 'IBizCronEditor';

  async createController(
    editorModel: ITextBox,
    parentController: IEditorContainerController,
  ): Promise<CronEditorController> {
    const c = new CronEditorController(editorModel, parentController);
    await c.init();
    return c;
  }
}
