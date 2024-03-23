export default {
  mdctrlActiveMode: 1,
  xdataControlName: 'list',
  loadDefault: true,
  deviewCodeName: 'LogListView',
  deviewId: 'AD5CF017-484D-4BE5-A580-FF0BE148A6AD',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.PAGE',
  },
  caption: '日志列表视图',
  codeName: 'article_pageLogListView',
  appDataEntityId: 'plmweb.article_page',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'ListView',
      id: 'engine',
    },
  ],
  appViewLogics: [
    {
      logicTrigger: 'CUSTOM',
      logicType: 'APPUILOGIC',
      builtinAppUILogic: {
        actionAfterWizard: 'DEFAULT',
        newDataAppView: {
          refAppViewId: 'plmweb.article_pageeditview',
        },
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.article_pageeditview',
          },
        ],
        builtinLogic: true,
        logicType: 'PREDEFINED',
        viewLogicType: 'APP_NEWDATA',
        id: '新建数据',
      },
      builtinLogic: true,
      id: 'newdata',
    },
    {
      logicTrigger: 'CUSTOM',
      logicType: 'APPUILOGIC',
      builtinAppUILogic: {
        openDataAppView: {
          refAppViewId: 'plmweb.article_pageeditview',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.article_pageeditview',
          },
        ],
        builtinLogic: true,
        logicType: 'PREDEFINED',
        viewLogicType: 'APP_OPENDATA',
        id: '打开数据',
      },
      builtinLogic: true,
      id: 'opendata',
    },
  ],
  appViewNavContexts: [
    {
      rawValue: true,
      key: 'SPACE',
      value: 'plm_space',
      name: 'SPACE',
      id: 'space',
    },
  ],
  appViewNavParams: [
    {
      rawValue: true,
      key: 'n_type_eq',
      value: '1',
      id: 'n_type_eq',
    },
    {
      rawValue: true,
      key: 'n_space_id_eq',
      value: 'plm_space',
      id: 'n_space_id_eq',
    },
    {
      rawValue: true,
      key: 'n_parent_id_eq',
      value: 'plm_space_change_log',
      id: 'n_parent_id_eq',
    },
  ],
  appViewRefs: [
    {
      realTitle: '页面编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.PAGE.EDITVIEW',
      },
      refAppViewId: 'plmweb.article_pageeditview',
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      realTitle: '页面编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.PAGE.EDITVIEW',
      },
      refAppViewId: 'plmweb.article_pageeditview',
      name: 'EDITDATA',
      id: 'editdata',
    },
  ],
  controls: [
    {
      groupMode: 'NONE',
      itemLayoutPanel: {
        layoutMode: 'TABLE_24COL',
        layout: {
          columnCount: 24,
          layout: 'TABLE_24COL',
        },
        rootPanelItems: [
          {
            layout: {
              dir: 'column',
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            id: 'page_container',
          },
        ],
        codeName: 'Usr0314805172',
        controlType: 'PANEL',
        logicName: 'log_list_列表项面板',
        appDataEntityId: 'plmweb.article_page',
        controlParam: {},
        modelId: '25B66B9E-1428-4ACF-A611-881A55DD266A',
        modelType: 'PSSYSVIEWPANEL',
        name: 'list_itempanel',
        id: 'plmweb.article_page.usr0314805172',
      },
      minorSortDir: 'DESC',
      minorSortAppDEFieldId: 'create_time',
      delistDataItems: [
        {
          appDEFieldId: 'id',
          dataType: 25,
          id: 'srfkey',
        },
        {
          appDEFieldId: 'name',
          dataType: 25,
          id: 'srfmajortext',
        },
        {
          appDEFieldId: 'space_id',
          dataType: 25,
          id: 'space_id',
        },
        {
          appDEFieldId: 'parent_id',
          dataType: 25,
          id: 'parent_id',
        },
        {
          dataType: 25,
          id: 'srfmstag',
        },
      ],
      pagingSize: 1000,
      showHeader: true,
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.article_page',
        id: 'create',
      },
      fetchControlAction: {
        appDEMethodId: 'fetchnormal',
        appDataEntityId: 'plmweb.article_page',
        id: 'fetch',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.article_page',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.article_page',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.article_page',
        id: 'update',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'Log_list',
      controlType: 'LIST',
      logicName: 'log_list',
      appDataEntityId: 'plmweb.article_page',
      controlParam: {
        id: 'list',
      },
      modelId: '1D0CC7EB-C81D-471B-8656-FF1C7082389B',
      modelType: 'PSDELIST',
      name: 'list',
      id: 'plmweb.article_page.log_list',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.article_page',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.PAGE',
      },
      caption: '日志列表视图',
      codeName: 'LogListViewcaptionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.article_page',
      controlParam: {},
      name: 'captionbar',
      id: 'loglistviewcaptionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'Layoutpanel',
    controlStyle: 'APPDELISTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.article_page',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '日志列表视图',
  viewStyle: 'DEFAULT',
  viewType: 'DELISTVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '149437f8c1e9a153bb05e5ddeb595ce5',
  modelType: 'PSAPPDEVIEW',
  name: 'article_pageLogListView',
  id: 'plmweb.article_pageloglistview',
};
