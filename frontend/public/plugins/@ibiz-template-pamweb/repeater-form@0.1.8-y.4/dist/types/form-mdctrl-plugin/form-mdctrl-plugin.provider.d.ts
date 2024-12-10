import { FormController, FormMDCtrlController, IFormDetailContainerController, IFormDetailProvider } from '@ibiz-template/runtime';
import { IDEFormMDCtrl } from '@ibiz/model-core';
/**
 * 表单多数据部件适配器
 *
 * @author lxm
 * @date 2022-09-19 22:09:03
 * @export
 * @class FormMDCtrlProvider
 * @implements {EditorProvider}
 */
export declare class FormMDCtrlPluginProvider implements IFormDetailProvider {
    component: string;
    createController(detailModel: IDEFormMDCtrl, form: FormController, parent: IFormDetailContainerController | undefined): Promise<FormMDCtrlController>;
}
