export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'space_grid_view',
  deviewId: 'CBE025A6-82F7-45EC-B7CE-5B9B9E5386A4',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.BASELINE',
  },
  caption: '全部基线',
  codeName: 'baseline_space_grid_view',
  appDataEntityId: 'plmweb.baseline',
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
          refAppViewId: 'plmweb.baseline_space_create_view',
        },
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.baseline_space_create_view',
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
          navigateContexts: [
            {
              key: 'BASELINE_STATUS',
              value: 'status',
              name: 'BASELINE_STATUS',
              id: 'baseline_status',
            },
          ],
          refAppViewId: 'plmweb.baseline_space_main_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            navigateContexts: [
              {
                key: 'BASELINE_STATUS',
                value: 'status',
                name: 'BASELINE_STATUS',
                id: 'baseline_status',
              },
            ],
            refAppViewId: 'plmweb.baseline_space_main_view',
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
      realOpenMode: 'POPUPMODAL',
      realTitle: '空间基线快速建立视图',
      refAppViewId: 'plmweb.baseline_space_create_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      navigateContexts: [
        {
          key: 'BASELINE_STATUS',
          value: 'status',
          name: 'BASELINE_STATUS',
          id: 'baseline_status',
        },
      ],
      realTitle: '空间基线分页导航视图',
      refAppViewId: 'plmweb.baseline_space_main_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
  ],
  controls: [
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'new_subdata',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.*.NEW',
          },
          caption: '新建基线',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-plus',
            glyph: 'xf067@FontAwesome',
          },
          tooltip: '新建基线',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.*.NEW',
          },
          showCaption: true,
          showIcon: true,
          id: 'deuiaction1',
        },
      ],
      xdataControlName: 'grid',
      codeName: 'space_grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '新建基线',
      appDataEntityId: 'plmweb.baseline',
      controlParam: {
        id: 'toolbar',
      },
      modelId: 'F4C7FDFF-9067-4458-8533-CF79BB9ED78D',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'space_grid_view_toolbar',
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
          excelCaption: '基线名称',
          appDEFieldId: 'name',
          deuiactionGroup: {
            uiactionGroupDetails: [
              {
                actionLevel: 200,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'set_complete_space@baseline',
                tooltip: '设立完成',
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-dot-circle-o',
                  glyph: 'xf192@FontAwesome',
                },
                id: 'uc5d5fe3',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '编辑',
                detailType: 'DEUIACTION',
                uiactionId: 'open_space_update_view@baseline',
                showCaption: true,
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-edit',
                  glyph: 'xf044@FontAwesome',
                },
                id: 'u2e3d8c0',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '删除',
                detailType: 'DEUIACTION',
                uiactionId: 'remove@baseline',
                showCaption: true,
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-trash-o',
                  glyph: 'xf014@FontAwesome',
                },
                id: 'u80a6b80',
              },
            ],
            appDataEntityId: 'plmweb.baseline',
            uniqueTag: 'baseline__Usr0524607778',
            name: '空间基线表格操作列',
            id: 'usr0524607778',
          },
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '基线名称',
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 300,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'name',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'status',
          excelCaption: '状态',
          appCodeListId: 'plmweb.base__baseline_status',
          appDEFieldId: 'status',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '状态',
          codeName: 'status',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'status',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'categories',
          excelCaption: '类别',
          appCodeListId: 'plmweb.prodmgmt__category',
          appDEFieldId: 'categories',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '类别',
          codeName: 'categories',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 300,
          widthUnit: 'PX',
          enableSort: true,
          id: 'categories',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'assignee_name',
          excelCaption: '负责人',
          appDEFieldId: 'assignee_name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '负责人',
          codeName: 'assignee_name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'assignee_name',
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
          widthUnit: 'PX',
          enableSort: true,
          id: 'description',
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
          appDEFieldId: 'status',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'status',
        },
        {
          appDEFieldId: 'categories',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'categories',
        },
        {
          appDEFieldId: 'assignee_name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'assignee_name',
        },
        {
          appDEFieldId: 'description',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'description',
        },
        {
          format: 'YYYY-MM-DD HH:mm:ss',
          appDEFieldId: 'create_time',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'create_time',
        },
        {
          appDEFieldId: 'create_man',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'create_man',
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
      enablePagingBar: true,
      singleSelect: true,
      fetchControlAction: {
        appDEMethodId: 'fetch_baseline',
        appDataEntityId: 'plmweb.baseline',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.baseline',
        id: 'remove',
      },
      autoLoad: true,
      enableItemPrivilege: true,
      showBusyIndicator: true,
      codeName: 'space_baseline_grid',
      controlType: 'GRID',
      logicName: '空间基线_表格',
      appDataEntityId: 'plmweb.baseline',
      controlLogics: [
        {
          eventNames: 'onLoadSuccess',
          logicTag: 'grid',
          logicType: 'APPDEUILOGIC',
          appDEUILogicId: 'calc_column_action_state',
          appDataEntityId: 'plmweb.baseline',
          triggerType: 'CTRLEVENT',
          id: 'logic',
        },
      ],
      controlParam: {
        id: 'grid',
      },
      modelId: 'db225c57bf09ee64f9e44697669b54c2',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.baseline.space_baseline_grid',
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
            lanResTag: 'CONTROL.DEFORM.BASELINE.DEFAULT.FORMPAGE.FORMPAGE1',
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
      appDataEntityId: 'plmweb.baseline',
      controlParam: {
        id: 'searchform',
      },
      modelId: '4ca9c1fe6f7ba679795e6b8200664b53',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.baseline.default',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.baseline',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.BASELINE',
      },
      caption: '全部基线',
      codeName: 'space_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.baseline',
      controlParam: {},
      name: 'captionbar',
      id: 'space_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.baseline',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '空间基线树导航表格视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '5f4c3a6d5568b6e4fbd3be5efce601a7',
  modelType: 'PSAPPDEVIEW',
  name: 'baselinespace_grid_view',
  id: 'plmweb.baseline_space_grid_view',
};