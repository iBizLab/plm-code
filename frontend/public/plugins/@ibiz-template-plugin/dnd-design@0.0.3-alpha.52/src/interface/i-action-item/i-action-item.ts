import { VNode } from 'vue';

/**
 * 执行的行为项
 *
 * @author chitanda
 * @date 2024-01-02 16:01:51
 * @export
 * @interface IActionItem
 */
export interface IActionItem {
  /**
   * 图标
   *
   * @author chitanda
   * @date 2024-01-02 16:01:51
   * @type {string}
   */
  icon: string | VNode;

  /**
   * 文本
   *
   * @author chitanda
   * @date 2024-01-02 16:01:02
   * @type {string}
   */
  text: string;

  /**
   * 提示
   *
   * @author chitanda
   * @date 2024-01-02 16:01:32
   * @type {string}
   */
  tooltip?: string;

  /**
   * 触发的指令
   *
   * @author chitanda
   * @date 2024-01-02 16:01:36
   * @type {string}
   */
  command: string;
}
