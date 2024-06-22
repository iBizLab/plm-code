/* eslint-disable prettier/prettier */
import { IAppBICube, IAppBIReport, IAppBIScheme, IAppDataEntity, IAppView, IApplication } from '@ibiz/model-core';
import { ModelLoaderProvider } from '@ibiz-template/runtime';
import {
  getAppDataEntityModel,
  getAppViewModel,
  getAppModel,
} from '@/publish/model';
import { mergeUIActions } from './merge-ui-action';

/**
 * 模型加载适配器
 *
 * @author chitanda
 * @date 2023-04-17 23:04:44
 * @export
 * @class ModelLoader
 * @implements {ModelLoaderProvider}
 */
export class ModelLoader implements ModelLoaderProvider {

  async initApp(_id?: string): Promise<boolean> {
    return true;
  }

  loadAppView(
    _appId: string,
    _viewId: string,
    _params: IParams,
  ): Promise<IAppView> {
    throw new Error('Method not implemented.');
  }

  async getAppStyle(_appId: string): Promise<string | null> {
    const style: string = '/PSSYSAPP.json.css';
    return style;
  }

  async getApp(_id?: string): Promise<IApplication> {
    const app = await getAppModel();
    return mergeUIActions(app);
  }

  async getAppView(_appId: string, codeName: string): Promise<IAppView> {
    return getAppViewModel(codeName);
  }

  async getAppDataEntity(_appId: string, id: string): Promise<IAppDataEntity> {
    return getAppDataEntityModel(id);
  }

  async getAppDataEntityByCodeName(
    appId: string,
    codeName: string,
  ): Promise<IAppDataEntity> {
    return this.getAppDataEntity(appId, codeName);
  }

  getAppBISchemes(appId: string, ids: string[]): Promise<IAppBIScheme[]> {
    throw new Error('Method not implemented.');
  }

  getAppAppBICubes(appId: string, ids: string[]): Promise<IAppBICube[]> {
    throw new Error('Method not implemented.');
  }

  getAppBIReports(appId: string, ids: string[]): Promise<IAppBIReport[]> {
    throw new Error('Method not implemented.');
  }
}
