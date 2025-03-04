import { recursiveIterate } from '@ibiz-template/core';
import { PreviewContentController } from '@ibiz-template-plugin/design-base';
import { FormPreviewContentState } from './form-preview-content.state.mjs';

"use strict";
class FormPreviewContentController extends PreviewContentController {
  /**
   * 创建面板状态对象
   *
   * @protected
   * @return {*}  {GridPreviewContentState}
   * @memberof FormPreviewContentController
   */
  createState() {
    var _a;
    return new FormPreviewContentState((_a = this.parent) == null ? void 0 : _a.state);
  }
  /**
   * 初始化工具栏项数据
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof FormPreviewContentController
   */
  async initItems() {
    const items = this.majorData.psdeformdetails || [];
    recursiveIterate(
      { psdeformdetails: items },
      (item) => {
        this.view.preViewProvider.getTargetDataBySourceData("FORMDETAIL", [
          item
        ]);
      },
      { childrenFields: ["psdeformdetails"] }
    );
    this.state.items = items;
  }
}

export { FormPreviewContentController };
