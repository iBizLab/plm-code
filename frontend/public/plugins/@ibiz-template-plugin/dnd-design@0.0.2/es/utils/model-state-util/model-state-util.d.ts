declare class ModelStateUtil {
    /**
     * 是否启用更新
     *
     * @author zhanghengfeng
     * @date 2024-04-23 18:04:35
     * @param {number} state
     * @return {*}  {boolean}
     */
    isEnableUpdate(state: number): boolean;
    /**
     * 是否启用删除
     *
     * @author zhanghengfeng
     * @date 2024-04-23 18:04:54
     * @param {number} state
     * @return {*}  {boolean}
     */
    isEnableRemove(state: number): boolean;
    /**
     * 是否启用拖动
     *
     * @author zhanghengfeng
     * @date 2024-04-23 18:04:07
     * @param {number} state
     * @return {*}  {boolean}
     */
    isEnableDrag(state: number): boolean;
    /**
     * 是否启用拖入
     *
     * @author zhanghengfeng
     * @date 2024-04-23 18:04:27
     * @param {number} state
     * @return {*}  {boolean}
     */
    isEnableDrop(state: number): boolean;
}
declare const modelStateUtil: ModelStateUtil;
export { modelStateUtil };
