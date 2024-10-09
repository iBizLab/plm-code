import { IDataEntity } from '@ibiz-template/runtime';
import { X6NodeDataProvider } from '../../interface';
import { CellDataProviderImpl } from './cell-data';

/**
 * 节点数据适配
 *
 * @author chitanda
 * @date 2023-11-20 22:11:14
 * @export
 * @class NodeData
 * @implements {X6NodeDataProvider}
 */
export class NodeDataProviderImpl
  extends CellDataProviderImpl
  implements X6NodeDataProvider<IDataEntity>
{
  set type(type: string) {
    this.data.logicnodetype = type;
  }

  get type(): string {
    return this.data.logicnodetype;
  }

  get x(): number {
    return this.data.leftpos;
  }

  get y(): number {
    return this.data.toppos;
  }
}
