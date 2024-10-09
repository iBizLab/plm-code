import {
  IDEEditForm,
  ISysPFPlugin,
  IAppDataEntity,
  IDEFormDetail,
} from '@ibiz/model-core';
import {
  CodeListItem,
  IAppDEService,
  IAppService,
  IDataEntity,
  getPFPlugin,
} from '@ibiz-template/runtime';
import { Cell } from '@antv/x6';
import { X6CellDataProvider, X6CellServiceProvider } from '../../interface';

/**
 * 元素适配器
 *
 * @author chitanda
 * @date 2023-11-21 15:11:10
 * @export
 * @abstract
 * @class CellProviderImpl
 * @implements {X6CellServiceProvider<C, IDataEntity>}
 * @template C
 */
export abstract class CellProviderImpl<C>
  implements X6CellServiceProvider<C, IDataEntity>
{
  protected model: IDEEditForm;

  protected pluginConfig: ISysPFPlugin;

  protected app: IAppService;

  protected entityModel?: IAppDataEntity;

  protected deService?: IAppDEService;

  protected codeItems: CodeListItem[] = [];

  protected codeItemMap: Map<string | number, CodeListItem> = new Map();

  protected initialized: boolean = false;

  constructor(model: IDEEditForm) {
    this.model = model;
    this.pluginConfig = getPFPlugin(
      this.model.sysPFPluginId!,
      this.model.appId,
    );
    this.app = ibiz.hub.getApp(model.appId!);
  }

  async init(context: IContext, params: IParams): Promise<void> {
    if (this.initialized) {
      return;
    }
    await this.initCodeItems(context, params);
    this.initialized = true;
  }

  protected async initCodeItems(
    context: IContext,
    params: IParams,
  ): Promise<void> {
    const pages = this.model.deformPages;
    if (!Array.isArray(pages) || !pages.length) {
      ibiz.log.debug('表单模型未配置表单分页');
      return;
    }
    const page = pages[0];
    const formDetails = page.deformDetails;
    if (!Array.isArray(formDetails)) {
      ibiz.log.debug('表单模型的表单分页里面未配置表单项');
      return;
    }
    const formDetail = formDetails.find(
      item => item.codeName === 'type',
    ) as IDEFormDetail & { editor?: { appCodeListId?: string } };
    if (!formDetail) {
      ibiz.log.debug('表单模型的表单分页里面未配置标识为type的表单项');
      return;
    }
    const appCodeListId = formDetail.editor && formDetail.editor.appCodeListId;
    if (!appCodeListId) {
      ibiz.log.debug('标识为type的表单项未配置代码表');
      return;
    }
    const codeListItems = await this.app.codeList.get(
      appCodeListId,
      context,
      params,
    );
    if (codeListItems) {
      const codeItems: CodeListItem[] = [];
      codeListItems.forEach(item => {
        codeItems.push(item);
        if (item.value) {
          this.codeItemMap.set(item.value, item);
        }
        if (Array.isArray(item.children)) {
          item.children.forEach(child => {
            codeItems.push(child);
            if (child.value) {
              this.codeItemMap.set(child.value, child);
            }
          });
        }
      });
      this.codeItems = codeItems;
    }
  }

  abstract create(
    context: IContext,
    params: IParams,
    cell: C,
  ): Promise<IDataEntity>;

  abstract update(
    context: IContext,
    params: IParams,
    cell: C,
  ): Promise<IDataEntity>;

  abstract delete(
    context: IContext,
    params: IParams,
    id: string,
  ): Promise<IDataEntity>;

  async select(context: IContext, params: IParams): Promise<IDataEntity[]> {
    const deService = await this.getDeService(context);
    const res = await deService.fetchDefault(context, params);
    return (res.data as IDataEntity[]) || [];
  }

  abstract get(
    context: IContext,
    params: IParams,
    id: string,
  ): Promise<IDataEntity>;

  abstract copy?(
    context: IContext,
    params: IParams,
    cell: C,
  ): Promise<IDataEntity>;

  abstract createDataProvider(
    data: IDataEntity,
  ): X6CellDataProvider<IDataEntity>;

  abstract createCell(data: X6CellDataProvider<IDataEntity>): Cell.Metadata;

  /**
   * 获取当前节点对应的应用实体模型
   *
   * @author chitanda
   * @date 2023-11-23 15:11:04
   * @protected
   * @return {*}  {Promise<IAppDataEntity>}
   */
  protected async getAppDataEntity(): Promise<IAppDataEntity> {
    if (!this.entityModel) {
      this.entityModel = await ibiz.hub.getAppDataEntity(
        this.model.appDataEntityId!,
        this.model.appId,
      );
    }
    return this.entityModel;
  }

  /**
   * 获取当前表单对应实体的数据服务
   *
   * @author chitanda
   * @date 2023-12-23 14:12:37
   * @protected
   * @param {IContext} context
   * @return {*}  {Promise<IAppDEService>}
   */
  protected async getDeService(context: IContext): Promise<IAppDEService> {
    if (!this.deService) {
      this.deService = await this.app.deService.getService(
        context,
        this.model.appDataEntityId!,
      );
    }
    return this.deService;
  }
}
