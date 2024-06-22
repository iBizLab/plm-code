import { ScriptFactory } from '@ibiz-template/runtime';

export class DataTransformUtil {
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
  transform(data: IData, context: IContext, params: IParams): IData {
    const result: IData = {};
    if (!data || typeof data !== 'object') {
      return result;
    }
    Object.entries(data).forEach(([key, value]) => {
      if (typeof value === 'string') {
        const replaceValue = value.replace(
          /\$\{([^}]+)\}/g,
          function (_match, variable) {
            return `\${${variable} != null ? ${variable} : ''}`;
          },
        );

        result[key] = ScriptFactory.execSingleLine(`\`${replaceValue}\``, {
          context,
          params,
        });
        return;
      }
      result[key] = value;
    });
    return result;
  }
}

export const dataTransformUtil = new DataTransformUtil();
