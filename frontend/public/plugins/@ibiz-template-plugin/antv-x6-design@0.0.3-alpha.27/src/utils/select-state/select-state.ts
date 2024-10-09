import { QXEvent } from 'qx-util';

/**
 * 选中状态
 *
 * @author chitanda
 * @date 2022-02-21 13:02:34
 * @export
 * @class SelectState
 * @template T
 */
export class SelectState<T = unknown> {
  /**
   * 选中数据
   *
   * @author chitanda
   * @date 2022-02-21 13:02:29
   * @protected
   * @type {(T | null)}
   */
  protected _data: T | null = null;

  get data(): T | null {
    return this._data;
  }

  protected evt: QXEvent<{ change: (data: T | null) => void }> = new QXEvent();

  /**
   * 设置选中项
   *
   * @author chitanda
   * @date 2022-02-21 13:02:24
   * @param {T} data
   */
  set(data: T): void {
    this._data = data;
    this.evt.emit('change', this._data);
  }

  /**
   * 获取选中项
   *
   * @author chitanda
   * @date 2022-02-21 13:02:18
   * @return {*}  {(T | null)}
   */
  get(): T | null {
    return this.data;
  }

  /**
   * 重置选中项
   *
   * @author chitanda
   * @date 2022-02-21 13:02:12
   */
  reset(): void {
    this._data = null;
    this.evt.emit('change', null);
  }

  /**
   * 订阅选中变更
   *
   * @author chitanda
   * @date 2022-02-21 14:02:04
   * @param {((data?: T | null) => void)} cb
   * @return {*}  {void}
   */
  on(cb: (data?: T | null) => void): void {
    return this.evt.on('change', cb);
  }

  /**
   * 取消选中订阅
   *
   * @author chitanda
   * @date 2022-02-21 14:02:26
   * @param {((data?: T | null) => void)} cb 一定要确定，传进来要取消订阅的方法和订阅时方法在内存中指向的是同一个
   */
  off(cb: (data?: T | null) => void): void {
    this.evt.off('change', cb);
  }
}
