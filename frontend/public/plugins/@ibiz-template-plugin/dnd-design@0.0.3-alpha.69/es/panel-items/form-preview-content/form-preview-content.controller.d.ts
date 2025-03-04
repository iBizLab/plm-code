import { PreviewContentController } from '@ibiz-template-plugin/design-base';
import { FormPreviewContentState } from './form-preview-content.state';
/**
 * 表单预览内容区控制器
 *
 * @export
 * @class FormPreviewContentController
 * @extends {PreviewContentController}
 */
export declare class FormPreviewContentController extends PreviewContentController {
    /**
     * 预览内容区状态
     *
     * @type {FormPreviewContentState}
     * @memberof FormPreviewContentController
     */
    state: FormPreviewContentState;
    /**
     * 创建面板状态对象
     *
     * @protected
     * @return {*}  {GridPreviewContentState}
     * @memberof FormPreviewContentController
     */
    protected createState(): FormPreviewContentState;
    /**
     * 初始化工具栏项数据
     *
     * @protected
     * @return {*}  {Promise<void>}
     * @memberof FormPreviewContentController
     */
    protected initItems(): Promise<void>;
}
