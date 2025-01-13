import { IAppDECustomView } from '@ibiz/model-core';
import { IPreviewViewState, IPreviewViewEvent, PreviewViewControllerBase } from '@ibiz-template-plugin/design-base';
/**
 * 表单预览视图控制器
 *
 * @export
 * @class FormPreviewViewController
 * @extends {PreviewViewControllerBase<IAppDECustomView, IPreviewViewState, IPreviewViewEvent>}
 */
export declare class FormPreviewViewController extends PreviewViewControllerBase<IAppDECustomView, IPreviewViewState, IPreviewViewEvent> {
    /**
     * 初始化预览适配器
     *
     * @protected
     * @return {*}  {Promise<void>}
     * @memberof FormPreviewViewController
     */
    protected initPreViewProvider(): Promise<void>;
    /**
     * 初始化引擎
     *
     * @protected
     * @memberof FormPreviewViewController
     */
    protected initEngines(): void;
}
