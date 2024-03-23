import { App } from 'vue';
import { IBizViewShell } from './view-shell/view-shell';

export { IBizViewShell };

export default {
  install(v: App): void {
    v.component(IBizViewShell.name, IBizViewShell);
  },
};
