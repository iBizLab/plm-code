export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'drill_detail_grid_view',
  deviewId: '5029B921-A3F8-4A32-8C0A-29BCFF529060',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.RUN',
  },
  caption: '执行用例反查',
  codeName: 'run_drill_detail_grid_view',
  height: 90,
  appDataEntityId: 'plmweb.run',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'GridView',
      id: 'engine',
    },
  ],
  appViewLogics: [
    {
      logicTrigger: 'CUSTOM',
      logicType: 'APPUILOGIC',
      builtinAppUILogic: {
        actionAfterWizard: 'DEFAULT',
        batchAddAppViews: [
          {
            openMode: 'POPUPMODAL',
            refMode: 'TEST_CASE',
            refAppViewId: 'plmweb.test_case_mpick_up_view2_review',
          },
        ],
        newDataAppView: {
          openMode: 'POPUPMODAL',
          refAppViewId: 'plmweb.run_main_view',
        },
        enableBatchAdd: true,
        appDataEntityId: 'plmweb.run',
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.run_main_view',
          },
          {
            openMode: 'POPUPMODAL',
            refMode: 'TEST_CASE',
            refAppViewId: 'plmweb.test_case_mpick_up_view2_review',
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
          openMode: 'POPUPMODAL',
          refAppViewId: 'plmweb.run_main_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.run_main_view',
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
  appViewRefs: [
    {
      realOpenMode: 'POPUPMODAL',
      realTitle: '执行用例主视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.RUN.EDITVIEW',
      },
      refAppViewId: 'plmweb.run_main_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      openMode: 'POPUPMODAL',
      realOpenMode: 'POPUPMODAL',
      realTitle: '执行用例主视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.RUN.EDITVIEW',
      },
      refAppViewId: 'plmweb.run_main_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realOpenMode: 'POPUPMODAL',
      realTitle: '用例实体数据多项选择',
      refAppViewId: 'plmweb.test_case_mpick_up_view2_review',
      name: 'MPICKUPVIEW:TEST_CASE',
      id: 'mpickupview:test_case',
    },
    {
      name: 'MPICKUPVIEW:TEST_PLAN',
      id: 'mpickupview:test_plan',
    },
  ],
  controls: [
    {
      xdataControlName: 'grid',
      codeName: 'drill_detail_grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '执行用例反查表格视图_工具栏',
      appDataEntityId: 'plmweb.run',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '06069FE6-4A89-4F97-B6F5-AF3BD0A89346',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'drill_detail_grid_view_toolbar',
    },
    {
      aggMode: 'NONE',
      columnEnableFilter: 2,
      columnEnableLink: 2,
      groupMode: 'NONE',
      degridColumns: [
        {
          clconvertMode: 'NONE',
          dataItemName: 'title',
          excelCaption: '标题',
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '标题',
          codeName: 'title',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'title',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'status',
          excelCaption: '最近一次执行结果',
          appCodeListId: 'plmweb.testmgmt__run_status',
          appDEFieldId: 'status',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '最近一次执行结果',
          codeName: 'status',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'status',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'executor_name',
          excelCaption: '执行人',
          appDEFieldId: 'executor_name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '执行人',
          codeName: 'executor_name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'PX',
          enableSort: true,
          id: 'executor_name',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'state',
          excelCaption: '评审状态',
          appCodeListId: 'plmweb.testmgmt__case_state',
          appDEFieldId: 'state',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '评审状态',
          codeName: 'state',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'state',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'priority',
          excelCaption: '优先级',
          appCodeListId: 'plmweb.projmgmt__work_item_priority',
          appDEFieldId: 'priority',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '优先级',
          codeName: 'priority',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'PX',
          enableSort: true,
          id: 'priority',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'executed_at',
          excelCaption: '执行时间',
          appDEFieldId: 'executed_at',
          valueFormat: 'YYYY年MM月DD日',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '执行时间',
          codeName: 'executed_at',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'executed_at',
        },
      ],
      degridDataItems: [
        {
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'title',
        },
        {
          appDEFieldId: 'status',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'status',
        },
        {
          appDEFieldId: 'executor_name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'executor_name',
        },
        {
          appDEFieldId: 'state',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'state',
        },
        {
          appDEFieldId: 'priority',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'priority',
        },
        {
          format: 'YYYY年MM月DD日',
          appDEFieldId: 'executed_at',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'executed_at',
        },
        {
          appDEFieldId: 'id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfkey',
        },
        {
          appDEFieldId: 'id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfdataaccaction',
        },
        {
          appDEFieldId: 'plan_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'plan_id',
        },
        {
          appDEFieldId: 'case_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'case_id',
        },
        {
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfmajortext',
        },
      ],
      degridEditItems: [
        {
          caption: '标识',
          codeName: 'srfkey',
          enableCond: 3,
          appDEFieldId: 'id',
          editor: {
            editorType: 'HIDDEN',
            valueType: 'SIMPLE',
            editable: true,
            id: 'srfkey',
          },
          allowEmpty: true,
          id: 'srfkey',
        },
      ],
      pagingMode: 1,
      pagingSize: 20,
      sortMode: 'REMOTE',
      enableCustomized: true,
      enablePagingBar: true,
      singleSelect: true,
      fetchControlAction: {
        appDEMethodId: 'fetch_default',
        appDataEntityId: 'plmweb.run',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.run',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'drill_detail_grid_view_grid',
      controlType: 'GRID',
      logicName: '执行用例反查表格视图_表格',
      appDataEntityId: 'plmweb.run',
      controlParam: {
        id: 'grid',
      },
      modelId: 'B57D47C8-D483-4341-B405-24FD91FE4062',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.run.drill_detail_grid_view_grid',
    },
    {
      searchButtonStyle: 'DEFAULT',
      deformPages: [
        {
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          caption: '常规条件',
          codeName: 'formpage1',
          detailStyle: 'DEFAULT',
          detailType: 'FORMPAGE',
          id: 'formpage1',
        },
      ],
      layout: {
        columnCount: 24,
        layout: 'TABLE_24COL',
      },
      tabHeaderPos: 'TOP',
      noTabHeader: true,
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'usr07178382_search_form',
      controlType: 'SEARCHFORM',
      logicName: '执行用例反查表格视图_搜索表单',
      appDataEntityId: 'plmweb.run',
      controlParam: {
        id: 'searchform',
      },
      modelId: '08B0A2FA-BF9C-486E-B6B5-4CC9AE8CD52E',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.run.usr07178382_search_form',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.run',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.RUN',
      },
      caption: '执行用例反查',
      codeName: 'drill_detail_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.run',
      controlParam: {},
      name: 'captionbar',
      id: 'drill_detail_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.run',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '执行用例反查表格',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  width: 90,
  enableDP: true,
  showCaptionBar: true,
  modelId: 'ad205b7c7fef3cc474df1cb5a57cfc75',
  modelType: 'PSAPPDEVIEW',
  name: 'rundrill_detail_grid_view',
  id: 'plmweb.run_drill_detail_grid_view',
};