import { IDataEntity } from '@ibiz-template/runtime';
import { VNode, inject } from 'vue';
/**
 * 绘制拖拽组，给有子容器的项用于绘制子
 *
 * @author chitanda
 * @date 2023-12-23 17:12:37
 * @export
 * @return {*}  {(items2: IDataEntity[], parent2: IDataEntity) => VNode | VNode[]}
 */
export function useRenderItems(): (
  items: IDataEntity[],
  parent?: IDataEntity,
  renderChildren?: (
    items2: IDataEntity[],
    parent2: IDataEntity,
  ) => VNode | VNode[],
) => VNode {
  return inject('dndDesignRenderItems') as (
    items: IDataEntity[],
    parent?: IDataEntity,
    renderChildren?: (
      items2: IDataEntity[],
      parent2: IDataEntity,
    ) => VNode | VNode[],
  ) => VNode;
}
