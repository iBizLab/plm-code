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
      stringLength: 100,
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
      codeName: 'From_state',
      logicName: '源状态',
      stdDataType: 25,
      stringLength: 100,
      name: 'FROM_STATE',
      id: 'from_state',
    },
    {
      codeName: 'To_state',
      logicName: '目标状态',
      stdDataType: 25,
      stringLength: 100,
      name: 'TO_STATE',
      id: 'to_state',
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
  ],
  appDEMethodDTOs: [
    {
      codeName: 'Transition_historyDTO',
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
          codeName: 'From_state',
          logicName: '源状态',
          appDEFieldId: 'from_state',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'From_state',
          id: 'from_state',
        },
        {
          codeName: 'To_state',
          logicName: '目标状态',
          appDEFieldId: 'to_state',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'To_state',
          id: 'to_state',
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
      name: 'Transition_historyDTO',
      id: 'transition_historydto',
    },
    {
      codeName: 'Transition_historyFilterDTO',
      appDEMethodDTOFields: [
        {
          codeName: 'N_FROM_STATE_EQ',
          logicName: '源状态',
          appDEFieldId: 'from_state',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_FROM_STATE_EQ',
          id: 'n_from_state_eq',
        },
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
          codeName: 'N_TO_STATE_EQ',
          logicName: '目标状态',
          appDEFieldId: 'to_state',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_TO_STATE_EQ',
          id: 'n_to_state_eq',
        },
      ],
      sourceType: 'DE',
      type: 'DEFILTER',
      name: 'Transition_historyFilterDTO',
      id: 'transition_historyfilterdto',
    },
  ],
  appDEMethods: [
    {
      codeName: 'CheckKey',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'transition_historydto',
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
        appDEMethodDTOId: 'transition_historydto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'transition_historydto',
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
        appDEMethodDTOId: 'transition_historydto',
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
        appDEMethodDTOId: 'transition_historydto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'transition_historydto',
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
        appDEMethodDTOId: 'transition_historydto',
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
        appDEMethodDTOId: 'transition_historydto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'transition_historydto',
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
        appDEMethodDTOId: 'transition_historyfilterdto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'transition_historydto',
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
  codeName: 'Transition_history',
  deapicodeName: 'transition_history',
  deapicodeName2: 'transition_histories',
  deapitag: 'TRANSITION_HISTORY',
  dataAccCtrlArch: 1,
  dataAccCtrlMode: 1,
  enableUIActions: 15,
  keyAppDEFieldId: 'id',
  lnlanguageRes: {
    lanResTag: 'DE.LNAME.TRANSITION_HISTORY',
  },
  logicName: '流转记录',
  majorAppDEFieldId: 'name',
  quickSearchAppDEFieldIds: ['name'],
  sysAPITag: 'ServiceAPI',
  defaultMode: true,
  enableFilterActions: true,
  major: true,
  name: 'TRANSITION_HISTORY',
  id: 'plmweb.transition_history',
  codeName2: 'Transition_histories',
  requestPaths: [],
};