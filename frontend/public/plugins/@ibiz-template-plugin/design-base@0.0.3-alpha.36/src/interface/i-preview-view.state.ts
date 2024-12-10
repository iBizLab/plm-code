import { IViewState } from '@ibiz-template/runtime';

/**
 * 预览视图UI状态对象
 *
 * @export
 * @interface IPreviewViewState
 * @extends {IViewState}
 */
export interface IPreviewViewState extends IViewState {
  /**
   * 主数据
   *
   * @type {IData}
   * @memberof IPreviewViewState
   */
  data: IData;
}
