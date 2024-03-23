import { IDataEntity, IViewState } from '@ibiz-template/runtime';

/**
 * x6 设计视图状态
 *
 * @author chitanda
 * @date 2023-11-20 11:11:44
 * @export
 * @interface X6DesignViewState
 * @extends {IViewState}
 */
export interface X6DesignViewState extends IViewState {
  /**
   * 当前设计主数据
   *
   * @author chitanda
   * @date 2023-11-20 11:11:37
   * @type {IDataEntity}
   */
  data: IDataEntity;
}
