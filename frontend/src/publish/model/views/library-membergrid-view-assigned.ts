export default {
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'grid_view_assigned',
  deviewId: '8c0f7c314e2827319f0a1914e1e8a012',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.LIBRARY_MEMBER',
  },
  caption: '测试库成员',
  codeName: 'library_membergrid_view_assigned',
  appDataEntityId: 'plmweb.library_member',
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
      appDataEntityId: 'plmweb.library_member',
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
            refAppViewId: 'plmweb.userm_pick_up_view2',
          },
        ],
        newDataAppView: {
          refAppViewId: 'plmweb.library_membereditview',
        },
        enableBatchAdd: true,
        appDataEntityId: 'plmweb.library_member',
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.library_membereditview',
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
          refAppViewId: 'plmweb.library_memberredirectview',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.library_memberredirectview',
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
      key: 'n_library_id_eq',
      value: 'library',
      id: 'n_library_id_eq',
    },
    {
      key: 'library_id',
      value: 'library',
      id: 'library_id',
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
      realTitle: '测试库成员编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.LIBRARY_MEMBER.EDITVIEW',
      },
      refAppViewId: 'plmweb.library_membereditview',
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      realTitle: '测试库成员数据重定向视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.LIBRARY_MEMBER.REDIRECTVIEW',
      },
      refAppViewId: 'plmweb.library_memberredirectview',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      name: 'MPICKUPVIEW:LIBRARY',
      id: 'mpickupview:library',
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
      codeName: 'grid_view_assignedtoolbar',
      controlType: 'TOOLBAR',
      logicName: '添加成员',
      appDataEntityId: 'plmweb.library_member',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '1c9a0339342259c9a4e65f8c77b0dbbd',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'grid_view_assignedtoolbar',
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
                uiactionId: 'delete_member@library_member',
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-trash',
                  glyph: 'xf1f8@FontAwesome',
                },
                id: 'ud1b4964',
              },
            ],
            uniqueTag: 'Library_member__Usr1220824792',
            name: '设置测试库成员',
            id: 'usr1220824792',
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
          appDEFieldId: 'library_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'library_id',
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
        appDEMethodId: 'fetchdefault',
        appDataEntityId: 'plmweb.library_member',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.library_member',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'Binding',
      controlType: 'GRID',
      logicName: '测试库绑定成员表格',
      appDataEntityId: 'plmweb.library_member',
      controlParam: {
        id: 'grid',
      },
      modelId: 'b996342f57e766982f256ddd32e641a2',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.library_member.binding',
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
              'CONTROL.DEFORM.LIBRARY_MEMBER.DEFAULT.FORMPAGE.FORMPAGE1',
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
      codeName: 'Default',
      controlType: 'SEARCHFORM',
      logicName: '默认搜索表单',
      appDataEntityId: 'plmweb.library_member',
      controlParam: {
        id: 'searchform',
      },
      modelId: '8e6a7f92e510abf9b899c05e0516bea4',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.library_member.default',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.library_member',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.LIBRARY_MEMBER',
      },
      caption: '测试库成员',
      codeName: 'grid_view_assignedcaptionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.library_member',
      controlParam: {},
      name: 'captionbar',
      id: 'grid_view_assignedcaptionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'Layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.library_member',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '测试库成员',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'e0dccfd0371133a442f2739f4bdbd0fd',
  modelType: 'PSAPPDEVIEW',
  name: 'library_membergrid_view_assigned',
  id: 'plmweb.library_membergrid_view_assigned',
};