export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'drill_detail_grid_view',
  deviewId: '4dd3e1381045292191d89f8e28752147',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TICKET',
  },
  caption: '工单反查',
  codeName: 'ticket_drill_detail_grid_view',
  height: 90,
  appDataEntityId: 'plmweb.ticket',
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
          refAppViewId: 'plmweb.ticket_edit_view',
        },
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.ticket_edit_view',
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
          refAppViewId: 'plmweb.ticket_main_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.ticket_main_view',
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
      realTitle: '工单',
      refAppViewId: 'plmweb.ticket_main_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realTitle: '工单编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.TICKET.EDITVIEW',
      },
      refAppViewId: 'plmweb.ticket_edit_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
  ],
  controls: [
    {
      xdataControlName: 'grid',
      codeName: 'drill_detail_grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '工单反查表格视图_工具栏',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '663bd155e7545f9bbc444a5f990666ce',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'drill_detail_grid_view_toolbar',
    },
    {
      aggMode: 'NONE',
      columnEnableFilter: 2,
      columnEnableLink: 2,
      groupMode: 'NONE',
      groupStyle: 'DEFAULT',
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
          dataItemName: 'state',
          excelCaption: '状态',
          appCodeListId: 'plmweb.prodmgmt__ticket_state',
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
          appCodeListId: 'plmweb.prodmgmt__ticket_priority',
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
          dataItemName: 'customer_name',
          excelCaption: '客户',
          appDEFieldId: 'customer_name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '客户',
          codeName: 'customer_name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'customer_name',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'submitter_name',
          excelCaption: '提交人',
          appDEFieldId: 'submitter_name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '提交人',
          codeName: 'submitter_name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'PX',
          enableSort: true,
          id: 'submitter_name',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'estimated_at',
          excelCaption: '预计时间',
          appDEFieldId: 'estimated_at',
          valueFormat: 'YYYY年MM月DD日',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '预计时间',
          codeName: 'estimated_at',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'estimated_at',
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
          appDEFieldId: 'customer_name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'customer_name',
        },
        {
          appDEFieldId: 'submitter_name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'submitter_name',
        },
        {
          format: 'YYYY年MM月DD日',
          appDEFieldId: 'estimated_at',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'estimated_at',
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
          appDEFieldId: 'product_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'product_id',
        },
        {
          appDEFieldId: 'customer_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'customer_id',
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
        appDataEntityId: 'plmweb.ticket',
        id: 'fetch',
      },
      dedataImportId: 'import_ticket',
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.ticket',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'drill_detail_grid_view_grid',
      controlType: 'GRID',
      logicName: '工单反查表格视图_表格',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {
        id: 'grid',
      },
      modelId: 'c684af476f7efdf9e5f6a7c452c56789',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.ticket.drill_detail_grid_view_grid',
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
      codeName: 'usr07178753_search_form',
      controlType: 'SEARCHFORM',
      logicName: '工单反查表格视图_搜索表单',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {
        id: 'searchform',
      },
      modelId: '58c393a81770f636bfd996731a3b7101',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.ticket.usr07178753_search_form',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.TICKET',
      },
      caption: '工单反查',
      codeName: 'drill_detail_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.ticket',
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
    appDataEntityId: 'plmweb.ticket',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '工单反查表格',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  width: 90,
  enableDP: true,
  showCaptionBar: true,
  modelId: '6e3a37e025c113a0d56569f7a425edd7',
  modelType: 'PSAPPDEVIEW',
  name: 'ticketdrill_detail_grid_view',
  id: 'plmweb.ticket_drill_detail_grid_view',
};
