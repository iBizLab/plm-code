/* eslint-disable import/no-extraneous-dependencies */
/* eslint-disable prettier/prettier */
import { IAppBICube, IAppBIReport, IAppBIScheme, IAppDataEntity, IAppView, IApplication, ISubAppRef } from '@ibiz/model-core';
import { DSLHelper } from '@ibiz/rt-model-api';
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

  protected dsl = new DSLHelper();
  
  async getSubAppRef(appId: string): Promise<ISubAppRef | undefined> {
    return undefined;
  }

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

  async translationModelToDsl(data: IData, type: 'APP' | 'VIEW' | 'CTRL' | 'APPENTITY' | 'APPBIREPORT'): Promise<IModel | undefined> {
    switch (type) {
      case 'APP':
        return this.dsl.application(data);
      case 'VIEW':
        return this.dsl.appView(data);
      case 'CTRL':
        return this.dsl.control(data);
      case 'APPENTITY':
        return this.dsl.appDataEntity(data);
      case 'APPBIREPORT':
        return this.dsl.appBIReport(data);
      default:
        break;
    }
  }
}
