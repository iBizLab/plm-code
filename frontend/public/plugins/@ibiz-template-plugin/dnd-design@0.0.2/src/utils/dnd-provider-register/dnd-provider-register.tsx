import { DndItemProvider } from '../../interface';

/**
 * 拖拽组件绘制注册器
 *
 * @author chitanda
 * @date 2023-12-15 17:12:05
 * @export
 * @class DndProviderRegister
 */
export class DndProviderRegister {
  protected dndProviderMap: Map<string, DndItemProvider> = new Map();

  /**
   * 注册拖拽组件绘制
   *
   * @author chitanda
   * @date 2023-12-15 18:12:33
   * @param {DndItemProvider} dndProvider
   */
  registerItemProvider(type: string, dndProvider: DndItemProvider) {
    this.dndProviderMap.set(type.toUpperCase(), dndProvider);
  }

  /**
   * 获取拖拽组件绘制
   *
   * @author chitanda
   * @date 2023-12-18 16:12:17
   * @param {string} type
   * @return {*}  {DndItemProvider}
   */
  getItemProvider(type: string): DndItemProvider {
    const upperType = type.toUpperCase();
    if (this.dndProviderMap.has(upperType)) {
      return this.dndProviderMap.get(upperType)!;
    }
    throw new Error(`未找到${upperType}对应的拖拽组件绘制`);
  }
}

/**
 * 拖拽注册中心唯一实例
 */
export const dndProviderRegister = new DndProviderRegister();
