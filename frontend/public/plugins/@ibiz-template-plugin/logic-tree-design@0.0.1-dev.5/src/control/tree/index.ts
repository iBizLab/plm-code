import { registerControlProvider } from '@ibiz-template/runtime';
import { withInstall } from '@ibiz-template/vue3-util';
import { App } from 'vue';
import { LogicTreeDesignTree } from './tree';
import { LogicTreeDesignTreeProvider } from './tree.provider';
import { PackageTag } from '../../const';

export const IBizLogicTreeDesignTree = withInstall(
  LogicTreeDesignTree,
  function (v: App) {
    v.component(LogicTreeDesignTree.name, LogicTreeDesignTree);
    registerControlProvider(
      `TREE_RENDER_${PackageTag}_Tree`,
      () => new LogicTreeDesignTreeProvider(),
    );
    // eslint-disable-next-line @typescript-eslint/no-explicit-any
  } as any,
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
) as any;

export default IBizLogicTreeDesignTree;
