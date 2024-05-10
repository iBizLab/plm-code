import { ControllerEvent, ControlVO, MDCtrlLoadParams, TreeGridController } from '@ibiz-template/runtime';
import { IDETreeGrid } from '@ibiz/model-core';
import { INumberTreeGridEvent, INumberTreeGridState } from './interface';
export declare class NumberTreeGridController extends TreeGridController<IDETreeGrid, INumberTreeGridState, INumberTreeGridEvent> {
    protected get _evt(): ControllerEvent<INumberTreeGridEvent>;
    get overflowMode(): 'wrap' | 'ellipsis';
    /**
     * 是否默认展开所有
     *
     * @type {boolean}
     * @memberof NumberTreeGridController
     */
    defaultExpandAll: boolean;
    /**
     * 指定展开列下标
     *
     * @type {boolean}
     * @memberof NumberGridController
     */
    expandColumnIndex: number;
    /**
     * 切换显示模式
     *
     * @param {IData} param
     * @memberof NumberTreeGridController
     */
    switchShowMode(param: IData): void;
    /**
     * 初始化方法
     *
     * @protected
     * @return {*}  {Promise<void>}
     * @memberof NumberTreeGridController
     */
    protected onCreated(): Promise<void>;
    /**
     * 刷新
     *
     * @return {*}  {Promise<void>}
     * @memberof NumberTreeGridController
     */
    refresh(): Promise<void>;
    /**
     * 部件加载数据行为
     *
     * @param {MDCtrlLoadParams} [args={}]
     * @return {*}  {Promise<IData[]>}
     * @memberof NumberTreeGridController
     */
    load(args?: MDCtrlLoadParams): Promise<IData[]>;
    /**
     * 部件加载后处理
     *
     * @param {MDCtrlLoadParams} args
     * @param {ControlVO[]} items
     * @return {*}  {Promise<ControlVO[]>}
     * @memberof NumberTreeGridController
     */
    afterLoad(args: MDCtrlLoadParams, items: ControlVO[]): Promise<ControlVO[]>;
    /**
     * 保存
     *
     * @param {ControlVO} data
     * @return {*}  {Promise<void>}
     * @memberof NumberTreeGridController
     */
    save(data: ControlVO): Promise<void>;
    afterRemove(data: IData): void;
    /**
     * 新建行
     *
     * @param {MDCtrlLoadParams} [args={}]
     * @return {*}  {Promise<void>}
     * @memberof NumberTreeGridController
     */
    newRow(args?: MDCtrlLoadParams): Promise<void>;
    /**
     * 行单击事件
     *
     * @param {IData} data
     * @return {*}  {Promise<void>}
     * @memberof NumberTreeGridController
     */
    onRowClick(data: IData): Promise<void>;
    /**
     * 设置行展开
     *
     * @param {IData} data
     * @param {boolean} state
     * @memberof NumberTreeGridController
     */
    setRowExpand(data: IData, state: boolean): void;
}
