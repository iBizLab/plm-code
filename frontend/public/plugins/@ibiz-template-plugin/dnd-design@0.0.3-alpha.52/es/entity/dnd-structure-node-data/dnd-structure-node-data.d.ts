import { IDataEntity } from '@ibiz-template/runtime';
import { IDndStructureNodeData } from '../../interface';
export declare class DndStructureNodeData implements IDndStructureNodeData {
    entity: IDataEntity;
    get id(): string;
    get text(): string;
    get type(): string;
    parent: IDndStructureNodeData | null;
    children: IDndStructureNodeData[];
    constructor(entity: IDataEntity);
}
