import { IPreviewProvider } from '../interface';

/* eslint-disable no-use-before-define */
export class DndPreViewFactory {
  /**
   * 单例变量声明
   *
   * @private
   * @static
   * @type {DndPreViewFactory}
   * @memberof DndPreViewFactory
   */
  private static DndPreViewFactory: DndPreViewFactory;

  /**
   * 预览providerMap
   *
   * @author tony001
   * @date 2024-09-04 12:09:55
   * @private
   * @type {Map<string, IPreviewProvider>}
   */
  private preViewProviderMap: Map<string, IPreviewProvider> = new Map();

  /**
   * 获取 DndPreViewFactory 单例对象
   *
   * @static
   * @returns {DndPreViewFactory}
   * @memberof DndPreViewFactory
   */
  public static getInstance(): DndPreViewFactory {
    if (!DndPreViewFactory.DndPreViewFactory) {
      DndPreViewFactory.DndPreViewFactory = new DndPreViewFactory();
    }
    return this.DndPreViewFactory;
  }

  /**
   * 注册provider
   *
   * @author tony001
   * @date 2024-09-04 12:09:01
   * @param {string} key
   * @param {IPreviewProvider} provider
   */
  public registerProvider(key: string, provider: IPreviewProvider): void {
    this.preViewProviderMap.set(key, provider);
  }

  /**
   * 获取provider
   *
   * @author tony001
   * @date 2024-09-04 12:09:41
   * @param {string} key
   * @return {*}  {IPreviewProvider}
   */
  public getProvider(key: string): IPreviewProvider | undefined {
    return this.preViewProviderMap.get(key);
  }
}
