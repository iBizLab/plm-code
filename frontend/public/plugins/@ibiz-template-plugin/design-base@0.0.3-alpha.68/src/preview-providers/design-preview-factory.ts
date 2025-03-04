import { IDesignPreviewProvider } from '../interface';

/* eslint-disable no-use-before-define */
export class DesignPreViewFactory {
  /**
   * 单例变量声明
   *
   * @private
   * @static
   * @type {DesignPreViewFactory}
   * @memberof DesignPreViewFactory
   */
  private static DesignPreViewFactory: DesignPreViewFactory;

  /**
   * 预览适配器Map
   *
   * @author tony001
   * @date 2024-09-10 11:09:00
   * @private
   * @type {Map<string, () => IDesignPreviewProvider>}
   */
  private preViewProviderMap: Map<string, () => IDesignPreviewProvider> =
    new Map();

  /**
   * 获取 DesignPreViewFactory 单例对象
   *
   * @static
   * @returns {DesignPreViewFactory}
   * @memberof DesignPreViewFactory
   */
  public static getInstance(): DesignPreViewFactory {
    if (!DesignPreViewFactory.DesignPreViewFactory) {
      DesignPreViewFactory.DesignPreViewFactory = new DesignPreViewFactory();
    }
    return this.DesignPreViewFactory;
  }

  /**
   * 注册预览适配器
   *
   * @author tony001
   * @date 2024-09-10 11:09:21
   * @param {string} key
   * @param {() => IDesignPreviewProvider} provider
   */
  public registerProvider(
    key: string,
    provider: () => IDesignPreviewProvider,
  ): void {
    this.preViewProviderMap.set(key, provider);
  }

  /**
   * 获取预览适配器
   *
   * @author tony001
   * @date 2024-09-10 11:09:34
   * @param {string} key
   * @return {*}  {(IDesignPreviewProvider | undefined)}
   */
  public getProvider(key: string): IDesignPreviewProvider | undefined {
    return this.preViewProviderMap.get(key)?.();
  }
}
