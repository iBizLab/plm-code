import { IPortalMessage, RuntimeModelError } from '@ibiz-template/core';
import {
  IAppDEService,
  IDataEntity,
  PanelItemController,
  QXEventEx,
  getControl,
} from '@ibiz-template/runtime';
import {
  IAppCodeList,
  ICodeItem,
  ICodeListEditor,
  IDEForm,
  IPanelField,
} from '@ibiz/model-core';
import { ascSort } from 'qx-util';
import { DndStructurePanelItemState } from './dnd-structure.state';
import { DndDesignViewController } from '../../views';
import { DndStructureNodeData } from '../../entity';
import { IDndStructureNodeData } from '../../interface';

export class DndStructurePanelItemController extends PanelItemController<IPanelField> {
  codeList!: IAppCodeList;

  protected service!: IAppDEService;

  protected form!: IDEForm;

  declare state: DndStructurePanelItemState;

  get view(): DndDesignViewController {
    return this.panel.view as DndDesignViewController;
  }

  /**
   * 事件中心
   *
   * @author zhanghengfeng
   * @date 2024-01-09 19:01:28
   */
  readonly evt = new QXEventEx<{ updateSelect: () => void }>();

  /**
   * 数据
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:44
   * @protected
   * @type {IDataEntity[]}
   */
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
   * 代码表列表
   *
   * @author zhanghengfeng
   * @date 2024-01-18 16:01:21
   * @type {{ key: string; map: Map<string, ICodeItem> }[]}
   */
  codeItemList: { key: string; map: Map<string, ICodeItem> }[] = [];

  protected createState(): DndStructurePanelItemState {
    return new DndStructurePanelItemState(this.parent?.state);
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
    const editor = this.model.editor as ICodeListEditor;
    if (editor) {
      const { appCodeListId } = editor;
      if (appCodeListId) {
        this.codeList = app.codeList.getCodeList(appCodeListId)!;
      }
      if (!this.codeList) {
        throw new RuntimeModelError(this.model, `未配置结构区代码表`);
      }
      const codeItems = this.codeList.codeItems || [];
      const codeItemList: { key: string; map: Map<string, ICodeItem> }[] = [];
      codeItems.forEach(item => {
        const key = item.value;
        const children = item.codeItems;
        if (key && Array.isArray(children)) {
          const map = new Map();
          children.forEach(child => {
            const type = child.value;
            if (type) {
              map.set(type, child);
            }
          });
          codeItemList.push({ key, map });
        }
      });
      this.codeItemList = codeItemList;
    }
    this.view.evt.on('onSaveSuccess', async () => {
      await this.load();
    });
    await this.load();
    this.subscribeMessage();
  }

  /**
   * 获取节点图标
   *
   * @author zhanghengfeng
   * @date 2024-01-18 16:01:35
   * @param {IDndStructureNodeData} node
   * @return {*}  {string}
   */
  getNodeIcon(node: IDndStructureNodeData): string | undefined {
    const entity = node.entity;
    for (let i = 0; i < this.codeItemList.length; i++) {
      const codeItem = this.codeItemList[i];
      const { key, map } = codeItem;
      const type = entity[key];
      if (type && map.get(type)) {
        return map.get(type)!.iconPath;
      }
    }
  }

  /**
   * 监听数据变化
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:59
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
          this.items.splice(index, 1);
          this.items.push(data);
          if (this.timer) {
            window.clearTimeout(this.timer);
          }
          // 防抖
          this.timer = window.setTimeout(() => {
            this.items = ascSort(this.items, 'srfordervalue');
            this.state.items = this.transformItemsToTree(this.items);
            this.evt.emit('updateSelect');
          }, 50);
        }
      }
    }
  }

  /**
   * 监听数据创建
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:10
   * @protected
   * @param {IPortalMessage} msg
   * @return {*}  {void}
   */
  protected onDataCreate(msg: IPortalMessage): void {
    if (
      this.isDisableMessage ||
      msg.messageid !== this.panel.context.srfsessionid
    ) {
      return;
    }
    if (msg.data && typeof msg.data === 'object') {
      const data = msg.data as IDataEntity;
      if (data.srfkey) {
        this.items.push(data);
        this.items = ascSort(this.items, 'srfordervalue');
        this.state.items = this.transformItemsToTree(this.items);
        this.evt.emit('updateSelect');
      }
    }
  }

