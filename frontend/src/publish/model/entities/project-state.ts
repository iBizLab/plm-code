export default {
  appDEFields: [
    {
      codeName: 'sequence',
      logicName: '序号',
      stdDataType: 6,
      name: 'SEQUENCE',
      id: 'sequence',
    },
    {
      codeName: 'is_system',
      logicName: '是否系统类型',
      stdDataType: 9,
      name: 'IS_SYSTEM',
      id: 'is_system',
    },
    {
      codeName: 'color',
      logicName: '字体颜色',
      stdDataType: 25,
      stringLength: 100,
      name: 'COLOR',
      id: 'color',
    },
    {
      codeName: 'style',
      logicName: '背景样式',
      stdDataType: 25,
      stringLength: 100,
      name: 'STYLE',
      id: 'style',
    },
    {
      codeName: 'type',
      logicName: '状态类别',
      stdDataType: 25,
      stringLength: 60,
      name: 'TYPE',
      id: 'type',
    },
    {
      codeName: 'id',
      lnlanguageRes: {
        lanResTag: 'DEF.LNAME.ID',
      },
      logicName: '标识',
      stdDataType: 25,
      stringLength: 100,
      name: 'ID',
      id: 'id',
    },
    {
      codeName: 'name',
      lnlanguageRes: {
        lanResTag: 'DEF.LNAME.NAME',
      },
      logicName: '状态名称',
      stdDataType: 25,
      stringLength: 200,
      enableQuickSearch: true,
      name: 'NAME',
      id: 'name',
    },
    {
      codeName: 'create_man',
      lnlanguageRes: {
        lanResTag: 'DEF.LNAME.CREATE_MAN',
      },
      logicName: '建立人',
      stdDataType: 25,
      stringLength: 100,
      name: 'CREATE_MAN',
      id: 'create_man',
    },
    {
      codeName: 'create_time',
      lnlanguageRes: {
        lanResTag: 'DEF.LNAME.CREATE_TIME',
      },
      logicName: '建立时间',
      stdDataType: 5,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
      name: 'CREATE_TIME',
      id: 'create_time',
    },
    {
      codeName: 'update_man',
      lnlanguageRes: {
        lanResTag: 'DEF.LNAME.UPDATE_MAN',
      },
      logicName: '更新人',
      stdDataType: 25,
      stringLength: 100,
      name: 'UPDATE_MAN',
      id: 'update_man',
    },
    {
      codeName: 'update_time',
      lnlanguageRes: {
        lanResTag: 'DEF.LNAME.UPDATE_TIME',
      },
      logicName: '更新时间',
      stdDataType: 5,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
      name: 'UPDATE_TIME',
      id: 'update_time',
    },
  ],
  appDELogics: [
    {
      codeName: 'nothing',
      defaultParamName: 'Default',
      logicName: '无操作',
      logicSubType: 'NONE',
      delogicNodes: [
        {
          codeName: 'Begin',
          leftPos: 200,
          logicNodeType: 'BEGIN',
          topPos: 200,
          parallelOutput: true,
          name: '开始',
          id: 'begin',
        },
      ],
      delogicParams: [
        {
          codeName: 'Default',
          default: true,
          entityParam: true,
          paramAppDataEntityId: 'plmweb.project_state',
          name: '传入变量',
          id: 'default',
        },
      ],
      startDELogicNodeId: 'begin',
      valid: true,
      name: '无操作',
      id: 'nothing',
    },
  ],
  appDEMethodDTOs: [
    {
      codeName: 'project_state_dto',
      appDEMethodDTOFields: [
        {
          codeName: 'sequence',
          logicName: '序号',
          appDEFieldId: 'sequence',
          sourceType: 'DEFIELD',
          stdDataType: 6,
          type: 'SIMPLE',
          id: 'sequence',
        },
        {
          codeName: 'is_system',
          logicName: '是否系统类型',
          appDEFieldId: 'is_system',
          sourceType: 'DEFIELD',
          stdDataType: 9,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'is_system',
        },
        {
          codeName: 'color',
          logicName: '字体颜色',
          appDEFieldId: 'color',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'color',
        },
        {
          codeName: 'style',
          logicName: '背景样式',
          appDEFieldId: 'style',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'style',
        },
        {
          codeName: 'type',
          logicName: '状态类别',
          appDEFieldId: 'type',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'type',
        },
        {
          codeName: 'create_man',
          logicName: '建立人',
          appDEFieldId: 'create_man',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          id: 'create_man',
        },
        {
          codeName: 'create_time',
          jsonFormat: 'yyyy-MM-dd HH:mm:ss',
          logicName: '建立时间',
          appDEFieldId: 'create_time',
          sourceType: 'DEFIELD',
          stdDataType: 5,
          type: 'SIMPLE',
          id: 'create_time',
        },
        {
          codeName: 'id',
          logicName: '标识',
          appDEFieldId: 'id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          id: 'id',
        },
        {
          codeName: 'name',
          logicName: '状态名称',
          appDEFieldId: 'name',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          id: 'name',
        },
        {
          codeName: 'update_man',
          logicName: '更新人',
          appDEFieldId: 'update_man',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          id: 'update_man',
        },
        {
          codeName: 'update_time',
          jsonFormat: 'yyyy-MM-dd HH:mm:ss',
          logicName: '更新时间',
          appDEFieldId: 'update_time',
          sourceType: 'DEFIELD',
          stdDataType: 5,
          type: 'SIMPLE',
          id: 'update_time',
        },
      ],
      sourceType: 'DE',
      type: 'DEFAULT',
      id: 'project_state_dto',
    },
    {
      codeName: 'project_state_filter_dto',
      appDEMethodDTOFields: [
        {
          codeName: 'n_id_eq',
          logicName: '标识',
          appDEFieldId: 'id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_id_eq',
        },
        {
          codeName: 'n_name_like',
          logicName: '状态名称',
          appDEFieldId: 'name',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_name_like',
        },
        {
          codeName: 'n_type_eq',
          logicName: '状态类别',
          appDEFieldId: 'type',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_type_eq',
        },
      ],
      sourceType: 'DE',
      type: 'DEFILTER',
      id: 'project_state_filter_dto',
    },
  ],
  appDEMethods: [
    {
      codeName: 'check_key',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'project_state_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        stdDataType: 9,
        type: 'SIMPLE',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/check_key',
      actionMode: 'CHECKKEY',
      actionTag: 'CheckKey',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'CheckKey',
      id: 'check_key',
    },
    {
      codeName: 'create',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'project_state_dto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'project_state_dto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      noServiceCodeName: true,
      actionMode: 'CREATE',
      actionTag: 'Create',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Create',
      id: 'create',
    },
    {
      codeName: 'get',
      methodType: 'DEACTION',
      appDEMethodInput: {
        keyAppDEFieldId: 'id',
        type: 'KEYFIELD',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'project_state_dto',
        type: 'DTO',
        id: '返回对象',
      },
      requestField: 'ID',
      requestMethod: 'GET',
      requestParamType: 'FIELD',
      needResourceKey: true,
      noServiceCodeName: true,
      actionMode: 'READ',
      actionTag: 'Get',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Get',
      id: 'get',
    },
    {
      codeName: 'get_draft',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'project_state_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'project_state_dto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'GET',
      requestParamType: 'NONE',
      requestPath: '/get_draft',
      actionMode: 'GETDRAFT',
      actionTag: 'GetDraft',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'GetDraft',
      id: 'get_draft',
    },
    {
      codeName: 'move_order',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'project_state_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'project_state_dto',
        type: 'DTOS',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/move_order',
      needResourceKey: true,
      actionMode: 'MOVEORDER',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      id: 'move_order',
    },
    {
      codeName: 'remove',
      methodType: 'DEACTION',
      appDEMethodInput: {
        keyAppDEFieldId: 'id',
        type: 'KEYFIELDS',
        id: '输入对象',
      },
      appDEMethodReturn: {
        type: 'VOID',
        id: '返回对象',
      },
      requestField: 'ID',
      requestMethod: 'DELETE',
      requestParamType: 'FIELD',
      needResourceKey: true,
      noServiceCodeName: true,
      actionMode: 'DELETE',
      actionTag: 'Remove',
      actionType: 'REMOTE',
      batchActionMode: 1,
      enableBatchAction: true,
      dataSetType: 'REMOTE',
      name: 'Remove',
      id: 'remove',
    },
    {
      codeName: 'save',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'project_state_dto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'project_state_dto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/save',
      actionMode: 'SAVE',
      actionTag: 'Save',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Save',
      id: 'save',
    },
    {
      codeName: 'update',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'project_state_dto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'project_state_dto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'PUT',
      requestParamType: 'ENTITY',
      needResourceKey: true,
      noServiceCodeName: true,
      actionMode: 'UPDATE',
      actionTag: 'Update',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Update',
      id: 'update',
    },
    {
      codeName: 'fetch_default',
      methodType: 'FETCH',
      appDEMethodInput: {
        appDEMethodDTOId: 'project_state_filter_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'project_state_dto',
        type: 'PAGE',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/fetch_default',
      actionType: 'REMOTE',
      dataSetName: 'DEFAULT',
      dataSetTag: 'Default',
      dataSetType: 'REMOTE',
      id: 'fetch_default',
    },
    {
      codeName: 'FilterCreate',
      methodType: 'FILTERACTION',
      builtinMethod: true,
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'FILTERCREATE',
      id: 'filtercreate',
    },
    {
      codeName: 'FilterFetch',
      methodType: 'FILTERACTION',
      builtinMethod: true,
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'FILTERFETCH',
      id: 'filterfetch',
    },
    {
      codeName: 'FilterGet',
      methodType: 'FILTERACTION',
      builtinMethod: true,
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'FILTERGET',
      id: 'filterget',
    },
    {
      codeName: 'FilterGetDraft',
      methodType: 'FILTERACTION',
      builtinMethod: true,
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'FILTERGETDRAFT',
      id: 'filtergetdraft',
    },
    {
      codeName: 'FilterRemove',
      methodType: 'FILTERACTION',
      builtinMethod: true,
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'FILTERREMOVE',
      id: 'filterremove',
    },
    {
      codeName: 'FilterSearch',
      methodType: 'FILTERACTION',
      builtinMethod: true,
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'FILTERSEARCH',
      id: 'filtersearch',
    },
    {
      codeName: 'FilterUpdate',
      methodType: 'FILTERACTION',
      builtinMethod: true,
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'FILTERUPDATE',
      id: 'filterupdate',
    },
  ],
  appDEUIActions: [
    {
      actionLevel: 100,
      actionTarget: 'SINGLEKEY',
      caption: '编辑',
      codeName: 'edit_pro_state',
      frontAppViewId: 'plmweb.project_state_quick_create_option_view',
      frontProcessType: 'WIZARD',
      fullCodeName: 'project_state_edit_pro_state',
      sysImage: {
        cssClass: 'fa fa-edit',
        glyph: 'xf044@FontAwesome',
      },
      tooltip: '编辑',
      uiactionMode: 'FRONT',
      uiactionTag: 'edit_pro_state',
      uiactionType: 'DEUIACTION',
      showBusyIndicator: true,
      noPrivDisplayMode: 2,
      appDataEntityId: 'plmweb.project_state',
      name: '编辑项目状态',
      id: 'edit_pro_state@project_state',
    },
    {
      actionLevel: 100,
      actionTarget: 'SINGLEKEY',
      caption: '删除',
      codeName: 'remove_pro_state',
      confirmMsg: '确认删除该状态?',
      fullCodeName: 'project_state_remove_pro_state',
      appDEMethodId: 'remove',
      sysImage: {
        cssClass: 'fa fa-trash-o',
        glyph: 'xf014@FontAwesome',
      },
      refreshMode: 1,
      successMsg: '删除成功',
      timeout: 60000,
      tooltip: '删除',
      uiactionMode: 'BACKEND',
      uiactionTag: 'remove_pro_state',
      uiactionType: 'DEUIACTION',
      enableConfirm: true,
      reloadData: true,
      showBusyIndicator: true,
      noPrivDisplayMode: 2,
      appDataEntityId: 'plmweb.project_state',
      name: '删除项目状态',
      id: 'remove_pro_state@project_state',
    },
  ],
  appDEUILogics: [
    {
      codeName: 'judge_column_state',
      defaultParamName: 'Default',
      logicName: '判断操作列是否禁用',
      deuilogicNodes: [
        {
          codeName: 'Begin',
          leftPos: 200,
          logicNodeType: 'BEGIN',
          deuilogicLinks: [
            {
              dstDEUILogicNodeId: 'rawjscode1',
              srcDEUILogicNodeId: 'begin',
              id: '连接名称',
            },
          ],
          topPos: 200,
          parallelOutput: true,
          name: '开始',
          id: 'begin',
        },
        {
          code: '\tconst rows = uiLogic.grid.state.rows;\r\n    console.log(rows);\r\n\tif (rows && rows.length > 0) {\r\n\t\trows.forEach(row => {\r\n\t\t\tconst is_system = row.data.is_system;\r\n\t\t\t\t\t if (is_system === 1) {\r\n\t\t\t\t\t\t// 禁用\r\n                        row.uaColStates.uagridcolumn1.visible = false;\r\n                        Object.values(row.uaColStates.uagridcolumn1).forEach(item => {\r\n                            item.visible = false;\r\n                            item.disabled = true;\r\n                        })\r\n\t\t\t\t\t} \t\r\n\t\t})\r\n\t}\r\n',
          codeName: 'RAWJSCODE1',
          leftPos: 160,
          logicNodeType: 'RAWJSCODE',
          deuilogicLinks: [
            {
              dstDEUILogicNodeId: 'end1',
              srcDEUILogicNodeId: 'rawjscode1',
              id: '连接名称',
            },
          ],
          topPos: 358,
          name: '判断操作列是否禁用',
          id: 'rawjscode1',
        },
        {
          codeName: 'END1',
          leftPos: 200,
          logicNodeType: 'END',
          topPos: 484,
          name: '结束',
          id: 'end1',
        },
      ],
      deuilogicParams: [
        {
          codeName: 'Default',
          default: true,
          entityParam: true,
          name: '传入变量',
          id: 'default',
        },
        {
          codeName: 'Grid',
          activeCtrlParam: true,
          ctrlParam: true,
          name: '表格',
          id: 'grid',
        },
      ],
      startDEUILogicNodeId: 'begin',
      name: '判断操作列是否禁用',
      id: 'judge_column_state',
    },
  ],
  deopprivs: [
    {
      logicName: '建立',
      name: 'CREATE',
      id: 'create',
    },
    {
      logicName: '删除',
      name: 'DELETE',
      id: 'delete',
    },
    {
      logicName: '读取',
      name: 'READ',
      id: 'read',
    },
    {
      logicName: '更新',
      name: 'UPDATE',
      id: 'update',
    },
  ],
  codeName: 'project_state',
  deapicodeName: 'project_state',
  deapicodeName2: 'project_states',
  deapitag: 'PROJECT_STATE',
  dataAccCtrlArch: 1,
  dataAccCtrlMode: 1,
  enableUIActions: 15,
  keyAppDEFieldId: 'id',
  lnlanguageRes: {
    lanResTag: 'DE.LNAME.PROJECT_STATE',
  },
  logicName: '项目状态',
  majorAppDEFieldId: 'name',
  quickSearchAppDEFieldIds: ['name'],
  sysAPITag: 'ServiceAPI',
  defaultMode: true,
  enableFilterActions: true,
  major: true,
  name: 'PROJECT_STATE',
  id: 'plmweb.project_state',
  codeName2: 'project_states',
  requestPaths: [],
};
