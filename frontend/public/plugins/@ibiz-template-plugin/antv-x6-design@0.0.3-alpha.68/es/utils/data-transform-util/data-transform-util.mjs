import { ScriptFactory } from '@ibiz-template/runtime';

"use strict";
class DataTransformUtil {
  /**
   * 转换数据
   *
   * @author zhanghengfeng
   * @date 2024-02-05 17:02:22
   * @param {IData} data
   * @param {IContext} context
   * @param {IParams} params
   * @return {*}  {IData}
   */
  transform(data, context, params) {
    const result = {};
    if (!data || typeof data !== "object") {
      return result;
    }
    Object.entries(data).forEach(([key, value]) => {
      if (typeof value === "string") {
        const replaceValue = value.replace(
          /\$\{([^}]+)\}/g,
          function(_match, variable) {
            return "${".concat(variable, " != null ? ").concat(variable, " : ''}");
          }
        );
        result[key] = ScriptFactory.execSingleLine("`".concat(replaceValue, "`"), {
          context,
          params
        });
        return;
      }
      result[key] = value;
    });
    return result;
  }
}
const dataTransformUtil = new DataTransformUtil();

export { DataTransformUtil, dataTransformUtil };
