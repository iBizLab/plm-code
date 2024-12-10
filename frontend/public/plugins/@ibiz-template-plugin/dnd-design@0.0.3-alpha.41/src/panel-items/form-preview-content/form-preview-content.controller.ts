/* eslint-disable array-callback-return */
import { recursiveIterate } from '@ibiz-template/core';
import { PreviewContentController } from '@ibiz-template-plugin/design-base';
import { FormPreviewContentState } from './form-preview-content.state';

/**
 * 表单预览内容区控制器
 *
 * @export
 * @class FormPreviewContentController
 * @extends {PreviewContentController}
 */
export class FormPreviewContentController extends PreviewContentController {
  /**
   * 预览内容区状态
   *
   * @type {FormPreviewContentState}
   * @memberof FormPreviewContentController
   */
  declare state: FormPreviewContentState;

  /**
   * 创建面板状态对象
   *
   * @protected
   * @return {*}  {GridPreviewContentState}
   * @memberof FormPreviewContentController
   */
  protected createState(): FormPreviewContentState {
    return new FormPreviewContentState(this.parent?.state);
  }

  /**
   * 初始化工具栏项数据
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof FormPreviewContentController
   */
  protected async initItems(): Promise<void> {
    const items = this.majorData.psdeformdetails || [];
    recursiveIterate(
      { psdeformdetails: items },
      (item: IData) => {
        this.view.preViewProvider.getTargetDataBySourceData('FORMDETAIL', [
          item,
        ]);
      },
      { childrenFields: ['psdeformdetails'] },
    );
    this.state.items = items;
  }
}
