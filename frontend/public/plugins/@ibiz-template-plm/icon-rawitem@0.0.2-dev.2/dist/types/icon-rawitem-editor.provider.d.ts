import { IEditorContainerController, IEditorProvider } from '@ibiz-template/runtime';
import { IRaw } from '@ibiz/model-core';
import { IconRawItemEditorController } from './icon-rawitem-editor.controller';
/**
 * 直接内容编辑器适配器
 *
 * @export
 * @class IconRawItemEditorController
 * @implements {EditorProvider}
 */
export declare class IconRawItemEditorProvider implements IEditorProvider {
    formEditor: string;
    gridEditor: string;
    createController(editorModel: IRaw, parentController: IEditorContainerController): Promise<IconRawItemEditorController>;
}
