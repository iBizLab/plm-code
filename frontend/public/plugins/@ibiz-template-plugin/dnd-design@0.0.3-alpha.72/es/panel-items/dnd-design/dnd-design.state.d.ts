import { IDataEntity, PanelItemState } from '@ibiz-template/runtime';
export declare class DndDesignPanelItemState extends PanelItemState {
    /**
     * 数据项
     *
     * @description 子数据为 children
     * @author chitanda
     * @date 2023-12-18 15:12:15
     * @type {IDataEntity[]}
     */
    items: IDataEntity[];
    /**
     * 当前选中的数据
     *
     * @author chitanda
     * @date 2023-12-21 17:12:52
     * @type {(IDataEntity | null)}
     */
    activeData: IDataEntity | null;
    /**
     * key标识，用于触发重新渲染
     *
     * @author zhanghengfeng
     * @date 2024-01-05 15:01:51
     * @type {string}
     */
    uuid: string;
    /**
     * 隐藏表单项是否可见
     *
     * @author zhanghengfeng
     * @date 2024-06-05 13:06:17
     * @type {boolean}
     */
    hiddenFormItemVisible: boolean;
    /**
     * 逻辑映射map
     *
     * @author zhanghengfeng
     * @date 2025-02-12 22:02:01
     * @type {Record<string, number>}
     */
    logicMap: Record<string, number>;
    /**
     * 是否正在预览
     *
     * @author zhanghengfeng
     * @date 2025-02-14 20:02:06
     * @type {boolean}
     */
    isPreview: boolean;
    /**
     * 预览数据
     *
     * @author zhanghengfeng
     * @date 2025-02-14 20:02:43
     * @type {IData}
     */
    previewData?: IData;
    /**
     * 预览key
     *
     * @author zhanghengfeng
     * @date 2025-02-14 20:02:50
     * @type {string}
     */
    previewKey: string;
    /**
     * 表单项标签宽度
     *
     * @author zhanghengfeng
     * @date 2025-02-20 20:02:28
     * @type {(number | undefined)}
     */
    formItemLabelWidth: number | undefined;
}
