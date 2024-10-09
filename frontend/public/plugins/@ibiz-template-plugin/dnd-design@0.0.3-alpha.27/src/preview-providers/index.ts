/* eslint-disable @typescript-eslint/no-unused-vars */
/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
/* eslint-disable @typescript-eslint/explicit-function-return-type */
import { App } from 'vue';
import { DndPreViewFactory } from './dnd-preview-factory';
import { DndDesignPreViewProvider } from './design-preview-provider';
import { DndRuntimePreViewProvider } from './runtime-preview-provider';

export default {
  install(app: App) {
    DndPreViewFactory.getInstance().registerProvider(
      'DESIGN',
      new DndDesignPreViewProvider(),
    );
    DndPreViewFactory.getInstance().registerProvider(
      'RUNTIME',
      new DndRuntimePreViewProvider(),
    );
  },
};
