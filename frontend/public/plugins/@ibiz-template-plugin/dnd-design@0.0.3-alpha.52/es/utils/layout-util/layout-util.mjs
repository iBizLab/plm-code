"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class LayoutUtil {
  constructor() {
    /**
     * 栅格布局模式
     *
     * @author zhanghengfeng
     * @date 2024-01-29 17:01:09
     */
    __publicField(this, "gridLayoutMode", ["lg", "md", "sm", "xs"]);
  }
  /**
   * 获取栅格布局值
   *
   * @author zhanghengfeng
   * @date 2024-01-29 15:01:11
   * @param {IDataEntity} item
   * @param {string} [prefix='']
   * @param {string} [suffix='']
   * @return {*}  {(string | undefined)}
   */
  getGridLayoutModeValue(item, prefix = "", suffix = "") {
    for (let i = 0; i < this.gridLayoutMode.length; i++) {
      const mode = this.gridLayoutMode[i];
      const key = "".concat(prefix).concat(mode).concat(suffix);
      if (item[key] != null) {
        return item[key];
      }
    }
    return "";
  }
  /**
   * 获取栅格布局值，不存在时从父数据获取
   *
   * @author zhanghengfeng
   * @date 2024-01-29 09:01:05
   * @param {IDataEntity} item
   * @param {IDataEntity} parent
   * @return {*}  {(number | null)}
   */
  getGridCol(item, parent) {
    let value = this.getGridLayoutModeValue(item, "col_");
    if (parent && !value) {
      value = this.getGridLayoutModeValue(parent, "child_col_");
    }
    if (!value || value <= "0" || value > "24") {
      value = "24";
    }
    if (value) {
      const num = parseInt(value, 10);
      const layoutMode = parent == null ? void 0 : parent.layoutmode;
      if (layoutMode === "TABLE_12COL") {
        if (num > 0 && num <= 12) {
          return num * 2;
        }
      }
      if (num > 0 && num <= 24) {
        return num;
      }
    }
    return null;
  }
  /**
   * 获取栅格布局偏移
   *
   * @author zhanghengfeng
   * @date 2024-01-29 10:01:33
   * @param {IDataEntity} item
   * @param {IDataEntity} pData
   * @return {*}  {(number | null)}
   */
  getGridOffset(item, parent) {
    let value = this.getGridLayoutModeValue(item, "col_", "_os");
    if (parent && !value) {
      value = this.getGridLayoutModeValue(item, "child_col_", "_os");
    }
    if (value) {
      const num = parseInt(value, 10);
      const layoutMode = parent == null ? void 0 : parent.layoutmode;
      if (layoutMode === "TABLE_12COL") {
        if (num > 0 && num <= 12) {
          return num * 2;
        }
      }
      if (num > 0 && num <= 24) {
        return num;
      }
    }
    return null;
  }
  /**
   * 计算栅格样式
   *
   * @author zhanghengfeng
   * @date 2024-01-29 09:01:21
   * @param {IDataEntity} item
   * @param {IDataEntity} parent
   * @return {*}
   */
  calcColClass(item, parent) {
    const colClass = {};
    if (parent && parent.layoutmode === "FLEX") {
      return colClass;
    }
    const col = this.getGridCol(item, parent);
    if (col) {
      colClass["el-col-".concat(col)] = true;
    }
    const offset = this.getGridOffset(item, parent);
    if (offset) {
      colClass["el-col-offset-".concat(offset)] = true;
    }
    return colClass;
  }
  /**
   * 计算Flex容器样式
   *
   * @author zhanghengfeng
   * @date 2024-01-29 10:01:54
   * @param {IDataEntity} data
   * @return {*}
   */
  getFlexLayoutStyle(item) {
    const isFlex = item.layoutmode === "FLEX";
    if (isFlex) {
      return {
        display: "flex",
        "flex-direction": item.flexdir,
        "justify-content": item.flexalign,
        "align-items": item.flexvalign,
        "flex-grow": item.flexgrow,
        "flex-shrink": item.flexshrink,
        "flex-basis": "".concat(item.flexbasis, "px"),
        padding: "".concat(item.padding, "px")
      };
    }
    return {
      padding: "".concat(item.padding, "px")
    };
  }
  /**
   * 计算拖拽容器class
   *
   * @author zhanghengfeng
   * @date 2024-01-29 14:01:07
   * @param {IDataEntity} item
   * @param {Namespace} ns
   * @return {*}
   */
  getDraggableContainerClass(item, ns) {
    const isFlex = item.layoutmode === "FLEX";
    return {
      [ns.b("grid-layout")]: !isFlex,
      [ns.b("flex-layout")]: isFlex,
      [ns.b("flex-row")]: isFlex && item.flexdir && item.flexdir.indexOf("column") === -1,
      [ns.b("flex-column")]: isFlex && item.flexdir && item.flexdir.indexOf("column") !== -1
    };
  }
  /**
   * 计算项样式
   *
   * @author zhanghengfeng
   * @date 2024-01-29 11:01:54
   * @param {IDataEntity} item
   * @param {IDataEntity} parent
   * @return {*}
   */
  calcStyle(item, parent) {
    const style = {};
    if (!item) {
      return style;
    }
    if (item) {
      if (item.heightmode === "FULL") {
        style.height = "auto";
      } else if (item.height) {
        style.height = item.height + (item.heightmode === "PERCENTAGE" ? "%" : "px");
      } else if (parent && parent.itemtype === "PSSysViewPanel") {
        if (parent.itemtype === "CONTAINER" || parent.itemtype === "CTRLPOS") {
          style["flex-grow"] = 1;
        }
      } else {
        style.height = "auto";
      }
      if (item.widthmode === "FULL") {
        style.width = "auto";
      } else if (item.width) {
        style.width = item.width + (item.widthmode === "PERCENTAGE" ? "%" : "px");
      }
      const isFlex = (parent == null ? void 0 : parent.layoutmode) === "FLEX";
      if (isFlex) {
        if (item.flexgrow != null) {
          style["flex-grow"] = item.flexgrow;
        }
        if (item.flexshrink != null) {
          style["flex-shrink"] = item.flexshrink;
        }
        if (item.flexbasis != null) {
          style["flex-basis"] = "".concat(item.flexbasis, "px");
        }
        if (parent && (!parent.flexdir || parent.flexdir.indexOf("row") !== -1)) {
          Object.assign(style, this.getVerticalAlign(item, parent, isFlex));
        } else {
          Object.assign(style, this.getHorizontalAlign(item, parent, isFlex));
        }
      } else {
        Object.assign(style, this.getHorizontalAlign(item, parent, isFlex));
      }
      Object.assign(style, this.getSwapMode(item));
      Object.assign(style, this.getBorderStyle(item));
    }
    return style;
  }
  /**
   *获取换行模式
   *
   * @author zhanghengfeng
   * @date 2024-01-29 14:01:38
   * @param {IDataEntity} item
   * @return {*}
   */
  getSwapMode(item) {
    const style = {};
    if (item.swapmode) {
      if (item.layoutmode === "FLEX") {
        if (item.swapmode === "NOWRAP") {
          style["flex-wrap"] = "nowrap";
        } else {
          style["flex-wrap"] = "wrap";
        }
      } else if (item.swapmode === "NOWRAP") {
        style["white-space"] = "nowrap";
      } else {
        style["white-space"] = "pre-wrap";
      }
    }
    return style;
  }
  /**
   * 获取边框样式
   *
   * @author zhanghengfeng
   * @date 2024-01-29 14:01:10
   * @param {IDataEntity} item
   * @return {*}
   */
  getBorderStyle(item) {
    const style = {};
    if (item.spacingleft) {
      if (item.spacingleft.indexOf("OUTER") !== -1) {
        style["margin-left"] = this.getSpacingStyle(
          item.spacingleft.replace("OUTER", "")
        );
      } else {
        style["padding-left"] = this.getSpacingStyle(
          item.spacingleft.replace("INNER", "")
        );
      }
    }
    if (item.spacingright) {
      if (item.spacingright.indexOf("OUTER") !== -1) {
        style["margin-right"] = this.getSpacingStyle(
          item.spacingright.replace("OUTER", "")
        );
      } else {
        style["padding-right"] = this.getSpacingStyle(
          item.spacingright.replace("INNER", "")
        );
      }
    }
    if (item.spacingtop) {
      if (item.spacingtop.indexOf("OUTER") !== -1) {
        style["margin-top"] = this.getSpacingStyle(
          item.spacingtop.replace("OUTER", "")
        );
      } else {
        style["padding-top"] = this.getSpacingStyle(
          item.spacingtop.replace("INNER", "")
        );
      }
    }
    if (item.spacingbottom) {
      if (item.spacingbottom.indexOf("OUTER") !== -1) {
        style["margin-bottom"] = this.getSpacingStyle(
          item.spacingbottom.replace("OUTER", "")
        );
      } else {
        style["padding-bottom"] = this.getSpacingStyle(
          item.spacingbottom.replace("INNER", "")
        );
      }
    }
    return style;
  }
  /**
   * 获取边距样式
   *
   * @author zhanghengfeng
   * @date 2024-01-29 14:01:46
   * @param {string} tag
   * @return {*}
   */
  getSpacingStyle(tag) {
    let spacing = "0px";
    switch (tag) {
      case "NONE":
        spacing = "0px";
        break;
      case "SMALL":
        spacing = "8px";
        break;
      case "MEDIUM":
        spacing = "16px";
        break;
      case "LARGE":
        spacing = "24px";
        break;
      default:
        spacing = "0px";
        break;
    }
    return spacing;
  }
  /**
   * 获取水平对齐样式
   *
   * @author zhanghengfeng
   * @date 2024-01-29 14:01:05
   * @param {IDataEntity} item
   * @param {IDataEntity} parent
   * @param {boolean} [flex=false]
   * @return {*}
   */
  getHorizontalAlign(item, parent, flex = false) {
    const style = {};
    const horizontal = item.halignself || (parent == null ? void 0 : parent.height);
    switch (horizontal) {
      case "LEFT":
        if (flex) {
          style["align-self"] = "flex-start";
        } else {
          style.float = "left";
        }
        break;
      case "RIGHT":
        if (flex) {
          style["align-self"] = "flex-end";
        } else {
          style.float = "right";
        }
        break;
      case "CENTER":
        if (flex) {
          style["align-self"] = "center";
        } else {
          style.margin = "auto";
          style.float = "none";
          style.display = "table";
        }
        break;
      default:
        break;
    }
    return style;
  }
  /**
   * 获取垂直对齐样式
   *
   * @author zhanghengfeng
   * @date 2024-01-29 14:01:30
   * @param {IDataEntity} data
   * @param {IDataEntity} pData
   * @param {boolean} [flex=false]
   * @return {*}
   */
  getVerticalAlign(item, parent, flex = false) {
    const style = {};
    const vertical = item.valignself || (parent == null ? void 0 : parent.valign);
    switch (vertical) {
      case "TOP":
        if (flex) {
          style["align-self"] = "flex-start";
        }
        break;
      case "BOTTOM":
        if (flex) {
          style["align-self"] = "flex-end";
        }
        break;
      case "MIDDLE":
        if (flex) {
          style["align-self"] = "center";
        }
        break;
      default:
        break;
    }
    return style;
  }
}
const layoutUtil = new LayoutUtil();

export { LayoutUtil, layoutUtil };
