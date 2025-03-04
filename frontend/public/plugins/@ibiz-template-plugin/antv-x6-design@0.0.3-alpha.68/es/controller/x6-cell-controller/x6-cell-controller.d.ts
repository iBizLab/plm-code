import { Graph } from '@antv/x6';
import { IDataEntity, IPanelController } from '@ibiz-template/runtime';
import { IDEEditForm } from '@ibiz/model-core';
import { IPortalMessage } from '@ibiz-template/core';
import { X6CellDataProvider, X6CellServiceProvider } from '../../interface';
/**
 * X6图形控制器
 *
 * @author chitanda
 * @date 2023-11-16 18:11:12
 * @export
 * @class X6CellController
 */
export declare abstract class X6CellController {
    protected panel: IPanelController;
    /**
     * 当前视图上下文(由外部传入)
     *
     * @author chitanda
     * @date 2023-11-20 11:11:59
     * @protected
     * @type {IContext}
     */
    protected context: IContext;
    /**
     * 当前图形参数(由外部传入)
     *
     * @author chitanda
     * @date 2023-11-20 11:11:29
     * @protected
     * @type {IParams}
     */
    protected params: IParams;
    /**
     * 当前x6图形实例
     *
     * @author chitanda
     * @date 2023-11-09 18:11:46
     * @type {Graph}
     */
    protected readonly g: Graph;
    /**
     * 连线表单模型对象
     *
     * @author chitanda
     * @date 2023-11-21 12:11:45
     * @protected
     * @type {IDEEditForm}
     */
    protected model: IDEEditForm;
    /**
     * 当前数据
     *
     * @author chitanda
     * @date 2023-11-21 17:11:24
     * @protected
     * @type {IDataEntity[]}
     */
    items: IDataEntity[];
    /**
     * 当前数据映射，用于快速查找
     *
     * @description 主键为key
     * @author chitanda
     * @date 2023-11-22 12:11:32
     * @type {Map<string, X6CellDataProvider>}
     */
    readonly map: Map<string, X6CellDataProvider>;
    /**
     * 图形适配器
     *
     * @author zhanghengfeng
     * @date 2023-12-11 19:12:02
     * @type {X6CellServiceProvider}
     */
    provider: X6CellServiceProvider;
    constructor(panel: IPanelController, g: Graph);
    /**
     * 由外部调用进行初始化(不可以重写)
     *
     * @author chitanda
     * @date 2023-11-21 11:11:25
     * @return {*}  {Promise<void>}
     */
    init(): void;
    /**
     * 初始化(子类重写)
     *
     * @author chitanda
     * @date 2023-11-21 11:11:23
     * @protected
     */
    protected onInit(): void;
    /**
     * 监听消息变更
     *
     * @author zhanghengfeng
     * @date 2024-01-10 17:01:46
     * @protected
     * @param {IPortalMessage} msg
     */
    protected onMessageChange(msg: IPortalMessage): void;
    /**
     * 销毁
     *
     * @author zhanghengfeng
     * @date 2024-01-10 17:01:36
     */
    destroy(): void;
    /**
     * 加载图形数据
     *
     * @author chitanda
     * @date 2023-11-20 11:11:57
     * @return {*}  {Promise<void>}
     */
    abstract load(): Promise<void>;
}
