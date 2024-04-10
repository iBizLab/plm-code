import { IAppDEUIAction } from '@ibiz/model-core';
import { IModal, IOverlayPopoverContainer, IUIActionResult, IUILogicParams, UIActionProviderBase } from '@ibiz-template/runtime';
import { VNode } from 'vue';
/**
 * 修改密码界面行为插件
 *
 * @export
 * @class ChangePasswordUIActionProvider
 * @extends {UIActionProviderBase}
 */
export declare class ChangePasswordUIActionProvider extends UIActionProviderBase {
    /**
     * 气泡容器
     *
     * @type {IOverlayPopoverContainer}
     * @memberof ChangePasswordUIActionProvider
     */
    overlay: IOverlayPopoverContainer | null;
    /**
     * 执行界面行为
     *
     * @param {IAppDEUIAction} _action
     * @param {IUILogicParams} _params
     * @return {*}  {Promise<IUIActionResult>}
     * @memberof ChangePasswordUIActionProvider
     */
    execAction(_action: IAppDEUIAction, _params: IUILogicParams): Promise<IUIActionResult>;
    /**
     * 打开模态
     *
     * @return {*}
     * @memberof ChangePasswordUIActionProvider
     */
    openModal(): Promise<IData[]>;
    /**
     * 创建overlay
     *
     * @return {*}  {(modal: IModal) => VNode}
     * @memberof ChangePasswordUIActionProvider
     */
    createOverlayView(): (modal: IModal) => VNode;
    /**
     * 修改密码
     *
     * @param {IData} data
     * @return {*}  {Promise<boolean>}
     * @memberof ChangePasswordUIActionProvider
     */
    changePass(data: IData): Promise<boolean>;
}
