import { X6CellDataProvider } from './x6-cell-data.provider';
/**
 * 节点数据结构
 *
 * @author chitanda
 * @date 2023-11-16 18:11:29
 * @export
 * @interface X6NodeDataProvider
 * @template T
 */
export interface X6NodeDataProvider<T = IData> extends X6CellDataProvider<T> {
    /**
     * x 轴位置
     *
     * @author chitanda
     * @date 2023-11-21 21:11:49
     * @type {number}
     */
    x: number;
    /**
     * y 轴位置
     *
     * @author chitanda
     * @date 2023-11-21 21:11:03
     * @type {number}
     */
    y: number;
}
