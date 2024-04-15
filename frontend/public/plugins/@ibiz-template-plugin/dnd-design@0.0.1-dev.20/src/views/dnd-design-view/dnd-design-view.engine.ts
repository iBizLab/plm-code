import {
  IAppDEService,
  IDataEntity,
  SysUIActionTag,
  ViewEngineBase,
  getControl,
} from '@ibiz-template/runtime';
import { IDEEditForm } from '@ibiz/model-core';
import { RuntimeModelError } from '@ibiz-template/core';
import { NavPosController } from '@ibiz-template/vue3-util';
import { DndDesignViewController } from './dnd-design-view.controller';

/**
 * dnd 设计视图引擎
 *
 * @author chitanda
 * @date 2023-11-11 17:11:39
 * @export
 * @class DndDesignViewEngine
 * @extends {ViewEngineBase}
 */
export class DndDesignViewEngine extends ViewEngineBase {
  protected declare view: DndDesignViewController;

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
   * @type {IAppDEService}
   */
  protected service!: IAppDEService;

  async onCreated(): Promise<void> {
    await super.onCreated();
    // 初始化主表单相关
    {
      const form = getControl(this.view.model, 'form') as IDEEditForm;
      if (!form) {
        throw new RuntimeModelError(this.view, '未找到主数据表单模型');
      }
      this.form = form;
      const app = ibiz.hub.getApp(this.view.model.appId);
      this.service = await app.deService.getService(
        this.view.context,
        this.form.appDataEntityId!,
      );
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

  protected onSelect(data: IData | null | undefined): void {
    this.onActive(data!);
  }

  async onMounted(): Promise<void> {
    await super.onMounted();
    // 初始化工具栏状态
    this.toolbar?.calcButtonState(
      this.view.state.data,
      this.form.appDataEntityId,
    );
    this.navPos = this.view.layoutPanel!.panelItems.nav_pos as NavPosController;
    this.activeRoot();
    this.view.evt.emit('onViewInfoChange', {
      dataInfo: this.view.state.data.srfmajortext || '',
    });
  }

  async onDestroyed(): Promise<void> {
    await super.onDestroyed();
    this.view.select.off(this.onSelect);
  }

  /**
   * 激活根节点
   *
   * @author chitanda
   * @date 2023-11-22 21:11:04
   * @protected
   */
  protected activeRoot(): void {
    this.view.select.set(this.view.state.data);
  }

  protected async load(): Promise<IData | null> {
    try {
      this.view.startLoading();
      const res = await this.service.get(this.view.context, this.view.params);
      this.service.local.add(this.view.context, res.data as IDataEntity);
      this.view.state.data = res.data as IDataEntity;
      return res.data;
    } finally {
      this.view.endLoading();
    }
  }

  protected async save(): Promise<IData | null> {
    try {
      this.view.startLoading();
      const data = this.service.local.get(
        this.view.context,
        this.view.state.data.srfkey,
      );
      // eslint-disable-next-line no-restricted-syntax
      for (const key in data) {
        if (Object.prototype.hasOwnProperty.call(data, key)) {
          const val = data[key];
          if (typeof val === 'object') {
            data[key] = undefined;
          }
        }
      }
      const res = await this.service.update(this.view.context, data!);
      this.service.local.add(this.view.context, res.data as IDataEntity);
      this.view.state.data = res.data as IDataEntity;
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
    if (key === 'onActive' && args) {
      this.onActive(args);
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
   * @param {IData} data
   */
  protected onActive(data: IData): void {
    const refs = this.view.model.appViewRefs;
    if (refs) {
      const type = data.srftype ? data.srftype.toUpperCase() : null;
      const ref = refs.find(
        item =>
          item.name ===
          `EDITDATA:${data.srfdecodename.toUpperCase()}${
            type ? `:${type}` : ''
          }`,
      );
      if (ref) {
        const context = this.view.context.clone();
        context[data.srfdecodename.toLowerCase()] = data.srfkey;
        this.navPos.openView({
          key: data.srfkey,
          viewId: ref.refAppViewId,
          context,
        });
      } else {
        throw new RuntimeModelError(
          this.view.model,
          `未匹配到对应[${data.srftype}]的属性编辑视图`,
        );
      }
    }
  }
}
