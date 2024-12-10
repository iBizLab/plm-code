import { IDataEntity } from '@ibiz-template/runtime';
import { IDndStructureNodeData } from '../../interface';

export class DndStructureNodeData implements IDndStructureNodeData {
  entity: IDataEntity;

  get id(): string {
    return this.entity.srfkey || '';
  }

  get text(): string {
    return this.entity.srftext || '';
  }

  get type(): string {
    return this.entity.srftype || '';
  }

  parent: IDndStructureNodeData | null = null;

  children: IDndStructureNodeData[] = [];

  constructor(entity: IDataEntity) {
    this.entity = entity;
  }
}
