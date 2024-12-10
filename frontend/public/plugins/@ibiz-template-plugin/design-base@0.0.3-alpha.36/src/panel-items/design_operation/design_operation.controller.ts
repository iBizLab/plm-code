/* eslint-disable no-await-in-loop */
/* eslint-disable @typescript-eslint/no-unused-vars */
/* eslint-disable no-restricted-syntax */
/* eslint-disable guard-for-in */
/* eslint-disable @typescript-eslint/no-explicit-any */
import { debounce } from 'lodash-es';
import {
  getControl,
  IAppDEService,
  PanelItemController,
} from '@ibiz-template/runtime';
import {
  IAppDataEntity,
  IAppView,
  IDEEditForm,
  IPanelContainer,
} from '@ibiz/model-core';
import { generateOrderValue } from 'qx-util';
import { IPortalMessage } from '@ibiz-template/core';
import { DesignOperationState } from './design_operation.state';
import {
  IActionItem,
  IDesignViewEvent,
  IDesignViewState,
  INewItem,
  ITreeNode,
} from '../../interface';
import { DesignViewControllerBase } from '../../views';

export class DesignOperationController extends PanelItemController<IPanelContainer> {
  /**
   * 当前状态
   *
   * @author tony001
   * @date 2024-09-10 16:09:07
   * @type {DesignOperationState}
   */
  declare state: DesignOperationState;

  /**
   * 主数据服务
   *
   * @author tony001
   * @date 2024-09-10 16:09:23
   * @protected
   * @type {IAppDEService}
   */
  protected majorService!: IAppDEService;

  /**
   * 子项数据服务
   *
   * @author tony001
   * @date 2024-09-10 16:09:43
   * @protected
   * @type {IAppDEService}
   */
  protected itemService!: IAppDEService;

  /**
   * 主实体
   *
   * @author tony001
   * @date 2024-09-10 16:09:53
   * @protected
   * @type {IAppDataEntity}
   */
  protected majorEntity!: IAppDataEntity;

  /**
   * 从实体
   *
   * @author tony001
   * @date 2024-09-10 16:09:07
   * @protected
   * @type {IAppDataEntity}
   */
  protected itemEntity!: IAppDataEntity;

  /**
   * 类型属性
   *
   * @author tony001
   * @date 2024-09-10 16:09:21
   * @protected
   * @type {string}
   */
  protected typeKeyName: string = 'itemtype';

  /**
   * 子项实体主键名称
   *
   * @author tony001
   * @date 2024-09-10 16:09:31
   * @protected
   * @type {string}
   */
  protected itemEntityKeyName: string = '';

  /**
   * 可新建项
   *
   * @author tony001
   * @date 2024-09-10 16:09:04
   * @protected
   * @type {INewItem[]}
   */
  protected newItems: INewItem[] = [];

  /**
   * 规则数据
   *
   * @author tony001
   * @date 2024-09-10 16:09:18
   * @protected
   * @type {*}
   */
  protected ruleData: any;

  /**
   * 根路径默认参数
   *
   * @author tony001
   * @date 2024-09-10 16:09:31
   * @protected
   * @type {*}
   */
  protected defaultRoot: any = null;

  /**
   * 绘制树引用
   *
   * @author tony001
   * @date 2024-09-10 16:09:40
   * @protected
   * @type {*}
   */
  protected treeRef: any;

  /**
   * 视图对象
   *
   * @author tony001
   * @date 2024-09-10 16:09:22
   * @readonly
   * @type {DesignViewControllerBase<
   *     IAppView,
   *     IDesignViewState,
   *     IDesignViewEvent
   *   >}
   */
  get view(): DesignViewControllerBase<
    IAppView,
    IDesignViewState,
    IDesignViewEvent
  > {
    return this.panel.view as DesignViewControllerBase<
      IAppView,
      IDesignViewState,
      IDesignViewEvent
    >;
  }

  /**
   * 主表单
   *
   * @author tony001
   * @date 2024-09-10 16:09:37
   * @readonly
   * @type {IDEEditForm}
   */
  get majorForm(): IDEEditForm {
    return getControl(this.view.model, 'form') as IDEEditForm;
  }

  /**
   * 项表单
   *
   * @author tony001
   * @date 2024-09-10 16:09:45
   * @readonly
   * @type {IDEEditForm}
   */
  get itemForm(): IDEEditForm {
    return getControl(this.view.model, 'item') as IDEEditForm;
  }

