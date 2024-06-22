import { Namespace } from '@ibiz-template/core';
import { IDataEntity } from '@ibiz-template/runtime';

export class LayoutUtil {
  /**
   * 栅格布局模式
   *
   * @author zhanghengfeng
   * @date 2024-01-29 17:01:09
   */
  gridLayoutMode = ['lg', 'md', 'sm', 'xs'];

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
  getGridLayoutModeValue(
    item: IDataEntity,
    prefix: string = '',
    suffix: string = '',
  ): string {
    for (let i = 0; i < this.gridLayoutMode.length; i++) {
      const mode = this.gridLayoutMode[i];
      const key = `${prefix}${mode}${suffix}`;
      if (item[key] != null) {
        return item[key];
      }
    }
    return '';
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
  getGridCol(item: IDataEntity, parent: IDataEntity): number | null {
    let value = this.getGridLayoutModeValue(item, 'col_');
    if (parent && !value) {
      value = this.getGridLayoutModeValue(item, 'child_col_');
    }
    if (!value || value <= '0' || value > '24') {
      value = '24';
    }
    if (value) {
      const num = parseInt(value, 10);
      const layoutMode: string = parent?.layoutmode;
      if (layoutMode === 'TABLE_12COL') {
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
  getGridOffset(item: IDataEntity, parent: IDataEntity): number | null {
    let value = this.getGridLayoutModeValue(item, 'col_', '_os');
    if (parent && !value) {
      value = this.getGridLayoutModeValue(item, 'child_col_', '_os');
    }
    if (value) {
      const num: number = parseInt(value, 10);
      const layoutMode: string = parent?.layoutmode;
      if (layoutMode === 'TABLE_12COL') {
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
  calcColClass(item: IDataEntity, parent: IDataEntity): IData {
    const colClass: IData = {};
    if (parent && parent.layoutmode === 'FLEX') {
      return colClass;
    }
    // 计算栅格布局占位
    const col = this.getGridCol(item, parent);
    if (col) {
      colClass[`el-col-${col}`] = true;
    }
    // 计算栅格布局偏移
    const offset = this.getGridOffset(item, parent);
    if (offset) {
      colClass[`el-col-offset-${offset}`] = true;
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
  getFlexLayoutStyle(item: IDataEntity): IData {
    const isFlex = item.layoutmode === 'FLEX';
    if (isFlex) {
      return {
        display: 'flex',
        'flex-direction': item.flexdir,
        'justify-content': item.flexalign,
        'align-items': item.flexvalign,
        'flex-grow': item.flexgrow,
        'flex-shrink': item.flexshrink,
        'flex-basis': `${item.flexbasis}px`,
        padding: `${item.padding}px`,
      };
    }
    return {
      padding: `${item.padding}px`,
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
  getDraggableContainerClass(item: IDataEntity, ns: Namespace): IData {
    const isFlex = item.layoutmode === 'FLEX';
    return {
      [ns.b('grid-layout')]: !isFlex,
      [ns.b('flex-layout')]: isFlex,
      [ns.b('flex-row')]:
        isFlex && item.flexdir && item.flexdir.indexOf('column') === -1,
      [ns.b('flex-column')]:
        isFlex && item.flexdir && item.flexdir.indexOf('column') !== -1,
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
  calcStyle(item: IDataEntity, parent: IDataEntity): IData {
    const style: IData = {};
    if (!item) {
      return style;
    }

    if (item) {
      // 计算高度
      if (item.heightmode === 'FULL') {
        style.height = 'auto';
      } else if (item.height) {
        style.height =
          item.height + (item.heightmode === 'PERCENTAGE' ? '%' : 'px');
      } else if (parent && parent.itemtype === 'PSSysViewPanel') {
        if (parent.itemtype === 'CONTAINER' || parent.itemtype === 'CTRLPOS') {
          style['flex-grow'] = 1;
        }
      } else {
        style.height = 'auto';
      }

      // 计算宽度
      if (item.widthmode === 'FULL') {
        style.width = 'auto';
      } else if (item.width) {
        style.width =
          item.width + (item.widthmode === 'PERCENTAGE' ? '%' : 'px');
      }

      const isFlex = parent?.layoutmode === 'FLEX';
      // 计算对齐模式
      if (isFlex) {
        if (item.flexgrow != null) {
          style['flex-grow'] = item.flexgrow;
        }
        if (item.flexshrink != null) {
          style['flex-shrink'] = item.flexshrink;
        }
        if (item.flexbasis != null) {
          style['flex-basis'] = `${item.flexbasis}px`;
        }
        if (
          parent &&
          (!parent.flexdir || parent.flexdir.indexOf('row') !== -1)
        ) {
          Object.assign(style, this.getVerticalAlign(item, parent, isFlex));
        } else {
          Object.assign(style, this.getHorizontalAlign(item, parent, isFlex));
        }
      } else {
        Object.assign(style, this.getHorizontalAlign(item, parent, isFlex));
      }

      // 换行模式
      Object.assign(style, this.getSwapMode(item));

      // 计算边距
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
  getSwapMode(item: IDataEntity): IData {
    const style: IData = {};
    if (item.swapmode) {
      if (item.layoutmode === 'FLEX') {
        if (item.swapmode === 'NOWRAP') {
          style['flex-wrap'] = 'nowrap';
        } else {
          style['flex-wrap'] = 'wrap';
        }
      } else if (item.swapmode === 'NOWRAP') {
        style['white-space'] = 'nowrap';
      } else {
        style['white-space'] = 'pre-wrap';
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
  getBorderStyle(item: IDataEntity): IData {
    const style: IData = {};
    if (item.spacingleft) {
      if (item.spacingleft.indexOf('OUTER') !== -1) {
        style['margin-left'] = this.getSpacingStyle(
          item.spacingleft.replace('OUTER', ''),
        );
      } else {
        style['padding-left'] = this.getSpacingStyle(
          item.spacingleft.replace('INNER', ''),
        );
      }
    }
    if (item.spacingright) {
      if (item.spacingright.indexOf('OUTER') !== -1) {
        style['margin-right'] = this.getSpacingStyle(
          item.spacingright.replace('OUTER', ''),
        );
      } else {
        style['padding-right'] = this.getSpacingStyle(
          item.spacingright.replace('INNER', ''),
        );
      }
    }
    if (item.spacingtop) {
      if (item.spacingtop.indexOf('OUTER') !== -1) {
        style['margin-top'] = this.getSpacingStyle(
          item.spacingtop.replace('OUTER', ''),
        );
      } else {
        style['padding-top'] = this.getSpacingStyle(
          item.spacingtop.replace('INNER', ''),
        );
      }
    }
    if (item.spacingbottom) {
      if (item.spacingbottom.indexOf('OUTER') !== -1) {
        style['margin-bottom'] = this.getSpacingStyle(
          item.spacingbottom.replace('OUTER', ''),
        );
      } else {
        style['padding-bottom'] = this.getSpacingStyle(
          item.spacingbottom.replace('INNER', ''),
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
  getSpacingStyle(tag: string): string {
    let spacing = '0px';
    switch (tag) {
      case 'NONE':
        spacing = '0px';
        break;
      case 'SMALL':
        spacing = '8px';
        break;
      case 'MEDIUM':
        spacing = '16px';
        break;
      case 'LARGE':
        spacing = '24px';
        break;
      default:
        spacing = '0px';
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
  getHorizontalAlign(
    item: IDataEntity,
    parent: IDataEntity,
    flex = false,
  ): IData {
    const style: IData = {};
    const horizontal = item.halignself || parent?.height;
    switch (horizontal) {
      case 'LEFT':
        if (flex) {
          style['align-self'] = 'flex-start';
        } else {
          style.float = 'left';
        }
        break;
      case 'RIGHT':
        if (flex) {
          style['align-self'] = 'flex-end';
        } else {
          style.float = 'right';
        }
        break;
      case 'CENTER':
        if (flex) {
          style['align-self'] = 'center';
        } else {
          style.margin = 'auto';
          style.float = 'none';
          style.display = 'table';
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
  getVerticalAlign(
    item: IDataEntity,
    parent: IDataEntity,
    flex = false,
  ): IData {
    const style: IData = {};
    const vertical = item.valignself || parent?.valign;
    switch (vertical) {
      case 'TOP':
        if (flex) {
          style['align-self'] = 'flex-start';
        }
        break;
      case 'BOTTOM':
        if (flex) {
          style['align-self'] = 'flex-end';
        }
        break;
      case 'MIDDLE':
        if (flex) {
          style['align-self'] = 'center';
        }
        break;
      default:
        break;
    }
    return style;
  }
}

export const layoutUtil = new LayoutUtil();
