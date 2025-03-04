import { Edge, EdgeView, Graph, Node } from '@antv/x6';
import { CodeListItem, IDataEntity } from '@ibiz-template/runtime';
import { clone, isSvg } from '@ibiz-template/core';
import { IDEEditForm } from '@ibiz/model-core';
import { createUUID } from 'qx-util';
import { Dnd } from '@antv/x6-plugin-dnd';
import { X6NodeDataProvider, X6NodeServiceProvider } from '../../interface';
import { CellProviderImpl } from './cell';
import { dataTransformUtil, x6ProviderRegister } from '../../utils';

export class NodeProviderImpl
  extends CellProviderImpl<Node>
  implements X6NodeServiceProvider
{
  protected linkModel: IDEEditForm;

  protected validateNodeType: string[] = ['BEGIN'];

  constructor(node: IDEEditForm, link: IDEEditForm) {
    super(node);
    this.linkModel = link;
  }

  createDataProvider(data: IDataEntity): X6NodeDataProvider<IDataEntity> {
    return x6ProviderRegister.getNodeData<IDataEntity>(
      `${this.pluginConfig.pluginType}_${this.pluginConfig.pluginCode}_DataProvider`,
    )(data);
  }

  /**
   * 获取排序值
   *
   * @author zhanghengfeng
   * @date 2024-01-26 20:01:18
   * @protected
   * @param {IDataEntity[]} items
   * @return {*}  {number}
   */
  protected getOrderValue(items: IDataEntity[]): number {
    let orderValue = 0;
    items.forEach(item => {
      if (item.ordervalue) {
        orderValue = Math.max(orderValue, item.ordervalue);
      }
    });
    return orderValue + 10;
  }

  async create(
    context: IContext,
    params: IParams,
    node: Node,
    items: IDataEntity[] = [],
  ): Promise<IDataEntity> {
    const { x, y } = node.position();
    const data = node.getData();
    const transformData = dataTransformUtil.transform(data, context, params);
    const deService = await this.getDeService(context);
    const res = await deService.create(context, {
      ...transformData,
      leftpos: x,
      toppos: y,
      ordervalue: this.getOrderValue(items),
    });
    return res.data as IDataEntity;
  }

  async update(
    context: IContext,
    _params: IParams,
    node: Node,
  ): Promise<IDataEntity> {
    const { x, y } = node.position();
    const entityModel = await this.getAppDataEntity();
    const deService = await this.getDeService(context);
    const res = await deService.update(context, {
      [entityModel.keyAppDEFieldId!]: node.id,
      leftpos: x,
      toppos: y,
    });
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
    context: IContext,
    params: IParams,
    cell: Node,
  ): Promise<IDataEntity> {
    const data = await this.get(context, params, cell.id);
    const { x, y } = cell.position();
    const deService = await this.getDeService(context);
    data.srfkey = '';
    const res = await deService.create(context, {
      ...data,
      leftpos: x,
      toppos: y,
    });
    return res.data as IDataEntity;
  }

  protected getIcon(codeItem?: CodeListItem): string | undefined {
    if (!codeItem) {
      return;
    }
    const image = codeItem.sysImage;
    let icon;
    if (image) {
      if (image.imagePath && isSvg(image.imagePath)) {
        icon = image.imagePath;
      } else if (image.rawContent) {
        icon = image.rawContent;
      }
    }
    return icon;
  }

  createCell(data: X6NodeDataProvider<IDataEntity>): Node.Metadata {
    let codeItem = this.codeItems.find(item => item.value === data.type);
    let showTitle = false;
    const { ctrlParams = {} } = this.model.controlParam || {};
    if (ctrlParams.SHOWTITLE) {
      showTitle = ctrlParams.SHOWTITLE === 'true';
    }
    if (!codeItem && ctrlParams.ICONKEY) {
      codeItem = this.codeItems.find(
        item => item.value === data.data[ctrlParams.ICONKEY],
      );
    }
    const icon = this.getIcon(codeItem);
    return {
      id: data.id,
      shape: 'logic-node',
      x: data.x,
      y: data.y,
      label: data.label,
      icon,
      showTitle,
      typeLabel: codeItem?.text || '',
      type: data.type,
      data,
    };
  }

  createDragCell(codeItem: CodeListItem): Node.Metadata {
    const data: IData = {
      ...(codeItem.data || {}),
      isNew: true,
    };
    const { ctrlParams = {} } = this.model.controlParam || {};
    if (ctrlParams.ICONKEY) {
      Object.assign(data, { [ctrlParams.ICONKEY]: codeItem.value });
    }
    return {
      id: createUUID(),
      shape: `logic-node`,
      data,
      label: codeItem.text,
      icon: this.getIcon(codeItem),
      typeLabel: codeItem.text,
      type: data.logicnodetype,
    };
  }

  createMaterialCell(codeItem: CodeListItem): Node.Metadata {
    return {
      shape: 'material-node',
      label: codeItem.text,
      data: codeItem,
      icon: this.getIcon(codeItem),
    };
  }

  createMaterialAddCell(codeItem: CodeListItem): Node.Metadata {
    return {
      shape: 'material-add-node',
      label: codeItem.text,
      data: codeItem,
      icon: this.getIcon(codeItem),
    };
  }

  validateNode(node: Node, options: Dnd.ValidateNodeOptions): boolean {
    const data = node.data;
    if (!data) {
      return true;
    }
    const name = data.psdelogicnodename || '';
    const type = data.logicnodetype || '';
    const g = options.targetGraph;
    if (this.validateNodeType.includes(type)) {
      const index = g.getNodes().findIndex(cell => {
        const nodeDate = cell.data;
        return nodeDate && nodeDate.type === type;
      });
      if (index !== -1) {
        ibiz.message.error(`不能重复添加${name}节点`);
        return false;
      }
    }

    return true;
  }

  /**
   *  获取与节点相交的边
   *
   * @author zhanghengfeng
   * @date 2024-01-19 17:01:30
   * @protected
   * @param {Node} node
   * @param {Graph} g
   * @return {*}  {(Edge | null)}
   */
  protected findIntersectsEdge(node: Node, g: Graph): Edge | null {
    let intersectsEdge: Edge | null = null;
    const edges = g.getEdges();
    const bBox = node.getBBox();
    const lines = [
      bBox.leftLine,
      bBox.rightLine,
      bBox.topLine,
      bBox.bottomLine,
    ];
    edges.forEach(edge => {
      const view = g.findViewByCell(edge) as EdgeView;
      if (view) {
        lines.forEach(line => {
          if (view.path.intersectsWithLine(line)) {
            intersectsEdge = edge;
          }
        });
      }
    });
    return intersectsEdge;
  }

  async createEdges(node: Node, g: Graph): Promise<void> {
    const edge = this.findIntersectsEdge(node, g);
    if (!edge) {
      return;
    }
    const sourceNode = edge.getSourceNode();
    const targetNode = edge.getTargetNode();
    if (sourceNode && targetNode && sourceNode.id && targetNode.id) {
      edge.setSource(sourceNode);
      edge.setTarget(node);
      await g.trigger('edge:connected', { edge });
      const newEdge = g.addEdge({ source: node, target: targetNode });
      await g.trigger('edge:connected', { edge: newEdge });
    }
  }
}
