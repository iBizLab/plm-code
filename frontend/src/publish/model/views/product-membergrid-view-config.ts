export default {
  enableRowEdit: true,
  rowEditDefault: true,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'grid_view_config',
  deviewId: '2f3e78d0e1a8446a870a42d2a858e79e',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.PRODUCT_MEMBER',
  },
  caption: '产品成员',
  codeName: 'product_membergrid_view_config',
  appDataEntityId: 'plmweb.product_member',
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
            refAppViewId: 'plmweb.userm_pick_up_view2',
          },
        ],
        newDataAppView: {
          openMode: 'POPUPMODAL',
          refAppViewId: 'plmweb.product_membereditview',
        },
        enableBatchAdd: true,
        appDataEntityId: 'plmweb.product_member',
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.product_membereditview',
          },
          {
            openMode: 'POPUPMODAL',
            refMode: 'USER',
            refAppViewId: 'plmweb.userm_pick_up_view2',
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
          refAppViewId: 'plmweb.product_memberredirectview',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.product_memberredirectview',
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
      realTitle: '产品成员数据重定向视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.PRODUCT_MEMBER.REDIRECTVIEW',
      },
      refAppViewId: 'plmweb.product_memberredirectview',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      openMode: 'POPUPMODAL',
      realOpenMode: 'POPUPMODAL',
      realTitle: '产品成员编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.PRODUCT_MEMBER.EDITVIEW',
      },
      refAppViewId: 'plmweb.product_membereditview',
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      name: 'MPICKUPVIEW:PRODUCT',
      id: 'mpickupview:product',
    },
    {
      realOpenMode: 'POPUPMODAL',
      realTitle: '选择成员',
      refAppViewId: 'plmweb.userm_pick_up_view2',
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
          uiactionId: 'add_product_member',
          uiactionTarget: 'NONE',
          valid: true,
          caption: '添加成员',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-plus',
            glyph: 'xf067@FontAwesome',
          },
          tooltip: '添加成员',
          showCaption: true,
          showIcon: true,
          id: 'deuiaction1',
        },
      ],
      xdataControlName: 'grid',
      codeName: 'grid_view_configtoolbar',
      controlType: 'TOOLBAR',
      logicName: '成员表-添加成员',
      appDataEntityId: 'plmweb.product_member',
      controlParam: {
        id: 'toolbar',
      },
      modelId: 'fe0f7071346a0550d43e1d9420fd7574',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'grid_view_configtoolbar',
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
          appDEFieldId: 'product_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'product_id',
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
        appDataEntityId: 'plmweb.product_member',
        id: 'create',
      },
      fetchControlAction: {
        appDEMethodId: 'fetchdefault',
        appDataEntityId: 'plmweb.product_member',
        id: 'fetch',
      },
      getDraftControlAction: {
        appDEMethodId: 'getdraft',
        appDataEntityId: 'plmweb.product_member',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.product_member',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.product_member',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.product_member',
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
          codeName: 'grid_view_configgrid_batchtoolbar',
          controlType: 'TOOLBAR',
          logicName: '工具栏模板（表格批量操作）',
          appDataEntityId: 'plmweb.product_member',
          controlParam: {
            id: 'grid_batchtoolbar',
          },
          modelId: '824333fc6aa069bfea300fcc0b94336d',
          modelType: 'PSDETOOLBAR',
          name: 'grid_batchtoolbar',
          id: 'grid_view_configgrid_batchtoolbar',
        },
      ],
      codeName: 'Setting_table',
      controlType: 'GRID',
      logicName: '产品成员',
      appDataEntityId: 'plmweb.product_member',
      controlParam: {
        id: 'grid',
      },
      modelId: 'd71b3dd388a97ca314fd6fdf148e0d02',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.product_member.setting_table',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.product_member',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.PRODUCT_MEMBER',
      },
      caption: '产品成员',
      codeName: 'grid_view_configcaptionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.product_member',
      controlParam: {},
      name: 'captionbar',
      id: 'grid_view_configcaptionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'Layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.product_member',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '产品成员',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'fc673378e1cfcbf265abb5be40ea9f2b',
  modelType: 'PSAPPDEVIEW',
  name: 'product_membergrid_view_config',
  id: 'plmweb.product_membergrid_view_config',
};