export default {
  funcViewMode: 'PICKUPVIEW',
  deviewCodeName: 'pick_up_view',
  deviewId: '79d3549741fed978d60f5558708358e3',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORK_ITEM',
  },
  caption: '工作项',
  codeName: 'work_item_pick_up_view',
  appDataEntityId: 'plmweb.work_item',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'PickupView',
      id: 'engine',
    },
  ],
  controls: [
    {
      embeddedAppDEViewId: 'plmweb.work_item_pick_up_grid_view',
      codeName: 'pick_up_view_pickupviewpanel',
      controlType: 'PICKUPVIEWPANEL',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        id: 'pickupviewpanel',
      },
      name: 'pickupviewpanel',
      id: 'pick_up_view_pickupviewpanel',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.WORK_ITEM',
      },
      caption: '工作项',
      codeName: 'pick_up_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {},
      name: 'captionbar',
      id: 'pick_up_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEPICKUPVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.work_item',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '工作项数据选择视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.WORK_ITEM.PICKUPVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEPICKUPVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '97d237ca32b37f2edbe788c8334794ed',
  modelType: 'PSAPPDEVIEW',
  name: 'work_itemPickupView',
  id: 'plmweb.work_item_pick_up_view',
};