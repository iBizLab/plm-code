import { IAppView, IPanelContainer } from '@ibiz/model-core';
import { PanelItemController } from '@ibiz-template/runtime';
import { PreviewContentState } from './preview-content.state';
import { PreviewViewControllerBase } from '../../views';
import { IPreviewViewEvent, IPreviewViewState } from '../../interface';
/**
 * 预览内容区控制器
 *
 * @export
 * @class PreviewContentController
 * @extends {PanelItemController<IPanelContainer>}
 */
export declare class PreviewContentController extends PanelItemController<IPanelContainer> {
    /**
     * 预览内容区状态
     *
     * @type {PreviewContentState}
     * @memberof PreviewContentController
     */
    state: PreviewContentState;
    /**
     * 预览视图控制器
     *
     * @readonly
     * @type {PreviewViewControllerBase<
     *     IAppView,
     *     IPreviewViewState,
     *     IPreviewViewEvent
     *   >}
     * @memberof PreviewContentController
     */
    get view(): PreviewViewControllerBase<IAppView, IPreviewViewState, IPreviewViewEvent>;
    /**
     * 主数据
     *
     * @readonly
     * @type {IData}
     * @memberof PreviewContentController
     */
    get majorData(): IData;
    /**
     * 创建面板状态对象
     *
     * @protected
     * @return {*}  {PreviewContentState}
     * @memberof PreviewContentController
     */
    protected createState(): PreviewContentState;
    /**
     * 初始化
     *
     * @protected
     * @return {*}  {Promise<void>}
     * @memberof PreviewContentController
     */
    protected onInit(): Promise<void>;
    /**
     * 加载数据
     *
     * @protected
     * @return {*}  {Promise<void>}
     * @memberof PreviewContentController
     */
    protected load(): Promise<void>;
    /**
     * 初始化子项数据
     *
     * @protected
     * @return {*}  {Promise<void>}
     * @memberof PreviewContentController
     */
    protected initItems(): Promise<void>;
}