  /**
   * 创建面板状态对象
   *
   * @author tony001
   * @date 2024-09-10 16:09:33
   * @protected
   * @return {*}  {DesignOperationState}
   */
  protected createState(): DesignOperationState {
    return new DesignOperationState(this.parent?.state);
  }

  /**
   * 初始化
   *
   * @author tony001
   * @date 2024-09-10 16:09:00
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async onInit(): Promise<void> {
    await super.onInit();
    this.state.activeNode = this.view.select.data?.id || '';
    // 初始化当前数据服务
    await this.initBaseResource();
    // 初始化参数
    this.initUserParam();
    // 加载数据
    await this.load();
    // 监听数据变化
    await this.subscribeDataChange();
  }

  /**
   * 初始化基础资源
   *
   * @author tony001
   * @date 2024-09-10 16:09:29
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async initBaseResource(): Promise<void> {
    const app = ibiz.hub.getApp(this.view.model.appId);
    this.majorEntity = await ibiz.hub.getAppDataEntity(
      this.majorForm!.appDataEntityId!,
      this.view.model.appId,
    );
    this.majorService = await app.deService.getService(
      this.panel.context,
      this.majorForm.appDataEntityId!,
    );
    this.itemEntity = await ibiz.hub.getAppDataEntity(
      this.itemForm!.appDataEntityId!,
      this.view.model.appId,
    );
    this.itemEntityKeyName = `${this.itemEntity?.codeName!.toLowerCase()}id`;
    this.itemService = await app.deService.getService(
      this.panel.context,
      this.itemForm!.appDataEntityId!,
    );
  }

  /**
   * 订阅数据变化
   *
   * @author tony001
   * @date 2024-09-10 17:09:50
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async subscribeDataChange(): Promise<void> {
    this.refresh = this.refresh.bind(this);
    this.onDEDataChange = debounce(this.onDEDataChange.bind(this), 200);
    this.view.evt.on('onUpdateSuccess', this.refresh);
    this.view.evt.on('onCreateSuccess', this.refresh);
    this.view.evt.on('onRemoveSuccess', this.refresh);
    ibiz.mc.command.change.on(this.onDEDataChange);
    this.onSelectDataChange = this.onSelectDataChange.bind(this);
    this.view.select.on(this.onSelectDataChange);
  }

  /**
   * 取消订阅数据变化
   *
   * @author tony001
   * @date 2024-09-10 17:09:13
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async unSubscribeDataChange(): Promise<void> {
    this.view.evt.off('onUpdateSuccess', this.refresh);
    this.view.evt.off('onCreateSuccess', this.refresh);
    this.view.evt.off('onRemoveSuccess', this.refresh);
    ibiz.mc.command.change.off(this.onDEDataChange);
    this.view.select.off(this.onSelectDataChange);
  }

  /**
   * 初始化用户参数
   *
   * @author tony001
   * @date 2024-09-10 16:09:41
   * @protected
   */
  protected initUserParam(): void {
    const userParam = this.majorForm.userParam;
    if (userParam) {
      this.typeKeyName = userParam!.fileType;
      try {
        this.ruleData = userParam?.ruleData
          ? JSON.parse(userParam.ruleData)
          : {};
        this.newItems = userParam?.newItems
          ? JSON.parse(userParam.newItems)
          : [];
        this.defaultRoot = userParam?.defaultRoot
          ? JSON.parse(userParam.defaultRoot)
          : {};
        if (this.ruleData) {
          const rules: Map<string, RegExp> = new Map();
          for (const key in this.ruleData) {
            rules.set(key, new RegExp(this.ruleData[key]));
          }
          this.state.rules = rules;
        }
      } catch (error) {
        ibiz.log.error(`JSON序列化出错!${error}`);
      }
    }
  }

