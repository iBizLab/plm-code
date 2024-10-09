import { Cell, Point, Edge } from '@antv/x6';
import { X6CellDataProvider } from './x6-cell-data.provider';
/**
 * 连线数据结构适配器
 *
 * @author chitanda
 * @date 2023-11-16 18:11:04
 * @export
 * @interface X6LinkDataProvider
 */
export interface X6LinkDataProvider<T = IData> extends X6CellDataProvider<T> {
    /**
     * 连线源节点
     *
     * @author chitanda
     * @date 2023-11-21 21:11:10
     * @type {(string
     *     | Cell
     *     | Point.PointLike
     *     | Point.PointData
     *     | Edge.TerminalPointData
     *     | Edge.TerminalCellLooseData)}
     */
    source: string | Cell | Point.PointLike | Point.PointData | Edge.TerminalPointData | Edge.TerminalCellLooseData;
    /**
     * 连线目标节点
     *
     * @author chitanda
     * @date 2023-11-21 21:11:14
     * @type {(string
     *     | Cell
     *     | Point.PointLike
     *     | Point.PointData
     *     | Edge.TerminalPointData
     *     | Edge.TerminalCellLooseData)}
     */
    target: string | Cell | Point.PointLike | Point.PointData | Edge.TerminalPointData | Edge.TerminalCellLooseData;
}
