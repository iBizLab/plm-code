export default {
  gridRowActiveMode: 1,
  expandSearchForm: true,
  pickupMode: true,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'program_pickup_grid_view',
  deviewId: '230dd82978b9973909bbcd0def2208a6',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPRINT',
  },
  caption: '迭代',
  codeName: 'sprint_program_pickup_grid_view',
  appDataEntityId: 'plmweb.sprint',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'PickupGridView',
      id: 'engine',
    },
  ],
  appViewNavParams: [
    {
      key: 'project',
      value: 'project',
      id: 'project',
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
          excelCaption: '迭代名称',
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '迭代名称',
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
          appCodeListId: 'plmweb.projmgmt__sprint_status',
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
          enableRowEdit: true,
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
          dataItemName: 'start_at',
          excelCaption: '开始时间',
          appDEFieldId: 'start_at',
          valueFormat: 'YYYY-MM-DD',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '开始时间',
          codeName: 'start_at',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'start_at',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'end_at',
          excelCaption: '结束时间',
          appDEFieldId: 'end_at',
          valueFormat: 'YYYY-MM-DD',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '结束时间',
          codeName: 'end_at',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
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
        {
          clconvertMode: 'NONE',
          dataItemName: 'schedule',
          excelCaption: '进度',
          appDEFieldId: 'schedule',
          valueType: 'SIMPLE',
          enableRowEdit: true,
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '进度',
          codeName: 'schedule',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          id: 'schedule',
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
          appDEFieldId: 'schedule',
          valueType: 'SIMPLE',
          dataType: 6,
          id: 'schedule',
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
          appDEFieldId: 'project_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'project_id',
        },
        {
          appDEFieldId: 'pid',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'pid',
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
            appDEACModeId: 'member_select',
            appDEDataSetId: 'fetch_default',
            appDataEntityId: 'plmweb.project_member',
            uiactionGroup: {
              uiactionGroupDetails: [
                {
                  actionLevel: 100,
                  afterItemType: 'NONE',
                  beforeItemType: 'NONE',
                  caption: '跳转至成员设置',
                  detailType: 'DEUIACTION',
                  uiactionId: 'jump_to_member_set@project_member',
                  tooltip: '跳转至成员设置',
                  showCaption: true,
                  showIcon: true,
                  sysImage: {
                    cssClass: 'fa fa-user-md',
                    glyph: 'xf0f0@FontAwesome',
                  },
                  id: 'uc5eeb4c',
                },
              ],
              appDataEntityId: 'plmweb.project_member',
              uniqueTag: 'project_member__Usr0104465165',
              name: '跳转至成员配置',
              id: 'usr0104465165',
            },
            enableAC: true,
            forceSelection: true,
            showTrigger: true,
            valueItemName: 'ASSIGNEE_ID',
            editorParams: {
              'SRFNAVPARAM.n_project_id_eq': '%project%',
              'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
              AC: 'TRUE',
              readonly: 'true',
              'SRFNAVCTX.project': '%project%',
              TRIGGER: 'TRUE',
              URL: 'projects/${context.project}/project_members/fetchdefault',
              PICKUPVIEW: 'FALSE',
              USERMETHOD: 'post',
              USERMAP: '{"id":"user_id","name":"name"}',
              DEPTMETHOD: 'get',
              DEPTMAP: '{"id":"id","name":"display_name"}',
              DEPTURL: '/users/fetchdefault',
            },
            editorStyle: 'PERSONEL_SELECT',
            editorType: 'PICKEREX_TRIGGER',
            editorItems: [{}],
            sysPFPluginId: 'person_select',
            valueType: 'SIMPLE',
            editable: true,
            readOnly: true,
            navigateContexts: [
              {
                key: 'PROJECT',
                value: 'project',
                name: 'PROJECT',
                id: 'project',
              },
            ],
            navigateParams: [
              {
                key: 'n_project_id_eq',
                value: 'project',
                id: 'n_project_id_eq',
              },
              {
                key: 'n_department_id_eq',
                value: 'srforgsectorid',
                id: 'n_department_id_eq',
              },
            ],
            id: 'assignee_name',
          },
          allowEmpty: true,
          id: 'assignee_name',
        },
        {
          caption: '进度',
          codeName: 'schedule',
          enableCond: 3,
          appDEFieldId: 'schedule',
          editor: {
            stepValue: 1,
            editorParams: {
              readonly: 'true',
              showText: 'true',
            },
            editorType: 'SLIDER',
            valueType: 'SIMPLE',
            editable: true,
            readOnly: true,
            id: 'schedule',
          },
          allowEmpty: true,
          id: 'schedule',
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
        {
          enableCond: 3,
          appDEFieldId: 'assignee_id',
          editor: {
            editorType: 'HIDDEN',
            valueType: 'SIMPLE',
            editable: true,
          },
          allowEmpty: true,
          id: 'assignee_id',
        },
      ],
      pagingMode: 1,
      pagingSize: 20,
      sortMode: 'REMOTE',
      enableCustomized: true,
      enablePagingBar: true,
      navViewPos: 'NONE',
      fetchControlAction: {
        appDEMethodId: 'fetch_all',
        appDataEntityId: 'plmweb.sprint',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.sprint',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'program_sprint',
      controlType: 'GRID',
      logicName: '规划计划的迭代表格',
      appDataEntityId: 'plmweb.sprint',
      controlLogics: [
        {
          eventNames: 'onLoadSuccess',
          logicTag: 'grid',
          logicType: 'APPDEUILOGIC',
          appDEUILogicId: 'cal_schedule',
          appDataEntityId: 'plmweb.sprint',
          triggerType: 'CTRLEVENT',
          id: 'cal_schedule',
        },
      ],
      controlParam: {
        id: 'grid',
      },
      modelId: '2bfbebe1f5795d35062ca3a31f2885d3',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.sprint.program_sprint',
    },
    {
      searchButtonStyle: 'DEFAULT',
      deformPages: [
        {
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          deformDetails: [
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'NONE',
              noPrivDisplayMode: 1,
              appDEFieldId: 'name',
              editor: {
                editorType: 'TEXTBOX',
                placeHolder: '请输入迭代名称',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_name_like',
              },
              allowEmpty: true,
              capLanguageRes: {
                lanResTag: 'CONTROL.DEFSFITEM.SPRINT.N_NAME_LIKE',
              },
              caption: '名称(%)',
              codeName: 'n_name_like',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 8,
                colMD: 8,
                layout: 'TABLE_24COL',
              },
              id: 'n_name_like',
            },
          ],
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
      codeName: 'usr12189848_search_form',
      controlType: 'SEARCHFORM',
      logicName: '迭代实体数据选择视图（选择关系）_选择数据视图_搜索表单',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {
        id: 'searchform',
      },
      modelId: '3816d3032c6bb3b290fb704fdd31a775',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.sprint.usr12189848_search_form',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.SPRINT',
      },
      caption: '迭代',
      codeName: 'program_pickup_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {},
      name: 'captionbar',
      id: 'program_pickup_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEPICKUPGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.sprint',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '规划计划的迭代表格视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEPICKUPGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '12214362cd035e1beeccc0330130b7e8',
  modelType: 'PSAPPDEVIEW',
  name: 'sprintprogram_pickup_grid_view',
  id: 'plmweb.sprint_program_pickup_grid_view',
};
