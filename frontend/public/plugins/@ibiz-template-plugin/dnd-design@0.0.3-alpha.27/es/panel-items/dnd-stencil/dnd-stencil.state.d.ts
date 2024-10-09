import { PanelItemState } from '@ibiz-template/runtime';
import { ICodeItem } from '@ibiz/model-core';
export declare class DndStencilPanelItemState extends PanelItemState {
    /**
     * 代码表项
     *
     * @author zhanghengfeng
     * @date 2024-01-08 17:01:55
     * @type {ICodeItem[]}
     */
    items: ICodeItem[];
    /**
     * 过滤值
     *
     * @author zhanghengfeng
     * @date 2024-01-11 17:01:34
     * @type {string}
     */
    filterValue: string;
}