  /**
   * 加载数据
   *
   * @author tony001
   * @date 2024-09-10 16:09:39
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async load(): Promise<void> {
    const majorResult = await this.majorService.getTemp(
      this.panel.context,
      this.panel.params,
    );
    let majorData: IData = {};
    let itemDatas: IData[] = [];
    if (majorResult.ok && majorResult.data) {
      majorData = majorResult.data;
    }
    if (majorData) {
      const itemResult = await this.itemService.fetchDefault(
        this.panel.context,
        this.panel.params,
      );
      if (itemResult.ok && itemResult.data) {
        itemDatas = itemResult.data as IData[];
      }
    }
    await this.afterLoad({ majorData, itemDatas });
  }

  /**
   * 加载之后
   *
   * @protected
   * @memberof GridDesignOperationController
   */
  protected async afterLoad(args: IData): Promise<void> {
    const { majorData, itemDatas } = args;
    const rootData: IData = {};
    if (majorData) {
      const rootNode = this.generateTreeNode(majorData);
      Object.assign(rootData, { ...rootNode, children: [] });
    }
    if (itemDatas && itemDatas.length > 0) {
      this.state.items = itemDatas;
      itemDatas.forEach((item: any) => {
        if (!item[`p${this.itemEntityKeyName}`]) {
          const node = this.generateTreeNode(item);
          this.calcTreeNodes(itemDatas, node);
          rootData.children.push(node);
        }
      });
    }
    this.state.treeData.length = 0;
    this.state.treeData.push(rootData as ITreeNode);
    if (this.treeRef) {
      this.treeRef.expandAll();
    }
  }

  /**
   * 刷新
   *
   * @author tony001
   * @date 2024-09-10 17:09:48
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async refresh(): Promise<void> {
    await this.load();
    if (this.view.select.data?.id) {
      const data = this.state.items.find(
        item => item.srfkey === this.view.select.data?.id,
      );
      if (!data) {
        this.panel.view.call('onActiveRoot');
      }
    }
  }

  /**
   * 选中数据变化
   *
   * @author tony001
   * @date 2024-09-10 17:09:57
   * @protected
   * @param {(IData | null)} [data]
   */
  protected onSelectDataChange(data?: IData | null): void {
    this.state.activeNode = data?.id || '';
  }

  /**
   * 监听数据变化
   *
   * @author tony001
   * @date 2024-09-10 17:09:49
   * @protected
   * @param {IPortalMessage} msg
   */
  protected onDEDataChange(msg: IPortalMessage): void {
    const { data } = msg;
    if (data && (data as IData).srfdecodename) {
      const triggerDECodeName = (data as IData).srfdecodename;
      if (
        triggerDECodeName === this.itemEntity.codeName ||
        triggerDECodeName === this.majorEntity.codeName
      ) {
        this.refresh();
      }
    }
  }

  /**
   * 生成树节点
   *
   * @author tony001
   * @date 2024-09-10 16:09:22
   * @protected
   * @param {IData} data
   * @return {*}  {ITreeNode}
   */
  protected generateTreeNode(data: IData): ITreeNode {
    const type = data[this.typeKeyName];
    const newItem = this.newItems.find(item => item.type === type)!;
    let icon: string = '';
    if (newItem) {
      icon = newItem.icon!;
    }
    if (data.hiddenitem === 1) {
      icon = 'eye-off-outline';
    }
    if (data.enablemode === 0) {
      icon = 'ban-outline';
    }
    const param: ITreeNode = {
      id: data.srfkey,
      label: data.text,
      type: data.itemtype,
      icon,
      data,
    };
    return param;
  }

  /**
   * 递归计算树结构数据
   *
   * @author tony001
   * @date 2024-09-10 16:09:31
   * @protected
   * @param {any[]} items
   * @param {ITreeNode} p
   */
  protected calcTreeNodes(items: any[], p: ITreeNode): void {
    if (items) {
      p.children = [];
      items.forEach(item => {
        const pk = `p${this.itemEntityKeyName}`;
        if (item[pk] != null && item[pk] === p.id) {
          const data = this.generateTreeNode(item);
          p.children!.push(data);
          this.calcTreeNodes(items, data);
        }
      });
    }
  }

  /**
   * 设置树引用
   *
   * @author tony001
   * @date 2024-09-10 17:09:25
   * @param {*} treeRef
   */
  public setTreeRef(treeRef: any): void {
    this.treeRef = treeRef;
  }

  /**
   * 树节点选中
   *
   * @author tony001
   * @date 2024-09-10 17:09:47
   * @param {ITreeNode} data
   * @param {IData} node
   */
  public onNodeSelect(data: ITreeNode, node: IData): void {
    const sourceData = data.data;
    if (node.level === 1) {
      this.view.call('onActiveRoot');
    } else {
      this.view.call('onActive', {
        id: sourceData.srfkey!,
        label: sourceData.srfmajortext!,
        type: sourceData.itemtype,
        data: sourceData,
      });
    }
  }

