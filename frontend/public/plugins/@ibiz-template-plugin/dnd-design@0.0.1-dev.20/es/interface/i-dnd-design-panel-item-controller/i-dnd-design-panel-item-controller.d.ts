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
}
