import { ISysImage } from '@ibiz/model-core';

/**
 * 获取图片模型
 *
 * @author zhanghengfeng
 * @date 2025-02-13 19:02:21
 * @export
 * @param {IData} item
 * @param {string} appId
 * @return {*}  {(ISysImage | undefined)}
 */
export function getSysImage(item: IData, appId: string): ISysImage | undefined {
  if (!item) {
    return;
  }
  if (item.reficoncontent) {
    return {
      imagePath: item.reficoncontent,
      appId,
    };
  }
  if (item.reficoncss) {
    return {
      cssClass: item.reficoncss,
      appId,
    };
  }
  if (item.deuaiconcontent) {
    return {
      imagePath: item.deuaiconcontent,
      appId,
    };
  }
  if (item.deuaiconcss) {
    return {
      cssClass: item.deuaiconcss,
      appId,
    };
  }
}
