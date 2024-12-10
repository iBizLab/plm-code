import { X6Options } from '../../interface';

/**
 * 初始化默认参数
 *
 * @author chitanda
 * @date 2023-11-09 17:11:23
 * @export
 * @param {X6Options} [options={}]
 * @return {*}
 */
export function defaultX6Options(options: X6Options = {}) {
  return {
    minimap: true,
    ...options,
  };
}
