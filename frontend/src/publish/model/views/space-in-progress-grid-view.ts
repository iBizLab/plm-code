export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'in_progress_grid_view',
  deviewId: '2667d38c5188f79ae94921942e02f7ee',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPACE',
  },
  caption: '空间管理',
  codeName: 'space_in_progress_grid_view',
  appDataEntityId: 'plmweb.space',
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
          refAppViewId: 'plmweb.space_edit_view',
        },
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.space_edit_view',
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
          refAppViewId: 'plmweb.space_info_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.space_info_view',
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
      realTitle: '空间信息',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.SPACE.INFO_VIEW',
      },
      refAppViewId: 'plmweb.space_info_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realTitle: '空间编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.SPACE.EDITVIEW',
      },
      refAppViewId: 'plmweb.space_edit_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
  ],
  controls: [
    {
      xdataControlName: 'grid',
      codeName: 'in_progress_grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '空间管理表格视图_进行中_工具栏',
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '0d6fce344bad4491df7ba13379f3bde8',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'in_progress_grid_view_toolbar',
    },
    {
      aggMode: 'NONE',
      columnEnableFilter: 2,
      columnEnableLink: 2,
      groupMode: 'NONE',
      degridColumns: [
        {
          clconvertMode: 'NONE',
          dataItemName: 'name',
          excelCaption: '空间名称',
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '空间名称',
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'name',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'create_man',
          excelCaption: '创建人',
          appCodeListId: 'plmweb.sysoperator',
          appDEFieldId: 'create_man',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.CREATE_MAN',
          },
          caption: '创建人',
          codeName: 'create_man',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'create_man',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'create_time',
          excelCaption: '创建时间',
          appDEFieldId: 'create_time',
          valueFormat: 'YYYY-MM-DD HH:mm:ss',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.CREATE_TIME',
          },
          caption: '创建时间',
          codeName: 'create_time',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'create_time',
        },
        {
          deuiactionGroup: {
            uiactionGroupDetails: [
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'in_progress_into_archived@space',
                tooltip: '归档',
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-archive',
                  glyph: 'xf187@FontAwesome',
                },
                id: 'u25f5697',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'in_progress_into_deleted@space',
                tooltip: '删除',
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-trash',
                  glyph: 'xf1f8@FontAwesome',
                },
                id: 'u183e681',
              },
            ],
            appDataEntityId: 'plmweb.space',
            uniqueTag: 'space__Usr0227887014',
            name: '进行中',
            id: 'usr0227887014',
          },
          aggMode: 'NONE',
          align: 'CENTER',
          caption: '操作',
          codeName: 'uagridcolumn1',
          columnType: 'UAGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'PX',
          id: 'uagridcolumn1',
        },
      ],
      degridDataItems: [
        {
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'name',
        },
        {
          appDEFieldId: 'create_man',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'create_man',
        },
        {
          format: 'YYYY-MM-DD HH:mm:ss',
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
          appDEFieldId: 'category_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'category_id',
        },
        {
          appDEFieldId: 'name',
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
      enableCustomized: true,
      enablePagingBar: true,
      singleSelect: true,
      fetchControlAction: {
        appDEMethodId: 'fetch_normal',
        appDataEntityId: 'plmweb.space',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.space',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'in_progress',
      controlType: 'GRID',
      logicName: '进行中',
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'grid',
      },
      modelId: 'a709d3ead7479b55508729d53d9b0dc7',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.space.in_progress',
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
      codeName: 'usr02274660_search_form',
      controlType: 'SEARCHFORM',
      logicName: '空间管理表格视图_进行中_搜索表单',
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'searchform',
      },
      modelId: 'bde447df887bf56208f6768d1b833efa',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.space.usr02274660_search_form',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.SPACE',
      },
      caption: '空间管理',
      codeName: 'in_progress_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.space',
      controlParam: {},
      name: 'captionbar',
      id: 'in_progress_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.space',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '空间管理',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '4fdbd706c1fde5df05b891744c97b44b',
  modelType: 'PSAPPDEVIEW',
  name: 'spacein_progress_grid_view',
  id: 'plmweb.space_in_progress_grid_view',
};