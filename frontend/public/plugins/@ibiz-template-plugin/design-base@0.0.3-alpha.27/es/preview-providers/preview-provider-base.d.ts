import { IViewController } from '@ibiz-template/runtime';
import { IDesignPreviewProvider } from '../interface';
export declare class PreViewProviderBase implements IDesignPreviewProvider {
    init(view: IViewController): Promise<void>;
    getTargetDataBySourceData(type: string, source: IData[]): IData[];
    getPropertyByTag(tag: string): IData[];
}
