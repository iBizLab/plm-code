export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  funcViewMode: 'MDATAVIEW',
  deviewCodeName: 'GridView',
  deviewId: '64527ac9694430587332ca607a10a955',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.RECENT',
  },
  caption: '最近访问',
  codeName: 'recent_grid_view',
  appDataEntityId: 'plmweb.recent',
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
          refAppViewId: 'plmweb.recent_edit_view',
        },
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.recent_edit_view',
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
          refAppViewId: 'plmweb.recent_edit_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.recent_edit_view',
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
      realTitle: '最近访问编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.RECENT.EDITVIEW',
      },
      refAppViewId: 'plmweb.recent_edit_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realTitle: '最近访问编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.RECENT.EDITVIEW',
      },
      refAppViewId: 'plmweb.recent_edit_view',
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
      minorSortDir: 'DESC',
      minorSortAppDEFieldId: 'update_time',
      degridColumns: [
        {
          clconvertMode: 'FRONT',
          dataItemName: 'owner_subtype',
          excelCaption: '所属对象子类型',
          appCodeListId: 'plmweb.base__recent_visite',
          appDEFieldId: 'owner_subtype',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '所属对象子类型',
          codeName: 'owner_subtype',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          sysPFPluginId: 'icon_gridcolumn',
          width: 40,
          widthUnit: 'PX',
          enableSort: true,
          id: 'owner_subtype',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'show_identifier',
          excelCaption: '编号',
          appDEFieldId: 'show_identifier',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '编号',
          cellSysCss: {
            cssName: 'recent_identified_style',
          },
          codeName: 'identifier',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'PX',
          enableSort: true,
          id: 'identifier',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'name',
          excelCaption: '名称',
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '名称',
          cellSysCss: {
            cssName: 'td_a_link',
          },
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 600,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'name',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'recent_parent_name',
          excelCaption: '所属访问父类名称',
          appDEFieldId: 'recent_parent_name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'RIGHT',
          caption: '所属访问父类名称',
          cellSysCss: {
            cssName: 'td_right',
          },
          codeName: 'recent_parent_name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 230,
          widthUnit: 'PX',
          enableSort: true,
          id: 'recent_parent_name',
        },
      ],
      degridDataItems: [
        {
          appDEFieldId: 'owner_subtype',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'owner_subtype',
        },
        {
          appDEFieldId: 'show_identifier',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'show_identifier',
        },
        {
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'name',
        },
        {
          appDEFieldId: 'recent_parent_name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'recent_parent_name',
        },
        {
          appDEFieldId: 'owner_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'owner_id',
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
      forceFit: true,
      hideHeader: true,
      fetchControlAction: {
        appDEMethodId: 'fetch_default',
        appDataEntityId: 'plmweb.recent',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.recent',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'main',
      controlType: 'GRID',
      logicName: '主表格',
      appDataEntityId: 'plmweb.recent',
      controlParam: {
        id: 'grid',
      },
      modelId: '9fd8e9a7cee034fb7f66feae3e0a5433',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.recent.main',
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
              dataType: 25,
              enableCond: 3,
              labelPos: 'NONE',
              noPrivDisplayMode: 1,
              appDEFieldId: 'show_identifier',
              editor: {
                editorType: 'TEXTBOX',
                placeHolder: '编号',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_show_identifier_like',
              },
              allowEmpty: true,
              caption: '编号',
              codeName: 'n_show_identifier_like',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 4,
                colMD: 4,
                layout: 'TABLE_24COL',
              },
              id: 'n_show_identifier_like',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'NONE',
              noPrivDisplayMode: 1,
              appDEFieldId: 'name',
              editor: {
                editorType: 'TEXTBOX',
                placeHolder: '标题',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_name_like',
              },
              allowEmpty: true,
              emptyCaption: true,
              capLanguageRes: {
                lanResTag: 'CONTROL.DEFSFITEM.RECENT.N_NAME_LIKE',
              },
              codeName: 'n_name_like',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 4,
                colMD: 4,
                layout: 'TABLE_24COL',
              },
              id: 'n_name_like',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'NONE',
              noPrivDisplayMode: 1,
              appDEFieldId: 'owner_subtype',
              editor: {
                singleSelect: true,
                appCodeListId: 'plmweb.base__recent_index',
                editorType: 'DROPDOWNLIST',
                placeHolder: '选择类型',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_owner_subtype_eq',
              },
              allowEmpty: true,
              emptyCaption: true,
              needCodeListConfig: true,
              codeName: 'n_owner_subtype_eq',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 4,
                colMD: 4,
                layout: 'TABLE_24COL',
              },
              id: 'n_owner_subtype_eq',
            },
          ],
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.RECENT.DEFAULT.FORMPAGE.FORMPAGE1',
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
      appDataEntityId: 'plmweb.recent',
      controlParam: {
        id: 'searchform',
      },
      modelId: 'e0daefea3163d35c58b1f48a00f0fc03',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.recent.default',
    },
    {
      xdataControlName: 'grid',
      codeName: 'grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '工具栏模板（默认表格界面）',
      appDataEntityId: 'plmweb.recent',
      controlParam: {
        id: 'toolbar',
      },
      modelId: 'ec6fbb681f5e3e6783c2af57e5eefaaa',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'grid_view_toolbar',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.recent',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.RECENT',
      },
      caption: '最近访问',
      codeName: 'grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.recent',
      controlParam: {},
      name: 'captionbar',
      id: 'grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.recent',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '最近访问表格视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.RECENT.GRIDVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '65c011076060068f706061ee5f90d166',
  modelType: 'PSAPPDEVIEW',
  name: 'recentGridView',
  id: 'plmweb.recent_grid_view',
};