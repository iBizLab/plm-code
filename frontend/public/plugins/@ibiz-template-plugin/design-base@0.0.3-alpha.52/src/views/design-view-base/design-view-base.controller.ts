import { getPFPlugin, ViewController } from '@ibiz-template/runtime';
import { IAppView } from '@ibiz/model-core';
import { SelectState } from '../../utils';
import {
  IDesignPreviewProvider,
  IDesignViewEvent,
  IDesignViewState,
} from '../../interface';

export class DesignViewControllerBase<
  M extends IAppView,
  S extends IDesignViewState,
  E extends IDesignViewEvent,
> extends ViewController<M, S, E> {
  /**
   * 选中数据
   *
   * @author tony001
   * @date 2024-09-10 10:09:14
   */
  readonly select = new SelectState<IData>();

  /**
   * 预览适配器
   *
   * @author tony001
   * @date 2024-09-10 10:09:18
   * @protected
   * @type {IDesignPreviewProvider}
   */
  protected preViewProvider!: IDesignPreviewProvider;

  /**
   * 获取预览区适配器
   *
   * @author tony001
   * @date 2024-09-10 10:09:33
   * @return {*}  {IDesignPreviewProvider}
   */
  public getPreViewProvider(): IDesignPreviewProvider {
    return this.preViewProvider;
  }

  /**
   * 生命周期-创建完成(将插件参数合入上下文中)
   *
   * @author tony001
   * @date 2024-09-10 10:09:15
   * @protected
   * @return {*}  {Promise<void>}
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
    await this.initPreViewProvider();
  }

  /**
   * 初始化预览适配器
   *
   * @author tony001
   * @date 2024-09-10 10:09:56
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async initPreViewProvider(): Promise<void> {
    throw new Error('Method not implemented.');
  }
}
