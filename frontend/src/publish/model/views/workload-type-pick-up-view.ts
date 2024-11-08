export default {
  funcViewMode: 'PICKUPVIEW',
  deviewCodeName: 'pick_up_view',
  deviewId: '8c874e334b6714acb619c71a35637f66',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORKLOAD_TYPE',
  },
  caption: '工时类别',
  codeName: 'workload_type_pick_up_view',
  appDataEntityId: 'plmweb.workload_type',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'PickupView',
      id: 'engine',
    },
  ],
  controls: [
    {
      embeddedAppDEViewId: 'plmweb.workload_type_pick_up_grid_view',
      codeName: 'pick_up_view_pickupviewpanel',
      controlType: 'PICKUPVIEWPANEL',
      appDataEntityId: 'plmweb.workload_type',
      controlParam: {
        id: 'pickupviewpanel',
      },
      name: 'pickupviewpanel',
      id: 'pick_up_view_pickupviewpanel',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.WORKLOAD_TYPE',
      },
      caption: '工时类别',
      codeName: 'pick_up_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.workload_type',
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
    appDataEntityId: 'plmweb.workload_type',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '工时类别数据选择视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.WORKLOAD_TYPE.PICKUPVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEPICKUPVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '3034b5bcf0a67763f29d50f4cd26e74c',
  modelType: 'PSAPPDEVIEW',
  name: 'workload_typePickupView',
  id: 'plmweb.workload_type_pick_up_view',
};
