export default {
  gridRowActiveMode: 1,
  expandSearchForm: true,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'advanced_search_grid_view',
  deviewId: '5a5d9f07a982b84868dd97dbd3e0b716',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORK_ITEM',
  },
  caption: '工作项',
  codeName: 'work_item_advanced_search_grid_view',
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
          openMode: 'INDEXVIEWTAB_POPUPMODAL',
          navigateContexts: [
            {
              key: 'PROJECT',
              value: 'project_id',
              name: 'PROJECT',
              id: 'project',
            },
            {
              key: 'WORK_ITEM_TYPE_ID',
              value: 'work_item_type_id',
              name: 'WORK_ITEM_TYPE_ID',
              id: 'work_item_type_id',
            },
          ],
          refAppViewId: 'plmweb.work_item_main_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            openMode: 'INDEXVIEWTAB_POPUPMODAL',
            navigateContexts: [
              {
                key: 'PROJECT',
                value: 'project_id',
                name: 'PROJECT',
                id: 'project',
              },
              {
                key: 'WORK_ITEM_TYPE_ID',
                value: 'work_item_type_id',
                name: 'WORK_ITEM_TYPE_ID',
                id: 'work_item_type_id',
              },
            ],
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
      openMode: 'INDEXVIEWTAB_POPUPMODAL',
      navigateContexts: [
        {
          key: 'PROJECT',
          value: 'project_id',
          name: 'PROJECT',
          id: 'project',
        },
        {
          key: 'WORK_ITEM_TYPE_ID',
          value: 'work_item_type_id',
          name: 'WORK_ITEM_TYPE_ID',
          id: 'work_item_type_id',
        },
      ],
      realOpenMode: 'INDEXVIEWTAB_POPUPMODAL',
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
      aggMode: 'NONE',
      columnEnableFilter: 2,
      columnEnableLink: 2,
      groupMode: 'NONE',
      degridColumns: [
        {
          clconvertMode: 'NONE',
          dataItemName: 'show_identifier',
          excelCaption: '编号',
          appDEFieldId: 'show_identifier',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '编号',
          codeName: 'show_identifier',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'show_identifier',
        },
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
          appCodeListId: 'plmweb.projmgmt__work_item_state2',
          appDEFieldId: 'state',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '状态',
          codeName: 'state',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'state',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'project_name',
          excelCaption: '所属项目',
          linkAppViewId: 'plmweb.project_redirect_view',
          linkValueItem: 'project_id',
          appDEFieldId: 'project_name',
          valueType: 'SIMPLE',
          enableLinkView: true,
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '所属项目',
          codeName: 'project_name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'project_name',
        },
      ],
      degridDataItems: [
        {
          appDEFieldId: 'show_identifier',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'show_identifier',
        },
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
          appDEFieldId: 'project_name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'project_name',
        },
        {
          appDEFieldId: 'id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'id',
        },
        {
          appDEFieldId: 'project_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'project_id',
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
      pagingSize: 20,
      sortMode: 'REMOTE',
      enablePagingBar: true,
      singleSelect: true,
      fetchControlAction: {
        appDEMethodId: 'fetch_advanced_search',
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
      codeName: 'advanced_search_work_item_grid',
      controlType: 'GRID',
      logicName: '高级搜索工作项_表格',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        id: 'grid',
      },
      modelId: '4ab4aabde626d9711655bed38b952a37',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.work_item.advanced_search_work_item_grid',
    },
    {
      searchButtonStyle: 'NONE',
      enableAutoSearch: true,
      deformPages: [
        {
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          deformDetails: [
            {
              layout: {
                columnCount: 24,
                layout: 'TABLE_24COL',
              },
              deformDetails: [
                {
                  rawItem: {
                    caption: '搜索词范围',
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    contentType: 'RAW',
                    id: 'rawitem1',
                  },
                  codeName: 'rawitem1',
                  detailStyle: 'DEFAULT',
                  detailType: 'RAWITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'rawitem1',
                },
                {
                  layout: {
                    columnCount: 12,
                    layout: 'TABLE_12COL',
                  },
                  deformDetails: [
                    {
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'NONE',
                      noPrivDisplayMode: 1,
                      editor: {
                        appCodeListId:
                          'plmweb.projmgmt__work_item_advanced_search_field',
                        editorParams: {
                          VALUETYPE: 'SIMPLES',
                        },
                        editorType: 'CHECKBOXLIST',
                        valueType: 'SIMPLES',
                        editable: true,
                        id: 'queryconds',
                      },
                      allowEmpty: true,
                      needCodeListConfig: true,
                      codeName: 'queryconds',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colMD: 12,
                        layout: 'TABLE_12COL',
                      },
                      id: 'queryconds',
                    },
                  ],
                  caption: '搜索词范围',
                  codeName: 'grouppanel1',
                  detailStyle: 'DEFAULT',
                  detailType: 'GROUPPANEL',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'grouppanel1',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'project_id',
                  editor: {
                    singleSelect: true,
                    appCodeListId: 'plmweb.projmgmt__usrcodelist0122047845',
                    editorType: 'DROPDOWNLIST',
                    placeHolder: '选择项目',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'n_project_id_eq',
                  },
                  allowEmpty: true,
                  needCodeListConfig: true,
                  caption: '项目名称',
                  codeName: 'n_project_id_eq',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'n_project_id_eq',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'work_item_type_id',
                  editor: {
                    singleSelect: true,
                    appCodeListId: 'plmweb.projmgmt__work_item_type',
                    editorType: 'DROPDOWNLIST',
                    placeHolder: '选择工作项类型',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'n_work_item_type_id_eq',
                  },
                  allowEmpty: true,
                  needCodeListConfig: true,
                  caption: '工作项类型',
                  codeName: 'n_work_item_type_id_eq',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'n_work_item_type_id_eq',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'priority',
                  editor: {
                    singleSelect: true,
                    appCodeListId: 'plmweb.projmgmt__work_item_priority',
                    editorType: 'DROPDOWNLIST',
                    placeHolder: '选择优先级',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'n_priority_eq',
                  },
                  allowEmpty: true,
                  needCodeListConfig: true,
                  caption: '优先级',
                  codeName: 'n_priority_eq',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'n_priority_eq',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  editor: {
                    singleSelect: true,
                    enableAC: true,
                    forceSelection: true,
                    showTrigger: true,
                    valueItemName: 'n_assignee_id_eq',
                    editorParams: {
                      URL: '/users/fetch_default',
                      ISSHOWTAB: 'false',
                      USERMAP: '{"id":"id","name":"display_name"}',
                      AC: 'TRUE',
                      USERMETHOD: 'get',
                      TRIGGER: 'TRUE',
                      PICKUPVIEW: 'FALSE',
                    },
                    editorStyle: 'PERSONEL_SELECT_ALL',
                    editorType: 'PICKEREX_TRIGGER',
                    editorItems: [
                      {
                        id: 'n_assignee_id_eq',
                      },
                    ],
                    sysPFPluginId: 'person_select',
                    placeHolder: '选择负责人',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'assignee',
                  },
                  allowEmpty: true,
                  caption: '负责人',
                  codeName: 'assignee',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'assignee',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  editor: {
                    editorParams: {
                      TIMEFMT: 'YYYY-MM-DD',
                    },
                    editorType: 'DATERANGE_NOTIME',
                    editorItems: [
                      {
                        id: 'n_create_time_gtandeq',
                      },
                      {
                        id: 'n_create_time_ltandeq',
                      },
                    ],
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'create_time',
                  },
                  allowEmpty: true,
                  caption: '创建时间',
                  codeName: 'create_time',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'create_time',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'assignee_id',
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'n_assignee_id_eq',
                  },
                  allowEmpty: true,
                  hidden: true,
                  caption: '负责人',
                  codeName: 'n_assignee_id_eq',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'n_assignee_id_eq',
                },
                {
                  dataType: 5,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'create_time',
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'n_create_time_gtandeq',
                  },
                  valueFormat: 'YYYY-MM-DD HH:mm:ss',
                  allowEmpty: true,
                  hidden: true,
                  caption: '创建时间',
                  codeName: 'n_create_time_gtandeq',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'n_create_time_gtandeq',
                },
                {
                  dataType: 5,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'create_time',
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'n_create_time_ltandeq',
                  },
                  valueFormat: 'YYYY-MM-DD HH:mm:ss',
                  allowEmpty: true,
                  hidden: true,
                  caption: '建立时间',
                  codeName: 'n_create_time_ltandeq',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'n_create_time_ltandeq',
                },
              ],
              caption: '选项',
              codeName: 'grouppanel2',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'grouppanel2',
            },
          ],
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
      codeName: 'advanced_search_form',
      controlType: 'SEARCHFORM',
      logicName: '高级搜索_搜索表单',
      appDataEntityId: 'plmweb.work_item',
      controlLogics: [
        {
          eventNames: 'onBeforeLoadDraft',
          logicTag: 'tabsearchform',
          logicType: 'SCRIPT',
          scriptCode:
            'viewParam.queryconds=["n_title_like", "n_identifier_like", "n_description_like"];',
          triggerType: 'CTRLEVENT',
          name: 'changeSearchData',
          id: 'changesearchdata',
        },
      ],
      controlParam: {
        ctrlParams: {
          TELEPORTFLAG: 'true',
        },
        id: 'tabsearchform',
      },
      modelId: '2BBE62BC-D574-419C-AA5A-6E8795580A48',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'tabsearchform',
      id: 'plmweb.work_item.advanced_search_form',
    },
    {
      groupMode: 'SINGLE',
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
      caption: '工作项',
      codeName: 'advanced_search_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {},
      name: 'captionbar',
      id: 'advanced_search_grid_view_captionbar',
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
  title: '工作项高级搜索表格视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'eaa8e12ded1be77ba0a0cba9129949d1',
  modelType: 'PSAPPDEVIEW',
  name: 'work_itemadvanced_search_grid_view',
  id: 'plmweb.work_item_advanced_search_grid_view',
};