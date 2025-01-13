import FormItem from './form-item/index.mjs';
import GroupPanel from './group-panel/index.mjs';
import RawItem from './raw-item/index.mjs';
import TabPage from './tab-page/index.mjs';
import TabPanel from './tab-panel/index.mjs';
import FormPage from './form-page/index.mjs';
import Button from './button/index.mjs';
import Iframe from './iframe/index.mjs';
import DRUIPart from './druipart/index.mjs';
import MDCtrl from './mdctrl/index.mjs';
import FormItemEx from './form-item-ex/index.mjs';
import ButtonList from './button-list/index.mjs';

"use strict";
var DndItems = {
  install(app) {
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
    app.use(ButtonList);
  }
};

export { DndItems as default };
