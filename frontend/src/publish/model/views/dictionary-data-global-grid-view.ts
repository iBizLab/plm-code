export default {
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'global_grid_view',
  deviewId: '2AD8D583-270B-4E03-A6F0-98B6A1B934F4',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.DICTIONARY',
  },
  caption: '发布阶段',
  codeName: 'dictionary_data_global_grid_view',
  appDataEntityId: 'plmweb.dictionary_data',
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
          refAppViewId: 'plmweb.dictionary_data_global_create_view',
        },
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.dictionary_data_global_create_view',
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
          refAppViewId: 'plmweb.dictionary_data_global_edit_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.dictionary_data_global_edit_view',
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
  appViewMsgGroupId: 'usrvmgroup0419846925',
  appViewNavParams: [
    {
      key: 'n_catalog_eq',
      value: 'catalog',
      id: 'n_catalog_eq',
    },
  ],
  appViewRefs: [
    {
      realOpenMode: 'POPUPMODAL',
      realTitle: '编辑阶段',
      refAppViewId: 'plmweb.dictionary_data_global_edit_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realOpenMode: 'POPUPMODAL',
      realTitle: '新建阶段',
      refAppViewId: 'plmweb.dictionary_data_global_create_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
  ],
  controls: [
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'create_global_type@dictionary_data',
          uiactionTarget: 'NONE',
          valid: true,
          caption: '新建阶段',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-plus',
            glyph: 'xf067@FontAwesome',
          },
          tooltip: '新建阶段',
          showCaption: true,
          showIcon: true,
          id: 'deuiaction1_create_global_type',
        },
      ],
      xdataControlName: 'grid',
      codeName: 'global_grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '工具栏模板（只有一个实体界面行为组）',
      appDataEntityId: 'plmweb.dictionary_data',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '97b647cbe00cc608f9a368e2d0874c1e',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'global_grid_view_toolbar',
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
          excelCaption: '阶段名称',
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '阶段名称',
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'name',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'type',
          excelCaption: '阶段类型',
          appCodeListId: 'plmweb.base__stage_type',
          appDEFieldId: 'type',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '阶段类型',
          codeName: 'type',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'type',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'update_man',
          excelCaption: '更新人',
          appCodeListId: 'plmweb.sysoperator',
          appDEFieldId: 'update_man',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.UPDATE_MAN',
          },
          caption: '更新人',
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
          excelCaption: '更新时间',
          appDEFieldId: 'update_time',
          valueFormat: 'YYYY-MM-DD HH:mm:ss',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.UPDATE_TIME',
          },
          caption: '更新时间',
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
                uiactionId: 'edit',
                tooltip: '编辑',
                tooltipLanguageRes: {
                  lanResTag: 'TBB.TOOLTIP.*.EDIT',
                },
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-edit',
                  glyph: 'xf044@FontAwesome',
                },
                id: 'u7a0a349',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'remove',
                tooltip: '删除',
                tooltipLanguageRes: {
                  lanResTag: 'TBB.TOOLTIP.*.REMOVE',
                },
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-trash-o',
                  glyph: 'xf014@FontAwesome',
                },
                id: 'u5537edb',
              },
            ],
            appDataEntityId: 'plmweb.dictionary_data',
            uniqueTag: 'dictionary_data__Usr0418096363',
            name: '编辑&删除',
            id: 'usr0418096363',
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
          appDEFieldId: 'type',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'type',
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
        appDEMethodId: 'fetch_default',
        appDataEntityId: 'plmweb.dictionary_data',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.dictionary_data',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'global_grid_view_grid',
      controlType: 'GRID',
      logicName: '实体表格视图（发布阶段）_表格',
      appDataEntityId: 'plmweb.dictionary_data',
      controlParam: {
        id: 'grid',
      },
      modelId: '18920A97-8084-43A7-9DA8-E1A7FC515465',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.dictionary_data.global_grid_view_grid',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.dictionary_data',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.DICTIONARY',
      },
      caption: '发布阶段',
      codeName: 'global_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.dictionary_data',
      controlParam: {},
      name: 'captionbar',
      id: 'global_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.dictionary_data',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '发布阶段',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '43104ebd526edc84a7254fb2205af188',
  modelType: 'PSAPPDEVIEW',
  name: 'dictionary_dataglobal_grid_view',
  id: 'plmweb.dictionary_data_global_grid_view',
};