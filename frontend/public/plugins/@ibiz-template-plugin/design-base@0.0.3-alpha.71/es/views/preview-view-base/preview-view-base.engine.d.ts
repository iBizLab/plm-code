import { IAppView } from '@ibiz/model-core';
import { IAppDEService, ViewEngineBase } from '@ibiz-template/runtime';
import { PreviewViewControllerBase } from './preview-view-base.controller';
import { IPreviewViewEvent, IPreviewViewState } from '../../interface';
/**
 * 预览视图引擎基类
 *
 * @export
 * @class PreviewViewEngineBase
 * @extends {ViewEngineBase}
 */
export declare class PreviewViewEngineBase extends ViewEngineBase {
    /**
     * 视图控制器
     *
     * @protected
     * @type {PreviewViewControllerBase<
     *     IAppView,
     *     IPreviewViewState,
     *     IPreviewViewEvent
     *   >}
     * @memberof PreviewViewEngineBase
     */
    protected view: PreviewViewControllerBase<IAppView, IPreviewViewState, IPreviewViewEvent>;
    /**
     * 主实体服务
     *
     * @protected
     * @type {IAppDEService}
     * @memberof PreviewViewEngineBase
     */
    protected service: IAppDEService;
    /**
     * 初始化tab导航
     *
     * @author zhanghengfeng
     * @date 2025-02-11 18:02:31
     * @protected
     * @return {*}  {void}
     */
    protected initNavTab(): void;
    /**
     * 视图created生命周期执行逻辑
     *
     * @return {*}  {Promise<void>}
     * @memberof PreviewViewEngineBase
     */
    onCreated(): Promise<void>;
    /**
     * 初始化实体服务
     *
     * @return {*}  {Promise<void>}
     * @memberof PreviewViewEngineBase
     */
    initDeService(): Promise<void>;
    /**
     * 加载主数据
     *
     * @protected
     * @return {*}  {Promise<void>}
     * @memberof PreviewViewEngineBase
     */
    protected load(): Promise<void>;
}