  /**
   * 监听数据删除
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:26
   * @protected
   * @param {IPortalMessage} msg
   * @return {*}  {void}
   */
  protected onDataRemove(msg: IPortalMessage): void {
    if (this.isDisableMessage) {
      return;
    }
    if (msg.data && typeof msg.data === 'object') {
      const data = msg.data as IDataEntity;
      if (data.srfkey) {
        const index = this.items.findIndex(item => item.srfkey === data.srfkey);
        if (index !== -1) {
          this.items.splice(index, 1);
          this.items = ascSort(this.items, 'srfordervalue');
          this.state.items = this.transformItemsToTree(this.items);
          this.evt.emit('updateSelect');
        }
      }
    }
  }

  /**
   * 发送消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:39
   * @protected
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
   * @date 2024-01-09 18:01:44
   * @protected
   */
  protected subscribeMessage(): void {
    this.onDataUpdate = this.onDataUpdate.bind(this);
    this.onDataCreate = this.onDataCreate.bind(this);
    this.onDataRemove = this.onDataRemove.bind(this);
    this.load = this.load.bind(this);
    this.view.evt.on('onRefreshView', this.load);
    ibiz.mc.command.update.on(this.onDataUpdate);
    ibiz.mc.command.create.on(this.onDataCreate);
    ibiz.mc.command.remove.on(this.onDataRemove);
  }

  /**
   * 取消订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:55
   * @protected
   */
  protected unsubscribeMessage(): void {
    this.view.evt.off('onRefreshView', this.load);
    ibiz.mc.command.update.off(this.onDataUpdate);
    ibiz.mc.command.create.off(this.onDataCreate);
    ibiz.mc.command.remove.off(this.onDataRemove);
  }

  /**
   * 销毁方法
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:10
   */
  destroy(): void {
    super.destroy();
    this.unsubscribeMessage();
  }

  async load(): Promise<void> {
    const result = await this.service.fetchDefault(this.panel.context);
    if (result.ok && Array.isArray(result.data)) {
      const items = ascSort(result.data as IDataEntity[], 'srfordervalue');
      this.items = items;
      this.state.items = this.transformItemsToTree(items);
    } else {
      this.state.items = [];
    }
  }

  /**
   * 将列表数据转为树
   *
   * @author zhanghengfeng
   * @date 2023-12-28 19:12:36
   * @protected
   * @param {IDataEntity[]} items
   * @return {*}  {IDndStructureNodeData[]}
   */
  protected transformItemsToTree(
    items: IDataEntity[],
  ): IDndStructureNodeData[] {
    const map: Record<string, IDndStructureNodeData> = {};
    const tree: IDndStructureNodeData[] = [];

    items.forEach(item => {
      const id = item.srfkey;
      if (id) {
        map[id] = new DndStructureNodeData(item);
      }
    });

    items.forEach(item => {
      const child = map[item.srfkey];
      if (child) {
        if (item.srfpkey) {
          const parent = item.srfpkey ? map[item.srfpkey] : null;
          if (parent) {
            child.parent = parent;
            parent.children.push(child);
          }
        } else {
          child.parent = null;
          tree.push(child);
        }
      }
    });

    return tree;
  }

  /**
   * 数据拖拽变更
   *
   * @author zhanghengfeng
   * @date 2023-12-28 19:12:23
   * @param {IDndStructureNodeData} item
   * @param {IDndStructureNodeData[]} items
   * @param {IDndStructureNodeData} [parent]
   */
  change(
    item: IDndStructureNodeData,
    items: IDndStructureNodeData[],
    parent?: IDndStructureNodeData,
  ): void {
    if (parent) {
      // 移入到分组中修改父
      item.parent = parent;
      item.entity.srfpkey = parent.entity.srfkey;
    } else {
      // 移入到根节点修改父为空
      item.parent = null;
      item.entity.srfpkey = undefined;
    }
    this.move(
      items.map(node => node.entity),
      0,
      items.length - 1,
    );
  }

  /**
   * 节点排序并更新
   *
   * @author zhanghengfeng
   * @date 2023-12-28 19:12:45
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
    // 小值为起始值
    const start = oldIndex > newIndex ? newIndex : oldIndex;
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
}
