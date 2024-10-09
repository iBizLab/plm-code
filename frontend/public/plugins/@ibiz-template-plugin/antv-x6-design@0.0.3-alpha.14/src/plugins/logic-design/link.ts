import { Edge, Options, Point } from '@antv/x6';
import { IDataEntity } from '@ibiz-template/runtime';
import { Namespace, clone } from '@ibiz-template/core';
import { IDEEditForm } from '@ibiz/model-core';
import { X6LinkDataProvider, X6LinkServiceProvider } from '../../interface';
import { dataTransformUtil, x6ProviderRegister } from '../../utils';
import { CellProviderImpl } from './cell';
import { X6DesignViewController } from '../../views';

export class LinkProviderImpl
  extends CellProviderImpl<Edge>
  implements X6LinkServiceProvider
{
  protected nodeModel: IDEEditForm;

  logicType: string = '';

  constructor(node: IDEEditForm, link: IDEEditForm) {
    super(link);
    this.nodeModel = node;
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
      const vertices = edge.vertices;
      const data = edge.getData();
      const shapeParams = JSON.parse(data?.data?.shapeparams || '{}');
      if (shapeParams) {
        Object.assign(shapeParams, {
          vertices,
        });
      }
      return JSON.stringify(shapeParams);
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
    const transformData = dataTransformUtil.transform(
      this.getCodeItemData(),
      context,
      params,
    );
    const deService = await this.getDeService(context);
    const res = await deService.create(context, {
      ...data,
      srcpsdelogicnodeid: sourceCell.id,
      defaultlink: 0,
      dstpsdelogicnodeid: targetCell.id,
      psdelogiclinkname: '连接名称',
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
    const data = {
      [entityModel.keyAppDEFieldId!]: edge.id,
      srcpsdelogicnodeid: sourceCell.id,
      dstpsdelogicnodeid: targetCell.id,
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
    context: IContext,
    _params: IParams,
    id: string,
  ): Promise<IDataEntity> {
    const entityModel = await this.getAppDataEntity();
    const deService = await this.getDeService(context);
    const _context = clone(context);
    _context[entityModel.codeName!.toLowerCase()] = id;
    const res = await deService.get(_context);
    return res.data as IDataEntity;
  }

  async copy(
    _context: IContext,
    _params: IParams,
    _cell: Edge,
  ): Promise<IDataEntity> {
    throw new Error('Method not implemented.');
  }

  createCell(data: X6LinkDataProvider<IDataEntity>): Edge.Metadata {
    return {
      shape: 'logic-link',
      id: data.id,
      source: data.source,
      target: data.target,
      data,
      label: data.label,
      vertices: this.getVertices(data),
      logicType: this.logicType,
    };
  }

  onEdgeLabelRendered(args: Options.OnEdgeLabelRenderedArgs): undefined {
    const { container, edge, label } = args;
    if (container && edge && label && label.logicDesignLabel) {
      const { width, height, el } = label.logicDesignLabel;
      if (!width || !height || !el) {
        return;
      }
      const foreignObject = document.createElementNS(
        'http://www.w3.org/2000/svg',
        'foreignObject',
      );
      container.appendChild(foreignObject);
      foreignObject.setAttribute('width', `${width}`);
      foreignObject.setAttribute('height', `${height}`);
      foreignObject.style.transform = `translateY(-${height / 2}px)`;
      const position = label.position;
      if (position && typeof position === 'object') {
        const angle = position.angle;
        if (typeof angle === 'number' && (angle < -90 || angle > 90)) {
          const ns = new Namespace('logic-design-label');
          foreignObject.classList.add(ns.bm('foreignObject', 'left'));
        }
      }
      foreignObject.appendChild(el);
    }
  }

  afterLoad(view: X6DesignViewController): void {
    const data = view.state?.data;
    if (data) {
      this.logicType = data.logictype || '';
    }
  }
}
