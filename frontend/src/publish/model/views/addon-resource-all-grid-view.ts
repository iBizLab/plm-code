export default {
  xdataControlName: 'grid',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'all_grid_view',
  deviewId: 'DEE770C3-53CF-4BCA-A001-60054319981E',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.ADDON_RESOURCE',
  },
  caption: '资源视图管理',
  codeName: 'addon_resource_all_grid_view',
  height: 500,
  appDataEntityId: 'plmweb.addon_resource',
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
          refAppViewId: 'plmweb.addon_resource_edit_view',
        },
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.addon_resource_edit_view',
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
          refAppViewId: 'plmweb.addon_resource_redirect_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.addon_resource_redirect_view',
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
      key: 'n_id_noteq',
      value: 'all_resource',
      id: 'n_id_noteq',
    },
  ],
  appViewRefs: [
    {
      realTitle: '资源组件编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.ADDON_RESOURCE.EDITVIEW',
      },
      refAppViewId: 'plmweb.addon_resource_edit_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      realTitle: '资源组件数据重定向视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.ADDON_RESOURCE.REDIRECTVIEW',
      },
      refAppViewId: 'plmweb.addon_resource_redirect_view',
      name: 'EDITDATA',
      id: 'editdata',
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
          excelCaption: '资源视图名称',
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '资源视图名称',
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'name',
        },
        {
          deuiactionGroup: {
            uiactionGroupDetails: [
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'edit_resource@addon_resource',
                tooltip: '编辑资源',
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-edit',
                  glyph: 'xf044@FontAwesome',
                },
                id: 'ua05b4ba',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'del_resource@addon_resource',
                tooltip: '删除资源',
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-trash-o',
                  glyph: 'xf014@FontAwesome',
                },
                id: 'u84f7de3',
              },
            ],
            appDataEntityId: 'plmweb.addon_resource',
            uniqueTag: 'addon_resource__Usr0604823722',
            name: '全局资源表格_操作列',
            id: 'usr0604823722',
          },
          aggMode: 'NONE',
          align: 'CENTER',
          caption: '操作',
          codeName: 'uagridcolumn1',
          columnType: 'UAGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
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
          appDEFieldId: 'id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'id',
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
      pagingSize: 500,
      sortMode: 'REMOTE',
      singleSelect: true,
      fetchControlAction: {
        appDEMethodId: 'fetch_all',
        appDataEntityId: 'plmweb.addon_resource',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.addon_resource',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'all',
      controlType: 'GRID',
      logicName: '全局资源_表格',
      appDataEntityId: 'plmweb.addon_resource',
      controlParam: {
        id: 'grid',
      },
      modelId: 'D817F3AD-5522-4E43-A9B0-C50CEB67298B',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.addon_resource.all',
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
              'CONTROL.DEFORM.ADDON_RESOURCE.DEFAULT.FORMPAGE.FORMPAGE1',
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
      appDataEntityId: 'plmweb.addon_resource',
      controlParam: {
        id: 'searchform',
      },
      modelId: 'df72825609b9a49691fe3c434cf3d81f',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.addon_resource.default',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.addon_resource',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.ADDON_RESOURCE',
      },
      caption: '资源视图管理',
      codeName: 'all_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.addon_resource',
      controlParam: {},
      name: 'captionbar',
      id: 'all_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.addon_resource',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '资源视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  width: 700,
  enableDP: true,
  showCaptionBar: true,
  modelId: 'f23b6fbbf238afda08257adc6d5e983e',
  modelType: 'PSAPPDEVIEW',
  name: 'addon_resourceall_grid_view',
  id: 'plmweb.addon_resource_all_grid_view',
};