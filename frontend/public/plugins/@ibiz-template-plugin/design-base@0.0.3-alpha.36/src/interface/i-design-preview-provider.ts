import { IViewController } from '@ibiz-template/runtime';

export interface IDesignPreviewProvider {
  /**
   * 初始化(初始化设计预览适配器参数)
   *
   * @author tony001
   * @date 2024-09-10 10:09:13
   * @param {IViewController} view
   * @return {*}  {Promise<void>}
   */
  init(view: IViewController): Promise<void>;

  /**
   * 通过源数据获取目标数据
   *
   * @author tony001
   * @date 2024-09-10 10:09:54
   * @param {string} type
   * @param {IData[]} source
   * @return {*}  {IData[]}
   */
  getTargetDataBySourceData(type: string, source: IData[]): IData[];

  /**
   * 获取设计预览参数
   *
   * @author tony001
   * @date 2024-09-10 10:09:41
   * @param {string} tag
   * @return {*}  {IData[]}
   */
  getPropertyByTag(tag: string): IData[];
}
