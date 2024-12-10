import { CodeListEditorController, IEditorContainerController, IEditorProvider } from '@ibiz-template/runtime';
import { ITextBox } from '@ibiz/model-core';
export declare class MarkdownMemoEditorProvider implements IEditorProvider {
    formEditor: string;
    gridEditor: string;
    createController(editorModel: ITextBox, parentController: IEditorContainerController): Promise<CodeListEditorController>;
}
