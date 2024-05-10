import { App } from 'vue';
import { IBizViewShell } from './view-shell/view-shell';
import { IBizSpecialView } from './special-view/special-view';

export { IBizViewShell };

export default {
  install(v: App): void {
    v.component(IBizViewShell.name, IBizViewShell);
    v.component(IBizSpecialView.name, IBizSpecialView);
  },
};
