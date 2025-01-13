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
export class LinkDataProviderImpl
  extends CellDataProviderImpl
  implements X6LinkDataProvider<IDataEntity>
{
  get type(): string {
    return '';
  }

  get source():
    | string
    | Cell<Cell.Properties>
    | Point.PointLike
    | Point.PointData
    | Edge.TerminalPointData
    | Edge.TerminalCellLooseData {
    if (this.data.srcendpoint) {
      return {
        cell: this.data.srcpsdelogicnodeid,
        port: this.data.srcendpoint,
      };
    }
    return this.data.srcpsdelogicnodeid;
  }

  get target():
    | string
    | Cell<Cell.Properties>
    | Point.PointLike
    | Point.PointData
    | Edge.TerminalPointData
    | Edge.TerminalCellLooseData {
    if (this.data.dstendpoint) {
      return {
        cell: this.data.dstpsdelogicnodeid,
        port: this.data.dstendpoint,
      };
    }
    return this.data.dstpsdelogicnodeid;
  }

  get label(): string {
    return (
      (this.data.psdelogiclinkname === '连接名称'
        ? ''
        : this.data.psdelogiclinkname) || ''
    );
  }
}
