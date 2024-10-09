import { Graph, Node } from '@antv/x6';
import { CodeListItem, IDataEntity } from '@ibiz-template/runtime';
import { clone, isSvg } from '@ibiz-template/core';
import { createUUID } from 'qx-util';
import { IDEEditForm } from '@ibiz/model-core';
import { Dnd } from '@antv/x6-plugin-dnd';
import { X6NodeDataProvider, X6NodeServiceProvider } from '../../interface';
import { CellProviderImpl } from './cell';
import { dataTransformUtil, x6ProviderRegister } from '../../utils';

export class NodeProviderImpl
  extends CellProviderImpl<Node>
  implements X6NodeServiceProvider
{
  protected linkModel: IDEEditForm;

  protected validateNodeType: string[] = ['START'];

  constructor(node: IDEEditForm, link: IDEEditForm) {
    super(node);
    this.linkModel = link;
  }

  createDataProvider(data: IDataEntity): X6NodeDataProvider<IDataEntity> {
    return x6ProviderRegister.getNodeData<IDataEntity>(
      `${this.pluginConfig.pluginType}_${this.pluginConfig.pluginCode}_DataProvider`,
    )(data);
  }

  async create(
    context: IContext,
    params: IParams,
    node: Node,
  ): Promise<IDataEntity> {
    const { x, y } = node.position();
    const data = node.getData();
    const transformData = dataTransformUtil.transform(data, context, params);
    const deService = await this.getDeService(context);
    const res = await deService.create(context, {
      ...transformData,
      leftpos: x,
      toppos: y,
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
    _context: IContext,
    _params: IParams,
    _id: string,
  ): Promise<IDataEntity> {
    throw new Error('Method not implemented.');
  }

  async copy?(
    _context: IContext,
    _params: IParams,
    _cell: Node,
  ): Promise<IDataEntity> {
    throw new Error('Method not implemented.');
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
    const codeItem = this.codeItems.find(item => item.value === data.type);
    const icon = this.getIcon(codeItem);
    return {
      id: data.id,
      shape: 'wf-node',
      x: data.x,
      y: data.y,
      label: data.label,
      icon,
      type: data.type,
      data,
    };
  }

  createDragCell(codeItem: CodeListItem): Node.Metadata {
    const data: IData = {
      ...(codeItem.data || {}),
      isNew: true,
    };
    return {
      id: createUUID(),
      shape: `wf-node`,
      data,
      label: codeItem.text,
      icon: this.getIcon(codeItem),
      type: data.wfprocesstype,
    };
  }

  createMaterialCell(codeItem: CodeListItem): Node.Metadata {
    return {
      shape: 'wf-material-node',
      label: codeItem.text,
      data: codeItem,
      icon: this.getIcon(codeItem),
    };
  }

  createMaterialAddCell(codeItem: CodeListItem): Node.Metadata {
    return {
      shape: 'wf-material-node',
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
    const name = data.pswfprocessname || '';
    const type = data.wfprocesstype || '';
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

  async createEdges(_node: Node<Node.Properties>, _g: Graph): Promise<void> {
    return undefined;
  }
}
