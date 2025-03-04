/* eslint-disable no-empty-function */
/* eslint-disable @typescript-eslint/no-unused-vars */
import { IViewController } from '@ibiz-template/runtime';
import { IDesignPreviewProvider } from '../interface';

export class PreViewProviderBase implements IDesignPreviewProvider {
  async init(view: IViewController): Promise<void> {}

  getTargetDataBySourceData(type: string, source: IData[]): IData[] {
    return source;
  }

  getPropertyByTag(tag: string): IData[] {
    return [];
  }
}
