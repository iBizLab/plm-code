export default {
  xdataControlName: 'grid',
  loadDefault: true,
  funcViewMode: 'MDATAVIEW',
  deviewCodeName: 'GridView',
  deviewId: '8ffab4b433db31af337f0bdf9bbb9d3f',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.ROLE_MEMBER',
  },
  caption: '角色成员',
  codeName: 'role_member_grid_view',
  appDataEntityId: 'plmweb.role_member',
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
          refAppViewId: 'plmweb.role_member_edit_view',
        },
        enableBatchAdd: true,
        appDataEntityId: 'plmweb.role_member',
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.role_member_edit_view',
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
          refAppViewId: 'plmweb.role_member_edit_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.role_member_edit_view',
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
      realTitle: '系统角色成员编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.ROLE_MEMBER.EDITVIEW',
      },
      refAppViewId: 'plmweb.role_member_edit_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realTitle: '系统角色成员编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.ROLE_MEMBER.EDITVIEW',
      },
      refAppViewId: 'plmweb.role_member_edit_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      name: 'MPICKUPVIEW:ROLE',
      id: 'mpickupview:role',
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
      searchButtonStyle: 'DEFAULT',
      deformPages: [
        {
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.ROLE_MEMBER.DEFAULT.FORMPAGE.FORMPAGE1',
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
      appDataEntityId: 'plmweb.role_member',
      controlParam: {
        id: 'searchform',
      },
      modelId: '842250713fdccef83dc67d74e70820ef',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.role_member.default',
    },
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
          width: 150,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'name',
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
      pagingMode: 1,
      pagingSize: 20,
      sortMode: 'REMOTE',
      enableCustomized: true,
      enablePagingBar: true,
      navViewPos: 'NONE',
      fetchControlAction: {
        appDEMethodId: 'fetch_default',
        appDataEntityId: 'plmweb.role_member',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.role_member',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      controls: [
        {
          detoolbarItems: [
            {
              actionLevel: 100,
              noPrivDisplayMode: 2,
              uiactionId: 'remove@role_member',
              uiactionTarget: 'MULTIKEY',
              valid: true,
              caption: '删除',
              itemType: 'DEUIACTION',
              sysImage: {
                cssClass: 'fa fa-trash-o',
                glyph: 'xf014@FontAwesome',
              },
              tooltip: '删除',
              showCaption: true,
              showIcon: true,
              id: 'deuiaction1',
            },
          ],
          codeName: 'grid_view_grid_batchtoolbar',
          controlType: 'TOOLBAR',
          logicName: '批量操作工具栏',
          appDataEntityId: 'plmweb.role_member',
          controlParam: {
            id: 'grid_batchtoolbar',
          },
          modelId: '1680AA6D-A479-4B48-8669-DF8D0C3D66A2',
          modelType: 'PSDETOOLBAR',
          name: 'grid_batchtoolbar',
          id: 'grid_view_grid_batchtoolbar',
        },
      ],
      codeName: 'main',
      controlType: 'GRID',
      logicName: '主表格',
      appDataEntityId: 'plmweb.role_member',
      controlParam: {
        id: 'grid',
      },
      modelId: 'cffc3a3b0a051f595c6bcb05a2845c51',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.role_member.main',
    },
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'gridview_newaction',
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
      codeName: 'grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '添加成员',
      appDataEntityId: 'plmweb.role_member',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '78284ACE-F7C8-47E1-8032-A44E7FA5545F',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'grid_view_toolbar',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.role_member',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.ROLE_MEMBER',
      },
      caption: '角色成员',
      codeName: 'grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.role_member',
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
    appDataEntityId: 'plmweb.role_member',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '系统角色成员表格视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.ROLE_MEMBER.GRIDVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '90145ce960d1541641036bfd82aae570',
  modelType: 'PSAPPDEVIEW',
  name: 'role_memberGridView',
  id: 'plmweb.role_member_grid_view',
};
