import { IDataEntity } from '@ibiz-template/runtime';
import { SelectState } from '../../utils';
import { IActionItem } from '../i-action-item/i-action-item';

/**
 * 拖拽项项控制器
 *
 * @author chitanda
 * @date 2024-01-03 14:01:51
 * @export
 * @interface IDndItemController
 */
export interface IDndItemController {
  /**
   * 视图中的选中数据
   *
   * @author zhanghengfeng
   * @date 2024-01-04 17:01:03
   * @type {SelectState<IData>}
   */
  readonly select: SelectState<IData>;

  /**
   * 数据
   *
   * @author zhanghengfeng
   * @date 2024-01-04 17:01:16
   * @type {IDataEntity}
   */
  data: IDataEntity;

  /**
   * 设计项的右上角菜单行为组
   *
   * @author chitanda
   * @date 2024-01-03 14:01:12
   * @type {IActionItem[]}
   */
  actions: IActionItem[];
  /**
   * 执行行为
   *
   * @author chitanda
   * @date 2024-01-03 14:01:36
   * @param {IActionItem} action
   * @return {*}  {Promise<boolean>}
   */
  onAction(action: IActionItem): Promise<boolean>;

  /**
   * 项销毁
   *
   * @author chitanda
   * @date 2024-01-03 16:01:29
   */
  destroy(): void;

  /**
   * 拖拽变更
   *
   * @author zhanghengfeng
   * @date 2024-01-04 17:01:32
   * @param {IData} evt
   * @param {IDataEntity[]} items
   * @param {IDataEntity} [parent]
   */
  change(evt: IData, items: IDataEntity[], parent?: IDataEntity): void;

  /**
   * 删除数据项
   *
   * @author zhanghengfeng
   * @date 2024-01-04 17:01:07
   * @param {IDataEntity[]} items
   * @param {IDataEntity} item
   * @return {*}  {Promise<boolean>}
   */
  remove(items: IDataEntity[], item: IDataEntity): Promise<boolean>;
}
