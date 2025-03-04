import { IEditorContainerController, IEditorProvider } from '@ibiz-template/runtime';
import { ICode } from '@ibiz/model-core';
import { FormLogicEventScriptEditorController } from './form-logic-event-script.controller';
/**
 * 表单逻辑（事件脚本）编辑器适配器
 *
 * @export
 * @class FormLogicEventScriptEditorProvider
 * @implements {IEditorProvider}
 */
export declare class FormLogicEventScriptEditorProvider implements IEditorProvider {
    formEditor: string;
    gridEditor: string;
    createController(editorModel: ICode, parentController: IEditorContainerController): Promise<FormLogicEventScriptEditorController>;
}
