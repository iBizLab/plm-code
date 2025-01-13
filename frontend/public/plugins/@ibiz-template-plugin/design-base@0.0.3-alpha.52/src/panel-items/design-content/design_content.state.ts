import { PanelItemState } from '@ibiz-template/runtime';
import { createUUID } from 'qx-util';

export class DesignContentState extends PanelItemState {
  /**
   *主数据
   *
   * @author tony001
   * @date 2024-09-10 14:09:45
   * @type {IData}
   */
  majorData: IData = {};

  /**
   * item子数据
   *
   * @author tony001
   * @date 2024-09-10 14:09:40
   * @type {IData[]}
   */
  itemDatas: IData[] = [];

  /**
   * 刷新标识
   *
   * @author tony001
   * @date 2024-09-11 10:09:43
   * @type {string}
   */
  refreshTag: string = createUUID();
}
