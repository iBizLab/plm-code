/* eslint-disable @typescript-eslint/no-explicit-any */
import {
  IEditorContainerController,
  IEditorProvider,
} from '@ibiz-template/runtime';
import { ICode } from '@ibiz/model-core';
import { FormLogicEventScriptEditorController } from './form-logic-event-script.controller';

/**
 * 表单逻辑（事件脚本）编辑器适配器
 *
 * @export
 * @class FormLogicEventScriptEditorProvider
 * @implements {IEditorProvider}
 */
export class FormLogicEventScriptEditorProvider implements IEditorProvider {
  formEditor: string = 'IBizFormLogicEventScript';

  gridEditor: string = 'IBizFormLogicEventScript';

  async createController(
    editorModel: ICode,
    parentController: IEditorContainerController,
  ): Promise<FormLogicEventScriptEditorController> {
    const c = new FormLogicEventScriptEditorController(
      editorModel,
      parentController,
    );
    await c.init();
    return c;
  }
}
