export default {
  gridRowActiveMode: 1,
  expandSearchForm: true,
  pickupMode: true,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'pick_up_grid_view',
  deviewId: 'd77fa5524667512d862aa19230882a7c',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TEST_PLAN',
  },
  caption: '测试计划',
  codeName: 'test_plan_pick_up_grid_view',
  appDataEntityId: 'plmweb.test_plan',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'PickupGridView',
      id: 'engine',
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
          excelCaption: '计划名称',
          appDEFieldId: 'name',
          deuiactionGroup: {
            uiactionGroupDetails: [
              {
                actionLevel: 200,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'start_test_plan@test_plan',
                tooltip: '开始测试',
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-play-circle-o',
                  glyph: 'xf01d@FontAwesome',
                },
                id: 'u6d3152c',
              },
              {
                actionLevel: 200,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'end_test_plan@test_plan',
                tooltip: '结束测试',
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-dot-circle-o',
                  glyph: 'xf192@FontAwesome',
                },
                id: 'u8dd3442',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '编辑',
                detailType: 'DEUIACTION',
                uiactionId: 'open_update_view@test_plan',
                showCaption: true,
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-edit',
                  glyph: 'xf044@FontAwesome',
                },
                id: 'uf8d2086',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '删除',
                detailType: 'DEUIACTION',
                uiactionId: 'delete_test_plan@test_plan',
                showCaption: true,
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-trash-o',
                  glyph: 'xf014@FontAwesome',
                },
                id: 'u405a462',
              },
            ],
            appDataEntityId: 'plmweb.test_plan',
            uniqueTag: 'test_plan__Usr1220152730',
            name: '主表格操作列',
            id: 'usr1220152730',
          },
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '计划名称',
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
          dataItemName: 'type',
          excelCaption: '测试分类',
          appCodeListId: 'plmweb.testmgmt__test_plan_type',
          appDEFieldId: 'type',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '测试分类',
          codeName: 'type',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'type',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'status',
          excelCaption: '状态',
          appCodeListId: 'plmweb.testmgmt__test_plan_status',
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
          clconvertMode: 'NONE',
          dataItemName: 'assignee_name',
          excelCaption: '负责人',
          appDEFieldId: 'assignee_name',
          valueType: 'SIMPLE',
          enableRowEdit: true,
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '负责人',
          codeName: 'assignee_name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'assignee_name',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'start_at',
          excelCaption: '计划开始',
          appDEFieldId: 'start_at',
          valueFormat: 'YYYY-MM-DD',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '计划开始',
          codeName: 'start_at',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'start_at',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'end_at',
          excelCaption: '计划结束',
          appDEFieldId: 'end_at',
          valueFormat: 'YYYY-MM-DD',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '计划结束',
          codeName: 'end_at',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'end_at',
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
          hideMode: 1,
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'PX',
          enableSort: true,
          hideDefault: true,
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
          hideMode: 1,
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          hideDefault: true,
          id: 'update_time',
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
          hideMode: 1,
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'PX',
          enableSort: true,
          hideDefault: true,
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
          hideMode: 1,
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          hideDefault: true,
          id: 'create_time',
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
          appDEFieldId: 'status',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'status',
        },
        {
          appDEFieldId: 'assignee_name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'assignee_name',
        },
        {
          format: 'YYYY-MM-DD',
          appDEFieldId: 'start_at',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'start_at',
        },
        {
          format: 'YYYY-MM-DD',
          appDEFieldId: 'end_at',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'end_at',
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
          appDEFieldId: 'assignee_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'assignee_id',
        },
        {
          appDEFieldId: 'project_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'project_id',
        },
        {
          appDEFieldId: 'project_type',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'project_type',
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
          appDEFieldId: 'library_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'library_id',
        },
        {
          appDEFieldId: 'sprint_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'sprint_id',
        },
        {
          appDEFieldId: 'release_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'release_id',
        },
        {
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfmajortext',
        },
        {
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfmstag',
        },
      ],
      degridEditItems: [
        {
          caption: '负责人',
          codeName: 'assignee_name',
          enableCond: 3,
          appDEFieldId: 'assignee_name',
          editor: {
            singleSelect: true,
            enableAC: true,
            forceSelection: true,
            showTrigger: true,
            editorParams: {
              'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
              AC: 'TRUE',
              readonly: 'true',
              'SRFNAVPARAM.n_status_eq': '1',
              TRIGGER: 'TRUE',
              URL: 'projects/${context.project}/project_members/fetch_default',
              PICKUPVIEW: 'FALSE',
              USERMETHOD: 'post',
              USERMAP: '{"id":"user_id","name":"name"}',
              DEPTMAP: '{"id":"id","name":"display_name"}',
              DEPTMETHOD: 'get',
              DEPTURL: '/users/fetch_default',
            },
            editorStyle: 'PERSONEL_SELECT_PROJECT',
            editorType: 'PICKEREX_TRIGGER',
            sysPFPluginId: 'person_select',
            valueType: 'SIMPLE',
            editable: true,
            readOnly: true,
            navigateParams: [
              {
                key: 'n_department_id_eq',
                value: 'srforgsectorid',
                id: 'n_department_id_eq',
              },
              {
                key: 'n_status_eq',
                value: '1',
                rawValue: true,
                id: 'n_status_eq',
              },
            ],
            id: 'assignee_name',
          },
          allowEmpty: true,
          id: 'assignee_name',
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
      pagingMode: 1,
      pagingSize: 20,
      sortMode: 'REMOTE',
      enableCustomized: true,
      enablePagingBar: true,
      navViewPos: 'NONE',
      fetchControlAction: {
        appDEMethodId: 'fetch_default',
        appDataEntityId: 'plmweb.test_plan',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.test_plan',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'main',
      controlType: 'GRID',
      logicName: '主表格',
      appDataEntityId: 'plmweb.test_plan',
      controlLogics: [
        {
          eventNames: 'onLoadSuccess',
          logicTag: 'grid',
          logicType: 'APPDEUILOGIC',
          appDEUILogicId: 'calc_column_action_state',
          appDataEntityId: 'plmweb.test_plan',
          triggerType: 'CTRLEVENT',
          id: 'calc_button_state',
        },
      ],
      controlParam: {
        id: 'grid',
      },
      modelId: '9c274f421be8ffeaed6131edd5a89415',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.test_plan.main',
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
            lanResTag: 'CONTROL.DEFORM.TEST_PLAN.DEFAULT.FORMPAGE.FORMPAGE1',
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
      appDataEntityId: 'plmweb.test_plan',
      controlParam: {
        id: 'searchform',
      },
      modelId: '2e03f13dbf080a0ac507fdf67dfaf6c4',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.test_plan.default',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.test_plan',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.TEST_PLAN',
      },
      caption: '测试计划',
      codeName: 'pick_up_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.test_plan',
      controlParam: {},
      name: 'captionbar',
      id: 'pick_up_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEPICKUPGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.test_plan',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '测试计划选择表格视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.TEST_PLAN.PICKUPGRIDVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEPICKUPGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '909455f6896c08ca07e550864272cb6b',
  modelType: 'PSAPPDEVIEW',
  name: 'test_planPickupGridView',
  id: 'plmweb.test_plan_pick_up_grid_view',
};