  /**
   * 树节点行为项点击
   *
   * @author tony001
   * @date 2024-09-10 17:09:10
   * @param {MouseEvent} e
   * @param {IActionItem} action
   * @param {IData} [data]
   * @return {*}  {void}
   */
  public onActionClick(e: MouseEvent, action: IActionItem, data?: IData): void {
    const { type } = action;
    switch (type) {
      case 'add':
        this.createItem(e, data as IData);
        return;
      case 'remove':
        this.remove(data as IData);
        return;
      default:
        ibiz.log.error(`${type}类型暂不支持`);
    }
  }

  /**
   * 打开新建项
   *
   * @author tony001
   * @date 2024-09-10 17:09:52
   * @protected
   * @param {MouseEvent} e
   * @param {IData} data
   * @return {*}  {Promise<void>}
   */
  protected async createItem(e: MouseEvent, data: IData): Promise<void> {
    throw new Error('Method not implemented.');
  }

  /**
   * 新建
   *
   * @author tony001
   * @date 2024-09-10 17:09:36
   * @protected
   * @param {IData} data
   * @return {*}  {Promise<void>}
   */
  protected async create(data: IData): Promise<void> {
    const result = await this.itemService.createTemp(this.panel.context, data);
    if (result.ok && Array.isArray(result.data)) {
      this.view.evt.emit('onCreateSuccess', undefined);
      const item = result.data[result.data.length - 1];
      if (item) {
        this.view.call('onActive', {
          id: item.srfkey!,
          label: item.srfmajortext!,
          type: item.itemtype,
          data: item,
        });
      }
    } else {
      ibiz.log.error('新建表格列失败');
    }
  }

  /**
   * 删除
   *
   * @author tony001
   * @date 2024-09-10 17:09:45
   * @protected
   * @param {IData} data
   * @return {*}  {Promise<void>}
   */
  protected async remove(data: IData): Promise<void> {
    const tempContext = this.panel.context.clone();
    Object.assign(tempContext, {
      [this.itemEntity.codeName!.toLowerCase()]: data[this.itemEntityKeyName],
    });
    const res = await this.itemService.remove(
      tempContext,
      this.panel.params,
      data,
    );
    if (res.ok) {
      this.view.evt.emit('onRemoveSuccess', undefined);
      if (this.view.select.data?.id === data?.srfkey) {
        this.panel.view.call('onActiveRoot');
      }
    } else {
      ibiz.message.error('删除失败!');
    }
  }

  /**
   * 节点拖拽完成
   *
   * @author tony001
   * @date 2024-09-10 17:09:44
   * @param {IData} draggingNode
   * @param {IData} dropNode
   * @param {string} dropType
   * @return {*}  {Promise<void>}
   */
  public async onNodeDrop(
    draggingNode: IData,
    dropNode: IData,
    dropType: string,
  ): Promise<void> {
    let parent = dropNode.parent;
    if (dropType === 'inner') {
      parent = dropNode;
    }
    const pData = parent?.data?.data;
    const updateFn = async (data: any, index: number): Promise<void> => {
      data.ordervalue = generateOrderValue(index);
      data.srfordervalue = data.ordervalue;
      if (
        !(
          this.panel.context[this.majorEntity.codeName!.toLowerCase()] ===
          pData?.srfkey
        )
      ) {
        data[`p${this.itemEntity.codeName?.toLowerCase()}id`] = pData.srfkey;
      } else {
        data[`p${this.itemEntity.codeName?.toLowerCase()}id`] = null;
        data.srfpmajortext = null;
      }
      await this.itemService.update(this.panel.context, data);
    };
    if (parent && parent.childNodes.length > 0) {
      for (let i = 0; i < parent.childNodes.length; i++) {
        const { data } = parent.childNodes[i].data;
        await updateFn(data, i);
      }
    }
    this.view.evt.emit('onUpdateSuccess', undefined);
  }

  /**
   * 销毁
   *
   * @author tony001
   * @date 2024-09-10 17:09:47
   */
  destroy(): void {
    super.destroy();
    this.unSubscribeDataChange();
  }
}
