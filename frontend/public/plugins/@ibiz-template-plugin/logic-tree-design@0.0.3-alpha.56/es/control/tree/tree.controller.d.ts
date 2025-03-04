import { ITreeNodeData, MDCtrlLoadParams, MDCtrlRemoveParams, TreeController } from '@ibiz-template/runtime';
import { LogicDesignTreeService } from './tree.service';
export declare class LogicTreeDesignTreeController extends TreeController {
    service: LogicDesignTreeService;
    protected initService(): Promise<void>;
    /**
     * @description 下一步选中数据
     * @type {string}
     * @memberof LogicTreeDesignTreeController
     */
    toSelectSrfkey: string;
    /**
     * @description 设置下一步选中数据
     * @memberof LogicTreeDesignTreeController
     */
    setToSelectData(): void;
    protected onCreated(): Promise<void>;
    afterLoad(args: MDCtrlLoadParams, items: IData[]): Promise<IData[]>;
    /**
     * 当数据放生变更时，若为当前应用实体数据。则多数据部件进行刷新
     *
     * @author chitanda
     * @date 2023-09-13 17:09:04
     * @protected
     * @param {IData} msg
     */
    protected onDataChange(msg: IData): void;
    calcAllowDrop(draggingNode: ITreeNodeData, dropNode: ITreeNodeData, type: 'inner' | 'prev' | 'next'): boolean;
    onNodeDrop(draggingNode: ITreeNodeData, dropNode: ITreeNodeData, dropType: 'inner' | 'prev' | 'next'): Promise<void>;
    /**
     * 删除强制静默，其他不变
     * @author lxm
     * @date 2023-12-27 03:32:36
     * @param {MDCtrlRemoveParams} [args]
     * @return {*}  {Promise<void>}
     */
    remove(args?: MDCtrlRemoveParams): Promise<void>;
    /**
     * 执行界面行为
     *
     * @author chitanda
     * @date 2023-12-07 15:12:26
     * @param {string} uiActionId
     * @param {ITreeNodeData} nodeData
     * @param {MouseEvent} event
     * @param {string} appId
     * @return {*}  {Promise<void>}
     */
    doUIAction(uiActionId: string, nodeData: ITreeNodeData, event: MouseEvent, appId: string): Promise<void>;
}
