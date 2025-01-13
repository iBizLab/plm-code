import { IDataEntity, PanelItemState } from '@ibiz-template/runtime';
import { IActionItem, ITreeNode } from '../../interface';
export declare class DesignOperationState extends PanelItemState {
    /**
     * 所有数据
     *
     * @author tony001
     * @date 2024-09-10 16:09:44
     * @type {IDataEntity[]}
     */
    items: IDataEntity[];
    /**
     * 树数据
     *
     * @author tony001
     * @date 2024-09-10 16:09:54
     * @type {ITreeNode[]}
     */
    treeData: ITreeNode[];
    /**
     * 操作行为
     *
     * @author tony001
     * @date 2024-09-10 16:09:04
     * @type {IActionItem[]}
     */
    actions: IActionItem[];
    /**
     * 打开行为规则
     *
     * @author tony001
     * @date 2024-09-10 16:09:15
     * @type {Map<string, RegExp>}
     */
    rules: Map<string, RegExp>;
    /**
     * 激活节点标识
     *
     * @author tony001
     * @date 2024-09-10 17:09:17
     * @type {string}
     */
    activeNode: string;
}
