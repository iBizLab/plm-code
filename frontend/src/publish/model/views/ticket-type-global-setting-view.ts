export default {
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'global_setting_view',
  deviewId: 'f69998c2e4b466905276c17ebd9504d1',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TICKET_TYPE',
  },
  caption: '工单类型',
  codeName: 'ticket_type_global_setting_view',
  appDataEntityId: 'plmweb.ticket_type',
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
          openMode: 'POPUPMODAL',
          refAppViewId: 'plmweb.ticket_type_quick_create_view',
        },
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.ticket_type_quick_create_view',
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
          refAppViewId: 'plmweb.ticket_type_editor_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.ticket_type_editor_view',
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
  appViewMsgGroupId: 'usrvmgroup0417664142',
  appViewRefs: [
    {
      realOpenMode: 'POPUPMODAL',
      realTitle: '新建工单类型',
      refAppViewId: 'plmweb.ticket_type_quick_create_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      realOpenMode: 'POPUPMODAL',
      realTitle: '编辑工单类型',
      refAppViewId: 'plmweb.ticket_type_editor_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realOpenMode: 'POPUPMODAL',
      realTitle: '编辑工单类型',
      refAppViewId: 'plmweb.ticket_type_editor_view',
      name: 'OPENDATA',
      id: 'opendata',
    },
  ],
  controls: [
    {
      aggMode: 'NONE',
      columnEnableFilter: 2,
      columnEnableLink: 2,
      groupMode: 'NONE',
      groupStyle: 'DEFAULT',
      degridColumns: [
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
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'name',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'description',
          excelCaption: '描述',
          appDEFieldId: 'description',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '描述',
          codeName: 'description',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'description',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'create_man',
          excelCaption: '建立人',
          appCodeListId: 'plmweb.sysoperator',
          appDEFieldId: 'create_man',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.CREATE_MAN',
          },
          caption: '建立人',
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
          excelCaption: '建立时间',
          appDEFieldId: 'create_time',
          valueFormat: 'YYYY-MM-DD HH:mm:ss',
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
        {
          deuiactionGroup: {
            uiactionGroupDetails: [
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'gridview_editaction',
                tooltip: '编辑',
                tooltipLanguageRes: {
                  lanResTag: 'TBB.TOOLTIP.*.EDIT',
                },
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-edit',
                  glyph: 'xf044@FontAwesome',
                },
                id: 'uc771d16',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'remove@ticket_type',
                tooltip: '删除',
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-trash-o',
                  glyph: 'xf014@FontAwesome',
                },
                id: 'u9370fb6',
              },
            ],
            appDataEntityId: 'plmweb.ticket_type',
            uniqueTag: 'ticket_type__Usr0418746430',
            name: '编辑&删除',
            id: 'usr0418746430',
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
          appDEFieldId: 'description',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'description',
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
      pagingSize: 100,
      sortMode: 'REMOTE',
      enableCustomized: true,
      singleSelect: true,
      navViewPos: 'NONE',
      fetchControlAction: {
        appDEMethodId: 'fetch_default',
        appDataEntityId: 'plmweb.ticket_type',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.ticket_type',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'global_setting_view_grid',
      controlType: 'GRID',
      logicName: '工单类型全局配置_表格',
      appDataEntityId: 'plmweb.ticket_type',
      controlParam: {
        id: 'grid',
      },
      modelId: '33a2f24357181c47a80341479451babe',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.ticket_type.global_setting_view_grid',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      codeName: 'tabsearchbar',
      controlType: 'SEARCHBAR',
      logicName: '快速搜索栏',
      appDataEntityId: 'plmweb.ticket_type',
      controlParam: {
        ctrlParams: {
          TELEPORTFLAG: 'true',
        },
        id: 'tabsearchbar',
      },
      modelId: 'e7584f4cd4afbdbd5774b7f59cc55b01',
      modelType: 'PSSYSSEARCHBAR',
      name: 'tabsearchbar',
      id: 'plmweb.ticket_type.tabsearchbar',
    },
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'create_ticket_type@ticket_type',
          uiactionTarget: 'NONE',
          valid: true,
          caption: '新建工单类型',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-plus',
            glyph: 'xf067@FontAwesome',
          },
          tooltip: '新建工单类型',
          showCaption: true,
          showIcon: true,
          id: 'deuiaction1_create_ticket_type',
        },
      ],
      xdataControlName: 'grid',
      codeName: 'global_setting_view_tabtoolbar',
      controlType: 'TOOLBAR',
      logicName: '工具栏模板（只有一个实体界面行为组）',
      appDataEntityId: 'plmweb.ticket_type',
      controlParam: {
        ctrlParams: {
          TELEPORTFLAG: 'true',
        },
        id: 'tabtoolbar',
      },
      modelId: '97b647cbe00cc608f9a368e2d0874c1e',
      modelType: 'PSDETOOLBAR',
      name: 'tabtoolbar',
      id: 'global_setting_view_tabtoolbar',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.ticket_type',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.TICKET_TYPE',
      },
      caption: '工单类型',
      codeName: 'global_setting_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.ticket_type',
      controlParam: {},
      name: 'captionbar',
      id: 'global_setting_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.ticket_type',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '工单类型',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'dba56297bb3b3c238f479a4080904015',
  modelType: 'PSAPPDEVIEW',
  name: 'ticket_typeglobal_setting_view',
  id: 'plmweb.ticket_type_global_setting_view',
};
