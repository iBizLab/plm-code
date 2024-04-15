import { IDataEntity } from '@ibiz-template/runtime';
import { X6CellDataProvider } from '../../interface';

export abstract class CellDataProviderImpl
  implements X6CellDataProvider<IDataEntity>
{
  get id(): string {
    return this.data.srfkey;
  }

  get label(): string {
    return this.data.srfmajortext;
  }

  abstract type: string;

  /**
   * 图形额外参数存储
   *
   * @author chitanda
   * @date 2023-11-24 18:11:29
   * @type {unknown}
   */
  shapeparams: unknown;

  readonly data: IDataEntity;

  constructor(data: IDataEntity) {
    this.data = data;
  }
}
