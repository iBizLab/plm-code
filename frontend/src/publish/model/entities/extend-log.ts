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
      codeName: 'Owner_id',
      logicName: '所属数据标识',
      stdDataType: 25,
      stringLength: 200,
      name: 'OWNER_ID',
      id: 'owner_id',
    },
    {
      codeName: 'Owner_type',
      logicName: '所属数据对象',
      stdDataType: 25,
      stringLength: 100,
      name: 'OWNER_TYPE',
      id: 'owner_type',
    },
    {
      codeName: 'Owner_subtype',
      logicName: '所属对象子类型',
      stdDataType: 25,
      stringLength: 100,
      name: 'OWNER_SUBTYPE',
      id: 'owner_subtype',
    },
    {
      codeName: 'Category',
      logicName: '类别',
      stdDataType: 25,
      stringLength: 100,
      name: 'CATEGORY',
      id: 'category',
    },
    {
      codeName: 'Level',
      logicName: '级别',
      stdDataType: 25,
      stringLength: 100,
      name: 'LEVEL',
      id: 'level',
    },
    {
      codeName: 'Info',
      logicName: '日志信息',
      stdDataType: 21,
      stringLength: 1048576,
      name: 'INFO',
      id: 'info',
    },
    {
      codeName: 'Start_at',
      logicName: '起始时间',
      stdDataType: 5,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
      name: 'START_AT',
      id: 'start_at',
    },
    {
      codeName: 'End_at',
      logicName: '结束时间',
      stdDataType: 5,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
      name: 'END_AT',
      id: 'end_at',
    },
    {
      codeName: 'Elapsed_time',
      logicName: '持续时间',
      stdDataType: 9,
      name: 'ELAPSED_TIME',
      id: 'elapsed_time',
    },
    {
      codeName: 'State',
      logicName: '状态',
      stdDataType: 25,
      stringLength: 100,
      name: 'STATE',
      id: 'state',
    },
    {
      codeName: 'Name',
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
      codeName: 'Update_time',
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
      codeName: 'Create_time',
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
      codeName: 'Id',
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
      codeName: 'Update_man',
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
      codeName: 'Create_man',
      lnlanguageRes: {
        lanResTag: 'DEF.LNAME.CREATE_MAN',
      },
      logicName: '建立人',
      stdDataType: 25,
      stringLength: 100,
      name: 'CREATE_MAN',
      id: 'create_man',
    },
  ],
  appDEMethodDTOs: [
    {
      codeName: 'Extend_logDTO',
      appDEMethodDTOFields: [
        {
          codeName: 'Owner_id',
          logicName: '所属数据标识',
          appDEFieldId: 'owner_id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Owner_id',
          id: 'owner_id',
        },
        {
          codeName: 'Owner_type',
          logicName: '所属数据对象',
          appDEFieldId: 'owner_type',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Owner_type',
          id: 'owner_type',
        },
        {
          codeName: 'Owner_subtype',
          logicName: '所属对象子类型',
          appDEFieldId: 'owner_subtype',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Owner_subtype',
          id: 'owner_subtype',
        },
        {
          codeName: 'Category',
          logicName: '类别',
          appDEFieldId: 'category',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Category',
          id: 'category',
        },
        {
          codeName: 'Level',
          logicName: '级别',
          appDEFieldId: 'level',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Level',
          id: 'level',
        },
        {
          codeName: 'Info',
          logicName: '日志信息',
          appDEFieldId: 'info',
          sourceType: 'DEFIELD',
          stdDataType: 21,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Info',
          id: 'info',
        },
        {
          codeName: 'Start_at',
          jsonFormat: 'yyyy-MM-dd HH:mm:ss',
          logicName: '起始时间',
          appDEFieldId: 'start_at',
          sourceType: 'DEFIELD',
          stdDataType: 5,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Start_at',
          id: 'start_at',
        },
        {
          codeName: 'End_at',
          jsonFormat: 'yyyy-MM-dd HH:mm:ss',
          logicName: '结束时间',
          appDEFieldId: 'end_at',
          sourceType: 'DEFIELD',
          stdDataType: 5,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'End_at',
          id: 'end_at',
        },
        {
          codeName: 'Elapsed_time',
          logicName: '持续时间',
          appDEFieldId: 'elapsed_time',
          sourceType: 'DEFIELD',
          stdDataType: 9,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Elapsed_time',
          id: 'elapsed_time',
        },
        {
          codeName: 'State',
          logicName: '状态',
          appDEFieldId: 'state',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'State',
          id: 'state',
        },
        {
          codeName: 'Create_man',
          logicName: '建立人',
          appDEFieldId: 'create_man',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          name: 'Create_man',
          id: 'create_man',
        },
        {
          codeName: 'Create_time',
          jsonFormat: 'yyyy-MM-dd HH:mm:ss',
          logicName: '建立时间',
          appDEFieldId: 'create_time',
          sourceType: 'DEFIELD',
          stdDataType: 5,
          type: 'SIMPLE',
          name: 'Create_time',
          id: 'create_time',
        },
        {
          codeName: 'Id',
          logicName: '标识',
          appDEFieldId: 'id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          name: 'Id',
          id: 'id',
        },
        {
          codeName: 'Name',
          logicName: '名称',
          appDEFieldId: 'name',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Name',
          id: 'name',
        },
        {
          codeName: 'Update_man',
          logicName: '更新人',
          appDEFieldId: 'update_man',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          name: 'Update_man',
          id: 'update_man',
        },
        {
          codeName: 'Update_time',
          jsonFormat: 'yyyy-MM-dd HH:mm:ss',
          logicName: '更新时间',
          appDEFieldId: 'update_time',
          sourceType: 'DEFIELD',
          stdDataType: 5,
          type: 'SIMPLE',
          name: 'Update_time',
          id: 'update_time',
        },
      ],
      sourceType: 'DE',
      type: 'DEFAULT',
      name: 'Extend_logDTO',
      id: 'extend_logdto',
    },
    {
      codeName: 'Extend_logFilterDTO',
      appDEMethodDTOFields: [
        {
          codeName: 'N_ID_EQ',
          logicName: '标识',
          appDEFieldId: 'id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_ID_EQ',
          id: 'n_id_eq',
        },
        {
          codeName: 'N_NAME_LIKE',
          logicName: '名称',
          appDEFieldId: 'name',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_NAME_LIKE',
          id: 'n_name_like',
        },
        {
          codeName: 'N_OWNER_ID_EQ',
          logicName: '所属数据标识',
          appDEFieldId: 'owner_id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_OWNER_ID_EQ',
          id: 'n_owner_id_eq',
        },
        {
          codeName: 'N_OWNER_SUBTYPE_EQ',
          logicName: '所属对象子类型',
          appDEFieldId: 'owner_subtype',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_OWNER_SUBTYPE_EQ',
          id: 'n_owner_subtype_eq',
        },
      ],
      sourceType: 'DE',
      type: 'DEFILTER',
      name: 'Extend_logFilterDTO',
      id: 'extend_logfilterdto',
    },
  ],
  appDEMethods: [
    {
      codeName: 'CheckKey',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'extend_logdto',
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
      requestPath: '/checkkey',
      actionMode: 'CHECKKEY',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'CheckKey',
      id: 'checkkey',
    },
    {
      codeName: 'Create',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'extend_logdto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'extend_logdto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      noServiceCodeName: true,
      actionMode: 'CREATE',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Create',
      id: 'create',
    },
    {
      codeName: 'Get',
      methodType: 'DEACTION',
      appDEMethodInput: {
        keyAppDEFieldId: 'id',
        type: 'KEYFIELD',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'extend_logdto',
        type: 'DTO',
        id: '返回对象',
      },
      requestField: 'ID',
      requestMethod: 'GET',
      requestParamType: 'FIELD',
      needResourceKey: true,
      noServiceCodeName: true,
      actionMode: 'READ',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Get',
      id: 'get',
    },
    {
      codeName: 'GetDraft',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'extend_logdto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'extend_logdto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'GET',
      requestParamType: 'NONE',
      requestPath: '/getdraft',
      actionMode: 'GETDRAFT',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'GetDraft',
      id: 'getdraft',
    },
    {
      codeName: 'Remove',
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
      actionType: 'REMOTE',
      batchActionMode: 1,
      enableBatchAction: true,
      dataSetType: 'REMOTE',
      name: 'Remove',
      id: 'remove',
    },
    {
      codeName: 'Save',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'extend_logdto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        type: 'VOID',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/save',
      needResourceKey: true,
      actionMode: 'UNKNOWN',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Save',
      id: 'save',
    },
    {
      codeName: 'Update',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'extend_logdto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'extend_logdto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'PUT',
      requestParamType: 'ENTITY',
      needResourceKey: true,
      noServiceCodeName: true,
      actionMode: 'UPDATE',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Update',
      id: 'update',
    },
    {
      codeName: 'FetchDefault',
      methodType: 'FETCH',
      appDEMethodInput: {
        appDEMethodDTOId: 'extend_logfilterdto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'extend_logdto',
        type: 'PAGE',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/fetchdefault',
      actionType: 'REMOTE',
      dataSetName: 'DEFAULT',
      dataSetTag: 'Default',
      dataSetType: 'REMOTE',
      name: 'FetchDefault',
      id: 'fetchdefault',
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
      caption: '详情',
      codeName: 'open_info_view',
      frontAppViewId: 'plmweb.extend_loginfo_view',
      frontProcessType: 'WIZARD',
      fullCodeName: 'Extend_log_open_info_view',
      timeout: 60000,
      uiactionMode: 'FRONT',
      uiactionTag: 'open_info_view',
      uiactionType: 'DEUIACTION',
      showBusyIndicator: true,
      noPrivDisplayMode: 2,
      appDataEntityId: 'plmweb.extend_log',
      name: '打开详情信息',
      id: 'open_info_view@extend_log',
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
  codeName: 'Extend_log',
  deapicodeName: 'extend_log',
  deapicodeName2: 'extend_logs',
  deapitag: 'EXTEND_LOG',
  dataAccCtrlArch: 1,
  dataAccCtrlMode: 1,
  enableUIActions: 15,
  keyAppDEFieldId: 'id',
  lnlanguageRes: {
    lanResTag: 'DE.LNAME.EXTEND_LOG',
  },
  logicName: '扩展日志',
  majorAppDEFieldId: 'name',
  quickSearchAppDEFieldIds: ['name'],
  sysAPITag: 'ServiceAPI',
  defaultMode: true,
  enableFilterActions: true,
  major: true,
  name: 'EXTEND_LOG',
  id: 'plmweb.extend_log',
  codeName2: 'Extend_logs',
  requestPaths: [],
};