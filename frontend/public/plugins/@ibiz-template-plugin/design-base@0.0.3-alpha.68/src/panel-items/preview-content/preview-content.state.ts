import { PanelItemState } from '@ibiz-template/runtime';

/**
 * 预览内容区控制器
 *
 * @export
 * @class PreviewContentState
 * @extends {PanelItemState}
 */
export class PreviewContentState extends PanelItemState {
  /**
   * 预览子项数据集合
   *
   * @type {IData[]}
   * @memberof PreviewContentState
   */
  items: IData[] = [];
}
