import { IDataEntity } from '@ibiz-template/runtime';
import { Cell } from '@antv/x6';
import { X6CellDataProvider } from './x6-cell-data.provider';

/**
 * 图形节点适配器
 *
 * @author chitanda
 * @date 2023-11-21 17:11:26
 * @export
 * @interface X6CellServiceProvider
 * @template C
 * @template D
 */
export interface X6CellServiceProvider<C = IData, D = IDataEntity> {
  create(context: IContext, params: IParams, cell: C, items?: D[]): Promise<D>;
  update(context: IContext, params: IParams, cell: C): Promise<D>;
  delete(context: IContext, params: IParams, id: string): Promise<D>;
  select(context: IContext, params: IParams): Promise<D[]>;
  get(context: IContext, params: IParams, id: string): Promise<D>;
  copy?(context: IContext, params: IParams, cell: C): Promise<D>;

  /**
   * 建立数据对象，实例化数据适配器
   *
   * @author chitanda
   * @date 2023-11-20 12:11:24
   * @param {D} data
   * @return {*}  {X6CellDataProvider<D>}
   */
  createDataProvider(data: D): X6CellDataProvider<D>;

  /**
   * 创建图形实例
   *
   * @author chitanda
   * @date 2023-11-21 18:11:20
   * @param {X6CellDataProvider<D>} data
   * @return {*}  {Cell.Metadata}
   */
  createCell(data: X6CellDataProvider<D>): Cell.Metadata;

  /**
   * 初始化
   *
   * @author zhanghengfeng
   * @date 2024-02-19 16:02:57
   * @param {IContext} context
   * @param {IParams} params
   * @return {*}  {Promise<void>}
   */
  init(context: IContext, params: IParams): Promise<void>;
}
