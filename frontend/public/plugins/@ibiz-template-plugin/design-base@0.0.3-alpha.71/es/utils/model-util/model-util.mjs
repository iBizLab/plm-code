"use strict";
function getSysImage(item, appId) {
  if (!item) {
    return;
  }
  if (item.reficoncontent) {
    return {
      imagePath: item.reficoncontent,
      appId
    };
  }
  if (item.reficoncss) {
    return {
      cssClass: item.reficoncss,
      appId
    };
  }
  if (item.deuaiconcontent) {
    return {
      imagePath: item.deuaiconcontent,
      appId
    };
  }
  if (item.deuaiconcss) {
    return {
      cssClass: item.deuaiconcss,
      appId
    };
  }
}

export { getSysImage };
