export default {
  tabLayout: 'TOP',
  loadDefault: true,
  showDataInfoBar: true,
  deviewCodeName: 'tab_exp_view',
  deviewId: '2906fce6200ee61fc6d6268fec889d83',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORKLOAD',
  },
  caption: '工时',
  codeName: 'workload_tab_exp_view',
  appDataEntityId: 'plmweb.workload',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'TabExpView',
      id: 'engine',
    },
  ],
  controls: [
    {
      tabExpPageIds: ['calendar', 'log'],
      tabLayout: 'TOP',
      uniqueTag: 'workload_tab_exp_view__tabexppanel',
      appViewRefs: [
        {
          realTitle: '工时日历分页搜索视图',
          refAppViewId: 'plmweb.workload_tab_search_view',
          name: 'EXPITEM:calendar',
          id: 'expitem:calendar',
        },
        {
          realTitle: '工时日志表格视图',
          refAppViewId: 'plmweb.workload_log_grid_view',
          name: 'EXPITEM:log',
          id: 'expitem:log',
        },
      ],
      controls: [
        {
          caption: '工时日历',
          embeddedAppDEViewId: 'plmweb.workload_tab_search_view',
          codeName: 'tab_exp_view_calendar',
          controlType: 'TABVIEWPANEL',
          appDataEntityId: 'plmweb.workload',
          controlParam: {
            id: 'calendar',
          },
          modelId: '1a93673445538379ba10fd3b7a80c26a_calendar',
          modelType: 'PSVIEWPANEL',
          name: 'calendar',
          id: 'tab_exp_view_calendar',
        },
        {
          caption: '工时日志',
          embeddedAppDEViewId: 'plmweb.workload_log_grid_view',
          codeName: 'tab_exp_view_log',
          controlType: 'TABVIEWPANEL',
          appDataEntityId: 'plmweb.workload',
          controlParam: {
            id: 'log',
          },
          modelId: '1a93673445538379ba10fd3b7a80c26a_log',
          modelType: 'PSVIEWPANEL',
          name: 'log',
          id: 'tab_exp_view_log',
        },
      ],
      codeName: 'tab_exp_view_tabexppanel',
      controlType: 'TABEXPPANEL',
      appDataEntityId: 'plmweb.workload',
      controlParam: {},
      modelId: '1a93673445538379ba10fd3b7a80c26a_tabexppanel',
      modelType: 'PSTABEXPPANEL',
      name: 'tabexppanel',
      id: 'tab_exp_view_tabexppanel',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.WORKLOAD',
      },
      caption: '工时',
      codeName: 'tab_exp_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.workload',
      controlParam: {},
      name: 'captionbar',
      id: 'tab_exp_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDETABEXPVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.workload',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '工时实体分页导航视图',
  viewStyle: 'DEFAULT',
  viewType: 'DETABEXPVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '1a93673445538379ba10fd3b7a80c26a',
  modelType: 'PSAPPDEVIEW',
  name: 'workloadtab_exp_view',
  id: 'plmweb.workload_tab_exp_view',
};