import { RuntimeModelError, clone, IPortalMessage } from '@ibiz-template/core';
import {
  CodeListItem,
  IAppDEService,
  IAppService,
  IDataEntity,
  PanelItemController,
  UIActionUtil,
  getControl,
  getPFPlugin,
} from '@ibiz-template/runtime';
import {
  IAppDataEntity,
  IDEEditForm,
  IDEFormButton,
  IDEFormDetail,
  IPanelContainer,
} from '@ibiz/model-core';
import { ascSort } from 'qx-util';
import { X6PanelItemTableState } from './x6-panel-item-table.state';
import { X6DesignViewController } from '../../views';
import { dataTransformUtil, x6ProviderRegister } from '../../utils';
import {
  X6LinkServiceProvider,
  X6NodeServiceProvider,
  X6PanelItemTableLinkData,
} from '../../interface';

export class X6PanelItemTableController extends PanelItemController<IPanelContainer> {
  protected app!: IAppService;

  protected node!: IDEEditForm;

  protected link!: IDEEditForm;

  protected nodeService!: IAppDEService;

  protected linkService!: IAppDEService;

  protected nodeProvider!: X6NodeServiceProvider;

  protected linkProvider!: X6LinkServiceProvider;

  protected nodeModel!: IAppDataEntity;

  protected linkModel!: IAppDataEntity;

  protected nodeMap: Map<string, IDataEntity> = new Map();

  protected linkMap: Map<string, IDataEntity> = new Map();

  protected codeItemMap: Map<string | number, CodeListItem> = new Map();

  protected addStatusUIActionId: string = '';

  declare state: X6PanelItemTableState;

  protected createState(): X6PanelItemTableState {
    return new X6PanelItemTableState(this.parent?.state);
  }

  get view(): X6DesignViewController {
    return this.panel.view as X6DesignViewController;
  }

  protected async onInit(): Promise<void> {
    await super.onInit();
    const { view } = this.panel;
    this.node = getControl(view.model, 'node') as IDEEditForm;
    if (!this.node) {
      throw new RuntimeModelError(view.model, '未找到节点表单模型对象');
    }
    this.link = getControl(view.model, 'link') as IDEEditForm;
    if (!this.link) {
      throw new RuntimeModelError(view.model, '未找到连线表单模型对象');
    }
    this.app = await ibiz.hub.getApp(this.node.appId);
    const nodePluginConfig = getPFPlugin(
      this.node.sysPFPluginId!,
      this.node.appId,
    );
    if (!nodePluginConfig) {
      throw new RuntimeModelError(this.node, '未找到节点插件配置');
    }
    const nodeTag = `${nodePluginConfig.pluginType}_${nodePluginConfig.pluginCode}`;
    const nodeProvider = x6ProviderRegister.getNode(nodeTag);
    if (!nodeProvider) {
      throw new RuntimeModelError(this.node, `未找到节点插件[${nodeTag}]`);
    }
    const linkPluginConfig = getPFPlugin(
      this.link.sysPFPluginId!,
      this.link.appId,
    );
    if (!linkPluginConfig) {
      throw new RuntimeModelError(this.link, '未找到连线插件配置');
    }
    const linkTag = `${linkPluginConfig.pluginType}_${linkPluginConfig.pluginCode}`;
    const linkProvider = x6ProviderRegister.getLink(linkTag);
    if (!linkProvider) {
      throw new RuntimeModelError(this.link, `未找到连线插件[${linkTag}]`);
    }
    this.nodeProvider = nodeProvider(this.node, this.link);
    this.linkProvider = linkProvider(this.node, this.link);
    this.nodeService = await this.getDeService(this.node);
    this.linkService = await this.getDeService(this.link);
    this.nodeModel = await ibiz.hub.getAppDataEntity(
      this.node.appDataEntityId!,
      this.node.appId,
    );
    this.linkModel = await ibiz.hub.getAppDataEntity(
      this.link.appDataEntityId!,
      this.link.appId,
    );
    await this.initCodeItems(this.panel.context, this.panel.params);
    this.initUIAction();
    this.view.evt.on('onSaveSuccess', async () => {
      await this.load();
    });
    this.view.evt.on('onRefreshView', async () => {
      await this.load();
    });
  }

