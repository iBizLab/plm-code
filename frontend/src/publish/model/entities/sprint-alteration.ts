export default {
  appDEACModes: [
    {
      actype: 'AUTOCOMPLETE',
      codeName: 'Default',
      logicName: 'DEFAULT',
      deacmodeDataItems: [
        {
          appDEFieldId: 'id',
          dataType: 25,
          id: 'value',
        },
        {
          appDEFieldId: 'name',
          dataType: 25,
          id: 'text',
        },
      ],
      pagingSize: 50,
      defaultMode: true,
      textAppDEFieldId: 'name',
      valueAppDEFieldId: 'id',
      name: 'DEFAULT',
      id: 'default',
    },
  ],
  appDEFields: [
    {
      codeName: 'is_deleted',
      logicName: '是否删除',
      stdDataType: 9,
      name: 'IS_DELETED',
      id: 'is_deleted',
    },
    {
      codeName: 'type',
      logicName: '类型',
      stdDataType: 25,
      stringLength: 100,
      name: 'TYPE',
      id: 'type',
    },
    {
      codeName: 'sprint_status',
      logicName: '迭代状态',
      stdDataType: 25,
      stringLength: 60,
      name: 'SPRINT_STATUS',
      id: 'sprint_status',
    },
    {
      codeName: 'rep_date',
      logicName: '燃尽统计日期',
      stdDataType: 5,
      valueFormat: 'YYYY-MM-DD',
      name: 'REP_DATE',
      id: 'rep_date',
    },
    {
      codeName: 'rep_value1',
      logicName: '燃尽统计数值1',
      stdDataType: 6,
      name: 'REP_VALUE1',
      id: 'rep_value1',
    },
    {
      codeName: 'rep_value2',
      logicName: '燃尽统计数值2',
      stdDataType: 6,
      name: 'REP_VALUE2',
      id: 'rep_value2',
    },
    {
      codeName: 'work_item_completed_at',
      logicName: '工作项完成时间',
      stdDataType: 5,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
      name: 'WORK_ITEM_COMPLETED_AT',
      id: 'work_item_completed_at',
    },
    {
      codeName: 'work_item_priority',
      logicName: '工作项优先级',
      stdDataType: 25,
      stringLength: 100,
      name: 'WORK_ITEM_PRIORITY',
      id: 'work_item_priority',
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
      logicName: '名称',
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
    {
      codeName: 'sprint_id',
      logicName: '迭代标识',
      stdDataType: 25,
      stringLength: 100,
      name: 'SPRINT_ID',
      id: 'sprint_id',
    },
    {
      codeName: 'work_item_id',
      logicName: '工作项标识',
      stdDataType: 25,
      stringLength: 100,
      name: 'WORK_ITEM_ID',
      id: 'work_item_id',
    },
    {
      codeName: 'work_item_title',
      logicName: '标题',
      stdDataType: 25,
      stringLength: 500,
      name: 'WORK_ITEM_TITLE',
      id: 'work_item_title',
    },
    {
      codeName: 'sprint_name',
      logicName: '名称',
      stdDataType: 25,
      stringLength: 200,
      name: 'SPRINT_NAME',
      id: 'sprint_name',
    },
  ],
  appDEMethodDTOs: [
    {
      codeName: 'sprint_alteration_dto',
      appDEMethodDTOFields: [
        {
          codeName: 'is_deleted',
          logicName: '是否删除',
          appDEFieldId: 'is_deleted',
          sourceType: 'DEFIELD',
          stdDataType: 9,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'is_deleted',
        },
        {
          codeName: 'type',
          logicName: '类型',
          appDEFieldId: 'type',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'type',
        },
        {
          codeName: 'sprint_status',
          logicName: '迭代状态',
          appDEFieldId: 'sprint_status',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'sprint_status',
        },
        {
          codeName: 'rep_date',
          jsonFormat: 'yyyy-MM-dd',
          logicName: '燃尽统计日期',
          appDEFieldId: 'rep_date',
          sourceType: 'DEFIELD',
          stdDataType: 5,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'rep_date',
        },
        {
          codeName: 'rep_value1',
          logicName: '燃尽统计数值1',
          appDEFieldId: 'rep_value1',
          sourceType: 'DEFIELD',
          stdDataType: 6,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'rep_value1',
        },
        {
          codeName: 'rep_value2',
          logicName: '燃尽统计数值2',
          appDEFieldId: 'rep_value2',
          sourceType: 'DEFIELD',
          stdDataType: 6,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'rep_value2',
        },
        {
          codeName: 'work_item_completed_at',
          jsonFormat: 'yyyy-MM-dd HH:mm:ss',
          logicName: '工作项完成时间',
          appDEFieldId: 'work_item_completed_at',
          sourceType: 'DEFIELD',
          stdDataType: 5,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'work_item_completed_at',
        },
        {
          codeName: 'work_item_priority',
          logicName: '工作项优先级',
          appDEFieldId: 'work_item_priority',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'work_item_priority',
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
          logicName: '名称',
          appDEFieldId: 'name',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'name',
        },
        {
          codeName: 'sprint_id',
          logicName: '迭代标识',
          appDEFieldId: 'sprint_id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'sprint_id',
        },
        {
          codeName: 'sprint_name',
          logicName: '名称',
          appDEFieldId: 'sprint_name',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'sprint_name',
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
        {
          codeName: 'work_item_id',
          logicName: '工作项标识',
          appDEFieldId: 'work_item_id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'work_item_id',
        },
        {
          codeName: 'work_item_title',
          logicName: '标题',
          appDEFieldId: 'work_item_title',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'work_item_title',
        },
      ],
      sourceType: 'DE',
      type: 'DEFAULT',
      id: 'sprint_alteration_dto',
    },
    {
      codeName: 'sprint_alteration_filter_dto',
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
          logicName: '名称',
          appDEFieldId: 'name',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_name_like',
        },
        {
          codeName: 'n_sprint_id_eq',
          logicName: '迭代标识',
          appDEFieldId: 'sprint_id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_sprint_id_eq',
        },
        {
          codeName: 'n_sprint_name_eq',
          logicName: '名称',
          appDEFieldId: 'sprint_name',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_sprint_name_eq',
        },
        {
          codeName: 'n_sprint_name_like',
          logicName: '名称',
          appDEFieldId: 'sprint_name',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_sprint_name_like',
        },
        {
          codeName: 'n_work_item_id_eq',
          logicName: '工作项标识',
          appDEFieldId: 'work_item_id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_work_item_id_eq',
        },
        {
          codeName: 'n_work_item_title_eq',
          logicName: '标题',
          appDEFieldId: 'work_item_title',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_work_item_title_eq',
        },
        {
          codeName: 'n_work_item_title_like',
          logicName: '标题',
          appDEFieldId: 'work_item_title',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_work_item_title_like',
        },
      ],
      sourceType: 'DE',
      type: 'DEFILTER',
      id: 'sprint_alteration_filter_dto',
    },
  ],
  appDEMethods: [
    {
      codeName: 'check_key',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'sprint_alteration_dto',
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
        appDEMethodDTOId: 'sprint_alteration_dto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'sprint_alteration_dto',
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
        appDEMethodDTOId: 'sprint_alteration_dto',
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
        appDEMethodDTOId: 'sprint_alteration_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'sprint_alteration_dto',
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
      codeName: 'rep_change',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'sprint_alteration_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'sprint_alteration_dto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/rep_change',
      actionMode: 'GETDRAFT',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      id: 'rep_change',
    },
    {
      codeName: 'save',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'sprint_alteration_dto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'sprint_alteration_dto',
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
        appDEMethodDTOId: 'sprint_alteration_dto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'sprint_alteration_dto',
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
      codeName: 'fetch_change',
      methodType: 'FETCH',
      appDEMethodInput: {
        appDEMethodDTOId: 'sprint_alteration_filter_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'sprint_alteration_dto',
        type: 'PAGE',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/fetch_change',
      actionType: 'REMOTE',
      dataSetName: 'change',
      dataSetTag: 'change',
      dataSetType: 'REMOTE',
      id: 'fetch_change',
    },
    {
      codeName: 'fetch_default',
      methodType: 'FETCH',
      appDEMethodInput: {
        appDEMethodDTOId: 'sprint_alteration_filter_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'sprint_alteration_dto',
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
  codeName: 'sprint_alteration',
  deapicodeName: 'sprint_alteration',
  deapicodeName2: 'sprint_alterations',
  deapitag: 'SPRINT_ALTERATION',
  dataAccCtrlArch: 1,
  dataAccCtrlMode: 2,
  enableUIActions: 15,
  keyAppDEFieldId: 'id',
  lnlanguageRes: {
    lanResTag: 'DE.LNAME.SPRINT_ALTERATION',
  },
  logicName: '迭代变更',
  majorAppDEFieldId: 'name',
  minorAppDERSs: [
    {
      actionRSMode: 1,
      codeName: 'sprint_alterations',
      majorAppDataEntityId: 'plmweb.sprint',
      parentAppDEFieldId: 'sprint_id',
      rsmode: 2,
      name: 'DER1N_SPRINT_ALTERATION_SPRINT_SPRINT_ID',
      id: 'sprint_alterations',
    },
    {
      actionRSMode: 1,
      codeName: 'sprint_alterations',
      majorAppDataEntityId: 'plmweb.work_item',
      parentAppDEFieldId: 'work_item_id',
      rsmode: 2,
      name: 'DER1N_SPRINT_ALTERATION_WORK_ITEM_WORK_ITEM_ID',
      id: 'sprint_alterations',
    },
  ],
  quickSearchAppDEFieldIds: ['name'],
  sysAPITag: 'ServiceAPI',
  defaultMode: true,
  enableFilterActions: true,
  name: 'SPRINT_ALTERATION',
  id: 'plmweb.sprint_alteration',
  codeName2: 'sprint_alterations',
  requestPaths: [
    'sprints/${sprint}/sprint_alterations/${sprint_alteration}',
    'work_items/${work_item}/sprint_alterations/${sprint_alteration}',
  ],
};