"use strict";
var MODEL_STATE = /* @__PURE__ */ ((MODEL_STATE2) => {
  MODEL_STATE2[MODEL_STATE2["Update"] = 32768] = "Update";
  MODEL_STATE2[MODEL_STATE2["Remove"] = 65536] = "Remove";
  MODEL_STATE2[MODEL_STATE2["Drag"] = 131072] = "Drag";
  MODEL_STATE2[MODEL_STATE2["Drop"] = 262144] = "Drop";
  return MODEL_STATE2;
})(MODEL_STATE || {});
class ModelStateUtil {
  /**
   * 是否启用更新
   *
   * @author zhanghengfeng
   * @date 2024-04-23 18:04:35
   * @param {number} state
   * @return {*}  {boolean}
   */
  isEnableUpdate(state) {
    if (!state) {
      return true;
    }
    return (state & 32768 /* Update */) === 32768 /* Update */;
  }
  /**
   * 是否启用删除
   *
   * @author zhanghengfeng
   * @date 2024-04-23 18:04:54
   * @param {number} state
   * @return {*}  {boolean}
   */
  isEnableRemove(state) {
    if (!state) {
      return true;
    }
    return (state & 65536 /* Remove */) === 65536 /* Remove */;
  }
  /**
   * 是否启用拖动
   *
   * @author zhanghengfeng
   * @date 2024-04-23 18:04:07
   * @param {number} state
   * @return {*}  {boolean}
   */
  isEnableDrag(state) {
    if (!state) {
      return true;
    }
    return (state & 131072 /* Drag */) === 131072 /* Drag */;
  }
  /**
   * 是否启用拖入
   *
   * @author zhanghengfeng
   * @date 2024-04-23 18:04:27
   * @param {number} state
   * @return {*}  {boolean}
   */
  isEnableDrop(state) {
    if (!state) {
      return true;
    }
    return (state & 262144 /* Drop */) === 262144 /* Drop */;
  }
}
const modelStateUtil = new ModelStateUtil();

export { modelStateUtil };
