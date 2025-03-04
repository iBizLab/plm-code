export interface X6CellDataProvider<T = IData> {
  /**
   * 唯一标识
   *
   * @author chitanda
   * @date 2023-11-16 18:11:03
   * @type {string}
   */
  id: string;
  /**
   * 显示文本
   *
   * @author chitanda
   * @date 2023-11-16 18:11:14
   * @type {string}
   */
  label: string;
  /**
   * 类型值
   *
   * @author chitanda
   * @date 2023-11-22 15:11:14
   * @type {string}
   */
  type: string;
  /**
   * 连线数据
   *
   * @author chitanda
   * @date 2023-11-16 18:11:20
   * @type {T}
   */
  readonly data: T;
  /**
   * 是否强制刷新
   *
   * @author zhanghengfeng
   * @date 2025-01-09 19:01:18
   * @type {boolean}
   */
  forceRefresh?: boolean;
}
