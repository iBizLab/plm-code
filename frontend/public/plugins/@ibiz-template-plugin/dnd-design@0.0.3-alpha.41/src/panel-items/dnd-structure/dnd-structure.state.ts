import { PanelItemState } from '@ibiz-template/runtime';
import { IDndStructureNodeData } from '../../interface';

export class DndStructurePanelItemState extends PanelItemState {
  /**
   * 树节点数据
   *
   * @author zhanghengfeng
   * @date 2023-12-28 19:12:54
   * @type {IDndStructureNodeData[]}
   */
  items: IDndStructureNodeData[] = [];
}
