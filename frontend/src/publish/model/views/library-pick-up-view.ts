export default {
  funcViewMode: 'PICKUPVIEW',
  deviewCodeName: 'pick_up_view',
  deviewId: 'e1f3ac5960b65ec5e23f5c20fff341ba',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.LIBRARY',
  },
  caption: '测试库',
  codeName: 'library_pick_up_view',
  appDataEntityId: 'plmweb.library',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'PickupView',
      id: 'engine',
    },
  ],
  controls: [
    {
      embeddedAppDEViewId: 'plmweb.library_pick_up_grid_view',
      codeName: 'pick_up_view_pickupviewpanel',
      controlType: 'PICKUPVIEWPANEL',
      appDataEntityId: 'plmweb.library',
      controlParam: {
        id: 'pickupviewpanel',
      },
      name: 'pickupviewpanel',
      id: 'pick_up_view_pickupviewpanel',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.LIBRARY',
      },
      caption: '测试库',
      codeName: 'pick_up_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.library',
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
    appDataEntityId: 'plmweb.library',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '测试库数据选择视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.LIBRARY.PICKUPVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEPICKUPVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'f8528550af8f1440115abc78da1370c6',
  modelType: 'PSAPPDEVIEW',
  name: 'libraryPickupView',
  id: 'plmweb.library_pick_up_view',
};
