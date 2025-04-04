export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'workload_detail_grid_view',
  deviewId: '727c8e1f9abc865275902d1a738e56b1',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORK_ITEM',
  },
  caption: '工时反查',
  codeName: 'work_item_workload_detail_grid_view',
  height: 90,
  appDataEntityId: 'plmweb.work_item',
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
        newDataAppView: {
          refAppViewId: 'plmweb.work_item_edit_view',
        },
        wizardAppView: {
          refAppViewId: 'plmweb.work_item_edit_view',
        },
        enableWizardAdd: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.work_item_edit_view',
          },
          {
            refAppViewId: 'plmweb.work_item_edit_view',
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
          refAppViewId: 'plmweb.work_item_main_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.work_item_main_view',
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
      openMode: 'POPUPMODAL',
      realOpenMode: 'POPUPMODAL',
      realTitle: '工作项',
      refAppViewId: 'plmweb.work_item_main_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realTitle: '工作项编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.WORK_ITEM.EDITVIEW',
      },
      refAppViewId: 'plmweb.work_item_edit_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
  ],
  controls: [
    {
      xdataControlName: 'grid',
      codeName: 'workload_detail_grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '工时反查表格视图_工具栏',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        id: 'toolbar',
      },
      modelId: 'cb67f8a43529c8077905a738625dfb66',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'workload_detail_grid_view_toolbar',
    },
    {
      aggMode: 'NONE',
      columnEnableFilter: 2,
      columnEnableLink: 2,
      groupMode: 'NONE',
      groupStyle: 'DEFAULT',
      orderValueAppDEFieldId: 'sequence',
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
          clconvertMode: 'NONE',
          dataItemName: 'estimated_workload',
          excelCaption: '预估工时',
          appDEFieldId: 'estimated_workload',
          valueFormat: '#0.0',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '预估工时',
          codeName: 'estimated_workload',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          id: 'estimated_workload',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'state',
          excelCaption: '状态',
          appCodeListId: 'plmweb.projmgmt__work_item_state2',
          appDEFieldId: 'state',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '状态',
          codeName: 'state',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'PX',
          enableSort: true,
          id: 'state',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'assignee_name',
          excelCaption: '负责人',
          appDEFieldId: 'assignee_name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '负责人',
          codeName: 'assignee_name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'assignee_name',
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
          dataItemName: 'start_at',
          excelCaption: '开始时间',
          appDEFieldId: 'start_at',
          valueFormat: 'YYYY年MM月DD日',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '开始时间',
          codeName: 'start_at',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'start_at',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'end_at',
          excelCaption: '截止时间',
          appDEFieldId: 'end_at',
          valueFormat: 'YYYY年MM月DD日',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '截止时间',
          codeName: 'end_at',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'end_at',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'create_time',
          excelCaption: '建立时间',
          appDEFieldId: 'create_time',
          valueFormat: 'YYYY年MM月DD日',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.CREATE_TIME',
          },
          caption: '建立时间',
          codeName: 'create_time',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'create_time',
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
          format: '#0.0',
          appDEFieldId: 'estimated_workload',
          valueType: 'SIMPLE',
          dataType: 6,
          id: 'estimated_workload',
        },
        {
          appDEFieldId: 'state',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'state',
        },
        {
          appDEFieldId: 'assignee_name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'assignee_name',
        },
        {
          appDEFieldId: 'priority',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'priority',
        },
        {
          format: 'YYYY年MM月DD日',
          appDEFieldId: 'start_at',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'start_at',
        },
        {
          format: 'YYYY年MM月DD日',
          appDEFieldId: 'end_at',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'end_at',
        },
        {
          format: 'YYYY年MM月DD日',
          appDEFieldId: 'create_time',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'create_time',
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
          appDEFieldId: 'assignee_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'assignee_id',
        },
        {
          appDEFieldId: 'project_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'project_id',
        },
        {
          appDEFieldId: 'work_item_type_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfdatatype',
        },
        {
          appDEFieldId: 'work_item_type_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'work_item_type_id',
        },
        {
          appDEFieldId: 'pid',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'pid',
        },
        {
          appDEFieldId: 'sprint_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'sprint_id',
        },
        {
          appDEFieldId: 'board_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'board_id',
        },
        {
          appDEFieldId: 'entry_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'entry_id',
        },
        {
          appDEFieldId: 'swimlane_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'swimlane_id',
        },
        {
          appDEFieldId: 'top_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'top_id',
        },
        {
          appDEFieldId: 'release_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'release_id',
        },
        {
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfmajortext',
        },
        {
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfmstag',
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
      navViewPos: 'NONE',
      fetchControlAction: {
        appDEMethodId: 'fetch_default',
        appDataEntityId: 'plmweb.work_item',
        id: 'fetch',
      },
      dedataImportId: 'import_work_item_waterfall',
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.work_item',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'load_detail_grid_view_grid',
      controlType: 'GRID',
      logicName: '工时反查表格视图_表格',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        id: 'grid',
      },
      modelId: '99effb8a2edfe1ced9cfd196520831c6',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.work_item.load_detail_grid_view_grid',
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
      codeName: 'usr07223309_search_form',
      controlType: 'SEARCHFORM',
      logicName: '工时反查表格视图_搜索表单',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        id: 'searchform',
      },
      modelId: '8949d22b361943ae526968bc828e7dea',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.work_item.usr07223309_search_form',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.WORK_ITEM',
      },
      caption: '工时反查',
      codeName: 'workload_detail_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {},
      name: 'captionbar',
      id: 'workload_detail_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.work_item',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '工时反查表格',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  width: 90,
  enableDP: true,
  showCaptionBar: true,
  modelId: 'f32cd48b2f81fafc8c97dd9effd5339d',
  modelType: 'PSAPPDEVIEW',
  name: 'work_itemworkload_detail_grid_view',
  id: 'plmweb.work_item_workload_detail_grid_view',
};
