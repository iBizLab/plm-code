import { IDataEntity, IPanelItemController } from '@ibiz-template/runtime';
import { DndDesignViewController } from '../../views';

/**
 *
 *
 * @author chitanda
 * @date 2024-01-03 14:01:42
 * @export
 * @interface IDndDesignPanelItemController
 */
export interface IDndDesignPanelItemController extends IPanelItemController {
  /**
   * 设计视图控制器
   *
   * @author zhanghengfeng
   * @date 2024-01-04 17:01:39
   * @type {DndDesignViewController}
   */
  view: DndDesignViewController;

  /**
   * 拖拽变更
   *
   * @author zhanghengfeng
   * @date 2024-01-04 17:01:17
   * @param {IData} evt
   * @param {IDataEntity[]} items
   * @param {IDataEntity} [parent]
   */
  change(evt: IData, items: IDataEntity[], parent?: IDataEntity): void;

  /**
   * 删除数据项
   *
   * @author chitanda
   * @date 2024-01-03 15:01:15
   * @param {IDataEntity} item
   * @return {*}  {Promise<boolean>}
   */
  remove(items: IDataEntity[], item: IDataEntity): Promise<boolean>;

  /**
   * 获取模型状态
   *
   * @author zhanghengfeng
   * @date 2024-04-23 20:04:29
   * @param {IDataEntity} entity
   * @return {*}  {number}
   */
  getModelState(entity: IDataEntity): number;

  /**
   * 更新隐藏表单项可见性
   *
   * @author zhanghengfeng
   * @date 2024-06-05 13:06:25
   * @param {boolean} value
   */
  updateHiddenFormItemVisible(value: boolean): void;

  /**
   * 是否显示遮罩
   *
   * @author zhanghengfeng
   * @date 2024-06-21 19:06:27
   * @param {IDataEntity} entity
   * @return {*}  {boolean}
   */
  isShowMask(entity: IDataEntity): boolean;
}
