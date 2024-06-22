import { RuntimeError } from '@ibiz-template/core';
import { debounce } from 'lodash-es';

"use strict";
function findNodeData(key, c) {
  const find = c.state.items.find((item) => item._id === key);
  if (find) {
    return find;
  }
  return c.state.items.find((item) => item._uuid === key);
}
function useElTreeUtil(treeRef, c) {
  const getTreeInstance = () => {
    const elTree = treeRef.value;
    if (!elTree) {
      throw new RuntimeError("\u627E\u4E0D\u5230el-tree\u5B9E\u4F8B\u5BF9\u8C61");
    }
    return elTree;
  };
  const _updateUI = () => {
    var _a;
    const elTree = treeRef.value;
    if (!elTree) {
      setTimeout(() => {
        _updateUI();
      }, 200);
      return;
    }
    Object.values(elTree.store.nodesMap).forEach((node) => {
      const shouldExpanded = c.state.expandedKeys.includes(node.data._id);
      if (shouldExpanded !== node.expanded) {
        if (shouldExpanded) {
          node.expand();
        } else {
          node.collapse();
        }
      }
    });
    if (c.state.singleSelect) {
      treeRef.value.setCurrentKey(((_a = c.state.selectedData[0]) == null ? void 0 : _a._id) || void 0);
    } else {
      elTree.setCheckedKeys(c.state.selectedData.map((item) => item._id));
    }
  };
  const updateUI = debounce(_updateUI, 500);
  const triggerNodeExpand = (id) => {
    const elTree = getTreeInstance();
    const target = elTree.store.nodesMap[id];
    if (target) {
      if (target.expanded) {
        target.collapse();
        return false;
      }
      target.expand();
      return true;
    }
  };
  return { getTreeInstance, updateUI, triggerNodeExpand };
}
function formatNodeDropType(dropType) {
  switch (dropType) {
    case "inner":
      return "inner";
    case "before":
      return "prev";
    case "after":
      return "next";
    default:
      throw new RuntimeError("\u6682\u4E0D\u652F\u6301dropType:".concat(dropType));
  }
}

export { findNodeData, formatNodeDropType, useElTreeUtil };
