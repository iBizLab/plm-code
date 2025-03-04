import { App } from 'vue';
import { registerUIActionProvider } from '@ibiz-template/runtime';
import { RefreshFieldProvider } from './refresh-field-provider';

export default {
  install(_app: App) {
    registerUIActionProvider(
      `FRONT_RefreshField`,
      () => new RefreshFieldProvider(),
    );
  },
};
