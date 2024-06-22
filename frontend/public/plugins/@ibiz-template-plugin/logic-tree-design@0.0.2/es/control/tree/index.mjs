import { registerControlProvider } from '@ibiz-template/runtime';
import { withInstall } from '@ibiz-template/vue3-util';
import { LogicTreeDesignTree } from './tree.mjs';
import { LogicTreeDesignTreeProvider } from './tree.provider.mjs';
import { PackageTag } from '../../const/index.mjs';

"use strict";
const IBizLogicTreeDesignTree = withInstall(
  LogicTreeDesignTree,
  function(v) {
    v.component(LogicTreeDesignTree.name, LogicTreeDesignTree);
    registerControlProvider(
      "TREE_RENDER_".concat(PackageTag, "_Tree"),
      () => new LogicTreeDesignTreeProvider()
    );
  }
);

export { IBizLogicTreeDesignTree, IBizLogicTreeDesignTree as default };
