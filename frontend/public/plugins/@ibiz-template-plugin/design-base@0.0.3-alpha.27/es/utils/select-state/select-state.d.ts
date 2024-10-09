import { QXEvent } from 'qx-util';
/**
 * 选中状态
 *
 * @author tony001
 * @date 2024-08-19 15:08:28
 * @export
 * @class SelectState
 * @template T
 */
export declare class SelectState<T = unknown> {
    /**
     * 选中数据
     *
     * @author tony001
     * @date 2024-08-19 15:08:36
     * @protected
     * @type {(T | null)}
     */
    protected _data: T | null;
    /**
     * 原始数据
     *
     * @author tony001
     * @date 2024-08-19 15:08:45
     * @readonly
     * @type {(T | null)}
     */
    get data(): T | null;
    /**
     * 事件对象
     *
     * @author tony001
     * @date 2024-08-19 15:08:58
     * @protected
     */
    protected evt: QXEvent<{
        change: (data: T | null) => void;
    }>;
    /**
     * 设置选中项
     *
     * @author tony001
     * @date 2024-08-19 16:08:12
     * @param {T} data
     */
    set(data: T): void;
    /**
     * 获取选中项
     *
     * @author tony001
     * @date 2024-08-19 16:08:20
     * @return {*}  {(T | null)}
     */
    get(): T | null;
    /**
     * 重置选中项
     *
     * @author tony001
     * @date 2024-08-19 16:08:31
     */
    reset(): void;
    /**
     * 订阅选中变更
     *
     * @author tony001
     * @date 2024-08-19 16:08:40
     * @param {((data?: T | null) => void)} cb
     * @return {*}  {void}
     */
    on(cb: (data?: T | null) => void): void;
    /**
     * 取消选中订阅
     *
     * @author tony001
     * @date 2024-08-19 16:08:58
     * @param {((data?: T | null) => void)} cb 一定要确定，传进来要取消订阅的方法和订阅时方法在内存中指向的是同一个
     */
    off(cb: (data?: T | null) => void): void;
}
