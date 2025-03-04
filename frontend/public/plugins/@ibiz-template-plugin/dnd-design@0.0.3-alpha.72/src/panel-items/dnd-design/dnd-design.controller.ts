import { reactive } from 'vue';
import {
  IPortalMessage,
  RuntimeError,
  RuntimeModelError,
} from '@ibiz-template/core';
import {
  IDataEntity,
  IAppDEService,
  PanelItemController,
  getControl,
  getUIActionById,
  UIActionUtil,
} from '@ibiz-template/runtime';
import {
  IPanelContainer,
  IDEForm,
  IDEToolbar,
  IDETBUIActionItem,
} from '@ibiz/model-core';
import { ascSort, createUUID } from 'qx-util';
import { DndDesignPanelItemState } from './dnd-design.state';
import { dndProviderRegister, modelStateUtil } from '../../utils';
import {
  DndItemProvider,
  IDndDesignPanelItemController,
  IDndItemController,
} from '../../interface';
import { DndDesignViewController } from '../../views';

/**
 * 拖拽素材区控制器
 *
 * @author chitanda
 * @date 2023-12-14 16:12:54
 * @export
 * @class DndDesignPanelItemController
 * @extends {PanelItemController<IPanelContainer>}
 */
export class DndDesignPanelItemController
  extends PanelItemController<IPanelContainer>
  implements IDndDesignPanelItemController
{
  protected service!: IAppDEService;

  protected form!: IDEForm;

  readonly providers: Record<string, DndItemProvider> = {};

  readonly controllers: Record<string, IDndItemController> = {};

  declare state: DndDesignPanelItemState;

  get view(): DndDesignViewController {
    return this.panel.view as DndDesignViewController;
  }

  protected items: IDataEntity[] = [];

  /**
   * 定时器
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:01
   * @protected
   * @type {(number | null)}
   */
  protected timer: number | null = null;

  /**
   * 是否禁止处理消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:58
   * @protected
   * @type {boolean}
   */
  protected isDisableMessage: boolean = false;

  /**
   * 主表单
   *
   * @author zhanghengfeng
   * @date 2025-02-14 20:02:12
   * @protected
   * @type {IDEForm}
   */
  protected majorForm!: IDEForm;

  /**
   * 主表单服务
   *
   * @author zhanghengfeng
   * @date 2025-02-14 20:02:22
   * @protected
   * @type {IAppDEService}
   */
  protected majorService!: IAppDEService;

  /**
   * 创建面板状态对象
   *
   * @author zhanghengfeng
   * @date 2025-01-21 19:01:03
   * @protected
   * @return {*}  {DndDesignPanelItemState}
   */
  protected createState(): DndDesignPanelItemState {
    return new DndDesignPanelItemState(this.parent?.state);
  }

  protected async onInit(): Promise<void> {
    await super.onInit();
    const form = getControl(this.panel.view.model, 'item');
    if (!form) {
      throw new RuntimeModelError(this.panel.view, '未找到 item 表单模型');
    }
    this.form = form as IDEForm;
    const app = await ibiz.hub.getApp(this.model.appId);
    this.service = await app.deService.getService(
      this.panel.context,
      form.appDataEntityId!,
    );
    const majorForm = getControl(this.panel.view.model, 'form');
    if (!majorForm) {
      throw new RuntimeModelError(this.panel.view, '未找到 form 表单模型');
    }
    this.majorService = await app.deService.getService(
      this.panel.context,
      majorForm.appDataEntityId!,
    );
    this.view.evt.on('onSaveSuccess', async () => {
      await this.load();
      this.state.uuid = createUUID();
    });
    this.view.evt.on('onStencilAdd', async e => {
      if (!e || !e.stencil) {
        return;
      }
      const id = this.view.select.data?.srfkey;
      this.handleStencilAdd(e.stencil, id);
    });
    this.view.evt.on('onPreviewStateChange', async e => {
      if (!e) {
        return;
      }
      this.state.isPreview = e.isPreview;
      if (this.state.isPreview) {
        await this.preview();
        this.view.call('onActiveRoot');
      }
    });
    await this.load();
    this.subscribeMessage();
  }

  /**
   * 预览表单
   *
   * @author zhanghengfeng
   * @date 2025-02-14 20:02:27
   * @return {*}  {Promise<void>}
   */
  async preview(): Promise<void> {
    const majorResult = await this.majorService.getTemp(this.panel.context);
    if (!majorResult || !majorResult.data) {
      return;
    }
    const majorData = majorResult.data;
    const result = await this.service.fetchDefault(this.panel.context);
    if (!result || !Array.isArray(result.data)) {
      return;
    }
    const items = result.data as IDataEntity[];
    const preViewProvider = this.view.getPreViewProvider();
    preViewProvider.getTargetDataBySourceData('FORMDETAIL', items);
    majorData.psdeformdetails = this.calcDeepItems(
      items,
      undefined,
      'psdeformdetails',
    );
    this.state.previewData = majorData;
    this.state.previewKey = createUUID();
  }

  /**
   * 处理素材添加
   *
   * @author zhanghengfeng
   * @date 2025-02-12 22:02:48
   * @param {IData} stencil
   * @param {string} [id]
   * @param {IDataEntity} [child]
   * @return {*}  {void}
   */
  handleStencilAdd(stencil: IData, id?: string, child?: IDataEntity): void {
    if (!id) {
      return;
    }
    const parent = this.items.find(item => item.srfkey === id);
    if (!parent) {
      return;
    }
    const type = parent.srftype;
    if (!type) {
      return;
    }
    const container = [
      'GROUPPANEL',
      'FORMPAGE',
      'TABPAGE',
      'TABPANEL',
      'MDCTRL',
    ];
    if (!container.includes(type)) {
      this.handleStencilAdd(stencil, parent.srfpkey, child || parent);
      return;
    }
    if (type === 'TABPANEL') {
      return;
    }
    if (type === 'MDCTRL' && parent.mdctrltype !== 'REPEATER') {
      return;
    }
    const children: IDataEntity[] = parent.children || [];
    let newIndex = children.length;
    if (child) {
      const index = children.findIndex(item => item.srfkey === child.srfkey);
      if (index !== -1) {
        newIndex = index + 1;
      }
    }
    this.add(
      {
        added: {
          element: stencil,
          newIndex,
        },
      },
      children,
      parent,
    );
  }

  /**
   * 更新逻辑映射map
   *
   * @author zhanghengfeng
   * @date 2025-02-12 22:02:38
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async updateLogicMap(): Promise<void> {
    const appId = this.view.context.srfappid;
    if (!appId) {
      return;
    }
    const app = ibiz.hub.getApp(appId);
    if (!app) {
      return;
    }
    const entity = await ibiz.hub.getAppDataEntity('PSDEFDLogic', appId);
    if (!entity) {
      return;
    }
    const service = await app.deService.getService(
      this.view.context,
      entity.id!,
    );
    if (!service) {
      return;
    }
    const res = await service.fetchDefault(this.view.context);
    const map: Record<string, number> = {};
    if (res && Array.isArray(res.data)) {
      res.data.forEach(item => {
        const key = item.psdeformdetailid;
        if (map[key]) {
          map[key] += 1;
        } else {
          map[key] = 1;
        }
      });
    }
    this.state.logicMap = map;
  }

  /**
   * 监听数据变化
   *
   * @author zhanghengfeng
   * @date 2025-02-12 22:02:29
   * @protected
   * @param {IPortalMessage} msg
   */
  protected onDEDataChange(msg: IPortalMessage): void {
    if (msg && msg.data && typeof msg.data === 'object') {
      const data = msg.data as IDataEntity;
      if (data.srfdecodename === 'PSDEFDLogic') {
        this.updateLogicMap();
      }
    }
  }

  /**
   * 打开逻辑视图
   *
   * @author zhanghengfeng
   * @date 2025-02-12 22:02:40
   * @param {IDataEntity} item
   * @return {*}  {Promise<void>}
   */
  async openLogicView(item: IDataEntity): Promise<void> {
    if (!item) {
      return;
    }
    const structure = getControl(
      this.view.model,
      'structuretoolbar',
    ) as IDEToolbar;
    if (!structure) {
      return;
    }
    const toolbarItems = structure.detoolbarItems || [];
    if (toolbarItems && toolbarItems.length) {
      const action = toolbarItems.find(toolbarItem => {
        if (item.srftype === 'FORMITEM' || item.srftype === 'FORMITEMEX') {
          return toolbarItem.id === 'formitem';
        }
        return toolbarItem.id === 'default';
      });
      if (action && action.itemType === 'DEUIACTION') {
        const actionId = (action as IDETBUIActionItem).uiactionId;
        if (!actionId) {
          return;
        }
        const uiAction = await getUIActionById(actionId, action.appId);
        if (!uiAction) {
          throw new RuntimeError(
            ibiz.i18n.t('runtime.controller.control.toolbar.noFound', {
              actionId,
            }),
          );
        }
        const context = this.view.context.clone();
        delete context.srfrunmode;
        const modelState = this.getModelState(item);
        if (!modelStateUtil.isEnableUpdate(modelState)) {
          context.srfreadonly = true;
        }
        await UIActionUtil.execAndResolved(
          actionId,
          {
            context,
            params: this.view.params,
            data: [item],
            view: this.view,
          },
          action.appId,
        );
      }
    }
  }

  /**
   * 更新隐藏表单项可见性
   *
   * @author zhanghengfeng
   * @date 2024-06-05 13:06:07
   * @param {boolean} value
   */
  updateHiddenFormItemVisible(value: boolean): void {
    this.state.hiddenFormItemVisible = value;
  }

  /**
   * 监听数据变化
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:35
   * @protected
   * @param {IPortalMessage} msg
   * @return {*}  {void}
   */
  protected onDataUpdate(msg: IPortalMessage): void {
    if (this.isDisableMessage) {
      return;
    }
    if (msg.data && typeof msg.data === 'object') {
      const data = msg.data as IDataEntity;
      if (data.srfkey) {
        const index = this.items.findIndex(item => item.srfkey === data.srfkey);
        if (index !== -1) {
          this.removeController(this.items[index]);
          this.items.splice(index, 1, data);
          this.initItem(data);
          if (this.timer) {
            window.clearTimeout(this.timer);
          }
          // 防抖
          this.timer = window.setTimeout(() => {
            this.recalculateDeppItems();
          }, 50);
        }
      }
    }
  }

  /**
   * 发送消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:47
   * @param {IDataEntity[]} items
   * @param {IPortalMessage['subtype']} [type]
   * @param {IPortalMessage} [msg]
   */
  protected sendMessage(
    items: IDataEntity[],
    type?: IPortalMessage['subtype'],
    msg?: IPortalMessage,
  ): void {
    this.isDisableMessage = true;
    items.forEach(item => {
      if (type) {
        ibiz.mc.command.send(item, type);
        return;
      }
      if (msg) {
        ibiz.mc.command.next({ ...msg, data: item });
      }
    });
    this.isDisableMessage = false;
  }

  /**
   * 刷新
   *
   * @author zhanghengfeng
   * @date 2024-12-30 21:12:42
   * @return {*}  {Promise<void>}
   */
  async refresh(): Promise<void> {
    await this.load();
    this.state.uuid = createUUID();
  }

  /**
   * 订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:59
   */
  protected subscribeMessage(): void {
    this.onDataUpdate = this.onDataUpdate.bind(this);
    this.onDEDataChange = this.onDEDataChange.bind(this);
    this.refresh = this.refresh.bind(this);
    this.view.evt.on('onRefreshView', this.refresh);
    ibiz.mc.command.update.on(this.onDataUpdate);
    ibiz.mc.command.change.on(this.onDEDataChange);
  }

  /**
   * 取消订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:13
   */
  protected unsubscribeMessage(): void {
    this.view.evt.off('onRefreshView', this.refresh);
    ibiz.mc.command.update.off(this.onDataUpdate);
    ibiz.mc.command.change.off(this.onDEDataChange);
  }

  /**
   * 销毁方法
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:26
   */
  destroy(): void {
    super.destroy();
    this.unsubscribeMessage();
  }

  /**
   * 初始化数据项
   *
   * @author chitanda
   * @date 2023-12-21 11:12:17
   * @protected
   * @param {IDataEntity} item
   * @return {*}  {Promise<void>}
   */
  protected async initItem(item: IDataEntity): Promise<void> {
    if (item.srftype === 'FORMPAGE') {
      return;
    }
    const type = `${item.srfdecodename}_${item.srftype}`;
    const provider = dndProviderRegister.getItemProvider(type);
    const c = provider.createController(this, this.form, item);
    this.providers[item.srfkey!] = provider;
    this.controllers[item.srfkey!] = c;
  }

  /**
   * 加载项数据，并初始化适配器相关
   *
   * @author chitanda
   * @date 2023-12-18 16:12:27
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async load(): Promise<void> {
    await this.updateLogicMap();
    const result = await this.service.fetchDefault(this.panel.context);
    this.items = result.data as IDataEntity[];
    this.items.forEach(item => {
      this.initItem(item);
    });
    this.state.items = this.calcDeepItems(this.items);
    this.state.formItemLabelWidth = this.view.state.data?.labelwidth;
  }

  /**
   * 重新计算现有数据的递归结构
   *
   * @author chitanda
   * @date 2023-12-28 15:12:31
   */
  recalculateDeppItems(): void {
    this.state.items = this.calcDeepItems(this.items);
  }

  /**
   * 计算递归数据，用于渲染树界面
   *
   * @author chitanda
   * @date 2023-12-15 16:12:32
   * @protected
   * @param {IDataEntity[]} items
   * @param {IDataEntity} [parent]
   * @param {string} [key='children']
   * @return {*}  {IDataEntity[]}
   */
  protected calcDeepItems(
    items: IDataEntity[],
    parent?: IDataEntity,
    key: string = 'children',
  ): IDataEntity[] {
    const list: IDataEntity[] = [];
    items
      .filter(item => {
        if (parent == null) {
          return item.srfpkey == null;
        }
        return item.srfpkey === parent.srfkey;
      })
      .forEach(item => {
        list.push(item);
        let children = this.calcDeepItems(items, item, key);
        if (children.length > 0) {
          children = ascSort(children as IDataEntity[], 'srfordervalue');
          item[key] = reactive(children);
        } else {
          item[key] = reactive([]);
        }
      });
    return list;
  }

  /**
   * 拖拽放生变更
   *
   * @author chitanda
   * @date 2023-12-21 11:12:03
   * @param {IData} evt
   * @param {IDataEntity[]} items
   * @param {IDataEntity} [parent]
   */
  change(evt: IData, items: IDataEntity[], parent?: IDataEntity): void {
    if (evt) {
      const { added, moved } = evt;
      if (added && added.element) {
        const item = added.element as IDataEntity;
        if (!item.srfkey || Object.is(item.srfkey, '')) {
          // 新建数据
          items.splice(added.newIndex, 1);
          this.add(evt, items, parent);
        } else {
          // 从其他分组中移入
          if (parent) {
            // 移入到分组中修改父
            item.srfpkey = parent.srfkey;
          } else {
            // 移入到根节点修改父为空
            item.srfpkey = undefined;
          }
          this.move(items, 0, items.length - 1);
        }
      } else if (moved && moved.element) {
        this.move(items, 0, items.length - 1);
      }
    }
  }

  /**
   * 新增一个项
   *
   * @author chitanda
   * @date 2023-12-21 11:12:53
   * @protected
   * @param {IData} evt
   * @param {IDataEntity[]} items
   * @param {IDataEntity} [parent]
   * @return {*}  {Promise<void>}
   */
  protected async add(
    evt: IData,
    items: IDataEntity[],
    parent?: IDataEntity,
  ): Promise<void> {
    const index = evt.added.newIndex;
    const item = evt.added.element as IDataEntity;
    const res = await this.service.getDraft(this.panel.context, item);
    if (res.ok) {
      const { data } = res;
      if (item.caption && this.panel.context.srfrunmode === 'DESIGN') {
        item.caption = undefined;
      }
      Object.assign(data, item);
      data.srfordervalue = (index + 1) * 10;
      if (parent) {
        data.srfpkey = parent.srfkey;
      }
      const res2 = await this.service.create(this.panel.context, data);
      if (res2.ok) {
        const data2 = res2.data as IDataEntity;
        data2.children = reactive([]);
        await this.initItem(data2);
        this.items.push(data2);
        this.sendMessage([data2], undefined, {
          messageid: this.panel.context.srfsessionid,
          messagename: 'command',
          type: 'COMMAND',
          subtype: 'OBJECTCREATED',
        });
        items.splice(index, 0, data2);
        this.view.select.set(res2.data);
        await this.move(items, index, items.length - 1);
      }
    }
  }

  /**
   * 节点排序并更新
   *
   * @author chitanda
   * @date 2023-12-21 11:12:25
   * @protected
   * @param {IDataEntity[]} items
   * @param {number} oldIndex
   * @param {number} newIndex
   * @return {*}  {Promise<void>}
   */
  protected async move(
    items: IDataEntity[],
    oldIndex: number,
    newIndex: number,
  ): Promise<void> {
    // 变更后所有的向序号重排，所以起始值为 0
    const start = 0;
    // 大值为结束值
    const end = oldIndex > newIndex ? oldIndex : newIndex;
    // 改变排序值并获取已经改变过排序值的数据
    const list: IDataEntity[] = [];
    items.forEach((item, index) => {
      if (index >= start && index <= end) {
        item.srfordervalue = (index + 1) * 10;
        list.push(item);
      }
    });
    // 更新修改过排序值的数据
    const res = await this.service.update(this.panel.context, list);
    if (res.ok) {
      if (Array.isArray(res.data)) {
        this.sendMessage(res.data, 'OBJECTUPDATED');
      }
      ibiz.log.debug('排序成功');
    }
  }

  /**
   * 删除项
   *
   * @author chitanda
   * @date 2024-01-03 15:01:19
   * @param {IDataEntity[]} items
   * @param {IDataEntity} item
   * @return {*}  {Promise<boolean>}
   */
  async remove(items: IDataEntity[], item: IDataEntity): Promise<boolean> {
    const res = await this.service.remove(this.panel.context, {}, item);
    if (res.ok) {
      const index = this.items.findIndex(it => it.srfkey === item.srfkey);
      const index2 = items.findIndex(it => it.srfkey === item.srfkey);
      if (index > -1) {
        this.items.splice(index, 1);
        items.splice(index2, 1);
        this.removeController(item);
        this.sendMessage([item], 'OBJECTREMOVED');
        // 删除后默认选中第一个，如果没有则选中父节点，如果没有父节点则选中根节点
        const select =
          items[0] || this.items.find(it => it.srfkey === item.srfpkey);
        if (select) {
          this.view.select.set(select);
        } else {
          this.view.call('onActiveRoot');
        }
        this.recalculateDeppItems();
      }
      return true;
    }
    return false;
  }

  /**
   * 删除项控制器实例
   *
   * @author chitanda
   * @date 2024-01-03 16:01:04
   * @protected
   * @param {IDataEntity} item
   */
  protected removeController(item: IDataEntity): void {
    if (item.srftype === 'FORMPAGE') {
      return;
    }
    const c = this.controllers[item.srfkey!];
    c.destroy();
    delete this.controllers[item.srfkey!];
  }

  /**
   * 获取模型状态
   *
   * @author zhanghengfeng
   * @date 2024-04-23 20:04:49
   * @param {IDataEntity} entity
   * @return {*}  {number}
   */
  getModelState(entity: IDataEntity): number {
    let modelState = 0;
    let current = entity;
    while (current) {
      if (current.modelstate) {
        modelState = current.modelstate;
        break;
      }
      let isChange = false;
      const key = current.srfpkey;
      if (key) {
        const parent = this.controllers[key];
        if (parent) {
          current = parent.data;
          isChange = true;
        } else {
          const parent2 = this.items.find(item => item.srfkey === key);
          if (parent2) {
            current = parent2;
            isChange = true;
          }
        }
      }
      if (!isChange) {
        break;
      }
    }
    return modelState;
  }

  showMaskType: string[] = [
    'MDCTRL',
    'GROUPPANEL',
    'TABPANEL',
    'TABPAGE',
    'FORMPAGE',
  ];

  isShowMask(entity: IDataEntity): boolean {
    if (!entity) {
      return false;
    }
    const modelState = entity.modelstate;
    const mask =
      modelStateUtil.isEnablePlaceholder(modelState) &&
      this.showMaskType.includes(entity.srftype);
    if (!mask) {
      return mask;
    }
    let current = entity;
    let mask2 = false;
    while (current) {
      let isChange = false;
      const key = current.srfpkey;
      if (key) {
        const parent = this.controllers[key];
        if (parent) {
          current = parent.data;
          mask2 =
            (modelStateUtil.isEnablePlaceholder(current.modelstate) &&
              this.showMaskType.includes(current.srftype)) ||
            mask2;
          isChange = true;
        } else {
          const parent2 = this.items.find(item => item.srfkey === key);
          if (parent2) {
            current = parent2;
            mask2 =
              (modelStateUtil.isEnablePlaceholder(current.modelstate) &&
                this.showMaskType.includes(current.srftype)) ||
              mask2;
            isChange = true;
          }
        }
      }
      if (!isChange) {
        break;
      }
    }

    return !mask2;
  }
}
