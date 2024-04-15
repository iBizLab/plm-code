import { Namespace } from '@ibiz-template/core';
import { IDataEntity } from '@ibiz-template/runtime';
export declare class LayoutUtil {
    /**
     * 栅格布局模式
     *
     * @author zhanghengfeng
     * @date 2024-01-29 17:01:09
     */
    gridLayoutMode: string[];
    /**
     * 获取栅格布局值
     *
     * @author zhanghengfeng
     * @date 2024-01-29 15:01:11
     * @param {IDataEntity} item
     * @param {string} [prefix='']
     * @param {string} [suffix='']
     * @return {*}  {(string | undefined)}
     */
    getGridLayoutModeValue(item: IDataEntity, prefix?: string, suffix?: string): string;
    /**
     * 获取栅格布局值，不存在时从父数据获取
     *
     * @author zhanghengfeng
     * @date 2024-01-29 09:01:05
     * @param {IDataEntity} item
     * @param {IDataEntity} parent
     * @return {*}  {(number | null)}
     */
    getGridCol(item: IDataEntity, parent: IDataEntity): number | null;
    /**
     * 获取栅格布局偏移
     *
     * @author zhanghengfeng
     * @date 2024-01-29 10:01:33
     * @param {IDataEntity} item
     * @param {IDataEntity} pData
     * @return {*}  {(number | null)}
     */
    getGridOffset(item: IDataEntity, parent: IDataEntity): number | null;
    /**
     * 计算栅格样式
     *
     * @author zhanghengfeng
     * @date 2024-01-29 09:01:21
     * @param {IDataEntity} item
     * @param {IDataEntity} parent
     * @return {*}
     */
    calcColClass(item: IDataEntity, parent: IDataEntity): IData;
    /**
     * 计算Flex容器样式
     *
     * @author zhanghengfeng
     * @date 2024-01-29 10:01:54
     * @param {IDataEntity} data
     * @return {*}
     */
    getFlexLayoutStyle(item: IDataEntity): IData;
    /**
     * 计算拖拽容器class
     *
     * @author zhanghengfeng
     * @date 2024-01-29 14:01:07
     * @param {IDataEntity} item
     * @param {Namespace} ns
     * @return {*}
     */
    getDraggableContainerClass(item: IDataEntity, ns: Namespace): IData;
    /**
     * 计算项样式
     *
     * @author zhanghengfeng
     * @date 2024-01-29 11:01:54
     * @param {IDataEntity} item
     * @param {IDataEntity} parent
     * @return {*}
     */
    calcStyle(item: IDataEntity, parent: IDataEntity): IData;
    /**
     *获取换行模式
     *
     * @author zhanghengfeng
     * @date 2024-01-29 14:01:38
     * @param {IDataEntity} item
     * @return {*}
     */
    getSwapMode(item: IDataEntity): IData;
    /**
     * 获取边框样式
     *
     * @author zhanghengfeng
     * @date 2024-01-29 14:01:10
     * @param {IDataEntity} item
     * @return {*}
     */
    getBorderStyle(item: IDataEntity): IData;
    /**
     * 获取边距样式
     *
     * @author zhanghengfeng
     * @date 2024-01-29 14:01:46
     * @param {string} tag
     * @return {*}
     */
    getSpacingStyle(tag: string): string;
    /**
     * 获取水平对齐样式
     *
     * @author zhanghengfeng
     * @date 2024-01-29 14:01:05
     * @param {IDataEntity} item
     * @param {IDataEntity} parent
     * @param {boolean} [flex=false]
     * @return {*}
     */
    getHorizontalAlign(item: IDataEntity, parent: IDataEntity, flex?: boolean): IData;
    /**
     * 获取垂直对齐样式
     *
     * @author zhanghengfeng
     * @date 2024-01-29 14:01:30
     * @param {IDataEntity} data
     * @param {IDataEntity} pData
     * @param {boolean} [flex=false]
     * @return {*}
     */
    getVerticalAlign(item: IDataEntity, parent: IDataEntity, flex?: boolean): IData;
}
export declare const layoutUtil: LayoutUtil;
