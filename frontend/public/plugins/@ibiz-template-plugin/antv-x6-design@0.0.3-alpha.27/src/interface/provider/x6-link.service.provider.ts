import { Edge, Options } from '@antv/x6';
import { IDataEntity } from '@ibiz-template/runtime';
import { X6CellServiceProvider } from './x6-cell.service.provider';
import { X6LinkDataProvider } from './x6-link-data.provider';
import { X6DesignViewController } from '../../views';

/**
 * 连线适配器
 *
 * @author chitanda
 * @date 2023-11-09 21:11:34
 * @export
 * @interface X6LinkServiceProvider
 */
export interface X6LinkServiceProvider
  extends X6CellServiceProvider<Edge.Metadata> {
  createDataProvider(data: IDataEntity): X6LinkDataProvider<IDataEntity>;

  /**
   * 创建连线实例
   *
   * @author chitanda
   * @date 2023-11-21 17:11:02
   * @param {X6LinkDataProvider<IDataEntity>} data
   * @return {*}  {Edge.Metadata}
   */
  createCell(data: X6LinkDataProvider<IDataEntity>): Edge.Metadata;

  /**
   * 自定义渲染label标签
   *
   * @author zhanghengfeng
   * @date 2024-01-30 17:01:23
   * @param {Options.OnEdgeLabelRenderedArgs} args
   * @return {*}  {undefined}
   */
  onEdgeLabelRendered(args: Options.OnEdgeLabelRenderedArgs): undefined;

  /**
   * 数据加载后处理
   *
   * @author zhanghengfeng
   * @date 2024-02-01 19:02:01
   * @param {X6DesignViewController} view
   */
  afterLoad?(view: X6DesignViewController): void;
}
