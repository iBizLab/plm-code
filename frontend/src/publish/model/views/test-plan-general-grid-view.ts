export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'general_grid_view',
  deviewId: '5ce9a155546f6afb0991ec66b6807e59',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TEST_PLAN',
  },
  caption: '普通测试',
  codeName: 'test_plan_general_grid_view',
  appDataEntityId: 'plmweb.test_plan',
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
          refAppViewId: 'plmweb.test_plan_quick_create_view',
        },
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.test_plan_quick_create_view',
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
          refAppViewId: 'plmweb.test_plan_main_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.test_plan_main_view',
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
      realTitle: '测试计划',
      refAppViewId: 'plmweb.test_plan_main_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realOpenMode: 'POPUPMODAL',
      realTitle: '新建测试计划',
      refAppViewId: 'plmweb.test_plan_quick_create_view',
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
          uiactionId: 'new_subdata',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.*.NEW',
          },
          caption: '新建计划',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-plus',
            glyph: 'xf067@FontAwesome',
          },
          tooltip: '新建计划',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.*.NEW',
          },
          showCaption: true,
          showIcon: true,
          id: 'deuiaction1',
        },
      ],
      xdataControlName: 'grid',
      codeName: 'general_grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '新建计划',
      appDataEntityId: 'plmweb.test_plan',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '0d4ce6c20e2b972b3be01a298df124b9',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'general_grid_view_toolbar',
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
      singleSelect: true,
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
      enableItemPrivilege: true,
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
      groupMode: 'SINGLE',
      searchBarFilters: [
        {
          dataType: 25,
          labelPos: 'NONE',
          editor: {
            singleSelect: true,
            appCodeListId: 'plmweb.testmgmt__test_plan_status',
            editorType: 'DROPDOWNLIST',
            valueType: 'SIMPLE',
            editable: true,
            id: 'status',
          },
          allowEmpty: true,
          needCodeListConfig: true,
          itemType: 'FILTER',
          appDEFieldId: 'status',
          id: 'status',
        },
        {
          dataType: 25,
          labelPos: 'NONE',
          defsearchMode: {
            codeName: 'N_ASSIGNEE_ID_IN',
            stdDataType: 25,
            valueOP: 'IN',
            name: 'N_ASSIGNEE_ID_IN',
            id: 'n_assignee_id_in',
          },
          editor: {
            singleSelect: true,
            enableAC: true,
            forceSelection: true,
            showTrigger: true,
            valueItemName: 'assignee_id',
            editorParams: {
              ISADDSYMBOL: 'true',
              MULTIPLE: 'true',
              'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
              AC: 'TRUE',
              TRIGGER: 'TRUE',
              URL: 'libraries/${context.library}/library_members/fetch_default',
              PICKUPVIEW: 'FALSE',
              USERMETHOD: 'post',
              USERMAP: '{"id":"user_id","name":"name"}',
              DEPTMAP: '{"id":"id","name":"display_name"}',
              DEPTMETHOD: 'get',
              DEPTURL: '/users/fetch_default',
            },
            editorStyle: 'PERSONEL_SELECT_LIBRARY',
            editorType: 'PICKEREX_TRIGGER',
            sysPFPluginId: 'person_select',
            valueType: 'SIMPLE',
            editable: true,
            navigateParams: [
              {
                key: 'n_department_id_eq',
                value: 'srforgsectorid',
                id: 'n_department_id_eq',
              },
            ],
            id: 'assignee_in',
          },
          allowEmpty: true,
          caption: '负责人',
          itemType: 'FILTER',
          appDEFieldId: 'assignee_id',
          id: 'assignee_in',
        },
        {
          dataType: 25,
          labelPos: 'NONE',
          defsearchMode: {
            codeName: 'N_ASSIGNEE_ID_NOTIN',
            stdDataType: 25,
            valueOP: 'NOTIN',
            name: 'N_ASSIGNEE_ID_NOTIN',
            id: 'n_assignee_id_notin',
          },
          editor: {
            singleSelect: true,
            enableAC: true,
            forceSelection: true,
            showTrigger: true,
            valueItemName: 'assignee_id',
            editorParams: {
              ISADDSYMBOL: 'true',
              MULTIPLE: 'true',
              'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
              AC: 'TRUE',
              TRIGGER: 'TRUE',
              URL: 'libraries/${context.library}/library_members/fetch_default',
              PICKUPVIEW: 'FALSE',
              USERMETHOD: 'post',
              USERMAP: '{"id":"user_id","name":"name"}',
              DEPTMAP: '{"id":"id","name":"display_name"}',
              DEPTMETHOD: 'get',
              DEPTURL: '/users/fetch_default',
            },
            editorStyle: 'PERSONEL_SELECT_LIBRARY',
            editorType: 'PICKEREX_TRIGGER',
            sysPFPluginId: 'person_select',
            valueType: 'SIMPLE',
            editable: true,
            navigateParams: [
              {
                key: 'n_department_id_eq',
                value: 'srforgsectorid',
                id: 'n_department_id_eq',
              },
            ],
            id: 'assignee_not_in',
          },
          allowEmpty: true,
          caption: '负责人',
          itemType: 'FILTER',
          appDEFieldId: 'assignee_id',
          id: 'assignee_not_in',
        },
        {
          dataType: 25,
          labelPos: 'NONE',
          defsearchMode: {
            codeName: 'N_ASSIGNEE_ID_EQ',
            stdDataType: 25,
            valueOP: 'EQ',
            name: 'N_ASSIGNEE_ID_EQ',
            id: 'n_assignee_id_eq',
          },
          editor: {
            singleSelect: true,
            enableAC: true,
            forceSelection: true,
            showTrigger: true,
            valueItemName: 'assignee_id',
            editorParams: {
              'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
              AC: 'TRUE',
              TRIGGER: 'TRUE',
              URL: 'libraries/${context.library}/library_members/fetch_default',
              PICKUPVIEW: 'FALSE',
              USERMETHOD: 'post',
              USERMAP: '{"id":"user_id","name":"name"}',
              DEPTMAP: '{"id":"id","name":"display_name"}',
              DEPTMETHOD: 'get',
              DEPTURL: '/users/fetch_default',
            },
            editorStyle: 'PERSONEL_SELECT_LIBRARY',
            editorType: 'PICKEREX_TRIGGER',
            sysPFPluginId: 'person_select',
            valueType: 'SIMPLE',
            editable: true,
            navigateParams: [
              {
                key: 'n_department_id_eq',
                value: 'srforgsectorid',
                id: 'n_department_id_eq',
              },
            ],
            id: 'assignee_eq',
          },
          allowEmpty: true,
          caption: '负责人',
          itemType: 'FILTER',
          appDEFieldId: 'assignee_id',
          id: 'assignee_eq',
        },
        {
          dataType: 25,
          labelPos: 'NONE',
          defsearchMode: {
            codeName: 'N_ASSIGNEE_ID_ISNULL',
            stdDataType: 25,
            valueOP: 'ISNULL',
            name: 'N_ASSIGNEE_ID_ISNULL',
            id: 'n_assignee_id_isnull',
          },
          editor: {
            editorType: 'TEXTBOX',
            valueType: 'SIMPLE',
            editable: true,
            id: 'assignee_isnull',
          },
          allowEmpty: true,
          convertToCodeItemText: true,
          caption: '负责人',
          itemType: 'FILTER',
          appDEFieldId: 'assignee_id',
          id: 'assignee_isnull',
        },
        {
          dataType: 25,
          labelPos: 'NONE',
          defsearchMode: {
            codeName: 'N_ASSIGNEE_ID_ISNOTNULL',
            stdDataType: 25,
            valueOP: 'ISNOTNULL',
            name: 'N_ASSIGNEE_ID_ISNOTNULL',
            id: 'n_assignee_id_isnotnull',
          },
          editor: {
            editorType: 'TEXTBOX',
            valueType: 'SIMPLE',
            editable: true,
            id: 'assignee_notnull',
          },
          allowEmpty: true,
          convertToCodeItemText: true,
          caption: '负责人标识(NotNil)',
          itemType: 'FILTER',
          appDEFieldId: 'assignee_id',
          id: 'assignee_notnull',
        },
        {
          dataType: 25,
          labelPos: 'NONE',
          defsearchMode: {
            codeName: 'N_CREATE_MAN_EQ',
            stdDataType: 25,
            valueOP: 'EQ',
            name: 'N_CREATE_MAN_EQ',
            id: 'n_create_man_eq',
          },
          editor: {
            singleSelect: true,
            enableAC: true,
            forceSelection: true,
            showTrigger: true,
            valueItemName: 'create_man',
            editorParams: {
              'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
              AC: 'TRUE',
              TRIGGER: 'TRUE',
              URL: 'libraries/${context.library}/library_members/fetch_default',
              PICKUPVIEW: 'FALSE',
              USERMETHOD: 'post',
              USERMAP: '{"id":"user_id","name":"name"}',
              DEPTMAP: '{"id":"id","name":"display_name"}',
              DEPTMETHOD: 'get',
              DEPTURL: '/users/fetch_default',
            },
            editorStyle: 'PERSONEL_SELECT_LIBRARY',
            editorType: 'PICKEREX_TRIGGER',
            sysPFPluginId: 'person_select',
            valueType: 'SIMPLE',
            editable: true,
            navigateParams: [
              {
                key: 'n_department_id_eq',
                value: 'srforgsectorid',
                id: 'n_department_id_eq',
              },
            ],
            id: 'create_man_eq',
          },
          allowEmpty: true,
          caption: '创建人',
          itemType: 'FILTER',
          appDEFieldId: 'create_man',
          id: 'create_man_eq',
        },
        {
          dataType: 25,
          labelPos: 'NONE',
          defsearchMode: {
            codeName: 'N_CREATE_MAN_IN',
            stdDataType: 25,
            valueOP: 'IN',
            name: 'N_CREATE_MAN_IN',
            id: 'n_create_man_in',
          },
          editor: {
            singleSelect: true,
            enableAC: true,
            forceSelection: true,
            showTrigger: true,
            valueItemName: 'create_man',
            editorParams: {
              ISADDSYMBOL: 'true',
              MULTIPLE: 'true',
              'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
              AC: 'TRUE',
              TRIGGER: 'TRUE',
              URL: 'libraries/${context.library}/library_members/fetch_default',
              PICKUPVIEW: 'FALSE',
              USERMETHOD: 'post',
              USERMAP: '{"id":"user_id","name":"name"}',
              DEPTMAP: '{"id":"id","name":"display_name"}',
              DEPTMETHOD: 'get',
              DEPTURL: '/users/fetch_default',
            },
            editorStyle: 'PERSONEL_SELECT_LIBRARY',
            editorType: 'PICKEREX_TRIGGER',
            sysPFPluginId: 'person_select',
            valueType: 'SIMPLE',
            editable: true,
            navigateParams: [
              {
                key: 'n_department_id_eq',
                value: 'srforgsectorid',
                id: 'n_department_id_eq',
              },
            ],
            id: 'create_man_in',
          },
          allowEmpty: true,
          caption: '创建人',
          itemType: 'FILTER',
          appDEFieldId: 'create_man',
          id: 'create_man_in',
        },
        {
          dataType: 25,
          labelPos: 'NONE',
          defsearchMode: {
            codeName: 'N_CREATE_MAN_IN',
            stdDataType: 25,
            valueOP: 'IN',
            name: 'N_CREATE_MAN_IN',
            id: 'n_create_man_in',
          },
          editor: {
            singleSelect: true,
            enableAC: true,
            forceSelection: true,
            showTrigger: true,
            valueItemName: 'create_man',
            editorParams: {
              ISADDSYMBOL: 'true',
              MULTIPLE: 'true',
              'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
              AC: 'TRUE',
              TRIGGER: 'TRUE',
              URL: 'libraries/${context.library}/library_members/fetch_default',
              PICKUPVIEW: 'FALSE',
              USERMETHOD: 'post',
              USERMAP: '{"id":"user_id","name":"name"}',
              DEPTMAP: '{"id":"id","name":"display_name"}',
              DEPTMETHOD: 'get',
              DEPTURL: '/users/fetch_default',
            },
            editorStyle: 'PERSONEL_SELECT_LIBRARY',
            editorType: 'PICKEREX_TRIGGER',
            sysPFPluginId: 'person_select',
            valueType: 'SIMPLE',
            editable: true,
            navigateParams: [
              {
                key: 'n_department_id_eq',
                value: 'srforgsectorid',
                id: 'n_department_id_eq',
              },
            ],
            id: 'create_man_not_in',
          },
          allowEmpty: true,
          caption: '创建人',
          itemType: 'FILTER',
          appDEFieldId: 'create_man',
          id: 'create_man_not_in',
        },
        {
          dataType: 25,
          labelPos: 'NONE',
          defsearchMode: {
            codeName: 'N_CREATE_MAN_ISNULL',
            stdDataType: 25,
            valueOP: 'ISNULL',
            name: 'N_CREATE_MAN_ISNULL',
            id: 'n_create_man_isnull',
          },
          editor: {
            halign: 'LEFT',
            valign: 'MIDDLE',
            wrapMode: 'NOWRAP',
            appCodeListId: 'plmweb.sysoperator',
            editorType: 'SPAN',
            valueType: 'SIMPLE',
            editable: true,
            id: 'create_man_isnull',
          },
          allowEmpty: true,
          convertToCodeItemText: true,
          caption: '创建人',
          itemType: 'FILTER',
          appDEFieldId: 'create_man',
          id: 'create_man_isnull',
        },
        {
          dataType: 25,
          labelPos: 'NONE',
          defsearchMode: {
            codeName: 'N_CREATE_MAN_ISNOTNULL',
            stdDataType: 25,
            valueOP: 'ISNOTNULL',
            name: 'N_CREATE_MAN_ISNOTNULL',
            id: 'n_create_man_isnotnull',
          },
          editor: {
            halign: 'LEFT',
            valign: 'MIDDLE',
            wrapMode: 'NOWRAP',
            appCodeListId: 'plmweb.sysoperator',
            editorType: 'SPAN',
            valueType: 'SIMPLE',
            editable: true,
            id: 'create_notnull',
          },
          allowEmpty: true,
          convertToCodeItemText: true,
          caption: '建立人(NotNil)',
          itemType: 'FILTER',
          appDEFieldId: 'create_man',
          id: 'create_notnull',
        },
      ],
      quickSearchMode: 1,
      searchBarStyle: 'SEARCHBAR2',
      enableFilter: true,
      enableQuickSearch: true,
      codeName: 'usr0204427021',
      controlType: 'SEARCHBAR',
      logicName: '测试计划',
      appDataEntityId: 'plmweb.test_plan',
      controlParam: {
        id: 'searchbar',
      },
      modelId: '0beec61e35014502963147dd1dbc0615',
      modelType: 'PSSYSSEARCHBAR',
      name: 'searchbar',
      id: 'plmweb.test_plan.usr0204427021',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.TEST_PLAN',
      },
      caption: '普通测试',
      codeName: 'general_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.test_plan',
      controlParam: {},
      name: 'captionbar',
      id: 'general_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.test_plan',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '普通测试',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'e88743f8f717b80640621a94e8118098',
  modelType: 'PSAPPDEVIEW',
  name: 'test_plangeneral_grid_view',
  id: 'plmweb.test_plan_general_grid_view',
};