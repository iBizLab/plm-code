export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'InstalledGridView',
  deviewId: '5DE7BD53-C2A0-445F-881C-E557C0B5F3BE',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.PSCOREPRDFUNC',
  },
  caption: '已安装应用',
  codeName: 'ps_core_prd_func_installed_grid_view',
  appDataEntityId: 'plmweb.pscoreprdfunc',
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
          openMode: 'INDEXVIEWTAB_POPUPMODAL',
          refAppViewId: 'plmweb.ps_core_prd_func_info_view',
        },
        appUILogicRefViews: [
          {
            openMode: 'INDEXVIEWTAB_POPUPMODAL',
            refAppViewId: 'plmweb.ps_core_prd_func_info_view',
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
          refAppViewId: 'plmweb.ps_core_prd_func_redirect_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.ps_core_prd_func_redirect_view',
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
  appViewNavParams: [
    {
      rawValue: true,
      key: 'n_funcstate_eq',
      value: '1',
      id: 'n_funcstate_eq',
    },
    {
      key: 'n_pscoreprdid_eq',
      value: 'srfv2systemid',
      id: 'n_pscoreprdid_eq',
    },
  ],
  appViewRefs: [
    {
      realTitle: '核心产品功能数据重定向视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.PSCOREPRDFUNC.REDIRECTVIEW',
      },
      refAppViewId: 'plmweb.ps_core_prd_func_redirect_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realOpenMode: 'INDEXVIEWTAB_POPUPMODAL',
      realTitle: '核心产品功能编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.PSCOREPRDFUNC.EDITVIEW',
      },
      refAppViewId: 'plmweb.ps_core_prd_func_info_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
  ],
  controls: [
    {
      xdataControlName: 'grid',
      codeName: 'installed_grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '工具栏模板（默认表格界面）',
      appDataEntityId: 'plmweb.pscoreprdfunc',
      controlParam: {
        id: 'toolbar',
      },
      modelId: 'ec6fbb681f5e3e6783c2af57e5eefaaa',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'installed_grid_view_toolbar',
    },
    {
      aggMode: 'NONE',
      columnEnableFilter: 2,
      columnEnableLink: 2,
      groupMode: 'NONE',
      orderValueAppDEFieldId: 'ordervalue',
      degridColumns: [
        {
          clconvertMode: 'NONE',
          dataItemName: 'pscoreprdfuncname',
          excelCaption: '应用',
          appDEFieldId: 'pscoreprdfuncname',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '应用',
          codeName: 'pscoreprdfuncname',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'pscoreprdfuncname',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'memo',
          excelCaption: '描述',
          appDEFieldId: 'memo',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '描述',
          codeName: 'memo',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'memo',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'updatedate',
          excelCaption: '最后操作时间',
          appDEFieldId: 'updatedate',
          valueFormat: 'YYYY-MM-DD HH:mm:ss',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '最后操作时间',
          codeName: 'updatedate',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 160,
          widthUnit: 'PX',
          enableSort: true,
          id: 'updatedate',
        },
        {
          deuiactionGroup: {
            uiactionGroupDetails: [
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '启用',
                detailType: 'DEUIACTION',
                uiactionId: 'install@pscoreprdfunc',
                showCaption: true,
                showIcon: true,
                id: 'u3f3f6fa',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '禁用',
                detailType: 'DEUIACTION',
                uiactionId: 'uninstall@pscoreprdfunc',
                showCaption: true,
                showIcon: true,
                sysCss: {
                  cssName: 'red-span',
                },
                id: 'u6a7b09a',
              },
            ],
            appDataEntityId: 'plmweb.pscoreprdfunc',
            uniqueTag: 'PSCorePrdFunc__Usr0728525275',
            name: '表格操作列界面行为组',
            id: 'usr0728525275',
          },
          aggMode: 'NONE',
          align: 'RIGHT',
          caption: '操作',
          codeName: 'uagridcolumn1',
          columnType: 'UAGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 160,
          widthUnit: 'PX',
          id: 'uagridcolumn1',
        },
      ],
      degridDataItems: [
        {
          appDEFieldId: 'pscoreprdfuncname',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'pscoreprdfuncname',
        },
        {
          appDEFieldId: 'memo',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'memo',
        },
        {
          format: 'YYYY-MM-DD HH:mm:ss',
          appDEFieldId: 'updatedate',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'updatedate',
        },
        {
          appDEFieldId: 'avatarurl',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'avatarurl',
        },
        {
          appDEFieldId: 'functype',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'functype',
        },
        {
          appDEFieldId: 'funcstate',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'funcstate',
        },
        {
          appDEFieldId: 'pscoreprdfuncid',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfkey',
        },
        {
          appDEFieldId: 'pscoreprdfuncid',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfdataaccaction',
        },
        {
          appDEFieldId: 'pscoreprdfuncname',
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
          caption: '核心产品功能标识',
          codeName: 'srfkey',
          enableCond: 3,
          appDEFieldId: 'pscoreprdfuncid',
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
      fetchControlAction: {
        appDEMethodId: 'fetchdefault',
        appDataEntityId: 'plmweb.pscoreprdfunc',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.pscoreprdfunc',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'main',
      controlType: 'GRID',
      logicName: '主表格',
      appDataEntityId: 'plmweb.pscoreprdfunc',
      controlParam: {
        id: 'grid',
      },
      modelId: '29e89aed359f5f091e50b85612dae59d',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.pscoreprdfunc.main',
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
            lanResTag:
              'CONTROL.DEFORM.PSCOREPRDFUNC.DEFAULT.FORMPAGE.FORMPAGE1',
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
      appDataEntityId: 'plmweb.pscoreprdfunc',
      controlParam: {
        id: 'searchform',
      },
      modelId: '61109953a8abc24445134ae8f23a11ae',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.pscoreprdfunc.default',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.pscoreprdfunc',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.PSCOREPRDFUNC',
      },
      caption: '已安装应用',
      codeName: 'installed_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.pscoreprdfunc',
      controlParam: {},
      name: 'captionbar',
      id: 'installed_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.pscoreprdfunc',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '已安装应用',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'e6224504c5e2df764eee52834b106e0f',
  modelType: 'PSAPPDEVIEW',
  name: 'PSCorePrdFuncInstalledGridView',
  id: 'plmweb.ps_core_prd_func_installed_grid_view',
};