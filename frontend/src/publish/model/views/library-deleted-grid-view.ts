export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'deleted_grid_view',
  deviewId: 'b729e660fa59a6bb3c34024a1d44a803',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.LIBRARY',
  },
  caption: '测试库管理',
  codeName: 'library_deleted_grid_view',
  appDataEntityId: 'plmweb.library',
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
          refAppViewId: 'plmweb.library_index_view',
        },
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.library_index_view',
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
          refAppViewId: 'plmweb.library_redirect_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.library_redirect_view',
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
      realTitle: '测试库数据重定向视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.LIBRARY.REDIRECTVIEW',
      },
      refAppViewId: 'plmweb.library_redirect_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realTitle: '测试库',
      refAppViewId: 'plmweb.library_index_view',
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
          dataItemName: 'name',
          excelCaption: '测试库名称',
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '测试库名称',
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
          dataItemName: 'update_man',
          excelCaption: '删除人',
          appCodeListId: 'plmweb.sysoperator',
          appDEFieldId: 'update_man',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.UPDATE_MAN',
          },
          caption: '删除人',
          codeName: 'update_man',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'update_man',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'update_time',
          excelCaption: '删除时间',
          appDEFieldId: 'update_time',
          valueFormat: 'YYYY-MM-DD HH:mm:ss',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.UPDATE_TIME',
          },
          caption: '删除时间',
          codeName: 'update_time',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'update_time',
        },
        {
          deuiactionGroup: {
            uiactionGroupDetails: [
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'recover@library',
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-retweet',
                  glyph: 'xf079@FontAwesome',
                },
                id: 'u0fccb24',
              },
            ],
            appDataEntityId: 'plmweb.library',
            uniqueTag: 'library__Usr1219570203',
            name: '已删除',
            id: 'usr1219570203',
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
          appDEFieldId: 'update_man',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'update_man',
        },
        {
          format: 'YYYY-MM-DD HH:mm:ss',
          appDEFieldId: 'update_time',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'update_time',
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
        appDEMethodId: 'fetch_deleted',
        appDataEntityId: 'plmweb.library',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.library',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'deleted',
      controlType: 'GRID',
      logicName: '已删除',
      appDataEntityId: 'plmweb.library',
      controlParam: {
        id: 'grid',
      },
      modelId: 'c45ee5346f6d0f4d9a5fcf074ae12d82',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.library.deleted',
    },
    {
      searchButtonStyle: 'DEFAULT',
      deformPages: [
        {
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.LIBRARY.DEFAULT.FORMPAGE.FORMPAGE1',
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
      codeName: 'default',
      controlType: 'SEARCHFORM',
      logicName: '默认搜索表单',
      appDataEntityId: 'plmweb.library',
      controlParam: {
        id: 'searchform',
      },
      modelId: '2da066d2403c1b0418e8c01fb609c9ba',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.library.default',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.library',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.LIBRARY',
      },
      caption: '测试库管理',
      codeName: 'deleted_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.library',
      controlParam: {},
      name: 'captionbar',
      id: 'deleted_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.library',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '测试库管理',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '4f3e28cab8b878e18434eaa5a5b3e5fb',
  modelType: 'PSAPPDEVIEW',
  name: 'librarydeleted_grid_view',
  id: 'plmweb.library_deleted_grid_view',
};