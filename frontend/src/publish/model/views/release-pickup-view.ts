export default {
  funcViewMode: 'PICKUPVIEW',
  deviewCodeName: 'PickupView',
  deviewId: 'bfb447004d9ea0719901d8047ffd2ce6',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.RELEASE',
  },
  caption: '项目发布',
  codeName: 'releasePickupView',
  appDataEntityId: 'plmweb.release',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'PickupView',
      id: 'engine',
    },
  ],
  controls: [
    {
      embeddedAppDEViewId: 'plmweb.releasepickupgridview',
      codeName: 'PickupViewpickupviewpanel',
      controlType: 'PICKUPVIEWPANEL',
      appDataEntityId: 'plmweb.release',
      controlParam: {
        id: 'pickupviewpanel',
      },
      name: 'pickupviewpanel',
      id: 'pickupviewpickupviewpanel',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.RELEASE',
      },
      caption: '项目发布',
      codeName: 'PickupViewcaptionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.release',
      controlParam: {},
      name: 'captionbar',
      id: 'pickupviewcaptionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'Layoutpanel',
    controlStyle: 'APPDEPICKUPVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.release',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '项目发布数据选择视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.RELEASE.PICKUPVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEPICKUPVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'c28e56d19d7016322628ec738e01e4a3',
  modelType: 'PSAPPDEVIEW',
  name: 'releasePickupView',
  id: 'plmweb.releasepickupview',
};