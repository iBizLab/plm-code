import { Edge, Options, Point } from '@antv/x6';
import { IAppDEService, IDataEntity } from '@ibiz-template/runtime';
import { clone } from '@ibiz-template/core';
import { IDEEditForm } from '@ibiz/model-core';
import { X6LinkDataProvider, X6LinkServiceProvider } from '../../interface';
import { dataTransformUtil, x6ProviderRegister } from '../../utils';
import { CellProviderImpl } from './cell';
import { linkUtil } from './utils';

export class LinkProviderImpl
  extends CellProviderImpl<Edge>
  implements X6LinkServiceProvider
{
  protected nodeModel: IDEEditForm;

  protected nodeService?: IAppDEService;

  constructor(node: IDEEditForm, link: IDEEditForm) {
    super(link);
    this.nodeModel = node;
  }

  protected async getNodeService(context: IContext): Promise<IAppDEService> {
    if (!this.nodeService) {
      this.nodeService = await this.app.deService.getService(
        context,
        this.nodeModel.appDataEntityId!,
      );
    }
    return this.nodeService;
  }

  createDataProvider(data: IDataEntity): X6LinkDataProvider<IDataEntity> {
    return x6ProviderRegister.getLinkData<IDataEntity>(
      `${this.pluginConfig.pluginType}_${this.pluginConfig.pluginCode}_DataProvider`,
    )(data);
  }

  getCodeItemData(type?: string): IData {
    const codeItem = this.codeItemMap.get(type || 'default');
    const codeItemData = codeItem?.data || {};
    return codeItemData;
  }

  protected getVertices(
    data: X6LinkDataProvider<IDataEntity>,
  ): Point.PointLike | Point.PointLike[] | undefined {
    if (!data) {
      return;
    }
    try {
      const entity = data.data;
      const shapeParams = JSON.parse(entity?.shapeparams || '{}');
      return shapeParams?.vertices;
    } catch (err) {
      ibiz.log.error(`${data} 数据解析错误`);
    }
  }

  protected getShapeParams(edge: Edge): string | undefined {
    try {
      const targetPort = edge.getTargetPortId();
      const data = JSON.parse(edge.getData() || '{}');
      const vertices = edge.vertices;
      let shapeParams = data.shapeparams;
      const isCenterTarget = targetPort === 'center';
      if (data.shapeparams) {
        const originShapeParams = JSON.parse(data.shapeparams);
        Object.assign(originShapeParams, {
          vertices,
          isCenterTarget,
        });
        shapeParams = JSON.stringify(originShapeParams);
      } else {
        shapeParams = JSON.stringify({ vertices, isCenterTarget });
      }
      return shapeParams;
    } catch (err) {
      ibiz.log.error(`${edge.getData()} 数据解析错误`);
    }
  }

  async create(
    context: IContext,
    params: IParams,
    edge: Edge,
  ): Promise<IDataEntity> {
    const data = edge.getData();
    const sourceCell = edge.getSourceCell()!;
    const targetCell = edge.getTargetCell()!;
    const nodeService = await this.getNodeService(context);
    let linkType = await linkUtil.getLinkType(
      {
        ...context,
        pswfprocess: sourceCell.id,
      },
      nodeService,
    );
    const deService = await this.getDeService(context);
    if (sourceCell) {
      const sourceData = sourceCell.getData()?.data;
      if (sourceData && sourceData.enabletimeout) {
        const res = await deService.fetchDefault(context);
        if (res && res.ok && Array.isArray(res.data)) {
          const isTimeout = res.data.some(
            item =>
              item.frompswfprocid === sourceCell.id &&
              item.wflinktype === 'TIMEOUT',
          );
          if (!isTimeout) {
            const result = await ibiz.confirm.warning({
              title: '工作流连线',
              desc: '是否建立超时链接？',
              options: {
                confirmButtonText: '是',
                cancelButtonText: '否',
              },
            });
            if (result) {
              linkType = 'TIMEOUT';
            }
          }
        }
      }
    }
    const linkName = await linkUtil.getLinkName(context, linkType, deService);
    const sourcePort = edge.getSourcePortId();
    const targetPort = edge.getTargetPortId();
    const isCenterTarget = targetPort === 'center';
    const shapeParams = JSON.stringify({ isCenterTarget });
    const transformData = dataTransformUtil.transform(
      this.getCodeItemData(linkType),
      context,
      params,
    );
    const res = await deService.create(context, {
      ...data,
      frompswfprocid: sourceCell.id,
      topswfprocid: targetCell.id,
      wflinktype: linkType,
      pswflinkname: linkName,
      ordervalue: 100,
      srcendpoint: sourcePort !== 'center' ? sourcePort : undefined,
      dstendpoint: targetPort !== 'center' ? targetPort : undefined,
      shapeparams: shapeParams,
      ...transformData,
    });
    return res.data as IDataEntity;
  }

  async update(
    context: IContext,
    _params: IParams,
    edge: Edge,
  ): Promise<IDataEntity> {
    const entityModel = await this.getAppDataEntity();
    const sourceCell = edge.getSourceCell()!;
    const targetCell = edge.getTargetCell()!;
    const deService = await this.getDeService(context);
    const sourcePort = edge.getSourcePortId();
    const targetPort = edge.getTargetPortId();
    const data = {
      [entityModel.keyAppDEFieldId!]: edge.id,
      frompswfprocid: sourceCell.id,
      topswfprocid: targetCell.id,
      srcendpoint: sourcePort !== 'center' ? sourcePort : undefined,
      dstendpoint: targetPort !== 'center' ? targetPort : undefined,
    };
    const shapeParams = this.getShapeParams(edge);
    if (shapeParams) {
      data.shapeparams = shapeParams;
    }
    const res = await deService.update(context, data);
    return res.data as IDataEntity;
  }

  async delete(
    context: IContext,
    _params: IParams,
    id: string,
  ): Promise<IDataEntity> {
    const entityModel = await this.getAppDataEntity();
    const deService = await this.getDeService(context);
    const _context = clone(context);
    _context[entityModel.codeName!.toLowerCase()] = id;
    const res = await deService.remove(_context);
    return res.data as IDataEntity;
  }

  async get(
    _context: IContext,
    _params: IParams,
    _id: string,
  ): Promise<IDataEntity> {
    throw new Error('Method not implemented.');
  }

  async copy?(
    _context: IContext,
    _params: IParams,
    _cell: Edge,
  ): Promise<IDataEntity> {
    throw new Error('Method not implemented.');
  }

  createCell(data: X6LinkDataProvider<IDataEntity>): Edge.Metadata {
    return {
      shape: 'wf-link',
      id: data.id,
      source: data.source,
      target: data.target,
      data: JSON.stringify(data.data),
      label: data.label,
      dataProvider: data,
      vertices: this.getVertices(data),
    };
  }

  onEdgeLabelRendered(_args: Options.OnEdgeLabelRenderedArgs): undefined {}
}
