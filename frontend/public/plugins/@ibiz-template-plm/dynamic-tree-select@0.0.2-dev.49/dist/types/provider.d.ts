import { IEditorContainerController, IEditorProvider } from '@ibiz-template/runtime';
import { IPicker } from '@ibiz/model-core';
import { DynamicTreeSelectController } from './dynamic-tree-select-controller';
export declare class DynamicTreeSelectProvider implements IEditorProvider {
    component: string;
    formEditor: string;
    gridEditor: string;
    createController(editorModel: IPicker, parentController: IEditorContainerController): Promise<DynamicTreeSelectController>;
}
