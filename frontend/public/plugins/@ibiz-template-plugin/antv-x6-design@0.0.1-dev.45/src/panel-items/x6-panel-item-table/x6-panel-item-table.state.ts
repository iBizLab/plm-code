import { IDataEntity, PanelItemState } from '@ibiz-template/runtime';
import { X6PanelItemTableLinkData } from '../../interface';

export class X6PanelItemTableState extends PanelItemState {
  /**
   * 节点
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:08
   * @type {IDataEntity[]}
   */
  nodes: IDataEntity[] = [];

  /**
   * 连线
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:16
   * @type {IDataEntity[]}
   */
  links: IDataEntity[] = [];

  /**
   * 表格行数据
   *
   * @author zhanghengfeng
   * @date 2024-01-25 16:01:27
   * @type {Record<string, X6PanelItemTableLinkData>[]}
   */
  rows: Record<string, X6PanelItemTableLinkData>[] = [];
}
