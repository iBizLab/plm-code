"use strict";
class PreViewProviderBase {
  async init(view) {
  }
  getTargetDataBySourceData(type, source) {
    return source;
  }
  getPropertyByTag(tag) {
    return [];
  }
}

export { PreViewProviderBase };
