/* eslint-disable @typescript-eslint/no-explicit-any */
import {
  CodeListEditorController,
  IEditorContainerController,
  IEditorProvider,
} from '@ibiz-template/runtime';
import { ITextBox } from '@ibiz/model-core';

export class MarkdownMemoEditorProvider implements IEditorProvider {
  formEditor: string = 'IBizMarkdownMemoEditor';

  gridEditor: string = 'IBizMarkdownMemoEditor';

  async createController(
    editorModel: ITextBox,
    parentController: IEditorContainerController,
  ): Promise<CodeListEditorController> {
    const c = new CodeListEditorController(editorModel, parentController);
    await c.init();
    return c;
  }
}
