export default {
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'assigned_grid_view',
  deviewId: 'e6bae1d1b201c101c59b95a62ae82ca3',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPACE_MEMBER',
  },
  caption: '空间成员',
  codeName: 'space_member_assigned_grid_view',
  appDataEntityId: 'plmweb.space_member',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'GridView',
      id: 'engine',
    },
  ],
  appViewLogics: [
    {
      eventNames: 'onCreated',
      logicTrigger: 'VIEWEVENT',
      logicType: 'APPDEUILOGIC',
      appDEUILogicId: 'create_default_temp_members',
      appDataEntityId: 'plmweb.space_member',
      builtinLogic: true,
      name: 'LOGIC',
      id: 'logic',
    },
    {
      logicTrigger: 'CUSTOM',
      logicType: 'APPUILOGIC',
      builtinAppUILogic: {
        actionAfterWizard: 'DEFAULT',
        batchAddAppViews: [
          {
            openMode: 'POPUPMODAL',
            refMode: 'USER',
            refAppViewId: 'plmweb.user_choose_mpick_up_view',
          },
        ],
        newDataAppView: {
          refAppViewId: 'plmweb.space_member_edit_view',
        },
        enableBatchAdd: true,
        appDataEntityId: 'plmweb.space_member',
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.space_member_edit_view',
          },
          {
            openMode: 'POPUPMODAL',
            refMode: 'USER',
            refAppViewId: 'plmweb.user_choose_mpick_up_view',
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
          refAppViewId: 'plmweb.space_member_redirect_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.space_member_redirect_view',
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
  appViewParams: [
    {
      key: 'PROPERTYMAP',
      value: 'display_name:name',
      name: 'PROPERTYMAP',
      id: 'propertymap',
    },
  ],
  appViewRefs: [
    {
      realTitle: '空间成员编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.SPACE_MEMBER.EDITVIEW',
      },
      refAppViewId: 'plmweb.space_member_edit_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      realTitle: '空间成员数据重定向视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.SPACE_MEMBER.REDIRECTVIEW',
      },
      refAppViewId: 'plmweb.space_member_redirect_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realOpenMode: 'POPUPMODAL',
      realTitle: '选择成员',
      refAppViewId: 'plmweb.user_choose_mpick_up_view',
      name: 'MPICKUPVIEW:USER',
      id: 'mpickupview:user',
    },
  ],
  controls: [
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'new',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.*.NEW',
          },
          caption: '添加成员',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-plus',
            glyph: 'xf067@FontAwesome',
          },
          tooltip: '添加成员',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.*.NEW',
          },
          showCaption: true,
          showIcon: true,
          id: 'deuiaction1',
        },
      ],
      xdataControlName: 'grid',
      codeName: 'assigned_grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '添加成员',
      appDataEntityId: 'plmweb.space_member',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '41167099b62c6b269095ada0e0176010',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'assigned_grid_view_toolbar',
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
          excelCaption: '姓名',
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '姓名',
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
                uiactionId: 'remove_member@space_member',
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-trash',
                  glyph: 'xf1f8@FontAwesome',
                },
                id: 'uafbf3eb',
              },
            ],
            appDataEntityId: 'plmweb.space_member',
            uniqueTag: 'space_member__Usr0227475921',
            name: '空间成员配置',
            id: 'usr0227475921',
          },
          aggMode: 'NONE',
          align: 'RIGHT',
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
          appDEFieldId: 'user_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'user_id',
        },
        {
          appDEFieldId: 'space_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'space_id',
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
      singleSelect: true,
      fetchControlAction: {
        appDEMethodId: 'fetch_default',
        appDataEntityId: 'plmweb.space_member',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.space_member',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'main',
      controlType: 'GRID',
      logicName: '主表格',
      appDataEntityId: 'plmweb.space_member',
      controlParam: {
        id: 'grid',
      },
      modelId: '100d9372caebff7f3d1a7a4eeb580300',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.space_member.main',
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
            lanResTag: 'CONTROL.DEFORM.SPACE_MEMBER.DEFAULT.FORMPAGE.FORMPAGE1',
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
      appDataEntityId: 'plmweb.space_member',
      controlParam: {
        id: 'searchform',
      },
      modelId: '75d1281e27232788f0dc7293c49c244d',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.space_member.default',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.space_member',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.SPACE_MEMBER',
      },
      caption: '空间成员',
      codeName: 'assigned_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.space_member',
      controlParam: {},
      name: 'captionbar',
      id: 'assigned_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.space_member',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '空间成员',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '45c146e362bf996668c08a9b3add40ff',
  modelType: 'PSAPPDEVIEW',
  name: 'space_memberassigned_grid_view',
  id: 'plmweb.space_member_assigned_grid_view',
};