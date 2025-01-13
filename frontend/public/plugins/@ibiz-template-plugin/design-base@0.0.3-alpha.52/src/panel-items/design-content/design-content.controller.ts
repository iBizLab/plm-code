/* eslint-disable no-empty-function */
import { createUUID } from 'qx-util';
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
import { IPortalMessage } from '@ibiz-template/core';
import { DesignContentState } from './design_content.state';
import { DesignViewControllerBase } from '../../views';
import { IDesignViewEvent, IDesignViewState } from '../../interface';

export class DesignContentController extends PanelItemController<IPanelContainer> {
  /**
   * 当前状态
   *
   * @author tony001
   * @date 2024-09-10 14:09:09
   * @type {DesignContentState}
   */
  declare state: DesignContentState;

  /**
   * 主服务
   *
   * @author tony001
   * @date 2024-09-10 14:09:22
   * @protected
   * @type {IAppDEService}
   */
  protected majorService!: IAppDEService;

  /**
   * 从数据服务
   *
   * @author tony001
   * @date 2024-09-10 14:09:31
   * @protected
   * @type {IAppDEService}
   */
  protected itemService!: IAppDEService;

  /**
   * 主实体
   *
   * @author tony001
   * @date 2024-09-10 14:09:46
   * @protected
   * @type {IAppDataEntity}
   */
  protected majorEntity!: IAppDataEntity;

  /**
   * 从实体
   *
   * @author tony001
   * @date 2024-09-10 14:09:05
   * @protected
   * @type {IAppDataEntity}
   */
  protected itemEntity!: IAppDataEntity;

  /**
   * 主表单
   *
   * @author tony001
   * @date 2024-09-10 14:09:17
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
   * @date 2024-09-10 14:09:26
   * @readonly
   * @type {IDEEditForm}
   */
  get itemForm(): IDEEditForm {
    return getControl(this.view.model, 'item') as IDEEditForm;
  }

  /**
   * 视图对象
   *
   * @author tony001
   * @date 2024-09-10 15:09:46
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
   * 创建面板状态对象
   *
   * @author tony001
   * @date 2024-09-10 14:09:24
   * @protected
   * @return {*}  {DesignContentState}
   */
  protected createState(): DesignContentState {
    return new DesignContentState(this.parent?.state);
  }

  /**
   * 初始化
   *
   * @author tony001
   * @date 2024-08-19 16:08:12
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async onInit(): Promise<void> {
    await super.onInit();
    // 初始化当前数据服务
    await this.initBaseResource();
    // 加载数据
    await this.load();
    // 数据变化重新加载
    await this.subscribeDataChange();
  }

  /**
   * 初始化基础资源
   *
   * @author tony001
   * @date 2024-09-10 15:09:30
   * @protected
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
    this.itemService = await app.deService.getService(
      this.panel.context,
      this.itemForm!.appDataEntityId!,
    );
  }

  /**
   * 订阅数据变化
   *
   * @author tony001
   * @date 2024-09-10 15:09:10
   * @protected
   */
  protected async subscribeDataChange(): Promise<void> {
    this.refresh = this.refresh.bind(this);
    this.onDEDataChange = this.onDEDataChange.bind(this);
    this.view.evt.on('onUpdateSuccess', this.refresh);
    this.view.evt.on('onCreateSuccess', this.refresh);
    this.view.evt.on('onRemoveSuccess', this.refresh);
    this.view.evt.on('onSaveSuccess', this.refresh);
    ibiz.mc.command.change.on(this.onDEDataChange);
  }

  /**
   * 取消订阅数据变化
   *
   * @author tony001
   * @date 2024-09-10 15:09:06
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async unSubscribeDataChange(): Promise<void> {
    this.view.evt.off('onUpdateSuccess', this.refresh);
    this.view.evt.off('onCreateSuccess', this.refresh);
    this.view.evt.off('onRemoveSuccess', this.refresh);
    this.view.evt.off('onSaveSuccess', this.refresh);
    ibiz.mc.command.change.off(this.onDEDataChange);
  }

  /**
   * 加载数据
   *
   * @author tony001
   * @date 2024-09-04 09:09:05
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async load(): Promise<void> {
    const majorResult = await this.majorService.getTemp(
      this.panel.context,
      this.panel.params,
    );
    if (majorResult.ok && majorResult.data) {
      const majorData = majorResult.data;
      const itemResult = await this.itemService.fetchDefault(
        this.panel.context,
        this.panel.params,
      );
      if (itemResult.ok && itemResult.data) {
        const itemDatas = itemResult.data as IData[];
        await this.afterLoad({ majorData, itemDatas });
      }
    }
  }

  /**
   * 加载之后
   *
   * @author tony001
   * @date 2024-09-10 15:09:35
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async afterLoad(args: IData): Promise<void> {
    const { majorData, itemDatas } = args;
    this.state.majorData = majorData;
    this.state.itemDatas.length = 0;
    this.state.itemDatas.push(...itemDatas);
  }

  /**
   * 刷新
   *
   * @author tony001
   * @date 2024-09-10 15:09:27
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async refresh(): Promise<void> {
    await this.load();
    this.state.refreshTag = createUUID();
  }

  /**
   * 监听数据变化
   *
   * @author tony001
   * @date 2024-09-10 15:09:25
   * @protected
   * @param {IPortalMessage} msg
   */
  protected onDEDataChange(msg: IPortalMessage): void {
    const { data } = msg;
    if (data && (data as IData).srfdecodename === this.itemEntity.codeName) {
      this.refresh();
    }
  }

  /**
   * 销毁
   *
   * @author tony001
   * @date 2024-09-02 18:09:42
   */
  destroy(): void {
    super.destroy();
    this.unSubscribeDataChange();
  }
}
