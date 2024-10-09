import { IViewController } from '@ibiz-template/runtime';

export interface IPreviewProvider {
  /**
   * 初始化
   *
   * @author tony001
   * @date 2024-09-06 15:09:12
   * @param {IViewController} view
   * @return {*}  {Promise<void>}
   */
  init(view: IViewController): Promise<void>;

  /**
   * 通过源数据获取目标数据
   *
   * @author tony001
   * @date 2024-09-06 15:09:50
   * @param {('FORMDETAIL' | string)} type
   * @param {IData[]} source
   * @return {*}  {IData[]}
   */
  getTargetDataBySourceData(
    type: 'FORMDETAIL' | string,
    source: IData[],
  ): IData[];
}
