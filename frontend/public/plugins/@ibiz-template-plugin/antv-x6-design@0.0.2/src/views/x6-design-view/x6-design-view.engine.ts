import {
  EditFormService,
  IDataEntity,
  SysUIActionTag,
  ViewEngineBase,
  getControl,
} from '@ibiz-template/runtime';
import { IDEEditForm } from '@ibiz/model-core';
import { RuntimeModelError } from '@ibiz-template/core';
import { NavPosController } from '@ibiz-template/vue3-util';
import { X6DesignViewController } from './x6-design-view.controller';
import { X6PanelItemController } from '../../panel-items/x6-panel-item/x6-panel-item.controller'; // 此导入只做类型声明用，不会被打包进来
import { X6CellDataProvider } from '../../interface';

/**
 * x6 设计视图引擎
 *
 * @author chitanda
 * @date 2023-11-11 17:11:39
 * @export
 * @class X6DesignViewEngine
 * @extends {ViewEngineBase}
 */
export class X6DesignViewEngine extends ViewEngineBase {
  protected declare view: X6DesignViewController;

  /**
   * 主数据表单(主要用于主数据加载相关接口模型)
   *
   * @author chitanda
   * @date 2023-11-16 17:11:08
   * @protected
   * @type {IDEEditForm}
   */
  protected form!: IDEEditForm;

  /**
   * X6 设计主内容区组件控制器
   *
   * @author chitanda
   * @date 2023-11-20 11:11:07
   * @protected
   * @type {X6PanelItemController}
   */
  protected x6!: X6PanelItemController;

  /**
   * 属性区导航占位控制器
   *
   * @author chitanda
   * @date 2023-11-22 12:11:07
   * @protected
   * @type {NavPosController}
   */
  protected navPos!: NavPosController;

  /**
   * 主数据表单服务
   *
   * @author chitanda
   * @date 2023-11-16 17:11:13
   * @protected
   * @type {EditFormService}
   */
  protected service!: EditFormService;

  async onCreated(): Promise<void> {
    await super.onCreated();
    // 初始化主表单相关
    {
      const form = getControl(this.view.model, 'form') as IDEEditForm;
      if (!form) {
        throw new RuntimeModelError(this.view, '未找到主数据表单模型');
      }
      this.form = form;
      this.service = new EditFormService(this.form);
      await this.service.init(this.view.context);
    }
    this.onSelect = this.onSelect.bind(this);
    // 订阅视图级选中事件
    this.view.select.on(this.onSelect);
    this.view.modal.hooks.shouldDismiss.tapPromise(async context => {
      const uiDomain = ibiz.uiDomainManager.get(this.view.context.srfsessionid);
      if (uiDomain.dataModification === true && context.allowClose == null) {
        const isAllow = await ibiz.confirm.error({
          title: '关闭提醒',
          desc: '数据已经修改，确定要关闭？',
        });
        if (!isAllow) {
          context.allowClose = false;
        } else {
          context.allowClose = true;
        }
      }
    });
    await this.load();
  }

  protected onSelect(data: X6CellDataProvider | undefined | null): void {
    if (data) {
      this.onActive(data);
    }
  }

  async onMounted(): Promise<void> {
    await super.onMounted();
    // 初始化工具栏状态
    this.toolbar?.calcButtonState(
      this.view.state.data,
      this.form.appDataEntityId,
    );
    this.navPos = this.view.layoutPanel!.panelItems.nav_pos as NavPosController;
    this.x6 = this.view.layoutPanel!.panelItems
      .x6_panel_item as X6PanelItemController;
    this.activeRoot();
    this.view.evt.emit('onViewInfoChange', {
      dataInfo: this.view.state.data.srfmajortext || '',
    });
    await this.x6.load();
  }

  /**
   * 激活根节点
   *
   * @author chitanda
   * @date 2023-11-22 21:11:04
   * @protected
   */
  protected activeRoot(): void {
    this.view.select.set({
      id: this.view.state.data.srfkey!,
      label: this.view.state.data.srfmajortext!,
      type: '',
      data: this.view.state.data,
    });
  }

  protected async load(): Promise<IData | null> {
    try {
      this.view.startLoading();
      const uiDomain = ibiz.uiDomainManager.get(this.view.context.srfsessionid);
      if (uiDomain && uiDomain.state.rsInit) {
        uiDomain.state.rsInit = false;
      }
      const res = await this.service.get(this.view.context, this.view.params);
      const app = ibiz.hub.getApp(this.view.model.appId);
      const service = await app.deService.getService(
        this.view.context,
        this.form.appDataEntityId!,
      );
      service.local.add(this.view.context, res.data.getOrigin() as IDataEntity);
      this.view.state.data = res.data.getOrigin() as IDataEntity;
      return res.data;
    } finally {
      this.view.endLoading();
    }
  }

  protected async save(): Promise<IData | null> {
    try {
      this.view.startLoading();
      const app = ibiz.hub.getApp(this.view.model.appId);
      const service = await app.deService.getService(
        this.view.context,
        this.form.appDataEntityId!,
      );
      const data = service.local.get(
        this.view.context,
        this.view.state.data.srfkey,
      )!;
      const res = await this.service.update(this.view.context, data);
      service.local.add(this.view.context, res.data.getOrigin() as IDataEntity);
      this.view.state.data = res.data.getOrigin() as IDataEntity;
      await this.view.evt.emit('onSaveSuccess', undefined);
      this.activeRoot();
      this.view.evt.emit('onViewInfoChange', {
        dataInfo: this.view.state.data.srfmajortext || '',
      });
      this.toolbar?.calcButtonState(
        this.view.state.data,
        this.form.appDataEntityId,
      );
      return res.data;
    } finally {
      this.view.endLoading();
    }
  }

  async call(key: string, args?: IData): Promise<IData | null | undefined> {
    if (key === SysUIActionTag.SAVE) {
      return this.save();
    }
    if (key === 'onActive') {
      this.view.select.set(args as X6CellDataProvider);
      return undefined;
    }
    if (key === 'onActiveRoot') {
      this.activeRoot();
      return undefined;
    }
    return super.call(key, args);
  }

  /**
   * 设置激活数据
   *
   * @description 主要控制右侧属性视图的显示
   * @author chitanda
   * @date 2023-11-22 12:11:36
   * @protected
   * @param {X6CellDataProvider} data
   */
  protected onActive(data: X6CellDataProvider): void {
    const refs = this.view.model.appViewRefs;
    if (refs) {
      const type = data.type ? data.type.toUpperCase() : null;
      const ref = refs.find(
        item =>
          item.name ===
          `EDITDATA:${data.data.srfdecodename.toUpperCase()}${
            type ? `:${type}` : ''
          }`,
      );
      if (ref) {
        const context = this.view.context.clone();
        context[data.data.srfdecodename.toLowerCase()] = data.id;
        this.navPos.openView({
          key: data.id,
          viewId: ref.refAppViewId,
          context,
        });
      } else {
        throw new RuntimeModelError(
          this.view.model,
          data.type
            ? `未匹配到对应[${data.type}]的属性编辑视图`
            : '当前数据未指定类型，无法匹配到属性编辑视图',
        );
      }
    }
  }
}