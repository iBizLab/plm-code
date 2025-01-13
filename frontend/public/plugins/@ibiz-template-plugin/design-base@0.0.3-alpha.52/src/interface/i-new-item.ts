/* eslint-disable @typescript-eslint/no-explicit-any */
/**
 * 新建项列表接口
 *
 * @export
 * @interface INewItem
 */
export interface INewItem {
  /**
   * 展示文本
   *
   * @type {string}
   * @memberof INewItem
   */
  text: string;
  /**
   * 归属类型[与新建规则匹配]
   *
   * @type {string}
   * @memberof INewItem
   */
  type: string;
  /**
   * 提示信息
   *
   * @type {string}
   * @memberof INewItem
   */
  tooltip?: string;
  /**
   * 显示图标
   *
   * @type {string}
   * @memberof INewItem
   */
  icon?: string;
  /**
   * 新建默认携带数据
   *
   * @type {*}
   * @memberof INewItem
   */
  data: any;
}
