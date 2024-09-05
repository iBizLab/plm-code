import { IDataEntity } from '@ibiz-template/runtime';
export interface IDndStructureNodeData {
    /**
     * 实体数据
     *
     * @author zhanghengfeng
     * @date 2023-12-28 19:12:48
     * @type {IDataEntity}
     */
    entity: IDataEntity;
    /**
     * 唯一标识
     *
     * @author zhanghengfeng
     * @date 2023-12-28 19:12:10
     * @type {string}
     */
    id: string;
    /**
     * 显示文本
     *
     * @author zhanghengfeng
     * @date 2023-12-28 19:12:30
     * @type {string}
     */
    text: string;
    /**
     * 类型
     *
     * @author zhanghengfeng
     * @date 2023-12-28 19:12:24
     * @type {string}
     */
    type: string;
    /**
     * 父节点
     *
     * @author zhanghengfeng
     * @date 2023-12-28 19:12:31
     * @type {(IDndStructureNodeData | null)}
     */
    parent: IDndStructureNodeData | null;
    /**
     * 子节点
     *
     * @author zhanghengfeng
     * @date 2023-12-28 19:12:55
     * @type {IDndStructureNodeData[]}
     */
    children: IDndStructureNodeData[];
}
