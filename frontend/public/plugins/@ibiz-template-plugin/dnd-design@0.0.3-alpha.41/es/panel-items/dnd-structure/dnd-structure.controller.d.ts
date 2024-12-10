import { IPortalMessage } from '@ibiz-template/core';
import { IAppDEService, IDataEntity, PanelItemController, QXEventEx } from '@ibiz-template/runtime';
import { IAppCodeList, ICodeItem, IDEForm, IPanelField } from '@ibiz/model-core';
import { DndStructurePanelItemState } from './dnd-structure.state';
import { DndDesignViewController } from '../../views';
import { IDndStructureNodeData } from '../../interface';
export declare class DndStructurePanelItemController extends PanelItemController<IPanelField> {
    codeList: IAppCodeList;
    protected service: IAppDEService;
    protected form: IDEForm;
    state: DndStructurePanelItemState;
    get view(): DndDesignViewController;
    /**
     * 事件中心
     *
     * @author zhanghengfeng
     * @date 2024-01-09 19:01:28
     */
    readonly evt: QXEventEx<{
        updateSelect: () => void;
    }>;
    /**
     * 数据
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:44
     * @protected
     * @type {IDataEntity[]}
     */
    protected items: IDataEntity[];
    /**
     * 定时器
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:01
     * @protected
     * @type {(number | null)}
     */
    protected timer: number | null;
    /**
     * 是否禁止处理消息
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:58
     * @protected
     * @type {boolean}
     */
    protected isDisableMessage: boolean;
    /**
     * 代码表列表
     *
     * @author zhanghengfeng
     * @date 2024-01-18 16:01:21
     * @type {{ key: string; map: Map<string, ICodeItem> }[]}
     */
    codeItemList: {
        key: string;
        map: Map<string, ICodeItem>;
    }[];
    protected createState(): DndStructurePanelItemState;
    protected onInit(): Promise<void>;
    /**
     * 获取节点图标
     *
     * @author zhanghengfeng
     * @date 2024-01-18 16:01:35
     * @param {IDndStructureNodeData} node
     * @return {*}  {string}
     */
    getNodeIcon(node: IDndStructureNodeData): string | undefined;
    /**
     * 监听数据变化
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:59
     * @protected
     * @param {IPortalMessage} msg
     * @return {*}  {void}
     */
    protected onDataUpdate(msg: IPortalMessage): void;
    /**
     * 监听数据创建
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:10
     * @protected
     * @param {IPortalMessage} msg
     * @return {*}  {void}
     */
    protected onDataCreate(msg: IPortalMessage): void;
    /**
     * 监听数据删除
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:26
     * @protected
     * @param {IPortalMessage} msg
     * @return {*}  {void}
     */
    protected onDataRemove(msg: IPortalMessage): void;
    /**
     * 发送消息
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:39
     * @protected
     * @param {IDataEntity[]} items
     * @param {IPortalMessage['subtype']} [type]
     * @param {IPortalMessage} [msg]
     */
    protected sendMessage(items: IDataEntity[], type?: IPortalMessage['subtype'], msg?: IPortalMessage): void;
    /**
     * 订阅消息
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:44
     * @protected
     */
    protected subscribeMessage(): void;
    /**
     * 取消订阅消息
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:55
     * @protected
     */
    protected unsubscribeMessage(): void;
    /**
     * 销毁方法
     *
     * @author zhanghengfeng
     * @date 2024-01-09 18:01:10
     */
    destroy(): void;
    load(): Promise<void>;
    /**
     * 将列表数据转为树
     *
     * @author zhanghengfeng
     * @date 2023-12-28 19:12:36
     * @protected
     * @param {IDataEntity[]} items
     * @return {*}  {IDndStructureNodeData[]}
     */
    protected transformItemsToTree(items: IDataEntity[]): IDndStructureNodeData[];
    /**
     * 数据拖拽变更
     *
     * @author zhanghengfeng
     * @date 2023-12-28 19:12:23
     * @param {IDndStructureNodeData} item
     * @param {IDndStructureNodeData[]} items
     * @param {IDndStructureNodeData} [parent]
     */
    change(item: IDndStructureNodeData, items: IDndStructureNodeData[], parent?: IDndStructureNodeData): void;
    /**
     * 节点排序并更新
     *
     * @author zhanghengfeng
     * @date 2023-12-28 19:12:45
     * @protected
     * @param {IDataEntity[]} items
     * @param {number} oldIndex
     * @param {number} newIndex
     * @return {*}  {Promise<void>}
     */
    protected move(items: IDataEntity[], oldIndex: number, newIndex: number): Promise<void>;
}
