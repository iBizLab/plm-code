export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  deviewCodeName: 'comparison_grid_view',
  deviewId: 'b181c93651627625fac6c85923fd268b',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.BASELINE_WORK_ITEM',
  },
  caption: '基线对比',
  codeName: 'baseline_work_item_comparison_grid_view',
  appDataEntityId: 'plmweb.baseline_work_item',
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
          refAppViewId: 'plmweb.baseline_work_item_edit_view',
        },
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.baseline_work_item_edit_view',
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
          navigateContexts: [
            {
              key: 'WORK_ITEM',
              value: 'target_id',
              name: 'WORK_ITEM',
              id: 'work_item',
            },
            {
              key: 'PROJECT',
              value: 'project_id',
              name: 'PROJECT',
              id: 'project',
            },
            {
              key: 'SRFREADONLY',
              value: 'true',
              rawValue: true,
              name: 'SRFREADONLY',
              id: 'srfreadonly',
            },
          ],
          navigateParams: [
            {
              key: 'srfversionid',
              value: 'target_version_id',
              id: 'srfversionid',
            },
          ],
          refAppViewId: 'plmweb.work_item_main_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            navigateContexts: [
              {
                key: 'WORK_ITEM',
                value: 'target_id',
                name: 'WORK_ITEM',
                id: 'work_item',
              },
              {
                key: 'PROJECT',
                value: 'project_id',
                name: 'PROJECT',
                id: 'project',
              },
              {
                key: 'SRFREADONLY',
                value: 'true',
                rawValue: true,
                name: 'SRFREADONLY',
                id: 'srfreadonly',
              },
            ],
            navigateParams: [
              {
                key: 'srfversionid',
                value: 'target_version_id',
                id: 'srfversionid',
              },
            ],
            refAppViewId: 'plmweb.work_item_main_view',
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
      key: 'baseline',
      value: 'baseline',
      id: 'baseline',
    },
  ],
  appViewRefs: [
    {
      realTitle: '基线工作项编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.BASELINE_WORK_ITEM.EDITVIEW',
      },
      refAppViewId: 'plmweb.baseline_work_item_edit_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      openMode: 'POPUPMODAL',
      navigateContexts: [
        {
          key: 'WORK_ITEM',
          value: 'target_id',
          name: 'WORK_ITEM',
          id: 'work_item',
        },
        {
          key: 'PROJECT',
          value: 'project_id',
          name: 'PROJECT',
          id: 'project',
        },
        {
          key: 'SRFREADONLY',
          value: 'true',
          rawValue: true,
          name: 'SRFREADONLY',
          id: 'srfreadonly',
        },
      ],
      navigateParams: [
        {
          key: 'srfversionid',
          value: 'target_version_id',
          id: 'srfversionid',
        },
      ],
      realOpenMode: 'POPUPMODAL',
      realTitle: '工作项',
      refAppViewId: 'plmweb.work_item_main_view',
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
      groupStyle: 'DEFAULT',
      degridColumns: [
        {
          clconvertMode: 'NONE',
          dataItemName: 'show_identifier',
          excelCaption: '编号',
          appDEFieldId: 'show_identifier',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '编号',
          codeName: 'show_identifier',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          id: 'show_identifier',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'title',
          excelCaption: '标题',
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '标题',
          codeName: 'title',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'STAR',
          id: 'title',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'target_version',
          excelCaption: '版本',
          objectNameField: 'name',
          appDEFieldId: 'target_version',
          valueType: 'OBJECT',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '版本',
          codeName: 'target_version_name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'PX',
          id: 'target_version_name',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'state',
          excelCaption: '状态',
          appCodeListId: 'plmweb.projmgmt__work_item_state',
          appDEFieldId: 'state',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '状态',
          codeName: 'state',
          columnType: 'DEFGRIDCOLUMN',
          hideMode: 1,
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          hideDefault: true,
          id: 'state',
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
          hideMode: 1,
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          hideDefault: true,
          id: 'assignee_name',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'priority',
          excelCaption: '优先级',
          appCodeListId: 'plmweb.projmgmt__work_item_priority',
          appDEFieldId: 'priority',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '优先级',
          codeName: 'priority',
          columnType: 'DEFGRIDCOLUMN',
          hideMode: 1,
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          hideDefault: true,
          id: 'priority',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'ptitle',
          excelCaption: '父工作项',
          appDEFieldId: 'ptitle',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '父工作项',
          codeName: 'ptitle',
          columnType: 'DEFGRIDCOLUMN',
          hideMode: 1,
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          hideDefault: true,
          id: 'ptitle',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'create_time',
          excelCaption: '建立时间',
          appDEFieldId: 'create_time',
          valueFormat: 'YYYY-MM-DD',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.CREATE_TIME',
          },
          caption: '建立时间',
          codeName: 'create_time',
          columnType: 'DEFGRIDCOLUMN',
          hideMode: 1,
          noPrivDisplayMode: 1,
          width: 180,
          widthUnit: 'PX',
          enableSort: true,
          hideDefault: true,
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
                uiactionId: 'work_item_version_comparison@baseline_work_item',
                tooltip: '版本对比',
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-exchange',
                  glyph: 'xf0ec@FontAwesome',
                },
                id: 'u7bf94a9',
              },
            ],
            appDataEntityId: 'plmweb.baseline_work_item',
            uniqueTag: 'baseline_work_item__Usr0425392134',
            name: '基线对比操作列',
            id: 'usr0425392134',
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
          appDEFieldId: 'show_identifier',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'show_identifier',
        },
        {
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'title',
        },
        {
          appDEFieldId: 'target_version',
          valueType: 'OBJECT',
          dataType: 21,
          id: 'target_version',
        },
        {
          appDEFieldId: 'state',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'state',
        },
        {
          appDEFieldId: 'assignee_name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'assignee_name',
        },
        {
          appDEFieldId: 'priority',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'priority',
        },
        {
          appDEFieldId: 'ptitle',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'ptitle',
        },
        {
          format: 'YYYY-MM-DD',
          appDEFieldId: 'create_time',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'create_time',
        },
        {
          appDEFieldId: 'target_version_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'target_version_id',
        },
        {
          appDEFieldId: 'target_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'target_id',
        },
        {
          appDEFieldId: 'principal_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'principal_id',
        },
        {
          appDEFieldId: 'project_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'project_id',
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
      enableCustomized: true,
      singleSelect: true,
      navViewPos: 'NONE',
      fetchControlAction: {
        appDEMethodId: 'fetch_baseline_comparison',
        appDataEntityId: 'plmweb.baseline_work_item',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.baseline_work_item',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'comparison_grid',
      controlStyle: 'BASELINECOMPARE',
      controlType: 'GRID',
      logicName: '基线对比_表格',
      appDataEntityId: 'plmweb.baseline_work_item',
      controlParam: {
        ctrlParams: {
          N_OWNER_ID_EQ: '`${context.project}`',
          RESPONSEMAP: '{"id":"id","name":"name"}',
          REQUESTURL: '`projects/${context.project}/baselines/fetch_baseline`',
          REQUESTMETHOD: 'post',
          N_OWNER_TYPE_EQ: "'project'",
        },
        id: 'grid',
      },
      sysPFPluginId: 'baselinecompare',
      modelId: '31f0ecc0c5b1d2e3c298c3382b6c4954',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.baseline_work_item.comparison_grid',
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
              'CONTROL.DEFORM.BASELINE_WORK_ITEM.DEFAULT.FORMPAGE.FORMPAGE1',
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
      appDataEntityId: 'plmweb.baseline_work_item',
      controlParam: {
        id: 'searchform',
      },
      modelId: 'bbbfee9105ddc8f23d074413cadb60e8',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.baseline_work_item.default',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.baseline_work_item',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.BASELINE_WORK_ITEM',
      },
      caption: '基线对比',
      codeName: 'comparison_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.baseline_work_item',
      controlParam: {},
      name: 'captionbar',
      id: 'comparison_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.baseline_work_item',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '项目基线对比表格视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '3afec2adff355320c82d90b58233cd06',
  modelType: 'PSAPPDEVIEW',
  name: 'baseline_work_itemcomparison_grid_view',
  id: 'plmweb.baseline_work_item_comparison_grid_view',
};
