import { IDataEntity } from '@ibiz-template/runtime';
import { Cell, Point, Edge } from '@antv/x6';
import { X6LinkDataProvider } from '../../interface';
import { CellDataProviderImpl } from './cell-data';
/**
 * 连线数据适配
 *
 * @author chitanda
 * @date 2023-11-20 22:11:22
 * @export
 * @class LinkData
 * @implements {X6LinkDataProvider}
 */
export declare class LinkDataProviderImpl extends CellDataProviderImpl implements X6LinkDataProvider<IDataEntity> {
    get type(): string;
    get source(): string | Cell<Cell.Properties> | Point.PointLike | Point.PointData | Edge.TerminalPointData | Edge.TerminalCellLooseData;
    get target(): string | Cell<Cell.Properties> | Point.PointLike | Point.PointData | Edge.TerminalPointData | Edge.TerminalCellLooseData;
    get label(): string;
}
