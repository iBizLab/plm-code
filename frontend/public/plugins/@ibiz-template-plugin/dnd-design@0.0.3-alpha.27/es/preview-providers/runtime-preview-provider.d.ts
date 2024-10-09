import { IViewController } from '@ibiz-template/runtime';
import { IPreviewProvider } from '../interface';
export declare class DndRuntimePreViewProvider implements IPreviewProvider {
    init(view: IViewController): Promise<void>;
    getTargetDataBySourceData(type: 'FORMDETAIL' | string, source: IData[]): IData[];
}
