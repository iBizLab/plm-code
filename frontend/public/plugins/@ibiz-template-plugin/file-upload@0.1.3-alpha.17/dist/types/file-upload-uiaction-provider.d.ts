import { IAppDEUIAction } from '@ibiz/model-core';
import { IUIActionResult, IUILogicParams, FrontUIActionProvider } from '@ibiz-template/runtime';
import { HttpResponse } from '@ibiz-template/core';
/**
 * 文件上传行为适配器
 *
 * @export
 * @class FileUploadUIActionProvider
 * @extends {FrontUIActionProvider}
 */
export declare class FileUploadUIActionProvider extends FrontUIActionProvider {
    /**
     * 文件上传路径
     *
     * @type {string}
     * @memberof FileUploadUIActionProvider
     */
    uploadUrl: string;
    execAction(action: IAppDEUIAction, args: IUILogicParams): Promise<IUIActionResult>;
    /**
     * 选择文件改变
     *
     * @params
     * @memberof NetDiskTree
     */
    uploadFiles: (e: IData, resolve: Function) => void;
    /**
     * 处理上传文件事件
     *
     * @memberof NetDiskTree
     */
    handleUploadFile: (files: FileList, resolve: Function) => Promise<void>;
    uploadRequest: (file: File) => Promise<HttpResponse>;
    createFileInput(resolve: Function): void;
}
