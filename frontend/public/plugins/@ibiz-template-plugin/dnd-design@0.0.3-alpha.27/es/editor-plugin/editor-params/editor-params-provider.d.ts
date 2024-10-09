import { IEditorContainerController, IEditorProvider } from '@ibiz-template/runtime';
import { ITextBox } from '@ibiz/model-core';
import { EditorParamsController } from './editor-params.controller';
export declare class EditorParamsProvider implements IEditorProvider {
    formEditor: string;
    gridEditor: string;
    createController(editorModel: ITextBox, parentController: IEditorContainerController): Promise<EditorParamsController>;
}
