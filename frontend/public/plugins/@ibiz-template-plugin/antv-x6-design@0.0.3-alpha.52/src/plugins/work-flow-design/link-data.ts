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
    return this.data.wflinktype || '';
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
        cell: this.data.frompswfprocid,
        port: this.data.srcendpoint,
      };
    }
    return this.data.frompswfprocid;
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
        cell: this.data.topswfprocid,
        port: this.data.dstendpoint,
      };
    }
    return this.data.topswfprocid;
  }

  get label(): string {
    let text: string = this.data.logicname || this.data.pswflinkname || '';
    if (this.data.nextcond) {
      text = text ? `${text}\n${this.data.nextcond}` : this.data.nextcond;
    }
    return text;
  }
}