  /**
   * 初始化代码表项
   *
   * @author zhanghengfeng
   * @date 2024-01-31 13:01:55
   * @protected
   * @return {*}  {void}
   */
  protected async initCodeItems(
    context: IContext,
    params: IParams,
  ): Promise<void> {
    const pages = this.link.deformPages;
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
      codeListItems.forEach(item => {
        if (item.value) {
          this.codeItemMap.set(item.value, item);
        }
        if (Array.isArray(item.children)) {
          item.children.forEach(child => {
            if (child.value) {
              this.codeItemMap.set(child.value, child);
            }
          });
        }
      });
    }
  }

  /**
   * 获取对应类型的代码表项
   *
   * @author zhanghengfeng
   * @date 2024-01-31 13:01:28
   * @protected
   * @param {string} [type]
   * @return {*}  {IData}
   */
  protected getCodeItemData(type?: string): IData {
    const codeItem = this.codeItemMap.get(type || 'default');
    const codeItemData = codeItem?.data || {};
    return codeItemData;
  }

  /**
   * 订阅消息变更
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:09
   */
  subscribeMessage(): void {
    this.onMessageChange = this.onMessageChange.bind(this);
    ibiz.mc.command.update.on(this.onMessageChange);
  }

  /**
   * 取消订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:02
   */
  unsubscribeMessage(): void {
    ibiz.mc.command.update.off(this.onMessageChange);
  }

  /**
   * 监听消息变更
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:08
   * @protected
   * @param {IPortalMessage} msg
   * @return {*}  {void}
   */
  protected onMessageChange(msg: IPortalMessage): void {
    if (msg.data && typeof msg.data === 'object') {
      const id = (msg.data as IData).srfkey;
      if (id) {
        const data = msg.data as IDataEntity;
        if (this.nodeMap.get(id)) {
          this.nodeMap.set(id, data);
          const index = this.state.nodes.findIndex(item => {
            return item.srfkey === id;
          });
          if (index !== -1) {
            this.state.nodes[index] = data;
          }
          return;
        }
        if (this.linkMap.get(id)) {
          this.linkMap.set(id, data);
          const index = this.state.links.findIndex(item => {
            return item.srfkey === id;
          });
          if (index !== -1) {
            this.state.links[index] = data;
          }
        }
      }
    }
  }

  /**
   * 获取当前表单对应实体的数据服务
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:33
   * @protected
   * @param {IDEEditForm} model
   * @return {*}  {Promise<IAppDEService>}
   */
  protected async getDeService(model: IDEEditForm): Promise<IAppDEService> {
    return this.app.deService.getService(
      this.panel.context,
      model.appDataEntityId!,
    );
  }

  /**
   * 初始化界面行为
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:13
   * @protected
   * @return {*}  {void}
   */
  protected initUIAction(): void {
    const pages = this.node.deformPages;
    if (!Array.isArray(pages) || !pages.length) {
      ibiz.log.error('节点表单模型未配置表单分页');
      return;
    }
    const page = pages[0];
    const formDetails = page.deformDetails;
    if (!Array.isArray(formDetails)) {
      ibiz.log.error('节点表单模型的表单分页里面未配置表单项');
      return;
    }
    const formDetail = formDetails.find(
      item => item.codeName === 'addstatusbutton',
    ) as IDEFormButton;
    if (!formDetail || !formDetail.uiactionId) {
      ibiz.log.error('节点表单模型未配置添加状态按钮');
      return;
    }
    this.addStatusUIActionId = formDetail.uiactionId;
  }

  /**
   * 加载节点数据
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:15
   * @protected
   * @return {*}  {Promise<IDataEntity[]>}
   */
  protected async loadNodes(): Promise<IDataEntity[]> {
    const res = await this.nodeService.fetchDefault(this.panel.context);
    this.nodeMap.clear();
    if (res.ok && Array.isArray(res.data)) {
      const data = ascSort(res.data as IDataEntity[], 'ordervalue');
      data.forEach(item => {
        this.nodeMap.set(item.srfkey, item);
      });
      return data;
    }
    return [];
  }

  /**
   * 加载连线数据
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:48
   * @protected
   * @return {*}  {Promise<IDataEntity[]>}
   */
  protected async loadLinks(): Promise<IDataEntity[]> {
    const res = await this.linkService.fetchDefault(this.panel.context);
    this.linkMap.clear();
    if (res.ok && Array.isArray(res.data)) {
      const data = res.data as IDataEntity[];
      data.forEach(item => {
        this.linkMap.set(item.srfkey, item);
      });
      return data;
    }
    return [];
  }

  /**
   * 获取连线关系映射
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:18
   * @protected
   * @return {*}  {Map<string, Map<string, string>>}
   */
  protected getConnectionMap(): Map<string, Map<string, string>> {
    const connectionMap = new Map<string, Map<string, string>>();
    this.state.links.forEach(link => {
      const source = link.srcpsdelogicnodeid;
      const target = link.dstpsdelogicnodeid;
      if (source && target) {
        const map = connectionMap.get(source) || new Map();
        map.set(target, link.srfkey);
        connectionMap.set(source, map);
      }
    });
    return connectionMap;
  }

  /**
   * 生成表格行数据
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:55
   * @protected
   */
  protected generateRows(): void {
    const connectionMap = this.getConnectionMap();
    this.state.rows = this.state.nodes.map(source => {
      const data: Record<string, X6PanelItemTableLinkData> = {};
      const map = connectionMap.get(source.srfkey);
      this.state.nodes.forEach(target => {
        if (target.srfkey) {
          const link = map ? map.get(target.srfkey) : undefined;
          data[target.srfkey] = {
            source: source.srfkey,
            target: target.srfkey,
            link,
            isConnected: !!link,
          };
        }
      });
      return data;
    });
  }

  /**
   * 加载数据
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:20
   * @return {*}  {Promise<void>}
   */
  async load(): Promise<void> {
    this.state.nodes = await this.loadNodes();
    this.state.links = await this.loadLinks();
    this.generateRows();
  }

  /**
   * 更新节点初始状态
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:32
   * @param {IDataEntity} item
   * @return {*}  {Promise<boolean>}
   */
  async updateInitialState(item: IDataEntity): Promise<boolean> {
    const map = new Map<string, number | undefined>();
    const nodes = this.state.nodes.filter(
      node => node.param9 || node.srfkey === item.srfkey,
    );
    nodes.forEach(node => {
      map.set(node.srfkey, node.param9);
      if (node.srfkey === item.srfkey) {
        node.param9 = 1;
      } else {
        node.param9 = 0;
      }
    });
    const res = await this.nodeService.update(this.panel.context, nodes);
    if (res.ok) {
      return true;
    }
    nodes.forEach(node => {
      node.param9 = map.get(node.srfkey);
    });
    return false;
  }

  /**
   * 获取排序值
   *
   * @author zhanghengfeng
   * @date 2024-01-26 20:01:07
   * @protected
   * @return {*}  {number}
   */
  protected getOrderValue(): number {
    let orderValue = 0;
    this.state.nodes.forEach(item => {
      if (item.ordervalue) {
        orderValue = Math.max(orderValue, item.ordervalue);
      }
    });
    return orderValue + 10;
  }

  /**
   * 创建节点
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:10
   * @param {MouseEvent} event
   * @return {*}  {Promise<void>}
   */
  async createNode(event: MouseEvent): Promise<void> {
    if (!this.addStatusUIActionId) {
      return;
    }
    await UIActionUtil.execAndResolved(
      this.addStatusUIActionId,
      {
        context: this.panel.context,
        params: {
          ...this.panel.params,
          leftpos: 30 * this.state.nodes.length,
          toppos: 70 * this.state.nodes.length,
          ordervalue: this.getOrderValue(),
        },
        data: [],
        view: this.panel.view,
        event,
        noWaitRoute: true,
      },
      this.model.appId,
    );
    await this.load();
  }

  /**
   * 删除节点
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:59
   * @param {IDataEntity} item
   * @return {*}  {Promise<boolean>}
   */
  async removeNode(item: IDataEntity): Promise<boolean> {
    if (!this.nodeModel.codeName) {
      return false;
    }
    const context = clone(this.panel.context);
    context[this.nodeModel.codeName.toLowerCase()] = item.srfkey;
    const res = await this.nodeService.remove(context);
    if (res.ok) {
      this.nodeMap.delete(item.srfkey);
      const index = this.state.nodes.findIndex(node => {
        return node.srfkey === item.srfkey;
      });
      if (index !== -1) {
        this.state.nodes.splice(index, 1);
        this.state.rows.splice(index, 1);
      }
      return true;
    }
    return false;
  }

  /**
   * 激活节点
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:43
   * @param {IDataEntity} item
   */
  activeNode(item: IDataEntity): void {
    this.panel.view.call(
      'onActive',
      this.nodeProvider.createDataProvider(item),
    );
  }

  /**
   * 创建连线
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:05
   * @param {X6PanelItemTableLinkData} cell
   * @return {*}  {Promise<boolean>}
   */
  async createLink(cell: X6PanelItemTableLinkData): Promise<boolean> {
    const source = cell.source;
    const target = cell.target;
    if (!source || !target) {
      return false;
    }
    const transformData = dataTransformUtil.transform(
      this.getCodeItemData(),
      this.panel.context,
      this.panel.params,
    );
    const res = await this.linkService.create(this.panel.context, {
      srcpsdelogicnodeid: source,
      defaultlink: 0,
      dstpsdelogicnodeid: target,
      psdelogiclinkname: '连接名称',
      ...transformData,
    });
    if (res.ok && res.data) {
      const link = res.data as IDataEntity;
      this.state.links.push(link);
      this.linkMap.set(link.srfkey, link);
      cell.link = link.srfkey;
      cell.isConnected = true;
      return true;
    }
    cell.isConnected = false;
    return false;
  }

  /**
   * 删除连线
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:23
   * @param {string} key
   * @return {*}  {Promise<boolean>}
   */
  async removeLink(cell: X6PanelItemTableLinkData): Promise<boolean> {
    if (!this.linkModel.codeName || !cell.link) {
      return false;
    }
    const context = clone(this.panel.context);
    context[this.linkModel.codeName.toLowerCase()] = cell.link;
    const res = await this.linkService.remove(context);
    if (res.ok) {
      this.linkMap.delete(cell.link);
      cell.link = undefined;
      cell.isConnected = false;
      const index = this.state.links.findIndex(node => {
        return node.srfkey === cell.link;
      });
      if (index !== -1) {
        this.state.links.splice(index, 1);
      }
      return true;
    }
    cell.isConnected = true;
    return false;
  }

  /**
   * 激活连线
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:50
   * @param {X6PanelItemTableLinkData} cell
   * @return {*}  {void}
   */
  activeLink(cell: X6PanelItemTableLinkData): void {
    if (!cell.link) {
      return;
    }
    const link = this.linkMap.get(cell.link);
    if (link) {
      this.panel.view.call(
        'onActive',
        this.linkProvider.createDataProvider(link),
      );
    }
  }

  destroy(): void {
    super.destroy();
    this.unsubscribeMessage();
  }
}
