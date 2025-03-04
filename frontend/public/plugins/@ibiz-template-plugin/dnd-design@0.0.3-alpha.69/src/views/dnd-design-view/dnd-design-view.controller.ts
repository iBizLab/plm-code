import { ViewController, getPFPlugin } from '@ibiz-template/runtime';
import { IAppDECustomView } from '@ibiz/model-core';
import { DndDesignViewEngine } from './dnd-design-view.engine';
import { DndDesignViewState } from './interface/dnd-design-view.state';
import { DndDesignViewEvent } from './interface/dnd-design-view.event';
import { SelectState } from '../../utils';
import { IPreviewProvider } from '../../interface';
import { DndPreViewFactory } from '../../preview-providers/dnd-preview-factory';

export class DndDesignViewController extends ViewController<
  IAppDECustomView,
  DndDesignViewState,
  DndDesignViewEvent
> {
  /**
   * 视图中的选中数据
   *
   * @author chitanda
   * @date 2023-12-21 18:12:25
   */
  readonly select = new SelectState<IData>();

  /**
   * 预览适配器
   *
   * @author tony001
   * @date 2024-09-06 15:09:59
   * @private
   * @type {IPreviewProvider}
   */
  private preViewProvider!: IPreviewProvider;

  /**
   * 获取预览区适配器
   *
   * @author tony001
   * @date 2024-09-06 15:09:07
   * @return {*}  {IPreviewProvider}
   */
  public getPreViewProvider(): IPreviewProvider {
    return this.preViewProvider;
  }

  /**
   * 生命周期-创建完成
   * - 将插件参数合入上下文中
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof DndDesignViewController
   */
  protected async onCreated(): Promise<void> {
    await super.onCreated();
    const { sysPFPluginId, appId } = this.model;
    const plugin = getPFPlugin(sysPFPluginId!, appId);
    if (plugin && plugin.pluginParams) {
      const params = plugin.pluginParams;
      Object.keys(params).forEach(key => {
        if (params[key] && key !== 'appId') {
          this.context[key.toLowerCase()] = params[key];
        }
      });
    }
    const srfRunMode = this.context.srfrunmode
      ? this.context.srfrunmode
      : 'RUNTIME';
    this.preViewProvider = DndPreViewFactory.getInstance().getProvider(
      srfRunMode,
    ) as IPreviewProvider;
    await this.preViewProvider.init(this);
  }

  protected initEngines(): void {
    this.engines.push(new DndDesignViewEngine(this));
  }
}
