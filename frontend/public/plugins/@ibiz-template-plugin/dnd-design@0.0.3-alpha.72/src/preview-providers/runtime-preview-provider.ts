/* eslint-disable no-empty-function */
/* eslint-disable @typescript-eslint/no-unused-vars */
import { IViewController } from '@ibiz-template/runtime';
import { IPreviewProvider } from '../interface';

export class DndRuntimePreViewProvider implements IPreviewProvider {
  async init(view: IViewController): Promise<void> {}

  getTargetDataBySourceData(
    type: 'FORMDETAIL' | string,
    source: IData[],
  ): IData[] {
    return source;
  }

  getPropertyByTag(tag: string): IData[] {
    return [];
  }
}
