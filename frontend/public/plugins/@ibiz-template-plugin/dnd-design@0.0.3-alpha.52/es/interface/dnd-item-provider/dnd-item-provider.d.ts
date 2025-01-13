import { IDataEntity } from '@ibiz-template/runtime';
import { IDEForm } from '@ibiz/model-core';
import { IDndDesignPanelItemController } from '../i-dnd-design-panel-item-controller/i-dnd-design-panel-item-controller';
import { IDndItemController } from '../i-dnd-item-controller/i-dnd-item-controller';
/**
 * 项适配器
 *
 * @author chitanda
 * @date 2023-12-15 17:12:33
 * @export
 * @interface DndItemProvider
 */
export interface DndItemProvider {
    /**
     * 当前类型
     *
     * @author chitanda
     * @date 2023-12-18 16:12:15
     * @type {string}
     */
    type: string;
    /**
     * 绘制的组件名称
     *
     * @author chitanda
     * @date 2023-12-15 17:12:39
     * @type {string}
     */
    component: string;
    /**
     * 创建控制器
     *
     * @author chitanda
     * @date 2024-01-03 14:01:24
     * @param {IDndDesignPanelItemController} c
     * @param {IDEForm} model
     * @param {IDataEntity} item
     * @return {*}  {IDndItemController}
     */
    createController(c: IDndDesignPanelItemController, model: IDEForm, item: IDataEntity): IDndItemController;
}
