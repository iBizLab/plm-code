/* eslint-disable */
/**
 * 模型状态
 *
 * @author zhanghengfeng
 * @date 2024-04-23 20:04:56
 * @enum {number}
 */
enum MODEL_STATE {
  /**
   * 更新
   */
  Update = 32768,

  /**
   * 删除
   */
  Remove = 65536,

  /**
   * 拖动
   */
  Drag = 131072,

  /**
   * 拖入
   */
  Drop = 262144,
}

class ModelStateUtil {
  /**
   * 是否启用更新
   *
   * @author zhanghengfeng
   * @date 2024-04-23 18:04:35
   * @param {number} state
   * @return {*}  {boolean}
   */
  isEnableUpdate(state: number): boolean {
    if (!state) {
      return true;
    }
    return (state & MODEL_STATE.Update) === MODEL_STATE.Update;
  }

  /**
   * 是否启用删除
   *
   * @author zhanghengfeng
   * @date 2024-04-23 18:04:54
   * @param {number} state
   * @return {*}  {boolean}
   */
  isEnableRemove(state: number): boolean {
    if (!state) {
      return true;
    }
    return (state & MODEL_STATE.Remove) === MODEL_STATE.Remove;
  }

  /**
   * 是否启用拖动
   *
   * @author zhanghengfeng
   * @date 2024-04-23 18:04:07
   * @param {number} state
   * @return {*}  {boolean}
   */
  isEnableDrag(state: number): boolean {
    if (!state) {
      return true;
    }
    return (state & MODEL_STATE.Drag) === MODEL_STATE.Drag;
  }

  /**
   * 是否启用拖入
   *
   * @author zhanghengfeng
   * @date 2024-04-23 18:04:27
   * @param {number} state
   * @return {*}  {boolean}
   */
  isEnableDrop(state: number): boolean {
    if (!state) {
      return true;
    }
    return (state & MODEL_STATE.Drop) === MODEL_STATE.Drop;
  }
}

const modelStateUtil = new ModelStateUtil();

export { modelStateUtil };
