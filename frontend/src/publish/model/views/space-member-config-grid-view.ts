export default {
  enableRowEdit: true,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'config_grid_view',
  deviewId: '497520aefed42b2875dece0f91e66429',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPACE_MEMBER',
  },
  caption: '空间成员',
  codeName: 'space_member_config_grid_view',
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
      realTitle: '空间成员数据重定向视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.SPACE_MEMBER.REDIRECTVIEW',
      },
      refAppViewId: 'plmweb.space_member_redirect_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
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
          uiactionId: 'new_common',
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
      codeName: 'config_grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '成员表-添加成员',
      appDataEntityId: 'plmweb.space_member',
      controlParam: {
        id: 'toolbar',
      },
      modelId: 'e4c7ec8c53b0399f986684f7da9b5686',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'config_grid_view_toolbar',
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
          clconvertMode: 'FRONT',
          dataItemName: 'role_id',
          excelCaption: '角色',
          appCodeListId: 'plmweb.base__role_type',
          appDEFieldId: 'role_id',
          valueType: 'SIMPLE',
          enableRowEdit: true,
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '角色',
          codeName: 'role_id',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'role_id',
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
          width: 150,
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
      ],
      degridDataItems: [
        {
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'name',
        },
        {
          appDEFieldId: 'role_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'role_id',
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
          caption: '角色',
          codeName: 'role_id',
          enableCond: 3,
          appDEFieldId: 'role_id',
          editor: {
            singleSelect: true,
            appCodeListId: 'plmweb.base__role_type',
            editorType: 'DROPDOWNLIST',
            valueType: 'SIMPLE',
            editable: true,
            id: 'role_id',
          },
          allowEmpty: true,
          needCodeListConfig: true,
          id: 'role_id',
        },
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
      enableRowEdit: true,
      enableRowNew: true,
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.space_member',
        id: 'create',
      },
      fetchControlAction: {
        appDEMethodId: 'fetch_default',
        appDataEntityId: 'plmweb.space_member',
        id: 'fetch',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.space_member',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.space_member',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.space_member',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.space_member',
        id: 'update',
      },
      autoLoad: true,
      showBusyIndicator: true,
      controls: [
        {
          detoolbarItems: [
            {
              actionLevel: 100,
              noPrivDisplayMode: 1,
              uiactionId: 'remove',
              uiactionTarget: 'MULTIKEY',
              valid: true,
              capLanguageRes: {
                lanResTag: 'TBB.TEXT.*.REMOVE',
              },
              caption: '删除',
              itemType: 'DEUIACTION',
              sysImage: {
                cssClass: 'fa fa-remove',
                glyph: 'xf00d@FontAwesome',
              },
              tooltip: '删除',
              tooltipLanguageRes: {
                lanResTag: 'TBB.TOOLTIP.*.REMOVE',
              },
              showCaption: true,
              showIcon: true,
              id: 'deuiaction2',
            },
          ],
          codeName: 'config_grid_view_grid_batchtoolbar',
          controlType: 'TOOLBAR',
          logicName: '工具栏模板（表格批量操作）',
          appDataEntityId: 'plmweb.space_member',
          controlParam: {
            id: 'grid_batchtoolbar',
          },
          modelId: '824333fc6aa069bfea300fcc0b94336d',
          modelType: 'PSDETOOLBAR',
          name: 'grid_batchtoolbar',
          id: 'config_grid_view_grid_batchtoolbar',
        },
      ],
      codeName: 'grid_view_config_grid',
      controlType: 'GRID',
      logicName: '空间成员实体表格视图_表格',
      appDataEntityId: 'plmweb.space_member',
      controlParam: {
        id: 'grid',
      },
      modelId: '038f008fc3cba72d2ce40759e204269e',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.space_member.grid_view_config_grid',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
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
      codeName: 'config_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.space_member',
      controlParam: {},
      name: 'captionbar',
      id: 'config_grid_view_captionbar',
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
  title: '空间成员表格',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '85130571d7b835e9206c9b31705b683c',
  modelType: 'PSAPPDEVIEW',
  name: 'space_memberconfig_grid_view',
  id: 'plmweb.space_member_config_grid_view',
};