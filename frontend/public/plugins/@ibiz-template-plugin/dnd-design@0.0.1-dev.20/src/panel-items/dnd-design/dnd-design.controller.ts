import { reactive } from 'vue';
import { IPortalMessage, RuntimeModelError } from '@ibiz-template/core';
import {
  IDataEntity,
  IAppDEService,
  PanelItemController,
  getControl,
} from '@ibiz-template/runtime';
import { IPanelContainer, IDEForm } from '@ibiz/model-core';
import { ascSort, createUUID } from 'qx-util';
import { DndDesignPanelItemState } from './dnd-design.state';
import { dndProviderRegister } from '../../utils';
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
    this.view.evt.on('onSaveSuccess', async () => {
      await this.load();
      this.state.uuid = createUUID();
    });
    await this.load();
    this.subscribeMessage();
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
   * 订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:59
   */
  protected subscribeMessage(): void {
    this.onDataUpdate = this.onDataUpdate.bind(this);
    ibiz.mc.command.update.on(this.onDataUpdate);
  }

  /**
   * 取消订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:13
   */
  protected unsubscribeMessage(): void {
    ibiz.mc.command.update.off(this.onDataUpdate);
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
    const result = await this.service.fetchDefault(this.panel.context);
    this.items = result.data as IDataEntity[];
    this.items.forEach(item => {
      this.initItem(item);
    });
    this.state.items = this.calcDeepItems(this.items);
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
   * @return {*}  {IDataEntity[]}
   */
  protected calcDeepItems(
    items: IDataEntity[],
    parent?: IDataEntity,
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
        let children = this.calcDeepItems(items, item);
        if (children.length > 0) {
          children = ascSort(children as IDataEntity[], 'srfordervalue');
          item.children = reactive(children);
        } else {
          item.children = reactive([]);
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
          const { oldIndex, newIndex } = added;
          this.move(items, oldIndex, newIndex);
        }
      } else if (moved && moved.element) {
        const { oldIndex, newIndex } = moved;
        this.move(items, oldIndex, newIndex);
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
}
