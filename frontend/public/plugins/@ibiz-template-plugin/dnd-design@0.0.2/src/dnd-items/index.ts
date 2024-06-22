import { App } from 'vue';
import FormItem from './form-item';
import GroupPanel from './group-panel';
import RawItem from './raw-item';
import TabPage from './tab-page';
import TabPanel from './tab-panel';
import FormPage from './form-page';
import Button from './button';
import Iframe from './iframe';
import DRUIPart from './druipart';
import MDCtrl from './mdctrl';
import FormItemEx from './form-item-ex';

export default {
  install(app: App) {
    app.use(FormItem);
    app.use(GroupPanel);
    app.use(RawItem);
    app.use(TabPage);
    app.use(TabPanel);
    app.use(FormPage);
    app.use(Button);
    app.use(Iframe);
    app.use(DRUIPart);
    app.use(MDCtrl);
    app.use(FormItemEx);
  },
};
