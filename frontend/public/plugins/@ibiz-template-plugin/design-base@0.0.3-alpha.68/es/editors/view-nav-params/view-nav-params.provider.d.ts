import { IEditorContainerController, IEditorProvider } from '@ibiz-template/runtime';
import { ITextBox } from '@ibiz/model-core';
import { ViewNavParamsController } from './view-nav-params.controller';
export declare class ViewNavParamsProvider implements IEditorProvider {
    formEditor: string;
    gridEditor: string;
    createController(editorModel: ITextBox, parentController: IEditorContainerController): Promise<ViewNavParamsController>;
}
